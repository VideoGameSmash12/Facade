package jd;

import java.io.FileNotFoundException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.FileOutputStream;
import java.io.File;
import java.util.Collection;
import java.io.Writer;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ListIterator;
import java.util.Vector;
import java.util.LinkedList;

public class ClassDescriptor extends CodeBlockDescriptor
{
    public String packageName;
    private LinkedList imports;
    public String className;
    private LinkedList classModifiers;
    private LinkedList fieldMembers;
    private LinkedList methodMembers;
    private Vector staticBlocks;
    public String extendsClass;
    private LinkedList interfaces;
    private int nestLevel;
    
    public void addPackageImport(final String s) {
        this.imports.add(s);
    }
    
    public void addField(final FieldDescriptor fieldDescriptor) {
        this.fieldMembers.add(fieldDescriptor);
    }
    
    public void addField(final String[] array, final String fieldType, final String s, final String initializer) {
        final FieldDescriptor fieldDescriptor = new FieldDescriptor();
        fieldDescriptor.fieldType = fieldType;
        fieldDescriptor.addFieldName(s);
        fieldDescriptor.addFieldModifiers(array);
        fieldDescriptor.initializer = initializer;
        this.fieldMembers.add(fieldDescriptor);
    }
    
    public FieldDescriptor[] getFields() {
        final LinkedList list = new LinkedList<FieldDescriptor>();
        final ListIterator listIterator = this.fieldMembers.listIterator();
        while (listIterator.hasNext()) {
            final FieldDescriptor fieldDescriptor = listIterator.next();
            final String[] fieldNames = fieldDescriptor.getFieldNames();
            final String fieldType = fieldDescriptor.fieldType;
            final FieldDescriptor fieldDescriptor2 = new FieldDescriptor();
            for (int i = 0; i < fieldNames.length; ++i) {
                fieldDescriptor2.fieldType = fieldType;
                fieldDescriptor2.addFieldName(fieldNames[i]);
            }
            list.add(fieldDescriptor2);
        }
        final Object[] array = list.toArray();
        final FieldDescriptor[] array2 = new FieldDescriptor[array.length];
        System.arraycopy(array, 0, array2, 0, array.length);
        return array2;
    }
    
    public void addMethod(final MethodDescriptor methodDescriptor) {
        this.methodMembers.add(methodDescriptor);
    }
    
    public void addClassModifier(final String s) {
        this.classModifiers.add(s);
    }
    
    public void addInterface(final String s) {
        this.interfaces.add(s);
    }
    
    public void addStaticBlock(final CodeStringDescriptor codeStringDescriptor) {
        final CodeBlockDescriptor codeBlockDescriptor = new CodeBlockDescriptor();
        codeBlockDescriptor.setBlockHeader("static {");
        codeBlockDescriptor.addToBlockBody(codeStringDescriptor);
        codeBlockDescriptor.setBlockFooter("}");
        this.staticBlocks.add(codeBlockDescriptor);
    }
    
    public String toString(final int n) {
        final StringWriter stringWriter = new StringWriter();
        final PrintWriter printWriter = new PrintWriter(stringWriter);
        if (this.className == null) {
            throw new JavaDescriptorError("Attempt to call toString(int) on an instance of ClassDescriptor without a specified class name");
        }
        if (this.packageName != null) {
            printWriter.println("package " + this.packageName + ';');
            printWriter.println();
        }
        if (this.imports.size() != 0) {
            final ListIterator listIterator = this.imports.listIterator();
            while (listIterator.hasNext()) {
                printWriter.println("import " + listIterator.next() + ';');
            }
            printWriter.println();
        }
        stringWriter.write(JavaCodeDescriptor.delimitedList(this.classModifiers.toArray(), " "));
        if (this.classModifiers.size() != 0) {
            stringWriter.write(" ");
        }
        stringWriter.write("class " + this.className);
        if (this.extendsClass != null) {
            stringWriter.write(" extends " + this.extendsClass);
        }
        if (this.interfaces.size() != 0) {
            stringWriter.write(" implements " + JavaCodeDescriptor.delimitedList(this.interfaces.toArray(), ", "));
        }
        stringWriter.write(" {");
        this.blockHeader = stringWriter.toString();
        this.blockFooter = "}";
        this.blockBody.clear();
        this.blockBody.addAll(this.fieldMembers);
        this.blockBody.add(new BlanklineDescriptor());
        this.blockBody.addAll(this.staticBlocks);
        this.blockBody.add(new BlanklineDescriptor());
        this.blockBody.addAll(this.methodMembers);
        return super.toString(n);
    }
    
    public void setBlockHeader(final String s) {
        throw new JavaDescriptorError("setBlockHeader() should not be called on a ClassDescriptor.");
    }
    
    public void setBlockFooter(final String s) {
        throw new JavaDescriptorError("setBlockFooter() should not be called on a ClassDescriptor.");
    }
    
    public void addToBlockBody(final NestableCodeDescriptor nestableCodeDescriptor) {
        throw new JavaDescriptorError("addToBlockBody() should not be called on a ClassDescriptor.");
    }
    
    private final void writeToFileHelper(final File file, final String s) {
        try {
            final PrintStream printStream = new PrintStream(new FileOutputStream(new File(file, this.className + ".java")));
            printStream.print(s);
            printStream.close();
        }
        catch (IOException ex) {
            throw new JavaDescriptorError("Error writing " + this.className + ".java", ex);
        }
    }
    
    public boolean writeToFile(final File file) {
        final String string = this.toString();
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(file, this.className + ".java")));
        }
        catch (FileNotFoundException ex2) {
            this.writeToFileHelper(file, string);
            return true;
        }
        final StringBuffer sb = new StringBuffer(8000);
        try {
            for (int i = bufferedReader.read(); i != -1; i = bufferedReader.read()) {
                sb.append((char)i);
            }
            bufferedReader.close();
        }
        catch (IOException ex) {
            throw new JavaDescriptorError("Error reading " + this.className + ".java", ex);
        }
        if (!sb.toString().equals(string)) {
            this.writeToFileHelper(file, string);
            return true;
        }
        return false;
    }
    
    public void writeNestedClassToStream(final PrintStream printStream) {
        this.addClassModifier("static");
        printStream.print(this.toString());
    }
    
    private final /* synthetic */ void this() {
        this.imports = new LinkedList();
        this.classModifiers = new LinkedList();
        this.fieldMembers = new LinkedList();
        this.methodMembers = new LinkedList();
        this.staticBlocks = new Vector();
        this.interfaces = new LinkedList();
        this.nestLevel = 0;
    }
    
    public ClassDescriptor() {
        this.this();
    }
}
