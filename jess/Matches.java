package jess;

import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.Serializable;

class Matches implements Userfunction, Serializable
{
    public String getName() {
        return "matches";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final PrintWriter outStream = context.getEngine().getOutStream();
        final HasLHS defrule = context.getEngine().findDefrule(valueVector.get(1).stringValue(context));
        if (defrule == null) {
            throw new JessException("matches", "No such rule or query", valueVector.get(1).stringValue(context));
        }
        final ArrayList nodes = defrule.getNodes();
        for (int i = 0; i < nodes.size(); ++i) {
            final Node node = nodes.get(i);
            if (node instanceof Node2) {
                outStream.print(">>> ");
                outStream.println(node);
                outStream.println(((Node2)node).displayMemory());
            }
        }
        return Funcall.TRUE;
    }
}
