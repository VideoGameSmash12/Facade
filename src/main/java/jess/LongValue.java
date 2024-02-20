package jess;

import java.io.Serializable;

public class LongValue extends Value implements Serializable
{
    private long m_long;
    
    public final long longValue(final Context context) throws JessException {
        return this.m_long;
    }
    
    public final double numericValue(final Context context) throws JessException {
        return (double)this.m_long;
    }
    
    public final int intValue(final Context context) throws JessException {
        return (int)this.m_long;
    }
    
    public final String stringValue(final Context context) throws JessException {
        return this.toString();
    }
    
    public final String toString() {
        return new Long(this.m_long).toString();
    }
    
    public final boolean equals(final Value value) {
        if (value.type() != 65536) {
            return false;
        }
        boolean b = false;
        if (this.m_long == ((LongValue)value).m_long) {
            b = true;
        }
        return b;
    }
    
    public LongValue(final long long1) throws JessException {
        super((double)long1, 65536);
        this.m_long = long1;
    }
}
