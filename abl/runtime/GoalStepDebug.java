package abl.runtime;

import java.lang.reflect.Method;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

public class GoalStepDebug extends GoalStep implements DebuggableStep
{
    final void execute() {
        ((DebuggableBehavior)this.parent).traceAblExecutionEvent(7, this, null, this.getNestLevel());
        super.execute();
    }
    
    final void succeedStep() {
        ((DebuggableBehavior)this.parent).traceAblExecutionEvent(8, this, new Boolean(true), this.getNestLevel());
        super.succeedStep();
    }
    
    final void failStep() {
        ((DebuggableBehavior)this.parent).traceAblExecutionEvent(8, this, new Boolean(false), this.getNestLevel());
        super.failStep();
    }
    
    final boolean successTest() {
        final boolean successTest = super.successTest();
        if (successTest) {
            ((DebuggableBehavior)this.parent).traceAblExecutionEvent(18, this, null, this.getNestLevel());
        }
        return successTest;
    }
    
    public final MutableTreeNode getTree() {
        final DefaultMutableTreeNode defaultMutableTreeNode = new DefaultMutableTreeNode(this);
        if (this.child != null) {
            defaultMutableTreeNode.add(((DebuggableBehavior)this.child).getTree());
        }
        return defaultMutableTreeNode;
    }
    
    public final int getNestLevel() {
        return ((DebuggableBehavior)this.parent).getNestLevel() + 1;
    }
    
    public GoalStepDebug(final int n, final Behavior behavior, final boolean b, final boolean b2, final boolean b3, final boolean b4, final boolean b5, final boolean b6, final short n2, final short n3, final boolean b7, final String s, final Method method, final Method method2, final Method method3, final AblNamedPropertySupport ablNamedPropertySupport, final String s2, final String[] array) {
        super(n, behavior, b, b2, b3, b4, b5, b6, n2, n3, b7, s, method, method2, method3, ablNamedPropertySupport, s2, array);
    }
    
    public GoalStepDebug(final int n, final Behavior behavior, final boolean b, final boolean b2, final boolean b3, final boolean b4, final boolean b5, final boolean b6, final short n2, final short n3, final boolean b7, final String s, final Method method, final Method method2, final Method method3, final AblNamedPropertySupport ablNamedPropertySupport, final String s2, final String[] array, final short n4) {
        super(n, behavior, b, b2, b3, b4, b5, b6, n2, n3, b7, s, method, method2, method3, ablNamedPropertySupport, s2, array, n4);
    }
}
