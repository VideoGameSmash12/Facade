package jess;

import java.io.Serializable;

class NodeNot2 extends Node2 implements Serializable
{
    private int m_size;
    
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
        this.doRunTestsVaryRight(token, tokenTree.findCodeInTree(token.hashCode(), false), context);
    }
    
    boolean doRunTestsVaryRight(final Token token, final TokenVector tokenVector, final Context context) throws JessException {
        if (tokenVector != null) {
            final int size = tokenVector.size();
            if (size > 0) {
                final int nTests = this.m_nTests;
                context.setToken(token);
                for (int i = 0; i < size; ++i) {
                    if (this.runTests(nTests, context, tokenVector.elementAt(i))) {
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
        this.doRunTestsVaryLeft(token, tokenTree.findCodeInTree(this.subsetRightToken(token).hashCode(), false), context);
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
                    if (tag != 1 || element.m_negcnt != 0) {
                        if (this.runTests(nTests, context, token)) {
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
                            }
                        }
                    }
                }
            }
        }
    }
    
    Token subsetRightToken(final Token token) {
        Token parent;
        for (parent = token; parent.size() > this.m_size; parent = parent.getParent()) {}
        return parent;
    }
    
    boolean runTests(final int n, final Context context, Token subsetRightToken) throws JessException {
        final Token token = context.getToken();
        subsetRightToken = this.subsetRightToken(subsetRightToken);
        boolean b = false;
        if (subsetRightToken == token || subsetRightToken.dataEquals(token)) {
            b = true;
        }
        return b;
    }
    
    protected void initTokenTrees() {
        final boolean b = true;
        if (this.m_left == null) {
            this.m_left = new TokenTree(this.m_hashkey, b, 0, 0, 0);
        }
        else {
            this.m_left.clear();
        }
        if (this.m_right == null) {
            this.m_right = new TokenTree(this.m_hashkey, b, this.m_size, 0, 0);
        }
        else {
            this.m_right.clear();
        }
    }
    
    public String toString() {
        final StringBuffer sb = new StringBuffer(256);
        sb.append("[NodeNot2");
        sb.append(";usecount = ");
        sb.append(this.m_usecount);
        sb.append("]");
        return sb.toString();
    }
    
    void addTest(final int n, final int n2, final int n3, final int n4, final int n5, final int n6) {
        this.addTest(null);
    }
    
    void addTest(final TestBase testBase) {
        throw new RuntimeException("ABORT: Can't add tests to NodeNot2");
    }
    
    NodeNot2(final int n, final int size) throws JessException {
        super(n);
        this.m_size = size;
        this.complete();
    }
}
