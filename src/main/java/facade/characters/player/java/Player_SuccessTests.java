package facade.characters.player.java;

import java.util.ListIterator;
import abl.runtime.AblRuntimeError;
import facade.util.Staging;
import facade.characters.wmedef.ObjectRotationWME;
import facade.characters.wmedef.ObjectPositionWME;
import facade.characters.wmedef.SameAffinityNBeatsWME;
import dramaman.runtime.StoryStatusWME;
import dramaman.runtime.BeatStartWME;
import dramaman.runtime.BeatCompletedWME;
import wm.WorkingMemory;
import facade.characters.wmedef.PhysicallyFavorWME;
import abl.runtime.__ValueTypes;
import facade.characters.wmedef.ObjectActivationWME;
import facade.characters.wmedef.IsPlayerTranslatingOrRotatingWME;
import abl.runtime.BehavingEntity;
import dramaman.runtime.DramaManagerConstants;
import facade.util.SpriteID;
import facade.util.BeatConstants;

public class Player_SuccessTests implements BeatConstants, SpriteID, DramaManagerConstants
{
    public static boolean successTest0(final int n, final Object[] array, final BehavingEntity behavingEntity) {
        switch (n) {
            case 6: {
                final ListIterator listIterator = BehavingEntity.getBehavingEntity().lookupWME("IsPlayerTranslatingOrRotatingWME").listIterator();
                while (listIterator.hasNext()) {
                    if (!listIterator.next().getB()) {
                        return true;
                    }
                }
                return false;
            }
            case 32: {
                final ListIterator listIterator2 = BehavingEntity.getBehavingEntity().lookupWME("ObjectActivationWME").listIterator();
                while (listIterator2.hasNext()) {
                    final ObjectActivationWME objectActivationWME = listIterator2.next();
                    final int activationID;
                    if (objectActivationWME.getActivatorID() == 2 && BehavingEntity.constantTrue(activationID = objectActivationWME.getActivationID()) && objectActivationWME.getObjectID() == ((__ValueTypes.IntVar)array[0]).i && System.currentTimeMillis() - ((Player)behavingEntity).g_previousPhysicallyFavoredTime > ((Player)behavingEntity).g_physicallyFavorLatencyInMS && (activationID == 0 || activationID == 2 || activationID == 4)) {
                        return true;
                    }
                }
                return false;
            }
            case 39: {
                return System.currentTimeMillis() - ((Player)behavingEntity).g_previousPhysicallyFavoredTime >= ((Player)behavingEntity).g_physicallyFavorLatencyInMS;
            }
            case 40: {
                final ListIterator listIterator3 = BehavingEntity.getBehavingEntity().lookupWME("PhysicallyFavorWME").listIterator();
                while (listIterator3.hasNext()) {
                    final PhysicallyFavorWME physicallyFavorWME = listIterator3.next();
                    if (physicallyFavorWME.getObjectID() == ((__ValueTypes.IntVar)array[0]).i && physicallyFavorWME.getFavoringCharID() == 2) {
                        return false;
                    }
                }
                return true;
            }
            case 45: {
                final ListIterator listIterator4 = BehavingEntity.getBehavingEntity().lookupWME("PhysicallyFavorWME").listIterator();
                while (listIterator4.hasNext()) {
                    if (!listIterator4.next().getHandled()) {
                        return true;
                    }
                }
                return false;
            }
            case 52: {
                final ListIterator listIterator5 = WorkingMemory.lookupWME("StoryMemory", "BeatCompletedWME").listIterator();
                while (listIterator5.hasNext()) {
                    if (listIterator5.next().getTimestamp() > ((__ValueTypes.LongVar)array[3]).l) {
                        return true;
                    }
                }
                return false;
            }
            case 54: {
                final ListIterator listIterator6 = WorkingMemory.lookupWME("StoryMemory", "BeatStartWME").listIterator();
                while (listIterator6.hasNext()) {
                    if (listIterator6.next().getTimestamp() > ((__ValueTypes.LongVar)array[3]).l) {
                        return true;
                    }
                }
                return false;
            }
            case 57: {
                final ListIterator listIterator7 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator7.hasNext()) {
                    final int affinity;
                    if (BehavingEntity.constantTrue(affinity = listIterator7.next().getAffinity()) && ((((__ValueTypes.IntVar)array[1]).i <= -1 && affinity <= -1) || (((__ValueTypes.IntVar)array[1]).i >= 1 && affinity >= 1) || (((__ValueTypes.IntVar)array[1]).i == 0 && affinity == 0))) {
                        return true;
                    }
                }
                return false;
            }
            case 59: {
                final ListIterator listIterator8 = BehavingEntity.getBehavingEntity().lookupWME("SameAffinityBeatCounterWME").listIterator();
                while (listIterator8.hasNext()) {
                    final SameAffinityBeatCounterWME sameAffinityBeatCounterWME = listIterator8.next();
                    if (sameAffinityBeatCounterWME.getTargetBeatCount() == ((__ValueTypes.IntVar)array[0]).i && sameAffinityBeatCounterWME.getCounter() >= ((__ValueTypes.IntVar)array[0]).i && sameAffinityBeatCounterWME.getTargetAffinity() == ((__ValueTypes.IntVar)array[1]).i) {
                        return true;
                    }
                }
                return false;
            }
            case 61: {
                final ListIterator listIterator9 = WorkingMemory.lookupWME("BeatMemory", "SameAffinityNBeatsWME").listIterator();
                while (listIterator9.hasNext()) {
                    final SameAffinityNBeatsWME sameAffinityNBeatsWME = listIterator9.next();
                    if (sameAffinityNBeatsWME.getBeatCount() == ((__ValueTypes.IntVar)array[0]).i && sameAffinityNBeatsWME.getTargetAffinity() == ((__ValueTypes.IntVar)array[1]).i) {
                        return false;
                    }
                }
                return true;
            }
            case 66: {
                final ListIterator listIterator10 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                while (listIterator10.hasNext()) {
                    final ObjectPositionWME objectPositionWME = listIterator10.next();
                    final float x;
                    final float z;
                    if (objectPositionWME.getObjectID() == 2 && BehavingEntity.constantTrue(x = objectPositionWME.getX()) && BehavingEntity.constantTrue(z = objectPositionWME.getZ())) {
                        final ListIterator listIterator11 = BehavingEntity.getBehavingEntity().lookupWME("ObjectRotationWME").listIterator();
                        while (listIterator11.hasNext()) {
                            final ObjectRotationWME objectRotationWME = listIterator11.next();
                            final float y;
                            if (objectRotationWME.getObjectID() == 2 && BehavingEntity.constantTrue(y = objectRotationWME.getY())) {
                                final ListIterator listIterator12 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                                while (listIterator12.hasNext()) {
                                    final ObjectPositionWME objectPositionWME2 = listIterator12.next();
                                    final float x2;
                                    final float z2;
                                    if (objectPositionWME2.getObjectID() == 1 && BehavingEntity.constantTrue(x2 = objectPositionWME2.getX()) && BehavingEntity.constantTrue(z2 = objectPositionWME2.getZ())) {
                                        final ListIterator listIterator13 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                                        while (listIterator13.hasNext()) {
                                            final ObjectPositionWME objectPositionWME3 = listIterator13.next();
                                            final float x3;
                                            final float z3;
                                            if (objectPositionWME3.getObjectID() == 0 && BehavingEntity.constantTrue(x3 = objectPositionWME3.getX()) && BehavingEntity.constantTrue(z3 = objectPositionWME3.getZ())) {
                                                final ListIterator listIterator14 = BehavingEntity.getBehavingEntity().lookupWME("OneCharacterVisibleInfoWME").listIterator();
                                                while (listIterator14.hasNext()) {
                                                    final float lookDistance;
                                                    if (BehavingEntity.constantTrue(lookDistance = listIterator14.next().getLookDistance())) {
                                                        final __ValueTypes.BooleanVar booleanVar = (__ValueTypes.BooleanVar)array[0];
                                                        final boolean pointWithinCharCone = Staging.isPointWithinCharCone(x2, z2, x, z, y, 45.0f, 0.0f, lookDistance);
                                                        booleanVar.b = pointWithinCharCone;
                                                        if (!BehavingEntity.constantTrue(pointWithinCharCone)) {
                                                            continue;
                                                        }
                                                        final __ValueTypes.BooleanVar booleanVar2 = (__ValueTypes.BooleanVar)array[1];
                                                        final boolean pointWithinCharCone2 = Staging.isPointWithinCharCone(x3, z3, x, z, y, 45.0f, 0.0f, lookDistance);
                                                        booleanVar2.b = pointWithinCharCone2;
                                                        if (BehavingEntity.constantTrue(pointWithinCharCone2) && ((((__ValueTypes.BooleanVar)array[0]).b && ((__ValueTypes.BooleanVar)array[1]).b) || (!((__ValueTypes.BooleanVar)array[0]).b && !((__ValueTypes.BooleanVar)array[1]).b) || (((__ValueTypes.BooleanVar)array[0]).b && ((__ValueTypes.IntVar)array[3]).i == 0) || (((__ValueTypes.BooleanVar)array[1]).b && ((__ValueTypes.IntVar)array[3]).i == 1))) {
                                                            return true;
                                                        }
                                                        continue;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return false;
            }
            case 68: {
                final ListIterator listIterator15 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                while (listIterator15.hasNext()) {
                    final ObjectPositionWME objectPositionWME4 = listIterator15.next();
                    final float x4;
                    final float z4;
                    if (objectPositionWME4.getObjectID() == 2 && BehavingEntity.constantTrue(x4 = objectPositionWME4.getX()) && BehavingEntity.constantTrue(z4 = objectPositionWME4.getZ())) {
                        final ListIterator listIterator16 = BehavingEntity.getBehavingEntity().lookupWME("ObjectRotationWME").listIterator();
                        while (listIterator16.hasNext()) {
                            final ObjectRotationWME objectRotationWME2 = listIterator16.next();
                            final float y2;
                            if (objectRotationWME2.getObjectID() == 2 && BehavingEntity.constantTrue(y2 = objectRotationWME2.getY())) {
                                final ListIterator listIterator17 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                                while (listIterator17.hasNext()) {
                                    final ObjectPositionWME objectPositionWME5 = listIterator17.next();
                                    final float x5;
                                    final float z5;
                                    if (objectPositionWME5.getObjectID() == 1 && BehavingEntity.constantTrue(x5 = objectPositionWME5.getX()) && BehavingEntity.constantTrue(z5 = objectPositionWME5.getZ())) {
                                        final ListIterator listIterator18 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                                        while (listIterator18.hasNext()) {
                                            final ObjectPositionWME objectPositionWME6 = listIterator18.next();
                                            final float x6;
                                            final float z6;
                                            if (objectPositionWME6.getObjectID() == 0 && BehavingEntity.constantTrue(x6 = objectPositionWME6.getX()) && BehavingEntity.constantTrue(z6 = objectPositionWME6.getZ())) {
                                                final ListIterator listIterator19 = BehavingEntity.getBehavingEntity().lookupWME("OneCharacterVisibleInfoWME").listIterator();
                                                while (listIterator19.hasNext()) {
                                                    final float lookDistance2;
                                                    if (BehavingEntity.constantTrue(lookDistance2 = listIterator19.next().getLookDistance())) {
                                                        final __ValueTypes.BooleanVar booleanVar3 = (__ValueTypes.BooleanVar)array[0];
                                                        final boolean pointWithinCharCone3 = Staging.isPointWithinCharCone(x5, z5, x4, z4, y2, 45.0f, 0.0f, lookDistance2);
                                                        booleanVar3.b = pointWithinCharCone3;
                                                        if (!BehavingEntity.constantTrue(pointWithinCharCone3)) {
                                                            continue;
                                                        }
                                                        final __ValueTypes.BooleanVar booleanVar4 = (__ValueTypes.BooleanVar)array[1];
                                                        final boolean pointWithinCharCone4 = Staging.isPointWithinCharCone(x6, z6, x4, z4, y2, 45.0f, 0.0f, lookDistance2);
                                                        booleanVar4.b = pointWithinCharCone4;
                                                        if (BehavingEntity.constantTrue(pointWithinCharCone4) && ((((__ValueTypes.BooleanVar)array[0]).b && !((__ValueTypes.BooleanVar)array[1]).b) || (!((__ValueTypes.BooleanVar)array[0]).b && ((__ValueTypes.BooleanVar)array[1]).b))) {
                                                            return true;
                                                        }
                                                        continue;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return false;
            }
            case 75: {
                return System.currentTimeMillis() > ((__ValueTypes.LongVar)array[1]).l;
            }
            default: {
                throw new AblRuntimeError("Unexpected stepID " + n);
            }
        }
    }
}
