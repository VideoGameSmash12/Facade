package jess;

import java.io.Serializable;

class TokenTree implements Serializable
{
    int m_hash;
    TokenVector[] m_tokens;
    boolean m_useSortcode;
    int m_tokenIdx;
    int m_factIdx;
    int m_subIdx;
    
    final void clear() {
        for (int i = 0; i < this.m_hash; ++i) {
            if (this.m_tokens[i] != null) {
                this.m_tokens[i].clear();
            }
        }
    }
    
    private final Token subsetToken(final Token token) {
        Token parent;
        for (parent = token; parent.size() > this.m_tokenIdx; parent = parent.getParent()) {}
        return parent;
    }
    
    private final int codeForToken(final Token token) throws JessException {
        int n;
        if (this.m_useSortcode) {
            if (this.m_tokenIdx == 0) {
                n = token.m_sortcode;
            }
            else {
                n = this.subsetToken(token).m_sortcode;
            }
        }
        else if (this.m_factIdx == -1) {
            n = token.fact(this.m_tokenIdx).getFactId();
        }
        else if (this.m_subIdx == -1) {
            n = token.fact(this.m_tokenIdx).m_v[this.m_factIdx].hashCode();
        }
        else {
            n = token.fact(this.m_tokenIdx).m_v[this.m_factIdx].listValue(null).m_v[this.m_subIdx].hashCode();
        }
        if (n < 0) {
            n = -n;
        }
        return n;
    }
    
    synchronized boolean add(final Token token, final boolean b) throws JessException {
        final TokenVector codeInTree = this.findCodeInTree(this.codeForToken(token), true);
        if (b) {
            for (int size = codeInTree.size(), i = 0; i < size; ++i) {
                if (token.dataEquals(codeInTree.elementAt(i))) {
                    return false;
                }
            }
        }
        codeInTree.addElement(token);
        return true;
    }
    
    synchronized boolean remove(final Token token) throws JessException {
        final TokenVector codeInTree = this.findCodeInTree(this.codeForToken(token), false);
        if (codeInTree == null) {
            return false;
        }
        final int size = codeInTree.size();
        if (size == 0) {
            return false;
        }
        for (int i = 0; i < size; ++i) {
            if (token.dataEquals(codeInTree.elementAt(i))) {
                codeInTree.removeElementAt(i);
                return true;
            }
        }
        return false;
    }
    
    synchronized TokenVector findCodeInTree(int n, final boolean b) {
        n %= this.m_hash;
        if (n < 0) {
            n = -n;
        }
        if (b && this.m_tokens[n] == null) {
            return this.m_tokens[n] = new TokenVector();
        }
        return this.m_tokens[n];
    }
    
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        for (int i = 0; i < this.m_hash; ++i) {
            if (this.m_tokens[i] != null) {
                sb.append(i);
                sb.append(": ");
                sb.append(this.m_tokens[i]);
                sb.append("\n");
            }
        }
        return sb.toString();
    }
    
    TokenTree(final int hash, final boolean useSortcode, final int tokenIdx, final int factIdx, final int subIdx) {
        this.m_hash = hash;
        this.m_useSortcode = useSortcode;
        this.m_factIdx = factIdx;
        this.m_subIdx = subIdx;
        this.m_tokenIdx = tokenIdx;
        this.m_tokens = new TokenVector[this.m_hash];
    }
}
