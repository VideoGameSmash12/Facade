package jess;

import java.util.Iterator;
import java.util.Stack;
import java.io.Serializable;

class GetFocusStack implements Userfunction, Serializable
{
    public String getName() {
        return "get-focus-stack";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final Rete engine = context.getEngine();
        final ValueVector valueVector2 = new ValueVector();
        final Stack<String> stack = new Stack<String>();
        final Iterator listFocusStack = engine.listFocusStack();
        while (listFocusStack.hasNext()) {
            stack.push(listFocusStack.next());
        }
        while (!stack.isEmpty()) {
            valueVector2.add(new Value(stack.pop(), 1));
        }
        return new Value(valueVector2, 512);
    }
}
