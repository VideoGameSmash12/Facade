package jess;

import java.io.Serializable;

class Test2Simple implements TestBase, Serializable
{
    private boolean m_test;
    private int m_tokenIdx;
    private int m_leftIdx;
    private int m_rightIdx;
    
    boolean getTest() {
        return this.m_test;
    }
    
    int getTokenIndex() {
        return this.m_tokenIdx;
    }
    
    int getLeftIndex() {
        return this.m_leftIdx;
    }
    
    int getRightIndex() {
        return this.m_rightIdx;
    }
    
    public boolean equals(final Object o) {
        if (!(o instanceof Test2Simple)) {
            return false;
        }
        final Test2Simple test2Simple = (Test2Simple)o;
        boolean b = false;
        if (this.m_test == test2Simple.m_test && this.m_tokenIdx == test2Simple.m_tokenIdx && this.m_rightIdx == test2Simple.m_rightIdx && this.m_leftIdx == test2Simple.m_leftIdx) {
            b = true;
        }
        return b;
    }
    
    public boolean doTest(final Context context) throws JessException {
        final Token token = context.getToken();
        final Fact fact = context.getFact();
        final Value value = token.fact(this.m_tokenIdx).get(this.m_leftIdx);
        final Value value2 = fact.get(this.m_rightIdx);
        value.equals(value2);
        return this.m_test ^ value.equals(value2) ^ true;
    }
    
    public String toString() {
        final StringBuffer sb = new StringBuffer(100);
        sb.append("[Test2Simple: test=");
        sb.append(this.m_test ? "EQ" : "NEQ");
        sb.append(";tokenIdx=");
        sb.append(this.m_tokenIdx);
        sb.append(";leftIdx=");
        sb.append(this.m_leftIdx);
        sb.append(";rightIdx=");
        sb.append(this.m_rightIdx);
        sb.append("]");
        return sb.toString();
    }
    
    Test2Simple(final int n, final int tokenIdx, final int leftIdx, final int rightIdx) {
        boolean test = false;
        if (n == 0) {
            test = true;
        }
        this.m_test = test;
        this.m_tokenIdx = tokenIdx;
        this.m_rightIdx = rightIdx;
        this.m_leftIdx = leftIdx;
    }
}
