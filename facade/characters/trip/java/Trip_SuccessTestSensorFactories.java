package facade.characters.trip.java;

import abl.runtime.AblRuntimeError;
import facade.sensor.HeldObjectsSensor;
import facade.sensor.TripAnimationCueSensor;
import facade.sensor.ObjectRotationSensor;
import facade.sensor.ObjectPositionSensor;
import facade.sensor.PlayerGestureSensor;
import abl.runtime.Sensor;
import facade.sensor.TripObjectActivationSensor;
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

public class Trip_SuccessTestSensorFactories implements GraceScript, TripScript, AnimLayer, FullExpressions, SpriteID, PoseScripts, GestureBodyPart, BodyResource, BeatStatus, BeatConstants, ReactionID, ReactionConstants, DAType, UniversalScript, DramaManagerConstants, PlayerGestureID, BeatArguments, BeatID, EpisodicMemoryConstants, BackstoryCategories, CrisisAccusations, TherapyGameConstants, MusicDefs
{
    public static SensorActivation[] successTestSensorFactory0(final int n) {
        switch (n) {
            case 130: {
                return new SensorActivation[] { new SensorActivation(new TripObjectActivationSensor(), null) };
            }
            case 242: {
                return new SensorActivation[] { new SensorActivation(new PlayerGestureSensor(), null) };
            }
            case 280: {
                return new SensorActivation[] { new SensorActivation(new PlayerGestureSensor(), null) };
            }
            case 282: {
                return new SensorActivation[] { new SensorActivation(new TripObjectActivationSensor(), null) };
            }
            case 365: {
                return new SensorActivation[] { new SensorActivation(new TripObjectActivationSensor(), null) };
            }
            case 425: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 609: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 628: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 1177: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 1179: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 1483: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 1485: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 2933: {
                return new SensorActivation[] { new SensorActivation(new TripObjectActivationSensor(), null) };
            }
            case 2946: {
                return new SensorActivation[] { new SensorActivation(new TripObjectActivationSensor(), null) };
            }
            case 3344: {
                return new SensorActivation[] { new SensorActivation(new TripObjectActivationSensor(), null) };
            }
            case 3357: {
                return new SensorActivation[] { new SensorActivation(new TripObjectActivationSensor(), null) };
            }
            case 15473: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 17582: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 17586: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 17601: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 20581: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 20585: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 20620: {
                return new SensorActivation[] { new SensorActivation(new ObjectRotationSensor(), null) };
            }
            case 20622: {
                return new SensorActivation[] { new SensorActivation(new ObjectRotationSensor(), null) };
            }
            case 20967: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 20971: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 21045: {
                return new SensorActivation[] { new SensorActivation(new ObjectRotationSensor(), null) };
            }
            case 21047: {
                return new SensorActivation[] { new SensorActivation(new ObjectRotationSensor(), null) };
            }
            case 21449: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 21453: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 21658: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 21662: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 21862: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 21866: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 26614: {
                return new SensorActivation[] { new SensorActivation(new ObjectRotationSensor(), null), new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 31825: {
                return new SensorActivation[] { new SensorActivation(new TripAnimationCueSensor(), null) };
            }
            case 31829: {
                return new SensorActivation[] { new SensorActivation(new TripAnimationCueSensor(), null) };
            }
            case 31834: {
                return new SensorActivation[] { new SensorActivation(new TripAnimationCueSensor(), null) };
            }
            case 31839: {
                return new SensorActivation[] { new SensorActivation(new TripAnimationCueSensor(), null) };
            }
            case 31850: {
                return new SensorActivation[] { new SensorActivation(new TripAnimationCueSensor(), null) };
            }
            case 31861: {
                return new SensorActivation[] { new SensorActivation(new TripAnimationCueSensor(), null) };
            }
            case 31862: {
                return new SensorActivation[] { new SensorActivation(new TripAnimationCueSensor(), null) };
            }
            case 32009: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 32033: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 32077: {
                return new SensorActivation[] { new SensorActivation(new ObjectRotationSensor(), null), new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 32095: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 32195: {
                return new SensorActivation[] { new SensorActivation(new ObjectRotationSensor(), null) };
            }
            default: {
                throw new AblRuntimeError("Unexpected stepID " + n);
            }
        }
    }
}
