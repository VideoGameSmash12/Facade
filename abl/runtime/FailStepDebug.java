package abl.runtime;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

public class FailStepDebug extends FailStep implements DebuggableStep
{
    final void execute() {
        ((DebuggableBehavior)this.parent).traceAblExecutionEvent(12, this, null, this.getNestLevel());
        super.execute();
    }
    
    final void succeedStep() {
        ((DebuggableBehavior)this.parent).traceAblExecutionEvent(13, this, new Boolean(true), this.getNestLevel());
        super.succeedStep();
    }
    
    final void failStep() {
        ((DebuggableBehavior)this.parent).traceAblExecutionEvent(13, this, new Boolean(false), this.getNestLevel());
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
    
    public FailStepDebug(final int n, final Behavior behavior, final boolean b, final boolean b2, final boolean b3, final short n2, final short n3, final boolean b4, final String s, final AblNamedPropertySupport ablNamedPropertySupport) {
        super(n, behavior, b, b2, b3, n2, n3, b4, s, ablNamedPropertySupport);
    }
}
