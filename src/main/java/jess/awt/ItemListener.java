package jess.awt;

import jess.JessException;
import jess.Rete;
import java.awt.AWTEvent;
import java.awt.event.ItemEvent;

public class ItemListener extends JessAWTListener implements java.awt.event.ItemListener
{
    public void itemStateChanged(final ItemEvent itemEvent) {
        this.receiveEvent(itemEvent);
    }
    
    public ItemListener(final String s, final Rete rete) throws JessException {
        super(s, rete);
    }
}
