package jess;

import java.io.Serializable;

class NodeNot2Single extends Node2 implements Serializable
{
    void callNodeLeft(Token token, final Context context) throws JessException {
        if (token.m_tag == 0 || token.m_tag == 2) {
            token = Rete.getFactory().newToken(token);
        }
        super.callNodeLeft(token, context);
    }
    
    void runTestsVaryRight(final Token token, final TokenTree tokenTree, final Context context) throws JessException {
        if (token.m_tag != 1) {
            super.runTestsVaryRight(token, tokenTree, context);
        }
        if (token.m_negcnt == 0) {
            final Token token2 = Rete.getFactory().newToken(token, Fact.getNullFact());
            token2.updateTime(context.getEngine());
            ++this.m_matches;
            this.passAlong(token2, context);
            if (this.m_logicalDepends != null) {
                this.removeLogicalSupportFrom(token2, context);
            }
        }
    }
    
    void doRunTestsVaryRight(final Token token, final TokenTree tokenTree, final Context context) throws JessException {
        if (tokenTree == null) {
            return;
        }
        for (int i = 0; i < tokenTree.m_hash; ++i) {
            this.doRunTestsVaryRight(token, tokenTree.m_tokens[i], context);
        }
    }
    
    boolean doRunTestsVaryRight(final Token token, final TokenVector tokenVector, final Context context) throws JessException {
        if (tokenVector != null) {
            final int size = tokenVector.size();
            if (size > 0) {
                final int nTests = this.m_nTests;
                context.setToken(token);
                for (int i = 0; i < size; ++i) {
                    if (nTests == 0 || this.runTests(nTests, context, tokenVector.elementAt(i))) {
                        ++token.m_negcnt;
                    }
                }
            }
        }
        return false;
    }
    
    void doRunTestsVaryLeft(final Token token, final TokenTree tokenTree, final Context context) throws JessException {
        if (tokenTree == null) {
            return;
        }
        for (int i = 0; i < tokenTree.m_hash; ++i) {
            this.doRunTestsVaryLeft(token, tokenTree.m_tokens[i], context);
        }
    }
    
    void doRunTestsVaryLeft(final Token token, final TokenVector tokenVector, final Context context) throws JessException {
        if (tokenVector != null) {
            final int size = tokenVector.size();
            if (size > 0) {
                final int nTests = this.m_nTests;
                final int tag = token.m_tag;
                for (int i = 0; i < size; ++i) {
                    final Token element = tokenVector.elementAt(i);
                    context.setToken(element);
                    if (nTests == 0 || this.runTests(nTests, context, token)) {
                        if (tag == 0 || tag == 2) {
                            final Token token2 = Rete.getFactory().newToken(element, Fact.getNullFact());
                            token2.updateTime(context.getEngine());
                            token2.m_tag = 1;
                            this.passAlong(token2, context);
                            if (this.m_logicalDepends != null) {
                                this.removeLogicalSupportFrom(token2, context);
                            }
                            final Token token3 = element;
                            ++token3.m_negcnt;
                        }
                        else {
                            final Token token4 = element;
                            if (--token4.m_negcnt == 0) {
                                final Token token5 = Rete.getFactory().newToken(element, Fact.getNullFact());
                                token5.updateTime(context.getEngine());
                                this.passAlong(token5, context);
                                if (this.m_logicalDepends != null) {
                                    this.removeLogicalSupportFrom(token5, context);
                                }
                            }
                            else if (element.m_negcnt < 0) {
                                throw new JessException("NodeNot2.RunTestsVaryLeft", "Corrupted Negcnt (< 0)", "");
                            }
                        }
                    }
                }
            }
        }
    }
    
    public String toString() {
        final StringBuffer sb = new StringBuffer(256);
        sb.append("[NodeNot2Single ntests=");
        sb.append(this.m_nTests);
        sb.append(" ");
        for (int i = 0; i < this.m_nTests; ++i) {
            sb.append(this.m_tests[i].toString());
            sb.append(" ");
        }
        sb.append(";usecount = ");
        sb.append(this.m_usecount);
        sb.append("]");
        return sb.toString();
    }
    
    NodeNot2Single(final int n) throws JessException {
        super(n);
    }
}
