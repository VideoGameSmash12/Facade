package jess;

import java.io.Serializable;

class StrCat implements Userfunction, Serializable
{
    public String getName() {
        return "str-cat";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final Value resolveValue = valueVector.get(1).resolveValue(context);
        if (valueVector.size() == 2 && resolveValue.type() == 2) {
            return resolveValue;
        }
        final StringBuffer sb = new StringBuffer("");
        for (int i = 1; i < valueVector.size(); ++i) {
            final Value resolveValue2 = valueVector.get(i).resolveValue(context);
            if (resolveValue2.type() == 2) {
                sb.append(resolveValue2.stringValue(context));
            }
            else if (resolveValue2.type() == 2048) {
                sb.append(resolveValue2.externalAddressValue(context).toString());
            }
            else {
                sb.append(resolveValue2.toString());
            }
        }
        return new Value(sb.toString(), 2);
    }
}
