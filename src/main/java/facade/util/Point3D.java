package facade.util;

public class Point3D
{
    public float x;
    public float y;
    public float z;
    
    public synchronized void setX(final float x) {
        this.x = x;
    }
    
    public synchronized void setY(final float y) {
        this.y = y;
    }
    
    public synchronized void setZ(final float z) {
        this.z = z;
    }
    
    public Point3D() {
    }
    
    public Point3D(final float x, final float y, final float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
