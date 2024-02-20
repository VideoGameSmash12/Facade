package facade.characters.player.java;

import abl.runtime.AblRuntimeError;
import facade.sensor.ObjectPositionSensor;
import facade.sensor.ObjectRotationSensor;
import facade.sensor.HeldObjectsSensor;
import facade.sensor.PlayerRotationSensor;
import abl.runtime.Sensor;
import facade.sensor.PlayerPositionSensor;
import abl.runtime.SensorActivation;
import dramaman.runtime.DramaManagerConstants;
import facade.util.SpriteID;
import facade.util.BeatConstants;

public class Player_PreconditionSensorFactories implements BeatConstants, SpriteID, DramaManagerConstants
{
    public static SensorActivation[] preconditionSensorFactory0(final int n) {
        switch (n) {
            case 9: {
                return new SensorActivation[] { new SensorActivation(new PlayerPositionSensor(), null), new SensorActivation(new PlayerRotationSensor(), null) };
            }
            case 21: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null), new SensorActivation(new ObjectRotationSensor(), null), new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 22: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 25: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 35: {
                return new SensorActivation[] { new SensorActivation(new ObjectRotationSensor(), null), new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 40: {
                return new SensorActivation[] { new SensorActivation(new ObjectRotationSensor(), null), new SensorActivation(new ObjectPositionSensor(), null) };
            }
            default: {
                throw new AblRuntimeError("Unexpected behaviorID " + n);
            }
        }
    }
}
