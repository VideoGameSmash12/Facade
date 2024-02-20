package jess;

class Node1TNEQ extends Node1
{
    private Value m_value;
    private int m_idx;
    
    void callNodeRight(Token prepare, final Context context) throws JessException {
        if (this.processClearCommand(prepare, context)) {
            return;
        }
        if (prepare.m_tag == 1) {
            this.passAlong(prepare, context);
            return;
        }
        try {
            boolean b = false;
            final Fact topFact = prepare.topFact();
            if (this.m_value.type() == 64) {
                context.setFact(topFact);
                context.setToken(prepare);
                if (this.m_value.resolveValue(context).equals(Funcall.FALSE)) {
                    b = true;
                }
                prepare = prepare.prepare(b);
            }
            else if (!topFact.get(this.m_idx).equals(this.m_value.resolveValue(context))) {
                b = true;
            }
            if (b) {
                this.passAlong(prepare, context);
            }
        }
        catch (JessException ex) {
            ex.addContext("rule LHS (TNEQ)");
            throw ex;
        }
        catch (Exception ex3) {
            final JessException ex2 = new JessException("Node1TNEQ.call", "Error during LHS execution", ex3);
            ex2.addContext("rule LHS (TNEQ)");
            throw ex2;
        }
    }
    
    public String toString() {
        return "[Test that slot at index " + this.m_idx + " is not equal to " + this.m_value + ']';
    }
    
    public boolean equals(final Object o) {
        if (o instanceof Node1TNEQ) {
            final Node1TNEQ node1TNEQ = (Node1TNEQ)o;
            boolean b = false;
            if (this.m_idx == node1TNEQ.m_idx && this.m_value.equals(node1TNEQ.m_value)) {
                b = true;
            }
            return b;
        }
        return false;
    }
    
    Node1TNEQ(final int idx, final Value value) throws JessException {
        this.m_value = this.cleanupBindings(value);
        this.m_idx = idx;
    }
}
