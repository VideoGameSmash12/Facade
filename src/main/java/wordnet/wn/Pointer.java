package wordnet.wn;

public class Pointer
{
    protected FileBackedDictionary dictionary;
    protected Synset synset;
    protected int index;
    protected PointerType pointerType;
    protected PointerTarget source;
    protected TargetIndex targetIndex;
    
    Pointer initializeFrom(final TokenizerParser tokenizerParser) {
        this.pointerType = PointerType.parseKey(tokenizerParser.nextToken());
        final long nextLong = tokenizerParser.nextLong();
        final POS lookup = POS.lookup(tokenizerParser.nextToken());
        final int nextHexInt = tokenizerParser.nextHexInt();
        final int n = nextHexInt / 256;
        final int n2 = nextHexInt & 0xFF;
        this.source = this.resolveTarget(this.synset, lookup, n);
        this.targetIndex = new TargetIndex(lookup, nextLong, n2);
        return this;
    }
    
    static Pointer parsePointer(final FileBackedDictionary fileBackedDictionary, final Synset synset, final int n, final TokenizerParser tokenizerParser) {
        return new Pointer(fileBackedDictionary, synset, n).initializeFrom(tokenizerParser);
    }
    
    public boolean equals(final Object o) {
        boolean b = false;
        if (o instanceof Pointer && ((Pointer)o).source.equals(this.source) && ((Pointer)o).index == this.index) {
            b = true;
        }
        return b;
    }
    
    public int hashCode() {
        return this.source.hashCode() + this.index;
    }
    
    public String toString() {
        return "[Link #" + this.index + " from " + this.source + ']';
    }
    
    public PointerType getType() {
        return this.pointerType;
    }
    
    public boolean isLexical() {
        return this.source instanceof Word;
    }
    
    protected PointerTarget resolveTarget(final Synset synset, final POS pos, final long n) {
        if (n >= 100L) {
            return this.dictionary.getSynsetAt(pos, n);
        }
        if (n == 0L) {
            return synset;
        }
        return synset.getWord((int)n - 1);
    }
    
    public PointerTarget getSource() {
        return this.source;
    }
    
    public PointerTarget getTarget() {
        return this.resolveTarget(this.synset, this.targetIndex.pos, this.targetIndex.offset);
    }
    
    Pointer(final FileBackedDictionary dictionary, final Synset synset, final int index) {
        this.dictionary = dictionary;
        this.synset = synset;
        this.index = index;
    }
    
    protected class TargetIndex
    {
        POS pos;
        long offset;
        int index;
        
        TargetIndex(final POS pos, final long offset, final int index) {
            this.pos = pos;
            this.offset = offset;
            this.index = index;
        }
    }
}
