package TemplateCompiler;

import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.IOException;
import java.io.Reader;

public final class ASCII_UCodeESC_CharStream
{
    public static final boolean staticFlag = true;
    public static int bufpos;
    static int bufsize;
    static int available;
    static int tokenBegin;
    private static int[] bufline;
    private static int[] bufcolumn;
    private static int column;
    private static int line;
    private static Reader inputStream;
    private static boolean prevCharIsCR;
    private static boolean prevCharIsLF;
    private static char[] nextCharBuf;
    private static char[] buffer;
    private static int maxNextCharInd;
    private static int nextCharInd;
    private static int inBuf;
    
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
    
    private static final void ExpandBuff(final boolean b) {
        final char[] array = new char[ASCII_UCodeESC_CharStream.bufsize + 2048];
        final int[] array2 = new int[ASCII_UCodeESC_CharStream.bufsize + 2048];
        final int[] array3 = new int[ASCII_UCodeESC_CharStream.bufsize + 2048];
        try {
            if (b) {
                System.arraycopy(ASCII_UCodeESC_CharStream.buffer, ASCII_UCodeESC_CharStream.tokenBegin, array, 0, ASCII_UCodeESC_CharStream.bufsize - ASCII_UCodeESC_CharStream.tokenBegin);
                System.arraycopy(ASCII_UCodeESC_CharStream.buffer, 0, array, ASCII_UCodeESC_CharStream.bufsize - ASCII_UCodeESC_CharStream.tokenBegin, ASCII_UCodeESC_CharStream.bufpos);
                ASCII_UCodeESC_CharStream.buffer = array;
                System.arraycopy(ASCII_UCodeESC_CharStream.bufline, ASCII_UCodeESC_CharStream.tokenBegin, array2, 0, ASCII_UCodeESC_CharStream.bufsize - ASCII_UCodeESC_CharStream.tokenBegin);
                System.arraycopy(ASCII_UCodeESC_CharStream.bufline, 0, array2, ASCII_UCodeESC_CharStream.bufsize - ASCII_UCodeESC_CharStream.tokenBegin, ASCII_UCodeESC_CharStream.bufpos);
                ASCII_UCodeESC_CharStream.bufline = array2;
                System.arraycopy(ASCII_UCodeESC_CharStream.bufcolumn, ASCII_UCodeESC_CharStream.tokenBegin, array3, 0, ASCII_UCodeESC_CharStream.bufsize - ASCII_UCodeESC_CharStream.tokenBegin);
                System.arraycopy(ASCII_UCodeESC_CharStream.bufcolumn, 0, array3, ASCII_UCodeESC_CharStream.bufsize - ASCII_UCodeESC_CharStream.tokenBegin, ASCII_UCodeESC_CharStream.bufpos);
                ASCII_UCodeESC_CharStream.bufcolumn = array3;
                ASCII_UCodeESC_CharStream.bufpos += ASCII_UCodeESC_CharStream.bufsize - ASCII_UCodeESC_CharStream.tokenBegin;
            }
            else {
                System.arraycopy(ASCII_UCodeESC_CharStream.buffer, ASCII_UCodeESC_CharStream.tokenBegin, array, 0, ASCII_UCodeESC_CharStream.bufsize - ASCII_UCodeESC_CharStream.tokenBegin);
                ASCII_UCodeESC_CharStream.buffer = array;
                System.arraycopy(ASCII_UCodeESC_CharStream.bufline, ASCII_UCodeESC_CharStream.tokenBegin, array2, 0, ASCII_UCodeESC_CharStream.bufsize - ASCII_UCodeESC_CharStream.tokenBegin);
                ASCII_UCodeESC_CharStream.bufline = array2;
                System.arraycopy(ASCII_UCodeESC_CharStream.bufcolumn, ASCII_UCodeESC_CharStream.tokenBegin, array3, 0, ASCII_UCodeESC_CharStream.bufsize - ASCII_UCodeESC_CharStream.tokenBegin);
                ASCII_UCodeESC_CharStream.bufcolumn = array3;
                ASCII_UCodeESC_CharStream.bufpos -= ASCII_UCodeESC_CharStream.tokenBegin;
            }
        }
        catch (Throwable t) {
            throw new Error(t.getMessage());
        }
        ASCII_UCodeESC_CharStream.available = (ASCII_UCodeESC_CharStream.bufsize += 2048);
        ASCII_UCodeESC_CharStream.tokenBegin = 0;
    }
    
    private static final void FillBuff() throws IOException {
        if (ASCII_UCodeESC_CharStream.maxNextCharInd == 4096) {
            ASCII_UCodeESC_CharStream.maxNextCharInd = (ASCII_UCodeESC_CharStream.nextCharInd = 0);
        }
        try {
            final int read;
            if ((read = ASCII_UCodeESC_CharStream.inputStream.read(ASCII_UCodeESC_CharStream.nextCharBuf, ASCII_UCodeESC_CharStream.maxNextCharInd, 4096 - ASCII_UCodeESC_CharStream.maxNextCharInd)) == -1) {
                ASCII_UCodeESC_CharStream.inputStream.close();
                throw new IOException();
            }
            ASCII_UCodeESC_CharStream.maxNextCharInd += read;
        }
        catch (IOException ex) {
            if (ASCII_UCodeESC_CharStream.bufpos != 0) {
                --ASCII_UCodeESC_CharStream.bufpos;
                backup(0);
            }
            else {
                ASCII_UCodeESC_CharStream.bufline[ASCII_UCodeESC_CharStream.bufpos] = ASCII_UCodeESC_CharStream.line;
                ASCII_UCodeESC_CharStream.bufcolumn[ASCII_UCodeESC_CharStream.bufpos] = ASCII_UCodeESC_CharStream.column;
            }
            throw ex;
        }
    }
    
    private static final char ReadByte() throws IOException {
        if (++ASCII_UCodeESC_CharStream.nextCharInd >= ASCII_UCodeESC_CharStream.maxNextCharInd) {
            FillBuff();
        }
        return ASCII_UCodeESC_CharStream.nextCharBuf[ASCII_UCodeESC_CharStream.nextCharInd];
    }
    
    public static final char BeginToken() throws IOException {
        if (ASCII_UCodeESC_CharStream.inBuf > 0) {
            --ASCII_UCodeESC_CharStream.inBuf;
            final char[] buffer = ASCII_UCodeESC_CharStream.buffer;
            int n;
            ASCII_UCodeESC_CharStream.tokenBegin = ((ASCII_UCodeESC_CharStream.bufpos == ASCII_UCodeESC_CharStream.bufsize - 1) ? (ASCII_UCodeESC_CharStream.bufpos = (n = 0)) : (ASCII_UCodeESC_CharStream.bufpos = (n = ASCII_UCodeESC_CharStream.bufpos + 1)));
            return buffer[n];
        }
        ASCII_UCodeESC_CharStream.tokenBegin = 0;
        ASCII_UCodeESC_CharStream.bufpos = -1;
        return readChar();
    }
    
    private static final void AdjustBuffSize() {
        if (ASCII_UCodeESC_CharStream.available == ASCII_UCodeESC_CharStream.bufsize) {
            if (ASCII_UCodeESC_CharStream.tokenBegin > 2048) {
                ASCII_UCodeESC_CharStream.bufpos = 0;
                ASCII_UCodeESC_CharStream.available = ASCII_UCodeESC_CharStream.tokenBegin;
            }
            else {
                ExpandBuff(false);
            }
        }
        else if (ASCII_UCodeESC_CharStream.available > ASCII_UCodeESC_CharStream.tokenBegin) {
            ASCII_UCodeESC_CharStream.available = ASCII_UCodeESC_CharStream.bufsize;
        }
        else if (ASCII_UCodeESC_CharStream.tokenBegin - ASCII_UCodeESC_CharStream.available < 2048) {
            ExpandBuff(true);
        }
        else {
            ASCII_UCodeESC_CharStream.available = ASCII_UCodeESC_CharStream.tokenBegin;
        }
    }
    
    private static final void UpdateLineColumn(final char c) {
        ++ASCII_UCodeESC_CharStream.column;
        if (ASCII_UCodeESC_CharStream.prevCharIsLF) {
            ASCII_UCodeESC_CharStream.prevCharIsLF = false;
            ASCII_UCodeESC_CharStream.line += (ASCII_UCodeESC_CharStream.column = 1);
        }
        else if (ASCII_UCodeESC_CharStream.prevCharIsCR) {
            ASCII_UCodeESC_CharStream.prevCharIsCR = false;
            if (c == '\n') {
                ASCII_UCodeESC_CharStream.prevCharIsLF = true;
            }
            else {
                ASCII_UCodeESC_CharStream.line += (ASCII_UCodeESC_CharStream.column = 1);
            }
        }
        switch (c) {
            case '\r': {
                ASCII_UCodeESC_CharStream.prevCharIsCR = true;
                break;
            }
            case '\n': {
                ASCII_UCodeESC_CharStream.prevCharIsLF = true;
                break;
            }
            case '\t': {
                --ASCII_UCodeESC_CharStream.column;
                ASCII_UCodeESC_CharStream.column += 8 - (ASCII_UCodeESC_CharStream.column & 0x7);
                break;
            }
        }
        ASCII_UCodeESC_CharStream.bufline[ASCII_UCodeESC_CharStream.bufpos] = ASCII_UCodeESC_CharStream.line;
        ASCII_UCodeESC_CharStream.bufcolumn[ASCII_UCodeESC_CharStream.bufpos] = ASCII_UCodeESC_CharStream.column;
    }
    
    public static final char readChar() throws IOException {
        if (ASCII_UCodeESC_CharStream.inBuf > 0) {
            --ASCII_UCodeESC_CharStream.inBuf;
            return ASCII_UCodeESC_CharStream.buffer[(ASCII_UCodeESC_CharStream.bufpos == ASCII_UCodeESC_CharStream.bufsize - 1) ? (ASCII_UCodeESC_CharStream.bufpos = 0) : (++ASCII_UCodeESC_CharStream.bufpos)];
        }
        if (++ASCII_UCodeESC_CharStream.bufpos == ASCII_UCodeESC_CharStream.available) {
            AdjustBuffSize();
        }
        final char c;
        if ((ASCII_UCodeESC_CharStream.buffer[ASCII_UCodeESC_CharStream.bufpos] = (c = (char)('\u00ff' & ReadByte()))) != '\\') {
            UpdateLineColumn(c);
            return c;
        }
        UpdateLineColumn(c);
        int n = 1;
        while (true) {
            if (++ASCII_UCodeESC_CharStream.bufpos == ASCII_UCodeESC_CharStream.available) {
                AdjustBuffSize();
            }
            char c2;
            try {
                if ((ASCII_UCodeESC_CharStream.buffer[ASCII_UCodeESC_CharStream.bufpos] = (c2 = (char)('\u00ff' & ReadByte()))) != '\\') {
                    UpdateLineColumn(c2);
                    if (c2 == 'u' && (n & 0x1) == 0x1) {
                        if (--ASCII_UCodeESC_CharStream.bufpos < 0) {
                            ASCII_UCodeESC_CharStream.bufpos = ASCII_UCodeESC_CharStream.bufsize - 1;
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
            UpdateLineColumn(c2);
            ++n;
        }
        char c4;
        try {
            char c3;
            while ((c3 = (char)('\u00ff' & ReadByte())) == 'u') {
                ++ASCII_UCodeESC_CharStream.column;
            }
            c4 = (ASCII_UCodeESC_CharStream.buffer[ASCII_UCodeESC_CharStream.bufpos] = (char)(hexval(c3) << 12 | hexval((char)('\u00ff' & ReadByte())) << 8 | hexval((char)('\u00ff' & ReadByte())) << 4 | hexval((char)('\u00ff' & ReadByte()))));
            ASCII_UCodeESC_CharStream.column += 4;
        }
        catch (IOException ex2) {
            throw new Error("Invalid escape character at line " + ASCII_UCodeESC_CharStream.line + " column " + ASCII_UCodeESC_CharStream.column + '.');
        }
        if (n == 1) {
            return c4;
        }
        backup(n - 1);
        return '\\';
    }
    
    public static final int getColumn() {
        return ASCII_UCodeESC_CharStream.bufcolumn[ASCII_UCodeESC_CharStream.bufpos];
    }
    
    public static final int getLine() {
        return ASCII_UCodeESC_CharStream.bufline[ASCII_UCodeESC_CharStream.bufpos];
    }
    
    public static final int getEndColumn() {
        return ASCII_UCodeESC_CharStream.bufcolumn[ASCII_UCodeESC_CharStream.bufpos];
    }
    
    public static final int getEndLine() {
        return ASCII_UCodeESC_CharStream.bufline[ASCII_UCodeESC_CharStream.bufpos];
    }
    
    public static final int getBeginColumn() {
        return ASCII_UCodeESC_CharStream.bufcolumn[ASCII_UCodeESC_CharStream.tokenBegin];
    }
    
    public static final int getBeginLine() {
        return ASCII_UCodeESC_CharStream.bufline[ASCII_UCodeESC_CharStream.tokenBegin];
    }
    
    public static final void backup(final int n) {
        ASCII_UCodeESC_CharStream.inBuf += n;
        if ((ASCII_UCodeESC_CharStream.bufpos -= n) < 0) {
            ASCII_UCodeESC_CharStream.bufpos += ASCII_UCodeESC_CharStream.bufsize;
        }
    }
    
    public final void ReInit(final Reader inputStream, final int line, final int n, final int n2) {
        ASCII_UCodeESC_CharStream.inputStream = inputStream;
        ASCII_UCodeESC_CharStream.line = line;
        ASCII_UCodeESC_CharStream.column = n - 1;
        if (ASCII_UCodeESC_CharStream.buffer == null || n2 != ASCII_UCodeESC_CharStream.buffer.length) {
            ASCII_UCodeESC_CharStream.bufsize = n2;
            ASCII_UCodeESC_CharStream.available = n2;
            ASCII_UCodeESC_CharStream.buffer = new char[n2];
            ASCII_UCodeESC_CharStream.bufline = new int[n2];
            ASCII_UCodeESC_CharStream.bufcolumn = new int[n2];
            ASCII_UCodeESC_CharStream.nextCharBuf = new char[4096];
        }
        ASCII_UCodeESC_CharStream.prevCharIsLF = (ASCII_UCodeESC_CharStream.prevCharIsCR = false);
        ASCII_UCodeESC_CharStream.tokenBegin = (ASCII_UCodeESC_CharStream.inBuf = (ASCII_UCodeESC_CharStream.maxNextCharInd = 0));
        ASCII_UCodeESC_CharStream.nextCharInd = (ASCII_UCodeESC_CharStream.bufpos = -1);
    }
    
    public final void ReInit(final Reader reader, final int n, final int n2) {
        this.ReInit(reader, n, n2, 4096);
    }
    
    public final void ReInit(final InputStream inputStream, final int n, final int n2, final int n3) {
        this.ReInit(new InputStreamReader(inputStream), n, n2, 4096);
    }
    
    public final void ReInit(final InputStream inputStream, final int n, final int n2) {
        this.ReInit(inputStream, n, n2, 4096);
    }
    
    public static final String GetImage() {
        if (ASCII_UCodeESC_CharStream.bufpos >= ASCII_UCodeESC_CharStream.tokenBegin) {
            return new String(ASCII_UCodeESC_CharStream.buffer, ASCII_UCodeESC_CharStream.tokenBegin, ASCII_UCodeESC_CharStream.bufpos - ASCII_UCodeESC_CharStream.tokenBegin + 1);
        }
        return new String(ASCII_UCodeESC_CharStream.buffer, ASCII_UCodeESC_CharStream.tokenBegin, ASCII_UCodeESC_CharStream.bufsize - ASCII_UCodeESC_CharStream.tokenBegin) + new String(ASCII_UCodeESC_CharStream.buffer, 0, ASCII_UCodeESC_CharStream.bufpos + 1);
    }
    
    public static final char[] GetSuffix(final int n) {
        final char[] array = new char[n];
        if (ASCII_UCodeESC_CharStream.bufpos + 1 >= n) {
            System.arraycopy(ASCII_UCodeESC_CharStream.buffer, ASCII_UCodeESC_CharStream.bufpos - n + 1, array, 0, n);
        }
        else {
            System.arraycopy(ASCII_UCodeESC_CharStream.buffer, ASCII_UCodeESC_CharStream.bufsize - (n - ASCII_UCodeESC_CharStream.bufpos - 1), array, 0, n - ASCII_UCodeESC_CharStream.bufpos - 1);
            System.arraycopy(ASCII_UCodeESC_CharStream.buffer, 0, array, n - ASCII_UCodeESC_CharStream.bufpos - 1, ASCII_UCodeESC_CharStream.bufpos + 1);
        }
        return array;
    }
    
    public static final void Done() {
        ASCII_UCodeESC_CharStream.nextCharBuf = null;
        ASCII_UCodeESC_CharStream.buffer = null;
        ASCII_UCodeESC_CharStream.bufline = null;
        ASCII_UCodeESC_CharStream.bufcolumn = null;
    }
    
    public static final void adjustBeginLineColumn(int n, final int n2) {
        int tokenBegin = ASCII_UCodeESC_CharStream.tokenBegin;
        int n3;
        if (ASCII_UCodeESC_CharStream.bufpos >= ASCII_UCodeESC_CharStream.tokenBegin) {
            n3 = ASCII_UCodeESC_CharStream.bufpos - ASCII_UCodeESC_CharStream.tokenBegin + ASCII_UCodeESC_CharStream.inBuf + 1;
        }
        else {
            n3 = ASCII_UCodeESC_CharStream.bufsize - ASCII_UCodeESC_CharStream.tokenBegin + ASCII_UCodeESC_CharStream.bufpos + 1 + ASCII_UCodeESC_CharStream.inBuf;
        }
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7;
        while (n4 < n3 && ASCII_UCodeESC_CharStream.bufline[n5 = tokenBegin % ASCII_UCodeESC_CharStream.bufsize] == ASCII_UCodeESC_CharStream.bufline[n7 = ++tokenBegin % ASCII_UCodeESC_CharStream.bufsize]) {
            ASCII_UCodeESC_CharStream.bufline[n5] = n;
            final int n8 = n6 + ASCII_UCodeESC_CharStream.bufcolumn[n7] - ASCII_UCodeESC_CharStream.bufcolumn[n5];
            ASCII_UCodeESC_CharStream.bufcolumn[n5] = n2 + n6;
            n6 = n8;
            ++n4;
        }
        if (n4 < n3) {
            ASCII_UCodeESC_CharStream.bufline[n5] = n++;
            ASCII_UCodeESC_CharStream.bufcolumn[n5] = n2 + n6;
            while (n4++ < n3) {
                if (ASCII_UCodeESC_CharStream.bufline[n5 = tokenBegin % ASCII_UCodeESC_CharStream.bufsize] != ASCII_UCodeESC_CharStream.bufline[++tokenBegin % ASCII_UCodeESC_CharStream.bufsize]) {
                    ASCII_UCodeESC_CharStream.bufline[n5] = n++;
                }
                else {
                    ASCII_UCodeESC_CharStream.bufline[n5] = n;
                }
            }
        }
        ASCII_UCodeESC_CharStream.line = ASCII_UCodeESC_CharStream.bufline[n5];
        ASCII_UCodeESC_CharStream.column = ASCII_UCodeESC_CharStream.bufcolumn[n5];
    }
    
    public ASCII_UCodeESC_CharStream(final Reader inputStream, final int line, final int n, final int n2) {
        if (ASCII_UCodeESC_CharStream.inputStream != null) {
            throw new Error("\n   ERROR: Second call to the constructor of a static ASCII_UCodeESC_CharStream.  You must\n       either use ReInit() or set the JavaCC option STATIC to false\n       during the generation of this class.");
        }
        ASCII_UCodeESC_CharStream.inputStream = inputStream;
        ASCII_UCodeESC_CharStream.line = line;
        ASCII_UCodeESC_CharStream.column = n - 1;
        ASCII_UCodeESC_CharStream.bufsize = n2;
        ASCII_UCodeESC_CharStream.available = n2;
        ASCII_UCodeESC_CharStream.buffer = new char[n2];
        ASCII_UCodeESC_CharStream.bufline = new int[n2];
        ASCII_UCodeESC_CharStream.bufcolumn = new int[n2];
        ASCII_UCodeESC_CharStream.nextCharBuf = new char[4096];
    }
    
    public ASCII_UCodeESC_CharStream(final Reader reader, final int n, final int n2) {
        this(reader, n, n2, 4096);
    }
    
    public ASCII_UCodeESC_CharStream(final InputStream inputStream, final int n, final int n2, final int n3) {
        this(new InputStreamReader(inputStream), n, n2, 4096);
    }
    
    public ASCII_UCodeESC_CharStream(final InputStream inputStream, final int n, final int n2) {
        this(inputStream, n, n2, 4096);
    }
    
    static {
        ASCII_UCodeESC_CharStream.bufpos = -1;
        ASCII_UCodeESC_CharStream.column = 0;
        ASCII_UCodeESC_CharStream.line = 1;
        ASCII_UCodeESC_CharStream.prevCharIsCR = false;
        ASCII_UCodeESC_CharStream.prevCharIsLF = false;
        ASCII_UCodeESC_CharStream.maxNextCharInd = 0;
        ASCII_UCodeESC_CharStream.nextCharInd = -1;
        ASCII_UCodeESC_CharStream.inBuf = 0;
    }
}
