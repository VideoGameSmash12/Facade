package jess.awt;

import jess.JessException;
import jess.Rete;
import java.awt.AWTEvent;
import java.awt.event.KeyEvent;

public class KeyListener extends JessAWTListener implements java.awt.event.KeyListener
{
    public void keyPressed(final KeyEvent keyEvent) {
        this.receiveEvent(keyEvent);
    }
    
    public void keyReleased(final KeyEvent keyEvent) {
        this.receiveEvent(keyEvent);
    }
    
    public void keyTyped(final KeyEvent keyEvent) {
        this.receiveEvent(keyEvent);
    }
    
    public KeyListener(final String s, final Rete rete) throws JessException {
        super(s, rete);
    }
}
