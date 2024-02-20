package TemplateCompiler;

import java.util.HashSet;
import java.io.IOException;
import java.io.BufferedWriter;

class ASTTemplate extends ASTStart implements PatternProducingNode
{
    private boolean retraction;
    private boolean negated;
    private static final /* synthetic */ boolean $noassert;
    
    void setRetraction(final boolean retraction) {
        this.retraction = retraction;
    }
    
    void compileToJess(final BufferedWriter bufferedWriter) throws IOException {
        if (!ASTTemplate.$noassert && this.jjtGetNumChildren() != 1) {
            throw new AssertionError();
        }
        final PatternProducingNode patternProducingNode = (PatternProducingNode)this.children[0];
        if (patternProducingNode != null) {
            final String image = this.firstToken.next.image;
            final String patternHead = patternProducingNode.getPatternHead();
            if (image.equals("tnot")) {
                this.negated = true;
                this.ruleName = "nottest" + patternHead;
                this.patternHead = "not" + patternHead;
                bufferedWriter.write("(definerule nottest" + patternHead + " \" (declare (salience " + NLU.salience + ")) " + NLU.startDependency + "(not" + patternProducingNode.getPatternToMatch(-1) + ')' + NLU.endDependency + " => (assert(" + this.patternHead + " any any))\")\n\n");
            }
            else {
                this.ruleName = patternProducingNode.getRuleName();
                this.patternHead = patternHead;
            }
        }
        if (this.retraction) {
            this.addFactsRecursively(this, NLU.retractThese);
        }
    }
    
    String toStringNodeBelow() {
        final ASTJessRule astJessRule = (ASTJessRule)this.children[0];
        if (astJessRule != null) {
            return astJessRule.toString();
        }
        return "";
    }
    
    public String getPatternToMatch(final int n) {
        return NLU.startDependency + this.getPatternToMatchNoDependency(n) + NLU.endDependency;
    }
    
    public String getPatternToMatchNoDependency(final int n) {
        return ((PatternProducingNode)this.children[0]).getPatternToMatch(n);
    }
    
    boolean isRegexp() {
        final ASTJessRule astJessRule = (ASTJessRule)this.children[0];
        if (!ASTTemplate.$noassert && astJessRule == null) {
            throw new AssertionError();
        }
        return astJessRule.isRegexp();
    }
    
    void addFactsRecursively(final PatternProducingNode patternProducingNode, final HashSet set) {
        if (patternProducingNode.jjtGetNumChildren() != 0) {
            for (int i = 0; i < patternProducingNode.jjtGetNumChildren(); ++i) {
                final PatternProducingNode patternProducingNode2 = (PatternProducingNode)patternProducingNode.jjtGetChild(i);
                if (patternProducingNode2 != null) {
                    this.addFactsRecursively(patternProducingNode2, set);
                    set.add(patternProducingNode2.getPatternHead());
                }
            }
        }
    }
    
    int getChildNodeID() {
        return ((SimpleNode)this.children[0]).getParseNodeID();
    }
    
    private final /* synthetic */ void this() {
        this.retraction = false;
        this.negated = false;
    }
    
    ASTTemplate(final int n) {
        super(n);
        this.this();
    }
    
    ASTTemplate(final NLU nlu, final int n) {
        super(nlu, n);
        this.this();
    }
    
    static {
        $noassert = (Class.forName("[LTemplateCompiler.ASTTemplate;").getComponentType().desiredAssertionStatus() ^ true);
    }
}
