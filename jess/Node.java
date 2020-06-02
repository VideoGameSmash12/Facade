package jess;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.io.Serializable;

public abstract class Node implements Serializable
{
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public int m_usecount;
    Node[] m_succ;
    int m_nSucc;
    private transient Hashtable m_listeners;
    
    public Enumeration getSuccessors() {
        return new NodeEnumeration();
    }
    
    Node resolve(final Node node) {
        for (int i = 0; i < this.m_nSucc; ++i) {
            if (this.m_succ[i].equals(node)) {
                return this.m_succ[i];
            }
        }
        return node;
    }
    
    void addSuccessor(final Node node, final NodeSink nodeSink) throws JessException {
        if (this.m_succ == null || this.m_nSucc == this.m_succ.length) {
            final Node[] succ = this.m_succ;
            this.m_succ = new Node[this.m_nSucc + 5];
            if (succ != null) {
                System.arraycopy(succ, 0, this.m_succ, 0, this.m_nSucc);
            }
        }
        nodeSink.addNode(this.m_succ[this.m_nSucc++] = node);
    }
    
    Node mergeSuccessor(final Node node, final NodeSink nodeSink) throws JessException {
        for (int i = 0; i < this.m_nSucc; ++i) {
            final Node node2 = this.m_succ[i];
            if (node.equals(node2)) {
                nodeSink.addNode(node2);
                return node2;
            }
        }
        this.addSuccessor(node, nodeSink);
        return node;
    }
    
    void removeSuccessor(final Node node) {
        for (int i = 0; i < this.m_nSucc; ++i) {
            if (node == this.m_succ[i]) {
                System.arraycopy(this.m_succ, i + 1, this.m_succ, i, --this.m_nSucc - i);
                return;
            }
        }
    }
    
    void callNodeLeft(final Token token, final Context context) throws JessException {
        throw new JessException("callNodeLeft", "Undefined in class", this.getClass().getName());
    }
    
    void callNodeRight(final Token token, final Context context) throws JessException {
        throw new JessException("callNodeRight", "Undefined in class", this.getClass().getName());
    }
    
    public void addJessListener(final JessListener jessListener) {
        if (this.m_listeners == null) {
            this.m_listeners = new Hashtable();
        }
        this.m_listeners.put(jessListener, jessListener);
    }
    
    public void removeJessListener(final JessListener jessListener) {
        if (this.m_listeners == null) {
            return;
        }
        this.m_listeners.remove(jessListener);
        if (this.m_listeners.size() == 0) {
            this.m_listeners = null;
        }
    }
    
    void broadcastEvent(final int n, final Object o) throws JessException {
        if (this.m_listeners != null && this.m_listeners.size() != 0) {
            final Enumeration<JessListener> elements = (Enumeration<JessListener>)this.m_listeners.elements();
            final JessEvent jessEvent = new JessEvent(this, n, o);
            while (elements.hasMoreElements()) {
                elements.nextElement().eventHappened(jessEvent);
            }
        }
    }
    
    private final void readObject(final ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
    }
    
    abstract String getCompilationTraceToken();
    
    private final /* synthetic */ void this() {
        this.m_usecount = 0;
    }
    
    public Node() {
        this.this();
    }
    
    private class NodeEnumeration implements Enumeration
    {
        private int m_index;
        
        public boolean hasMoreElements() {
            boolean b = false;
            if (this.m_index < Node.this.m_nSucc) {
                b = true;
            }
            return b;
        }
        
        public Object nextElement() {
            if (!this.hasMoreElements()) {
                throw new RuntimeException("No more elements!");
            }
            return Node.this.m_succ[this.m_index++];
        }
        
        private final /* synthetic */ void this() {
            this.m_index = 0;
        }
        
        private NodeEnumeration() {
            this.this();
        }
    }
}
