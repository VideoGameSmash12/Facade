package TemplateCompiler;

import jess.JessException;
import jess.Rete;
import java.util.Iterator;
import java.io.StringWriter;
import java.io.IOException;
import java.io.BufferedWriter;

class ASTStart extends ASTJessRule implements NLUTreeConstants
{
    private static long ruleCounter;
    private static final /* synthetic */ boolean $noassert;
    
    void compileToJess(final BufferedWriter bufferedWriter) throws IOException, CompileException {
        if (!ASTStart.$noassert) {
            throw new AssertionError((Object)"don't call compileToJess on ASTStart");
        }
    }
    
    void compileToJessChildren(final ASTJessRule astJessRule, final BufferedWriter bufferedWriter) throws IOException, CompileException {
        if (astJessRule.children != null) {
            for (int i = 0; i < astJessRule.children.length; ++i) {
                final ASTJessRule astJessRule2 = (ASTJessRule)astJessRule.children[i];
                if (astJessRule2 != null) {
                    this.compileToJessChildren(astJessRule2, bufferedWriter);
                    if (astJessRule2.toString().equals("RHside") || astJessRule2.toString().equals("worddump")) {
                        return;
                    }
                    if (!astJessRule2.toString().equals("WildMatch")) {
                        astJessRule2.compileToJess(bufferedWriter);
                    }
                    else {
                        ASTJessRule astJessRule3;
                        int n;
                        for (astJessRule3 = (ASTJessRule)((ASTJessRule)astJessRule2.parent).parent, n = 0; ((ASTJessRule)astJessRule3.children[n]).children[0] != astJessRule2; ++n) {}
                        if (n == 0) {
                            astJessRule2.compileToJess(bufferedWriter);
                        }
                        else {
                            final ASTTemplate astTemplate = (ASTTemplate)astJessRule3.children[n - 1];
                            ((ASTWildMatch)astJessRule2).setPreviousMatchTest(astTemplate.getPatternHead(), astTemplate.getPatternToMatch(-1));
                            astJessRule2.compileToJess(bufferedWriter);
                        }
                    }
                }
            }
        }
    }
    
    void prepareChildrenRetract(final StringWriter stringWriter) {
        final Iterator<String> iterator = NLU.retractThese.iterator();
        while (iterator.hasNext()) {
            stringWriter.write("\n(conditionalRetract " + iterator.next() + " ?startpos1 ?endpos1)\n");
        }
    }
    
    void compileToplevel(final StringWriter stringWriter, final StringWriter stringWriter2, final BufferedWriter bufferedWriter, final String s) throws IOException, CompileException {
        if (!ASTStart.$noassert && this.jjtGetNumChildren() != 1) {
            throw new AssertionError();
        }
        if (++ASTStart.ruleCounter % 100L == 0L) {
            System.out.print(new StringBuffer().append(ASTStart.ruleCounter).append(' ').toString());
        }
        final String image = this.firstToken.next.next.image;
        NLU.retractThese.clear();
        this.compileToJessChildren(this, bufferedWriter);
        boolean b = true;
        final ASTTemplate astTemplate = (ASTTemplate)this.children[0];
        if (astTemplate.toStringNodeBelow().startsWith("O")) {
            b = false;
        }
        final StringBuffer sb = new StringBuffer();
        if (NLU.retractThese.size() == 0) {
            sb.append(astTemplate.getPatternToMatch(1));
        }
        else {
            sb.append(astTemplate.getPatternToMatchNoDependency(1));
        }
        if (b) {
            ASTJessRule astJessRule = (ASTJessRule)((ASTJessRule)this.children[0]).children[0];
            if (astJessRule.getParseNodeID() != 13 && astJessRule.getParseNodeID() != 17) {
                astJessRule = (ASTJessRule)astJessRule.children[0];
            }
            if (astJessRule.isRegexp()) {
                sb.append(" (test (MyEquals ?startpos1 1)) ");
            }
            final ASTJessRule astJessRule2 = (ASTJessRule)astJessRule.parent;
            if (((ASTJessRule)astJessRule2.children[astJessRule2.children.length - 1]).isRegexp()) {
                sb.append("(_wordcount ?wordno) (test (MyEquals ?endpos" + Integer.toString(this.children.length) + " ?wordno))");
            }
        }
        stringWriter.write(sb.toString());
        final StringWriter stringWriter3 = new StringWriter();
        this.prepareChildrenRetract(stringWriter3);
        stringWriter2.write(stringWriter3.getBuffer().toString());
        stringWriter2.flush();
        stringWriter.flush();
    }
    
    public void runNetwork(final Rete rete, final String s) throws JessException {
        rete.executeCommand("(assert(SENTENCE " + s + "))");
        rete.run();
    }
    
    ASTStart(final int n) {
        super(n);
    }
    
    ASTStart(final NLU nlu, final int n) {
        super(nlu, n);
    }
    
    static {
        $noassert = (Class.forName("[LTemplateCompiler.ASTStart;").getComponentType().desiredAssertionStatus() ^ true);
        ASTStart.ruleCounter = 0L;
    }
}
