package wm;

public class IncompatibleWmeClassException extends WorkingMemoryException
{
    private static final String errorString = "Attempt to modify a WME with an incompatible WME class";
    
    public IncompatibleWmeClassException() {
        super("Attempt to modify a WME with an incompatible WME class");
    }
    
    public IncompatibleWmeClassException(final String s) {
        super("Attempt to modify a WME with an incompatible WME class: " + s);
    }
}
