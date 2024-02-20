package facade.characters.player.java;

import abl.runtime.AblRuntimeError;
import abl.runtime.GoalStep;
import java.util.Hashtable;
import abl.runtime.CollectionBehavior;
import abl.runtime.__BehaviorDesc;
import java.lang.reflect.Method;
import dramaman.runtime.DramaManagerConstants;
import facade.util.SpriteID;
import facade.util.BeatConstants;
import abl.runtime.BehavingEntity;

public class Player extends BehavingEntity implements BeatConstants, SpriteID, DramaManagerConstants
{
    private static final Object[] __$tempObjArray;
    private static final Class[] __$sensorFactoryArgArray;
    private static final Class[] __$behFactoryArgArray;
    private static final Class[] __$preconditionArgArray;
    private static final Class[] __$continuousConditionArgArray;
    private static final Class[] __$stepFactoryArgArray;
    private static final Class[] __$argumentStepExecuteArgArray;
    private static final Class[] __$mentalStepExecuteArgArray;
    private static final Class __$Player_BehaviorFactories_rfield;
    static final Method __$behaviorFactory0_rfield;
    private static final Class __$Player_Preconditions_rfield;
    static final Method __$precondition0_rfield;
    private static final Class __$Player_PreconditionSensorFactories_rfield;
    static final Method __$preconditionSensorFactory0_rfield;
    private static final Class __$Player_ContextConditions_rfield;
    static final Method __$contextCondition0_rfield;
    private static final Class __$Player_ContextConditionSensorFactories_rfield;
    static final Method __$contextConditionSensorFactory0_rfield;
    private static final Class __$Player_StepFactories_rfield;
    static final Method __$stepFactory0_rfield;
    private static final Class __$Player_ArgumentStepExecute_rfield;
    static final Method __$argumentExecute0_rfield;
    private static final Class __$Player_MentalStepExecute_rfield;
    static final Method __$mentalExecute0_rfield;
    private static final Class __$Player_SuccessTests_rfield;
    static final Method __$successTest0_rfield;
    private static final Class __$Player_SuccessTestSensorFactories_rfield;
    static final Method __$successTestSensorFactory0_rfield;
    long g_previousPhysicallyFavoredTime;
    long g_physicallyFavorLatencyInMS;
    int g_physicallyFavorObjectLatency;
    float g_physicallyFavorLookDistance_Medium;
    float g_physicallyFavorLookDistance_Long;
    int g_physicallyFavorLookTime;
    
    private static final void registerBehaviors_0(final BehaviorLibrary behaviorLibrary) {
        behaviorLibrary.registerBehavior(new __BehaviorDesc(0, Player.__$behaviorFactory0_rfield, Player.__$precondition0_rfield, null, "csIsPlayerTranslating()", null, (short)0));
        behaviorLibrary.registerBehavior(new __BehaviorDesc(1, Player.__$behaviorFactory0_rfield, Player.__$precondition0_rfield, null, "csIsPlayerTranslating()", null, (short)0));
        behaviorLibrary.registerBehavior(new __BehaviorDesc(2, Player.__$behaviorFactory0_rfield, Player.__$precondition0_rfield, null, "csIsPlayerTranslating()", null, (short)0));
        behaviorLibrary.registerBehavior(new __BehaviorDesc(3, Player.__$behaviorFactory0_rfield, Player.__$precondition0_rfield, null, "csIsPlayerRotating()", null, (short)0));
        behaviorLibrary.registerBehavior(new __BehaviorDesc(4, Player.__$behaviorFactory0_rfield, Player.__$precondition0_rfield, null, "csIsPlayerRotating()", null, (short)0));
        behaviorLibrary.registerBehavior(new __BehaviorDesc(5, Player.__$behaviorFactory0_rfield, Player.__$precondition0_rfield, null, "csIsPlayerRotating()", null, (short)0));
        behaviorLibrary.registerBehavior(new __BehaviorDesc(6, Player.__$behaviorFactory0_rfield, null, null, "csPlayerSettled()", null, (short)0));
        behaviorLibrary.registerBehavior(new __BehaviorDesc(7, Player.__$behaviorFactory0_rfield, Player.__$precondition0_rfield, null, "csPlayerSettled_Part2()", null, (short)0));
        behaviorLibrary.registerBehavior(new __BehaviorDesc(8, Player.__$behaviorFactory0_rfield, null, null, "InitCSensors()", null, (short)0));
        behaviorLibrary.registerBehavior(new __BehaviorDesc(9, Player.__$behaviorFactory0_rfield, Player.__$precondition0_rfield, Player.__$preconditionSensorFactory0_rfield, "CSensorsLowLevel()", null, (short)0));
        behaviorLibrary.registerBehavior(new __BehaviorDesc(10, Player.__$behaviorFactory0_rfield, Player.__$precondition0_rfield, null, "csPlayerPhysicallyFavors(int, boolean, boolean, float)", null, (short)0));
        behaviorLibrary.registerBehavior(new __BehaviorDesc(11, Player.__$behaviorFactory0_rfield, Player.__$precondition0_rfield, null, "csPlayerPhysicallyFavors(int, boolean, boolean, float)", null, (short)0));
        behaviorLibrary.registerBehavior(new __BehaviorDesc(12, Player.__$behaviorFactory0_rfield, Player.__$precondition0_rfield, null, "csPlayerPhysicallyFavors(int, boolean, boolean, float)", null, (short)0));
        behaviorLibrary.registerBehavior(new __BehaviorDesc(13, Player.__$behaviorFactory0_rfield, Player.__$precondition0_rfield, null, "csPlayerPhysicallyFavors(int, boolean, boolean, float)", null, (short)0));
        behaviorLibrary.registerBehavior(new __BehaviorDesc(15, Player.__$behaviorFactory0_rfield, Player.__$precondition0_rfield, null, "TurnOffPhysicallyFavorsWithTimeout_KillSensor(int)", null, (short)0));
        behaviorLibrary.registerBehavior(new __BehaviorDesc(16, Player.__$behaviorFactory0_rfield, null, null, "TurnPhysicallyFavorsBackOnAfterTimeout_Demon(int, int)", null, (short)0));
        behaviorLibrary.registerBehavior(new __BehaviorDesc(17, Player.__$behaviorFactory0_rfield, Player.__$precondition0_rfield, null, "TurnPhysicallyFavorsBackOnAfterTimeout_Demon_Body(int)", null, (short)0));
        behaviorLibrary.registerBehavior(new __BehaviorDesc(19, Player.__$behaviorFactory0_rfield, Player.__$precondition0_rfield, null, "PhysicallyFavorsCSensor_KillTimeoutDemon(int)", null, (short)0));
        behaviorLibrary.registerBehavior(new __BehaviorDesc(20, Player.__$behaviorFactory0_rfield, null, null, "csPlayerPhysicallyFavors_ObjectActivation(int)", null, (short)0));
        behaviorLibrary.registerBehavior(new __BehaviorDesc(21, Player.__$behaviorFactory0_rfield, Player.__$precondition0_rfield, Player.__$preconditionSensorFactory0_rfield, "csPlayerPhysicallyFavors_LookAt(int, float)", null, (short)3));
        behaviorLibrary.registerBehavior(new __BehaviorDesc(22, Player.__$behaviorFactory0_rfield, Player.__$precondition0_rfield, Player.__$preconditionSensorFactory0_rfield, "csPlayerPhysicallyFavors_LookAt(int, float)", null, (short)2));
        behaviorLibrary.registerBehavior(new __BehaviorDesc(23, Player.__$behaviorFactory0_rfield, null, null, "csPlayerPhysicallyFavors_LookAt(int, float)", null, (short)1));
        behaviorLibrary.registerBehavior(new __BehaviorDesc(24, Player.__$behaviorFactory0_rfield, null, null, "csPlayerPhysicallyFavors_LookAt_Wait(int)", null, (short)0));
        behaviorLibrary.registerBehavior(new __BehaviorDesc(25, Player.__$behaviorFactory0_rfield, Player.__$precondition0_rfield, Player.__$preconditionSensorFactory0_rfield, "printDistanceToObject(int)", null, (short)0));
        behaviorLibrary.registerBehavior(new __BehaviorDesc(26, Player.__$behaviorFactory0_rfield, null, null, "csPlayerPhysicallyFavors_CleanupDemon(PhysicallyFavorWME)", null, (short)0));
        behaviorLibrary.registerBehavior(new __BehaviorDesc(27, Player.__$behaviorFactory0_rfield, null, null, "csPlayerPhysicallyFavors_LookAt_PostWMEsDemon()", null, (short)0));
        behaviorLibrary.registerBehavior(new __BehaviorDesc(28, Player.__$behaviorFactory0_rfield, null, null, "csNBeatsSameAffinity(int, int)", null, (short)0));
        behaviorLibrary.registerBehavior(new __BehaviorDesc(29, Player.__$behaviorFactory0_rfield, Player.__$precondition0_rfield, null, "csNBeatsSameAffinity_CountBeats(int, int)", null, (short)2));
        behaviorLibrary.registerBehavior(new __BehaviorDesc(30, Player.__$behaviorFactory0_rfield, Player.__$precondition0_rfield, null, "csNBeatsSameAffinity_CountBeats(int, int)", null, (short)1));
        behaviorLibrary.registerBehavior(new __BehaviorDesc(31, Player.__$behaviorFactory0_rfield, Player.__$precondition0_rfield, null, "DeleteSameAffinityNBeatsWME(int, int)", null, (short)0));
        behaviorLibrary.registerBehavior(new __BehaviorDesc(32, Player.__$behaviorFactory0_rfield, null, null, "csNBeatsSameAffinity_Trigger(int, int)", null, (short)0));
        behaviorLibrary.registerBehavior(new __BehaviorDesc(35, Player.__$behaviorFactory0_rfield, Player.__$precondition0_rfield, Player.__$preconditionSensorFactory0_rfield, "csOneCharacterVisible()", null, (short)0));
        behaviorLibrary.registerBehavior(new __BehaviorDesc(36, Player.__$behaviorFactory0_rfield, Player.__$precondition0_rfield, null, "csOneCharacterVisible()", null, (short)0));
        behaviorLibrary.registerBehavior(new __BehaviorDesc(37, Player.__$behaviorFactory0_rfield, Player.__$precondition0_rfield, null, "csOneCharacterVisible_NoOneCharacterVisibleWME(boolean, boolean)", null, (short)0));
        behaviorLibrary.registerBehavior(new __BehaviorDesc(38, Player.__$behaviorFactory0_rfield, Player.__$precondition0_rfield, null, "csOneCharacterVisible_NoOneCharacterVisibleWME(boolean, boolean)", null, (short)0));
        behaviorLibrary.registerBehavior(new __BehaviorDesc(39, Player.__$behaviorFactory0_rfield, null, null, "csPlayerUncoop()", null, (short)0));
        behaviorLibrary.registerBehavior(new __BehaviorDesc(40, Player.__$behaviorFactory0_rfield, Player.__$precondition0_rfield, Player.__$preconditionSensorFactory0_rfield, "csPlayerUncoop_Body()", null, (short)0));
        behaviorLibrary.registerBehavior(new __BehaviorDesc(41, Player.__$behaviorFactory0_rfield, null, null, "WaitFor(float)", null, (short)0));
        behaviorLibrary.registerBehavior(new __BehaviorDesc(42, Player.__$behaviorFactory0_rfield, null, null, "WaitFor(int)", null, (short)0));
        behaviorLibrary.registerBehavior(new __BehaviorDesc(43, Player.__$behaviorFactory0_rfield, null, null, "OverallControl()", null, (short)0));
        behaviorLibrary.registerBehavior(new __BehaviorDesc(44, Player.__$behaviorFactory0_rfield, null, null, "OverallControl_Body()", null, (short)0));
        behaviorLibrary.registerBehavior(new __BehaviorDesc(45, Player.__$behaviorFactory0_rfield, Player.__$precondition0_rfield, null, "InitPhysicallyFavors()", null, (short)0));
        behaviorLibrary.registerBehavior(new __BehaviorDesc(46, Player.__$behaviorFactory0_rfield, Player.__$precondition0_rfield, null, "InitPhysicallyFavors_Body(CollectionBehaviorWME, List)", null, (short)2));
        behaviorLibrary.registerBehavior(new __BehaviorDesc(47, Player.__$behaviorFactory0_rfield, Player.__$precondition0_rfield, null, "InitPhysicallyFavors_Body(CollectionBehaviorWME, List)", null, (short)1));
        behaviorLibrary.registerBehavior(new __BehaviorDesc(48, Player.__$behaviorFactory0_rfield, null, null, "Player_RootCollectionBehavior()", null, (short)0));
    }
    
    private static final void registerBehaviors_1(final BehaviorLibrary behaviorLibrary) {
        behaviorLibrary.registerBehavior(new __BehaviorDesc(14, Player.__$behaviorFactory0_rfield, null, null, "TurnOffPhysicallyFavorsWithTimeout(int, int)", new String[] { "Trip", "Player" }, (short)0));
        behaviorLibrary.registerBehavior(new __BehaviorDesc(18, Player.__$behaviorFactory0_rfield, Player.__$precondition0_rfield, null, "TurnOnPhysicallyFavors(int)", new String[] { "Trip", "Player" }, (short)0));
        behaviorLibrary.registerBehavior(new __BehaviorDesc(33, Player.__$behaviorFactory0_rfield, Player.__$precondition0_rfield, null, "SetOneCharacterVisibleDistance(float)", new String[] { "Player", "Trip" }, (short)2));
        behaviorLibrary.registerBehavior(new __BehaviorDesc(34, Player.__$behaviorFactory0_rfield, null, null, "SetOneCharacterVisibleDistance(float)", new String[] { "Player", "Trip" }, (short)1));
    }
    
    private final /* synthetic */ void this() {
        this.g_previousPhysicallyFavoredTime = 0L;
        this.g_physicallyFavorLatencyInMS = 10000L;
        this.g_physicallyFavorObjectLatency = 60;
        this.g_physicallyFavorLookDistance_Medium = 100.0f;
        this.g_physicallyFavorLookDistance_Long = 150.0f;
        this.g_physicallyFavorLookTime = 5;
    }
    
    public Player() {
        this.this();
        this.individualBehaviorLibrary = new BehaviorLibrary(90);
        this.jointBehaviorLibrary = new BehaviorLibrary(8);
        registerBehaviors_0(this.individualBehaviorLibrary);
        registerBehaviors_1(this.jointBehaviorLibrary);
        this.startWMEReflection(this.ABT = (CollectionBehavior)Player_BehaviorFactories.behaviorFactory0(48, null, null, null, "Player_RootCollectionBehavior()"));
        this.ABT.initRootBehavior();
        BehavingEntity.registerEntity("Player", this);
    }
    
    static {
        __$tempObjArray = new Object[1];
        __$sensorFactoryArgArray = new Class[1];
        __$behFactoryArgArray = new Class[5];
        __$preconditionArgArray = new Class[4];
        __$continuousConditionArgArray = new Class[3];
        __$stepFactoryArgArray = new Class[3];
        __$argumentStepExecuteArgArray = new Class[3];
        __$mentalStepExecuteArgArray = new Class[4];
        try {
            Player.__$sensorFactoryArgArray[0] = Integer.TYPE;
            Player.__$behFactoryArgArray[0] = Integer.TYPE;
            Player.__$behFactoryArgArray[1] = Player.__$tempObjArray.getClass();
            Player.__$behFactoryArgArray[2] = Class.forName("java.util.Hashtable");
            Player.__$behFactoryArgArray[3] = Class.forName("abl.runtime.GoalStep");
            Player.__$behFactoryArgArray[4] = Class.forName("java.lang.String");
            Player.__$preconditionArgArray[0] = Integer.TYPE;
            Player.__$preconditionArgArray[1] = Player.__$tempObjArray.getClass();
            Player.__$preconditionArgArray[2] = Class.forName("java.util.Hashtable");
            Player.__$preconditionArgArray[3] = Class.forName("abl.runtime.BehavingEntity");
            Player.__$continuousConditionArgArray[0] = Integer.TYPE;
            Player.__$continuousConditionArgArray[1] = Player.__$tempObjArray.getClass();
            Player.__$continuousConditionArgArray[2] = Class.forName("abl.runtime.BehavingEntity");
            Player.__$stepFactoryArgArray[0] = Integer.TYPE;
            Player.__$stepFactoryArgArray[1] = Class.forName("abl.runtime.Behavior");
            Player.__$stepFactoryArgArray[2] = Player.__$tempObjArray.getClass();
            Player.__$argumentStepExecuteArgArray[0] = Integer.TYPE;
            Player.__$argumentStepExecuteArgArray[1] = Player.__$tempObjArray.getClass();
            Player.__$argumentStepExecuteArgArray[2] = Class.forName("abl.runtime.BehavingEntity");
            Player.__$mentalStepExecuteArgArray[0] = Integer.TYPE;
            Player.__$mentalStepExecuteArgArray[1] = Player.__$tempObjArray.getClass();
            Player.__$mentalStepExecuteArgArray[2] = Class.forName("abl.runtime.BehavingEntity");
            Player.__$mentalStepExecuteArgArray[3] = Class.forName("abl.runtime.MentalStep");
        }
        catch (Exception ex) {
            throw new AblRuntimeError("Error in static initializer", ex);
        }
        try {
            __$Player_BehaviorFactories_rfield = Class.forName("facade.characters.player.java.Player_BehaviorFactories");
            (__$behaviorFactory0_rfield = Player.__$Player_BehaviorFactories_rfield.getDeclaredMethod("behaviorFactory0", (Class[])Player.__$behFactoryArgArray)).setAccessible(true);
        }
        catch (Exception ex2) {
            throw new AblRuntimeError("Error in static initializer", ex2);
        }
        try {
            __$Player_Preconditions_rfield = Class.forName("facade.characters.player.java.Player_Preconditions");
            (__$precondition0_rfield = Player.__$Player_Preconditions_rfield.getDeclaredMethod("precondition0", (Class[])Player.__$preconditionArgArray)).setAccessible(true);
        }
        catch (Exception ex3) {
            throw new AblRuntimeError("Error in static initializer", ex3);
        }
        try {
            __$Player_PreconditionSensorFactories_rfield = Class.forName("facade.characters.player.java.Player_PreconditionSensorFactories");
            (__$preconditionSensorFactory0_rfield = Player.__$Player_PreconditionSensorFactories_rfield.getDeclaredMethod("preconditionSensorFactory0", (Class[])Player.__$sensorFactoryArgArray)).setAccessible(true);
        }
        catch (Exception ex4) {
            throw new AblRuntimeError("Error in static initializer", ex4);
        }
        try {
            __$Player_ContextConditions_rfield = Class.forName("facade.characters.player.java.Player_ContextConditions");
            (__$contextCondition0_rfield = Player.__$Player_ContextConditions_rfield.getDeclaredMethod("contextCondition0", (Class[])Player.__$continuousConditionArgArray)).setAccessible(true);
        }
        catch (Exception ex5) {
            throw new AblRuntimeError("Error in static initializer", ex5);
        }
        try {
            __$Player_ContextConditionSensorFactories_rfield = Class.forName("facade.characters.player.java.Player_ContextConditionSensorFactories");
            (__$contextConditionSensorFactory0_rfield = Player.__$Player_ContextConditionSensorFactories_rfield.getDeclaredMethod("contextConditionSensorFactory0", (Class[])Player.__$sensorFactoryArgArray)).setAccessible(true);
        }
        catch (Exception ex6) {
            throw new AblRuntimeError("Error in static initializer", ex6);
        }
        try {
            __$Player_StepFactories_rfield = Class.forName("facade.characters.player.java.Player_StepFactories");
            (__$stepFactory0_rfield = Player.__$Player_StepFactories_rfield.getDeclaredMethod("stepFactory0", (Class[])Player.__$stepFactoryArgArray)).setAccessible(true);
        }
        catch (Exception ex7) {
            throw new AblRuntimeError("Error in static initializer", ex7);
        }
        try {
            __$Player_ArgumentStepExecute_rfield = Class.forName("facade.characters.player.java.Player_ArgumentStepExecute");
            (__$argumentExecute0_rfield = Player.__$Player_ArgumentStepExecute_rfield.getDeclaredMethod("argumentExecute0", (Class[])Player.__$argumentStepExecuteArgArray)).setAccessible(true);
        }
        catch (Exception ex8) {
            throw new AblRuntimeError("Error in static initializer", ex8);
        }
        try {
            __$Player_MentalStepExecute_rfield = Class.forName("facade.characters.player.java.Player_MentalStepExecute");
            (__$mentalExecute0_rfield = Player.__$Player_MentalStepExecute_rfield.getDeclaredMethod("mentalExecute0", (Class[])Player.__$mentalStepExecuteArgArray)).setAccessible(true);
        }
        catch (Exception ex9) {
            throw new AblRuntimeError("Error in static initializer", ex9);
        }
        try {
            __$Player_SuccessTests_rfield = Class.forName("facade.characters.player.java.Player_SuccessTests");
            (__$successTest0_rfield = Player.__$Player_SuccessTests_rfield.getDeclaredMethod("successTest0", (Class[])Player.__$continuousConditionArgArray)).setAccessible(true);
        }
        catch (Exception ex10) {
            throw new AblRuntimeError("Error in static initializer", ex10);
        }
        try {
            __$Player_SuccessTestSensorFactories_rfield = Class.forName("facade.characters.player.java.Player_SuccessTestSensorFactories");
            (__$successTestSensorFactory0_rfield = Player.__$Player_SuccessTestSensorFactories_rfield.getDeclaredMethod("successTestSensorFactory0", (Class[])Player.__$sensorFactoryArgArray)).setAccessible(true);
        }
        catch (Exception ex11) {
            throw new AblRuntimeError("Error in static initializer", ex11);
        }
    }
}
