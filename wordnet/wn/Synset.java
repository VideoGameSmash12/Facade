package wordnet.wn;

import java.util.Vector;

public class Synset implements PointerTarget
{
    protected FileBackedDictionary dictionary;
    protected POS pos;
    protected long offset;
    protected boolean isAdjectiveCluster;
    protected Word[] words;
    protected Pointer[] pointers;
    protected String gloss;
    
    Synset initializeFrom(final String s) {
        final TokenizerParser tokenizerParser = new TokenizerParser(s, " ");
        this.offset = tokenizerParser.nextLong();
        tokenizerParser.nextToken();
        String nextToken = tokenizerParser.nextToken();
        this.isAdjectiveCluster = false;
        if (nextToken.equals("s")) {
            nextToken = "a";
            this.isAdjectiveCluster = true;
        }
        this.pos = POS.lookup(nextToken);
        final int nextHexInt = tokenizerParser.nextHexInt();
        this.words = new Word[nextHexInt];
        for (int i = 0; i < nextHexInt; ++i) {
            String s2 = tokenizerParser.nextToken();
            tokenizerParser.nextHexInt();
            int n = 0;
            if (s2.charAt(s2.length() - 1) == ')' && s2.indexOf(40) > 0) {
                final int index = s2.indexOf(40);
                final String substring = s2.substring(index + 1, s2.length() - 1);
                s2 = s2.substring(0, index - 1);
                if (substring.equals("p")) {
                    n |= 0x1;
                }
                else if (substring.equals("a")) {
                    n |= 0x2;
                }
                else {
                    if (!substring.equals("ip")) {
                        throw new RuntimeException("unknown syntactic marker " + substring);
                    }
                    n |= 0x4;
                }
            }
            this.words[i] = new Word(this, i, s2.replace('_', ' '), n);
        }
        final int nextInt = tokenizerParser.nextInt();
        this.pointers = new Pointer[nextInt];
        for (int j = 0; j < nextInt; ++j) {
            this.pointers[j] = Pointer.parsePointer(this.dictionary, this, j, tokenizerParser);
        }
        if (this.pos == POS.VERB) {
            for (int nextInt2 = tokenizerParser.nextInt(), k = 0; k < nextInt2; ++k) {
                tokenizerParser.nextToken();
                final int nextHexInt2 = tokenizerParser.nextHexInt();
                final int nextHexInt3 = tokenizerParser.nextHexInt();
                if (nextHexInt3 > 0) {
                    this.words[nextHexInt3 - 1].setVerbFrameFlag(nextHexInt2);
                }
                else {
                    for (int l = 0; l < this.words.length; ++l) {
                        this.words[l].setVerbFrameFlag(nextHexInt2);
                    }
                }
            }
        }
        this.gloss = null;
        final int index2 = s.indexOf(124);
        if (index2 > 0) {
            this.gloss = s.substring(index2 + 2).trim();
        }
        return this;
    }
    
    static Synset parseSynset(final FileBackedDictionary fileBackedDictionary, final String s) {
        try {
            return new Synset(fileBackedDictionary).initializeFrom(s);
        }
        catch (RuntimeException ex) {
            System.err.println("while parsing " + s);
            throw ex;
        }
    }
    
    public boolean equals(final Object o) {
        boolean b = false;
        if (o instanceof Synset && ((Synset)o).pos.equals(this.pos) && ((Synset)o).offset == this.offset) {
            b = true;
        }
        return b;
    }
    
    public int hashCode() {
        return this.pos.hashCode() ^ (int)this.offset;
    }
    
    public String toString() {
        return "[Synset " + this.offset + '@' + this.pos + ": \"" + this.getDescription() + "\"]";
    }
    
    public POS getPOS() {
        return this.pos;
    }
    
    public String getGloss() {
        return this.gloss;
    }
    
    public Word[] getWords() {
        return this.words;
    }
    
    public Word getWord(final int n) {
        return this.words[n];
    }
    
    public String getDescription() {
        final StringBuffer sb = new StringBuffer();
        for (int i = 0; i < this.words.length; ++i) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(this.words[i].lemma);
        }
        return sb.toString();
    }
    
    public String getLongDescription() {
        String s = this.getDescription();
        final String gloss = this.getGloss();
        if (gloss != null) {
            s = s + " -- (" + gloss + ')';
        }
        return s;
    }
    
    protected static PointerTarget[] collectTargets(final Pointer[] array) {
        final PointerTarget[] array2 = new PointerTarget[array.length];
        for (int i = 0; i < array.length; ++i) {
            array2[i] = array[i].getTarget();
        }
        return array2;
    }
    
    public Pointer[] getPointers() {
        return this.pointers;
    }
    
    public Pointer[] getPointers(final PointerType pointerType) {
        final Vector vector = new Vector<Pointer>(this.pointers.length);
        for (int i = 0; i < this.pointers.length; ++i) {
            final Pointer pointer = this.pointers[i];
            if (pointer.getType().equals(pointerType)) {
                vector.addElement(pointer);
            }
        }
        final Pointer[] array = new Pointer[vector.size()];
        vector.copyInto(array);
        return array;
    }
    
    public PointerTarget[] getTargets() {
        return collectTargets(this.getPointers());
    }
    
    public PointerTarget[] getTargets(final PointerType pointerType) {
        return collectTargets(this.getPointers(pointerType));
    }
    
    Synset(final FileBackedDictionary dictionary) {
        this.dictionary = dictionary;
    }
}
