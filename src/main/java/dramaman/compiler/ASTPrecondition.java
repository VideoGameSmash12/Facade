package dramaman.compiler;

import jd.MethodDescriptor;

public class ASTPrecondition extends BeatTest
{
    BeatScopeMaintainer getEnclosingBeatScope() {
        return ((BeatParseNode)this.jjtGetParent()).getEnclosingBeatScope();
    }
    
    BeatScopeMaintainer getEnclosingScope() {
        return ((BeatParseNode)this.jjtGetParent()).getEnclosingScope();
    }
    
    String preconditionName(final String s, final int n) {
        return "_" + s + "_precondition" + n;
    }
    
    MethodDescriptor compileToJava(final String s, final int n) throws CompileException {
        return super.compileToJava(this.preconditionName(s, n));
    }
    
    public ASTPrecondition(final int n) {
        super(n);
    }
    
    public ASTPrecondition(final BeatParser beatParser, final int n) {
        super(beatParser, n);
    }
}
