package jess;

import java.util.Stack;
import java.io.Serializable;

class JessTokenStream implements Serializable
{
    private Stack m_stack;
    private Tokenizer m_stream;
    private int m_lineno;
    private StringBuffer m_string;
    
    int lineno() {
        return this.m_lineno;
    }
    
    void prepareSexp() throws JessException {
        int i = 0;
        this.m_string.setLength(0);
        final Stack stack = new Stack<JessToken>();
        do {
            final JessToken nextToken = this.m_stream.nextToken();
            stack.push(nextToken);
            if (nextToken.m_ttype == 0) {
                break;
            }
            if (nextToken.m_ttype == 41) {
                --i;
            }
            else {
                if (nextToken.m_ttype != 40) {
                    continue;
                }
                ++i;
            }
        } while (i > 0);
        while (!stack.empty()) {
            this.m_stack.push(stack.pop());
        }
    }
    
    JessToken nextToken() throws JessException {
        if (this.m_stack.empty()) {
            this.prepareSexp();
        }
        final JessToken jessToken = this.m_stack.pop();
        this.m_string.append(jessToken.toString());
        this.m_string.append(" ");
        this.m_lineno = jessToken.m_lineno;
        return jessToken;
    }
    
    void pushBack(final JessToken jessToken) {
        this.m_lineno = jessToken.m_lineno;
        this.m_stack.push(jessToken);
        this.m_string.setLength(this.m_string.length() - (jessToken.toString().length() + 1));
    }
    
    String head() throws JessException {
        if (this.m_stack.empty()) {
            this.prepareSexp();
        }
        final JessToken jessToken = this.m_stack.pop();
        if (jessToken.m_ttype != 40 || this.m_stack.empty()) {
            return null;
        }
        final JessToken jessToken2 = this.m_stack.peek();
        this.m_stack.push(jessToken);
        if (jessToken2.m_ttype != 1) {
            if (jessToken2.m_ttype == 45) {
                return "-";
            }
            if (jessToken2.m_ttype == 61) {
                return "=";
            }
            if (jessToken2.m_ttype == 8) {
                return jessToken2.m_sval;
            }
            return jessToken2.toString();
        }
        else {
            if (jessToken2.m_sval != null) {
                return jessToken2.m_sval;
            }
            return jessToken2.toString();
        }
    }
    
    void clear() {
        this.m_stack = new Stack();
        this.m_string.setLength(0);
    }
    
    public String toString() {
        return this.m_string.toString();
    }
    
    private final /* synthetic */ void this() {
        this.m_string = new StringBuffer();
    }
    
    JessTokenStream(final Tokenizer stream) {
        this.this();
        this.m_stream = stream;
        this.m_stack = new Stack();
    }
}
