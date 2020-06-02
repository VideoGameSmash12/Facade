package jess;

import java.io.Serializable;

public class Defglobal implements Serializable, Visitable
{
    private String m_name;
    private Value m_value;
    
    public void reset(final Rete rete) throws JessException {
        try {
            final Context globalContext = rete.getGlobalContext();
            globalContext.setVariable(this.m_name, this.m_value.resolveValue(globalContext));
        }
        catch (JessException ex) {
            ex.addContext("definition for defglobal ?" + this.m_name);
            throw ex;
        }
    }
    
    public String getName() {
        return this.m_name;
    }
    
    public Value getInitializationValue() {
        return this.m_value;
    }
    
    public String toString() {
        return "[defglobal " + this.m_name + ']';
    }
    
    public Object accept(final Visitor visitor) {
        return visitor.visitDefglobal(this);
    }
    
    public Defglobal(final String name, final Value value) throws JessException {
        this.m_name = name;
        this.m_value = value;
    }
}
