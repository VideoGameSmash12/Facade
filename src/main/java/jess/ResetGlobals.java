package jess;

import java.io.Serializable;

class ResetGlobals implements Userfunction, Serializable
{
    public static final int SET = 0;
    public static final int GET = 1;
    private int m_cmd;
    
    public String getName() {
        return (this.m_cmd == 0) ? "set-reset-globals" : "get-reset-globals";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        switch (this.m_cmd) {
            case 0: {
                final Value value = valueVector.get(1);
                Value value2;
                if (value.equals(Funcall.NIL) || value.equals(Funcall.FALSE)) {
                    context.getEngine().setResetGlobals(false);
                    value2 = Funcall.FALSE;
                }
                else {
                    context.getEngine().setResetGlobals(true);
                    value2 = Funcall.TRUE;
                }
                return value2;
            }
            default: {
                return context.getEngine().getResetGlobals() ? Funcall.TRUE : Funcall.FALSE;
            }
        }
    }
    
    public ResetGlobals(final int cmd) {
        this.m_cmd = cmd;
    }
}
