package facade.sensor;

import facade.nativeinterface.NativeAnimationInterface;
import java.util.Iterator;
import wm.WME;
import abl.runtime.BehavingEntity;
import facade.characters.wmedef.HeldObjectWME;
import java.util.HashMap;
import facade.util.HeldObjectSensePacket;
import facade.util.SpriteID;

public class HeldObjectsSensor extends FacadeSensor implements SpriteID
{
    private static final /* synthetic */ boolean $noassert;
    
    private final synchronized void processChangedHeldObjects(final HeldObjectSensePacket heldObjectSensePacket) {
        final HashMap<Integer, HeldObjectWME> hashMap = new HashMap<Integer, HeldObjectWME>();
        for (final HeldObjectWME heldObjectWME : BehavingEntity.getBehavingEntity().lookupWME("HeldObjectWME")) {
            if (heldObjectSensePacket.getObjectInfo(heldObjectWME.getObjectID()) == null) {
                BehavingEntity.getBehavingEntity().deleteWME(heldObjectWME);
            }
            else {
                hashMap.put(new Integer(heldObjectWME.getObjectID()), heldObjectWME);
            }
        }
        for (final HeldObjectSensePacket.HeldObjectInfo heldObjectInfo : heldObjectSensePacket) {
            if (heldObjectInfo.objectID != -1) {
                final HeldObjectWME heldObjectWME2 = hashMap.get(new Integer(heldObjectInfo.objectID));
                if (heldObjectWME2 == null) {
                    BehavingEntity.getBehavingEntity().addWME(new HeldObjectWME(heldObjectInfo.objectID, heldObjectInfo.characterID, heldObjectInfo.attachPointID, heldObjectInfo.objectCategory));
                }
                else {
                    if (heldObjectWME2.getCharacterID() == heldObjectInfo.characterID && heldObjectWME2.getAttachPointID() == heldObjectInfo.attachPointID && heldObjectWME2.getObjectCategory() == heldObjectInfo.objectCategory) {
                        continue;
                    }
                    heldObjectWME2.setCharacterID(heldObjectInfo.characterID);
                    heldObjectWME2.setAttachPointID(heldObjectInfo.attachPointID);
                    heldObjectWME2.setObjectCategory(heldObjectInfo.objectCategory);
                }
            }
        }
    }
    
    private final synchronized void sense() {
        final HeldObjectSensePacket heldObjectSensePacket = new HeldObjectSensePacket();
        NativeAnimationInterface.getAllHeldObjects(heldObjectSensePacket);
        this.processChangedHeldObjects(heldObjectSensePacket);
    }
    
    public void senseOneShot(final Object[] array) {
        if (!HeldObjectsSensor.$noassert && array != null && array.length != 0) {
            throw new AssertionError();
        }
        this.sense();
    }
    
    public void initializeContinuous(final Object[] array) {
        if (!HeldObjectsSensor.$noassert && array != null && array.length != 0) {
            throw new AssertionError();
        }
        this.sense();
    }
    
    public void senseContinuous(final Object[] array) {
        if (!HeldObjectsSensor.$noassert && array != null && array.length != 0) {
            throw new AssertionError();
        }
        this.sense();
    }
    
    static {
        $noassert = (Class.forName("[Lfacade.sensor.HeldObjectsSensor;").getComponentType().desiredAssertionStatus() ^ true);
    }
}
