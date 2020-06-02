package facade.primact;

import abl.runtime.AblRuntimeError;
import facade.util.GestureBodyPart;

public class DoTwoArmGestureAnimation extends FacadeAsynchronousAction implements GestureBodyPart
{
    private int armLCompletionStatus;
    private int armRCompletionStatus;
    private DoGestureAnimationWithSpecialCompletion armLGesture;
    private DoGestureAnimationWithSpecialCompletion armRGesture;
    private int character;
    
    public void execute(final Object[] array) {
        final int intValue = (int)array[0];
        final int intValue2 = (int)array[1];
        final int intValue3 = (int)array[2];
        this.armLGesture.execute(new Object[] { new Integer(intValue), new Integer(0), new Integer(intValue2) });
        System.out.println("Executing left arm gesture");
        this.armRGesture.execute(new Object[] { new Integer(intValue), new Integer(1), new Integer(intValue3) });
        System.out.println("Executing right arm gesture");
        this.character = intValue;
    }
    
    public void abort() {
        if (this.character != -1) {
            this.armLGesture.abort();
            this.armRGesture.abort();
        }
    }
    
    static /* synthetic */ void access$1(final DoTwoArmGestureAnimation doTwoArmGestureAnimation, final int armLCompletionStatus) {
        doTwoArmGestureAnimation.armLCompletionStatus = armLCompletionStatus;
    }
    
    static /* synthetic */ void access$3(final DoTwoArmGestureAnimation doTwoArmGestureAnimation, final int armRCompletionStatus) {
        doTwoArmGestureAnimation.armRCompletionStatus = armRCompletionStatus;
    }
    
    private final /* synthetic */ void this() {
        this.armLCompletionStatus = 0;
        this.armRCompletionStatus = 0;
        this.armLGesture = new DoGestureAnimationWithSpecialCompletion(this);
        this.armRGesture = new DoGestureAnimationWithSpecialCompletion(this);
        this.character = -1;
    }
    
    public DoTwoArmGestureAnimation() {
        this.this();
    }
    
    class DoGestureAnimationWithSpecialCompletion extends DoGestureAnimation
    {
        private DoTwoArmGestureAnimation twoArm;
        
        public synchronized void completionCallback(final boolean b) {
            if (b) {
                if (this.gestureBodyPart == 0) {
                    DoTwoArmGestureAnimation.access$1(DoTwoArmGestureAnimation.this, 1);
                }
                else {
                    if (this.gestureBodyPart != 1) {
                        throw new AblRuntimeError("Unexpected body part index in DoTwoArmGestureAnimation");
                    }
                    DoTwoArmGestureAnimation.access$3(DoTwoArmGestureAnimation.this, 1);
                }
                if (DoTwoArmGestureAnimation.this.armLCompletionStatus == 1 && DoTwoArmGestureAnimation.this.armRCompletionStatus == 1) {
                    this.twoArm.completionStatus = 1;
                }
            }
            else {
                DoTwoArmGestureAnimation.this.armLGesture.abort();
                DoTwoArmGestureAnimation.this.armRGesture.abort();
                this.twoArm.completionStatus = 2;
            }
        }
        
        DoGestureAnimationWithSpecialCompletion(final DoTwoArmGestureAnimation twoArm) {
            this.twoArm = twoArm;
        }
    }
}
