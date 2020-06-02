package dramaman.compiler;

import jd.MethodDescriptor;

public class ASTInitAction extends BeatAction
{
    String initActionName(final String s) {
        return "_" + s + "_initAction";
    }
    
    MethodDescriptor compileToJava(final String s) throws CompileException {
        return super.compileToJava(this.initActionName(s));
    }
    
    public ASTInitAction(final int n) {
        super(n);
    }
    
    public ASTInitAction(final BeatParser beatParser, final int n) {
        super(beatParser, n);
    }
}
