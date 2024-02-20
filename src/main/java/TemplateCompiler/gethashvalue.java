package TemplateCompiler;

import jess.JessException;
import jess.Value;
import jess.Context;
import jess.ValueVector;
import jess.Userfunction;

public class gethashvalue implements Userfunction
{
    public String getName() {
        return "gethashvalue";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        return ((RefCountRete)context.getEngine()).getHashValue(valueVector.get(1).stringValue(context));
    }
}
