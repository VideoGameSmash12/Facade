package dramaman.runtime;

import wm.WME;
import facade.characters.wmedef.BeatRevelationsP2WME;
import java.awt.Component;
import javax.swing.JFrame;
import wm.WorkingMemory;

public class DramaManagerMain
{
    public static void main(final String[] array) {
        if (array == null || array.length == 0) {
            System.out.println("usage: DramaManager.main(<package-name>)");
        }
        else {
            final WorkingMemory workingMemory = new WorkingMemory("BeatMemory");
            final JFrame frame = new JFrame("Beat Memory Debugger");
            frame.getContentPane().add(workingMemory.getWMDebugInterface());
            frame.pack();
            frame.show();
            final DramaManager dramaManager = new DramaManager("facade.beats", true, true);
            final BeatRevelationsP2WME beatRevelationsP2WME = new BeatRevelationsP2WME(-1, -1, -1, -1, -1, -1, -1, -1, -1, false, false);
            DramaManager.getDramaManager();
            DramaManager.addWME(beatRevelationsP2WME);
            dramaManager.startManaging();
        }
    }
}
