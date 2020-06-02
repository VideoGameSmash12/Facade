package dramaman.compiler;

import jd.MethodDescriptor;

public class ASTSelectAction extends BeatAction
{
    String selectActionName(final String s) {
        return "_" + s + "_selectAction";
    }
    
    MethodDescriptor compileToJava(final String s) throws CompileException {
        return super.compileToJava(this.selectActionName(s));
    }
    
    public ASTSelectAction(final int n) {
        super(n);
    }
    
    public ASTSelectAction(final BeatParser beatParser, final int n) {
        super(beatParser, n);
    }
}
