package wordnet.wn;

import wordnet.util.LRUCache;
import wordnet.util.LookaheadEnumeration;
import java.util.NoSuchElementException;
import java.util.Enumeration;
import java.io.IOException;
import wordnet.util.ArrayUtilities;
import wordnet.util.Cache;

public class FileBackedDictionary implements DictionaryDatabase
{
    protected static final POS[] POS_KEYS;
    protected static final String[] POS_FILENAME_ROOTS;
    protected final FileManagerInterface db;
    protected final int DEFAULT_CACHE_CAPACITY = 1000;
    protected Cache entityCache;
    
    public void setEntityCache(final Cache entityCache) {
        if (this.entityCache != entityCache) {
            this.entityCache.clear();
            this.entityCache = entityCache;
        }
    }
    
    protected static String getDatabaseSuffixName(final POS pos) {
        return FileBackedDictionary.POS_FILENAME_ROOTS[ArrayUtilities.indexOf(FileBackedDictionary.POS_KEYS, pos)];
    }
    
    protected static String getDataFilename(final POS pos) {
        return "data." + getDatabaseSuffixName(pos);
    }
    
    protected static String getIndexFilename(final POS pos) {
        return "index." + getDatabaseSuffixName(pos);
    }
    
    protected static String getExceptionsFilename(final POS pos) {
        return getDatabaseSuffixName(pos) + ".exc";
    }
    
    protected IndexWord getIndexWordAt(final POS pos, final long n) {
        final DatabaseKey databaseKey = new DatabaseKey(pos, new Long(n));
        IndexWord indexWord = (IndexWord)this.entityCache.get(databaseKey);
        if (indexWord == null) {
            final String indexFilename = getIndexFilename(pos);
            String line;
            try {
                line = this.db.readLineAt(indexFilename, n);
            }
            catch (IOException ex) {
                throw new RuntimeException(ex.toString());
            }
            indexWord = IndexWord.parseIndexWord(this, line);
            this.entityCache.put(databaseKey, indexWord);
        }
        return indexWord;
    }
    
    protected Synset getSynsetAt(final POS pos, final long n, String line) {
        final DatabaseKey databaseKey = new DatabaseKey(pos, new Long(n));
        Synset synset = (Synset)this.entityCache.get(databaseKey);
        if (synset == null) {
            if (line == null) {
                final String dataFilename = getDataFilename(pos);
                try {
                    line = this.db.readLineAt(dataFilename, n);
                }
                catch (IOException ex) {
                    throw new RuntimeException(ex.toString());
                }
            }
            synset = Synset.parseSynset(this, line);
            this.entityCache.put(databaseKey, synset);
        }
        return synset;
    }
    
    public Synset getSynsetAt(final POS pos, final long n) {
        return this.getSynsetAt(pos, n, null);
    }
    
    public IndexWord lookupIndexWord(final POS pos, final String s) {
        final DatabaseKey databaseKey = new DatabaseKey(pos, s);
        IndexWord indexWord = (IndexWord)this.entityCache.get(databaseKey);
        if (indexWord == null) {
            final String indexFilename = getIndexFilename(pos);
            long indexedLinePointer;
            try {
                indexedLinePointer = this.db.getIndexedLinePointer(indexFilename, s.toLowerCase().replace(' ', '_'));
            }
            catch (IOException ex) {
                throw new RuntimeException(ex.toString());
            }
            if (indexedLinePointer >= 0L) {
                indexWord = this.getIndexWordAt(pos, indexedLinePointer);
            }
            if (indexWord != null) {
                this.entityCache.put(databaseKey, indexWord);
            }
        }
        return indexWord;
    }
    
    public String lookupBaseForm(final POS pos, final String s) {
        final String exceptionsFilename = getExceptionsFilename(pos);
        try {
            final long indexedLinePointer = this.db.getIndexedLinePointer(exceptionsFilename, s.toLowerCase());
            if (indexedLinePointer >= 0L) {
                final String line = this.db.readLineAt(exceptionsFilename, indexedLinePointer);
                return line.substring(line.indexOf(32) + 1);
            }
        }
        catch (IOException ex) {
            throw new RuntimeException(ex.toString());
        }
        return null;
    }
    
    public Enumeration searchIndexWords(final POS pos, final String s) {
        return new LookaheadEnumeration(new Enumeration() {
            protected String filename;
            protected long nextOffset;
            
            public final boolean hasMoreElements() {
                return true;
            }
            
            public final Object nextElement() {
                try {
                    final long matchingLinePointer = FileBackedDictionary.this.db.getMatchingLinePointer(this.filename, this.nextOffset, s);
                    if (matchingLinePointer >= 0L) {
                        final IndexWord indexWord = FileBackedDictionary.this.getIndexWordAt(pos, matchingLinePointer);
                        this.nextOffset = FileBackedDictionary.this.db.getNextLinePointer(this.filename, matchingLinePointer);
                        return indexWord;
                    }
                    throw new NoSuchElementException();
                }
                catch (IOException ex) {
                    throw new RuntimeException(ex.toString());
                }
            }

            {
                this.filename = FileBackedDictionary.getIndexFilename(pos);
                this.nextOffset = 0L;
            }
        });
    }
    
    public Enumeration synsets(final POS pos) {
        return new LookaheadEnumeration(new Enumeration() {
            protected String filename;
            protected long nextOffset;
            
            public final boolean hasMoreElements() {
                return true;
            }
            
            public final Object nextElement() {
                try {
                    while (this.nextOffset >= 0L) {
                        final String line = FileBackedDictionary.this.db.readLineAt(this.filename, this.nextOffset);
                        this.nextOffset = FileBackedDictionary.this.db.getNextLinePointer(this.filename, this.nextOffset);
                        if (!line.startsWith("  ")) {
                            return FileBackedDictionary.this.getSynsetAt(pos, this.nextOffset, line);
                        }
                    }
                    throw new NoSuchElementException();
                }
                catch (IOException ex) {
                    throw new RuntimeException(ex.toString());
                }
            }
            
            {
                this.filename = FileBackedDictionary.getDataFilename(pos);
                this.nextOffset = 0L;
            }
        });
    }
    
    public FileBackedDictionary(final FileManagerInterface db) {
        this.entityCache = new LRUCache(1000);
        this.db = db;
    }
    
    public FileBackedDictionary() {
        this(new FileManager());
    }
    
    public FileBackedDictionary(final String s) {
        this(new FileManager(s));
    }
    
    static {
        POS_KEYS = new POS[] { POS.NOUN, POS.VERB, POS.ADJ, POS.ADV };
        POS_FILENAME_ROOTS = new String[] { "noun", "verb", "adj", "adv" };
    }
    
    protected class DatabaseKey
    {
        POS pos;
        Object key;
        
        public boolean equals(final Object o) {
            boolean b = false;
            if (o instanceof DatabaseKey && ((DatabaseKey)o).pos.equals(this.pos) && ((DatabaseKey)o).key.equals(this.key)) {
                b = true;
            }
            return b;
        }
        
        public int hashCode() {
            return this.pos.hashCode() ^ this.key.hashCode();
        }
        
        DatabaseKey(final POS pos, final Object key) {
            this.pos = pos;
            this.key = key;
        }
    }
}
