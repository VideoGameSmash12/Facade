package abl.runtime;

import wm.WME;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class GoalStepWME extends ExecutableStepWME
{
    protected BehaviorWME child;
    protected GoalChildChangeListener listener;
    
    void delete() {
        ((GoalStep)this.s).removeChildChangeListener(this.listener);
        super.delete();
    }
    
    public synchronized String getSignature() {
        return ((GoalStep)this.s).getSignature();
    }
    
    public synchronized BehaviorWME getChild() {
        return this.child;
    }
    
    public synchronized boolean getIsExpanded() {
        return ((GoalStep)this.s).isExpanded();
    }
    
    private final synchronized void setChild(final BehaviorWME child) {
        this.child = child;
    }
    
    private final /* synthetic */ void this() {
        this.child = null;
    }
    
    public GoalStepWME(final GoalStep goalStep, final BehaviorWME behaviorWME) {
        super(goalStep, behaviorWME);
        this.this();
        goalStep.addChildChangeListener(this.listener = new GoalChildChangeListener(this));
    }
    
    private class GoalChildChangeListener implements PropertyChangeListener
    {
        GoalStepWME goalStepWME;
        private static final /* synthetic */ boolean $noassert;
        
        public void propertyChange(final PropertyChangeEvent propertyChangeEvent) {
            if (!GoalChildChangeListener.$noassert && ((propertyChangeEvent.getOldValue() != null && propertyChangeEvent.getNewValue() != null) || (propertyChangeEvent.getOldValue() == null && propertyChangeEvent.getNewValue() == null))) {
                throw new AssertionError();
            }
            if (propertyChangeEvent.getOldValue() == null) {
                if (!GoalChildChangeListener.$noassert && this.goalStepWME.child != null) {
                    throw new AssertionError();
                }
                final Behavior behavior = (Behavior)propertyChangeEvent.getNewValue();
                BehaviorWME behaviorWME = null;
                switch (behavior.getBehaviorType()) {
                    case 0: {
                        behaviorWME = new SequentialBehaviorWME((SequentialBehavior)behavior, this.goalStepWME);
                        break;
                    }
                    case 1: {
                        behaviorWME = new ParallelBehaviorWME((ParallelBehavior)behavior, this.goalStepWME);
                        break;
                    }
                    case 2: {
                        behaviorWME = new CollectionBehaviorWME((CollectionBehavior)behavior, this.goalStepWME);
                        break;
                    }
                }
                this.goalStepWME.setChild(behaviorWME);
                BehavingEntity.getBehavingEntity().addWME(behaviorWME);
            }
            else {
                if (!GoalChildChangeListener.$noassert && this.goalStepWME.child == null) {
                    throw new AssertionError();
                }
                BehavingEntity.getBehavingEntity().deleteWME(this.goalStepWME.child);
                GoalStepWME.this.child.delete();
                this.goalStepWME.setChild(null);
            }
        }
        
        GoalChildChangeListener(final GoalStepWME goalStepWME) {
            this.goalStepWME = goalStepWME;
        }
        
        static {
            $noassert = (Class.forName("[Labl.runtime.GoalStepWME;").getComponentType().desiredAssertionStatus() ^ true);
        }
    }
}
