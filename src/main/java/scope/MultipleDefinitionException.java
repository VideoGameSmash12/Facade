package scope;

public class MultipleDefinitionException extends ScopeException
{
    public MultipleDefinitionException() {
    }
    
    public MultipleDefinitionException(final String s) {
        super(s);
    }
    
    public MultipleDefinitionException(final String s, final String s2) {
        super("Attempt to multiply define variable " + s + " in scope " + s2);
    }
}
