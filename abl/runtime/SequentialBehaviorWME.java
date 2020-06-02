package abl.runtime;

import wm.WME;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SequentialBehaviorWME extends BehaviorWME
{
    protected StepWME child;
    
    public synchronized StepWME getChild() {
        return this.child;
    }
    
    public synchronized int getBehaviorType() {
        return this.behavior.getBehaviorType();
    }
    
    private final synchronized void setChild(final StepWME child) {
        this.child = child;
    }
    
    private final /* synthetic */ void this() {
        this.child = null;
    }
    
    public SequentialBehaviorWME(final SequentialBehavior sequentialBehavior, final GoalStepWME goalStepWME) {
        super(sequentialBehavior, goalStepWME);
        this.this();
        sequentialBehavior.addChildChangeListener(new SequentialBehaviorChildChangeListener(this));
    }
    
    private class SequentialBehaviorChildChangeListener implements PropertyChangeListener
    {
        SequentialBehaviorWME sequentialBehaviorWME;
        private static final /* synthetic */ boolean $noassert;
        
        public void propertyChange(final PropertyChangeEvent propertyChangeEvent) {
            if (!SequentialBehaviorChildChangeListener.$noassert && ((propertyChangeEvent.getOldValue() != null && propertyChangeEvent.getNewValue() != null) || (propertyChangeEvent.getOldValue() == null && propertyChangeEvent.getNewValue() == null))) {
                throw new AssertionError((Object)("Behavior " + SequentialBehaviorWME.this.behavior));
            }
            if (propertyChangeEvent.getOldValue() == null) {
                if (BehavingEntity.getBehavingEntity().getBehavingEntityShortName().equals("Trip") && SequentialBehaviorWME.this.behavior.getSignature().equals("DoDialog(int, boolean, int, int, int, int, boolean)") && !SequentialBehaviorChildChangeListener.$noassert && !Thread.currentThread().getName().equals("DecisionCycleThread")) {
                    throw new AssertionError((Object)("Thread adding a step reflection wme = " + Thread.currentThread()));
                }
                if (!SequentialBehaviorChildChangeListener.$noassert && this.sequentialBehaviorWME.child != null) {
                    throw new AssertionError((Object)("Behavior " + SequentialBehaviorWME.this.behavior));
                }
                final Step step = (Step)propertyChangeEvent.getNewValue();
                switch (step.getStepType()) {
                    case 1: {
                        this.sequentialBehaviorWME.setChild(new GoalStepWME((GoalStep)step, this.sequentialBehaviorWME));
                        break;
                    }
                    case 0: {
                        this.sequentialBehaviorWME.setChild(new PrimitiveStepWME((PrimitiveStep)step, this.sequentialBehaviorWME));
                        break;
                    }
                    case 3: {
                        this.sequentialBehaviorWME.setChild(new WaitStepWME((WaitStep)step, this.sequentialBehaviorWME));
                        break;
                    }
                    case 2: {
                        this.sequentialBehaviorWME.setChild(new MentalStepWME((MentalStep)step, this.sequentialBehaviorWME));
                        break;
                    }
                    case 4: {
                        this.sequentialBehaviorWME.setChild(new FailStepWME((FailStep)step, this.sequentialBehaviorWME));
                        break;
                    }
                    case 5: {
                        this.sequentialBehaviorWME.setChild(new SucceedStepWME((SucceedStep)step, this.sequentialBehaviorWME));
                        break;
                    }
                }
                BehavingEntity.getBehavingEntity().addWME(this.sequentialBehaviorWME.child);
            }
            else {
                if (!SequentialBehaviorChildChangeListener.$noassert && this.sequentialBehaviorWME.child == null) {
                    throw new AssertionError((Object)("Behavior " + SequentialBehaviorWME.this.behavior));
                }
                BehavingEntity.getBehavingEntity().deleteWME(this.sequentialBehaviorWME.child);
                this.sequentialBehaviorWME.getChild().delete();
                this.sequentialBehaviorWME.setChild(null);
            }
        }
        
        SequentialBehaviorChildChangeListener(final SequentialBehaviorWME sequentialBehaviorWME) {
            this.sequentialBehaviorWME = sequentialBehaviorWME;
        }
        
        static {
            $noassert = (Class.forName("[Labl.runtime.SequentialBehaviorWME;").getComponentType().desiredAssertionStatus() ^ true);
        }
    }
}
