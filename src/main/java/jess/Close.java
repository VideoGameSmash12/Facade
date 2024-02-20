package jess;

import java.io.Reader;
import java.io.Writer;
import java.io.IOException;
import java.io.Serializable;

class Close implements Userfunction, Serializable
{
    public String getName() {
        return "close";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final Rete engine = context.getEngine();
        if (valueVector.size() > 1) {
            for (int i = 1; i < valueVector.size(); ++i) {
                final String stringValue = valueVector.get(i).stringValue(context);
                try {
                    final Writer outputRouter;
                    if ((outputRouter = engine.getOutputRouter(stringValue)) != null) {
                        outputRouter.close();
                        engine.removeOutputRouter(stringValue);
                    }
                }
                catch (IOException ex) {}
                try {
                    final Reader inputRouter;
                    if ((inputRouter = engine.getInputRouter(stringValue)) != null) {
                        inputRouter.close();
                        engine.removeInputRouter(stringValue);
                    }
                }
                catch (IOException ex2) {}
            }
            return Funcall.TRUE;
        }
        throw new JessException("close", "Must close files by name", "");
    }
}
