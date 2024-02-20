package jess.awt;

import java.awt.TextArea;
import java.io.Serializable;
import java.io.Writer;

public class TextAreaWriter extends Writer implements Serializable
{
    private static final int MAXSIZE = 30000;
    private StringBuffer m_str;
    private TextArea m_ta;
    private int m_size;
    
    public synchronized void clear() {
        this.m_ta.setText("");
        this.m_size = 0;
    }
    
    public void close() {
    }
    
    public synchronized void flush() {
        final int length = this.m_str.length();
        if (this.m_size > 30000) {
            this.m_ta.replaceRange("", 0, length);
            this.m_size -= length;
        }
        this.m_ta.append(this.m_str.toString());
        this.m_size += length;
        this.m_str.setLength(0);
    }
    
    public synchronized void write(final char[] array, final int n, final int n2) {
        this.m_str.append(array, n, n2);
    }
    
    private final /* synthetic */ void this() {
        this.m_size = 0;
    }
    
    public TextAreaWriter(final TextArea ta) {
        this.this();
        this.m_str = new StringBuffer(100);
        this.m_ta = ta;
        this.m_size = this.m_ta.getText().length();
    }
}
