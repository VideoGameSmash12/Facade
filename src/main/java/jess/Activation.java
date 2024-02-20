package jess;

import java.io.PrintWriter;
import java.io.Serializable;

public class Activation implements Serializable
{
    private Token m_token;
    private Defrule m_rule;
    private boolean m_inactive;
    private int m_salience;
    private int m_seq;
    
    public final Token getToken() {
        return this.m_token;
    }
    
    public final Defrule getRule() {
        return this.m_rule;
    }
    
    public boolean isInactive() {
        return this.m_inactive;
    }
    
    void setInactive() {
        this.m_inactive = true;
    }
    
    public int getSalience() {
        return this.m_salience;
    }
    
    void fire(final Rete rete) throws JessException {
        this.m_rule.fire(this.m_token, rete);
    }
    
    void setSequenceNumber(final int seq) {
        this.m_seq = seq;
    }
    
    void debugPrint(final PrintWriter printWriter) {
        this.m_rule.debugPrint(this.m_token, this.m_seq, printWriter);
    }
    
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Activation)) {
            return false;
        }
        final Activation activation = (Activation)o;
        boolean b = false;
        if (this.m_rule == activation.m_rule && this.m_token.dataEquals(activation.m_token)) {
            b = true;
        }
        return b;
    }
    
    boolean getAutoFocus() {
        return this.m_rule.getAutoFocus();
    }
    
    String getModule() {
        return this.m_rule.getModule();
    }
    
    void evalSalience(final Rete rete) throws JessException {
        this.m_salience = this.m_rule.evalSalience(rete);
    }
    
    public String toString() {
        final StringBuffer sb = new StringBuffer(100);
        sb.append("[Activation: ");
        sb.append(this.m_rule.getDisplayName());
        sb.append(" ");
        sb.append(this.m_token.factList());
        sb.append(" ; time=");
        sb.append(this.m_token.getTime());
        sb.append(" ; salience=");
        sb.append(this.getSalience());
        sb.append("]");
        return sb.toString();
    }
    
    Activation(final Token token, final Defrule rule) {
        this.m_token = token;
        this.m_rule = rule;
        this.m_salience = this.m_rule.getSalience();
    }
}
