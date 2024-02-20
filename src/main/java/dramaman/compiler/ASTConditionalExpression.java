package dramaman.compiler;

import jd.NestableCodeDescriptor;
import jd.CodeStringDescriptor;
import jd.CodeBlockDescriptor;
import jd.JavaCodeDescriptor;

public class ASTConditionalExpression extends VariableContainer implements Compileable, BeatParserTreeConstants
{
    public JavaCodeDescriptor compileToJava() throws CompileException {
        final CodeBlockDescriptor codeBlockDescriptor = new CodeBlockDescriptor("if (", ")");
        this.processVariableReferences(this.getEnclosingScope());
        codeBlockDescriptor.addToBlockBody(new CodeStringDescriptor(this.prettyPrintTokens()));
        final CodeBlockDescriptor codeBlockDescriptor2 = new CodeBlockDescriptor("{", "}");
        if (((ASTTestExpression)this.jjtGetParent()).hasNextTest()) {
            codeBlockDescriptor2.addToBlockBody(((ASTTestExpression)this.jjtGetParent()).compileNextTest());
        }
        else {
            ((ASTTestExpression)this.jjtGetParent()).compileVariableCopyThrough(codeBlockDescriptor2);
            codeBlockDescriptor2.addToBlockBody(new CodeStringDescriptor("return true;"));
        }
        final CodeBlockDescriptor codeBlockDescriptor3 = new CodeBlockDescriptor();
        codeBlockDescriptor3.addToBlockBody(codeBlockDescriptor);
        codeBlockDescriptor3.addToBlockBody(codeBlockDescriptor2);
        return codeBlockDescriptor3;
    }
    
    public ASTConditionalExpression(final int n) {
        super(n);
    }
    
    public ASTConditionalExpression(final BeatParser beatParser, final int n) {
        super(beatParser, n);
    }
}
