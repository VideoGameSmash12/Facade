package jess;

import java.io.Serializable;

class TypeP implements Userfunction, Serializable
{
    private String m_name;
    private int m_type;
    
    public String getName() {
        return this.m_name;
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        return ((valueVector.get(1).resolveValue(context).type() & this.m_type) != 0x0) ? Funcall.TRUE : Funcall.FALSE;
    }
    
    TypeP(final String name, final int type) {
        this.m_name = name;
        this.m_type = type;
    }
}
