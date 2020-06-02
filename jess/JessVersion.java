package jess;

import java.io.Serializable;

class JessVersion implements Userfunction, Serializable
{
    static final int NUMBER = 0;
    static final int STRING = 1;
    static final String[] s_names;
    private int m_name;
    
    public String getName() {
        return JessVersion.s_names[this.m_name];
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        switch (this.m_name) {
            case 0: {
                return new Value(6.1, 32);
            }
            default: {
                return new Value("Jess Version 6.1p2 5/21/2003", 2);
            }
        }
    }
    
    JessVersion(final int name) {
        this.m_name = name;
    }
    
    static {
        s_names = new String[] { "jess-version-number", "jess-version-string" };
    }
}
