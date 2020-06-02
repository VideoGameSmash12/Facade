package abl.runtime;

public class PrimitiveStepWME extends ExecutableStepWME
{
    public synchronized int getCompletionStatus() {
        return ((PrimitiveStep)this.s).getCompletionStatus();
    }
    
    public synchronized String getName() {
        return ((PrimitiveStep)this.s).getName();
    }
    
    public PrimitiveStepWME(final PrimitiveStep primitiveStep, final BehaviorWME behaviorWME) {
        super(primitiveStep, behaviorWME);
    }
}
