package jess;

class Node1TNEV1 extends Node1
{
    private int m_idx1;
    private int m_idx2;
    private int m_subidx1;
    private int m_subidx2;
    
    void callNodeRight(final Token token, final Context context) throws JessException {
        if (this.processClearCommand(token, context)) {
            return;
        }
        try {
            final Fact topFact = token.topFact();
            Value value;
            if (this.m_subidx1 != -1) {
                value = topFact.get(this.m_idx1).listValue(null).get(this.m_subidx1);
            }
            else {
                value = topFact.get(this.m_idx1);
            }
            Value value2;
            if (this.m_subidx2 != -1) {
                value2 = topFact.get(this.m_idx2).listValue(null).get(this.m_subidx2);
            }
            else {
                value2 = topFact.get(this.m_idx2);
            }
            if (value.equals(value2) ^ true) {
                this.passAlong(token, context);
            }
        }
        catch (JessException ex) {
            ex.addContext("rule LHS (TNEV1)");
            throw ex;
        }
        catch (Exception ex3) {
            final JessException ex2 = new JessException("Node1TNEV1.call", "Error during LHS execution", ex3);
            ex2.addContext("rule LHS (TNEV1)");
            throw ex2;
        }
    }
    
    public boolean equals(final Object o) {
        if (o instanceof Node1TNEV1) {
            final Node1TNEV1 node1TNEV1 = (Node1TNEV1)o;
            boolean b = false;
            if (this.m_idx1 == node1TNEV1.m_idx1 && this.m_idx2 == node1TNEV1.m_idx2 && this.m_subidx1 == node1TNEV1.m_subidx1 && this.m_subidx2 == node1TNEV1.m_subidx2) {
                b = true;
            }
            return b;
        }
        return false;
    }
    
    public String toString() {
        final StringBuffer sb = new StringBuffer("[Test that slot #");
        sb.append(this.m_idx1);
        if (this.m_subidx1 != -1) {
            sb.append(", subindex ");
            sb.append(this.m_subidx1);
        }
        sb.append(" != slot#");
        sb.append(this.m_idx2);
        if (this.m_subidx2 != -1) {
            sb.append(", subindex ");
            sb.append(this.m_subidx2);
        }
        sb.append("]");
        return sb.toString();
    }
    
    Node1TNEV1(final int idx1, final int subidx1, final int idx2, final int subidx2) {
        this.m_idx1 = idx1;
        this.m_subidx1 = subidx1;
        this.m_idx2 = idx2;
        this.m_subidx2 = subidx2;
    }
}
