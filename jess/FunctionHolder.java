package jess;

import java.io.Serializable;

final class FunctionHolder implements Serializable
{
    private Userfunction m_uf;
    
    final void setFunction(final Userfunction uf) {
        this.m_uf = uf;
    }
    
    final Userfunction getFunction() {
        return this.m_uf;
    }
    
    final Value call(final Funcall funcall, final Context context) throws JessException {
        Userfunction userfunction = this.m_uf;
        if (context.getInAdvice()) {
            userfunction = this.stripAdvice();
        }
        return userfunction.call(funcall, context);
    }
    
    final Userfunction stripAdvice() {
        Userfunction userfunction;
        for (userfunction = this.m_uf; userfunction instanceof Advice; userfunction = ((Advice)userfunction).getFunction()) {}
        return userfunction;
    }
    
    FunctionHolder(final Userfunction function) {
        this.setFunction(function);
    }
}
