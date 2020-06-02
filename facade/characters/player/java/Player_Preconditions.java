package facade.characters.player.java;

import java.util.ListIterator;
import abl.runtime.AblRuntimeError;
import java.util.List;
import facade.characters.wmedef.PlayerRecentlyTypedTextWME;
import facade.characters.wmedef.PlayerUncoopWME;
import facade.characters.wmedef.OneCharacterVisibleWME;
import facade.characters.wmedef.SameAffinityNBeatsWME;
import dramaman.runtime.StoryStatusWME;
import wm.WorkingMemory;
import facade.characters.wmedef.HeldObjectWME;
import facade.util.Staging;
import facade.characters.wmedef.ObjectRotationWME;
import facade.characters.wmedef.ObjectPositionWME;
import abl.runtime.CollectionBehaviorWME;
import abl.runtime.GoalStepWME;
import facade.characters.wmedef.PlayerFutureRotationWME;
import facade.characters.wmedef.PlayerFuturePositionWME;
import facade.characters.wmedef.PlayerRotationWME;
import facade.characters.wmedef.PlayerPositionWME;
import facade.characters.wmedef.IsPlayerRotatingWME;
import abl.runtime.ObjectWrapper;
import facade.characters.wmedef.IsPlayerSettledWME;
import facade.characters.wmedef.IsPlayerTranslatingOrRotatingWME;
import facade.characters.wmedef.IsPlayerTranslatingWME;
import abl.runtime.BehavingEntity;
import java.util.Hashtable;
import dramaman.runtime.DramaManagerConstants;
import facade.util.SpriteID;
import facade.util.BeatConstants;

public class Player_Preconditions implements BeatConstants, SpriteID, DramaManagerConstants
{
    public static boolean precondition0(final int n, final Object[] array, final Hashtable hashtable, final BehavingEntity behavingEntity) {
        switch (n) {
            case 0: {
                final ListIterator listIterator = BehavingEntity.getBehavingEntity().lookupWME("PreviousCachedPlayerPositionWME").listIterator();
                if (!listIterator.hasNext()) {
                    final ListIterator listIterator2 = BehavingEntity.getBehavingEntity().lookupWME("CachedPlayerPositionWME").listIterator();
                    while (listIterator2.hasNext()) {
                        final CachedPlayerPositionWME cachedPlayerPositionWME = listIterator2.next();
                        final float x;
                        final float z;
                        if (BehavingEntity.constantTrue(x = cachedPlayerPositionWME.getX()) && BehavingEntity.constantTrue(z = cachedPlayerPositionWME.getZ())) {
                            hashtable.put("playerX", new Float(x));
                            hashtable.put("playerZ", new Float(z));
                            return true;
                        }
                    }
                    return false;
                }
                final PreviousCachedPlayerPositionWME previousCachedPlayerPositionWME = listIterator.next();
                return false;
            }
            case 1: {
                final ListIterator listIterator3 = BehavingEntity.getBehavingEntity().lookupWME("IsPlayerTranslatingWME").listIterator();
                while (listIterator3.hasNext()) {
                    final IsPlayerTranslatingWME isPlayerTranslatingWME;
                    if (!(isPlayerTranslatingWME = listIterator3.next()).getB()) {
                        final ListIterator listIterator4 = BehavingEntity.getBehavingEntity().lookupWME("PreviousCachedPlayerPositionWME").listIterator();
                        while (listIterator4.hasNext()) {
                            final PreviousCachedPlayerPositionWME previousCachedPlayerPositionWME3;
                            final PreviousCachedPlayerPositionWME previousCachedPlayerPositionWME2 = previousCachedPlayerPositionWME3 = listIterator4.next();
                            final float x2;
                            final float z2;
                            if (BehavingEntity.constantTrue(x2 = previousCachedPlayerPositionWME2.getX()) && BehavingEntity.constantTrue(z2 = previousCachedPlayerPositionWME2.getZ())) {
                                final ListIterator listIterator5 = BehavingEntity.getBehavingEntity().lookupWME("CachedPlayerPositionWME").listIterator();
                                while (listIterator5.hasNext()) {
                                    final CachedPlayerPositionWME cachedPlayerPositionWME2 = listIterator5.next();
                                    final float x3;
                                    final float z3;
                                    if (BehavingEntity.constantTrue(x3 = cachedPlayerPositionWME2.getX()) && BehavingEntity.constantTrue(z3 = cachedPlayerPositionWME2.getZ())) {
                                        final ListIterator listIterator6 = BehavingEntity.getBehavingEntity().lookupWME("IsPlayerTranslatingOrRotatingWME").listIterator();
                                        while (listIterator6.hasNext()) {
                                            final IsPlayerTranslatingOrRotatingWME isPlayerTranslatingOrRotatingWME = listIterator6.next();
                                            final ListIterator listIterator7 = BehavingEntity.getBehavingEntity().lookupWME("IsPlayerSettledWME").listIterator();
                                            if (!listIterator7.hasNext()) {
                                                continue;
                                            }
                                            hashtable.put("settledWME", new ObjectWrapper(listIterator7.next()));
                                            hashtable.put("playerX2", new Float(x3));
                                            hashtable.put("transWME", new ObjectWrapper(isPlayerTranslatingWME));
                                            hashtable.put("playerZ1", new Float(z2));
                                            hashtable.put("prevWME", new ObjectWrapper(previousCachedPlayerPositionWME3));
                                            hashtable.put("playerX1", new Float(x2));
                                            hashtable.put("movWME", new ObjectWrapper(isPlayerTranslatingOrRotatingWME));
                                            hashtable.put("playerZ2", new Float(z3));
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return false;
            }
            case 2: {
                final ListIterator listIterator8 = BehavingEntity.getBehavingEntity().lookupWME("IsPlayerTranslatingWME").listIterator();
                while (listIterator8.hasNext()) {
                    final IsPlayerTranslatingWME isPlayerTranslatingWME2;
                    if ((isPlayerTranslatingWME2 = listIterator8.next()).getB()) {
                        final ListIterator listIterator9 = BehavingEntity.getBehavingEntity().lookupWME("PreviousCachedPlayerPositionWME").listIterator();
                        while (listIterator9.hasNext()) {
                            final PreviousCachedPlayerPositionWME previousCachedPlayerPositionWME5;
                            final PreviousCachedPlayerPositionWME previousCachedPlayerPositionWME4 = previousCachedPlayerPositionWME5 = listIterator9.next();
                            final float x4;
                            final float z4;
                            if (BehavingEntity.constantTrue(x4 = previousCachedPlayerPositionWME4.getX()) && BehavingEntity.constantTrue(z4 = previousCachedPlayerPositionWME4.getZ())) {
                                final ListIterator listIterator10 = BehavingEntity.getBehavingEntity().lookupWME("CachedPlayerPositionWME").listIterator();
                                while (listIterator10.hasNext()) {
                                    final CachedPlayerPositionWME cachedPlayerPositionWME3 = listIterator10.next();
                                    final float x5;
                                    final float z5;
                                    if (BehavingEntity.constantTrue(x5 = cachedPlayerPositionWME3.getX()) && BehavingEntity.constantTrue(z5 = cachedPlayerPositionWME3.getZ())) {
                                        final ListIterator listIterator11 = BehavingEntity.getBehavingEntity().lookupWME("IsPlayerTranslatingOrRotatingWME").listIterator();
                                        while (listIterator11.hasNext()) {
                                            final IsPlayerTranslatingOrRotatingWME isPlayerTranslatingOrRotatingWME2 = listIterator11.next();
                                            final ListIterator listIterator12 = BehavingEntity.getBehavingEntity().lookupWME("IsPlayerRotatingWME").listIterator();
                                            while (listIterator12.hasNext()) {
                                                final boolean b;
                                                if (BehavingEntity.constantTrue(b = listIterator12.next().getB())) {
                                                    hashtable.put("playerX2", new Float(x5));
                                                    hashtable.put("transWME", new ObjectWrapper(isPlayerTranslatingWME2));
                                                    hashtable.put("playerZ1", new Float(z4));
                                                    hashtable.put("prevWME", new ObjectWrapper(previousCachedPlayerPositionWME5));
                                                    hashtable.put("playerX1", new Float(x4));
                                                    hashtable.put("movWME", new ObjectWrapper(isPlayerTranslatingOrRotatingWME2));
                                                    hashtable.put("bRotating", new Boolean(b));
                                                    hashtable.put("playerZ2", new Float(z5));
                                                    return true;
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
            case 3: {
                final ListIterator listIterator13 = BehavingEntity.getBehavingEntity().lookupWME("PreviousCachedPlayerRotationWME").listIterator();
                if (!listIterator13.hasNext()) {
                    final ListIterator listIterator14 = BehavingEntity.getBehavingEntity().lookupWME("CachedPlayerRotationWME").listIterator();
                    while (listIterator14.hasNext()) {
                        final float y;
                        if (BehavingEntity.constantTrue(y = listIterator14.next().getY())) {
                            hashtable.put("playerYRot", new Float(y));
                            return true;
                        }
                    }
                    return false;
                }
                final PreviousCachedPlayerRotationWME previousCachedPlayerRotationWME = listIterator13.next();
                return false;
            }
            case 4: {
                final ListIterator listIterator15 = BehavingEntity.getBehavingEntity().lookupWME("IsPlayerRotatingWME").listIterator();
                while (listIterator15.hasNext()) {
                    final IsPlayerRotatingWME isPlayerRotatingWME;
                    if (!(isPlayerRotatingWME = listIterator15.next()).getB()) {
                        final ListIterator listIterator16 = BehavingEntity.getBehavingEntity().lookupWME("PreviousCachedPlayerRotationWME").listIterator();
                        while (listIterator16.hasNext()) {
                            final PreviousCachedPlayerRotationWME previousCachedPlayerRotationWME2;
                            final float y2;
                            if (BehavingEntity.constantTrue(y2 = (previousCachedPlayerRotationWME2 = listIterator16.next()).getY())) {
                                final ListIterator listIterator17 = BehavingEntity.getBehavingEntity().lookupWME("CachedPlayerRotationWME").listIterator();
                                while (listIterator17.hasNext()) {
                                    final float y3;
                                    if (BehavingEntity.constantTrue(y3 = listIterator17.next().getY())) {
                                        final ListIterator listIterator18 = BehavingEntity.getBehavingEntity().lookupWME("IsPlayerTranslatingOrRotatingWME").listIterator();
                                        while (listIterator18.hasNext()) {
                                            final IsPlayerTranslatingOrRotatingWME isPlayerTranslatingOrRotatingWME3 = listIterator18.next();
                                            final ListIterator listIterator19 = BehavingEntity.getBehavingEntity().lookupWME("IsPlayerSettledWME").listIterator();
                                            if (!listIterator19.hasNext()) {
                                                continue;
                                            }
                                            hashtable.put("settledWME", new ObjectWrapper(listIterator19.next()));
                                            hashtable.put("playerYRot2", new Float(y3));
                                            hashtable.put("prevWME", new ObjectWrapper(previousCachedPlayerRotationWME2));
                                            hashtable.put("movWME", new ObjectWrapper(isPlayerTranslatingOrRotatingWME3));
                                            hashtable.put("rotWME", new ObjectWrapper(isPlayerRotatingWME));
                                            hashtable.put("playerYRot1", new Float(y2));
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return false;
            }
            case 5: {
                final ListIterator listIterator20 = BehavingEntity.getBehavingEntity().lookupWME("IsPlayerRotatingWME").listIterator();
                while (listIterator20.hasNext()) {
                    final IsPlayerRotatingWME isPlayerRotatingWME2;
                    if ((isPlayerRotatingWME2 = listIterator20.next()).getB()) {
                        final ListIterator listIterator21 = BehavingEntity.getBehavingEntity().lookupWME("PreviousCachedPlayerRotationWME").listIterator();
                        while (listIterator21.hasNext()) {
                            final PreviousCachedPlayerRotationWME previousCachedPlayerRotationWME3;
                            final float y4;
                            if (BehavingEntity.constantTrue(y4 = (previousCachedPlayerRotationWME3 = listIterator21.next()).getY())) {
                                final ListIterator listIterator22 = BehavingEntity.getBehavingEntity().lookupWME("CachedPlayerRotationWME").listIterator();
                                while (listIterator22.hasNext()) {
                                    final float y5;
                                    if (BehavingEntity.constantTrue(y5 = listIterator22.next().getY())) {
                                        final ListIterator listIterator23 = BehavingEntity.getBehavingEntity().lookupWME("IsPlayerTranslatingOrRotatingWME").listIterator();
                                        while (listIterator23.hasNext()) {
                                            final IsPlayerTranslatingOrRotatingWME isPlayerTranslatingOrRotatingWME4 = listIterator23.next();
                                            final ListIterator listIterator24 = BehavingEntity.getBehavingEntity().lookupWME("IsPlayerTranslatingWME").listIterator();
                                            while (listIterator24.hasNext()) {
                                                final boolean b2;
                                                if (BehavingEntity.constantTrue(b2 = listIterator24.next().getB())) {
                                                    hashtable.put("playerYRot2", new Float(y5));
                                                    hashtable.put("prevWME", new ObjectWrapper(previousCachedPlayerRotationWME3));
                                                    hashtable.put("bTranslating", new Boolean(b2));
                                                    hashtable.put("movWME", new ObjectWrapper(isPlayerTranslatingOrRotatingWME4));
                                                    hashtable.put("rotWME", new ObjectWrapper(isPlayerRotatingWME2));
                                                    hashtable.put("playerYRot1", new Float(y4));
                                                    return true;
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
            case 7: {
                final ListIterator listIterator25 = BehavingEntity.getBehavingEntity().lookupWME("IsPlayerSettledWME").listIterator();
                if (!listIterator25.hasNext()) {
                    return false;
                }
                hashtable.put("settledWME", new ObjectWrapper(listIterator25.next()));
                return true;
            }
            case 9: {
                final ListIterator listIterator26 = BehavingEntity.getBehavingEntity().lookupWME("PlayerPositionWME").listIterator();
                while (listIterator26.hasNext()) {
                    final PlayerPositionWME playerPositionWME = listIterator26.next();
                    final float x6;
                    final float y6;
                    final float z6;
                    if (BehavingEntity.constantTrue(x6 = playerPositionWME.getX()) && BehavingEntity.constantTrue(y6 = playerPositionWME.getY()) && BehavingEntity.constantTrue(z6 = playerPositionWME.getZ())) {
                        final ListIterator listIterator27 = BehavingEntity.getBehavingEntity().lookupWME("PlayerRotationWME").listIterator();
                        while (listIterator27.hasNext()) {
                            final float y7;
                            if (BehavingEntity.constantTrue(y7 = listIterator27.next().getY())) {
                                final ListIterator listIterator28 = BehavingEntity.getBehavingEntity().lookupWME("CachedPlayerPositionWME").listIterator();
                                while (listIterator28.hasNext()) {
                                    final CachedPlayerPositionWME cachedPlayerPositionWME4 = listIterator28.next();
                                    final ListIterator listIterator29 = BehavingEntity.getBehavingEntity().lookupWME("CachedPlayerRotationWME").listIterator();
                                    while (listIterator29.hasNext()) {
                                        final CachedPlayerRotationWME cachedPlayerRotationWME = listIterator29.next();
                                        final ListIterator listIterator30 = BehavingEntity.getBehavingEntity().lookupWME("PlayerFuturePositionWME").listIterator();
                                        while (listIterator30.hasNext()) {
                                            final PlayerFuturePositionWME playerFuturePositionWME = listIterator30.next();
                                            final ListIterator listIterator31 = BehavingEntity.getBehavingEntity().lookupWME("PlayerFutureRotationWME").listIterator();
                                            if (!listIterator31.hasNext()) {
                                                continue;
                                            }
                                            final PlayerFutureRotationWME playerFutureRotationWME = listIterator31.next();
                                            hashtable.put("playerZPos", new Float(z6));
                                            hashtable.put("cachedPlayerPositionWME", new ObjectWrapper(cachedPlayerPositionWME4));
                                            hashtable.put("playerYPos", new Float(y6));
                                            hashtable.put("playerFutureRotationWME", new ObjectWrapper(playerFutureRotationWME));
                                            hashtable.put("playerFuturePositionWME", new ObjectWrapper(playerFuturePositionWME));
                                            hashtable.put("playerXPos", new Float(x6));
                                            hashtable.put("cachedPlayerRotationWME", new ObjectWrapper(cachedPlayerRotationWME));
                                            hashtable.put("playerYRot", new Float(y7));
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return false;
            }
            case 10: {
                (int)array[0];
                final boolean booleanValue = (boolean)array[1];
                final boolean booleanValue2 = (boolean)array[2];
                (float)array[3];
                return booleanValue && booleanValue2;
            }
            case 11: {
                (int)array[0];
                final boolean booleanValue3 = (boolean)array[1];
                final boolean booleanValue4 = (boolean)array[2];
                (float)array[3];
                return booleanValue3 && !booleanValue4;
            }
            case 12: {
                (int)array[0];
                final boolean booleanValue5 = (boolean)array[1];
                final boolean booleanValue6 = (boolean)array[2];
                (float)array[3];
                return !booleanValue5 && booleanValue6;
            }
            case 13: {
                (int)array[0];
                final boolean booleanValue7 = (boolean)array[1];
                final boolean booleanValue8 = (boolean)array[2];
                (float)array[3];
                return !booleanValue7 && !booleanValue8;
            }
            case 15: {
                final int intValue = (int)array[0];
                final ListIterator<GoalStepWME> listIterator32 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEBySignature("GoalStepWME", "csPlayerPhysicallyFavors(int, boolean, boolean, float)").listIterator();
                while (listIterator32.hasNext()) {
                    final GoalStepWME goalStepWME2;
                    final GoalStepWME goalStepWME = goalStepWME2 = listIterator32.next();
                    final Object property;
                    if (goalStepWME.getSignature().equals("csPlayerPhysicallyFavors(int, boolean, boolean, float)") && BehavingEntity.constantTrue(property = goalStepWME.getProperty("physicallyFavorsID")) && (int)property == intValue) {
                        hashtable.put("objID", new ObjectWrapper(property));
                        hashtable.put("gWME", new ObjectWrapper(goalStepWME2));
                        return true;
                    }
                }
                return false;
            }
            case 17: {
                final int intValue2 = (int)array[0];
                final ListIterator<CollectionBehaviorWME> listIterator33 = (ListIterator<CollectionBehaviorWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEBySignature("CollectionBehaviorWME", "OverallControl_Body()").listIterator();
                while (listIterator33.hasNext()) {
                    final CollectionBehaviorWME collectionBehaviorWME;
                    if ((collectionBehaviorWME = listIterator33.next()).getSignature().equals("OverallControl_Body()")) {
                        final ListIterator listIterator34 = BehavingEntity.getBehavingEntity().lookupWME("PhysicallyFavorInfoWME").listIterator();
                        while (listIterator34.hasNext()) {
                            final PhysicallyFavorInfoWME physicallyFavorInfoWME = listIterator34.next();
                            final boolean lookAtSensorActive;
                            final boolean objectActivateSensorActive;
                            final float lookDistance;
                            if (physicallyFavorInfoWME.getSpriteID() == intValue2 && BehavingEntity.constantTrue(lookAtSensorActive = physicallyFavorInfoWME.getLookAtSensorActive()) && BehavingEntity.constantTrue(objectActivateSensorActive = physicallyFavorInfoWME.getObjectActivateSensorActive()) && BehavingEntity.constantTrue(lookDistance = physicallyFavorInfoWME.getLookDistance())) {
                                hashtable.put("lDistance", new Float(lookDistance));
                                hashtable.put("objectActivateActive", new Boolean(objectActivateSensorActive));
                                hashtable.put("overallControl_Body", new ObjectWrapper(collectionBehaviorWME));
                                hashtable.put("lookActive", new Boolean(lookAtSensorActive));
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            case 18: {
                final int intValue3 = (int)array[0];
                final ListIterator listIterator35 = BehavingEntity.getBehavingEntity().lookupWME("PhysicallyFavorInfoWME").listIterator();
                while (listIterator35.hasNext()) {
                    final PhysicallyFavorInfoWME physicallyFavorInfoWME2 = listIterator35.next();
                    final boolean lookAtSensorActive2;
                    final boolean objectActivateSensorActive2;
                    final float lookDistance2;
                    if (physicallyFavorInfoWME2.getSpriteID() == intValue3 && BehavingEntity.constantTrue(lookAtSensorActive2 = physicallyFavorInfoWME2.getLookAtSensorActive()) && BehavingEntity.constantTrue(objectActivateSensorActive2 = physicallyFavorInfoWME2.getObjectActivateSensorActive()) && BehavingEntity.constantTrue(lookDistance2 = physicallyFavorInfoWME2.getLookDistance())) {
                        final ListIterator<CollectionBehaviorWME> listIterator36 = (ListIterator<CollectionBehaviorWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEBySignature("CollectionBehaviorWME", "OverallControl_Body()").listIterator();
                        while (listIterator36.hasNext()) {
                            final CollectionBehaviorWME collectionBehaviorWME2;
                            if ((collectionBehaviorWME2 = listIterator36.next()).getSignature().equals("OverallControl_Body()")) {
                                hashtable.put("lDistance", new Float(lookDistance2));
                                hashtable.put("objectActivateActive", new Boolean(objectActivateSensorActive2));
                                hashtable.put("overallControl_Body", new ObjectWrapper(collectionBehaviorWME2));
                                hashtable.put("lookActive", new Boolean(lookAtSensorActive2));
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            case 19: {
                final int intValue4 = (int)array[0];
                final ListIterator<GoalStepWME> listIterator37 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEBySignature("GoalStepWME", "TurnPhysicallyFavorsBackOnAfterTimeout_Demon(int, int)").listIterator();
                while (listIterator37.hasNext()) {
                    final GoalStepWME goalStepWME4;
                    final GoalStepWME goalStepWME3 = goalStepWME4 = listIterator37.next();
                    final Object property2;
                    if (goalStepWME3.getSignature().equals("TurnPhysicallyFavorsBackOnAfterTimeout_Demon(int, int)") && BehavingEntity.constantTrue(property2 = goalStepWME3.getProperty("physicallyFavorsID")) && (int)property2 == intValue4) {
                        hashtable.put("objID", new ObjectWrapper(property2));
                        hashtable.put("gWME", new ObjectWrapper(goalStepWME4));
                        return true;
                    }
                }
                return false;
            }
            case 21: {
                final int intValue5 = (int)array[0];
                final float floatValue = (float)array[1];
                final ListIterator listIterator38 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                while (listIterator38.hasNext()) {
                    final ObjectPositionWME objectPositionWME = listIterator38.next();
                    final float x7;
                    final float z7;
                    if (objectPositionWME.getObjectID() == 2 && BehavingEntity.constantTrue(x7 = objectPositionWME.getX()) && BehavingEntity.constantTrue(z7 = objectPositionWME.getZ())) {
                        final ListIterator listIterator39 = BehavingEntity.getBehavingEntity().lookupWME("ObjectRotationWME").listIterator();
                        while (listIterator39.hasNext()) {
                            final ObjectRotationWME objectRotationWME = listIterator39.next();
                            final float y8;
                            if (objectRotationWME.getObjectID() == 2 && BehavingEntity.constantTrue(y8 = objectRotationWME.getY())) {
                                final ListIterator listIterator40 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                                while (listIterator40.hasNext()) {
                                    final ObjectPositionWME objectPositionWME2 = listIterator40.next();
                                    final float x8;
                                    final float z8;
                                    if (objectPositionWME2.getObjectID() == intValue5 && BehavingEntity.constantTrue(x8 = objectPositionWME2.getX()) && BehavingEntity.constantTrue(z8 = objectPositionWME2.getZ()) && Staging.isPointWithinCharCone(x8, z8, x7, z7, y8, 45.0f, 0.0f, 9999.0f) && Staging.getXZDistanceBetweenPoints(x7, z7, x8, z8) < floatValue && System.currentTimeMillis() - ((Player)behavingEntity).g_previousPhysicallyFavoredTime >= ((Player)behavingEntity).g_physicallyFavorLatencyInMS) {
                                        final ListIterator listIterator41 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                                        while (listIterator41.hasNext()) {
                                            final ObjectPositionWME objectPositionWME3 = listIterator41.next();
                                            final float x9;
                                            final float z9;
                                            if (objectPositionWME3.getObjectID() == 1 && BehavingEntity.constantTrue(x9 = objectPositionWME3.getX()) && BehavingEntity.constantTrue(z9 = objectPositionWME3.getZ()) && !Staging.isPointWithinCharCone(x9, z9, x7, z7, y8, 45.0f, 0.0f, 9999.0f)) {
                                                final ListIterator listIterator42 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                                                while (listIterator42.hasNext()) {
                                                    final ObjectPositionWME objectPositionWME4 = listIterator42.next();
                                                    final float x10;
                                                    final float z10;
                                                    if (objectPositionWME4.getObjectID() == 0 && BehavingEntity.constantTrue(x10 = objectPositionWME4.getX()) && BehavingEntity.constantTrue(z10 = objectPositionWME4.getZ()) && !Staging.isPointWithinCharCone(x10, z10, x7, z7, y8, 45.0f, 0.0f, 9999.0f)) {
                                                        final ListIterator listIterator43 = BehavingEntity.getBehavingEntity().lookupWME("HeldObjectWME").listIterator();
                                                        while (listIterator43.hasNext()) {
                                                            if (listIterator43.next().getObjectID() == intValue5) {
                                                                return false;
                                                            }
                                                        }
                                                        hashtable.put("playerX", new Float(x7));
                                                        hashtable.put("graceX", new Float(x10));
                                                        hashtable.put("objX", new Float(x8));
                                                        hashtable.put("tripZ", new Float(z9));
                                                        hashtable.put("objZ", new Float(z8));
                                                        hashtable.put("playerRotY", new Float(y8));
                                                        hashtable.put("playerZ", new Float(z7));
                                                        hashtable.put("tripX", new Float(x9));
                                                        hashtable.put("graceZ", new Float(z10));
                                                        return true;
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
                final int intValue6 = (int)array[0];
                (float)array[1];
                final ListIterator listIterator44 = BehavingEntity.getBehavingEntity().lookupWME("HeldObjectWME").listIterator();
                while (listIterator44.hasNext()) {
                    if (listIterator44.next().getObjectID() == intValue6) {
                        return true;
                    }
                }
                return false;
            }
            case 25: {
                final int intValue7 = (int)array[0];
                final ListIterator listIterator45 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                while (listIterator45.hasNext()) {
                    final ObjectPositionWME objectPositionWME5 = listIterator45.next();
                    final float x11;
                    final float z11;
                    if (objectPositionWME5.getObjectID() == intValue7 && BehavingEntity.constantTrue(x11 = objectPositionWME5.getX()) && BehavingEntity.constantTrue(z11 = objectPositionWME5.getZ())) {
                        final ListIterator listIterator46 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                        while (listIterator46.hasNext()) {
                            final ObjectPositionWME objectPositionWME6 = listIterator46.next();
                            final float x12;
                            final float z12;
                            if (objectPositionWME6.getObjectID() == 2 && BehavingEntity.constantTrue(x12 = objectPositionWME6.getX()) && BehavingEntity.constantTrue(z12 = objectPositionWME6.getZ())) {
                                hashtable.put("playerX", new Float(x12));
                                hashtable.put("objX", new Float(x11));
                                hashtable.put("objZ", new Float(z11));
                                hashtable.put("playerZ", new Float(z12));
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            case 29: {
                final int intValue8 = (int)array[0];
                final int intValue9 = (int)array[1];
                final ListIterator listIterator47 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator47.hasNext()) {
                    final int affinity;
                    if (BehavingEntity.constantTrue(affinity = listIterator47.next().getAffinity()) && ((intValue9 <= -1 && affinity <= -1) || (intValue9 >= 1 && affinity >= 1) || (intValue9 == 0 && affinity == 0))) {
                        final ListIterator listIterator48 = BehavingEntity.getBehavingEntity().lookupWME("SameAffinityBeatCounterWME").listIterator();
                        while (listIterator48.hasNext()) {
                            final SameAffinityBeatCounterWME sameAffinityBeatCounterWME2;
                            final SameAffinityBeatCounterWME sameAffinityBeatCounterWME = sameAffinityBeatCounterWME2 = listIterator48.next();
                            if (sameAffinityBeatCounterWME.getTargetBeatCount() == intValue8 && sameAffinityBeatCounterWME.getTargetAffinity() == intValue9) {
                                hashtable.put("currentAffinity", new Integer(affinity));
                                hashtable.put("affinityCounter", new ObjectWrapper(sameAffinityBeatCounterWME2));
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            case 30: {
                final int intValue10 = (int)array[0];
                final int intValue11 = (int)array[1];
                final ListIterator listIterator49 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator49.hasNext()) {
                    final int affinity2;
                    if (BehavingEntity.constantTrue(affinity2 = listIterator49.next().getAffinity())) {
                        final ListIterator listIterator50 = BehavingEntity.getBehavingEntity().lookupWME("SameAffinityBeatCounterWME").listIterator();
                        while (listIterator50.hasNext()) {
                            final SameAffinityBeatCounterWME sameAffinityBeatCounterWME4;
                            final SameAffinityBeatCounterWME sameAffinityBeatCounterWME3 = sameAffinityBeatCounterWME4 = listIterator50.next();
                            if (sameAffinityBeatCounterWME3.getTargetBeatCount() == intValue10 && sameAffinityBeatCounterWME3.getTargetAffinity() == intValue11) {
                                hashtable.put("currentAffinity", new Integer(affinity2));
                                hashtable.put("affinityCounter", new ObjectWrapper(sameAffinityBeatCounterWME4));
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            case 31: {
                final int intValue12 = (int)array[0];
                final int intValue13 = (int)array[1];
                final ListIterator listIterator51 = WorkingMemory.lookupWME("BeatMemory", "SameAffinityNBeatsWME").listIterator();
                while (listIterator51.hasNext()) {
                    final SameAffinityNBeatsWME sameAffinityNBeatsWME2;
                    final SameAffinityNBeatsWME sameAffinityNBeatsWME = sameAffinityNBeatsWME2 = listIterator51.next();
                    if (sameAffinityNBeatsWME.getBeatCount() == intValue12 && sameAffinityNBeatsWME.getTargetAffinity() == intValue13) {
                        hashtable.put("sameAffinityWME", new ObjectWrapper(sameAffinityNBeatsWME2));
                        return true;
                    }
                }
                return false;
            }
            case 33: {
                (float)array[0];
                final ListIterator listIterator52 = BehavingEntity.getBehavingEntity().lookupWME("OneCharacterVisibleInfoWME").listIterator();
                if (!listIterator52.hasNext()) {
                    return false;
                }
                hashtable.put("oneCharacterVisibleInfoWME", new ObjectWrapper(listIterator52.next()));
                return true;
            }
            case 35: {
                final ListIterator listIterator53 = WorkingMemory.lookupWME("BeatMemory", "OneCharacterVisibleWME").listIterator();
                if (!listIterator53.hasNext()) {
                    final ListIterator listIterator54 = BehavingEntity.getBehavingEntity().lookupWME("OneCharacterVisibleInfoWME").listIterator();
                    while (listIterator54.hasNext()) {
                        final float lookDistance3;
                        if (BehavingEntity.constantTrue(lookDistance3 = listIterator54.next().getLookDistance())) {
                            final ListIterator listIterator55 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                            while (listIterator55.hasNext()) {
                                final ObjectPositionWME objectPositionWME7 = listIterator55.next();
                                final float x13;
                                final float z13;
                                if (objectPositionWME7.getObjectID() == 2 && BehavingEntity.constantTrue(x13 = objectPositionWME7.getX()) && BehavingEntity.constantTrue(z13 = objectPositionWME7.getZ())) {
                                    final ListIterator listIterator56 = BehavingEntity.getBehavingEntity().lookupWME("ObjectRotationWME").listIterator();
                                    while (listIterator56.hasNext()) {
                                        final ObjectRotationWME objectRotationWME2 = listIterator56.next();
                                        final float y9;
                                        if (objectRotationWME2.getObjectID() == 2 && BehavingEntity.constantTrue(y9 = objectRotationWME2.getY())) {
                                            final ListIterator listIterator57 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                                            while (listIterator57.hasNext()) {
                                                final ObjectPositionWME objectPositionWME8 = listIterator57.next();
                                                final float x14;
                                                final float z14;
                                                if (objectPositionWME8.getObjectID() == 1 && BehavingEntity.constantTrue(x14 = objectPositionWME8.getX()) && BehavingEntity.constantTrue(z14 = objectPositionWME8.getZ())) {
                                                    final ListIterator listIterator58 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                                                    while (listIterator58.hasNext()) {
                                                        final ObjectPositionWME objectPositionWME9 = listIterator58.next();
                                                        final float x15;
                                                        final float z15;
                                                        if (objectPositionWME9.getObjectID() == 0 && BehavingEntity.constantTrue(x15 = objectPositionWME9.getX()) && BehavingEntity.constantTrue(z15 = objectPositionWME9.getZ())) {
                                                            hashtable.put("playerX", new Float(x13));
                                                            hashtable.put("lookDistance", new Float(lookDistance3));
                                                            hashtable.put("graceX", new Float(x15));
                                                            hashtable.put("tripZ", new Float(z14));
                                                            hashtable.put("playerRotY", new Float(y9));
                                                            hashtable.put("playerZ", new Float(z13));
                                                            hashtable.put("tripX", new Float(x14));
                                                            hashtable.put("graceZ", new Float(z15));
                                                            return true;
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
                final OneCharacterVisibleWME oneCharacterVisibleWME = listIterator53.next();
                return false;
            }
            case 36: {
                final ListIterator listIterator59 = WorkingMemory.lookupWME("BeatMemory", "OneCharacterVisibleWME").listIterator();
                while (listIterator59.hasNext()) {
                    final OneCharacterVisibleWME oneCharacterVisibleWME2;
                    final int visibleCharID;
                    if (BehavingEntity.constantTrue(visibleCharID = (oneCharacterVisibleWME2 = listIterator59.next()).getVisibleCharID())) {
                        hashtable.put("charID", new Integer(visibleCharID));
                        hashtable.put("visibleWME", new ObjectWrapper(oneCharacterVisibleWME2));
                        return true;
                    }
                }
                return false;
            }
            case 37: {
                final boolean booleanValue9 = (boolean)array[0];
                final boolean booleanValue10 = (boolean)array[1];
                return (booleanValue9 && booleanValue10) || (!booleanValue9 && !booleanValue10);
            }
            case 38: {
                final boolean booleanValue11 = (boolean)array[0];
                final boolean booleanValue12 = (boolean)array[1];
                return (booleanValue11 && !booleanValue12) || (!booleanValue11 && booleanValue12);
            }
            case 40: {
                final ListIterator listIterator60 = BehavingEntity.getBehavingEntity().lookupWME("PlayerUncoopWME").listIterator();
                while (listIterator60.hasNext()) {
                    final PlayerUncoopWME playerUncoopWME = listIterator60.next();
                    final ListIterator listIterator61 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                    while (listIterator61.hasNext()) {
                        final ObjectPositionWME objectPositionWME10 = listIterator61.next();
                        final float x16;
                        final float z16;
                        if (objectPositionWME10.getObjectID() == 2 && BehavingEntity.constantTrue(x16 = objectPositionWME10.getX()) && BehavingEntity.constantTrue(z16 = objectPositionWME10.getZ())) {
                            final ListIterator listIterator62 = BehavingEntity.getBehavingEntity().lookupWME("ObjectRotationWME").listIterator();
                            while (listIterator62.hasNext()) {
                                final ObjectRotationWME objectRotationWME3 = listIterator62.next();
                                final float y10;
                                if (objectRotationWME3.getObjectID() == 2 && BehavingEntity.constantTrue(y10 = objectRotationWME3.getY())) {
                                    final ListIterator listIterator63 = BehavingEntity.getBehavingEntity().lookupWME("PlayerRecentlyTypedTextWME").listIterator();
                                    while (listIterator63.hasNext()) {
                                        final boolean b3;
                                        if (BehavingEntity.constantTrue(b3 = listIterator63.next().getB())) {
                                            hashtable.put("playerX", new Float(x16));
                                            hashtable.put("w", new ObjectWrapper(playerUncoopWME));
                                            hashtable.put("playerRotY", new Float(y10));
                                            hashtable.put("playerZ", new Float(z16));
                                            hashtable.put("bRecentlyTyped", new Boolean(b3));
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return false;
            }
            case 45: {
                final ListIterator<CollectionBehaviorWME> listIterator64 = (ListIterator<CollectionBehaviorWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEBySignature("CollectionBehaviorWME", "OverallControl_Body()").listIterator();
                while (listIterator64.hasNext()) {
                    final CollectionBehaviorWME collectionBehaviorWME3;
                    if ((collectionBehaviorWME3 = listIterator64.next()).getSignature().equals("OverallControl_Body()")) {
                        hashtable.put("overallControl_Body", new ObjectWrapper(collectionBehaviorWME3));
                        return true;
                    }
                }
                return false;
            }
            case 46: {
                final CollectionBehaviorWME collectionBehaviorWME4 = (CollectionBehaviorWME)array[0];
                return !((List)array[1]).isEmpty();
            }
            case 47: {
                final CollectionBehaviorWME collectionBehaviorWME5 = (CollectionBehaviorWME)array[0];
                return ((List)array[1]).isEmpty();
            }
            default: {
                throw new AblRuntimeError("Unexpected behaviorID " + n);
            }
        }
    }
}
