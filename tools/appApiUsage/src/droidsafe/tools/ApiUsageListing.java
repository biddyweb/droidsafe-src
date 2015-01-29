package droidsafe.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarFile;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Type;
import soot.util.Chain;

import droidsafe.utils.SootUtils;

/**
 * This class lists APIs used in a given app.  This will help collect API directly used
 * so that we can properly model and annotate the APIs
 * @author Nguyen Nguyen
 *
 */
public class ApiUsageListing {
    private static final Logger logger = LoggerFactory.getLogger(ApiUsageListing.class);
    
    private PrintStream printStream = System.out;

    public ApiUsageListing() {
        setSootOptions();
    }

    //We need to activate the scene in order to call getMethod
    protected void activateSootScene(){
        for (SootClass clz: Scene.v().getClasses()) {
            for (SootMethod method: clz.getMethods()){
            }
        }
    }
    
    public void addApiJar(String jarFile) {
        //SootUtils.loadClassesFromJar(jarFile, true, null);
        JarFile jar;
        try {
            jar = new JarFile(jarFile);
            SootUtils.loadClassesFromJar(jar, false, new HashSet<String>());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        };               
    }
    

    protected HashMap<SootMethod, Integer> apiAllUsage    = new HashMap<SootMethod, Integer>();
    protected HashMap<SootMethod, Integer> apiAllOverride = new HashMap<SootMethod, Integer>();
    protected HashMap<SootMethod, Integer> apiAllConcrete    = new HashMap<SootMethod, Integer>();

    // method with interface as a parameters
    protected HashSet<SootMethod> apiAllInterfaceParam = new HashSet<SootMethod>();
    protected HashSet<SootMethod> infImplSet = new HashSet<SootMethod>();
    
    int jarCount = 0;
    
    public void addAppJar(String jarFile) {
        List<SootClass> appClasses = new LinkedList<SootClass>(); 

        for (SootClass sootClass: Scene.v().getApplicationClasses()) {
            appClasses.add(sootClass);
        }
        
        for (SootClass sootClass: appClasses) {
            Scene.v().removeClass(sootClass);
        }

        //SootUtils.loadClassesFromJar(jarFile, true, null);
        logger.info("Loading appJar {}", jarFile);
        JarFile jar;
        try {
            jar = new JarFile(jarFile);
            SootUtils.loadClassesFromJar(jar, true, new HashSet<String>());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return;
        };
        
        jarCount++;
        
        HashMap<SootMethod, Integer> apiUsage    = new HashMap<SootMethod, Integer>();
        HashMap<SootMethod, Integer> apiConcrete = new HashMap<SootMethod, Integer>();
        HashMap<SootMethod, Integer> apiOverride = new HashMap<SootMethod, Integer>();
        
       
        // Going through all methods inside the class
        for (SootClass sootClass: Scene.v().getApplicationClasses()) {
            logger.info("Application classes {} ", sootClass);
        
            Chain<SootClass> infSet = sootClass.getInterfaces(); 
            
            // we are skipping android.support in user code
            if (sootClass.getName().startsWith("android.support"))
                continue;

            for (SootMethod sootMethod: sootClass.getMethods()) {
                // Check for overriding method
                // check for method being called by someone
                logger.info("Method {} ", sootMethod);
                                
                SootMethod overriden = SootUtils.getApiOverridenMethod(sootMethod);
                //if (SootUtils.isApiOverridenMethod(sootMethod)) {
                if (overriden != null) {

                    logger.info("{} is API overring method ", sootMethod);
                    if (!apiOverride.containsKey(overriden)) {
                        apiOverride.put(overriden, 0);                        
                    }
                    // add the counter
                    apiOverride.put(overriden, apiOverride.get(overriden)+1);
                }

                Set<SootMethod> calleeSet = SootUtils.getCalleeSet(sootMethod);
                for (SootMethod method: calleeSet) {
                    // skip aplication class
                    if (method.getDeclaringClass().isApplicationClass()) {
                        continue;
                    }
                    // if the callee is not application class, it is direct API class
                   if (!apiUsage.containsKey(method)) {
                        apiUsage.put(method, 0);                        
                    }
                    
                    // add the counter
                    apiUsage.put(method, apiUsage.get(method)+1); 
                    
                    // if abstract and not java class, search subclasses
                    if (method.isAbstract() && !sootClass.getName().startsWith("java")) {
                        List<SootMethod> concreteList = SootUtils.findPossibleInheritedMethods(sootClass, method.getSignature());
                        for (SootMethod concrete: concreteList) {
                            if (!apiConcrete.containsKey(concrete)) {
                                apiConcrete.put(method, 0);                        
                            }
                            
                            // add the counter
                            apiConcrete.put(concrete, apiConcrete.get(concrete)+1); 
                        }
                    }
                    
                    for (Type type: method.getParameterTypes()) {
                        if (type instanceof soot.RefType) {
                            SootClass clazz = ((soot.RefType)type).getSootClass();
                            if (clazz.isInterface() && !clazz.isApplicationClass()) {
                                logger.info("method {} uses API interface", method);
                                apiAllInterfaceParam.add(sootMethod); 
                            }
                        }
                    }
                }
                
           }            
        }

        printJarReport(jarFile, apiOverride, apiUsage, apiConcrete);
        
        for (SootMethod method: apiOverride.keySet()) {
            if (!apiAllOverride.containsKey(method)) {
                apiAllOverride.put(method,  0);
            }
            int count = apiOverride.get(method);
            apiAllOverride.put(method,  apiAllOverride.get(method) + count);
        }

        for (SootMethod method: apiUsage.keySet()) {
            if (!apiAllUsage.containsKey(method)) {
                apiAllUsage.put(method,  0);
            }
            int count = apiUsage.get(method);
            apiAllUsage.put(method,  apiAllUsage.get(method) + count);
        }
        
        for (SootMethod method: apiConcrete.keySet()) {
            if (!apiAllConcrete.containsKey(method)) {
                apiAllConcrete.put(method,  0);
            }
            int count = apiConcrete.get(method);
            apiAllConcrete.put(method,  apiAllConcrete.get(method) + count);
        }
    }
    
    /**
     * Set a report File
     * @param reportFile
     */
    public void setReportFile(String reportFile) {
        try {
            PrintStream stream = new PrintStream(reportFile);
            printStream = stream;
        }
        catch (Exception ex) {
            logger.warn("Cannot open report file {}", reportFile);
        }        
    }
    
    public void printSummaryReport(){
       printStream.printf("======== Summary for all (%d) Jars =============\n", jarCount); 
       printJarReport("All", apiAllOverride, apiAllUsage, apiAllConcrete);
    }
    /**
     * Output report for each section
     * @param jarFile
     * @param overrideMap
     * @param usageMap
     */
    private void printJarReport(String jarFile, Map<SootMethod, Integer> overrideMap, 
                                Map<SootMethod, Integer> usageMap, Map<SootMethod, Integer> concreteMap) {
       
       printStream.printf("========Output Report for jar %s=======\n", jarFile);
       printStream.printf("API overriden methods:\n");
       printStream.printf("----------------------\n");
       
       ArrayList<String> methodList = new ArrayList<String>(overrideMap.size());
       
       for (SootMethod method: overrideMap.keySet()) {
           methodList.add(method.toString());
       }
       Collections.sort(methodList);
       
       for (String methodSig: methodList) {
           try {
               SootMethod method = Scene.v().getMethod(methodSig); 
               printStream.printf("%s => %d \n",  method, overrideMap.get(method));  
           }
           catch (Exception e) {
               logger.warn("exception {}", e);
           }
       }
       
       // Dealing with API interface paramters
       methodList = new ArrayList<String>(apiAllInterfaceParam.size());
       
       for (SootMethod method: apiAllInterfaceParam) {
           methodList.add(method.toString());
       }
       Collections.sort(methodList);
       
       printStream.printf("----------------------------------------------\n");
       printStream.printf("\nMethod with API Interface parameters: \n");
       printStream.printf("----------------------\n");
       for (String methodSig: methodList) {
           try {
           SootMethod method = Scene.v().getMethod(methodSig);       
           printStream.printf("%s \n",  method);
           }
           catch (Exception e) {
               //logger.warn("exception {}", e);
               logger.info("method {} not availalbe ", methodSig);
           }
       }

       methodList = new ArrayList<String>(usageMap.size());
       for (SootMethod method: usageMap.keySet()) {
           methodList.add(method.toString());
       }
       Collections.sort(methodList);
       
       printStream.printf("\nDirect API call methods: \n");
       printStream.printf("----------------------\n");
       for (String methodSig: methodList) {
           try {
           SootMethod method = Scene.v().getMethod(methodSig);       
           printStream.printf("%s => %d \n",  method, usageMap.get(method));
           }
           catch (Exception e) {
               logger.warn("exception {}", e);
           }
       }
       
       methodList = new ArrayList<String>(usageMap.size());
       for (SootMethod method: usageMap.keySet()) {
           methodList.add(method.toString());
       }
       Collections.sort(methodList);
       
       printStream.printf("\nAdditionl Concrete call methods: \n");
       printStream.printf("----------------------\n");
       for (String methodSig: methodList) {
           try {
           SootMethod method = Scene.v().getMethod(methodSig);       
           if (apiAllUsage.containsKey(method))
               continue;
           printStream.printf("%s => %d \n",  method, usageMap.get(method));
           }
           catch (Exception e) {
               logger.warn("exception {}", e);
           }
       }
       //// Print out the list of classes
       Set<SootClass> usageClassSet = new HashSet<SootClass>();
       Set<SootClass> usageAndConcreteClassSet = new HashSet<SootClass>();

       for (SootMethod method: usageMap.keySet()) {
           usageClassSet.add(method.getDeclaringClass());
           usageAndConcreteClassSet.add(method.getDeclaringClass());
       }
       
       for (SootMethod method: concreteMap.keySet()) {
           usageAndConcreteClassSet.add(method.getDeclaringClass());
       }
       
       List<String> classList = new ArrayList<String>(usageClassSet.size());
       for (SootClass aclass: usageClassSet) {
           classList.add(aclass.toString());
       }
       Collections.sort(classList);
       
       printStream.printf("\n=============== Classes used: %d ==============\n", classList.size());
       for (String aClass: classList) {
           printStream.printf("%s \n", aClass);
       }
       
       classList = new ArrayList<String>();
       for (SootClass aclass: usageAndConcreteClassSet) {
           if (!usageClassSet.contains(aclass))
               classList.add(aclass.toString());
       }
       Collections.sort(classList);
       
       printStream.printf("\n=============== Addition Impl classes: %d==============\n", classList.size());
       for (String aClass: classList) {
           printStream.printf("%s \n", aClass);
       }
    }
    
    /**
     * 
     * @param stream
     */

    private static boolean isComponentClass(SootClass klass) {
       return false; 
    }
    public void dumpComponentExchange(PrintStream stream) {
        // Going through all methods inside the class
        for (SootClass sootClass: Scene.v().getApplicationClasses()) {
            logger.info("Application classes {} ", sootClass);
        
            Chain<SootClass> infSet = sootClass.getInterfaces(); 

            for (SootMethod sootMethod: sootClass.getMethods()) {
                // Check for overriding method
                // check for method being called by someone
                logger.info("Method {} ", sootMethod);
                                
                SootMethod overriden = SootUtils.getApiOverridenMethod(sootMethod);
                //if (SootUtils.isApiOverridenMethod(sootMethod)) {
                if (overriden != null) {
                }

                Set<SootMethod> calleeSet = SootUtils.getCalleeSet(sootMethod);
                for (SootMethod method: calleeSet) {
                    // skip aplication class
                    if (method.getDeclaringClass().isApplicationClass()) {
                        continue;
                    }
                    
                    // we need to crawl subclasses and is not java package
                    if (method.isAbstract() && !sootClass.getName().startsWith("java")) {
                        
                    }

                    // if already used 
                    if (apiAllUsage.containsKey(method)) {
                        continue;
                    }
                    
                    // add the counter
                   
                }
                
           }            
        }
    }

    private static void setSootOptions() {
        soot.options.Options.v().set_keep_line_number(true);
        soot.options.Options.v().set_whole_program(true);
        soot.options.Options.v().setPhaseOption("cg", "verbose:false");
        soot.options.Options.v().setPhaseOption("cg", "trim-clinit:true");
        //soot.options.Options.v().setPhaseOption("jb.tr", "ignore-wrong-staticness:true");
               
        // don't optimize the program 
        soot.options.Options.v().setPhaseOption("wjop", "enabled:false");
        // allow for the absence of some classes
        soot.options.Options.v().set_allow_phantom_refs(true);
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        Options options = new Options();
        options.addOption("o", "out",     true,  "output filename");
        options.addOption("i", "inlist",  true,  "input list of jar files");
        options.addOption("a", "apijar",  true,  "Optional API jar file");
        options.addOption("c", "comp",    false, "Component Dependency");

        if (args.length == 0){
            printHelp(options);
            return;         
        }
        
        CommandLineParser cliParser = new BasicParser();
        CommandLine commandLine = null;
        try {
            commandLine = cliParser.parse(options, args);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return;
        }
                       
        String[] libJars = null;
        if (commandLine.hasOption("apijar")) {
             libJars = commandLine.getOptionValues("apijar");
            
            for (String jarFile: libJars) {
                System.out.println("jarfile: " + jarFile);
            }
        } else {
            libJars = new String[1];
            libJars[0] = droidsafe.main.Config.v().getAndroidLibJarPath();
        }
        
        ApiUsageListing listing = new ApiUsageListing();
        
        if (commandLine.hasOption("out")) {
            String outFile = commandLine.getOptionValue("out");
            listing.setReportFile(outFile);
        }
        
        StringBuilder cp = new StringBuilder();
        
        cp.append(".");
        for (String jarName: libJars) {
            cp.append(File.pathSeparator + jarName);
        }

        List<String> appJarFiles = new LinkedList<String>();
        String[] arguments = commandLine.getArgs();
        for (String arg: arguments) {
            appJarFiles.add(arg);
        }

        if (commandLine.hasOption("inlist")) {
            InputStream listFile;
            try {
                listFile = new FileInputStream(commandLine.getOptionValue("inlist"));
                List<String> list = IOUtils.readLines(listFile);
                appJarFiles.addAll(list);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }            
        }
        
        for (String jarName: appJarFiles) {
            cp.append(File.pathSeparator + jarName);
        }
        System.setProperty("soot.class.path", cp.toString());
        logger.info("classpath: {} ", cp.toString());

        for (String jarName: libJars) {
            logger.warn("Loading API jar {} ", jarName);
            listing.addApiJar(jarName);
        }
 

        for (String jarName: appJarFiles) {
            logger.warn("Loading app jar {} ", jarName);
            listing.addAppJar(jarName);
        }
        
        listing.printSummaryReport();

    }
    
    private static void printHelp(Options options) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("AndroidSdkResourceCrawler [options] <app-jars> ", options);
    }   

}