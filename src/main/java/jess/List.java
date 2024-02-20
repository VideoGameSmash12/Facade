package jess;

import java.util.ArrayList;

class List
{
    private String m_head;
    private String m_indent;
    private ArrayList m_data;
    private char m_open;
    private char m_close;
    
    public void setDelimiters(final char open, final char close) {
        this.m_open = open;
        this.m_close = close;
    }
    
    public List add(final Object o) {
        this.m_data.add(o);
        return this;
    }
    
    public List addQuoted(final String s) {
        this.add("\"" + s + '\"');
        return this;
    }
    
    public void indent(final String indent) {
        this.m_indent = indent;
    }
    
    public void newLine() {
        this.add("\n" + this.m_indent);
    }
    
    public StringBuffer toStringBuffer() {
        final StringBuffer sb = new StringBuffer(this.m_data.size() * 6);
        sb.append(this.m_open);
        sb.append(this.m_head);
        for (int i = 0; i < this.m_data.size(); ++i) {
            if (sb.length() > 1) {
                sb.append(' ');
            }
            sb.append(this.m_data.get(i));
        }
        sb.append(this.m_close);
        return sb;
    }
    
    public String toString() {
        return this.toStringBuffer().toString();
    }
    
    public List(final String head) {
        this.m_indent = "";
        this.m_data = new ArrayList();
        this.m_open = '(';
        this.m_close = ')';
        this.m_head = head;
    }
    
    public List() {
        this("");
    }
    
    public List(final String s, final Object o) {
        this(s);
        this.add(o);
    }
    
    public List(final Value value, final Object o) throws JessException {
        this(value.stringValue(null));
        this.add(o);
    }
}
