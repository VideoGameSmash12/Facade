package TemplateCompiler;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.Iterator;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Vector;
import java.io.StringWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.util.Arrays;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.util.Enumeration;
import java.math.BigInteger;
import java.util.Hashtable;

class ASTJessRule extends SimpleNode
{
    protected static Hashtable tableOfConsts;
    private static BigInteger ruleID;
    private static final BigInteger inc1;
    private static Hashtable idTable;
    protected String patternHead;
    protected String ruleName;
    private static final /* synthetic */ boolean $noassert;
    
    int getFirstLineNumber() {
        return this.firstToken.endLine - 1;
    }
    
    String dumpTokens() {
        final StringBuffer sb = new StringBuffer();
        Token token;
        for (token = this.firstToken; token != this.lastToken; token = token.next) {
            sb.append(token.image);
            sb.append(" ");
        }
        sb.append(token.image);
        return sb.toString();
    }
    
    public String toString() {
        return NLUTreeConstants.jjtNodeName[this.id];
    }
    
    public void dump(final String s) {
        System.out.println(s + this.toString() + ": " + this.dumpTokens() + '\n');
        if (this.children != null) {
            for (int i = 0; i < this.children.length; ++i) {
                final ASTJessRule astJessRule = (ASTJessRule)this.children[i];
                if (astJessRule != null) {
                    astJessRule.dump(s + '-');
                }
            }
        }
    }
    
    protected String getID(final String s) {
        final String s2 = ASTJessRule.idTable.get(s);
        if (s2 == null) {
            final String string = ASTJessRule.ruleID.toString();
            ASTJessRule.ruleID = ASTJessRule.ruleID.add(ASTJessRule.inc1);
            ASTJessRule.idTable.put(s, string);
            return string;
        }
        return s2;
    }
    
    protected String getID() {
        final String string = ASTJessRule.ruleID.toString();
        ASTJessRule.ruleID = ASTJessRule.ruleID.add(ASTJessRule.inc1);
        return string;
    }
    
    static String[] getIDKeys() {
        final String[] array = new String[ASTJessRule.idTable.size()];
        int n = 0;
        final Enumeration<String> keys = ASTJessRule.idTable.keys();
        while (keys.hasMoreElements()) {
            array[n++] = keys.nextElement();
        }
        return array;
    }
    
    static void printIDKeysToFile(final String s) {
        try {
            final PrintWriter printWriter = new PrintWriter(new FileOutputStream(s));
            final String[] idKeys = getIDKeys();
            Arrays.sort(idKeys);
            for (int i = 0; i < idKeys.length; ++i) {
                printWriter.println(idKeys[i]);
            }
            printWriter.close();
        }
        catch (Exception ex) {
            throw new Error(ex);
        }
    }
    
    void compileToJess(final BufferedWriter bufferedWriter) throws IOException, CompileException {
        if (!ASTJessRule.$noassert) {
            throw new AssertionError((Object)"Don't call compileToJess() on ASTJessRule");
        }
    }
    
    void prepareRetraction(final BufferedWriter bufferedWriter) throws IOException {
        if (this.children != null) {
            for (int i = 0; i < this.children.length; ++i) {
                final ASTJessRule astJessRule = (ASTJessRule)this.children[i];
                if (astJessRule != null) {
                    astJessRule.prepareRetraction(bufferedWriter);
                    final String patternHead = ((PatternProducingNode)astJessRule).getPatternHead();
                    if (!this.toString().equals("Template") && patternHead != null && !patternHead.equals("_OBSOLETE")) {
                        bufferedWriter.write("(undefinerule " + patternHead + ")\n");
                    }
                }
            }
        }
    }
    
    int handleDeclare(final BufferedWriter bufferedWriter) throws IOException, CompileException {
        int n = 0;
        ASTJessRule astJessRule = (ASTJessRule)this.children[n];
        final String image = this.firstToken.next.next.image;
        while (astJessRule.toString().equals("Declare")) {
            final ASTDeclare astDeclare = (ASTDeclare)astJessRule;
            astDeclare.setName(image);
            astDeclare.compileToJess(bufferedWriter);
            final int salience = astDeclare.getSalience();
            if (salience != -255) {
                NLU.salience = salience;
            }
            ++n;
            astJessRule = (ASTJessRule)this.children[n];
        }
        return n;
    }
    
    void compileToJessRule(final String s, final String s2, final BufferedWriter bufferedWriter, final int n) throws IOException, CompileException {
        final StringWriter stringWriter = new StringWriter();
        final String image = this.firstToken.next.next.image;
        int i = n;
        bufferedWriter.write("(defrule " + image + " (declare (salience " + NLU.salience + ")) ");
        int n2 = 0;
        stringWriter.write(s);
        while (i < this.children.length) {
            final ASTJessRule astJessRule = (ASTJessRule)this.children[i];
            if (astJessRule != null) {
                if (!astJessRule.toString().equals("Start")) {
                    if (astJessRule.toString().equals("RHside")) {
                        if (n2 == 0) {
                            stringWriter.write("\n => ");
                            stringWriter.write(s2);
                            n2 = 1;
                        }
                        ((ASTRHside)this.children[i]).compileToJess(stringWriter);
                    }
                    else {
                        ((ASTLHside)this.children[i]).compileToJess(stringWriter);
                    }
                }
            }
            ++i;
        }
        bufferedWriter.write(stringWriter.getBuffer().toString() + " )\n\n");
        if (NLU.generateRuleRetractionRules) {
            bufferedWriter.write("(defrule retract" + image + " (RETRACT" + image + ") => \n");
            this.prepareRetraction(bufferedWriter);
            bufferedWriter.write("(undefrule " + image + ")\n(undefrule retract" + image + "))\n\n");
        }
    }
    
    boolean isRegexp() {
        return false;
    }
    
    protected int getNumberOfArgumentsForDeclaredFact(final String s) {
        final Vector vector = ASTJessRule.tableOfConsts.get(s);
        if (vector == null) {
            return -1;
        }
        return vector.size();
    }
    
    protected boolean isDeclaredFact(final String s) {
        return ASTJessRule.tableOfConsts.get(s) != null;
    }
    
    void typeCheck(final HashSet set) throws CompileException {
        final Token next = this.firstToken.next;
        final String image = next.image;
        int n = 0;
        final Object o = new Object();
        final String s = new String();
        Token token = next.next;
        if (ASTJessRule.tableOfConsts.containsKey(image)) {
            final Vector<Object> vector = ASTJessRule.tableOfConsts.get(image);
            if (vector.size() == 0) {
                return;
            }
            int n2 = 0;
            while (token != this.lastToken) {
                final String image2 = token.image;
                Vector<String> value;
                try {
                    value = vector.get(n2);
                }
                catch (ArrayIndexOutOfBoundsException ex) {
                    throw new CompileException(this.getFirstLineNumber(), "The type definition of " + image + " did not match against the excessive argument " + image2);
                }
                if (value.getClass().getName().equals("java.lang.String")) {
                    final String s2 = (String)value;
                    if (!s2.equals("*")) {
                        if (!image2.startsWith("?") && this.finder(set, s2, image2) == 1) {
                            throw new CompileException(this.getFirstLineNumber(), "Constant not found " + image2 + ". ");
                        }
                    }
                    else if (image2.equals("(")) {
                        while (!token.image.equals(")")) {
                            token = token.next;
                        }
                        token = token.next;
                        n = 1;
                        ++n2;
                    }
                    if (n != 1) {
                        token = token.next;
                        ++n2;
                    }
                    n = 0;
                }
                else {
                    final Vector<String> vector2 = value;
                    if (!image2.startsWith("?")) {
                        int i = 1;
                        int n3 = 0;
                        while (i == 1) {
                            try {
                                i = this.finder(set, vector2.get(n3), image2);
                                ++n3;
                            }
                            catch (Throwable t) {
                                throw new CompileException(this.getFirstLineNumber(), "Constant not found " + image2 + ". ");
                            }
                        }
                    }
                    token = token.next;
                    ++n2;
                }
            }
        }
    }
    
    private final int finder(final HashSet set, final String s, final String s2) throws CompileException {
        Class<?> forName;
        try {
            forName = Class.forName("facade.util." + s);
        }
        catch (ClassNotFoundException ex) {
            throw new CompileException(this.getFirstLineNumber(), "Class not found in declarations " + ex);
        }
        final Field[] declaredFields = forName.getDeclaredFields();
        for (int i = 0; i < declaredFields.length; ++i) {
            if (declaredFields[i].getName().equals(s2)) {
                final Integer n = new Integer(-255);
                Integer n2;
                try {
                    n2 = (Integer)declaredFields[i].get(new Integer(0));
                }
                catch (IllegalAccessException ex2) {
                    throw new CompileException(this.getFirstLineNumber(), ex2.getMessage());
                }
                set.add("(assert (DefConst " + s2 + ' ' + n2.toString() + "))\n");
                return 0;
            }
        }
        return 1;
    }
    
    public String getRuleName() {
        if (!ASTJessRule.$noassert && this.ruleName == null) {
            throw new AssertionError();
        }
        return this.ruleName;
    }
    
    public String getPatternHead() {
        if (!ASTJessRule.$noassert && this.patternHead == null) {
            throw new AssertionError();
        }
        return this.patternHead;
    }
    
    public String getPatternToMatch(final int n) {
        if (!ASTJessRule.$noassert && this.patternHead == null) {
            throw new AssertionError();
        }
        final StringBuffer sb = new StringBuffer(100);
        if (n != -1) {
            sb.append("(" + this.patternHead + " ?startpos" + n + " ?endpos" + n);
        }
        else {
            sb.append("(" + this.patternHead + " ?startpos ?endpos");
        }
        final Iterator<Object> iterator = this.getPatternBindingVariablesCanonical().iterator();
        while (iterator.hasNext()) {
            sb.append(" " + iterator.next());
        }
        sb.append(")");
        return sb.toString();
    }
    
    public HashSet getPatternBindingVariables() {
        final HashSet set = new HashSet();
        for (int i = 0; i < this.jjtGetNumChildren(); ++i) {
            set.addAll(((PatternProducingNode)this.jjtGetChild(i)).getPatternBindingVariables());
        }
        return set;
    }
    
    public List getPatternBindingVariablesCanonical() {
        return new ArrayList(this.getPatternBindingVariables());
    }
    
    ASTJessRule(final int n) {
        super(n);
    }
    
    ASTJessRule(final NLU nlu, final int n) {
        super(nlu, n);
    }
    
    static {
        $noassert = (Class.forName("[LTemplateCompiler.ASTJessRule;").getComponentType().desiredAssertionStatus() ^ true);
        ASTJessRule.tableOfConsts = new Hashtable();
        ASTJessRule.ruleID = new BigInteger("0");
        inc1 = new BigInteger("1");
        ASTJessRule.idTable = new Hashtable(10000);
    }
}
