package jess;

import java.io.Serializable;

class Test2Multi implements TestBase, Serializable
{
    public static int m_count;
    private boolean m_test;
    private int m_tokenIdx;
    private int m_leftIdx;
    private int m_leftSubIdx;
    private int m_rightIdx;
    int m_rightSubIdx;
    
    boolean getTest() {
        return this.m_test;
    }
    
    int getTokenIndex() {
        return this.m_tokenIdx;
    }
    
    int getLeftIndex() {
        return this.m_leftIdx;
    }
    
    int getLeftSubIndex() {
        return this.m_leftSubIdx;
    }
    
    int getRightIndex() {
        return this.m_rightIdx;
    }
    
    int getRightSubIndex() {
        return this.m_rightSubIdx;
    }
    
    public boolean equals(final Object o) {
        if (!(o instanceof Test2Multi)) {
            return false;
        }
        final Test2Multi test2Multi = (Test2Multi)o;
        boolean b = false;
        if (this.m_test == test2Multi.m_test && this.m_tokenIdx == test2Multi.m_tokenIdx && this.m_rightIdx == test2Multi.m_rightIdx && this.m_leftIdx == test2Multi.m_leftIdx && this.m_rightSubIdx == test2Multi.m_rightSubIdx && this.m_leftSubIdx == test2Multi.m_leftSubIdx) {
            b = true;
        }
        return b;
    }
    
    public boolean doTest(final Context context) throws JessException {
        ++Test2Multi.m_count;
        final Fact fact = context.getToken().fact(this.m_tokenIdx);
        if (fact == null) {
            return true;
        }
        final Fact fact2 = context.getFact();
        Value value;
        if (this.m_leftSubIdx != -1) {
            value = fact.get(this.m_leftIdx).listValue(null).get(this.m_leftSubIdx);
        }
        else {
            value = fact.get(this.m_leftIdx);
        }
        boolean b;
        if (this.m_rightSubIdx != -1) {
            b = value.equals(fact2.get(this.m_rightIdx).listValue(null).get(this.m_rightSubIdx));
        }
        else {
            b = value.equals(fact2.get(this.m_rightIdx));
        }
        return b ^ this.m_test ^ true;
    }
    
    public String toString() {
        final StringBuffer sb = new StringBuffer(100);
        sb.append("[Test2Multi: test=");
        sb.append(this.m_test ? "EQ" : "NEQ");
        sb.append(";tokenIdx=");
        sb.append(this.m_tokenIdx);
        sb.append(";leftIdx=");
        sb.append(this.m_leftIdx);
        sb.append(";leftSubIdx=");
        sb.append(this.m_leftSubIdx);
        sb.append(";rightIdx=");
        sb.append(this.m_rightIdx);
        sb.append(";rightSubIdx=");
        sb.append(this.m_rightSubIdx);
        sb.append("]");
        return sb.toString();
    }
    
    Test2Multi(final int n, final int tokenIdx, final int leftIdx, final int leftSubIdx, final int rightIdx, final int rightSubIdx) {
        boolean test = false;
        if (n == 0) {
            test = true;
        }
        this.m_test = test;
        this.m_tokenIdx = tokenIdx;
        this.m_rightIdx = rightIdx;
        this.m_rightSubIdx = rightSubIdx;
        this.m_leftIdx = leftIdx;
        this.m_leftSubIdx = leftSubIdx;
    }
    
    static {
        Test2Multi.m_count = 0;
    }
}
