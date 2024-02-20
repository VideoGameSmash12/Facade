package TemplateCompiler;

import java.io.IOException;
import java.util.Iterator;
import java.io.BufferedWriter;

class ASTOand extends ASTJessRule implements NLUTreeConstants, PatternProducingNode
{
    private final void checkVariableBindings() throws CompileException {
        for (int i = 0; i < this.jjtGetNumChildren(); ++i) {
            if (((ASTTemplate)this.jjtGetChild(i)).getChildNodeID() == 18) {
                throw new CompileException("Line " + this.getFirstLineNumber() + ": A known compiler bug incorrectly handles nested opt expressions within tand expressions. Such nesting is currently disallowed.");
            }
        }
    }
    
    void compileToJess(final BufferedWriter bufferedWriter) throws IOException, CompileException {
        this.checkVariableBindings();
        final StringBuffer sb = new StringBuffer(100);
        final StringBuffer sb2 = new StringBuffer(100);
        sb.append("(min");
        sb2.append("(max");
        final StringBuffer sb3 = new StringBuffer(100);
        final StringBuffer sb4 = new StringBuffer(100);
        final String id = this.getID(this.dumpTokens());
        sb3.append("(definerule occursandtest" + id + ' ' + NLU.salience + ' ');
        sb3.append(" \" (declare (salience " + NLU.salience + ")) ");
        for (int i = 0; i < this.children.length; ++i) {
            final ASTTemplate astTemplate = (ASTTemplate)this.children[i];
            if (astTemplate != null) {
                sb4.append(astTemplate.getPatternToMatch(i + 1));
                sb.append(" ?startpos");
                sb.append(Integer.toString(i + 1));
                sb2.append(" ?endpos");
                sb2.append(Integer.toString(i + 1));
            }
        }
        sb3.append(sb4.toString() + " => ");
        this.patternHead = "occurs-and" + id;
        this.ruleName = "occursandtest" + id;
        sb.append(")");
        sb2.append(")");
        sb3.append("(assert(occurs-and" + id + ' ' + sb.toString() + ' ' + sb2.toString());
        final Iterator<Object> iterator = this.getPatternBindingVariablesCanonical().iterator();
        while (iterator.hasNext()) {
            sb3.append(" " + iterator.next());
        }
        sb3.append("))\")\n\n");
        bufferedWriter.write(sb3.toString());
    }
    
    boolean isRegexp() {
        return false;
    }
    
    ASTOand(final int n) {
        super(n);
    }
    
    ASTOand(final NLU nlu, final int n) {
        super(nlu, n);
    }
}
