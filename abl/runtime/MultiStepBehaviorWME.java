package abl.runtime;

import wm.WME;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Hashtable;
import java.util.HashSet;

public class MultiStepBehaviorWME extends BehaviorWME
{
    private final HashSet children;
    private final Hashtable stepToWMETable;
    
    public synchronized int getNumberNeededForSuccess() {
        return ((MultiStepBehavior)this.behavior).getNumberNeededForSuccess();
    }
    
    public synchronized int getNumberOfCompletedSteps() {
        return ((MultiStepBehavior)this.behavior).getNumberOfCompletedSteps();
    }
    
    public synchronized int getNumberOfSteps() {
        return ((MultiStepBehavior)this.behavior).getNumberOfSteps();
    }
    
    public synchronized int getBehaviorType() {
        return this.behavior.getBehaviorType();
    }
    
    public synchronized StepWME[] getChildren() {
        return (StepWME[])this.children.toArray(new StepWME[this.children.size()]);
    }
    
    private final synchronized void addChild(final StepWME stepWME, final Step step) {
        this.children.add(stepWME);
        this.stepToWMETable.put(step, stepWME);
    }
    
    private final synchronized void removeChild(final StepWME stepWME, final Step step) {
        this.children.remove(stepWME);
        this.stepToWMETable.remove(step);
    }
    
    private final /* synthetic */ void this() {
        this.children = new HashSet();
        this.stepToWMETable = new Hashtable();
    }
    
    public MultiStepBehaviorWME(final MultiStepBehavior multiStepBehavior, final GoalStepWME goalStepWME) {
        super(multiStepBehavior, goalStepWME);
        this.this();
        this.behavior.addChildChangeListener(new MultiStepBehaviorChildChangeListener(this));
    }
    
    private class MultiStepBehaviorChildChangeListener implements PropertyChangeListener
    {
        MultiStepBehaviorWME multiStepBehaviorWME;
        private static final /* synthetic */ boolean $noassert;
        
        public void propertyChange(final PropertyChangeEvent propertyChangeEvent) {
            if (!MultiStepBehaviorChildChangeListener.$noassert && ((propertyChangeEvent.getOldValue() != null && propertyChangeEvent.getNewValue() != null) || (propertyChangeEvent.getOldValue() == null && propertyChangeEvent.getNewValue() == null))) {
                throw new AssertionError();
            }
            if (propertyChangeEvent.getOldValue() == null) {
                final Step step = (Step)propertyChangeEvent.getNewValue();
                StepWME stepWME = null;
                switch (step.getStepType()) {
                    case 1: {
                        stepWME = new GoalStepWME((GoalStep)step, this.multiStepBehaviorWME);
                        break;
                    }
                    case 0: {
                        stepWME = new PrimitiveStepWME((PrimitiveStep)step, this.multiStepBehaviorWME);
                        break;
                    }
                    case 3: {
                        stepWME = new WaitStepWME((WaitStep)step, this.multiStepBehaviorWME);
                        break;
                    }
                    case 2: {
                        stepWME = new MentalStepWME((MentalStep)step, this.multiStepBehaviorWME);
                        break;
                    }
                    case 4: {
                        stepWME = new FailStepWME((FailStep)step, this.multiStepBehaviorWME);
                        break;
                    }
                    case 5: {
                        stepWME = new SucceedStepWME((SucceedStep)step, this.multiStepBehaviorWME);
                        break;
                    }
                }
                this.multiStepBehaviorWME.addChild(stepWME, step);
                BehavingEntity.getBehavingEntity().addWME(stepWME);
            }
            else {
                final Step step2 = (Step)propertyChangeEvent.getOldValue();
                final StepWME stepWME2 = MultiStepBehaviorWME.this.stepToWMETable.get(step2);
                if (!MultiStepBehaviorChildChangeListener.$noassert && stepWME2 == null) {
                    throw new AssertionError();
                }
                this.multiStepBehaviorWME.removeChild(stepWME2, step2);
                BehavingEntity.getBehavingEntity().deleteWME(stepWME2);
                stepWME2.delete();
            }
        }
        
        MultiStepBehaviorChildChangeListener(final MultiStepBehaviorWME multiStepBehaviorWME) {
            this.multiStepBehaviorWME = multiStepBehaviorWME;
        }
        
        static {
            $noassert = (Class.forName("[Labl.runtime.MultiStepBehaviorWME;").getComponentType().desiredAssertionStatus() ^ true);
        }
    }
}
