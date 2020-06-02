package abl.runtime;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

public class SucceedStepDebug extends SucceedStep implements DebuggableStep
{
    final void execute() {
        ((DebuggableBehavior)this.parent).traceAblExecutionEvent(14, this, null, this.getNestLevel());
        super.execute();
    }
    
    final void succeedStep() {
        ((DebuggableBehavior)this.parent).traceAblExecutionEvent(15, this, new Boolean(true), this.getNestLevel());
        super.succeedStep();
    }
    
    final void failStep() {
        ((DebuggableBehavior)this.parent).traceAblExecutionEvent(15, this, new Boolean(false), this.getNestLevel());
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
    
    public SucceedStepDebug(final int n, final Behavior behavior, final boolean b, final boolean b2, final short n2, final short n3, final boolean b3, final String s, final AblNamedPropertySupport ablNamedPropertySupport) {
        super(n, behavior, b, b2, n2, n3, b3, s, ablNamedPropertySupport);
    }
}
