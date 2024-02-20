package abl.runtime;

import java.lang.reflect.Method;
import javax.swing.tree.MutableTreeNode;

public final class ParallelBehaviorDebug extends ParallelBehavior implements DebuggableBehavior
{
    private final BehaviorDebugSupport debugSupport;
    private final __BehaviorDesc behaviorDesc;
    
    final boolean contextCondition() {
        final boolean contextCondition = super.contextCondition();
        if (!contextCondition) {
            this.debugSupport.traceAblExecutionEvent(4, this.behaviorDesc, null);
        }
        return contextCondition;
    }
    
    final void succeedBehavior() {
        this.debugSupport.traceAblExecutionEvent(3, this.behaviorDesc, new Boolean(true));
        super.succeedBehavior();
    }
    
    final void failBehavior() {
        this.debugSupport.traceAblExecutionEvent(3, this.behaviorDesc, new Boolean(false));
        super.failBehavior();
    }
    
    final void addChildren() {
        this.debugSupport.traceAblExecutionEvent(2, this.behaviorDesc, this.parent);
        super.addChildren();
    }
    
    public final int getNestLevel() {
        return this.debugSupport.getNestLevel();
    }
    
    public final MutableTreeNode getTree() {
        return this.debugSupport.getTree();
    }
    
    public final void traceAblExecutionEvent(final int n, final Step step, final Object o, final int n2) {
        this.debugSupport.traceAblExecutionEvent(n, step, o, n2);
    }
    
    public ParallelBehaviorDebug(final GoalStep goalStep, final Method method, final Method method2, final boolean b, final String s, final short n, final int n2, final Object[] array, final __StepDesc[] array2, final int n3, final __BehaviorDesc behaviorDesc) {
        super(goalStep, method, method2, b, s, n, n2, array, array2, n3);
        this.debugSupport = new BehaviorDebugSupport(this, ((DebuggableStep)this.parent).getNestLevel());
        this.behaviorDesc = behaviorDesc;
    }
    
    public ParallelBehaviorDebug(final GoalStep goalStep, final Method method, final Method method2, final boolean b, final String s, final short n, final int n2, final Object[] array, final __StepDesc[] array2, final int n3, final BehavingEntity[] array3, final __BehaviorDesc behaviorDesc) {
        super(goalStep, method, method2, b, s, n, n2, array, array2, n3, array3);
        this.debugSupport = new BehaviorDebugSupport(this, ((DebuggableStep)this.parent).getNestLevel());
        this.behaviorDesc = behaviorDesc;
    }
}
