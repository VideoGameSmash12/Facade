package TemplateCompiler;

import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.IOException;
import java.io.Reader;

public final class ASCII_CharStream
{
    public static final boolean staticFlag = true;
    static int bufsize;
    static int available;
    static int tokenBegin;
    public static int bufpos;
    private static int[] bufline;
    private static int[] bufcolumn;
    private static int column;
    private static int line;
    private static boolean prevCharIsCR;
    private static boolean prevCharIsLF;
    private static Reader inputStream;
    private static char[] buffer;
    private static int maxNextCharInd;
    private static int inBuf;
    
    private static final void ExpandBuff(final boolean b) {
        final char[] array = new char[ASCII_CharStream.bufsize + 2048];
        final int[] array2 = new int[ASCII_CharStream.bufsize + 2048];
        final int[] array3 = new int[ASCII_CharStream.bufsize + 2048];
        try {
            if (b) {
                System.arraycopy(ASCII_CharStream.buffer, ASCII_CharStream.tokenBegin, array, 0, ASCII_CharStream.bufsize - ASCII_CharStream.tokenBegin);
                System.arraycopy(ASCII_CharStream.buffer, 0, array, ASCII_CharStream.bufsize - ASCII_CharStream.tokenBegin, ASCII_CharStream.bufpos);
                ASCII_CharStream.buffer = array;
                System.arraycopy(ASCII_CharStream.bufline, ASCII_CharStream.tokenBegin, array2, 0, ASCII_CharStream.bufsize - ASCII_CharStream.tokenBegin);
                System.arraycopy(ASCII_CharStream.bufline, 0, array2, ASCII_CharStream.bufsize - ASCII_CharStream.tokenBegin, ASCII_CharStream.bufpos);
                ASCII_CharStream.bufline = array2;
                System.arraycopy(ASCII_CharStream.bufcolumn, ASCII_CharStream.tokenBegin, array3, 0, ASCII_CharStream.bufsize - ASCII_CharStream.tokenBegin);
                System.arraycopy(ASCII_CharStream.bufcolumn, 0, array3, ASCII_CharStream.bufsize - ASCII_CharStream.tokenBegin, ASCII_CharStream.bufpos);
                ASCII_CharStream.bufcolumn = array3;
                ASCII_CharStream.maxNextCharInd = (ASCII_CharStream.bufpos += ASCII_CharStream.bufsize - ASCII_CharStream.tokenBegin);
            }
            else {
                System.arraycopy(ASCII_CharStream.buffer, ASCII_CharStream.tokenBegin, array, 0, ASCII_CharStream.bufsize - ASCII_CharStream.tokenBegin);
                ASCII_CharStream.buffer = array;
                System.arraycopy(ASCII_CharStream.bufline, ASCII_CharStream.tokenBegin, array2, 0, ASCII_CharStream.bufsize - ASCII_CharStream.tokenBegin);
                ASCII_CharStream.bufline = array2;
                System.arraycopy(ASCII_CharStream.bufcolumn, ASCII_CharStream.tokenBegin, array3, 0, ASCII_CharStream.bufsize - ASCII_CharStream.tokenBegin);
                ASCII_CharStream.bufcolumn = array3;
                ASCII_CharStream.maxNextCharInd = (ASCII_CharStream.bufpos -= ASCII_CharStream.tokenBegin);
            }
        }
        catch (Throwable t) {
            throw new Error(t.getMessage());
        }
        ASCII_CharStream.bufsize += 2048;
        ASCII_CharStream.available = ASCII_CharStream.bufsize;
        ASCII_CharStream.tokenBegin = 0;
    }
    
    private static final void FillBuff() throws IOException {
        if (ASCII_CharStream.maxNextCharInd == ASCII_CharStream.available) {
            if (ASCII_CharStream.available == ASCII_CharStream.bufsize) {
                if (ASCII_CharStream.tokenBegin > 2048) {
                    ASCII_CharStream.bufpos = (ASCII_CharStream.maxNextCharInd = 0);
                    ASCII_CharStream.available = ASCII_CharStream.tokenBegin;
                }
                else if (ASCII_CharStream.tokenBegin < 0) {
                    ASCII_CharStream.bufpos = (ASCII_CharStream.maxNextCharInd = 0);
                }
                else {
                    ExpandBuff(false);
                }
            }
            else if (ASCII_CharStream.available > ASCII_CharStream.tokenBegin) {
                ASCII_CharStream.available = ASCII_CharStream.bufsize;
            }
            else if (ASCII_CharStream.tokenBegin - ASCII_CharStream.available < 2048) {
                ExpandBuff(true);
            }
            else {
                ASCII_CharStream.available = ASCII_CharStream.tokenBegin;
            }
        }
        try {
            final int read;
            if ((read = ASCII_CharStream.inputStream.read(ASCII_CharStream.buffer, ASCII_CharStream.maxNextCharInd, ASCII_CharStream.available - ASCII_CharStream.maxNextCharInd)) == -1) {
                ASCII_CharStream.inputStream.close();
                throw new IOException();
            }
            ASCII_CharStream.maxNextCharInd += read;
        }
        catch (IOException ex) {
            --ASCII_CharStream.bufpos;
            backup(0);
            if (ASCII_CharStream.tokenBegin == -1) {
                ASCII_CharStream.tokenBegin = ASCII_CharStream.bufpos;
            }
            throw ex;
        }
    }
    
    public static final char BeginToken() throws IOException {
        ASCII_CharStream.tokenBegin = -1;
        final char char1 = readChar();
        ASCII_CharStream.tokenBegin = ASCII_CharStream.bufpos;
        return char1;
    }
    
    private static final void UpdateLineColumn(final char c) {
        ++ASCII_CharStream.column;
        if (ASCII_CharStream.prevCharIsLF) {
            ASCII_CharStream.prevCharIsLF = false;
            ASCII_CharStream.line += (ASCII_CharStream.column = 1);
        }
        else if (ASCII_CharStream.prevCharIsCR) {
            ASCII_CharStream.prevCharIsCR = false;
            if (c == '\n') {
                ASCII_CharStream.prevCharIsLF = true;
            }
            else {
                ASCII_CharStream.line += (ASCII_CharStream.column = 1);
            }
        }
        switch (c) {
            case '\r': {
                ASCII_CharStream.prevCharIsCR = true;
                break;
            }
            case '\n': {
                ASCII_CharStream.prevCharIsLF = true;
                break;
            }
            case '\t': {
                --ASCII_CharStream.column;
                ASCII_CharStream.column += 8 - (ASCII_CharStream.column & 0x7);
                break;
            }
        }
        ASCII_CharStream.bufline[ASCII_CharStream.bufpos] = ASCII_CharStream.line;
        ASCII_CharStream.bufcolumn[ASCII_CharStream.bufpos] = ASCII_CharStream.column;
    }
    
    public static final char readChar() throws IOException {
        if (ASCII_CharStream.inBuf > 0) {
            --ASCII_CharStream.inBuf;
            return (char)('\u00ff' & ASCII_CharStream.buffer[(ASCII_CharStream.bufpos == ASCII_CharStream.bufsize - 1) ? (ASCII_CharStream.bufpos = 0) : (++ASCII_CharStream.bufpos)]);
        }
        if (++ASCII_CharStream.bufpos >= ASCII_CharStream.maxNextCharInd) {
            FillBuff();
        }
        final char c = (char)('\u00ff' & ASCII_CharStream.buffer[ASCII_CharStream.bufpos]);
        UpdateLineColumn(c);
        return c;
    }
    
    public static final int getColumn() {
        return ASCII_CharStream.bufcolumn[ASCII_CharStream.bufpos];
    }
    
    public static final int getLine() {
        return ASCII_CharStream.bufline[ASCII_CharStream.bufpos];
    }
    
    public static final int getEndColumn() {
        return ASCII_CharStream.bufcolumn[ASCII_CharStream.bufpos];
    }
    
    public static final int getEndLine() {
        return ASCII_CharStream.bufline[ASCII_CharStream.bufpos];
    }
    
    public static final int getBeginColumn() {
        return ASCII_CharStream.bufcolumn[ASCII_CharStream.tokenBegin];
    }
    
    public static final int getBeginLine() {
        return ASCII_CharStream.bufline[ASCII_CharStream.tokenBegin];
    }
    
    public static final void backup(final int n) {
        ASCII_CharStream.inBuf += n;
        if ((ASCII_CharStream.bufpos -= n) < 0) {
            ASCII_CharStream.bufpos += ASCII_CharStream.bufsize;
        }
    }
    
    public static final void ReInit(final Reader inputStream, final int line, final int n, final int n2) {
        ASCII_CharStream.inputStream = inputStream;
        ASCII_CharStream.line = line;
        ASCII_CharStream.column = n - 1;
        if (ASCII_CharStream.buffer == null || n2 != ASCII_CharStream.buffer.length) {
            ASCII_CharStream.bufsize = n2;
            ASCII_CharStream.available = n2;
            ASCII_CharStream.buffer = new char[n2];
            ASCII_CharStream.bufline = new int[n2];
            ASCII_CharStream.bufcolumn = new int[n2];
        }
        ASCII_CharStream.prevCharIsLF = (ASCII_CharStream.prevCharIsCR = false);
        ASCII_CharStream.tokenBegin = (ASCII_CharStream.inBuf = (ASCII_CharStream.maxNextCharInd = 0));
        ASCII_CharStream.bufpos = -1;
    }
    
    public static final void ReInit(final Reader reader, final int n, final int n2) {
        ReInit(reader, n, n2, 4096);
    }
    
    public static final void ReInit(final InputStream inputStream, final int n, final int n2, final int n3) {
        ReInit(new InputStreamReader(inputStream), n, n2, 4096);
    }
    
    public static final void ReInit(final InputStream inputStream, final int n, final int n2) {
        ReInit(inputStream, n, n2, 4096);
    }
    
    public static final String GetImage() {
        if (ASCII_CharStream.bufpos >= ASCII_CharStream.tokenBegin) {
            return new String(ASCII_CharStream.buffer, ASCII_CharStream.tokenBegin, ASCII_CharStream.bufpos - ASCII_CharStream.tokenBegin + 1);
        }
        return new String(ASCII_CharStream.buffer, ASCII_CharStream.tokenBegin, ASCII_CharStream.bufsize - ASCII_CharStream.tokenBegin) + new String(ASCII_CharStream.buffer, 0, ASCII_CharStream.bufpos + 1);
    }
    
    public static final char[] GetSuffix(final int n) {
        final char[] array = new char[n];
        if (ASCII_CharStream.bufpos + 1 >= n) {
            System.arraycopy(ASCII_CharStream.buffer, ASCII_CharStream.bufpos - n + 1, array, 0, n);
        }
        else {
            System.arraycopy(ASCII_CharStream.buffer, ASCII_CharStream.bufsize - (n - ASCII_CharStream.bufpos - 1), array, 0, n - ASCII_CharStream.bufpos - 1);
            System.arraycopy(ASCII_CharStream.buffer, 0, array, n - ASCII_CharStream.bufpos - 1, ASCII_CharStream.bufpos + 1);
        }
        return array;
    }
    
    public static final void Done() {
        ASCII_CharStream.buffer = null;
        ASCII_CharStream.bufline = null;
        ASCII_CharStream.bufcolumn = null;
    }
    
    public static final void adjustBeginLineColumn(int n, final int n2) {
        int tokenBegin = ASCII_CharStream.tokenBegin;
        int n3;
        if (ASCII_CharStream.bufpos >= ASCII_CharStream.tokenBegin) {
            n3 = ASCII_CharStream.bufpos - ASCII_CharStream.tokenBegin + ASCII_CharStream.inBuf + 1;
        }
        else {
            n3 = ASCII_CharStream.bufsize - ASCII_CharStream.tokenBegin + ASCII_CharStream.bufpos + 1 + ASCII_CharStream.inBuf;
        }
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7;
        while (n4 < n3 && ASCII_CharStream.bufline[n5 = tokenBegin % ASCII_CharStream.bufsize] == ASCII_CharStream.bufline[n7 = ++tokenBegin % ASCII_CharStream.bufsize]) {
            ASCII_CharStream.bufline[n5] = n;
            final int n8 = n6 + ASCII_CharStream.bufcolumn[n7] - ASCII_CharStream.bufcolumn[n5];
            ASCII_CharStream.bufcolumn[n5] = n2 + n6;
            n6 = n8;
            ++n4;
        }
        if (n4 < n3) {
            ASCII_CharStream.bufline[n5] = n++;
            ASCII_CharStream.bufcolumn[n5] = n2 + n6;
            while (n4++ < n3) {
                if (ASCII_CharStream.bufline[n5 = tokenBegin % ASCII_CharStream.bufsize] != ASCII_CharStream.bufline[++tokenBegin % ASCII_CharStream.bufsize]) {
                    ASCII_CharStream.bufline[n5] = n++;
                }
                else {
                    ASCII_CharStream.bufline[n5] = n;
                }
            }
        }
        ASCII_CharStream.line = ASCII_CharStream.bufline[n5];
        ASCII_CharStream.column = ASCII_CharStream.bufcolumn[n5];
    }
    
    public ASCII_CharStream(final Reader inputStream, final int line, final int n, final int n2) {
        if (ASCII_CharStream.inputStream != null) {
            throw new Error("\n   ERROR: Second call to the constructor of a static ASCII_CharStream.  You must\n       either use ReInit() or set the JavaCC option STATIC to false\n       during the generation of this class.");
        }
        ASCII_CharStream.inputStream = inputStream;
        ASCII_CharStream.line = line;
        ASCII_CharStream.column = n - 1;
        ASCII_CharStream.bufsize = n2;
        ASCII_CharStream.available = n2;
        ASCII_CharStream.buffer = new char[n2];
        ASCII_CharStream.bufline = new int[n2];
        ASCII_CharStream.bufcolumn = new int[n2];
    }
    
    public ASCII_CharStream(final Reader reader, final int n, final int n2) {
        this(reader, n, n2, 4096);
    }
    
    public ASCII_CharStream(final InputStream inputStream, final int n, final int n2, final int n3) {
        this(new InputStreamReader(inputStream), n, n2, 4096);
    }
    
    public ASCII_CharStream(final InputStream inputStream, final int n, final int n2) {
        this(inputStream, n, n2, 4096);
    }
    
    static {
        ASCII_CharStream.bufpos = -1;
        ASCII_CharStream.column = 0;
        ASCII_CharStream.line = 1;
        ASCII_CharStream.prevCharIsCR = false;
        ASCII_CharStream.prevCharIsLF = false;
        ASCII_CharStream.maxNextCharInd = 0;
        ASCII_CharStream.inBuf = 0;
    }
}
