package TemplateCompiler;

import java.io.IOException;
import java.io.BufferedWriter;

public class ASTTopLevel extends ASTJessRule
{
    public void compileToJess(final BufferedWriter bufferedWriter) throws IOException, CompileException {
        for (int i = 0; i < this.children.length; ++i) {
            final ASTStart astStart = (ASTStart)this.children[i];
            if (astStart != null) {
                astStart.compileToJess(bufferedWriter);
            }
        }
    }
    
    public ASTTopLevel(final int n) {
        super(n);
    }
    
    public ASTTopLevel(final NLU nlu, final int n) {
        super(nlu, n);
    }
}
