package facade.characters.player.java;

import abl.runtime.AblRuntimeError;
import facade.sensor.ObjectPositionSensor;
import facade.sensor.ObjectRotationSensor;
import abl.runtime.Sensor;
import facade.sensor.HeldObjectsSensor;
import abl.runtime.SensorActivation;
import dramaman.runtime.DramaManagerConstants;
import facade.util.SpriteID;
import facade.util.BeatConstants;

public class Player_ContextConditionSensorFactories implements BeatConstants, SpriteID, DramaManagerConstants
{
    public static SensorActivation[] contextConditionSensorFactory0(final int n) {
        switch (n) {
            case 21: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null), new SensorActivation(new ObjectRotationSensor(), null), new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 22: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 23: {
                return new SensorActivation[] { new SensorActivation(new ObjectRotationSensor(), null), new SensorActivation(new ObjectPositionSensor(), null) };
            }
            default: {
                throw new AblRuntimeError("Unexpected behaviorID " + n);
            }
        }
    }
}
