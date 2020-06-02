package jess;

import java.io.Serializable;
import java.util.Comparator;

class FactComparator implements Comparator, Serializable
{
    public int compare(final Object o, final Object o2) {
        return ((Fact)o).getFactId() - ((Fact)o2).getFactId();
    }
}
