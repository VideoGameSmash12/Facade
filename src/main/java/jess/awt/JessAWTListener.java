package jess.awt;

import jess.JessException;
import jess.Value;
import java.awt.AWTEvent;
import jess.Rete;
import jess.Funcall;

class JessAWTListener
{
    private Funcall m_fc;
    private Rete m_engine;
    
    final void receiveEvent(final AWTEvent awtEvent) {
        try {
            this.m_fc.set(new Value(awtEvent), 1);
            this.m_fc.execute(this.m_engine.getGlobalContext());
        }
        catch (JessException ex) {
            this.m_engine.getErrStream().println(ex);
            this.m_engine.getErrStream().flush();
        }
    }
    
    JessAWTListener(final String s, final Rete engine) throws JessException {
        this.m_engine = engine;
        (this.m_fc = new Funcall(s, engine)).setLength(2);
    }
}
