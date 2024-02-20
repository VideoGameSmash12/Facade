package dramaman.compiler;

import java.util.Collection;
import jd.MethodDescriptor;
import java.util.Vector;
import java.lang.reflect.Modifier;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.ListIterator;
import jd.ClassDescriptor;
import java.util.LinkedList;

public class ASTBeatTopLevel extends BeatParseNode implements MacroDefinitions
{
    private static final String[] importPackages;
    private static ASTBeatTopLevel beatTopLevel;
    String beatPackage;
    private LinkedList userImportPackages;
    private LinkedList userImportClasses;
    private LinkedList userConstantDeclarations;
    
    public void addUserImport(final String s) {
        if (s.endsWith("*")) {
            this.userImportPackages.add(s.substring(0, s.length() - 2));
        }
        else {
            this.userImportClasses.add(s);
        }
    }
    
    public void addUserImports(final ClassDescriptor classDescriptor) {
        final ListIterator listIterator = this.userImportPackages.listIterator();
        while (listIterator.hasNext()) {
            classDescriptor.addPackageImport(listIterator.next() + ".*");
        }
        final ListIterator listIterator2 = this.userImportClasses.listIterator();
        while (listIterator2.hasNext()) {
            classDescriptor.addPackageImport(listIterator2.next());
        }
    }
    
    public Iterator getUserImportPackages() {
        return this.userImportPackages.listIterator();
    }
    
    public Iterator getUserImportClasses() {
        return this.userImportClasses.listIterator();
    }
    
    public void addUserConstants(final String s) {
        this.userConstantDeclarations.add(s);
    }
    
    public void addUserConstantDeclarations(final ClassDescriptor classDescriptor) {
        final ListIterator listIterator = this.userConstantDeclarations.listIterator();
        while (listIterator.hasNext()) {
            classDescriptor.addInterface(listIterator.next());
        }
    }
    
    public Field getDeclaredConstant(final String s) throws CompileException {
        final ListIterator listIterator = this.userConstantDeclarations.listIterator();
        while (listIterator.hasNext()) {
            final String s2 = listIterator.next();
            try {
                final Class<?> forName = Class.forName(s2);
                if (!Modifier.isInterface(forName.getModifiers())) {
                    throw new CompileException("Expected " + s2 + " to be an interface declaring constants.");
                }
                try {
                    final Field declaredField = forName.getDeclaredField(s);
                    if (!Modifier.isFinal(declaredField.getModifiers())) {
                        throw new CompileException("Expected " + s + " in interface " + s2 + " to be final.");
                    }
                    return declaredField;
                }
                catch (SecurityException ex) {
                    throw new CompileException("Security exception accessing " + s + " in interface " + s2);
                }
                catch (NoSuchFieldException ex2) {}
            }
            catch (ClassNotFoundException ex3) {
                throw new CompileException("Unable to find interface " + s2);
            }
        }
        return null;
    }
    
    public static ASTBeatTopLevel getBeatTopLevel() {
        return ASTBeatTopLevel.beatTopLevel;
    }
    
    BeatScopeMaintainer getEnclosingScope() {
        return null;
    }
    
    public void compileToJava() throws CompileException {
        final ClassDescriptor classDescriptor = new ClassDescriptor();
        final ClassDescriptor classDescriptor2 = new ClassDescriptor();
        final ClassDescriptor classDescriptor3 = new ClassDescriptor();
        classDescriptor.className = "BeatTests";
        classDescriptor.packageName = this.beatPackage;
        classDescriptor.addClassModifier("public");
        classDescriptor2.className = "BeatFactories";
        classDescriptor2.packageName = this.beatPackage;
        classDescriptor2.addClassModifier("public");
        classDescriptor3.className = "BeatActions";
        classDescriptor3.packageName = this.beatPackage;
        classDescriptor3.addClassModifier("public");
        for (int i = 0; i < ASTBeatTopLevel.importPackages.length; ++i) {
            classDescriptor.addPackageImport(ASTBeatTopLevel.importPackages[i]);
        }
        this.addUserImports(classDescriptor);
        this.addUserConstantDeclarations(classDescriptor);
        for (int j = 0; j < ASTBeatTopLevel.importPackages.length; ++j) {
            classDescriptor2.addPackageImport(ASTBeatTopLevel.importPackages[j]);
        }
        this.addUserImports(classDescriptor2);
        this.addUserConstantDeclarations(classDescriptor2);
        for (int k = 0; k < ASTBeatTopLevel.importPackages.length; ++k) {
            classDescriptor3.addPackageImport(ASTBeatTopLevel.importPackages[k]);
        }
        this.addUserImports(classDescriptor3);
        this.addUserConstantDeclarations(classDescriptor3);
        final Vector<MethodDescriptor> vector = new Vector<MethodDescriptor>();
        final Vector<MethodDescriptor> vector2 = new Vector<MethodDescriptor>();
        final Vector<MethodDescriptor> vector3 = new Vector<MethodDescriptor>();
        for (int l = 0; l < this.jjtGetNumChildren(); ++l) {
            final BeatParseNode beatParseNode = (BeatParseNode)this.jjtGetChild(l);
            if (BeatParserTreeConstants.jjtNodeName[beatParseNode.id].equals("BeatDefinition")) {
                vector2.add(((ASTBeatDefinition)beatParseNode).compileFactory());
                vector.addAll(((ASTBeatDefinition)beatParseNode).compileTestsToJava());
                vector3.addAll(((ASTBeatDefinition)beatParseNode).compileActionsToJava());
            }
        }
        final Iterator<MethodDescriptor> iterator = vector.iterator();
        while (iterator.hasNext()) {
            classDescriptor.addMethod(iterator.next());
        }
        final Iterator<MethodDescriptor> iterator2 = vector2.iterator();
        while (iterator2.hasNext()) {
            classDescriptor2.addMethod(iterator2.next());
        }
        final Iterator<MethodDescriptor> iterator3 = vector3.iterator();
        while (iterator3.hasNext()) {
            classDescriptor3.addMethod(iterator3.next());
        }
        classDescriptor.writeToFile(Beat.objectDirectory);
        classDescriptor2.writeToFile(Beat.objectDirectory);
        classDescriptor3.writeToFile(Beat.objectDirectory);
    }
    
    private final /* synthetic */ void this() {
        this.beatPackage = null;
        this.userImportPackages = new LinkedList();
        this.userImportClasses = new LinkedList();
        this.userConstantDeclarations = new LinkedList();
    }
    
    public ASTBeatTopLevel(final int n) {
        super(n);
        this.this();
        ASTBeatTopLevel.beatTopLevel = this;
    }
    
    public ASTBeatTopLevel(final BeatParser beatParser, final int n) {
        super(beatParser, n);
        this.this();
        ASTBeatTopLevel.beatTopLevel = this;
    }
    
    static {
        importPackages = new String[] { "dramaman.runtime.*", "wm.WME", "java.util.*", "scope.*" };
    }
}
