package dramaman.compiler;

import jd.NestableCodeDescriptor;
import jd.CodeStringDescriptor;
import jd.MethodDescriptor;

abstract class BeatAction extends BeatScopeMaintainer implements BeatParserTreeConstants
{
    MethodDescriptor compileToJava(final String methodName) throws CompileException {
        final MethodDescriptor methodDescriptor = new MethodDescriptor();
        methodDescriptor.methodName = methodName;
        methodDescriptor.addModifier("public");
        methodDescriptor.addModifier("static");
        methodDescriptor.addModifier("void");
        methodDescriptor.addArgument("VariableScope", "beatScope");
        this.initializeScope(1, methodName, this.getNextEnclosingScope());
        this.addChildVariableDeclarations();
        this.defineRuntimeScope(methodDescriptor, methodName, "beatScope");
        for (int i = 0; i < this.jjtGetNumChildren(); ++i) {
            final BeatParseNode beatParseNode = (BeatParseNode)this.jjtGetChild(i);
            if (beatParseNode.id == 24) {
                final ASTJavaStatement astJavaStatement = (ASTJavaStatement)beatParseNode;
                astJavaStatement.processVariableReferences(this);
                methodDescriptor.addToBlockBody(new CodeStringDescriptor(astJavaStatement.prettyPrintTokens()));
            }
        }
        return methodDescriptor;
    }
    
    BeatAction(final int n) {
        super(n);
    }
    
    BeatAction(final BeatParser beatParser, final int n) {
        super(beatParser, n);
    }
}
