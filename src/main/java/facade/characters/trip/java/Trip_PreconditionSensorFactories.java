package facade.characters.trip.java;

import abl.runtime.AblRuntimeError;
import facade.sensor.ObjectStateSensor;
import facade.sensor.TripArmBaseSensor;
import facade.sensor.TripObjectPickupRotationSensor;
import facade.sensor.TripObjectPickupPositionSensor;
import facade.sensor.HeldObjectsSensor;
import facade.sensor.ObjectRotationSensor;
import abl.runtime.Sensor;
import facade.sensor.ObjectPositionSensor;
import abl.runtime.SensorActivation;
import facade.util.MusicDefs;
import facade.util.TherapyGameConstants;
import facade.util.CrisisAccusations;
import facade.util.BackstoryCategories;
import facade.util.EpisodicMemoryConstants;
import facade.util.BeatID;
import facade.util.BeatArguments;
import facade.util.PlayerGestureID;
import dramaman.runtime.DramaManagerConstants;
import facade.util.UniversalScript;
import facade.util.DAType;
import facade.util.ReactionConstants;
import facade.util.ReactionID;
import facade.util.BeatConstants;
import facade.util.BeatStatus;
import facade.util.BodyResource;
import facade.util.GestureBodyPart;
import facade.util.PoseScripts;
import facade.util.SpriteID;
import facade.util.FullExpressions;
import facade.util.AnimLayer;
import facade.util.TripScript;
import facade.util.GraceScript;

public class Trip_PreconditionSensorFactories implements GraceScript, TripScript, AnimLayer, FullExpressions, SpriteID, PoseScripts, GestureBodyPart, BodyResource, BeatStatus, BeatConstants, ReactionID, ReactionConstants, DAType, UniversalScript, DramaManagerConstants, PlayerGestureID, BeatArguments, BeatID, EpisodicMemoryConstants, BackstoryCategories, CrisisAccusations, TherapyGameConstants, MusicDefs
{
    public static SensorActivation[] preconditionSensorFactory0(final int n) {
        switch (n) {
            case 196: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 317: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 318: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 319: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 372: {
                return new SensorActivation[] { new SensorActivation(new ObjectRotationSensor(), null), new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 402: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 514: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 515: {
                return new SensorActivation[] { new SensorActivation(new ObjectRotationSensor(), null) };
            }
            case 516: {
                return new SensorActivation[] { new SensorActivation(new ObjectRotationSensor(), null) };
            }
            case 793: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 798: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 829: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 849: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 852: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 853: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 854: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 855: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 856: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 1511: {
                return new SensorActivation[] { new SensorActivation(new ObjectRotationSensor(), null), new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 1533: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 1577: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 1578: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 1603: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 1615: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 1616: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 1617: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 1618: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 1682: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 1727: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 1752: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 1766: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 1824: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 1868: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 1869: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 1896: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 1906: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 1907: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 1908: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 1909: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 3010: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 3074: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 3113: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 3135: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 3196: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 3394: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 3398: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 3401: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 3406: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 4041: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 4042: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 4043: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 4044: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 4045: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 4046: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 4338: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 4339: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 4443: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 4466: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 4943: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 5310: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 5312: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 5313: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 5314: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 5315: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 5806: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 5807: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 5819: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 5820: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 6955: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 6962: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 6977: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 7040: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 7041: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 7048: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 7049: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 7178: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 7179: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 8394: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 8561: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 8567: {
                return new SensorActivation[] { new SensorActivation(new ObjectRotationSensor(), null), new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 8571: {
                return new SensorActivation[] { new SensorActivation(new ObjectRotationSensor(), null), new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 8572: {
                return new SensorActivation[] { new SensorActivation(new ObjectRotationSensor(), null), new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 8574: {
                return new SensorActivation[] { new SensorActivation(new ObjectRotationSensor(), null), new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 8576: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 8577: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 8578: {
                return new SensorActivation[] { new SensorActivation(new TripObjectPickupPositionSensor(), null), new SensorActivation(new TripObjectPickupRotationSensor(), null) };
            }
            case 8581: {
                return new SensorActivation[] { new SensorActivation(new TripObjectPickupPositionSensor(), null) };
            }
            case 8582: {
                return new SensorActivation[] { new SensorActivation(new TripObjectPickupRotationSensor(), null) };
            }
            case 8585: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 8586: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 8587: {
                return new SensorActivation[] { new SensorActivation(new TripObjectPickupPositionSensor(), null), new SensorActivation(new TripObjectPickupRotationSensor(), null) };
            }
            case 8588: {
                return new SensorActivation[] { new SensorActivation(new TripObjectPickupPositionSensor(), null) };
            }
            case 8589: {
                return new SensorActivation[] { new SensorActivation(new TripObjectPickupRotationSensor(), null) };
            }
            case 8591: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 8592: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 8594: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 8598: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 8601: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 8602: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 8607: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 8617: {
                return new SensorActivation[] { new SensorActivation(new ObjectRotationSensor(), null), new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 8626: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 8627: {
                return new SensorActivation[] { new SensorActivation(new ObjectRotationSensor(), null), new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 8628: {
                return new SensorActivation[] { new SensorActivation(new ObjectRotationSensor(), null), new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 8632: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 8644: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 8670: {
                return new SensorActivation[] { new SensorActivation(new TripArmBaseSensor(), null) };
            }
            case 8671: {
                return new SensorActivation[] { new SensorActivation(new TripArmBaseSensor(), null) };
            }
            case 8716: {
                return new SensorActivation[] { new SensorActivation(new TripArmBaseSensor(), null) };
            }
            case 8717: {
                return new SensorActivation[] { new SensorActivation(new TripArmBaseSensor(), null) };
            }
            case 8766: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 8767: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 8779: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 8780: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 8788: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 8811: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 8837: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 8838: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 8839: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 8842: {
                return new SensorActivation[] { new SensorActivation(new ObjectRotationSensor(), null), new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 8862: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 8871: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 8874: {
                return new SensorActivation[] { new SensorActivation(new ObjectRotationSensor(), null), new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 8879: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 8913: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 8917: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 8918: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null), new SensorActivation(new ObjectRotationSensor(), null), new SensorActivation(new ObjectPositionSensor(), null), new SensorActivation(new ObjectStateSensor(), null) };
            }
            case 8922: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null), new SensorActivation(new ObjectStateSensor(), null) };
            }
            case 8930: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null), new SensorActivation(new ObjectStateSensor(), null) };
            }
            case 8933: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 8934: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 8935: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 9001: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 9006: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 9048: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 9129: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 9135: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 9141: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            default: {
                throw new AblRuntimeError("Unexpected behaviorID " + n);
            }
        }
    }
}
