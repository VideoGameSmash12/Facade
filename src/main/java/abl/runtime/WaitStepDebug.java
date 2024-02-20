package abl.runtime;

import java.lang.reflect.Method;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

public class WaitStepDebug extends WaitStep implements DebuggableStep
{
    final void succeedStep() {
        ((DebuggableBehavior)this.parent).traceAblExecutionEvent(11, this, new Boolean(true), this.getNestLevel());
        super.succeedStep();
    }
    
    final void failStep() {
        ((DebuggableBehavior)this.parent).traceAblExecutionEvent(11, this, new Boolean(false), this.getNestLevel());
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
        return new DefaultMutableTreeNode(this);
    }
    
    public final int getNestLevel() {
        return ((DebuggableBehavior)this.parent).getNestLevel() + 1;
    }
    
    public WaitStepDebug(final int n, final Behavior behavior, final boolean b, final boolean b2, final boolean b3, final boolean b4, final boolean b5, final boolean b6, final short n2, final short n3, final boolean b7, final String s, final Method method, final Method method2, final Method method3, final AblNamedPropertySupport ablNamedPropertySupport) {
        super(n, behavior, b, b2, b3, b4, b5, b6, n2, n3, b7, s, method, method2, method3, ablNamedPropertySupport);
    }
}
