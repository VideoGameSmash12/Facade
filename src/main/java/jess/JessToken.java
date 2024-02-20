package jess;

import java.io.Serializable;

final class JessToken implements Serializable
{
    String m_sval;
    double m_nval;
    int m_lineno;
    int m_ttype;
    
    final Value tokenToValue(final Context context) throws JessException {
        switch (this.m_ttype) {
            case 32: {
                return new Value(this.m_nval, 32);
            }
            case 4: {
                return new Value(this.m_nval, 4);
            }
            case 2: {
                return new Value(this.m_sval, 2);
            }
            case 8:
            case 8192: {
                if (context != null) {
                    return context.getVariable(this.m_sval);
                }
                return new Value("?" + this.m_sval, 1);
            }
            case 1: {
                return new Value(this.m_sval, 1);
            }
            case 0: {
                if ("EOF".equals(this.m_sval)) {
                    return Funcall.EOF;
                }
                break;
            }
        }
        return new Value(new StringBuffer().append((char)this.m_ttype).toString(), 2);
    }
    
    final boolean isBlankVariable() {
        boolean b = false;
        if (this.m_sval != null && this.m_sval.startsWith("_blank_")) {
            b = true;
        }
        return b;
    }
    
    public final String toString() {
        if (this.m_ttype == 8) {
            return "?" + this.m_sval;
        }
        if (this.m_ttype == 8192) {
            return "$?" + this.m_sval;
        }
        if (this.m_ttype == 2) {
            return "\"" + this.m_sval + '\"';
        }
        if (this.m_sval != null) {
            return this.m_sval;
        }
        if (this.m_ttype == 32) {
            return new StringBuffer().append(this.m_nval).toString();
        }
        if (this.m_ttype == 4) {
            return new StringBuffer().append((int)this.m_nval).toString();
        }
        return new StringBuffer().append((char)this.m_ttype).toString();
    }
}
