package abl.runtime;

import java.util.Vector;

class AblEventSupport
{
    private Vector listeners;
    private Object source;
    
    void addAblListener(final AblListener ablListener) {
        this.listeners.add(ablListener);
    }
    
    void removeAblListener(final AblListener ablListener) {
        this.listeners.remove(ablListener);
    }
    
    void setSource(final Object source) {
        this.source = source;
    }
    
    void fireAblEvent(final int n, final Object o) {
        final AblEvent ablEvent = new AblEvent(this.source, n, o);
        for (int i = 0; i < this.listeners.size(); ++i) {
            ((AblListener)this.listeners.get(i)).eventHappened(ablEvent);
        }
    }
    
    void fireAblEvent(final int n, final Object o, final int n2) {
        final AblEvent ablEvent = new AblEvent(this.source, n, o, n2);
        for (int i = 0; i < this.listeners.size(); ++i) {
            ((AblListener)this.listeners.get(i)).eventHappened(ablEvent);
        }
    }
    
    void fireAblEvent(final int n, final Object o, final Object o2, final int n2) {
        final AblEvent ablEvent = new AblEvent(o, n, o2, n2);
        for (int i = 0; i < this.listeners.size(); ++i) {
            ((AblListener)this.listeners.get(i)).eventHappened(ablEvent);
        }
    }
    
    private final /* synthetic */ void this() {
        this.listeners = new Vector();
    }
    
    AblEventSupport() {
        this.this();
        this.source = null;
    }
    
    AblEventSupport(final Object source) {
        this.this();
        this.source = source;
    }
}
