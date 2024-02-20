package TemplateCompiler;

public class NLUNode extends SimpleNode implements Node
{
    public Token firstToken;
    public Token lastToken;
    
    public NLUNode(final int n) {
        super(n);
    }
    
    public NLUNode(final NLU nlu, final int n) {
        super(nlu, n);
    }
}
