package facade.util;

public class ObjectSensePacket implements SpriteID
{
    public final ObjectSenseInfo[] info;
    
    public void setObjectInfo(final int objectID, final float x, final float y, final float z, final int n) {
        this.info[n].objectID = objectID;
        this.info[n].x = x;
        this.info[n].y = y;
        this.info[n].z = z;
    }
    
    public ObjectSensePacket() {
        this.info = new ObjectSenseInfo[49];
        for (int i = 0; i < this.info.length; ++i) {
            this.info[i] = new ObjectSenseInfo();
        }
    }
    
    public class ObjectSenseInfo
    {
        public int objectID;
        public float x;
        public float y;
        public float z;
        
        private final /* synthetic */ void this() {
            this.objectID = -1;
            this.x = Float.NEGATIVE_INFINITY;
            this.y = Float.NEGATIVE_INFINITY;
            this.z = Float.NEGATIVE_INFINITY;
        }
        
        public ObjectSenseInfo() {
            this.this();
        }
    }
}
