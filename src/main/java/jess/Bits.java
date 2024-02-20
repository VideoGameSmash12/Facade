package jess;

import java.io.Serializable;

class Bits implements Userfunction, Serializable
{
    static final String AND = "bit-and";
    static final String OR = "bit-or";
    static final String NOT = "bit-not";
    private String m_name;
    
    public String getName() {
        return this.m_name;
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        int intValue = valueVector.get(1).intValue(context);
        if (this.m_name.equals("bit-and")) {
            for (int i = 2; i < valueVector.size(); ++i) {
                intValue &= valueVector.get(i).intValue(context);
            }
        }
        else if (this.m_name.equals("bit-or")) {
            for (int j = 2; j < valueVector.size(); ++j) {
                intValue |= valueVector.get(j).intValue(context);
            }
        }
        else {
            intValue ^= -1;
        }
        return new Value(intValue, 4);
    }
    
    Bits(final String name) {
        this.m_name = name;
    }
}
