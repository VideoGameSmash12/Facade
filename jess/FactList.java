package jess;

import java.util.Collections;
import java.util.HashMap;
import java.io.IOException;
import java.util.Iterator;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Map;
import java.io.Serializable;

class FactList implements Serializable
{
    private Map m_table;
    private ArrayList m_factsToAssert;
    private ArrayList m_factsToRetract;
    private Map m_logicalSupport;
    private int m_time;
    private Object m_idLock;
    private int m_nextFactId;
    
    void clear() {
        this.m_table.clear();
        this.m_time = 0;
        this.m_factsToAssert.clear();
        this.m_factsToRetract.clear();
        if (this.m_logicalSupport != null) {
            this.m_logicalSupport.clear();
        }
        this.m_nextFactId = 0;
    }
    
    int getTime() {
        return this.m_time;
    }
    
    void assignTime(final Fact fact) {
        fact.updateTime(++this.m_time);
    }
    
    int doPreAssertionProcessing(final Fact fact) {
        return 0 - (this.m_table.containsKey(fact) ? 1 : 0);
    }
    
    Fact findFactByFact(final Fact fact) {
        return this.m_table.get(fact);
    }
    
    Fact findFactByID(final int p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     4: monitorexit    
        //     5: athrow         
        //     6: aload_0        
        //     7: getfield        jess/FactList.m_table:Ljava/util/Map;
        //    10: dup            
        //    11: astore_2       
        //    12: monitorenter   
        //    13: aload_0        
        //    14: getfield        jess/FactList.m_table:Ljava/util/Map;
        //    17: invokeinterface java/util/Map.keySet:()Ljava/util/Set;
        //    22: invokeinterface java/util/Set.iterator:()Ljava/util/Iterator;
        //    27: astore          5
        //    29: goto            58
        //    32: aload           5
        //    34: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    39: checkcast       Ljess/Fact;
        //    42: astore          6
        //    44: aload           6
        //    46: invokevirtual   jess/Fact.getFactId:()I
        //    49: iload_1        
        //    50: if_icmpne       58
        //    53: aload           6
        //    55: aload_2        
        //    56: monitorexit    
        //    57: areturn        
        //    58: aload           5
        //    60: invokeinterface java/util/Iterator.hasNext:()Z
        //    65: ifne            32
        //    68: aconst_null    
        //    69: aload_2        
        //    70: monitorexit    
        //    71: areturn        
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  3      5      3      6      Any
        //  58     71     3      6      Any
        //  13     57     3      6      Any
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
    
    void ppFacts(final String s, final Writer writer) throws IOException {
        final Iterator listFacts = this.listFacts();
        while (listFacts.hasNext()) {
            final Fact fact = listFacts.next();
            if (s == null || fact.getName().equals(s)) {
                writer.write(fact.toString());
                writer.write("\n");
            }
        }
    }
    
    void ppFacts(final Writer writer) throws IOException {
        this.ppFacts(null, writer);
    }
    
    Iterator listFacts() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     4: monitorexit    
        //     5: athrow         
        //     6: aload_0        
        //     7: getfield        jess/FactList.m_table:Ljava/util/Map;
        //    10: dup            
        //    11: astore_1       
        //    12: monitorenter   
        //    13: new             Ljess/SortedIterator;
        //    16: dup            
        //    17: aload_0        
        //    18: getfield        jess/FactList.m_table:Ljava/util/Map;
        //    21: invokespecial   jess/SortedIterator.<init>:(Ljava/util/Map;)V
        //    24: aload_1        
        //    25: monitorexit    
        //    26: areturn        
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  3      5      3      6      Any
        //  13     26     3      6      Any
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
    
    private final int nextFactId() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: aload_1        
        //     4: monitorexit    
        //     5: athrow         
        //     6: aload_0        
        //     7: getfield        jess/FactList.m_idLock:Ljava/lang/Object;
        //    10: dup            
        //    11: astore_1       
        //    12: monitorenter   
        //    13: aload_0        
        //    14: dup            
        //    15: getfield        jess/FactList.m_nextFactId:I
        //    18: dup_x1         
        //    19: iconst_1       
        //    20: iadd           
        //    21: putfield        jess/FactList.m_nextFactId:I
        //    24: aload_1        
        //    25: monitorexit    
        //    26: ireturn        
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  3      5      3      6      Any
        //  13     26     3      6      Any
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
    
    void setPendingFact(Fact fact, final boolean b) {
        if (b) {
            this.m_factsToAssert.add(fact);
        }
        else {
            fact = this.m_table.get(fact);
            if (fact != null) {
                this.m_factsToRetract.add(fact);
            }
        }
    }
    
    void processPendingFacts(final Rete p0) throws JessException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     4: monitorexit    
        //     5: athrow         
        //     6: aload_0        
        //     7: getfield        jess/FactList.m_factsToAssert:Ljava/util/ArrayList;
        //    10: dup            
        //    11: astore_2       
        //    12: monitorenter   
        //    13: goto            51
        //    16: aload_0        
        //    17: getfield        jess/FactList.m_factsToAssert:Ljava/util/ArrayList;
        //    20: iconst_0       
        //    21: invokevirtual   java/util/ArrayList.get:(I)Ljava/lang/Object;
        //    24: checkcast       Ljess/Fact;
        //    27: astore          4
        //    29: aload_0        
        //    30: getfield        jess/FactList.m_factsToAssert:Ljava/util/ArrayList;
        //    33: iconst_0       
        //    34: invokevirtual   java/util/ArrayList.remove:(I)Ljava/lang/Object;
        //    37: pop            
        //    38: aload_0        
        //    39: aload           4
        //    41: iconst_1       
        //    42: aload_1        
        //    43: aload_1        
        //    44: invokevirtual   jess/Rete.getGlobalContext:()Ljess/Context;
        //    47: invokespecial   jess/FactList._assert:(Ljess/Fact;ZLjess/Rete;Ljess/Context;)Ljess/Fact;
        //    50: pop            
        //    51: aload_0        
        //    52: getfield        jess/FactList.m_factsToAssert:Ljava/util/ArrayList;
        //    55: invokevirtual   java/util/ArrayList.size:()I
        //    58: ifgt            16
        //    61: aload_2        
        //    62: monitorexit    
        //    63: goto            69
        //    66: aload_2        
        //    67: monitorexit    
        //    68: athrow         
        //    69: aload_0        
        //    70: getfield        jess/FactList.m_factsToRetract:Ljava/util/ArrayList;
        //    73: dup            
        //    74: astore_2       
        //    75: monitorenter   
        //    76: goto            108
        //    79: aload_0        
        //    80: getfield        jess/FactList.m_factsToRetract:Ljava/util/ArrayList;
        //    83: iconst_0       
        //    84: invokevirtual   java/util/ArrayList.get:(I)Ljava/lang/Object;
        //    87: checkcast       Ljess/Fact;
        //    90: astore          4
        //    92: aload_0        
        //    93: getfield        jess/FactList.m_factsToRetract:Ljava/util/ArrayList;
        //    96: iconst_0       
        //    97: invokevirtual   java/util/ArrayList.remove:(I)Ljava/lang/Object;
        //   100: pop            
        //   101: aload_1        
        //   102: aload           4
        //   104: invokevirtual   jess/Rete.retract:(Ljess/Fact;)Ljess/Fact;
        //   107: pop            
        //   108: aload_0        
        //   109: getfield        jess/FactList.m_factsToRetract:Ljava/util/ArrayList;
        //   112: invokevirtual   java/util/ArrayList.size:()I
        //   115: ifgt            79
        //   118: aload_2        
        //   119: monitorexit    
        //   120: return         
        //    Exceptions:
        //  throws jess.JessException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  3      5      3      6      Any
        //  13     63     3      6      Any
        //  66     68     66     69     Any
        //  76     120    66     69     Any
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
    
    Fact assertFact(final Fact fact, final Rete rete, final Context context) throws JessException {
        final Fact assert1 = this._assert(fact, true, rete, context);
        if (assert1 != null) {
            this.processPendingFacts(rete);
        }
        return assert1;
    }
    
    Fact assertKeepID(final Fact fact, final Rete rete, final Context context) throws JessException {
        final Fact assert1 = this._assert(fact, false, rete, context);
        if (assert1 != null) {
            this.processPendingFacts(rete);
        }
        return assert1;
    }
    
    private final Fact _assert(final Fact p0, final boolean p1, final Rete p2, final Context p3) throws JessException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: aload           5
        //     5: monitorexit    
        //     6: athrow         
        //     7: aload_0        
        //     8: getfield        jess/FactList.m_table:Ljava/util/Map;
        //    11: dup            
        //    12: astore          5
        //    14: monitorenter   
        //    15: iconst_0       
        //    16: aload_3        
        //    17: aload_1        
        //    18: invokevirtual   jess/Rete.doPreAssertionProcessing:(Ljess/Fact;)I
        //    21: ifeq            26
        //    24: pop            
        //    25: iconst_1       
        //    26: istore          8
        //    28: aload           4
        //    30: invokevirtual   jess/Context.getLogicalSupportNode:()Ljess/LogicalNode;
        //    33: ifnull          71
        //    36: aload           4
        //    38: invokevirtual   jess/Context.getToken:()Ljess/Token;
        //    41: astore          9
        //    43: aload           4
        //    45: invokevirtual   jess/Context.getLogicalSupportNode:()Ljess/LogicalNode;
        //    48: aload_1        
        //    49: aload           4
        //    51: invokevirtual   jess/Context.getToken:()Ljess/Token;
        //    54: invokeinterface jess/LogicalNode.dependsOn:(Ljess/Fact;Ljess/Token;)V
        //    59: aload_0        
        //    60: aload           9
        //    62: aload_1        
        //    63: iload           8
        //    65: invokevirtual   jess/FactList.addLogicalSupportFor:(Ljess/Token;Ljess/Fact;Z)V
        //    68: goto            83
        //    71: aload_0        
        //    72: getfield        jess/FactList.m_logicalSupport:Ljava/util/Map;
        //    75: ifnull          83
        //    78: aload_0        
        //    79: aload_1        
        //    80: invokespecial   jess/FactList.addUnconditionalSupportFor:(Ljess/Fact;)V
        //    83: iload           8
        //    85: ifeq            93
        //    88: aconst_null    
        //    89: aload           5
        //    91: monitorexit    
        //    92: areturn        
        //    93: iload_2        
        //    94: ifeq            105
        //    97: aload_1        
        //    98: aload_0        
        //    99: invokespecial   jess/FactList.nextFactId:()I
        //   102: invokevirtual   jess/Fact.setFactId:(I)V
        //   105: aload_3        
        //   106: bipush          16
        //   108: aload_1        
        //   109: invokevirtual   jess/Rete.broadcastEvent:(ILjava/lang/Object;)V
        //   112: aload_0        
        //   113: getfield        jess/FactList.m_table:Ljava/util/Map;
        //   116: aload_1        
        //   117: aload_1        
        //   118: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   123: pop            
        //   124: aload_3        
        //   125: iconst_0       
        //   126: aload_1        
        //   127: invokevirtual   jess/Rete.processToken:(ILjess/Fact;)Ljess/Token;
        //   130: pop            
        //   131: aload_1        
        //   132: aload           5
        //   134: monitorexit    
        //   135: areturn        
        //    Exceptions:
        //  throws jess.JessException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  3      6      3      7      Any
        //  93     135    3      7      Any
        //  15     92     3      7      Any
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
    
    Fact retract(final Fact p0, final Rete p1) throws JessException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     4: monitorexit    
        //     5: athrow         
        //     6: aload_0        
        //     7: getfield        jess/FactList.m_table:Ljava/util/Map;
        //    10: dup            
        //    11: astore_3       
        //    12: monitorenter   
        //    13: aload_0        
        //    14: getfield        jess/FactList.m_table:Ljava/util/Map;
        //    17: aload_1        
        //    18: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    23: checkcast       Ljess/Fact;
        //    26: dup            
        //    27: astore          6
        //    29: ifnull          45
        //    32: aload_0        
        //    33: aload           6
        //    35: aload_2        
        //    36: invokespecial   jess/FactList._retract:(Ljess/Fact;Ljess/Rete;)Ljess/Fact;
        //    39: pop            
        //    40: aload_0        
        //    41: aload_2        
        //    42: invokevirtual   jess/FactList.processPendingFacts:(Ljess/Rete;)V
        //    45: aload           6
        //    47: aload_3        
        //    48: monitorexit    
        //    49: areturn        
        //    Exceptions:
        //  throws jess.JessException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  3      5      3      6      Any
        //  13     49     3      6      Any
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
    
    private final Fact _retract(final Fact p0, final Rete p1) throws JessException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: aload_3        
        //     4: monitorexit    
        //     5: athrow         
        //     6: aload_0        
        //     7: getfield        jess/FactList.m_table:Ljava/util/Map;
        //    10: dup            
        //    11: astore_3       
        //    12: monitorenter   
        //    13: aload_2        
        //    14: ldc             -2147483632
        //    16: aload_1        
        //    17: invokevirtual   jess/Rete.broadcastEvent:(ILjava/lang/Object;)V
        //    20: aload_0        
        //    21: getfield        jess/FactList.m_table:Ljava/util/Map;
        //    24: aload_1        
        //    25: invokeinterface java/util/Map.remove:(Ljava/lang/Object;)Ljava/lang/Object;
        //    30: pop            
        //    31: aload_0        
        //    32: aload_1        
        //    33: invokevirtual   jess/FactList.removeAllLogicalSupportFor:(Ljess/Fact;)V
        //    36: aload_2        
        //    37: iconst_1       
        //    38: aload_1        
        //    39: invokevirtual   jess/Rete.processToken:(ILjess/Fact;)Ljess/Token;
        //    42: pop            
        //    43: aload_1        
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
    
    Fact _duplicate(final ValueVector p0, final Context p1, final Rete p2) throws JessException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     2: invokevirtual   jess/ValueVector.get:(I)Ljess/Value;
        //     5: aload_2        
        //     6: invokevirtual   jess/Value.resolveValue:(Ljess/Context;)Ljess/Value;
        //     9: astore          4
        //    11: aload           4
        //    13: invokevirtual   jess/Value.type:()I
        //    16: iconst_4       
        //    17: if_icmpne       39
        //    20: aload           4
        //    22: aload_2        
        //    23: invokevirtual   jess/Value.intValue:(Ljess/Context;)I
        //    26: istore          6
        //    28: aload_3        
        //    29: iload           6
        //    31: invokevirtual   jess/Rete.findFactByID:(I)Ljess/Fact;
        //    34: astore          5
        //    36: goto            57
        //    39: aload           4
        //    41: aload_2        
        //    42: invokevirtual   jess/Value.externalAddressValue:(Ljess/Context;)Ljava/lang/Object;
        //    45: checkcast       Ljess/Fact;
        //    48: astore          5
        //    50: aload           5
        //    52: invokevirtual   jess/Fact.getFactId:()I
        //    55: istore          6
        //    57: aload           5
        //    59: ifnull          71
        //    62: aload           5
        //    64: invokevirtual   jess/Fact.getFactId:()I
        //    67: iconst_m1      
        //    68: if_icmpne       85
        //    71: new             Ljess/JessException;
        //    74: dup            
        //    75: ldc             "duplicate"
        //    77: ldc             "no such fact"
        //    79: iload           6
        //    81: invokespecial   jess/JessException.<init>:(Ljava/lang/String;Ljava/lang/String;I)V
        //    84: athrow         
        //    85: aload           5
        //    87: invokevirtual   jess/Fact.isShadow:()Z
        //    90: ifeq            110
        //    93: new             Ljess/JessException;
        //    96: dup            
        //    97: ldc             "duplicate"
        //    99: ldc             "Can't duplicate shadow fact"
        //   101: aload           5
        //   103: invokevirtual   jess/Fact.toString:()Ljava/lang/String;
        //   106: invokespecial   jess/JessException.<init>:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //   109: athrow         
        //   110: aload           5
        //   112: invokevirtual   jess/Fact.getDeftemplate:()Ljess/Deftemplate;
        //   115: astore          7
        //   117: goto            124
        //   120: aload           8
        //   122: monitorexit    
        //   123: athrow         
        //   124: aload_3        
        //   125: invokevirtual   jess/Rete.getCompiler:()Ljess/ReteCompiler;
        //   128: dup            
        //   129: astore          8
        //   131: monitorenter   
        //   132: aload           5
        //   134: invokevirtual   jess/Fact.clone:()Ljava/lang/Object;
        //   137: checkcast       Ljess/Fact;
        //   140: astore          5
        //   142: iconst_2       
        //   143: istore          11
        //   145: goto            251
        //   148: aload_1        
        //   149: iload           11
        //   151: invokevirtual   jess/ValueVector.get:(I)Ljess/Value;
        //   154: aload_2        
        //   155: invokevirtual   jess/Value.listValue:(Ljess/Context;)Ljess/ValueVector;
        //   158: astore          12
        //   160: aload_0        
        //   161: aload           12
        //   163: aload_2        
        //   164: invokespecial   jess/FactList.getSlotName:(Ljess/ValueVector;Ljess/Context;)Ljava/lang/String;
        //   167: astore          13
        //   169: aload           7
        //   171: aload           13
        //   173: invokevirtual   jess/Deftemplate.getSlotIndex:(Ljava/lang/String;)I
        //   176: istore          14
        //   178: iload           14
        //   180: iconst_m1      
        //   181: if_icmpne       223
        //   184: new             Ljess/JessException;
        //   187: dup            
        //   188: ldc             "duplicate"
        //   190: new             Ljava/lang/StringBuffer;
        //   193: dup            
        //   194: ldc_w           "No such slot "
        //   197: invokespecial   java/lang/StringBuffer.<init>:(Ljava/lang/String;)V
        //   200: aload           13
        //   202: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   205: ldc_w           " in template"
        //   208: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   211: invokevirtual   java/lang/StringBuffer.toString:()Ljava/lang/String;
        //   214: aload           7
        //   216: invokevirtual   jess/Deftemplate.getName:()Ljava/lang/String;
        //   219: invokespecial   jess/JessException.<init>:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //   222: athrow         
        //   223: aload           7
        //   225: iload           14
        //   227: invokevirtual   jess/Deftemplate.getSlotType:(I)I
        //   230: istore          15
        //   232: aload           5
        //   234: aload           13
        //   236: aload_0        
        //   237: aload           12
        //   239: aload_2        
        //   240: iload           15
        //   242: invokespecial   jess/FactList.getSlotValue:(Ljess/ValueVector;Ljess/Context;I)Ljess/Value;
        //   245: invokevirtual   jess/Fact.setSlotValue:(Ljava/lang/String;Ljess/Value;)V
        //   248: iinc            11, 1
        //   251: iload           11
        //   253: aload_1        
        //   254: invokevirtual   jess/ValueVector.size:()I
        //   257: if_icmplt       148
        //   260: aload           8
        //   262: monitorexit    
        //   263: aload_0        
        //   264: aload           5
        //   266: aload_3        
        //   267: aload_2        
        //   268: invokevirtual   jess/FactList.assertFact:(Ljess/Fact;Ljess/Rete;Ljess/Context;)Ljess/Fact;
        //   271: areturn        
        //    Exceptions:
        //  throws jess.JessException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  120    123    120    124    Any
        //  132    263    120    124    Any
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
    
    Fact modify(final Fact p0, final String p1, final Value p2, final Rete p3, final Context p4) throws JessException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     4: ifeq            15
        //     7: aload_1        
        //     8: invokevirtual   jess/Fact.getShadowMode:()I
        //    11: iconst_2       
        //    12: if_icmpne       58
        //    15: goto            22
        //    18: aload           6
        //    20: monitorexit    
        //    21: athrow         
        //    22: aload           4
        //    24: invokevirtual   jess/Rete.getActivationSemaphore:()Ljava/lang/Object;
        //    27: dup            
        //    28: astore          6
        //    30: monitorenter   
        //    31: aload_0        
        //    32: aload_1        
        //    33: aload           4
        //    35: invokevirtual   jess/FactList.prepareToModify:(Ljess/Fact;Ljess/Rete;)Ljess/Fact;
        //    38: pop            
        //    39: aload_1        
        //    40: aload_2        
        //    41: aload_3        
        //    42: invokevirtual   jess/Fact.setSlotValue:(Ljava/lang/String;Ljess/Value;)V
        //    45: aload_0        
        //    46: aload_1        
        //    47: aload           4
        //    49: aload           5
        //    51: invokevirtual   jess/FactList.finishModify:(Ljess/Fact;Ljess/Rete;Ljess/Context;)Ljess/Fact;
        //    54: pop            
        //    55: aload           6
        //    57: monitorexit    
        //    58: aload_1        
        //    59: invokevirtual   jess/Fact.getShadowMode:()I
        //    62: ifeq            126
        //    65: aload_1        
        //    66: ldc_w           "OBJECT"
        //    69: invokevirtual   jess/Fact.getSlotValue:(Ljava/lang/String;)Ljess/Value;
        //    72: astore          6
        //    74: new             Ljess/Funcall;
        //    77: dup            
        //    78: ldc_w           "set"
        //    81: aload           4
        //    83: invokespecial   jess/Funcall.<init>:(Ljava/lang/String;Ljess/Rete;)V
        //    86: aload           6
        //    88: invokevirtual   jess/Funcall.arg:(Ljess/Value;)Ljess/Funcall;
        //    91: astore          7
        //    93: aload           7
        //    95: new             Ljess/Value;
        //    98: dup            
        //    99: aload_2        
        //   100: iconst_1       
        //   101: invokespecial   jess/Value.<init>:(Ljava/lang/String;I)V
        //   104: invokevirtual   jess/Funcall.arg:(Ljess/Value;)Ljess/Funcall;
        //   107: pop            
        //   108: aload           7
        //   110: aload_3        
        //   111: invokevirtual   jess/Funcall.arg:(Ljess/Value;)Ljess/Funcall;
        //   114: pop            
        //   115: aload           7
        //   117: aload           4
        //   119: invokevirtual   jess/Rete.getGlobalContext:()Ljess/Context;
        //   122: invokevirtual   jess/Funcall.execute:(Ljess/Context;)Ljess/Value;
        //   125: pop            
        //   126: aload_1        
        //   127: areturn        
        //    Exceptions:
        //  throws jess.JessException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  18     21     18     22     Any
        //  31     58     18     22     Any
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
    
    Fact _modify(final ValueVector valueVector, final Context context, final Rete rete) throws JessException {
        final Value resolveValue = valueVector.get(1).resolveValue(context);
        int n;
        Fact factByID;
        if (resolveValue.type() == 4) {
            n = resolveValue.intValue(context);
            factByID = rete.findFactByID(n);
        }
        else {
            factByID = (Fact)resolveValue.externalAddressValue(context);
            n = factByID.getFactId();
        }
        if (factByID == null || factByID.getFactId() == -1) {
            throw new JessException("modify", "no such fact", n);
        }
        final Deftemplate deftemplate = factByID.getDeftemplate();
        Fact fact = null;
        switch (factByID.getShadowMode()) {
            case 0: {
                fact = this.modifyRegularFact(rete, factByID, valueVector, context, deftemplate);
                break;
            }
            case 1: {
                fact = this.modifyShadowFact(rete, factByID, valueVector, context, deftemplate);
                break;
            }
            case 2: {
                this.modifyShadowFact(rete, factByID, valueVector, context, deftemplate);
                fact = this.modifyRegularFact(rete, factByID, valueVector, context, deftemplate);
                break;
            }
            default: {
                throw new JessException("modify", "Impossible shadow mode", factByID.getShadowMode());
            }
        }
        return fact;
    }
    
    Fact prepareToModify(final Fact p0, final Rete p1) throws JessException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     4: monitorexit    
        //     5: athrow         
        //     6: aload_2        
        //     7: invokevirtual   jess/Rete.getCompiler:()Ljess/ReteCompiler;
        //    10: dup            
        //    11: astore_3       
        //    12: monitorenter   
        //    13: aload_2        
        //    14: iconst_1       
        //    15: aload_1        
        //    16: invokevirtual   jess/Rete.processToken:(ILjess/Fact;)Ljess/Token;
        //    19: pop            
        //    20: aload_0        
        //    21: getfield        jess/FactList.m_table:Ljava/util/Map;
        //    24: aload_1        
        //    25: invokeinterface java/util/Map.remove:(Ljava/lang/Object;)Ljava/lang/Object;
        //    30: checkcast       Ljess/Fact;
        //    33: astore_1       
        //    34: aload_0        
        //    35: aload_1        
        //    36: invokevirtual   jess/FactList.removeAllLogicalSupportFor:(Ljess/Fact;)V
        //    39: aload_1        
        //    40: aload_3        
        //    41: monitorexit    
        //    42: areturn        
        //    Exceptions:
        //  throws jess.JessException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  3      5      3      6      Any
        //  13     42     3      6      Any
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
    
    Fact finishModify(final Fact p0, final Rete p1, final Context p2) throws JessException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     5: monitorexit    
        //     6: athrow         
        //     7: aload_2        
        //     8: invokevirtual   jess/Rete.getCompiler:()Ljess/ReteCompiler;
        //    11: dup            
        //    12: astore          4
        //    14: monitorenter   
        //    15: aload_2        
        //    16: ldc_w           1073741840
        //    19: aload_1        
        //    20: invokevirtual   jess/Rete.broadcastEvent:(ILjava/lang/Object;)V
        //    23: aload_3        
        //    24: invokevirtual   jess/Context.getLogicalSupportNode:()Ljess/LogicalNode;
        //    27: ifnull          61
        //    30: aload_3        
        //    31: invokevirtual   jess/Context.getToken:()Ljess/Token;
        //    34: astore          7
        //    36: aload_3        
        //    37: invokevirtual   jess/Context.getLogicalSupportNode:()Ljess/LogicalNode;
        //    40: aload_1        
        //    41: aload_3        
        //    42: invokevirtual   jess/Context.getToken:()Ljess/Token;
        //    45: invokeinterface jess/LogicalNode.dependsOn:(Ljess/Fact;Ljess/Token;)V
        //    50: aload_0        
        //    51: aload           7
        //    53: aload_1        
        //    54: iconst_0       
        //    55: invokevirtual   jess/FactList.addLogicalSupportFor:(Ljess/Token;Ljess/Fact;Z)V
        //    58: goto            73
        //    61: aload_0        
        //    62: getfield        jess/FactList.m_logicalSupport:Ljava/util/Map;
        //    65: ifnull          73
        //    68: aload_0        
        //    69: aload_1        
        //    70: invokespecial   jess/FactList.addUnconditionalSupportFor:(Ljess/Fact;)V
        //    73: aload_2        
        //    74: aload_1        
        //    75: invokevirtual   jess/Rete.doPreAssertionProcessing:(Ljess/Fact;)I
        //    78: ifne            110
        //    81: aload_0        
        //    82: getfield        jess/FactList.m_table:Ljava/util/Map;
        //    85: aload_1        
        //    86: aload_1        
        //    87: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    92: pop            
        //    93: aload_2        
        //    94: iconst_0       
        //    95: aload_1        
        //    96: invokevirtual   jess/Rete.processToken:(ILjess/Fact;)Ljess/Token;
        //    99: pop            
        //   100: aload_0        
        //   101: aload_2        
        //   102: invokevirtual   jess/FactList.processPendingFacts:(Ljess/Rete;)V
        //   105: aload_1        
        //   106: aload           4
        //   108: monitorexit    
        //   109: areturn        
        //   110: invokestatic    jess/Fact.getNullFact:()Ljess/Fact;
        //   113: aload           4
        //   115: monitorexit    
        //   116: areturn        
        //    Exceptions:
        //  throws jess.JessException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  3      6      3      7      Any
        //  110    116    3      7      Any
        //  15     109    3      7      Any
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
    
    private final Fact modifyRegularFact(final Rete p0, final Fact p1, final ValueVector p2, final Context p3, final Deftemplate p4) throws JessException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: aload           6
        //     5: monitorexit    
        //     6: athrow         
        //     7: aload_1        
        //     8: invokevirtual   jess/Rete.getActivationSemaphore:()Ljava/lang/Object;
        //    11: dup            
        //    12: astore          6
        //    14: monitorenter   
        //    15: aload_0        
        //    16: aload_2        
        //    17: aload_1        
        //    18: invokevirtual   jess/FactList.prepareToModify:(Ljess/Fact;Ljess/Rete;)Ljess/Fact;
        //    21: astore_2       
        //    22: iconst_2       
        //    23: istore          12
        //    25: goto            134
        //    28: aload_3        
        //    29: iload           12
        //    31: invokevirtual   jess/ValueVector.get:(I)Ljess/Value;
        //    34: aload           4
        //    36: invokevirtual   jess/Value.listValue:(Ljess/Context;)Ljess/ValueVector;
        //    39: astore          13
        //    41: aload_0        
        //    42: aload           13
        //    44: aload           4
        //    46: invokespecial   jess/FactList.getSlotName:(Ljess/ValueVector;Ljess/Context;)Ljava/lang/String;
        //    49: astore          14
        //    51: aload           5
        //    53: aload           14
        //    55: invokevirtual   jess/Deftemplate.getSlotIndex:(Ljava/lang/String;)I
        //    58: istore          15
        //    60: iload           15
        //    62: iconst_m1      
        //    63: if_icmpne       106
        //    66: new             Ljess/JessException;
        //    69: dup            
        //    70: ldc_w           "modify"
        //    73: new             Ljava/lang/StringBuffer;
        //    76: dup            
        //    77: ldc_w           "No such slot "
        //    80: invokespecial   java/lang/StringBuffer.<init>:(Ljava/lang/String;)V
        //    83: aload           14
        //    85: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //    88: ldc_w           " in template"
        //    91: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //    94: invokevirtual   java/lang/StringBuffer.toString:()Ljava/lang/String;
        //    97: aload           5
        //    99: invokevirtual   jess/Deftemplate.getName:()Ljava/lang/String;
        //   102: invokespecial   jess/JessException.<init>:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //   105: athrow         
        //   106: aload           5
        //   108: iload           15
        //   110: invokevirtual   jess/Deftemplate.getSlotType:(I)I
        //   113: istore          16
        //   115: aload_2        
        //   116: aload           14
        //   118: aload_0        
        //   119: aload           13
        //   121: aload           4
        //   123: iload           16
        //   125: invokespecial   jess/FactList.getSlotValue:(Ljess/ValueVector;Ljess/Context;I)Ljess/Value;
        //   128: invokevirtual   jess/Fact.setSlotValue:(Ljava/lang/String;Ljess/Value;)V
        //   131: iinc            12, 1
        //   134: iload           12
        //   136: aload_3        
        //   137: invokevirtual   jess/ValueVector.size:()I
        //   140: if_icmplt       28
        //   143: goto            167
        //   146: astore          9
        //   148: jsr             154
        //   151: aload           9
        //   153: athrow         
        //   154: astore          10
        //   156: aload_0        
        //   157: aload_2        
        //   158: aload_1        
        //   159: aload           4
        //   161: invokevirtual   jess/FactList.finishModify:(Ljess/Fact;Ljess/Rete;Ljess/Context;)Ljess/Fact;
        //   164: astore_2       
        //   165: ret             10
        //   167: jsr             154
        //   170: aload           6
        //   172: monitorexit    
        //   173: aload_2        
        //   174: areturn        
        //    Exceptions:
        //  throws jess.JessException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  3      6      3      7      Any
        //  22     151    146    154    Any
        //  167    170    146    154    Any
        //  15     173    3      7      Any
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
    
    private final Fact modifyShadowFact(final Rete rete, final Fact fact, final ValueVector valueVector, final Context context, final Deftemplate deftemplate) throws JessException {
        final Funcall arg = new Funcall("set", rete).arg(fact.getSlotValue("OBJECT"));
        arg.setLength(4);
        for (int i = 2; i < valueVector.size(); ++i) {
            final ValueVector listValue = valueVector.get(i).listValue(context);
            final String slotName = this.getSlotName(listValue, context);
            arg.set(new Value(slotName, 1), 2);
            final int slotIndex = deftemplate.getSlotIndex(slotName);
            if (slotIndex == -1) {
                throw new JessException("modify", "No such slot " + slotName + " in template", deftemplate.getName());
            }
            arg.set(this.getSlotValue(listValue, context, deftemplate.getSlotType(slotIndex)), 3);
            arg.execute(rete.getGlobalContext());
        }
        return fact;
    }
    
    private final String getSlotName(final ValueVector valueVector, final Context context) throws JessException {
        return valueVector.get(0).stringValue(context);
    }
    
    private final Value getSlotValue(final ValueVector valueVector, final Context context, final int n) throws JessException {
        if (n == 16384) {
            Value value;
            for (value = valueVector.get(1).resolveValue(context); value.type() == 512; value = value.listValue(context).get(0).resolveValue(context)) {}
            return value;
        }
        final ValueVector valueVector2 = new ValueVector();
        for (int i = 1; i < valueVector.size(); ++i) {
            final Value resolveValue = valueVector.get(i).resolveValue(context);
            if (resolveValue.type() == 512) {
                final ValueVector listValue = resolveValue.listValue(context);
                for (int j = 0; j < listValue.size(); ++j) {
                    valueVector2.add(listValue.get(j).resolveValue(context));
                }
            }
            else {
                valueVector2.add(resolveValue);
            }
        }
        return new Value(valueVector2, 512);
    }
    
    void addLogicalSupportFor(final Token p0, final Fact p1, final boolean p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     4: ifnonnull       21
        //     7: aload_0        
        //     8: new             Ljava/util/HashMap;
        //    11: dup            
        //    12: invokespecial   java/util/HashMap.<init>:()V
        //    15: invokestatic    java/util/Collections.synchronizedMap:(Ljava/util/Map;)Ljava/util/Map;
        //    18: putfield        jess/FactList.m_logicalSupport:Ljava/util/Map;
        //    21: aconst_null    
        //    22: astore          4
        //    24: goto            31
        //    27: aload           5
        //    29: monitorexit    
        //    30: athrow         
        //    31: aload_0        
        //    32: getfield        jess/FactList.m_logicalSupport:Ljava/util/Map;
        //    35: dup            
        //    36: astore          5
        //    38: monitorenter   
        //    39: aload_0        
        //    40: getfield        jess/FactList.m_logicalSupport:Ljava/util/Map;
        //    43: aload_2        
        //    44: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    49: checkcast       Ljava/util/ArrayList;
        //    52: astore          4
        //    54: aload           4
        //    56: ifnonnull       89
        //    59: iload_3        
        //    60: ifeq            67
        //    63: aload           5
        //    65: monitorexit    
        //    66: return         
        //    67: new             Ljava/util/ArrayList;
        //    70: dup            
        //    71: invokespecial   java/util/ArrayList.<init>:()V
        //    74: astore          4
        //    76: aload_0        
        //    77: getfield        jess/FactList.m_logicalSupport:Ljava/util/Map;
        //    80: aload_2        
        //    81: aload           4
        //    83: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    88: pop            
        //    89: aload           5
        //    91: monitorexit    
        //    92: aload           4
        //    94: aload_1        
        //    95: invokevirtual   java/util/ArrayList.add:(Ljava/lang/Object;)Z
        //    98: pop            
        //    99: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  27     30     27     31     Any
        //  67     92     27     31     Any
        //  39     66     27     31     Any
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
    
    private final void addUnconditionalSupportFor(final Fact p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        jess/FactList.m_logicalSupport:Ljava/util/Map;
        //     4: ifnonnull       8
        //     7: return         
        //     8: goto            14
        //    11: aload_2        
        //    12: monitorexit    
        //    13: athrow         
        //    14: aload_0        
        //    15: getfield        jess/FactList.m_logicalSupport:Ljava/util/Map;
        //    18: dup            
        //    19: astore_2       
        //    20: monitorenter   
        //    21: aload_0        
        //    22: getfield        jess/FactList.m_logicalSupport:Ljava/util/Map;
        //    25: aload_1        
        //    26: invokeinterface java/util/Map.remove:(Ljava/lang/Object;)Ljava/lang/Object;
        //    31: pop            
        //    32: aload_2        
        //    33: monitorexit    
        //    34: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  11     13     11     14     Any
        //  21     34     11     14     Any
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
    
    void removeLogicalSupportFrom(final Token p0, final Fact p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     4: ifnonnull       8
        //     7: return         
        //     8: aload_0        
        //     9: getfield        jess/FactList.m_logicalSupport:Ljava/util/Map;
        //    12: aload_2        
        //    13: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    18: checkcast       Ljava/util/ArrayList;
        //    21: astore_3       
        //    22: aload_3        
        //    23: ifnonnull       27
        //    26: return         
        //    27: goto            34
        //    30: aload           4
        //    32: monitorexit    
        //    33: athrow         
        //    34: aload_0        
        //    35: getfield        jess/FactList.m_logicalSupport:Ljava/util/Map;
        //    38: dup            
        //    39: astore          4
        //    41: monitorenter   
        //    42: aload_3        
        //    43: aload_1        
        //    44: invokevirtual   java/util/ArrayList.remove:(Ljava/lang/Object;)Z
        //    47: ifeq            74
        //    50: aload_3        
        //    51: invokevirtual   java/util/ArrayList.size:()I
        //    54: ifne            74
        //    57: aload_0        
        //    58: getfield        jess/FactList.m_logicalSupport:Ljava/util/Map;
        //    61: aload_2        
        //    62: invokeinterface java/util/Map.remove:(Ljava/lang/Object;)Ljava/lang/Object;
        //    67: pop            
        //    68: aload_0        
        //    69: aload_2        
        //    70: iconst_0       
        //    71: invokevirtual   jess/FactList.setPendingFact:(Ljess/Fact;Z)V
        //    74: aload           4
        //    76: monitorexit    
        //    77: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  30     33     30     34     Any
        //  42     77     30     34     Any
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
    
    ArrayList getSupportingTokens(final Fact fact) {
        return this.m_logicalSupport.get(fact);
    }
    
    void removeAllLogicalSupportFor(final Fact fact) {
        if (this.m_logicalSupport != null) {
            this.m_logicalSupport.remove(fact);
        }
    }
    
    public ArrayList getSupportedFacts(final Fact p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   java/util/ArrayList.<init>:()V
        //     7: astore_2       
        //     8: goto            14
        //    11: aload_3        
        //    12: monitorexit    
        //    13: athrow         
        //    14: aload_0        
        //    15: getfield        jess/FactList.m_logicalSupport:Ljava/util/Map;
        //    18: dup            
        //    19: astore_3       
        //    20: monitorenter   
        //    21: aload_0        
        //    22: getfield        jess/FactList.m_logicalSupport:Ljava/util/Map;
        //    25: invokeinterface java/util/Map.entrySet:()Ljava/util/Set;
        //    30: invokeinterface java/util/Set.iterator:()Ljava/util/Iterator;
        //    35: astore          6
        //    37: goto            149
        //    40: aload           6
        //    42: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    47: checkcast       Ljava/util/Map$Entry;
        //    50: astore          7
        //    52: aload           7
        //    54: invokeinterface java/util/Map$Entry.getValue:()Ljava/lang/Object;
        //    59: checkcast       Ljava/util/ArrayList;
        //    62: astore          8
        //    64: aload           8
        //    66: ifnonnull       72
        //    69: goto            149
        //    72: iconst_0       
        //    73: istore          9
        //    75: goto            139
        //    78: aload           8
        //    80: iload           9
        //    82: invokevirtual   java/util/ArrayList.get:(I)Ljava/lang/Object;
        //    85: checkcast       Ljess/Token;
        //    88: astore          10
        //    90: aload           10
        //    92: astore          11
        //    94: goto            131
        //    97: aload           11
        //    99: invokevirtual   jess/Token.topFact:()Ljess/Fact;
        //   102: invokevirtual   jess/Fact.getFactId:()I
        //   105: aload_1        
        //   106: invokevirtual   jess/Fact.getFactId:()I
        //   109: if_icmpne       124
        //   112: aload_2        
        //   113: aload           7
        //   115: invokeinterface java/util/Map$Entry.getKey:()Ljava/lang/Object;
        //   120: invokevirtual   java/util/ArrayList.add:(Ljava/lang/Object;)Z
        //   123: pop            
        //   124: aload           11
        //   126: invokevirtual   jess/Token.getParent:()Ljess/Token;
        //   129: astore          11
        //   131: aload           11
        //   133: ifnonnull       97
        //   136: iinc            9, 1
        //   139: iload           9
        //   141: aload           8
        //   143: invokevirtual   java/util/ArrayList.size:()I
        //   146: if_icmplt       78
        //   149: aload           6
        //   151: invokeinterface java/util/Iterator.hasNext:()Z
        //   156: ifne            40
        //   159: aload_3        
        //   160: monitorexit    
        //   161: aload_2        
        //   162: areturn        
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  11     13     11     14     Any
        //  21     161    11     14     Any
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
    
    private final /* synthetic */ void this() {
        this.m_table = Collections.synchronizedMap(new HashMap<Object, Object>());
        this.m_factsToAssert = new ArrayList();
        this.m_factsToRetract = new ArrayList();
        this.m_time = 0;
        this.m_idLock = new String("LOCK");
    }
    
    FactList() {
        this.this();
    }
}
