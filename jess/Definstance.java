package jess;

import java.io.Serializable;

class Definstance implements Userfunction, Serializable
{
    public String getName() {
        return "definstance";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final Value resolveValue = valueVector.get(2).resolveValue(context);
        if (resolveValue.equals(Funcall.NIL)) {
            throw new JessException("definstance", "Argument is nil:", resolveValue.toString());
        }
        final String stringValue = valueVector.get(1).stringValue(context);
        final Object externalAddressValue = resolveValue.externalAddressValue(context);
        boolean b = false;
        if (valueVector.size() < 4 || valueVector.get(3).equals("dynamic")) {
            b = true;
        }
        return context.getEngine().definstance(stringValue, externalAddressValue, b, context);
    }
}
