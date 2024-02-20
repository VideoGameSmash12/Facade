package facade.sensor;

import java.util.Iterator;
import wm.WME;
import facade.characters.wmedef.ArmBaseWME;
import java.util.HashMap;
import abl.runtime.BehavingEntity;
import facade.nativeinterface.NativeAnimationInterface;
import facade.util.IntegerRef;
import facade.util.AnimLayer;

public abstract class ArmBaseSensor extends FacadeSensor implements AnimLayer
{
    private static final /* synthetic */ boolean $noassert;
    
    public void sense_Utility(final int n) {
        final IntegerRef integerRef = new IntegerRef();
        final IntegerRef integerRef2 = new IntegerRef();
        final IntegerRef integerRef3 = new IntegerRef();
        NativeAnimationInterface.getArmGestureBases(n, integerRef, integerRef2, integerRef3);
        if (!ArmBaseSensor.$noassert && (integerRef.i != -1 || integerRef2.i != -1 || integerRef3.i == -1) && (integerRef.i == -1 || integerRef2.i == -1 || integerRef3.i != -1)) {
            throw new AssertionError();
        }
        this.updateWMEs(n, integerRef.i, integerRef2.i, integerRef3.i);
    }
    
    private final void updateWMEs(final int n, final int base, final int base2, final int base3) {
        final Iterator iterator = BehavingEntity.getBehavingEntity().lookupWME("ArmBaseWME").iterator();
        final HashMap<Integer, ArmBaseWME> hashMap = new HashMap<Integer, ArmBaseWME>();
        while (iterator.hasNext()) {
            final ArmBaseWME armBaseWME = iterator.next();
            hashMap.put(new Integer(armBaseWME.getGestureLayer()), armBaseWME);
        }
        final ArmBaseWME armBaseWME2 = hashMap.get(new Integer(4));
        if (base != -1) {
            if (armBaseWME2 == null) {
                BehavingEntity.getBehavingEntity().addWME(new ArmBaseWME(n, 4, base));
            }
            else if (armBaseWME2.getBase() != base) {
                armBaseWME2.setBase(base);
            }
        }
        else if (armBaseWME2 != null) {
            BehavingEntity.getBehavingEntity().deleteWME(armBaseWME2);
        }
        final ArmBaseWME armBaseWME3 = hashMap.get(new Integer(5));
        if (base2 != -1) {
            if (armBaseWME3 == null) {
                BehavingEntity.getBehavingEntity().addWME(new ArmBaseWME(n, 5, base2));
            }
            else if (armBaseWME3.getBase() != base2) {
                armBaseWME3.setBase(base2);
            }
        }
        else if (armBaseWME3 != null) {
            BehavingEntity.getBehavingEntity().deleteWME(armBaseWME3);
        }
        final ArmBaseWME armBaseWME4 = hashMap.get(new Integer(6));
        if (base3 != -1) {
            if (armBaseWME4 == null) {
                BehavingEntity.getBehavingEntity().addWME(new ArmBaseWME(n, 6, base3));
            }
            else if (armBaseWME4.getBase() != base3) {
                armBaseWME4.setBase(base3);
            }
        }
        else if (armBaseWME4 != null) {
            BehavingEntity.getBehavingEntity().deleteWME(armBaseWME4);
        }
    }
    
    static {
        $noassert = (Class.forName("[Lfacade.sensor.ArmBaseSensor;").getComponentType().desiredAssertionStatus() ^ true);
    }
}
