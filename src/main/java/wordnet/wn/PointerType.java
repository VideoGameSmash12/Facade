package wordnet.wn;

import wordnet.util.ArrayUtilities;
import java.util.NoSuchElementException;

public class PointerType
{
    protected static final int N = 1;
    protected static final int V = 2;
    protected static final int ADJ = 4;
    protected static final int ADV = 8;
    protected static final int LEXICAL = 16;
    protected static final POS[] CATS;
    protected static final int[] POS_MASK;
    public static final PointerType ANTONYM;
    public static final PointerType HYPERNYM;
    public static final PointerType HYPONYM;
    public static final PointerType ATTRIBUTE;
    public static final PointerType SEE_ALSO;
    public static final PointerType ENTAILMENT;
    public static final PointerType CAUSE;
    public static final PointerType VERB_GROUP;
    public static final PointerType MEMBER_MERONYM;
    public static final PointerType SUBSTANCE_MERONYM;
    public static final PointerType PART_MERONYM;
    public static final PointerType MEMBER_HOLONYM;
    public static final PointerType SUBSTANCE_HOLONYM;
    public static final PointerType PART_HOLONYM;
    public static final PointerType SIMILAR_TO;
    public static final PointerType PARTICIPLE_OF;
    public static final PointerType PERTAINYM;
    public static final PointerType DERIVED;
    public static final PointerType[] TYPES;
    protected String label;
    protected String key;
    protected int flags;
    protected PointerType symmetricType;
    
    protected static void setSymmetric(final PointerType symmetricType, final PointerType symmetricType2) {
        symmetricType.symmetricType = symmetricType2;
        symmetricType2.symmetricType = symmetricType;
    }
    
    static PointerType parseKey(final String s) {
        for (int i = 0; i < PointerType.TYPES.length; ++i) {
            final PointerType pointerType = PointerType.TYPES[i];
            if (pointerType.key.equals(s)) {
                return pointerType;
            }
        }
        throw new NoSuchElementException("unknown link type " + s);
    }
    
    public String getLabel() {
        return this.label;
    }
    
    public boolean appliesTo(final POS pos) {
        boolean b = false;
        if ((this.flags & PointerType.POS_MASK[ArrayUtilities.indexOf(PointerType.CATS, pos)]) != 0x0) {
            b = true;
        }
        return b;
    }
    
    public boolean symmetricTo(final PointerType pointerType) {
        boolean b = false;
        if (this.symmetricType != null && this.symmetricType.equals(pointerType)) {
            b = true;
        }
        return b;
    }
    
    protected PointerType(final String label, final String key, final int flags) {
        this.label = label;
        this.key = key;
        this.flags = flags;
    }
    
    static {
        CATS = new POS[] { POS.NOUN, POS.VERB, POS.ADJ, POS.ADV };
        POS_MASK = new int[] { 1, 2, 4, 8 };
        ANTONYM = new PointerType("antonym", "!", 31);
        HYPERNYM = new PointerType("hypernym", "@", 3);
        HYPONYM = new PointerType("hyponym", "~", 3);
        ATTRIBUTE = new PointerType("attribute", "=", 5);
        SEE_ALSO = new PointerType("also see", "^", 21);
        ENTAILMENT = new PointerType("entailment", "*", 2);
        CAUSE = new PointerType("cause", ">", 2);
        VERB_GROUP = new PointerType("verb group", "$", 2);
        MEMBER_MERONYM = new PointerType("member meronym", "#m", 1);
        SUBSTANCE_MERONYM = new PointerType("substance meronym", "#s", 1);
        PART_MERONYM = new PointerType("part meronym", "#p", 1);
        MEMBER_HOLONYM = new PointerType("member holonym", "%m", 1);
        SUBSTANCE_HOLONYM = new PointerType("substance holonym", "%s", 1);
        PART_HOLONYM = new PointerType("part holonym", "%p", 1);
        SIMILAR_TO = new PointerType("similar", "&", 4);
        PARTICIPLE_OF = new PointerType("participle of", "<", 20);
        PERTAINYM = new PointerType("pertainym", "\\", 20);
        DERIVED = new PointerType("derived from", "\\", 8);
        TYPES = new PointerType[] { PointerType.ANTONYM, PointerType.HYPERNYM, PointerType.HYPONYM, PointerType.ATTRIBUTE, PointerType.SEE_ALSO, PointerType.ENTAILMENT, PointerType.CAUSE, PointerType.VERB_GROUP, PointerType.MEMBER_MERONYM, PointerType.SUBSTANCE_MERONYM, PointerType.PART_MERONYM, PointerType.MEMBER_HOLONYM, PointerType.SUBSTANCE_HOLONYM, PointerType.PART_HOLONYM, PointerType.SIMILAR_TO, PointerType.PARTICIPLE_OF, PointerType.PERTAINYM, PointerType.DERIVED };
        setSymmetric(PointerType.ANTONYM, PointerType.ANTONYM);
        setSymmetric(PointerType.HYPERNYM, PointerType.HYPONYM);
        setSymmetric(PointerType.MEMBER_MERONYM, PointerType.MEMBER_HOLONYM);
        setSymmetric(PointerType.SUBSTANCE_MERONYM, PointerType.SUBSTANCE_HOLONYM);
        setSymmetric(PointerType.PART_MERONYM, PointerType.PART_HOLONYM);
        setSymmetric(PointerType.SIMILAR_TO, PointerType.SIMILAR_TO);
    }
}
