package jess;

import java.io.Writer;
import java.io.IOException;
import java.io.Serializable;

class JessFormat implements Userfunction, Serializable
{
    public String getName() {
        return "format";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final Value resolveValue = valueVector.get(1).resolveValue(context);
        final String stringValue = valueVector.get(2).stringValue(context);
        final Object[] array = new Object[valueVector.size() - 3];
        for (int i = 0, n = 3; i < array.length; ++i, ++n) {
            final Value resolveValue2 = valueVector.get(n).resolveValue(context);
            Object o = null;
            switch (resolveValue2.type()) {
                case 1:
                case 2: {
                    o = resolveValue2.stringValue(context);
                    break;
                }
                case 4: {
                    o = new Integer(resolveValue2.intValue(context));
                    break;
                }
                case 32: {
                    o = new Double(resolveValue2.floatValue(context));
                    break;
                }
                case 65536: {
                    o = new Long(resolveValue2.longValue(context));
                    break;
                }
                case 2048: {
                    o = resolveValue2.externalAddressValue(context);
                    break;
                }
                default: {
                    o = resolveValue2.toString();
                    break;
                }
            }
            array[i] = o;
        }
        try {
            final String sprintf = new PrintfFormat(stringValue).sprintf(array);
            if (!resolveValue.equals(Funcall.NIL)) {
                final String stringValue2 = resolveValue.stringValue(context);
                final Writer outputRouter = context.getEngine().getOutputRouter(stringValue2);
                if (outputRouter == null) {
                    throw new JessException("format", "Bad router", stringValue2);
                }
                try {
                    outputRouter.write(sprintf);
                    outputRouter.flush();
                }
                catch (IOException ex) {
                    throw new JessException("format", "I/O Exception", ex);
                }
            }
            return new Value(sprintf, 2);
        }
        catch (IllegalArgumentException ex2) {
            throw new JessException("format", "Bad format string " + stringValue, ex2);
        }
    }
}
