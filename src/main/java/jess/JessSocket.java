package jess;

import java.io.IOException;
import java.io.Writer;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.io.Serializable;

class JessSocket implements Userfunction, Serializable
{
    public String getName() {
        return "socket";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final String stringValue = valueVector.get(1).stringValue(context);
        final int intValue = valueVector.get(2).intValue(context);
        final String stringValue2 = valueVector.get(3).stringValue(context);
        try {
            final Socket socket = new Socket(stringValue, intValue);
            final Rete engine = context.getEngine();
            engine.addInputRouter(stringValue2, new InputStreamReader(socket.getInputStream()), false);
            engine.addOutputRouter(stringValue2, new PrintWriter(socket.getOutputStream()));
            return valueVector.get(3);
        }
        catch (IOException ex) {
            throw new JessException("socket", "I/O Exception", ex);
        }
    }
}
