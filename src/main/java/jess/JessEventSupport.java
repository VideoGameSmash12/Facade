package jess;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class JessEventSupport implements Serializable {
    private List m_listeners;

    private int m_eventMask;

    JessEventSupport(Rete paramRete) {
        this.m_listeners = Collections.synchronizedList(new ArrayList());
        this.m_eventMask = 0;
        addJessListener(paramRete);
    }

    public void addJessListener(JessListener paramJessListener) {
        this.m_listeners.add(paramJessListener);
    }

    public void removeJessListener(JessListener paramJessListener) {
        this.m_listeners.remove(paramJessListener);
    }

    public Iterator listJessListeners() {
        synchronized (this.m_listeners) {
            return (new ArrayList(this.m_listeners)).iterator();
        }
    }

    public synchronized int getEventMask() {
        return this.m_eventMask;
    }

    public synchronized void setEventMask(int paramInt) {
        this.m_eventMask = paramInt;
    }

    final void broadcastEvent(Object paramObject1, int paramInt, Object paramObject2) throws JessException {
        int i;
        if ((paramInt & getEventMask()) == 0)
            return;
        synchronized (this.m_listeners) {
            if ((i = this.m_listeners.size()) == 0)
                return;
        }
        ArrayList arrayList = new ArrayList(this.m_listeners);
        /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_6} */
        for (byte b = 0; b < i; b++) {
            try {
                JessEvent jessEvent = new JessEvent(paramObject1, paramInt, paramObject2);
                ((JessListener)arrayList.get(b)).eventHappened(jessEvent);
            } catch (JessException jessException) {
                throw jessException;
            } catch (Exception exception) {
                throw new JessException("JessEventSupport.broadcastEvent", "Event handler threw an exception", exception);
            }
        }
    }
}
