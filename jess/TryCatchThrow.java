package jess;

import java.io.Serializable;

class TryCatchThrow implements Userfunction, Serializable
{
    public static final String TRY = "try";
    public static final String THROW = "throw";
    private String m_name;
    
    public String getName() {
        return this.m_name;
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        if (this.m_name.equals("throw")) {
            final Throwable t = (Throwable)valueVector.get(1).externalAddressValue(context);
            t.fillInStackTrace();
            if (t instanceof JessException) {
                throw (JessException)t;
            }
            throw new JessException("throw", "Exception thrown from Jess language code", t);
        }
        else {
            int n = -1;
            int n2 = -1;
            int n3 = -1;
            int size = -1;
            int size2 = -1;
            for (int i = 1; i < valueVector.size(); ++i) {
                if (valueVector.get(i).type() == 1 && valueVector.get(i).equals("catch") && n < 0) {
                    n = (n3 = i);
                    size = valueVector.size();
                }
                if (valueVector.get(i).type() == 1 && valueVector.get(i).equals("finally")) {
                    n2 = i;
                    size2 = valueVector.size();
                    if (n > 0) {
                        size = n2;
                    }
                    else {
                        n3 = n2;
                    }
                    break;
                }
            }
            if (n == -1 && n2 == -1) {
                throw new JessException("try", "Neither catch nor finally block in try expression", "");
            }
            Value value = Funcall.NIL;
            try {
                for (int j = 1; j < n3; ++j) {
                    value = valueVector.get(j).resolveValue(context);
                    if (context.returning()) {
                        value = context.getReturnValue();
                        break;
                    }
                }
            }
            catch (Throwable t2) {
                if (n == -1) {
                    if (t2 instanceof JessException) {
                        throw (JessException)t2;
                    }
                    throw new JessException("TryCatchThrow.call", "Unexpected exception in try-block", t2);
                }
                else {
                    value = Funcall.FALSE;
                    context.setVariable("ERROR", new Value(t2));
                    for (int k = ++n; k < size; ++k) {
                        value = valueVector.get(k).resolveValue(context);
                        if (context.returning()) {
                            value = context.getReturnValue();
                            break;
                        }
                    }
                }
            }
            finally {
                final boolean returning = context.returning();
                context.clearReturnValue();
                for (int l = ++n2; l < size2; ++l) {
                    valueVector.get(l).resolveValue(context);
                    if (context.returning()) {
                        return context.getReturnValue();
                    }
                }
                if (returning) {
                    context.setReturnValue(value);
                }
            }
            final boolean returning2 = context.returning();
            context.clearReturnValue();
            for (int n4 = ++n2; n4 < size2; ++n4) {
                valueVector.get(n4).resolveValue(context);
                if (context.returning()) {
                    return context.getReturnValue();
                }
            }
            if (returning2) {
                context.setReturnValue(value);
            }
            return value;
        }
    }
    
    TryCatchThrow(final String name) {
        this.m_name = name;
    }
}
