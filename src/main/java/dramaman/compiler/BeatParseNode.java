package dramaman.compiler;

import java.util.Iterator;

abstract class BeatParseNode extends SimpleNode implements BeatParserConstants
{
    protected static final String QUOTE = "\"";
    public Token firstToken;
    public Token lastToken;
    private static final /* synthetic */ boolean $noassert;
    
    public int getFirstLineNumber() {
        return this.firstToken.beginLine;
    }
    
    public int getLastLineNumber() {
        return this.lastToken.endLine;
    }
    
    public int getFirstColumn() {
        return this.firstToken.beginColumn;
    }
    
    public int getLastColumn() {
        return this.lastToken.endColumn;
    }
    
    public String prettyPrintTokens() {
        final StringBuffer sb = new StringBuffer();
        Token token;
        for (token = this.firstToken; token != this.lastToken; token = token.next) {
            if (token.next.image != ";" && token.next.image != "." && token.next.image != "(" && token.next.image != ")" && token.image != "." && token.image != "(") {
                sb.append(token.image + ' ');
            }
            else {
                sb.append(token.image);
            }
        }
        sb.append(token.image);
        return sb.toString();
    }
    
    public String dumpTokens() {
        final StringBuffer sb = new StringBuffer();
        Token token;
        for (token = this.firstToken; token != this.lastToken; token = token.next) {
            sb.append(token.image);
        }
        sb.append(token.image);
        return sb.toString();
    }
    
    public int numberOfTokens() {
        int n = 0;
        for (Token token = this.firstToken; token != this.lastToken; token = token.next) {
            ++n;
        }
        return ++n;
    }
    
    public String dumpTokens(final int n, final int n2) {
        final StringBuffer sb = new StringBuffer();
        int i = 0;
        if (!BeatParseNode.$noassert && n2 > this.numberOfTokens()) {
            throw new AssertionError();
        }
        if (!BeatParseNode.$noassert && n2 < 1) {
            throw new AssertionError();
        }
        if (!BeatParseNode.$noassert && n < 0) {
            throw new AssertionError();
        }
        if (!BeatParseNode.$noassert && n >= n2) {
            throw new AssertionError();
        }
        Token token;
        for (token = this.firstToken; i != n; ++i, token = token.next) {}
        while (i < n2) {
            sb.append(token.image);
            token = token.next;
            ++i;
        }
        return sb.toString();
    }
    
    public static String uppercaseFirstCharacter(final String s) {
        final StringBuffer sb = new StringBuffer(s);
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        return sb.toString();
    }
    
    protected static String stripQuotes(final String s) {
        return s.substring(1, s.length() - 1);
    }
    
    public static boolean primitiveType(final String s) {
        return s == "int" || s == "float" || s == "char" || s == "boolean" || s == "long" || s == "short" || s == "byte" || s == "double";
    }
    
    protected Class getClass(final String s) throws ClassNotFoundException {
        try {
            return Class.forName(ASTBeatTopLevel.getBeatTopLevel().beatPackage + '.' + s);
        }
        catch (ClassNotFoundException ex) {
            final Iterator userImportPackages = ASTBeatTopLevel.getBeatTopLevel().getUserImportPackages();
            while (userImportPackages.hasNext()) {
                try {
                    return Class.forName(userImportPackages.next() + '.' + s);
                }
                catch (ClassNotFoundException ex2) {}
            }
            final Iterator userImportClasses = ASTBeatTopLevel.getBeatTopLevel().getUserImportClasses();
            while (userImportClasses.hasNext()) {
                final String s2 = userImportClasses.next();
                if (s.equals(s2.substring(s2.lastIndexOf(46) + 1, s2.length()))) {
                    return Class.forName(s2);
                }
            }
            throw new ClassNotFoundException(s);
        }
    }
    
    protected Class getFieldType(final String s, final String s2) throws ClassNotFoundException, NoSuchFieldException {
        return this.getClass(s).getField(s2).getType();
    }
    
    protected Class getWMEFieldType(final String s, final String s2) throws ClassNotFoundException, NoSuchMethodException {
        return this.getClass(s).getMethod("get" + uppercaseFirstCharacter(s2), (Class[])null).getReturnType();
    }
    
    BeatScopeMaintainer getEnclosingBeatScope() {
        throw new CompileError("getEnclosingBeatScope() called on a parse node which never appears in a subtree rooted at an ASTBeatDefinition");
    }
    
    BeatScopeMaintainer getEnclosingScope() {
        throw new CompileError("getEnclosingScope() called on BeatParseNode");
    }
    
    public BeatParseNode(final int n) {
        super(n);
    }
    
    public BeatParseNode(final BeatParser beatParser, final int n) {
        super(beatParser, n);
    }
    
    static {
        $noassert = (Class.forName("[Ldramaman.compiler.BeatParseNode;").getComponentType().desiredAssertionStatus() ^ true);
    }
}
