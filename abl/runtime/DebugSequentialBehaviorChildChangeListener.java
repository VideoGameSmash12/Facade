package abl.runtime;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class DebugSequentialBehaviorChildChangeListener implements PropertyChangeListener
{
    SequentialBehavior b;
    private static final /* synthetic */ boolean $noassert;
    
    public void propertyChange(final PropertyChangeEvent propertyChangeEvent) {
        if (!DebugSequentialBehaviorChildChangeListener.$noassert && ((propertyChangeEvent.getOldValue() != null && propertyChangeEvent.getNewValue() != null) || (propertyChangeEvent.getOldValue() == null && propertyChangeEvent.getNewValue() == null))) {
            throw new AssertionError((Object)("Behavior " + this.b));
        }
        if (propertyChangeEvent.getOldValue() == null) {
            System.out.println("Adding child " + propertyChangeEvent.getNewValue() + " to sequential behavior " + this.b.getSignature());
            System.out.println("ignoreFailure = " + ((Step)propertyChangeEvent.getNewValue()).getIgnoreFailure());
            Thread.currentThread();
            Thread.dumpStack();
        }
        else {
            System.out.println("Removing child " + propertyChangeEvent.getOldValue() + " from sequential behavior " + this.b.getSignature());
            Thread.currentThread();
            Thread.dumpStack();
        }
    }
    
    public DebugSequentialBehaviorChildChangeListener(final SequentialBehavior b) {
        this.b = b;
    }
    
    static {
        $noassert = (Class.forName("[Labl.runtime.DebugSequentialBehaviorChildChangeListener;").getComponentType().desiredAssertionStatus() ^ true);
    }
}
