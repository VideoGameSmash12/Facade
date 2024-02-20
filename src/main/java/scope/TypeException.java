package scope;

public class TypeException extends ScopeException
{
    public TypeException() {
    }
    
    public TypeException(final String s) {
        super(s);
    }
    
    public TypeException(final String s, final String s2, final String s3, final String s4) {
        super("Attempt to treat variable " + s + " of type " + s3 + " as type " + s4 + " in scope " + s2);
    }
}
