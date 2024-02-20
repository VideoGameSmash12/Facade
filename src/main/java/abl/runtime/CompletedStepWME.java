package abl.runtime;

import wm.TimeStampedWME;

public abstract class CompletedStepWME extends TimeStampedWME
{
    private String behaviorSignature;
    private String agent;
    
    public synchronized String getBehaviorSignature() {
        return this.behaviorSignature;
    }
    
    public synchronized void setBehaviorSignature(final String behaviorSignature) {
        this.behaviorSignature = behaviorSignature;
    }
    
    public synchronized String getAgent() {
        return this.agent;
    }
    
    public synchronized void setAgent(final String agent) {
        this.agent = agent;
    }
    
    public CompletedStepWME(final String behaviorSignature, final String agent, final long n) {
        super(n);
        this.behaviorSignature = behaviorSignature;
        this.agent = agent;
    }
    
    public CompletedStepWME(final String behaviorSignature, final String agent) {
        this.behaviorSignature = behaviorSignature;
        this.agent = agent;
    }
}
