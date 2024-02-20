package dramaman.compiler;

public class ASTImportDeclaration extends BeatParseNode
{
    public ASTImportDeclaration(final int n) {
        super(n);
    }
    
    public ASTImportDeclaration(final BeatParser beatParser, final int n) {
        super(beatParser, n);
    }
}
