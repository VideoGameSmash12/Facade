package scope;

public class ScopeError extends Error
{
    public ScopeError(final ScopeException ex) {
        super(ex.getMessage());
    }
}
