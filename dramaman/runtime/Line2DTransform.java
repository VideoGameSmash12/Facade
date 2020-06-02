package dramaman.runtime;

import java.awt.geom.Point2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;

public class Line2DTransform extends Float
{
    public Line2DTransform(final float n, final float n2, final float n3, final float n4, final AffineTransform affineTransform) {
        super(((Point2D.Float)affineTransform.transform(new Point2D.Float(n, n2), null)).x, ((Point2D.Float)affineTransform.transform(new Point2D.Float(n, n2), null)).y, ((Point2D.Float)affineTransform.transform(new Point2D.Float(n3, n4), null)).x, ((Point2D.Float)affineTransform.transform(new Point2D.Float(n3, n4), null)).y);
    }
}
