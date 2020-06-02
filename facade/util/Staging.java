package facade.util;

import java.util.Random;

public class Staging implements SpriteID, BeatConstants
{
    private static final float sharingAngle = 20.0f;
    private static final float playerViewConeAngle = 35.0f;
    private static final float tooFarAwayToCareIfBlockedByOtherCharacter = 1000.0f;
    private static final float pi = 3.1415f;
    private static final float radiansPerDegree = 0.017452778f;
    private static final float degreesPerRadian = 57.29747f;
    private static final Random randomGen;
    private static final /* synthetic */ boolean $noassert;
    
    public static void getConversationPosition(final boolean b, boolean b2, final BooleanRef booleanRef, float n, final boolean b3, final float n2, final Point3D point3D, float adjustPlayerPtAndRotToAvoidFurniture, final Point3D point3D2, final Point3D point3D3, final FloatRef floatRef, final boolean b4, final Point3D point3D4, final Point3D point3D5, final FloatRef floatRef2, final boolean b5) {
        final Point3D point3D6 = new Point3D();
        adjustPlayerPtAndRotToAvoidFurniture = AdjustPlayerPtAndRotToAvoidFurniture(point3D, adjustPlayerPtAndRotToAvoidFurniture);
        if (n >= 35.0f) {
            n = randRange(n - 3, n + 3);
        }
        else {
            n = randRange(n - 1.0f, n + 1.0f);
        }
        if (n < 30.0f) {
            n = 30.0f;
        }
        float randRange;
        if (!b3) {
            randRange = randRange(-3.0f, 3);
        }
        else {
            if (!b4 && !b5) {
                final float normalizeNeg180to180 = normalizeNeg180to180(getAngleRelativeToPlayer(point3D2, point3D, adjustPlayerPtAndRotToAvoidFurniture));
                final float normalizeNeg180to181 = normalizeNeg180to180(getAngleRelativeToPlayer(point3D4, point3D, adjustPlayerPtAndRotToAvoidFurniture));
                if ((normalizeNeg180to180 > 0.0f && normalizeNeg180to181 < 0.0f) || (normalizeNeg180to180 < 0.0f && normalizeNeg180to181 > 0.0f)) {
                    if (normalizeNeg180to180 > 0.0f) {
                        b2 = false;
                    }
                    else {
                        b2 = true;
                    }
                }
                else if (normalizeNeg180to180 > 0.0f) {
                    if (normalizeNeg180to180 > normalizeNeg180to181) {
                        b2 = true;
                    }
                    else {
                        b2 = false;
                    }
                }
                else if (normalizeNeg180to180 > normalizeNeg180to181) {
                    b2 = false;
                }
                else {
                    b2 = true;
                }
            }
            if ((b2 && b) || (!b2 && !b)) {
                randRange = -20.0f + randRange(-2.0f, 2.0f);
            }
            else {
                randRange = 20.0f + randRange(-2.0f, 2.0f);
            }
        }
        final Point3D conversationPositionComputation = conversationPositionComputation(n, randRange, point3D, adjustPlayerPtAndRotToAvoidFurniture);
        final float n3 = getXZAngleBetweenPoints(point3D, conversationPositionComputation) + 180.0f;
        float n4;
        if ((b2 && b) || (!b2 && !b)) {
            n4 = normalize0to360(n3 + n2);
        }
        else {
            n4 = normalize0to360(n3 - n2);
        }
        if (b) {
            point3D3.x = conversationPositionComputation.x;
            point3D3.y = conversationPositionComputation.y;
            point3D3.z = conversationPositionComputation.z;
            floatRef.f = n4;
        }
        else {
            point3D5.x = conversationPositionComputation.x;
            point3D5.y = conversationPositionComputation.y;
            point3D5.z = conversationPositionComputation.z;
            floatRef2.f = n4;
        }
        booleanRef.b = b2;
    }
    
    public static Point3D conversationPositionComputation(final float n, float n2, final Point3D point3D, final float n3) {
        n2 = normalize0to360(n2 + n3);
        n2 = convertWorldDegreesToRadians(n2);
        final Point3D point3D2 = new Point3D();
        point3D2.x = point3D.x;
        point3D2.z = point3D.z;
        final Point3D point3D3 = point3D2;
        point3D3.x += (float)(n * Math.cos(n2));
        final Point3D point3D4 = point3D2;
        point3D4.z += (float)(n * Math.sin(n2));
        return point3D2;
    }
    
    public static Point3D pointAtAngleAndDist(final float n, float n2, final Point3D point3D) {
        n2 = normalize0to360(n2);
        n2 = convertWorldDegreesToRadians(n2);
        final Point3D point3D2 = new Point3D();
        point3D2.x = point3D.x;
        point3D2.z = point3D.z;
        final Point3D point3D3 = point3D2;
        point3D3.x += (float)(n * Math.cos(n2));
        final Point3D point3D4 = point3D2;
        point3D4.z += (float)(n * Math.sin(n2));
        return point3D2;
    }
    
    public static void updateWalkToPtToRadiusEdge(final Point3D point3D, final Point3D point3D2, final float n, final Point3D point3D3) {
        final float xzAngleBetweenPoints = getXZAngleBetweenPoints(point3D, point3D2);
        final Point3D point3D4 = new Point3D();
        final Point3D conversationPositionComputation = conversationPositionComputation(n, xzAngleBetweenPoints, point3D, 0.0f);
        point3D3.x = conversationPositionComputation.x;
        point3D3.y = conversationPositionComputation.y;
        point3D3.z = conversationPositionComputation.z;
    }
    
    public static boolean isPointWithinCharCone(final float n, final float n2, final float n3, final float n4, final float n5, final float n6, final float n7, final float n8) {
        final float xzDistanceBetweenPoints = getXZDistanceBetweenPoints(n3, n4, n, n2);
        return xzDistanceBetweenPoints >= n7 && xzDistanceBetweenPoints <= n8 && Math.abs(normalizeNeg180to180(getXZAngleBetweenPoints(n3, n4, n, n2) - n5)) <= n6;
    }
    
    public static float getAngleRelativeToPlayer(final Point3D point3D, final Point3D point3D2, final float n) {
        return normalizeNeg180to180(getXZAngleBetweenPoints(point3D2, point3D) - n);
    }
    
    public static float getXZDistanceBetweenPoints(final Point3D point3D, final Point3D point3D2) {
        return getXZDistanceBetweenPoints(point3D.x, point3D.z, point3D2.x, point3D2.z);
    }
    
    public static float getXZDistanceBetweenPoints(final float n, final float n2, final float n3, final float n4) {
        final float n5 = n - n3;
        final float n6 = n2 - n4;
        return (float)Math.sqrt(n5 * n5 + n6 * n6);
    }
    
    public static float getXZAngleBetweenPoints(final Point3D point3D, final Point3D point3D2) {
        return getXZAngleBetweenPoints(point3D.x, point3D.z, point3D2.x, point3D2.z);
    }
    
    public static float getXZAngleBetweenPoints(final float n, final float n2, final float n3, final float n4) {
        return normalizeNeg180to180((float)Math.atan2(n4 - n2, n3 - n) * 57.29747f + 90.0f);
    }
    
    public static float normalizeNeg180to180(float n) {
        while (n > 180.0f) {
            n -= 360.0f;
        }
        while (n < -180.0f) {
            n += 360.0f;
        }
        return n;
    }
    
    public static float normalize0to360(float n) {
        while (n >= 360.0f) {
            n -= 360.0f;
        }
        while (n < 0.0f) {
            n += 360.0f;
        }
        return n;
    }
    
    public static float convertWorldDegreesToRadians(final float n) {
        return normalize0to360(n - 90.0f) * 0.017452778f;
    }
    
    public static int randRange(final int n, final int n2) {
        if (!Staging.$noassert && n2 <= n) {
            throw new AssertionError();
        }
        return Staging.randomGen.nextInt(n2 - n + 1) + n;
    }
    
    public static float randRange(final float n, final float n2) {
        if (!Staging.$noassert && n2 <= n) {
            throw new AssertionError();
        }
        return n + (n2 - n) * Staging.randomGen.nextFloat();
    }
    
    public static boolean percentChance(final int n) {
        if (!Staging.$noassert && (n < 0 || n > 100)) {
            throw new AssertionError();
        }
        boolean b = false;
        if (Staging.randomGen.nextInt(101) < n) {
            b = true;
        }
        return b;
    }
    
    public static float AdjustPlayerPtAndRotToAvoidFurniture(final Point3D point3D, float n) {
        final float x = point3D.x;
        final float z = point3D.z;
        final float normalize0to360 = normalize0to360(n);
        final float n2 = 60.0f;
        final float z2 = -475.0f;
        final float x2 = -165.0f;
        final float n3 = -200.0f;
        final float x3 = -115.0f;
        final float z3 = 75.0f;
        final float n4 = 135.0f;
        final float n5 = -435.0f;
        final float n6 = 70.0f;
        final float n7 = 35.0f;
        final float n8 = 0.0f + n7;
        final float n9 = 0.0f - n7;
        final float n10 = 180.0f - n7;
        final float n11 = 180.0f + n7;
        final float n12 = 90.0f - n7;
        final float n13 = 90.0f + n7;
        final float n14 = 270.0f + n7;
        final float n15 = 270.0f - n7;
        if (x < x2 + n2 && z < n3) {
            if (x < x2) {
                point3D.x = x2;
            }
            if (z < z2 + n2) {
                n = n10;
            }
            else if (z > n3 - n2) {
                n = n8;
            }
            else if (normalize0to360 <= 45.0f || normalize0to360 >= 135.0f) {
                if (normalize0to360 > 90.0f && normalize0to360 < 270.0f) {
                    n = n10;
                }
                else {
                    n = n8;
                }
            }
        }
        else if (z < z2 + n2 && x < n6) {
            if (z < z2) {
                point3D.z = z2;
            }
            if (x > n6 - n2) {
                n = n11;
            }
            else if (normalize0to360 <= 135.0f || normalize0to360 >= 225.0f) {
                if (normalize0to360 > 0.0f && normalize0to360 < 180.0f) {
                    n = n13;
                }
                else {
                    n = n15;
                }
            }
        }
        else if (z < n5 + n2 && x > n6 - n2) {
            if (x > n4) {
                point3D.x = n4;
            }
            if (normalize0to360 <= 135.0f || normalize0to360 >= 315.0f) {
                if (normalize0to360 > 45.0f && normalize0to360 <= 135.0f) {
                    n = 135.0f;
                }
                else {
                    n = 315.0f;
                }
            }
        }
        else if (x > n4 - n2 && z < z3) {
            if (x > n4) {
                point3D.x = n4;
            }
            if (z < n5 + n2) {
                n = n11;
            }
            else if (z > z3 - n2) {
                n = n9;
            }
            else if (normalize0to360 <= 225.0f || normalize0to360 >= 315.0f) {
                if (normalize0to360 > 90.0f && normalize0to360 < 270.0f) {
                    n = n11;
                }
                else {
                    n = n9;
                }
            }
        }
        else if (z > z3 - n2) {
            if (x < x3) {
                point3D.x = x3;
            }
            if (z > z3) {
                point3D.z = z3;
            }
            if (x < x3 + n2) {
                n = n8;
            }
            else if (normalize0to360 <= 315.0f && normalize0to360 >= 45.0f) {
                if (normalize0to360 > 0.0f && normalize0to360 < 180.0f) {
                    n = n12;
                }
                else {
                    n = n14;
                }
            }
        }
        else if (x < x3 + n2 && z >= n3) {
            if (x < x3) {
                point3D.x = x3;
            }
            if (normalize0to360 <= 45.0f || normalize0to360 >= 135.0f) {
                if (normalize0to360 > 90.0f && normalize0to360 < 270.0f) {
                    n = n10;
                }
                else {
                    n = n8;
                }
            }
        }
        else if (z > n3 - n2 && x < x3 + n2) {
            if (x < x3) {
                point3D.x = x3;
            }
            if (normalize0to360 <= 315.0f && normalize0to360 >= 225.0f) {
                if (normalize0to360 > 45.0f && normalize0to360 < 225.0f) {
                    n = 135.0f;
                }
                else {
                    n = 315.0f;
                }
            }
        }
        return normalize0to360(n);
    }
    
    static {
        $noassert = (Class.forName("[Lfacade.util.Staging;").getComponentType().desiredAssertionStatus() ^ true);
        randomGen = new Random();
    }
}
