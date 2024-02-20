package jess;

import java.util.Iterator;
import java.util.ArrayList;
import java.io.Serializable;

public class Deffunction implements Userfunction, Serializable, Visitable
{
    private String m_name;
    private String m_docstring;
    private ArrayList m_arguments;
    private ArrayList m_actions;
    private boolean m_hasWildcard;
    
    public final String getName() {
        return this.m_name;
    }
    
    public final String getDocstring() {
        return this.m_docstring;
    }
    
    public final void setDocstring(final String docstring) {
        this.m_docstring = docstring;
    }
    
    public Iterator getArguments() {
        return this.m_arguments.iterator();
    }
    
    public Iterator getActions() {
        return this.m_actions.iterator();
    }
    
    public void addArgument(final String s, final int n) throws JessException {
        if (this.m_hasWildcard) {
            throw new JessException("Deffunction.addArgument", "Deffunction " + this.m_name + " already has a wildcard argument:", s);
        }
        this.m_arguments.add(new Argument(s, n));
        if (n == 8192) {
            this.m_hasWildcard = true;
        }
    }
    
    public void addAction(final Funcall funcall) throws JessException {
        this.m_actions.add(new FuncallValue(funcall));
    }
    
    public void addValue(final Value value) {
        this.m_actions.add(value);
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final Context push = context.getEngine().getGlobalContext().push();
        push.clearReturnValue();
        Value value = Funcall.NIL;
        try {
            if (valueVector.size() < this.m_arguments.size() - (this.m_hasWildcard ? 1 : 0) + 1) {
                throw new JessException(this.m_name, "Too few arguments to deffunction", this.m_name);
            }
            for (int i = 0; i < this.m_arguments.size(); ++i) {
                final Argument argument = this.m_arguments.get(i);
                switch (argument.m_type) {
                    case 8: {
                        push.setVariable(argument.m_name, valueVector.get(i + 1).resolveValue(context));
                        break;
                    }
                    case 8192: {
                        final ValueVector valueVector2 = new ValueVector();
                        for (int j = i + 1; j < valueVector.size(); ++j) {
                            final Value resolveValue = valueVector.get(j).resolveValue(context);
                            if (resolveValue.type() == 512) {
                                final ValueVector listValue = resolveValue.listValue(context);
                                for (int k = 0; k < listValue.size(); ++k) {
                                    valueVector2.add(listValue.get(k).resolveValue(context));
                                }
                            }
                            else {
                                valueVector2.add(resolveValue);
                            }
                        }
                        push.setVariable(argument.m_name, new Value(valueVector2, 512));
                        break;
                    }
                }
            }
            for (int size = this.m_actions.size(), l = 0; l < size; ++l) {
                value = ((Value)this.m_actions.get(l)).resolveValue(push);
                if (push.returning()) {
                    value = push.getReturnValue();
                    push.clearReturnValue();
                    break;
                }
            }
        }
        catch (JessException ex) {
            ex.addContext("deffunction " + this.m_name);
            throw ex;
        }
        finally {
            push.pop();
        }
        push.pop();
        return value.resolveValue(push);
    }
    
    public String toString() {
        return "[deffunction " + this.m_name + ']';
    }
    
    public Object accept(final Visitor visitor) {
        return visitor.visitDeffunction(this);
    }
    
    private final /* synthetic */ void this() {
        this.m_docstring = "";
        this.m_arguments = new ArrayList();
        this.m_actions = new ArrayList();
        this.m_hasWildcard = false;
    }
    
    public Deffunction(final String name, final String docstring) {
        this.this();
        this.m_name = name;
        this.m_docstring = docstring;
    }
    
    public static class Argument implements Serializable
    {
        String m_name;
        int m_type;
        
        public String getName() {
            return this.m_name;
        }
        
        public int getType() {
            return this.m_type;
        }
        
        Argument(final String name, final int type) {
            this.m_name = name;
            this.m_type = type;
        }
    }
}
