package jess;

import java.io.Serializable;

class SymCat implements Userfunction, Serializable
{
    public String getName() {
        return "sym-cat";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final StringBuffer sb = new StringBuffer("");
        for (int i = 1; i < valueVector.size(); ++i) {
            final Value resolveValue = valueVector.get(i).resolveValue(context);
            if (resolveValue.type() == 2) {
                sb.append(resolveValue.stringValue(context));
            }
            else if (resolveValue.type() == 2048) {
                sb.append(resolveValue.externalAddressValue(context).toString());
            }
            else {
                sb.append(resolveValue.toString());
            }
        }
        return new Value(sb.toString(), 1);
    }
}
