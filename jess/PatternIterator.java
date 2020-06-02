package jess;

import java.util.ArrayList;
import java.util.Iterator;

class PatternIterator implements Iterator
{
    private int m_index;
    private Pattern[] m_patterns;
    
    private final void storePatternsInList(final LHSComponent lhsComponent, final ArrayList list) {
        for (int i = 0; i < lhsComponent.getGroupSize(); ++i) {
            final LHSComponent lhsComponent2 = lhsComponent.getLHSComponent(i);
            if (lhsComponent2 instanceof Pattern) {
                list.add(lhsComponent2);
            }
            else {
                this.storePatternsInList(lhsComponent2, list);
            }
        }
    }
    
    public boolean hasNext() {
        boolean b = false;
        if (this.m_index < this.m_patterns.length) {
            b = true;
        }
        return b;
    }
    
    public Object next() {
        return this.m_patterns[this.m_index++];
    }
    
    public void remove() {
        throw new UnsupportedOperationException();
    }
    
    PatternIterator(final LHSComponent lhsComponent) {
        final ArrayList list = new ArrayList();
        this.storePatternsInList(lhsComponent, list);
        this.m_patterns = list.toArray(new Pattern[list.size()]);
    }
}
