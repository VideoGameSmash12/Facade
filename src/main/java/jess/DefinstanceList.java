package jess;

import java.beans.PropertyDescriptor;
import java.beans.IntrospectionException;
import java.beans.PropertyChangeEvent;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import java.beans.PropertyChangeListener;
import java.io.Serializable;

class DefinstanceList implements Serializable, PropertyChangeListener
{
    private HashMap m_javaClasses;
    private HashMap m_definstances;
    private HashMap m_jessClasses;
    private transient Rete m_rete;
    static /* synthetic */ Class class$java$beans$PropertyChangeListener;
    
    void setEngine(final Rete rete) {
        this.m_rete = rete;
    }
    
    synchronized void clear() {
        final Iterator<Object> iterator = this.m_definstances.keySet().iterator();
        while (iterator.hasNext()) {
            this.removePropertyChangeListener(iterator.next());
        }
        this.m_javaClasses.clear();
        this.m_definstances.clear();
        this.m_jessClasses.clear();
    }
    
    synchronized void reset() throws JessException {
        final Iterator<Object> iterator = this.m_definstances.keySet().iterator();
        while (iterator.hasNext()) {
            this.updateMultipleSlots(iterator.next(), true, this.m_rete.getGlobalContext());
        }
    }
    
    synchronized Iterator listDefinstances() {
        return new ArrayList(this.m_definstances.keySet()).iterator();
    }
    
    synchronized Iterator listDefclasses() {
        return new ArrayList(this.m_javaClasses.keySet()).iterator();
    }
    
    String jessNameToJavaName(final String s) {
        return this.m_javaClasses.get(s);
    }
    
    void mapDefclassName(final String s, final String s2) {
        this.m_javaClasses.put(s, s2);
    }
    
    private final Fact updateShadowFact(final Object o, final String s, final Object o2, final boolean b, final Context context) throws JessException {
        if (s == null || o2 == null) {
            return this.updateMultipleSlots(o, b, context);
        }
        return this.updateSingleSlot(o, s, o2, context);
    }
    
    private final synchronized Fact updateMultipleSlots(final Object p0, final boolean p1, final Context p2) throws JessException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        jess/DefinstanceList.m_definstances:Ljava/util/HashMap;
        //     4: aload_1        
        //     5: invokevirtual   java/util/HashMap.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //     8: checkcast       Ljess/Fact;
        //    11: astore          4
        //    13: aload           4
        //    15: ifnonnull       34
        //    18: new             Ljess/JessException;
        //    21: dup            
        //    22: ldc             "DefinstanceList.updateShadowFact"
        //    24: ldc             "Object not a definstance: "
        //    26: aload_1        
        //    27: invokevirtual   java/lang/Object.toString:()Ljava/lang/String;
        //    30: invokespecial   jess/JessException.<init>:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //    33: athrow         
        //    34: aload_3        
        //    35: invokevirtual   jess/Context.getEngine:()Ljess/Rete;
        //    38: astore          5
        //    40: aload           5
        //    42: invokevirtual   jess/Rete.getFactList:()Ljess/FactList;
        //    45: astore          6
        //    47: goto            54
        //    50: aload           7
        //    52: monitorexit    
        //    53: athrow         
        //    54: aload           5
        //    56: invokevirtual   jess/Rete.getCompiler:()Ljess/ReteCompiler;
        //    59: dup            
        //    60: astore          7
        //    62: monitorenter   
        //    63: goto            70
        //    66: aload           10
        //    68: monitorexit    
        //    69: athrow         
        //    70: aload           5
        //    72: invokevirtual   jess/Rete.getActivationSemaphore:()Ljava/lang/Object;
        //    75: dup            
        //    76: astore          10
        //    78: monitorenter   
        //    79: aload           6
        //    81: aload           4
        //    83: aload           5
        //    85: invokevirtual   jess/FactList.prepareToModify:(Ljess/Fact;Ljess/Rete;)Ljess/Fact;
        //    88: pop            
        //    89: aload           4
        //    91: invokevirtual   jess/Fact.getDeftemplate:()Ljess/Deftemplate;
        //    94: astore          16
        //    96: iconst_0       
        //    97: anewarray       Ljava/lang/Object;
        //   100: astore          17
        //   102: iconst_0       
        //   103: istore          18
        //   105: goto            215
        //   108: aload           16
        //   110: iload           18
        //   112: invokevirtual   jess/Deftemplate.getSlotName:(I)Ljava/lang/String;
        //   115: ldc             "OBJECT"
        //   117: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   120: ifeq            126
        //   123: goto            212
        //   126: aload           16
        //   128: iload           18
        //   130: invokevirtual   jess/Deftemplate.getSlotDefault:(I)Ljess/Value;
        //   133: aload_3        
        //   134: invokevirtual   jess/Value.externalAddressValue:(Ljess/Context;)Ljava/lang/Object;
        //   137: checkcast       Ljess/SerializablePD;
        //   140: astore          19
        //   142: aload           19
        //   144: invokevirtual   jess/SerializablePD.getName:()Ljava/lang/String;
        //   147: astore          20
        //   149: aload           19
        //   151: aload           5
        //   153: invokevirtual   jess/SerializablePD.getReadMethod:(Ljess/Rete;)Ljava/lang/reflect/Method;
        //   156: astore          21
        //   158: aload           21
        //   160: invokevirtual   java/lang/reflect/Method.getReturnType:()Ljava/lang/Class;
        //   163: astore          22
        //   165: aload           21
        //   167: aload_1        
        //   168: aload           17
        //   170: invokevirtual   java/lang/reflect/Method.invoke:(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //   173: astore          23
        //   175: aload           22
        //   177: aload           23
        //   179: invokestatic    jess/ReflectFunctions.objectToValue:(Ljava/lang/Class;Ljava/lang/Object;)Ljess/Value;
        //   182: astore          24
        //   184: aload           4
        //   186: aload           20
        //   188: invokevirtual   jess/Fact.getSlotValue:(Ljava/lang/String;)Ljess/Value;
        //   191: astore          25
        //   193: aload           24
        //   195: aload           25
        //   197: invokevirtual   jess/Value.equals:(Ljess/Value;)Z
        //   200: ifne            212
        //   203: aload           4
        //   205: aload           20
        //   207: aload           24
        //   209: invokevirtual   jess/Fact.setSlotValue:(Ljava/lang/String;Ljess/Value;)V
        //   212: iinc            18, 1
        //   215: iload           18
        //   217: aload           16
        //   219: invokevirtual   jess/Deftemplate.getNSlots:()I
        //   222: if_icmplt       108
        //   225: goto            322
        //   228: astore          16
        //   230: new             Ljess/JessException;
        //   233: dup            
        //   234: ldc             "DefinstanceList.updateShadowFact"
        //   236: ldc             "Called method threw an exception"
        //   238: aload           16
        //   240: invokevirtual   java/lang/reflect/InvocationTargetException.getTargetException:()Ljava/lang/Throwable;
        //   243: invokespecial   jess/JessException.<init>:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   246: athrow         
        //   247: astore          16
        //   249: new             Ljess/JessException;
        //   252: dup            
        //   253: ldc             "DefinstanceList.updateShadowFact"
        //   255: ldc             "Method is not accessible"
        //   257: aload           16
        //   259: invokespecial   jess/JessException.<init>:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   262: athrow         
        //   263: astore          16
        //   265: new             Ljess/JessException;
        //   268: dup            
        //   269: ldc             "DefinstanceList.updateShadowFact"
        //   271: ldc             "Invalid argument"
        //   273: aload           16
        //   275: invokespecial   jess/JessException.<init>:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   278: athrow         
        //   279: astore          13
        //   281: jsr             287
        //   284: aload           13
        //   286: athrow         
        //   287: astore          14
        //   289: iload_2        
        //   290: ifne            308
        //   293: aload           6
        //   295: aload           4
        //   297: aload           5
        //   299: aload_3        
        //   300: invokevirtual   jess/FactList.finishModify:(Ljess/Fact;Ljess/Rete;Ljess/Context;)Ljess/Fact;
        //   303: astore          4
        //   305: goto            320
        //   308: aload_0        
        //   309: getfield        jess/DefinstanceList.m_rete:Ljess/Rete;
        //   312: aload           4
        //   314: aload_3        
        //   315: invokevirtual   jess/Rete.assertFact:(Ljess/Fact;Ljess/Context;)Ljess/Fact;
        //   318: astore          4
        //   320: ret             14
        //   322: jsr             287
        //   325: aload           10
        //   327: monitorexit    
        //   328: aload           7
        //   330: monitorexit    
        //   331: aload           4
        //   333: areturn        
        //    Exceptions:
        //  throws jess.JessException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                         
        //  -----  -----  -----  -----  ---------------------------------------------
        //  50     53     50     54     Any
        //  66     69     66     70     Any
        //  79     225    228    247    Ljava/lang/reflect/InvocationTargetException;
        //  79     225    247    263    Ljava/lang/IllegalAccessException;
        //  79     225    263    279    Ljava/lang/IllegalArgumentException;
        //  79     284    279    287    Any
        //  322    325    279    287    Any
        //  79     328    66     70     Any
        //  63     331    50     54     Any
        // 
        // The error that occurred was:
        // 
        // java.util.ConcurrentModificationException
        //     at java.util.ArrayList$Itr.checkForComodification(Unknown Source)
        //     at java.util.ArrayList$Itr.next(Unknown Source)
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2863)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2445)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private final synchronized Fact updateSingleSlot(final Object p0, final String p1, final Object p2, final Context p3) throws JessException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        jess/DefinstanceList.m_definstances:Ljava/util/HashMap;
        //     4: aload_1        
        //     5: invokevirtual   java/util/HashMap.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //     8: checkcast       Ljess/Fact;
        //    11: astore          5
        //    13: aload           5
        //    15: ifnonnull       34
        //    18: new             Ljess/JessException;
        //    21: dup            
        //    22: ldc             "DefinstanceList.updateShadowFact"
        //    24: ldc             "Object not a definstance: "
        //    26: aload_1        
        //    27: invokevirtual   java/lang/Object.toString:()Ljava/lang/String;
        //    30: invokespecial   jess/JessException.<init>:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //    33: athrow         
        //    34: aload           4
        //    36: invokevirtual   jess/Context.getEngine:()Ljess/Rete;
        //    39: astore          6
        //    41: aload           6
        //    43: invokevirtual   jess/Rete.getFactList:()Ljess/FactList;
        //    46: astore          7
        //    48: goto            55
        //    51: aload           8
        //    53: monitorexit    
        //    54: athrow         
        //    55: aload           6
        //    57: invokevirtual   jess/Rete.getCompiler:()Ljess/ReteCompiler;
        //    60: dup            
        //    61: astore          8
        //    63: monitorenter   
        //    64: goto            71
        //    67: aload           11
        //    69: monitorexit    
        //    70: athrow         
        //    71: aload           6
        //    73: invokevirtual   jess/Rete.getActivationSemaphore:()Ljava/lang/Object;
        //    76: dup            
        //    77: astore          11
        //    79: monitorenter   
        //    80: aload           7
        //    82: aload           5
        //    84: aload           6
        //    86: invokevirtual   jess/FactList.prepareToModify:(Ljess/Fact;Ljess/Rete;)Ljess/Fact;
        //    89: pop            
        //    90: aload           5
        //    92: invokevirtual   jess/Fact.getDeftemplate:()Ljess/Deftemplate;
        //    95: astore          17
        //    97: aload           17
        //    99: aload_2        
        //   100: invokevirtual   jess/Deftemplate.getSlotIndex:(Ljava/lang/String;)I
        //   103: istore          18
        //   105: iload           18
        //   107: iconst_m1      
        //   108: if_icmpne       147
        //   111: new             Ljess/JessException;
        //   114: dup            
        //   115: ldc             "DeftemplateList.updateSingleSlot"
        //   117: new             Ljava/lang/StringBuffer;
        //   120: dup            
        //   121: ldc             "No such slot "
        //   123: invokespecial   java/lang/StringBuffer.<init>:(Ljava/lang/String;)V
        //   126: aload_2        
        //   127: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   130: ldc             " in template"
        //   132: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   135: invokevirtual   java/lang/StringBuffer.toString:()Ljava/lang/String;
        //   138: aload           17
        //   140: invokevirtual   jess/Deftemplate.getName:()Ljava/lang/String;
        //   143: invokespecial   jess/JessException.<init>:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //   146: athrow         
        //   147: aload           17
        //   149: iload           18
        //   151: invokevirtual   jess/Deftemplate.getSlotDefault:(I)Ljess/Value;
        //   154: aload           4
        //   156: invokevirtual   jess/Value.externalAddressValue:(Ljess/Context;)Ljava/lang/Object;
        //   159: checkcast       Ljess/SerializablePD;
        //   162: astore          19
        //   164: aload           19
        //   166: aload           6
        //   168: invokevirtual   jess/SerializablePD.getReadMethod:(Ljess/Rete;)Ljava/lang/reflect/Method;
        //   171: astore          20
        //   173: aload           20
        //   175: invokevirtual   java/lang/reflect/Method.getReturnType:()Ljava/lang/Class;
        //   178: astore          21
        //   180: aload           21
        //   182: aload_3        
        //   183: invokestatic    jess/ReflectFunctions.objectToValue:(Ljava/lang/Class;Ljava/lang/Object;)Ljess/Value;
        //   186: astore          22
        //   188: aload           5
        //   190: aload_2        
        //   191: aload           22
        //   193: invokevirtual   jess/Fact.setSlotValue:(Ljava/lang/String;Ljess/Value;)V
        //   196: goto            240
        //   199: astore          17
        //   201: new             Ljess/JessException;
        //   204: dup            
        //   205: ldc             "DefinstanceList.updateShadowFact"
        //   207: ldc             "Invalid argument"
        //   209: aload           17
        //   211: invokespecial   jess/JessException.<init>:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   214: athrow         
        //   215: astore          14
        //   217: jsr             223
        //   220: aload           14
        //   222: athrow         
        //   223: astore          15
        //   225: aload           7
        //   227: aload           5
        //   229: aload           6
        //   231: aload           4
        //   233: invokevirtual   jess/FactList.finishModify:(Ljess/Fact;Ljess/Rete;Ljess/Context;)Ljess/Fact;
        //   236: astore          5
        //   238: ret             15
        //   240: jsr             223
        //   243: aload           11
        //   245: monitorexit    
        //   246: aload           8
        //   248: monitorexit    
        //   249: aload           5
        //   251: areturn        
        //    Exceptions:
        //  throws jess.JessException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                
        //  -----  -----  -----  -----  ------------------------------------
        //  51     54     51     55     Any
        //  67     70     67     71     Any
        //  80     196    199    215    Ljava/lang/IllegalArgumentException;
        //  80     220    215    223    Any
        //  240    243    215    223    Any
        //  80     246    67     71     Any
        //  64     249    51     55     Any
        // 
        // The error that occurred was:
        // 
        // java.util.ConcurrentModificationException
        //     at java.util.ArrayList$Itr.checkForComodification(Unknown Source)
        //     at java.util.ArrayList$Itr.next(Unknown Source)
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2863)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2445)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private final synchronized Fact createNewShadowFact(final Object o, final Context context, final int shadowMode) throws JessException {
        final Rete engine = context.getEngine();
        Fact fact;
        try {
            fact = new Fact(this.m_jessClasses.get(o), this.m_rete);
            fact.setSlotValue("OBJECT", new Value(o));
            fact.setShadowMode(shadowMode);
            this.m_definstances.put(o, fact);
            final Deftemplate deftemplate = fact.getDeftemplate();
            final Object[] array = new Object[0];
            for (int i = 0; i < deftemplate.getNSlots(); ++i) {
                if (!deftemplate.getSlotName(i).equals("OBJECT")) {
                    final SerializablePD serializablePD = (SerializablePD)deftemplate.getSlotDefault(i).externalAddressValue(context);
                    final String name = serializablePD.getName();
                    final Method readMethod = serializablePD.getReadMethod(engine);
                    fact.setSlotValue(name, ReflectFunctions.objectToValue(readMethod.getReturnType(), readMethod.invoke(o, array)));
                }
            }
        }
        catch (InvocationTargetException ex) {
            throw new JessException("DefinstanceList.createNewShadowFact", "Called method threw an exception", ex.getTargetException());
        }
        catch (IllegalAccessException ex2) {
            throw new JessException("DefinstanceList.createNewShadowFact", "Method is not accessible", ex2);
        }
        catch (IllegalArgumentException ex3) {
            throw new JessException("DefinstanceList.createNewShadowFact", "Invalid argument", ex3);
        }
        return this.m_rete.assertFact(fact, context);
    }
    
    synchronized Value updateObject(final Object o) throws JessException {
        return new FactIDValue(this.updateMultipleSlots(o, false, this.m_rete.getGlobalContext()));
    }
    
    synchronized Value definstance(final String s, final Object o, final boolean b, final Context context) throws JessException {
        try {
            final String jessNameToJavaName = this.jessNameToJavaName(s);
            if (jessNameToJavaName == null) {
                throw new JessException("DefinstanceList.definstance", "Unknown object class", s);
            }
            if (this.m_definstances.get(o) != null) {
                return new FactIDValue((Fact)null);
            }
            if (!context.getEngine().findClass(jessNameToJavaName).isAssignableFrom(o.getClass())) {
                throw new JessException("DefinstanceList.definstance", "Object is not instance of", jessNameToJavaName);
            }
            if (b) {
                o.getClass().getMethod("addPropertyChangeListener", Class.forName("java.beans.PropertyChangeListener")).invoke(o, this);
            }
            this.m_jessClasses.put(o, s);
            return new FactIDValue(this.createNewShadowFact(o, context, 2 - (b ? 1 : 0)));
        }
        catch (InvocationTargetException ex) {
            throw new JessException("DefinstanceList.definstance", "Cannot add PropertyChangeListener", ex.getTargetException());
        }
        catch (NoSuchMethodException ex2) {
            throw new JessException("DefinstanceList.definstance", "Obj doesn't accept PropertyChangeListeners", ex2);
        }
        catch (ClassNotFoundException ex3) {
            throw new JessException("DefinstanceList.definstance", "Class not found", ex3);
        }
        catch (IllegalAccessException ex4) {
            throw new JessException("DefinstanceList.definstance", "Class or method is not accessible", ex4);
        }
    }
    
    synchronized Fact undefinstance(final Object o) throws JessException {
        Fact retractNoUndefinstance = this.m_definstances.get(o);
        if (retractNoUndefinstance != null) {
            retractNoUndefinstance = this.m_rete.retractNoUndefinstance(retractNoUndefinstance);
        }
        this.m_definstances.remove(o);
        this.removePropertyChangeListener(o);
        this.m_jessClasses.remove(o);
        return retractNoUndefinstance;
    }
    
    private final void removePropertyChangeListener(final Object o) {
        try {
            final Class<?> class1 = o.getClass();
            final String s = "removePropertyChangeListener";
            final Class[] array = { null };
            final int n = 0;
            Class class$java$beans$PropertyChangeListener;
            if ((class$java$beans$PropertyChangeListener = DefinstanceList.class$java$beans$PropertyChangeListener) == null) {
                class$java$beans$PropertyChangeListener = (DefinstanceList.class$java$beans$PropertyChangeListener = class$("[Ljava.beans.PropertyChangeListener;", false));
            }
            array[n] = class$java$beans$PropertyChangeListener;
            class1.getMethod(s, (Class[])array).invoke(o, this);
        }
        catch (Exception ex) {}
    }
    
    public synchronized void propertyChange(final PropertyChangeEvent propertyChangeEvent) {
        final Object source = propertyChangeEvent.getSource();
        try {
            if (this.m_jessClasses.get(source) != null) {
                this.updateShadowFact(source, propertyChangeEvent.getPropertyName(), propertyChangeEvent.getNewValue(), false, this.m_rete.getGlobalContext());
            }
        }
        catch (JessException ex) {
            System.out.println("Async Error: " + ex);
            if (ex.getCause() != null) {
                ex.getCause().printStackTrace();
            }
        }
    }
    
    synchronized Value defclass(final String s, final String s2, final String s3) throws JessException {
        try {
            Deftemplate deftemplate2;
            if (s3 != null) {
                final Deftemplate deftemplate = this.m_rete.findDeftemplate(this.m_rete.resolveName(s3));
                if (deftemplate == null) {
                    throw new JessException("defclass", "No such parent template: ", s3);
                }
                deftemplate2 = new Deftemplate(s, "$JAVA-OBJECT$ " + s2, deftemplate, this.m_rete);
            }
            else {
                deftemplate2 = new Deftemplate(s, "$JAVA-OBJECT$ " + s2, this.m_rete);
            }
            final Class class1 = this.m_rete.findClass(s2);
            this.mapDefclassName(s, class1.getName());
            final PropertyDescriptor[] propertyDescriptors = ReflectFunctions.getPropertyDescriptors(class1);
            for (int i = 0; i < propertyDescriptors.length - 1; ++i) {
                for (int j = i + 1; j < propertyDescriptors.length; ++j) {
                    if (propertyDescriptors[i].getName().compareTo(propertyDescriptors[j].getName()) > 0) {
                        final PropertyDescriptor propertyDescriptor = propertyDescriptors[i];
                        propertyDescriptors[i] = propertyDescriptors[j];
                        propertyDescriptors[j] = propertyDescriptor;
                    }
                }
            }
            for (int k = 0; k < propertyDescriptors.length; ++k) {
                final Method readMethod = propertyDescriptors[k].getReadMethod();
                if (readMethod != null) {
                    final String name = propertyDescriptors[k].getName();
                    final Class<?> returnType = readMethod.getReturnType();
                    final Value value = new Value(new SerializablePD(class1, propertyDescriptors[k]));
                    if (returnType.isArray()) {
                        deftemplate2.addMultiSlot(name, value);
                    }
                    else {
                        deftemplate2.addSlot(name, value, "ANY");
                    }
                }
            }
            deftemplate2.addSlot("OBJECT", Funcall.NIL, "OBJECT");
            this.m_rete.addDeftemplate(deftemplate2);
            return new Value(class1.getName(), 1);
        }
        catch (ClassNotFoundException ex) {
            throw new JessException("defclass", "Class not found:", ex);
        }
        catch (IntrospectionException ex2) {
            throw new JessException("defclass", "Introspection error:", ex2);
        }
    }
    
    static /* synthetic */ Class class$(final String s, final boolean b) {
        try {
            final Class<?> forName = Class.forName(s);
            if (!b) {
                forName.getComponentType();
            }
            return forName;
        }
        catch (ClassNotFoundException ex) {
            throw new NoClassDefFoundError(ex.getMessage());
        }
    }
    
    private final /* synthetic */ void this() {
        this.m_javaClasses = new HashMap(101);
        this.m_definstances = new HashMap(101);
        this.m_jessClasses = new HashMap(101);
    }
    
    DefinstanceList(final Rete engine) {
        this.this();
        this.setEngine(engine);
    }
}
