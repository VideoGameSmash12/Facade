package jess;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.io.IOException;
import java.io.PushbackReader;

class Tokenizer
{
    private static final int EOF = -1;
    public static final String BLANK_PREFIX = "_blank_";
    public static final String BLANK_MULTI = "_blank_mf";
    private PushbackReader m_ios;
    private int m_line;
    private boolean m_nl;
    StringBuffer m_sb;
    
    public void reportNewlines(final boolean nl) {
        this.m_nl = nl;
    }
    
    public synchronized String readLine() throws JessException {
        this.m_sb.setLength(0);
        int nextChar;
        while ((nextChar = this.nextChar()) != 10 && nextChar != -1) {
            this.m_sb.append((char)nextChar);
        }
        if (nextChar == -1 && this.m_sb.length() == 0) {
            return null;
        }
        ++this.m_line;
        return this.m_sb.toString();
    }
    
    public synchronized JessToken nextToken() throws JessException {
        this.m_sb.setLength(0);
        try {
            int i;
        Label_0224:
            do {
                i = this.nextChar();
                switch (i) {
                    case -1: {
                        return this.finishToken(-1, this.m_sb);
                    }
                    case 10: {
                        ++this.m_line;
                        if (this.m_nl) {
                            return this.finishToken(10, this.m_sb);
                        }
                        continue;
                    }
                    case 9:
                    case 32: {
                        continue;
                    }
                    default: {
                        this.m_ios.unread(i);
                        break Label_0224;
                    }
                }
            } while (i != -1);
            final int nextChar = this.nextChar();
            switch (nextChar) {
                case -1: {
                    return this.finishToken(-1, this.m_sb);
                }
                case 59: {
                    this.discardToEOL();
                    return this.nextToken();
                }
                case 34: {
                    this.readString(this.m_sb);
                    return this.finishToken(34, this.m_sb);
                }
                case 38:
                case 40:
                case 41:
                case 61:
                case 124:
                case 126: {
                    return this.finishToken(nextChar, this.m_sb);
                }
                default: {
                    this.m_sb.append((char)nextChar);
                    while (true) {
                        final int nextChar2 = this.nextChar();
                        if (Character.isWhitespace((char)nextChar2)) {
                            this.m_ios.unread(nextChar2);
                            return this.finishToken(0, this.m_sb);
                        }
                        switch (nextChar2) {
                            case -1: {
                                return this.finishToken(-1, this.m_sb);
                            }
                            case 34:
                            case 38:
                            case 40:
                            case 41:
                            case 59:
                            case 60:
                            case 124:
                            case 126: {
                                this.m_ios.unread(nextChar2);
                                return this.finishToken(0, this.m_sb);
                            }
                            case 92: {
                                final int nextChar3 = this.nextChar();
                                if (nextChar3 == -1) {
                                    return this.finishToken(-1, this.m_sb);
                                }
                                this.m_sb.append((char)nextChar3);
                                continue;
                            }
                            default: {
                                this.m_sb.append((char)nextChar2);
                                continue;
                            }
                        }
                    }
                    break;
                }
            }
        }
        catch (IOException ex) {
            throw new JessException("Tokenizer.nextToken", "I/O Exception", ex);
        }
    }
    
    private final int nextChar() throws JessException {
        try {
            int read = this.m_ios.read();
            if (read == 13) {
                if (this.m_ios.ready()) {
                    final int read2 = this.m_ios.read();
                    if (read2 != 10) {
                        this.m_ios.unread(read2);
                    }
                }
                read = 10;
            }
            return read;
        }
        catch (IOException ex) {
            throw new JessException("Tokenizer.nextChar", "Error on input stream", ex);
        }
    }
    
    private final JessToken finishToken(final int ttype, final StringBuffer sb) throws JessException {
        final JessToken jessToken = new JessToken();
        jessToken.m_lineno = this.m_line;
        switch (ttype) {
            case 34: {
                jessToken.m_ttype = 2;
                jessToken.m_sval = sb.toString();
                break;
            }
            case 40: {
                jessToken.m_ttype = 40;
                jessToken.m_sval = "(";
                break;
            }
            case 41: {
                jessToken.m_ttype = 41;
                jessToken.m_sval = ")";
                break;
            }
            case 38: {
                jessToken.m_ttype = 38;
                jessToken.m_sval = "&";
                break;
            }
            case 126: {
                jessToken.m_ttype = 126;
                jessToken.m_sval = "~";
                break;
            }
            case 124: {
                jessToken.m_ttype = ttype;
                jessToken.m_sval = "|";
                break;
            }
            case 61: {
                jessToken.m_ttype = 61;
                jessToken.m_sval = "=";
                break;
            }
            case 10: {
                jessToken.m_ttype = 1;
                jessToken.m_sval = "CRLF";
                break;
            }
            case -1: {
                if (sb.length() == 0) {
                    jessToken.m_ttype = 0;
                    jessToken.m_sval = "EOF";
                    break;
                }
                return this.finishToken(0, sb);
            }
            case 0: {
                final String string = sb.toString();
                final char char1 = string.charAt(0);
                if (char1 == '?') {
                    jessToken.m_ttype = 8;
                    if (string.length() > 1) {
                        jessToken.m_sval = string.substring(1);
                    }
                    else {
                        jessToken.m_sval = RU.gensym("_blank_");
                    }
                    break;
                }
                if (char1 == '$' && string.length() > 1 && string.charAt(1) == '?') {
                    jessToken.m_ttype = 8192;
                    if (string.length() > 2) {
                        jessToken.m_sval = string.substring(2);
                    }
                    else {
                        jessToken.m_sval = RU.gensym("_blank_mf");
                    }
                    break;
                }
                if (string.length() == 1 && (char1 == '-' || char1 == '.' || char1 == '+')) {
                    jessToken.m_ttype = 1;
                    jessToken.m_sval = string;
                    break;
                }
                if (this.isAnInteger(string)) {
                    try {
                        final int int1 = Integer.parseInt(string, 10);
                        jessToken.m_ttype = 4;
                        jessToken.m_nval = int1;
                        break;
                    }
                    catch (NumberFormatException ex) {}
                }
                try {
                    final double doubleValue = Double.valueOf(string);
                    jessToken.m_ttype = 32;
                    jessToken.m_nval = doubleValue;
                }
                catch (NumberFormatException ex2) {
                    jessToken.m_ttype = 1;
                    jessToken.m_sval = string;
                }
                break;
            }
            default: {
                throw new JessException("Tokenizer.finishToken", "Impossible tag:", new StringBuffer().append((char)ttype).toString());
            }
        }
        return jessToken;
    }
    
    private final boolean isAnInteger(final String s) {
        final char char1 = s.charAt(0);
        if (!Character.isDigit(char1) && char1 != '+' && char1 != '-') {
            return false;
        }
        for (int i = 1; i < s.length(); ++i) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    
    public void discardToEOL() throws JessException {
        int i;
        do {
            i = this.nextChar();
            if (i == 10) {
                ++this.m_line;
                break;
            }
        } while (i != -1);
    }
    
    private final String readString(final StringBuffer sb) throws JessException {
        int i;
    Label_0100:
        do {
            i = this.nextChar();
            switch (i) {
                case -1: {
                    return null;
                }
                case 92: {
                    i = this.nextChar();
                    sb.append((char)i);
                    continue;
                }
                case 10: {
                    ++this.m_line;
                    sb.append((char)i);
                    continue;
                }
                case 34: {
                    break Label_0100;
                }
                default: {
                    sb.append((char)i);
                    continue;
                }
            }
        } while (i != -1);
        return sb.toString();
    }
    
    private final /* synthetic */ void this() {
        this.m_line = 1;
        this.m_nl = false;
        this.m_sb = new StringBuffer(5);
    }
    
    public Tokenizer(final Reader reader) {
        this.this();
        if (reader instanceof PushbackReader) {
            this.m_ios = (PushbackReader)reader;
        }
        else if (reader instanceof FileReader) {
            this.m_ios = new PushbackReader(new BufferedReader(reader, 512));
        }
        else {
            this.m_ios = new PushbackReader(reader);
        }
    }
}
