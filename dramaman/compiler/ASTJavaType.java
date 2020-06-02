package dramaman.compiler;

public class ASTJavaType extends BeatParseNode
{
    public ASTJavaType(final int n) {
        super(n);
    }
    
    public ASTJavaType(final BeatParser beatParser, final int n) {
        super(beatParser, n);
    }
}
