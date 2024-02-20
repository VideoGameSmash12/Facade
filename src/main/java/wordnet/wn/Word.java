package wordnet.wn;

import java.util.Vector;

public class Word implements PointerTarget
{
    public static final int NONE = 0;
    public static final int PREDICATIVE = 1;
    public static final int ATTRIBUTIVE = 2;
    public static final int IMMEDIATE_POSTNOMINAL = 4;
    protected Synset synset;
    protected int index;
    protected String lemma;
    protected int flags;
    protected long verbFrameFlags;
    
    void setVerbFrameFlag(final int n) {
        this.verbFrameFlags |= 1 << n;
    }
    
    public boolean equals(final Object o) {
        boolean b = false;
        if (o instanceof Word && ((Word)o).synset.equals(this.synset) && ((Word)o).index == this.index) {
            b = true;
        }
        return b;
    }
    
    public int hashCode() {
        return this.synset.hashCode() ^ this.index;
    }
    
    public String toString() {
        return "[Word " + this.synset.offset + '@' + this.synset.pos + '(' + this.index + "): \"" + this.getLemma() + "\"]";
    }
    
    public Synset getSynset() {
        return this.synset;
    }
    
    public POS getPOS() {
        return this.synset.getPOS();
    }
    
    public int getIndex() {
        return this.index;
    }
    
    public String getLemma() {
        return this.lemma;
    }
    
    public long getFlags() {
        return this.flags;
    }
    
    public long getVerbFrameFlags() {
        return this.verbFrameFlags;
    }
    
    public String getDescription() {
        return this.lemma;
    }
    
    public String getLongDescription() {
        String s = this.getDescription();
        final String gloss = this.synset.getGloss();
        if (gloss != null) {
            s = s + " -- (" + gloss + ')';
        }
        return s;
    }
    
    protected Pointer[] restrictPointers(final Pointer[] array) {
        final Vector vector = new Vector<Pointer>(array.length);
        for (int i = 0; i < array.length; ++i) {
            final Pointer pointer = array[i];
            if (pointer.getSource() == this) {
                vector.addElement(pointer);
            }
        }
        final Pointer[] array2 = new Pointer[vector.size()];
        vector.copyInto(array2);
        return array2;
    }
    
    public Pointer[] getPointers() {
        return this.restrictPointers(this.synset.getPointers());
    }
    
    public Pointer[] getPointers(final PointerType pointerType) {
        return this.restrictPointers(this.synset.getPointers(pointerType));
    }
    
    public PointerTarget[] getTargets() {
        return Synset.collectTargets(this.getPointers());
    }
    
    public PointerTarget[] getTargets(final PointerType pointerType) {
        return Synset.collectTargets(this.getPointers(pointerType));
    }
    
    public Word(final Synset synset, final int index, final String lemma, final int flags) {
        this.synset = synset;
        this.index = index;
        this.lemma = lemma;
        this.flags = flags;
    }
}
