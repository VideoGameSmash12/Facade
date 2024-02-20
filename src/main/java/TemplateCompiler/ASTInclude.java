package TemplateCompiler;

public class ASTInclude extends SimpleNode
{
    public ASTInclude(final int n) {
        super(n);
    }
    
    public ASTInclude(final NLU nlu, final int n) {
        super(nlu, n);
    }
}
