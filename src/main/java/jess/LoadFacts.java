package jess;

import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.net.URL;
import java.io.FileReader;
import java.io.Serializable;

class LoadFacts implements Userfunction, Serializable
{
    public String getName() {
        return "load-facts";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final Rete engine = context.getEngine();
        final String stringValue = valueVector.get(1).stringValue(context);
        InputStreamReader inputStreamReader;
        try {
            if (engine.getApplet() == null) {
                inputStreamReader = new FileReader(stringValue);
            }
            else {
                inputStreamReader = new InputStreamReader(new URL(engine.getApplet().getDocumentBase(), stringValue).openStream());
            }
        }
        catch (Exception ex) {
            try {
                final URL resource = engine.getAppObjectClass().getResource(stringValue);
                if (resource == null) {
                    throw new JessException("load-facts", "Cannot open file", ex);
                }
                inputStreamReader = new InputStreamReader(resource.openStream());
                return new Jesp(inputStreamReader, context.getEngine()).loadFacts(context);
            }
            catch (IOException ex2) {
                throw new JessException("load-facts", "Network error", ex2);
            }
        }
        return new Jesp(inputStreamReader, context.getEngine()).loadFacts(context);
    }
}
