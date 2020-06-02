package jess;

class Node1LTR extends Node
{
    void callNodeLeft(final Token token, final Context context) throws JessException {
        this.broadcastEvent(32768, token);
        this.passAlong(token, context);
    }
    
    void passAlong(final Token token, final Context context) throws JessException {
        final Node[] succ = this.m_succ;
        for (int i = 0; i < this.m_nSucc; ++i) {
            succ[i].callNodeRight(token, context);
        }
    }
    
    public boolean equals(final Object o) {
        return o instanceof Node1LTR;
    }
    
    public String getCompilationTraceToken() {
        return "a";
    }
    
    public String toString() {
        return "[Right input adapter]";
    }
}
