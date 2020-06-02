package jess.awt;

import java.io.IOException;
import java.io.Serializable;
import java.io.Reader;

public class TextReader extends Reader implements Serializable
{
    private StringBuffer m_buf;
    private int m_ptr;
    private boolean m_dontWait;
    
    public synchronized int read() {
        while (this.m_ptr >= this.m_buf.length()) {
            if (this.m_dontWait) {
                return -1;
            }
            try {
                this.wait(100L);
            }
            catch (InterruptedException ex) {}
        }
        final char char1 = this.m_buf.charAt(this.m_ptr++);
        if (this.m_ptr >= this.m_buf.length()) {
            this.clear();
        }
        return char1;
    }
    
    public int read(final char[] array) throws IOException {
        return this.read(array, 0, array.length);
    }
    
    public int read(final char[] array, final int n, final int n2) throws IOException {
        for (int i = n; i < n + n2; ++i) {
            final int read = this.read();
            if (read == -1) {
                return (i > n) ? (i - n) : -1;
            }
            array[i] = (char)read;
        }
        return n2;
    }
    
    public void close() {
    }
    
    public int available() {
        return this.m_buf.length() - this.m_ptr;
    }
    
    public synchronized void appendText(final String s) {
        this.m_buf.append(s);
        this.notifyAll();
    }
    
    public synchronized void clear() {
        this.m_buf.setLength(0);
        this.m_ptr = 0;
    }
    
    private final /* synthetic */ void this() {
        this.m_buf = new StringBuffer(256);
        this.m_ptr = 0;
        this.m_dontWait = false;
    }
    
    public TextReader(final boolean dontWait) {
        this.this();
        this.m_dontWait = dontWait;
    }
}
