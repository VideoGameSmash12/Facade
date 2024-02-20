package jess;

import java.io.Serializable;

class HaltEtc implements Userfunction, Serializable
{
    static final int HALT = 0;
    static final int EXIT = 1;
    static final int CLEAR = 2;
    static final int RUN = 3;
    static final int RESET = 4;
    static final int RETURN = 5;
    static final String[] s_names;
    private int m_name;
    
    public String getName() {
        return HaltEtc.s_names[this.m_name];
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final Rete engine = context.getEngine();
        switch (this.m_name) {
            case 0: {
                engine.halt();
                break;
            }
            case 1: {
                PrintThread.getPrintThread().waitForCompletion();
                System.exit(0);
                break;
            }
            case 2: {
                engine.clear();
                break;
            }
            case 3: {
                if (valueVector.size() == 1) {
                    return new Value(engine.run(), 4);
                }
                return new Value(engine.run(valueVector.get(1).intValue(context)), 4);
            }
            case 5: {
                if (valueVector.size() > 1) {
                    return context.setReturnValue(valueVector.get(1).resolveValue(context));
                }
                return context.setReturnValue(Funcall.NIL);
            }
            case 4: {
                engine.reset();
                break;
            }
        }
        return Funcall.TRUE;
    }
    
    HaltEtc(final int name) {
        this.m_name = name;
    }
    
    static {
        s_names = new String[] { "halt", "exit", "clear", "run", "reset", "return" };
    }
}
