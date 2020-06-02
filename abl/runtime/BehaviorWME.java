package abl.runtime;

import java.util.List;
import wm.WME;

public class BehaviorWME extends WME
{
    protected Behavior behavior;
    protected GoalStepWME parent;
    protected boolean valid;
    private static final /* synthetic */ boolean $noassert;
    
    public synchronized boolean getHasContextCondition() {
        return this.behavior.getHasContextCondition();
    }
    
    public synchronized int getSpecificity() {
        return this.behavior.getSpecificity();
    }
    
    public synchronized String getSignature() {
        return this.behavior.getSignature();
    }
    
    public synchronized GoalStepWME getParent() {
        if (!BehaviorWME.$noassert && (this.behavior.isRootBehavior() || this.parent == null) && (!this.behavior.isRootBehavior() || this.parent != null)) {
            throw new AssertionError();
        }
        return this.parent;
    }
    
    public synchronized int getBehaviorType() {
        return this.behavior.getBehaviorType();
    }
    
    public synchronized Object getProperty(final String s) {
        return this.behavior.propertyTable.getProperty(s);
    }
    
    public synchronized void setProperty(final String s, final Object o) {
        this.behavior.propertyTable.setProperty(s, o);
    }
    
    public synchronized void deleteProperty(final String s) {
        this.behavior.propertyTable.deleteProperty(s);
    }
    
    public synchronized List getAllDefinedProperties() {
        return this.behavior.propertyTable.getAllDefinedProperties();
    }
    
    synchronized Behavior getBehavior() {
        if (this.isValid()) {
            return this.behavior;
        }
        return null;
    }
    
    public synchronized boolean isValid() {
        return this.valid;
    }
    
    public synchronized boolean isParent(final GoalStepWME goalStepWME) {
        return this.parent != null && (this.parent == goalStepWME || this.parent.isParent(goalStepWME));
    }
    
    public synchronized boolean isParent(final BehaviorWME behaviorWME) {
        return this.parent != null && this.parent.isParent(behaviorWME);
    }
    
    void delete() {
        this.valid = false;
    }
    
    public String toString() {
        return this.objectToString() + super.toString();
    }
    
    private final /* synthetic */ void this() {
        this.parent = null;
        this.valid = true;
    }
    
    public BehaviorWME(final Behavior behavior, final GoalStepWME parent) {
        this.this();
        this.behavior = behavior;
        this.parent = parent;
        behavior.setReflectionWME(this);
    }
    
    static {
        $noassert = (Class.forName("[Labl.runtime.BehaviorWME;").getComponentType().desiredAssertionStatus() ^ true);
    }
}
