package jess;

import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

public class Main
{
    private Rete m_rete;
    private Reader m_fis;
    private Jesp m_j;
    private boolean m_readStdin;
    private boolean m_exitOnError;
    
    public static void main(final String[] array) {
        final Main main = new Main();
        main.initialize(array, new Rete());
        main.execute(true);
    }
    
    public void showLogo() {
        if (this.m_rete != null && this.m_rete.getOutStream() != null) {
            this.m_rete.getOutStream().println("\nJess, the Java Expert System Shell");
            this.m_rete.getOutStream().println("Copyright (C) 2001 E.J. Friedman Hill and the Sandia Corporation");
            try {
                this.m_rete.executeCommand("(printout t (jess-version-string) crlf crlf)");
            }
            catch (JessException ex) {}
        }
    }
    
    public Main initialize(final String[] array, final Rete rete) {
        this.m_rete = rete;
        int n = 0;
        boolean b = true;
        if (array.length > 0) {
            while (n < array.length && array[n].startsWith("-")) {
                if (array[n].equals("-nologo")) {
                    b = false;
                }
                else if (array[n].equals("-exit")) {
                    this.m_exitOnError = true;
                }
                ++n;
            }
        }
        if (b) {
            this.showLogo();
        }
        this.m_fis = this.m_rete.getInputRouter("t");
        final String s = (array.length <= n) ? null : array[n];
        try {
            if (s != null) {
                if (this.m_rete.getApplet() == null) {
                    this.m_fis = new BufferedReader(new FileReader(s));
                }
                else {
                    this.m_fis = new BufferedReader(new InputStreamReader(new URL(this.m_rete.getApplet().getDocumentBase(), s).openStream()));
                }
                this.m_readStdin = false;
            }
        }
        catch (IOException ex) {
            this.m_rete.getErrStream().println("File not found or cannot open file:" + ex.getMessage());
            this.m_rete.getErrStream().flush();
            System.exit(0);
        }
        return this;
    }
    
    public void execute(final boolean b) {
        if (this.m_fis != null) {
            while (true) {
                this.m_j = new Jesp(this.m_fis, this.m_rete);
                while (true) {
                    try {
                        final Jesp j = this.m_j;
                        boolean b2 = false;
                        if (b && this.m_readStdin) {
                            b2 = true;
                        }
                        j.parse(b2);
                    }
                    catch (JessException ex) {
                        final PrintWriter errStream = this.m_rete.getErrStream();
                        if (ex.getCause() != null) {
                            errStream.write(ex.toString());
                            errStream.write("\nNested exception is:\n");
                            errStream.println(ex.getCause().getMessage());
                            ex.getCause().printStackTrace(errStream);
                        }
                        else {
                            ex.printStackTrace(errStream);
                        }
                        if (this.m_exitOnError) {
                            this.m_rete.getErrStream().flush();
                            this.m_rete.getOutStream().flush();
                            System.exit(-1);
                        }
                    }
                    catch (Exception ex2) {
                        this.m_rete.getErrStream().println("Unexpected exception:");
                        ex2.printStackTrace(this.m_rete.getErrStream());
                        if (this.m_exitOnError) {
                            this.m_rete.getErrStream().flush();
                            this.m_rete.getOutStream().flush();
                            System.exit(-1);
                        }
                    }
                    finally {
                        this.m_rete.getErrStream().flush();
                        this.m_rete.getOutStream().flush();
                    }
                    this.m_rete.getErrStream().flush();
                    this.m_rete.getOutStream().flush();
                    if (!this.m_readStdin) {
                        break;
                    }
                    continue;
                }
            }
        }
        this.m_readStdin = true;
        this.m_fis = this.m_rete.getInputRouter("t");
    }
    
    private final /* synthetic */ void this() {
        this.m_readStdin = true;
        this.m_exitOnError = false;
    }
    
    public Main() {
        this.this();
    }
}
