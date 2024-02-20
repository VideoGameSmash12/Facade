package scope;

public class UndefinedVariableError extends ScopeError
{
    public UndefinedVariableError(final UndefinedVariableException ex) {
        super(ex);
    }
}
