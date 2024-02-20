package facade.sensor;

import facade.nativeinterface.NativeAnimationInterface;
import java.util.Iterator;
import wm.WME;
import abl.runtime.BehavingEntity;
import facade.characters.wmedef.ObjectStateWME;
import java.util.HashMap;
import facade.util.ObjectStateSensePacket;
import facade.util.SpriteID;

public class ObjectStateSensor extends FacadeSensor implements SpriteID
{
    private static final /* synthetic */ boolean $noassert;
    
    private final synchronized void processChangedObjectState(final ObjectStateSensePacket objectStateSensePacket) {
        final HashMap<Integer, ObjectStateWME> hashMap = new HashMap<Integer, ObjectStateWME>();
        for (final ObjectStateWME objectStateWME : BehavingEntity.getBehavingEntity().lookupWME("ObjectStateWME")) {
            if (objectStateSensePacket.getObjectInfo(objectStateWME.getObjectID()) == null) {
                BehavingEntity.getBehavingEntity().deleteWME(objectStateWME);
            }
            else {
                hashMap.put(new Integer(objectStateWME.getObjectID()), objectStateWME);
            }
        }
        for (final ObjectStateSensePacket.ObjectStateInfo objectStateInfo : objectStateSensePacket) {
            if (objectStateInfo.objectID != -1) {
                final ObjectStateWME objectStateWME2 = hashMap.get(new Integer(objectStateInfo.objectID));
                if (objectStateWME2 == null) {
                    BehavingEntity.getBehavingEntity().addWME(new ObjectStateWME(objectStateInfo.objectID, objectStateInfo.state));
                }
                else {
                    if (objectStateWME2.getState() == objectStateInfo.state) {
                        continue;
                    }
                    objectStateWME2.setState(objectStateInfo.state);
                }
            }
        }
    }
    
    private final synchronized void sense() {
        final ObjectStateSensePacket objectStateSensePacket = new ObjectStateSensePacket();
        NativeAnimationInterface.getAllObjectStates(objectStateSensePacket);
        this.processChangedObjectState(objectStateSensePacket);
    }
    
    public void senseOneShot(final Object[] array) {
        if (!ObjectStateSensor.$noassert && array != null && array.length != 0) {
            throw new AssertionError();
        }
        this.sense();
    }
    
    public void initializeContinuous(final Object[] array) {
        if (!ObjectStateSensor.$noassert && array != null && array.length != 0) {
            throw new AssertionError();
        }
        this.sense();
    }
    
    public void senseContinuous(final Object[] array) {
        if (!ObjectStateSensor.$noassert && array != null && array.length != 0) {
            throw new AssertionError();
        }
        this.sense();
    }
    
    static {
        $noassert = (Class.forName("[Lfacade.sensor.ObjectStateSensor;").getComponentType().desiredAssertionStatus() ^ true);
    }
}
