package abl.runtime;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

class BehaviorDebugSupport
{
    private final int nestLevel;
    private final Behavior debuggedBehavior;
    private final BehavingEntity entity;
    
    int getNestLevel() {
        return this.nestLevel;
    }
    
    MutableTreeNode getTree() {
        final short behaviorType = this.debuggedBehavior.getBehaviorType();
        final DefaultMutableTreeNode defaultMutableTreeNode = new DefaultMutableTreeNode(this.debuggedBehavior);
        switch (behaviorType) {
            case 1:
            case 2: {
                final Step[] children = ((MultiStepBehavior)this.debuggedBehavior).getChildren();
                for (int i = 0; i < children.length; ++i) {
                    defaultMutableTreeNode.add(((DebuggableStep)children[i]).getTree());
                }
                return defaultMutableTreeNode;
            }
            case 0: {
                defaultMutableTreeNode.add(((DebuggableStep)((SequentialBehavior)this.debuggedBehavior).getChild()).getTree());
                return defaultMutableTreeNode;
            }
            default: {
                throw new AblRuntimeError("Unexpected behavior type " + behaviorType);
            }
        }
    }
    
    void traceAblExecutionEvent(final int n, final Step step, final Object o, final int n2) {
        this.entity.traceAblExecutionEvent(n, step, o, n2, this.debuggedBehavior.getID());
    }
    
    void traceAblExecutionEvent(final int n, final Step step, final Object o) {
        this.entity.traceAblExecutionEvent(n, step, o, this.nestLevel + 1, this.debuggedBehavior.getID());
    }
    
    void traceAblExecutionEvent(final int n, final __BehaviorDesc _BehaviorDesc, final Object o, final int n2) {
        this.entity.traceAblExecutionEvent(n, _BehaviorDesc, o, n2, _BehaviorDesc.behaviorID);
    }
    
    void traceAblExecutionEvent(final int n, final __BehaviorDesc _BehaviorDesc, final Object o) {
        this.entity.traceAblExecutionEvent(n, _BehaviorDesc, o, this.nestLevel, _BehaviorDesc.behaviorID);
    }
    
    private final /* synthetic */ void this() {
        this.entity = BehavingEntity.getBehavingEntity();
    }
    
    BehaviorDebugSupport(final Behavior debuggedBehavior, final int nestLevel) {
        this.this();
        this.debuggedBehavior = debuggedBehavior;
        this.nestLevel = nestLevel;
    }
}
