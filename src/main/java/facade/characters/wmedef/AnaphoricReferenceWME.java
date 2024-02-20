package facade.characters.wmedef;

import javax.swing.JComboBox;
import facade.util.StringUtil;
import wm.WMEFieldEditor;
import facade.util.PrintUtilities;
import jess.Value;
import facade.util.SpriteID;
import facade.util.DAType;
import wm.WME;

public class AnaphoricReferenceWME extends WME implements DAType, SpriteID
{
    private static final int YOU = 0;
    private static final int HE = 1;
    private static final int SHE = 2;
    private static final int IT = 3;
    private static final int THIS = 4;
    private int youRef;
    private int youRefDefault;
    private int youRefTimeout;
    private int youRefNoOverride;
    private int youRefDefaultNoOverride;
    private boolean youRefOverrideByVisibleChar;
    private Value youRefJV;
    private Value youRefNoOverrideJV;
    private Thread youThread;
    private int heRef;
    private int heRefDefault;
    private int heRefTimeout;
    private Value heRefJV;
    private Thread heThread;
    private int sheRef;
    private int sheRefDefault;
    private int sheRefTimeout;
    private Value sheRefJV;
    private Thread sheThread;
    private int itRef;
    private int itRefDefault;
    private int itRefTimeout;
    private Value itRefJV;
    private Thread itThread;
    private int thisRef;
    private int thisRefDefault;
    private int thisRefTimeout;
    private Value thisRefJV;
    private Thread thisThread;
    
    private final void checkCharacterRef(final int n) {
        if (n < -1 || n > 2) {
            throw new RuntimeException("Attempt to set out-of-range character reference in AnaphoricReferenceWME " + n);
        }
    }
    
    private final void checkObjectRef(final int n) {
        if ((n < 58 || n > 61) && (n < 71 || n > 79) && (n < 80 || n > 99) && n != -1) {
            throw new RuntimeException("Attempt to set out-of-range object reference in AnaphoricReferenceWME " + PrintUtilities.daParam1_EnumToString(n));
        }
    }
    
    public WMEFieldEditor _getYouRefEditor() {
        return new CharIDEditor(this.getYouRef());
    }
    
    public WMEFieldEditor _getYouRefDefaultEditor() {
        return new CharIDEditor(this.getYouRefDefault());
    }
    
    public WMEFieldEditor _getHeRefEditor() {
        return new CharIDEditor(this.getHeRef());
    }
    
    public WMEFieldEditor _getHeRefDefaultEditor() {
        return new CharIDEditor(this.getHeRefDefault());
    }
    
    public WMEFieldEditor _getSheRefEditor() {
        return new CharIDEditor(this.getSheRef());
    }
    
    public WMEFieldEditor _getSheRefDefaultEditor() {
        return new CharIDEditor(this.getSheRefDefault());
    }
    
    public WMEFieldEditor _getItRefEditor() {
        return new DAObjectEditor(this.getItRef());
    }
    
    public WMEFieldEditor _getItRefDefaultEditor() {
        return new DAObjectEditor(this.getItRefDefault());
    }
    
    public WMEFieldEditor _getThisRefEditor() {
        return new DAObjectEditor(this.getThisRef());
    }
    
    public WMEFieldEditor _getThisRefDefaultEditor() {
        return new DAObjectEditor(this.getThisRefDefault());
    }
    
    public synchronized String formatYouRef() {
        return PrintUtilities.spriteID_EnumToString(this.getYouRef());
    }
    
    public synchronized String formatYouRefDefault() {
        return PrintUtilities.spriteID_EnumToString(this.getYouRefDefault());
    }
    
    public synchronized String formatYouRefNoOverride() {
        return PrintUtilities.spriteID_EnumToString(this.getYouRefNoOverride());
    }
    
    public synchronized String formatYouRefDefaultNoOverride() {
        return PrintUtilities.spriteID_EnumToString(this.getYouRefDefaultNoOverride());
    }
    
    public synchronized String formatHeRef() {
        return PrintUtilities.spriteID_EnumToString(this.getHeRef());
    }
    
    public synchronized String formatHeRefDefault() {
        return PrintUtilities.spriteID_EnumToString(this.getHeRefDefault());
    }
    
    public synchronized String formatSheRef() {
        return PrintUtilities.spriteID_EnumToString(this.getSheRef());
    }
    
    public synchronized String formatSheRefDefault() {
        return PrintUtilities.spriteID_EnumToString(this.getSheRefDefault());
    }
    
    public synchronized String formatItRef() {
        return PrintUtilities.daParam1_EnumToString(this.getItRef());
    }
    
    public synchronized String formatItRefDefault() {
        return PrintUtilities.daParam1_EnumToString(this.getItRefDefault());
    }
    
    public synchronized String formatThisRef() {
        return PrintUtilities.daParam1_EnumToString(this.getThisRef());
    }
    
    public synchronized String formatThisRefDefault() {
        return PrintUtilities.daParam1_EnumToString(this.getThisRefDefault());
    }
    
    private final void resetYouDecayThread() {
        if (this.getYouRef() != this.getYouRefDefault()) {
            if (this.youThread != null) {
                this.youThread.interrupt();
                this.youThread = null;
            }
            if (this.youRefTimeout > 0) {
                (this.youThread = new ReferenceDecayThread(0)).start();
            }
        }
    }
    
    public final synchronized int getYouRef() {
        return this.youRef;
    }
    
    public final void setYouRef(final int p0) {
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
        //    11: getfield        facade/characters/wmedef/AnaphoricReferenceWME.youRef:I
        //    14: istore_2       
        //    15: aload_0        
        //    16: iload_1        
        //    17: invokespecial   facade/characters/wmedef/AnaphoricReferenceWME.checkCharacterRef:(I)V
        //    20: iload_1        
        //    21: iconst_m1      
        //    22: if_icmpeq       33
        //    25: aload_0        
        //    26: iload_1        
        //    27: putfield        facade/characters/wmedef/AnaphoricReferenceWME.youRef:I
        //    30: goto            71
        //    33: aload_0        
        //    34: getfield        facade/characters/wmedef/AnaphoricReferenceWME.youRef:I
        //    37: ifeq            66
        //    40: aload_0        
        //    41: getfield        facade/characters/wmedef/AnaphoricReferenceWME.youRef:I
        //    44: iconst_1       
        //    45: if_icmpeq       66
        //    48: ldc             "$$$$$ Forcing youRef to be non-null"
        //    50: invokestatic    facade/util/StringUtil.println:(Ljava/lang/String;)V
        //    53: aload_0        
        //    54: iconst_1       
        //    55: putfield        facade/characters/wmedef/AnaphoricReferenceWME.youRef:I
        //    58: aload_0        
        //    59: getfield        facade/characters/wmedef/AnaphoricReferenceWME.youRef:I
        //    62: istore_2       
        //    63: goto            71
        //    66: ldc             "$$$$$ Ignoring request for null youRef"
        //    68: invokestatic    facade/util/StringUtil.println:(Ljava/lang/String;)V
        //    71: aload_0        
        //    72: invokespecial   facade/characters/wmedef/AnaphoricReferenceWME.resetYouDecayThread:()V
        //    75: aload_3        
        //    76: monitorexit    
        //    77: aload_0        
        //    78: new             Ljess/Value;
        //    81: dup            
        //    82: aload_0        
        //    83: getfield        facade/characters/wmedef/AnaphoricReferenceWME.youRef:I
        //    86: invokestatic    facade/util/PrintUtilities.spriteID_EnumToString:(I)Ljava/lang/String;
        //    89: iconst_1       
        //    90: invokespecial   jess/Value.<init>:(Ljava/lang/String;I)V
        //    93: invokespecial   facade/characters/wmedef/AnaphoricReferenceWME.setYouRefJV:(Ljess/Value;)V
        //    96: goto            111
        //    99: astore          5
        //   101: new             Ljava/lang/RuntimeException;
        //   104: dup            
        //   105: aload           5
        //   107: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/Throwable;)V
        //   110: athrow         
        //   111: aload_0        
        //   112: getfield        facade/characters/wmedef/AnaphoricReferenceWME.__support:Ljava/beans/PropertyChangeSupport;
        //   115: ldc             "youRef"
        //   117: iload_2        
        //   118: iload_1        
        //   119: invokevirtual   java/beans/PropertyChangeSupport.firePropertyChange:(Ljava/lang/String;II)V
        //   122: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                
        //  -----  -----  -----  -----  --------------------
        //  3      5      3      6      Any
        //  10     77     3      6      Any
        //  77     96     99     111    Ljess/JessException;
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
    
    public final synchronized Value getYouRefJV() {
        return this.youRefJV;
    }
    
    private final void setYouRefJV(final Value p0) {
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
        //    11: getfield        facade/characters/wmedef/AnaphoricReferenceWME.youRefJV:Ljess/Value;
        //    14: astore_2       
        //    15: aload_0        
        //    16: aload_1        
        //    17: putfield        facade/characters/wmedef/AnaphoricReferenceWME.youRefJV:Ljess/Value;
        //    20: aload_3        
        //    21: monitorexit    
        //    22: aload_0        
        //    23: getfield        facade/characters/wmedef/AnaphoricReferenceWME.__support:Ljava/beans/PropertyChangeSupport;
        //    26: ldc             "youRefJV"
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
    
    public final synchronized int getYouRefDefault() {
        return this.youRefDefault;
    }
    
    public final void setYouRefDefault(final int p0) {
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
        //    11: getfield        facade/characters/wmedef/AnaphoricReferenceWME.youRefDefault:I
        //    14: istore_2       
        //    15: aload_0        
        //    16: iload_1        
        //    17: invokespecial   facade/characters/wmedef/AnaphoricReferenceWME.checkCharacterRef:(I)V
        //    20: aload_0        
        //    21: iload_1        
        //    22: putfield        facade/characters/wmedef/AnaphoricReferenceWME.youRefDefault:I
        //    25: aload_3        
        //    26: monitorexit    
        //    27: aload_0        
        //    28: getfield        facade/characters/wmedef/AnaphoricReferenceWME.__support:Ljava/beans/PropertyChangeSupport;
        //    31: ldc             "youRefDefault"
        //    33: iload_2        
        //    34: iload_1        
        //    35: invokevirtual   java/beans/PropertyChangeSupport.firePropertyChange:(Ljava/lang/String;II)V
        //    38: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  3      5      3      6      Any
        //  10     27     3      6      Any
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
    
    public final synchronized int getYouRefNoOverride() {
        return this.youRefNoOverride;
    }
    
    public final void setYouRefNoOverride(final int p0) {
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
        //    11: getfield        facade/characters/wmedef/AnaphoricReferenceWME.youRefNoOverride:I
        //    14: istore_2       
        //    15: aload_0        
        //    16: iload_1        
        //    17: invokespecial   facade/characters/wmedef/AnaphoricReferenceWME.checkCharacterRef:(I)V
        //    20: aload_0        
        //    21: iload_1        
        //    22: putfield        facade/characters/wmedef/AnaphoricReferenceWME.youRefNoOverride:I
        //    25: aload_3        
        //    26: monitorexit    
        //    27: aload_0        
        //    28: new             Ljess/Value;
        //    31: dup            
        //    32: aload_0        
        //    33: getfield        facade/characters/wmedef/AnaphoricReferenceWME.youRefNoOverride:I
        //    36: invokestatic    facade/util/PrintUtilities.spriteID_EnumToString:(I)Ljava/lang/String;
        //    39: iconst_1       
        //    40: invokespecial   jess/Value.<init>:(Ljava/lang/String;I)V
        //    43: invokespecial   facade/characters/wmedef/AnaphoricReferenceWME.setYouRefNoOverrideJV:(Ljess/Value;)V
        //    46: goto            61
        //    49: astore          5
        //    51: new             Ljava/lang/RuntimeException;
        //    54: dup            
        //    55: aload           5
        //    57: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/Throwable;)V
        //    60: athrow         
        //    61: aload_0        
        //    62: getfield        facade/characters/wmedef/AnaphoricReferenceWME.__support:Ljava/beans/PropertyChangeSupport;
        //    65: ldc             "youRefNoOverride"
        //    67: iload_2        
        //    68: iload_1        
        //    69: invokevirtual   java/beans/PropertyChangeSupport.firePropertyChange:(Ljava/lang/String;II)V
        //    72: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                
        //  -----  -----  -----  -----  --------------------
        //  3      5      3      6      Any
        //  10     27     3      6      Any
        //  27     46     49     61     Ljess/JessException;
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
    
    public final synchronized int getYouRefDefaultNoOverride() {
        return this.youRefDefaultNoOverride;
    }
    
    public final void setYouRefDefaultNoOverride(final int p0) {
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
        //    11: getfield        facade/characters/wmedef/AnaphoricReferenceWME.youRefDefaultNoOverride:I
        //    14: istore_2       
        //    15: aload_0        
        //    16: iload_1        
        //    17: invokespecial   facade/characters/wmedef/AnaphoricReferenceWME.checkCharacterRef:(I)V
        //    20: aload_0        
        //    21: iload_1        
        //    22: putfield        facade/characters/wmedef/AnaphoricReferenceWME.youRefDefaultNoOverride:I
        //    25: aload_3        
        //    26: monitorexit    
        //    27: aload_0        
        //    28: getfield        facade/characters/wmedef/AnaphoricReferenceWME.__support:Ljava/beans/PropertyChangeSupport;
        //    31: ldc             "youRefDefaultNoOverride"
        //    33: iload_2        
        //    34: iload_1        
        //    35: invokevirtual   java/beans/PropertyChangeSupport.firePropertyChange:(Ljava/lang/String;II)V
        //    38: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  3      5      3      6      Any
        //  10     27     3      6      Any
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
    
    public final synchronized void saveYouRefToNoOverride() {
        this.setYouRefNoOverride(this.getYouRef());
        this.setYouRefDefaultNoOverride(this.getYouRefDefault());
        this.youRefOverrideByVisibleChar = true;
    }
    
    public final synchronized void restoreYouRefFromNoOverride() {
        this.setYouRef(this.getYouRefNoOverride());
        this.setYouRefDefault(this.getYouRefDefaultNoOverride());
        this.setYouRefNoOverride(-1);
        this.setYouRefDefaultNoOverride(-1);
        this.youRefOverrideByVisibleChar = false;
    }
    
    public final synchronized Value getYouRefNoOverrideJV() {
        return this.youRefNoOverrideJV;
    }
    
    private final synchronized void setYouRefNoOverrideJV(final Value p0) {
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
        //    11: getfield        facade/characters/wmedef/AnaphoricReferenceWME.youRefNoOverrideJV:Ljess/Value;
        //    14: astore_2       
        //    15: aload_0        
        //    16: aload_1        
        //    17: putfield        facade/characters/wmedef/AnaphoricReferenceWME.youRefNoOverrideJV:Ljess/Value;
        //    20: aload_3        
        //    21: monitorexit    
        //    22: aload_0        
        //    23: getfield        facade/characters/wmedef/AnaphoricReferenceWME.__support:Ljava/beans/PropertyChangeSupport;
        //    26: ldc             "youRefNoOverrideJV"
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
    
    public final synchronized int getYouRefTimeout() {
        return this.youRefTimeout;
    }
    
    public final void setYouRefTimeout(final int p0) {
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
        //    11: getfield        facade/characters/wmedef/AnaphoricReferenceWME.youRefTimeout:I
        //    14: istore_2       
        //    15: aload_0        
        //    16: iload_1        
        //    17: putfield        facade/characters/wmedef/AnaphoricReferenceWME.youRefTimeout:I
        //    20: aload_0        
        //    21: invokespecial   facade/characters/wmedef/AnaphoricReferenceWME.resetYouDecayThread:()V
        //    24: aload_3        
        //    25: monitorexit    
        //    26: aload_0        
        //    27: getfield        facade/characters/wmedef/AnaphoricReferenceWME.__support:Ljava/beans/PropertyChangeSupport;
        //    30: ldc_w           "youRefTimeout"
        //    33: iload_2        
        //    34: iload_1        
        //    35: invokevirtual   java/beans/PropertyChangeSupport.firePropertyChange:(Ljava/lang/String;II)V
        //    38: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  3      5      3      6      Any
        //  10     26     3      6      Any
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
    
    public final synchronized boolean getYouRefOverrideByVisibleChar() {
        return this.youRefOverrideByVisibleChar;
    }
    
    public final synchronized void setYouRefOverrideByVisibleChar(final boolean youRefOverrideByVisibleChar) {
        this.youRefOverrideByVisibleChar = youRefOverrideByVisibleChar;
    }
    
    private final void resetHeDecayThread() {
        if (this.getHeRef() != this.getHeRefDefault()) {
            if (this.heThread != null) {
                this.heThread.interrupt();
                this.heThread = null;
            }
            if (this.heRefTimeout > 0) {
                (this.heThread = new ReferenceDecayThread(1)).start();
            }
        }
    }
    
    public final synchronized int getHeRef() {
        return this.heRef;
    }
    
    public final void setHeRef(final int p0) {
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
        //    11: getfield        facade/characters/wmedef/AnaphoricReferenceWME.heRef:I
        //    14: istore_2       
        //    15: aload_0        
        //    16: iload_1        
        //    17: invokespecial   facade/characters/wmedef/AnaphoricReferenceWME.checkCharacterRef:(I)V
        //    20: aload_0        
        //    21: iload_1        
        //    22: putfield        facade/characters/wmedef/AnaphoricReferenceWME.heRef:I
        //    25: aload_0        
        //    26: invokespecial   facade/characters/wmedef/AnaphoricReferenceWME.resetHeDecayThread:()V
        //    29: aload_3        
        //    30: monitorexit    
        //    31: aload_0        
        //    32: new             Ljess/Value;
        //    35: dup            
        //    36: aload_0        
        //    37: getfield        facade/characters/wmedef/AnaphoricReferenceWME.heRef:I
        //    40: invokestatic    facade/util/PrintUtilities.spriteID_EnumToString:(I)Ljava/lang/String;
        //    43: iconst_1       
        //    44: invokespecial   jess/Value.<init>:(Ljava/lang/String;I)V
        //    47: invokevirtual   facade/characters/wmedef/AnaphoricReferenceWME.setHeRefJV:(Ljess/Value;)V
        //    50: goto            65
        //    53: astore          5
        //    55: new             Ljava/lang/RuntimeException;
        //    58: dup            
        //    59: aload           5
        //    61: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/Throwable;)V
        //    64: athrow         
        //    65: aload_0        
        //    66: getfield        facade/characters/wmedef/AnaphoricReferenceWME.__support:Ljava/beans/PropertyChangeSupport;
        //    69: ldc_w           "heRef"
        //    72: iload_2        
        //    73: iload_1        
        //    74: invokevirtual   java/beans/PropertyChangeSupport.firePropertyChange:(Ljava/lang/String;II)V
        //    77: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                
        //  -----  -----  -----  -----  --------------------
        //  3      5      3      6      Any
        //  10     31     3      6      Any
        //  31     50     53     65     Ljess/JessException;
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
    
    public final synchronized Value getHeRefJV() {
        return this.heRefJV;
    }
    
    public final void setHeRefJV(final Value p0) {
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
        //    11: getfield        facade/characters/wmedef/AnaphoricReferenceWME.heRefJV:Ljess/Value;
        //    14: astore_2       
        //    15: aload_0        
        //    16: aload_1        
        //    17: putfield        facade/characters/wmedef/AnaphoricReferenceWME.heRefJV:Ljess/Value;
        //    20: aload_3        
        //    21: monitorexit    
        //    22: aload_0        
        //    23: getfield        facade/characters/wmedef/AnaphoricReferenceWME.__support:Ljava/beans/PropertyChangeSupport;
        //    26: ldc_w           "heRefJV"
        //    29: aload_2        
        //    30: aload_1        
        //    31: invokevirtual   java/beans/PropertyChangeSupport.firePropertyChange:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
        //    34: return         
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
    
    public final synchronized int getHeRefDefault() {
        return this.heRefDefault;
    }
    
    public final void setHeRefDefault(final int p0) {
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
        //    11: getfield        facade/characters/wmedef/AnaphoricReferenceWME.heRefDefault:I
        //    14: istore_2       
        //    15: aload_0        
        //    16: iload_1        
        //    17: invokespecial   facade/characters/wmedef/AnaphoricReferenceWME.checkCharacterRef:(I)V
        //    20: aload_0        
        //    21: iload_1        
        //    22: putfield        facade/characters/wmedef/AnaphoricReferenceWME.heRefDefault:I
        //    25: aload_3        
        //    26: monitorexit    
        //    27: aload_0        
        //    28: getfield        facade/characters/wmedef/AnaphoricReferenceWME.__support:Ljava/beans/PropertyChangeSupport;
        //    31: ldc_w           "heRefDefault"
        //    34: iload_2        
        //    35: iload_1        
        //    36: invokevirtual   java/beans/PropertyChangeSupport.firePropertyChange:(Ljava/lang/String;II)V
        //    39: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  3      5      3      6      Any
        //  10     27     3      6      Any
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
    
    public final synchronized int getHeRefTimeout() {
        return this.heRefTimeout;
    }
    
    public final void setHeRefTimeout(final int p0) {
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
        //    11: getfield        facade/characters/wmedef/AnaphoricReferenceWME.heRefTimeout:I
        //    14: istore_2       
        //    15: aload_0        
        //    16: iload_1        
        //    17: putfield        facade/characters/wmedef/AnaphoricReferenceWME.heRefTimeout:I
        //    20: aload_0        
        //    21: invokespecial   facade/characters/wmedef/AnaphoricReferenceWME.resetHeDecayThread:()V
        //    24: aload_3        
        //    25: monitorexit    
        //    26: aload_0        
        //    27: getfield        facade/characters/wmedef/AnaphoricReferenceWME.__support:Ljava/beans/PropertyChangeSupport;
        //    30: ldc_w           "heRefTimeout"
        //    33: iload_2        
        //    34: iload_1        
        //    35: invokevirtual   java/beans/PropertyChangeSupport.firePropertyChange:(Ljava/lang/String;II)V
        //    38: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  3      5      3      6      Any
        //  10     26     3      6      Any
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
    
    private final void resetSheDecayThread() {
        if (this.getSheRef() != this.getSheRefDefault()) {
            if (this.sheThread != null) {
                this.sheThread.interrupt();
                this.sheThread = null;
            }
            if (this.sheRefTimeout > 0) {
                (this.sheThread = new ReferenceDecayThread(2)).start();
            }
        }
    }
    
    public final synchronized int getSheRef() {
        return this.sheRef;
    }
    
    public final void setSheRef(final int p0) {
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
        //    11: getfield        facade/characters/wmedef/AnaphoricReferenceWME.sheRef:I
        //    14: istore_2       
        //    15: aload_0        
        //    16: iload_1        
        //    17: invokespecial   facade/characters/wmedef/AnaphoricReferenceWME.checkCharacterRef:(I)V
        //    20: aload_0        
        //    21: iload_1        
        //    22: putfield        facade/characters/wmedef/AnaphoricReferenceWME.sheRef:I
        //    25: aload_0        
        //    26: invokespecial   facade/characters/wmedef/AnaphoricReferenceWME.resetSheDecayThread:()V
        //    29: aload_3        
        //    30: monitorexit    
        //    31: aload_0        
        //    32: new             Ljess/Value;
        //    35: dup            
        //    36: aload_0        
        //    37: getfield        facade/characters/wmedef/AnaphoricReferenceWME.sheRef:I
        //    40: invokestatic    facade/util/PrintUtilities.spriteID_EnumToString:(I)Ljava/lang/String;
        //    43: iconst_1       
        //    44: invokespecial   jess/Value.<init>:(Ljava/lang/String;I)V
        //    47: invokevirtual   facade/characters/wmedef/AnaphoricReferenceWME.setSheRefJV:(Ljess/Value;)V
        //    50: goto            65
        //    53: astore          5
        //    55: new             Ljava/lang/RuntimeException;
        //    58: dup            
        //    59: aload           5
        //    61: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/Throwable;)V
        //    64: athrow         
        //    65: aload_0        
        //    66: getfield        facade/characters/wmedef/AnaphoricReferenceWME.__support:Ljava/beans/PropertyChangeSupport;
        //    69: ldc_w           "sheRef"
        //    72: iload_2        
        //    73: iload_1        
        //    74: invokevirtual   java/beans/PropertyChangeSupport.firePropertyChange:(Ljava/lang/String;II)V
        //    77: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                
        //  -----  -----  -----  -----  --------------------
        //  3      5      3      6      Any
        //  10     31     3      6      Any
        //  31     50     53     65     Ljess/JessException;
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
    
    public final synchronized Value getSheRefJV() {
        return this.sheRefJV;
    }
    
    public final void setSheRefJV(final Value p0) {
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
        //    11: getfield        facade/characters/wmedef/AnaphoricReferenceWME.sheRefJV:Ljess/Value;
        //    14: astore_2       
        //    15: aload_0        
        //    16: aload_1        
        //    17: putfield        facade/characters/wmedef/AnaphoricReferenceWME.sheRefJV:Ljess/Value;
        //    20: aload_3        
        //    21: monitorexit    
        //    22: aload_0        
        //    23: getfield        facade/characters/wmedef/AnaphoricReferenceWME.__support:Ljava/beans/PropertyChangeSupport;
        //    26: ldc_w           "sheRefJV"
        //    29: aload_2        
        //    30: aload_1        
        //    31: invokevirtual   java/beans/PropertyChangeSupport.firePropertyChange:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
        //    34: return         
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
    
    public final synchronized int getSheRefDefault() {
        return this.sheRefDefault;
    }
    
    public final void setSheRefDefault(final int p0) {
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
        //    11: getfield        facade/characters/wmedef/AnaphoricReferenceWME.sheRefDefault:I
        //    14: istore_2       
        //    15: aload_0        
        //    16: iload_1        
        //    17: invokespecial   facade/characters/wmedef/AnaphoricReferenceWME.checkCharacterRef:(I)V
        //    20: aload_0        
        //    21: iload_1        
        //    22: putfield        facade/characters/wmedef/AnaphoricReferenceWME.sheRefDefault:I
        //    25: aload_3        
        //    26: monitorexit    
        //    27: aload_0        
        //    28: getfield        facade/characters/wmedef/AnaphoricReferenceWME.__support:Ljava/beans/PropertyChangeSupport;
        //    31: ldc_w           "sheRefDefault"
        //    34: iload_2        
        //    35: iload_1        
        //    36: invokevirtual   java/beans/PropertyChangeSupport.firePropertyChange:(Ljava/lang/String;II)V
        //    39: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  3      5      3      6      Any
        //  10     27     3      6      Any
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
    
    public final synchronized int getSheRefTimeout() {
        return this.sheRefTimeout;
    }
    
    public final void setSheRefTimeout(final int p0) {
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
        //    11: getfield        facade/characters/wmedef/AnaphoricReferenceWME.sheRefTimeout:I
        //    14: istore_2       
        //    15: aload_0        
        //    16: iload_1        
        //    17: putfield        facade/characters/wmedef/AnaphoricReferenceWME.sheRefTimeout:I
        //    20: aload_0        
        //    21: invokespecial   facade/characters/wmedef/AnaphoricReferenceWME.resetSheDecayThread:()V
        //    24: aload_3        
        //    25: monitorexit    
        //    26: aload_0        
        //    27: getfield        facade/characters/wmedef/AnaphoricReferenceWME.__support:Ljava/beans/PropertyChangeSupport;
        //    30: ldc_w           "sheRefTimeout"
        //    33: iload_2        
        //    34: iload_1        
        //    35: invokevirtual   java/beans/PropertyChangeSupport.firePropertyChange:(Ljava/lang/String;II)V
        //    38: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  3      5      3      6      Any
        //  10     26     3      6      Any
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
    
    private final void resetItDecayThread(final boolean b) {
        if (this.getItRef() != this.getItRefDefault() || b) {
            if (this.itThread != null) {
                this.itThread.interrupt();
                this.itThread = null;
            }
            if (this.itRefTimeout > 0) {
                (this.itThread = new ReferenceDecayThread(3)).start();
            }
        }
    }
    
    private final void resetThisDecayThread() {
        if (this.getThisRef() != this.getThisRefDefault()) {
            if (this.thisThread != null) {
                this.thisThread.interrupt();
                this.thisThread = null;
            }
            if (this.thisRefTimeout > 0) {
                (this.thisThread = new ReferenceDecayThread(4)).start();
            }
        }
    }
    
    public final synchronized int getItRef() {
        return this.itRef;
    }
    
    public final void setItRef(final int p0) {
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
        //    11: getfield        facade/characters/wmedef/AnaphoricReferenceWME.itRef:I
        //    14: istore_2       
        //    15: aload_0        
        //    16: iload_1        
        //    17: invokespecial   facade/characters/wmedef/AnaphoricReferenceWME.checkObjectRef:(I)V
        //    20: aload_0        
        //    21: iload_1        
        //    22: putfield        facade/characters/wmedef/AnaphoricReferenceWME.itRef:I
        //    25: aload_0        
        //    26: iconst_0       
        //    27: invokespecial   facade/characters/wmedef/AnaphoricReferenceWME.resetItDecayThread:(Z)V
        //    30: aload_3        
        //    31: monitorexit    
        //    32: aload_0        
        //    33: new             Ljess/Value;
        //    36: dup            
        //    37: aload_0        
        //    38: getfield        facade/characters/wmedef/AnaphoricReferenceWME.itRef:I
        //    41: invokestatic    facade/util/PrintUtilities.daParam1_EnumToString:(I)Ljava/lang/String;
        //    44: iconst_1       
        //    45: invokespecial   jess/Value.<init>:(Ljava/lang/String;I)V
        //    48: invokevirtual   facade/characters/wmedef/AnaphoricReferenceWME.setItRefJV:(Ljess/Value;)V
        //    51: goto            66
        //    54: astore          5
        //    56: new             Ljava/lang/RuntimeException;
        //    59: dup            
        //    60: aload           5
        //    62: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/Throwable;)V
        //    65: athrow         
        //    66: aload_0        
        //    67: getfield        facade/characters/wmedef/AnaphoricReferenceWME.__support:Ljava/beans/PropertyChangeSupport;
        //    70: ldc_w           "itRef"
        //    73: iload_2        
        //    74: iload_1        
        //    75: invokevirtual   java/beans/PropertyChangeSupport.firePropertyChange:(Ljava/lang/String;II)V
        //    78: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                
        //  -----  -----  -----  -----  --------------------
        //  3      5      3      6      Any
        //  10     32     3      6      Any
        //  32     51     54     66     Ljess/JessException;
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
    
    public final synchronized Value getItRefJV() {
        return this.itRefJV;
    }
    
    public final void setItRefJV(final Value p0) {
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
        //    11: getfield        facade/characters/wmedef/AnaphoricReferenceWME.itRefJV:Ljess/Value;
        //    14: astore_2       
        //    15: aload_0        
        //    16: aload_1        
        //    17: putfield        facade/characters/wmedef/AnaphoricReferenceWME.itRefJV:Ljess/Value;
        //    20: aload_3        
        //    21: monitorexit    
        //    22: aload_0        
        //    23: getfield        facade/characters/wmedef/AnaphoricReferenceWME.__support:Ljava/beans/PropertyChangeSupport;
        //    26: ldc_w           "itRefJV"
        //    29: aload_2        
        //    30: aload_1        
        //    31: invokevirtual   java/beans/PropertyChangeSupport.firePropertyChange:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
        //    34: return         
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
    
    public final synchronized int getItRefDefault() {
        return this.itRefDefault;
    }
    
    public final void setItRefDefault(final int p0) {
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
        //    11: getfield        facade/characters/wmedef/AnaphoricReferenceWME.itRefDefault:I
        //    14: istore_2       
        //    15: aload_0        
        //    16: iload_1        
        //    17: invokespecial   facade/characters/wmedef/AnaphoricReferenceWME.checkObjectRef:(I)V
        //    20: aload_0        
        //    21: iload_1        
        //    22: putfield        facade/characters/wmedef/AnaphoricReferenceWME.itRefDefault:I
        //    25: aload_3        
        //    26: monitorexit    
        //    27: aload_0        
        //    28: getfield        facade/characters/wmedef/AnaphoricReferenceWME.__support:Ljava/beans/PropertyChangeSupport;
        //    31: ldc_w           "itRefDefault"
        //    34: iload_2        
        //    35: iload_1        
        //    36: invokevirtual   java/beans/PropertyChangeSupport.firePropertyChange:(Ljava/lang/String;II)V
        //    39: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  3      5      3      6      Any
        //  10     27     3      6      Any
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
    
    public final synchronized int getItRefTimeout() {
        return this.itRefTimeout;
    }
    
    public final void setItRefTimeout(final int p0) {
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
        //    11: getfield        facade/characters/wmedef/AnaphoricReferenceWME.itRefTimeout:I
        //    14: istore_2       
        //    15: aload_0        
        //    16: iload_1        
        //    17: putfield        facade/characters/wmedef/AnaphoricReferenceWME.itRefTimeout:I
        //    20: aload_0        
        //    21: iconst_1       
        //    22: invokespecial   facade/characters/wmedef/AnaphoricReferenceWME.resetItDecayThread:(Z)V
        //    25: aload_3        
        //    26: monitorexit    
        //    27: aload_0        
        //    28: getfield        facade/characters/wmedef/AnaphoricReferenceWME.__support:Ljava/beans/PropertyChangeSupport;
        //    31: ldc_w           "itRefTimeout"
        //    34: iload_2        
        //    35: iload_1        
        //    36: invokevirtual   java/beans/PropertyChangeSupport.firePropertyChange:(Ljava/lang/String;II)V
        //    39: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  3      5      3      6      Any
        //  10     27     3      6      Any
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
    
    public final synchronized int getThisRef() {
        return this.thisRef;
    }
    
    public final void setThisRef(final int p0) {
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
        //    11: getfield        facade/characters/wmedef/AnaphoricReferenceWME.thisRef:I
        //    14: istore_2       
        //    15: aload_0        
        //    16: iload_1        
        //    17: invokespecial   facade/characters/wmedef/AnaphoricReferenceWME.checkObjectRef:(I)V
        //    20: aload_0        
        //    21: iload_1        
        //    22: putfield        facade/characters/wmedef/AnaphoricReferenceWME.thisRef:I
        //    25: aload_0        
        //    26: invokespecial   facade/characters/wmedef/AnaphoricReferenceWME.resetThisDecayThread:()V
        //    29: aload_3        
        //    30: monitorexit    
        //    31: aload_0        
        //    32: new             Ljess/Value;
        //    35: dup            
        //    36: aload_0        
        //    37: getfield        facade/characters/wmedef/AnaphoricReferenceWME.thisRef:I
        //    40: invokestatic    facade/util/PrintUtilities.daParam1_EnumToString:(I)Ljava/lang/String;
        //    43: iconst_1       
        //    44: invokespecial   jess/Value.<init>:(Ljava/lang/String;I)V
        //    47: invokevirtual   facade/characters/wmedef/AnaphoricReferenceWME.setThisRefJV:(Ljess/Value;)V
        //    50: goto            65
        //    53: astore          5
        //    55: new             Ljava/lang/RuntimeException;
        //    58: dup            
        //    59: aload           5
        //    61: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/Throwable;)V
        //    64: athrow         
        //    65: aload_0        
        //    66: getfield        facade/characters/wmedef/AnaphoricReferenceWME.__support:Ljava/beans/PropertyChangeSupport;
        //    69: ldc_w           "thisRef"
        //    72: iload_2        
        //    73: iload_1        
        //    74: invokevirtual   java/beans/PropertyChangeSupport.firePropertyChange:(Ljava/lang/String;II)V
        //    77: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                
        //  -----  -----  -----  -----  --------------------
        //  3      5      3      6      Any
        //  10     31     3      6      Any
        //  31     50     53     65     Ljess/JessException;
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
    
    public final synchronized Value getThisRefJV() {
        return this.thisRefJV;
    }
    
    public final void setThisRefJV(final Value p0) {
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
        //    11: getfield        facade/characters/wmedef/AnaphoricReferenceWME.thisRefJV:Ljess/Value;
        //    14: astore_2       
        //    15: aload_0        
        //    16: aload_1        
        //    17: putfield        facade/characters/wmedef/AnaphoricReferenceWME.thisRefJV:Ljess/Value;
        //    20: aload_3        
        //    21: monitorexit    
        //    22: aload_0        
        //    23: getfield        facade/characters/wmedef/AnaphoricReferenceWME.__support:Ljava/beans/PropertyChangeSupport;
        //    26: ldc_w           "thisRefJV"
        //    29: aload_2        
        //    30: aload_1        
        //    31: invokevirtual   java/beans/PropertyChangeSupport.firePropertyChange:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
        //    34: return         
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
    
    public final synchronized int getThisRefDefault() {
        return this.thisRefDefault;
    }
    
    public final void setThisRefDefault(final int p0) {
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
        //    11: getfield        facade/characters/wmedef/AnaphoricReferenceWME.thisRefDefault:I
        //    14: istore_2       
        //    15: aload_0        
        //    16: iload_1        
        //    17: invokespecial   facade/characters/wmedef/AnaphoricReferenceWME.checkObjectRef:(I)V
        //    20: aload_0        
        //    21: iload_1        
        //    22: putfield        facade/characters/wmedef/AnaphoricReferenceWME.thisRefDefault:I
        //    25: aload_3        
        //    26: monitorexit    
        //    27: aload_0        
        //    28: getfield        facade/characters/wmedef/AnaphoricReferenceWME.__support:Ljava/beans/PropertyChangeSupport;
        //    31: ldc_w           "thisRefDefault"
        //    34: iload_2        
        //    35: iload_1        
        //    36: invokevirtual   java/beans/PropertyChangeSupport.firePropertyChange:(Ljava/lang/String;II)V
        //    39: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  3      5      3      6      Any
        //  10     27     3      6      Any
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
    
    public final synchronized int getThisRefTimeout() {
        return this.thisRefTimeout;
    }
    
    public final void setThisRefTimeout(final int p0) {
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
        //    11: getfield        facade/characters/wmedef/AnaphoricReferenceWME.thisRefTimeout:I
        //    14: istore_2       
        //    15: aload_0        
        //    16: iload_1        
        //    17: putfield        facade/characters/wmedef/AnaphoricReferenceWME.thisRefTimeout:I
        //    20: aload_0        
        //    21: invokespecial   facade/characters/wmedef/AnaphoricReferenceWME.resetThisDecayThread:()V
        //    24: aload_3        
        //    25: monitorexit    
        //    26: aload_0        
        //    27: getfield        facade/characters/wmedef/AnaphoricReferenceWME.__support:Ljava/beans/PropertyChangeSupport;
        //    30: ldc_w           "thisRefTimeout"
        //    33: iload_2        
        //    34: iload_1        
        //    35: invokevirtual   java/beans/PropertyChangeSupport.firePropertyChange:(Ljava/lang/String;II)V
        //    38: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  3      5      3      6      Any
        //  10     26     3      6      Any
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
        this.youThread = null;
        this.heThread = null;
        this.sheThread = null;
        this.itThread = null;
        this.thisThread = null;
    }
    
    public AnaphoricReferenceWME(final int youRef, final int youRefDefault, final int youRefTimeout, final int heRef, final int heRefDefault, final int heRefTimeout, final int sheRef, final int sheRefDefault, final int sheRefTimeout, final int itRef, final int itRefDefault, final int itRefTimeout, final int thisRef, final int thisRefDefault, final int thisRefTimeout) {
        this.this();
        this.checkCharacterRef(youRef);
        this.checkCharacterRef(youRefDefault);
        this.checkCharacterRef(heRef);
        this.checkCharacterRef(heRefDefault);
        this.checkCharacterRef(sheRef);
        this.checkCharacterRef(sheRefDefault);
        this.checkObjectRef(itRef);
        this.checkObjectRef(itRefDefault);
        this.checkObjectRef(thisRef);
        this.checkObjectRef(thisRefDefault);
        this.setYouRef(youRef);
        this.youRefDefault = youRefDefault;
        this.youRefTimeout = youRefTimeout;
        this.youRefNoOverride = -1;
        this.youRefOverrideByVisibleChar = false;
        this.youRefDefaultNoOverride = -1;
        this.setHeRef(heRef);
        this.heRefDefault = heRefDefault;
        this.heRefTimeout = heRefTimeout;
        this.setSheRef(sheRef);
        this.sheRefDefault = sheRefDefault;
        this.sheRefTimeout = sheRefTimeout;
        this.setItRef(itRef);
        this.itRefDefault = itRefDefault;
        this.itRefTimeout = itRefTimeout;
        this.setThisRef(thisRef);
        this.thisRefDefault = thisRefDefault;
        this.thisRefTimeout = thisRefTimeout;
    }
    
    public AnaphoricReferenceWME() {
        this.this();
        this.setYouRef(-1);
        this.youRefDefault = -1;
        this.youRefNoOverride = -1;
        this.youRefDefaultNoOverride = -1;
        this.youRefTimeout = 30;
        this.setHeRef(1);
        this.heRefDefault = 1;
        this.heRefTimeout = 30;
        this.setSheRef(0);
        this.sheRefDefault = 0;
        this.sheRefTimeout = 30;
        this.setItRef(-1);
        this.itRefDefault = -1;
        this.itRefTimeout = 15;
        this.setThisRef(-1);
        this.thisRefDefault = -1;
        this.thisRefTimeout = 9999;
    }
    
    class ReferenceDecayThread extends Thread
    {
        private int refType;
        private static final /* synthetic */ boolean $noassert;
        
        public void run() {
            long n = 0L;
            switch (this.refType) {
                case 0: {
                    if (!ReferenceDecayThread.$noassert && AnaphoricReferenceWME.this.youRefTimeout <= 0) {
                        throw new AssertionError();
                    }
                    n = AnaphoricReferenceWME.this.getYouRefTimeout() * 1000;
                    break;
                }
                case 1: {
                    if (!ReferenceDecayThread.$noassert && AnaphoricReferenceWME.this.heRefTimeout <= 0) {
                        throw new AssertionError();
                    }
                    n = AnaphoricReferenceWME.this.getHeRefTimeout() * 1000;
                    break;
                }
                case 2: {
                    if (!ReferenceDecayThread.$noassert && AnaphoricReferenceWME.this.sheRefTimeout <= 0) {
                        throw new AssertionError();
                    }
                    n = AnaphoricReferenceWME.this.getSheRefTimeout() * 1000;
                    break;
                }
                case 3: {
                    if (!ReferenceDecayThread.$noassert && AnaphoricReferenceWME.this.itRefTimeout <= 0) {
                        throw new AssertionError();
                    }
                    n = AnaphoricReferenceWME.this.getItRefTimeout() * 1000;
                    break;
                }
                case 4: {
                    if (!ReferenceDecayThread.$noassert && AnaphoricReferenceWME.this.thisRefTimeout <= 0) {
                        throw new AssertionError();
                    }
                    n = AnaphoricReferenceWME.this.getThisRefTimeout() * 1000;
                    break;
                }
                default: {
                    throw new Error("Unexpected anaphoric reference type " + this.refType);
                }
            }
            try {
                Thread.sleep(n);
                switch (this.refType) {
                    case 0: {
                        AnaphoricReferenceWME.this.setYouRef(AnaphoricReferenceWME.this.getYouRefDefault());
                        break;
                    }
                    case 1: {
                        AnaphoricReferenceWME.this.setHeRef(AnaphoricReferenceWME.this.getHeRefDefault());
                        break;
                    }
                    case 2: {
                        AnaphoricReferenceWME.this.setSheRef(AnaphoricReferenceWME.this.getSheRefDefault());
                        break;
                    }
                    case 3: {
                        StringUtil.println("$$$$$ ItRef decayed to default: " + AnaphoricReferenceWME.this.getItRefDefault());
                        AnaphoricReferenceWME.this.setItRef(AnaphoricReferenceWME.this.getItRefDefault());
                        break;
                    }
                    case 4: {
                        AnaphoricReferenceWME.this.setThisRef(AnaphoricReferenceWME.this.getThisRefDefault());
                        break;
                    }
                    default: {
                        throw new Error("Unexpected anaphoric reference type " + this.refType);
                    }
                }
            }
            catch (InterruptedException ex) {}
        }
        
        ReferenceDecayThread(final int refType) {
            this.refType = refType;
        }
        
        static {
            $noassert = (Class.forName("[Lfacade.characters.wmedef.AnaphoricReferenceWME;").getComponentType().desiredAssertionStatus() ^ true);
        }
    }
    
    private class CharIDEditor extends JComboBox implements WMEFieldEditor
    {
        public String getFieldValue() {
            return Integer.toString(PrintUtilities.spriteID_StringToEnum((String)this.getSelectedItem()));
        }
        
        public void setFieldValue(final String s) {
            this.setSelectedItem(PrintUtilities.spriteID_EnumToString(Integer.parseInt(s)));
        }
        
        CharIDEditor(final int n) {
            super(PrintUtilities.spriteID_GetCharacterEnumArray());
            this.setEditable(false);
            this.setSelectedItem(PrintUtilities.spriteID_EnumToString(n));
        }
    }
    
    private class DAObjectEditor extends JComboBox implements WMEFieldEditor
    {
        public String getFieldValue() {
            return Integer.toString(PrintUtilities.daParam1_StringToEnum((String)this.getSelectedItem()));
        }
        
        public void setFieldValue(final String s) {
            this.setSelectedItem(PrintUtilities.daParam1_EnumToString(Integer.parseInt(s)));
        }
        
        DAObjectEditor(final int n) {
            super(PrintUtilities.daParam1_GetEnumArray("eDAObjectParam"));
            this.setEditable(false);
            this.setSelectedItem(PrintUtilities.daParam1_EnumToString(n));
        }
    }
}
