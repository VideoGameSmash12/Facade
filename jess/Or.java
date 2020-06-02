package jess;

import java.io.Serializable;

class Or implements Userfunction, Serializable
{
    public String getName() {
        return "or";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        for (int i = 1; i < valueVector.size(); ++i) {
            if (!valueVector.get(i).resolveValue(context).equals(Funcall.FALSE)) {
                return Funcall.TRUE;
            }
        }
        return Funcall.FALSE;
    }
}
