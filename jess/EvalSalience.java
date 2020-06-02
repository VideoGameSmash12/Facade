package jess;

import java.io.Serializable;

class EvalSalience implements Userfunction, Serializable
{
    public static final int SET = 0;
    public static final int GET = 1;
    private static final String[] s_values;
    private int m_cmd;
    
    public String getName() {
        return (this.m_cmd == 0) ? "set-salience-evaluation" : "get-salience-evaluation";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        switch (this.m_cmd) {
            case 0: {
                final int evalSalience = context.getEngine().getEvalSalience();
                final String stringValue = valueVector.get(1).stringValue(context);
                for (int i = 0; i < EvalSalience.s_values.length; ++i) {
                    if (stringValue.equals(EvalSalience.s_values[i])) {
                        context.getEngine().setEvalSalience(i);
                        return new Value(EvalSalience.s_values[evalSalience], 1);
                    }
                }
                throw new JessException("set-eval-salience", "Invalid value: " + stringValue, "(valid values are when-defined, when-activated, every-cycle)");
            }
            default: {
                return new Value(EvalSalience.s_values[context.getEngine().getEvalSalience()], 1);
            }
        }
    }
    
    public EvalSalience(final int cmd) {
        this.m_cmd = cmd;
    }
    
    static {
        s_values = new String[] { "when-defined", "when-activated", "every-cycle" };
    }
}
