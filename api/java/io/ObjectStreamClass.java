package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.lang.ref.SoftReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.WeakHashMap;
import libcore.io.Memory;
import libcore.util.EmptyArray;

public class ObjectStreamClass implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.266 -0400", hash_original_field = "924AD349EDF719B44ED4F6F5E69E79C8", hash_generated_field = "565644E752815B2ABF82349A3CEA0B6B")

    private transient Method methodWriteReplace;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.267 -0400", hash_original_field = "122CA9229276E3DB873F1636B9A73713", hash_generated_field = "6059C8931AF46DD9869FE9A893452731")

    private transient Method methodReadResolve;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.267 -0400", hash_original_field = "0AF54E3AF04EAD8206E09DE0F3EFF6A5", hash_generated_field = "79B39BB54513173AC7D6E6CEF6CBC2C1")

    private transient Method methodWriteObject;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.267 -0400", hash_original_field = "B82644AD4949DE727339E54F199447FA", hash_generated_field = "95EB8846D319017FC3432FF6857D1E5F")

    private transient Method methodReadObject;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.267 -0400", hash_original_field = "32BFCA8D9BFE8B95457E5550245CB6B9", hash_generated_field = "7CE9FEA6AC19BB8C204FD6B95B2862F7")

    private transient Method methodReadObjectNoData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.268 -0400", hash_original_field = "98E79AD3A7FF3396963BD7E17B70758D", hash_generated_field = "9CF3DD8AED4B95AE1F483D580B3C9FB3")

    private transient boolean arePropertiesResolved;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.268 -0400", hash_original_field = "C4140104E3123239B50920CAF039E81E", hash_generated_field = "CCFF438B2B69BBC8976762B5C0E1BAAE")

    private transient boolean isSerializable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.268 -0400", hash_original_field = "E7861AE2BAD033AB7951E8BEF5C2A338", hash_generated_field = "4BE511410EC0FFD94E2FF75D626D91CA")

    private transient boolean isExternalizable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.268 -0400", hash_original_field = "AD3DC48725AE019F4BB4FCBF31A8F0A2", hash_generated_field = "08F3A9F82723EA0AE100503EE65CAB86")

    private transient boolean isProxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.268 -0400", hash_original_field = "DE5BB2742FE3A4D4DDF9022B2054FD05", hash_generated_field = "36F43E2AAA4E18617E48CB413466DD29")

    private transient boolean isEnum;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.269 -0400", hash_original_field = "6F66E878C62DB60568A3487869695820", hash_generated_field = "288941F24943F280BE7DD01D20E3054F")

    private transient String className;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.269 -0400", hash_original_field = "49F703B414E479ADB1C3D60FCEC4F53F", hash_generated_field = "AC340BA4F3A44FB166243898294EB37E")

    private transient Class<?> resolvedClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.269 -0400", hash_original_field = "F92B03D6EDD39C2B4E711BE71293FD13", hash_generated_field = "971C9C890CEBC6BE40FABDECB2212AA0")

    private transient Class<?> resolvedConstructorClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.269 -0400", hash_original_field = "0F889FB01934E2F8046B517E783FC0E3", hash_generated_field = "A4FBAD79CEB03A973A15AB5C7331E7A6")

    private transient int resolvedConstructorMethodId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.270 -0400", hash_original_field = "28CDF3CD863FE5D84844FE25A3CD04A2", hash_generated_field = "2CBD7F29D2CB9FEFE962129E37123233")

    private transient long svUID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.270 -0400", hash_original_field = "4E5868D676CB634AA75B125A0F741ABF", hash_generated_field = "E30025CF9CDCA8A17963070ADA592697")

    private transient byte flags;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.270 -0400", hash_original_field = "7ECAB020F524F5AA6F04649D13BC0A2C", hash_generated_field = "F7485FE95D068421E7ED5928F1406E97")

    private transient ObjectStreamClass superclass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.270 -0400", hash_original_field = "D05B6ED7D2345020440DF396D6DA7F73", hash_generated_field = "186A117481AECE390EACD17A001BE99F")

    private transient ObjectStreamField[] fields;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.271 -0400", hash_original_field = "B7449C3BA34A98413B53EF5F6AAAAE64", hash_generated_field = "A56A7B7B744B804CA41E1FD965741EE2")

    private transient ObjectStreamField[] loadFields;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.271 -0400", hash_original_field = "7ED7EB5221669EADB9DDC3B8CA1218F3", hash_generated_field = "00A9BB651D9852E56EFAEA15E35B461E")

    private transient HashMap<ObjectStreamField, Field> reflectionFields = new HashMap<ObjectStreamField, Field>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.271 -0400", hash_original_field = "6ED86FE66FD07A5256097A5CD1494E95", hash_generated_field = "C0358E6BFD2D898DD9C7ADBEBD4D2ECF")

    private transient long constructor = CONSTRUCTOR_IS_NOT_RESOLVED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.271 -0400", hash_original_field = "B145651EF057F5E0B5598B009F752B32", hash_generated_field = "4AA36F11897D193C7F055A6BB8228782")

    private transient volatile List<ObjectStreamClass> cachedHierarchy;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.272 -0400", hash_original_method = "F4D9898A03FC0DADA999BF46D97F9433", hash_generated_method = "A9246BC45205ECF4E818CF0D168C4ADC")
      ObjectStreamClass() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.273 -0400", hash_original_method = "7053F33417C9644BFD49070B9EF96C54", hash_generated_method = "AC3AFCBDE4A9E172383956581C876B87")
     void setConstructor(long newConstructor) {
        constructor = newConstructor;
        // ---------- Original Method ----------
        //constructor = newConstructor;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.273 -0400", hash_original_method = "AE977884038645FC18D9650C0686387C", hash_generated_method = "A32337068D8C95DF8292830D062B0B9B")
     long getConstructor() {
        long var6CA268371EEB5D93EEFEB68F96157666_525223417 = (constructor);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1344557426 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1344557426;
        // ---------- Original Method ----------
        //return constructor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.274 -0400", hash_original_method = "592D0703821799AB937A99A67AB05B5C", hash_generated_method = "D5F618CDCBDBB0EC3B5FEDA1B1517959")
     Field getReflectionField(ObjectStreamField osf) {
        addTaint(osf.getTaint());
        synchronized
(reflectionFields)        {
            Field field = reflectionFields.get(osf);
    if(field != null)            
            {
Field varFD00DDA829A3FEC584386A3762542DE0_621394500 =                 field;
                varFD00DDA829A3FEC584386A3762542DE0_621394500.addTaint(taint);
                return varFD00DDA829A3FEC584386A3762542DE0_621394500;
            } //End block
        } //End block
        try 
        {
            Class<?> declaringClass = forClass();
            Field field = declaringClass.getDeclaredField(osf.getName());
            field.setAccessible(true);
            synchronized
(reflectionFields)            {
                reflectionFields.put(osf, field);
            } //End block
Field varE76FBDD0F30F44DA2A6872192CC4C234_2144378363 =             reflectionFields.get(osf);
            varE76FBDD0F30F44DA2A6872192CC4C234_2144378363.addTaint(taint);
            return varE76FBDD0F30F44DA2A6872192CC4C234_2144378363;
        } //End block
        catch (NoSuchFieldException ex)
        {
Field var540C13E9E156B687226421B24F2DF178_310760388 =             null;
            var540C13E9E156B687226421B24F2DF178_310760388.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_310760388;
        } //End block
        // ---------- Original Method ----------
        //synchronized (reflectionFields) {
            //Field field = reflectionFields.get(osf);
            //if (field != null) {
                //return field;
            //}
        //}
        //try {
            //Class<?> declaringClass = forClass();
            //Field field = declaringClass.getDeclaredField(osf.getName());
            //field.setAccessible(true);
            //synchronized (reflectionFields) {
                //reflectionFields.put(osf, field);
            //}
            //return reflectionFields.get(osf);
        //} catch (NoSuchFieldException ex) {
            //return null;
        //}
    }

    
        private static ObjectStreamClass createClassDesc(Class<?> cl) {
        ObjectStreamClass result = new ObjectStreamClass();
        boolean isArray = cl.isArray();
        boolean serializable = isSerializable(cl);
        boolean externalizable = isExternalizable(cl);
        result.isSerializable = serializable;
        result.isExternalizable = externalizable;
        result.setName(cl.getName());
        result.setClass(cl);
        Class<?> superclass = cl.getSuperclass();
        if (superclass != null) {
            result.setSuperclass(lookup(superclass));
        }
        Field[] declaredFields = null;
        if (serializable || externalizable) {
            if (result.isEnum() || result.isProxy()) {
                result.setSerialVersionUID(0L);
            } else {
                declaredFields = cl.getDeclaredFields();
                result.setSerialVersionUID(computeSerialVersionUID(cl, declaredFields));
            }
        }
        if (serializable && !isArray) {
            if (declaredFields == null) {
                declaredFields = cl.getDeclaredFields();
            }
            result.buildFieldDescriptors(declaredFields);
        } else {
            result.setFields(NO_FIELDS);
        }
        ObjectStreamField[] fields = result.getFields();
        if (fields != null) {
            ObjectStreamField[] loadFields = new ObjectStreamField[fields.length];
            for (int i = 0; i < fields.length; ++i) {
                loadFields[i] = new ObjectStreamField(fields[i].getName(),
                        fields[i].getType(), fields[i].isUnshared());
                loadFields[i].getTypeString();
            }
            result.setLoadFields(loadFields);
        }
        byte flags = 0;
        if (externalizable) {
            flags |= ObjectStreamConstants.SC_EXTERNALIZABLE;
            flags |= ObjectStreamConstants.SC_BLOCK_DATA; 
        } else if (serializable) {
            flags |= ObjectStreamConstants.SC_SERIALIZABLE;
        }
        result.methodWriteReplace = findMethod(cl, "writeReplace");
        result.methodReadResolve = findMethod(cl, "readResolve");
        result.methodWriteObject = findPrivateMethod(cl, "writeObject", WRITE_PARAM_TYPES);
        result.methodReadObject = findPrivateMethod(cl, "readObject", READ_PARAM_TYPES);
        result.methodReadObjectNoData = findPrivateMethod(cl, "readObjectNoData", EmptyArray.CLASS);
        if (result.hasMethodWriteObject()) {
            flags |= ObjectStreamConstants.SC_WRITE_METHOD;
        }
        result.setFlags(flags);
        return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.279 -0400", hash_original_method = "3492CF41320405C3965233DAB60A3EF1", hash_generated_method = "CB75105F90732F613CB04418DDB92A44")
     void buildFieldDescriptors(Field[] declaredFields) {
        addTaint(declaredFields[0].getTaint());
        final Field f = ObjectStreamClass.fieldSerialPersistentFields(this.forClass());
        boolean useReflectFields = f == null;
        ObjectStreamField[] _fields = null;
    if(!useReflectFields)        
        {
            f.setAccessible(true);
            try 
            {
                _fields = (ObjectStreamField[]) f.get(null);
            } //End block
            catch (IllegalAccessException ex)
            {
                AssertionError var856F93FDE0E323DC56DBDD84445E8491_1411205747 = new AssertionError(ex);
                var856F93FDE0E323DC56DBDD84445E8491_1411205747.addTaint(taint);
                throw var856F93FDE0E323DC56DBDD84445E8491_1411205747;
            } //End block
        } //End block
        else
        {
            List<ObjectStreamField> serializableFields = new ArrayList<ObjectStreamField>(declaredFields.length);
for(Field declaredField : declaredFields)
            {
                int modifiers = declaredField.getModifiers();
    if(!Modifier.isStatic(modifiers) && !Modifier.isTransient(modifiers))                
                {
                    ObjectStreamField field = new ObjectStreamField(declaredField.getName(),
                            declaredField.getType());
                    serializableFields.add(field);
                } //End block
            } //End block
    if(serializableFields.size() == 0)            
            {
                _fields = NO_FIELDS;
            } //End block
            else
            {
                _fields = serializableFields.toArray(new ObjectStreamField[serializableFields.size()]);
            } //End block
        } //End block
        Arrays.sort(_fields);
        int primOffset = 0;
        int objectOffset = 0;
for(int i = 0;i < _fields.length;i++)
        {
            Class<?> type = _fields[i].getType();
    if(type.isPrimitive())            
            {
                _fields[i].offset = primOffset;
                primOffset += primitiveSize(type);
            } //End block
            else
            {
                _fields[i].offset = objectOffset++;
            } //End block
        } //End block
        fields = _fields;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        private static long computeSerialVersionUID(Class<?> cl, Field[] fields) {
        for (int i = 0; i < fields.length; i++) {
            final Field field = fields[i];
            if (field.getType() == long.class) {
                int modifiers = field.getModifiers();
                if (Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers)) {
                    if (UID_FIELD_NAME.equals(field.getName())) {
                        field.setAccessible(true);
                        try {
                            return field.getLong(null);
                        } catch (IllegalAccessException iae) {
                            throw new RuntimeException("Error fetching SUID: " + iae);
                        }
                    }
                }
            }
        }
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA");
        } catch (NoSuchAlgorithmException e) {
            throw new Error(e);
        }
        ByteArrayOutputStream sha = new ByteArrayOutputStream();
        try {
            DataOutputStream output = new DataOutputStream(sha);
            output.writeUTF(cl.getName());
            int classModifiers = CLASS_MODIFIERS_MASK & cl.getModifiers();
            boolean isArray = cl.isArray();
            if (isArray) {
                classModifiers |= Modifier.ABSTRACT;
            }
            if (cl.isInterface() && !Modifier.isPublic(classModifiers)) {
                classModifiers &= ~Modifier.ABSTRACT;
            }
            output.writeInt(classModifiers);
            if (!isArray) {
                Class<?>[] interfaces = cl.getInterfaces();
                if (interfaces.length > 1) {
                    Comparator<Class<?>> interfaceComparator = new Comparator<Class<?>>() {
                        public int compare(Class<?> itf1, Class<?> itf2) {
                            return itf1.getName().compareTo(itf2.getName());
                        }
                    };
                    Arrays.sort(interfaces, interfaceComparator);
                }
                for (int i = 0; i < interfaces.length; i++) {
                    output.writeUTF(interfaces[i].getName());
                }
            }
            if (fields.length > 1) {
                Comparator<Field> fieldComparator = new Comparator<Field>() {
                    public int compare(Field field1, Field field2) {
                        return field1.getName().compareTo(field2.getName());
                    }
                };
                Arrays.sort(fields, fieldComparator);
            }
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                int modifiers = field.getModifiers() & FIELD_MODIFIERS_MASK;
                boolean skip = Modifier.isPrivate(modifiers)
                        && (Modifier.isTransient(modifiers) || Modifier
                                .isStatic(modifiers));
                if (!skip) {
                    output.writeUTF(field.getName());
                    output.writeInt(modifiers);
                    output
                            .writeUTF(descriptorForFieldSignature(getFieldSignature(field)));
                }
            }
            if (hasClinit(cl)) {
                output.writeUTF(CLINIT_NAME);
                output.writeInt(CLINIT_MODIFIERS);
                output.writeUTF(CLINIT_SIGNATURE);
            }
            Constructor<?>[] constructors = cl.getDeclaredConstructors();
            if (constructors.length > 1) {
                Comparator<Constructor<?>> constructorComparator = new Comparator<Constructor<?>>() {
                    public int compare(Constructor<?> ctr1, Constructor<?> ctr2) {
                        return (getConstructorSignature(ctr1)
                                .compareTo(getConstructorSignature(ctr2)));
                    }
                };
                Arrays.sort(constructors, constructorComparator);
            }
            for (int i = 0; i < constructors.length; i++) {
                Constructor<?> constructor = constructors[i];
                int modifiers = constructor.getModifiers()
                        & METHOD_MODIFIERS_MASK;
                boolean isPrivate = Modifier.isPrivate(modifiers);
                if (!isPrivate) {
                    output.writeUTF("<init>");
                    output.writeInt(modifiers);
                    output.writeUTF(descriptorForSignature(
                            getConstructorSignature(constructor)).replace('/',
                            '.'));
                }
            }
            Method[] methods = cl.getDeclaredMethods();
            if (methods.length > 1) {
                Comparator<Method> methodComparator = new Comparator<Method>() {
                    public int compare(Method m1, Method m2) {
                        int result = m1.getName().compareTo(m2.getName());
                        if (result == 0) {
                            return getMethodSignature(m1).compareTo(
                                    getMethodSignature(m2));
                        }
                        return result;
                    }
                };
                Arrays.sort(methods, methodComparator);
            }
            for (int i = 0; i < methods.length; i++) {
                Method method = methods[i];
                int modifiers = method.getModifiers() & METHOD_MODIFIERS_MASK;
                boolean isPrivate = Modifier.isPrivate(modifiers);
                if (!isPrivate) {
                    output.writeUTF(method.getName());
                    output.writeInt(modifiers);
                    output.writeUTF(descriptorForSignature(
                            getMethodSignature(method)).replace('/', '.'));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e + " computing SHA-1/SUID");
        }
        byte[] hash = digest.digest(sha.toByteArray());
        return Memory.peekLong(hash, 0, ByteOrder.LITTLE_ENDIAN);
    }

    
        private static String descriptorForFieldSignature(String signature) {
        return signature.replace('.', '/');
    }

    
        private static String descriptorForSignature(String signature) {
        return signature.substring(signature.indexOf("("));
    }

    
        static Field fieldSerialPersistentFields(Class<?> cl) {
        try {
            Field f = cl.getDeclaredField("serialPersistentFields");
            int modifiers = f.getModifiers();
            if (Modifier.isStatic(modifiers) && Modifier.isPrivate(modifiers)
                    && Modifier.isFinal(modifiers)) {
                if (f.getType() == ARRAY_OF_FIELDS) {
                    return f;
                }
            }
        } catch (NoSuchFieldException nsm) {
        }
        return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.287 -0400", hash_original_method = "3FC829F6BB79347D76007A55E3423470", hash_generated_method = "8C4C4275A8BD7D6552421BFC7A4F31B6")
    public Class<?> forClass() {
Class<?> var075125BABC426AEE972114AF721E5216_781832256 =         resolvedClass;
        var075125BABC426AEE972114AF721E5216_781832256.addTaint(taint);
        return var075125BABC426AEE972114AF721E5216_781832256;
        // ---------- Original Method ----------
        //return resolvedClass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.288 -0400", hash_original_method = "CFDAB7386CDDDD8EC35152CD7D073792", hash_generated_method = "E228D4B5B0AC3670E6C450FC871FDA87")
     Object newInstance(Class<?> instantiationClass) throws InvalidClassException {
        addTaint(instantiationClass.getTaint());
        resolveConstructorClass(instantiationClass);
Object varEF848881956A937135F95B8D07FA083C_1946735022 =         newInstance(instantiationClass, resolvedConstructorMethodId);
        varEF848881956A937135F95B8D07FA083C_1946735022.addTaint(taint);
        return varEF848881956A937135F95B8D07FA083C_1946735022;
        // ---------- Original Method ----------
        //resolveConstructorClass(instantiationClass);
        //return newInstance(instantiationClass, resolvedConstructorMethodId);
    }

    
    @DSModeled(DSC.SAFE)
    private static Object newInstance(Class<?> instantiationClass, int methodId) {
		return new Object();
	}

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.294 -0400", hash_original_method = "66A47A19F5FB8C837FA66140F62CB154", hash_generated_method = "CB7E51EEF055581356AAADEBEFF818E8")
    private Class<?> resolveConstructorClass(Class<?> objectClass) throws InvalidClassException {
        addTaint(objectClass.getTaint());
    if(resolvedConstructorClass != null)        
        {
Class<?> var34A24997B353A15578CD09690BCF037A_219859844 =             resolvedConstructorClass;
            var34A24997B353A15578CD09690BCF037A_219859844.addTaint(taint);
            return var34A24997B353A15578CD09690BCF037A_219859844;
        } //End block
        Class<?> constructorClass = objectClass;
        boolean wasSerializable = (flags & ObjectStreamConstants.SC_SERIALIZABLE) != 0;
    if(wasSerializable)        
        {
            while
(constructorClass != null && ObjectStreamClass.isSerializable(constructorClass))            
            {
                constructorClass = constructorClass.getSuperclass();
            } //End block
        } //End block
        Constructor<?> constructor = null;
    if(constructorClass != null)        
        {
            try 
            {
                constructor = constructorClass.getDeclaredConstructor(EmptyArray.CLASS);
            } //End block
            catch (NoSuchMethodException ignored)
            {
            } //End block
        } //End block
    if(constructor == null)        
        {
            String className = constructorClass != null ? constructorClass.getName() : null;
            InvalidClassException var34659025CA086E19721752EC30460C1C_1252399743 = new InvalidClassException(className, "IllegalAccessException");
            var34659025CA086E19721752EC30460C1C_1252399743.addTaint(taint);
            throw var34659025CA086E19721752EC30460C1C_1252399743;
        } //End block
        int constructorModifiers = constructor.getModifiers();
        boolean isPublic = Modifier.isPublic(constructorModifiers);
        boolean isProtected = Modifier.isProtected(constructorModifiers);
        boolean isPrivate = Modifier.isPrivate(constructorModifiers);
        boolean wasExternalizable = (flags & ObjectStreamConstants.SC_EXTERNALIZABLE) != 0;
    if(isPrivate || (wasExternalizable && !isPublic))        
        {
            InvalidClassException var2C87DA26BA27D0F36D8921A3A833B686_1007878036 = new InvalidClassException(constructorClass.getName(), "IllegalAccessException");
            var2C87DA26BA27D0F36D8921A3A833B686_1007878036.addTaint(taint);
            throw var2C87DA26BA27D0F36D8921A3A833B686_1007878036;
        } //End block
    if(!isPublic && !isProtected)        
        {
    if(!inSamePackage(constructorClass, objectClass))            
            {
                InvalidClassException var2C87DA26BA27D0F36D8921A3A833B686_1514855389 = new InvalidClassException(constructorClass.getName(), "IllegalAccessException");
                var2C87DA26BA27D0F36D8921A3A833B686_1514855389.addTaint(taint);
                throw var2C87DA26BA27D0F36D8921A3A833B686_1514855389;
            } //End block
        } //End block
        resolvedConstructorClass = constructorClass;
        resolvedConstructorMethodId = getConstructorId(resolvedConstructorClass);
Class<?> var76428D7ECDBDBDA03374EA99025A082D_456553679 =         constructorClass;
        var76428D7ECDBDBDA03374EA99025A082D_456553679.addTaint(taint);
        return var76428D7ECDBDBDA03374EA99025A082D_456553679;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    private static int getConstructorId(Class<?> c) {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1812619741 = DSUtils.UNKNOWN_INT;
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1812619741;
	}

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.298 -0400", hash_original_method = "C730C766F4F6CE91266CBA72D38C529A", hash_generated_method = "B2FDE47E8AE3E2B88646C37A62088FAB")
    private boolean inSamePackage(Class<?> c1, Class<?> c2) {
        addTaint(c2.getTaint());
        addTaint(c1.getTaint());
        String nameC1 = c1.getName();
        String nameC2 = c2.getName();
        int indexDotC1 = nameC1.lastIndexOf('.');
        int indexDotC2 = nameC2.lastIndexOf('.');
    if(indexDotC1 != indexDotC2)        
        {
            boolean var68934A3E9455FA72420237EB05902327_314169536 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2120801721 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2120801721;
        } //End block
    if(indexDotC1 == -1)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_160159984 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_548748337 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_548748337;
        } //End block
        boolean var4ABFC7CF49238B4319197AA9701D0DFC_1718325383 = (nameC1.regionMatches(0, nameC2, 0, indexDotC1));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_998991819 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_998991819;
        // ---------- Original Method ----------
        //String nameC1 = c1.getName();
        //String nameC2 = c2.getName();
        //int indexDotC1 = nameC1.lastIndexOf('.');
        //int indexDotC2 = nameC2.lastIndexOf('.');
        //if (indexDotC1 != indexDotC2) {
            //return false; 
        //}
        //if (indexDotC1 == -1) {
            //return true; 
        //}
        //return nameC1.regionMatches(0, nameC2, 0, indexDotC1);
    }

    
    @DSModeled(DSC.SAFE)
    static String getConstructorSignature(Constructor<?> c) {
		return new String();
	}

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.301 -0400", hash_original_method = "58A307C728457592549C73808957655C", hash_generated_method = "359A874165BA595D4548B8D0DB125B22")
    public ObjectStreamField getField(String name) {
        addTaint(name.getTaint());
        ObjectStreamField[] allFields = getFields();
for(int i = 0;i < allFields.length;i++)
        {
            ObjectStreamField f = allFields[i];
    if(f.getName().equals(name))            
            {
ObjectStreamField varABE3CFB53FE4A79F34CB25BC80BFD6E2_1107804883 =                 f;
                varABE3CFB53FE4A79F34CB25BC80BFD6E2_1107804883.addTaint(taint);
                return varABE3CFB53FE4A79F34CB25BC80BFD6E2_1107804883;
            } //End block
        } //End block
ObjectStreamField var540C13E9E156B687226421B24F2DF178_1510390120 =         null;
        var540C13E9E156B687226421B24F2DF178_1510390120.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1510390120;
        // ---------- Original Method ----------
        //ObjectStreamField[] allFields = getFields();
        //for (int i = 0; i < allFields.length; i++) {
            //ObjectStreamField f = allFields[i];
            //if (f.getName().equals(name)) {
                //return f;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.303 -0400", hash_original_method = "3D80A7A04F3988E3E464D888981C4A01", hash_generated_method = "0680F5D829B756BCC2A60C3E92C725C5")
     ObjectStreamField[] fields() {
    if(fields == null)        
        {
            Class<?> forCl = forClass();
    if(forCl != null && isSerializable() && !forCl.isArray())            
            {
                buildFieldDescriptors(forCl.getDeclaredFields());
            } //End block
            else
            {
                setFields(NO_FIELDS);
            } //End block
        } //End block
ObjectStreamField[] varDA099C5ABC8C115F7AAB4D8E4C4982EA_1348150927 =         fields;
        varDA099C5ABC8C115F7AAB4D8E4C4982EA_1348150927.addTaint(taint);
        return varDA099C5ABC8C115F7AAB4D8E4C4982EA_1348150927;
        // ---------- Original Method ----------
        //if (fields == null) {
            //Class<?> forCl = forClass();
            //if (forCl != null && isSerializable() && !forCl.isArray()) {
                //buildFieldDescriptors(forCl.getDeclaredFields());
            //} else {
                //setFields(NO_FIELDS);
            //}
        //}
        //return fields;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.308 -0400", hash_original_method = "BA69DA3B5E6C7F20CA233B877CCB0384", hash_generated_method = "1E08F96001532FD6F4C8F8729E9DE08C")
    public ObjectStreamField[] getFields() {
        copyFieldAttributes();
ObjectStreamField[] varAFD42F6EF24F64BA6A7D3A69307F5D14_1242863524 =         loadFields == null ? fields().clone() : loadFields.clone();
        varAFD42F6EF24F64BA6A7D3A69307F5D14_1242863524.addTaint(taint);
        return varAFD42F6EF24F64BA6A7D3A69307F5D14_1242863524;
        // ---------- Original Method ----------
        //copyFieldAttributes();
        //return loadFields == null ? fields().clone() : loadFields.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.312 -0400", hash_original_method = "8AA71837DDE89491F51C878CBC8B38A5", hash_generated_method = "59A10E61F688EDDDD0339D8C7FAAD45A")
     List<ObjectStreamClass> getHierarchy() {
        List<ObjectStreamClass> result = cachedHierarchy;
    if(result == null)        
        {
            cachedHierarchy = result = makeHierarchy();
        } //End block
List<ObjectStreamClass> varDC838461EE2FA0CA4C9BBB70A15456B0_396622466 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_396622466.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_396622466;
        // ---------- Original Method ----------
        //List<ObjectStreamClass> result = cachedHierarchy;
        //if (result == null) {
            //cachedHierarchy = result = makeHierarchy();
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.315 -0400", hash_original_method = "970C4D30E4F07A217EB44CA0880B9D33", hash_generated_method = "68149EF983851E0A92D879B6F1C51F09")
    private List<ObjectStreamClass> makeHierarchy() {
        ArrayList<ObjectStreamClass> result = new ArrayList<ObjectStreamClass>();
for(ObjectStreamClass osc = this;osc != null;osc = osc.getSuperclass())
        {
            result.add(0, osc);
        } //End block
List<ObjectStreamClass> varDC838461EE2FA0CA4C9BBB70A15456B0_401768268 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_401768268.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_401768268;
        // ---------- Original Method ----------
        //ArrayList<ObjectStreamClass> result = new ArrayList<ObjectStreamClass>();
        //for (ObjectStreamClass osc = this; osc != null; osc = osc.getSuperclass()) {
            //result.add(0, osc);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.318 -0400", hash_original_method = "F57C7EC559BF09EB03BA0EA2BC063E8F", hash_generated_method = "C3AC8A3FA338727C6657204B779B88B8")
    private void copyFieldAttributes() {
    if((loadFields == null) || fields == null)        
        {
            return;
        } //End block
for(int i = 0;i < loadFields.length;i++)
        {
            ObjectStreamField loadField = loadFields[i];
            String name = loadField.getName();
for(int j = 0;j < fields.length;j++)
            {
                ObjectStreamField field = fields[j];
    if(name.equals(field.getName()))                
                {
                    loadField.setUnshared(field.isUnshared());
                    loadField.setOffset(field.getOffset());
                    break;
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if ((loadFields == null) || fields == null) {
            //return;
        //}
        //for (int i = 0; i < loadFields.length; i++) {
            //ObjectStreamField loadField = loadFields[i];
            //String name = loadField.getName();
            //for (int j = 0; j < fields.length; j++) {
                //ObjectStreamField field = fields[j];
                //if (name.equals(field.getName())) {
                    //loadField.setUnshared(field.isUnshared());
                    //loadField.setOffset(field.getOffset());
                    //break;
                //}
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.320 -0400", hash_original_method = "8F334CDB84C81A51C0419AAF322CA87A", hash_generated_method = "A66BD086223C1042C05B24D9510EC424")
     ObjectStreamField[] getLoadFields() {
ObjectStreamField[] varFFE48A86F4DE3B2E682DE0CE30222550_1983587909 =         loadFields;
        varFFE48A86F4DE3B2E682DE0CE30222550_1983587909.addTaint(taint);
        return varFFE48A86F4DE3B2E682DE0CE30222550_1983587909;
        // ---------- Original Method ----------
        //return loadFields;
    }

    
    @DSModeled(DSC.SAFE)
    private static String getFieldSignature(Field f) {
		return new String();
	}

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.323 -0400", hash_original_method = "CB224A404D2A4A24CFF7504565CB22F2", hash_generated_method = "6E5347F20B97244E8F14B40620B67084")
     byte getFlags() {
        byte var4E5868D676CB634AA75B125A0F741ABF_549519506 = (flags);
                byte var40EA57D3EE3C07BF1C102B466E1C3091_1118162377 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_1118162377;
        // ---------- Original Method ----------
        //return flags;
    }

    
    @DSModeled(DSC.SAFE)
    static String getMethodSignature(Method m) {
		return new String();
	}

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.327 -0400", hash_original_method = "4A271A070FBC29EF826D1B50170E00D2", hash_generated_method = "45AB3D04A0C312221E9AC2C017F7BB18")
    public String getName() {
String varF57DF2C3C72C0BA8574176BD3A4AA127_1019383579 =         className;
        varF57DF2C3C72C0BA8574176BD3A4AA127_1019383579.addTaint(taint);
        return varF57DF2C3C72C0BA8574176BD3A4AA127_1019383579;
        // ---------- Original Method ----------
        //return className;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.328 -0400", hash_original_method = "50DDDA79153910C7DDC4FA6D8AF3586E", hash_generated_method = "315382B9222BB56DC48412F303828246")
    public long getSerialVersionUID() {
        long var28CDF3CD863FE5D84844FE25A3CD04A2_1378417080 = (svUID);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_62925360 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_62925360;
        // ---------- Original Method ----------
        //return svUID;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.329 -0400", hash_original_method = "B099B86A783D62A1B2FEC5CAB74CA2FF", hash_generated_method = "E168F9820C3469B7F5A01C67BE6B6853")
     ObjectStreamClass getSuperclass() {
ObjectStreamClass var605488FFF682003C1CF49E47CFE0CB88_719465507 =         superclass;
        var605488FFF682003C1CF49E47CFE0CB88_719465507.addTaint(taint);
        return var605488FFF682003C1CF49E47CFE0CB88_719465507;
        // ---------- Original Method ----------
        //return superclass;
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean hasClinit(Class<?> cl) {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_153496694 = DSUtils.UNKNOWN_BOOLEAN;
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_153496694;
	}

    
        static boolean isExternalizable(Class<?> cl) {
        return EXTERNALIZABLE.isAssignableFrom(cl);
    }

    
        @DSModeled(DSC.SAFE)
    static boolean isPrimitiveType(char typecode) {
        return !(typecode == '[' || typecode == 'L');
    }

    
        static boolean isSerializable(Class<?> cl) {
        return SERIALIZABLE.isAssignableFrom(cl);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.336 -0400", hash_original_method = "742EA2900A6EB88CE28517352A724CD7", hash_generated_method = "5F1FFE78E26AA1A310D199DC72C38791")
    private void resolveProperties() {
    if(arePropertiesResolved)        
        {
            return;
        } //End block
        Class<?> cl = forClass();
        isProxy = Proxy.isProxyClass(cl);
        isEnum = Enum.class.isAssignableFrom(cl);
        isSerializable = isSerializable(cl);
        isExternalizable = isExternalizable(cl);
        arePropertiesResolved = true;
        // ---------- Original Method ----------
        //if (arePropertiesResolved) {
            //return;
        //}
        //Class<?> cl = forClass();
        //isProxy = Proxy.isProxyClass(cl);
        //isEnum = Enum.class.isAssignableFrom(cl);
        //isSerializable = isSerializable(cl);
        //isExternalizable = isExternalizable(cl);
        //arePropertiesResolved = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.339 -0400", hash_original_method = "250E0179C7C05D1D77B183DF06C38BC2", hash_generated_method = "E1F37A94688BF2D8C207AD6109310104")
     boolean isSerializable() {
        resolveProperties();
        boolean varC4140104E3123239B50920CAF039E81E_895830442 = (isSerializable);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1045892048 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1045892048;
        // ---------- Original Method ----------
        //resolveProperties();
        //return isSerializable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.340 -0400", hash_original_method = "86835294A15C6057A38D3AF0C7A856A1", hash_generated_method = "3CB736DE56F4BB26BE43B39130A47CC4")
     boolean isExternalizable() {
        resolveProperties();
        boolean varE7861AE2BAD033AB7951E8BEF5C2A338_1065834386 = (isExternalizable);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1331255456 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1331255456;
        // ---------- Original Method ----------
        //resolveProperties();
        //return isExternalizable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.342 -0400", hash_original_method = "052543446E0B6EEA498804C02394B590", hash_generated_method = "6F5C9EBE32191107EE472274A46CFC4D")
     boolean isProxy() {
        resolveProperties();
        boolean varAD3DC48725AE019F4BB4FCBF31A8F0A2_367822884 = (isProxy);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_826015027 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_826015027;
        // ---------- Original Method ----------
        //resolveProperties();
        //return isProxy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.344 -0400", hash_original_method = "23781B8C58B21A484CF86E4B23EBD9CC", hash_generated_method = "A1925186024E4C372D5DD9C83731A053")
     boolean isEnum() {
        resolveProperties();
        boolean varDE5BB2742FE3A4D4DDF9022B2054FD05_314238536 = (isEnum);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1541476115 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1541476115;
        // ---------- Original Method ----------
        //resolveProperties();
        //return isEnum;
    }

    
        public static ObjectStreamClass lookup(Class<?> cl) {
        ObjectStreamClass osc = lookupStreamClass(cl);
        return (osc.isSerializable() || osc.isExternalizable()) ? osc : null;
    }

    
        public static ObjectStreamClass lookupAny(Class<?> cl) {
        return lookupStreamClass(cl);
    }

    
        static ObjectStreamClass lookupStreamClass(Class<?> cl) {
        WeakHashMap<Class<?>, ObjectStreamClass> tlc = getCache();
        ObjectStreamClass cachedValue = tlc.get(cl);
        if (cachedValue == null) {
            cachedValue = createClassDesc(cl);
            tlc.put(cl, cachedValue);
        }
        return cachedValue;
    }

    
        private static WeakHashMap<Class<?>, ObjectStreamClass> getCache() {
        ThreadLocal<WeakHashMap<Class<?>, ObjectStreamClass>> tls = storage.get();
        if (tls == null) {
            tls = new ThreadLocal<WeakHashMap<Class<?>, ObjectStreamClass>>() {
                public WeakHashMap<Class<?>, ObjectStreamClass> initialValue() {
                    return new WeakHashMap<Class<?>, ObjectStreamClass>();
                }
            };
            storage = new SoftReference<ThreadLocal<WeakHashMap<Class<?>, ObjectStreamClass>>>(tls);
        }
        return tls.get();
    }

    
        static Method findMethod(Class<?> cl, String methodName) {
        Class<?> search = cl;
        Method method = null;
        while (search != null) {
            try {
                method = search.getDeclaredMethod(methodName, (Class[]) null);
                if (search == cl
                        || (method.getModifiers() & Modifier.PRIVATE) == 0) {
                    method.setAccessible(true);
                    return method;
                }
            } catch (NoSuchMethodException nsm) {
            }
            search = search.getSuperclass();
        }
        return null;
    }

    
        static Method findPrivateMethod(Class<?> cl, String methodName,
            Class<?>[] param) {
        try {
            Method method = cl.getDeclaredMethod(methodName, param);
            if (Modifier.isPrivate(method.getModifiers()) && method.getReturnType() == void.class) {
                method.setAccessible(true);
                return method;
            }
        } catch (NoSuchMethodException nsm) {
        }
        return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.350 -0400", hash_original_method = "8B291B650661131936FFDD0976F9C451", hash_generated_method = "B6992FE6ED70034CAFFB9493B7C3A253")
     boolean hasMethodWriteReplace() {
        boolean varC5C50AF3A96235EE06F14A4054ECB16D_1237069866 = ((methodWriteReplace != null));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_447550624 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_447550624;
        // ---------- Original Method ----------
        //return (methodWriteReplace != null);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.350 -0400", hash_original_method = "42662B3DE24059CFD85E0D286320D7E3", hash_generated_method = "716236FF452541E1C83D8ED9AA638C43")
     Method getMethodWriteReplace() {
Method var206BC8C04910C0FB4D4E5C2F0A803E8D_1945791546 =         methodWriteReplace;
        var206BC8C04910C0FB4D4E5C2F0A803E8D_1945791546.addTaint(taint);
        return var206BC8C04910C0FB4D4E5C2F0A803E8D_1945791546;
        // ---------- Original Method ----------
        //return methodWriteReplace;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.352 -0400", hash_original_method = "2852DBB1E5C3B0D1351FCC53EE3E49ED", hash_generated_method = "BAB31BB3BAF42318055E993ED9E3F48D")
     boolean hasMethodReadResolve() {
        boolean var9FA32245FC9D15A587F6C8E61C826120_901016354 = ((methodReadResolve != null));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2105354378 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2105354378;
        // ---------- Original Method ----------
        //return (methodReadResolve != null);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.353 -0400", hash_original_method = "4E87A71E13632BD19F893729646A7048", hash_generated_method = "726456111D8A171AE715445C1C583CF9")
     Method getMethodReadResolve() {
Method varC362345BB436481765CCFD945370E01A_1021591593 =         methodReadResolve;
        varC362345BB436481765CCFD945370E01A_1021591593.addTaint(taint);
        return varC362345BB436481765CCFD945370E01A_1021591593;
        // ---------- Original Method ----------
        //return methodReadResolve;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.354 -0400", hash_original_method = "5A79EE26139C94EE3C3A1C73D8050C0E", hash_generated_method = "27940847BCFD4FEE31A294580FA93025")
     boolean hasMethodWriteObject() {
        boolean varCD42F0C01E864FCB858A5F038B60FDB4_246947019 = ((methodWriteObject != null));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1727545313 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1727545313;
        // ---------- Original Method ----------
        //return (methodWriteObject != null);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.354 -0400", hash_original_method = "234967F1224E01D561A4A7AA93A723BD", hash_generated_method = "7ED0460C3EAB2D0276F8DDDDEAFA41D3")
     Method getMethodWriteObject() {
Method var0C7876443CF7079D263CA84361BC21AF_935464428 =         methodWriteObject;
        var0C7876443CF7079D263CA84361BC21AF_935464428.addTaint(taint);
        return var0C7876443CF7079D263CA84361BC21AF_935464428;
        // ---------- Original Method ----------
        //return methodWriteObject;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.356 -0400", hash_original_method = "46A702B5AEFAE4B1088A7C3DF1FC5D53", hash_generated_method = "66E65186E331F3E0FB1CA23EF82DBBA7")
     boolean hasMethodReadObject() {
        boolean varA66395F47C27FB7F49C015BF5A9A3975_337248261 = ((methodReadObject != null));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1135422237 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1135422237;
        // ---------- Original Method ----------
        //return (methodReadObject != null);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.357 -0400", hash_original_method = "46960222BC0B63A6D59A57191BB77464", hash_generated_method = "57FAA0018611A39D78F9B924387CAE7B")
     Method getMethodReadObject() {
Method varD22288161F844BB1B614C017B84DB295_690434327 =         methodReadObject;
        varD22288161F844BB1B614C017B84DB295_690434327.addTaint(taint);
        return varD22288161F844BB1B614C017B84DB295_690434327;
        // ---------- Original Method ----------
        //return methodReadObject;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.359 -0400", hash_original_method = "29BCBE89B6EA217724D7699109546E15", hash_generated_method = "59CC7EF805E3F162CCA4C893F08DCF10")
     boolean hasMethodReadObjectNoData() {
        boolean var2268C4BD6E66C45D000783AEB8105D0F_428802606 = ((methodReadObjectNoData != null));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_547367769 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_547367769;
        // ---------- Original Method ----------
        //return (methodReadObjectNoData != null);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.360 -0400", hash_original_method = "04BED52E799E809DB8DD364039964962", hash_generated_method = "1E3E19B246156C6BFF041D9B832DF589")
     Method getMethodReadObjectNoData() {
Method var96D778C62F00BBE1AC313B4CD63FC46E_391625096 =         methodReadObjectNoData;
        var96D778C62F00BBE1AC313B4CD63FC46E_391625096.addTaint(taint);
        return var96D778C62F00BBE1AC313B4CD63FC46E_391625096;
        // ---------- Original Method ----------
        //return methodReadObjectNoData;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.364 -0400", hash_original_method = "971C620E95BDC0255A7014EB736B5315", hash_generated_method = "B5F3BDDAE6A803CDF4D471FA2756DB0E")
     void initPrivateFields(ObjectStreamClass desc) {
        methodWriteReplace = desc.methodWriteReplace;
        methodReadResolve = desc.methodReadResolve;
        methodWriteObject = desc.methodWriteObject;
        methodReadObject = desc.methodReadObject;
        methodReadObjectNoData = desc.methodReadObjectNoData;
        // ---------- Original Method ----------
        //methodWriteReplace = desc.methodWriteReplace;
        //methodReadResolve = desc.methodReadResolve;
        //methodWriteObject = desc.methodWriteObject;
        //methodReadObject = desc.methodReadObject;
        //methodReadObjectNoData = desc.methodReadObjectNoData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.366 -0400", hash_original_method = "7A3AD0F8FFB276A7B1543CE5BED00A8C", hash_generated_method = "F5A742D0B09B68C4FB60A9954C304EDB")
     void setClass(Class<?> c) {
        resolvedClass = c;
        // ---------- Original Method ----------
        //resolvedClass = c;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.368 -0400", hash_original_method = "95CB44F7E664D85BD475B63456D19F48", hash_generated_method = "621FA11CDA9BF8080C1105CE3A873D93")
     void setFields(ObjectStreamField[] f) {
        fields = f;
        // ---------- Original Method ----------
        //fields = f;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.370 -0400", hash_original_method = "BCDE99C62E7E698332D80A91E945CB98", hash_generated_method = "D8783C05CB4817ECCBC0A4DB4114E614")
     void setLoadFields(ObjectStreamField[] f) {
        loadFields = f;
        // ---------- Original Method ----------
        //loadFields = f;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.371 -0400", hash_original_method = "576B4ED3621FB044BCB61FA4A013466B", hash_generated_method = "A1473C1BC66B458281188527CD3D2FFA")
     void setFlags(byte b) {
        flags = b;
        // ---------- Original Method ----------
        //flags = b;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.371 -0400", hash_original_method = "013A745A10FFAC0063C18ECA8D35B13C", hash_generated_method = "A8DB264CFECA0C5CD0FC0F9AB8AC5A8F")
     void setName(String newName) {
        className = newName;
        // ---------- Original Method ----------
        //className = newName;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.373 -0400", hash_original_method = "F5AE79B32CCC15982EBF3437ADD142B6", hash_generated_method = "2B1ADB1E939E150C2B4F3759E3B94493")
     void setSerialVersionUID(long l) {
        svUID = l;
        // ---------- Original Method ----------
        //svUID = l;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.375 -0400", hash_original_method = "0C66D1C8E17ECB3824AFA99C964D873A", hash_generated_method = "B10D683C7024190847B8FAF4B67B2A8C")
     void setSuperclass(ObjectStreamClass c) {
        superclass = c;
        // ---------- Original Method ----------
        //superclass = c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.377 -0400", hash_original_method = "555F932795060D0A381054093FA5AE4C", hash_generated_method = "20D17C410FE38D90C15C0F8910C739A6")
    private int primitiveSize(Class<?> type) {
        addTaint(type.getTaint());
    if(type == byte.class || type == boolean.class)        
        {
            int varC4CA4238A0B923820DCC509A6F75849B_68664735 = (1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_79473665 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_79473665;
        } //End block
    if(type == short.class || type == char.class)        
        {
            int varC81E728D9D4C2F636F067F89CC14862C_1510689834 = (2);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_58379225 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_58379225;
        } //End block
    if(type == int.class || type == float.class)        
        {
            int varA87FF679A2F3E71D9181A67B7542122C_1561232484 = (4);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_216321960 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_216321960;
        } //End block
    if(type == long.class || type == double.class)        
        {
            int varC9F0F895FB98AB9159F51FD0297E236D_1447626603 = (8);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1930766111 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1930766111;
        } //End block
        AssertionError varA81442E36297E737EB908877E58260E8_1775529460 = new AssertionError();
        varA81442E36297E737EB908877E58260E8_1775529460.addTaint(taint);
        throw varA81442E36297E737EB908877E58260E8_1775529460;
        // ---------- Original Method ----------
        //if (type == byte.class || type == boolean.class) {
            //return 1;
        //}
        //if (type == short.class || type == char.class) {
            //return 2;
        //}
        //if (type == int.class || type == float.class) {
            //return 4;
        //}
        //if (type == long.class || type == double.class) {
            //return 8;
        //}
        //throw new AssertionError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.379 -0400", hash_original_method = "0689970A4402522168D5BA272C87560D", hash_generated_method = "790A9157A6CBA5DA9ABE01E06AE13CE4")
    @Override
    public String toString() {
String var5FAD7D225659685DEAC931806B2CCAFE_118254772 =         getName() + ": static final long serialVersionUID =" + getSerialVersionUID() + "L;";
        var5FAD7D225659685DEAC931806B2CCAFE_118254772.addTaint(taint);
        return var5FAD7D225659685DEAC931806B2CCAFE_118254772;
        // ---------- Original Method ----------
        //return getName() + ": static final long serialVersionUID =" + getSerialVersionUID() + "L;";
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.380 -0400", hash_original_field = "F80ED60A319D1F80CB33832164C227CF", hash_generated_field = "BA8EEE23E6596CE6F7527CE0FB83EF58")

    private static final long serialVersionUID = -6120832682080437368L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.380 -0400", hash_original_field = "356C063796A1DA01825DA22B2E8BF97E", hash_generated_field = "7C93B17B1CD1259F16B6C51AFF108516")

    private static final String UID_FIELD_NAME = "serialVersionUID";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.381 -0400", hash_original_field = "804DD882D7CAF8F79C2FD4521F960B6D", hash_generated_field = "9AFAE497812747A92BB053856885C1C2")

    static final long CONSTRUCTOR_IS_NOT_RESOLVED = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.381 -0400", hash_original_field = "622985B8B870C83F524B1E348D91C675", hash_generated_field = "590029B14B4132E56D522CD50C18A2A5")

    private static final int CLASS_MODIFIERS_MASK = Modifier.PUBLIC | Modifier.FINAL |
            Modifier.INTERFACE | Modifier.ABSTRACT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.382 -0400", hash_original_field = "A22CFAB1E19A0404A170D1B7CE8C38AA", hash_generated_field = "6E176BF4C7339EE62D8B4C9DEC6243A9")

    private static final int FIELD_MODIFIERS_MASK = Modifier.PUBLIC | Modifier.PRIVATE |
            Modifier.PROTECTED | Modifier.STATIC | Modifier.FINAL | Modifier.VOLATILE |
            Modifier.TRANSIENT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.382 -0400", hash_original_field = "91DFB60E26ED5735564D744CF8176019", hash_generated_field = "5D118F6B69CCB323323A9B49BDA9C6C3")

    private static final int METHOD_MODIFIERS_MASK = Modifier.PUBLIC | Modifier.PRIVATE |
            Modifier.PROTECTED | Modifier.STATIC | Modifier.FINAL | Modifier.SYNCHRONIZED |
            Modifier.NATIVE | Modifier.ABSTRACT | Modifier.STRICT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.384 -0400", hash_original_field = "624FC6A8300688A4B8B6B2000FCD81E0", hash_generated_field = "43D6F3E9D5C647D35731B8383079E1D6")

    private static final Class<?>[] READ_PARAM_TYPES = new Class[] { ObjectInputStream.class };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.385 -0400", hash_original_field = "C13E9F6B09096E6021DA7DDB46B18579", hash_generated_field = "4A3EE43FA683211E618FB6747D07F843")

    private static final Class<?>[] WRITE_PARAM_TYPES = new Class[] { ObjectOutputStream.class };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.385 -0400", hash_original_field = "243B2E96A5F4E8F89A323D42DBE7EEBC", hash_generated_field = "7D11682BF64A4B005019DE32559565EF")

    public static final ObjectStreamField[] NO_FIELDS = new ObjectStreamField[0];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.386 -0400", hash_original_field = "92BCE7D158829B88C361F39F1D78D7E8", hash_generated_field = "6978DEEE48DC3157891475C4DA0DAB91")

    static Class<?> ARRAY_OF_FIELDS;
    static {
        try {
            ARRAY_OF_FIELDS = Class.forName("[Ljava.io.ObjectStreamField;");
        } catch (ClassNotFoundException e) {
            throw new AssertionError(e);
        }
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.386 -0400", hash_original_field = "F76F81B088AEDCF4CC4AC04CE877788E", hash_generated_field = "FA5209333B79D9097B62842702D68121")

    private static final String CLINIT_NAME = "<clinit>";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.387 -0400", hash_original_field = "8DF4213BA7E05A81E7135E331B30C11A", hash_generated_field = "ACFFC1389FDC9F82445E4D03EE9ED911")

    private static final int CLINIT_MODIFIERS = Modifier.STATIC;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.387 -0400", hash_original_field = "BB1CCCC3FF0A517413C95AB9047469B9", hash_generated_field = "423C84B6DC3BB79CF9824136C350B1B0")

    private static final String CLINIT_SIGNATURE = "()V";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.388 -0400", hash_original_field = "94EB83F78C40AA1F634F2E0003836AD5", hash_generated_field = "4F2D1BC91F0EEAF8AFC3647840FAEB8F")

    private static final Class<Serializable> SERIALIZABLE = Serializable.class;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.388 -0400", hash_original_field = "11A54DB730E2A2D3B34516F5BDFFC5DA", hash_generated_field = "8FF60D62BE9F159A9087406109E4ACEB")

    private static final Class<Externalizable> EXTERNALIZABLE = Externalizable.class;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.389 -0400", hash_original_field = "596AA5ABAEC6715E1C73E44D6723DCCF", hash_generated_field = "E50E1B7F50901172462DF6CB7A52BABD")

    static final Class<String> STRINGCLASS = String.class;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.389 -0400", hash_original_field = "5F0E1B2239647B717460E2812C1E45A5", hash_generated_field = "51D83A7260A0C617FACB44B683730C6D")

    static final Class<?> CLASSCLASS = Class.class;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.390 -0400", hash_original_field = "4A025773485868FB6759CAC7E647646C", hash_generated_field = "F91CD3D7464571E8E9D05D8CAFE05B21")

    static final Class<ObjectStreamClass> OBJECTSTREAMCLASSCLASS = ObjectStreamClass.class;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.391 -0400", hash_original_field = "17CA37E35AD877567E00ECAF794A6918", hash_generated_field = "16A63F3AB899CF3EB9607AD6E5CAA631")

    private static SoftReference<ThreadLocal<WeakHashMap<Class<?>, ObjectStreamClass>>> storage = new SoftReference<ThreadLocal<WeakHashMap<Class<?>, ObjectStreamClass>>>(null);
    // orphaned legacy method
    public int compare(Class<?> itf1, Class<?> itf2) {
		return itf1.getName().compareTo(itf2.getName());
	}
    
    // orphaned legacy method
    public WeakHashMap<Class<?>, ObjectStreamClass> initialValue() {
		return new WeakHashMap<Class<?>, ObjectStreamClass>();
	}
    
    // orphaned legacy method
    public int compare(Method m1, Method m2) {
		int result = m1.getName().compareTo(m2.getName());
		if (result == 0) {
			return getMethodSignature(m1).compareTo(getMethodSignature(m2));
		}
		return result;
	}
    
    // orphaned legacy method
    public int compare(Constructor<?> ctr1, Constructor<?> ctr2) {
		return (getConstructorSignature(ctr1).compareTo(getConstructorSignature(ctr2)));
	}
    
    // orphaned legacy method
    public int compare(Field field1, Field field2) {
		return field1.getName().compareTo(field2.getName());
	}
    
}

