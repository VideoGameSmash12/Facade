package jess;

import java.io.Serializable;

class ReplaceMF implements Userfunction, Serializable
{
    public String getName() {
        return "replace$";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final ValueVector listValue = valueVector.get(1).listValue(context);
        int n = (int)valueVector.get(2).numericValue(context);
        int n2 = (int)valueVector.get(3).numericValue(context);
        if (n < 1 || n > listValue.size() + 1 || n2 < 1 || n2 > listValue.size() + 1 || n > n2) {
            throw new JessException("replace$", "index must be >= 1 and <= " + (listValue.size() + 1), ": " + n + ' ' + n2);
        }
        final ValueVector valueVector2 = new ValueVector();
        --n;
        --n2;
        for (int i = 0; i <= n - 1; ++i) {
            valueVector2.add(listValue.get(i).resolveValue(context));
        }
        for (int j = 4; j < valueVector.size(); ++j) {
            final Value resolveValue = valueVector.get(j).resolveValue(context);
            if (resolveValue.type() != 512) {
                valueVector2.add(resolveValue);
            }
            else {
                final ValueVector listValue2 = resolveValue.listValue(context);
                for (int k = 0; k < listValue2.size(); ++k) {
                    valueVector2.add(listValue2.get(k).resolveValue(context));
                }
            }
        }
        for (int l = n2 + 1; l < listValue.size(); ++l) {
            valueVector2.add(listValue.get(l).resolveValue(context));
        }
        return new Value(valueVector2, 512);
    }
}
