package abl.runtime;

import java.io.Writer;
import java.io.PrintWriter;
import java.io.StringWriter;

public class RuntimeError extends Error
{
    protected static String fullErrorString(final String s, final Throwable t) {
        final StringWriter stringWriter = new StringWriter();
        t.printStackTrace(new PrintWriter(stringWriter));
        return s + t.getMessage() + stringWriter;
    }
    
    public RuntimeError(final String s) {
        super(s);
    }
    
    public RuntimeError(final String s, final Throwable t) {
        super(fullErrorString(s, t));
    }
}
