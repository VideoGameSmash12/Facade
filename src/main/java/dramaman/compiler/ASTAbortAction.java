package dramaman.compiler;

import jd.MethodDescriptor;

public class ASTAbortAction extends BeatAction
{
    String abortActionName(final String s) {
        return "_" + s + "_abortAction";
    }
    
    MethodDescriptor compileToJava(final String s) throws CompileException {
        return super.compileToJava(this.abortActionName(s));
    }
    
    public ASTAbortAction(final int n) {
        super(n);
    }
    
    public ASTAbortAction(final BeatParser beatParser, final int n) {
        super(beatParser, n);
    }
}
