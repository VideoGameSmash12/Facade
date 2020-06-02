package dramaman.compiler;

public class ScopeException extends CompileException
{
    private static final String errorString = "Undeclared variable";
    
    public ScopeException() {
        super("Undeclared variable");
    }
    
    public ScopeException(final String s) {
        super("Undeclared variable: " + s);
    }
}
