package jess;

public class JessEventAdapter implements JessListener
{
    private Funcall m_fc;
    private Rete m_rete;
    
    public final void eventHappened(final JessEvent jessEvent) {
        try {
            this.m_fc.set(new Value(jessEvent), 1);
            this.m_fc.execute(this.m_rete.getGlobalContext());
        }
        catch (JessException ex) {
            this.m_rete.getErrStream().println(ex);
        }
    }
    
    public JessEventAdapter(final String s, final Rete rete) throws JessException {
        this.m_rete = rete;
        (this.m_fc = new Funcall(s, rete)).setLength(2);
    }
}
