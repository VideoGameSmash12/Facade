package abl.runtime;

import java.lang.reflect.Method;

public class WaitStep extends Step
{
    void resetStep() {
        throw new RuntimeError("Attempt to reset a wait step.");
    }
    
    void execute() {
        throw new RuntimeError("Attempt to execute a wait step.");
    }
    
    public WaitStep(final int n, final Behavior behavior, final boolean b, final boolean b2, final boolean b3, final boolean b4, final boolean b5, final boolean b6, final short n2, final short n3, final boolean b7, final String s, final Method method, final Method method2, final Method method3, final AblNamedPropertySupport ablNamedPropertySupport) {
        super(n, behavior, b, b2, b3, b4, b5, b6, n2, n3, b7, s, method, method2, method3, ablNamedPropertySupport, (short)3);
    }
}
