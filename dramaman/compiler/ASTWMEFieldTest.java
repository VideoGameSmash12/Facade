package dramaman.compiler;

import jd.CodeStringDescriptor;
import jd.JavaCodeDescriptor;
import jd.FieldDescriptor;

public class ASTWMEFieldTest extends BeatParseNode
{
    private String wmeFieldName;
    private int testOp;
    private ASTBeatExpression wmeTestOperand;
    
    void setWMEFieldName(final String wmeFieldName) {
        this.wmeFieldName = wmeFieldName;
    }
    
    void setTestOp(final int testOp) {
        this.testOp = testOp;
    }
    
    void setWMETestOperand(final ASTBeatExpression wmeTestOperand) {
        this.wmeTestOperand = wmeTestOperand;
    }
    
    private final String getWMEFieldType() throws ClassNotFoundException, NoSuchFieldException {
        final String wmeClassName = ((ASTWMETest)this.jjtGetParent()).wmeClassName;
        try {
            return this.getWMEFieldType(wmeClassName, this.wmeFieldName).getName();
        }
        catch (NoSuchMethodException ex) {
            throw new NoSuchFieldException();
        }
    }
    
    BeatScopeMaintainer getEnclosingBeatScope() {
        return ((ASTWMETest)this.jjtGetParent()).getEnclosingBeatScope();
    }
    
    BeatScopeMaintainer getEnclosingScope() {
        return ((ASTWMETest)this.jjtGetParent()).getEnclosingScope();
    }
    
    FieldDescriptor preprocessVariableRef() throws CompileException {
        try {
            final String wmeFieldType = this.getWMEFieldType();
            if (this.wmeTestOperand.isIdentifier() && this.testOp == 78) {
                final BeatScopeMaintainer enclosingScope = this.getEnclosingScope();
                if (!this.wmeTestOperand.getRef().declaredInLocalScope(enclosingScope)) {
                    final FieldDescriptor fieldDescriptor = new FieldDescriptor();
                    fieldDescriptor.addFieldName(this.wmeTestOperand.getRef().getName());
                    fieldDescriptor.fieldType = wmeFieldType;
                    enclosingScope.addVariableDeclaration(fieldDescriptor);
                    return fieldDescriptor;
                }
                if (this.wmeTestOperand.getRef().lookupFieldType(enclosingScope) != wmeFieldType.intern()) {
                    throw new CompileException(this.getFirstLineNumber(), "Type error in WME field test: " + this.dumpTokens());
                }
            }
            return null;
        }
        catch (ClassNotFoundException ex) {
            throw new CompileException(this.getFirstLineNumber(), "Reference to undefined WME " + ex.getMessage() + " in WME test: " + this.dumpTokens());
        }
        catch (NoSuchFieldException ex2) {
            throw new CompileException(this.getFirstLineNumber(), "Reference to undefined WME field in WME test: " + this.dumpTokens());
        }
    }
    
    public String getBoundVariable() {
        if (this.wmeTestOperand.isIdentifier() && this.testOp == 78) {
            return this.wmeTestOperand.getRef().getName();
        }
        return null;
    }
    
    protected int getTestType() {
        return ((ASTWMETest)this.jjtGetParent()).getTestType();
    }
    
    public JavaCodeDescriptor compileToJava() throws CompileException {
        final int wmeCounter = ((ASTWMETest)this.jjtGetParent()).getWMECounter();
        final String variableReferenceConstantOrLiteral = this.wmeTestOperand.getVariableReferenceConstantOrLiteral(this.getEnclosingScope());
        final StringBuffer sb = new StringBuffer();
        final String string = "get" + BeatParseNode.uppercaseFirstCharacter(this.wmeFieldName) + "()";
        if (this.testOp == 78) {
            sb.append("DramaManager.constantTrue(" + variableReferenceConstantOrLiteral + " = wme__" + wmeCounter + '.' + string + ')');
        }
        else {
            String wmeFieldType;
            try {
                wmeFieldType = this.getWMEFieldType();
            }
            catch (ClassNotFoundException ex) {
                throw new CompileException(this.getFirstLineNumber(), "Reference to undefined WME " + ex.getMessage() + " in WME test: " + this.dumpTokens());
            }
            catch (NoSuchFieldException ex2) {
                throw new CompileException(this.getFirstLineNumber(), "Reference to undefined WME field in WME test: " + this.dumpTokens());
            }
            if ((wmeFieldType.equals("java.lang.String") || wmeFieldType.equals("String")) && BeatParseNode.stripQuotes(ASTWMEFieldTest.tokenImage[this.testOp]).equals("==")) {
                sb.append("(wme__" + wmeCounter + '.' + string + ".equals(" + variableReferenceConstantOrLiteral + "))");
            }
            else {
                sb.append("( wme__" + wmeCounter + '.' + string + ' ' + BeatParseNode.stripQuotes(ASTWMEFieldTest.tokenImage[this.testOp]) + ' ');
                sb.append(variableReferenceConstantOrLiteral + " )");
            }
        }
        return new CodeStringDescriptor(sb.toString());
    }
    
    public ASTWMEFieldTest(final int n) {
        super(n);
    }
    
    public ASTWMEFieldTest(final BeatParser beatParser, final int n) {
        super(beatParser, n);
    }
}
