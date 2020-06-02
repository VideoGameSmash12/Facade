package TemplateCompiler;

import java.io.IOException;
import java.io.BufferedWriter;
import java.util.HashSet;

class ASTOor extends ASTJessRule implements NLUTreeConstants, PatternProducingNode
{
    private final void checkVariableBindings() throws CompileException {
        final HashSet patternBindingVariables = ((ASTTemplate)this.jjtGetChild(0)).getPatternBindingVariables();
        for (int i = 1; i < this.jjtGetNumChildren(); ++i) {
            if (!patternBindingVariables.equals(((ASTTemplate)this.jjtGetChild(i)).getPatternBindingVariables())) {
                throw new CompileException(this.getFirstLineNumber() + " Variable bindings introduced by positional facts must be equal across all branches of the occurs-or");
            }
        }
    }
    
    void compileToJess(final BufferedWriter bufferedWriter) throws IOException, CompileException {
        this.checkVariableBindings();
        final String id = this.getID(this.dumpTokens());
        this.patternHead = "occurs-or" + id;
        for (int i = 0; i < this.children.length; ++i) {
            final ASTTemplate astTemplate = (ASTTemplate)this.children[i];
            if (astTemplate != null) {
                final String id2 = this.getID(astTemplate.dumpTokens() + " occurs-or" + id);
                bufferedWriter.write("(definerule occursortest" + id2 + ' ' + NLU.salience + " \" (declare (salience " + NLU.salience + ")) " + astTemplate.getPatternToMatch(0) + " => (assert" + this.getPatternToMatch(0) + ")\")\n\n");
                this.ruleName = this.ruleName + "occursortest" + id2 + ' ';
            }
        }
    }
    
    boolean isRegexp() {
        return false;
    }
    
    ASTOor(final int n) {
        super(n);
    }
    
    ASTOor(final NLU nlu, final int n) {
        super(nlu, n);
    }
}
