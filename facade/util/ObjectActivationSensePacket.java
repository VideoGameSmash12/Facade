package facade.util;

public class ObjectActivationSensePacket implements SpriteID
{
    private final ObjectActivationEntry[] activationEntries;
    private static final /* synthetic */ boolean $noassert;
    
    public void setActivationInfo(final int[] array, final int[] array2) {
        if (!ObjectActivationSensePacket.$noassert && (array.length != 49 || array2.length != 49)) {
            throw new AssertionError();
        }
        for (int i = 0; i < 49; ++i) {
            this.activationEntries[i].activation = array[i];
            this.activationEntries[i].activatorID = array2[i];
        }
    }
    
    public ObjectActivationEntry getActivationInfo(final int n) {
        return new ObjectActivationEntry(this.activationEntries[n]);
    }
    
    public ObjectActivationSensePacket() {
        this.activationEntries = new ObjectActivationEntry[49];
        for (int i = 0; i < this.activationEntries.length; ++i) {
            this.activationEntries[i] = new ObjectActivationEntry();
        }
    }
    
    static {
        $noassert = (Class.forName("[Lfacade.util.ObjectActivationSensePacket;").getComponentType().desiredAssertionStatus() ^ true);
    }
    
    public class ObjectActivationEntry
    {
        public int activation;
        public int activatorID;
        
        private final /* synthetic */ void this() {
            this.activation = -1;
            this.activatorID = -1;
        }
        
        ObjectActivationEntry() {
            this.this();
            this.activation = -1;
            this.activatorID = -1;
        }
        
        ObjectActivationEntry(final ObjectActivationEntry objectActivationEntry) {
            this.this();
            this.activation = objectActivationEntry.activation;
            this.activatorID = objectActivationEntry.activatorID;
        }
    }
}
