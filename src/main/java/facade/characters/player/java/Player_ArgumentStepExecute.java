package facade.characters.player.java;

import abl.runtime.AblRuntimeError;
import java.util.List;
import facade.characters.wmedef.PhysicallyFavorWME;
import abl.runtime.CollectionBehaviorWME;
import abl.runtime.__ValueTypes;
import abl.runtime.BehavingEntity;
import dramaman.runtime.DramaManagerConstants;
import facade.util.SpriteID;
import facade.util.BeatConstants;

public class Player_ArgumentStepExecute implements BeatConstants, SpriteID, DramaManagerConstants
{
    public static Object[] argumentExecute0(final int n, final Object[] array, final BehavingEntity behavingEntity) {
        switch (n) {
            case 8: {
                return new Object[] { new Integer(1) };
            }
            case 15: {
                return new Object[] { new Integer(((__ValueTypes.IntVar)array[0]).i) };
            }
            case 16: {
                return new Object[] { new Integer(((__ValueTypes.IntVar)array[0]).i), new Float(((__ValueTypes.FloatVar)array[3]).f) };
            }
            case 17: {
                return new Object[] { new Integer(((__ValueTypes.IntVar)array[0]).i), new Float(((__ValueTypes.FloatVar)array[3]).f) };
            }
            case 18: {
                return new Object[] { new Integer(((__ValueTypes.IntVar)array[0]).i) };
            }
            case 20: {
                return new Object[] { new Integer(((__ValueTypes.IntVar)array[0]).i) };
            }
            case 21: {
                return new Object[] { new Integer(((__ValueTypes.IntVar)array[0]).i) };
            }
            case 22: {
                return new Object[] { new Integer(((__ValueTypes.IntVar)array[0]).i), new Integer(((__ValueTypes.IntVar)array[1]).i) };
            }
            case 24: {
                return new Object[] { new Integer(((__ValueTypes.IntVar)array[1]).i) };
            }
            case 26: {
                return new Object[] { new Integer(((__ValueTypes.IntVar)array[0]).i) };
            }
            case 27: {
                return new Object[] { (CollectionBehaviorWME)array[2], new Integer(((__ValueTypes.IntVar)array[0]).i), new Boolean(((__ValueTypes.BooleanVar)array[1]).b), new Boolean(((__ValueTypes.BooleanVar)array[3]).b), new Float(((__ValueTypes.FloatVar)array[4]).f) };
            }
            case 29: {
                return new Object[] { new Integer(((__ValueTypes.IntVar)array[0]).i) };
            }
            case 30: {
                return new Object[] { (CollectionBehaviorWME)array[2], new Integer(((__ValueTypes.IntVar)array[0]).i), new Boolean(((__ValueTypes.BooleanVar)array[1]).b), new Boolean(((__ValueTypes.BooleanVar)array[3]).b), new Float(((__ValueTypes.FloatVar)array[4]).f) };
            }
            case 34: {
                return new Object[] { (PhysicallyFavorWME)array[1] };
            }
            case 35: {
                return new Object[] { new Integer(((__ValueTypes.IntVar)array[0]).i) };
            }
            case 37: {
                return new Object[] { (PhysicallyFavorWME)array[2] };
            }
            case 38: {
                return new Object[] { new Integer(((Player)behavingEntity).g_physicallyFavorLookTime) };
            }
            case 42: {
                return new Object[] { new Integer(1) };
            }
            case 43: {
                return new Object[] { new Integer(((Player)behavingEntity).g_physicallyFavorObjectLatency) };
            }
            case 46: {
                return new Object[] { new Integer(3) };
            }
            case 49: {
                return new Object[] { new Integer(((__ValueTypes.IntVar)array[0]).i), new Integer(((__ValueTypes.IntVar)array[1]).i) };
            }
            case 50: {
                return new Object[] { new Integer(((__ValueTypes.IntVar)array[0]).i), new Integer(((__ValueTypes.IntVar)array[1]).i) };
            }
            case 56: {
                return new Object[] { new Integer(((__ValueTypes.IntVar)array[0]).i), new Integer(((__ValueTypes.IntVar)array[1]).i) };
            }
            case 65: {
                return new Object[] { new Boolean(((__ValueTypes.BooleanVar)array[0]).b), new Boolean(((__ValueTypes.BooleanVar)array[1]).b) };
            }
            case 72: {
                return new Object[] { new Integer(1) };
            }
            case 77: {
                return new Object[] { new Float(((__ValueTypes.FloatVar)array[1]).f) };
            }
            case 88: {
                return new Object[] { new Integer(2), new Integer(-1) };
            }
            case 90: {
                return new Object[] { (CollectionBehaviorWME)array[1], (List)array[0] };
            }
            case 92: {
                return new Object[] { (CollectionBehaviorWME)array[0], new Integer(((__ValueTypes.IntVar)array[3]).i), new Boolean(((__ValueTypes.BooleanVar)array[5]).b), new Boolean(((__ValueTypes.BooleanVar)array[6]).b), new Float(((__ValueTypes.FloatVar)array[4]).f) };
            }
            case 93: {
                return new Object[] { (CollectionBehaviorWME)array[0], (List)array[1] };
            }
            default: {
                throw new AblRuntimeError("Unexpected stepID " + n);
            }
        }
    }
}
