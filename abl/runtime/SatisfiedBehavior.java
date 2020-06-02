package abl.runtime;

import java.util.Hashtable;

class SatisfiedBehavior
{
    __BehaviorDesc behDesc;
    Hashtable preconditionBoundVariables;
    
    public SatisfiedBehavior(final __BehaviorDesc behDesc, final Hashtable preconditionBoundVariables) {
        this.behDesc = behDesc;
        this.preconditionBoundVariables = preconditionBoundVariables;
    }
}
