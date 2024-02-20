package TemplateCompiler;

import wordnet.wn.FileBackedDictionary;
import jess.JessException;
import wordnet.wn.IndexWord;
import jess.Value;
import wordnet.wn.PointerTarget;
import wordnet.wn.Synset;
import java.util.Vector;
import wordnet.wn.PointerType;
import wordnet.wn.POS;
import wordnet.wn.DictionaryDatabase;

public class trywn
{
    private static DictionaryDatabase dictionary;
    private static POS TYPE;
    private static PointerType POINTER;
    
    private static final boolean BFS_(final Vector vector, final Synset synset, final int n) {
        if (vector.isEmpty()) {
            return false;
        }
        final Synset synset2 = vector.remove(0);
        if (synset2.equals(synset)) {
            return true;
        }
        final PointerTarget[] targets = synset2.getTargets(trywn.POINTER);
        if (targets != null && n < 10) {
            for (int i = 0; i < targets.length; ++i) {
                vector.addElement(targets[i]);
            }
        }
        return BFS_(vector, synset, n + 1);
    }
    
    private static final boolean BFS(final Synset[] array, final Synset[] array2) {
        final Vector<Synset> vector = new Vector<Synset>();
        for (int i = 0; i < array2.length; ++i) {
            final Synset synset = array2[i];
            for (int j = 0; j < array.length; ++j) {
                vector.addElement(array[j]);
            }
            if (BFS_(vector, synset, 0)) {
                return true;
            }
        }
        return false;
    }
    
    public static Value IsLinkedJess(final String s, final String s2, final int n) throws JessException {
        switch (n) {
            case 0: {
                trywn.TYPE = POS.NOUN;
                break;
            }
            case 1: {
                trywn.TYPE = POS.VERB;
                break;
            }
            case 2: {
                trywn.TYPE = POS.ADJ;
                break;
            }
            case 3: {
                trywn.TYPE = POS.ADV;
                break;
            }
            default: {
                throw new RuntimeException("Unknown type");
            }
        }
        final IndexWord lookupIndexWord = trywn.dictionary.lookupIndexWord(trywn.TYPE, s);
        final IndexWord lookupIndexWord2 = trywn.dictionary.lookupIndexWord(trywn.TYPE, s2);
        if (lookupIndexWord2 == null || lookupIndexWord == null) {
            return new Value("FALSE", 1);
        }
        return new Value(new Boolean(BFS(lookupIndexWord.getSenses(), lookupIndexWord2.getSenses())).toString().toUpperCase(), 1);
    }
    
    public static boolean IsLinkedJava(final String s, final String s2, final int n) {
        switch (n) {
            case 0: {
                trywn.TYPE = POS.NOUN;
                trywn.POINTER = PointerType.HYPONYM;
                break;
            }
            case 1: {
                trywn.TYPE = POS.VERB;
                trywn.POINTER = PointerType.HYPONYM;
                break;
            }
            case 2: {
                trywn.TYPE = POS.ADJ;
                trywn.POINTER = PointerType.SIMILAR_TO;
                break;
            }
            case 3: {
                trywn.TYPE = POS.ADV;
                trywn.POINTER = PointerType.DERIVED;
                break;
            }
            default: {
                throw new RuntimeException("Unknown type");
            }
        }
        try {
            final IndexWord lookupIndexWord = trywn.dictionary.lookupIndexWord(trywn.TYPE, s);
            if (lookupIndexWord == null) {
                return false;
            }
            final Synset[] senses = lookupIndexWord.getSenses();
            final IndexWord lookupIndexWord2 = trywn.dictionary.lookupIndexWord(trywn.TYPE, s2);
            return lookupIndexWord2 != null && BFS(senses, lookupIndexWord2.getSenses());
        }
        catch (RuntimeException ex) {
            System.out.println("I dont know why this happens with " + s + " and " + s2 + " Error msg: " + ex.getMessage());
            return false;
        }
    }
    
    public static void main(final String[] array) {
        if (IsLinkedJava(array[0], array[1], Integer.parseInt(array[2]))) {
            System.out.println("TRUE");
        }
        else {
            System.out.println("FALSE");
        }
    }
    
    static {
        trywn.dictionary = new FileBackedDictionary("C:\\WN16\\DICT");
    }
}
