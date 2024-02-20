package wordnet.wn;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Hashtable;

public class FileManager implements FileManagerInterface
{
    public static String VERSION;
    public static final boolean TRACE_LOOKUP = false;
    protected static final boolean IS_MW_VM;
    protected static final boolean IS_WINDOWS_OS;
    protected static final boolean IS_MAC_OS;
    protected static final String fileSeparator;
    protected String searchDirectory;
    protected Hashtable filenameCache;
    protected NextLineCache nextLineCache;
    
    protected static String getWNHome() {
        final String property = System.getProperty("WNHOME");
        if (property != null) {
            return property;
        }
        if (FileManager.IS_WINDOWS_OS) {
            return "C:\\wn16";
        }
        if (FileManager.IS_MAC_OS) {
            return ".";
        }
        return "/usr/local/wordnet1.6";
    }
    
    protected static String getWNSearchDir() {
        final String property = System.getProperty("WNSEARCHDIR");
        if (property != null) {
            return property;
        }
        if (FileManager.IS_MAC_OS && getWNHome().equals(".")) {
            return "Database";
        }
        return getWNHome() + FileManager.fileSeparator + (FileManager.IS_MAC_OS ? "Database" : "dict");
    }
    
    static String mapToWindowsFilename(String s) {
        if (s.startsWith("data.")) {
            s = s.substring("data.".length()) + ".dat";
        }
        else if (s.startsWith("index.")) {
            s = s.substring("index.".length()) + ".idx";
        }
        return s;
    }
    
    protected synchronized RandomAccessFile getFileStream(String mapToWindowsFilename) throws IOException {
        if (FileManager.IS_WINDOWS_OS) {
            mapToWindowsFilename = mapToWindowsFilename(mapToWindowsFilename);
        }
        RandomAccessFile randomAccessFile = (RandomAccessFile) this.filenameCache.get(mapToWindowsFilename);
        if (randomAccessFile == null) {
            randomAccessFile = new RandomAccessFile(this.searchDirectory + FileManager.fileSeparator + mapToWindowsFilename, "r");
            this.filenameCache.put(mapToWindowsFilename, randomAccessFile);
        }
        return randomAccessFile;
    }
    
    protected String readLine(final RandomAccessFile randomAccessFile) throws IOException {
        if (!FileManager.IS_MW_VM) {
            return randomAccessFile.readLine();
        }
        final StringBuffer sb = new StringBuffer();
        int read;
        while ((read = randomAccessFile.read()) != -1 && read != 10 && read != 13) {
            sb.append((char)read);
        }
        if (read == -1 && sb.length() == 0) {
            return null;
        }
        return sb.toString();
    }
    
    protected void skipLine(final RandomAccessFile randomAccessFile) throws IOException {
        int read;
        while ((read = randomAccessFile.read()) != -1 && read != 10 && read != 13) {}
    }
    
    public String readLineAt(final String p0, final long p1) throws IOException {
        String str;
        long l;
        RandomAccessFile randomAccessFile = getFileStream(p0);
        synchronized (randomAccessFile) {
            randomAccessFile.seek(p1);
            str = readLine(randomAccessFile);
            l = randomAccessFile.getFilePointer();
        }
        if (str == null)
            l = -1L;
        this.nextLineCache.setNextLineOffset(p0, p1, l);
        /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_5} */
        return str;
    }
    
    protected String readLineWord(final RandomAccessFile randomAccessFile) throws IOException {
        final StringBuffer sb = new StringBuffer();
        int read;
        while ((read = randomAccessFile.read()) != -1 && read != 10 && read != 13 && read != 32) {
            sb.append((char)read);
        }
        if (read == -1 && sb.length() == 0) {
            return null;
        }
        if (read == 32) {
            this.skipLine(randomAccessFile);
        }
        return sb.toString();
    }
    
    public long getNextLinePointer(final String p0, final long p1) throws IOException {
        RandomAccessFile randomAccessFile = getFileStream(p0);
        synchronized (randomAccessFile) {
            if (this.nextLineCache.matchingOffset(p0, p1))
                return this.nextLineCache.getNextOffset();
        }
        randomAccessFile.seek(p1);
        skipLine(randomAccessFile);
        /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_5} */
        return randomAccessFile.getFilePointer();
    }
    
    public long getMatchingLinePointer(String p0, long p1, String p2) throws IOException {
        RandomAccessFile randomAccessFile = getFileStream(p0);
        synchronized (randomAccessFile) {
            randomAccessFile.seek(p1);
        }
        while (true) {
            String str = readLineWord(randomAccessFile);
            long l = randomAccessFile.getFilePointer();
            if (str == null) {
                /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_6} */
                return -1L;
            }
            this.nextLineCache.setNextLineOffset(p0, p1, l);
            if (str.indexOf(p2) >= 0) {
                /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_6} */
                return p1;
            }
            p1 = l;
        }
    }
    
    public long getIndexedLinePointer(final String p0, final String p1) throws IOException {
        long l1, l2, l3;
        RandomAccessFile randomAccessFile = getFileStream(p0);
        synchronized (randomAccessFile) {
            l1 = 0L;
            l2 = randomAccessFile.length();
        }
        while (true) {
            long l4 = (l1 + l2) / 2L;
            randomAccessFile.seek(l4);
            skipLine(randomAccessFile);
            long l5 = randomAccessFile.getFilePointer();
            if (l5 == l1) {
                /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_4} */
                return -1L;
            }
            if (l5 == l2) {
                randomAccessFile.seek(l1 + 1L);
                skipLine(randomAccessFile);
                while (randomAccessFile.getFilePointer() < l2) {
                    long l = randomAccessFile.getFilePointer();
                    String str1 = readLineWord(randomAccessFile);
                    if (str1.equals(p1)) {
                        /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_4} */
                        return l;
                    }
                }
                /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_4} */
                return -1L;
            }
            l3 = randomAccessFile.getFilePointer();
            String str = readLineWord(randomAccessFile);
            if (str.equals(p1)) {
                /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_4} */
                return l3;
            }
            int i = compare(p1, str);
            if (i > 0) {
                l1 = l5;
                continue;
            }
            if (i < 0) {
                l2 = l5;
                continue;
            }
            break;
        }
        /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_4} */
        return l3;
    }
    
    protected int compare(final String s, final String s2) {
        final int min = Math.min(s.length(), s2.length());
        for (int i = 0; i < min; ++i) {
            final int n = s.charAt(i) - s2.charAt(i);
            if (n != 0) {
                return n;
            }
        }
        if (s.length() > min) {
            return 1;
        }
        if (min < s2.length()) {
            return -1;
        }
        return 0;
    }
    
    public FileManager() {
        this(getWNSearchDir());
    }
    
    public FileManager(final String searchDirectory) {
        this.filenameCache = new Hashtable();
        this.nextLineCache = new NextLineCache();
        this.searchDirectory = searchDirectory;
    }
    
    static {
        FileManager.VERSION = "1.0";
        IS_MW_VM = System.getProperties().getProperty("java.vendor").equalsIgnoreCase("Metrowerks Corp.");
        IS_WINDOWS_OS = System.getProperties().getProperty("os.name").startsWith("Windows");
        IS_MAC_OS = System.getProperties().getProperty("os.name").startsWith("Mac");
        fileSeparator = (FileManager.IS_MW_VM ? ":" : File.separator);
    }
    
    protected class NextLineCache
    {
        protected String filename;
        protected long previous;
        protected long next;
        
        void setNextLineOffset(final String filename, final long previous, final long next) {
            this.filename = filename;
            this.previous = previous;
            this.next = next;
        }
        
        boolean matchingOffset(final String s, final long n) {
            boolean b = false;
            if (this.filename != null && this.previous == n && this.filename.equals(s)) {
                b = true;
            }
            return b;
        }
        
        long getNextOffset() {
            return this.next;
        }
    }
}
