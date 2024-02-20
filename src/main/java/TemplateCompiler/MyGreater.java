package TemplateCompiler;

import jess.JessException;
import jess.Value;
import jess.Context;
import jess.ValueVector;
import jess.Userfunction;

public class MyGreater implements Userfunction
{
    public String getName() {
        return "MyGreater";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final String stringValue = valueVector.get(1).stringValue(context);
        final String stringValue2 = valueVector.get(2).stringValue(context);
        if (stringValue.equals("any") || stringValue2.equals("any")) {
            return new Value("TRUE", 1);
        }
        if (Integer.parseInt(stringValue) > Integer.parseInt(stringValue2)) {
            return new Value("TRUE", 1);
        }
        return new Value("FALSE", 1);
    }
}
