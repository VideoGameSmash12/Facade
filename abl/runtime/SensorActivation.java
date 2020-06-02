package abl.runtime;

import java.util.Arrays;

public class SensorActivation
{
    public Sensor activeSensor;
    public Object[] arguments;
    public int referenceCount;
    
    public boolean equals(final Object o) {
        final SensorActivation sensorActivation = (SensorActivation)o;
        return sensorActivation.activeSensor.getClass() == this.activeSensor.getClass() && Arrays.equals(sensorActivation.arguments, this.arguments);
    }
    
    public SensorActivation(final Sensor activeSensor, final Object[] arguments) {
        this.activeSensor = activeSensor;
        this.arguments = arguments;
        this.referenceCount = 1;
    }
}
