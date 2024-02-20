package dramaman.compiler;

public class ASTVariableInitializer extends VariableContainer
{
    public ASTVariableInitializer(final int n) {
        super(n);
    }
    
    public ASTVariableInitializer(final BeatParser beatParser, final int n) {
        super(beatParser, n);
    }
}
