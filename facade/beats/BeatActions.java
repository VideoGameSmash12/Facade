package facade.beats;

import facade.characters.wmedef.BeatRevelationsP2WME;
import java.util.LinkedList;
import dramaman.runtime.DramaManager;
import dramaman.runtime.StoryStatusWME;
import facade.characters.wmedef.DAWME;
import wm.WME;
import facade.characters.wmedef.BeatArgumentWME;
import wm.WorkingMemory;
import dramaman.runtime.BeatStartWME;
import dramaman.runtime.StoryMemory;
import scope.VariableScopeThrowsErrors;
import scope.VariableScope;
import facade.util.TherapyGameConstants;
import facade.util.BeatArguments;
import facade.util.DAType;
import dramaman.runtime.DramaManagerConstants;
import facade.util.BeatID;

public class BeatActions implements BeatID, DramaManagerConstants, DAType, BeatArguments, TherapyGameConstants
{
    public static void _ExplDatAnniv_T1_initAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ExplDatAnniv_T1_initAction_scope");
        variableScopeThrowsErrors.getVariable("unhandledAct").value = null;
        ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType")).i = 0;
        variableScopeThrowsErrors.getVariable("lastBeatStart").value = ((StoryMemory)variableScopeThrowsErrors.getVariable("storyMemory").value).findPrev("dramaman.runtime.BeatStartWME", System.currentTimeMillis());
        if (variableScopeThrowsErrors.getVariable("lastBeatStart").value == null) {
            variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value = null;
        }
        else {
            variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value = ((StoryMemory)variableScopeThrowsErrors.getVariable("storyMemory").value).findPrev("dramaman.runtime.BeatStartWME", ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp());
        }
    }
    
    public static void _ExplDatAnniv_T1_selectAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ExplDatAnniv_T1_selectAction_scope");
        ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).deleteAllWMEClass("BeatArgumentWME");
        ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).addWME(new BeatArgumentWME(((VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType")).i));
    }
    
    public static void _ExplDatAnniv_T1_succeedAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ExplDatAnniv_T1_succeedAction_scope");
        if (variableScopeThrowsErrors.getVariable("unhandledAct").value != null) {
            ((DAWME)variableScopeThrowsErrors.getVariable("unhandledAct").value).setHandledStatus(2);
        }
    }
    
    public static void _PhoneCall_NGPA_T1_initAction(final VariableScope variableScope) {
        ((VariableScope.IntValue)new VariableScopeThrowsErrors(variableScope, "_PhoneCall_NGPA_T1_initAction_scope").getValue("txnInType")).i = 0;
    }
    
    public static void _PhoneCall_NGPA_T1_selectAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_PhoneCall_NGPA_T1_selectAction_scope");
        ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).deleteAllWMEClass("BeatArgumentWME");
        ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).addWME(new BeatArgumentWME(((VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType")).i));
    }
    
    public static void _PhoneCall_NTPA_T1_initAction(final VariableScope variableScope) {
        ((VariableScope.IntValue)new VariableScopeThrowsErrors(variableScope, "_PhoneCall_NTPA_T1_initAction_scope").getValue("txnInType")).i = 0;
    }
    
    public static void _PhoneCall_NTPA_T1_selectAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_PhoneCall_NTPA_T1_selectAction_scope");
        ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).deleteAllWMEClass("BeatArgumentWME");
        ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).addWME(new BeatArgumentWME(((VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType")).i));
    }
    
    public static void _ArtistAdvertising_N_T1_initAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_N_T1_initAction_scope");
        variableScopeThrowsErrors.getVariable("unhandledAct").value = null;
        ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType")).i = 0;
        ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason")).i = 0;
        ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("subtopic")).i = -1;
        variableScopeThrowsErrors.getVariable("lastBeatStart").value = ((StoryMemory)variableScopeThrowsErrors.getVariable("storyMemory").value).findPrev("dramaman.runtime.BeatStartWME", System.currentTimeMillis());
        if (variableScopeThrowsErrors.getVariable("lastBeatStart").value == null) {
            variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value = null;
        }
        else {
            variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value = ((StoryMemory)variableScopeThrowsErrors.getVariable("storyMemory").value).findPrev("dramaman.runtime.BeatStartWME", ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp());
        }
    }
    
    public static void _ArtistAdvertising_N_T1_selectAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_N_T1_selectAction_scope");
        ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).deleteAllWMEClass("BeatArgumentWME");
        if (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason")).i == 0) {
            ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).addWME(new BeatArgumentWME(((VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType")).i, -1, -1, false, ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("subtopic")).i));
        }
        else if (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason")).i == 2 || ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason")).i == 1) {
            ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).addWME(new BeatArgumentWME(3));
        }
        ((StoryStatusWME)variableScopeThrowsErrors.getVariable("storyStatusWME").value).setStoryTopicBeatCount(((StoryStatusWME)variableScopeThrowsErrors.getVariable("storyStatusWME").value).getStoryTopicBeatCount() + 1);
    }
    
    public static void _ArtistAdvertising_N_T1_succeedAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_N_T1_succeedAction_scope");
        if (variableScopeThrowsErrors.getVariable("unhandledAct").value != null) {
            ((DAWME)variableScopeThrowsErrors.getVariable("unhandledAct").value).setHandledStatus(2);
        }
    }
    
    public static void _ArtistAdvertising_GPA_T1_initAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_GPA_T1_initAction_scope");
        variableScopeThrowsErrors.getVariable("unhandledAct").value = null;
        ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType")).i = 0;
        ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason")).i = 0;
        ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("subtopic")).i = -1;
        variableScopeThrowsErrors.getVariable("lastBeatStart").value = ((StoryMemory)variableScopeThrowsErrors.getVariable("storyMemory").value).findPrev("dramaman.runtime.BeatStartWME", System.currentTimeMillis());
        if (variableScopeThrowsErrors.getVariable("lastBeatStart").value == null) {
            variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value = null;
        }
        else {
            variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value = ((StoryMemory)variableScopeThrowsErrors.getVariable("storyMemory").value).findPrev("dramaman.runtime.BeatStartWME", ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp());
        }
    }
    
    public static void _ArtistAdvertising_GPA_T1_selectAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_GPA_T1_selectAction_scope");
        ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).deleteAllWMEClass("BeatArgumentWME");
        if (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason")).i == 0) {
            ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).addWME(new BeatArgumentWME(((VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType")).i, -1, -1, false, ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("subtopic")).i));
        }
        else if (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason")).i == 1) {
            ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).addWME(new BeatArgumentWME(3));
        }
        ((StoryStatusWME)variableScopeThrowsErrors.getVariable("storyStatusWME").value).setStoryTopicBeatCount(((StoryStatusWME)variableScopeThrowsErrors.getVariable("storyStatusWME").value).getStoryTopicBeatCount() + 1);
    }
    
    public static void _ArtistAdvertising_GPA_T1_succeedAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_GPA_T1_succeedAction_scope");
        if (variableScopeThrowsErrors.getVariable("unhandledAct").value != null) {
            ((DAWME)variableScopeThrowsErrors.getVariable("unhandledAct").value).setHandledStatus(2);
        }
    }
    
    public static void _ArtistAdvertising_TPA_T1_initAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_TPA_T1_initAction_scope");
        variableScopeThrowsErrors.getVariable("unhandledAct").value = null;
        ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType")).i = 0;
        ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason")).i = 0;
        ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("subtopic")).i = -1;
        variableScopeThrowsErrors.getVariable("lastBeatStart").value = ((StoryMemory)variableScopeThrowsErrors.getVariable("storyMemory").value).findPrev("dramaman.runtime.BeatStartWME", System.currentTimeMillis());
        if (variableScopeThrowsErrors.getVariable("lastBeatStart").value == null) {
            variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value = null;
        }
        else {
            variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value = ((StoryMemory)variableScopeThrowsErrors.getVariable("storyMemory").value).findPrev("dramaman.runtime.BeatStartWME", ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp());
        }
    }
    
    public static void _ArtistAdvertising_TPA_T1_selectAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_TPA_T1_selectAction_scope");
        ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).deleteAllWMEClass("BeatArgumentWME");
        if (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason")).i == 0) {
            ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).addWME(new BeatArgumentWME(((VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType")).i, -1, -1, false, ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("subtopic")).i));
        }
        else if (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason")).i == 2) {
            ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).addWME(new BeatArgumentWME(3));
        }
        ((StoryStatusWME)variableScopeThrowsErrors.getVariable("storyStatusWME").value).setStoryTopicBeatCount(((StoryStatusWME)variableScopeThrowsErrors.getVariable("storyStatusWME").value).getStoryTopicBeatCount() + 1);
    }
    
    public static void _ArtistAdvertising_TPA_T1_succeedAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_TPA_T1_succeedAction_scope");
        if (variableScopeThrowsErrors.getVariable("unhandledAct").value != null) {
            ((DAWME)variableScopeThrowsErrors.getVariable("unhandledAct").value).setHandledStatus(2);
        }
    }
    
    public static void _RockyMarriage_N_T1_initAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_RockyMarriage_N_T1_initAction_scope");
        variableScopeThrowsErrors.getVariable("unhandledAct").value = null;
        ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType")).i = 0;
        ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason")).i = 0;
        variableScopeThrowsErrors.getVariable("lastBeatStart").value = ((StoryMemory)variableScopeThrowsErrors.getVariable("storyMemory").value).findPrev("dramaman.runtime.BeatStartWME", System.currentTimeMillis());
        if (variableScopeThrowsErrors.getVariable("lastBeatStart").value == null) {
            variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value = null;
        }
        else {
            variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value = ((StoryMemory)variableScopeThrowsErrors.getVariable("storyMemory").value).findPrev("dramaman.runtime.BeatStartWME", ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp());
        }
    }
    
    public static void _RockyMarriage_N_T1_selectAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_RockyMarriage_N_T1_selectAction_scope");
        ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).deleteAllWMEClass("BeatArgumentWME");
        if (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason")).i == 0) {
            ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).addWME(new BeatArgumentWME(((VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType")).i));
        }
        ((StoryStatusWME)variableScopeThrowsErrors.getVariable("storyStatusWME").value).setStoryTopicBeatCount(((StoryStatusWME)variableScopeThrowsErrors.getVariable("storyStatusWME").value).getStoryTopicBeatCount() + 1);
    }
    
    public static void _RockyMarriage_N_T1_succeedAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_RockyMarriage_N_T1_succeedAction_scope");
        if (variableScopeThrowsErrors.getVariable("unhandledAct").value != null) {
            ((DAWME)variableScopeThrowsErrors.getVariable("unhandledAct").value).setHandledStatus(2);
        }
    }
    
    public static void _RockyMarriage_GPA_T1_initAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_RockyMarriage_GPA_T1_initAction_scope");
        variableScopeThrowsErrors.getVariable("unhandledAct").value = null;
        ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType")).i = 0;
        ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason")).i = 0;
        variableScopeThrowsErrors.getVariable("lastBeatStart").value = ((StoryMemory)variableScopeThrowsErrors.getVariable("storyMemory").value).findPrev("dramaman.runtime.BeatStartWME", System.currentTimeMillis());
        if (variableScopeThrowsErrors.getVariable("lastBeatStart").value == null) {
            variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value = null;
        }
        else {
            variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value = ((StoryMemory)variableScopeThrowsErrors.getVariable("storyMemory").value).findPrev("dramaman.runtime.BeatStartWME", ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp());
        }
    }
    
    public static void _RockyMarriage_GPA_T1_selectAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_RockyMarriage_GPA_T1_selectAction_scope");
        ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).deleteAllWMEClass("BeatArgumentWME");
        if (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason")).i == 0) {
            ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).addWME(new BeatArgumentWME(((VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType")).i));
        }
        ((StoryStatusWME)variableScopeThrowsErrors.getVariable("storyStatusWME").value).setStoryTopicBeatCount(((StoryStatusWME)variableScopeThrowsErrors.getVariable("storyStatusWME").value).getStoryTopicBeatCount() + 1);
    }
    
    public static void _RockyMarriage_GPA_T1_succeedAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_RockyMarriage_GPA_T1_succeedAction_scope");
        if (variableScopeThrowsErrors.getVariable("unhandledAct").value != null) {
            ((DAWME)variableScopeThrowsErrors.getVariable("unhandledAct").value).setHandledStatus(2);
        }
    }
    
    public static void _RockyMarriage_TPA_T1_initAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_RockyMarriage_TPA_T1_initAction_scope");
        variableScopeThrowsErrors.getVariable("unhandledAct").value = null;
        ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType")).i = 0;
        ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason")).i = 0;
        variableScopeThrowsErrors.getVariable("lastBeatStart").value = ((StoryMemory)variableScopeThrowsErrors.getVariable("storyMemory").value).findPrev("dramaman.runtime.BeatStartWME", System.currentTimeMillis());
        if (variableScopeThrowsErrors.getVariable("lastBeatStart").value == null) {
            variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value = null;
        }
        else {
            variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value = ((StoryMemory)variableScopeThrowsErrors.getVariable("storyMemory").value).findPrev("dramaman.runtime.BeatStartWME", ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp());
        }
    }
    
    public static void _RockyMarriage_TPA_T1_selectAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_RockyMarriage_TPA_T1_selectAction_scope");
        ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).deleteAllWMEClass("BeatArgumentWME");
        if (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason")).i == 0) {
            ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).addWME(new BeatArgumentWME(((VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType")).i));
        }
        ((StoryStatusWME)variableScopeThrowsErrors.getVariable("storyStatusWME").value).setStoryTopicBeatCount(((StoryStatusWME)variableScopeThrowsErrors.getVariable("storyStatusWME").value).getStoryTopicBeatCount() + 1);
    }
    
    public static void _RockyMarriage_TPA_T1_succeedAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_RockyMarriage_TPA_T1_succeedAction_scope");
        if (variableScopeThrowsErrors.getVariable("unhandledAct").value != null) {
            ((DAWME)variableScopeThrowsErrors.getVariable("unhandledAct").value).setHandledStatus(2);
        }
    }
    
    public static void _Facade_NTPA_T1_initAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_Facade_NTPA_T1_initAction_scope");
        variableScopeThrowsErrors.getVariable("unhandledAct").value = null;
        ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType")).i = 0;
        ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason")).i = 0;
        variableScopeThrowsErrors.getVariable("lastBeatStart").value = ((StoryMemory)variableScopeThrowsErrors.getVariable("storyMemory").value).findPrev("dramaman.runtime.BeatStartWME", System.currentTimeMillis());
        if (variableScopeThrowsErrors.getVariable("lastBeatStart").value == null) {
            variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value = null;
        }
        else {
            variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value = ((StoryMemory)variableScopeThrowsErrors.getVariable("storyMemory").value).findPrev("dramaman.runtime.BeatStartWME", ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp());
        }
    }
    
    public static void _Facade_NTPA_T1_selectAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_Facade_NTPA_T1_selectAction_scope");
        ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).deleteAllWMEClass("BeatArgumentWME");
        if (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason")).i == 0) {
            ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).addWME(new BeatArgumentWME(((VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType")).i));
        }
        else if (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason")).i == 2) {
            ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).addWME(new BeatArgumentWME(3));
        }
        ((StoryStatusWME)variableScopeThrowsErrors.getVariable("storyStatusWME").value).setStoryTopicBeatCount(((StoryStatusWME)variableScopeThrowsErrors.getVariable("storyStatusWME").value).getStoryTopicBeatCount() + 1);
    }
    
    public static void _Facade_NTPA_T1_succeedAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_Facade_NTPA_T1_succeedAction_scope");
        if (variableScopeThrowsErrors.getVariable("unhandledAct").value != null) {
            ((DAWME)variableScopeThrowsErrors.getVariable("unhandledAct").value).setHandledStatus(2);
        }
    }
    
    public static void _Facade_GPA_T1_initAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_Facade_GPA_T1_initAction_scope");
        variableScopeThrowsErrors.getVariable("unhandledAct").value = null;
        ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType")).i = 0;
        ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason")).i = 0;
        variableScopeThrowsErrors.getVariable("lastBeatStart").value = ((StoryMemory)variableScopeThrowsErrors.getVariable("storyMemory").value).findPrev("dramaman.runtime.BeatStartWME", System.currentTimeMillis());
        if (variableScopeThrowsErrors.getVariable("lastBeatStart").value == null) {
            variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value = null;
        }
        else {
            variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value = ((StoryMemory)variableScopeThrowsErrors.getVariable("storyMemory").value).findPrev("dramaman.runtime.BeatStartWME", ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp());
        }
    }
    
    public static void _Facade_GPA_T1_selectAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_Facade_GPA_T1_selectAction_scope");
        ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).deleteAllWMEClass("BeatArgumentWME");
        if (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason")).i == 0) {
            ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).addWME(new BeatArgumentWME(((VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType")).i));
        }
        ((StoryStatusWME)variableScopeThrowsErrors.getVariable("storyStatusWME").value).setStoryTopicBeatCount(((StoryStatusWME)variableScopeThrowsErrors.getVariable("storyStatusWME").value).getStoryTopicBeatCount() + 1);
    }
    
    public static void _Facade_GPA_T1_succeedAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_Facade_GPA_T1_succeedAction_scope");
        if (variableScopeThrowsErrors.getVariable("unhandledAct").value != null) {
            ((DAWME)variableScopeThrowsErrors.getVariable("unhandledAct").value).setHandledStatus(2);
        }
    }
    
    public static void _TxnT1ToT2NGPA_selectAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_TxnT1ToT2NGPA_selectAction_scope");
        WorkingMemory.deleteAllWMEClass("BeatMemory", "BeatArgumentWME");
        WorkingMemory.addWME("BeatMemory", new BeatArgumentWME(0));
    }
    
    public static void _TxnT1ToT2TPA_selectAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_TxnT1ToT2TPA_selectAction_scope");
        WorkingMemory.deleteAllWMEClass("BeatMemory", "BeatArgumentWME");
        WorkingMemory.addWME("BeatMemory", new BeatArgumentWME(0));
    }
    
    public static void _OneOnOneGAffChr_T2_initAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_OneOnOneGAffChr_T2_initAction_scope");
        variableScopeThrowsErrors.getVariable("unhandledAct").value = null;
        ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType")).i = 0;
        variableScopeThrowsErrors.getVariable("lastBeatStart").value = ((StoryMemory)variableScopeThrowsErrors.getVariable("storyMemory").value).findPrev("dramaman.runtime.BeatStartWME", System.currentTimeMillis());
    }
    
    public static void _OneOnOneGAffChr_T2_selectAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_OneOnOneGAffChr_T2_selectAction_scope");
        ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).deleteAllWMEClass("BeatArgumentWME");
        ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).addWME(new BeatArgumentWME(((VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType")).i));
    }
    
    public static void _OneOnOneGAffChr_T2_succeedAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_OneOnOneGAffChr_T2_succeedAction_scope");
        if (variableScopeThrowsErrors.getVariable("unhandledAct").value != null) {
            ((DAWME)variableScopeThrowsErrors.getVariable("unhandledAct").value).setHandledStatus(2);
        }
    }
    
    public static void _OneOnOneTAffChr_T2_initAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_OneOnOneTAffChr_T2_initAction_scope");
        variableScopeThrowsErrors.getVariable("unhandledAct").value = null;
        ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType")).i = 0;
        variableScopeThrowsErrors.getVariable("lastBeatStart").value = ((StoryMemory)variableScopeThrowsErrors.getVariable("storyMemory").value).findPrev("dramaman.runtime.BeatStartWME", System.currentTimeMillis());
    }
    
    public static void _OneOnOneTAffChr_T2_selectAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_OneOnOneTAffChr_T2_selectAction_scope");
        ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).deleteAllWMEClass("BeatArgumentWME");
        ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).addWME(new BeatArgumentWME(((VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType")).i));
    }
    
    public static void _OneOnOneTAffChr_T2_succeedAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_OneOnOneTAffChr_T2_succeedAction_scope");
        if (variableScopeThrowsErrors.getVariable("unhandledAct").value != null) {
            ((DAWME)variableScopeThrowsErrors.getVariable("unhandledAct").value).setHandledStatus(2);
        }
    }
    
    public static void _NonAffChrGReturns_T2_initAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_NonAffChrGReturns_T2_initAction_scope");
        variableScopeThrowsErrors.getVariable("unhandledAct").value = null;
        ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType")).i = 0;
        ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason")).i = 0;
        variableScopeThrowsErrors.getVariable("lastBeatStart").value = ((StoryMemory)variableScopeThrowsErrors.getVariable("storyMemory").value).findPrev("dramaman.runtime.BeatStartWME", System.currentTimeMillis());
    }
    
    public static void _NonAffChrGReturns_T2_selectAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_NonAffChrGReturns_T2_selectAction_scope");
        ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).deleteAllWMEClass("BeatArgumentWME");
        ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).addWME(new BeatArgumentWME(((VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType")).i));
    }
    
    public static void _NonAffChrGReturns_T2_succeedAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_NonAffChrGReturns_T2_succeedAction_scope");
        if (variableScopeThrowsErrors.getVariable("unhandledAct").value != null) {
            ((DAWME)variableScopeThrowsErrors.getVariable("unhandledAct").value).setHandledStatus(2);
        }
    }
    
    public static void _NonAffChrTReturns_T2_initAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_NonAffChrTReturns_T2_initAction_scope");
        variableScopeThrowsErrors.getVariable("unhandledAct").value = null;
        ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType")).i = 0;
        ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason")).i = 0;
        variableScopeThrowsErrors.getVariable("lastBeatStart").value = ((StoryMemory)variableScopeThrowsErrors.getVariable("storyMemory").value).findPrev("dramaman.runtime.BeatStartWME", System.currentTimeMillis());
    }
    
    public static void _NonAffChrTReturns_T2_selectAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_NonAffChrTReturns_T2_selectAction_scope");
        ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).deleteAllWMEClass("BeatArgumentWME");
        ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).addWME(new BeatArgumentWME(((VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType")).i));
    }
    
    public static void _NonAffChrTReturns_T2_succeedAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_NonAffChrTReturns_T2_succeedAction_scope");
        if (variableScopeThrowsErrors.getVariable("unhandledAct").value != null) {
            ((DAWME)variableScopeThrowsErrors.getVariable("unhandledAct").value).setHandledStatus(2);
        }
    }
    
    public static void _OneOnOneGNonAffChr_T2_initAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_OneOnOneGNonAffChr_T2_initAction_scope");
        variableScopeThrowsErrors.getVariable("unhandledAct").value = null;
        ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType")).i = 0;
        ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason")).i = 0;
        variableScopeThrowsErrors.getVariable("lastBeatStart").value = ((StoryMemory)variableScopeThrowsErrors.getVariable("storyMemory").value).findPrev("dramaman.runtime.BeatStartWME", System.currentTimeMillis());
    }
    
    public static void _OneOnOneGNonAffChr_T2_selectAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_OneOnOneGNonAffChr_T2_selectAction_scope");
        ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).deleteAllWMEClass("BeatArgumentWME");
        ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).addWME(new BeatArgumentWME(((VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType")).i));
    }
    
    public static void _OneOnOneGNonAffChr_T2_succeedAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_OneOnOneGNonAffChr_T2_succeedAction_scope");
        if (variableScopeThrowsErrors.getVariable("unhandledAct").value != null) {
            ((DAWME)variableScopeThrowsErrors.getVariable("unhandledAct").value).setHandledStatus(2);
        }
    }
    
    public static void _OneOnOneTNonAffChr_T2_initAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_OneOnOneTNonAffChr_T2_initAction_scope");
        variableScopeThrowsErrors.getVariable("unhandledAct").value = null;
        ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType")).i = 0;
        ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason")).i = 0;
        variableScopeThrowsErrors.getVariable("lastBeatStart").value = ((StoryMemory)variableScopeThrowsErrors.getVariable("storyMemory").value).findPrev("dramaman.runtime.BeatStartWME", System.currentTimeMillis());
    }
    
    public static void _OneOnOneTNonAffChr_T2_selectAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_OneOnOneTNonAffChr_T2_selectAction_scope");
        ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).deleteAllWMEClass("BeatArgumentWME");
        ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).addWME(new BeatArgumentWME(((VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType")).i));
    }
    
    public static void _OneOnOneTNonAffChr_T2_succeedAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_OneOnOneTNonAffChr_T2_succeedAction_scope");
        if (variableScopeThrowsErrors.getVariable("unhandledAct").value != null) {
            ((DAWME)variableScopeThrowsErrors.getVariable("unhandledAct").value).setHandledStatus(2);
        }
    }
    
    public static void _ArtistAdvertising_GPA_T2_initAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_GPA_T2_initAction_scope");
        variableScopeThrowsErrors.getVariable("unhandledAct").value = null;
        ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType")).i = 0;
        ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason")).i = 0;
        ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("subtopic")).i = -1;
        variableScopeThrowsErrors.getVariable("lastBeatStart").value = ((StoryMemory)variableScopeThrowsErrors.getVariable("storyMemory").value).findPrev("dramaman.runtime.BeatStartWME", System.currentTimeMillis());
        if (variableScopeThrowsErrors.getVariable("lastBeatStart").value == null) {
            variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value = null;
        }
        else {
            variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value = ((StoryMemory)variableScopeThrowsErrors.getVariable("storyMemory").value).findPrev("dramaman.runtime.BeatStartWME", ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp());
        }
    }
    
    public static void _ArtistAdvertising_GPA_T2_selectAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_GPA_T2_selectAction_scope");
        ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).deleteAllWMEClass("BeatArgumentWME");
        if (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason")).i == 0) {
            ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).addWME(new BeatArgumentWME(((VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType")).i, -1, -1, false, ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("subtopic")).i));
        }
        else if (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason")).i == 1) {
            ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).addWME(new BeatArgumentWME(3));
        }
        ((StoryStatusWME)variableScopeThrowsErrors.getVariable("storyStatusWME").value).setStoryTopicBeatCount(((StoryStatusWME)variableScopeThrowsErrors.getVariable("storyStatusWME").value).getStoryTopicBeatCount() + 1);
    }
    
    public static void _ArtistAdvertising_GPA_T2_succeedAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_GPA_T2_succeedAction_scope");
        if (variableScopeThrowsErrors.getVariable("unhandledAct").value != null) {
            ((DAWME)variableScopeThrowsErrors.getVariable("unhandledAct").value).setHandledStatus(2);
        }
    }
    
    public static void _ArtistAdvertising_GPA_T2ToT3_initAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_GPA_T2ToT3_initAction_scope");
        variableScopeThrowsErrors.getVariable("unhandledAct").value = null;
        ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType")).i = 0;
        ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason")).i = 0;
        ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("subtopic")).i = -1;
        variableScopeThrowsErrors.getVariable("lastBeatStart").value = ((StoryMemory)variableScopeThrowsErrors.getVariable("storyMemory").value).findPrev("dramaman.runtime.BeatStartWME", System.currentTimeMillis());
        if (variableScopeThrowsErrors.getVariable("lastBeatStart").value == null) {
            variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value = null;
        }
        else {
            variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value = ((StoryMemory)variableScopeThrowsErrors.getVariable("storyMemory").value).findPrev("dramaman.runtime.BeatStartWME", ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp());
        }
    }
    
    public static void _ArtistAdvertising_GPA_T2ToT3_selectAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_GPA_T2ToT3_selectAction_scope");
        ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).deleteAllWMEClass("BeatArgumentWME");
        if (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason")).i == 0) {
            ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).addWME(new BeatArgumentWME(0, 4, -1, false, ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("subtopic")).i));
        }
        else if (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason")).i == 1) {
            ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).addWME(new BeatArgumentWME(3, 4));
        }
        ((StoryStatusWME)variableScopeThrowsErrors.getVariable("storyStatusWME").value).setStoryTopicBeatCount(((StoryStatusWME)variableScopeThrowsErrors.getVariable("storyStatusWME").value).getStoryTopicBeatCount() + 1);
    }
    
    public static void _ArtistAdvertising_GPA_T2ToT3_succeedAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_GPA_T2ToT3_succeedAction_scope");
        if (variableScopeThrowsErrors.getVariable("unhandledAct").value != null) {
            ((DAWME)variableScopeThrowsErrors.getVariable("unhandledAct").value).setHandledStatus(2);
        }
    }
    
    public static void _ArtistAdvertising_TPA_T2_initAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_TPA_T2_initAction_scope");
        variableScopeThrowsErrors.getVariable("unhandledAct").value = null;
        ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType")).i = 0;
        ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason")).i = 0;
        ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("subtopic")).i = -1;
        variableScopeThrowsErrors.getVariable("lastBeatStart").value = ((StoryMemory)variableScopeThrowsErrors.getVariable("storyMemory").value).findPrev("dramaman.runtime.BeatStartWME", System.currentTimeMillis());
        if (variableScopeThrowsErrors.getVariable("lastBeatStart").value == null) {
            variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value = null;
        }
        else {
            variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value = ((StoryMemory)variableScopeThrowsErrors.getVariable("storyMemory").value).findPrev("dramaman.runtime.BeatStartWME", ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp());
        }
    }
    
    public static void _ArtistAdvertising_TPA_T2_selectAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_TPA_T2_selectAction_scope");
        ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).deleteAllWMEClass("BeatArgumentWME");
        if (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason")).i == 0) {
            ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).addWME(new BeatArgumentWME(((VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType")).i, -1, -1, false, ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("subtopic")).i));
        }
        else if (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason")).i == 2) {
            ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).addWME(new BeatArgumentWME(3));
        }
        ((StoryStatusWME)variableScopeThrowsErrors.getVariable("storyStatusWME").value).setStoryTopicBeatCount(((StoryStatusWME)variableScopeThrowsErrors.getVariable("storyStatusWME").value).getStoryTopicBeatCount() + 1);
    }
    
    public static void _ArtistAdvertising_TPA_T2_succeedAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_TPA_T2_succeedAction_scope");
        if (variableScopeThrowsErrors.getVariable("unhandledAct").value != null) {
            ((DAWME)variableScopeThrowsErrors.getVariable("unhandledAct").value).setHandledStatus(2);
        }
    }
    
    public static void _ArtistAdvertising_TPA_T2ToT3_initAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_TPA_T2ToT3_initAction_scope");
        variableScopeThrowsErrors.getVariable("unhandledAct").value = null;
        ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType")).i = 0;
        ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason")).i = 0;
        ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("subtopic")).i = -1;
        variableScopeThrowsErrors.getVariable("lastBeatStart").value = ((StoryMemory)variableScopeThrowsErrors.getVariable("storyMemory").value).findPrev("dramaman.runtime.BeatStartWME", System.currentTimeMillis());
        if (variableScopeThrowsErrors.getVariable("lastBeatStart").value == null) {
            variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value = null;
        }
        else {
            variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value = ((StoryMemory)variableScopeThrowsErrors.getVariable("storyMemory").value).findPrev("dramaman.runtime.BeatStartWME", ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp());
        }
    }
    
    public static void _ArtistAdvertising_TPA_T2ToT3_selectAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_TPA_T2ToT3_selectAction_scope");
        ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).deleteAllWMEClass("BeatArgumentWME");
        if (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason")).i == 0) {
            ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).addWME(new BeatArgumentWME(0, 4, -1, false, ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("subtopic")).i));
        }
        else if (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason")).i == 2) {
            ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).addWME(new BeatArgumentWME(3, 4));
        }
        ((StoryStatusWME)variableScopeThrowsErrors.getVariable("storyStatusWME").value).setStoryTopicBeatCount(((StoryStatusWME)variableScopeThrowsErrors.getVariable("storyStatusWME").value).getStoryTopicBeatCount() + 1);
    }
    
    public static void _ArtistAdvertising_TPA_T2ToT3_succeedAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_TPA_T2ToT3_succeedAction_scope");
        if (variableScopeThrowsErrors.getVariable("unhandledAct").value != null) {
            ((DAWME)variableScopeThrowsErrors.getVariable("unhandledAct").value).setHandledStatus(2);
        }
    }
    
    public static void _RockyMarriage_GPA_T2_initAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_RockyMarriage_GPA_T2_initAction_scope");
        variableScopeThrowsErrors.getVariable("unhandledAct").value = null;
        ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType")).i = 0;
        ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason")).i = 0;
        variableScopeThrowsErrors.getVariable("lastBeatStart").value = ((StoryMemory)variableScopeThrowsErrors.getVariable("storyMemory").value).findPrev("dramaman.runtime.BeatStartWME", System.currentTimeMillis());
        if (variableScopeThrowsErrors.getVariable("lastBeatStart").value == null) {
            variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value = null;
        }
        else {
            variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value = ((StoryMemory)variableScopeThrowsErrors.getVariable("storyMemory").value).findPrev("dramaman.runtime.BeatStartWME", ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp());
        }
    }
    
    public static void _RockyMarriage_GPA_T2_selectAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_RockyMarriage_GPA_T2_selectAction_scope");
        ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).deleteAllWMEClass("BeatArgumentWME");
        if (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason")).i == 0) {
            ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).addWME(new BeatArgumentWME(((VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType")).i));
        }
        ((StoryStatusWME)variableScopeThrowsErrors.getVariable("storyStatusWME").value).setStoryTopicBeatCount(((StoryStatusWME)variableScopeThrowsErrors.getVariable("storyStatusWME").value).getStoryTopicBeatCount() + 1);
    }
    
    public static void _RockyMarriage_GPA_T2_succeedAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_RockyMarriage_GPA_T2_succeedAction_scope");
        if (variableScopeThrowsErrors.getVariable("unhandledAct").value != null) {
            ((DAWME)variableScopeThrowsErrors.getVariable("unhandledAct").value).setHandledStatus(2);
        }
    }
    
    public static void _RockyMarriage_GPA_T2ToT3_initAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_RockyMarriage_GPA_T2ToT3_initAction_scope");
        variableScopeThrowsErrors.getVariable("unhandledAct").value = null;
        ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType")).i = 0;
        ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason")).i = 0;
        variableScopeThrowsErrors.getVariable("lastBeatStart").value = ((StoryMemory)variableScopeThrowsErrors.getVariable("storyMemory").value).findPrev("dramaman.runtime.BeatStartWME", System.currentTimeMillis());
        if (variableScopeThrowsErrors.getVariable("lastBeatStart").value == null) {
            variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value = null;
        }
        else {
            variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value = ((StoryMemory)variableScopeThrowsErrors.getVariable("storyMemory").value).findPrev("dramaman.runtime.BeatStartWME", ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp());
        }
    }
    
    public static void _RockyMarriage_GPA_T2ToT3_selectAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_RockyMarriage_GPA_T2ToT3_selectAction_scope");
        ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).deleteAllWMEClass("BeatArgumentWME");
        if (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason")).i == 0) {
            ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).addWME(new BeatArgumentWME(0, 4));
        }
        ((StoryStatusWME)variableScopeThrowsErrors.getVariable("storyStatusWME").value).setStoryTopicBeatCount(((StoryStatusWME)variableScopeThrowsErrors.getVariable("storyStatusWME").value).getStoryTopicBeatCount() + 1);
    }
    
    public static void _RockyMarriage_GPA_T2ToT3_succeedAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_RockyMarriage_GPA_T2ToT3_succeedAction_scope");
        if (variableScopeThrowsErrors.getVariable("unhandledAct").value != null) {
            ((DAWME)variableScopeThrowsErrors.getVariable("unhandledAct").value).setHandledStatus(2);
        }
    }
    
    public static void _RockyMarriage_TPA_T2_initAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_RockyMarriage_TPA_T2_initAction_scope");
        variableScopeThrowsErrors.getVariable("unhandledAct").value = null;
        ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType")).i = 0;
        ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason")).i = 0;
        variableScopeThrowsErrors.getVariable("lastBeatStart").value = ((StoryMemory)variableScopeThrowsErrors.getVariable("storyMemory").value).findPrev("dramaman.runtime.BeatStartWME", System.currentTimeMillis());
        if (variableScopeThrowsErrors.getVariable("lastBeatStart").value == null) {
            variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value = null;
        }
        else {
            variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value = ((StoryMemory)variableScopeThrowsErrors.getVariable("storyMemory").value).findPrev("dramaman.runtime.BeatStartWME", ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp());
        }
    }
    
    public static void _RockyMarriage_TPA_T2_selectAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_RockyMarriage_TPA_T2_selectAction_scope");
        ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).deleteAllWMEClass("BeatArgumentWME");
        if (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason")).i == 0) {
            ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).addWME(new BeatArgumentWME(((VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType")).i));
        }
        ((StoryStatusWME)variableScopeThrowsErrors.getVariable("storyStatusWME").value).setStoryTopicBeatCount(((StoryStatusWME)variableScopeThrowsErrors.getVariable("storyStatusWME").value).getStoryTopicBeatCount() + 1);
    }
    
    public static void _RockyMarriage_TPA_T2_succeedAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_RockyMarriage_TPA_T2_succeedAction_scope");
        if (variableScopeThrowsErrors.getVariable("unhandledAct").value != null) {
            ((DAWME)variableScopeThrowsErrors.getVariable("unhandledAct").value).setHandledStatus(2);
        }
    }
    
    public static void _RockyMarriage_TPA_T2ToT3_initAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_RockyMarriage_TPA_T2ToT3_initAction_scope");
        variableScopeThrowsErrors.getVariable("unhandledAct").value = null;
        ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType")).i = 0;
        ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason")).i = 0;
        variableScopeThrowsErrors.getVariable("lastBeatStart").value = ((StoryMemory)variableScopeThrowsErrors.getVariable("storyMemory").value).findPrev("dramaman.runtime.BeatStartWME", System.currentTimeMillis());
        if (variableScopeThrowsErrors.getVariable("lastBeatStart").value == null) {
            variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value = null;
        }
        else {
            variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value = ((StoryMemory)variableScopeThrowsErrors.getVariable("storyMemory").value).findPrev("dramaman.runtime.BeatStartWME", ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp());
        }
    }
    
    public static void _RockyMarriage_TPA_T2ToT3_selectAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_RockyMarriage_TPA_T2ToT3_selectAction_scope");
        ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).deleteAllWMEClass("BeatArgumentWME");
        if (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason")).i == 0) {
            ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).addWME(new BeatArgumentWME(0, 4));
        }
        ((StoryStatusWME)variableScopeThrowsErrors.getVariable("storyStatusWME").value).setStoryTopicBeatCount(((StoryStatusWME)variableScopeThrowsErrors.getVariable("storyStatusWME").value).getStoryTopicBeatCount() + 1);
    }
    
    public static void _RockyMarriage_TPA_T2ToT3_succeedAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_RockyMarriage_TPA_T2ToT3_succeedAction_scope");
        if (variableScopeThrowsErrors.getVariable("unhandledAct").value != null) {
            ((DAWME)variableScopeThrowsErrors.getVariable("unhandledAct").value).setHandledStatus(2);
        }
    }
    
    public static void _Facade_TPA_T2_initAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_Facade_TPA_T2_initAction_scope");
        variableScopeThrowsErrors.getVariable("unhandledAct").value = null;
        ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType")).i = 0;
        ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason")).i = 0;
        variableScopeThrowsErrors.getVariable("lastBeatStart").value = ((StoryMemory)variableScopeThrowsErrors.getVariable("storyMemory").value).findPrev("dramaman.runtime.BeatStartWME", System.currentTimeMillis());
        if (variableScopeThrowsErrors.getVariable("lastBeatStart").value == null) {
            variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value = null;
        }
        else {
            variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value = ((StoryMemory)variableScopeThrowsErrors.getVariable("storyMemory").value).findPrev("dramaman.runtime.BeatStartWME", ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp());
        }
    }
    
    public static void _Facade_TPA_T2_selectAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_Facade_TPA_T2_selectAction_scope");
        ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).deleteAllWMEClass("BeatArgumentWME");
        if (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason")).i == 0) {
            ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).addWME(new BeatArgumentWME(((VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType")).i));
        }
        ((StoryStatusWME)variableScopeThrowsErrors.getVariable("storyStatusWME").value).setStoryTopicBeatCount(((StoryStatusWME)variableScopeThrowsErrors.getVariable("storyStatusWME").value).getStoryTopicBeatCount() + 1);
    }
    
    public static void _Facade_TPA_T2_succeedAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_Facade_TPA_T2_succeedAction_scope");
        if (variableScopeThrowsErrors.getVariable("unhandledAct").value != null) {
            ((DAWME)variableScopeThrowsErrors.getVariable("unhandledAct").value).setHandledStatus(2);
        }
    }
    
    public static void _Facade_GPA_T2_initAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_Facade_GPA_T2_initAction_scope");
        variableScopeThrowsErrors.getVariable("unhandledAct").value = null;
        ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType")).i = 0;
        ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason")).i = 0;
        variableScopeThrowsErrors.getVariable("lastBeatStart").value = ((StoryMemory)variableScopeThrowsErrors.getVariable("storyMemory").value).findPrev("dramaman.runtime.BeatStartWME", System.currentTimeMillis());
        if (variableScopeThrowsErrors.getVariable("lastBeatStart").value == null) {
            variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value = null;
        }
        else {
            variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value = ((StoryMemory)variableScopeThrowsErrors.getVariable("storyMemory").value).findPrev("dramaman.runtime.BeatStartWME", ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp());
        }
    }
    
    public static void _Facade_GPA_T2_selectAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_Facade_GPA_T2_selectAction_scope");
        ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).deleteAllWMEClass("BeatArgumentWME");
        if (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason")).i == 0) {
            ((WorkingMemory)variableScopeThrowsErrors.getVariable("beatMemory").value).addWME(new BeatArgumentWME(((VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType")).i));
        }
        ((StoryStatusWME)variableScopeThrowsErrors.getVariable("storyStatusWME").value).setStoryTopicBeatCount(((StoryStatusWME)variableScopeThrowsErrors.getVariable("storyStatusWME").value).getStoryTopicBeatCount() + 1);
    }
    
    public static void _Facade_GPA_T2_succeedAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_Facade_GPA_T2_succeedAction_scope");
        if (variableScopeThrowsErrors.getVariable("unhandledAct").value != null) {
            ((DAWME)variableScopeThrowsErrors.getVariable("unhandledAct").value).setHandledStatus(2);
        }
    }
    
    public static void _TxnT2ToT3_selectAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_TxnT2ToT3_selectAction_scope");
        WorkingMemory.deleteAllWMEClass("BeatMemory", "BeatArgumentWME");
        WorkingMemory.addWME("BeatMemory", new BeatArgumentWME(0));
    }
    
    public static void _RomPrp_GPA_T2_selectAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_RomPrp_GPA_T2_selectAction_scope");
        WorkingMemory.deleteAllWMEClass("BeatMemory", "BeatArgumentWME");
        WorkingMemory.addWME("BeatMemory", new BeatArgumentWME(0));
    }
    
    public static void _CrisisP1_selectAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_CrisisP1_selectAction_scope");
        WorkingMemory.deleteAllWMEClass("BeatMemory", "BeatArgumentWME");
        WorkingMemory.addWME("BeatMemory", new BeatArgumentWME(0));
    }
    
    public static void _CrisisToTherapyGameGlue_P2_initAction(final VariableScope variableScope) {
        final VariableScope.Variable variable = new VariableScopeThrowsErrors(variableScope, "_CrisisToTherapyGameGlue_P2_initAction_scope").getVariable("lastBeatStart");
        DramaManager.getDramaManager();
        variable.value = DramaManager.getStoryMemory().findPrev("dramaman.runtime.BeatStartWME", System.currentTimeMillis());
    }
    
    public static void _CrisisToTherapyGameGlue_P2_selectAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_CrisisToTherapyGameGlue_P2_selectAction_scope");
        WorkingMemory.deleteAllWMEClass("BeatMemory", "BeatArgumentWME");
    }
    
    public static void _TherapyGame_P2_initAction(final VariableScope variableScope) {
        final VariableScope.Variable variable = new VariableScopeThrowsErrors(variableScope, "_TherapyGame_P2_initAction_scope").getVariable("lastBeatStart");
        DramaManager.getDramaManager();
        variable.value = DramaManager.getStoryMemory().findPrev("dramaman.runtime.BeatStartWME", System.currentTimeMillis());
    }
    
    public static void _TherapyGame_P2_selectAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_TherapyGame_P2_selectAction_scope");
        WorkingMemory.deleteAllWMEClass("BeatMemory", "BeatArgumentWME");
    }
    
    public static void _RevelationBuildup_P2_initAction(final VariableScope variableScope) {
        final VariableScope.Variable variable = new VariableScopeThrowsErrors(variableScope, "_RevelationBuildup_P2_initAction_scope").getVariable("lastBeatStart");
        DramaManager.getDramaManager();
        variable.value = DramaManager.getStoryMemory().findPrev("dramaman.runtime.BeatStartWME", System.currentTimeMillis());
    }
    
    public static void _RevelationBuildup_P2_selectAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_RevelationBuildup_P2_selectAction_scope");
        WorkingMemory.deleteAllWMEClass("BeatMemory", "BeatArgumentWME");
    }
    
    public static void _Revelations_P2_selectAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_Revelations_P2_selectAction_scope");
        WorkingMemory.deleteAllWMEClass("BeatMemory", "BeatArgumentWME");
    }
    
    public static void _EndingNoRevelations_selectAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_EndingNoRevelations_selectAction_scope");
        WorkingMemory.deleteAllWMEClass("BeatMemory", "BeatArgumentWME");
    }
    
    public static void _EndingSelfRevelationOnly_selectAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_EndingSelfRevelationOnly_selectAction_scope");
        WorkingMemory.deleteAllWMEClass("BeatMemory", "BeatArgumentWME");
    }
    
    public static void _EndingRelationshipRevelationOnly_selectAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_EndingRelationshipRevelationOnly_selectAction_scope");
        WorkingMemory.deleteAllWMEClass("BeatMemory", "BeatArgumentWME");
    }
    
    public static void _EndingSelfAndRelationshipNotGTR_initAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_EndingSelfAndRelationshipNotGTR_initAction_scope");
        variableScopeThrowsErrors.getVariable("wmeList").value = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME");
        if (((LinkedList)variableScopeThrowsErrors.getVariable("wmeList").value).size() == 1) {
            variableScopeThrowsErrors.getVariable("revWME").value = ((LinkedList)variableScopeThrowsErrors.getVariable("wmeList").value).get(0);
            ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("rev1Focus")).i = ((BeatRevelationsP2WME)variableScopeThrowsErrors.getVariable("revWME").value).getRev1CharFocus();
            ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("rev2Focus")).i = ((BeatRevelationsP2WME)variableScopeThrowsErrors.getVariable("revWME").value).getRev2CharFocus();
            ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("rev3Focus")).i = ((BeatRevelationsP2WME)variableScopeThrowsErrors.getVariable("revWME").value).getRev3CharFocus();
            if (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("rev1Focus")).i == 1 || ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("rev2Focus")).i == 1 || ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("rev3Focus")).i == 1) {
                ((VariableScope.BooleanValue)variableScopeThrowsErrors.getValue("tripRev")).b = true;
            }
            if (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("rev1Focus")).i == 0 || ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("rev2Focus")).i == 0 || ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("rev3Focus")).i == 0) {
                ((VariableScope.BooleanValue)variableScopeThrowsErrors.getValue("graceRev")).b = true;
            }
            if (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("rev1Focus")).i == 2 || ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("rev2Focus")).i == 2 || ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("rev3Focus")).i == 2) {
                ((VariableScope.BooleanValue)variableScopeThrowsErrors.getValue("relationshipRev")).b = true;
            }
        }
    }
    
    public static void _EndingSelfAndRelationshipNotGTR_selectAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_EndingSelfAndRelationshipNotGTR_selectAction_scope");
        WorkingMemory.deleteAllWMEClass("BeatMemory", "BeatArgumentWME");
    }
    
    public static void _EndingGTR_initAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_EndingGTR_initAction_scope");
        variableScopeThrowsErrors.getVariable("wmeList").value = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME");
        if (((LinkedList)variableScopeThrowsErrors.getVariable("wmeList").value).size() == 1) {
            variableScopeThrowsErrors.getVariable("revWME").value = ((LinkedList)variableScopeThrowsErrors.getVariable("wmeList").value).get(0);
            ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("rev1Focus")).i = ((BeatRevelationsP2WME)variableScopeThrowsErrors.getVariable("revWME").value).getRev1CharFocus();
            ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("rev2Focus")).i = ((BeatRevelationsP2WME)variableScopeThrowsErrors.getVariable("revWME").value).getRev2CharFocus();
            ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("rev3Focus")).i = ((BeatRevelationsP2WME)variableScopeThrowsErrors.getVariable("revWME").value).getRev3CharFocus();
            if (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("rev1Focus")).i == 1 || ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("rev2Focus")).i == 1 || ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("rev3Focus")).i == 1) {
                ((VariableScope.BooleanValue)variableScopeThrowsErrors.getValue("tripRev")).b = true;
            }
            if (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("rev1Focus")).i == 0 || ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("rev2Focus")).i == 0 || ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("rev3Focus")).i == 0) {
                ((VariableScope.BooleanValue)variableScopeThrowsErrors.getValue("graceRev")).b = true;
            }
            if (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("rev1Focus")).i == 2 || ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("rev2Focus")).i == 2 || ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("rev3Focus")).i == 2) {
                ((VariableScope.BooleanValue)variableScopeThrowsErrors.getValue("relationshipRev")).b = true;
            }
        }
    }
    
    public static void _EndingGTR_selectAction(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_EndingGTR_selectAction_scope");
        WorkingMemory.deleteAllWMEClass("BeatMemory", "BeatArgumentWME");
    }
}
