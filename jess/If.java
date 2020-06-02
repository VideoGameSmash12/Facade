package jess;

import java.io.Serializable;

class If implements Userfunction, Serializable
{
    public String getName() {
        return "if";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        if (!valueVector.get(2).equals(Funcall.s_then)) {
            throw new JessException("if", "Expected 'then':", valueVector.get(2).toString());
        }
        if (!valueVector.get(1).resolveValue(context).equals(Funcall.FALSE)) {
            Value value = Funcall.FALSE;
            for (int i = 3; i < valueVector.size(); ++i) {
                final Value resolveValue = valueVector.get(i).resolveValue(context);
                if (resolveValue.equals(Funcall.s_else)) {
                    break;
                }
                if (context.returning()) {
                    value = context.getReturnValue();
                    break;
                }
                value = resolveValue;
            }
            return value;
        }
        Value value2 = Funcall.FALSE;
        int n = 0;
        for (int j = 3; j < valueVector.size(); ++j) {
            if (n == 0) {
                if (valueVector.get(j).equals(Funcall.s_else)) {
                    n = 1;
                }
            }
            else {
                final Value resolveValue2 = valueVector.get(j).resolveValue(context);
                if (context.returning()) {
                    value2 = context.getReturnValue();
                    break;
                }
                value2 = resolveValue2;
            }
        }
        return value2;
    }
}
