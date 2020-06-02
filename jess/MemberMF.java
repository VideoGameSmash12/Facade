package jess;

import java.io.Serializable;

class MemberMF implements Userfunction, Serializable
{
    public String getName() {
        return "member$";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final Value resolveValue = valueVector.get(1).resolveValue(context);
        final ValueVector listValue = valueVector.get(2).listValue(context);
        for (int i = 0; i < listValue.size(); ++i) {
            if (resolveValue.equals(listValue.get(i).resolveValue(context))) {
                return new Value(i + 1, 4);
            }
        }
        return Funcall.FALSE;
    }
}
