package abl.runtime;

import java.util.HashSet;
import java.util.Collection;
import java.util.ArrayList;
import java.lang.reflect.Method;
import java.util.List;

public class AdaptiveBehavior extends MultiStepBehavior
{
    protected static final short behaviorType = 3;
    static List oldStateWMEList;
    private final short adaptiveBehaviorType;
    private final Method reinforcementSignal;
    private final Method reinforcementSignalSensorFactory;
    private final Method stateWME;
    private final Method stateWMESensorFactory;
    private final Method rlPolicy;
    private static final /* synthetic */ boolean $noassert;
    
    final int getNumberNeededForSuccess() {
        throw new AblRuntimeError("numberNeededForSuccess is meaningless for AdaptiveBehaviors");
    }
    
    private final boolean childrenConsistencyTest() {
        return true;
    }
    
    protected final void removeChildren() {
        if (!AdaptiveBehavior.$noassert && !this.childrenConsistencyTest()) {
            throw new AssertionError();
        }
        super.removeChildren();
    }
    
    final void addChild(final Step step) {
        if (!AdaptiveBehavior.$noassert) {}
        this.children.add(step);
        BehavingEntity.getBehavingEntity().addStep(step);
        this.changes.firePropertyChange("child", null, step);
    }
    
    final void addChildren() {
        if (!AdaptiveBehavior.$noassert && this.children.size() != 0) {
            throw new AssertionError();
        }
        this.addChild(new ExecutePolicyStep(this));
    }
    
    protected final void removeChild(final Step step, final boolean b) {
        if (!AdaptiveBehavior.$noassert && !this.children.contains(step)) {
            throw new AssertionError((Object)("child == " + step + " current children == " + this.children));
        }
        if (!AdaptiveBehavior.$noassert && !this.childrenConsistencyTest()) {
            throw new AssertionError();
        }
        super.removeChild(step, b);
        this.children.remove(step);
        this.clearLastPursuedGoal();
    }
    
    protected final Step[] getAllSteps() {
        throw new AblRuntimeError("Don't call getAllSteps() on AdaptiveBehaviors");
    }
    
    final boolean isSuccessful() {
        return false;
    }
    
    public String toString() {
        try {
            final String signature = this.getSignature();
            String s = null;
            switch (this.getAdaptiveBehaviorType()) {
                case 0: {
                    s = "adaptive sequential";
                    break;
                }
                case 1: {
                    s = "adaptive parallel";
                    break;
                }
                case 2: {
                    throw new AblRuntimeError("Adaptive collection behaviors currently not supported");
                }
                default: {
                    s = "UNEXPECTED BEHAVIOR TYPE";
                    break;
                }
            }
            return s + ' ' + signature + " priority: " + this.getPriority();
        }
        catch (Exception ex) {
            throw new AblRuntimeError("Reflection error in SequentialBehavior.toString()");
        }
    }
    
    final boolean currentLineOfExpansion(final GoalStep goalStep) {
        if (!AdaptiveBehavior.$noassert && this.parent == null) {
            throw new AssertionError((Object)("AdaptiveBehavior found at the root of the ABT " + this));
        }
        return super.currentLineOfExpansion(goalStep);
    }
    
    void executePolicy() {
        try {
            final ArrayList<SensorActivation> list = new ArrayList<SensorActivation>();
            final SensorActivation[] stateWMESensorActivations = this.getStateWMESensorActivations();
            if (stateWMESensorActivations != null) {
                for (int i = 0; i < stateWMESensorActivations.length; ++i) {
                    list.add(stateWMESensorActivations[i]);
                }
                BehavingEntity.getBehavingEntity().runSensors(new ArrayList(list), false);
            }
            AdaptiveBehavior.oldStateWMEList = (List)this.stateWME.invoke(null, new Integer(this.behaviorID), this.behaviorVariableFrame, BehavingEntity.getBehavingEntity());
            final Step step = (Step)this.stepDescs[(int)this.rlPolicy.invoke(null, AdaptiveBehavior.oldStateWMEList, null, new Double(0.0), new Boolean(false))].factory.invoke(null, new Integer(this.behaviorID), this, this.getBehaviorVariableFrame());
            this.addChild(step);
            step.execute();
        }
        catch (Exception ex) {
            throw new AblRuntimeError("Error invoking executePolicy", ex);
        }
    }
    
    void updatePolicy() {
        try {
            final HashSet<SensorActivation> set = new HashSet<SensorActivation>();
            final SensorActivation[] reinforcementSignalSensorActivations = this.getReinforcementSignalSensorActivations();
            if (reinforcementSignalSensorActivations != null) {
                for (int i = 0; i < reinforcementSignalSensorActivations.length; ++i) {
                    set.add(reinforcementSignalSensorActivations[i]);
                }
            }
            final SensorActivation[] stateWMESensorActivations = this.getStateWMESensorActivations();
            if (stateWMESensorActivations != null) {
                for (int j = 0; j < stateWMESensorActivations.length; ++j) {
                    set.add(stateWMESensorActivations[j]);
                }
            }
            BehavingEntity.getBehavingEntity().runSensors(new ArrayList(set), false);
            (int)this.rlPolicy.invoke(null, AdaptiveBehavior.oldStateWMEList, (List)this.stateWME.invoke(null, new Integer(this.behaviorID), this.behaviorVariableFrame, BehavingEntity.getBehavingEntity()), new Double((double)this.reinforcementSignal.invoke(null, new Integer(this.behaviorID), this.behaviorVariableFrame, BehavingEntity.getBehavingEntity())), new Boolean(true));
        }
        catch (Exception ex) {
            throw new AblRuntimeError("Error invoking updatePolicy", ex);
        }
    }
    
    final float reinforcementSignal() {
        if (!AdaptiveBehavior.$noassert && this.reinforcementSignal == null) {
            throw new AssertionError();
        }
        final Object[] array = { new Integer(this.behaviorID), this.behaviorVariableFrame, BehavingEntity.getBehavingEntity() };
        try {
            return (float)this.reinforcementSignal.invoke(null, array);
        }
        catch (Exception ex) {
            throw new AblRuntimeError("Error invoking reinforcement signal function", ex);
        }
    }
    
    final SensorActivation[] getReinforcementSignalSensorActivations() {
        if (this.reinforcementSignalSensorFactory == null) {
            return null;
        }
        final Object[] array = { new Integer(this.behaviorID) };
        try {
            return (SensorActivation[])this.reinforcementSignalSensorFactory.invoke(null, array);
        }
        catch (Exception ex) {
            throw new AblRuntimeError("Error invoking reinforcement signal sensor factory", ex);
        }
    }
    
    final SensorActivation[] getStateWMESensorActivations() {
        if (this.stateWMESensorFactory == null) {
            return null;
        }
        final Object[] array = { new Integer(this.behaviorID) };
        try {
            return (SensorActivation[])this.stateWMESensorFactory.invoke(null, array);
        }
        catch (Exception ex) {
            throw new AblRuntimeError("Error invoking stateWME sensor factory", ex);
        }
    }
    
    public short getBehaviorType() {
        return 3;
    }
    
    public short getAdaptiveBehaviorType() {
        return this.adaptiveBehaviorType;
    }
    
    public AdaptiveBehavior(final GoalStep goalStep, final Method method, final Method method2, final Method method3, final Method method4, final Method reinforcementSignal, final Method reinforcementSignalSensorFactory, final Method stateWME, final Method stateWMESensorFactory, final Method rlPolicy, final boolean b, final String s, final short n, final int n2, final Object[] array, final __StepDesc[] array2, final short adaptiveBehaviorType) {
        super(goalStep, method, method2, method3, method4, b, s, n, n2, array, array2, -1);
        this.reinforcementSignal = reinforcementSignal;
        this.reinforcementSignalSensorFactory = reinforcementSignalSensorFactory;
        this.stateWME = stateWME;
        this.stateWMESensorFactory = stateWMESensorFactory;
        this.rlPolicy = rlPolicy;
        this.adaptiveBehaviorType = adaptiveBehaviorType;
    }
    
    static {
        $noassert = (Class.forName("[Labl.runtime.AdaptiveBehavior;").getComponentType().desiredAssertionStatus() ^ true);
    }
}
