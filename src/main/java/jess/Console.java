package jess;

import java.awt.Component;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.io.Serializable;
import java.awt.Frame;

public class Console extends Frame implements Serializable
{
    ConsolePanel m_panel;
    Rete m_rete;
    boolean m_doEcho;
    
    public Rete getEngine() {
        return this.m_rete;
    }
    
    public void execute(final String[] array) {
        final Main main = new Main();
        main.initialize(array, this.m_rete);
        this.m_panel.setFocus();
        while (true) {
            main.execute(this.m_doEcho);
        }
    }
    
    public static void main(final String[] array) {
        final Console console = new Console("Jess Console");
        console.addWindowListener(new WindowAdapter() {
            public final void windowClosing(final WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        console.execute(array);
    }
    
    private final /* synthetic */ void this() {
        this.m_doEcho = true;
    }
    
    public Console(final String s) {
        this(s, true);
    }
    
    public Console(final String s, final boolean b) {
        this(s, new Rete(), b);
    }
    
    public Console(final String s, final Rete rete) {
        this(s, rete, true);
    }
    
    public Console(final String s, final Rete rete, final boolean doEcho) {
        super(s);
        this.this();
        this.m_rete = rete;
        this.m_panel = new ConsolePanel(rete, doEcho);
        this.m_doEcho = doEcho;
        this.add("Center", this.m_panel);
        this.validate();
        this.setSize(500, 300);
        this.show();
    }
}
