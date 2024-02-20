package jd;

import java.io.IOException;
import java.io.Writer;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.StringReader;

public class CodeStringDescriptor extends NestableCodeDescriptor
{
    protected String codeString;
    
    public void setCodeString(final String codeString) {
        this.codeString = codeString;
    }
    
    public String toString(final int n) {
        final BufferedReader bufferedReader = new BufferedReader(new StringReader(this.codeString));
        final StringWriter stringWriter = new StringWriter();
        final PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            for (String s = bufferedReader.readLine(); s != null; s = bufferedReader.readLine()) {
                printWriter.println(NestableCodeDescriptor.leadingTabs(n) + s);
            }
        }
        catch (IOException ex) {
            throw new JavaDescriptorError("IO error during CodeStringDescriptor.toString(int): ", ex);
        }
        return stringWriter.getBuffer().substring(0, stringWriter.getBuffer().length() - System.getProperty("line.separator").length());
    }
    
    public CodeStringDescriptor() {
        this.codeString = null;
    }
    
    public CodeStringDescriptor(final String codeString) {
        this.codeString = codeString;
    }
}
