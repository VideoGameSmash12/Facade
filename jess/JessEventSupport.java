package jess;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.Serializable;

class JessEventSupport implements Serializable
{
    private List m_listeners;
    private int m_eventMask;
    
    public void addJessListener(final JessListener jessListener) {
        this.m_listeners.add(jessListener);
    }
    
    public void removeJessListener(final JessListener jessListener) {
        this.m_listeners.remove(jessListener);
    }
    
    public Iterator listJessListeners() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: aload_1        
        //     4: monitorexit    
        //     5: athrow         
        //     6: aload_0        
        //     7: getfield        jess/JessEventSupport.m_listeners:Ljava/util/List;
        //    10: dup            
        //    11: astore_1       
        //    12: monitorenter   
        //    13: new             Ljava/util/ArrayList;
        //    16: dup            
        //    17: aload_0        
        //    18: getfield        jess/JessEventSupport.m_listeners:Ljava/util/List;
        //    21: invokespecial   java/util/ArrayList.<init>:(Ljava/util/Collection;)V
        //    24: invokevirtual   java/util/ArrayList.iterator:()Ljava/util/Iterator;
        //    27: aload_1        
        //    28: monitorexit    
        //    29: areturn        
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  3      5      3      6      Any
        //  13     29     3      6      Any
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
    
    public synchronized int getEventMask() {
        return this.m_eventMask;
    }
    
    public synchronized void setEventMask(final int eventMask) {
        this.m_eventMask = eventMask;
    }
    
    final void broadcastEvent(final Object p0, final int p1, final Object p2) throws JessException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_0        
        //     2: invokevirtual   jess/JessEventSupport.getEventMask:()I
        //     5: iand           
        //     6: ifne            10
        //     9: return         
        //    10: goto            17
        //    13: aload           6
        //    15: monitorexit    
        //    16: athrow         
        //    17: aload_0        
        //    18: getfield        jess/JessEventSupport.m_listeners:Ljava/util/List;
        //    21: dup            
        //    22: astore          6
        //    24: monitorenter   
        //    25: aload_0        
        //    26: getfield        jess/JessEventSupport.m_listeners:Ljava/util/List;
        //    29: invokeinterface java/util/List.size:()I
        //    34: dup            
        //    35: istore          5
        //    37: ifne            44
        //    40: aload           6
        //    42: monitorexit    
        //    43: return         
        //    44: new             Ljava/util/ArrayList;
        //    47: dup            
        //    48: aload_0        
        //    49: getfield        jess/JessEventSupport.m_listeners:Ljava/util/List;
        //    52: invokespecial   java/util/ArrayList.<init>:(Ljava/util/Collection;)V
        //    55: astore          4
        //    57: aload           6
        //    59: monitorexit    
        //    60: iconst_0       
        //    61: istore          8
        //    63: goto            122
        //    66: new             Ljess/JessEvent;
        //    69: dup            
        //    70: aload_1        
        //    71: iload_2        
        //    72: aload_3        
        //    73: invokespecial   jess/JessEvent.<init>:(Ljava/lang/Object;ILjava/lang/Object;)V
        //    76: astore          9
        //    78: aload           4
        //    80: iload           8
        //    82: invokevirtual   java/util/ArrayList.get:(I)Ljava/lang/Object;
        //    85: checkcast       Ljess/JessListener;
        //    88: aload           9
        //    90: invokeinterface jess/JessListener.eventHappened:(Ljess/JessEvent;)V
        //    95: goto            119
        //    98: astore          9
        //   100: aload           9
        //   102: athrow         
        //   103: astore          9
        //   105: new             Ljess/JessException;
        //   108: dup            
        //   109: ldc             "JessEventSupport.broadcastEvent"
        //   111: ldc             "Event handler threw an exception"
        //   113: aload           9
        //   115: invokespecial   jess/JessException.<init>:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   118: athrow         
        //   119: iinc            8, 1
        //   122: iload           8
        //   124: iload           5
        //   126: if_icmplt       66
        //   129: return         
        //    Exceptions:
        //  throws jess.JessException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  13     16     13     17     Any
        //  44     60     13     17     Any
        //  25     43     13     17     Any
        //  66     95     98     103    Ljess/JessException;
        //  66     95     103    119    Ljava/lang/Exception;
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
        this.m_listeners = Collections.synchronizedList(new ArrayList<Object>());
        this.m_eventMask = 0;
    }
    
    JessEventSupport(final Rete rete) {
        this.this();
        this.addJessListener(rete);
    }
}
