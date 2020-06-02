package scope;

public class VariableScopeThrowsErrors extends VariableScope
{
    public void defineVariable(final String s, final Object o, final String s2) {
        try {
            super.defineVariable(s, o, s2);
        }
        catch (MultipleDefinitionException ex) {
            throw new MultipleDefinitionError(ex);
        }
    }
    
    public String getType(final String s) {
        try {
            return super.getType(s);
        }
        catch (UndefinedVariableException ex) {
            throw new UndefinedVariableError(ex);
        }
    }
    
    public Object getValue(final String s) {
        try {
            return super.getValue(s);
        }
        catch (UndefinedVariableException ex) {
            throw new UndefinedVariableError(ex);
        }
        catch (TypeException ex2) {
            throw new TypeError(ex2);
        }
    }
    
    public Object setValue(final String s, final Object o) {
        try {
            return super.setValue(s, o);
        }
        catch (UndefinedVariableException ex) {
            throw new UndefinedVariableError(ex);
        }
        catch (TypeException ex2) {
            throw new TypeError(ex2);
        }
    }
    
    public Variable getVariable(final String s) {
        try {
            return super.getVariable(s);
        }
        catch (UndefinedVariableException ex) {
            throw new UndefinedVariableError(ex);
        }
        catch (TypeException ex2) {
            throw new TypeError(ex2);
        }
    }
    
    public Variable getParentVariable(final String s) {
        try {
            return super.getParentVariable(s);
        }
        catch (UndefinedVariableException ex) {
            throw new UndefinedVariableError(ex);
        }
        catch (TypeException ex2) {
            throw new TypeError(ex2);
        }
    }
    
    public VariableScopeThrowsErrors(final VariableScope variableScope, final String s) {
        super(variableScope, s);
    }
}
