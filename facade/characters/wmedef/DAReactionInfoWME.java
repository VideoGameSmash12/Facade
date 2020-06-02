package facade.characters.wmedef;

import facade.util.PrintUtilities;

public class DAReactionInfoWME extends ReactionInfoWME
{
    private int daID;
    private int daAddressee;
    
    public synchronized String formatDaID() {
        return PrintUtilities.daType_EnumToString(this.getDaID());
    }
    
    public synchronized int getDaID() {
        return this.daID;
    }
    
    public void setDaID(final int p0) {
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
        //    11: getfield        facade/characters/wmedef/DAReactionInfoWME.daID:I
        //    14: istore_2       
        //    15: aload_0        
        //    16: iload_1        
        //    17: putfield        facade/characters/wmedef/DAReactionInfoWME.daID:I
        //    20: aload_3        
        //    21: monitorexit    
        //    22: aload_0        
        //    23: getfield        facade/characters/wmedef/DAReactionInfoWME.__support:Ljava/beans/PropertyChangeSupport;
        //    26: ldc             "daID"
        //    28: iload_2        
        //    29: iload_1        
        //    30: invokevirtual   java/beans/PropertyChangeSupport.firePropertyChange:(Ljava/lang/String;II)V
        //    33: return         
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
    
    public synchronized int getDaAddressee() {
        return this.daAddressee;
    }
    
    public void setDaAddressee(final int p0) {
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
        //    11: getfield        facade/characters/wmedef/DAReactionInfoWME.daAddressee:I
        //    14: istore_2       
        //    15: aload_0        
        //    16: iload_1        
        //    17: putfield        facade/characters/wmedef/DAReactionInfoWME.daAddressee:I
        //    20: aload_3        
        //    21: monitorexit    
        //    22: aload_0        
        //    23: getfield        facade/characters/wmedef/DAReactionInfoWME.__support:Ljava/beans/PropertyChangeSupport;
        //    26: ldc             "daAddressee"
        //    28: iload_2        
        //    29: iload_1        
        //    30: invokevirtual   java/beans/PropertyChangeSupport.firePropertyChange:(Ljava/lang/String;II)V
        //    33: return         
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
    
    public DAReactionInfoWME(final int n, final boolean b, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int daID, final int daAddressee) {
        super(n, b, n2, n3, n4, n5, n6, n7);
        this.daID = daID;
        this.daAddressee = daAddressee;
    }
    
    public DAReactionInfoWME() {
    }
}
