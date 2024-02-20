package jess;

import java.util.Comparator;
import java.util.Arrays;
import java.util.Map;
import java.io.Serializable;
import java.util.Iterator;

class SortedIterator implements Iterator, Serializable
{
    private Object[] m_arr;
    private int m_index;
    
    public boolean hasNext() {
        boolean b = false;
        if (this.m_index < this.m_arr.length) {
            b = true;
        }
        return b;
    }
    
    public Object next() {
        return this.m_arr[this.m_index++];
    }
    
    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }
    
    SortedIterator(final Map map) {
        Arrays.sort(this.m_arr = map.keySet().toArray(), new FactComparator());
    }
}
