package jess;

import java.io.Serializable;

public class ValueVector implements Cloneable, Serializable
{
    Value[] m_v;
    private int m_ptr;
    
    public final int size() {
        return this.m_ptr;
    }
    
    public Object clone() {
        return this.cloneInto(new ValueVector(this.m_ptr));
    }
    
    public ValueVector cloneInto(final ValueVector valueVector) {
        if (this.m_ptr > valueVector.m_v.length) {
            valueVector.m_v = new Value[this.m_ptr];
        }
        valueVector.m_ptr = this.m_ptr;
        System.arraycopy(this.m_v, 0, valueVector.m_v, 0, this.m_ptr);
        return valueVector;
    }
    
    public Value get(final int n) throws JessException {
        if (n < 0 || n >= this.m_ptr) {
            throw new JessException("ValueVector.get", "Bad index " + n + " in call to get() on this vector: ", this.toStringWithParens());
        }
        return this.m_v[n];
    }
    
    public ValueVector setLength(final int ptr) {
        if (ptr > this.m_v.length) {
            final Value[] v = new Value[ptr];
            System.arraycopy(this.m_v, 0, v, 0, this.m_v.length);
            this.m_v = v;
        }
        this.m_ptr = ptr;
        return this;
    }
    
    public final ValueVector set(final Value value, final int n) throws JessException {
        if (n < 0 || n >= this.m_ptr) {
            throw new JessException("ValueVector.set", "Bad index " + n + " in call to set() on this vector:", this.toStringWithParens());
        }
        this.m_v[n] = value;
        return this;
    }
    
    public final ValueVector add(final Value value) {
        if (this.m_ptr >= this.m_v.length) {
            final Value[] v = new Value[this.m_v.length * 2];
            System.arraycopy(this.m_v, 0, v, 0, this.m_v.length);
            this.m_v = v;
        }
        this.m_v[this.m_ptr++] = value;
        return this;
    }
    
    public final ValueVector remove(final int n) throws JessException {
        if (n < 0 || n >= this.m_ptr) {
            throw new JessException("ValueVector.set", "Bad index " + n + " in call to remove() on this vector:", this.toStringWithParens());
        }
        if (n < this.m_ptr - 1) {
            System.arraycopy(this.m_v, n + 1, this.m_v, n, this.m_ptr - n);
        }
        this.m_v[--this.m_ptr] = null;
        return this;
    }
    
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ValueVector)) {
            return false;
        }
        final ValueVector valueVector = (ValueVector)o;
        if (this.m_ptr != valueVector.m_ptr) {
            return false;
        }
        for (int i = this.m_ptr - 1; i >= 0; --i) {
            if (!this.m_v[i].equals(valueVector.m_v[i])) {
                return false;
            }
        }
        return true;
    }
    
    public static void copy(final ValueVector valueVector, final int n, final ValueVector valueVector2, final int n2, final int n3) {
        final int length = n2 + n3;
        final int ptr = valueVector2.m_ptr;
        if (length > ptr) {
            valueVector2.setLength(length);
        }
        for (int i = ptr; i < n2; ++i) {
            valueVector2.m_v[i] = Funcall.NIL;
        }
        System.arraycopy(valueVector.m_v, n, valueVector2.m_v, n2, n3);
    }
    
    public ValueVector addAll(final ValueVector valueVector) {
        copy(valueVector, 0, this, this.m_ptr, valueVector.m_ptr);
        return this;
    }
    
    public String toString() {
        final StringBuffer sb = new StringBuffer(100);
        for (int i = 0; i < this.m_ptr; ++i) {
            if (i > 0) {
                sb.append(" ");
            }
            sb.append(this.m_v[i]);
        }
        return sb.toString();
    }
    
    public String toStringWithParens() {
        final StringBuffer sb = new StringBuffer(100);
        sb.append("(");
        for (int i = 0; i < this.m_ptr; ++i) {
            if (i > 0) {
                sb.append(" ");
            }
            sb.append(this.m_v[i].toStringWithParens());
        }
        sb.append(")");
        return sb.toString();
    }
    
    private final /* synthetic */ void this() {
        this.m_ptr = 0;
    }
    
    public ValueVector() {
        this(10);
    }
    
    public ValueVector(final int n) {
        this.this();
        this.m_v = new Value[n];
    }
}
