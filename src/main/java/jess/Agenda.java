package jess;

import java.util.Iterator;
import java.util.Stack;
import java.util.HashMap;
import java.io.Serializable;

class Agenda implements Serializable
{
    private Object m_activationSemaphore;
    private boolean m_halt;
    private int m_evalSalience;
    private HashMap m_modules;
    private String m_thisModule;
    private Strategy m_strategy;
    private Stack m_focusStack;
    private Activation m_thisActivation;
    
    void setEvalSalience(final int evalSalience) throws JessException {
        if (evalSalience < 0 || evalSalience > 2) {
            throw new JessException("Agenda.setEvalSalience", "Invalid value", evalSalience);
        }
        this.m_evalSalience = evalSalience;
    }
    
    int getEvalSalience() {
        return this.m_evalSalience;
    }
    
    void reset(final Rete rete) throws JessException {
        final Iterator<Defmodule> iterator = this.m_modules.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().reset();
        }
        this.m_focusStack.clear();
        this.m_focusStack.push("MAIN");
        rete.broadcastEvent(1048576, "MAIN");
    }
    
    void clear() throws JessException {
        this.m_modules.clear();
        this.m_strategy = new depth();
        this.addDefmodule("MAIN");
        this.m_focusStack.clear();
    }
    
    Object getActivationSemaphore() {
        return this.m_activationSemaphore;
    }
    
    HeapPriorityQueue getQueue() {
        return this.m_modules.get(this.m_thisModule).getQueue();
    }
    
    HeapPriorityQueue getQueue(final Object o) throws JessException {
        this.verifyModule(o);
        return this.m_modules.get(o).getQueue();
    }
    
    Activation getNextActivation(final Rete p0) throws JessException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     4: monitorexit    
        //     5: athrow         
        //     6: aload_0        
        //     7: getfield        jess/Agenda.m_activationSemaphore:Ljava/lang/Object;
        //    10: dup            
        //    11: astore_2       
        //    12: monitorenter   
        //    13: aload_0        
        //    14: getfield        jess/Agenda.m_focusStack:Ljava/util/Stack;
        //    17: invokevirtual   java/util/Stack.empty:()Z
        //    20: ifeq            35
        //    23: aload_0        
        //    24: ldc             "MAIN"
        //    26: invokevirtual   jess/Agenda.getQueue:(Ljava/lang/Object;)Ljess/HeapPriorityQueue;
        //    29: invokevirtual   jess/HeapPriorityQueue.pop:()Ljess/Activation;
        //    32: aload_2        
        //    33: monitorexit    
        //    34: areturn        
        //    35: goto            107
        //    38: aload_0        
        //    39: aload_0        
        //    40: getfield        jess/Agenda.m_focusStack:Ljava/util/Stack;
        //    43: invokevirtual   java/util/Stack.peek:()Ljava/lang/Object;
        //    46: invokevirtual   jess/Agenda.getQueue:(Ljava/lang/Object;)Ljess/HeapPriorityQueue;
        //    49: astore          5
        //    51: aload           5
        //    53: invokevirtual   jess/HeapPriorityQueue.pop:()Ljess/Activation;
        //    56: astore          6
        //    58: aload           6
        //    60: ifnull          68
        //    63: aload           6
        //    65: aload_2        
        //    66: monitorexit    
        //    67: areturn        
        //    68: aload_0        
        //    69: getfield        jess/Agenda.m_focusStack:Ljava/util/Stack;
        //    72: invokevirtual   java/util/Stack.pop:()Ljava/lang/Object;
        //    75: astore          7
        //    77: aload_1        
        //    78: ldc             -2146435072
        //    80: aload           7
        //    82: invokevirtual   jess/Rete.broadcastEvent:(ILjava/lang/Object;)V
        //    85: aload_0        
        //    86: invokevirtual   jess/Agenda.getFocus:()Ljava/lang/String;
        //    89: aload           7
        //    91: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    94: ifne            107
        //    97: aload_1        
        //    98: ldc             1048576
        //   100: aload_0        
        //   101: invokevirtual   jess/Agenda.getFocus:()Ljava/lang/String;
        //   104: invokevirtual   jess/Rete.broadcastEvent:(ILjava/lang/Object;)V
        //   107: aload_0        
        //   108: getfield        jess/Agenda.m_focusStack:Ljava/util/Stack;
        //   111: invokevirtual   java/util/Stack.empty:()Z
        //   114: ifeq            38
        //   117: aload_0        
        //   118: ldc             "MAIN"
        //   120: invokevirtual   jess/Agenda.getQueue:(Ljava/lang/Object;)Ljess/HeapPriorityQueue;
        //   123: invokevirtual   jess/HeapPriorityQueue.pop:()Ljess/Activation;
        //   126: aload_2        
        //   127: monitorexit    
        //   128: areturn        
        //    Exceptions:
        //  throws jess.JessException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  3      5      3      6      Any
        //  68     128    3      6      Any
        //  35     67     3      6      Any
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
    
    Iterator listActivations() {
        return this.getQueue().iterator();
    }
    
    Iterator listActivations(final String s) throws JessException {
        return this.getQueue(s).iterator();
    }
    
    Iterator listModules() {
        return this.m_modules.keySet().iterator();
    }
    
    void addActivation(final Activation p0, final Rete p1) throws JessException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     4: monitorexit    
        //     5: athrow         
        //     6: aload_0        
        //     7: getfield        jess/Agenda.m_activationSemaphore:Ljava/lang/Object;
        //    10: dup            
        //    11: astore_3       
        //    12: monitorenter   
        //    13: aload_0        
        //    14: getfield        jess/Agenda.m_evalSalience:I
        //    17: ifeq            25
        //    20: aload_1        
        //    21: aload_2        
        //    22: invokevirtual   jess/Activation.evalSalience:(Ljess/Rete;)V
        //    25: aload_0        
        //    26: aload_1        
        //    27: invokevirtual   jess/Activation.getModule:()Ljava/lang/String;
        //    30: invokevirtual   jess/Agenda.getQueue:(Ljava/lang/Object;)Ljess/HeapPriorityQueue;
        //    33: aload_1        
        //    34: invokevirtual   jess/HeapPriorityQueue.push:(Ljess/Activation;)V
        //    37: aload_1        
        //    38: invokevirtual   jess/Activation.getAutoFocus:()Z
        //    41: ifeq            53
        //    44: aload_0        
        //    45: aload_1        
        //    46: invokevirtual   jess/Activation.getModule:()Ljava/lang/String;
        //    49: aload_2        
        //    50: invokevirtual   jess/Agenda.setFocus:(Ljava/lang/String;Ljess/Rete;)V
        //    53: aload_0        
        //    54: getfield        jess/Agenda.m_activationSemaphore:Ljava/lang/Object;
        //    57: invokevirtual   java/lang/Object.notifyAll:()V
        //    60: aload_3        
        //    61: monitorexit    
        //    62: return         
        //    Exceptions:
        //  throws jess.JessException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  3      5      3      6      Any
        //  13     62     3      6      Any
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
    
    void waitForActivations() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     4: monitorexit    
        //     5: athrow         
        //     6: aload_0        
        //     7: getfield        jess/Agenda.m_activationSemaphore:Ljava/lang/Object;
        //    10: dup            
        //    11: astore_1       
        //    12: monitorenter   
        //    13: aload_0        
        //    14: invokevirtual   jess/Agenda.getQueue:()Ljess/HeapPriorityQueue;
        //    17: invokevirtual   jess/HeapPriorityQueue.isEmpty:()Z
        //    20: ifeq            30
        //    23: aload_0        
        //    24: getfield        jess/Agenda.m_activationSemaphore:Ljava/lang/Object;
        //    27: invokevirtual   java/lang/Object.wait:()V
        //    30: aload_1        
        //    31: monitorexit    
        //    32: goto            36
        //    35: astore_1       
        //    36: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                            
        //  -----  -----  -----  -----  --------------------------------
        //  3      5      3      6      Any
        //  13     32     3      6      Any
        //  0      32     35     36     Ljava/lang/InterruptedException;
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
    
    Strategy getStrategy() {
        return this.m_strategy;
    }
    
    String setStrategy(final Strategy p0, final Rete p1) throws JessException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     2: aload_0        
        //     3: getfield        jess/Agenda.m_modules:Ljava/util/HashMap;
        //     6: invokevirtual   java/util/HashMap.values:()Ljava/util/Collection;
        //     9: invokeinterface java/util/Collection.iterator:()Ljava/util/Iterator;
        //    14: astore          4
        //    16: goto            113
        //    19: aload           4
        //    21: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    26: checkcast       Ljess/Defmodule;
        //    29: invokevirtual   jess/Defmodule.getQueue:()Ljess/HeapPriorityQueue;
        //    32: astore          5
        //    34: goto            41
        //    37: aload           6
        //    39: monitorexit    
        //    40: athrow         
        //    41: aload           5
        //    43: dup            
        //    44: astore          6
        //    46: monitorenter   
        //    47: aload           5
        //    49: invokevirtual   jess/HeapPriorityQueue.iterator:()Ljava/util/Iterator;
        //    52: astore          9
        //    54: aload           5
        //    56: invokevirtual   jess/HeapPriorityQueue.clear:()V
        //    59: aload           5
        //    61: aload_1        
        //    62: invokevirtual   jess/HeapPriorityQueue.setStrategy:(Ljess/Strategy;)Ljess/Strategy;
        //    65: invokeinterface jess/Strategy.getName:()Ljava/lang/String;
        //    70: astore_3       
        //    71: goto            100
        //    74: aload           9
        //    76: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    81: checkcast       Ljess/Activation;
        //    84: astore          10
        //    86: aload           10
        //    88: invokevirtual   jess/Activation.isInactive:()Z
        //    91: ifne            100
        //    94: aload_2        
        //    95: aload           10
        //    97: invokevirtual   jess/Rete.addActivation:(Ljess/Activation;)V
        //   100: aload           9
        //   102: invokeinterface java/util/Iterator.hasNext:()Z
        //   107: ifne            74
        //   110: aload           6
        //   112: monitorexit    
        //   113: aload           4
        //   115: invokeinterface java/util/Iterator.hasNext:()Z
        //   120: ifne            19
        //   123: aload_0        
        //   124: aload_1        
        //   125: putfield        jess/Agenda.m_strategy:Ljess/Strategy;
        //   128: aload_3        
        //   129: areturn        
        //    Exceptions:
        //  throws jess.JessException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  37     40     37     41     Any
        //  47     113    37     41     Any
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
    
    void halt() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     2: putfield        jess/Agenda.m_halt:Z
        //     5: goto            11
        //     8: aload_1        
        //     9: monitorexit    
        //    10: athrow         
        //    11: aload_0        
        //    12: getfield        jess/Agenda.m_activationSemaphore:Ljava/lang/Object;
        //    15: dup            
        //    16: astore_1       
        //    17: monitorenter   
        //    18: aload_0        
        //    19: getfield        jess/Agenda.m_activationSemaphore:Ljava/lang/Object;
        //    22: invokevirtual   java/lang/Object.notifyAll:()V
        //    25: aload_1        
        //    26: monitorexit    
        //    27: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  8      10     8      11     Any
        //  18     27     8      11     Any
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
    
    int runUntilHalt(final Rete rete) throws JessException {
        int n = 0;
        do {
            n += this.run(rete);
            if (this.m_halt) {
                break;
            }
            this.waitForActivations();
        } while (!this.m_halt);
        return n;
    }
    
    synchronized int run(final Rete rete) throws JessException {
        int n = 0;
        int run;
        do {
            run = this.run(Integer.MAX_VALUE, rete);
            n += run;
        } while (run > 0 && !this.m_halt);
        return n;
    }
    
    synchronized int run(final int n, final Rete rete) throws JessException {
        int n2 = 0;
        this.m_halt = false;
        Activation nextActivation;
        while (!this.m_halt && n2 < n && (nextActivation = this.getNextActivation(rete)) != null) {
            if (!nextActivation.isInactive()) {
                nextActivation.setSequenceNumber(++n2);
                rete.broadcastEvent(2, nextActivation);
                try {
                    rete.aboutToFire(nextActivation);
                    (this.m_thisActivation = nextActivation).fire(rete);
                }
                finally {
                    this.m_thisActivation = null;
                    rete.justFired(nextActivation);
                }
                this.m_thisActivation = null;
                rete.justFired(nextActivation);
            }
            if (this.m_evalSalience == 2) {
                this.setStrategy(this.getQueue().getStrategy(), rete);
            }
        }
        return n2;
    }
    
    String getCurrentModule() {
        return this.m_thisModule;
    }
    
    Defmodule getModule(final String s) throws JessException {
        this.verifyModule(s);
        return this.m_modules.get(s);
    }
    
    Iterator listFocusStack() {
        return this.m_focusStack.iterator();
    }
    
    void clearFocusStack() {
        this.m_focusStack.clear();
    }
    
    String getFocus() {
        if (this.m_focusStack.empty()) {
            return "MAIN";
        }
        return this.m_focusStack.peek();
    }
    
    String popFocus(final Rete rete, final String s) throws JessException {
        if (this.m_focusStack.empty()) {
            return "MAIN";
        }
        if (s != null && !s.equals(this.getFocus())) {
            return s;
        }
        final String s2 = this.m_focusStack.pop();
        rete.broadcastEvent(-2146435072, s2);
        rete.broadcastEvent(1048576, this.getFocus());
        return s2;
    }
    
    void setFocus(final String s, final Rete rete) throws JessException {
        if (this.getFocus().equals(s)) {
            return;
        }
        this.verifyModule(s);
        rete.broadcastEvent(-2146435072, this.getFocus());
        rete.broadcastEvent(1048576, s);
        this.m_focusStack.push(s);
    }
    
    String setCurrentModule(final String thisModule) throws JessException {
        final String thisModule2 = this.m_thisModule;
        this.verifyModule(thisModule);
        this.m_thisModule = thisModule;
        return thisModule2;
    }
    
    void addDefmodule(final String s) throws JessException {
        this.addDefmodule(s, null);
    }
    
    void addDefmodule(final String thisModule, final String s) throws JessException {
        if (this.m_modules.get(thisModule) != null) {
            throw new JessException("Agenda.addDefmodule", "Attempt to redefine defmodule", thisModule);
        }
        this.m_thisModule = thisModule;
        this.m_modules.put(thisModule, new Defmodule(thisModule, s, this.m_strategy));
    }
    
    void verifyModule(final Object o) throws JessException {
        if (this.m_modules.get(o) == null) {
            throw new JessException("Agenda.verifyModule", "Undefined module", o.toString());
        }
    }
    
    String resolveName(String scopeName) {
        if (scopeName.indexOf("::") == -1) {
            scopeName = RU.scopeName(this.getCurrentModule(), scopeName);
        }
        return scopeName;
    }
    
    Activation getThisActivation() {
        return this.m_thisActivation;
    }
    
    private final /* synthetic */ void this() {
        this.m_activationSemaphore = new String("ACTIVATION LOCK");
        this.m_halt = false;
        this.m_evalSalience = 0;
        this.m_modules = new HashMap();
        this.m_strategy = new depth();
        this.m_focusStack = new Stack();
    }
    
    Agenda() {
        this.this();
        try {
            this.addDefmodule("MAIN");
        }
        catch (JessException ex) {
            throw new RuntimeException("Can't define module MAIN");
        }
    }
}
