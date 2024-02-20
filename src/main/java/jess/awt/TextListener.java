package jess.awt;

import jess.JessException;
import jess.Rete;
import java.awt.AWTEvent;
import java.awt.event.TextEvent;

public class TextListener extends JessAWTListener implements java.awt.event.TextListener
{
    public void textValueChanged(final TextEvent textEvent) {
        this.receiveEvent(textEvent);
    }
    
    public TextListener(final String s, final Rete rete) throws JessException {
        super(s, rete);
    }
}
