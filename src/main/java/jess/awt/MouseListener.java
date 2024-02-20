package jess.awt;

import jess.JessException;
import jess.Rete;
import java.awt.AWTEvent;
import java.awt.event.MouseEvent;

public class MouseListener extends JessAWTListener implements java.awt.event.MouseListener
{
    public void mouseClicked(final MouseEvent mouseEvent) {
        this.receiveEvent(mouseEvent);
    }
    
    public void mouseEntered(final MouseEvent mouseEvent) {
        this.receiveEvent(mouseEvent);
    }
    
    public void mouseExited(final MouseEvent mouseEvent) {
        this.receiveEvent(mouseEvent);
    }
    
    public void mousePressed(final MouseEvent mouseEvent) {
        this.receiveEvent(mouseEvent);
    }
    
    public void mouseReleased(final MouseEvent mouseEvent) {
        this.receiveEvent(mouseEvent);
    }
    
    public MouseListener(final String s, final Rete rete) throws JessException {
        super(s, rete);
    }
}
