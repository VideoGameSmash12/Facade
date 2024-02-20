package dramaman.runtime;

import java.awt.Component;
import javax.swing.JSplitPane;
import wm.WorkingMemory;
import java.util.Hashtable;
import wm.WorkingMemoryDebugger;
import javax.swing.JFrame;

public class DramaManagerMonitor extends JFrame
{
    protected BeatMonitor beatMonitor;
    protected WorkingMemoryDebugger storyMemoryMonitor;
    
    void succeedBeat(final Beat beat) {
        this.beatMonitor.succeedBeat(beat);
    }
    
    void failBeat(final Beat beat) {
        this.beatMonitor.failBeat(beat);
    }
    
    public void chooseBeat(final Beat beat) {
        this.beatMonitor.chooseBeat(beat);
    }
    
    public void refreshSatisfiedBeats(final Beat[] array, final Hashtable hashtable, final int n) {
        this.beatMonitor.refreshSatisfiedBeats(array, hashtable, n);
    }
    
    public void setStory(final Beat[] array, final int n, final Hashtable hashtable) {
        this.beatMonitor.setStory(array, n, hashtable);
    }
    
    public void setCumulativeError(final double cumulativeError) {
        this.beatMonitor.setCumulativeError(cumulativeError);
    }
    
    public DramaManagerMonitor() {
        this.setTitle("Drama Manager Monitor");
        this.beatMonitor = new BeatMonitor();
        this.storyMemoryMonitor = new WorkingMemoryDebugger(DramaManager.getStoryMemory());
        final JSplitPane splitPane = new JSplitPane(0, true, this.storyMemoryMonitor, this.beatMonitor);
        splitPane.setOneTouchExpandable(true);
        splitPane.setResizeWeight(0.5);
        this.getContentPane().add(splitPane);
        this.pack();
        this.setVisible(true);
        splitPane.setDividerLocation(0.3);
    }
}
