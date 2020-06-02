package facade.primact;

import facade.nativeinterface.NativeAnimationInterface;
import facade.util.SpriteID;
import facade.util.AnimLayer;

public class PushMultipleAnimationScripts extends FacadeAsynchronousAction implements AnimLayer, SpriteID
{
    private int character;
    private int layer;
    private static final /* synthetic */ boolean $noassert;
    
    public void execute(final Object[] array) {
        final int intValue = (int)array[0];
        final int intValue2 = (int)array[1];
        final int intValue3 = (int)array[2];
        final int intValue4 = (int)array[3];
        final int intValue5 = (int)array[4];
        final int intValue6 = (int)array[5];
        final boolean booleanValue = (boolean)array[6];
        this.character = intValue;
        this.layer = intValue6;
        if (booleanValue) {
            NativeAnimationInterface.pushAnimationUScript(intValue, intValue2, intValue6, this);
        }
        else {
            NativeAnimationInterface.pushMultipleAnimationScripts(intValue, intValue2, intValue3, intValue4, intValue5, intValue6, this);
        }
    }
    
    public void abort() {
        if (!PushMultipleAnimationScripts.$noassert && (this.character == -1 || this.layer == -1)) {
            throw new AssertionError();
        }
        NativeAnimationInterface.abortAnimationScripts(this.character, this.layer);
        this.unregisterAction();
        this.character = -1;
        this.layer = -1;
    }
    
    private final /* synthetic */ void this() {
        this.character = -1;
        this.layer = -1;
    }
    
    public PushMultipleAnimationScripts() {
        this.this();
    }
    
    static {
        $noassert = (Class.forName("[Lfacade.primact.PushMultipleAnimationScripts;").getComponentType().desiredAssertionStatus() ^ true);
    }
}
