package scope;

public class TypeError extends ScopeError
{
    public TypeError(final TypeException ex) {
        super(ex);
    }
}
