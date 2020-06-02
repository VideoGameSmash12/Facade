package jess.awt;

import jess.JessException;
import jess.Rete;
import java.awt.AWTEvent;
import java.awt.event.FocusEvent;

public class FocusListener extends JessAWTListener implements java.awt.event.FocusListener
{
    public void focusGained(final FocusEvent focusEvent) {
        this.receiveEvent(focusEvent);
    }
    
    public void focusLost(final FocusEvent focusEvent) {
        this.receiveEvent(focusEvent);
    }
    
    public FocusListener(final String s, final Rete rete) throws JessException {
        super(s, rete);
    }
}
