package jd;

import java.io.Writer;
import java.io.PrintWriter;
import java.io.StringWriter;

public class JavaDescriptorError extends Error
{
    protected static String fullErrorString(final String s, final Throwable t) {
        final StringWriter stringWriter = new StringWriter();
        t.printStackTrace(new PrintWriter(stringWriter));
        return s + t.getMessage() + stringWriter;
    }
    
    public JavaDescriptorError() {
    }
    
    public JavaDescriptorError(final String s) {
        super(s);
    }
    
    public JavaDescriptorError(final String s, final Throwable t) {
        super(fullErrorString(s, t));
    }
}
