package jess;

import java.io.Serializable;

class Apply implements Userfunction, Serializable
{
    public String getName() {
        return "apply";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final Funcall funcall = new Funcall(valueVector.get(1).stringValue(context), context.getEngine());
        for (int i = 2; i < valueVector.size(); ++i) {
            funcall.arg(valueVector.get(i));
        }
        return funcall.execute(context);
    }
}
