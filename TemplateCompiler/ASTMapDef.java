package TemplateCompiler;

import java.io.IOException;
import java.io.BufferedWriter;
import java.util.HashSet;

public class ASTMapDef extends ASTJessRule
{
    private static final /* synthetic */ boolean $noassert;
    
    public void AddDef(final HashSet set) throws CompileException {
        final Token next = this.firstToken.next.next;
        final String image = next.image;
        final String image2 = next.next.image;
        try {
            Class.forName("facade.characters.wmedef." + image2);
        }
        catch (ClassNotFoundException ex) {
            throw new CompileException(this.getFirstLineNumber(), ex.getMessage());
        }
        set.add("(assert (DefMap " + image + ' ' + image2 + "))");
    }
    
    public void compileToJess(final BufferedWriter bufferedWriter) throws IOException {
        if (!ASTMapDef.$noassert) {
            throw new AssertionError((Object)"Don't call compileToJess on ASTMapDef");
        }
    }
    
    public ASTMapDef(final int n) {
        super(n);
    }
    
    public ASTMapDef(final NLU nlu, final int n) {
        super(nlu, n);
    }
    
    static {
        $noassert = (Class.forName("[LTemplateCompiler.ASTMapDef;").getComponentType().desiredAssertionStatus() ^ true);
    }
}
