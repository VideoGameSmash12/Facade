package jess;

import java.io.Reader;
import java.io.Writer;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.TextArea;
import jess.awt.TextReader;
import java.awt.TextField;
import jess.awt.TextAreaWriter;
import java.io.Serializable;
import java.awt.Panel;

public class ConsolePanel extends Panel implements Serializable
{
    private TextAreaWriter m_taw;
    private TextField m_tf;
    private TextReader m_in;
    Rete m_rete;
    
    public final void setFocus() {
        this.m_tf.requestFocus();
    }
    
    public ConsolePanel(final Rete rete) {
        this(rete, true);
    }
    
    public ConsolePanel(final Rete rete, final boolean b) {
        this.m_rete = rete;
        final TextArea textArea = new TextArea(10, 40);
        this.m_tf = new TextField(50);
        textArea.setEditable(false);
        final Button button = new Button("Clear Window");
        final Panel panel = new Panel();
        panel.setLayout(new BorderLayout());
        this.m_taw = new TextAreaWriter(textArea);
        this.m_in = new TextReader(false);
        this.setLayout(new BorderLayout());
        this.add("Center", textArea);
        panel.add("Center", this.m_tf);
        panel.add("East", button);
        this.add("South", panel);
        this.m_tf.addActionListener(new ActionListener() {
            public final void actionPerformed(final ActionEvent p0) {
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     1: getfield        jess/ConsolePanel$1.val$doEcho:Z
                //     4: ifeq            69
                //     7: goto            13
                //    10: aload_2        
                //    11: monitorexit    
                //    12: athrow         
                //    13: aload_0        
                //    14: getfield        jess/ConsolePanel$1.val$ta:Ljava/awt/TextArea;
                //    17: dup            
                //    18: astore_2       
                //    19: monitorenter   
                //    20: aload_0        
                //    21: getfield        jess/ConsolePanel$1.this$0:Ljess/ConsolePanel;
                //    24: invokestatic    jess/ConsolePanel.access$1:(Ljess/ConsolePanel;)Ljess/awt/TextAreaWriter;
                //    27: aload_0        
                //    28: getfield        jess/ConsolePanel$1.this$0:Ljess/ConsolePanel;
                //    31: invokestatic    jess/ConsolePanel.access$0:(Ljess/ConsolePanel;)Ljava/awt/TextField;
                //    34: invokevirtual   java/awt/TextField.getText:()Ljava/lang/String;
                //    37: invokevirtual   jess/awt/TextAreaWriter.write:(Ljava/lang/String;)V
                //    40: aload_0        
                //    41: getfield        jess/ConsolePanel$1.this$0:Ljess/ConsolePanel;
                //    44: invokestatic    jess/ConsolePanel.access$1:(Ljess/ConsolePanel;)Ljess/awt/TextAreaWriter;
                //    47: bipush          10
                //    49: invokevirtual   jess/awt/TextAreaWriter.write:(I)V
                //    52: aload_0        
                //    53: getfield        jess/ConsolePanel$1.this$0:Ljess/ConsolePanel;
                //    56: invokestatic    jess/ConsolePanel.access$1:(Ljess/ConsolePanel;)Ljess/awt/TextAreaWriter;
                //    59: invokevirtual   jess/awt/TextAreaWriter.flush:()V
                //    62: goto            67
                //    65: astore          4
                //    67: aload_2        
                //    68: monitorexit    
                //    69: aload_0        
                //    70: getfield        jess/ConsolePanel$1.this$0:Ljess/ConsolePanel;
                //    73: invokestatic    jess/ConsolePanel.access$2:(Ljess/ConsolePanel;)Ljess/awt/TextReader;
                //    76: new             Ljava/lang/StringBuffer;
                //    79: dup            
                //    80: invokespecial   java/lang/StringBuffer.<init>:()V
                //    83: aload_0        
                //    84: getfield        jess/ConsolePanel$1.this$0:Ljess/ConsolePanel;
                //    87: invokestatic    jess/ConsolePanel.access$0:(Ljess/ConsolePanel;)Ljava/awt/TextField;
                //    90: invokevirtual   java/awt/TextField.getText:()Ljava/lang/String;
                //    93: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
                //    96: bipush          10
                //    98: invokevirtual   java/lang/StringBuffer.append:(C)Ljava/lang/StringBuffer;
                //   101: invokevirtual   java/lang/StringBuffer.toString:()Ljava/lang/String;
                //   104: invokevirtual   jess/awt/TextReader.appendText:(Ljava/lang/String;)V
                //   107: aload_0        
                //   108: getfield        jess/ConsolePanel$1.this$0:Ljess/ConsolePanel;
                //   111: invokestatic    jess/ConsolePanel.access$0:(Ljess/ConsolePanel;)Ljava/awt/TextField;
                //   114: ldc             ""
                //   116: invokevirtual   java/awt/TextField.setText:(Ljava/lang/String;)V
                //   119: return         
                //    Exceptions:
                //  Try           Handler
                //  Start  End    Start  End    Type                 
                //  -----  -----  -----  -----  ---------------------
                //  10     12     10     13     Any
                //  20     62     65     67     Ljava/io/IOException;
                //  20     69     10     13     Any
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
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformCall(AstMethodBodyBuilder.java:1164)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:1009)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:554)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformNode(AstMethodBodyBuilder.java:392)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformBlock(AstMethodBodyBuilder.java:333)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:294)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createConstructor(AstBuilder.java:713)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:549)
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
        });
        button.addActionListener(new ActionListener() {
            public final void actionPerformed(final ActionEvent actionEvent) {
                ConsolePanel.this.m_taw.clear();
                ConsolePanel.this.m_tf.setText("");
            }
        });
        final PrintWriter printWriter = new PrintWriter(this.m_taw, true);
        rete.addInputRouter("t", this.m_in, true);
        rete.addOutputRouter("t", printWriter);
        rete.addInputRouter("WSTDIN", this.m_in, true);
        rete.addOutputRouter("WSTDOUT", printWriter);
        rete.addOutputRouter("WSTDERR", printWriter);
    }
}
