package TemplateCompiler;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.io.IOException;
import java.io.BufferedWriter;

class ASTTermExpand extends ASTJessRule implements PatternProducingNode
{
    private String word;
    
    void compileToJess(final BufferedWriter bufferedWriter) throws IOException, CompileException {
        this.word = this.dumpTokens();
        final int index = this.word.indexOf(":");
        final String substring = this.word.substring(index + 1, this.word.length() - 2);
        this.word = this.word.substring(2, index - 1);
        int n;
        if (substring.equals("N") || substring.equals("n")) {
            n = 0;
        }
        else if (substring.equals("V") || substring.equals("v")) {
            n = 1;
        }
        else if (substring.equals("ADJ") || substring.equals("adj")) {
            n = 2;
        }
        else {
            if (!substring.equals("ADV") && !substring.equals("adv")) {
                throw new CompileException("Illegal part of speech in term expansion " + this.dumpTokens());
            }
            n = 3;
        }
        final String id = this.getID(this.word);
        this.ruleName = "termexptest" + id;
        this.patternHead = "to-" + this.word;
        WordNet.BuildSynsetHashtable(this.word, n);
        bufferedWriter.write("(definerule termexptest" + id + ' ' + NLU.salience + " \" (declare (salience " + NLU.salience + ")) (SENTENCE ?sentence) => (bind $?result (call ?mysearch TermExpander ?sentence " + this.word + ' ' + n + ")) (foreach ?x $?result (if (not(eq* ?x nil)) then (assert(to-" + this.word + " ?x ?x))))\")\n\n");
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
    
    private final /* synthetic */ void this() {
        this.word = "";
    }
    
    ASTTermExpand(final int n) {
        super(n);
        this.this();
    }
    
    ASTTermExpand(final NLU nlu, final int n) {
        super(nlu, n);
        this.this();
    }
}
