package jess;

import java.util.Arrays;
import java.io.Serializable;

class TokenVector implements Serializable
{
    private Token[] m_v;
    private int m_ptr;
    
    final int size() {
        return this.m_ptr;
    }
    
    final void clear() {
        if (this.m_ptr > 0) {
            Arrays.fill(this.m_v, 0, this.m_ptr, null);
            this.m_ptr = 0;
        }
    }
    
    final void addElement(final Token token) {
        if (this.m_ptr >= this.m_v.length) {
            final Token[] v = new Token[this.m_v.length * 2];
            System.arraycopy(this.m_v, 0, v, 0, this.m_v.length);
            this.m_v = v;
        }
        this.m_v[this.m_ptr++] = token;
    }
    
    final Token elementAt(final int n) {
        return this.m_v[n];
    }
    
    final void removeElementAt(final int n) {
        this.m_v[n] = this.m_v[this.m_ptr - 1];
        this.m_v[--this.m_ptr] = null;
    }
    
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        for (int i = 0; i < this.m_ptr; ++i) {
            sb.append(this.m_v[i]);
            sb.append(" ");
        }
        return sb.toString();
    }
    
    private final /* synthetic */ void this() {
        this.m_ptr = 0;
    }
    
    TokenVector() {
        this.this();
        this.m_v = new Token[3];
    }
}
