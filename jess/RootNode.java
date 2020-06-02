package jess;

class RootNode extends Node1
{
    void callNodeRight(final Token token, final Context context) throws JessException {
        this.passAlong(token, context);
    }
    
    public String toString() {
        return "The root of the Rete network";
    }
}
