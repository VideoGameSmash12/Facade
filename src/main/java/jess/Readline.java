package jess;

import java.io.Serializable;

class Readline implements Userfunction, Serializable
{
    public String getName() {
        return "readline";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        String stringValue = "t";
        if (valueVector.size() > 1) {
            stringValue = valueVector.get(1).stringValue(context);
        }
        final Rete engine = context.getEngine();
        final String line = engine.getInputWrapper(engine.getInputRouter(stringValue)).readLine();
        if (line == null) {
            return Funcall.EOF;
        }
        return new Value(line, 2);
    }
}
