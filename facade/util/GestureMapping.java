package facade.util;

import java.util.Random;

public class GestureMapping implements GraceScript, TripScript, BeatConstants, SpriteID, GestureBodyPart
{
    private static final Random randomGen;
    
    public static boolean IsEmphasisMotion(final int n, final int n2) {
        if (n == 0) {
            switch (n2) {
                case 70:
                case 71:
                case 72:
                case 73:
                case 74:
                case 75:
                case 120:
                case 121:
                case 125:
                case 126:
                case 130:
                case 131:
                case 135:
                case 136: {
                    return true;
                }
            }
        }
        else if (n == 1) {
            switch (n2) {
                case 89:
                case 90:
                case 91:
                case 92:
                case 93:
                case 94:
                case 95:
                case 96:
                case 97:
                case 98:
                case 99:
                case 100:
                case 101:
                case 111:
                case 112:
                case 113:
                case 114:
                case 115:
                case 116:
                case 202:
                case 203:
                case 207:
                case 208:
                case 212:
                case 213:
                case 217:
                case 218: {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static boolean IsEmphasisMotionOrHold(final int n, final int n2) {
        if (IsEmphasisMotion(n, n2)) {
            return true;
        }
        if (n == 0) {
            switch (n2) {
                case 86:
                case 92:
                case 119:
                case 124:
                case 129:
                case 134: {
                    return true;
                }
            }
        }
        else if (n == 1) {
            switch (n2) {
                case 69:
                case 72:
                case 75:
                case 78:
                case 84:
                case 106:
                case 201:
                case 206:
                case 211:
                case 216: {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static int GetGestureMappingCategory(final int n, final int n2) {
        if (n == 0) {
            switch (n2) {
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                case 69: {
                    return 1;
                }
            }
        }
        else if (n == 1) {
            switch (n2) {
                case 117:
                case 118:
                case 119:
                case 120:
                case 121:
                case 122:
                case 123:
                case 124:
                case 125:
                case 126:
                case 127:
                case 128:
                case 129:
                case 130:
                case 131:
                case 132:
                case 133:
                case 134:
                case 135:
                case 136:
                case 137:
                case 138:
                case 139:
                case 140:
                case 141:
                case 142:
                case 143:
                case 144:
                case 145:
                case 146:
                case 147:
                case 148:
                case 149:
                case 150:
                case 151:
                case 152:
                case 153:
                case 154:
                case 155:
                case 156:
                case 157: {
                    return 0;
                }
                case 158:
                case 162:
                case 163:
                case 164:
                case 165:
                case 166:
                case 167:
                case 168:
                case 169:
                case 170:
                case 171:
                case 172:
                case 173:
                case 174:
                case 180:
                case 181:
                case 182:
                case 183:
                case 184:
                case 185:
                case 186:
                case 187:
                case 188:
                case 189:
                case 190:
                case 191:
                case 192:
                case 193:
                case 194:
                case 195:
                case 196:
                case 197:
                case 198:
                case 199: {
                    return 1;
                }
            }
        }
        return -1;
    }
    
    public static int MapEmphasisGesture(final int n, final int n2, final int n3, final int n4) {
        if (n != 0 && n == 1 && n3 == 1 && IsEmphasisMotion(n, n4) && n2 == 1) {
            return 197 + GestureMapping.randomGen.nextInt(3);
        }
        return -2;
    }
    
    public static int MapOrSuppressGestureBecauseHoldingObj(final int n, final int n2) {
        int n3 = -2;
        if (n != 0 && n == 1) {
            switch (n2) {
                case 175: {
                    n3 = 180;
                    break;
                }
                case 176: {
                    n3 = 181;
                    break;
                }
                case 177: {
                    n3 = 182;
                    break;
                }
                case 178: {
                    n3 = 183;
                    break;
                }
                case 179: {
                    n3 = 184;
                    break;
                }
            }
        }
        return n3;
    }
    
    public static int MapArmLRGesture(final int n, final int n2, final int n3, final int n4, final int n5, final int n6) {
        if (n3 < 0) {
            return n3;
        }
        int n7;
        if (n2 == 0) {
            n7 = GetGestureMappingCategory(n, n4);
        }
        else if (n2 == 1) {
            n7 = GetGestureMappingCategory(n, n5);
        }
        else {
            if (n2 != 2) {
                return n3;
            }
            n7 = GetGestureMappingCategory(n, n6);
        }
        final boolean isEmphasisMotionOrHold = IsEmphasisMotionOrHold(n, n3);
        final int getGestureMappingCategory = GetGestureMappingCategory(n, n3);
        int n8 = n3;
        if ((n7 == -1 || getGestureMappingCategory != n7) && n7 == 1) {
            if (!isEmphasisMotionOrHold) {
                n8 = MapOrSuppressGestureBecauseHoldingObj(n, n3);
                if (n8 != -2) {
                    StringUtil.println(n + " mapped gesture " + n3 + " to holding-obj version " + n8);
                }
                else {
                    StringUtil.println(n + " suppressing non-emph gesture " + n3 + " because holding object");
                }
            }
            else {
                n8 = MapEmphasisGesture(n, n2, n7, n3);
                StringUtil.println(n + " mapping emph gesture " + n3 + " to " + n8);
            }
        }
        return n8;
    }
    
    static {
        randomGen = new Random();
    }
}
