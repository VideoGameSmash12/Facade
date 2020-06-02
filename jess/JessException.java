package jess;

import java.io.Serializable;

public class JessException extends Exception implements Serializable
{
    private Throwable m_nextException;
    private int m_lineNumber;
    private String m_message;
    private String m_routine;
    private String m_data;
    private String m_programText;
    private StringBuffer m_context;
    
    public Throwable getNextException() {
        return this.m_nextException;
    }
    
    public Throwable getCause() {
        return this.m_nextException;
    }
    
    public void setNextException(final Throwable nextException) {
        this.m_nextException = nextException;
    }
    
    public int getLineNumber() {
        return this.m_lineNumber;
    }
    
    public void setLineNumber(final int lineNumber) {
        this.m_lineNumber = lineNumber;
    }
    
    public String getMessage() {
        return this.m_message;
    }
    
    public void setMessage(final String message) {
        this.m_message = message;
    }
    
    public String getRoutine() {
        return this.m_routine;
    }
    
    public void setRoutine(final String routine) {
        this.m_routine = routine;
    }
    
    public String getData() {
        return this.m_data;
    }
    
    public void setData(final String data) {
        this.m_data = data;
    }
    
    public String getProgramText() {
        return this.m_programText;
    }
    
    public void setProgramText(final String programText) {
        this.m_programText = programText;
    }
    
    public void addContext(final String s) {
        if (this.m_context == null) {
            this.m_context = new StringBuffer();
        }
        this.m_context.append("\n\twhile executing ");
        this.m_context.append(s);
    }
    
    public String getContext() {
        return this.m_context.toString();
    }
    
    public String toString() {
        final StringBuffer sb = new StringBuffer(100);
        sb.append("Jess reported an error in routine ");
        sb.append(this.m_routine);
        if (this.m_context != null) {
            sb.append(this.m_context);
        }
        sb.append(".\n");
        sb.append("  Message: ");
        sb.append(this.m_message);
        if (this.m_data != null) {
            sb.append(" ");
            sb.append(this.m_data);
        }
        sb.append(".");
        if (this.m_programText != null) {
            sb.append("\n  Program text: ");
            sb.append(this.m_programText);
            if (this.m_lineNumber != -1) {
                sb.append(" at line ");
                sb.append(this.m_lineNumber);
                sb.append(".");
            }
        }
        return sb.toString();
    }
    
    private final /* synthetic */ void this() {
        this.m_lineNumber = -1;
    }
    
    public JessException(final String routine, final String message, final String data) {
        this.this();
        this.m_routine = routine;
        this.m_message = message;
        this.m_data = data;
    }
    
    public JessException(final String s, final String s2, final int n) {
        this(s, s2, String.valueOf(n));
    }
    
    public JessException(final String routine, final String message, final Throwable nextException) {
        this.this();
        this.m_routine = routine;
        this.m_message = message;
        this.m_nextException = nextException;
    }
}
