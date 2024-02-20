package dramaman.compiler;

public class ASTConstantDeclaration extends BeatParseNode
{
    public ASTConstantDeclaration(final int n) {
        super(n);
    }
    
    public ASTConstantDeclaration(final BeatParser beatParser, final int n) {
        super(beatParser, n);
    }
}
