package facade.primact;

import facade.nativeinterface.NativeAnimationInterface;
import facade.util.SpriteID;
import facade.util.AnimLayer;

public class PushPoseScript extends FacadeAsynchronousAction implements AnimLayer, SpriteID
{
    private int character;
    private static final /* synthetic */ boolean $noassert;
    
    public void execute(final Object[] array) {
        NativeAnimationInterface.pushPoseScript(this.character = (int)array[0], (int)array[1], this);
    }
    
    public void abort() {
        if (!PushPoseScript.$noassert && this.character == -1) {
            throw new AssertionError();
        }
        NativeAnimationInterface.abortAnimationScripts(this.character, 0);
        this.character = -1;
    }
    
    private final /* synthetic */ void this() {
        this.character = -1;
    }
    
    public PushPoseScript() {
        this.this();
    }
    
    static {
        $noassert = (Class.forName("[Lfacade.primact.PushPoseScript;").getComponentType().desiredAssertionStatus() ^ true);
    }
}
