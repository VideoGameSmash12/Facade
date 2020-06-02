package jess;

import java.io.Serializable;

class InstanceOf implements Userfunction, Serializable
{
    public String getName() {
        return "instanceof";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final Object externalAddressValue = valueVector.get(1).externalAddressValue(context);
        final String stringValue = valueVector.get(2).stringValue(context);
        try {
            return context.getEngine().findClass(stringValue).isInstance(externalAddressValue) ? Funcall.TRUE : Funcall.FALSE;
        }
        catch (ClassNotFoundException ex) {
            throw new JessException("instanceof", "Class not found: " + stringValue, ex);
        }
    }
}
