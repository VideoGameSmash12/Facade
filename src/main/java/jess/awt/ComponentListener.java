package jess.awt;

import jess.JessException;
import jess.Rete;
import java.awt.AWTEvent;
import java.awt.event.ComponentEvent;

public class ComponentListener extends JessAWTListener implements java.awt.event.ComponentListener
{
    public void componentHidden(final ComponentEvent componentEvent) {
        this.receiveEvent(componentEvent);
    }
    
    public void componentMoved(final ComponentEvent componentEvent) {
        this.receiveEvent(componentEvent);
    }
    
    public void componentResized(final ComponentEvent componentEvent) {
        this.receiveEvent(componentEvent);
    }
    
    public void componentShown(final ComponentEvent componentEvent) {
        this.receiveEvent(componentEvent);
    }
    
    public ComponentListener(final String s, final Rete rete) throws JessException {
        super(s, rete);
    }
}
