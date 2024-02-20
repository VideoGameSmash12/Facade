package jess;

class Node1MTMF extends Node1
{
    private int m_idx;
    private int m_slotSize;
    private int m_nMultifields;
    private boolean[] m_multiIndexes;
    
    void callNodeRight(final Token token, final Context context) throws JessException {
        if (this.processClearCommand(token, context)) {
            return;
        }
        final int n = token.fact(0).get(this.m_idx).listValue(null).size() - this.m_slotSize + this.m_nMultifields;
        if (n < 0) {
            return;
        }
        this.partition(token, n, this.m_nMultifields, context);
    }
    
    private final void partition(final Token token, final int n, final int n2, final Context context) throws JessException {
        final int[] array = new int[n2];
        do {
            if (this.testForSum(array, n, n2)) {
                this.process(token, array, context);
            }
            this.addOne(array, n, n2);
        } while (array[n2 - 1] <= n);
    }
    
    private final void addOne(final int[] array, final int n, final int n2) {
        final int n3 = 0;
        ++array[n3];
        for (int i = 0; i < n2 - 1; ++i) {
            if (array[i] > n) {
                array[i] = 0;
                final int n4 = i + 1;
                ++array[n4];
            }
        }
    }
    
    private final boolean testForSum(final int[] array, final int n, final int n2) {
        int n3 = 0;
        for (int i = 0; i < n2; ++i) {
            n3 += array[i];
        }
        boolean b = false;
        if (n3 == n) {
            b = true;
        }
        return b;
    }
    
    private final void process(Token token, final int[] array, final Context context) throws JessException {
        token = Rete.getFactory().newToken(this.createModifiedFact(token.fact(0), token.fact(0).get(this.m_idx).listValue(null), array), token.m_tag);
        this.passAlong(token, context);
    }
    
    private final Fact createModifiedFact(final Fact icon, final ValueVector valueVector, final int[] array) throws JessException {
        final Fact fact = (Fact)icon.clone();
        fact.setIcon(icon);
        final ValueVector valueVector2 = new ValueVector();
        valueVector2.setLength(this.m_slotSize);
        int i = 0;
        int n = 0;
        int n2 = 0;
        while (i < this.m_slotSize) {
            if (!this.m_multiIndexes[i]) {
                valueVector2.set(valueVector.get(n++), i);
            }
            else {
                final ValueVector valueVector3 = new ValueVector();
                final int length = array[n2++];
                valueVector3.setLength(length);
                for (int j = 0; j < length; ++j) {
                    valueVector3.set(valueVector.get(n++), j);
                }
                valueVector2.set(new Value(valueVector3, 512), i);
            }
            ++i;
        }
        fact.set(new Value(valueVector2, 512), this.m_idx);
        return fact;
    }
    
    public String toString() {
        return "[Split the multislot at index " + this.m_idx + " into " + this.m_slotSize + " pieces]";
    }
    
    public boolean equals(final Object o) {
        if (!(o instanceof Node1MTMF)) {
            return false;
        }
        final Node1MTMF node1MTMF = (Node1MTMF)o;
        if (this.m_idx != node1MTMF.m_idx || this.m_slotSize != node1MTMF.m_slotSize || this.m_nMultifields != node1MTMF.m_nMultifields) {
            return false;
        }
        for (int i = 0; i < this.m_slotSize; ++i) {
            if (this.m_multiIndexes[i] != node1MTMF.m_multiIndexes[i]) {
                return false;
            }
        }
        return true;
    }
    
    Node1MTMF(final int idx, final boolean[] multiIndexes) {
        this.m_idx = idx;
        this.m_slotSize = multiIndexes.length;
        this.m_multiIndexes = multiIndexes;
        for (int i = 0; i < this.m_slotSize; ++i) {
            if (this.m_multiIndexes[i]) {
                ++this.m_nMultifields;
            }
        }
    }
}
