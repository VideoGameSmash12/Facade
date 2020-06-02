package dramaman.runtime;

import java.io.Writer;
import java.io.PrintWriter;
import java.io.StringWriter;

public class DramaManagerError extends Error
{
    protected static String fullErrorString(final String s, final Throwable t) {
        final StringWriter stringWriter = new StringWriter();
        t.printStackTrace(new PrintWriter(stringWriter));
        return s + t.getMessage() + stringWriter;
    }
    
    public DramaManagerError(final String s) {
        super(s);
    }
    
    public DramaManagerError(final Throwable t) {
        super(fullErrorString("", t));
    }
}
