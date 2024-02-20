package jess.awt;

import jess.JessException;
import jess.Rete;
import java.awt.AWTEvent;
import java.awt.event.MouseEvent;

public class MouseMotionListener extends JessAWTListener implements java.awt.event.MouseMotionListener
{
    public void mouseDragged(final MouseEvent mouseEvent) {
        this.receiveEvent(mouseEvent);
    }
    
    public void mouseMoved(final MouseEvent mouseEvent) {
        this.receiveEvent(mouseEvent);
    }
    
    public MouseMotionListener(final String s, final Rete rete) throws JessException {
        super(s, rete);
    }
}
