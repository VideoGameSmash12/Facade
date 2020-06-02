package jess;

import jess.factory.FactoryImpl;
import java.util.TreeMap;
import java.applet.Applet;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Collections;
import java.util.HashMap;
import java.io.PrintWriter;
import java.io.Writer;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.List;
import jess.awt.TextReader;
import jess.factory.Factory;
import java.io.Serializable;

public class Rete implements Serializable, JessListener
{
    private static Factory m_factory;
    public static final int INSTALL = 0;
    public static final int ACTIVATE = 1;
    public static final int EVERY_TIME = 2;
    private static final String LIBRARY_NAME = "scriptlib.clp";
    private transient Object m_appObject;
    private Context m_globalContext;
    private transient Routers m_routers;
    private transient TextReader m_tis;
    private transient Jesp m_jesp;
    private transient JessEventSupport m_jes;
    private boolean m_resetGlobals;
    private List m_deffacts;
    private List m_defglobals;
    private Map m_functions;
    private FactList m_factList;
    private DefinstanceList m_definstanceList;
    private Map m_rules;
    private ReteCompiler m_compiler;
    private Map m_storage;
    private Agenda m_agenda;
    private Hashtable m_classImports;
    private ArrayList m_packageImports;
    private boolean[] m_watchInfo;
    static /* synthetic */ Class class$jess$Rete;
    
    public void addInputRouter(final String s, final Reader reader, final boolean b) {
        this.m_routers.addInputRouter(s, reader, b);
    }
    
    public void removeInputRouter(final String s) {
        this.m_routers.removeInputRouter(s);
    }
    
    public Reader getInputRouter(final String s) {
        return this.m_routers.getInputRouter(s);
    }
    
    Tokenizer getInputWrapper(final Reader reader) {
        return this.m_routers.getInputWrapper(reader);
    }
    
    public void addOutputRouter(final String s, final Writer writer) {
        this.m_routers.addOutputRouter(s, writer);
    }
    
    public void removeOutputRouter(final String s) {
        this.m_routers.removeOutputRouter(s);
    }
    
    public boolean getInputMode(final String s) {
        return this.m_routers.getInputMode(s);
    }
    
    public Writer getOutputRouter(final String s) {
        return this.m_routers.getOutputRouter(s);
    }
    
    public PrintWriter getErrStream() {
        return this.m_routers.getErrStream();
    }
    
    public PrintWriter getOutStream() {
        return this.m_routers.getOutStream();
    }
    
    public int doPreAssertionProcessing(final Fact fact) throws JessException {
        return this.m_factList.doPreAssertionProcessing(fact);
    }
    
    public synchronized void clear() throws JessException {
        this.clearStorage();
        this.m_globalContext.clear();
        this.m_factList.clear();
        this.m_rules.clear();
        this.m_agenda.clear();
        this.m_definstanceList.clear();
        this.keepJavaUserFunctionsOnly();
        Deftemplate.addStandardTemplates(this);
        this.m_compiler = new ReteCompiler();
        this.m_deffacts.clear();
        this.m_defglobals.clear();
        this.broadcastEvent(2048, this);
        this.setEventMask(0);
        this.unwatchAll();
        this.loadScriptlib();
        System.gc();
    }
    
    private final void keepJavaUserFunctionsOnly() {
        final ArrayList<Userfunction> list = new ArrayList<Userfunction>();
        final Iterator<String> iterator = this.m_functions.keySet().iterator();
        while (iterator.hasNext()) {
            final Userfunction userfunction = this.findUserfunction(iterator.next());
            if (!(userfunction instanceof Deffunction)) {
                list.add(userfunction);
            }
        }
        this.m_functions = Collections.synchronizedMap(new HashMap<Object, Object>());
        final Iterator<Userfunction> iterator2 = list.iterator();
        while (iterator2.hasNext()) {
            this.addUserfunction(iterator2.next());
        }
    }
    
    public void setPendingFact(final Fact fact, final boolean b) {
        this.m_factList.setPendingFact(fact, b);
    }
    
    void removeAllFacts() throws JessException {
        this.processToken(3, Fact.getClearFact());
        this.m_factList.clear();
    }
    
    public void reset() throws JessException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: aload_1        
        //     4: monitorexit    
        //     5: athrow         
        //     6: aload_0        
        //     7: getfield        jess/Rete.m_compiler:Ljess/ReteCompiler;
        //    10: dup            
        //    11: astore_1       
        //    12: monitorenter   
        //    13: aload_0        
        //    14: invokevirtual   jess/Rete.removeAllFacts:()V
        //    17: aload_0        
        //    18: getfield        jess/Rete.m_globalContext:Ljess/Context;
        //    21: invokevirtual   jess/Context.removeNonGlobals:()V
        //    24: aload_0        
        //    25: getfield        jess/Rete.m_agenda:Ljess/Agenda;
        //    28: aload_0        
        //    29: invokevirtual   jess/Agenda.reset:(Ljess/Rete;)V
        //    32: aload_0        
        //    33: invokestatic    jess/Fact.getInitialFact:()Ljess/Fact;
        //    36: aload_0        
        //    37: invokevirtual   jess/Rete.getGlobalContext:()Ljess/Context;
        //    40: invokevirtual   jess/Rete.assertFact:(Ljess/Fact;Ljess/Context;)Ljess/Fact;
        //    43: pop            
        //    44: aload_0        
        //    45: invokespecial   jess/Rete.resetDefglobals:()V
        //    48: aload_0        
        //    49: invokespecial   jess/Rete.resetDeffacts:()V
        //    52: aload_1        
        //    53: monitorexit    
        //    54: aload_0        
        //    55: getfield        jess/Rete.m_definstanceList:Ljess/DefinstanceList;
        //    58: invokevirtual   jess/DefinstanceList.reset:()V
        //    61: aload_0        
        //    62: sipush          4096
        //    65: aload_0        
        //    66: invokevirtual   jess/Rete.broadcastEvent:(ILjava/lang/Object;)V
        //    69: return         
        //    Exceptions:
        //  throws jess.JessException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  3      5      3      6      Any
        //  13     54     3      6      Any
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
    
    private final void resetDeffacts() throws JessException {
        final Iterator<Deffacts> iterator = this.m_deffacts.iterator();
        while (iterator.hasNext()) {
            iterator.next().reset(this);
        }
    }
    
    private final void resetDefglobals() throws JessException {
        if (this.getResetGlobals()) {
            final Iterator<Defglobal> iterator = this.m_defglobals.iterator();
            while (iterator.hasNext()) {
                iterator.next().reset(this);
            }
        }
    }
    
    public Fact assertString(final String p0, final Context p1) throws JessException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: aload_3        
        //     4: monitorexit    
        //     5: athrow         
        //     6: aload_0        
        //     7: getfield        jess/Rete.m_tis:Ljess/awt/TextReader;
        //    10: dup            
        //    11: astore_3       
        //    12: monitorenter   
        //    13: aload_0        
        //    14: getfield        jess/Rete.m_tis:Ljess/awt/TextReader;
        //    17: invokevirtual   jess/awt/TextReader.clear:()V
        //    20: aload_0        
        //    21: getfield        jess/Rete.m_jesp:Ljess/Jesp;
        //    24: invokevirtual   jess/Jesp.clear:()V
        //    27: aload_0        
        //    28: getfield        jess/Rete.m_tis:Ljess/awt/TextReader;
        //    31: new             Ljava/lang/StringBuffer;
        //    34: dup            
        //    35: ldc_w           "(assert "
        //    38: invokespecial   java/lang/StringBuffer.<init>:(Ljava/lang/String;)V
        //    41: aload_1        
        //    42: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //    45: bipush          41
        //    47: invokevirtual   java/lang/StringBuffer.append:(C)Ljava/lang/StringBuffer;
        //    50: invokevirtual   java/lang/StringBuffer.toString:()Ljava/lang/String;
        //    53: invokevirtual   jess/awt/TextReader.appendText:(Ljava/lang/String;)V
        //    56: aload_0        
        //    57: getfield        jess/Rete.m_jesp:Ljess/Jesp;
        //    60: aconst_null    
        //    61: aload_2        
        //    62: invokevirtual   jess/Jesp.parseAndExecuteFuncall:(Ljess/JessToken;Ljess/Context;)Ljess/Value;
        //    65: astore          6
        //    67: aload           6
        //    69: invokevirtual   jess/Value.type:()I
        //    72: bipush          16
        //    74: if_icmpne       86
        //    77: aload           6
        //    79: aload_2        
        //    80: invokevirtual   jess/Value.factValue:(Ljess/Context;)Ljess/Fact;
        //    83: aload_3        
        //    84: monitorexit    
        //    85: areturn        
        //    86: aconst_null    
        //    87: aload_3        
        //    88: monitorexit    
        //    89: areturn        
        //    Exceptions:
        //  throws jess.JessException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  3      5      3      6      Any
        //  86     89     3      6      Any
        //  13     85     3      6      Any
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
    
    public Fact assertString(final String s) throws JessException {
        return this.assertString(s, this.getGlobalContext());
    }
    
    public Fact assert(final Fact fact) throws JessException {
        return this.assertFact(fact);
    }
    
    public Fact assertFact(final Fact fact) throws JessException {
        return this.assertFact(fact, this.getGlobalContext());
    }
    
    public Fact assert(final Fact fact, final Context context) throws JessException {
        return this.assertFact(fact, context);
    }
    
    public Fact assertFact(final Fact p0, final Context p1) throws JessException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: aload_3        
        //     4: monitorexit    
        //     5: athrow         
        //     6: aload_0        
        //     7: getfield        jess/Rete.m_compiler:Ljess/ReteCompiler;
        //    10: dup            
        //    11: astore_3       
        //    12: monitorenter   
        //    13: aload_0        
        //    14: getfield        jess/Rete.m_factList:Ljess/FactList;
        //    17: aload_1        
        //    18: aload_0        
        //    19: aload_2        
        //    20: invokevirtual   jess/FactList.assertFact:(Ljess/Fact;Ljess/Rete;Ljess/Context;)Ljess/Fact;
        //    23: aload_3        
        //    24: monitorexit    
        //    25: areturn        
        //    Exceptions:
        //  throws jess.JessException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  3      5      3      6      Any
        //  13     25     3      6      Any
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
    
    Fact assertKeepID(final Fact p0, final Context p1) throws JessException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     4: monitorexit    
        //     5: athrow         
        //     6: aload_0        
        //     7: getfield        jess/Rete.m_compiler:Ljess/ReteCompiler;
        //    10: dup            
        //    11: astore_3       
        //    12: monitorenter   
        //    13: aload_0        
        //    14: getfield        jess/Rete.m_factList:Ljess/FactList;
        //    17: aload_1        
        //    18: aload_0        
        //    19: aload_2        
        //    20: invokevirtual   jess/FactList.assertKeepID:(Ljess/Fact;Ljess/Rete;Ljess/Context;)Ljess/Fact;
        //    23: aload_3        
        //    24: monitorexit    
        //    25: areturn        
        //    Exceptions:
        //  throws jess.JessException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  3      5      3      6      Any
        //  13     25     3      6      Any
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
    
    public Fact retractString(final String p0) throws JessException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: aload_2        
        //     4: monitorexit    
        //     5: athrow         
        //     6: aload_0        
        //     7: getfield        jess/Rete.m_tis:Ljess/awt/TextReader;
        //    10: dup            
        //    11: astore_2       
        //    12: monitorenter   
        //    13: aload_0        
        //    14: getfield        jess/Rete.m_tis:Ljess/awt/TextReader;
        //    17: invokevirtual   jess/awt/TextReader.clear:()V
        //    20: aload_0        
        //    21: getfield        jess/Rete.m_jesp:Ljess/Jesp;
        //    24: invokevirtual   jess/Jesp.clear:()V
        //    27: aload_0        
        //    28: getfield        jess/Rete.m_tis:Ljess/awt/TextReader;
        //    31: aload_1        
        //    32: invokevirtual   jess/awt/TextReader.appendText:(Ljava/lang/String;)V
        //    35: aload_0        
        //    36: getfield        jess/Rete.m_jesp:Ljess/Jesp;
        //    39: invokevirtual   jess/Jesp.parseFact:()Ljess/Fact;
        //    42: astore          5
        //    44: aload_0        
        //    45: aload           5
        //    47: invokevirtual   jess/Rete.retract:(Ljess/Fact;)Ljess/Fact;
        //    50: aload_2        
        //    51: monitorexit    
        //    52: areturn        
        //    53: astore_2       
        //    54: new             Ljess/JessException;
        //    57: dup            
        //    58: ldc_w           "Rete.retractString"
        //    61: aload_1        
        //    62: aload_2        
        //    63: invokespecial   jess/JessException.<init>:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //    66: athrow         
        //    Exceptions:
        //  throws jess.JessException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  3      5      3      6      Any
        //  13     52     3      6      Any
        //  0      52     53     67     Ljava/lang/Exception;
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
    
    public Fact retract(final Fact p0) throws JessException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   jess/Fact.isShadow:()Z
        //     4: ifeq            25
        //     7: aload_1        
        //     8: ldc_w           "OBJECT"
        //    11: invokevirtual   jess/Fact.getSlotValue:(Ljava/lang/String;)Ljess/Value;
        //    14: aconst_null    
        //    15: invokevirtual   jess/Value.externalAddressValue:(Ljess/Context;)Ljava/lang/Object;
        //    18: astore_2       
        //    19: aload_0        
        //    20: aload_2        
        //    21: invokevirtual   jess/Rete.undefinstance:(Ljava/lang/Object;)Ljess/Fact;
        //    24: areturn        
        //    25: goto            31
        //    28: aload_2        
        //    29: monitorexit    
        //    30: athrow         
        //    31: aload_0        
        //    32: getfield        jess/Rete.m_compiler:Ljess/ReteCompiler;
        //    35: dup            
        //    36: astore_2       
        //    37: monitorenter   
        //    38: aload_0        
        //    39: getfield        jess/Rete.m_factList:Ljess/FactList;
        //    42: aload_1        
        //    43: aload_0        
        //    44: invokevirtual   jess/FactList.retract:(Ljess/Fact;Ljess/Rete;)Ljess/Fact;
        //    47: aload_2        
        //    48: monitorexit    
        //    49: areturn        
        //    Exceptions:
        //  throws jess.JessException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  28     30     28     31     Any
        //  38     49     28     31     Any
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
    
    Fact retractNoUndefinstance(final Fact p0) throws JessException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     4: monitorexit    
        //     5: athrow         
        //     6: aload_0        
        //     7: getfield        jess/Rete.m_compiler:Ljess/ReteCompiler;
        //    10: dup            
        //    11: astore_2       
        //    12: monitorenter   
        //    13: aload_0        
        //    14: getfield        jess/Rete.m_factList:Ljess/FactList;
        //    17: aload_1        
        //    18: aload_0        
        //    19: invokevirtual   jess/FactList.retract:(Ljess/Fact;Ljess/Rete;)Ljess/Fact;
        //    22: aload_2        
        //    23: monitorexit    
        //    24: areturn        
        //    Exceptions:
        //  throws jess.JessException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  3      5      3      6      Any
        //  13     24     3      6      Any
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
    
    public Fact modify(final Fact fact, final String s, final Value value) throws JessException {
        return this.m_factList.modify(fact, s, value, this, this.getGlobalContext());
    }
    
    public Fact modify(final Fact fact, final String s, final Value value, final Context context) throws JessException {
        return this.m_factList.modify(fact, s, value, this, context);
    }
    
    Fact _modify(final ValueVector valueVector, final Context context) throws JessException {
        return this.m_factList._modify(valueVector, context, this);
    }
    
    Fact _duplicate(final ValueVector valueVector, final Context context) throws JessException {
        return this.m_factList._duplicate(valueVector, context, this);
    }
    
    public Fact findFactByID(final int n) throws JessException {
        return this.m_factList.findFactByID(n);
    }
    
    public Fact findFactByFact(final Fact fact) throws JessException {
        return this.m_factList.findFactByFact(fact);
    }
    
    void removeLogicalSupportFrom(final Token token, final Fact fact) {
        this.m_factList.removeLogicalSupportFrom(token, fact);
    }
    
    public void ppFacts(final String s, final Writer writer) throws IOException {
        this.m_factList.ppFacts(this.resolveName(s), writer);
    }
    
    public void ppFacts(final Writer writer) throws IOException {
        this.m_factList.ppFacts(writer);
    }
    
    public Iterator listDeffacts() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: aload_1        
        //     4: monitorexit    
        //     5: athrow         
        //     6: aload_0        
        //     7: getfield        jess/Rete.m_deffacts:Ljava/util/List;
        //    10: dup            
        //    11: astore_1       
        //    12: monitorenter   
        //    13: new             Ljava/util/ArrayList;
        //    16: dup            
        //    17: aload_0        
        //    18: getfield        jess/Rete.m_deffacts:Ljava/util/List;
        //    21: invokespecial   java/util/ArrayList.<init>:(Ljava/util/Collection;)V
        //    24: invokevirtual   java/util/ArrayList.iterator:()Ljava/util/Iterator;
        //    27: aload_1        
        //    28: monitorexit    
        //    29: areturn        
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  3      5      3      6      Any
        //  13     29     3      6      Any
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
    
    public Deffacts findDeffacts(String resolveName) {
        resolveName = this.resolveName(resolveName);
        final Iterator listDeffacts = this.listDeffacts();
        while (listDeffacts.hasNext()) {
            final Deffacts deffacts = listDeffacts.next();
            if (deffacts.getName().equals(resolveName)) {
                return deffacts;
            }
        }
        return null;
    }
    
    public Iterator listDeftemplates() {
        final ArrayList<Object> list = new ArrayList<Object>();
        final Iterator listModules = this.m_agenda.listModules();
        while (listModules.hasNext()) {
            try {
                final Iterator listDeftemplates = this.m_agenda.getModule(listModules.next()).listDeftemplates();
                while (listDeftemplates.hasNext()) {
                    list.add(listDeftemplates.next());
                }
            }
            catch (JessException ex) {}
        }
        return list.iterator();
    }
    
    public Iterator listDefrules() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: aload_1        
        //     4: monitorexit    
        //     5: athrow         
        //     6: aload_0        
        //     7: getfield        jess/Rete.m_rules:Ljava/util/Map;
        //    10: dup            
        //    11: astore_1       
        //    12: monitorenter   
        //    13: new             Ljava/util/ArrayList;
        //    16: dup            
        //    17: aload_0        
        //    18: getfield        jess/Rete.m_rules:Ljava/util/Map;
        //    21: invokeinterface java/util/Map.values:()Ljava/util/Collection;
        //    26: invokespecial   java/util/ArrayList.<init>:(Ljava/util/Collection;)V
        //    29: invokevirtual   java/util/ArrayList.iterator:()Ljava/util/Iterator;
        //    32: aload_1        
        //    33: monitorexit    
        //    34: areturn        
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  3      5      3      6      Any
        //  13     34     3      6      Any
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
    
    public Iterator listFacts() {
        return this.m_factList.listFacts();
    }
    
    public Iterator listDefinstances() {
        return this.m_definstanceList.listDefinstances();
    }
    
    public Iterator listDefclasses() {
        return this.m_definstanceList.listDefclasses();
    }
    
    public Iterator listDefglobals() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: aload_1        
        //     4: monitorexit    
        //     5: athrow         
        //     6: aload_0        
        //     7: getfield        jess/Rete.m_defglobals:Ljava/util/List;
        //    10: dup            
        //    11: astore_1       
        //    12: monitorenter   
        //    13: new             Ljava/util/ArrayList;
        //    16: dup            
        //    17: aload_0        
        //    18: getfield        jess/Rete.m_defglobals:Ljava/util/List;
        //    21: invokespecial   java/util/ArrayList.<init>:(Ljava/util/Collection;)V
        //    24: invokevirtual   java/util/ArrayList.iterator:()Ljava/util/Iterator;
        //    27: aload_1        
        //    28: monitorexit    
        //    29: areturn        
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  3      5      3      6      Any
        //  13     29     3      6      Any
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
    
    public Iterator listFunctions() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   java/util/ArrayList.<init>:()V
        //     7: astore_1       
        //     8: goto            14
        //    11: aload_2        
        //    12: monitorexit    
        //    13: athrow         
        //    14: aload_0        
        //    15: getfield        jess/Rete.m_functions:Ljava/util/Map;
        //    18: dup            
        //    19: astore_2       
        //    20: monitorenter   
        //    21: aload_0        
        //    22: getfield        jess/Rete.m_functions:Ljava/util/Map;
        //    25: invokeinterface java/util/Map.keySet:()Ljava/util/Set;
        //    30: invokeinterface java/util/Set.iterator:()Ljava/util/Iterator;
        //    35: astore          5
        //    37: goto            59
        //    40: aload_1        
        //    41: aload_0        
        //    42: aload           5
        //    44: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    49: checkcast       Ljava/lang/String;
        //    52: invokevirtual   jess/Rete.findUserfunction:(Ljava/lang/String;)Ljess/Userfunction;
        //    55: invokevirtual   java/util/ArrayList.add:(Ljava/lang/Object;)Z
        //    58: pop            
        //    59: aload           5
        //    61: invokeinterface java/util/Iterator.hasNext:()Z
        //    66: ifne            40
        //    69: aload_2        
        //    70: monitorexit    
        //    71: aload_1        
        //    72: invokevirtual   java/util/ArrayList.iterator:()Ljava/util/Iterator;
        //    75: areturn        
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  11     13     11     14     Any
        //  21     71     11     14     Any
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
    
    public final HasLHS findDefrule(final String s) {
        return this.m_rules.get(this.resolveName(s));
    }
    
    public Class javaClassForDefclass(final String s) {
        try {
            final String jessNameToJavaName = this.m_definstanceList.jessNameToJavaName(s);
            if (jessNameToJavaName == null) {
                return null;
            }
            return this.findClass(jessNameToJavaName);
        }
        catch (ClassNotFoundException ex) {
            return null;
        }
    }
    
    public Deftemplate findDeftemplate(final String s) throws JessException {
        final String resolveName = this.resolveName(s);
        Deftemplate deftemplate = this.m_agenda.getModule(resolveName.substring(0, resolveName.indexOf("::"))).getDeftemplate(s);
        if (deftemplate == null && !resolveName.equals(s)) {
            deftemplate = this.m_agenda.getModule("MAIN").getDeftemplate(s);
        }
        return deftemplate;
    }
    
    Deftemplate createDeftemplate(final String s) throws JessException {
        Deftemplate deftemplate = this.findDeftemplate(s);
        if (deftemplate == null) {
            deftemplate = this.addDeftemplate(new Deftemplate(s, "(Implied)", this));
            deftemplate.addMultiSlot("__data", Funcall.NILLIST);
        }
        return deftemplate;
    }
    
    public Deftemplate addDeftemplate(final Deftemplate deftemplate) throws JessException {
        return this.m_agenda.getModule(deftemplate.getModule()).addDeftemplate(deftemplate, this);
    }
    
    public Deffacts addDeffacts(final Deffacts deffacts) throws JessException {
        this.broadcastEvent(8, deffacts);
        this.m_deffacts.add(deffacts);
        return deffacts;
    }
    
    public Defglobal addDefglobal(final Defglobal defglobal) throws JessException {
        this.broadcastEvent(256, defglobal);
        defglobal.reset(this);
        this.m_defglobals.add(defglobal);
        return defglobal;
    }
    
    public Defglobal findDefglobal(final String s) {
        final Iterator listDefglobals = this.listDefglobals();
        while (listDefglobals.hasNext()) {
            final Defglobal defglobal = listDefglobals.next();
            if (defglobal.getName().equals(s)) {
                return defglobal;
            }
        }
        return null;
    }
    
    public Userfunction addUserfunction(final Userfunction function) {
        try {
            this.broadcastEvent(512, function);
        }
        catch (JessException ex) {
            return null;
        }
        FunctionHolder functionHolder;
        if ((functionHolder = this.m_functions.get(function.getName())) != null) {
            functionHolder.setFunction(function);
        }
        else {
            functionHolder = new FunctionHolder(function);
        }
        this.m_functions.put(function.getName(), functionHolder);
        return function;
    }
    
    public Userpackage addUserpackage(final Userpackage userpackage) {
        try {
            this.broadcastEvent(1024, userpackage);
        }
        catch (JessException ex) {
            return null;
        }
        userpackage.add(this);
        return userpackage;
    }
    
    public final Userfunction findUserfunction(final String s) {
        final FunctionHolder functionHolder = this.m_functions.get(s);
        if (functionHolder != null) {
            return functionHolder.getFunction();
        }
        return Funcall.getIntrinsic(s);
    }
    
    final FunctionHolder findFunctionHolder(final String s) {
        FunctionHolder functionHolder = this.m_functions.get(s);
        if (functionHolder == null) {
            final Userfunction intrinsic = Funcall.getIntrinsic(s);
            if (intrinsic != null) {
                this.addUserfunction(intrinsic);
            }
            functionHolder = this.m_functions.get(s);
        }
        return functionHolder;
    }
    
    public final HasLHS addDefrule(final HasLHS p0) throws JessException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: aload_2        
        //     4: monitorexit    
        //     5: athrow         
        //     6: aload_0        
        //     7: getfield        jess/Rete.m_compiler:Ljess/ReteCompiler;
        //    10: dup            
        //    11: astore_2       
        //    12: monitorenter   
        //    13: aconst_null    
        //    14: astore          5
        //    16: aload_0        
        //    17: aload_1        
        //    18: invokevirtual   jess/HasLHS.getName:()Ljava/lang/String;
        //    21: invokevirtual   jess/Rete.unDefrule:(Ljava/lang/String;)Ljess/Value;
        //    24: pop            
        //    25: aload_0        
        //    26: getfield        jess/Rete.m_compiler:Ljess/ReteCompiler;
        //    29: aload_1        
        //    30: aload_0        
        //    31: invokevirtual   jess/ReteCompiler.addRule:(Ljess/HasLHS;Ljess/Rete;)V
        //    34: goto            59
        //    37: astore          6
        //    39: aload_1        
        //    40: aload_0        
        //    41: getfield        jess/Rete.m_compiler:Ljess/ReteCompiler;
        //    44: invokevirtual   jess/ReteCompiler.getRoot:()Ljess/Node;
        //    47: invokevirtual   jess/HasLHS.remove:(Ljess/Node;)V
        //    50: aload           6
        //    52: athrow         
        //    53: astore          6
        //    55: aload           6
        //    57: astore          5
        //    59: aload_0        
        //    60: getfield        jess/Rete.m_rules:Ljava/util/Map;
        //    63: aload_1        
        //    64: invokevirtual   jess/HasLHS.getName:()Ljava/lang/String;
        //    67: aload_1        
        //    68: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    73: pop            
        //    74: aload_0        
        //    75: iconst_1       
        //    76: aload_1        
        //    77: invokevirtual   jess/Rete.broadcastEvent:(ILjava/lang/Object;)V
        //    80: aload           5
        //    82: ifnull          88
        //    85: aload           5
        //    87: athrow         
        //    88: aload_1        
        //    89: aload_2        
        //    90: monitorexit    
        //    91: areturn        
        //    Exceptions:
        //  throws jess.JessException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                        
        //  -----  -----  -----  -----  ----------------------------
        //  3      5      3      6      Any
        //  25     34     37     53     Ljess/RuleCompilerException;
        //  25     34     53     59     Ljess/JessException;
        //  13     91     3      6      Any
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
    
    public final Value unDefrule(final String p0) throws JessException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: aload_2        
        //     4: monitorexit    
        //     5: athrow         
        //     6: aload_0        
        //     7: getfield        jess/Rete.m_compiler:Ljess/ReteCompiler;
        //    10: dup            
        //    11: astore_2       
        //    12: monitorenter   
        //    13: aload_0        
        //    14: aload_1        
        //    15: invokevirtual   jess/Rete.findDefrule:(Ljava/lang/String;)Ljess/HasLHS;
        //    18: astore          5
        //    20: aload           5
        //    22: ifnull          146
        //    25: aload           5
        //    27: aload_0        
        //    28: getfield        jess/Rete.m_compiler:Ljess/ReteCompiler;
        //    31: invokevirtual   jess/ReteCompiler.getRoot:()Ljess/Node;
        //    34: invokevirtual   jess/HasLHS.remove:(Ljess/Node;)V
        //    37: aload_0        
        //    38: getfield        jess/Rete.m_rules:Ljava/util/Map;
        //    41: aload_0        
        //    42: aload_1        
        //    43: invokevirtual   jess/Rete.resolveName:(Ljava/lang/String;)Ljava/lang/String;
        //    46: invokeinterface java/util/Map.remove:(Ljava/lang/Object;)Ljava/lang/Object;
        //    51: pop            
        //    52: aload           5
        //    54: instanceof      Ljess/Defrule;
        //    57: ifeq            110
        //    60: aload_0        
        //    61: getfield        jess/Rete.m_agenda:Ljess/Agenda;
        //    64: invokevirtual   jess/Agenda.listActivations:()Ljava/util/Iterator;
        //    67: astore          6
        //    69: goto            100
        //    72: aload           6
        //    74: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    79: checkcast       Ljess/Activation;
        //    82: astore          7
        //    84: aload           7
        //    86: invokevirtual   jess/Activation.getRule:()Ljess/Defrule;
        //    89: aload           5
        //    91: if_acmpne       100
        //    94: aload_0        
        //    95: aload           7
        //    97: invokevirtual   jess/Rete.removeActivation:(Ljess/Activation;)V
        //   100: aload           6
        //   102: invokeinterface java/util/Iterator.hasNext:()Z
        //   107: ifne            72
        //   110: aload           5
        //   112: invokevirtual   jess/HasLHS.getNext:()Ljess/HasLHS;
        //   115: ifnull          131
        //   118: aload_0        
        //   119: aload           5
        //   121: invokevirtual   jess/HasLHS.getNext:()Ljess/HasLHS;
        //   124: invokevirtual   jess/HasLHS.getName:()Ljava/lang/String;
        //   127: invokevirtual   jess/Rete.unDefrule:(Ljava/lang/String;)Ljess/Value;
        //   130: pop            
        //   131: aload_0        
        //   132: ldc_w           -2147483647
        //   135: aload           5
        //   137: invokevirtual   jess/Rete.broadcastEvent:(ILjava/lang/Object;)V
        //   140: getstatic       jess/Funcall.TRUE:Ljess/Value;
        //   143: aload_2        
        //   144: monitorexit    
        //   145: areturn        
        //   146: aload_2        
        //   147: monitorexit    
        //   148: getstatic       jess/Funcall.FALSE:Ljess/Value;
        //   151: areturn        
        //    Exceptions:
        //  throws jess.JessException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  3      5      3      6      Any
        //  146    148    3      6      Any
        //  13     145    3      6      Any
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
    
    public void addDefmodule(final String s) throws JessException {
        this.m_agenda.addDefmodule(s);
    }
    
    public void addDefmodule(final String s, final String s2) throws JessException {
        this.m_agenda.addDefmodule(s, s2);
    }
    
    public String getCurrentModule() {
        return this.m_agenda.getCurrentModule();
    }
    
    public String setCurrentModule(final String currentModule) throws JessException {
        return this.m_agenda.setCurrentModule(currentModule);
    }
    
    public Iterator listModules() throws JessException {
        return this.m_agenda.listModules();
    }
    
    public String getFocus() {
        return this.m_agenda.getFocus();
    }
    
    public void setFocus(final String s) throws JessException {
        this.m_agenda.setFocus(s, this);
    }
    
    public Iterator listFocusStack() throws JessException {
        return this.m_agenda.listFocusStack();
    }
    
    public void clearFocusStack() {
        this.m_agenda.clearFocusStack();
    }
    
    public String popFocus(final String s) throws JessException {
        return this.m_agenda.popFocus(this, s);
    }
    
    public void verifyModule(final String s) throws JessException {
        this.m_agenda.verifyModule(s);
    }
    
    public String resolveName(final String s) {
        return this.m_agenda.resolveName(s);
    }
    
    Token processToken(final int p0, final Fact p1) throws JessException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     4: monitorexit    
        //     5: athrow         
        //     6: aload_0        
        //     7: getfield        jess/Rete.m_compiler:Ljess/ReteCompiler;
        //    10: dup            
        //    11: astore_3       
        //    12: monitorenter   
        //    13: aload_0        
        //    14: getfield        jess/Rete.m_factList:Ljess/FactList;
        //    17: aload_2        
        //    18: invokevirtual   jess/FactList.assignTime:(Ljess/Fact;)V
        //    21: invokestatic    jess/Rete.getFactory:()Ljess/factory/Factory;
        //    24: aload_2        
        //    25: iload_1        
        //    26: invokeinterface jess/factory/Factory.newToken:(Ljess/Fact;I)Ljess/Token;
        //    31: astore          6
        //    33: aload_0        
        //    34: getfield        jess/Rete.m_compiler:Ljess/ReteCompiler;
        //    37: invokevirtual   jess/ReteCompiler.getRoot:()Ljess/Node;
        //    40: aload           6
        //    42: aload_0        
        //    43: invokevirtual   jess/Rete.getGlobalContext:()Ljess/Context;
        //    46: invokevirtual   jess/Context.push:()Ljess/Context;
        //    49: invokevirtual   jess/Node.callNodeRight:(Ljess/Token;Ljess/Context;)V
        //    52: aload           6
        //    54: aload_3        
        //    55: monitorexit    
        //    56: areturn        
        //    Exceptions:
        //  throws jess.JessException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  3      5      3      6      Any
        //  13     56     3      6      Any
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
    
    void updateNodes(final Hashtable p0) throws JessException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     2: aload_0        
        //     3: getfield        jess/Rete.m_factList:Ljess/FactList;
        //     6: invokevirtual   jess/FactList.listFacts:()Ljava/util/Iterator;
        //     9: astore_3       
        //    10: goto            108
        //    13: aload_3        
        //    14: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    19: checkcast       Ljess/Fact;
        //    22: astore          4
        //    24: invokestatic    jess/Rete.getFactory:()Ljess/factory/Factory;
        //    27: aload           4
        //    29: iconst_2       
        //    30: invokeinterface jess/factory/Factory.newToken:(Ljess/Fact;I)Ljess/Token;
        //    35: astore          5
        //    37: aload_1        
        //    38: invokevirtual   java/util/Hashtable.elements:()Ljava/util/Enumeration;
        //    41: astore          6
        //    43: goto            98
        //    46: goto            53
        //    49: aload           7
        //    51: monitorexit    
        //    52: athrow         
        //    53: aload_0        
        //    54: getfield        jess/Rete.m_compiler:Ljess/ReteCompiler;
        //    57: dup            
        //    58: astore          7
        //    60: monitorenter   
        //    61: aload           6
        //    63: invokeinterface java/util/Enumeration.nextElement:()Ljava/lang/Object;
        //    68: checkcast       Ljess/Node;
        //    71: astore          9
        //    73: aload           9
        //    75: aload           5
        //    77: aload_0        
        //    78: invokevirtual   jess/Rete.getGlobalContext:()Ljess/Context;
        //    81: invokevirtual   jess/Context.push:()Ljess/Context;
        //    84: invokevirtual   jess/Node.callNodeRight:(Ljess/Token;Ljess/Context;)V
        //    87: goto            95
        //    90: astore          10
        //    92: aload           10
        //    94: astore_2       
        //    95: aload           7
        //    97: monitorexit    
        //    98: aload           6
        //   100: invokeinterface java/util/Enumeration.hasMoreElements:()Z
        //   105: ifne            46
        //   108: aload_3        
        //   109: invokeinterface java/util/Iterator.hasNext:()Z
        //   114: ifne            13
        //   117: aload_0        
        //   118: getfield        jess/Rete.m_factList:Ljess/FactList;
        //   121: aload_0        
        //   122: invokevirtual   jess/FactList.processPendingFacts:(Ljess/Rete;)V
        //   125: aload_2        
        //   126: ifnull          131
        //   129: aload_2        
        //   130: athrow         
        //   131: return         
        //    Exceptions:
        //  throws jess.JessException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                
        //  -----  -----  -----  -----  --------------------
        //  49     52     49     53     Any
        //  73     87     90     95     Ljess/JessException;
        //  61     98     49     53     Any
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
    
    void addActivation(final Activation activation) throws JessException {
        this.broadcastEvent(4, activation);
        this.m_agenda.addActivation(activation, this);
    }
    
    void removeActivation(final Activation activation) throws JessException {
        this.broadcastEvent(-2147483644, activation);
        activation.setInactive();
    }
    
    public Iterator listActivations() {
        return this.m_agenda.listActivations();
    }
    
    public Iterator listActivations(final String s) throws JessException {
        return this.m_agenda.listActivations(s);
    }
    
    public Object getActivationSemaphore() {
        return this.m_agenda.getActivationSemaphore();
    }
    
    public void waitForActivations() {
        this.m_agenda.waitForActivations();
    }
    
    public String setStrategy(final Strategy strategy) throws JessException {
        return this.m_agenda.setStrategy(strategy, this);
    }
    
    public Strategy getStrategy() {
        return this.m_agenda.getStrategy();
    }
    
    public final void setEvalSalience(final int evalSalience) throws JessException {
        this.m_agenda.setEvalSalience(evalSalience);
    }
    
    public final int getEvalSalience() {
        return this.m_agenda.getEvalSalience();
    }
    
    public int run() throws JessException {
        this.broadcastEvent(8192, this);
        return this.m_agenda.run(this);
    }
    
    protected void aboutToFire(final Activation activation) {
    }
    
    protected void justFired(final Activation activation) {
    }
    
    public int run(final int n) throws JessException {
        this.broadcastEvent(8192, this);
        return this.m_agenda.run(n, this);
    }
    
    public int runUntilHalt() throws JessException {
        this.broadcastEvent(8192, this);
        return this.m_agenda.runUntilHalt(this);
    }
    
    public void halt() throws JessException {
        this.broadcastEvent(16384, this);
        this.m_agenda.halt();
    }
    
    public String getThisRuleName() {
        final Activation thisActivation = this.getThisActivation();
        if (thisActivation != null) {
            return thisActivation.getRule().getName();
        }
        return null;
    }
    
    public Activation getThisActivation() {
        return this.m_agenda.getThisActivation();
    }
    
    public void addJessListener(final JessListener jessListener) {
        this.m_jes.addJessListener(jessListener);
    }
    
    public void removeJessListener(final JessListener jessListener) {
        this.m_jes.removeJessListener(jessListener);
    }
    
    public Iterator listJessListeners() {
        return this.m_jes.listJessListeners();
    }
    
    public int getEventMask() {
        return this.m_jes.getEventMask();
    }
    
    public void setEventMask(final int eventMask) {
        this.m_jes.setEventMask(eventMask);
    }
    
    final void broadcastEvent(final int n, final Object o) throws JessException {
        this.m_jes.broadcastEvent(this, n, o);
    }
    
    private final void readObject(final ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.m_routers = new Routers();
        this.m_tis = new TextReader(true);
        this.m_jesp = new Jesp(this.m_tis, this);
        this.m_jes = new JessEventSupport(this);
        this.m_definstanceList.setEngine(this);
        this.m_globalContext.setEngine(this);
    }
    
    public void bload(final InputStream inputStream) throws IOException, ClassNotFoundException {
        final ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        (this.m_globalContext = (Context)objectInputStream.readObject()).setEngine(this);
        this.m_resetGlobals = objectInputStream.readBoolean();
        this.m_deffacts = (List)objectInputStream.readObject();
        this.m_defglobals = (List)objectInputStream.readObject();
        this.m_functions = (Map)objectInputStream.readObject();
        this.m_factList = (FactList)objectInputStream.readObject();
        (this.m_definstanceList = (DefinstanceList)objectInputStream.readObject()).setEngine(this);
        this.m_rules = (Map)objectInputStream.readObject();
        this.m_compiler = (ReteCompiler)objectInputStream.readObject();
        this.m_storage = (Map)objectInputStream.readObject();
        this.m_agenda = (Agenda)objectInputStream.readObject();
        this.m_classImports = (Hashtable)objectInputStream.readObject();
        this.m_packageImports = (ArrayList)objectInputStream.readObject();
        this.m_watchInfo = (boolean[])objectInputStream.readObject();
    }
    
    public void bsave(final OutputStream outputStream) throws IOException {
        final ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(this.m_globalContext);
        objectOutputStream.writeBoolean(this.m_resetGlobals);
        objectOutputStream.writeObject(this.m_deffacts);
        objectOutputStream.writeObject(this.m_defglobals);
        objectOutputStream.writeObject(this.m_functions);
        objectOutputStream.writeObject(this.m_factList);
        objectOutputStream.writeObject(this.m_definstanceList);
        objectOutputStream.writeObject(this.m_rules);
        objectOutputStream.writeObject(this.m_compiler);
        objectOutputStream.writeObject(this.m_storage);
        objectOutputStream.writeObject(this.m_agenda);
        objectOutputStream.writeObject(this.m_classImports);
        objectOutputStream.writeObject(this.m_packageImports);
        objectOutputStream.writeObject(this.m_watchInfo);
        objectOutputStream.flush();
    }
    
    public Value definstance(final String s, final Object o, final boolean b) throws JessException {
        return this.definstance(s, o, b, this.getGlobalContext());
    }
    
    public Value definstance(final String s, final Object o, final boolean b, final Context context) throws JessException {
        this.broadcastEvent(32, o);
        return this.m_definstanceList.definstance(s, o, b, context);
    }
    
    public Fact undefinstance(final Object o) throws JessException {
        final Fact undefinstance = this.m_definstanceList.undefinstance(o);
        this.broadcastEvent(-2147483616, o);
        return undefinstance;
    }
    
    public Value updateObject(final Object o) throws JessException {
        return this.m_definstanceList.updateObject(o);
    }
    
    public Value defclass(final String s, final String s2, final String s3) throws JessException {
        this.broadcastEvent(128, s);
        return this.m_definstanceList.defclass(s, s2, s3);
    }
    
    FactList getFactList() {
        return this.m_factList;
    }
    
    public Applet getApplet() {
        if (this.m_appObject instanceof Applet) {
            return (Applet)this.m_appObject;
        }
        return null;
    }
    
    public Class getAppObjectClass() {
        if (this.m_appObject != null) {
            return this.m_appObject.getClass();
        }
        Class class$jess$Rete;
        if ((class$jess$Rete = Rete.class$jess$Rete) == null) {
            class$jess$Rete = (Rete.class$jess$Rete = class$("[Ljess.Rete;", false));
        }
        return class$jess$Rete;
    }
    
    public void setApplet(final Applet appObject) {
        this.m_appObject = appObject;
    }
    
    public void setAppObject(final Object appObject) {
        this.m_appObject = appObject;
    }
    
    public final Context getGlobalContext() {
        return this.m_globalContext;
    }
    
    public Value executeCommand(final String s) throws JessException {
        return this.executeCommand(s, this.m_globalContext);
    }
    
    public Value executeCommand(final String p0, final Context p1) throws JessException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: aload_3        
        //     4: monitorexit    
        //     5: athrow         
        //     6: aload_0        
        //     7: getfield        jess/Rete.m_tis:Ljess/awt/TextReader;
        //    10: dup            
        //    11: astore_3       
        //    12: monitorenter   
        //    13: aload_0        
        //    14: getfield        jess/Rete.m_tis:Ljess/awt/TextReader;
        //    17: invokevirtual   jess/awt/TextReader.clear:()V
        //    20: aload_0        
        //    21: getfield        jess/Rete.m_jesp:Ljess/Jesp;
        //    24: invokevirtual   jess/Jesp.clear:()V
        //    27: aload_0        
        //    28: getfield        jess/Rete.m_tis:Ljess/awt/TextReader;
        //    31: aload_1        
        //    32: invokevirtual   jess/awt/TextReader.appendText:(Ljava/lang/String;)V
        //    35: aload_0        
        //    36: getfield        jess/Rete.m_jesp:Ljess/Jesp;
        //    39: iconst_0       
        //    40: aload_2        
        //    41: invokevirtual   jess/Jesp.parse:(ZLjess/Context;)Ljess/Value;
        //    44: aload_3        
        //    45: monitorexit    
        //    46: areturn        
        //    Exceptions:
        //  throws jess.JessException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  3      5      3      6      Any
        //  13     46     3      6      Any
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
    
    public final void setResetGlobals(final boolean resetGlobals) {
        this.m_resetGlobals = resetGlobals;
    }
    
    public final boolean getResetGlobals() {
        return this.m_resetGlobals;
    }
    
    final ReteCompiler getCompiler() {
        return this.m_compiler;
    }
    
    public Value store(final String s, final Value value) {
        if (value == null) {
            return this.m_storage.remove(s);
        }
        return this.m_storage.put(s, value);
    }
    
    public Value store(final String s, final Object o) {
        if (o == null) {
            return this.m_storage.remove(s);
        }
        return this.m_storage.put(s, new Value(o));
    }
    
    public Value fetch(final String s) {
        return this.m_storage.get(s);
    }
    
    public void clearStorage() {
        this.m_storage.clear();
    }
    
    int getTime() {
        return this.m_factList.getTime();
    }
    
    public static Factory getFactory() {
        return Rete.m_factory;
    }
    
    public static void setFactory(final Factory factory) {
        Rete.m_factory = factory;
    }
    
    private final void loadScriptlib() {
        try {
            new Batch().batch("scriptlib.clp", this);
        }
        catch (JessException ex) {
            ex.printStackTrace();
        }
    }
    
    private final Class classForName(final String s) throws ClassNotFoundException {
        final ClassLoader classLoader = this.getAppObjectClass().getClassLoader();
        Class class$jess$Rete;
        if ((class$jess$Rete = Rete.class$jess$Rete) == null) {
            class$jess$Rete = (Rete.class$jess$Rete = class$("[Ljess.Rete;", false));
        }
        final ClassLoader classLoader2 = class$jess$Rete.getClassLoader();
        if (classLoader == null) {
            return Class.forName(s);
        }
        try {
            return Class.forName(s, true, classLoader);
        }
        catch (ClassNotFoundException ex) {
            if (classLoader != classLoader2) {
                return Class.forName(s);
            }
            throw ex;
        }
    }
    
    public Class findClass(String s) throws ClassNotFoundException {
        if (s.indexOf(".") == -1) {
            final String s2 = this.m_classImports.get(s);
            if (s2 != null) {
                s = s2;
            }
            else {
                final Iterator<String> iterator = (Iterator<String>)this.m_packageImports.iterator();
                while (iterator.hasNext()) {
                    final String string = iterator.next() + s;
                    try {
                        final Class classForName = this.classForName(string);
                        this.m_classImports.put(s, string);
                        return classForName;
                    }
                    catch (ClassNotFoundException ex) {}
                }
            }
        }
        return this.classForName(s);
    }
    
    public void importPackage(final String s) {
        this.m_packageImports.add(s);
    }
    
    public void importClass(final String s) {
        this.m_classImports.put(s.substring(s.lastIndexOf(".") + 1, s.length()), s);
    }
    
    public Iterator runQuery(final String s, final ValueVector valueVector) throws JessException {
        final Funcall funcall = new Funcall("run-query", this);
        funcall.add(new Value(s, 2));
        funcall.addAll(valueVector);
        final Context globalContext = this.getGlobalContext();
        return (Iterator)funcall.execute(globalContext).externalAddressValue(globalContext);
    }
    
    public void watch(final int n) throws JessException {
        this.m_watchInfo[n] = true;
        int n2 = 0;
        switch (n) {
            case 1: {
                n2 = 2;
                break;
            }
            case 0: {
                n2 = 16;
                break;
            }
            case 2: {
                n2 = 4;
                break;
            }
            case 3: {
                n2 = 1;
                break;
            }
            case 4: {
                n2 = 1048576;
                break;
            }
            default: {
                throw new JessException("watch", "Bad argument ", n);
            }
        }
        this.m_watchInfo[n] = true;
        this.setEventMask(this.getEventMask() | n2 | 0x800);
    }
    
    public void unwatch(final int n) throws JessException {
        int n2 = 0;
        switch (n) {
            case 1: {
                n2 = 2;
                break;
            }
            case 0: {
                n2 = 16;
                break;
            }
            case 2: {
                n2 = 4;
                break;
            }
            case 3: {
                n2 = 1;
                break;
            }
            case 4: {
                n2 = 1048576;
                break;
            }
            default: {
                throw new JessException("unwatch", "Bad argument ", n);
            }
        }
        this.m_watchInfo[n] = false;
        this.setEventMask(this.getEventMask() & ~n2);
    }
    
    public void watchAll() {
        for (int i = 0; i < this.m_watchInfo.length; ++i) {
            this.m_watchInfo[i] = true;
        }
        this.setEventMask(this.getEventMask() | 0x800 | 0x100017);
    }
    
    public void unwatchAll() {
        for (int i = 0; i < this.m_watchInfo.length; ++i) {
            this.m_watchInfo[i] = false;
        }
        this.setEventMask(this.getEventMask() & ~0x100017);
    }
    
    boolean watchingAny() {
        for (int i = 0; i < this.m_watchInfo.length; ++i) {
            if (this.m_watchInfo[i]) {
                return true;
            }
        }
        return false;
    }
    
    boolean watching(final int n) {
        return this.m_watchInfo[n];
    }
    
    public void eventHappened(final JessEvent jessEvent) {
        if (!this.watchingAny()) {
            return;
        }
        final int type = jessEvent.getType();
        boolean b = false;
        if ((type & Integer.MIN_VALUE) != 0x0) {
            b = true;
        }
        final boolean b2 = b;
        boolean b3 = false;
        if ((type & 0x40000000) != 0x0) {
            b3 = true;
        }
        final boolean b4 = b3;
        final PrintWriter outStream = this.getOutStream();
        switch (type & Integer.MAX_VALUE & 0xBFFFFFFF) {
            case 16: {
                if (this.watching(0)) {
                    final Fact fact = (Fact)jessEvent.getObject();
                    outStream.print(b2 ? " <== " : (b4 ? " <=> " : " ==> "));
                    outStream.print("f-");
                    outStream.print(fact.getFactId());
                    outStream.print(" ");
                    outStream.println(fact);
                    outStream.flush();
                }
                break;
            }
            case 1048576: {
                if (this.watching(4)) {
                    outStream.print(b2 ? " <== " : " ==> ");
                    outStream.print("Focus ");
                    outStream.println(jessEvent.getObject());
                    outStream.flush();
                }
                break;
            }
            case 2: {
                if (this.watching(1)) {
                    ((Activation)jessEvent.getObject()).debugPrint(this.getOutStream());
                }
                break;
            }
            case 4: {
                if (this.watching(2)) {
                    final Activation activation = (Activation)jessEvent.getObject();
                    outStream.print(b2 ? "<== " : "==> ");
                    outStream.print("Activation: ");
                    outStream.print(activation.getRule().getDisplayName());
                    outStream.print(" : ");
                    outStream.println(activation.getToken().factList());
                    outStream.flush();
                }
                break;
            }
            case 1: {
                if (this.watching(3) && !b2) {
                    outStream.println(((HasLHS)jessEvent.getObject()).getCompilationTrace());
                    outStream.flush();
                }
                break;
            }
        }
    }
    
    public String toString() {
        return "[Rete]";
    }
    
    public ArrayList getSupportingTokens(final Fact fact) {
        return this.m_factList.getSupportingTokens(fact);
    }
    
    public ArrayList getSupportedFacts(final Fact fact) {
        return this.m_factList.getSupportedFacts(fact);
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
        this.m_globalContext = new Context(this);
        this.m_routers = new Routers();
        this.m_tis = new TextReader(true);
        this.m_jesp = new Jesp(this.m_tis, this);
        this.m_jes = new JessEventSupport(this);
        this.m_resetGlobals = true;
        this.m_deffacts = Collections.synchronizedList(new ArrayList<Object>());
        this.m_defglobals = Collections.synchronizedList(new ArrayList<Object>());
        this.m_functions = Collections.synchronizedMap(new HashMap<Object, Object>(101));
        this.m_factList = new FactList();
        this.m_definstanceList = new DefinstanceList(this);
        this.m_rules = Collections.synchronizedMap(new TreeMap<Object, Object>());
        this.m_compiler = new ReteCompiler();
        this.m_storage = Collections.synchronizedMap(new HashMap<Object, Object>());
        this.m_agenda = new Agenda();
        this.m_classImports = new Hashtable();
        this.m_packageImports = new ArrayList();
        this.m_watchInfo = new boolean[5];
    }
    
    public Rete() {
        this(null);
    }
    
    public Rete(final Applet applet) {
        this((Object)applet);
    }
    
    public Rete(final Object appObject) {
        this.this();
        this.m_appObject = appObject;
        try {
            Deftemplate.addStandardTemplates(this);
        }
        catch (JessException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        this.setEventMask(0);
        this.loadScriptlib();
        this.m_packageImports.add("java.lang.");
    }
    
    static {
        Rete.m_factory = new FactoryImpl();
    }
}
