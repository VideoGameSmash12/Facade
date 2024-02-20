package abl.runtime;

import java.lang.reflect.Method;

public class __BehaviorDesc
{
    final int behaviorID;
    final Method factory;
    final Method precondition;
    final Method preconditionSensorFactory;
    final String signature;
    String uniqueName;
    final String[] teamMembers;
    final short specificity;
    
    public __BehaviorDesc(final int behaviorID, final Method factory, final Method precondition, final Method preconditionSensorFactory, final String signature, final String[] teamMembers, final short specificity) {
        this.behaviorID = behaviorID;
        this.factory = factory;
        this.precondition = precondition;
        this.preconditionSensorFactory = preconditionSensorFactory;
        this.signature = signature;
        this.uniqueName = null;
        this.teamMembers = teamMembers;
        this.specificity = specificity;
    }
}
