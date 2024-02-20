package jess;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.Serializable;

public class HeapPriorityQueue implements Serializable
{
    private Activation[] m_queue;
    private Strategy m_strategy;
    private int m_size;
    
    public Strategy setStrategy(final Strategy strategy) {
        final Strategy strategy2 = this.m_strategy;
        this.m_strategy = strategy;
        return strategy2;
    }
    
    public Strategy getStrategy() {
        return this.m_strategy;
    }
    
    public boolean isEmpty() {
        boolean b = false;
        if (this.m_size == 0) {
            b = true;
        }
        return b;
    }
    
    public synchronized void remove(final Activation activation) {
        for (int i = 1; i <= this.m_size; ++i) {
            if (this.m_queue[i].equals(activation)) {
                this.m_queue[i] = this.m_queue[this.m_size];
                this.m_queue[this.m_size] = null;
                --this.m_size;
                this.fixDown(i);
                return;
            }
        }
    }
    
    public synchronized void push(final Activation activation) {
        if (this.m_size == this.m_queue.length - 1) {
            final Activation[] queue = new Activation[this.m_size * 2];
            System.arraycopy(this.m_queue, 1, queue, 1, this.m_size);
            this.m_queue = queue;
        }
        this.m_queue[++this.m_size] = activation;
        this.fixUp(this.m_size);
        this.notify();
    }
    
    public synchronized Activation pop() {
        if (this.isEmpty()) {
            return null;
        }
        final Activation activation = this.m_queue[1];
        this.remove(activation);
        return activation;
    }
    
    public void clear() {
        this.m_queue = new Activation[10];
        this.m_size = 0;
    }
    
    public Iterator iterator() {
        final HeapPriorityQueue heapPriorityQueue = new HeapPriorityQueue(this);
        final ArrayList<Activation> list = new ArrayList<Activation>();
        while (!heapPriorityQueue.isEmpty()) {
            list.add(heapPriorityQueue.pop());
        }
        return list.iterator();
    }
    
    private final void fixDown(int n) {
        final Activation[] queue = this.m_queue;
        while (2 * n <= this.m_size) {
            int n2 = 2 * n;
            if (n2 < this.m_size && this.m_strategy.compare(queue[n2], queue[n2 + 1]) > 0) {
                ++n2;
            }
            if (this.m_strategy.compare(queue[n], queue[n2]) <= 0) {
                break;
            }
            this.exch(n, n2);
            n = n2;
        }
    }
    
    private final void fixUp(int n) {
        int n2;
        for (Activation[] queue = this.m_queue; n > 1 && this.m_strategy.compare(queue[n / 2], queue[n]) > 0; n = n2) {
            n2 = n / 2;
            this.exch(n, n2);
        }
    }
    
    private final void exch(final int n, final int n2) {
        final Activation[] queue = this.m_queue;
        final Activation activation = queue[n];
        queue[n] = queue[n2];
        queue[n2] = activation;
    }
    
    private final void writeObject(final ObjectOutputStream objectOutputStream) throws IOException {
        final HeapPriorityQueue heapPriorityQueue = new HeapPriorityQueue(this.m_strategy);
        while (!this.isEmpty()) {
            final Activation pop = this.pop();
            if (!pop.isInactive()) {
                heapPriorityQueue.push(pop);
            }
        }
        this.m_queue = heapPriorityQueue.m_queue;
        this.m_size = heapPriorityQueue.m_size;
        objectOutputStream.defaultWriteObject();
    }
    
    public HeapPriorityQueue(final Strategy strategy) {
        this.m_queue = new Activation[10];
        this.m_strategy = strategy;
    }
    
    private HeapPriorityQueue(final HeapPriorityQueue heapPriorityQueue) {
        this.m_queue = heapPriorityQueue.m_queue.clone();
        this.m_size = heapPriorityQueue.m_size;
        this.m_strategy = heapPriorityQueue.m_strategy;
    }
}
