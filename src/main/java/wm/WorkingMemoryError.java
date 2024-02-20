package wm;

import java.io.PrintWriter;
import java.io.PrintStream;

public class WorkingMemoryError extends Error
{
    private Throwable t;
    
    public void printStackTrace() {
        if (this.t != null) {
            System.err.println(this.getMessage());
            this.t.printStackTrace();
        }
        else {
            super.printStackTrace();
        }
    }
    
    public void printStackTrace(final PrintStream printStream) {
        if (this.t != null) {
            printStream.println(this.getMessage());
            this.t.printStackTrace(printStream);
        }
        else {
            super.printStackTrace(printStream);
        }
    }
    
    public void printStackTrace(final PrintWriter printWriter) {
        if (this.t != null) {
            printWriter.println(this.getMessage());
            this.t.printStackTrace(printWriter);
        }
        else {
            super.printStackTrace(printWriter);
        }
    }
    
    private final /* synthetic */ void this() {
        this.t = null;
    }
    
    public WorkingMemoryError() {
        this.this();
    }
    
    public WorkingMemoryError(final String s) {
        super(s);
        this.this();
    }
    
    public WorkingMemoryError(final String s, final Throwable t) {
        super(s);
        this.this();
        this.t = t;
    }
}
