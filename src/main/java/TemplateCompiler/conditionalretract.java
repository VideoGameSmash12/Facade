package TemplateCompiler;

import jess.JessException;
import jess.Value;
import jess.Context;
import jess.ValueVector;
import jess.Userfunction;

public class conditionalretract implements Userfunction
{
    public String getName() {
        return "conditionalRetract";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final RefCountRete refCountRete = (RefCountRete)context.getEngine();
        final String stringValue = valueVector.get(1).stringValue(context);
        final String stringValue2 = valueVector.get(2).stringValue(context);
        final String stringValue3 = valueVector.get(3).stringValue(context);
        int intValue;
        if (stringValue2.equals("any")) {
            intValue = Integer.MIN_VALUE;
        }
        else {
            intValue = valueVector.get(2).intValue(context);
        }
        int intValue2;
        if (stringValue3.equals("any")) {
            intValue2 = Integer.MAX_VALUE;
        }
        else {
            intValue2 = valueVector.get(3).intValue(context);
        }
        refCountRete.conditionalRetract(stringValue, intValue, intValue2);
        return null;
    }
}
