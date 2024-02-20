package jess;

import java.util.Iterator;
import java.io.PrintWriter;
import java.util.Stack;
import java.io.Serializable;

class ListFocusStack implements Userfunction, Serializable
{
    public String getName() {
        return "list-focus-stack";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final Rete engine = context.getEngine();
        final PrintWriter outStream = engine.getOutStream();
        final Stack stack = new Stack<Object>();
        final Iterator listFocusStack = engine.listFocusStack();
        while (listFocusStack.hasNext()) {
            stack.push(listFocusStack.next());
        }
        while (!stack.isEmpty()) {
            outStream.println(stack.pop());
        }
        return Funcall.NIL;
    }
}
