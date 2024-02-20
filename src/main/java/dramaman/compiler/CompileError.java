package dramaman.compiler;

import java.io.Writer;
import java.io.PrintWriter;
import java.io.StringWriter;

public class CompileError extends Error
{
    protected static String fullErrorString(final String s, final Throwable t) {
        final StringWriter stringWriter = new StringWriter();
        t.printStackTrace(new PrintWriter(stringWriter));
        return s + t.getMessage() + stringWriter;
    }
    
    public CompileError() {
    }
    
    public CompileError(final String s) {
        super(s);
    }
    
    public CompileError(final String s, final Throwable t) {
        super(fullErrorString(s, t));
    }
}
