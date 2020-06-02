package jess;

import java.io.Serializable;

class Foreach implements Userfunction, Serializable
{
    public String getName() {
        return "foreach";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final String variableValue = valueVector.get(1).variableValue(context);
        final ValueVector listValue = valueVector.get(2).listValue(context);
        Value value = Funcall.NIL;
        for (int i = 0; i < listValue.size(); ++i) {
            context.setVariable(variableValue, listValue.get(i).resolveValue(context));
            for (int j = 3; j < valueVector.size(); ++j) {
                value = valueVector.get(j).resolveValue(context);
                if (context.returning()) {
                    return context.getReturnValue();
                }
            }
        }
        return value;
    }
}
