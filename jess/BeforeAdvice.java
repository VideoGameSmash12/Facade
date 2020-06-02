package jess;

import java.util.ArrayList;

class BeforeAdvice implements Advice
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
    
    public Value call(ValueVector listValue, final Context context) throws JessException {
        final boolean inAdvice = context.getInAdvice();
        try {
            context.setInAdvice(true);
            context.setVariable("argv", new Value(listValue, 512));
            Value resolveValue = null;
            for (int i = 0; i < this.m_actions.size(); ++i) {
                resolveValue = ((Value)this.m_actions.get(i)).resolveValue(context);
            }
            if (context.returning()) {
                context.clearReturnValue();
                return resolveValue;
            }
            listValue = context.getVariable("argv").listValue(context);
            return this.m_uf.call(listValue, context);
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
    
    BeforeAdvice(final Userfunction uf) {
        this.this();
        this.m_uf = uf;
    }
}
