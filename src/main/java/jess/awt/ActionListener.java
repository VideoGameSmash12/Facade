package jess.awt;

import jess.JessException;
import jess.Rete;
import java.awt.AWTEvent;
import java.awt.event.ActionEvent;

public class ActionListener extends JessAWTListener implements java.awt.event.ActionListener
{
    public void actionPerformed(final ActionEvent actionEvent) {
        this.receiveEvent(actionEvent);
    }
    
    public ActionListener(final String s, final Rete rete) throws JessException {
        super(s, rete);
    }
}
