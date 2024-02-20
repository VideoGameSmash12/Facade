package jess;

import java.io.Serializable;

public final class Test1 implements TestBase, Serializable, Visitable, Cloneable
{
    int m_test;
    int m_subIdx;
    Value m_slotValue;
    int m_conjunction;
    
    public final Object clone() {
        try {
            final Test1 test1 = (Test1)super.clone();
            if (test1.m_slotValue instanceof FuncallValue) {
                test1.m_slotValue = new FuncallValue((Funcall)this.m_slotValue.funcallValue(null).clone());
            }
            return test1;
        }
        catch (CloneNotSupportedException ex) {
            return null;
        }
        catch (JessException ex2) {
            return null;
        }
    }
    
    public final int getTest() {
        return this.m_test;
    }
    
    public final Value getValue() {
        return this.m_slotValue;
    }
    
    public final int getMultiSlotIndex() {
        return this.m_subIdx;
    }
    
    public final int getConjunction() {
        return this.m_conjunction;
    }
    
    public final boolean doTest(final Context context) throws JessException {
        final boolean equals = this.m_slotValue.resolveValue(context).equals(Funcall.FALSE);
        switch (this.m_test) {
            case 0: {
                if (equals) {
                    return false;
                }
                break;
            }
            case 1: {
                if (!equals) {
                    return false;
                }
                break;
            }
        }
        return true;
    }
    
    public final boolean equals(final Object o) {
        if (!(o instanceof Test1)) {
            return false;
        }
        final Test1 test1 = (Test1)o;
        return this.m_test == test1.m_test && this.m_subIdx == test1.m_subIdx && this.m_conjunction == test1.m_conjunction && this.m_slotValue.equals(test1.m_slotValue);
    }
    
    public final Object accept(final Visitor visitor) {
        return visitor.visitTest1(this);
    }
    
    public final String toString() {
        final StringBuffer sb = new StringBuffer(100);
        sb.append("[Test1: test=");
        sb.append((this.m_test == 1) ? "NEQ" : "EQ");
        sb.append(";sub_idx=");
        sb.append(this.m_subIdx);
        sb.append(";slot_value=");
        sb.append(this.m_slotValue);
        sb.append(";conjunction=");
        sb.append(this.m_conjunction);
        sb.append("]");
        return sb.toString();
    }
    
    private final /* synthetic */ void this() {
        this.m_conjunction = 1;
    }
    
    public Test1(final int n, final int n2, final Value value, final int conjunction) throws JessException {
        this(n, n2, value);
        this.m_conjunction = conjunction;
    }
    
    Test1(final int test, final int subIdx, final Value slotValue) throws JessException {
        this.this();
        this.m_test = test;
        this.m_subIdx = subIdx;
        this.m_slotValue = slotValue;
    }
    
    Test1(final Test1 test1, final Value slotValue) throws JessException {
        this.this();
        this.m_test = test1.m_test;
        this.m_subIdx = test1.m_subIdx;
        this.m_conjunction = test1.m_conjunction;
        this.m_slotValue = slotValue;
    }
}
