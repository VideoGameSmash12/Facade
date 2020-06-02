package facade.util;

public class AnimCueSensePacket implements SpriteID, AnimLayer
{
    private final int[][] cues;
    private static final /* synthetic */ boolean $noassert;
    
    public void setCueInfo(final int n, final int[] array) {
        if (!AnimCueSensePacket.$noassert && array.length != 8) {
            throw new AssertionError();
        }
        for (int i = 0; i < 8; ++i) {
            this.cues[n][i] = array[i];
        }
    }
    
    public int getCueInfo(final int n, final int n2) {
        return this.cues[n][n2];
    }
    
    private final /* synthetic */ void this() {
        this.cues = new int[3][8];
    }
    
    public AnimCueSensePacket() {
        this.this();
    }
    
    static {
        $noassert = (Class.forName("[Lfacade.util.AnimCueSensePacket;").getComponentType().desiredAssertionStatus() ^ true);
    }
}
