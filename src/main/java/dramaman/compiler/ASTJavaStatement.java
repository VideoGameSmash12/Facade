package dramaman.compiler;

public class ASTJavaStatement extends VariableContainer
{
    public ASTJavaStatement(final int n) {
        super(n);
    }
    
    public ASTJavaStatement(final BeatParser beatParser, final int n) {
        super(beatParser, n);
    }
}
