package jd;

import java.util.Vector;
import java.util.ListIterator;
import java.util.LinkedList;
import java.io.StringWriter;
import java.util.Hashtable;
import java.util.List;

public class MethodArglistDescriptor extends JavaCodeDescriptor
{
    private List methodArgs;
    private Hashtable argIndexTable;
    private int argIndexCounter;
    
    public void addArgument(final MethodArgDescriptor methodArgDescriptor) {
        this.methodArgs.add(methodArgDescriptor);
        this.argIndexTable.put(methodArgDescriptor.argName, new Integer(this.argIndexCounter++));
    }
    
    public Object[] getArguments() {
        return this.methodArgs.toArray();
    }
    
    public String toString() {
        final StringWriter stringWriter = new StringWriter();
        stringWriter.write("(");
        final LinkedList list = new LinkedList<String>();
        final ListIterator<MethodArgDescriptor> listIterator = this.methodArgs.listIterator();
        while (listIterator.hasNext()) {
            list.add(listIterator.next().toString());
        }
        stringWriter.write(JavaCodeDescriptor.delimitedList(list.toArray(), ", "));
        stringWriter.write(")");
        return stringWriter.toString();
    }
    
    public int getArgIndex(final String s) {
        final Integer n = this.argIndexTable.get(s);
        if (n == null) {
            throw new Error("Unknown argument name " + s);
        }
        return n;
    }
    
    private final /* synthetic */ void this() {
        this.methodArgs = new Vector();
        this.argIndexTable = new Hashtable();
        this.argIndexCounter = 0;
    }
    
    public MethodArglistDescriptor() {
        this.this();
    }
}
