package jess;

class Node1NONE extends Node1
{
    void callNodeRight(final Token token, final Context context) throws JessException {
    }
    
    public boolean equals(final Object o) {
        return o instanceof Node1NONE;
    }
}
