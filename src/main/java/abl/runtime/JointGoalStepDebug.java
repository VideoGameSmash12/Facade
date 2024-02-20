package abl.runtime;

import java.lang.reflect.Method;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import java.util.Set;
import java.util.Hashtable;
import abl.compiler.AblDebuggerConstants;

public class JointGoalStepDebug extends JointGoalStep implements DebuggableJointGoalStep, AblDebuggerConstants
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
        if (!JointGoalStepDebug.$noassert && this.debugLevel != 2) {
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
    
    public JointGoalStepDebug(final int n, final Behavior behavior, final boolean b, final boolean b2, final boolean b3, final boolean b4, final boolean b5, final boolean b6, final short n2, final short n3, final boolean b7, final String s, final Method method, final Method method2, final Method method3, final AblNamedPropertySupport ablNamedPropertySupport, final String s2, final String[] array, final boolean b8, final byte debugLevel) {
        super(n, behavior, b, b2, b3, b4, b5, b6, n2, n3, b7, s, method, method2, method3, ablNamedPropertySupport, s2, array, b8);
        this.debugLevel = debugLevel;
    }
    
    public JointGoalStepDebug(final int n, final Behavior behavior, final boolean b, final boolean b2, final boolean b3, final boolean b4, final boolean b5, final boolean b6, final short n2, final short n3, final boolean b7, final String s, final Method method, final Method method2, final Method method3, final AblNamedPropertySupport ablNamedPropertySupport, final String s2, final String[] array, final short n4, final boolean b8, final byte debugLevel) {
        super(n, behavior, b, b2, b3, b4, b5, b6, n2, n3, b7, s, method, method2, method3, ablNamedPropertySupport, s2, array, n4, b8);
        this.debugLevel = debugLevel;
    }
    
    static {
        $noassert = (Class.forName("[Labl.runtime.JointGoalStepDebug;").getComponentType().desiredAssertionStatus() ^ true);
    }
}
