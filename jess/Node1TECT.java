package jess;

class Node1TECT extends Node1
{
    private String m_name;
    
    void callNodeRight(final Token token, final Context context) throws JessException {
        if (this.processClearCommand(token, context)) {
            return;
        }
        try {
            final Fact topFact = token.topFact();
            boolean b;
            if (!(b = this.m_name.equals(topFact.getName()))) {
                for (Deftemplate deftemplate = topFact.getDeftemplate().getParent(); deftemplate != null; deftemplate = deftemplate.getParent()) {
                    if (b = this.m_name.equals(deftemplate.getName())) {
                        break;
                    }
                }
            }
            if (b) {
                this.passAlong(token, context);
            }
        }
        catch (JessException ex) {
            ex.addContext("rule LHS (TECT)");
            throw ex;
        }
        catch (Exception ex3) {
            final JessException ex2 = new JessException("Node1TECT.call", "Error during LHS execution", ex3);
            ex2.addContext("rule LHS (TECT)");
            throw ex2;
        }
    }
    
    public String toString() {
        return "[Test that fact class is " + this.m_name + " or a subclass of type " + this.m_name + ']';
    }
    
    public boolean equals(final Object o) {
        return o instanceof Node1TECT && this.m_name.equals(((Node1TECT)o).m_name);
    }
    
    Node1TECT(final String name) {
        this.m_name = name;
    }
}
