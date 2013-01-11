package droidsafe.main;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.Scene;
import soot.SootMethod;

import droidsafe.analyses.PTA;
import droidsafe.android.app.EntryPoints;
import droidsafe.android.app.Harness;
import droidsafe.android.app.TagImplementedSystemMethods;

import droidsafe.android.app.Project;
import droidsafe.android.system.API;


/**
 * Main entry class for DroidSafe analysis.
 * 
 * @author mgordon
 *
 */
public class Main {
	private static final Logger logger = LoggerFactory.getLogger(Main.class);
	public static final String LOG_TXT_FILE = "droidsafe.log.txt";
	public static final String LOG_XML_FILE = "droidsafe.log.xml";
	
	/**
	 */
	public static void main(String[] args) {
		logger.info("Starting DroidSafe Run");
		Config.v().init(args);
		Project.v().init();
		SootConfig.init();
		API.v().init();
		logger.info("Create tags for the overriden system methods in user code.");
		TagImplementedSystemMethods.run();
		logger.info("Finding entry points in user code.");
		EntryPoints.v().calculate();
		logger.info("Creating Harness.");
		Harness.create();
		logger.info("Setting Harness Main as entry point.");
		setHarnessMainAsEntryPoint();
		logger.info("Starting PTA...");
		PTA.run();
		logger.info("Ending DroidSafe Run");
		
	}
	
	private static void setHarnessMainAsEntryPoint() {
		List<SootMethod> entryPoints = new LinkedList<SootMethod>();
		entryPoints.add(Harness.v().getMain());
		Scene.v().setEntryPoints(entryPoints);
	}
}
