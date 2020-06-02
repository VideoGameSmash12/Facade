package facade.characters.player.java;

import java.util.ListIterator;
import abl.runtime.AblRuntimeError;
import facade.characters.wmedef.HeldObjectWME;
import facade.util.Staging;
import facade.characters.wmedef.ObjectRotationWME;
import abl.runtime.__ValueTypes;
import facade.characters.wmedef.ObjectPositionWME;
import facade.characters.wmedef.IsPlayerTranslatingOrRotatingWME;
import abl.runtime.BehavingEntity;
import dramaman.runtime.DramaManagerConstants;
import facade.util.SpriteID;
import facade.util.BeatConstants;

public class Player_ContextConditions implements BeatConstants, SpriteID, DramaManagerConstants
{
    public static boolean contextCondition0(final int n, final Object[] array, final BehavingEntity behavingEntity) {
        switch (n) {
            case 7: {
                final ListIterator listIterator = BehavingEntity.getBehavingEntity().lookupWME("IsPlayerTranslatingOrRotatingWME").listIterator();
                while (listIterator.hasNext()) {
                    if (!listIterator.next().getB()) {
                        return true;
                    }
                }
                return false;
            }
            case 21: {
                final ListIterator listIterator2 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                while (listIterator2.hasNext()) {
                    final ObjectPositionWME objectPositionWME = listIterator2.next();
                    if (objectPositionWME.getObjectID() == 2) {
                        final __ValueTypes.FloatVar floatVar = (__ValueTypes.FloatVar)array[5];
                        final float x = objectPositionWME.getX();
                        floatVar.f = x;
                        if (!BehavingEntity.constantTrue(x)) {
                            continue;
                        }
                        final __ValueTypes.FloatVar floatVar2 = (__ValueTypes.FloatVar)array[8];
                        final float z = objectPositionWME.getZ();
                        floatVar2.f = z;
                        if (!BehavingEntity.constantTrue(z)) {
                            continue;
                        }
                        final ListIterator listIterator3 = BehavingEntity.getBehavingEntity().lookupWME("ObjectRotationWME").listIterator();
                        while (listIterator3.hasNext()) {
                            final ObjectRotationWME objectRotationWME = listIterator3.next();
                            if (objectRotationWME.getObjectID() == 2) {
                                final __ValueTypes.FloatVar floatVar3 = (__ValueTypes.FloatVar)array[4];
                                final float y = objectRotationWME.getY();
                                floatVar3.f = y;
                                if (!BehavingEntity.constantTrue(y)) {
                                    continue;
                                }
                                final ListIterator listIterator4 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                                while (listIterator4.hasNext()) {
                                    final ObjectPositionWME objectPositionWME2 = listIterator4.next();
                                    if (objectPositionWME2.getObjectID() == ((__ValueTypes.IntVar)array[0]).i) {
                                        final __ValueTypes.FloatVar floatVar4 = (__ValueTypes.FloatVar)array[11];
                                        final float x2 = objectPositionWME2.getX();
                                        floatVar4.f = x2;
                                        if (!BehavingEntity.constantTrue(x2)) {
                                            continue;
                                        }
                                        final __ValueTypes.FloatVar floatVar5 = (__ValueTypes.FloatVar)array[9];
                                        final float z2 = objectPositionWME2.getZ();
                                        floatVar5.f = z2;
                                        if (!BehavingEntity.constantTrue(z2) || !Staging.isPointWithinCharCone(((__ValueTypes.FloatVar)array[11]).f, ((__ValueTypes.FloatVar)array[9]).f, ((__ValueTypes.FloatVar)array[5]).f, ((__ValueTypes.FloatVar)array[8]).f, ((__ValueTypes.FloatVar)array[4]).f, 45.0f, 0.0f, 9999.0f) || Staging.getXZDistanceBetweenPoints(((__ValueTypes.FloatVar)array[5]).f, ((__ValueTypes.FloatVar)array[8]).f, ((__ValueTypes.FloatVar)array[11]).f, ((__ValueTypes.FloatVar)array[9]).f) >= ((__ValueTypes.FloatVar)array[1]).f || System.currentTimeMillis() - ((Player)behavingEntity).g_previousPhysicallyFavoredTime < ((Player)behavingEntity).g_physicallyFavorLatencyInMS) {
                                            continue;
                                        }
                                        final ListIterator listIterator5 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                                        while (listIterator5.hasNext()) {
                                            final ObjectPositionWME objectPositionWME3 = listIterator5.next();
                                            if (objectPositionWME3.getObjectID() == 1) {
                                                final __ValueTypes.FloatVar floatVar6 = (__ValueTypes.FloatVar)array[10];
                                                final float x3 = objectPositionWME3.getX();
                                                floatVar6.f = x3;
                                                if (!BehavingEntity.constantTrue(x3)) {
                                                    continue;
                                                }
                                                final __ValueTypes.FloatVar floatVar7 = (__ValueTypes.FloatVar)array[7];
                                                final float z3 = objectPositionWME3.getZ();
                                                floatVar7.f = z3;
                                                if (!BehavingEntity.constantTrue(z3) || Staging.isPointWithinCharCone(((__ValueTypes.FloatVar)array[10]).f, ((__ValueTypes.FloatVar)array[7]).f, ((__ValueTypes.FloatVar)array[5]).f, ((__ValueTypes.FloatVar)array[8]).f, ((__ValueTypes.FloatVar)array[4]).f, 45.0f, 0.0f, 9999.0f)) {
                                                    continue;
                                                }
                                                final ListIterator listIterator6 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                                                while (listIterator6.hasNext()) {
                                                    final ObjectPositionWME objectPositionWME4 = listIterator6.next();
                                                    if (objectPositionWME4.getObjectID() == 0) {
                                                        final __ValueTypes.FloatVar floatVar8 = (__ValueTypes.FloatVar)array[3];
                                                        final float x4 = objectPositionWME4.getX();
                                                        floatVar8.f = x4;
                                                        if (!BehavingEntity.constantTrue(x4)) {
                                                            continue;
                                                        }
                                                        final __ValueTypes.FloatVar floatVar9 = (__ValueTypes.FloatVar)array[6];
                                                        final float z4 = objectPositionWME4.getZ();
                                                        floatVar9.f = z4;
                                                        if (BehavingEntity.constantTrue(z4) && !Staging.isPointWithinCharCone(((__ValueTypes.FloatVar)array[3]).f, ((__ValueTypes.FloatVar)array[6]).f, ((__ValueTypes.FloatVar)array[5]).f, ((__ValueTypes.FloatVar)array[8]).f, ((__ValueTypes.FloatVar)array[4]).f, 45.0f, 0.0f, 9999.0f)) {
                                                            final ListIterator listIterator7 = BehavingEntity.getBehavingEntity().lookupWME("HeldObjectWME").listIterator();
                                                            while (listIterator7.hasNext()) {
                                                                if (listIterator7.next().getObjectID() == ((__ValueTypes.IntVar)array[0]).i) {
                                                                    return false;
                                                                }
                                                            }
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
            case 22: {
                final ListIterator listIterator8 = BehavingEntity.getBehavingEntity().lookupWME("HeldObjectWME").listIterator();
                while (listIterator8.hasNext()) {
                    if (listIterator8.next().getObjectID() == ((__ValueTypes.IntVar)array[0]).i) {
                        return true;
                    }
                }
                return false;
            }
            case 23: {
                final ListIterator listIterator9 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                while (listIterator9.hasNext()) {
                    final ObjectPositionWME objectPositionWME5 = listIterator9.next();
                    if (objectPositionWME5.getObjectID() == 2) {
                        final __ValueTypes.FloatVar floatVar10 = (__ValueTypes.FloatVar)array[9];
                        final float x5 = objectPositionWME5.getX();
                        floatVar10.f = x5;
                        if (!BehavingEntity.constantTrue(x5)) {
                            continue;
                        }
                        final __ValueTypes.FloatVar floatVar11 = (__ValueTypes.FloatVar)array[12];
                        final float z5 = objectPositionWME5.getZ();
                        floatVar11.f = z5;
                        if (!BehavingEntity.constantTrue(z5)) {
                            continue;
                        }
                        final ListIterator listIterator10 = BehavingEntity.getBehavingEntity().lookupWME("ObjectRotationWME").listIterator();
                        while (listIterator10.hasNext()) {
                            final ObjectRotationWME objectRotationWME2 = listIterator10.next();
                            if (objectRotationWME2.getObjectID() == 2) {
                                final __ValueTypes.FloatVar floatVar12 = (__ValueTypes.FloatVar)array[8];
                                final float y2 = objectRotationWME2.getY();
                                floatVar12.f = y2;
                                if (!BehavingEntity.constantTrue(y2)) {
                                    continue;
                                }
                                final ListIterator listIterator11 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                                while (listIterator11.hasNext()) {
                                    final ObjectPositionWME objectPositionWME6 = listIterator11.next();
                                    if (objectPositionWME6.getObjectID() == ((__ValueTypes.IntVar)array[0]).i) {
                                        final __ValueTypes.FloatVar floatVar13 = (__ValueTypes.FloatVar)array[15];
                                        final float x6 = objectPositionWME6.getX();
                                        floatVar13.f = x6;
                                        if (!BehavingEntity.constantTrue(x6)) {
                                            continue;
                                        }
                                        final __ValueTypes.FloatVar floatVar14 = (__ValueTypes.FloatVar)array[13];
                                        final float z6 = objectPositionWME6.getZ();
                                        floatVar14.f = z6;
                                        if (!BehavingEntity.constantTrue(z6)) {
                                            continue;
                                        }
                                        final __ValueTypes.BooleanVar booleanVar = (__ValueTypes.BooleanVar)array[3];
                                        final boolean pointWithinCharCone = Staging.isPointWithinCharCone(((__ValueTypes.FloatVar)array[15]).f, ((__ValueTypes.FloatVar)array[13]).f, ((__ValueTypes.FloatVar)array[9]).f, ((__ValueTypes.FloatVar)array[12]).f, ((__ValueTypes.FloatVar)array[8]).f, 45.0f, 0.0f, 9999.0f);
                                        booleanVar.b = pointWithinCharCone;
                                        if (!BehavingEntity.constantTrue(pointWithinCharCone)) {
                                            continue;
                                        }
                                        final __ValueTypes.FloatVar floatVar15 = (__ValueTypes.FloatVar)array[2];
                                        final float xzDistanceBetweenPoints = Staging.getXZDistanceBetweenPoints(((__ValueTypes.FloatVar)array[9]).f, ((__ValueTypes.FloatVar)array[12]).f, ((__ValueTypes.FloatVar)array[15]).f, ((__ValueTypes.FloatVar)array[13]).f);
                                        floatVar15.f = xzDistanceBetweenPoints;
                                        if (!BehavingEntity.constantTrue(xzDistanceBetweenPoints)) {
                                            continue;
                                        }
                                        final __ValueTypes.LongVar longVar = (__ValueTypes.LongVar)array[6];
                                        final long l = System.currentTimeMillis() - ((Player)behavingEntity).g_previousPhysicallyFavoredTime;
                                        longVar.l = l;
                                        if (!BehavingEntity.constantTrue(l)) {
                                            continue;
                                        }
                                        final ListIterator listIterator12 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                                        while (listIterator12.hasNext()) {
                                            final ObjectPositionWME objectPositionWME7 = listIterator12.next();
                                            if (objectPositionWME7.getObjectID() == 1) {
                                                final __ValueTypes.FloatVar floatVar16 = (__ValueTypes.FloatVar)array[14];
                                                final float x7 = objectPositionWME7.getX();
                                                floatVar16.f = x7;
                                                if (!BehavingEntity.constantTrue(x7)) {
                                                    continue;
                                                }
                                                final __ValueTypes.FloatVar floatVar17 = (__ValueTypes.FloatVar)array[11];
                                                final float z7 = objectPositionWME7.getZ();
                                                floatVar17.f = z7;
                                                if (!BehavingEntity.constantTrue(z7)) {
                                                    continue;
                                                }
                                                final __ValueTypes.BooleanVar booleanVar2 = (__ValueTypes.BooleanVar)array[4];
                                                final boolean pointWithinCharCone2 = Staging.isPointWithinCharCone(((__ValueTypes.FloatVar)array[14]).f, ((__ValueTypes.FloatVar)array[11]).f, ((__ValueTypes.FloatVar)array[9]).f, ((__ValueTypes.FloatVar)array[12]).f, ((__ValueTypes.FloatVar)array[8]).f, 45.0f, 0.0f, 9999.0f);
                                                booleanVar2.b = pointWithinCharCone2;
                                                if (!BehavingEntity.constantTrue(pointWithinCharCone2)) {
                                                    continue;
                                                }
                                                final ListIterator listIterator13 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                                                while (listIterator13.hasNext()) {
                                                    final ObjectPositionWME objectPositionWME8 = listIterator13.next();
                                                    if (objectPositionWME8.getObjectID() == 0) {
                                                        final __ValueTypes.FloatVar floatVar18 = (__ValueTypes.FloatVar)array[7];
                                                        final float x8 = objectPositionWME8.getX();
                                                        floatVar18.f = x8;
                                                        if (!BehavingEntity.constantTrue(x8)) {
                                                            continue;
                                                        }
                                                        final __ValueTypes.FloatVar floatVar19 = (__ValueTypes.FloatVar)array[10];
                                                        final float z8 = objectPositionWME8.getZ();
                                                        floatVar19.f = z8;
                                                        if (!BehavingEntity.constantTrue(z8)) {
                                                            continue;
                                                        }
                                                        final __ValueTypes.BooleanVar booleanVar3 = (__ValueTypes.BooleanVar)array[5];
                                                        final boolean pointWithinCharCone3 = Staging.isPointWithinCharCone(((__ValueTypes.FloatVar)array[7]).f, ((__ValueTypes.FloatVar)array[10]).f, ((__ValueTypes.FloatVar)array[9]).f, ((__ValueTypes.FloatVar)array[12]).f, ((__ValueTypes.FloatVar)array[8]).f, 45.0f, 0.0f, 9999.0f);
                                                        booleanVar3.b = pointWithinCharCone3;
                                                        if (BehavingEntity.constantTrue(pointWithinCharCone3) && (((__ValueTypes.FloatVar)array[2]).f > ((__ValueTypes.FloatVar)array[1]).f || !((__ValueTypes.BooleanVar)array[3]).b || ((__ValueTypes.BooleanVar)array[4]).b || ((__ValueTypes.BooleanVar)array[5]).b || ((__ValueTypes.LongVar)array[6]).l < ((Player)behavingEntity).g_physicallyFavorLatencyInMS)) {
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
            default: {
                throw new AblRuntimeError("Unexpected behaviorID " + n);
            }
        }
    }
}
