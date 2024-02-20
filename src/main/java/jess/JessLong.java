package jess;

import java.io.Serializable;

class JessLong implements Userfunction, Serializable
{
    public String getName() {
        return "long";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final Value resolveValue = valueVector.get(1).resolveValue(context);
        long longValue = 0L;
        switch (resolveValue.type()) {
            case 1:
            case 2: {
                try {
                    longValue = new Long(resolveValue.stringValue(context));
                    break;
                }
                catch (NumberFormatException ex) {
                    throw new JessException("long", "Invalid number format", resolveValue.toString());
                }
            }
            case 4:
            case 16:
            case 32: {
                longValue = (long)resolveValue.numericValue(context);
                break;
            }
            default: {
                throw new JessException("long", "Illegal argument", resolveValue.toString());
            }
        }
        return new LongValue(longValue);
    }
}
