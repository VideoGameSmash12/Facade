package jess;

import java.net.URLConnection;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.io.IOException;
import java.io.FileWriter;
import java.io.Serializable;

class SaveFacts implements Userfunction, Serializable
{
    public String getName() {
        return "save-facts";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final Rete engine = context.getEngine();
        OutputStreamWriter outputStreamWriter;
        if (engine.getApplet() == null) {
            try {
                outputStreamWriter = new FileWriter(valueVector.get(1).stringValue(context));
            }
            catch (IOException ex) {
                throw new JessException("save-facts", "I/O Exception", ex);
            }
        }
        else {
            try {
                final URLConnection openConnection = new URL(engine.getApplet().getDocumentBase(), valueVector.get(1).stringValue(context)).openConnection();
                openConnection.setDoOutput(true);
                outputStreamWriter = new OutputStreamWriter(openConnection.getOutputStream());
            }
            catch (Exception ex2) {
                throw new JessException("save-facts", "Network error", ex2);
            }
        }
        try {
            Label_0175: {
                if (valueVector.size() > 2) {
                    for (int i = 2; i < valueVector.size(); ++i) {
                        engine.ppFacts(valueVector.get(i).stringValue(context), outputStreamWriter);
                    }
                    break Label_0175;
                }
                engine.ppFacts(outputStreamWriter);
                break Label_0175;
            }
            goto Label_0199;
        }
        catch (IOException ex3) {
            throw new JessException("save-facts", "I/O Exception", ex3);
        }
        finally {
            outputStreamWriter.close();
        }
        return Funcall.TRUE;
    }
}
