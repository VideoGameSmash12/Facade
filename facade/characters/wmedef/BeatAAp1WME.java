package facade.characters.wmedef;

import wm.TimeStampedWME;

public class BeatAAp1WME extends TimeStampedWME
{
    private boolean bVal1;
    private boolean bVal2;
    private boolean bVal3;
    private boolean bVal4;
    private boolean bVal5;
    private int subtopic;
    private int previousSubtopic;
    private int iVal3;
    private int iVal4;
    private int subtopicObject;
    private float fVal1;
    private float fVal2;
    private float fVal3;
    private float fVal4;
    private float fVal5;
    
    public synchronized boolean getBVal1() {
        return this.bVal1;
    }
    
    public synchronized boolean getBVal2() {
        return this.bVal2;
    }
    
    public synchronized boolean getBVal3() {
        return this.bVal3;
    }
    
    public synchronized boolean getBVal4() {
        return this.bVal4;
    }
    
    public synchronized boolean getBVal5() {
        return this.bVal5;
    }
    
    public synchronized int getSubtopic() {
        return this.subtopic;
    }
    
    public synchronized int getPreviousSubtopic() {
        return this.previousSubtopic;
    }
    
    public synchronized int getIVal3() {
        return this.iVal3;
    }
    
    public synchronized int getIVal4() {
        return this.iVal4;
    }
    
    public synchronized int getSubtopicObject() {
        return this.subtopicObject;
    }
    
    public synchronized float getFVal1() {
        return this.fVal1;
    }
    
    public synchronized float getFVal2() {
        return this.fVal2;
    }
    
    public synchronized float getFVal3() {
        return this.fVal3;
    }
    
    public synchronized float getFVal4() {
        return this.fVal4;
    }
    
    public synchronized float getFVal5() {
        return this.fVal5;
    }
    
    public synchronized void setBVal1(final boolean bVal1) {
        this.bVal1 = bVal1;
    }
    
    public synchronized void setBVal2(final boolean bVal2) {
        this.bVal2 = bVal2;
    }
    
    public synchronized void setBVal3(final boolean bVal3) {
        this.bVal3 = bVal3;
    }
    
    public synchronized void setBVal4(final boolean bVal4) {
        this.bVal4 = bVal4;
    }
    
    public synchronized void setBVal5(final boolean bVal5) {
        this.bVal5 = bVal5;
    }
    
    public void setSubtopic(final int p0) {
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
        //    11: getfield        facade/characters/wmedef/BeatAAp1WME.subtopic:I
        //    14: istore_2       
        //    15: aload_0        
        //    16: iload_1        
        //    17: putfield        facade/characters/wmedef/BeatAAp1WME.subtopic:I
        //    20: aload_3        
        //    21: monitorexit    
        //    22: aload_0        
        //    23: getfield        facade/characters/wmedef/BeatAAp1WME.__support:Ljava/beans/PropertyChangeSupport;
        //    26: ldc             "subtopic"
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
    
    public void setPreviousSubtopic(final int p0) {
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
        //    11: getfield        facade/characters/wmedef/BeatAAp1WME.previousSubtopic:I
        //    14: istore_2       
        //    15: aload_0        
        //    16: iload_1        
        //    17: putfield        facade/characters/wmedef/BeatAAp1WME.previousSubtopic:I
        //    20: aload_3        
        //    21: monitorexit    
        //    22: aload_0        
        //    23: getfield        facade/characters/wmedef/BeatAAp1WME.__support:Ljava/beans/PropertyChangeSupport;
        //    26: ldc             "previousSubtopic"
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
    
    public synchronized void setIVal3(final int iVal3) {
        this.iVal3 = iVal3;
    }
    
    public synchronized void setIVal4(final int iVal4) {
        this.iVal4 = iVal4;
    }
    
    public synchronized void setSubtopicObject(final int subtopicObject) {
        this.subtopicObject = subtopicObject;
    }
    
    public synchronized void setFVal1(final float fVal1) {
        this.fVal1 = fVal1;
    }
    
    public synchronized void setFVal2(final float fVal2) {
        this.fVal2 = fVal2;
    }
    
    public synchronized void setFVal3(final float fVal3) {
        this.fVal3 = fVal3;
    }
    
    public synchronized void setFVal4(final float fVal4) {
        this.fVal4 = fVal4;
    }
    
    public synchronized void setFVal5(final float fVal5) {
        this.fVal5 = fVal5;
    }
    
    public BeatAAp1WME() {
        this.bVal1 = false;
        this.bVal2 = false;
        this.bVal3 = false;
        this.bVal4 = false;
        this.bVal5 = false;
        this.subtopic = -1;
        this.previousSubtopic = -1;
        this.iVal3 = 0;
        this.iVal4 = 0;
        this.subtopicObject = 0;
        this.fVal1 = 0.0f;
        this.fVal2 = 0.0f;
        this.fVal3 = 0.0f;
        this.fVal4 = 0.0f;
        this.fVal5 = 0.0f;
    }
}
