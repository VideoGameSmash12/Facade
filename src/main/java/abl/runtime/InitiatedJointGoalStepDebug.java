package abl.runtime;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import java.util.Set;
import java.util.Hashtable;
import abl.compiler.AblDebuggerConstants;

public class InitiatedJointGoalStepDebug extends InitiatedJointGoalStep implements DebuggableJointGoalStep, AblDebuggerConstants
{
    private final byte debugLevel;
    private static final /* synthetic */ boolean $noassert;
    
    protected final JointGoalNegotiator getNewJointGoalNegotiator(final Hashtable hashtable) {
        return new JointGoalNegotiatorDebug(hashtable, this.debugLevel);
    }
    
    protected final JointGoalNegotiator getNewJointGoalNegotiator(final Set set) {
        return new JointGoalNegotiatorDebug(set, this, this.debugLevel);
    }
    
    protected final JointGoalNegotiator getNewJointGoalNegotiator(final Hashtable hashtable, final int n) {
        return new JointGoalNegotiatorDebug(hashtable, n, this.debugLevel);
    }
    
    protected JointGoalNegotiator getNewJointGoalNegotiator(final Set set, final boolean b) {
        return new JointGoalNegotiatorDebug(set, b, this, this.debugLevel);
    }
    
    public final void traceAblNegotiationEvent(final int n, final JointGoalNegotiatorDebug.JointGoalNegotiationInfo jointGoalNegotiationInfo) {
        if (!InitiatedJointGoalStepDebug.$noassert && this.debugLevel != 2) {
            throw new AssertionError();
        }
        ((DebuggableBehavior)this.parent).traceAblExecutionEvent(n, this, jointGoalNegotiationInfo, this.getNestLevel());
    }
    
    final void execute() {
        if (this.debugLevel == 2) {
            ((DebuggableBehavior)this.parent).traceAblExecutionEvent(7, this, null, this.getNestLevel());
        }
        super.execute();
    }
    
    final void succeedStep() {
        if (this.debugLevel == 2) {
            ((DebuggableBehavior)this.parent).traceAblExecutionEvent(8, this, new Boolean(true), this.getNestLevel());
        }
        super.succeedStep();
    }
    
    final void failStep() {
        if (this.debugLevel == 2) {
            ((DebuggableBehavior)this.parent).traceAblExecutionEvent(8, this, new Boolean(false), this.getNestLevel());
        }
        super.failStep();
    }
    
    final boolean successTest() {
        final boolean successTest = super.successTest();
        if (successTest && this.debugLevel == 2) {
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
    
    public InitiatedJointGoalStepDebug(final Behavior behavior, final String s, final Set set, final Object[] array, final boolean b, final byte debugLevel) {
        super(behavior, s, set, array, b);
        this.debugLevel = debugLevel;
    }
    
    static {
        $noassert = (Class.forName("[Labl.runtime.InitiatedJointGoalStepDebug;").getComponentType().desiredAssertionStatus() ^ true);
    }
}
