package abl.runtime;

import java.util.List;
import wm.WME;

public class StepWME extends WME
{
    protected Step s;
    protected BehaviorWME parent;
    protected boolean valid;
    private static final /* synthetic */ boolean $noassert;
    
    public synchronized boolean getPersistent() {
        return this.s.getPersistent();
    }
    
    public synchronized boolean getPersistentWhenSucceeds() {
        return this.s.getPersistentWhenSucceeds();
    }
    
    public synchronized boolean getPersistentWhenFails() {
        return this.s.getPersistentWhenFails();
    }
    
    public synchronized boolean getIgnoreFailure() {
        return this.s.getIgnoreFailure();
    }
    
    public synchronized boolean getHasSuccessTest() {
        return this.s.getHasSuccessTest();
    }
    
    public synchronized boolean getEffectOnly() {
        return this.s.getEffectOnly();
    }
    
    public synchronized boolean getIsAtomic() {
        return this.s.getIsAtomic();
    }
    
    public synchronized short getPriority() {
        return this.s.getPriority();
    }
    
    public synchronized boolean getIsSuspended() {
        return this.s.isSuspended();
    }
    
    public synchronized BehaviorWME getParent() {
        return this.parent;
    }
    
    public synchronized short getStepType() {
        return this.s.getStepType();
    }
    
    public synchronized boolean getValid() {
        return this.valid;
    }
    
    public synchronized void setPersistent(final boolean persistent) {
        this.s.setPersistent(persistent);
    }
    
    public synchronized void setPersistentWhenSucceeds(final boolean persistentWhenSucceeds) {
        this.s.setPersistentWhenSucceeds(persistentWhenSucceeds);
    }
    
    public synchronized void setPersistentWhenFails(final boolean persistentWhenFails) {
        this.s.setPersistentWhenFails(persistentWhenFails);
    }
    
    public synchronized void setIgnoreFailure(final boolean ignoreFailure) {
        this.s.setIgnoreFailure(ignoreFailure);
    }
    
    public synchronized void setEffectOnly(final boolean effectOnly) {
        this.s.setEffectOnly(effectOnly);
    }
    
    public synchronized void setPriority(final short priority) {
        this.s.setPriority(priority);
    }
    
    public synchronized Object getProperty(final String s) {
        return this.s.propertyTable.getProperty(s);
    }
    
    public synchronized void setProperty(final String s, final Object o) {
        ((GoalStep)this.s).propertyTable.setProperty(s, o);
    }
    
    public synchronized void deleteProperty(final String s) {
        ((GoalStep)this.s).propertyTable.deleteProperty(s);
    }
    
    public synchronized List getAllDefinedProperties() {
        return this.s.propertyTable.getAllDefinedProperties();
    }
    
    public boolean isValid() {
        return this.valid;
    }
    
    public synchronized void fail() {
        if (this.isValid() && this.s != null) {
            this.s.failStep();
        }
    }
    
    public synchronized void succeed() {
        if (this.isValid() && this.s != null) {
            this.s.succeedStep();
        }
    }
    
    public synchronized boolean isParent(final GoalStepWME goalStepWME) {
        return this.parent.isParent(goalStepWME);
    }
    
    public synchronized boolean isParent(final BehaviorWME behaviorWME) {
        return this.parent == behaviorWME || this.parent.isParent(behaviorWME);
    }
    
    void delete() {
        this.valid = false;
    }
    
    public String toString() {
        return this.objectToString() + super.toString();
    }
    
    private final /* synthetic */ void this() {
        this.valid = true;
    }
    
    public StepWME(final Step s, final BehaviorWME parent) {
        this.this();
        if (!StepWME.$noassert && parent == null) {
            throw new AssertionError();
        }
        this.s = s;
        this.parent = parent;
        s.setReflectionWME(this);
    }
    
    static {
        $noassert = (Class.forName("[Labl.runtime.StepWME;").getComponentType().desiredAssertionStatus() ^ true);
    }
}
