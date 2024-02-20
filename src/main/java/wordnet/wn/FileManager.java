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
        RandomAccessFile randomAccessFile = this.filenameCache.get(mapToWindowsFilename);
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
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_1        
        //     2: invokevirtual   wordnet/wn/FileManager.getFileStream:(Ljava/lang/String;)Ljava/io/RandomAccessFile;
        //     5: astore          4
        //     7: goto            14
        //    10: aload           5
        //    12: monitorexit    
        //    13: athrow         
        //    14: aload           4
        //    16: dup            
        //    17: astore          5
        //    19: monitorenter   
        //    20: aload           4
        //    22: lload_2        
        //    23: invokevirtual   java/io/RandomAccessFile.seek:(J)V
        //    26: aload_0        
        //    27: aload           4
        //    29: invokevirtual   wordnet/wn/FileManager.readLine:(Ljava/io/RandomAccessFile;)Ljava/lang/String;
        //    32: astore          8
        //    34: aload           4
        //    36: invokevirtual   java/io/RandomAccessFile.getFilePointer:()J
        //    39: lstore          9
        //    41: aload           8
        //    43: ifnonnull       50
        //    46: iconst_m1      
        //    47: i2l            
        //    48: lstore          9
        //    50: aload_0        
        //    51: getfield        wordnet/wn/FileManager.nextLineCache:Lwordnet/wn/FileManager$NextLineCache;
        //    54: aload_1        
        //    55: lload_2        
        //    56: lload           9
        //    58: invokevirtual   wordnet/wn/FileManager$NextLineCache.setNextLineOffset:(Ljava/lang/String;JJ)V
        //    61: aload           8
        //    63: aload           5
        //    65: monitorexit    
        //    66: areturn        
        //    Exceptions:
        //  throws java.io.IOException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  10     13     10     14     Any
        //  20     66     10     14     Any
        // 
        // The error that occurred was:
        // 
        // java.util.ConcurrentModificationException
        //     at java.util.ArrayList$Itr.checkForComodification(Unknown Source)
        //     at java.util.ArrayList$Itr.next(Unknown Source)
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2863)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2445)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
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
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_1        
        //     2: invokevirtual   wordnet/wn/FileManager.getFileStream:(Ljava/lang/String;)Ljava/io/RandomAccessFile;
        //     5: astore          4
        //     7: goto            14
        //    10: aload           5
        //    12: monitorexit    
        //    13: athrow         
        //    14: aload           4
        //    16: dup            
        //    17: astore          5
        //    19: monitorenter   
        //    20: aload_0        
        //    21: getfield        wordnet/wn/FileManager.nextLineCache:Lwordnet/wn/FileManager$NextLineCache;
        //    24: aload_1        
        //    25: lload_2        
        //    26: invokevirtual   wordnet/wn/FileManager$NextLineCache.matchingOffset:(Ljava/lang/String;J)Z
        //    29: ifeq            43
        //    32: aload_0        
        //    33: getfield        wordnet/wn/FileManager.nextLineCache:Lwordnet/wn/FileManager$NextLineCache;
        //    36: invokevirtual   wordnet/wn/FileManager$NextLineCache.getNextOffset:()J
        //    39: aload           5
        //    41: monitorexit    
        //    42: lreturn        
        //    43: aload           4
        //    45: lload_2        
        //    46: invokevirtual   java/io/RandomAccessFile.seek:(J)V
        //    49: aload_0        
        //    50: aload           4
        //    52: invokevirtual   wordnet/wn/FileManager.skipLine:(Ljava/io/RandomAccessFile;)V
        //    55: aload           4
        //    57: invokevirtual   java/io/RandomAccessFile.getFilePointer:()J
        //    60: aload           5
        //    62: monitorexit    
        //    63: lreturn        
        //    Exceptions:
        //  throws java.io.IOException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  10     13     10     14     Any
        //  43     63     10     14     Any
        //  20     42     10     14     Any
        // 
        // The error that occurred was:
        // 
        // java.util.ConcurrentModificationException
        //     at java.util.ArrayList$Itr.checkForComodification(Unknown Source)
        //     at java.util.ArrayList$Itr.next(Unknown Source)
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2863)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2445)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public long getMatchingLinePointer(final String p0, final long p1, final String p2) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_1        
        //     2: invokevirtual   wordnet/wn/FileManager.getFileStream:(Ljava/lang/String;)Ljava/io/RandomAccessFile;
        //     5: astore          5
        //     7: goto            14
        //    10: aload           6
        //    12: monitorexit    
        //    13: athrow         
        //    14: aload           5
        //    16: dup            
        //    17: astore          6
        //    19: monitorenter   
        //    20: aload           5
        //    22: lload_2        
        //    23: invokevirtual   java/io/RandomAccessFile.seek:(J)V
        //    26: aload_0        
        //    27: aload           5
        //    29: invokevirtual   wordnet/wn/FileManager.readLineWord:(Ljava/io/RandomAccessFile;)Ljava/lang/String;
        //    32: astore          10
        //    34: aload           5
        //    36: invokevirtual   java/io/RandomAccessFile.getFilePointer:()J
        //    39: lstore          11
        //    41: aload           10
        //    43: ifnonnull       52
        //    46: iconst_m1      
        //    47: i2l            
        //    48: aload           6
        //    50: monitorexit    
        //    51: lreturn        
        //    52: aload_0        
        //    53: getfield        wordnet/wn/FileManager.nextLineCache:Lwordnet/wn/FileManager$NextLineCache;
        //    56: aload_1        
        //    57: lload_2        
        //    58: lload           11
        //    60: invokevirtual   wordnet/wn/FileManager$NextLineCache.setNextLineOffset:(Ljava/lang/String;JJ)V
        //    63: aload           10
        //    65: aload           4
        //    67: invokevirtual   java/lang/String.indexOf:(Ljava/lang/String;)I
        //    70: iflt            78
        //    73: lload_2        
        //    74: aload           6
        //    76: monitorexit    
        //    77: lreturn        
        //    78: lload           11
        //    80: lstore_2       
        //    81: goto            26
        //    Exceptions:
        //  throws java.io.IOException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  10     13     10     14     Any
        //  78     84     10     14     Any
        //  52     77     10     14     Any
        //  20     51     10     14     Any
        // 
        // The error that occurred was:
        // 
        // java.util.ConcurrentModificationException
        //     at java.util.ArrayList$Itr.checkForComodification(Unknown Source)
        //     at java.util.ArrayList$Itr.next(Unknown Source)
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2863)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2445)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public long getIndexedLinePointer(final String p0, final String p1) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_1        
        //     2: invokevirtual   wordnet/wn/FileManager.getFileStream:(Ljava/lang/String;)Ljava/io/RandomAccessFile;
        //     5: astore_3       
        //     6: goto            13
        //     9: aload           4
        //    11: monitorexit    
        //    12: athrow         
        //    13: aload_3        
        //    14: dup            
        //    15: astore          4
        //    17: monitorenter   
        //    18: lconst_0       
        //    19: lstore          8
        //    21: aload_3        
        //    22: invokevirtual   java/io/RandomAccessFile.length:()J
        //    25: lstore          10
        //    27: lload           8
        //    29: lload           10
        //    31: ladd           
        //    32: iconst_2       
        //    33: i2l            
        //    34: ldiv           
        //    35: lstore          12
        //    37: aload_3        
        //    38: lload           12
        //    40: invokevirtual   java/io/RandomAccessFile.seek:(J)V
        //    43: aload_0        
        //    44: aload_3        
        //    45: invokevirtual   wordnet/wn/FileManager.skipLine:(Ljava/io/RandomAccessFile;)V
        //    48: aload_3        
        //    49: invokevirtual   java/io/RandomAccessFile.getFilePointer:()J
        //    52: lstore          14
        //    54: lload           14
        //    56: lload           8
        //    58: lcmp           
        //    59: ifne            68
        //    62: iconst_m1      
        //    63: i2l            
        //    64: aload           4
        //    66: monitorexit    
        //    67: lreturn        
        //    68: lload           14
        //    70: lload           10
        //    72: lcmp           
        //    73: ifne            136
        //    76: aload_3        
        //    77: lload           8
        //    79: lconst_1       
        //    80: ladd           
        //    81: invokevirtual   java/io/RandomAccessFile.seek:(J)V
        //    84: aload_0        
        //    85: aload_3        
        //    86: invokevirtual   wordnet/wn/FileManager.skipLine:(Ljava/io/RandomAccessFile;)V
        //    89: goto            120
        //    92: aload_3        
        //    93: invokevirtual   java/io/RandomAccessFile.getFilePointer:()J
        //    96: lstore          16
        //    98: aload_0        
        //    99: aload_3        
        //   100: invokevirtual   wordnet/wn/FileManager.readLineWord:(Ljava/io/RandomAccessFile;)Ljava/lang/String;
        //   103: astore          18
        //   105: aload           18
        //   107: aload_2        
        //   108: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   111: ifeq            120
        //   114: lload           16
        //   116: aload           4
        //   118: monitorexit    
        //   119: lreturn        
        //   120: aload_3        
        //   121: invokevirtual   java/io/RandomAccessFile.getFilePointer:()J
        //   124: lload           10
        //   126: lcmp           
        //   127: iflt            92
        //   130: iconst_m1      
        //   131: i2l            
        //   132: aload           4
        //   134: monitorexit    
        //   135: lreturn        
        //   136: aload_3        
        //   137: invokevirtual   java/io/RandomAccessFile.getFilePointer:()J
        //   140: lstore          16
        //   142: aload_0        
        //   143: aload_3        
        //   144: invokevirtual   wordnet/wn/FileManager.readLineWord:(Ljava/io/RandomAccessFile;)Ljava/lang/String;
        //   147: astore          18
        //   149: aload           18
        //   151: aload_2        
        //   152: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   155: ifeq            164
        //   158: lload           16
        //   160: aload           4
        //   162: monitorexit    
        //   163: lreturn        
        //   164: aload_0        
        //   165: aload_2        
        //   166: aload           18
        //   168: invokevirtual   wordnet/wn/FileManager.compare:(Ljava/lang/String;Ljava/lang/String;)I
        //   171: istore          19
        //   173: iload           19
        //   175: ifle            185
        //   178: lload           14
        //   180: lstore          8
        //   182: goto            203
        //   185: iload           19
        //   187: ifge            197
        //   190: lload           14
        //   192: lstore          10
        //   194: goto            203
        //   197: lload           16
        //   199: aload           4
        //   201: monitorexit    
        //   202: lreturn        
        //   203: goto            27
        //    Exceptions:
        //  throws java.io.IOException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  9      12     9      13     Any
        //  203    206    9      13     Any
        //  164    202    9      13     Any
        //  136    163    9      13     Any
        //  120    135    9      13     Any
        //  68     119    9      13     Any
        //  18     67     9      13     Any
        // 
        // The error that occurred was:
        // 
        // java.util.ConcurrentModificationException
        //     at java.util.ArrayList$Itr.checkForComodification(Unknown Source)
        //     at java.util.ArrayList$Itr.next(Unknown Source)
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2863)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2445)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
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
    
    private final /* synthetic */ void this() {
        this.filenameCache = new Hashtable();
        this.nextLineCache = new NextLineCache();
    }
    
    public FileManager() {
        this(getWNSearchDir());
    }
    
    public FileManager(final String searchDirectory) {
        this.this();
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
