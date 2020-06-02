package facade.characters.player.java;

import abl.runtime.AblRuntimeError;
import abl.runtime.__ValueTypes;
import abl.runtime.GoalStep;
import abl.runtime.MentalStep;
import abl.runtime.SucceedStep;
import abl.runtime.FailStep;
import abl.runtime.AblNamedPropertySupport;
import java.lang.reflect.Method;
import abl.runtime.WaitStep;
import abl.runtime.Step;
import abl.runtime.Behavior;
import dramaman.runtime.DramaManagerConstants;
import facade.util.SpriteID;
import facade.util.BeatConstants;

public class Player_StepFactories implements BeatConstants, SpriteID, DramaManagerConstants
{
    public static Step stepFactory0(final int n, final Behavior behavior, final Object[] array) {
        switch (n) {
            case -3: {
                return new WaitStep(-3, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, null, null, null, null);
            }
            case -2: {
                return new FailStep(-2, behavior, false, false, false, (short)(-32768), (short)0, false, null, null);
            }
            case -1: {
                return new SucceedStep(-1, behavior, false, false, (short)(-32768), (short)0, false, null, null);
            }
            case 0: {
                return new MentalStep(0, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, Player.__$mentalExecute0_rfield, null, null, null);
            }
            case 1: {
                return new MentalStep(1, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, Player.__$mentalExecute0_rfield, null, null, null);
            }
            case 2: {
                return new MentalStep(2, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, Player.__$mentalExecute0_rfield, null, null, null);
            }
            case 3: {
                return new MentalStep(3, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, Player.__$mentalExecute0_rfield, null, null, null);
            }
            case 4: {
                return new MentalStep(4, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, Player.__$mentalExecute0_rfield, null, null, null);
            }
            case 5: {
                return new MentalStep(5, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, Player.__$mentalExecute0_rfield, null, null, null);
            }
            case 6: {
                return new WaitStep(6, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, null, Player.__$successTest0_rfield, null, null);
            }
            case 7: {
                return new GoalStep(7, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, null, null, null, null, "csPlayerSettled_Part2()", null, (short)0);
            }
            case 8: {
                return new GoalStep(8, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, Player.__$argumentExecute0_rfield, null, null, null, "WaitFor(int)", null, (short)0);
            }
            case 9: {
                return new MentalStep(9, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, Player.__$mentalExecute0_rfield, null, null, null);
            }
            case 10: {
                return new MentalStep(10, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, Player.__$mentalExecute0_rfield, null, null, null);
            }
            case 11: {
                return new MentalStep(11, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, Player.__$mentalExecute0_rfield, null, null, null);
            }
            case 12: {
                return new GoalStep(12, behavior, false, false, false, true, false, false, (short)(-32768), (short)0, false, null, null, null, null, null, "csIsPlayerRotating()", null, (short)0);
            }
            case 13: {
                return new GoalStep(13, behavior, false, false, false, true, false, false, (short)(-32768), (short)0, false, null, null, null, null, null, "csIsPlayerTranslating()", null, (short)0);
            }
            case 14: {
                return new MentalStep(14, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, Player.__$mentalExecute0_rfield, null, null, null);
            }
            case 15: {
                return new GoalStep(15, behavior, true, false, false, false, false, false, (short)(-32768), (short)1, false, null, Player.__$argumentExecute0_rfield, null, null, null, "csPlayerPhysicallyFavors_ObjectActivation(int)", null, (short)0);
            }
            case 16: {
                return new GoalStep(16, behavior, true, false, false, false, false, false, (short)(-32768), (short)0, false, null, Player.__$argumentExecute0_rfield, null, null, null, "csPlayerPhysicallyFavors_LookAt(int, float)", null, (short)0);
            }
            case 17: {
                return new GoalStep(17, behavior, true, false, false, false, false, false, (short)(-32768), (short)0, false, null, Player.__$argumentExecute0_rfield, null, null, null, "csPlayerPhysicallyFavors_LookAt(int, float)", null, (short)0);
            }
            case 18: {
                return new GoalStep(18, behavior, true, false, false, false, false, false, (short)(-32768), (short)1, false, null, Player.__$argumentExecute0_rfield, null, null, null, "csPlayerPhysicallyFavors_ObjectActivation(int)", null, (short)0);
            }
            case 19: {
                return new MentalStep(19, behavior, false, false, false, false, false, false, (short)40, (short)0, false, null, Player.__$mentalExecute0_rfield, null, null, null);
            }
            case 20: {
                return new GoalStep(20, behavior, false, false, false, true, false, false, (short)40, (short)0, false, null, Player.__$argumentExecute0_rfield, null, null, null, "TurnOffPhysicallyFavorsWithTimeout_KillSensor(int)", null, (short)0);
            }
            case 21: {
                return new GoalStep(21, behavior, false, false, false, true, false, false, (short)40, (short)0, false, null, Player.__$argumentExecute0_rfield, null, null, null, "PhysicallyFavorsCSensor_KillTimeoutDemon(int)", null, (short)0);
            }
            case 22: {
                final AblNamedPropertySupport ablNamedPropertySupport = new AblNamedPropertySupport();
                ablNamedPropertySupport.setProperty("physicallyFavorsID", new Integer(((__ValueTypes.IntVar)array[0]).i));
                return new GoalStep(22, behavior, false, false, false, false, false, false, (short)40, (short)0, false, null, Player.__$argumentExecute0_rfield, null, null, ablNamedPropertySupport, "TurnPhysicallyFavorsBackOnAfterTimeout_Demon(int, int)", null, (short)1);
            }
            case 23: {
                return new MentalStep(23, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, Player.__$mentalExecute0_rfield, null, null, null);
            }
            case 24: {
                return new GoalStep(24, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, Player.__$argumentExecute0_rfield, null, null, null, "WaitFor(int)", null, (short)0);
            }
            case 25: {
                return new MentalStep(25, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, Player.__$mentalExecute0_rfield, null, null, null);
            }
            case 26: {
                return new GoalStep(26, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, Player.__$argumentExecute0_rfield, null, null, null, "TurnPhysicallyFavorsBackOnAfterTimeout_Demon_Body(int)", null, (short)0);
            }
            case 27: {
                final AblNamedPropertySupport ablNamedPropertySupport2 = new AblNamedPropertySupport();
                ablNamedPropertySupport2.setProperty("physicallyFavorsID", new Integer(((__ValueTypes.IntVar)array[0]).i));
                return new GoalStep(27, behavior, false, false, false, false, false, false, (short)30, (short)0, false, null, Player.__$argumentExecute0_rfield, null, null, ablNamedPropertySupport2, "csPlayerPhysicallyFavors(int, boolean, boolean, float)", null, (short)2);
            }
            case 28: {
                return new MentalStep(28, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, Player.__$mentalExecute0_rfield, null, null, null);
            }
            case 29: {
                return new GoalStep(29, behavior, false, false, false, true, false, false, (short)(-32768), (short)0, false, null, Player.__$argumentExecute0_rfield, null, null, null, "PhysicallyFavorsCSensor_KillTimeoutDemon(int)", null, (short)0);
            }
            case 30: {
                final AblNamedPropertySupport ablNamedPropertySupport3 = new AblNamedPropertySupport();
                ablNamedPropertySupport3.setProperty("physicallyFavorsID", new Integer(((__ValueTypes.IntVar)array[0]).i));
                return new GoalStep(30, behavior, false, false, false, false, false, false, (short)30, (short)0, false, null, Player.__$argumentExecute0_rfield, null, null, ablNamedPropertySupport3, "csPlayerPhysicallyFavors(int, boolean, boolean, float)", null, (short)2);
            }
            case 31: {
                return new MentalStep(31, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, Player.__$mentalExecute0_rfield, null, null, null);
            }
            case 32: {
                return new WaitStep(32, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, null, Player.__$successTest0_rfield, Player.__$successTestSensorFactory0_rfield, null);
            }
            case 33: {
                return new MentalStep(33, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, Player.__$mentalExecute0_rfield, null, null, null);
            }
            case 34: {
                return new GoalStep(34, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, Player.__$argumentExecute0_rfield, null, null, null, "csPlayerPhysicallyFavors_CleanupDemon(PhysicallyFavorWME)", null, (short)1);
            }
            case 35: {
                return new GoalStep(35, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, Player.__$argumentExecute0_rfield, null, null, null, "csPlayerPhysicallyFavors_LookAt_Wait(int)", null, (short)0);
            }
            case 36: {
                return new MentalStep(36, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, Player.__$mentalExecute0_rfield, null, null, null);
            }
            case 37: {
                return new GoalStep(37, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, Player.__$argumentExecute0_rfield, null, null, null, "csPlayerPhysicallyFavors_CleanupDemon(PhysicallyFavorWME)", null, (short)1);
            }
            case 38: {
                return new GoalStep(38, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, Player.__$argumentExecute0_rfield, null, null, null, "WaitFor(int)", null, (short)0);
            }
            case 39: {
                return new WaitStep(39, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, null, Player.__$successTest0_rfield, null, null);
            }
            case 40: {
                return new WaitStep(40, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, null, Player.__$successTest0_rfield, null, null);
            }
            case 41: {
                return new MentalStep(41, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, Player.__$mentalExecute0_rfield, null, null, null);
            }
            case 42: {
                return new GoalStep(42, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, Player.__$argumentExecute0_rfield, null, null, null, "WaitFor(int)", null, (short)0);
            }
            case 43: {
                return new GoalStep(43, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, Player.__$argumentExecute0_rfield, null, null, null, "WaitFor(int)", null, (short)0);
            }
            case 44: {
                return new MentalStep(44, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, Player.__$mentalExecute0_rfield, null, null, null);
            }
            case 45: {
                return new WaitStep(45, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, null, Player.__$successTest0_rfield, null, null);
            }
            case 46: {
                return new GoalStep(46, behavior, false, false, false, false, false, false, (short)60, (short)0, false, null, Player.__$argumentExecute0_rfield, null, null, null, "WaitFor(int)", null, (short)0);
            }
            case 47: {
                return new MentalStep(47, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, Player.__$mentalExecute0_rfield, null, null, null);
            }
            case 48: {
                return new MentalStep(48, behavior, false, false, false, false, false, false, (short)(-32768), (short)1, false, null, Player.__$mentalExecute0_rfield, null, null, null);
            }
            case 49: {
                return new GoalStep(49, behavior, true, false, false, false, false, false, (short)(-32768), (short)0, false, null, Player.__$argumentExecute0_rfield, null, null, null, "csNBeatsSameAffinity_CountBeats(int, int)", null, (short)0);
            }
            case 50: {
                return new GoalStep(50, behavior, true, false, false, false, false, false, (short)(-32768), (short)0, false, null, Player.__$argumentExecute0_rfield, null, null, null, "csNBeatsSameAffinity_Trigger(int, int)", null, (short)0);
            }
            case 51: {
                return new MentalStep(51, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, Player.__$mentalExecute0_rfield, null, null, null);
            }
            case 52: {
                return new WaitStep(52, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, null, Player.__$successTest0_rfield, null, null);
            }
            case 53: {
                return new MentalStep(53, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, Player.__$mentalExecute0_rfield, null, null, null);
            }
            case 54: {
                return new WaitStep(54, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, null, Player.__$successTest0_rfield, null, null);
            }
            case 55: {
                return new MentalStep(55, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, Player.__$mentalExecute0_rfield, null, null, null);
            }
            case 56: {
                return new GoalStep(56, behavior, false, false, false, true, false, false, (short)(-32768), (short)0, false, null, Player.__$argumentExecute0_rfield, null, null, null, "DeleteSameAffinityNBeatsWME(int, int)", null, (short)0);
            }
            case 57: {
                return new WaitStep(57, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, null, Player.__$successTest0_rfield, null, null);
            }
            case 58: {
                return new MentalStep(58, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, Player.__$mentalExecute0_rfield, null, null, null);
            }
            case 59: {
                return new WaitStep(59, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, null, Player.__$successTest0_rfield, null, null);
            }
            case 60: {
                return new MentalStep(60, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, Player.__$mentalExecute0_rfield, null, null, null);
            }
            case 61: {
                return new WaitStep(61, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, null, Player.__$successTest0_rfield, null, null);
            }
            case 62: {
                return new MentalStep(62, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, Player.__$mentalExecute0_rfield, null, null, null);
            }
            case 63: {
                return new MentalStep(63, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, Player.__$mentalExecute0_rfield, null, null, null);
            }
            case 64: {
                return new MentalStep(64, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, Player.__$mentalExecute0_rfield, null, null, null);
            }
            case 65: {
                return new GoalStep(65, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, Player.__$argumentExecute0_rfield, null, null, null, "csOneCharacterVisible_NoOneCharacterVisibleWME(boolean, boolean)", null, (short)0);
            }
            case 66: {
                return new WaitStep(66, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, null, Player.__$successTest0_rfield, Player.__$successTestSensorFactory0_rfield, null);
            }
            case 67: {
                return new MentalStep(67, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, Player.__$mentalExecute0_rfield, null, null, null);
            }
            case 68: {
                return new WaitStep(68, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, null, Player.__$successTest0_rfield, Player.__$successTestSensorFactory0_rfield, null);
            }
            case 69: {
                return new MentalStep(69, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, Player.__$mentalExecute0_rfield, null, null, null);
            }
            case 70: {
                return new MentalStep(70, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, Player.__$mentalExecute0_rfield, null, null, null);
            }
            case 71: {
                return new GoalStep(71, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, null, null, null, null, "csPlayerUncoop_Body()", null, (short)0);
            }
            case 72: {
                return new GoalStep(72, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, Player.__$argumentExecute0_rfield, null, null, null, "WaitFor(int)", null, (short)0);
            }
            case 73: {
                return new MentalStep(73, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, Player.__$mentalExecute0_rfield, null, null, null);
            }
            case 74: {
                return new MentalStep(74, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, Player.__$mentalExecute0_rfield, null, null, null);
            }
            case 75: {
                return new WaitStep(75, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, null, Player.__$successTest0_rfield, null, null);
            }
            case 76: {
                return new MentalStep(76, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, Player.__$mentalExecute0_rfield, null, null, null);
            }
            case 77: {
                return new GoalStep(77, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, Player.__$argumentExecute0_rfield, null, null, null, "WaitFor(float)", null, (short)0);
            }
            case 78: {
                return new MentalStep(78, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, Player.__$mentalExecute0_rfield, null, null, null);
            }
            case 79: {
                return new GoalStep(79, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, null, null, null, null, "InitCSensors()", null, (short)0);
            }
            case 80: {
                return new MentalStep(80, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, Player.__$mentalExecute0_rfield, null, null, null);
            }
            case 81: {
                return new GoalStep(81, behavior, true, false, false, true, false, false, (short)(-32768), (short)0, false, null, null, null, null, null, "OverallControl_Body()", null, (short)0);
            }
            case 82: {
                return new GoalStep(82, behavior, true, false, false, false, false, false, (short)(-1), (short)0, false, null, null, null, null, null, "CSensorsLowLevel()", null, (short)0);
            }
            case 83: {
                return new GoalStep(83, behavior, true, false, false, false, false, false, (short)30, (short)0, false, null, null, null, null, null, "csPlayerSettled()", null, (short)0);
            }
            case 84: {
                return new GoalStep(84, behavior, true, false, false, false, false, false, (short)30, (short)0, false, null, null, null, null, null, "csPlayerUncoop()", null, (short)0);
            }
            case 85: {
                return new GoalStep(85, behavior, true, false, false, false, false, false, (short)30, (short)0, false, null, null, null, null, null, "csOneCharacterVisible()", null, (short)0);
            }
            case 86: {
                return new GoalStep(86, behavior, false, false, false, false, false, false, (short)50, (short)0, false, null, null, null, null, null, "InitPhysicallyFavors()", null, (short)0);
            }
            case 87: {
                return new GoalStep(87, behavior, true, false, false, false, false, false, (short)25, (short)0, false, null, null, null, null, null, "csPlayerPhysicallyFavors_LookAt_PostWMEsDemon()", null, (short)0);
            }
            case 88: {
                return new GoalStep(88, behavior, false, false, false, false, false, false, (short)25, (short)0, false, null, Player.__$argumentExecute0_rfield, null, null, null, "csNBeatsSameAffinity(int, int)", null, (short)0);
            }
            case 89: {
                return new MentalStep(89, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, Player.__$mentalExecute0_rfield, null, null, null);
            }
            case 90: {
                return new GoalStep(90, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, Player.__$argumentExecute0_rfield, null, null, null, "InitPhysicallyFavors_Body(CollectionBehaviorWME, List)", null, (short)0);
            }
            case 91: {
                return new MentalStep(91, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, Player.__$mentalExecute0_rfield, null, null, null);
            }
            case 92: {
                final AblNamedPropertySupport ablNamedPropertySupport4 = new AblNamedPropertySupport();
                ablNamedPropertySupport4.setProperty("physicallyFavorsID", new Integer(((__ValueTypes.IntVar)array[3]).i));
                return new GoalStep(92, behavior, false, false, false, false, false, false, (short)30, (short)0, false, null, Player.__$argumentExecute0_rfield, null, null, ablNamedPropertySupport4, "csPlayerPhysicallyFavors(int, boolean, boolean, float)", null, (short)2);
            }
            case 93: {
                return new GoalStep(93, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, Player.__$argumentExecute0_rfield, null, null, null, "InitPhysicallyFavors_Body(CollectionBehaviorWME, List)", null, (short)0);
            }
            case 94: {
                return new GoalStep(94, behavior, false, false, false, false, false, false, (short)(-32768), (short)0, false, null, null, null, null, null, "OverallControl()", null, (short)0);
            }
            default: {
                throw new AblRuntimeError("Unexpected stepID " + n);
            }
        }
    }
}
