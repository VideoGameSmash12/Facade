package abl.runtime;

import java.lang.reflect.Method;

public class ParallelBehavior extends MultiStepBehavior
{
    protected static short behaviorType;
    
    final short getBehaviorType() {
        return ParallelBehavior.behaviorType;
    }
    
    public ParallelBehavior(final GoalStep goalStep, final Method method, final Method method2, final boolean b, final String s, final short n, final int n2, final Object[] array, final __StepDesc[] array2, final int n3) {
        super(goalStep, method, method2, b, s, n, n2, array, array2, n3);
    }
    
    public ParallelBehavior(final GoalStep goalStep, final Method method, final Method method2, final boolean b, final String s, final short n, final int n2, final Object[] array, final __StepDesc[] array2, final int n3, final BehavingEntity[] array3) {
        super(goalStep, method, method2, b, s, n, n2, array, array2, n3, array3);
    }
    
    static {
        ParallelBehavior.behaviorType = 1;
    }
}
