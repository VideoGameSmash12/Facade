package TemplateCompiler;

import java.util.StringTokenizer;

public class ASTIncludeFile extends ASTJessRule
{
    String getfile() {
        final StringTokenizer stringTokenizer = new StringTokenizer(this.dumpTokens());
        stringTokenizer.nextToken();
        return stringTokenizer.nextToken();
    }
    
    public ASTIncludeFile(final int n) {
        super(n);
    }
    
    public ASTIncludeFile(final NLU nlu, final int n) {
        super(nlu, n);
    }
}
