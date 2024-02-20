package jess;

import java.io.Serializable;

class StrSimple implements Userfunction, Serializable
{
    public static final int LENGTH = 0;
    public static final int UPCASE = 1;
    public static final int LOWCASE = 2;
    public static final String[] m_names;
    private int m_name;
    
    public String getName() {
        return StrSimple.m_names[this.m_name];
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        switch (this.m_name) {
            case 1: {
                return new Value(valueVector.get(1).stringValue(context).toUpperCase(), 2);
            }
            case 2: {
                return new Value(valueVector.get(1).stringValue(context).toLowerCase(), 2);
            }
            case 0: {
                return new Value(valueVector.get(1).stringValue(context).length(), 4);
            }
            default: {
                return Funcall.NIL;
            }
        }
    }
    
    StrSimple(final int name) {
        this.m_name = name;
    }
    
    static {
        m_names = new String[] { "str-length", "upcase", "lowcase" };
    }
}
