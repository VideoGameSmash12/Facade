package abl.runtime;

import java.util.EventObject;

public class AblEvent extends EventObject
{
    public static final int PRECONDITION_EXECUTION = 1;
    public static final int BEHAVIOR_EXECUTION = 2;
    public static final int BEHAVIOR_COMPLETION = 3;
    public static final int CONTEXT_CONDITION_FAILURE = 4;
    public static final int ACT_EXECUTION = 5;
    public static final int ACT_COMPLETION = 6;
    public static final int SUBGOAL_EXECUTION = 7;
    public static final int SUBGOAL_COMPLETION = 8;
    public static final int MENTAL_STEP_EXECUTION = 9;
    public static final int MENTAL_STEP_COMPLETION = 10;
    public static final int WAIT_STEP_COMPLETION = 11;
    public static final int FAILSTEP_EXECUTION = 12;
    public static final int FAILSTEP_COMPLETION = 13;
    public static final int SUCCEEDSTEP_EXECUTION = 14;
    public static final int SUCCEEDSTEP_COMPLETION = 15;
    public static final int STEP_SUSPENSION = 16;
    public static final int STEP_UNSUSPENSION = 17;
    public static final int SUCCESS_TEST_SUCCESS = 18;
    public static final int SPAWNGOAL_AT_ROOT = 19;
    public static final int INITIATE_NEGOTIATION = 20;
    public static final int COMPLETE_NEGOTIATION = 21;
    public static final int INITIATE_INTENTION = 22;
    public static final int COMMIT_TO_INTENTION = 23;
    public static final int PROCESS_INTENTION = 24;
    public static final int BEHAVIOR = 1;
    public static final int STEP = 2;
    public static final int NEGOTIATOR = 3;
    protected Object obj;
    protected int type;
    protected int nestLevel;
    protected long elapsedTime;
    
    public int getType() {
        return this.type;
    }
    
    public int getSourceType() {
        if (this.type == 1 || this.type == 2 || this.type == 3 || this.type == 4) {
            return 1;
        }
        if (this.type == 20 || this.type == 21 || this.type == 22 || this.type == 23 || this.type == 24) {
            return 3;
        }
        return 2;
    }
    
    public Object getObject() {
        return this.obj;
    }
    
    public int getNestLevel() {
        return this.nestLevel;
    }
    
    public long getElapsedTime() {
        return this.elapsedTime;
    }
    
    void setElapsedTime(final long elapsedTime) {
        this.elapsedTime = elapsedTime;
    }
    
    public String toString() {
        return "[AblEvent: type =" + this.type + ']';
    }
    
    private final /* synthetic */ void this() {
        this.nestLevel = 0;
        this.elapsedTime = -1;
    }
    
    public AblEvent(final Object o, final int type, final Object obj) {
        super(o);
        this.this();
        this.type = type;
        this.obj = obj;
    }
    
    public AblEvent(final Object o, final int type, final Object obj, final int nestLevel) {
        super(o);
        this.this();
        this.type = type;
        this.obj = obj;
        this.nestLevel = nestLevel;
    }
}
