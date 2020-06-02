package jess;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Node1RTL extends Node1 implements LogicalNode
{
    private HashMap m_logicalDepends;
    private int m_tokenSize;
    
    void callNodeRight(final Token token, final Context context) throws JessException {
        if (this.m_logicalDepends != null) {
            this.removeLogicalSupportFrom(token, context);
        }
        this.passAlong(token, context);
    }
    
    void passAlong(final Token token, final Context context) throws JessException {
        this.m_tokenSize = token.size();
        final Node[] succ = this.m_succ;
        for (int i = 0; i < this.m_nSucc; ++i) {
            succ[i].callNodeLeft(token, context);
        }
    }
    
    public boolean equals(final Object o) {
        return o instanceof Node1RTL;
    }
    
    public String toString() {
        return "[Left input adapter]";
    }
    
    public void dependsOn(final Fact p0, final Token p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        jess/Node1RTL.m_logicalDepends:Ljava/util/HashMap;
        //     4: ifnonnull       18
        //     7: aload_0        
        //     8: new             Ljava/util/HashMap;
        //    11: dup            
        //    12: invokespecial   java/util/HashMap.<init>:()V
        //    15: putfield        jess/Node1RTL.m_logicalDepends:Ljava/util/HashMap;
        //    18: aload_0        
        //    19: getfield        jess/Node1RTL.m_logicalDepends:Ljava/util/HashMap;
        //    22: aload_2        
        //    23: invokevirtual   java/util/HashMap.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    26: checkcast       Ljava/util/ArrayList;
        //    29: astore_3       
        //    30: aload_3        
        //    31: ifnonnull       52
        //    34: new             Ljava/util/ArrayList;
        //    37: dup            
        //    38: invokespecial   java/util/ArrayList.<init>:()V
        //    41: astore_3       
        //    42: aload_0        
        //    43: getfield        jess/Node1RTL.m_logicalDepends:Ljava/util/HashMap;
        //    46: aload_2        
        //    47: aload_3        
        //    48: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    51: pop            
        //    52: goto            59
        //    55: aload           4
        //    57: monitorexit    
        //    58: athrow         
        //    59: aload_3        
        //    60: dup            
        //    61: astore          4
        //    63: monitorenter   
        //    64: aload_3        
        //    65: aload_1        
        //    66: invokevirtual   java/util/ArrayList.add:(Ljava/lang/Object;)Z
        //    69: pop            
        //    70: aload           4
        //    72: monitorexit    
        //    73: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  55     58     55     59     Any
        //  64     73     55     59     Any
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
    
    public Map getLogicalDependencies() {
        return this.m_logicalDepends;
    }
    
    public int getTokenSize() {
        return this.m_tokenSize;
    }
    
    protected void removeLogicalSupportFrom(final Token token, final Context context) {
        final ArrayList<Fact> list = this.m_logicalDepends.remove(token);
        if (list != null) {
            final Rete engine = context.getEngine();
            for (int i = 0; i < list.size(); ++i) {
                engine.removeLogicalSupportFrom(token, list.get(i));
            }
        }
    }
}
