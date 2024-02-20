package facade.characters.wmedef;

import wm.WME;

public class DAReferToWME extends WME
{
    private int topicID;
    private long timestamp;
    
    public synchronized int getTopicID() {
        return this.topicID;
    }
    
    public synchronized long getTimestamp() {
        return this.timestamp;
    }
    
    public synchronized void setTopicID(final int topicID) {
        this.topicID = topicID;
    }
    
    public synchronized void setTimestamp(final long timestamp) {
        this.timestamp = timestamp;
    }
    
    public DAReferToWME(final int topicID, final long timestamp) {
        this.topicID = topicID;
        this.timestamp = timestamp;
    }
    
    public DAReferToWME() {
    }
}
