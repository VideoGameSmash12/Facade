package wm;

public class NonexistentWmeException extends WorkingMemoryException
{
    private static final String errorString = "Attempt to modify a WME which doesn't exist in working memory";
    
    public NonexistentWmeException() {
        super("Attempt to modify a WME which doesn't exist in working memory");
    }
    
    public NonexistentWmeException(final String s) {
        super("Attempt to modify a WME which doesn't exist in working memory: " + s);
    }
}
