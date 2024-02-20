package facade.beats;

import wm.WorkingMemory;
import dramaman.runtime.DramaManager;
import scope.VariableScope;
import scope.VariableScopeThrowsErrors;
import dramaman.runtime.StoryEffect;
import dramaman.runtime.Beat;
import facade.util.TherapyGameConstants;
import facade.util.BeatArguments;
import facade.util.DAType;
import dramaman.runtime.DramaManagerConstants;
import facade.util.BeatID;

public class BeatFactories implements BeatID, DramaManagerConstants, DAType, BeatArguments, TherapyGameConstants
{
    public static Beat _PBehindDoor_T1_factory() {
        return new Beat(0, "PBehindDoor_T1", new StoryEffect[] { new StoryEffect("tension", 1.0f, true) }, 1.0f, Integer.MAX_VALUE, new String[] { "_PBehindDoor_T1_precondition1" }, new Beat.WeightTest[0], new Beat.PriorityTest[0], new VariableScopeThrowsErrors(null, "PBehindDoor_T1_scope"), null, null, null, null);
    }
    
    public static Beat _TGreetsP_T1_factory() {
        return new Beat(1, "TGreetsP_T1", new StoryEffect[] { new StoryEffect("tension", 1.0f, true) }, 1.0f, Integer.MAX_VALUE, new String[] { "_TGreetsP_T1_precondition1" }, new Beat.WeightTest[0], new Beat.PriorityTest[0], new VariableScopeThrowsErrors(null, "TGreetsP_T1_scope"), null, null, null, null);
    }
    
    public static Beat _TFetchesG_T1_factory() {
        return new Beat(2, "TFetchesG_T1", new StoryEffect[] { new StoryEffect("tension", 1.0f, true) }, 1.0f, Integer.MAX_VALUE, new String[] { "_TFetchesG_T1_precondition1" }, new Beat.WeightTest[0], new Beat.PriorityTest[0], new VariableScopeThrowsErrors(null, "TFetchesG_T1_scope"), null, null, null, null);
    }
    
    public static Beat _GGreetsP_T1_factory() {
        return new Beat(3, "GGreetsP_T1", new StoryEffect[] { new StoryEffect("tension", 1.0f, true) }, 1.0f, Integer.MAX_VALUE, new String[] { "_GGreetsP_T1_precondition1" }, new Beat.WeightTest[0], new Beat.PriorityTest[0], new VariableScopeThrowsErrors(null, "GGreetsP_T1_scope"), null, null, null, null);
    }
    
    public static Beat _ExplDatAnniv_T1_factory() {
        final StoryEffect[] array = { new StoryEffect("tension", 1.0f, true) };
        final String[] array2 = { "_ExplDatAnniv_T1_precondition1" };
        final Beat.WeightTest[] array3 = { new Beat.WeightTest("_ExplDatAnniv_T1_weighttest1", 2.0f) };
        final Beat.PriorityTest[] array4 = new Beat.PriorityTest[0];
        final VariableScopeThrowsErrors variableScopeThrowsErrors2;
        final VariableScopeThrowsErrors variableScopeThrowsErrors = variableScopeThrowsErrors2 = new VariableScopeThrowsErrors(null, "ExplDatAnniv_T1_scope");
        final String s = "storyMemory";
        DramaManager.getDramaManager();
        variableScopeThrowsErrors2.defineVariable(s, DramaManager.getStoryMemory(), "StoryMemory");
        variableScopeThrowsErrors.defineVariable("beatMemory", WorkingMemory.lookupRegisteredMemory("BeatMemory"), "WorkingMemory");
        variableScopeThrowsErrors.defineVariable("lastBeatStart", null, "BeatStartWME");
        variableScopeThrowsErrors.defineVariable("beatBeforeLastStart", null, "BeatStartWME");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        variableScopeThrowsErrors.defineVariable("txnInType", new VariableScope.IntValue(0), "int");
        return new Beat(4, "ExplDatAnniv_T1", array, 1.0f, 0, array2, array3, array4, variableScopeThrowsErrors, "_ExplDatAnniv_T1_initAction", "_ExplDatAnniv_T1_selectAction", "_ExplDatAnniv_T1_succeedAction", null);
    }
    
    public static Beat _PhoneCall_NGPA_T1_factory() {
        final StoryEffect[] array = { new StoryEffect("tension", 1.0f, true) };
        final String[] array2 = { "_PhoneCall_NGPA_T1_precondition1" };
        final Beat.WeightTest[] array3 = new Beat.WeightTest[0];
        final Beat.PriorityTest[] array4 = new Beat.PriorityTest[0];
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(null, "PhoneCall_NGPA_T1_scope");
        variableScopeThrowsErrors.defineVariable("beatMemory", WorkingMemory.lookupRegisteredMemory("BeatMemory"), "WorkingMemory");
        variableScopeThrowsErrors.defineVariable("txnInType", new VariableScope.IntValue(0), "int");
        return new Beat(5, "PhoneCall_NGPA_T1", array, 1.0f, 0, array2, array3, array4, variableScopeThrowsErrors, "_PhoneCall_NGPA_T1_initAction", "_PhoneCall_NGPA_T1_selectAction", null, null);
    }
    
    public static Beat _PhoneCall_NTPA_T1_factory() {
        final StoryEffect[] array = { new StoryEffect("tension", 1.0f, true) };
        final String[] array2 = { "_PhoneCall_NTPA_T1_precondition1" };
        final Beat.WeightTest[] array3 = new Beat.WeightTest[0];
        final Beat.PriorityTest[] array4 = new Beat.PriorityTest[0];
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(null, "PhoneCall_NTPA_T1_scope");
        variableScopeThrowsErrors.defineVariable("beatMemory", WorkingMemory.lookupRegisteredMemory("BeatMemory"), "WorkingMemory");
        variableScopeThrowsErrors.defineVariable("txnInType", new VariableScope.IntValue(0), "int");
        return new Beat(6, "PhoneCall_NTPA_T1", array, 1.0f, 0, array2, array3, array4, variableScopeThrowsErrors, "_PhoneCall_NTPA_T1_initAction", "_PhoneCall_NTPA_T1_selectAction", null, null);
    }
    
    public static Beat _ArtistAdvertising_N_T1_factory() {
        final StoryEffect[] array = { new StoryEffect("tension", 1.0f, true) };
        final String[] array2 = { "_ArtistAdvertising_N_T1_precondition1" };
        final Beat.WeightTest[] array3 = { new Beat.WeightTest("_ArtistAdvertising_N_T1_weighttest1", 3), new Beat.WeightTest("_ArtistAdvertising_N_T1_weighttest2", 2.999f) };
        final Beat.PriorityTest[] array4 = { new Beat.PriorityTest("_ArtistAdvertising_N_T1_prioritytest1", Integer.MAX_VALUE), new Beat.PriorityTest("_ArtistAdvertising_N_T1_prioritytest2", 10), new Beat.PriorityTest("_ArtistAdvertising_N_T1_prioritytest3", 9) };
        final VariableScopeThrowsErrors variableScopeThrowsErrors2;
        final VariableScopeThrowsErrors variableScopeThrowsErrors = variableScopeThrowsErrors2 = new VariableScopeThrowsErrors(null, "ArtistAdvertising_N_T1_scope");
        final String s = "storyMemory";
        DramaManager.getDramaManager();
        variableScopeThrowsErrors2.defineVariable(s, DramaManager.getStoryMemory(), "StoryMemory");
        variableScopeThrowsErrors.defineVariable("beatMemory", WorkingMemory.lookupRegisteredMemory("BeatMemory"), "WorkingMemory");
        variableScopeThrowsErrors.defineVariable("lastBeatStart", null, "BeatStartWME");
        variableScopeThrowsErrors.defineVariable("beatBeforeLastStart", null, "BeatStartWME");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        variableScopeThrowsErrors.defineVariable("txnInType", new VariableScope.IntValue(0), "int");
        variableScopeThrowsErrors.defineVariable("abortReason", new VariableScope.IntValue(0), "int");
        variableScopeThrowsErrors.defineVariable("storyStatusWME", null, "StoryStatusWME");
        variableScopeThrowsErrors.defineVariable("subtopic", new VariableScope.IntValue(-1), "int");
        return new Beat(11, "ArtistAdvertising_N_T1", array, 1.0f, 0, array2, array3, array4, variableScopeThrowsErrors, "_ArtistAdvertising_N_T1_initAction", "_ArtistAdvertising_N_T1_selectAction", "_ArtistAdvertising_N_T1_succeedAction", null);
    }
    
    public static Beat _ArtistAdvertising_GPA_T1_factory() {
        final StoryEffect[] array = { new StoryEffect("tension", 1.0f, true) };
        final String[] array2 = { "_ArtistAdvertising_GPA_T1_precondition1" };
        final Beat.WeightTest[] array3 = { new Beat.WeightTest("_ArtistAdvertising_GPA_T1_weighttest1", 3), new Beat.WeightTest("_ArtistAdvertising_GPA_T1_weighttest2", 2.999f) };
        final Beat.PriorityTest[] array4 = { new Beat.PriorityTest("_ArtistAdvertising_GPA_T1_prioritytest1", Integer.MAX_VALUE), new Beat.PriorityTest("_ArtistAdvertising_GPA_T1_prioritytest2", 10), new Beat.PriorityTest("_ArtistAdvertising_GPA_T1_prioritytest3", 9) };
        final VariableScopeThrowsErrors variableScopeThrowsErrors2;
        final VariableScopeThrowsErrors variableScopeThrowsErrors = variableScopeThrowsErrors2 = new VariableScopeThrowsErrors(null, "ArtistAdvertising_GPA_T1_scope");
        final String s = "storyMemory";
        DramaManager.getDramaManager();
        variableScopeThrowsErrors2.defineVariable(s, DramaManager.getStoryMemory(), "StoryMemory");
        variableScopeThrowsErrors.defineVariable("beatMemory", WorkingMemory.lookupRegisteredMemory("BeatMemory"), "WorkingMemory");
        variableScopeThrowsErrors.defineVariable("lastBeatStart", null, "BeatStartWME");
        variableScopeThrowsErrors.defineVariable("beatBeforeLastStart", null, "BeatStartWME");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        variableScopeThrowsErrors.defineVariable("txnInType", new VariableScope.IntValue(0), "int");
        variableScopeThrowsErrors.defineVariable("abortReason", new VariableScope.IntValue(0), "int");
        variableScopeThrowsErrors.defineVariable("storyStatusWME", null, "StoryStatusWME");
        variableScopeThrowsErrors.defineVariable("subtopic", new VariableScope.IntValue(-1), "int");
        return new Beat(9, "ArtistAdvertising_GPA_T1", array, 1.0f, 0, array2, array3, array4, variableScopeThrowsErrors, "_ArtistAdvertising_GPA_T1_initAction", "_ArtistAdvertising_GPA_T1_selectAction", "_ArtistAdvertising_GPA_T1_succeedAction", null);
    }
    
    public static Beat _ArtistAdvertising_TPA_T1_factory() {
        final StoryEffect[] array = { new StoryEffect("tension", 1.0f, true) };
        final String[] array2 = { "_ArtistAdvertising_TPA_T1_precondition1" };
        final Beat.WeightTest[] array3 = { new Beat.WeightTest("_ArtistAdvertising_TPA_T1_weighttest1", 3), new Beat.WeightTest("_ArtistAdvertising_TPA_T1_weighttest2", 2.999f) };
        final Beat.PriorityTest[] array4 = { new Beat.PriorityTest("_ArtistAdvertising_TPA_T1_prioritytest1", Integer.MAX_VALUE), new Beat.PriorityTest("_ArtistAdvertising_TPA_T1_prioritytest2", 10), new Beat.PriorityTest("_ArtistAdvertising_TPA_T1_prioritytest3", 9) };
        final VariableScopeThrowsErrors variableScopeThrowsErrors2;
        final VariableScopeThrowsErrors variableScopeThrowsErrors = variableScopeThrowsErrors2 = new VariableScopeThrowsErrors(null, "ArtistAdvertising_TPA_T1_scope");
        final String s = "storyMemory";
        DramaManager.getDramaManager();
        variableScopeThrowsErrors2.defineVariable(s, DramaManager.getStoryMemory(), "StoryMemory");
        variableScopeThrowsErrors.defineVariable("beatMemory", WorkingMemory.lookupRegisteredMemory("BeatMemory"), "WorkingMemory");
        variableScopeThrowsErrors.defineVariable("lastBeatStart", null, "BeatStartWME");
        variableScopeThrowsErrors.defineVariable("beatBeforeLastStart", null, "BeatStartWME");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        variableScopeThrowsErrors.defineVariable("txnInType", new VariableScope.IntValue(0), "int");
        variableScopeThrowsErrors.defineVariable("abortReason", new VariableScope.IntValue(0), "int");
        variableScopeThrowsErrors.defineVariable("storyStatusWME", null, "StoryStatusWME");
        variableScopeThrowsErrors.defineVariable("subtopic", new VariableScope.IntValue(-1), "int");
        return new Beat(10, "ArtistAdvertising_TPA_T1", array, 1.0f, 0, array2, array3, array4, variableScopeThrowsErrors, "_ArtistAdvertising_TPA_T1_initAction", "_ArtistAdvertising_TPA_T1_selectAction", "_ArtistAdvertising_TPA_T1_succeedAction", null);
    }
    
    public static Beat _RockyMarriage_N_T1_factory() {
        final StoryEffect[] array = { new StoryEffect("tension", 1.0f, true) };
        final String[] array2 = { "_RockyMarriage_N_T1_precondition1" };
        final Beat.WeightTest[] array3 = { new Beat.WeightTest("_RockyMarriage_N_T1_weighttest1", 3) };
        final Beat.PriorityTest[] array4 = { new Beat.PriorityTest("_RockyMarriage_N_T1_prioritytest1", 10) };
        final VariableScopeThrowsErrors variableScopeThrowsErrors2;
        final VariableScopeThrowsErrors variableScopeThrowsErrors = variableScopeThrowsErrors2 = new VariableScopeThrowsErrors(null, "RockyMarriage_N_T1_scope");
        final String s = "storyMemory";
        DramaManager.getDramaManager();
        variableScopeThrowsErrors2.defineVariable(s, DramaManager.getStoryMemory(), "StoryMemory");
        variableScopeThrowsErrors.defineVariable("beatMemory", WorkingMemory.lookupRegisteredMemory("BeatMemory"), "WorkingMemory");
        variableScopeThrowsErrors.defineVariable("lastBeatStart", null, "BeatStartWME");
        variableScopeThrowsErrors.defineVariable("beatBeforeLastStart", null, "BeatStartWME");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        variableScopeThrowsErrors.defineVariable("txnInType", new VariableScope.IntValue(0), "int");
        variableScopeThrowsErrors.defineVariable("abortReason", new VariableScope.IntValue(0), "int");
        variableScopeThrowsErrors.defineVariable("storyStatusWME", null, "StoryStatusWME");
        return new Beat(16, "RockyMarriage_N_T1", array, 1.0f, 0, array2, array3, array4, variableScopeThrowsErrors, "_RockyMarriage_N_T1_initAction", "_RockyMarriage_N_T1_selectAction", "_RockyMarriage_N_T1_succeedAction", null);
    }
    
    public static Beat _RockyMarriage_GPA_T1_factory() {
        final StoryEffect[] array = { new StoryEffect("tension", 1.0f, true) };
        final String[] array2 = { "_RockyMarriage_GPA_T1_precondition1" };
        final Beat.WeightTest[] array3 = { new Beat.WeightTest("_RockyMarriage_GPA_T1_weighttest1", 3) };
        final Beat.PriorityTest[] array4 = { new Beat.PriorityTest("_RockyMarriage_GPA_T1_prioritytest1", 10) };
        final VariableScopeThrowsErrors variableScopeThrowsErrors2;
        final VariableScopeThrowsErrors variableScopeThrowsErrors = variableScopeThrowsErrors2 = new VariableScopeThrowsErrors(null, "RockyMarriage_GPA_T1_scope");
        final String s = "storyMemory";
        DramaManager.getDramaManager();
        variableScopeThrowsErrors2.defineVariable(s, DramaManager.getStoryMemory(), "StoryMemory");
        variableScopeThrowsErrors.defineVariable("beatMemory", WorkingMemory.lookupRegisteredMemory("BeatMemory"), "WorkingMemory");
        variableScopeThrowsErrors.defineVariable("lastBeatStart", null, "BeatStartWME");
        variableScopeThrowsErrors.defineVariable("beatBeforeLastStart", null, "BeatStartWME");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        variableScopeThrowsErrors.defineVariable("txnInType", new VariableScope.IntValue(0), "int");
        variableScopeThrowsErrors.defineVariable("abortReason", new VariableScope.IntValue(0), "int");
        variableScopeThrowsErrors.defineVariable("storyStatusWME", null, "StoryStatusWME");
        return new Beat(14, "RockyMarriage_GPA_T1", array, 1.0f, 0, array2, array3, array4, variableScopeThrowsErrors, "_RockyMarriage_GPA_T1_initAction", "_RockyMarriage_GPA_T1_selectAction", "_RockyMarriage_GPA_T1_succeedAction", null);
    }
    
    public static Beat _RockyMarriage_TPA_T1_factory() {
        final StoryEffect[] array = { new StoryEffect("tension", 1.0f, true) };
        final String[] array2 = { "_RockyMarriage_TPA_T1_precondition1" };
        final Beat.WeightTest[] array3 = { new Beat.WeightTest("_RockyMarriage_TPA_T1_weighttest1", 3) };
        final Beat.PriorityTest[] array4 = { new Beat.PriorityTest("_RockyMarriage_TPA_T1_prioritytest1", 10) };
        final VariableScopeThrowsErrors variableScopeThrowsErrors2;
        final VariableScopeThrowsErrors variableScopeThrowsErrors = variableScopeThrowsErrors2 = new VariableScopeThrowsErrors(null, "RockyMarriage_TPA_T1_scope");
        final String s = "storyMemory";
        DramaManager.getDramaManager();
        variableScopeThrowsErrors2.defineVariable(s, DramaManager.getStoryMemory(), "StoryMemory");
        variableScopeThrowsErrors.defineVariable("beatMemory", WorkingMemory.lookupRegisteredMemory("BeatMemory"), "WorkingMemory");
        variableScopeThrowsErrors.defineVariable("lastBeatStart", null, "BeatStartWME");
        variableScopeThrowsErrors.defineVariable("beatBeforeLastStart", null, "BeatStartWME");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        variableScopeThrowsErrors.defineVariable("txnInType", new VariableScope.IntValue(0), "int");
        variableScopeThrowsErrors.defineVariable("abortReason", new VariableScope.IntValue(0), "int");
        variableScopeThrowsErrors.defineVariable("storyStatusWME", null, "StoryStatusWME");
        return new Beat(15, "RockyMarriage_TPA_T1", array, 1.0f, 0, array2, array3, array4, variableScopeThrowsErrors, "_RockyMarriage_TPA_T1_initAction", "_RockyMarriage_TPA_T1_selectAction", "_RockyMarriage_TPA_T1_succeedAction", null);
    }
    
    public static Beat _Facade_NTPA_T1_factory() {
        final StoryEffect[] array = { new StoryEffect("tension", 1.0f, true) };
        final String[] array2 = { "_Facade_NTPA_T1_precondition1" };
        final Beat.WeightTest[] array3 = { new Beat.WeightTest("_Facade_NTPA_T1_weighttest1", 3) };
        final Beat.PriorityTest[] array4 = { new Beat.PriorityTest("_Facade_NTPA_T1_prioritytest1", 10) };
        final VariableScopeThrowsErrors variableScopeThrowsErrors2;
        final VariableScopeThrowsErrors variableScopeThrowsErrors = variableScopeThrowsErrors2 = new VariableScopeThrowsErrors(null, "Facade_NTPA_T1_scope");
        final String s = "storyMemory";
        DramaManager.getDramaManager();
        variableScopeThrowsErrors2.defineVariable(s, DramaManager.getStoryMemory(), "StoryMemory");
        variableScopeThrowsErrors.defineVariable("beatMemory", WorkingMemory.lookupRegisteredMemory("BeatMemory"), "WorkingMemory");
        variableScopeThrowsErrors.defineVariable("lastBeatStart", null, "BeatStartWME");
        variableScopeThrowsErrors.defineVariable("beatBeforeLastStart", null, "BeatStartWME");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        variableScopeThrowsErrors.defineVariable("txnInType", new VariableScope.IntValue(0), "int");
        variableScopeThrowsErrors.defineVariable("abortReason", new VariableScope.IntValue(0), "int");
        variableScopeThrowsErrors.defineVariable("storyStatusWME", null, "StoryStatusWME");
        return new Beat(13, "Facade_NTPA_T1", array, 1.0f, 0, array2, array3, array4, variableScopeThrowsErrors, "_Facade_NTPA_T1_initAction", "_Facade_NTPA_T1_selectAction", "_Facade_NTPA_T1_succeedAction", null);
    }
    
    public static Beat _Facade_GPA_T1_factory() {
        final StoryEffect[] array = { new StoryEffect("tension", 1.0f, true) };
        final String[] array2 = { "_Facade_GPA_T1_precondition1" };
        final Beat.WeightTest[] array3 = { new Beat.WeightTest("_Facade_GPA_T1_weighttest1", 3) };
        final Beat.PriorityTest[] array4 = { new Beat.PriorityTest("_Facade_GPA_T1_prioritytest1", 10) };
        final VariableScopeThrowsErrors variableScopeThrowsErrors2;
        final VariableScopeThrowsErrors variableScopeThrowsErrors = variableScopeThrowsErrors2 = new VariableScopeThrowsErrors(null, "Facade_GPA_T1_scope");
        final String s = "storyMemory";
        DramaManager.getDramaManager();
        variableScopeThrowsErrors2.defineVariable(s, DramaManager.getStoryMemory(), "StoryMemory");
        variableScopeThrowsErrors.defineVariable("beatMemory", WorkingMemory.lookupRegisteredMemory("BeatMemory"), "WorkingMemory");
        variableScopeThrowsErrors.defineVariable("lastBeatStart", null, "BeatStartWME");
        variableScopeThrowsErrors.defineVariable("beatBeforeLastStart", null, "BeatStartWME");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        variableScopeThrowsErrors.defineVariable("txnInType", new VariableScope.IntValue(0), "int");
        variableScopeThrowsErrors.defineVariable("abortReason", new VariableScope.IntValue(0), "int");
        variableScopeThrowsErrors.defineVariable("storyStatusWME", null, "StoryStatusWME");
        return new Beat(12, "Facade_GPA_T1", array, 1.0f, 0, array2, array3, array4, variableScopeThrowsErrors, "_Facade_GPA_T1_initAction", "_Facade_GPA_T1_selectAction", "_Facade_GPA_T1_succeedAction", null);
    }
    
    public static Beat _TxnT1ToT2NGPA_factory() {
        return new Beat(7, "TxnT1ToT2NGPA", new StoryEffect[] { new StoryEffect("tension", 2.0f, true) }, 1.0f, -1, new String[] { "_TxnT1ToT2NGPA_precondition1" }, new Beat.WeightTest[0], new Beat.PriorityTest[] { new Beat.PriorityTest("_TxnT1ToT2NGPA_prioritytest1", 0) }, new VariableScopeThrowsErrors(null, "TxnT1ToT2NGPA_scope"), null, "_TxnT1ToT2NGPA_selectAction", null, null);
    }
    
    public static Beat _TxnT1ToT2TPA_factory() {
        return new Beat(8, "TxnT1ToT2TPA", new StoryEffect[] { new StoryEffect("tension", 2.0f, true) }, 1.0f, -1, new String[] { "_TxnT1ToT2TPA_precondition1" }, new Beat.WeightTest[0], new Beat.PriorityTest[] { new Beat.PriorityTest("_TxnT1ToT2TPA_prioritytest1", 0) }, new VariableScopeThrowsErrors(null, "TxnT1ToT2TPA_scope"), null, "_TxnT1ToT2TPA_selectAction", null, null);
    }
    
    public static Beat _OneOnOneGAffChr_T2_factory() {
        final StoryEffect[] array = { new StoryEffect("tension", 2.0f, true) };
        final String[] array2 = { "_OneOnOneGAffChr_T2_precondition1" };
        final Beat.WeightTest[] array3 = new Beat.WeightTest[0];
        final Beat.PriorityTest[] array4 = new Beat.PriorityTest[0];
        final VariableScopeThrowsErrors variableScopeThrowsErrors2;
        final VariableScopeThrowsErrors variableScopeThrowsErrors = variableScopeThrowsErrors2 = new VariableScopeThrowsErrors(null, "OneOnOneGAffChr_T2_scope");
        final String s = "storyMemory";
        DramaManager.getDramaManager();
        variableScopeThrowsErrors2.defineVariable(s, DramaManager.getStoryMemory(), "StoryMemory");
        variableScopeThrowsErrors.defineVariable("beatMemory", WorkingMemory.lookupRegisteredMemory("BeatMemory"), "WorkingMemory");
        variableScopeThrowsErrors.defineVariable("lastBeatStart", null, "BeatStartWME");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        variableScopeThrowsErrors.defineVariable("txnInType", new VariableScope.IntValue(0), "int");
        return new Beat(23, "OneOnOneGAffChr_T2", array, 1.0f, Integer.MAX_VALUE, array2, array3, array4, variableScopeThrowsErrors, "_OneOnOneGAffChr_T2_initAction", "_OneOnOneGAffChr_T2_selectAction", "_OneOnOneGAffChr_T2_succeedAction", null);
    }
    
    public static Beat _OneOnOneTAffChr_T2_factory() {
        final StoryEffect[] array = { new StoryEffect("tension", 2.0f, true) };
        final String[] array2 = { "_OneOnOneTAffChr_T2_precondition1" };
        final Beat.WeightTest[] array3 = new Beat.WeightTest[0];
        final Beat.PriorityTest[] array4 = new Beat.PriorityTest[0];
        final VariableScopeThrowsErrors variableScopeThrowsErrors2;
        final VariableScopeThrowsErrors variableScopeThrowsErrors = variableScopeThrowsErrors2 = new VariableScopeThrowsErrors(null, "OneOnOneTAffChr_T2_scope");
        final String s = "storyMemory";
        DramaManager.getDramaManager();
        variableScopeThrowsErrors2.defineVariable(s, DramaManager.getStoryMemory(), "StoryMemory");
        variableScopeThrowsErrors.defineVariable("beatMemory", WorkingMemory.lookupRegisteredMemory("BeatMemory"), "WorkingMemory");
        variableScopeThrowsErrors.defineVariable("lastBeatStart", null, "BeatStartWME");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        variableScopeThrowsErrors.defineVariable("txnInType", new VariableScope.IntValue(0), "int");
        return new Beat(24, "OneOnOneTAffChr_T2", array, 1.0f, Integer.MAX_VALUE, array2, array3, array4, variableScopeThrowsErrors, "_OneOnOneTAffChr_T2_initAction", "_OneOnOneTAffChr_T2_selectAction", "_OneOnOneTAffChr_T2_succeedAction", null);
    }
    
    public static Beat _NonAffChrGReturns_T2_factory() {
        final StoryEffect[] array = { new StoryEffect("tension", 2.0f, true) };
        final String[] array2 = { "_NonAffChrGReturns_T2_precondition1" };
        final Beat.WeightTest[] array3 = new Beat.WeightTest[0];
        final Beat.PriorityTest[] array4 = new Beat.PriorityTest[0];
        final VariableScopeThrowsErrors variableScopeThrowsErrors2;
        final VariableScopeThrowsErrors variableScopeThrowsErrors = variableScopeThrowsErrors2 = new VariableScopeThrowsErrors(null, "NonAffChrGReturns_T2_scope");
        final String s = "storyMemory";
        DramaManager.getDramaManager();
        variableScopeThrowsErrors2.defineVariable(s, DramaManager.getStoryMemory(), "StoryMemory");
        variableScopeThrowsErrors.defineVariable("beatMemory", WorkingMemory.lookupRegisteredMemory("BeatMemory"), "WorkingMemory");
        variableScopeThrowsErrors.defineVariable("lastBeatStart", null, "BeatStartWME");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        variableScopeThrowsErrors.defineVariable("txnInType", new VariableScope.IntValue(0), "int");
        variableScopeThrowsErrors.defineVariable("abortReason", new VariableScope.IntValue(0), "int");
        return new Beat(27, "NonAffChrGReturns_T2", array, 1.0f, Integer.MAX_VALUE, array2, array3, array4, variableScopeThrowsErrors, "_NonAffChrGReturns_T2_initAction", "_NonAffChrGReturns_T2_selectAction", "_NonAffChrGReturns_T2_succeedAction", null);
    }
    
    public static Beat _NonAffChrTReturns_T2_factory() {
        final StoryEffect[] array = { new StoryEffect("tension", 2.0f, true) };
        final String[] array2 = { "_NonAffChrTReturns_T2_precondition1" };
        final Beat.WeightTest[] array3 = new Beat.WeightTest[0];
        final Beat.PriorityTest[] array4 = new Beat.PriorityTest[0];
        final VariableScopeThrowsErrors variableScopeThrowsErrors2;
        final VariableScopeThrowsErrors variableScopeThrowsErrors = variableScopeThrowsErrors2 = new VariableScopeThrowsErrors(null, "NonAffChrTReturns_T2_scope");
        final String s = "storyMemory";
        DramaManager.getDramaManager();
        variableScopeThrowsErrors2.defineVariable(s, DramaManager.getStoryMemory(), "StoryMemory");
        variableScopeThrowsErrors.defineVariable("beatMemory", WorkingMemory.lookupRegisteredMemory("BeatMemory"), "WorkingMemory");
        variableScopeThrowsErrors.defineVariable("lastBeatStart", null, "BeatStartWME");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        variableScopeThrowsErrors.defineVariable("txnInType", new VariableScope.IntValue(0), "int");
        variableScopeThrowsErrors.defineVariable("abortReason", new VariableScope.IntValue(0), "int");
        return new Beat(28, "NonAffChrTReturns_T2", array, 1.0f, Integer.MAX_VALUE, array2, array3, array4, variableScopeThrowsErrors, "_NonAffChrTReturns_T2_initAction", "_NonAffChrTReturns_T2_selectAction", "_NonAffChrTReturns_T2_succeedAction", null);
    }
    
    public static Beat _OneOnOneGNonAffChr_T2_factory() {
        final StoryEffect[] array = { new StoryEffect("tension", 2.0f, true) };
        final String[] array2 = { "_OneOnOneGNonAffChr_T2_precondition1" };
        final Beat.WeightTest[] array3 = new Beat.WeightTest[0];
        final Beat.PriorityTest[] array4 = new Beat.PriorityTest[0];
        final VariableScopeThrowsErrors variableScopeThrowsErrors2;
        final VariableScopeThrowsErrors variableScopeThrowsErrors = variableScopeThrowsErrors2 = new VariableScopeThrowsErrors(null, "OneOnOneGNonAffChr_T2_scope");
        final String s = "storyMemory";
        DramaManager.getDramaManager();
        variableScopeThrowsErrors2.defineVariable(s, DramaManager.getStoryMemory(), "StoryMemory");
        variableScopeThrowsErrors.defineVariable("beatMemory", WorkingMemory.lookupRegisteredMemory("BeatMemory"), "WorkingMemory");
        variableScopeThrowsErrors.defineVariable("lastBeatStart", null, "BeatStartWME");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        variableScopeThrowsErrors.defineVariable("txnInType", new VariableScope.IntValue(0), "int");
        variableScopeThrowsErrors.defineVariable("abortReason", new VariableScope.IntValue(0), "int");
        return new Beat(25, "OneOnOneGNonAffChr_T2", array, 1.0f, Integer.MAX_VALUE, array2, array3, array4, variableScopeThrowsErrors, "_OneOnOneGNonAffChr_T2_initAction", "_OneOnOneGNonAffChr_T2_selectAction", "_OneOnOneGNonAffChr_T2_succeedAction", null);
    }
    
    public static Beat _OneOnOneTNonAffChr_T2_factory() {
        final StoryEffect[] array = { new StoryEffect("tension", 2.0f, true) };
        final String[] array2 = { "_OneOnOneTNonAffChr_T2_precondition1" };
        final Beat.WeightTest[] array3 = new Beat.WeightTest[0];
        final Beat.PriorityTest[] array4 = new Beat.PriorityTest[0];
        final VariableScopeThrowsErrors variableScopeThrowsErrors2;
        final VariableScopeThrowsErrors variableScopeThrowsErrors = variableScopeThrowsErrors2 = new VariableScopeThrowsErrors(null, "OneOnOneTNonAffChr_T2_scope");
        final String s = "storyMemory";
        DramaManager.getDramaManager();
        variableScopeThrowsErrors2.defineVariable(s, DramaManager.getStoryMemory(), "StoryMemory");
        variableScopeThrowsErrors.defineVariable("beatMemory", WorkingMemory.lookupRegisteredMemory("BeatMemory"), "WorkingMemory");
        variableScopeThrowsErrors.defineVariable("lastBeatStart", null, "BeatStartWME");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        variableScopeThrowsErrors.defineVariable("txnInType", new VariableScope.IntValue(0), "int");
        variableScopeThrowsErrors.defineVariable("abortReason", new VariableScope.IntValue(0), "int");
        return new Beat(26, "OneOnOneTNonAffChr_T2", array, 1.0f, Integer.MAX_VALUE, array2, array3, array4, variableScopeThrowsErrors, "_OneOnOneTNonAffChr_T2_initAction", "_OneOnOneTNonAffChr_T2_selectAction", "_OneOnOneTNonAffChr_T2_succeedAction", null);
    }
    
    public static Beat _ArtistAdvertising_GPA_T2_factory() {
        final StoryEffect[] array = { new StoryEffect("tension", 2.0f, true) };
        final String[] array2 = { "_ArtistAdvertising_GPA_T2_precondition1" };
        final Beat.WeightTest[] array3 = { new Beat.WeightTest("_ArtistAdvertising_GPA_T2_weighttest1", 3), new Beat.WeightTest("_ArtistAdvertising_GPA_T2_weighttest2", 2.999f) };
        final Beat.PriorityTest[] array4 = { new Beat.PriorityTest("_ArtistAdvertising_GPA_T2_prioritytest1", Integer.MAX_VALUE), new Beat.PriorityTest("_ArtistAdvertising_GPA_T2_prioritytest2", 10), new Beat.PriorityTest("_ArtistAdvertising_GPA_T2_prioritytest3", 9) };
        final VariableScopeThrowsErrors variableScopeThrowsErrors2;
        final VariableScopeThrowsErrors variableScopeThrowsErrors = variableScopeThrowsErrors2 = new VariableScopeThrowsErrors(null, "ArtistAdvertising_GPA_T2_scope");
        final String s = "storyMemory";
        DramaManager.getDramaManager();
        variableScopeThrowsErrors2.defineVariable(s, DramaManager.getStoryMemory(), "StoryMemory");
        variableScopeThrowsErrors.defineVariable("beatMemory", WorkingMemory.lookupRegisteredMemory("BeatMemory"), "WorkingMemory");
        variableScopeThrowsErrors.defineVariable("lastBeatStart", null, "BeatStartWME");
        variableScopeThrowsErrors.defineVariable("beatBeforeLastStart", null, "BeatStartWME");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        variableScopeThrowsErrors.defineVariable("txnInType", new VariableScope.IntValue(0), "int");
        variableScopeThrowsErrors.defineVariable("abortReason", new VariableScope.IntValue(0), "int");
        variableScopeThrowsErrors.defineVariable("storyStatusWME", null, "StoryStatusWME");
        variableScopeThrowsErrors.defineVariable("subtopic", new VariableScope.IntValue(-1), "int");
        return new Beat(17, "ArtistAdvertising_GPA_T2", array, 1.0f, 0, array2, array3, array4, variableScopeThrowsErrors, "_ArtistAdvertising_GPA_T2_initAction", "_ArtistAdvertising_GPA_T2_selectAction", "_ArtistAdvertising_GPA_T2_succeedAction", null);
    }
    
    public static Beat _ArtistAdvertising_GPA_T2ToT3_factory() {
        final StoryEffect[] array = { new StoryEffect("tension", 3, true) };
        final String[] array2 = { "_ArtistAdvertising_GPA_T2ToT3_precondition1" };
        final Beat.WeightTest[] array3 = { new Beat.WeightTest("_ArtistAdvertising_GPA_T2ToT3_weighttest1", 3), new Beat.WeightTest("_ArtistAdvertising_GPA_T2ToT3_weighttest2", 2.999f) };
        final Beat.PriorityTest[] array4 = { new Beat.PriorityTest("_ArtistAdvertising_GPA_T2ToT3_prioritytest1", Integer.MAX_VALUE), new Beat.PriorityTest("_ArtistAdvertising_GPA_T2ToT3_prioritytest2", 10), new Beat.PriorityTest("_ArtistAdvertising_GPA_T2ToT3_prioritytest3", 9) };
        final VariableScopeThrowsErrors variableScopeThrowsErrors2;
        final VariableScopeThrowsErrors variableScopeThrowsErrors = variableScopeThrowsErrors2 = new VariableScopeThrowsErrors(null, "ArtistAdvertising_GPA_T2ToT3_scope");
        final String s = "storyMemory";
        DramaManager.getDramaManager();
        variableScopeThrowsErrors2.defineVariable(s, DramaManager.getStoryMemory(), "StoryMemory");
        variableScopeThrowsErrors.defineVariable("beatMemory", WorkingMemory.lookupRegisteredMemory("BeatMemory"), "WorkingMemory");
        variableScopeThrowsErrors.defineVariable("lastBeatStart", null, "BeatStartWME");
        variableScopeThrowsErrors.defineVariable("beatBeforeLastStart", null, "BeatStartWME");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        variableScopeThrowsErrors.defineVariable("txnInType", new VariableScope.IntValue(0), "int");
        variableScopeThrowsErrors.defineVariable("abortReason", new VariableScope.IntValue(0), "int");
        variableScopeThrowsErrors.defineVariable("storyStatusWME", null, "StoryStatusWME");
        variableScopeThrowsErrors.defineVariable("subtopic", new VariableScope.IntValue(-1), "int");
        return new Beat(17, "ArtistAdvertising_GPA_T2ToT3", array, 1.0f, 0, array2, array3, array4, variableScopeThrowsErrors, "_ArtistAdvertising_GPA_T2ToT3_initAction", "_ArtistAdvertising_GPA_T2ToT3_selectAction", "_ArtistAdvertising_GPA_T2ToT3_succeedAction", null);
    }
    
    public static Beat _ArtistAdvertising_TPA_T2_factory() {
        final StoryEffect[] array = { new StoryEffect("tension", 2.0f, true) };
        final String[] array2 = { "_ArtistAdvertising_TPA_T2_precondition1" };
        final Beat.WeightTest[] array3 = { new Beat.WeightTest("_ArtistAdvertising_TPA_T2_weighttest1", 3), new Beat.WeightTest("_ArtistAdvertising_TPA_T2_weighttest2", 2.999f) };
        final Beat.PriorityTest[] array4 = { new Beat.PriorityTest("_ArtistAdvertising_TPA_T2_prioritytest1", Integer.MAX_VALUE), new Beat.PriorityTest("_ArtistAdvertising_TPA_T2_prioritytest2", 10), new Beat.PriorityTest("_ArtistAdvertising_TPA_T2_prioritytest3", 9) };
        final VariableScopeThrowsErrors variableScopeThrowsErrors2;
        final VariableScopeThrowsErrors variableScopeThrowsErrors = variableScopeThrowsErrors2 = new VariableScopeThrowsErrors(null, "ArtistAdvertising_TPA_T2_scope");
        final String s = "storyMemory";
        DramaManager.getDramaManager();
        variableScopeThrowsErrors2.defineVariable(s, DramaManager.getStoryMemory(), "StoryMemory");
        variableScopeThrowsErrors.defineVariable("beatMemory", WorkingMemory.lookupRegisteredMemory("BeatMemory"), "WorkingMemory");
        variableScopeThrowsErrors.defineVariable("lastBeatStart", null, "BeatStartWME");
        variableScopeThrowsErrors.defineVariable("beatBeforeLastStart", null, "BeatStartWME");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        variableScopeThrowsErrors.defineVariable("txnInType", new VariableScope.IntValue(0), "int");
        variableScopeThrowsErrors.defineVariable("abortReason", new VariableScope.IntValue(0), "int");
        variableScopeThrowsErrors.defineVariable("storyStatusWME", null, "StoryStatusWME");
        variableScopeThrowsErrors.defineVariable("subtopic", new VariableScope.IntValue(-1), "int");
        return new Beat(18, "ArtistAdvertising_TPA_T2", array, 1.0f, 0, array2, array3, array4, variableScopeThrowsErrors, "_ArtistAdvertising_TPA_T2_initAction", "_ArtistAdvertising_TPA_T2_selectAction", "_ArtistAdvertising_TPA_T2_succeedAction", null);
    }
    
    public static Beat _ArtistAdvertising_TPA_T2ToT3_factory() {
        final StoryEffect[] array = { new StoryEffect("tension", 3, true) };
        final String[] array2 = { "_ArtistAdvertising_TPA_T2ToT3_precondition1" };
        final Beat.WeightTest[] array3 = { new Beat.WeightTest("_ArtistAdvertising_TPA_T2ToT3_weighttest1", 3), new Beat.WeightTest("_ArtistAdvertising_TPA_T2ToT3_weighttest2", 2.999f) };
        final Beat.PriorityTest[] array4 = { new Beat.PriorityTest("_ArtistAdvertising_TPA_T2ToT3_prioritytest1", Integer.MAX_VALUE), new Beat.PriorityTest("_ArtistAdvertising_TPA_T2ToT3_prioritytest2", 10), new Beat.PriorityTest("_ArtistAdvertising_TPA_T2ToT3_prioritytest3", 9) };
        final VariableScopeThrowsErrors variableScopeThrowsErrors2;
        final VariableScopeThrowsErrors variableScopeThrowsErrors = variableScopeThrowsErrors2 = new VariableScopeThrowsErrors(null, "ArtistAdvertising_TPA_T2ToT3_scope");
        final String s = "storyMemory";
        DramaManager.getDramaManager();
        variableScopeThrowsErrors2.defineVariable(s, DramaManager.getStoryMemory(), "StoryMemory");
        variableScopeThrowsErrors.defineVariable("beatMemory", WorkingMemory.lookupRegisteredMemory("BeatMemory"), "WorkingMemory");
        variableScopeThrowsErrors.defineVariable("lastBeatStart", null, "BeatStartWME");
        variableScopeThrowsErrors.defineVariable("beatBeforeLastStart", null, "BeatStartWME");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        variableScopeThrowsErrors.defineVariable("txnInType", new VariableScope.IntValue(0), "int");
        variableScopeThrowsErrors.defineVariable("abortReason", new VariableScope.IntValue(0), "int");
        variableScopeThrowsErrors.defineVariable("storyStatusWME", null, "StoryStatusWME");
        variableScopeThrowsErrors.defineVariable("subtopic", new VariableScope.IntValue(-1), "int");
        return new Beat(18, "ArtistAdvertising_TPA_T2ToT3", array, 1.0f, 0, array2, array3, array4, variableScopeThrowsErrors, "_ArtistAdvertising_TPA_T2ToT3_initAction", "_ArtistAdvertising_TPA_T2ToT3_selectAction", "_ArtistAdvertising_TPA_T2ToT3_succeedAction", null);
    }
    
    public static Beat _RockyMarriage_GPA_T2_factory() {
        final StoryEffect[] array = { new StoryEffect("tension", 2.0f, true) };
        final String[] array2 = { "_RockyMarriage_GPA_T2_precondition1" };
        final Beat.WeightTest[] array3 = { new Beat.WeightTest("_RockyMarriage_GPA_T2_weighttest1", 3) };
        final Beat.PriorityTest[] array4 = { new Beat.PriorityTest("_RockyMarriage_GPA_T2_prioritytest1", 10) };
        final VariableScopeThrowsErrors variableScopeThrowsErrors2;
        final VariableScopeThrowsErrors variableScopeThrowsErrors = variableScopeThrowsErrors2 = new VariableScopeThrowsErrors(null, "RockyMarriage_GPA_T2_scope");
        final String s = "storyMemory";
        DramaManager.getDramaManager();
        variableScopeThrowsErrors2.defineVariable(s, DramaManager.getStoryMemory(), "StoryMemory");
        variableScopeThrowsErrors.defineVariable("beatMemory", WorkingMemory.lookupRegisteredMemory("BeatMemory"), "WorkingMemory");
        variableScopeThrowsErrors.defineVariable("lastBeatStart", null, "BeatStartWME");
        variableScopeThrowsErrors.defineVariable("beatBeforeLastStart", null, "BeatStartWME");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        variableScopeThrowsErrors.defineVariable("txnInType", new VariableScope.IntValue(0), "int");
        variableScopeThrowsErrors.defineVariable("abortReason", new VariableScope.IntValue(0), "int");
        variableScopeThrowsErrors.defineVariable("storyStatusWME", null, "StoryStatusWME");
        return new Beat(21, "RockyMarriage_GPA_T2", array, 1.0f, 0, array2, array3, array4, variableScopeThrowsErrors, "_RockyMarriage_GPA_T2_initAction", "_RockyMarriage_GPA_T2_selectAction", "_RockyMarriage_GPA_T2_succeedAction", null);
    }
    
    public static Beat _RockyMarriage_GPA_T2ToT3_factory() {
        final StoryEffect[] array = { new StoryEffect("tension", 3, true) };
        final String[] array2 = { "_RockyMarriage_GPA_T2ToT3_precondition1" };
        final Beat.WeightTest[] array3 = { new Beat.WeightTest("_RockyMarriage_GPA_T2ToT3_weighttest1", 3) };
        final Beat.PriorityTest[] array4 = { new Beat.PriorityTest("_RockyMarriage_GPA_T2ToT3_prioritytest1", 10) };
        final VariableScopeThrowsErrors variableScopeThrowsErrors2;
        final VariableScopeThrowsErrors variableScopeThrowsErrors = variableScopeThrowsErrors2 = new VariableScopeThrowsErrors(null, "RockyMarriage_GPA_T2ToT3_scope");
        final String s = "storyMemory";
        DramaManager.getDramaManager();
        variableScopeThrowsErrors2.defineVariable(s, DramaManager.getStoryMemory(), "StoryMemory");
        variableScopeThrowsErrors.defineVariable("beatMemory", WorkingMemory.lookupRegisteredMemory("BeatMemory"), "WorkingMemory");
        variableScopeThrowsErrors.defineVariable("lastBeatStart", null, "BeatStartWME");
        variableScopeThrowsErrors.defineVariable("beatBeforeLastStart", null, "BeatStartWME");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        variableScopeThrowsErrors.defineVariable("txnInType", new VariableScope.IntValue(0), "int");
        variableScopeThrowsErrors.defineVariable("abortReason", new VariableScope.IntValue(0), "int");
        variableScopeThrowsErrors.defineVariable("storyStatusWME", null, "StoryStatusWME");
        return new Beat(21, "RockyMarriage_GPA_T2ToT3", array, 1.0f, 0, array2, array3, array4, variableScopeThrowsErrors, "_RockyMarriage_GPA_T2ToT3_initAction", "_RockyMarriage_GPA_T2ToT3_selectAction", "_RockyMarriage_GPA_T2ToT3_succeedAction", null);
    }
    
    public static Beat _RockyMarriage_TPA_T2_factory() {
        final StoryEffect[] array = { new StoryEffect("tension", 2.0f, true) };
        final String[] array2 = { "_RockyMarriage_TPA_T2_precondition1" };
        final Beat.WeightTest[] array3 = { new Beat.WeightTest("_RockyMarriage_TPA_T2_weighttest1", 3) };
        final Beat.PriorityTest[] array4 = { new Beat.PriorityTest("_RockyMarriage_TPA_T2_prioritytest1", 10) };
        final VariableScopeThrowsErrors variableScopeThrowsErrors2;
        final VariableScopeThrowsErrors variableScopeThrowsErrors = variableScopeThrowsErrors2 = new VariableScopeThrowsErrors(null, "RockyMarriage_TPA_T2_scope");
        final String s = "storyMemory";
        DramaManager.getDramaManager();
        variableScopeThrowsErrors2.defineVariable(s, DramaManager.getStoryMemory(), "StoryMemory");
        variableScopeThrowsErrors.defineVariable("beatMemory", WorkingMemory.lookupRegisteredMemory("BeatMemory"), "WorkingMemory");
        variableScopeThrowsErrors.defineVariable("lastBeatStart", null, "BeatStartWME");
        variableScopeThrowsErrors.defineVariable("beatBeforeLastStart", null, "BeatStartWME");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        variableScopeThrowsErrors.defineVariable("txnInType", new VariableScope.IntValue(0), "int");
        variableScopeThrowsErrors.defineVariable("abortReason", new VariableScope.IntValue(0), "int");
        variableScopeThrowsErrors.defineVariable("storyStatusWME", null, "StoryStatusWME");
        return new Beat(22, "RockyMarriage_TPA_T2", array, 1.0f, 0, array2, array3, array4, variableScopeThrowsErrors, "_RockyMarriage_TPA_T2_initAction", "_RockyMarriage_TPA_T2_selectAction", "_RockyMarriage_TPA_T2_succeedAction", null);
    }
    
    public static Beat _RockyMarriage_TPA_T2ToT3_factory() {
        final StoryEffect[] array = { new StoryEffect("tension", 3, true) };
        final String[] array2 = { "_RockyMarriage_TPA_T2ToT3_precondition1" };
        final Beat.WeightTest[] array3 = { new Beat.WeightTest("_RockyMarriage_TPA_T2ToT3_weighttest1", 3) };
        final Beat.PriorityTest[] array4 = { new Beat.PriorityTest("_RockyMarriage_TPA_T2ToT3_prioritytest1", 10) };
        final VariableScopeThrowsErrors variableScopeThrowsErrors2;
        final VariableScopeThrowsErrors variableScopeThrowsErrors = variableScopeThrowsErrors2 = new VariableScopeThrowsErrors(null, "RockyMarriage_TPA_T2ToT3_scope");
        final String s = "storyMemory";
        DramaManager.getDramaManager();
        variableScopeThrowsErrors2.defineVariable(s, DramaManager.getStoryMemory(), "StoryMemory");
        variableScopeThrowsErrors.defineVariable("beatMemory", WorkingMemory.lookupRegisteredMemory("BeatMemory"), "WorkingMemory");
        variableScopeThrowsErrors.defineVariable("lastBeatStart", null, "BeatStartWME");
        variableScopeThrowsErrors.defineVariable("beatBeforeLastStart", null, "BeatStartWME");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        variableScopeThrowsErrors.defineVariable("txnInType", new VariableScope.IntValue(0), "int");
        variableScopeThrowsErrors.defineVariable("abortReason", new VariableScope.IntValue(0), "int");
        variableScopeThrowsErrors.defineVariable("storyStatusWME", null, "StoryStatusWME");
        return new Beat(22, "RockyMarriage_TPA_T2ToT3", array, 1.0f, 0, array2, array3, array4, variableScopeThrowsErrors, "_RockyMarriage_TPA_T2ToT3_initAction", "_RockyMarriage_TPA_T2ToT3_selectAction", "_RockyMarriage_TPA_T2ToT3_succeedAction", null);
    }
    
    public static Beat _Facade_TPA_T2_factory() {
        final StoryEffect[] array = { new StoryEffect("tension", 3, true) };
        final String[] array2 = { "_Facade_TPA_T2_precondition1" };
        final Beat.WeightTest[] array3 = { new Beat.WeightTest("_Facade_TPA_T2_weighttest1", 3) };
        final Beat.PriorityTest[] array4 = { new Beat.PriorityTest("_Facade_TPA_T2_prioritytest1", 10) };
        final VariableScopeThrowsErrors variableScopeThrowsErrors2;
        final VariableScopeThrowsErrors variableScopeThrowsErrors = variableScopeThrowsErrors2 = new VariableScopeThrowsErrors(null, "Facade_TPA_T2_scope");
        final String s = "storyMemory";
        DramaManager.getDramaManager();
        variableScopeThrowsErrors2.defineVariable(s, DramaManager.getStoryMemory(), "StoryMemory");
        variableScopeThrowsErrors.defineVariable("beatMemory", WorkingMemory.lookupRegisteredMemory("BeatMemory"), "WorkingMemory");
        variableScopeThrowsErrors.defineVariable("lastBeatStart", null, "BeatStartWME");
        variableScopeThrowsErrors.defineVariable("beatBeforeLastStart", null, "BeatStartWME");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        variableScopeThrowsErrors.defineVariable("txnInType", new VariableScope.IntValue(0), "int");
        variableScopeThrowsErrors.defineVariable("abortReason", new VariableScope.IntValue(0), "int");
        variableScopeThrowsErrors.defineVariable("storyStatusWME", null, "StoryStatusWME");
        return new Beat(20, "Facade_TPA_T2", array, 1.0f, 0, array2, array3, array4, variableScopeThrowsErrors, "_Facade_TPA_T2_initAction", "_Facade_TPA_T2_selectAction", "_Facade_TPA_T2_succeedAction", null);
    }
    
    public static Beat _Facade_GPA_T2_factory() {
        final StoryEffect[] array = { new StoryEffect("tension", 3, true) };
        final String[] array2 = { "_Facade_GPA_T2_precondition1" };
        final Beat.WeightTest[] array3 = { new Beat.WeightTest("_Facade_GPA_T2_weighttest1", 3) };
        final Beat.PriorityTest[] array4 = { new Beat.PriorityTest("_Facade_GPA_T2_prioritytest1", 10) };
        final VariableScopeThrowsErrors variableScopeThrowsErrors2;
        final VariableScopeThrowsErrors variableScopeThrowsErrors = variableScopeThrowsErrors2 = new VariableScopeThrowsErrors(null, "Facade_GPA_T2_scope");
        final String s = "storyMemory";
        DramaManager.getDramaManager();
        variableScopeThrowsErrors2.defineVariable(s, DramaManager.getStoryMemory(), "StoryMemory");
        variableScopeThrowsErrors.defineVariable("beatMemory", WorkingMemory.lookupRegisteredMemory("BeatMemory"), "WorkingMemory");
        variableScopeThrowsErrors.defineVariable("lastBeatStart", null, "BeatStartWME");
        variableScopeThrowsErrors.defineVariable("beatBeforeLastStart", null, "BeatStartWME");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        variableScopeThrowsErrors.defineVariable("txnInType", new VariableScope.IntValue(0), "int");
        variableScopeThrowsErrors.defineVariable("abortReason", new VariableScope.IntValue(0), "int");
        variableScopeThrowsErrors.defineVariable("storyStatusWME", null, "StoryStatusWME");
        return new Beat(19, "Facade_GPA_T2", array, 1.0f, 0, array2, array3, array4, variableScopeThrowsErrors, "_Facade_GPA_T2_initAction", "_Facade_GPA_T2_selectAction", "_Facade_GPA_T2_succeedAction", null);
    }
    
    public static Beat _TxnT2ToT3_factory() {
        return new Beat(30, "TxnT2ToT3", new StoryEffect[] { new StoryEffect("tension", 3, true) }, 1.0f, -1, new String[] { "_TxnT2ToT3_precondition1" }, new Beat.WeightTest[0], new Beat.PriorityTest[0], new VariableScopeThrowsErrors(null, "TxnT2ToT3_scope"), null, "_TxnT2ToT3_selectAction", null, null);
    }
    
    public static Beat _RomPrp_GPA_T2_factory() {
        return new Beat(29, "RomPrp_GPA_T2", new StoryEffect[] { new StoryEffect("tension", 2.0f, true) }, 5, 0, new String[] { "_RomPrp_GPA_T2_precondition1" }, new Beat.WeightTest[0], new Beat.PriorityTest[0], new VariableScopeThrowsErrors(null, "RomPrp_GPA_T2_scope"), null, "_RomPrp_GPA_T2_selectAction", null, null);
    }
    
    public static Beat _CrisisP1_factory() {
        return new Beat(31, "CrisisP1", new StoryEffect[] { new StoryEffect("tension", 3, true) }, 1.0f, Integer.MAX_VALUE, new String[] { "_CrisisP1_precondition1" }, new Beat.WeightTest[0], new Beat.PriorityTest[0], new VariableScopeThrowsErrors(null, "CrisisP1_scope"), null, "_CrisisP1_selectAction", null, null);
    }
    
    public static Beat _CrisisToTherapyGameGlue_P2_factory() {
        final StoryEffect[] array = { new StoryEffect("tension", 3, true) };
        final String[] array2 = { "_CrisisToTherapyGameGlue_P2_precondition1" };
        final Beat.WeightTest[] array3 = new Beat.WeightTest[0];
        final Beat.PriorityTest[] array4 = new Beat.PriorityTest[0];
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(null, "CrisisToTherapyGameGlue_P2_scope");
        variableScopeThrowsErrors.defineVariable("lastBeatStart", null, "BeatStartWME");
        return new Beat(32, "CrisisToTherapyGameGlue_P2", array, 1.0f, Integer.MAX_VALUE, array2, array3, array4, variableScopeThrowsErrors, "_CrisisToTherapyGameGlue_P2_initAction", "_CrisisToTherapyGameGlue_P2_selectAction", null, null);
    }
    
    public static Beat _TherapyGame_P2_factory() {
        final StoryEffect[] array = { new StoryEffect("tension", 3, true) };
        final String[] array2 = { "_TherapyGame_P2_precondition1" };
        final Beat.WeightTest[] array3 = new Beat.WeightTest[0];
        final Beat.PriorityTest[] array4 = new Beat.PriorityTest[0];
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(null, "TherapyGame_P2_scope");
        variableScopeThrowsErrors.defineVariable("lastBeatStart", null, "BeatStartWME");
        return new Beat(33, "TherapyGame_P2", array, 1.0f, Integer.MAX_VALUE, array2, array3, array4, variableScopeThrowsErrors, "_TherapyGame_P2_initAction", "_TherapyGame_P2_selectAction", null, null);
    }
    
    public static Beat _RevelationBuildup_P2_factory() {
        final StoryEffect[] array = { new StoryEffect("tension", 3, true) };
        final String[] array2 = { "_RevelationBuildup_P2_precondition1" };
        final Beat.WeightTest[] array3 = new Beat.WeightTest[0];
        final Beat.PriorityTest[] array4 = new Beat.PriorityTest[0];
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(null, "RevelationBuildup_P2_scope");
        variableScopeThrowsErrors.defineVariable("lastBeatStart", null, "BeatStartWME");
        return new Beat(34, "RevelationBuildup_P2", array, 1.0f, Integer.MAX_VALUE, array2, array3, array4, variableScopeThrowsErrors, "_RevelationBuildup_P2_initAction", "_RevelationBuildup_P2_selectAction", null, null);
    }
    
    public static Beat _Revelations_P2_factory() {
        return new Beat(35, "Revelations_P2", new StoryEffect[] { new StoryEffect("tension", 3, true) }, 1.0f, Integer.MAX_VALUE, new String[] { "_Revelations_P2_precondition1" }, new Beat.WeightTest[0], new Beat.PriorityTest[0], new VariableScopeThrowsErrors(null, "Revelations_P2_scope"), null, "_Revelations_P2_selectAction", null, null);
    }
    
    public static Beat _EndingNoRevelations_factory() {
        return new Beat(36, "EndingNoRevelations", new StoryEffect[] { new StoryEffect("tension", 3, true) }, 1.0f, Integer.MAX_VALUE, new String[] { "_EndingNoRevelations_precondition1" }, new Beat.WeightTest[0], new Beat.PriorityTest[0], new VariableScopeThrowsErrors(null, "EndingNoRevelations_scope"), null, "_EndingNoRevelations_selectAction", null, null);
    }
    
    public static Beat _EndingSelfRevelationOnly_factory() {
        final StoryEffect[] array = { new StoryEffect("tension", 3, true) };
        final String[] array2 = { "_EndingSelfRevelationOnly_precondition1" };
        final Beat.WeightTest[] array3 = new Beat.WeightTest[0];
        final Beat.PriorityTest[] array4 = new Beat.PriorityTest[0];
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(null, "EndingSelfRevelationOnly_scope");
        variableScopeThrowsErrors.defineVariable("lastBeatStart", null, "BeatStartWME");
        return new Beat(37, "EndingSelfRevelationOnly", array, 1.0f, Integer.MAX_VALUE, array2, array3, array4, variableScopeThrowsErrors, null, "_EndingSelfRevelationOnly_selectAction", null, null);
    }
    
    public static Beat _EndingRelationshipRevelationOnly_factory() {
        return new Beat(38, "EndingRelationshipRevelationOnly", new StoryEffect[] { new StoryEffect("tension", 3, true) }, 1.0f, 0, new String[] { "_EndingRelationshipRevelationOnly_precondition1" }, new Beat.WeightTest[0], new Beat.PriorityTest[0], new VariableScopeThrowsErrors(null, "EndingRelationshipRevelationOnly_scope"), null, "_EndingRelationshipRevelationOnly_selectAction", null, null);
    }
    
    public static Beat _EndingSelfAndRelationshipNotGTR_factory() {
        final StoryEffect[] array = { new StoryEffect("tension", 3, true) };
        final String[] array2 = { "_EndingSelfAndRelationshipNotGTR_precondition1" };
        final Beat.WeightTest[] array3 = new Beat.WeightTest[0];
        final Beat.PriorityTest[] array4 = new Beat.PriorityTest[0];
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(null, "EndingSelfAndRelationshipNotGTR_scope");
        variableScopeThrowsErrors.defineVariable("graceRev", new VariableScope.BooleanValue(false), "boolean");
        variableScopeThrowsErrors.defineVariable("tripRev", new VariableScope.BooleanValue(false), "boolean");
        variableScopeThrowsErrors.defineVariable("relationshipRev", new VariableScope.BooleanValue(false), "boolean");
        variableScopeThrowsErrors.defineVariable("wmeList", null, "LinkedList");
        variableScopeThrowsErrors.defineVariable("revWME", null, "BeatRevelationsP2WME");
        variableScopeThrowsErrors.defineVariable("rev1Focus", null, "int");
        variableScopeThrowsErrors.defineVariable("rev2Focus", null, "int");
        variableScopeThrowsErrors.defineVariable("rev3Focus", null, "int");
        return new Beat(39, "EndingSelfAndRelationshipNotGTR", array, 1.0f, 0, array2, array3, array4, variableScopeThrowsErrors, "_EndingSelfAndRelationshipNotGTR_initAction", "_EndingSelfAndRelationshipNotGTR_selectAction", null, null);
    }
    
    public static Beat _EndingGTR_factory() {
        final StoryEffect[] array = { new StoryEffect("tension", 3, true) };
        final String[] array2 = { "_EndingGTR_precondition1" };
        final Beat.WeightTest[] array3 = new Beat.WeightTest[0];
        final Beat.PriorityTest[] array4 = new Beat.PriorityTest[0];
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(null, "EndingGTR_scope");
        variableScopeThrowsErrors.defineVariable("graceRev", new VariableScope.BooleanValue(false), "boolean");
        variableScopeThrowsErrors.defineVariable("tripRev", new VariableScope.BooleanValue(false), "boolean");
        variableScopeThrowsErrors.defineVariable("relationshipRev", new VariableScope.BooleanValue(false), "boolean");
        variableScopeThrowsErrors.defineVariable("wmeList", null, "LinkedList");
        variableScopeThrowsErrors.defineVariable("revWME", null, "BeatRevelationsP2WME");
        variableScopeThrowsErrors.defineVariable("rev1Focus", null, "int");
        variableScopeThrowsErrors.defineVariable("rev2Focus", null, "int");
        variableScopeThrowsErrors.defineVariable("rev3Focus", null, "int");
        return new Beat(40, "EndingGTR", array, 1.0f, 0, array2, array3, array4, variableScopeThrowsErrors, "_EndingGTR_initAction", "_EndingGTR_selectAction", null, null);
    }
}
