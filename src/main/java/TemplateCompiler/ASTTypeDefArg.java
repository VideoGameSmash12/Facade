package TemplateCompiler;

public class ASTTypeDefArg extends ASTJessRule
{
    public String extractargs() {
        return this.dumpTokens();
    }
    
    public ASTTypeDefArg(final int n) {
        super(n);
    }
    
    public ASTTypeDefArg(final NLU nlu, final int n) {
        super(nlu, n);
    }
}
