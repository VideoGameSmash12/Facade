package TemplateCompiler;

import java.util.HashSet;
import java.io.IOException;
import java.io.StringWriter;

public class ASTLHside extends ASTRHside
{
    public void compileToJess(final StringWriter stringWriter) throws IOException {
        stringWriter.write(this.dumpTokens() + ' ');
    }
    
    public void typeCheck(final HashSet set) throws CompileException {
        super.typeCheck(set);
    }
    
    public ASTLHside(final int n) {
        super(n);
    }
    
    public ASTLHside(final NLU nlu, final int n) {
        super(nlu, n);
    }
}
