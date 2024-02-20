package jess;

class Node1MTELN extends Node1
{
    private int m_idx;
    private int m_len;
    
    void callNodeRight(final Token token, final Context context) throws JessException {
        if (this.processClearCommand(token, context)) {
            return;
        }
        try {
            boolean b = false;
            final Value value;
            if ((value = token.topFact().get(this.m_idx)).type() == 512 && value.listValue(null).size() == this.m_len) {
                b = true;
            }
            if (b) {
                this.passAlong(token, context);
            }
        }
        catch (JessException ex) {
            ex.addContext("rule LHS (MTELN)");
            throw ex;
        }
        catch (Exception ex3) {
            final JessException ex2 = new JessException("Node1MTELN.call", "Error during LHS execution", ex3);
            ex2.addContext("rule LHS (MTELN)");
            throw ex2;
        }
    }
    
    public String toString() {
        return "[Test that the multislot at index " + this.m_idx + " is " + this.m_len + " items long]";
    }
    
    public boolean equals(final Object o) {
        if (o instanceof Node1MTELN) {
            final Node1MTELN node1MTELN = (Node1MTELN)o;
            boolean b = false;
            if (this.m_idx == node1MTELN.m_idx && this.m_len == node1MTELN.m_len) {
                b = true;
            }
            return b;
        }
        return false;
    }
    
    Node1MTELN(final int idx, final int len) {
        this.m_idx = idx;
        this.m_len = len;
    }
}
