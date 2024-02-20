package abl.runtime;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

public class MentalStep extends Step
{
    private boolean valid;
    private static final /* synthetic */ boolean $noassert;
    
    void resetStep() {
        if (this.valid) {
            BehavingEntity.getBehavingEntity().resetStep(this);
        }
    }
    
    void succeedStep() {
        if (this.valid) {
            super.succeedStep();
        }
    }
    
    void failStep() {
        if (this.valid) {
            super.failStep();
        }
    }
    
    void execute() {
        if (!MentalStep.$noassert && !this.valid) {
            throw new AssertionError();
        }
        final Object[] array = { new Integer(this.stepID), this.parent.getBehaviorVariableFrame(), BehavingEntity.getBehavingEntity(), this };
        try {
            this.execute.invoke(null, array);
        }
        catch (InvocationTargetException ex) {
            throw new AblRuntimeError("InvocationTargetException executing mental step in behavior " + this.parent + ". Error " + ex.getCause(), ex.getCause());
        }
        catch (Exception ex2) {
            throw new AblRuntimeError("Error executing mental step in behavior " + this.parent, ex2);
        }
        this.succeedStep();
    }
    
    void delete() {
        this.valid = false;
    }
    
    public MentalStep(final int n, final Behavior behavior, final boolean b, final boolean b2, final boolean b3, final boolean b4, final boolean b5, final boolean b6, final short n2, final short n3, final boolean b7, final String s, final Method method, final Method method2, final Method method3, final AblNamedPropertySupport ablNamedPropertySupport) {
        super(n, behavior, b, b2, b3, b4, b5, b6, n2, n3, b7, s, method, method2, method3, ablNamedPropertySupport, (short)2);
        this.valid = true;
    }
    
    static {
        $noassert = (Class.forName("[Labl.runtime.MentalStep;").getComponentType().desiredAssertionStatus() ^ true);
    }
}
