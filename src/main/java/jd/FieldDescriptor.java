package jd;

import java.util.LinkedList;

public class FieldDescriptor extends CodeStringDescriptor
{
    public String fieldType;
    private LinkedList fieldNames;
    private LinkedList fieldModifiers;
    public String initializer;
    
    public void addFieldModifier(final String s) {
        this.fieldModifiers.add(s.intern());
    }
    
    public void addFieldModifiers(final String[] array) {
        for (int i = 0; i < array.length; ++i) {
            this.addFieldModifier(array[i].intern());
        }
    }
    
    public void addFieldName(final String s) {
        this.fieldNames.add(s.intern());
    }
    
    public String[] getFieldNames() {
        final Object[] array = this.fieldNames.toArray();
        final String[] array2 = new String[array.length];
        System.arraycopy(array, 0, array2, 0, array.length);
        return array2;
    }
    
    public int hashCode() {
        int hashCode = this.fieldType.hashCode();
        for (int i = 0; i < this.fieldNames.size(); ++i) {
            hashCode += this.fieldNames.get(i).hashCode();
        }
        return hashCode;
    }
    
    public boolean equals(final Object o) {
        if (o.getClass() != this.getClass()) {
            return false;
        }
        final FieldDescriptor fieldDescriptor = (FieldDescriptor)o;
        if (fieldDescriptor.fieldType != this.fieldType) {
            return false;
        }
        final String[] fieldNames = fieldDescriptor.getFieldNames();
        if (fieldNames.length != this.fieldNames.size()) {
            return false;
        }
        for (int i = 0; i < fieldNames.length; ++i) {
            int n;
            for (n = 0; n < this.fieldNames.size() && fieldNames[i] != this.fieldNames.get(n); ++n) {}
            if (n >= this.fieldNames.size()) {
                return false;
            }
        }
        return true;
    }
    
    public String toString(final int n) {
        this.codeString = this.fieldDeclarationString();
        return super.toString(n);
    }
    
    protected String fieldDeclarationString() {
        final StringBuffer sb = new StringBuffer();
        sb.append(JavaCodeDescriptor.delimitedList(this.fieldModifiers.toArray(), " "));
        if (this.fieldModifiers.size() != 0) {
            sb.append(" ");
        }
        sb.append(this.fieldType + ' ');
        sb.append(JavaCodeDescriptor.delimitedList(this.fieldNames.toArray(), ", "));
        if (this.initializer != null) {
            sb.append(" = " + this.initializer);
        }
        sb.append(";");
        return sb.toString();
    }
    
    public void setCodeString(final String s) {
        throw new JavaDescriptorError("setCodeString() should not be called on a FieldDescriptor.");
    }
    
    private final /* synthetic */ void this() {
        this.fieldNames = new LinkedList();
        this.fieldModifiers = new LinkedList();
    }
    
    public FieldDescriptor() {
        this.this();
        this.fieldType = null;
        this.initializer = null;
    }
}
