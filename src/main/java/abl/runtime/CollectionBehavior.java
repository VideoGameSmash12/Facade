package abl.runtime;

import java.lang.reflect.Method;

public class CollectionBehavior extends MultiStepBehavior
{
    protected static short behaviorType;
    
    final short getBehaviorType() {
        return CollectionBehavior.behaviorType;
    }
    
    public void initRootBehavior() {
        if (this.parent != null) {
            throw new AblRuntimeError("Attempt to call initRootBehavior() on a non-root behavior");
        }
        this.addChildren();
    }
    
    public CollectionBehavior(final GoalStep goalStep, final Method method, final Method method2, final boolean b, final String s, final short n, final int n2, final Object[] array, final __StepDesc[] array2, final int n3) {
        super(goalStep, method, method2, b, s, n, n2, array, array2, n3);
    }
    
    public CollectionBehavior(final GoalStep goalStep, final Method method, final Method method2, final boolean b, final String s, final short n, final int n2, final Object[] array, final __StepDesc[] array2, final int n3, final BehavingEntity[] array3) {
        super(goalStep, method, method2, b, s, n, n2, array, array2, n3, array3);
    }
    
    static {
        CollectionBehavior.behaviorType = 2;
    }
}
