package wordnet.wn;

import java.util.NoSuchElementException;

public class POS
{
    public static final POS NOUN;
    public static final POS VERB;
    public static final POS ADJ;
    public static final POS ADV;
    public static final POS[] CATS;
    protected String label;
    protected String key;
    
    public String toString() {
        return "[POS " + this.label + ']';
    }
    
    public boolean equals(final Object o) {
        boolean b = false;
        if (o instanceof POS && this.key.equals(((POS)o).key)) {
            b = true;
        }
        return b;
    }
    
    public int hashCode() {
        return this.key.hashCode();
    }
    
    public String getLabel() {
        return this.label;
    }
    
    public static POS lookup(final String s) {
        for (int i = 0; i < POS.CATS.length; ++i) {
            if (s.equals(POS.CATS[i].key)) {
                return POS.CATS[i];
            }
        }
        throw new NoSuchElementException("unknown POS " + s);
    }
    
    protected POS(final String label, final String key) {
        this.label = label;
        this.key = key;
    }
    
    static {
        NOUN = new POS("noun", "n");
        VERB = new POS("verb", "v");
        ADJ = new POS("adjective", "a");
        ADV = new POS("adverb", "r");
        CATS = new POS[] { POS.NOUN, POS.VERB, POS.ADJ, POS.ADV };
    }
}
