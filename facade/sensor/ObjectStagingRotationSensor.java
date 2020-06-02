package facade.sensor;

import wm.WME;
import facade.characters.wmedef.ObjectStagingRotationWME;
import abl.runtime.BehavingEntity;
import facade.nativeinterface.NativeAnimationInterface;
import facade.util.ObjectSensePacket;
import facade.util.Point3D;
import java.util.Hashtable;
import facade.util.SpriteID;

public class ObjectStagingRotationSensor extends FacadeSensor implements SpriteID
{
    protected static final float tolerance = 0.1f;
    private Hashtable lastRotations;
    private static final /* synthetic */ boolean $noassert;
    
    protected boolean changed(final int p0, final Point3D p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: aload_3        
        //     4: monitorexit    
        //     5: athrow         
        //     6: aload_0        
        //     7: getfield        facade/sensor/ObjectStagingRotationSensor.lastRotations:Ljava/util/Hashtable;
        //    10: dup            
        //    11: astore_3       
        //    12: monitorenter   
        //    13: aload_0        
        //    14: getfield        facade/sensor/ObjectStagingRotationSensor.lastRotations:Ljava/util/Hashtable;
        //    17: new             Ljava/lang/Integer;
        //    20: dup            
        //    21: iload_1        
        //    22: invokespecial   java/lang/Integer.<init>:(I)V
        //    25: invokevirtual   java/util/Hashtable.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    28: checkcast       Lfacade/util/Point3D;
        //    31: astore          6
        //    33: aload           6
        //    35: ifnull          142
        //    38: aload_2        
        //    39: getfield        facade/util/Point3D.x:F
        //    42: aload           6
        //    44: getfield        facade/util/Point3D.x:F
        //    47: fsub           
        //    48: ldc             0.1
        //    50: fcmpl          
        //    51: ifgt            134
        //    54: aload           6
        //    56: getfield        facade/util/Point3D.x:F
        //    59: aload_2        
        //    60: getfield        facade/util/Point3D.x:F
        //    63: fsub           
        //    64: ldc             0.1
        //    66: fcmpl          
        //    67: ifgt            134
        //    70: aload_2        
        //    71: getfield        facade/util/Point3D.y:F
        //    74: aload           6
        //    76: getfield        facade/util/Point3D.y:F
        //    79: fsub           
        //    80: ldc             0.1
        //    82: fcmpl          
        //    83: ifgt            134
        //    86: aload           6
        //    88: getfield        facade/util/Point3D.y:F
        //    91: aload_2        
        //    92: getfield        facade/util/Point3D.y:F
        //    95: fsub           
        //    96: ldc             0.1
        //    98: fcmpl          
        //    99: ifgt            134
        //   102: aload_2        
        //   103: getfield        facade/util/Point3D.z:F
        //   106: aload           6
        //   108: getfield        facade/util/Point3D.z:F
        //   111: fsub           
        //   112: ldc             0.1
        //   114: fcmpl          
        //   115: ifgt            134
        //   118: aload           6
        //   120: getfield        facade/util/Point3D.z:F
        //   123: aload_2        
        //   124: getfield        facade/util/Point3D.z:F
        //   127: fsub           
        //   128: ldc             0.1
        //   130: fcmpl          
        //   131: ifle            138
        //   134: iconst_1       
        //   135: aload_3        
        //   136: monitorexit    
        //   137: ireturn        
        //   138: iconst_0       
        //   139: aload_3        
        //   140: monitorexit    
        //   141: ireturn        
        //   142: iconst_1       
        //   143: aload_3        
        //   144: monitorexit    
        //   145: ireturn        
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  3      5      3      6      Any
        //  142    145    3      6      Any
        //  138    141    3      6      Any
        //  13     137    3      6      Any
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
    
    public void senseOneShot(final Object[] array) {
        if (!ObjectStagingRotationSensor.$noassert && array != null && array.length != 0) {
            throw new AssertionError((Object)"args.length == 0 in ObjectStagingRotationSensor.senseOneShot()");
        }
        final ObjectSensePacket objectSensePacket = new ObjectSensePacket();
        NativeAnimationInterface.getAllObjectStagingRotations(objectSensePacket);
        this.deleteAllOldWMEs();
        this.addAllRotationWMEs(objectSensePacket);
    }
    
    private final void addAllRotationWMEs(final ObjectSensePacket objectSensePacket) {
        for (int i = 0; i < objectSensePacket.info.length; ++i) {
            BehavingEntity.getBehavingEntity().addWME(new ObjectStagingRotationWME(objectSensePacket.info[i].objectID, objectSensePacket.info[i].x, objectSensePacket.info[i].y, objectSensePacket.info[i].z));
        }
    }
    
    private final synchronized void deleteOldWMEs(final int n) {
        final Object[] array = BehavingEntity.getBehavingEntity().lookupWME("ObjectStagingRotationWME").toArray();
        for (int i = 0; i < array.length; ++i) {
            if (((ObjectStagingRotationWME)array[i]).getObjectID() == n) {
                BehavingEntity.getBehavingEntity().deleteWME((WME)array[i]);
            }
        }
    }
    
    private final synchronized void deleteAllOldWMEs() {
        final Object[] array = BehavingEntity.getBehavingEntity().lookupWME("ObjectStagingRotationWME").toArray();
        for (int i = 0; i < array.length; ++i) {
            BehavingEntity.getBehavingEntity().deleteWME((WME)array[i]);
        }
    }
    
    public void initializeContinuous(final Object[] array) {
        if (!ObjectStagingRotationSensor.$noassert && array != null && array.length != 0) {
            throw new AssertionError((Object)"args.length == 0 in ObjectStagingRotationSensor.senseOneShot()");
        }
        final ObjectSensePacket objectSensePacket = new ObjectSensePacket();
        NativeAnimationInterface.getAllObjectStagingRotations(objectSensePacket);
        this.deleteAllOldWMEs();
        this.addAllRotationWMEs(objectSensePacket);
        this.updateLastRotations(objectSensePacket);
    }
    
    private final void updateLastRotations(final ObjectSensePacket p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: aload_2        
        //     4: monitorexit    
        //     5: athrow         
        //     6: aload_0        
        //     7: getfield        facade/sensor/ObjectStagingRotationSensor.lastRotations:Ljava/util/Hashtable;
        //    10: dup            
        //    11: astore_2       
        //    12: monitorenter   
        //    13: iconst_0       
        //    14: istore          4
        //    16: goto            98
        //    19: new             Ljava/lang/Integer;
        //    22: dup            
        //    23: aload_1        
        //    24: getfield        facade/util/ObjectSensePacket.info:[Lfacade/util/ObjectSensePacket$ObjectSenseInfo;
        //    27: iload           4
        //    29: aaload         
        //    30: getfield        facade/util/ObjectSensePacket$ObjectSenseInfo.objectID:I
        //    33: invokespecial   java/lang/Integer.<init>:(I)V
        //    36: astore          5
        //    38: aload_0        
        //    39: getfield        facade/sensor/ObjectStagingRotationSensor.lastRotations:Ljava/util/Hashtable;
        //    42: aload           5
        //    44: invokevirtual   java/util/Hashtable.remove:(Ljava/lang/Object;)Ljava/lang/Object;
        //    47: pop            
        //    48: aload_0        
        //    49: getfield        facade/sensor/ObjectStagingRotationSensor.lastRotations:Ljava/util/Hashtable;
        //    52: aload           5
        //    54: new             Lfacade/util/Point3D;
        //    57: dup            
        //    58: aload_1        
        //    59: getfield        facade/util/ObjectSensePacket.info:[Lfacade/util/ObjectSensePacket$ObjectSenseInfo;
        //    62: iload           4
        //    64: aaload         
        //    65: getfield        facade/util/ObjectSensePacket$ObjectSenseInfo.x:F
        //    68: aload_1        
        //    69: getfield        facade/util/ObjectSensePacket.info:[Lfacade/util/ObjectSensePacket$ObjectSenseInfo;
        //    72: iload           4
        //    74: aaload         
        //    75: getfield        facade/util/ObjectSensePacket$ObjectSenseInfo.y:F
        //    78: aload_1        
        //    79: getfield        facade/util/ObjectSensePacket.info:[Lfacade/util/ObjectSensePacket$ObjectSenseInfo;
        //    82: iload           4
        //    84: aaload         
        //    85: getfield        facade/util/ObjectSensePacket$ObjectSenseInfo.z:F
        //    88: invokespecial   facade/util/Point3D.<init>:(FFF)V
        //    91: invokevirtual   java/util/Hashtable.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    94: pop            
        //    95: iinc            4, 1
        //    98: iload           4
        //   100: aload_1        
        //   101: getfield        facade/util/ObjectSensePacket.info:[Lfacade/util/ObjectSensePacket$ObjectSenseInfo;
        //   104: arraylength    
        //   105: if_icmplt       19
        //   108: aload_2        
        //   109: monitorexit    
        //   110: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  3      5      3      6      Any
        //  13     110    3      6      Any
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
    
    private final void updateLastRotationsConditionally(final ObjectSensePacket p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: istore_2       
        //     2: goto            164
        //     5: new             Lfacade/util/Point3D;
        //     8: dup            
        //     9: aload_1        
        //    10: getfield        facade/util/ObjectSensePacket.info:[Lfacade/util/ObjectSensePacket$ObjectSenseInfo;
        //    13: iload_2        
        //    14: aaload         
        //    15: getfield        facade/util/ObjectSensePacket$ObjectSenseInfo.x:F
        //    18: aload_1        
        //    19: getfield        facade/util/ObjectSensePacket.info:[Lfacade/util/ObjectSensePacket$ObjectSenseInfo;
        //    22: iload_2        
        //    23: aaload         
        //    24: getfield        facade/util/ObjectSensePacket$ObjectSenseInfo.y:F
        //    27: aload_1        
        //    28: getfield        facade/util/ObjectSensePacket.info:[Lfacade/util/ObjectSensePacket$ObjectSenseInfo;
        //    31: iload_2        
        //    32: aaload         
        //    33: getfield        facade/util/ObjectSensePacket$ObjectSenseInfo.z:F
        //    36: invokespecial   facade/util/Point3D.<init>:(FFF)V
        //    39: astore_3       
        //    40: aload_0        
        //    41: aload_1        
        //    42: getfield        facade/util/ObjectSensePacket.info:[Lfacade/util/ObjectSensePacket$ObjectSenseInfo;
        //    45: iload_2        
        //    46: aaload         
        //    47: getfield        facade/util/ObjectSensePacket$ObjectSenseInfo.objectID:I
        //    50: aload_3        
        //    51: invokevirtual   facade/sensor/ObjectStagingRotationSensor.changed:(ILfacade/util/Point3D;)Z
        //    54: ifeq            161
        //    57: aload_0        
        //    58: aload_1        
        //    59: getfield        facade/util/ObjectSensePacket.info:[Lfacade/util/ObjectSensePacket$ObjectSenseInfo;
        //    62: iload_2        
        //    63: aaload         
        //    64: getfield        facade/util/ObjectSensePacket$ObjectSenseInfo.objectID:I
        //    67: invokespecial   facade/sensor/ObjectStagingRotationSensor.deleteOldWMEs:(I)V
        //    70: invokestatic    abl/runtime/BehavingEntity.getBehavingEntity:()Labl/runtime/BehavingEntity;
        //    73: new             Lfacade/characters/wmedef/ObjectStagingRotationWME;
        //    76: dup            
        //    77: aload_1        
        //    78: getfield        facade/util/ObjectSensePacket.info:[Lfacade/util/ObjectSensePacket$ObjectSenseInfo;
        //    81: iload_2        
        //    82: aaload         
        //    83: getfield        facade/util/ObjectSensePacket$ObjectSenseInfo.objectID:I
        //    86: aload_3        
        //    87: getfield        facade/util/Point3D.x:F
        //    90: aload_3        
        //    91: getfield        facade/util/Point3D.y:F
        //    94: aload_3        
        //    95: getfield        facade/util/Point3D.z:F
        //    98: invokespecial   facade/characters/wmedef/ObjectStagingRotationWME.<init>:(IFFF)V
        //   101: invokevirtual   abl/runtime/BehavingEntity.addWME:(Lwm/WME;)V
        //   104: goto            111
        //   107: aload           4
        //   109: monitorexit    
        //   110: athrow         
        //   111: aload_0        
        //   112: getfield        facade/sensor/ObjectStagingRotationSensor.lastRotations:Ljava/util/Hashtable;
        //   115: dup            
        //   116: astore          4
        //   118: monitorenter   
        //   119: new             Ljava/lang/Integer;
        //   122: dup            
        //   123: aload_1        
        //   124: getfield        facade/util/ObjectSensePacket.info:[Lfacade/util/ObjectSensePacket$ObjectSenseInfo;
        //   127: iload_2        
        //   128: aaload         
        //   129: getfield        facade/util/ObjectSensePacket$ObjectSenseInfo.objectID:I
        //   132: invokespecial   java/lang/Integer.<init>:(I)V
        //   135: astore          6
        //   137: aload_0        
        //   138: getfield        facade/sensor/ObjectStagingRotationSensor.lastRotations:Ljava/util/Hashtable;
        //   141: aload           6
        //   143: invokevirtual   java/util/Hashtable.remove:(Ljava/lang/Object;)Ljava/lang/Object;
        //   146: pop            
        //   147: aload_0        
        //   148: getfield        facade/sensor/ObjectStagingRotationSensor.lastRotations:Ljava/util/Hashtable;
        //   151: aload           6
        //   153: aload_3        
        //   154: invokevirtual   java/util/Hashtable.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   157: pop            
        //   158: aload           4
        //   160: monitorexit    
        //   161: iinc            2, 1
        //   164: iload_2        
        //   165: aload_1        
        //   166: getfield        facade/util/ObjectSensePacket.info:[Lfacade/util/ObjectSensePacket$ObjectSenseInfo;
        //   169: arraylength    
        //   170: if_icmplt       5
        //   173: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  107    110    107    111    Any
        //  119    161    107    111    Any
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
    
    public void senseContinuous(final Object[] array) {
        if (!ObjectStagingRotationSensor.$noassert && array != null && array.length != 0) {
            throw new AssertionError((Object)"args.length == 0 in ObjectStagingRotationSensor.senseOneShot()");
        }
        final ObjectSensePacket objectSensePacket = new ObjectSensePacket();
        NativeAnimationInterface.getAllObjectStagingRotations(objectSensePacket);
        this.updateLastRotationsConditionally(objectSensePacket);
    }
    
    private final /* synthetic */ void this() {
        this.lastRotations = new Hashtable();
    }
    
    public ObjectStagingRotationSensor() {
        this.this();
    }
    
    static {
        $noassert = (Class.forName("[Lfacade.sensor.ObjectStagingRotationSensor;").getComponentType().desiredAssertionStatus() ^ true);
    }
}
