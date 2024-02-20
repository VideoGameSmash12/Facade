package jess;

import java.io.Serializable;

class Not implements Userfunction, Serializable
{
    public String getName() {
        return "not";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        if (valueVector.get(1).resolveValue(context).equals(Funcall.FALSE)) {
            return Funcall.TRUE;
        }
        return Funcall.FALSE;
    }
}
