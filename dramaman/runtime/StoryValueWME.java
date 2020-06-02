package dramaman.runtime;

import wm.WME;

public class StoryValueWME extends WME
{
    private float value;
    
    public synchronized float getValue() {
        return this.value;
    }
    
    public void setValue(final float p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: aload_3        
        //     4: monitorexit    
        //     5: athrow         
        //     6: aload_0        
        //     7: dup            
        //     8: astore_3       
        //     9: monitorenter   
        //    10: aload_0        
        //    11: getfield        dramaman/runtime/StoryValueWME.value:F
        //    14: fstore_2       
        //    15: aload_0        
        //    16: fload_1        
        //    17: putfield        dramaman/runtime/StoryValueWME.value:F
        //    20: aload_3        
        //    21: monitorexit    
        //    22: aload_0        
        //    23: getfield        dramaman/runtime/StoryValueWME.__support:Ljava/beans/PropertyChangeSupport;
        //    26: ldc             "value"
        //    28: new             Ljava/lang/Float;
        //    31: dup            
        //    32: fload_2        
        //    33: invokespecial   java/lang/Float.<init>:(F)V
        //    36: new             Ljava/lang/Float;
        //    39: dup            
        //    40: fload_1        
        //    41: invokespecial   java/lang/Float.<init>:(F)V
        //    44: invokevirtual   java/beans/PropertyChangeSupport.firePropertyChange:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
        //    47: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  3      5      3      6      Any
        //  10     22     3      6      Any
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
        this.value = 0.0f;
    }
    
    public StoryValueWME(final float value) {
        this.this();
        this.value = value;
    }
    
    public StoryValueWME() {
        this.this();
    }
}
