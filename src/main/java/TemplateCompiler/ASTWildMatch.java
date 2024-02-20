package TemplateCompiler;

import java.io.IOException;
import java.io.BufferedWriter;

public class ASTWildMatch extends ASTJessRule implements PatternProducingNode
{
    private String previousFact;
    private String previousMatchTest;
    
    public void compileToJess(final BufferedWriter bufferedWriter) throws IOException {
        if (this.dumpTokens().equals("*")) {
            if (this.previousFact == null) {
                bufferedWriter.write("(definerule starmatch " + NLU.salience + " \" (declare (salience " + NLU.salience + ")) (initial-fact) => (assert(splat 1 any))\")\n\n");
            }
            else {
                final StringBuffer sb = new StringBuffer();
                sb.append("(definerule starmatch" + this.previousFact + ' ' + NLU.salience + ' ');
                sb.append(" \" (declare (salience " + NLU.salience + ")) ");
                sb.append(this.previousMatchTest);
                sb.append(" => (assert(splat (MyPlus ?endpos 1) any))\")\n\n");
                bufferedWriter.write(sb.toString());
            }
            this.patternHead = "splat";
            this.ruleName = "starmatch" + this.previousFact;
        }
        else {
            if (this.previousFact == null) {
                bufferedWriter.write("(definerule qmarkmatch " + NLU.salience + " \" (declare (salience " + NLU.salience + ")) (SENTENCE $?sentence) => (if(neq (length$ $?sentence) 0) then (assert(word-wildcard 1 1)))\")\n\n");
            }
            else {
                bufferedWriter.write("(definerule qmarkmatch" + this.previousFact + ' ' + NLU.salience + " \" (declare (salience " + NLU.salience + ")) " + this.previousMatchTest + " (SENTENCE ?sentence)  => (bind ?result (call ?mysearch IsThereWord ?sentence (MyPlus ?endpos 1))) (if(neq ?result -1) then (assert(word-wildcard (MyPlus ?endpos 1) (MyPlus ?endpos 1))))\")\n\n");
            }
            this.ruleName = "qmarkmatch" + this.previousFact;
            this.patternHead = "word-wildcard";
        }
    }
    
    void setPreviousMatchTest(final String previousFact, final String previousMatchTest) {
        this.previousFact = previousFact;
        this.previousMatchTest = previousMatchTest;
    }
    
    public boolean isRegexp() {
        return true;
    }
    
    private final /* synthetic */ void this() {
        this.previousFact = null;
        this.previousMatchTest = null;
    }
    
    public ASTWildMatch(final int n) {
        super(n);
        this.this();
    }
    
    public ASTWildMatch(final NLU nlu, final int n) {
        super(nlu, n);
        this.this();
    }
}
