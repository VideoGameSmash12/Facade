package dramaman.compiler;

import jd.MethodDescriptor;

public class ASTPriorityTest extends BeatTest
{
    private int priority;
    private boolean priorityDefined;
    
    boolean getPriorityDefined() {
        return this.priorityDefined;
    }
    
    int getPriority() {
        return this.priority;
    }
    
    void setPriority(final int priority) {
        if (!this.priorityDefined) {
            this.priority = priority;
            this.priorityDefined = true;
            return;
        }
        throw new CompileError("Attempt to set the priority more than once on a priority test");
    }
    
    BeatScopeMaintainer getEnclosingBeatScope() {
        return ((BeatParseNode)this.jjtGetParent()).getEnclosingBeatScope();
    }
    
    BeatScopeMaintainer getEnclosingScope() {
        return ((BeatParseNode)this.jjtGetParent()).getEnclosingScope();
    }
    
    String priorityTestName(final String s, final int n) {
        return "_" + s + "_prioritytest" + n;
    }
    
    MethodDescriptor compileToJava(final String s, final int n) throws CompileException {
        return super.compileToJava(this.priorityTestName(s, n));
    }
    
    private final /* synthetic */ void this() {
        this.priority = 0;
        this.priorityDefined = false;
    }
    
    public ASTPriorityTest(final int n) {
        super(n);
        this.this();
    }
    
    public ASTPriorityTest(final BeatParser beatParser, final int n) {
        super(beatParser, n);
        this.this();
    }
}
