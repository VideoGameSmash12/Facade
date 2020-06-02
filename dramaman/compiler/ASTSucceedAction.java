package dramaman.compiler;

import jd.MethodDescriptor;

public class ASTSucceedAction extends BeatAction
{
    String succeedActionName(final String s) {
        return "_" + s + "_succeedAction";
    }
    
    MethodDescriptor compileToJava(final String s) throws CompileException {
        return super.compileToJava(this.succeedActionName(s));
    }
    
    public ASTSucceedAction(final int n) {
        super(n);
    }
    
    public ASTSucceedAction(final BeatParser beatParser, final int n) {
        super(beatParser, n);
    }
}
