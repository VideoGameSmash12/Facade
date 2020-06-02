package jess;

import java.io.Reader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.io.FileReader;
import java.io.Serializable;

class Batch implements Userfunction, Serializable
{
    static /* synthetic */ Class class$jess$Rete;
    
    public String getName() {
        return "batch";
    }
    
    public Value batch(final String s, final Rete rete) throws JessException {
        Value value = Funcall.FALSE;
        Reader reader = null;
        try {
            try {
                if (rete.getApplet() == null) {
                    reader = new FileReader(s);
                }
                else {
                    reader = new InputStreamReader(new URL(rete.getApplet().getDocumentBase(), s).openStream());
                }
            }
            catch (Exception ex) {
                final Class appObjectClass = rete.getAppObjectClass();
                URL url = appObjectClass.getResource(s);
                if (url == null) {
                    final Class clazz = appObjectClass;
                    Class class$jess$Rete;
                    if ((class$jess$Rete = Batch.class$jess$Rete) == null) {
                        class$jess$Rete = (Batch.class$jess$Rete = class$("[Ljess.Rete;", false));
                    }
                    if (clazz != class$jess$Rete) {
                        Class class$jess$Rete2;
                        if ((class$jess$Rete2 = Batch.class$jess$Rete) == null) {
                            class$jess$Rete2 = (Batch.class$jess$Rete = class$("[Ljess.Rete;", false));
                        }
                        url = class$jess$Rete2.getResource(s);
                    }
                }
                if (url == null) {
                    throw new JessException("batch", "Cannot open file", ex);
                }
                reader = new InputStreamReader(url.openStream());
            }
            value = new Jesp(reader, rete).parse(false);
        }
        catch (IOException ex2) {
            throw new JessException("batch", "I/O Exception", ex2);
        }
        finally {
            if (reader != null) {
                try {
                    reader.close();
                }
                catch (IOException ex3) {}
            }
        }
        if (reader != null) {
            try {
                reader.close();
            }
            catch (IOException ex4) {}
        }
        return value;
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        return this.batch(valueVector.get(1).stringValue(context), context.getEngine());
    }
    
    static /* synthetic */ Class class$(final String s, final boolean b) {
        try {
            final Class<?> forName = Class.forName(s);
            if (!b) {
                forName.getComponentType();
            }
            return forName;
        }
        catch (ClassNotFoundException ex) {
            throw new NoClassDefFoundError(ex.getMessage());
        }
    }
}
