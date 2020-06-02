package facade;

import facade.characters.wmedef.PostBeatMixinInfoWME;
import facade.characters.wmedef.AnaphoricReferenceWME;
import facade.characters.player.java.Player;
import facade.characters.grace.java.Grace;
import facade.characters.trip.java.Trip;
import facade.util.StringUtil;
import facade.nativeinterface.NativeAnimationInterface;

public class Main
{
    private static final String generateEventLog = "generateEventLog";
    private static final String noEventLog = "noEventLog";
    
    private static final void respondToError(final Throwable t, final boolean b) {
        NativeAnimationInterface.addEventInfoToLog(t.toString());
        StringUtil.println(t.toString());
        if (b) {
            System.exit(1);
        }
    }
    
    public static void main(final String[] p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: arraylength    
        //     2: ifle            19
        //     5: aload_0        
        //     6: iconst_0       
        //     7: aaload         
        //     8: ldc             "generateEventLog"
        //    10: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    13: ifeq            19
        //    16: invokestatic    facade/util/StringUtil.setGenerateEventLog:()V
        //    19: new             Lwm/WorkingMemory;
        //    22: dup            
        //    23: ldc             "BeatMemory"
        //    25: invokespecial   wm/WorkingMemory.<init>:(Ljava/lang/String;)V
        //    28: astore_1       
        //    29: new             Ldramaman/runtime/DramaManager;
        //    32: dup            
        //    33: ldc             "facade.beats"
        //    35: iconst_0       
        //    36: iconst_0       
        //    37: invokespecial   dramaman/runtime/DramaManager.<init>:(Ljava/lang/String;ZZ)V
        //    40: astore_3       
        //    41: new             Lfacade/util/ProvocativeContentArchive;
        //    44: dup            
        //    45: invokespecial   facade/util/ProvocativeContentArchive.<init>:()V
        //    48: astore          4
        //    50: new             Lfacade/util/IntermediateContentArchive;
        //    53: dup            
        //    54: invokespecial   facade/util/IntermediateContentArchive.<init>:()V
        //    57: astore          5
        //    59: new             Lfacade/util/CrisisAccusationMapping;
        //    62: dup            
        //    63: invokespecial   facade/util/CrisisAccusationMapping.<init>:()V
        //    66: astore          6
        //    68: new             Lfacade/util/CrisisCalculus;
        //    71: dup            
        //    72: invokespecial   facade/util/CrisisCalculus.<init>:()V
        //    75: astore          7
        //    77: new             Lfacade/util/TherapyGameState;
        //    80: dup            
        //    81: invokespecial   facade/util/TherapyGameState.<init>:()V
        //    84: astore          8
        //    86: new             Lfacade/util/RawReactionDAArchive;
        //    89: dup            
        //    90: invokespecial   facade/util/RawReactionDAArchive.<init>:()V
        //    93: astore          9
        //    95: invokestatic    facade/util/StringUtil.initializeEventLog:()V
        //    98: new             Lfacade/characters/wmedef/PostBeatMixinInfoWME;
        //   101: dup            
        //   102: invokespecial   facade/characters/wmedef/PostBeatMixinInfoWME.<init>:()V
        //   105: astore          10
        //   107: ldc             "StoryMemory"
        //   109: aload           10
        //   111: invokestatic    wm/WorkingMemory.addWME:(Ljava/lang/String;Lwm/WME;)V
        //   114: new             Lfacade/Main$3PlayerThread;
        //   117: dup            
        //   118: invokespecial   facade/Main$3PlayerThread.<init>:()V
        //   121: astore          11
        //   123: aload           11
        //   125: iconst_5       
        //   126: invokevirtual   facade/Main$3PlayerThread.setPriority:(I)V
        //   129: aload           11
        //   131: invokevirtual   facade/Main$3PlayerThread.start:()V
        //   134: goto            141
        //   137: aload           12
        //   139: monitorexit    
        //   140: athrow         
        //   141: aload           11
        //   143: dup            
        //   144: astore          12
        //   146: monitorenter   
        //   147: aload           11
        //   149: invokevirtual   java/lang/Object.wait:()V
        //   152: aload           12
        //   154: monitorexit    
        //   155: new             Lfacade/Main$1TripThread;
        //   158: dup            
        //   159: invokespecial   facade/Main$1TripThread.<init>:()V
        //   162: astore          14
        //   164: aload           14
        //   166: iconst_5       
        //   167: invokevirtual   facade/Main$1TripThread.setPriority:(I)V
        //   170: aload           14
        //   172: invokevirtual   facade/Main$1TripThread.start:()V
        //   175: goto            182
        //   178: aload           12
        //   180: monitorexit    
        //   181: athrow         
        //   182: aload           14
        //   184: dup            
        //   185: astore          12
        //   187: monitorenter   
        //   188: aload           14
        //   190: invokevirtual   java/lang/Object.wait:()V
        //   193: aload           12
        //   195: monitorexit    
        //   196: new             Lfacade/Main$2GraceThread;
        //   199: dup            
        //   200: invokespecial   facade/Main$2GraceThread.<init>:()V
        //   203: astore          15
        //   205: aload           15
        //   207: iconst_5       
        //   208: invokevirtual   facade/Main$2GraceThread.setPriority:(I)V
        //   211: aload           15
        //   213: invokevirtual   facade/Main$2GraceThread.start:()V
        //   216: goto            223
        //   219: aload           12
        //   221: monitorexit    
        //   222: athrow         
        //   223: aload           15
        //   225: dup            
        //   226: astore          12
        //   228: monitorenter   
        //   229: aload           15
        //   231: invokevirtual   java/lang/Object.wait:()V
        //   234: aload           12
        //   236: monitorexit    
        //   237: new             Lfacade/characters/wmedef/AnaphoricReferenceWME;
        //   240: dup            
        //   241: invokespecial   facade/characters/wmedef/AnaphoricReferenceWME.<init>:()V
        //   244: astore          16
        //   246: ldc             "StoryMemory"
        //   248: aload           16
        //   250: invokestatic    wm/WorkingMemory.addWME:(Ljava/lang/String;Lwm/WME;)V
        //   253: new             Lfacade/Main$4NluTemplateThread;
        //   256: dup            
        //   257: aload           16
        //   259: aload           10
        //   261: invokespecial   facade/Main$4NluTemplateThread.<init>:(Lfacade/characters/wmedef/AnaphoricReferenceWME;Lfacade/characters/wmedef/PostBeatMixinInfoWME;)V
        //   264: astore          17
        //   266: aload           17
        //   268: bipush          6
        //   270: invokevirtual   facade/Main$4NluTemplateThread.setPriority:(I)V
        //   273: aload           17
        //   275: invokevirtual   facade/Main$4NluTemplateThread.start:()V
        //   278: goto            285
        //   281: aload           12
        //   283: monitorexit    
        //   284: athrow         
        //   285: aload           17
        //   287: dup            
        //   288: astore          12
        //   290: monitorenter   
        //   291: aload           17
        //   293: invokevirtual   java/lang/Object.wait:()V
        //   296: aload           12
        //   298: monitorexit    
        //   299: goto            329
        //   302: astore          10
        //   304: new             Labl/runtime/RuntimeError;
        //   307: dup            
        //   308: new             Ljava/lang/StringBuffer;
        //   311: dup            
        //   312: ldc             "Wait interrupted "
        //   314: invokespecial   java/lang/StringBuffer.<init>:(Ljava/lang/String;)V
        //   317: aload           10
        //   319: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/Object;)Ljava/lang/StringBuffer;
        //   322: invokevirtual   java/lang/StringBuffer.toString:()Ljava/lang/String;
        //   325: invokespecial   abl/runtime/RuntimeError.<init>:(Ljava/lang/String;)V
        //   328: athrow         
        //   329: goto            338
        //   332: astore_1       
        //   333: aload_1        
        //   334: iconst_1       
        //   335: invokestatic    facade/Main.respondToError:(Ljava/lang/Throwable;Z)V
        //   338: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                            
        //  -----  -----  -----  -----  --------------------------------
        //  137    140    137    141    Any
        //  147    155    137    141    Any
        //  178    181    178    182    Any
        //  188    196    178    182    Any
        //  219    222    219    223    Any
        //  229    237    219    223    Any
        //  281    284    281    285    Any
        //  291    299    281    285    Any
        //  95     299    302    329    Ljava/lang/InterruptedException;
        //  19     329    332    338    Ljava/lang/Throwable;
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
    
    class TripThread extends Thread
    {
        private Trip trip;
        
        public void run() {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: new             Lfacade/characters/trip/java/Trip;
            //     4: dup            
            //     5: invokespecial   facade/characters/trip/java/Trip.<init>:()V
            //     8: putfield        facade/Main$1TripThread.trip:Lfacade/characters/trip/java/Trip;
            //    11: goto            17
            //    14: aload_1        
            //    15: monitorexit    
            //    16: athrow         
            //    17: aload_0        
            //    18: dup            
            //    19: astore_1       
            //    20: monitorenter   
            //    21: aload_0        
            //    22: invokevirtual   java/lang/Object.notify:()V
            //    25: aload_1        
            //    26: monitorexit    
            //    27: aload_0        
            //    28: getfield        facade/Main$1TripThread.trip:Lfacade/characters/trip/java/Trip;
            //    31: invokevirtual   facade/characters/trip/java/Trip.startBehaving:()V
            //    34: goto            43
            //    37: astore_1       
            //    38: aload_1        
            //    39: iconst_1       
            //    40: invokestatic    facade/Main.access$0:(Ljava/lang/Throwable;Z)V
            //    43: return         
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type             
            //  -----  -----  -----  -----  -----------------
            //  14     16     14     17     Any
            //  21     27     14     17     Any
            //  0      34     37     43     Ljava/lang/Error;
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
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:576)
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
    
    class GraceThread extends Thread
    {
        private Grace grace;
        
        public void run() {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: new             Lfacade/characters/grace/java/Grace;
            //     4: dup            
            //     5: invokespecial   facade/characters/grace/java/Grace.<init>:()V
            //     8: putfield        facade/Main$2GraceThread.grace:Lfacade/characters/grace/java/Grace;
            //    11: goto            17
            //    14: aload_1        
            //    15: monitorexit    
            //    16: athrow         
            //    17: aload_0        
            //    18: dup            
            //    19: astore_1       
            //    20: monitorenter   
            //    21: aload_0        
            //    22: invokevirtual   java/lang/Object.notify:()V
            //    25: aload_1        
            //    26: monitorexit    
            //    27: aload_0        
            //    28: getfield        facade/Main$2GraceThread.grace:Lfacade/characters/grace/java/Grace;
            //    31: invokevirtual   facade/characters/grace/java/Grace.startBehaving:()V
            //    34: goto            43
            //    37: astore_1       
            //    38: aload_1        
            //    39: iconst_1       
            //    40: invokestatic    facade/Main.access$0:(Ljava/lang/Throwable;Z)V
            //    43: return         
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type             
            //  -----  -----  -----  -----  -----------------
            //  14     16     14     17     Any
            //  21     27     14     17     Any
            //  0      34     37     43     Ljava/lang/Error;
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
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:576)
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
    
    class PlayerThread extends Thread
    {
        private Player player;
        
        public void run() {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: new             Lfacade/characters/player/java/Player;
            //     4: dup            
            //     5: invokespecial   facade/characters/player/java/Player.<init>:()V
            //     8: putfield        facade/Main$3PlayerThread.player:Lfacade/characters/player/java/Player;
            //    11: goto            17
            //    14: aload_1        
            //    15: monitorexit    
            //    16: athrow         
            //    17: aload_0        
            //    18: dup            
            //    19: astore_1       
            //    20: monitorenter   
            //    21: aload_0        
            //    22: invokevirtual   java/lang/Object.notify:()V
            //    25: aload_1        
            //    26: monitorexit    
            //    27: aload_0        
            //    28: getfield        facade/Main$3PlayerThread.player:Lfacade/characters/player/java/Player;
            //    31: invokevirtual   facade/characters/player/java/Player.startBehaving:()V
            //    34: goto            43
            //    37: astore_1       
            //    38: aload_1        
            //    39: iconst_1       
            //    40: invokestatic    facade/Main.access$0:(Ljava/lang/Throwable;Z)V
            //    43: return         
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type             
            //  -----  -----  -----  -----  -----------------
            //  14     16     14     17     Any
            //  21     27     14     17     Any
            //  0      34     37     43     Ljava/lang/Error;
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
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:576)
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
    
    class NluTemplateThread extends Thread
    {
        private final AnaphoricReferenceWME anaphoricRefWME;
        private final PostBeatMixinInfoWME postBeatMixinWME;
        
        public void run() {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     3: dup            
            //     4: ldc             "general.rul"
            //     6: ldc             "general.map"
            //     8: ldc             "DummyBeat"
            //    10: aload_0        
            //    11: getfield        facade/Main$4NluTemplateThread.anaphoricRefWME:Lfacade/characters/wmedef/AnaphoricReferenceWME;
            //    14: aload_0        
            //    15: getfield        facade/Main$4NluTemplateThread.postBeatMixinWME:Lfacade/characters/wmedef/PostBeatMixinInfoWME;
            //    18: invokespecial   TemplateCompiler/NLUMain.<init>:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lfacade/characters/wmedef/AnaphoricReferenceWME;Lfacade/characters/wmedef/PostBeatMixinInfoWME;)V
            //    21: astore_1       
            //    22: goto            28
            //    25: aload_2        
            //    26: monitorexit    
            //    27: athrow         
            //    28: aload_0        
            //    29: dup            
            //    30: astore_2       
            //    31: monitorenter   
            //    32: aload_0        
            //    33: invokevirtual   java/lang/Object.notify:()V
            //    36: aload_2        
            //    37: monitorexit    
            //    38: aload_1        
            //    39: invokevirtual   TemplateCompiler/NLUMain.startNLU:()V
            //    42: goto            60
            //    45: astore_1       
            //    46: aload_1        
            //    47: iconst_1       
            //    48: invokestatic    facade/Main.access$0:(Ljava/lang/Throwable;Z)V
            //    51: goto            60
            //    54: astore_1       
            //    55: aload_1        
            //    56: iconst_0       
            //    57: invokestatic    facade/Main.access$0:(Ljava/lang/Throwable;Z)V
            //    60: return         
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                        
            //  -----  -----  -----  -----  ----------------------------
            //  25     27     25     28     Any
            //  32     38     25     28     Any
            //  0      42     45     54     Ljava/lang/Error;
            //  0      42     54     60     Ljava/lang/RuntimeException;
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
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:576)
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
        
        NluTemplateThread(final AnaphoricReferenceWME anaphoricRefWME, final PostBeatMixinInfoWME postBeatMixinWME) {
            this.anaphoricRefWME = anaphoricRefWME;
            this.postBeatMixinWME = postBeatMixinWME;
        }
    }
}
