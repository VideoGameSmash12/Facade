package abl.runtime;

import java.util.Comparator;

class BehaviorSpecificityComparator implements Comparator
{
    public int compare(final Object o, final Object o2) {
        return -new Integer(((SatisfiedBehavior)o).behDesc.specificity).compareTo(new Integer(((SatisfiedBehavior)o2).behDesc.specificity));
    }
}
