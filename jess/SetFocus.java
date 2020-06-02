package jess;

import java.io.Serializable;

class SetFocus implements Userfunction, Serializable
{
    public String getName() {
        return "focus";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final Rete engine = context.getEngine();
        final String focus = engine.getFocus();
        for (int i = valueVector.size() - 1; i > 0; --i) {
            engine.setFocus(valueVector.get(i).stringValue(context));
        }
        return new Value(focus, 1);
    }
}
