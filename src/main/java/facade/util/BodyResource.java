package facade.util;

public interface BodyResource
{
    public static final int eBodyResourceID_NOTARESOURCE = -1;
    public static final int eBodyResourceID_legsBody = 0;
    public static final int eBodyResourceID_armL = 1;
    public static final int eBodyResourceID_armR = 2;
    public static final int eBodyResourceID_gaze = 3;
    public static final int eBodyResourceID_gazeTorso = 4;
    public static final int eBodyResourceID_voice = 5;
    public static final int eBodyResourceID_faceExpressionBase = 6;
    public static final int eBodyResourceID_faceExpressionMood = 7;
    public static final int eBodyResourceID_facialMod = 8;
    public static final int eBodyResourcePriority_NOTAPRIORITY = -1;
    public static final int eBodyResourcePriority_ifNotBusy = 0;
    public static final int eBodyResourcePriority_always = Integer.MAX_VALUE;
    public static final int eBodyResourceAction_fail = 0;
    public static final int eBodyResourceAction_block = 1;
}
