package jess;

import java.io.Serializable;

class Read implements Userfunction, Serializable
{
    public String getName() {
        return "read";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        String stringValue = "t";
        if (valueVector.size() > 1) {
            stringValue = valueVector.get(1).stringValue(context);
        }
        final Rete engine = context.getEngine();
        final Tokenizer inputWrapper = engine.getInputWrapper(engine.getInputRouter(stringValue));
        if (inputWrapper == null) {
            throw new JessException("read", "bad router", stringValue);
        }
        final JessToken nextToken = inputWrapper.nextToken();
        if (engine.getInputMode(stringValue)) {
            inputWrapper.discardToEOL();
        }
        return nextToken.tokenToValue(null);
    }
}
