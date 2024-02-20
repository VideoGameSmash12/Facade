package jess;

import java.io.Serializable;

class Progn implements Userfunction, Serializable
{
    public String getName() {
        return "progn";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        Value value = Funcall.NIL;
        for (int i = 1; i < valueVector.size(); ++i) {
            value = valueVector.get(i).resolveValue(context);
        }
        return value;
    }
}
