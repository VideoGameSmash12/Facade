package jess.awt;

import jess.JessException;
import jess.Rete;
import java.awt.AWTEvent;
import java.awt.event.ContainerEvent;

public class ContainerListener extends JessAWTListener implements java.awt.event.ContainerListener
{
    public void componentAdded(final ContainerEvent containerEvent) {
        this.receiveEvent(containerEvent);
    }
    
    public void componentRemoved(final ContainerEvent containerEvent) {
        this.receiveEvent(containerEvent);
    }
    
    public ContainerListener(final String s, final Rete rete) throws JessException {
        super(s, rete);
    }
}
