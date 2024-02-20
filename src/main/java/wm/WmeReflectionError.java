package wm;

public class WmeReflectionError extends WorkingMemoryError
{
    private static final String errorString = "Error reflecting WME class";
    
    public WmeReflectionError() {
        super("Error reflecting WME class");
    }
    
    public WmeReflectionError(final String s) {
        super("Error reflecting WME class: " + s);
    }
    
    public WmeReflectionError(final Throwable t) {
        super("Error reflecting WME class", t);
    }
}
