package jess;

import java.io.Serializable;

abstract class Node1 extends Node implements Serializable
{
    boolean processClearCommand(final Token token, final Context context) throws JessException {
        this.broadcastEvent(32769, token);
        if (token.m_tag == 3) {
            this.passAlong(token, context);
            return true;
        }
        return false;
    }
    
    Value cleanupBindings(final Value value) throws JessException {
        if (value.type() == 4096) {
            final BindingValue bindingValue = new BindingValue((BindingValue)value);
            bindingValue.resetFactNumber();
            return bindingValue;
        }
        if (value.type() == 64) {
            final Funcall funcall = (Funcall)value.funcallValue(null).clone();
            for (int i = 0; i < funcall.size(); ++i) {
                funcall.set(this.cleanupBindings(funcall.get(i)), i);
            }
            return new FuncallValue(funcall);
        }
        return value;
    }
    
    void passAlong(final Token token, final Context context) throws JessException {
        final Node[] succ = this.m_succ;
        for (int i = 0; i < this.m_nSucc; ++i) {
            succ[i].callNodeRight(token, context);
        }
    }
    
    void debugPrint(final Token token, final boolean b) {
        System.out.println(new StringBuffer().append(this).append(' ').append(token.topFact()).append(" => ").append(b).toString());
    }
    
    String getCompilationTraceToken() {
        return "1";
    }
}
