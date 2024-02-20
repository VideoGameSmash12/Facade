package jd;

import java.util.ListIterator;
import java.io.Writer;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.LinkedList;

public class CodeBlockDescriptor extends NestableCodeDescriptor
{
    protected String blockHeader;
    protected String blockFooter;
    protected LinkedList blockBody;
    
    public void setBlockHeader(final String blockHeader) {
        this.blockHeader = blockHeader;
    }
    
    public void setBlockFooter(final String blockFooter) {
        this.blockFooter = blockFooter;
    }
    
    public void addToBlockBody(final NestableCodeDescriptor nestableCodeDescriptor) {
        this.blockBody.add(nestableCodeDescriptor);
    }
    
    public void addToBlockBody(final NestableCodeDescriptor[] array) {
        for (int i = 0; i < array.length; ++i) {
            this.blockBody.add(array[i]);
        }
    }
    
    public String toString(final int n) {
        final StringWriter stringWriter = new StringWriter(1024);
        final PrintWriter printWriter = new PrintWriter(stringWriter);
        if (this.blockHeader != null) {
            printWriter.print(NestableCodeDescriptor.leadingTabs(n));
            printWriter.println(this.blockHeader);
        }
        final ListIterator listIterator = this.blockBody.listIterator();
        while (listIterator.hasNext()) {
            final NestableCodeDescriptor nestableCodeDescriptor = listIterator.next();
            if (nestableCodeDescriptor.getClass().getName().equals("jd.CodeSequenceDescriptor")) {
                printWriter.println(nestableCodeDescriptor.toString(n));
            }
            else {
                printWriter.println(nestableCodeDescriptor.toString(n + 1));
            }
        }
        if (this.blockFooter != null) {
            printWriter.print(NestableCodeDescriptor.leadingTabs(n));
            printWriter.println(this.blockFooter);
        }
        return stringWriter.toString();
    }
    
    private final /* synthetic */ void this() {
        this.blockBody = new LinkedList();
    }
    
    public CodeBlockDescriptor() {
        this.this();
        this.blockHeader = null;
        this.blockFooter = null;
    }
    
    public CodeBlockDescriptor(final String blockHeader, final String blockFooter) {
        this.this();
        this.blockHeader = blockHeader;
        this.blockFooter = blockFooter;
    }
}
