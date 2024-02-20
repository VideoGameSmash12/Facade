package jess;

import java.io.Serializable;

class Update implements Userfunction, Serializable
{
    public String getName() {
        return "update";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        Value updateObject = null;
        final Rete engine = context.getEngine();
        for (int i = 1; i < valueVector.size(); ++i) {
            updateObject = engine.updateObject(valueVector.get(i).externalAddressValue(context));
        }
        if (updateObject != null) {
            return updateObject;
        }
        return Funcall.FALSE;
    }
}
