package TemplateCompiler;

import java.io.IOException;
import java.io.BufferedWriter;

class ASTRegexpopt extends ASTJessRule implements NLUTreeConstants, PatternProducingNode
{
    void compileToJess(final BufferedWriter bufferedWriter) throws IOException {
        final ASTTemplate astTemplate = (ASTTemplate)this.children[0];
        final String id = this.getID(this.dumpTokens());
        this.ruleName = "opttest" + id;
        this.patternHead = "optoc-" + id;
        bufferedWriter.write("(definerule opttest" + id + ' ' + NLU.salience + " \" (declare (salience " + NLU.salience + ")) " + astTemplate.getPatternToMatch(0) + " => (assert" + this.getPatternToMatch(0) + ")\")\n\n");
    }
    
    boolean isRegexp() {
        return true;
    }
    
    ASTRegexpopt(final int n) {
        super(n);
    }
    
    ASTRegexpopt(final NLU nlu, final int n) {
        super(nlu, n);
    }
}
