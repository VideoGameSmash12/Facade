package TemplateCompiler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.io.BufferedWriter;
import java.util.List;

class ASTPositional extends ASTJessRule implements NLUConstants, PatternProducingNode
{
    private final List arguments;
    private final List variables;
    
    void compileToJess(final BufferedWriter bufferedWriter) throws CompileException {
        this.patternHead = this.firstToken.next.image;
        this.ruleName = "";
        Token token;
        for (token = this.firstToken.next.next; token != this.lastToken; token = token.next) {
            this.arguments.add(token.image);
            if (token.kind == 52) {
                this.variables.add(token.image);
            }
        }
        if (!this.isDeclaredFact(this.patternHead)) {
            throw new CompileException("Positional fact " + this.patternHead + " on line " + token.beginLine + " has not been declared");
        }
        if (this.arguments.size() > this.getNumberOfArgumentsForDeclaredFact(this.patternHead) - 2) {
            throw new CompileException("Number of variable arguments for positional fact " + this.patternHead + " on line " + token.beginLine + " exceeds the number of declared arguments for the positional fact");
        }
    }
    
    public String getPatternToMatch(final int n) {
        final StringBuffer sb = new StringBuffer(100);
        if (n != -1) {
            sb.append("(" + this.patternHead + " ?startpos" + n + " ?endpos" + n);
        }
        else {
            sb.append("(" + this.patternHead + " ?startpos ?endpos");
        }
        final int n2 = this.getNumberOfArgumentsForDeclaredFact(this.patternHead) - this.arguments.size() - 2;
        if (this.arguments.size() != 0 || n2 > 0) {
            sb.append(" ");
        }
        if (this.arguments.size() != 0) {
            final Iterator iterator = this.arguments.iterator();
            while (iterator.hasNext()) {
                sb.append(iterator.next());
                if (iterator.hasNext()) {
                    sb.append(" ");
                }
            }
        }
        if (n2 > 0) {
            sb.append(" ");
            for (int i = 0; i < n2 - 1; ++i) {
                sb.append("? ");
            }
            sb.append("?");
        }
        sb.append(")");
        return sb.toString();
    }
    
    boolean isRegexp() {
        return true;
    }
    
    public HashSet getPatternBindingVariables() {
        return new HashSet(this.variables);
    }
    
    public List getPatternBindingVariablesCanonical() {
        return new ArrayList(this.variables);
    }
    
    private final /* synthetic */ void this() {
        this.arguments = new ArrayList();
        this.variables = new ArrayList();
    }
    
    ASTPositional(final int n) {
        super(n);
        this.this();
    }
    
    ASTPositional(final NLU nlu, final int n) {
        super(nlu, n);
        this.this();
    }
}
