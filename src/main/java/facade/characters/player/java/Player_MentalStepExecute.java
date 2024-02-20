package facade.characters.player.java;

import java.util.LinkedList;
import java.util.Iterator;
import facade.characters.wmedef.OneCharacterVisibleWME;
import facade.characters.wmedef.SameAffinityNBeatsWME;
import dramaman.runtime.StoryMemory;
import dramaman.runtime.BeatStartWME;
import java.util.List;
import java.util.Vector;
import wm.WorkingMemory;
import facade.characters.wmedef.PhysicallyFavorWME;
import abl.runtime.GoalStepWME;
import facade.nativeinterface.NativeAnimationInterface;
import facade.util.StringUtil;
import facade.util.PrintUtilities;
import abl.runtime.AblRuntimeError;
import facade.characters.wmedef.PlayerUncoopWME;
import facade.characters.wmedef.PlayerFutureRotationWME;
import facade.characters.wmedef.PlayerFuturePositionWME;
import facade.characters.wmedef.PlayerRecentlyTypedTextWME;
import facade.characters.wmedef.PlayerCrowdWME;
import facade.characters.wmedef.IsPlayerRotatingWME;
import facade.characters.wmedef.IsPlayerSettledWME;
import facade.characters.wmedef.IsPlayerTranslatingOrRotatingWME;
import facade.characters.wmedef.IsPlayerTranslatingWME;
import facade.util.Staging;
import wm.WME;
import abl.runtime.__ValueTypes;
import abl.runtime.MentalStep;
import abl.runtime.BehavingEntity;
import dramaman.runtime.DramaManagerConstants;
import facade.util.SpriteID;
import facade.util.BeatConstants;

public class Player_MentalStepExecute implements BeatConstants, SpriteID, DramaManagerConstants
{
    public static void mentalExecute0(final int n, final Object[] array, final BehavingEntity behavingEntity, final MentalStep mentalStep) {
        switch (n) {
            case 0: {
                BehavingEntity.getBehavingEntity().addWME(new PreviousCachedPlayerPositionWME(((__ValueTypes.FloatVar)array[0]).f, 0.0f, ((__ValueTypes.FloatVar)array[1]).f));
                break;
            }
            case 1: {
                ((PreviousCachedPlayerPositionWME)array[4]).setX(((__ValueTypes.FloatVar)array[3]).f);
                ((PreviousCachedPlayerPositionWME)array[4]).setY(0.0f);
                ((PreviousCachedPlayerPositionWME)array[4]).setZ(((__ValueTypes.FloatVar)array[0]).f);
                if (Staging.getXZDistanceBetweenPoints(((__ValueTypes.FloatVar)array[5]).f, ((__ValueTypes.FloatVar)array[1]).f, ((__ValueTypes.FloatVar)array[3]).f, ((__ValueTypes.FloatVar)array[0]).f) != 0.0f) {
                    ((IsPlayerTranslatingWME)array[7]).setB(true);
                    ((IsPlayerTranslatingOrRotatingWME)array[6]).setB(true);
                    ((IsPlayerSettledWME)array[2]).setB(false);
                }
                break;
            }
            case 2: {
                ((PreviousCachedPlayerPositionWME)array[3]).setX(((__ValueTypes.FloatVar)array[2]).f);
                ((PreviousCachedPlayerPositionWME)array[3]).setY(0.0f);
                ((PreviousCachedPlayerPositionWME)array[3]).setZ(((__ValueTypes.FloatVar)array[0]).f);
                if (Staging.getXZDistanceBetweenPoints(((__ValueTypes.FloatVar)array[4]).f, ((__ValueTypes.FloatVar)array[1]).f, ((__ValueTypes.FloatVar)array[2]).f, ((__ValueTypes.FloatVar)array[0]).f) == 0.0f) {
                    ((IsPlayerTranslatingWME)array[7]).setB(false);
                    if (!((__ValueTypes.BooleanVar)array[6]).b) {
                        ((IsPlayerTranslatingOrRotatingWME)array[5]).setB(false);
                    }
                }
                break;
            }
            case 3: {
                BehavingEntity.getBehavingEntity().addWME(new PreviousCachedPlayerRotationWME(0.0f, ((__ValueTypes.FloatVar)array[0]).f, 0.0f));
                break;
            }
            case 4: {
                ((PreviousCachedPlayerRotationWME)array[3]).setX(0.0f);
                ((PreviousCachedPlayerRotationWME)array[3]).setY(((__ValueTypes.FloatVar)array[2]).f);
                ((PreviousCachedPlayerRotationWME)array[3]).setZ(0.0f);
                if (Math.abs(Staging.normalizeNeg180to180(((__ValueTypes.FloatVar)array[1]).f - ((__ValueTypes.FloatVar)array[2]).f)) != 0.0f) {
                    ((IsPlayerRotatingWME)array[5]).setB(true);
                    ((IsPlayerTranslatingOrRotatingWME)array[4]).setB(true);
                    ((IsPlayerSettledWME)array[0]).setB(false);
                }
                break;
            }
            case 5: {
                ((PreviousCachedPlayerRotationWME)array[2]).setX(0.0f);
                ((PreviousCachedPlayerRotationWME)array[2]).setY(((__ValueTypes.FloatVar)array[1]).f);
                ((PreviousCachedPlayerRotationWME)array[2]).setZ(0.0f);
                if (Math.abs(Staging.normalizeNeg180to180(((__ValueTypes.FloatVar)array[0]).f - ((__ValueTypes.FloatVar)array[1]).f)) == 0.0f) {
                    ((IsPlayerRotatingWME)array[5]).setB(false);
                    if (!((__ValueTypes.BooleanVar)array[4]).b) {
                        ((IsPlayerTranslatingOrRotatingWME)array[3]).setB(false);
                    }
                }
                break;
            }
            case 9: {
                if (!((IsPlayerSettledWME)array[0]).getB()) {
                    ((IsPlayerSettledWME)array[0]).setB(true);
                }
                break;
            }
            case 10: {
                BehavingEntity.getBehavingEntity().addWME(new IsPlayerTranslatingWME(false));
                BehavingEntity.getBehavingEntity().addWME(new IsPlayerRotatingWME(false));
                BehavingEntity.getBehavingEntity().addWME(new IsPlayerTranslatingOrRotatingWME(false));
                BehavingEntity.getBehavingEntity().addWME(new IsPlayerSettledWME(true));
                BehavingEntity.getBehavingEntity().addWME(new PlayerCrowdWME(0L));
                BehavingEntity.getBehavingEntity().addWME(new PlayerRecentlyTypedTextWME(false, 0L));
                BehavingEntity.getBehavingEntity().addWME(new CachedPlayerPositionWME(0.0f, 0.0f, 0.0f));
                BehavingEntity.getBehavingEntity().addWME(new CachedPlayerRotationWME(0.0f, 0.0f, 0.0f));
                BehavingEntity.getBehavingEntity().addWME(new PlayerFuturePositionWME(0.0f, 0.0f, 0.0f));
                BehavingEntity.getBehavingEntity().addWME(new PlayerFutureRotationWME(0.0f, 0.0f, 0.0f));
                BehavingEntity.getBehavingEntity().addWME(new PlayerUncoopWME());
                break;
            }
            case 11: {
                ((__ValueTypes.FloatVar)array[1]).f = 5;
                ((PlayerFuturePositionWME)array[9]).setX((((__ValueTypes.FloatVar)array[2]).f - ((CachedPlayerPositionWME)array[4]).getX()) * ((__ValueTypes.FloatVar)array[1]).f + ((__ValueTypes.FloatVar)array[2]).f);
                ((PlayerFuturePositionWME)array[9]).setY((((__ValueTypes.FloatVar)array[5]).f - ((CachedPlayerPositionWME)array[4]).getY()) * ((__ValueTypes.FloatVar)array[1]).f + ((__ValueTypes.FloatVar)array[5]).f);
                ((PlayerFuturePositionWME)array[9]).setZ((((__ValueTypes.FloatVar)array[7]).f - ((CachedPlayerPositionWME)array[4]).getZ()) * ((__ValueTypes.FloatVar)array[1]).f + ((__ValueTypes.FloatVar)array[7]).f);
                ((PlayerFutureRotationWME)array[6]).setY((((__ValueTypes.FloatVar)array[3]).f - ((CachedPlayerRotationWME)array[8]).getY()) * ((__ValueTypes.FloatVar)array[1]).f + ((__ValueTypes.FloatVar)array[3]).f);
                ((__ValueTypes.LongVar)array[0]).l = System.currentTimeMillis();
                BehavingEntity.getBehavingEntity().deleteAllWMEClass("CachedPlayerPositionWME");
                BehavingEntity.getBehavingEntity().addWME(new CachedPlayerPositionWME(((__ValueTypes.FloatVar)array[2]).f, 0.0f, ((__ValueTypes.FloatVar)array[7]).f));
                BehavingEntity.getBehavingEntity().deleteAllWMEClass("CachedPlayerRotationWME");
                BehavingEntity.getBehavingEntity().addWME(new CachedPlayerRotationWME(0.0f, ((__ValueTypes.FloatVar)array[3]).f, 0.0f));
                break;
            }
            case 14: {
                try {
                    Thread.currentThread();
                    Thread.sleep(100L);
                }
                catch (InterruptedException ex) {
                    throw new AblRuntimeError(ex);
                }
                break;
            }
            case 19: {
                StringUtil.println("Turning off physicallyFavors sensor for sprite ID " + PrintUtilities.spriteID_EnumToString(((__ValueTypes.IntVar)array[0]).i) + " with timeout " + ((__ValueTypes.IntVar)array[1]).i);
                NativeAnimationInterface.addEventInfoToLog("Turning off physicallyFavors sensor for sprite ID " + PrintUtilities.spriteID_EnumToString(((__ValueTypes.IntVar)array[0]).i) + " with timeout " + ((__ValueTypes.IntVar)array[1]).i);
                break;
            }
            case 23: {
                if (((GoalStepWME)array[1]).isValid()) {
                    ((GoalStepWME)array[1]).fail();
                }
                else {
                    StringUtil.println("!!!! Unexpected invalid goal WME in TurnOffPhysicallyFavorsWithTimeout");
                }
                break;
            }
            case 25: {
                StringUtil.println("### PhysicallyFavors csensor turned back on after timeout for sprite " + PrintUtilities.spriteID_EnumToString(((__ValueTypes.IntVar)array[0]).i) + " ###");
                NativeAnimationInterface.addEventInfoToLog("PhysicallyFavors csensor turned back on after timeout for sprite " + PrintUtilities.spriteID_EnumToString(((__ValueTypes.IntVar)array[0]).i));
                break;
            }
            case 28: {
                StringUtil.println("Turning on physicallyFavors sensor for sprite ID " + PrintUtilities.spriteID_EnumToString(((__ValueTypes.IntVar)array[0]).i));
                NativeAnimationInterface.addEventInfoToLog("Turning on physicallyFavors sensor for sprite ID " + PrintUtilities.spriteID_EnumToString(((__ValueTypes.IntVar)array[0]).i));
                break;
            }
            case 31: {
                if (((GoalStepWME)array[1]).isValid()) {
                    ((GoalStepWME)array[1]).fail();
                }
                else {
                    StringUtil.println("!!!! Unexpected invalid goal WME in TurnOnPhysicallyFavors_KillDemon");
                }
                break;
            }
            case 33: {
                StringUtil.println("csPlayerPhysicallyFavors_ObjectActivation " + PrintUtilities.spriteID_EnumToString(((__ValueTypes.IntVar)array[0]).i));
                NativeAnimationInterface.addEventInfoToLog("csPlayerPhysicallyFavors_ObjectActivation " + PrintUtilities.spriteID_EnumToString(((__ValueTypes.IntVar)array[0]).i));
                WorkingMemory.addWME("BeatMemory", new PhysicallyFavorWME(((__ValueTypes.IntVar)array[0]).i, 2));
                array[1] = new PhysicallyFavorWME(((__ValueTypes.IntVar)array[0]).i, 2);
                ((PhysicallyFavorWME)array[1]).setHandled(true);
                BehavingEntity.getBehavingEntity().addWME((WME)array[1]);
                ((Player)behavingEntity).g_previousPhysicallyFavoredTime = System.currentTimeMillis();
                break;
            }
            case 36: {
                array[2] = new PhysicallyFavorWME(((__ValueTypes.IntVar)array[0]).i, 2);
                BehavingEntity.getBehavingEntity().addWME((WME)array[2]);
                break;
            }
            case 41: {
                StringUtil.println("Player distance to object = " + Staging.getXZDistanceBetweenPoints(((__ValueTypes.FloatVar)array[1]).f, ((__ValueTypes.FloatVar)array[2]).f, ((__ValueTypes.FloatVar)array[4]).f, ((__ValueTypes.FloatVar)array[3]).f));
                break;
            }
            case 44: {
                BehavingEntity.getBehavingEntity().deleteWME((WME)array[0]);
                StringUtil.println("Done suppressing physicallyFavors_lookAt for object: " + PrintUtilities.spriteID_EnumToString(((PhysicallyFavorWME)array[0]).getObjectID()));
                NativeAnimationInterface.addEventInfoToLog("Done suppressing physicallyFavors_lookAt for object: " + PrintUtilities.spriteID_EnumToString(((PhysicallyFavorWME)array[0]).getObjectID()));
                break;
            }
            case 47: {
                final Iterator iterator = BehavingEntity.getBehavingEntity().lookupWME("PhysicallyFavorWME").iterator();
                final Vector<PhysicallyFavorWME> vector = new Vector<PhysicallyFavorWME>();
                while (iterator.hasNext()) {
                    final PhysicallyFavorWME physicallyFavorWME = iterator.next();
                    if (!physicallyFavorWME.getHandled()) {
                        vector.add(new PhysicallyFavorWME(physicallyFavorWME.getObjectID(), physicallyFavorWME.getFavoringCharID()));
                        physicallyFavorWME.setHandled(true);
                        StringUtil.println("csPlayerPhysicallyFavors_LookAt " + PrintUtilities.spriteID_EnumToString(physicallyFavorWME.getObjectID()));
                        NativeAnimationInterface.addEventInfoToLog("csPlayerPhysicallyFavors_LookAt " + PrintUtilities.spriteID_EnumToString(physicallyFavorWME.getObjectID()));
                    }
                }
                WorkingMemory.addWMEs("BeatMemory", vector);
                ((Player)behavingEntity).g_previousPhysicallyFavoredTime = System.currentTimeMillis();
                break;
            }
            case 48: {
                final LinkedList lookupWME = BehavingEntity.getBehavingEntity().lookupWME("SameAffinityBeatCounterWME");
                final SameAffinityBeatCounterWME[] array2 = (SameAffinityBeatCounterWME[])lookupWME.toArray(new SameAffinityBeatCounterWME[lookupWME.size()]);
                for (int i = 0; i < array2.length; ++i) {
                    if (array2[i].getTargetBeatCount() == ((__ValueTypes.IntVar)array[0]).i && array2[i].getTargetAffinity() == ((__ValueTypes.IntVar)array[1]).i) {
                        BehavingEntity.getBehavingEntity().deleteWME(array2[i]);
                    }
                }
                BehavingEntity.getBehavingEntity().addWME(new SameAffinityBeatCounterWME(((__ValueTypes.IntVar)array[0]).i, 0, ((__ValueTypes.IntVar)array[1]).i));
                break;
            }
            case 51: {
                final BeatStartWME beatStartWME = (BeatStartWME)((StoryMemory)array[2]).findPrev("dramaman.runtime.BeatStartWME", System.currentTimeMillis());
                if (beatStartWME == null) {
                    ((__ValueTypes.LongVar)array[3]).l = 0L;
                }
                else {
                    ((__ValueTypes.LongVar)array[3]).l = beatStartWME.getTimestamp();
                }
                break;
            }
            case 53: {
                ((SameAffinityBeatCounterWME)array[5]).setCounter(((SameAffinityBeatCounterWME)array[5]).getCounter() + 1);
                break;
            }
            case 55: {
                ((SameAffinityBeatCounterWME)array[3]).setCounter(0);
                break;
            }
            case 58: {
                WorkingMemory.deleteWME("BeatMemory", (WME)array[2]);
                break;
            }
            case 60: {
                StringUtil.println("Adding SameAffinityNBeatsWME(" + ((__ValueTypes.IntVar)array[0]).i + ", " + ((__ValueTypes.IntVar)array[1]).i + ") to beat memory");
                WorkingMemory.addWME("BeatMemory", new SameAffinityNBeatsWME(((__ValueTypes.IntVar)array[0]).i, ((__ValueTypes.IntVar)array[1]).i));
                break;
            }
            case 62: {
                ((OneCharacterVisibleInfoWME)array[1]).setLookDistance(((__ValueTypes.FloatVar)array[0]).f);
                break;
            }
            case 63: {
                StringUtil.println("OneCharacterVisbileSensorWME not found in player memory!");
                break;
            }
            case 64: {
                ((__ValueTypes.BooleanVar)array[0]).b = Staging.isPointWithinCharCone(((__ValueTypes.FloatVar)array[8]).f, ((__ValueTypes.FloatVar)array[6]).f, ((__ValueTypes.FloatVar)array[4]).f, ((__ValueTypes.FloatVar)array[7]).f, ((__ValueTypes.FloatVar)array[3]).f, 45.0f, 0.0f, ((__ValueTypes.FloatVar)array[9]).f);
                ((__ValueTypes.BooleanVar)array[1]).b = Staging.isPointWithinCharCone(((__ValueTypes.FloatVar)array[2]).f, ((__ValueTypes.FloatVar)array[5]).f, ((__ValueTypes.FloatVar)array[4]).f, ((__ValueTypes.FloatVar)array[7]).f, ((__ValueTypes.FloatVar)array[3]).f, 45.0f, 0.0f, ((__ValueTypes.FloatVar)array[9]).f);
                break;
            }
            case 67: {
                WorkingMemory.deleteWME("BeatMemory", (WME)array[2]);
                break;
            }
            case 69: {
                boolean b;
                if (((__ValueTypes.BooleanVar)array[0]).b) {
                    b = true;
                }
                else {
                    b = false;
                }
                WorkingMemory.addWME("BeatMemory", new OneCharacterVisibleWME((int)(b ? 1 : 0)));
                break;
            }
            case 70: {
                boolean b2;
                if (((__ValueTypes.BooleanVar)array[0]).b) {
                    b2 = true;
                }
                else {
                    b2 = false;
                }
                WorkingMemory.addWME("BeatMemory", new OneCharacterVisibleWME((int)(b2 ? 1 : 0)));
                break;
            }
            case 73: {
                if (((PlayerUncoopWME)array[7]).getMillisLastSpoke() == 0L) {
                    if (!((__ValueTypes.BooleanVar)array[5]).b) {
                        ((PlayerUncoopWME)array[7]).setMillisLastSpoke(System.currentTimeMillis());
                    }
                }
                else if (((__ValueTypes.BooleanVar)array[5]).b) {
                    ((PlayerUncoopWME)array[7]).setMillisLastSpoke(0L);
                }
                final __ValueTypes.BooleanVar booleanVar = (__ValueTypes.BooleanVar)array[0];
                boolean b3 = false;
                if (((__ValueTypes.FloatVar)array[4]).f == ((PlayerUncoopWME)array[7]).getPrevPlayerX() && ((__ValueTypes.FloatVar)array[6]).f == ((PlayerUncoopWME)array[7]).getPrevPlayerZ() && ((__ValueTypes.FloatVar)array[3]).f == ((PlayerUncoopWME)array[7]).getPrevPlayerRot()) {
                    b3 = true;
                }
                booleanVar.b = b3;
                if (((PlayerUncoopWME)array[7]).getMillisLastStill() == 0L) {
                    if (((__ValueTypes.BooleanVar)array[0]).b) {
                        ((PlayerUncoopWME)array[7]).setMillisLastStill(System.currentTimeMillis());
                    }
                }
                else if (!((__ValueTypes.BooleanVar)array[0]).b) {
                    ((PlayerUncoopWME)array[7]).setMillisLastStill(0L);
                }
                ((PlayerUncoopWME)array[7]).setPrevPlayerX(((__ValueTypes.FloatVar)array[4]).f);
                ((PlayerUncoopWME)array[7]).setPrevPlayerZ(((__ValueTypes.FloatVar)array[6]).f);
                ((PlayerUncoopWME)array[7]).setPrevPlayerRot(((__ValueTypes.FloatVar)array[3]).f);
                if (((PlayerUncoopWME)array[7]).getMillisLastBeganMoving() == 0L) {
                    if (!((__ValueTypes.BooleanVar)array[0]).b) {
                        ((PlayerUncoopWME)array[7]).setMillisLastBeganMoving(System.currentTimeMillis());
                    }
                }
                else if (((__ValueTypes.BooleanVar)array[0]).b) {
                    ((PlayerUncoopWME)array[7]).setMillisLastBeganMoving(0L);
                }
                final __ValueTypes.BooleanVar booleanVar2 = (__ValueTypes.BooleanVar)array[1];
                boolean b4 = false;
                if (((__ValueTypes.FloatVar)array[4]).f < -150.0f && ((__ValueTypes.FloatVar)array[6]).f > 50.0f) {
                    b4 = true;
                }
                booleanVar2.b = b4;
                if (((PlayerUncoopWME)array[7]).getMillisStartedLeavingApartment() == 0L) {
                    if (((__ValueTypes.BooleanVar)array[1]).b) {
                        ((PlayerUncoopWME)array[7]).setMillisStartedLeavingApartment(System.currentTimeMillis());
                    }
                }
                else if (!((__ValueTypes.BooleanVar)array[1]).b) {
                    ((PlayerUncoopWME)array[7]).setMillisStartedLeavingApartment(0L);
                }
                final __ValueTypes.BooleanVar booleanVar3 = (__ValueTypes.BooleanVar)array[1];
                boolean b5 = false;
                if (((__ValueTypes.FloatVar)array[4]).f > -115.0f && ((__ValueTypes.FloatVar)array[6]).f > ((PlayerUncoopWME)array[7]).getLeavingForKitchenZ()) {
                    b5 = true;
                }
                booleanVar3.b = b5;
                if (((PlayerUncoopWME)array[7]).getMillisStartedLeavingForKitchen() == 0L) {
                    if (((__ValueTypes.BooleanVar)array[1]).b) {
                        ((PlayerUncoopWME)array[7]).setMillisStartedLeavingForKitchen(System.currentTimeMillis());
                    }
                }
                else if (!((__ValueTypes.BooleanVar)array[1]).b) {
                    ((PlayerUncoopWME)array[7]).setMillisStartedLeavingForKitchen(0L);
                }
                if (((PlayerUncoopWME)array[7]).getBMonitorAntisocial() && ((PlayerUncoopWME)array[7]).getMillisLastSpoke() > 0L && System.currentTimeMillis() - ((PlayerUncoopWME)array[7]).getMillisLastSpoke() > 180000L) {
                    if (!((PlayerUncoopWME)array[7]).getBNotSpeaking()) {
                        StringUtil.println("## Player has not spoken for a while");
                    }
                    ((PlayerUncoopWME)array[7]).setBNotSpeaking(true);
                }
                else {
                    ((PlayerUncoopWME)array[7]).setBNotSpeaking(false);
                }
                if (((PlayerUncoopWME)array[7]).getBMonitorAntisocial() && ((PlayerUncoopWME)array[7]).getMillisLastStill() > 0L && System.currentTimeMillis() - ((PlayerUncoopWME)array[7]).getMillisLastStill() > 300000L) {
                    if (!((PlayerUncoopWME)array[7]).getBNotMoving()) {
                        StringUtil.println("## Player has not moved for a while");
                    }
                    ((PlayerUncoopWME)array[7]).setBNotMoving(true);
                }
                else {
                    ((PlayerUncoopWME)array[7]).setBNotMoving(false);
                }
                if (((PlayerUncoopWME)array[7]).getBMonitorAntisocial() && ((PlayerUncoopWME)array[7]).getMillisLastBeganMoving() > 0L && System.currentTimeMillis() - ((PlayerUncoopWME)array[7]).getMillisLastBeganMoving() > 45000L) {
                    if (!((PlayerUncoopWME)array[7]).getBFidgety()) {
                        StringUtil.println("## Player has been fidgety for a while");
                    }
                    ((PlayerUncoopWME)array[7]).setBFidgety(true);
                }
                else {
                    ((PlayerUncoopWME)array[7]).setBFidgety(false);
                }
                if (((PlayerUncoopWME)array[7]).getBMonitorLeavingApartment() && ((PlayerUncoopWME)array[7]).getMillisStartedLeavingApartment() > 0L && System.currentTimeMillis() - ((PlayerUncoopWME)array[7]).getMillisStartedLeavingApartment() >= 3000L) {
                    if (!((PlayerUncoopWME)array[7]).getBLeavingApartment()) {
                        StringUtil.println("## Player seems to be leaving apartment");
                    }
                    ((PlayerUncoopWME)array[7]).setBLeavingApartment(true);
                }
                else {
                    ((PlayerUncoopWME)array[7]).setBLeavingApartment(false);
                }
                if (((PlayerUncoopWME)array[7]).getBMonitorLeavingForKitchen() && ((PlayerUncoopWME)array[7]).getMillisStartedLeavingForKitchen() > 0L && System.currentTimeMillis() - ((PlayerUncoopWME)array[7]).getMillisStartedLeavingForKitchen() >= 3000L) {
                    if (!((PlayerUncoopWME)array[7]).getBLeavingForKitchen()) {
                        StringUtil.println("## Player seems to be leaving for kitchen");
                    }
                    ((PlayerUncoopWME)array[7]).setBLeavingForKitchen(true);
                }
                else {
                    ((PlayerUncoopWME)array[7]).setBLeavingForKitchen(false);
                }
                final PlayerUncoopWME playerUncoopWME = (PlayerUncoopWME)array[7];
                boolean bCurrentlyUncooperative = false;
                if (((PlayerUncoopWME)array[7]).getBNotSpeaking() || ((PlayerUncoopWME)array[7]).getBNotMoving() || ((PlayerUncoopWME)array[7]).getBActingWeird() || ((PlayerUncoopWME)array[7]).getBFidgety() || ((PlayerUncoopWME)array[7]).getBLeavingForKitchen() || ((PlayerUncoopWME)array[7]).getBLeavingApartment() || ((PlayerUncoopWME)array[7]).getBLeftApartment()) {
                    bCurrentlyUncooperative = true;
                }
                playerUncoopWME.setBCurrentlyUncooperative(bCurrentlyUncooperative);
                break;
            }
            case 74: {
                ((__ValueTypes.LongVar)array[1]).l = System.currentTimeMillis() + (int)(((__ValueTypes.FloatVar)array[0]).f * 1000.0f);
                break;
            }
            case 76: {
                ((__ValueTypes.FloatVar)array[1]).f = (float)((__ValueTypes.IntVar)array[0]).i;
                break;
            }
            case 78: {
                StringUtil.println("** Player OverallControl");
                break;
            }
            case 80: {
                final BehavingEntity behavingEntity2 = BehavingEntity.getBehavingEntity();
                behavingEntity2.addWME(new PhysicallyFavorInfoWME(3, true, true, ((Player)behavingEntity).g_physicallyFavorLookDistance_Medium));
                behavingEntity2.addWME(new PhysicallyFavorInfoWME(5, true, true, ((Player)behavingEntity).g_physicallyFavorLookDistance_Medium));
                behavingEntity2.addWME(new PhysicallyFavorInfoWME(6, true, true, ((Player)behavingEntity).g_physicallyFavorLookDistance_Medium));
                behavingEntity2.addWME(new PhysicallyFavorInfoWME(7, true, true, ((Player)behavingEntity).g_physicallyFavorLookDistance_Medium));
                behavingEntity2.addWME(new PhysicallyFavorInfoWME(14, true, true, ((Player)behavingEntity).g_physicallyFavorLookDistance_Medium));
                behavingEntity2.addWME(new PhysicallyFavorInfoWME(15, true, true, ((Player)behavingEntity).g_physicallyFavorLookDistance_Medium));
                behavingEntity2.addWME(new PhysicallyFavorInfoWME(16, true, true, ((Player)behavingEntity).g_physicallyFavorLookDistance_Medium));
                behavingEntity2.addWME(new PhysicallyFavorInfoWME(17, true, true, ((Player)behavingEntity).g_physicallyFavorLookDistance_Medium));
                behavingEntity2.addWME(new PhysicallyFavorInfoWME(12, true, true, ((Player)behavingEntity).g_physicallyFavorLookDistance_Medium));
                behavingEntity2.addWME(new PhysicallyFavorInfoWME(13, true, true, ((Player)behavingEntity).g_physicallyFavorLookDistance_Medium));
                behavingEntity2.addWME(new PhysicallyFavorInfoWME(34, true, true, ((Player)behavingEntity).g_physicallyFavorLookDistance_Long));
                behavingEntity2.addWME(new PhysicallyFavorInfoWME(38, true, true, ((Player)behavingEntity).g_physicallyFavorLookDistance_Medium));
                behavingEntity2.addWME(new PhysicallyFavorInfoWME(39, true, true, ((Player)behavingEntity).g_physicallyFavorLookDistance_Medium));
                behavingEntity2.addWME(new PhysicallyFavorInfoWME(46, true, true, ((Player)behavingEntity).g_physicallyFavorLookDistance_Long));
                behavingEntity2.addWME(new PhysicallyFavorInfoWME(23, true, true, ((Player)behavingEntity).g_physicallyFavorLookDistance_Medium));
                behavingEntity2.addWME(new PhysicallyFavorInfoWME(24, true, true, ((Player)behavingEntity).g_physicallyFavorLookDistance_Medium));
                behavingEntity2.addWME(new PhysicallyFavorInfoWME(25, true, true, ((Player)behavingEntity).g_physicallyFavorLookDistance_Medium));
                behavingEntity2.addWME(new PhysicallyFavorInfoWME(26, true, true, ((Player)behavingEntity).g_physicallyFavorLookDistance_Medium));
                behavingEntity2.addWME(new PhysicallyFavorInfoWME(27, true, true, ((Player)behavingEntity).g_physicallyFavorLookDistance_Medium));
                behavingEntity2.addWME(new PhysicallyFavorInfoWME(28, true, true, ((Player)behavingEntity).g_physicallyFavorLookDistance_Medium));
                behavingEntity2.addWME(new PhysicallyFavorInfoWME(29, true, true, ((Player)behavingEntity).g_physicallyFavorLookDistance_Medium));
                behavingEntity2.addWME(new PhysicallyFavorInfoWME(30, true, true, ((Player)behavingEntity).g_physicallyFavorLookDistance_Medium));
                behavingEntity2.addWME(new PhysicallyFavorInfoWME(31, true, true, ((Player)behavingEntity).g_physicallyFavorLookDistance_Medium));
                behavingEntity2.addWME(new PhysicallyFavorInfoWME(32, true, true, ((Player)behavingEntity).g_physicallyFavorLookDistance_Medium));
                behavingEntity2.addWME(new PhysicallyFavorInfoWME(11, false, true, ((Player)behavingEntity).g_physicallyFavorLookDistance_Medium));
                behavingEntity2.addWME(new OneCharacterVisibleInfoWME(9999.0f));
                break;
            }
            case 89: {
                array[0] = BehavingEntity.getBehavingEntity().lookupWME("PhysicallyFavorInfoWME");
                break;
            }
            case 91: {
                array[2] = ((List)array[1]).remove(0);
                ((__ValueTypes.IntVar)array[3]).i = ((PhysicallyFavorInfoWME)array[2]).getSpriteID();
                ((__ValueTypes.FloatVar)array[4]).f = ((PhysicallyFavorInfoWME)array[2]).getLookDistance();
                ((__ValueTypes.BooleanVar)array[5]).b = ((PhysicallyFavorInfoWME)array[2]).getLookAtSensorActive();
                ((__ValueTypes.BooleanVar)array[6]).b = ((PhysicallyFavorInfoWME)array[2]).getObjectActivateSensorActive();
                break;
            }
            default: {
                throw new AblRuntimeError("Unexpected stepID " + n);
            }
        }
    }
}
