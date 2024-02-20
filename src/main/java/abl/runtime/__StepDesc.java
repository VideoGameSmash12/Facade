package abl.runtime;

import java.lang.reflect.Method;

public class __StepDesc
{
    final int stepID;
    final Method factory;
    
    public __StepDesc(final int stepID, final Method factory) {
        this.stepID = stepID;
        this.factory = factory;
    }
}
