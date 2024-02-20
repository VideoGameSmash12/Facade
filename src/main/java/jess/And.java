package jess;

import java.io.Serializable;

class And implements Userfunction, Serializable
{
    public String getName() {
        return "and";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        for (int i = 1; i < valueVector.size(); ++i) {
            if (valueVector.get(i).resolveValue(context).equals(Funcall.FALSE)) {
                return Funcall.FALSE;
            }
        }
        return Funcall.TRUE;
    }
}
