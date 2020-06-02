package jess;

import java.io.Serializable;

public class Token implements Serializable
{
    int m_tag;
    int m_negcnt;
    int m_sortcode;
    private Fact m_fact;
    private int m_size;
    private Token m_parent;
    private int m_totalTime;
    private int m_time;
    
    Token getParent() {
        return this.m_parent;
    }
    
    public final Fact topFact() {
        return this.m_fact;
    }
    
    public final Fact fact(final int n) {
        int n2 = this.m_size - n;
        Token parent = this;
        while (--n2 > 0) {
            parent = parent.m_parent;
        }
        return parent.m_fact;
    }
    
    public final int size() {
        return this.m_size;
    }
    
    void updateTime(final Rete rete) {
        final int time = rete.getTime();
        this.m_totalTime = this.m_totalTime - this.m_fact.getTime() + time;
        this.m_time = time;
    }
    
    int getTime() {
        return this.m_time;
    }
    
    int getTotalTime() {
        return this.m_totalTime;
    }
    
    public final boolean dataEquals(final Token token) {
        return token == this || (this.m_sortcode == token.m_sortcode && this.m_fact.getFactId() == token.m_fact.getFactId() && this.m_fact.equals(token.m_fact) && (this.m_parent == token.m_parent || this.m_parent.dataEquals(token.m_parent)));
    }
    
    public boolean equals(final Object o) {
        return o instanceof Token && this.dataEquals((Token)o);
    }
    
    public String toString() {
        final StringBuffer sb = new StringBuffer(100);
        sb.append("[Token: size=");
        sb.append(this.m_size);
        sb.append(";sortcode=");
        sb.append(this.m_sortcode);
        sb.append(";tag=");
        sb.append((this.m_tag == 0) ? "ADD" : ((this.m_tag == 2) ? "UPDATE" : "REMOVE"));
        sb.append(";negcnt=");
        sb.append(this.m_negcnt);
        sb.append(";facts=");
        for (int i = 0; i < this.m_size; ++i) {
            sb.append(this.fact(i).toString());
            sb.append(";");
        }
        sb.append("]");
        return sb.toString();
    }
    
    String factList() {
        final StringBuffer sb = new StringBuffer(100);
        int n = 1;
        for (int i = 0; i < this.size(); ++i) {
            if (n == 0) {
                sb.append(",");
            }
            final int factId = this.fact(i).getFactId();
            if (factId != -1) {
                sb.append(" f-");
                sb.append(factId);
            }
            n = 0;
        }
        return sb.toString();
    }
    
    public int hashCode() {
        return this.m_sortcode;
    }
    
    public Token prepare(final boolean b) throws JessException {
        return this;
    }
    
    public Token(final Fact fact, final int tag) throws JessException {
        ++this.m_size;
        this.m_fact = fact;
        this.m_tag = tag;
        this.m_totalTime = fact.getTime();
        this.m_time = this.m_totalTime;
        this.m_sortcode = fact.getFactId();
    }
    
    public Token(final Token parent, final Fact fact) throws JessException {
        this.m_fact = fact;
        this.m_parent = parent;
        this.m_tag = parent.m_tag;
        this.m_size = parent.m_size + 1;
        this.m_sortcode = (parent.m_sortcode << 3) + fact.getFactId();
        final int time = fact.getTime();
        this.m_totalTime = parent.m_totalTime + time;
        this.m_time = Math.max(time, parent.m_time);
    }
    
    public Token(final Token token, final Token token2) throws JessException {
        this(token, token2.topFact());
    }
    
    public Token(final Token token) throws JessException {
        this.m_fact = token.m_fact;
        this.m_parent = token.m_parent;
        this.m_tag = token.m_tag;
        this.m_size = token.m_size;
        this.m_sortcode = token.m_sortcode;
        this.m_time = token.m_time;
        this.m_totalTime = token.m_totalTime;
        this.m_negcnt = token.m_negcnt;
    }
}
