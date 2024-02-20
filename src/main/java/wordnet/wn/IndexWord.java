package wordnet.wn;

public class IndexWord
{
    protected FileBackedDictionary dictionary;
    protected POS pos;
    protected long offset;
    protected String lemma;
    protected int taggedSenseCount;
    protected long[] synsetOffsets;
    protected Synset[] synsets;
    
    IndexWord initializeFrom(final String s) {
        final TokenizerParser tokenizerParser = new TokenizerParser(s, " ");
        this.lemma = tokenizerParser.nextToken().replace('_', ' ');
        this.pos = POS.lookup(tokenizerParser.nextToken());
        tokenizerParser.nextToken();
        for (int nextInt = tokenizerParser.nextInt(), i = 0; i < nextInt; ++i) {
            tokenizerParser.nextToken();
        }
        final int nextInt2 = tokenizerParser.nextInt();
        this.taggedSenseCount = tokenizerParser.nextInt();
        this.synsetOffsets = new long[nextInt2];
        for (int j = 0; j < nextInt2; ++j) {
            this.synsetOffsets[j] = tokenizerParser.nextLong();
        }
        return this;
    }
    
    static IndexWord parseIndexWord(final FileBackedDictionary fileBackedDictionary, final String s) {
        try {
            return new IndexWord(fileBackedDictionary).initializeFrom(s);
        }
        catch (RuntimeException ex) {
            throw ex;
        }
    }
    
    public boolean equals(final Object o) {
        boolean b = false;
        if (o instanceof IndexWord && ((IndexWord)o).pos.equals(this.pos) && ((IndexWord)o).offset == this.offset) {
            b = true;
        }
        return b;
    }
    
    public int hashCode() {
        return this.pos.hashCode() ^ (int)this.offset;
    }
    
    public String toString() {
        return "[IndexWord " + this.offset + '@' + this.pos.getLabel() + ": \"" + this.lemma + "\"]";
    }
    
    public POS getPOS() {
        return this.pos;
    }
    
    public String getLemma() {
        return this.lemma;
    }
    
    public int getTaggedSenseCount() {
        return this.taggedSenseCount;
    }
    
    public Synset[] getSenses() {
        if (this.synsets == null) {
            this.synsets = new Synset[this.synsetOffsets.length];
            for (int i = 0; i < this.synsetOffsets.length; ++i) {
                this.synsets[i] = this.dictionary.getSynsetAt(this.pos, this.synsetOffsets[i]);
            }
        }
        return this.synsets;
    }
    
    IndexWord(final FileBackedDictionary dictionary) {
        this.dictionary = dictionary;
    }
}
