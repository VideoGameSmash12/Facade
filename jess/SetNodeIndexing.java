package jess;

import java.io.Serializable;

class SetNodeIndexing implements Userfunction, Serializable
{
    public String getName() {
        return "set-node-index-hash";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        context.getEngine().getCompiler().setHashKey(valueVector.get(1).intValue(context));
        return Funcall.TRUE;
    }
}
