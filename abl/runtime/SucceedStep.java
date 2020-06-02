package abl.runtime;

import java.lang.reflect.Method;

public class SucceedStep extends Step
{
    void execute() {
        this.succeedStep();
    }
    
    void resetStep() {
        BehavingEntity.getBehavingEntity().resetStep(this);
    }
    
    public SucceedStep(final int n, final Behavior behavior, final boolean b, final boolean b2, final short n2, final short n3, final boolean b3, final String s, final AblNamedPropertySupport ablNamedPropertySupport) {
        super(n, behavior, false, false, false, false, b, b2, n2, n3, b3, s, null, null, null, ablNamedPropertySupport, (short)5);
    }
}
