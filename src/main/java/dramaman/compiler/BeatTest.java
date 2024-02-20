package dramaman.compiler;

import jd.NestableCodeDescriptor;
import jd.MethodDescriptor;

abstract class BeatTest extends BeatParseNode implements BeatParserTreeConstants
{
    private static final /* synthetic */ boolean $noassert;
    
    MethodDescriptor compileToJava(final String methodName) throws CompileException {
        final MethodDescriptor methodDescriptor = new MethodDescriptor();
        methodDescriptor.methodName = methodName;
        methodDescriptor.addModifier("public");
        methodDescriptor.addModifier("static");
        methodDescriptor.addModifier("boolean");
        methodDescriptor.addArgument("VariableScope", "beatScope");
        ASTTestExpression astTestExpression = null;
        for (int i = 0; i < this.jjtGetNumChildren(); ++i) {
            if (((SimpleNode)this.jjtGetChild(i)).id == 14) {
                astTestExpression = (ASTTestExpression)this.jjtGetChild(i);
                break;
            }
        }
        if (!BeatTest.$noassert && astTestExpression == null) {
            throw new AssertionError((Object)"no ASTTestExpression found");
        }
        astTestExpression.initializeTestScope(methodName);
        astTestExpression.defineRuntimeScope(methodDescriptor, methodName, "beatScope");
        methodDescriptor.addToBlockBody(astTestExpression.compileToJava());
        return methodDescriptor;
    }
    
    BeatTest(final int n) {
        super(n);
    }
    
    BeatTest(final BeatParser beatParser, final int n) {
        super(beatParser, n);
    }
    
    static {
        $noassert = (Class.forName("[Ldramaman.compiler.BeatTest;").getComponentType().desiredAssertionStatus() ^ true);
    }
}
