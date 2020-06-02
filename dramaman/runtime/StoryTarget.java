package dramaman.runtime;

import java.util.Iterator;
import java.util.List;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.Graphics2D;
import java.util.Arrays;
import java.awt.geom.Point2D;

public class StoryTarget
{
    public static final int LINEAR = 0;
    public static final int DIP = 1;
    public static final int BUMP = 2;
    private String valueName;
    private String valueWMEName;
    private float targetMin;
    private float targetMax;
    private float initialValue;
    private int arcType;
    private int averageBeatLength;
    private InflectionPoint[] inflectionPoints;
    private static final /* synthetic */ boolean $noassert;
    
    public String getValueName() {
        return this.valueName;
    }
    
    public String getValueWMEName() {
        return this.valueWMEName;
    }
    
    public float getInitialValue() {
        return this.initialValue;
    }
    
    public float getTargetMin() {
        return this.targetMin;
    }
    
    public float getTargetMax() {
        return this.targetMax;
    }
    
    private final SegmentEndpoints getSegmentEndpoints(final int n) {
        if (this.inflectionPoints.length == 0) {
            return new SegmentEndpoints(new Point2D.Float(0.0f, this.initialValue), new Point2D.Float((float)this.averageBeatLength, this.targetMin + (this.targetMax - this.targetMin) / 2.0f));
        }
        int n2 = Arrays.binarySearch(this.inflectionPoints, new InflectionPoint((float)n, 0.0f));
        if (n2 == -1 || n2 == 0) {
            return new SegmentEndpoints(new Point2D.Float(0.0f, this.initialValue), this.inflectionPoints[0]);
        }
        if (n2 == -this.inflectionPoints.length - 1) {
            return new SegmentEndpoints(this.inflectionPoints[this.inflectionPoints.length - 1], new Point2D.Float((float)this.averageBeatLength, this.targetMin + (this.targetMax - this.targetMin) / 2.0f));
        }
        if (n2 < 0) {
            n2 = Math.abs(n2 + 1);
        }
        return new SegmentEndpoints(this.inflectionPoints[n2 - 1], this.inflectionPoints[n2]);
    }
    
    public float getDesiredValue(final int n) {
        final SegmentEndpoints segmentEndpoints = this.getSegmentEndpoints(n);
        if (!StoryTarget.$noassert && segmentEndpoints.endPoint.x <= segmentEndpoints.beginPoint.x) {
            throw new AssertionError((Object)("Endpoint < beginpoint " + segmentEndpoints));
        }
        final float n2 = (segmentEndpoints.endPoint.y - segmentEndpoints.beginPoint.y) / (segmentEndpoints.endPoint.x - segmentEndpoints.beginPoint.x);
        return n2 * n + (segmentEndpoints.beginPoint.y - n2 * segmentEndpoints.beginPoint.x);
    }
    
    public float getDesiredSlope(final int n, final float n2) {
        final SegmentEndpoints segmentEndpoints = this.getSegmentEndpoints(n);
        if (!StoryTarget.$noassert && segmentEndpoints.endPoint.x <= segmentEndpoints.beginPoint.x) {
            throw new AssertionError();
        }
        return (segmentEndpoints.endPoint.y - n2) / (segmentEndpoints.endPoint.x - n + 1.0f);
    }
    
    public float getSquaredError(final int n, final int n2) {
        final float n3 = this.getDesiredValue(n) - n2;
        return n3 * n3;
    }
    
    public void drawTarget(final Graphics2D graphics2D, final int n, final AffineTransform affineTransform) {
        float desiredValue = this.getDesiredValue(0);
        for (int i = 1; i <= n; ++i) {
            final float desiredValue2 = this.getDesiredValue(i);
            graphics2D.draw(new Line2DTransform(i - 1.0f, desiredValue, (float)i, desiredValue2, affineTransform));
            desiredValue = desiredValue2;
        }
        final Point2D.Float float1 = (Point2D.Float)affineTransform.transform(new Point2D.Float((float)n, this.getDesiredValue(n)), null);
        graphics2D.drawString(this.valueName, float1.x, float1.y);
    }
    
    public StoryTarget(final String valueName, final String valueWMEName, final float targetMin, final float targetMax, final int averageBeatLength, final int arcType) {
        this.valueName = valueName;
        this.valueWMEName = valueWMEName;
        this.targetMin = targetMin;
        this.targetMax = targetMax;
        this.initialValue = StoryMemory.getStoryMemory().getStoryValue(valueWMEName);
        this.averageBeatLength = averageBeatLength;
        if (arcType != 0 && arcType != 1 && arcType != 2) {
            throw new DramaManagerError("Illegal arc type " + arcType + " in StoryTarget constructor.");
        }
        switch (arcType) {
            case 0: {
                this.inflectionPoints = new InflectionPoint[0];
                break;
            }
            case 1: {
                (this.inflectionPoints = new InflectionPoint[1])[0] = new InflectionPoint((float)(this.averageBeatLength / 2), Math.max(Math.min(this.targetMin, this.initialValue) - 10.0f, 0.0f));
                break;
            }
            case 2: {
                (this.inflectionPoints = new InflectionPoint[1])[0] = new InflectionPoint((float)(this.averageBeatLength / 2), Math.min(Math.max(this.targetMax, this.initialValue) + 10.0f, 100.0f));
                break;
            }
        }
        this.arcType = arcType;
    }
    
    public StoryTarget(final String valueName, final String valueWMEName, final float targetMin, final float targetMax, final int averageBeatLength, final List list) {
        this.valueName = valueName;
        this.valueWMEName = valueWMEName;
        this.targetMin = targetMin;
        this.targetMax = targetMax;
        this.initialValue = StoryMemory.getStoryMemory().getStoryValue(valueWMEName);
        this.averageBeatLength = averageBeatLength;
        this.arcType = -1;
        this.inflectionPoints = new InflectionPoint[list.size()];
        final Iterator<Point2D.Float> iterator = list.iterator();
        int n = 0;
        while (iterator.hasNext()) {
            final Point2D.Float next = iterator.next();
            if (!next.getClass().getName().equals("java.awt.geom.Point2D$Float")) {
                throw new DramaManagerError("Illegal object " + next.getClass() + " passed as an arc inflection point to StoryTarget constructor");
            }
            this.inflectionPoints[n] = new InflectionPoint(next.x, next.y);
            ++n;
        }
        Arrays.sort(this.inflectionPoints);
    }
    
    static {
        $noassert = (Class.forName("[Ldramaman.runtime.StoryTarget;").getComponentType().desiredAssertionStatus() ^ true);
    }
    
    class InflectionPoint extends Float implements Comparable
    {
        public int compareTo(final Object o) {
            final InflectionPoint inflectionPoint = (InflectionPoint)o;
            if (this.x < inflectionPoint.x) {
                return -1;
            }
            if (this.x == inflectionPoint.x) {
                return 0;
            }
            return 1;
        }
        
        InflectionPoint(final float n, final float n2) {
            super(n, n2);
        }
    }
    
    class SegmentEndpoints
    {
        Point2D.Float beginPoint;
        Point2D.Float endPoint;
        
        public String toString() {
            return "SegmentEndpoints: (" + this.beginPoint.x + ", " + this.beginPoint.y + ")(" + this.endPoint.x + ", " + this.endPoint.y + ')';
        }
        
        SegmentEndpoints(final Point2D.Float beginPoint, final Point2D.Float endPoint) {
            this.beginPoint = beginPoint;
            this.endPoint = endPoint;
        }
    }
}
