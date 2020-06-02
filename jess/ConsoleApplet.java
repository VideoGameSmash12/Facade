package jess;

import java.awt.Label;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.BorderLayout;
import java.io.Serializable;
import java.applet.Applet;

public class ConsoleApplet extends Applet implements Runnable, Serializable
{
    private ConsolePanel m_panel;
    private Rete m_rete;
    private Thread m_thread;
    private Main m_main;
    
    public void init() {
        this.setLayout(new BorderLayout());
        this.m_rete = new Rete(this);
        this.add("Center", this.m_panel = new ConsolePanel(this.m_rete));
        this.add("South", new Label());
        String[] array = new String[0];
        final String parameter = this.getParameter("INPUT");
        if (parameter != null) {
            array = new String[] { parameter };
        }
        (this.m_main = new Main()).initialize(array, this.m_rete);
    }
    
    public synchronized void run() {
        while (true) {
            try {
                this.m_panel.setFocus();
                while (true) {
                    this.m_main.execute(true);
                }
            }
            catch (Throwable t) {
                this.m_thread = null;
                if (this.m_thread == null) {
                    return;
                }
                continue;
            }
            break;
        }
    }
    
    public void start() {
        if (this.m_thread == null) {
            (this.m_thread = new Thread(this)).start();
        }
    }
    
    public void stop() {
        this.m_thread = null;
    }
}
