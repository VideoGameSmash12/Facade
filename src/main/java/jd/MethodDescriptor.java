package jd;

import java.util.ListIterator;
import java.io.StringWriter;
import java.util.HashSet;
import java.util.LinkedList;

public class MethodDescriptor extends CodeBlockDescriptor
{
    private LinkedList methodModifiers;
    private MethodArglistDescriptor methodArguments;
    private HashSet localVarNames;
    public String methodName;
    
    public void addModifier(final String s) {
        this.methodModifiers.add(s);
    }
    
    public void addArgument(final MethodArgDescriptor methodArgDescriptor) {
        this.methodArguments.addArgument(methodArgDescriptor);
    }
    
    public void addArgument(final String argType, final String argName) {
        final MethodArgDescriptor methodArgDescriptor = new MethodArgDescriptor();
        methodArgDescriptor.argType = argType;
        methodArgDescriptor.argName = argName;
        this.methodArguments.addArgument(methodArgDescriptor);
    }
    
    public void addLocalVariableDecl(final FieldDescriptor fieldDescriptor) {
        this.addToBlockBody(fieldDescriptor);
        final String[] fieldNames = fieldDescriptor.getFieldNames();
        for (int i = 0; i < fieldNames.length; ++i) {
            if (this.localVarNames.contains(fieldNames[i])) {
                throw new JavaDescriptorError("Variable " + fieldNames[i] + " multiply defined in MethodDescriptor " + this.methodName);
            }
            this.localVarNames.add(fieldNames[i]);
        }
    }
    
    public String toString(final int n) {
        this.blockHeader = this.methodSignatureString() + " {";
        this.blockFooter = "}";
        return super.toString(n);
    }
    
    protected String methodSignatureString() {
        final StringWriter stringWriter = new StringWriter();
        final ListIterator listIterator = this.methodModifiers.listIterator();
        while (listIterator.hasNext()) {
            stringWriter.write(listIterator.next() + ' ');
        }
        stringWriter.write(this.methodName);
        stringWriter.write(this.methodArguments.toString());
        return stringWriter.toString();
    }
    
    public void setBlockHeader(final String s) {
        throw new JavaDescriptorError("setBlockHeader() should not be called on a MethodDescriptor.");
    }
    
    public void setBlockFooter(final String s) {
        throw new JavaDescriptorError("setBlockFooter() should not be called on a MethodDescriptor.");
    }
    
    private final /* synthetic */ void this() {
        this.methodModifiers = new LinkedList();
        this.methodArguments = new MethodArglistDescriptor();
        this.localVarNames = new HashSet();
    }
    
    public MethodDescriptor() {
        this.this();
    }
}
