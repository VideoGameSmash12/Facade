package jess;

import java.io.Serializable;

class Constant implements Userfunction, Serializable
{
    private Value m_val;
    private String m_name;
    
    public String getName() {
        return this.m_name;
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        return this.m_val;
    }
    
    Constant(final String name, final double n) {
        this.m_name = name;
        try {
            this.m_val = new Value(n, 32);
        }
        catch (JessException ex) {}
    }
}
