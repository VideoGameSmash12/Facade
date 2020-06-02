package jess;

import java.io.Serializable;

class CallOnEngine implements Userfunction, Serializable
{
    public String getName() {
        return "call-on-engine";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final Rete rete = (Rete)valueVector.get(1).externalAddressValue(context);
        Value value = Funcall.NIL;
        final Context context2 = new Context(context, rete);
        for (int i = 2; i < valueVector.size(); ++i) {
            value = valueVector.get(i).funcallValue(context2).execute(context2);
        }
        return value.resolveValue(context2);
    }
}
