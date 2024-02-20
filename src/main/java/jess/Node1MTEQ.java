package jess;

class Node1MTEQ extends Node1
{
    private int m_idx;
    private int m_subidx;
    private Value m_value;
    
    void callNodeRight(Token prepare, final Context context) throws JessException {
        try {
            if (this.processClearCommand(prepare, context)) {
                return;
            }
            if (prepare.m_tag == 1) {
                this.passAlong(prepare, context);
                return;
            }
            boolean b = false;
            final Fact topFact = prepare.topFact();
            final Value value;
            if ((value = topFact.get(this.m_idx)).type() == 512) {
                final ValueVector listValue = value.listValue(null);
                if (listValue.size() >= this.m_subidx) {
                    final Value value2 = listValue.get(this.m_subidx);
                    if (this.m_value.type() == 64) {
                        context.setFact(topFact);
                        context.setToken(prepare);
                        if (!this.m_value.resolveValue(context).equals(Funcall.FALSE)) {
                            b = true;
                        }
                        prepare = prepare.prepare(b);
                    }
                    else if (value2.equals(this.m_value.resolveValue(context))) {
                        b = true;
                    }
                }
            }
            if (b) {
                this.passAlong(prepare, context);
            }
        }
        catch (JessException ex) {
            ex.addContext("rule LHS (MTEQ)");
            throw ex;
        }
        catch (Exception ex3) {
            final JessException ex2 = new JessException("Node1MTEQ.call", "Error during LHS execution", ex3);
            ex2.addContext("rule LHS");
            throw ex2;
        }
    }
    
    public String toString() {
        return "[Test that the multislot entry at index " + this.m_idx + ", subindex " + this.m_subidx + " equals " + this.m_value + ']';
    }
    
    public boolean equals(final Object o) {
        if (o instanceof Node1MTEQ) {
            final Node1MTEQ node1MTEQ = (Node1MTEQ)o;
            boolean b = false;
            if (this.m_idx == node1MTEQ.m_idx && this.m_subidx == node1MTEQ.m_subidx && this.m_value.equals(node1MTEQ.m_value)) {
                b = true;
            }
            return b;
        }
        return false;
    }
    
    Node1MTEQ(final int idx, final int subidx, final Value value) throws JessException {
        this.m_idx = idx;
        this.m_subidx = subidx;
        this.m_value = this.cleanupBindings(value);
    }
}
