package jess.awt;

import jess.JessException;
import jess.Value;
import java.awt.Graphics;
import jess.Rete;
import jess.Funcall;

public class Canvas extends java.awt.Canvas
{
    private Funcall m_fc;
    private Rete m_engine;
    
    public void paint(final Graphics graphics) {
        try {
            this.m_fc.set(new Value(graphics), 2);
            this.m_fc.execute(this.m_engine.getGlobalContext());
        }
        catch (JessException ex) {
            this.m_engine.getErrStream().println(ex);
        }
    }
    
    public Canvas(final String s, final Rete engine) throws JessException {
        this.m_engine = engine;
        (this.m_fc = new Funcall(s, engine)).add(new Value(this));
        this.m_fc.setLength(3);
    }
}
