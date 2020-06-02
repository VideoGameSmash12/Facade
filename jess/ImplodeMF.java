package jess;

import java.io.Serializable;

class ImplodeMF implements Userfunction, Serializable
{
    public String getName() {
        return "implode$";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final ValueVector listValue = valueVector.get(1).listValue(context);
        final StringBuffer sb = new StringBuffer("");
        for (int i = 0; i < listValue.size(); ++i) {
            sb.append(new StringBuffer().append(listValue.get(i).resolveValue(context)).append(' ').toString());
        }
        final String string = sb.toString();
        final int length = string.length();
        if (length == 0) {
            return new Value(string, 2);
        }
        return new Value(string.substring(0, length - 1), 2);
    }
}
