package facade.sensor;

import wm.WME;
import facade.characters.wmedef.ObjectPickupRotationWME;
import abl.runtime.BehavingEntity;
import facade.nativeinterface.NativeAnimationInterface;
import facade.util.ObjectSensePacket;
import facade.util.Point3D;
import java.util.Hashtable;
import facade.util.SpriteID;

public abstract class ObjectPickupRotationSensor extends FacadeSensor implements SpriteID
{
    protected static final float tolerance = 0.1f;
    private Hashtable lastRotations;
    
    protected boolean changed(final int p0, final int p1, final Point3D p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: aload           4
        //     5: monitorexit    
        //     6: athrow         
        //     7: aload_0        
        //     8: getfield        facade/sensor/ObjectPickupRotationSensor.lastRotations:Ljava/util/Hashtable;
        //    11: dup            
        //    12: astore          4
        //    14: monitorenter   
        //    15: iload_1        
        //    16: bipush          10
        //    18: iadd           
        //    19: sipush          1000
        //    22: imul           
        //    23: iload_2        
        //    24: bipush          10
        //    26: iadd           
        //    27: iadd           
        //    28: istore          7
        //    30: aload_0        
        //    31: getfield        facade/sensor/ObjectPickupRotationSensor.lastRotations:Ljava/util/Hashtable;
        //    34: new             Ljava/lang/Integer;
        //    37: dup            
        //    38: iload           7
        //    40: invokespecial   java/lang/Integer.<init>:(I)V
        //    43: invokevirtual   java/util/Hashtable.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    46: checkcast       Lfacade/util/Point3D;
        //    49: astore          8
        //    51: aload           8
        //    53: ifnull          162
        //    56: aload_3        
        //    57: getfield        facade/util/Point3D.x:F
        //    60: aload           8
        //    62: getfield        facade/util/Point3D.x:F
        //    65: fsub           
        //    66: ldc             0.1
        //    68: fcmpl          
        //    69: ifgt            152
        //    72: aload           8
        //    74: getfield        facade/util/Point3D.x:F
        //    77: aload_3        
        //    78: getfield        facade/util/Point3D.x:F
        //    81: fsub           
        //    82: ldc             0.1
        //    84: fcmpl          
        //    85: ifgt            152
        //    88: aload_3        
        //    89: getfield        facade/util/Point3D.y:F
        //    92: aload           8
        //    94: getfield        facade/util/Point3D.y:F
        //    97: fsub           
        //    98: ldc             0.1
        //   100: fcmpl          
        //   101: ifgt            152
        //   104: aload           8
        //   106: getfield        facade/util/Point3D.y:F
        //   109: aload_3        
        //   110: getfield        facade/util/Point3D.y:F
        //   113: fsub           
        //   114: ldc             0.1
        //   116: fcmpl          
        //   117: ifgt            152
        //   120: aload_3        
        //   121: getfield        facade/util/Point3D.z:F
        //   124: aload           8
        //   126: getfield        facade/util/Point3D.z:F
        //   129: fsub           
        //   130: ldc             0.1
        //   132: fcmpl          
        //   133: ifgt            152
        //   136: aload           8
        //   138: getfield        facade/util/Point3D.z:F
        //   141: aload_3        
        //   142: getfield        facade/util/Point3D.z:F
        //   145: fsub           
        //   146: ldc             0.1
        //   148: fcmpl          
        //   149: ifle            157
        //   152: iconst_1       
        //   153: aload           4
        //   155: monitorexit    
        //   156: ireturn        
        //   157: iconst_0       
        //   158: aload           4
        //   160: monitorexit    
        //   161: ireturn        
        //   162: iconst_1       
        //   163: aload           4
        //   165: monitorexit    
        //   166: ireturn        
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  3      6      3      7      Any
        //  162    166    3      7      Any
        //  157    161    3      7      Any
        //  15     156    3      7      Any
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
    
    protected void senseOneShot_Utility(final int n) {
        final ObjectSensePacket objectSensePacket = new ObjectSensePacket();
        NativeAnimationInterface.getAllObjectPickupRotations(n, objectSensePacket);
        this.deleteAllOldWMEs(n);
        this.addAllPickupRotationWMEs(n, objectSensePacket);
    }
    
    private final synchronized void deleteAllOldWMEs(final int n) {
        final Object[] array = BehavingEntity.getBehavingEntity().lookupWME("ObjectPickupRotationWME").toArray();
        for (int i = 0; i < array.length; ++i) {
            if (((ObjectPickupRotationWME)array[i]).getCharacterID() == n) {
                BehavingEntity.getBehavingEntity().deleteWME((WME)array[i]);
            }
        }
    }
    
    private final synchronized void deleteOldWMEs(final int n, final int n2) {
        final Object[] array = BehavingEntity.getBehavingEntity().lookupWME("ObjectPickupRotationWME").toArray();
        for (int i = 0; i < array.length; ++i) {
            if (((ObjectPickupRotationWME)array[i]).getObjectID() == n && ((ObjectPickupRotationWME)array[i]).getCharacterID() == n2) {
                BehavingEntity.getBehavingEntity().deleteWME((WME)array[i]);
            }
        }
    }
    
    private final void addAllPickupRotationWMEs(final int n, final ObjectSensePacket objectSensePacket) {
        for (int i = 0; i < objectSensePacket.info.length; ++i) {
            BehavingEntity.getBehavingEntity().addWME(new ObjectPickupRotationWME(objectSensePacket.info[i].objectID, n, objectSensePacket.info[i].x, objectSensePacket.info[i].y, objectSensePacket.info[i].z));
        }
    }
    
    protected void initializeContinuous_Utility(final int n) {
        final ObjectSensePacket objectSensePacket = new ObjectSensePacket();
        NativeAnimationInterface.getAllObjectPickupRotations(n, objectSensePacket);
        this.deleteAllOldWMEs(n);
        this.addAllPickupRotationWMEs(n, objectSensePacket);
        this.updateLastPickupRotations(objectSensePacket);
    }
    
    private final void updateLastPickupRotations(final ObjectSensePacket p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: aload_2        
        //     4: monitorexit    
        //     5: athrow         
        //     6: aload_0        
        //     7: getfield        facade/sensor/ObjectPickupRotationSensor.lastRotations:Ljava/util/Hashtable;
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
        //    39: getfield        facade/sensor/ObjectPickupRotationSensor.lastRotations:Ljava/util/Hashtable;
        //    42: aload           5
        //    44: invokevirtual   java/util/Hashtable.remove:(Ljava/lang/Object;)Ljava/lang/Object;
        //    47: pop            
        //    48: aload_0        
        //    49: getfield        facade/sensor/ObjectPickupRotationSensor.lastRotations:Ljava/util/Hashtable;
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
    
    private final void updateLastPickupRotationsConditionally(final int p0, final ObjectSensePacket p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: istore_3       
        //     2: goto            173
        //     5: new             Lfacade/util/Point3D;
        //     8: dup            
        //     9: aload_2        
        //    10: getfield        facade/util/ObjectSensePacket.info:[Lfacade/util/ObjectSensePacket$ObjectSenseInfo;
        //    13: iload_3        
        //    14: aaload         
        //    15: getfield        facade/util/ObjectSensePacket$ObjectSenseInfo.x:F
        //    18: aload_2        
        //    19: getfield        facade/util/ObjectSensePacket.info:[Lfacade/util/ObjectSensePacket$ObjectSenseInfo;
        //    22: iload_3        
        //    23: aaload         
        //    24: getfield        facade/util/ObjectSensePacket$ObjectSenseInfo.y:F
        //    27: aload_2        
        //    28: getfield        facade/util/ObjectSensePacket.info:[Lfacade/util/ObjectSensePacket$ObjectSenseInfo;
        //    31: iload_3        
        //    32: aaload         
        //    33: getfield        facade/util/ObjectSensePacket$ObjectSenseInfo.z:F
        //    36: invokespecial   facade/util/Point3D.<init>:(FFF)V
        //    39: astore          4
        //    41: aload_0        
        //    42: aload_2        
        //    43: getfield        facade/util/ObjectSensePacket.info:[Lfacade/util/ObjectSensePacket$ObjectSenseInfo;
        //    46: iload_3        
        //    47: aaload         
        //    48: getfield        facade/util/ObjectSensePacket$ObjectSenseInfo.objectID:I
        //    51: iload_1        
        //    52: aload           4
        //    54: invokevirtual   facade/sensor/ObjectPickupRotationSensor.changed:(IILfacade/util/Point3D;)Z
        //    57: ifeq            170
        //    60: aload_0        
        //    61: aload_2        
        //    62: getfield        facade/util/ObjectSensePacket.info:[Lfacade/util/ObjectSensePacket$ObjectSenseInfo;
        //    65: iload_3        
        //    66: aaload         
        //    67: getfield        facade/util/ObjectSensePacket$ObjectSenseInfo.objectID:I
        //    70: iload_1        
        //    71: invokespecial   facade/sensor/ObjectPickupRotationSensor.deleteOldWMEs:(II)V
        //    74: invokestatic    abl/runtime/BehavingEntity.getBehavingEntity:()Labl/runtime/BehavingEntity;
        //    77: new             Lfacade/characters/wmedef/ObjectPickupRotationWME;
        //    80: dup            
        //    81: aload_2        
        //    82: getfield        facade/util/ObjectSensePacket.info:[Lfacade/util/ObjectSensePacket$ObjectSenseInfo;
        //    85: iload_3        
        //    86: aaload         
        //    87: getfield        facade/util/ObjectSensePacket$ObjectSenseInfo.objectID:I
        //    90: iload_1        
        //    91: aload           4
        //    93: getfield        facade/util/Point3D.x:F
        //    96: aload           4
        //    98: getfield        facade/util/Point3D.y:F
        //   101: aload           4
        //   103: getfield        facade/util/Point3D.z:F
        //   106: invokespecial   facade/characters/wmedef/ObjectPickupRotationWME.<init>:(IIFFF)V
        //   109: invokevirtual   abl/runtime/BehavingEntity.addWME:(Lwm/WME;)V
        //   112: goto            119
        //   115: aload           5
        //   117: monitorexit    
        //   118: athrow         
        //   119: aload_0        
        //   120: getfield        facade/sensor/ObjectPickupRotationSensor.lastRotations:Ljava/util/Hashtable;
        //   123: dup            
        //   124: astore          5
        //   126: monitorenter   
        //   127: new             Ljava/lang/Integer;
        //   130: dup            
        //   131: aload_2        
        //   132: getfield        facade/util/ObjectSensePacket.info:[Lfacade/util/ObjectSensePacket$ObjectSenseInfo;
        //   135: iload_3        
        //   136: aaload         
        //   137: getfield        facade/util/ObjectSensePacket$ObjectSenseInfo.objectID:I
        //   140: invokespecial   java/lang/Integer.<init>:(I)V
        //   143: astore          7
        //   145: aload_0        
        //   146: getfield        facade/sensor/ObjectPickupRotationSensor.lastRotations:Ljava/util/Hashtable;
        //   149: aload           7
        //   151: invokevirtual   java/util/Hashtable.remove:(Ljava/lang/Object;)Ljava/lang/Object;
        //   154: pop            
        //   155: aload_0        
        //   156: getfield        facade/sensor/ObjectPickupRotationSensor.lastRotations:Ljava/util/Hashtable;
        //   159: aload           7
        //   161: aload           4
        //   163: invokevirtual   java/util/Hashtable.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   166: pop            
        //   167: aload           5
        //   169: monitorexit    
        //   170: iinc            3, 1
        //   173: iload_3        
        //   174: aload_2        
        //   175: getfield        facade/util/ObjectSensePacket.info:[Lfacade/util/ObjectSensePacket$ObjectSenseInfo;
        //   178: arraylength    
        //   179: if_icmplt       5
        //   182: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  115    118    115    119    Any
        //  127    170    115    119    Any
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
    
    protected void senseContinuous_Utility(final int n) {
        final ObjectSensePacket objectSensePacket = new ObjectSensePacket();
        NativeAnimationInterface.getAllObjectPickupRotations(n, objectSensePacket);
        this.updateLastPickupRotationsConditionally(n, objectSensePacket);
    }
    
    private final /* synthetic */ void this() {
        this.lastRotations = new Hashtable();
    }
    
    public ObjectPickupRotationSensor() {
        this.this();
    }
}
