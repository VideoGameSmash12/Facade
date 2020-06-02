package dramaman.compiler;

public class ASTBeatExpression extends BeatParseNode
{
    boolean isIdentifier() {
        return this.jjtGetNumChildren() == 1;
    }
    
    boolean isLiteral() {
        return this.isIdentifier() ^ true;
    }
    
    public ASTJavaName getRef() {
        if (this.isIdentifier()) {
            return (ASTJavaName)this.jjtGetChild(0);
        }
        return null;
    }
    
    public String getVariableReferenceConstantOrLiteral(final BeatScopeMaintainer beatScopeMaintainer) throws CompileException {
        if (this.isIdentifier()) {
            return this.getRef().getVariableReferenceOrConstant(beatScopeMaintainer);
        }
        return this.firstToken.image;
    }
    
    public String getVariableReferenceConstantOrLiteralAsObject(final BeatScopeMaintainer beatScopeMaintainer) throws CompileException {
        if (this.isIdentifier()) {
            return this.getRef().getVariableReferenceOrConstantAsObject(beatScopeMaintainer);
        }
        switch (this.firstToken.kind) {
            case 79: {
                return "new Integer(" + this.firstToken.image + ')';
            }
            case 83: {
                return "new Float(" + this.firstToken.image + ')';
            }
            case 85: {
                return "new Character(" + this.firstToken.image.charAt(0) + ')';
            }
            case 86: {
                return "new String(" + this.firstToken.image + ')';
            }
            case 28:
            case 58: {
                return "new Boolean(" + this.firstToken.image + ')';
            }
            case 43: {
                return "null";
            }
            default: {
                throw new CompileError("Unexpected literal token");
            }
        }
    }
    
    public Object getLiteralValue() {
        if (!this.isLiteral()) {
            throw new CompileError(this.dumpTokens() + " is not a literal.");
        }
        switch (this.firstToken.kind) {
            case 79: {
                return new Integer(this.firstToken.image);
            }
            case 83: {
                return new Float(this.firstToken.image);
            }
            case 85: {
                return new Character(this.firstToken.image.charAt(0));
            }
            case 86: {
                return new String(this.firstToken.image);
            }
            case 28:
            case 58: {
                return new Boolean(this.firstToken.image);
            }
            case 43: {
                return null;
            }
            default: {
                throw new CompileError("Unexpected literal token");
            }
        }
    }
    
    public String getFullNameOrLiteral() {
        if (this.isIdentifier()) {
            return this.getRef().getFullName();
        }
        return this.firstToken.image;
    }
    
    public String getType(final BeatScopeMaintainer beatScopeMaintainer) throws CompileException {
        if (this.isIdentifier()) {
            return this.getRef().getType(beatScopeMaintainer);
        }
        switch (this.firstToken.kind) {
            case 79: {
                return "int";
            }
            case 83: {
                return "float";
            }
            case 85: {
                return "char";
            }
            case 86: {
                return "String";
            }
            case 28:
            case 58: {
                return "boolean";
            }
            case 43: {
                return "Object";
            }
            default: {
                throw new CompileError("Unexpected literal token");
            }
        }
    }
    
    public ASTBeatExpression(final int n) {
        super(n);
    }
    
    public ASTBeatExpression(final BeatParser beatParser, final int n) {
        super(beatParser, n);
    }
}
