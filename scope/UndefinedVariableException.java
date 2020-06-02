package scope;

public class UndefinedVariableException extends ScopeException
{
    public UndefinedVariableException() {
    }
    
    public UndefinedVariableException(final String s) {
        super(s);
    }
    
    public UndefinedVariableException(final String s, final String s2) {
        super("Variable " + s + " undefined in scope " + s2);
    }
}
