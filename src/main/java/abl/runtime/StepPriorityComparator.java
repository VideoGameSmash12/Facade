package abl.runtime;

import java.util.Comparator;

class StepPriorityComparator implements Comparator
{
    public int compare(final Object o, final Object o2) {
        return new Integer(((Step)o2).getPriority()).compareTo(new Integer(((Step)o).getPriority()));
    }
}
