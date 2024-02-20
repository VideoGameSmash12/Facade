package dramaman.compiler;

public class ASTFileName extends BeatParseNode
{
    public ASTFileName(final int n) {
        super(n);
    }
    
    public ASTFileName(final BeatParser beatParser, final int n) {
        super(beatParser, n);
    }
}
