package facade.characters.player.java;

import wm.WME;

public class SameAffinityBeatCounterWME extends WME
{
    private int targetBeatCount;
    private int counter;
    private int targetAffinity;
    
    public synchronized int getTargetBeatCount() {
        return this.targetBeatCount;
    }
    
    public synchronized int getCounter() {
        return this.counter;
    }
    
    public synchronized int getTargetAffinity() {
        return this.targetAffinity;
    }
    
    public synchronized void setTargetBeatCount(final int targetBeatCount) {
        this.targetBeatCount = targetBeatCount;
    }
    
    public synchronized void setCounter(final int counter) {
        this.counter = counter;
    }
    
    public synchronized void setTargetAffinity(final int targetAffinity) {
        this.targetAffinity = targetAffinity;
    }
    
    public SameAffinityBeatCounterWME(final int targetBeatCount, final int counter, final int targetAffinity) {
        this.targetBeatCount = targetBeatCount;
        this.counter = counter;
        this.targetAffinity = targetAffinity;
    }
    
    public SameAffinityBeatCounterWME() {
    }
}
