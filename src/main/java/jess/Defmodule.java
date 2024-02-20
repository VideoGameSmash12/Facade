package jess;

import java.util.Iterator;
import java.util.TreeMap;
import java.io.Serializable;

class Defmodule implements Serializable
{
    public static final String MAIN = "MAIN";
    private HeapPriorityQueue m_queue;
    private TreeMap m_deftemplates;
    private String m_name;
    private String m_comment;
    
    HeapPriorityQueue getQueue() {
        return this.m_queue;
    }
    
    String getName() {
        return this.m_name;
    }
    
    String getDocstring() {
        return this.m_comment;
    }
    
    void reset() {
        this.m_queue.clear();
    }
    
    Iterator listDeftemplates() {
        return this.m_deftemplates.values().iterator();
    }
    
    Deftemplate getDeftemplate(String substring) {
        final int index = substring.indexOf("::");
        if (index != -1) {
            substring = substring.substring(index + 2);
        }
        return this.m_deftemplates.get(substring);
    }
    
    Deftemplate addDeftemplate(final Deftemplate p0, final Rete p1) throws JessException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     4: monitorexit    
        //     5: athrow         
        //     6: aload_0        
        //     7: getfield        jess/Defmodule.m_deftemplates:Ljava/util/TreeMap;
        //    10: dup            
        //    11: astore_3       
        //    12: monitorenter   
        //    13: aload_1        
        //    14: invokevirtual   jess/Deftemplate.getModule:()Ljava/lang/String;
        //    17: aload_0        
        //    18: getfield        jess/Defmodule.m_name:Ljava/lang/String;
        //    21: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    24: ifne            43
        //    27: new             Ljess/JessException;
        //    30: dup            
        //    31: ldc             "Defmodule.addDeftemplate"
        //    33: ldc             "Wrong module name"
        //    35: aload_1        
        //    36: invokevirtual   jess/Deftemplate.getModule:()Ljava/lang/String;
        //    39: invokespecial   jess/JessException.<init>:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //    42: athrow         
        //    43: aload_1        
        //    44: invokevirtual   jess/Deftemplate.getBaseName:()Ljava/lang/String;
        //    47: astore          6
        //    49: aload_0        
        //    50: getfield        jess/Defmodule.m_deftemplates:Ljava/util/TreeMap;
        //    53: aload           6
        //    55: invokevirtual   java/util/TreeMap.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    58: checkcast       Ljess/Deftemplate;
        //    61: astore          7
        //    63: aload           7
        //    65: ifnull          77
        //    68: aload           7
        //    70: aload_1        
        //    71: invokevirtual   jess/Deftemplate.equals:(Ljava/lang/Object;)Z
        //    74: ifeq            98
        //    77: aload_2        
        //    78: bipush          64
        //    80: aload_1        
        //    81: invokevirtual   jess/Rete.broadcastEvent:(ILjava/lang/Object;)V
        //    84: aload_0        
        //    85: getfield        jess/Defmodule.m_deftemplates:Ljava/util/TreeMap;
        //    88: aload           6
        //    90: aload_1        
        //    91: invokevirtual   java/util/TreeMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    94: pop            
        //    95: goto            114
        //    98: new             Ljess/JessException;
        //   101: dup            
        //   102: ldc             "Defmodule.addDeftemplate"
        //   104: ldc             "Cannot redefine deftemplate"
        //   106: aload_1        
        //   107: invokevirtual   jess/Deftemplate.getName:()Ljava/lang/String;
        //   110: invokespecial   jess/JessException.<init>:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //   113: athrow         
        //   114: aload_1        
        //   115: aload_3        
        //   116: monitorexit    
        //   117: areturn        
        //    Exceptions:
        //  throws jess.JessException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  3      5      3      6      Any
        //  13     117    3      6      Any
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
    
    Defmodule(final String name, final String comment, final Strategy strategy) {
        this.m_name = name;
        this.m_comment = comment;
        this.m_queue = new HeapPriorityQueue(strategy);
        this.m_deftemplates = new TreeMap();
    }
}
