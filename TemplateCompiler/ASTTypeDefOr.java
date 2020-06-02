package TemplateCompiler;

import java.util.Vector;

public class ASTTypeDefOr extends ASTJessRule
{
    public Vector extractargs() {
        final Vector<String> vector = new Vector<String>();
        for (int i = 0; i < this.children.length; ++i) {
            final ASTTypeDefArg astTypeDefArg = (ASTTypeDefArg)this.children[i];
            if (astTypeDefArg != null) {
                vector.addElement(astTypeDefArg.extractargs());
            }
        }
        return vector;
    }
    
    public ASTTypeDefOr(final int n) {
        super(n);
    }
    
    public ASTTypeDefOr(final NLU nlu, final int n) {
        super(nlu, n);
    }
}
