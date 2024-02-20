package jess;

import java.io.Serializable;

class Synchronized implements Userfunction, Serializable
{
    public String getName() {
        return "synchronized";
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
        //     6: invokevirtual   jess/Value.externalAddressValue:(Ljess/Context;)Ljava/lang/Object;
        //     9: astore_3       
        //    10: aconst_null    
        //    11: astore          4
        //    13: goto            20
        //    16: aload           5
        //    18: monitorexit    
        //    19: athrow         
        //    20: aload_3        
        //    21: dup            
        //    22: astore          5
        //    24: monitorenter   
        //    25: iconst_2       
        //    26: istore          8
        //    28: goto            62
        //    31: aload_1        
        //    32: iload           8
        //    34: invokevirtual   jess/ValueVector.get:(I)Ljess/Value;
        //    37: aload_2        
        //    38: invokevirtual   jess/Value.resolveValue:(Ljess/Context;)Ljess/Value;
        //    41: astore          4
        //    43: aload_2        
        //    44: invokevirtual   jess/Context.returning:()Z
        //    47: ifeq            59
        //    50: aload_2        
        //    51: invokevirtual   jess/Context.getReturnValue:()Ljess/Value;
        //    54: astore          4
        //    56: goto            71
        //    59: iinc            8, 1
        //    62: iload           8
        //    64: aload_1        
        //    65: invokevirtual   jess/ValueVector.size:()I
        //    68: if_icmplt       31
        //    71: aload           5
        //    73: monitorexit    
        //    74: aload           4
        //    76: areturn        
        //    Exceptions:
        //  throws jess.JessException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  16     19     16     20     Any
        //  25     74     16     20     Any
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
}
