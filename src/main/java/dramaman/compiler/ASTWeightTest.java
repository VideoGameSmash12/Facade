package dramaman.compiler;

import jd.MethodDescriptor;

public class ASTWeightTest extends BeatTest
{
    private float weight;
    private boolean weightDefined;
    
    boolean getWeightDefined() {
        return this.weightDefined;
    }
    
    float getWeight() {
        return this.weight;
    }
    
    void setWeight(final float weight) {
        if (!this.weightDefined) {
            this.weight = weight;
            this.weightDefined = true;
            return;
        }
        throw new CompileError("Attempt to set the weight more than once on a weight test");
    }
    
    BeatScopeMaintainer getEnclosingBeatScope() {
        return ((BeatParseNode)this.jjtGetParent()).getEnclosingBeatScope();
    }
    
    BeatScopeMaintainer getEnclosingScope() {
        return ((BeatParseNode)this.jjtGetParent()).getEnclosingScope();
    }
    
    String weightTestName(final String s, final int n) {
        return "_" + s + "_weighttest" + n;
    }
    
    MethodDescriptor compileToJava(final String s, final int n) throws CompileException {
        return super.compileToJava(this.weightTestName(s, n));
    }
    
    public ASTWeightTest(final int n) {
        super(n);
        this.weight = 1.0f;
        this.weightDefined = false;
    }
    
    public ASTWeightTest(final BeatParser beatParser, final int n) {
        super(beatParser, n);
        this.weight = 1.0f;
        this.weightDefined = false;
    }
}
