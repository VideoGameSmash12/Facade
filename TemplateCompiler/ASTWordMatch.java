package TemplateCompiler;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.io.IOException;
import java.io.BufferedWriter;

class ASTWordMatch extends ASTJessRule implements PatternProducingNode
{
    void compileToJess(final BufferedWriter bufferedWriter) throws IOException {
        this.patternHead = "wo-" + Preprocessor.replaceAll(Preprocessor.replaceAll(Preprocessor.replaceAll(this.dumpTokens(), "(", "\\\\("), ")", "\\\\)"), ";", "\\\\;");
        this.ruleName = "";
    }
    
    boolean isRegexp() {
        return true;
    }
    
    public HashSet getPatternBindingVariables() {
        return new HashSet();
    }
    
    public List getPatternBindingVariablesCanonical() {
        return new ArrayList();
    }
    
    ASTWordMatch(final int n) {
        super(n);
    }
    
    ASTWordMatch(final NLU nlu, final int n) {
        super(nlu, n);
    }
}
