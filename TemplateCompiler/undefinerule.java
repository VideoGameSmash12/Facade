package TemplateCompiler;

import jess.JessException;
import jess.Value;
import jess.Context;
import jess.ValueVector;
import jess.Userfunction;

public class undefinerule implements Userfunction
{
    public String getName() {
        return "undefinerule";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        return ((RefCountRete)context.getEngine()).undefineRule(valueVector, context);
    }
}
