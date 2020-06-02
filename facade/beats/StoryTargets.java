package facade.beats;

import java.util.List;
import dramaman.runtime.StoryTarget;
import java.awt.geom.Point2D;
import java.util.Vector;
import java.util.Hashtable;

public class StoryTargets
{
    public static Hashtable getTargets() {
        final Vector<Point2D.Float> vector = new Vector<Point2D.Float>();
        vector.add(new Point2D.Float(6.0f, 1.0f));
        vector.add(new Point2D.Float(7.0f, 2.0f));
        vector.add(new Point2D.Float(8.0f, 2.0f));
        vector.add(new Point2D.Float(9.0f, 3));
        final StoryTarget storyTarget = new StoryTarget("tension", "TensionStoryValueWME", 3, 3, 17, vector);
        final Hashtable<String, StoryTarget> hashtable = new Hashtable<String, StoryTarget>();
        hashtable.put("tension", storyTarget);
        return hashtable;
    }
}
