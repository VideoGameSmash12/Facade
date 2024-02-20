package jess.awt;

import jess.JessException;
import jess.Rete;
import java.awt.AWTEvent;
import java.awt.event.WindowEvent;

public class WindowListener extends JessAWTListener implements java.awt.event.WindowListener
{
    public void windowActivated(final WindowEvent windowEvent) {
        this.receiveEvent(windowEvent);
    }
    
    public void windowDeactivated(final WindowEvent windowEvent) {
        this.receiveEvent(windowEvent);
    }
    
    public void windowDeiconified(final WindowEvent windowEvent) {
        this.receiveEvent(windowEvent);
    }
    
    public void windowIconified(final WindowEvent windowEvent) {
        this.receiveEvent(windowEvent);
    }
    
    public void windowOpened(final WindowEvent windowEvent) {
        this.receiveEvent(windowEvent);
    }
    
    public void windowClosed(final WindowEvent windowEvent) {
        this.receiveEvent(windowEvent);
    }
    
    public void windowClosing(final WindowEvent windowEvent) {
        this.receiveEvent(windowEvent);
    }
    
    public WindowListener(final String s, final Rete rete) throws JessException {
        super(s, rete);
    }
}
