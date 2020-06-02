package jess;

import java.io.Serializable;

class Eq implements Userfunction, Serializable
{
    public String getName() {
        return "eq";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final Value resolveValue = valueVector.get(1).resolveValue(context);
        for (int i = 2; i < valueVector.size(); ++i) {
            if (!valueVector.get(i).resolveValue(context).equals(resolveValue)) {
                return Funcall.FALSE;
            }
        }
        return Funcall.TRUE;
    }
}
