package jess.awt;

import jess.JessException;
import jess.Rete;
import java.awt.AWTEvent;
import java.awt.event.AdjustmentEvent;

public class AdjustmentListener extends JessAWTListener implements java.awt.event.AdjustmentListener
{
    public void adjustmentValueChanged(final AdjustmentEvent adjustmentEvent) {
        this.receiveEvent(adjustmentEvent);
    }
    
    public AdjustmentListener(final String s, final Rete rete) throws JessException {
        super(s, rete);
    }
}
