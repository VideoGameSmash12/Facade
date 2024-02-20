package jess;

import java.io.Serializable;

class RetractString implements Userfunction, Serializable
{
    public String getName() {
        return "retract-string";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        for (int i = 1; i < valueVector.size(); ++i) {
            context.getEngine().retractString(valueVector.get(i).stringValue(context));
        }
        return Funcall.TRUE;
    }
}
