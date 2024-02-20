package facade.util;

import java.util.Collection;
import java.util.Vector;
import java.util.List;
import java.lang.reflect.Field;
import java.util.Hashtable;

public class PrintUtilities implements SpriteID, BeatConstants
{
    private static final Hashtable tripScriptTable;
    private static final Hashtable graceScriptTable;
    private static final int tripScriptTrim;
    private static final int graceScriptTrim;
    
    private static final boolean isMarkerEnum(final String s) {
        final char[] charArray = s.substring(s.indexOf(95)).toCharArray();
        for (int i = 0; i < charArray.length; ++i) {
            if (!Character.isUpperCase(charArray[i]) && charArray[i] != '_' && !Character.isDigit(charArray[i])) {
                return false;
            }
        }
        return true;
    }
    
    public static String mapEnumToStringViaTable(final int n, final String s) {
        Hashtable hashtable;
        if (s.equals("facade.util.TripScript")) {
            hashtable = PrintUtilities.tripScriptTable;
        }
        else {
            if (!s.equals("facade.util.GraceScript")) {
                return null;
            }
            hashtable = PrintUtilities.graceScriptTable;
        }
        return hashtable.get(new Integer(n));
    }
    
    public static String mapEnumToString(final int n, final String s, final String s2) {
        try {
            final Field[] fields = Class.forName(s).getFields();
            for (int i = 0; i < fields.length; ++i) {
                if (fields[i].getName().startsWith(s2) && !isMarkerEnum(fields[i].getName()) && fields[i].getInt(null) == n) {
                    return fields[i].getName();
                }
            }
            return null;
        }
        catch (Exception ex) {
            StringUtil.println("Exception: " + ex + " in PrintUtilities.mapEnumToString()");
            return null;
        }
    }
    
    public static int mapStringToEnum(final String s, final String s2) {
        try {
            final Field[] fields = Class.forName(s2).getFields();
            for (int i = 0; i < fields.length; ++i) {
                if (fields[i].getName().equals(s)) {
                    return fields[i].getInt(null);
                }
            }
            return Integer.MIN_VALUE;
        }
        catch (Exception ex) {
            StringUtil.println("Exception: " + ex + " in PrintUtilities.mapStringToEnum()");
            return Integer.MIN_VALUE;
        }
    }
    
    public static List getEnumNames(final String s, final String s2) {
        final Vector<String> vector = new Vector<String>();
        try {
            final Field[] fields = Class.forName(s).getFields();
            for (int i = 0; i < fields.length; ++i) {
                if (fields[i].getName().startsWith(s2) && !isMarkerEnum(fields[i].getName())) {
                    vector.add(fields[i].getName());
                }
            }
            return vector;
        }
        catch (Exception ex) {
            StringUtil.println("Exception: " + ex + " in PrintUtilities.getEnumNames()");
            return null;
        }
    }
    
    public static List getEnumNamesInSubrange(final String s, final String s2, final int n, final int n2) {
        final Vector<String> vector = new Vector<String>();
        try {
            final Field[] fields = Class.forName(s).getFields();
            for (int i = 0; i < fields.length; ++i) {
                if (fields[i].getName().startsWith(s2) && !isMarkerEnum(fields[i].getName()) && fields[i].getInt(null) >= n && fields[i].getInt(null) <= n2) {
                    vector.add(fields[i].getName());
                }
            }
            return vector;
        }
        catch (Exception ex) {
            StringUtil.println("Exception: " + ex + " in PrintUtilities.getEnumNames()");
            return null;
        }
    }
    
    public static String bodyResource_EnumToString(final int n) {
        return mapEnumToString(n, "facade.util.BodyResource", "eBodyResourceID");
    }
    
    public static String daHandledStatus_EnumToString(final int n) {
        return mapEnumToString(n, "facade.util.DAType", "eDAHandledStatus");
    }
    
    public static int daHandledStatus_StringToEnum(final String s) {
        return mapStringToEnum(s, "facade.util.DAType");
    }
    
    public static String[] daHandledStatus_GetEnumArray() {
        final List enumNames = getEnumNames("facade.util.DAType", "eDAHandledStatus");
        return enumNames.toArray(new String[enumNames.size()]);
    }
    
    public static String daType_EnumToString(final int n) {
        if (n == -1) {
            return "eDAMiscParam_NOPARAM";
        }
        return mapEnumToString(n, "facade.util.DAType", "eDAType");
    }
    
    public static int daType_StringToEnum(final String s) {
        return mapStringToEnum(s, "facade.util.DAType");
    }
    
    public static String[] daType_GetEnumArray() {
        final Vector<Object> vector = (Vector<Object>)new Vector<String>();
        vector.add("eDAMiscParam_NOPARAM");
        vector.addAll(getEnumNames("facade.util.DAType", "eDAType"));
        return vector.toArray(new String[vector.size()]);
    }
    
    public static String spriteID_EnumToString(final int n) {
        if (n == -1) {
            return "eSpriteID_NOTASPRITE";
        }
        return mapEnumToString(n, "facade.util.SpriteID", "eSpriteID");
    }
    
    public static int spriteID_StringToEnum(final String s) {
        return mapStringToEnum(s, "facade.util.SpriteID");
    }
    
    public static String[] spriteID_GetEnumArray() {
        final Vector<Object> vector = (Vector<Object>)new Vector<String>();
        vector.add("eSpriteID_NOTASPRITE");
        vector.addAll(getEnumNames("facade.util.SpriteID", "eSpriteID"));
        return vector.toArray(new String[vector.size()]);
    }
    
    public static String[] spriteID_GetCharacterEnumArray() {
        final Vector<Object> vector = (Vector<Object>)new Vector<String>();
        vector.add("eSpriteID_NOTASPRITE");
        vector.addAll(getEnumNamesInSubrange("facade.util.SpriteID", "eSpriteID", 0, 1));
        return vector.toArray(new String[vector.size()]);
    }
    
    public static String affinity_EnumToString(final int n) {
        return mapEnumToString(n, "dramaman.runtime.DramaManagerConstants", "eAffinity");
    }
    
    public static int affinity_StringToEnum(final String s) {
        return mapStringToEnum(s, "dramaman.runtime.DramaManagerConstants");
    }
    
    public static String[] affinity_GetEnumArray() {
        final List enumNames = getEnumNames("dramaman.runtime.DramaManagerConstants", "eAffinity");
        return enumNames.toArray(new String[enumNames.size()]);
    }
    
    public static String beatID_EnumToString(final int n) {
        return mapEnumToString(n, "facade.util.BeatID", "eBeatID");
    }
    
    public static int beatID_StringToEnum(final String s) {
        return mapStringToEnum(s, "facade.util.BeatID");
    }
    
    public static String[] beatID_GetEnumArray() {
        final List enumNames = getEnumNames("facade.util.BeatID", "eBeatID");
        return enumNames.toArray(new String[enumNames.size()]);
    }
    
    public static String beatAbortReason_EnumToString(final int n) {
        return mapEnumToString(n, "dramaman.runtime.DramaManagerConstants", "eBeatAbortReason");
    }
    
    public static int beatAbortReason_StringToEnum(final String s) {
        return mapStringToEnum(s, "dramaman.runtime.DramaManagerConstants");
    }
    
    public static String[] beatAbortReason_GetEnumArray() {
        final List enumNames = getEnumNames("dramaman.runtime.DramaManagerConstants", "eBeatAbortReason");
        return enumNames.toArray(new String[enumNames.size()]);
    }
    
    public static String storySegment_EnumToString(final int n) {
        return mapEnumToString(n, "dramaman.runtime.DramaManagerConstants", "eStorySegment");
    }
    
    public static int storySegment_StringToEnum(final String s) {
        return mapStringToEnum(s, "dramaman.runtime.DramaManagerConstants");
    }
    
    public static String[] storySegment_GetEnumArray() {
        final List enumNames = getEnumNames("dramaman.runtime.DramaManagerConstants", "eStorySegment");
        return enumNames.toArray(new String[enumNames.size()]);
    }
    
    public static String daParam1_EnumToString(final int n) {
        if (n == -1) {
            return "eDAMiscParam_NOPARAM";
        }
        final String mapEnumToString;
        if ((mapEnumToString = mapEnumToString(n, "facade.util.DAType", "eDAExpressParam")) != null) {
            return mapEnumToString;
        }
        final String mapEnumToString2;
        if ((mapEnumToString2 = mapEnumToString(n, "facade.util.DAType", "eDACriticizeParam")) != null) {
            return mapEnumToString2;
        }
        final String mapEnumToString3;
        if ((mapEnumToString3 = mapEnumToString(n, "facade.util.DAType", "eDAStoryTopicParam")) != null) {
            return mapEnumToString3;
        }
        final String mapEnumToString4;
        if ((mapEnumToString4 = mapEnumToString(n, "facade.util.DAType", "eDASatelliteTopicParam")) != null) {
            return mapEnumToString4;
        }
        final String mapEnumToString5;
        if ((mapEnumToString5 = mapEnumToString(n, "facade.util.DAType", "eDACharParam")) != null) {
            return mapEnumToString5;
        }
        final String mapEnumToString6;
        if ((mapEnumToString6 = mapEnumToString(n, "facade.util.DAType", "eDAObjectParam")) != null) {
            return mapEnumToString6;
        }
        final String mapEnumToString7;
        if ((mapEnumToString7 = mapEnumToString(n, "facade.util.DAType", "eDAMiscParam")) != null) {
            return mapEnumToString7;
        }
        final String mapEnumToString8;
        if ((mapEnumToString8 = mapEnumToString(n, "facade.util.DAType", "eDABeatRefParam")) != null) {
            return mapEnumToString8;
        }
        return mapEnumToString(n, "facade.util.DAType", "eDACustomParam");
    }
    
    public static int daParam1_StringToEnum(final String s) {
        return mapStringToEnum(s, "facade.util.DAType");
    }
    
    public static String[] daParam1_GetEnumArray() {
        final Vector<Object> vector = (Vector<Object>)new Vector<String>();
        vector.add("eDAMiscParam_NOPARAM");
        vector.addAll(getEnumNames("facade.util.DAType", "eDAExpressParam"));
        vector.addAll(getEnumNames("facade.util.DAType", "eDACriticizeParam"));
        vector.addAll(getEnumNames("facade.util.DAType", "eDAStoryTopicParam"));
        vector.addAll(getEnumNames("facade.util.DAType", "eDASatelliteTopicParam"));
        vector.addAll(getEnumNames("facade.util.DAType", "eDABeatRefParam"));
        vector.addAll(getEnumNames("facade.util.DAType", "eDACharParam"));
        vector.addAll(getEnumNames("facade.util.DAType", "eDAObjectParam"));
        vector.addAll(getEnumNames("facade.util.DAType", "eDAMiscParam"));
        vector.addAll(getEnumNames("facade.util.DAType", "eDACustomParam"));
        return vector.toArray(new String[vector.size()]);
    }
    
    public static String[] daParam1_GetEnumArray(final String s) {
        final Vector<Object> vector = (Vector<Object>)new Vector<String>();
        vector.add("eDAMiscParam_NOPARAM");
        vector.addAll(getEnumNames("facade.util.DAType", s));
        return vector.toArray(new String[vector.size()]);
    }
    
    public static String daParam2_EnumToString(final int n) {
        if (n == -1) {
            return "eDAMiscParam_NOPARAM";
        }
        final String mapEnumToString;
        if ((mapEnumToString = mapEnumToString(n, "facade.util.DAType", "eDAExpressParam")) != null) {
            return mapEnumToString;
        }
        final String mapEnumToString2;
        if ((mapEnumToString2 = mapEnumToString(n, "facade.util.DAType", "eDACriticizeParam")) != null) {
            return mapEnumToString2;
        }
        final String mapEnumToString3;
        if ((mapEnumToString3 = mapEnumToString(n, "facade.util.DAType", "eDAStoryTopicParam")) != null) {
            return mapEnumToString3;
        }
        final String mapEnumToString4;
        if ((mapEnumToString4 = mapEnumToString(n, "facade.util.DAType", "eDASatelliteTopicParam")) != null) {
            return mapEnumToString4;
        }
        final String mapEnumToString5;
        if ((mapEnumToString5 = mapEnumToString(n, "facade.util.DAType", "eDACharParam")) != null) {
            return mapEnumToString5;
        }
        final String mapEnumToString6;
        if ((mapEnumToString6 = mapEnumToString(n, "facade.util.DAType", "eDAObjectParam")) != null) {
            return mapEnumToString6;
        }
        final String mapEnumToString7;
        if ((mapEnumToString7 = mapEnumToString(n, "facade.util.DAType", "eDAMiscParam")) != null) {
            return mapEnumToString7;
        }
        final String mapEnumToString8;
        if ((mapEnumToString8 = mapEnumToString(n, "facade.util.DAType", "eDABeatRefParam")) != null) {
            return mapEnumToString8;
        }
        final String mapEnumToString9;
        if ((mapEnumToString9 = mapEnumToString(n, "facade.util.DAType", "eDAMiscKeywordParam")) != null) {
            return mapEnumToString9;
        }
        final String mapEnumToString10;
        if ((mapEnumToString10 = mapEnumToString(n, "facade.util.DAType", "eDAMiscWhatWhereParam")) != null) {
            return mapEnumToString10;
        }
        final String mapEnumToString11;
        if ((mapEnumToString11 = mapEnumToString(n, "facade.util.DAType", "eDrink")) != null) {
            return mapEnumToString11;
        }
        return mapEnumToString(n, "facade.util.DAType", "eDACustomParam");
    }
    
    public static int daParam2_StringToEnum(final String s) {
        return mapStringToEnum(s, "facade.util.DAType");
    }
    
    public static String[] daParam2_GetEnumArray() {
        final Vector<Object> vector = (Vector<Object>)new Vector<String>();
        vector.add("eDAMiscParam_NOPARAM");
        vector.addAll(getEnumNames("facade.util.DAType", "eDAExpressParam"));
        vector.addAll(getEnumNames("facade.util.DAType", "eDACriticizeParam"));
        vector.addAll(getEnumNames("facade.util.DAType", "eDAStoryTopicParam"));
        vector.addAll(getEnumNames("facade.util.DAType", "eDASatelliteTopicParam"));
        vector.addAll(getEnumNames("facade.util.DAType", "eDABeatRefParam"));
        vector.addAll(getEnumNames("facade.util.DAType", "eDACharParam"));
        vector.addAll(getEnumNames("facade.util.DAType", "eDAObjectParam"));
        vector.addAll(getEnumNames("facade.util.DAType", "eDAMiscParam"));
        vector.addAll(getEnumNames("facade.util.DAType", "eDACustomParam"));
        vector.addAll(getEnumNames("facade.util.DAType", "eDAMiscKeywordParam"));
        vector.addAll(getEnumNames("facade.util.DAType", "eDAMiscWhatWhereParam"));
        vector.addAll(getEnumNames("facade.util.DAType", "eDrink"));
        return vector.toArray(new String[vector.size()]);
    }
    
    public static String[] daParam2_GetEnumArray(final String s) {
        final Vector<Object> vector = (Vector<Object>)new Vector<String>();
        vector.add("eDAMiscParam_NOPARAM");
        vector.addAll(getEnumNames("facade.util.DAType", s));
        return vector.toArray(new String[vector.size()]);
    }
    
    public static String daParam3_EnumToString(final int n) {
        if (n == -1) {
            return "eDAMiscParam_NOPARAM";
        }
        final String mapEnumToString;
        if ((mapEnumToString = mapEnumToString(n, "facade.util.DAType", "eDAExpressParam")) != null) {
            return mapEnumToString;
        }
        final String mapEnumToString2;
        if ((mapEnumToString2 = mapEnumToString(n, "facade.util.DAType", "eDACriticizeParam")) != null) {
            return mapEnumToString2;
        }
        final String mapEnumToString3;
        if ((mapEnumToString3 = mapEnumToString(n, "facade.util.DAType", "eDAStoryTopicParam")) != null) {
            return mapEnumToString3;
        }
        final String mapEnumToString4;
        if ((mapEnumToString4 = mapEnumToString(n, "facade.util.DAType", "eDASatelliteTopicParam")) != null) {
            return mapEnumToString4;
        }
        final String mapEnumToString5;
        if ((mapEnumToString5 = mapEnumToString(n, "facade.util.DAType", "eDACharParam")) != null) {
            return mapEnumToString5;
        }
        final String mapEnumToString6;
        if ((mapEnumToString6 = mapEnumToString(n, "facade.util.DAType", "eDAObjectParam")) != null) {
            return mapEnumToString6;
        }
        final String mapEnumToString7;
        if ((mapEnumToString7 = mapEnumToString(n, "facade.util.DAType", "eDAMiscParam")) != null) {
            return mapEnumToString7;
        }
        final String mapEnumToString8;
        if ((mapEnumToString8 = mapEnumToString(n, "facade.util.DAType", "eDABeatRefParam")) != null) {
            return mapEnumToString8;
        }
        final String mapEnumToString9;
        if ((mapEnumToString9 = mapEnumToString(n, "facade.util.DAType", "eDAMiscKeywordParam")) != null) {
            return mapEnumToString9;
        }
        final String mapEnumToString10;
        if ((mapEnumToString10 = mapEnumToString(n, "facade.util.DAType", "eDAMiscWhatWhereParam")) != null) {
            return mapEnumToString10;
        }
        final String mapEnumToString11;
        if ((mapEnumToString11 = mapEnumToString(n, "facade.util.DAType", "eDrink")) != null) {
            return mapEnumToString11;
        }
        return mapEnumToString(n, "facade.util.DAType", "eDACustomParam");
    }
    
    public static int daParam3_StringToEnum(final String s) {
        return mapStringToEnum(s, "facade.util.DAType");
    }
    
    public static String[] daParam3_GetEnumArray() {
        final Vector<Object> vector = (Vector<Object>)new Vector<String>();
        vector.add("eDAMiscParam_NOPARAM");
        vector.addAll(getEnumNames("facade.util.DAType", "eDAExpressParam"));
        vector.addAll(getEnumNames("facade.util.DAType", "eDACriticizeParam"));
        vector.addAll(getEnumNames("facade.util.DAType", "eDAStoryTopicParam"));
        vector.addAll(getEnumNames("facade.util.DAType", "eDASatelliteTopicParam"));
        vector.addAll(getEnumNames("facade.util.DAType", "eDABeatRefParam"));
        vector.addAll(getEnumNames("facade.util.DAType", "eDACharParam"));
        vector.addAll(getEnumNames("facade.util.DAType", "eDAObjectParam"));
        vector.addAll(getEnumNames("facade.util.DAType", "eDAMiscParam"));
        vector.addAll(getEnumNames("facade.util.DAType", "eDACustomParam"));
        vector.addAll(getEnumNames("facade.util.DAType", "eDAMiscKeywordParam"));
        vector.addAll(getEnumNames("facade.util.DAType", "eDAMiscWhatWhereParam"));
        vector.addAll(getEnumNames("facade.util.DAType", "eDrink"));
        return vector.toArray(new String[vector.size()]);
    }
    
    public static String[] daParam3_GetEnumArray(final String s) {
        final Vector<Object> vector = (Vector<Object>)new Vector<String>();
        vector.add("eDAMiscParam_NOPARAM");
        vector.addAll(getEnumNames("facade.util.DAType", s));
        return vector.toArray(new String[vector.size()]);
    }
    
    public static String beatArgument_txn_EnumToString(final int n) {
        return mapEnumToString(n, "facade.util.BeatArguments", "eBeatArgument_txn");
    }
    
    public static int beatArgument_txn_StringToEnum(final String s) {
        return mapStringToEnum(s, "facade.util.BeatArguments");
    }
    
    public static String[] beatArgument_txn_GetEnumArray() {
        final List enumNames = getEnumNames("facade.util.BeatArguments", "eBeatArgument_txn");
        return enumNames.toArray(new String[enumNames.size()]);
    }
    
    public static String animLayer_EnumToString(final int n) {
        return mapEnumToString(n, "facade.util.AnimLayer", "eAnimLayer");
    }
    
    public static int animLayer_StringToEnum(final String s) {
        return mapStringToEnum(s, "facade.util.AnimLayer");
    }
    
    public static String[] animLayer_GetEnumArray() {
        final List enumNames = getEnumNames("facade.util.AnimLayer", "eAnimLayer");
        return enumNames.toArray(new String[enumNames.size()]);
    }
    
    public static String rxnType_EnumToString(final int n) {
        return mapEnumToString(n, "facade.util.ReactionID", "eDARxnType");
    }
    
    public static int rxnType_StringToEnum(final String s) {
        return mapStringToEnum(s, "facade.util.ReactionID");
    }
    
    public static String[] rxnType_GetEnumArray() {
        final List enumNames = getEnumNames("facade.util.ReactionID", "eDARxnType");
        return enumNames.toArray(new String[enumNames.size()]);
    }
    
    public static String rxnCategory_EnumToString(final int n) {
        return mapEnumToString(n, "facade.util.ReactionID", "eRxnCategory");
    }
    
    public static int rxnCategory_StringToEnum(final String s) {
        return mapStringToEnum(s, "facade.util.ReactionID");
    }
    
    public static String[] rxnCategory_GetEnumArray() {
        final List enumNames = getEnumNames("facade.util.ReactionID", "eRxnCategory");
        return enumNames.toArray(new String[enumNames.size()]);
    }
    
    public static String rxnParam_EnumToString(final int n) {
        return mapEnumToString(n, "facade.util.ReactionID", "eRxnParam");
    }
    
    public static int rxnParam_StringToEnum(final String s) {
        return mapStringToEnum(s, "facade.util.ReactionID");
    }
    
    public static String[] rxnParam_GetEnumArray() {
        final List enumNames = getEnumNames("facade.util.ReactionID", "eRxnParam");
        return enumNames.toArray(new String[enumNames.size()]);
    }
    
    public static String txnOut_EnumToString(final int n) {
        return mapEnumToString(n, "facade.util.ReactionID", "eTxnOut");
    }
    
    public static int txnOut_StringToEnum(final String s) {
        return mapStringToEnum(s, "facade.util.ReactionID");
    }
    
    public static String[] txnOut_GetEnumArray() {
        final List enumNames = getEnumNames("facade.util.ReactionID", "eTxnOut");
        return enumNames.toArray(new String[enumNames.size()]);
    }
    
    public static String responseAttitude_EnumToString(final int n) {
        return mapEnumToString(n, "facade.util.ReactionID", "eResponseAttitude");
    }
    
    public static int responseAttitude_StringToEnum(final String s) {
        return mapStringToEnum(s, "facade.util.ReactionID");
    }
    
    public static String[] responseAttitude_GetEnumArray() {
        final List enumNames = getEnumNames("facade.util.ReactionID", "eResponseAttitude");
        return enumNames.toArray(new String[enumNames.size()]);
    }
    
    public static String patternID_EnumToString(final int n) {
        return mapEnumToString(n, "facade.util.ReactionID", "ePatternID");
    }
    
    public static int patternID_StringToEnum(final String s) {
        return mapStringToEnum(s, "facade.util.ReactionID");
    }
    
    public static String[] patternID_GetEnumArray() {
        final List enumNames = getEnumNames("facade.util.ReactionID", "ePatternID");
        return enumNames.toArray(new String[enumNames.size()]);
    }
    
    public static String playerGesture_EnumToString(final int n) {
        return mapEnumToString(n, "facade.util.PlayerGestureID", "ePlayerGesture");
    }
    
    public static int playerGesture_StringToEnum(final String s) {
        return mapStringToEnum(s, "facade.util.PlayerGestureID");
    }
    
    public static String[] playerGesture_GetEnumArray() {
        final List enumNames = getEnumNames("facade.util.PlayerGestureID", "ePlayerGesture");
        return enumNames.toArray(new String[enumNames.size()]);
    }
    
    public static String therapyGameCharFocus_EnumToString(final int n) {
        return mapEnumToString(n, "facade.util.TherapyGameConstants", "eTherapyGame_charFocus");
    }
    
    public static int therapyGameCharFocus_StringToEnum(final String s) {
        return mapStringToEnum(s, "facade.util.TherapyGameConstants");
    }
    
    public static String[] therapyGameCharFocus_GetEnumArray() {
        final List enumNames = getEnumNames("facade.util.TherapyGameConstants", "eTherapyGame_charFocus");
        return enumNames.toArray(new String[enumNames.size()]);
    }
    
    public static String tripScript_EnumToString(final int n) {
        final String mapEnumToStringViaTable = mapEnumToStringViaTable(n, "facade.util.TripScript");
        if (mapEnumToStringViaTable != null) {
            return mapEnumToStringViaTable.substring(PrintUtilities.tripScriptTrim);
        }
        return "ERROR: UNKNOWN TRIP SCRIPT " + n;
    }
    
    public static String graceScript_EnumToString(final int n) {
        final String mapEnumToStringViaTable = mapEnumToStringViaTable(n, "facade.util.GraceScript");
        if (mapEnumToStringViaTable != null) {
            return mapEnumToStringViaTable.substring(PrintUtilities.graceScriptTrim);
        }
        return "ERROR: UNKNOWN GRACE SCRIPT " + n;
    }
    
    public static String dialogScript_EnumToString(final int n, final int n2) {
        if (n2 == -1) {
            return "";
        }
        if (n == 1) {
            return tripScript_EnumToString(n2);
        }
        if (n == 0) {
            return graceScript_EnumToString(n2);
        }
        return "";
    }
    
    static {
        tripScriptTable = new Hashtable(8000);
        graceScriptTable = new Hashtable(8000);
        try {
            final Field[] fields = Class.forName("facade.util.TripScript").getFields();
            for (int i = 0; i < fields.length; ++i) {
                final String name = fields[i].getName();
                if (!isMarkerEnum(name)) {
                    PrintUtilities.tripScriptTable.put(new Integer(fields[i].getInt(null)), name);
                }
            }
        }
        catch (Exception ex) {
            StringUtil.println("Exception: " + ex + " in PrintUtilities.initTripScriptTable (static block)");
        }
        try {
            final Field[] fields2 = Class.forName("facade.util.GraceScript").getFields();
            for (int j = 0; j < fields2.length; ++j) {
                final String name2 = fields2[j].getName();
                if (!isMarkerEnum(name2)) {
                    PrintUtilities.graceScriptTable.put(new Integer(fields2[j].getInt(null)), name2);
                }
            }
        }
        catch (Exception ex2) {
            StringUtil.println("Exception: " + ex2 + " in PrintUtilities.initTripScriptTable (static block)");
        }
        tripScriptTrim = "etripScript_dialog_".length();
        graceScriptTrim = "egraceScript_dialog_".length();
    }
}
