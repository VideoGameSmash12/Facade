package jd;

import java.util.Vector;
import java.util.Iterator;
import java.io.Writer;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

public class CodeSequenceDescriptor extends NestableCodeDescriptor
{
    private List sequence;
    
    public void addToSequence(final NestableCodeDescriptor nestableCodeDescriptor) {
        this.sequence.add(nestableCodeDescriptor);
    }
    
    public void addToSequence(final NestableCodeDescriptor[] array) {
        for (int i = 0; i < array.length; ++i) {
            this.sequence.add(array[i]);
        }
    }
    
    public String toString(final int n) {
        final StringWriter stringWriter = new StringWriter(1024);
        final PrintWriter printWriter = new PrintWriter(stringWriter);
        for (final NestableCodeDescriptor nestableCodeDescriptor : this.sequence) {
            if (nestableCodeDescriptor.getClass().getName().equals("jd.CodeSequenceDescriptor")) {
                printWriter.println(nestableCodeDescriptor.toString(n));
            }
            else {
                printWriter.println(nestableCodeDescriptor.toString(n + 1));
            }
        }
        return stringWriter.toString();
    }
    
    private final /* synthetic */ void this() {
        this.sequence = new Vector(100);
    }
    
    public CodeSequenceDescriptor() {
        this.this();
    }
}
