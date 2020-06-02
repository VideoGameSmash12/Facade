package TemplateCompiler;

import jess.JessException;
import jess.Value;
import jess.Context;
import jess.ValueVector;
import jess.Userfunction;

public class MyPlus implements Userfunction
{
    public String getName() {
        return "MyPlus";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final String stringValue = valueVector.get(1).stringValue(context);
        final String stringValue2 = valueVector.get(2).stringValue(context);
        if (stringValue.equals("any")) {
            return new Value("any", 1);
        }
        return new Value(Integer.parseInt(stringValue) + Integer.parseInt(stringValue2), 4);
    }
}
