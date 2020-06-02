package jess;

import java.util.ArrayList;

class AfterAdvice implements Advice
{
    private Userfunction m_uf;
    private ArrayList m_actions;
    
    public Userfunction getFunction() {
        return this.m_uf;
    }
    
    public void addAction(final Value value) {
        this.m_actions.add(value);
    }
    
    public String getName() {
        return this.m_uf.getName();
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final boolean inAdvice = context.getInAdvice();
        try {
            context.setInAdvice(true);
            final Value call = this.m_uf.call(valueVector, context);
            context.setVariable("retval", call);
            Value resolveValue = null;
            for (int i = 0; i < this.m_actions.size(); ++i) {
                resolveValue = ((Value)this.m_actions.get(i)).resolveValue(context);
            }
            if (context.returning()) {
                context.clearReturnValue();
                return resolveValue;
            }
            return call;
        }
        catch (JessException ex) {
            ex.addContext("advice");
            throw ex;
        }
        finally {
            context.setInAdvice(inAdvice);
        }
    }
    
    private final /* synthetic */ void this() {
        this.m_actions = new ArrayList(3);
    }
    
    AfterAdvice(final Userfunction uf) {
        this.this();
        this.m_uf = uf;
    }
}
