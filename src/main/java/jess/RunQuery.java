package jess;

import java.io.Serializable;

class RunQuery implements Userfunction, Serializable
{
    public static final int RUN = 0;
    public static final int COUNT = 1;
    private int m_cmd;
    
    public String getName() {
        return (this.m_cmd == 0) ? "run-query" : "count-query-results";
    }
    
    public Value call(final ValueVector p0, final Context p1) throws JessException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: iconst_1       
        //     2: invokevirtual   jess/ValueVector.get:(I)Ljess/Value;
        //     5: aload_2        
        //     6: invokevirtual   jess/Value.atomValue:(Ljess/Context;)Ljava/lang/String;
        //     9: astore_3       
        //    10: aload_2        
        //    11: invokevirtual   jess/Context.getEngine:()Ljess/Rete;
        //    14: aload_3        
        //    15: invokevirtual   jess/Rete.findDefrule:(Ljava/lang/String;)Ljess/HasLHS;
        //    18: astore          4
        //    20: aload           4
        //    22: ifnull          33
        //    25: aload           4
        //    27: instanceof      Ljess/Defquery;
        //    30: ifne            46
        //    33: new             Ljess/JessException;
        //    36: dup            
        //    37: ldc             "run-query"
        //    39: ldc             "No such query:"
        //    41: aload_3        
        //    42: invokespecial   jess/JessException.<init>:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //    45: athrow         
        //    46: aload           4
        //    48: checkcast       Ljess/Defquery;
        //    51: astore          5
        //    53: aload_2        
        //    54: invokevirtual   jess/Context.getEngine:()Ljess/Rete;
        //    57: astore          6
        //    59: new             Ljess/Fact;
        //    62: dup            
        //    63: aload           5
        //    65: invokevirtual   jess/Defquery.getQueryTriggerName:()Ljava/lang/String;
        //    68: aload           6
        //    70: invokespecial   jess/Fact.<init>:(Ljava/lang/String;Ljess/Rete;)V
        //    73: astore          7
        //    75: new             Ljess/ValueVector;
        //    78: dup            
        //    79: invokespecial   jess/ValueVector.<init>:()V
        //    82: astore          8
        //    84: aload_1        
        //    85: invokevirtual   jess/ValueVector.size:()I
        //    88: iconst_2       
        //    89: isub           
        //    90: aload           5
        //    92: invokevirtual   jess/Defquery.getNVariables:()I
        //    95: if_icmpeq       111
        //    98: new             Ljess/JessException;
        //   101: dup            
        //   102: ldc             "run-query"
        //   104: ldc             "Wrong number of variables for query"
        //   106: aload_3        
        //   107: invokespecial   jess/JessException.<init>:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //   110: athrow         
        //   111: iconst_2       
        //   112: istore          9
        //   114: goto            136
        //   117: aload           8
        //   119: aload_1        
        //   120: iload           9
        //   122: invokevirtual   jess/ValueVector.get:(I)Ljess/Value;
        //   125: aload_2        
        //   126: invokevirtual   jess/Value.resolveValue:(Ljess/Context;)Ljess/Value;
        //   129: invokevirtual   jess/ValueVector.add:(Ljess/Value;)Ljess/ValueVector;
        //   132: pop            
        //   133: iinc            9, 1
        //   136: iload           9
        //   138: aload_1        
        //   139: invokevirtual   jess/ValueVector.size:()I
        //   142: if_icmplt       117
        //   145: aload           7
        //   147: ldc             "__data"
        //   149: new             Ljess/Value;
        //   152: dup            
        //   153: aload           8
        //   155: sipush          512
        //   158: invokespecial   jess/Value.<init>:(Ljess/ValueVector;I)V
        //   161: invokevirtual   jess/Fact.setSlotValue:(Ljava/lang/String;Ljess/Value;)V
        //   164: goto            171
        //   167: aload           9
        //   169: monitorexit    
        //   170: athrow         
        //   171: aload           6
        //   173: invokevirtual   jess/Rete.getCompiler:()Ljess/ReteCompiler;
        //   176: dup            
        //   177: astore          9
        //   179: monitorenter   
        //   180: goto            187
        //   183: aload           12
        //   185: monitorexit    
        //   186: athrow         
        //   187: aload           5
        //   189: dup            
        //   190: astore          12
        //   192: monitorenter   
        //   193: aload           5
        //   195: invokevirtual   jess/Defquery.clearResults:()V
        //   198: aload           6
        //   200: aload           7
        //   202: aload_2        
        //   203: invokevirtual   jess/Rete.assertFact:(Ljess/Fact;Ljess/Context;)Ljess/Fact;
        //   206: pop            
        //   207: aload           5
        //   209: invokevirtual   jess/Defquery.getMaxBackgroundRules:()I
        //   212: ifle            226
        //   215: aload           6
        //   217: aload           5
        //   219: invokevirtual   jess/Defquery.getMaxBackgroundRules:()I
        //   222: invokevirtual   jess/Rete.run:(I)I
        //   225: pop            
        //   226: aload_0        
        //   227: getfield        jess/RunQuery.m_cmd:I
        //   230: ifne            254
        //   233: aload           5
        //   235: invokevirtual   jess/Defquery.getResults:()Ljava/util/Iterator;
        //   238: astore          16
        //   240: new             Ljess/Value;
        //   243: dup            
        //   244: aload           16
        //   246: invokespecial   jess/Value.<init>:(Ljava/lang/Object;)V
        //   249: astore          15
        //   251: goto            269
        //   254: new             Ljess/Value;
        //   257: dup            
        //   258: aload           5
        //   260: invokevirtual   jess/Defquery.countResults:()I
        //   263: iconst_4       
        //   264: invokespecial   jess/Value.<init>:(II)V
        //   267: astore          15
        //   269: aload           5
        //   271: invokevirtual   jess/Defquery.clearResults:()V
        //   274: aload           6
        //   276: aload           7
        //   278: invokevirtual   jess/Rete.retract:(Ljess/Fact;)Ljess/Fact;
        //   281: pop            
        //   282: aload           15
        //   284: aload           12
        //   286: monitorexit    
        //   287: aload           9
        //   289: monitorexit    
        //   290: areturn        
        //    Exceptions:
        //  throws jess.JessException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  167    170    167    171    Any
        //  183    186    183    187    Any
        //  193    287    183    187    Any
        //  180    290    167    171    Any
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
    
    RunQuery(final int cmd) {
        this.m_cmd = cmd;
    }
}
