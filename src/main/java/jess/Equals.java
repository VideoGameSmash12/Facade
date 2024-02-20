package jess;

import java.io.Serializable;

class Equals implements Userfunction, Serializable
{
    public String getName() {
        return "=";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        for (int i = 2; i < valueVector.size(); ++i) {
            if (valueVector.get(i).numericValue(context) != valueVector.get(1).numericValue(context)) {
                return Funcall.FALSE;
            }
        }
        return Funcall.TRUE;
    }
}
