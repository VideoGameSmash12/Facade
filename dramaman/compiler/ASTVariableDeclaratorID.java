package dramaman.compiler;

public class ASTVariableDeclaratorID extends BeatParseNode
{
    public ASTVariableDeclaratorID(final int n) {
        super(n);
    }
    
    public ASTVariableDeclaratorID(final BeatParser beatParser, final int n) {
        super(beatParser, n);
    }
}
