package TemplateCompiler;

import jess.JessException;
import jess.Value;
import jess.Context;
import jess.ValueVector;
import jess.Userfunction;

public class definerule implements Userfunction
{
    public String getName() {
        return "definerule";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        return ((RefCountRete)context.getEngine()).defineRule(valueVector.get(1).stringValue(context), valueVector.get(2).intValue(context), valueVector.get(3).stringValue(context));
    }
}
