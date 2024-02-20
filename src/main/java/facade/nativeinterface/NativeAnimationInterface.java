package facade.nativeinterface;

import facade.util.ObjectStateSensePacket;
import facade.util.ObjectActivationSensePacket;
import facade.util.AnimCueSensePacket;
import facade.util.HeldObjectSensePacket;
import facade.util.FloatRef;
import facade.util.ObjectSensePacket;
import facade.util.IntegerRef;
import facade.primact.Turn;
import facade.primact.ReactiveWalk;
import facade.primact.Walk;
import facade.util.Point3D;
import facade.primact.DoFullExpressionMoodAnimation;
import facade.primact.DoFullExpressionBaseAnimation;
import facade.primact.DoPutdownObjGestureAnimation;
import facade.primact.DoPickupObjGestureAnimation;
import facade.primact.DoGestureAnimation;
import facade.primact.PushPoseScript;
import facade.primact.PushMultipleAnimationScripts;
import facade.util.SpriteID;

public class NativeAnimationInterface implements SpriteID
{
    static PushMultipleAnimationScripts asyncActInstance;
    private static long lastTripSMCallTime;
    private static long lastGraceSMCallTime;
    
    public static native void resetCharacterState(final int p0);
    
    public static native void resetObjectActivation(final int p0);
    
    public static native void resetAllObjectActivations();
    
    public static native void processCompletedActions(final int p0, final PushMultipleAnimationScripts p1);
    
    public static void facadeDecisionCycleSMCall(final int n) {
        processCompletedActions(n, NativeAnimationInterface.asyncActInstance);
    }
    
    public static void tripDecisionCycleSMCall() {
        if (System.currentTimeMillis() - NativeAnimationInterface.lastTripSMCallTime > 33L) {
            NativeAnimationInterface.lastTripSMCallTime = System.currentTimeMillis();
            facadeDecisionCycleSMCall(1);
        }
    }
    
    public static void graceDecisionCycleSMCall() {
        if (System.currentTimeMillis() - NativeAnimationInterface.lastGraceSMCallTime > 33L) {
            NativeAnimationInterface.lastGraceSMCallTime = System.currentTimeMillis();
            facadeDecisionCycleSMCall(0);
        }
    }
    
    public static native void setObjectPosition(final int p0, final float p1, final float p2, final float p3);
    
    public static native void setObjectRotation(final int p0, final float p1, final float p2, final float p3);
    
    public static native void pushMultipleAnimationScripts(final int p0, final int p1, final int p2, final int p3, final int p4, final int p5, final PushMultipleAnimationScripts p6);
    
    public static native void pushAnimationUScript(final int p0, final int p1, final int p2, final PushMultipleAnimationScripts p3);
    
    public static native void pushPoseScript(final int p0, final int p1, final PushPoseScript p2);
    
    public static native void doGestureAnimation(final int p0, final int p1, final int p2, final DoGestureAnimation p3);
    
    public static native void doPickupObjGestureAnimation(final int p0, final int p1, final int p2, final int p3, final int p4, final DoPickupObjGestureAnimation p5);
    
    public static native void doPutdownObjGestureAnimation(final int p0, final int p1, final int p2, final int p3, final int p4, final float p5, final float p6, final float p7, final int p8, final DoPutdownObjGestureAnimation p9);
    
    public static native void doFullExpressionBaseAnimation(final int p0, final int p1, final int p2, final int p3, final DoFullExpressionBaseAnimation p4);
    
    public static native void doFullExpressionMoodAnimation(final int p0, final int p1, final int p2, final int p3, final DoFullExpressionMoodAnimation p4);
    
    public static native void abortAnimationScripts(final int p0, final int p1);
    
    public static native void setGazeTracking(final int p0, final int p1, final float p2, final float p3, final float p4, final int p5, final int p6, final int p7);
    
    public static native void setEyelidHeightL(final int p0, final float p1, final float p2);
    
    public static native void setEyelidHeightR(final int p0, final float p1, final float p2);
    
    public static native void setBrowShapeL(final int p0, final int p1);
    
    public static native void setBrowShapeR(final int p0, final int p1);
    
    public static native void setMouthShape(final int p0, final int p1);
    
    public static native void miscLittleAction(final int p0, final int p1, final int p2, final float p3);
    
    public static native void setObjectToHold(final int p0, final int p1, final int p2);
    
    public static native void walkStep(final int p0, final int p1, final float p2, final float p3, final float p4, final float p5, final Point3D p6, final Walk p7);
    
    public static native void reactiveWalkStep(final int p0, final int p1, final boolean p2, final ReactiveWalk p3);
    
    public static native void abortWalkStep(final int p0);
    
    public static native void turnInPlace(final int p0, final float p1, final Turn p2);
    
    public static native void abortTurnInPlace(final int p0);
    
    public static native void music(final int p0, final int p1);
    
    public static native void setAnimEngineInfo(final int p0, final int p1);
    
    public static native void setPerformanceInfo(final int p0, final int p1, final int p2, final int p3, final int p4, final int p5, final int p6, final int p7, final int p8, final int p9, final int p10, final int p11, final int p12, final int p13, final int p14, final int p15, final int p16, final int p17, final int p18, final int p19, final int p20, final int p21, final int p22, final int p23, final int p24, final int p25, final int p26, final int p27, final int p28, final int p29, final int p30, final int p31, final int p32, final int p33, final int p34, final int p35, final int p36, final int p37, final int p38, final int p39, final int p40, final int p41, final int p42, final int p43, final int p44, final int p45, final int p46, final int p47, final int p48, final int p49, final int p50, final int p51, final int p52, final int p53, final int p54, final int p55, final int p56, final int p57, final int p58, final int p59, final int p60, final int p61, final int p62, final int p63, final int p64, final int p65, final int p66, final int p67, final int p68, final int p69, final int p70, final int p71, final int p72, final int p73, final int p74, final int p75, final int p76, final int p77, final int p78, final int p79, final int p80, final int p81, final int p82, final int p83, final int p84);
    
    public static native void dprintf(final String p0);
    
    public static native void addEventInfoToLog(final String p0);
    
    public static native void getObjectPosition(final int p0, final Point3D p1);
    
    public static native void getObjectRotation(final int p0, final Point3D p1);
    
    public static native void getObjectState(final int p0, final IntegerRef p1);
    
    public static native void getAllObjectRotations(final ObjectSensePacket p0);
    
    public static native void getAllObjectStagingRotations(final ObjectSensePacket p0);
    
    public static native void getAllObjectPositions(final ObjectSensePacket p0);
    
    public static native void getAllObjectPickupRotations(final int p0, final ObjectSensePacket p1);
    
    public static native void getAllObjectPickupPositions(final int p0, final ObjectSensePacket p1);
    
    public static native void getGazeTracking(final int p0, final IntegerRef p1);
    
    public static native void getEyelidHeightL(final int p0, final FloatRef p1);
    
    public static native void getEyelidHeightR(final int p0, final FloatRef p1);
    
    public static native void getBrowShapeL(final int p0, final IntegerRef p1);
    
    public static native void getBrowShapeR(final int p0, final IntegerRef p1);
    
    public static native void getMouthShape(final int p0, final IntegerRef p1);
    
    public static native void getAllHeldObjects(final HeldObjectSensePacket p0);
    
    public static native int getTickCount();
    
    public static native String textSensor();
    
    public static native void getPlayerGesture(final IntegerRef p0, final IntegerRef p1, final IntegerRef p2);
    
    public static native void getMyCopyOfAllAnimCues(final int p0, final AnimCueSensePacket p1);
    
    public static native void resetMyCopyOfAllAnimCues(final int p0);
    
    public static native void getMyCopyOfAllObjectActivations(final int p0, final ObjectActivationSensePacket p1);
    
    public static native void resetMyCopyOfAllObjectActivations(final int p0);
    
    public static native void getObjectPickupPosition(final int p0, final int p1, final Point3D p2);
    
    public static native void getAllObjectStates(final ObjectStateSensePacket p0);
    
    public static native void getArmGestureBases(final int p0, final IntegerRef p1, final IntegerRef p2, final IntegerRef p3);
    
    static {
        NativeAnimationInterface.asyncActInstance = new PushMultipleAnimationScripts();
        System.loadLibrary("nativeAnimInterface");
        NativeAnimationInterface.lastTripSMCallTime = 0L;
        NativeAnimationInterface.lastGraceSMCallTime = 0L;
    }
}
