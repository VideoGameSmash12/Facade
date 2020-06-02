package abl.runtime;

import java.util.Comparator;

class StepExpansionComparator implements Comparator
{
    public int compare(final Object o, final Object o2) {
        final boolean currentLineOfExpansion = ((Step)o).currentLineOfExpansion(null);
        final boolean currentLineOfExpansion2 = ((Step)o2).currentLineOfExpansion(null);
        int n = 0;
        if (currentLineOfExpansion && !currentLineOfExpansion2) {
            n = -1;
        }
        else if (currentLineOfExpansion == currentLineOfExpansion2) {
            n = 0;
        }
        else if (!currentLineOfExpansion && currentLineOfExpansion2) {
            n = 1;
        }
        return n;
    }
}
