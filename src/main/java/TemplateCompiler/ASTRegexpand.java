package TemplateCompiler;

import java.util.Vector;
import java.util.HashSet;
import java.util.Iterator;
import java.io.IOException;
import java.io.BufferedWriter;
import java.util.List;

class ASTRegexpand extends ASTJessRule implements NLUTreeConstants, PatternProducingNode
{
    private List subrules;
    
    private final void compileAndVariants(boolean[] array, final int n, final int n2, final BufferedWriter bufferedWriter, final String s) throws IOException {
        if (array == null) {
            array = new boolean[n2];
            for (int i = 0; i < array.length; ++i) {
                array[i] = true;
            }
        }
        if (n == n2) {
            this.compileRule(bufferedWriter, s, array);
        }
        else {
            array[n] = true;
            this.compileAndVariants(array, n + 1, n2, bufferedWriter, s);
            array[n] = false;
            this.compileAndVariants(array, n + 1, n2, bufferedWriter, s);
        }
    }
    
    private final void compileRule(final BufferedWriter bufferedWriter, final String s, final boolean[] array) throws IOException {
        int n = 0;
        int n2 = 0;
        boolean b = false;
        final StringBuffer sb = new StringBuffer();
        final StringBuffer sb2 = new StringBuffer();
        final StringBuffer sb3 = new StringBuffer("(");
        for (int i = 0; i < this.children.length; ++i) {
            final ASTTemplate astTemplate = (ASTTemplate)this.children[i];
            if (astTemplate != null) {
                final String patternToMatch = astTemplate.getPatternToMatch(n2);
                final int parseNodeID = ((SimpleNode)astTemplate.children[0]).getParseNodeID();
                if ((parseNodeID == 18 && array[n++]) || parseNodeID != 18) {
                    sb3.append(" " + astTemplate.dumpTokens());
                    sb.append(patternToMatch);
                    final boolean regexp = astTemplate.isRegexp();
                    if (b && regexp && n2 > 0) {
                        sb2.append(" (test (MyEquals ?startpos" + n2);
                        sb2.append(" (MyPlus ?endpos" + (n2 - 1));
                        sb2.append(" 1)))");
                    }
                    else if ((b || regexp) && n2 > 0) {
                        sb2.append(" (test (MyGreater ?startpos" + n2);
                        sb2.append(" ?endpos" + (n2 - 1));
                        sb2.append("))");
                    }
                    ++n2;
                    b = regexp;
                }
            }
        }
        sb3.append(" ) ");
        sb3.append(this.dumpTokens());
        final StringBuffer sb4 = new StringBuffer();
        final String string = "andtest" + this.getID(sb3.toString());
        this.subrules.add(string);
        sb4.append("(definerule " + string + ' ' + NLU.salience + ' ');
        sb4.append(" \" (declare (salience " + NLU.salience + ")) ");
        sb4.append(sb);
        sb4.append(sb2);
        sb4.append(" => ");
        sb4.append("(assert(po-" + s + " ?startpos0 ?endpos" + (n2 - 1));
        final Iterator<Object> iterator = (Iterator<Object>)this.getPatternBindingVariablesCanonical().iterator();
        while (iterator.hasNext()) {
            sb4.append(" " + iterator.next());
        }
        sb4.append("))\")\n\n");
        bufferedWriter.write(sb4.toString());
    }
    
    private final void checkVariableBindings() throws CompileException {
        HashSet patternBindingVariables = new HashSet();
        for (int i = 0; i < this.jjtGetNumChildren(); ++i) {
            final ASTTemplate astTemplate = (ASTTemplate)this.jjtGetChild(i);
            if (astTemplate.getChildNodeID() == 18) {
                patternBindingVariables = astTemplate.getPatternBindingVariables();
                if (patternBindingVariables.size() > 0) {
                    break;
                }
            }
        }
        if (patternBindingVariables.size() > 0) {
            boolean b = false;
            for (int j = 0; j < this.jjtGetNumChildren(); ++j) {
                final ASTTemplate astTemplate2 = (ASTTemplate)this.jjtGetChild(j);
                if (astTemplate2.getChildNodeID() == 18) {
                    if (!astTemplate2.getPatternBindingVariables().equals(patternBindingVariables)) {
                        throw new CompileException("Line " + this.getFirstLineNumber() + ": If a regexp-opt subexpression of a regexp-and expression binds variables, the same variables must be bound by all regexp-opt subexpressions of the regexp-and expression");
                    }
                }
                else if (astTemplate2.getPatternBindingVariables().equals(patternBindingVariables)) {
                    b = true;
                }
            }
            if (!b) {
                throw new CompileException("Line " + this.getFirstLineNumber() + ": If a regexp-opt subexpression of a regexp-and expression binds variables, at least one non-opt subexpression must bind the same variables as the opt subexpression");
            }
        }
    }
    
    void compileToJess(final BufferedWriter bufferedWriter) throws IOException, CompileException {
        int n = 0;
        for (int i = 0; i < this.jjtGetNumChildren(); ++i) {
            if (((SimpleNode)((ASTTemplate)this.jjtGetChild(i)).children[0]).getParseNodeID() == 18) {
                ++n;
            }
        }
        if (n == this.jjtGetNumChildren()) {
            throw new CompileException("An 'and' regular expression can not consist solely of optional expressions");
        }
        if (n > 0) {
            this.checkVariableBindings();
        }
        final String id = this.getID(this.dumpTokens());
        this.patternHead = "po-" + id;
        this.compileAndVariants(null, 0, n, bufferedWriter, id);
        final Iterator<String> iterator = this.subrules.iterator();
        while (iterator.hasNext()) {
            this.ruleName += iterator.next();
        }
    }
    
    boolean isRegexp() {
        return true;
    }
    
    private final /* synthetic */ void this() {
        this.subrules = new Vector();
    }
    
    ASTRegexpand(final int n) {
        super(n);
        this.this();
    }
    
    ASTRegexpand(final NLU nlu, final int n) {
        super(nlu, n);
        this.this();
    }
}
