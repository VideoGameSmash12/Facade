package abl.runtime;

import java.lang.reflect.Method;

public class FailStep extends Step
{
    void execute() {
        this.failStep();
    }
    
    void resetStep() {
        BehavingEntity.getBehavingEntity().resetStep(this);
    }
    
    public FailStep(final int n, final Behavior behavior, final boolean b, final boolean b2, final boolean b3, final short n2, final short n3, final boolean b4, final String s, final AblNamedPropertySupport ablNamedPropertySupport) {
        super(n, behavior, false, false, false, b, b2, b3, n2, n3, b4, s, null, null, null, ablNamedPropertySupport, (short)4);
    }
}
