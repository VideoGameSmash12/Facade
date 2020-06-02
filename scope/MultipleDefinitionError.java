package scope;

public class MultipleDefinitionError extends ScopeError
{
    public MultipleDefinitionError(final MultipleDefinitionException ex) {
        super(ex);
    }
}
