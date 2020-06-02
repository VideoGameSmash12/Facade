package TemplateCompiler;

import java.io.IOException;
import java.io.StringWriter;

class ASTRHside extends ASTJessRule
{
    void compileToJess(final StringWriter stringWriter) throws IOException {
        final String dumpTokens = this.dumpTokens();
        stringWriter.write("\n(");
        if (dumpTokens.indexOf("(", 2) > 0) {
            stringWriter.write(dumpTokens.substring(2, dumpTokens.indexOf("(", 2) - 1));
        }
        else {
            stringWriter.write(dumpTokens.substring(2, dumpTokens.indexOf(")", 2) - 1));
        }
        if (this.children != null) {
            for (int i = 0; i < this.children.length; ++i) {
                final ASTRHside astrHside = (ASTRHside)this.children[i];
                if (astrHside != null) {
                    astrHside.compileToJess(stringWriter);
                }
            }
        }
        stringWriter.write(")");
        stringWriter.flush();
    }
    
    ASTRHside(final int n) {
        super(n);
    }
    
    ASTRHside(final NLU nlu, final int n) {
        super(nlu, n);
    }
}
