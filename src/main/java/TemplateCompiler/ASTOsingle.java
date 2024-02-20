package TemplateCompiler;

import java.io.IOException;
import java.io.BufferedWriter;

class ASTOsingle extends ASTJessRule implements NLUTreeConstants, PatternProducingNode
{
    private static final /* synthetic */ boolean $noassert;
    
    void compileToJess(final BufferedWriter bufferedWriter) throws IOException {
        final ASTTemplate astTemplate = (ASTTemplate)this.children[0];
        if (!ASTOsingle.$noassert && astTemplate == null) {
            throw new AssertionError();
        }
        final String id = this.getID(this.dumpTokens());
        this.ruleName = "occurssingletest" + id;
        this.patternHead = "occurs-single" + id;
        bufferedWriter.write("(definerule occurssingletest" + id + ' ' + NLU.salience + " \" (declare (salience " + NLU.salience + ")) " + astTemplate.getPatternToMatch(0) + " => (assert" + this.getPatternToMatch(0) + ")\")\n\n");
    }
    
    boolean isRegexp() {
        return false;
    }
    
    ASTOsingle(final int n) {
        super(n);
    }
    
    ASTOsingle(final NLU nlu, final int n) {
        super(nlu, n);
    }
    
    static {
        $noassert = (Class.forName("[LTemplateCompiler.ASTOsingle;").getComponentType().desiredAssertionStatus() ^ true);
    }
}
