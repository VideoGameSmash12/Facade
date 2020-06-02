package jess;

import java.io.OutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Writer;
import java.io.Reader;
import java.util.Hashtable;

class Routers
{
    private Hashtable m_outRouters;
    private Hashtable m_inRouters;
    private Hashtable m_inWrappers;
    private Hashtable m_inModes;
    
    synchronized void addInputRouter(final String s, final Reader reader, final boolean b) {
        Tokenizer tokenizer = this.m_inWrappers.get(reader);
        if (tokenizer == null) {
            tokenizer = new Tokenizer(reader);
        }
        this.m_inRouters.put(s, reader);
        this.m_inWrappers.put(reader, tokenizer);
        this.m_inModes.put(s, new Boolean(b));
    }
    
    synchronized void removeInputRouter(final String s) {
        this.m_inRouters.remove(s);
    }
    
    Reader getInputRouter(final String s) {
        return this.m_inRouters.get(s);
    }
    
    Tokenizer getInputWrapper(final Reader reader) {
        return this.m_inWrappers.get(reader);
    }
    
    boolean getInputMode(final String s) {
        return this.m_inModes.get(s);
    }
    
    synchronized void addOutputRouter(final String s, final Writer writer) {
        this.m_outRouters.put(s, writer);
    }
    
    synchronized void removeOutputRouter(final String s) {
        this.m_outRouters.remove(s);
    }
    
    Writer getOutputRouter(final String s) {
        return this.m_outRouters.get(s);
    }
    
    synchronized PrintWriter getErrStream() {
        final Writer outputRouter = this.getOutputRouter("WSTDERR");
        PrintWriter printWriter;
        if (outputRouter instanceof PrintWriter) {
            printWriter = (PrintWriter)outputRouter;
        }
        else {
            printWriter = new PrintWriter(outputRouter);
            this.addOutputRouter("WSTDERR", printWriter);
        }
        return printWriter;
    }
    
    synchronized PrintWriter getOutStream() {
        final Writer outputRouter = this.getOutputRouter("WSTDOUT");
        PrintWriter printWriter;
        if (outputRouter instanceof PrintWriter) {
            printWriter = (PrintWriter)outputRouter;
        }
        else {
            printWriter = new PrintWriter(outputRouter);
            this.addOutputRouter("WSTDOUT", printWriter);
        }
        return printWriter;
    }
    
    private final /* synthetic */ void this() {
        this.m_outRouters = new Hashtable(13);
        this.m_inRouters = new Hashtable(13);
        this.m_inWrappers = new Hashtable(13);
        this.m_inModes = new Hashtable(13);
    }
    
    Routers() {
        this.this();
        this.addInputRouter("t", new InputStreamReader(System.in), true);
        this.addOutputRouter("t", new PrintWriter(System.out, false));
        this.addInputRouter("WSTDIN", this.getInputRouter("t"), true);
        this.addOutputRouter("WSTDOUT", this.getOutputRouter("t"));
        this.addOutputRouter("WSTDERR", this.getOutputRouter("t"));
    }
}
