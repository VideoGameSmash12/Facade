package facade.characters.wmedef;

import facade.util.PrintUtilities;
import wm.WME;

public class TopicReferenceCountWME extends WME
{
    private int topicID;
    private int count;
    
    public synchronized String formatTopicID() {
        return PrintUtilities.daParam1_EnumToString(this.getTopicID());
    }
    
    public synchronized int getTopicID() {
        return this.topicID;
    }
    
    public void setTopicID(final int p0) {
        synchronized (this) {
            int i = this.topicID;
            this.topicID = paramInt;
            this.__support.firePropertyChange("topicID", i, paramInt);
        }
    }
    
    public synchronized int getCount() {
        return this.count;
    }
    
    public void setCount(final int p0) {
        synchronized (this) {
          int i = this.count;
          this.count = paramInt;
          this.__support.firePropertyChange("count", i, paramInt);
        }
    }
    
    public TopicReferenceCountWME(final int topicID) {
        this.topicID = topicID;
        this.count = 0;
    }
    
    public TopicReferenceCountWME() {
    }
}
