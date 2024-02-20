package jess;

import java.io.Serializable;

class While implements Userfunction, Serializable
{
    public String getName() {
        return "while";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        Value value = valueVector.get(1).resolveValue(context);
        int n = 0;
        if (valueVector.get(2).equals(Funcall.s_do)) {
            ++n;
        }
    Label_0100:
        while (!value.equals(Funcall.FALSE)) {
            for (int i = 2 + n; i < valueVector.size(); ++i) {
                valueVector.get(i).resolveValue(context);
                if (context.returning()) {
                    value = context.getReturnValue();
                    break Label_0100;
                }
            }
            value = valueVector.get(1).resolveValue(context);
        }
        return value;
    }
}
