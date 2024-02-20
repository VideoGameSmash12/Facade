package facade.characters.wmedef;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collection;
import wm.WME;

public class BeatStatusWME extends WME
{
    private int status;
    private String curBGSig;
    private boolean bCommitPointReached;
    private boolean bGistPointReached;
    private boolean bTxningOut;
    private int abortReason;
    private boolean mixInAllowed_pushTooFar;
    private boolean mixInAllowed_satellite;
    private boolean mixInAllowed_redirectConnect;
    private boolean mixInAllowed_object;
    private boolean mixInAllowed_DA;
    private boolean mixInAllowed_deflect;
    private boolean mixInAllowed_pattern;
    private boolean mixInAllowed_ltb;
    private Collection disallowedPushTooFarObjects;
    
    public synchronized int getStatus() {
        return this.status;
    }
    
    public void setStatus(final int p0) {
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
        //    11: getfield        facade/characters/wmedef/BeatStatusWME.status:I
        //    14: istore_2       
        //    15: aload_0        
        //    16: iload_1        
        //    17: putfield        facade/characters/wmedef/BeatStatusWME.status:I
        //    20: aload_3        
        //    21: monitorexit    
        //    22: aload_0        
        //    23: getfield        facade/characters/wmedef/BeatStatusWME.__support:Ljava/beans/PropertyChangeSupport;
        //    26: ldc             "status"
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
    
    public synchronized String getCurBGSig() {
        return this.curBGSig;
    }
    
    public void setCurBGSig(final String p0) {
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
        //    11: getfield        facade/characters/wmedef/BeatStatusWME.curBGSig:Ljava/lang/String;
        //    14: astore_2       
        //    15: aload_0        
        //    16: aload_1        
        //    17: putfield        facade/characters/wmedef/BeatStatusWME.curBGSig:Ljava/lang/String;
        //    20: aload_3        
        //    21: monitorexit    
        //    22: aload_0        
        //    23: getfield        facade/characters/wmedef/BeatStatusWME.__support:Ljava/beans/PropertyChangeSupport;
        //    26: ldc             "curBGSig"
        //    28: aload_2        
        //    29: aload_1        
        //    30: invokevirtual   java/beans/PropertyChangeSupport.firePropertyChange:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
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
    
    public synchronized boolean getCommitPointReached() {
        return this.bCommitPointReached;
    }
    
    public void setCommitPointReached(final boolean p0) {
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
        //    11: getfield        facade/characters/wmedef/BeatStatusWME.bCommitPointReached:Z
        //    14: istore_2       
        //    15: aload_0        
        //    16: iload_1        
        //    17: putfield        facade/characters/wmedef/BeatStatusWME.bCommitPointReached:Z
        //    20: aload_3        
        //    21: monitorexit    
        //    22: aload_0        
        //    23: getfield        facade/characters/wmedef/BeatStatusWME.__support:Ljava/beans/PropertyChangeSupport;
        //    26: ldc             "commitPointReached"
        //    28: iload_2        
        //    29: iload_1        
        //    30: invokevirtual   java/beans/PropertyChangeSupport.firePropertyChange:(Ljava/lang/String;ZZ)V
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
    
    public synchronized boolean getGistPointReached() {
        return this.bGistPointReached;
    }
    
    public void setGistPointReached(final boolean p0) {
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
        //    11: getfield        facade/characters/wmedef/BeatStatusWME.bGistPointReached:Z
        //    14: istore_2       
        //    15: aload_0        
        //    16: iload_1        
        //    17: putfield        facade/characters/wmedef/BeatStatusWME.bGistPointReached:Z
        //    20: aload_3        
        //    21: monitorexit    
        //    22: aload_0        
        //    23: getfield        facade/characters/wmedef/BeatStatusWME.__support:Ljava/beans/PropertyChangeSupport;
        //    26: ldc             "gistPointReached"
        //    28: iload_2        
        //    29: iload_1        
        //    30: invokevirtual   java/beans/PropertyChangeSupport.firePropertyChange:(Ljava/lang/String;ZZ)V
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
    
    public synchronized boolean getTxningOut() {
        return this.bTxningOut;
    }
    
    public synchronized boolean getBTxningOut() {
        return this.bTxningOut;
    }
    
    public void setTxningOut(final boolean p0) {
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
        //    11: getfield        facade/characters/wmedef/BeatStatusWME.bTxningOut:Z
        //    14: istore_2       
        //    15: aload_0        
        //    16: iload_1        
        //    17: putfield        facade/characters/wmedef/BeatStatusWME.bTxningOut:Z
        //    20: aload_3        
        //    21: monitorexit    
        //    22: aload_0        
        //    23: getfield        facade/characters/wmedef/BeatStatusWME.__support:Ljava/beans/PropertyChangeSupport;
        //    26: ldc             "txningOut"
        //    28: iload_2        
        //    29: iload_1        
        //    30: invokevirtual   java/beans/PropertyChangeSupport.firePropertyChange:(Ljava/lang/String;ZZ)V
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
    
    public synchronized int getAbortReason() {
        return this.abortReason;
    }
    
    public void setAbortReason(final int p0) {
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
        //    11: getfield        facade/characters/wmedef/BeatStatusWME.abortReason:I
        //    14: istore_2       
        //    15: aload_0        
        //    16: iload_1        
        //    17: putfield        facade/characters/wmedef/BeatStatusWME.abortReason:I
        //    20: aload_3        
        //    21: monitorexit    
        //    22: aload_0        
        //    23: getfield        facade/characters/wmedef/BeatStatusWME.__support:Ljava/beans/PropertyChangeSupport;
        //    26: ldc             "abortReason"
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
    
    public synchronized boolean getMixInAllowed_pushTooFar() {
        return this.mixInAllowed_pushTooFar;
    }
    
    public void setMixInAllowed_pushTooFar(final boolean p0) {
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
        //    11: getfield        facade/characters/wmedef/BeatStatusWME.mixInAllowed_pushTooFar:Z
        //    14: istore_2       
        //    15: aload_0        
        //    16: iload_1        
        //    17: putfield        facade/characters/wmedef/BeatStatusWME.mixInAllowed_pushTooFar:Z
        //    20: aload_3        
        //    21: monitorexit    
        //    22: aload_0        
        //    23: getfield        facade/characters/wmedef/BeatStatusWME.__support:Ljava/beans/PropertyChangeSupport;
        //    26: ldc             "mixInAllowed_pushTooFar"
        //    28: iload_2        
        //    29: iload_1        
        //    30: invokevirtual   java/beans/PropertyChangeSupport.firePropertyChange:(Ljava/lang/String;ZZ)V
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
    
    public synchronized boolean getMixInAllowed_satellite() {
        return this.mixInAllowed_satellite;
    }
    
    public void setMixInAllowed_satellite(final boolean p0) {
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
        //    11: getfield        facade/characters/wmedef/BeatStatusWME.mixInAllowed_satellite:Z
        //    14: istore_2       
        //    15: aload_0        
        //    16: iload_1        
        //    17: putfield        facade/characters/wmedef/BeatStatusWME.mixInAllowed_satellite:Z
        //    20: aload_3        
        //    21: monitorexit    
        //    22: aload_0        
        //    23: getfield        facade/characters/wmedef/BeatStatusWME.__support:Ljava/beans/PropertyChangeSupport;
        //    26: ldc             "mixInAllowed_satellite"
        //    28: iload_2        
        //    29: iload_1        
        //    30: invokevirtual   java/beans/PropertyChangeSupport.firePropertyChange:(Ljava/lang/String;ZZ)V
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
    
    public synchronized boolean getMixInAllowed_redirectConnect() {
        return this.mixInAllowed_redirectConnect;
    }
    
    public void setMixInAllowed_redirectConnect(final boolean p0) {
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
        //    11: getfield        facade/characters/wmedef/BeatStatusWME.mixInAllowed_redirectConnect:Z
        //    14: istore_2       
        //    15: aload_0        
        //    16: iload_1        
        //    17: putfield        facade/characters/wmedef/BeatStatusWME.mixInAllowed_redirectConnect:Z
        //    20: aload_3        
        //    21: monitorexit    
        //    22: aload_0        
        //    23: getfield        facade/characters/wmedef/BeatStatusWME.__support:Ljava/beans/PropertyChangeSupport;
        //    26: ldc             "mixInAllowed_redirectConnect"
        //    28: iload_2        
        //    29: iload_1        
        //    30: invokevirtual   java/beans/PropertyChangeSupport.firePropertyChange:(Ljava/lang/String;ZZ)V
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
    
    public synchronized boolean getMixInAllowed_object() {
        return this.mixInAllowed_object;
    }
    
    public void setMixInAllowed_object(final boolean p0) {
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
        //    11: getfield        facade/characters/wmedef/BeatStatusWME.mixInAllowed_object:Z
        //    14: istore_2       
        //    15: aload_0        
        //    16: iload_1        
        //    17: putfield        facade/characters/wmedef/BeatStatusWME.mixInAllowed_object:Z
        //    20: aload_3        
        //    21: monitorexit    
        //    22: aload_0        
        //    23: getfield        facade/characters/wmedef/BeatStatusWME.__support:Ljava/beans/PropertyChangeSupport;
        //    26: ldc             "mixInAllowed_object"
        //    28: iload_2        
        //    29: iload_1        
        //    30: invokevirtual   java/beans/PropertyChangeSupport.firePropertyChange:(Ljava/lang/String;ZZ)V
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
    
    public synchronized boolean getMixInAllowed_DA() {
        return this.mixInAllowed_DA;
    }
    
    public void setMixInAllowed_DA(final boolean p0) {
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
        //    10: iload_1        
        //    11: istore_2       
        //    12: aload_0        
        //    13: iload_1        
        //    14: putfield        facade/characters/wmedef/BeatStatusWME.mixInAllowed_DA:Z
        //    17: aload_3        
        //    18: monitorexit    
        //    19: aload_0        
        //    20: getfield        facade/characters/wmedef/BeatStatusWME.__support:Ljava/beans/PropertyChangeSupport;
        //    23: ldc             "mixInAllowed_DA"
        //    25: iload_2        
        //    26: iload_1        
        //    27: invokevirtual   java/beans/PropertyChangeSupport.firePropertyChange:(Ljava/lang/String;ZZ)V
        //    30: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  3      5      3      6      Any
        //  10     19     3      6      Any
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
    
    public synchronized boolean getMixInAllowed_deflect() {
        return this.mixInAllowed_deflect;
    }
    
    public void setMixInAllowed_deflect(final boolean p0) {
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
        //    11: getfield        facade/characters/wmedef/BeatStatusWME.mixInAllowed_deflect:Z
        //    14: istore_2       
        //    15: aload_0        
        //    16: iload_1        
        //    17: putfield        facade/characters/wmedef/BeatStatusWME.mixInAllowed_deflect:Z
        //    20: aload_3        
        //    21: monitorexit    
        //    22: aload_0        
        //    23: getfield        facade/characters/wmedef/BeatStatusWME.__support:Ljava/beans/PropertyChangeSupport;
        //    26: ldc             "mixInAllowed_deflect"
        //    28: iload_2        
        //    29: iload_1        
        //    30: invokevirtual   java/beans/PropertyChangeSupport.firePropertyChange:(Ljava/lang/String;ZZ)V
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
    
    public synchronized boolean getMixInAllowed_pattern() {
        return this.mixInAllowed_pattern;
    }
    
    public void setMixInAllowed_pattern(final boolean p0) {
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
        //    11: getfield        facade/characters/wmedef/BeatStatusWME.mixInAllowed_pattern:Z
        //    14: istore_2       
        //    15: aload_0        
        //    16: iload_1        
        //    17: putfield        facade/characters/wmedef/BeatStatusWME.mixInAllowed_pattern:Z
        //    20: aload_3        
        //    21: monitorexit    
        //    22: aload_0        
        //    23: getfield        facade/characters/wmedef/BeatStatusWME.__support:Ljava/beans/PropertyChangeSupport;
        //    26: ldc             "mixInAllowed_pattern"
        //    28: iload_2        
        //    29: iload_1        
        //    30: invokevirtual   java/beans/PropertyChangeSupport.firePropertyChange:(Ljava/lang/String;ZZ)V
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
    
    public synchronized boolean getMixInAllowed_ltb() {
        return this.mixInAllowed_ltb;
    }
    
    public void setMixInAllowed_ltb(final boolean p0) {
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
        //    11: getfield        facade/characters/wmedef/BeatStatusWME.mixInAllowed_ltb:Z
        //    14: istore_2       
        //    15: aload_0        
        //    16: iload_1        
        //    17: putfield        facade/characters/wmedef/BeatStatusWME.mixInAllowed_ltb:Z
        //    20: aload_3        
        //    21: monitorexit    
        //    22: aload_0        
        //    23: getfield        facade/characters/wmedef/BeatStatusWME.__support:Ljava/beans/PropertyChangeSupport;
        //    26: ldc             "mixInAllowed_ltb"
        //    28: iload_2        
        //    29: iload_1        
        //    30: invokevirtual   java/beans/PropertyChangeSupport.firePropertyChange:(Ljava/lang/String;ZZ)V
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
    
    public synchronized int[] getDisallowedPushTooFarObjects() {
        final Iterator<Integer> iterator = this.disallowedPushTooFarObjects.iterator();
        final int[] array = new int[this.disallowedPushTooFarObjects.size()];
        int n = 0;
        while (iterator.hasNext()) {
            array[n++] = iterator.next();
        }
        return array;
    }
    
    public synchronized void addDisallowedPushTooFarObject(final int n) {
        this.disallowedPushTooFarObjects.add(new Integer(n));
    }
    
    public synchronized void deleteDisallowedPushTooFarObject(final int n) {
        this.disallowedPushTooFarObjects.remove(new Integer(n));
    }
    
    public synchronized void clearDisallowedPushTooFarObjects() {
        this.disallowedPushTooFarObjects.clear();
    }
    
    private final /* synthetic */ void this() {
        this.bTxningOut = false;
        this.mixInAllowed_pushTooFar = true;
        this.mixInAllowed_satellite = true;
        this.mixInAllowed_redirectConnect = true;
        this.mixInAllowed_object = true;
        this.mixInAllowed_DA = true;
        this.mixInAllowed_deflect = true;
        this.mixInAllowed_pattern = true;
        this.mixInAllowed_ltb = true;
        this.disallowedPushTooFarObjects = new ArrayList();
    }
    
    public BeatStatusWME(final int status, final boolean bCommitPointReached, final boolean bGistPointReached) {
        this.this();
        this.status = status;
        this.curBGSig = "none";
        this.abortReason = -1;
        this.bCommitPointReached = bCommitPointReached;
        this.bGistPointReached = bGistPointReached;
    }
    
    public BeatStatusWME(final int status, final boolean bCommitPointReached, final boolean bGistPointReached, final boolean bTxningOut, final boolean mixInAllowed_pushTooFar, final boolean mixInAllowed_satellite, final boolean mixInAllowed_redirectConnect, final boolean mixInAllowed_object, final boolean mixInAllowed_DA, final boolean mixInAllowed_deflect, final boolean mixInAllowed_pattern) {
        this.this();
        this.status = status;
        this.curBGSig = "none";
        this.bCommitPointReached = bCommitPointReached;
        this.bGistPointReached = bGistPointReached;
        this.bTxningOut = bTxningOut;
        this.abortReason = -1;
        this.mixInAllowed_pushTooFar = mixInAllowed_pushTooFar;
        this.mixInAllowed_satellite = mixInAllowed_satellite;
        this.mixInAllowed_redirectConnect = mixInAllowed_redirectConnect;
        this.mixInAllowed_object = mixInAllowed_object;
        this.mixInAllowed_DA = mixInAllowed_DA;
        this.mixInAllowed_deflect = mixInAllowed_deflect;
        this.mixInAllowed_pattern = mixInAllowed_pattern;
        this.mixInAllowed_ltb = true;
    }
    
    public BeatStatusWME() {
        this.this();
    }
}
