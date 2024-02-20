package TemplateCompiler;

import wordnet.wn.FileBackedDictionary;
import wordnet.wn.IndexWord;
import wordnet.wn.Synset;
import wordnet.wn.PointerTarget;
import java.util.HashSet;
import java.util.Vector;
import java.io.OutputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.util.Hashtable;
import wordnet.wn.PointerType;
import wordnet.wn.POS;
import wordnet.wn.DictionaryDatabase;

public class WordNet
{
    private static DictionaryDatabase dictionary;
    private static POS TYPE;
    private static PointerType POINTER;
    private static Hashtable WordToSynsets;
    
    public static void readHashSynsets(final String s) throws IOException {
        final ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(s));
        try {
            WordNet.WordToSynsets = (Hashtable)objectInputStream.readObject();
        }
        catch (Exception ex) {
            throw new IOException(ex.getMessage());
        }
        objectInputStream.close();
    }
    
    public static void dumpHashSynsets(final String s) throws IOException {
        final ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(s));
        objectOutputStream.writeObject(WordNet.WordToSynsets);
        objectOutputStream.flush();
    }
    
    private static final void BFS_(final Vector vector, final int n, final HashSet set) {
        final Vector<PointerTarget> vector2 = new Vector<PointerTarget>();
        while (!vector.isEmpty()) {
            final Synset synset = vector.remove(0);
            if (!set.contains(new Integer(synset.hashCode()))) {
                set.add(new Integer(synset.hashCode()));
                final PointerTarget[] targets = synset.getTargets(WordNet.POINTER);
                if (targets != null && n < 10) {
                    for (int i = 0; i < targets.length; ++i) {
                        vector2.addElement(targets[i]);
                    }
                }
                BFS_(vector2, n + 1, set);
            }
        }
    }
    
    private static final void BFS(final Synset[] array, final HashSet set) {
        final Vector<Synset> vector = new Vector<Synset>();
        for (int i = 0; i < array.length; ++i) {
            vector.addElement(array[i]);
        }
        BFS_(vector, 0, set);
    }
    
    public static void BuildSynsetHashtable(String string, final int n) {
        if (WordNet.WordToSynsets.containsKey(string + n)) {
            return;
        }
        switch (n) {
            case 0: {
                WordNet.TYPE = POS.NOUN;
                WordNet.POINTER = PointerType.HYPONYM;
                break;
            }
            case 1: {
                WordNet.TYPE = POS.VERB;
                WordNet.POINTER = PointerType.HYPONYM;
                break;
            }
            case 2: {
                WordNet.TYPE = POS.ADJ;
                WordNet.POINTER = PointerType.SIMILAR_TO;
                break;
            }
            case 3: {
                WordNet.TYPE = POS.ADV;
                WordNet.POINTER = PointerType.DERIVED;
                break;
            }
            default: {
                throw new RuntimeException("Unknown type");
            }
        }
        try {
            final HashSet set = new HashSet();
            final IndexWord lookupIndexWord = WordNet.dictionary.lookupIndexWord(WordNet.TYPE, string);
            if (lookupIndexWord == null) {
                throw new CompileException("No such word in WordNet " + string);
            }
            BFS(lookupIndexWord.getSenses(), set);
            string += n;
            WordNet.WordToSynsets.put(string, set);
        }
        catch (CompileException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
    
    public static boolean IsLinkedJava(String string, final String s, final int n) {
        switch (n) {
            case 0: {
                WordNet.TYPE = POS.NOUN;
                break;
            }
            case 1: {
                WordNet.TYPE = POS.VERB;
                break;
            }
            case 2: {
                WordNet.TYPE = POS.ADJ;
                break;
            }
            case 3: {
                WordNet.TYPE = POS.ADV;
                break;
            }
            default: {
                throw new RuntimeException("Unknown type");
            }
        }
        string += n;
        final HashSet set = WordNet.WordToSynsets.get(string);
        if (set == null) {
            throw new RuntimeException("Concept " + string + " not found in wordnet.bin. Did you properly copy wordnet.bin?");
        }
        final IndexWord lookupIndexWord = WordNet.dictionary.lookupIndexWord(WordNet.TYPE, s);
        if (lookupIndexWord == null) {
            return false;
        }
        final Synset[] senses = lookupIndexWord.getSenses();
        for (int i = 0; i < senses.length; ++i) {
            if (set.contains(new Integer(senses[i].hashCode()))) {
                return true;
            }
        }
        return false;
    }
    
    static {
        WordNet.dictionary = new FileBackedDictionary("C:\\WN16\\DICT");
        WordNet.WordToSynsets = new Hashtable();
    }
}
