package TemplateCompiler;

import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.IOException;
import java.io.Reader;

public class JavaCharStream
{
    public static final boolean staticFlag = true;
    public static int bufpos;
    static int bufsize;
    static int available;
    static int tokenBegin;
    protected static int[] bufline;
    protected static int[] bufcolumn;
    protected static int column;
    protected static int line;
    protected static boolean prevCharIsCR;
    protected static boolean prevCharIsLF;
    protected static Reader inputStream;
    protected static char[] nextCharBuf;
    protected static char[] buffer;
    protected static int maxNextCharInd;
    protected static int nextCharInd;
    protected static int inBuf;
    
    static final int hexval(final char c) throws IOException {
        switch (c) {
            case '0': {
                return 0;
            }
            case '1': {
                return 1;
            }
            case '2': {
                return 2;
            }
            case '3': {
                return 3;
            }
            case '4': {
                return 4;
            }
            case '5': {
                return 5;
            }
            case '6': {
                return 6;
            }
            case '7': {
                return 7;
            }
            case '8': {
                return 8;
            }
            case '9': {
                return 9;
            }
            case 'A':
            case 'a': {
                return 10;
            }
            case 'B':
            case 'b': {
                return 11;
            }
            case 'C':
            case 'c': {
                return 12;
            }
            case 'D':
            case 'd': {
                return 13;
            }
            case 'E':
            case 'e': {
                return 14;
            }
            case 'F':
            case 'f': {
                return 15;
            }
            default: {
                throw new IOException();
            }
        }
    }
    
    protected static void ExpandBuff(final boolean b) {
        final char[] array = new char[JavaCharStream.bufsize + 2048];
        final int[] array2 = new int[JavaCharStream.bufsize + 2048];
        final int[] array3 = new int[JavaCharStream.bufsize + 2048];
        try {
            if (b) {
                System.arraycopy(JavaCharStream.buffer, JavaCharStream.tokenBegin, array, 0, JavaCharStream.bufsize - JavaCharStream.tokenBegin);
                System.arraycopy(JavaCharStream.buffer, 0, array, JavaCharStream.bufsize - JavaCharStream.tokenBegin, JavaCharStream.bufpos);
                JavaCharStream.buffer = array;
                System.arraycopy(JavaCharStream.bufline, JavaCharStream.tokenBegin, array2, 0, JavaCharStream.bufsize - JavaCharStream.tokenBegin);
                System.arraycopy(JavaCharStream.bufline, 0, array2, JavaCharStream.bufsize - JavaCharStream.tokenBegin, JavaCharStream.bufpos);
                JavaCharStream.bufline = array2;
                System.arraycopy(JavaCharStream.bufcolumn, JavaCharStream.tokenBegin, array3, 0, JavaCharStream.bufsize - JavaCharStream.tokenBegin);
                System.arraycopy(JavaCharStream.bufcolumn, 0, array3, JavaCharStream.bufsize - JavaCharStream.tokenBegin, JavaCharStream.bufpos);
                JavaCharStream.bufcolumn = array3;
                JavaCharStream.bufpos += JavaCharStream.bufsize - JavaCharStream.tokenBegin;
            }
            else {
                System.arraycopy(JavaCharStream.buffer, JavaCharStream.tokenBegin, array, 0, JavaCharStream.bufsize - JavaCharStream.tokenBegin);
                JavaCharStream.buffer = array;
                System.arraycopy(JavaCharStream.bufline, JavaCharStream.tokenBegin, array2, 0, JavaCharStream.bufsize - JavaCharStream.tokenBegin);
                JavaCharStream.bufline = array2;
                System.arraycopy(JavaCharStream.bufcolumn, JavaCharStream.tokenBegin, array3, 0, JavaCharStream.bufsize - JavaCharStream.tokenBegin);
                JavaCharStream.bufcolumn = array3;
                JavaCharStream.bufpos -= JavaCharStream.tokenBegin;
            }
        }
        catch (Throwable t) {
            throw new Error(t.getMessage());
        }
        JavaCharStream.available = (JavaCharStream.bufsize += 2048);
        JavaCharStream.tokenBegin = 0;
    }
    
    protected static void FillBuff() throws IOException {
        if (JavaCharStream.maxNextCharInd == 4096) {
            JavaCharStream.maxNextCharInd = (JavaCharStream.nextCharInd = 0);
        }
        try {
            final int read;
            if ((read = JavaCharStream.inputStream.read(JavaCharStream.nextCharBuf, JavaCharStream.maxNextCharInd, 4096 - JavaCharStream.maxNextCharInd)) == -1) {
                JavaCharStream.inputStream.close();
                throw new IOException();
            }
            JavaCharStream.maxNextCharInd += read;
        }
        catch (IOException ex) {
            if (JavaCharStream.bufpos != 0) {
                --JavaCharStream.bufpos;
                backup(0);
            }
            else {
                JavaCharStream.bufline[JavaCharStream.bufpos] = JavaCharStream.line;
                JavaCharStream.bufcolumn[JavaCharStream.bufpos] = JavaCharStream.column;
            }
            throw ex;
        }
    }
    
    protected static char ReadByte() throws IOException {
        if (++JavaCharStream.nextCharInd >= JavaCharStream.maxNextCharInd) {
            FillBuff();
        }
        return JavaCharStream.nextCharBuf[JavaCharStream.nextCharInd];
    }
    
    public static char BeginToken() throws IOException {
        if (JavaCharStream.inBuf > 0) {
            --JavaCharStream.inBuf;
            if (++JavaCharStream.bufpos == JavaCharStream.bufsize) {
                JavaCharStream.bufpos = 0;
            }
            JavaCharStream.tokenBegin = JavaCharStream.bufpos;
            return JavaCharStream.buffer[JavaCharStream.bufpos];
        }
        JavaCharStream.tokenBegin = 0;
        JavaCharStream.bufpos = -1;
        return readChar();
    }
    
    protected static void AdjustBuffSize() {
        if (JavaCharStream.available == JavaCharStream.bufsize) {
            if (JavaCharStream.tokenBegin > 2048) {
                JavaCharStream.bufpos = 0;
                JavaCharStream.available = JavaCharStream.tokenBegin;
            }
            else {
                ExpandBuff(false);
            }
        }
        else if (JavaCharStream.available > JavaCharStream.tokenBegin) {
            JavaCharStream.available = JavaCharStream.bufsize;
        }
        else if (JavaCharStream.tokenBegin - JavaCharStream.available < 2048) {
            ExpandBuff(true);
        }
        else {
            JavaCharStream.available = JavaCharStream.tokenBegin;
        }
    }
    
    protected static void UpdateLineColumn(final char c) {
        ++JavaCharStream.column;
        if (JavaCharStream.prevCharIsLF) {
            JavaCharStream.prevCharIsLF = false;
            JavaCharStream.line += (JavaCharStream.column = 1);
        }
        else if (JavaCharStream.prevCharIsCR) {
            JavaCharStream.prevCharIsCR = false;
            if (c == '\n') {
                JavaCharStream.prevCharIsLF = true;
            }
            else {
                JavaCharStream.line += (JavaCharStream.column = 1);
            }
        }
        switch (c) {
            case '\r': {
                JavaCharStream.prevCharIsCR = true;
                break;
            }
            case '\n': {
                JavaCharStream.prevCharIsLF = true;
                break;
            }
            case '\t': {
                --JavaCharStream.column;
                JavaCharStream.column += 8 - (JavaCharStream.column & 0x7);
                break;
            }
        }
        JavaCharStream.bufline[JavaCharStream.bufpos] = JavaCharStream.line;
        JavaCharStream.bufcolumn[JavaCharStream.bufpos] = JavaCharStream.column;
    }
    
    public static char readChar() throws IOException {
        if (JavaCharStream.inBuf > 0) {
            --JavaCharStream.inBuf;
            if (++JavaCharStream.bufpos == JavaCharStream.bufsize) {
                JavaCharStream.bufpos = 0;
            }
            return JavaCharStream.buffer[JavaCharStream.bufpos];
        }
        if (++JavaCharStream.bufpos == JavaCharStream.available) {
            AdjustBuffSize();
        }
        final char readByte;
        if ((JavaCharStream.buffer[JavaCharStream.bufpos] = (readByte = ReadByte())) != '\\') {
            UpdateLineColumn(readByte);
            return readByte;
        }
        UpdateLineColumn(readByte);
        int n = 1;
        while (true) {
            if (++JavaCharStream.bufpos == JavaCharStream.available) {
                AdjustBuffSize();
            }
            char readByte2;
            try {
                if ((JavaCharStream.buffer[JavaCharStream.bufpos] = (readByte2 = ReadByte())) != '\\') {
                    UpdateLineColumn(readByte2);
                    if (readByte2 == 'u' && (n & 0x1) == 0x1) {
                        if (--JavaCharStream.bufpos < 0) {
                            JavaCharStream.bufpos = JavaCharStream.bufsize - 1;
                        }
                        break;
                    }
                    backup(n);
                    return '\\';
                }
            }
            catch (IOException ex) {
                if (n > 1) {
                    backup(n);
                }
                return '\\';
            }
            UpdateLineColumn(readByte2);
            ++n;
        }
        char c;
        try {
            char readByte3;
            while ((readByte3 = ReadByte()) == 'u') {
                ++JavaCharStream.column;
            }
            c = (JavaCharStream.buffer[JavaCharStream.bufpos] = (char)(hexval(readByte3) << 12 | hexval(ReadByte()) << 8 | hexval(ReadByte()) << 4 | hexval(ReadByte())));
            JavaCharStream.column += 4;
        }
        catch (IOException ex2) {
            throw new Error("Invalid escape character at line " + JavaCharStream.line + " column " + JavaCharStream.column + '.');
        }
        if (n == 1) {
            return c;
        }
        backup(n - 1);
        return '\\';
    }
    
    public static int getColumn() {
        return JavaCharStream.bufcolumn[JavaCharStream.bufpos];
    }
    
    public static int getLine() {
        return JavaCharStream.bufline[JavaCharStream.bufpos];
    }
    
    public static int getEndColumn() {
        return JavaCharStream.bufcolumn[JavaCharStream.bufpos];
    }
    
    public static int getEndLine() {
        return JavaCharStream.bufline[JavaCharStream.bufpos];
    }
    
    public static int getBeginColumn() {
        return JavaCharStream.bufcolumn[JavaCharStream.tokenBegin];
    }
    
    public static int getBeginLine() {
        return JavaCharStream.bufline[JavaCharStream.tokenBegin];
    }
    
    public static void backup(final int n) {
        JavaCharStream.inBuf += n;
        if ((JavaCharStream.bufpos -= n) < 0) {
            JavaCharStream.bufpos += JavaCharStream.bufsize;
        }
    }
    
    public void ReInit(final Reader inputStream, final int line, final int n, final int n2) {
        JavaCharStream.inputStream = inputStream;
        JavaCharStream.line = line;
        JavaCharStream.column = n - 1;
        if (JavaCharStream.buffer == null || n2 != JavaCharStream.buffer.length) {
            JavaCharStream.bufsize = n2;
            JavaCharStream.available = n2;
            JavaCharStream.buffer = new char[n2];
            JavaCharStream.bufline = new int[n2];
            JavaCharStream.bufcolumn = new int[n2];
            JavaCharStream.nextCharBuf = new char[4096];
        }
        JavaCharStream.prevCharIsLF = (JavaCharStream.prevCharIsCR = false);
        JavaCharStream.tokenBegin = (JavaCharStream.inBuf = (JavaCharStream.maxNextCharInd = 0));
        JavaCharStream.nextCharInd = (JavaCharStream.bufpos = -1);
    }
    
    public void ReInit(final Reader reader, final int n, final int n2) {
        this.ReInit(reader, n, n2, 4096);
    }
    
    public void ReInit(final Reader reader) {
        this.ReInit(reader, 1, 1, 4096);
    }
    
    public void ReInit(final InputStream inputStream, final int n, final int n2, final int n3) {
        this.ReInit(new InputStreamReader(inputStream), n, n2, 4096);
    }
    
    public void ReInit(final InputStream inputStream, final int n, final int n2) {
        this.ReInit(inputStream, n, n2, 4096);
    }
    
    public void ReInit(final InputStream inputStream) {
        this.ReInit(inputStream, 1, 1, 4096);
    }
    
    public static String GetImage() {
        if (JavaCharStream.bufpos >= JavaCharStream.tokenBegin) {
            return new String(JavaCharStream.buffer, JavaCharStream.tokenBegin, JavaCharStream.bufpos - JavaCharStream.tokenBegin + 1);
        }
        return new String(JavaCharStream.buffer, JavaCharStream.tokenBegin, JavaCharStream.bufsize - JavaCharStream.tokenBegin) + new String(JavaCharStream.buffer, 0, JavaCharStream.bufpos + 1);
    }
    
    public static char[] GetSuffix(final int n) {
        final char[] array = new char[n];
        if (JavaCharStream.bufpos + 1 >= n) {
            System.arraycopy(JavaCharStream.buffer, JavaCharStream.bufpos - n + 1, array, 0, n);
        }
        else {
            System.arraycopy(JavaCharStream.buffer, JavaCharStream.bufsize - (n - JavaCharStream.bufpos - 1), array, 0, n - JavaCharStream.bufpos - 1);
            System.arraycopy(JavaCharStream.buffer, 0, array, n - JavaCharStream.bufpos - 1, JavaCharStream.bufpos + 1);
        }
        return array;
    }
    
    public static void Done() {
        JavaCharStream.nextCharBuf = null;
        JavaCharStream.buffer = null;
        JavaCharStream.bufline = null;
        JavaCharStream.bufcolumn = null;
    }
    
    public static void adjustBeginLineColumn(int n, final int n2) {
        int tokenBegin = JavaCharStream.tokenBegin;
        int n3;
        if (JavaCharStream.bufpos >= JavaCharStream.tokenBegin) {
            n3 = JavaCharStream.bufpos - JavaCharStream.tokenBegin + JavaCharStream.inBuf + 1;
        }
        else {
            n3 = JavaCharStream.bufsize - JavaCharStream.tokenBegin + JavaCharStream.bufpos + 1 + JavaCharStream.inBuf;
        }
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7;
        while (n4 < n3 && JavaCharStream.bufline[n5 = tokenBegin % JavaCharStream.bufsize] == JavaCharStream.bufline[n7 = ++tokenBegin % JavaCharStream.bufsize]) {
            JavaCharStream.bufline[n5] = n;
            final int n8 = n6 + JavaCharStream.bufcolumn[n7] - JavaCharStream.bufcolumn[n5];
            JavaCharStream.bufcolumn[n5] = n2 + n6;
            n6 = n8;
            ++n4;
        }
        if (n4 < n3) {
            JavaCharStream.bufline[n5] = n++;
            JavaCharStream.bufcolumn[n5] = n2 + n6;
            while (n4++ < n3) {
                if (JavaCharStream.bufline[n5 = tokenBegin % JavaCharStream.bufsize] != JavaCharStream.bufline[++tokenBegin % JavaCharStream.bufsize]) {
                    JavaCharStream.bufline[n5] = n++;
                }
                else {
                    JavaCharStream.bufline[n5] = n;
                }
            }
        }
        JavaCharStream.line = JavaCharStream.bufline[n5];
        JavaCharStream.column = JavaCharStream.bufcolumn[n5];
    }
    
    public JavaCharStream(final Reader inputStream, final int line, final int n, final int n2) {
        if (JavaCharStream.inputStream != null) {
            throw new Error("\n   ERROR: Second call to the constructor of a static JavaCharStream.  You must\n       either use ReInit() or set the JavaCC option STATIC to false\n       during the generation of this class.");
        }
        JavaCharStream.inputStream = inputStream;
        JavaCharStream.line = line;
        JavaCharStream.column = n - 1;
        JavaCharStream.bufsize = n2;
        JavaCharStream.available = n2;
        JavaCharStream.buffer = new char[n2];
        JavaCharStream.bufline = new int[n2];
        JavaCharStream.bufcolumn = new int[n2];
        JavaCharStream.nextCharBuf = new char[4096];
    }
    
    public JavaCharStream(final Reader reader, final int n, final int n2) {
        this(reader, n, n2, 4096);
    }
    
    public JavaCharStream(final Reader reader) {
        this(reader, 1, 1, 4096);
    }
    
    public JavaCharStream(final InputStream inputStream, final int n, final int n2, final int n3) {
        this(new InputStreamReader(inputStream), n, n2, 4096);
    }
    
    public JavaCharStream(final InputStream inputStream, final int n, final int n2) {
        this(inputStream, n, n2, 4096);
    }
    
    public JavaCharStream(final InputStream inputStream) {
        this(inputStream, 1, 1, 4096);
    }
    
    static {
        JavaCharStream.bufpos = -1;
        JavaCharStream.column = 0;
        JavaCharStream.line = 1;
        JavaCharStream.prevCharIsCR = false;
        JavaCharStream.prevCharIsLF = false;
        JavaCharStream.maxNextCharInd = 0;
        JavaCharStream.nextCharInd = -1;
        JavaCharStream.inBuf = 0;
    }
}
