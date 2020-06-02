package TemplateCompiler;

import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JList;
import java.util.Vector;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class NLUdebugger
{
    private static JFrame frame;
    private static JPanel pane;
    private static Vector facts;
    private static JList datalist;
    private static JButton button1;
    public static boolean observe;
    
    private final Component createComponents() {
        NLUdebugger.button1 = new JButton("Show Facts");
        final JButton button = new JButton("Clear Facts");
        NLUdebugger.button1.setMnemonic(83);
        button.setMnemonic(67);
        NLUdebugger.button1.addActionListener(new ActionListener() {
            public final void actionPerformed(final ActionEvent actionEvent) {
                if (NLUdebugger.observe) {
                    NLUdebugger.observe = false;
                    NLUdebugger.button1.setLabel("Show Facts");
                }
                else {
                    NLUdebugger.observe = true;
                    NLUdebugger.button1.setLabel("Hide Facts");
                }
            }
        });
        button.addActionListener(new ActionListener() {
            public final void actionPerformed(final ActionEvent actionEvent) {
                NLUdebugger.facts.removeAllElements();
                NLUdebugger.datalist.setListData(NLUdebugger.facts.toArray());
            }
        });
        NLUdebugger.button1.setPreferredSize(new Dimension(450, 50));
        button.setPreferredSize(new Dimension(450, 50));
        (NLUdebugger.pane = new JPanel()).setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        NLUdebugger.pane.add(NLUdebugger.button1);
        NLUdebugger.pane.add(button);
        final JScrollPane scrollPane = new JScrollPane(NLUdebugger.datalist);
        scrollPane.setPreferredSize(new Dimension(450, 400));
        NLUdebugger.pane.add(scrollPane);
        NLUdebugger.pane.setPreferredSize(new Dimension(500, 600));
        return NLUdebugger.pane;
    }
    
    public static void addmessage(final String s, final long n) {
        NLUdebugger.facts.addElement(s);
        NLUdebugger.datalist.setListData(NLUdebugger.facts.toArray());
    }
    
    public NLUdebugger() {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        }
        catch (Exception ex) {}
        NLUdebugger.frame = new JFrame("NLU Debugger");
        NLUdebugger.facts = new Vector();
        NLUdebugger.frame.getContentPane().add(this.createComponents());
        NLUdebugger.frame.addWindowListener(new WindowAdapter() {
            public final void windowClosing(final WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        NLUdebugger.frame.pack();
        NLUdebugger.frame.setResizable(false);
        NLUdebugger.frame.setVisible(true);
    }
    
    static {
        NLUdebugger.datalist = new JList();
        NLUdebugger.observe = false;
    }
}
