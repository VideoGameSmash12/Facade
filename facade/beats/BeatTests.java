package facade.beats;

import java.util.LinkedList;
import facade.characters.wmedef.BeatRevelationsP2WME;
import facade.characters.wmedef.SameAffinityNBeatsWME;
import facade.characters.wmedef.BeatStatusWME;
import wm.WorkingMemory;
import facade.util.BeatHelperFxns;
import dramaman.runtime.BeatStartWME;
import dramaman.runtime.BeatAbortWME;
import dramaman.runtime.BeatCompletedWME;
import facade.characters.wmedef.DAWME;
import dramaman.runtime.TensionStoryValueWME;
import java.util.ListIterator;
import dramaman.runtime.StoryStatusWME;
import dramaman.runtime.DramaManager;
import scope.VariableScopeThrowsErrors;
import scope.VariableScope;
import facade.util.TherapyGameConstants;
import facade.util.BeatArguments;
import facade.util.DAType;
import dramaman.runtime.DramaManagerConstants;
import facade.util.BeatID;

public class BeatTests implements BeatID, DramaManagerConstants, DAType, BeatArguments, TherapyGameConstants
{
    public static boolean _PBehindDoor_T1_precondition1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_PBehindDoor_T1_precondition1_scope");
        final ListIterator<StoryStatusWME> listIterator = (ListIterator<StoryStatusWME>)DramaManager.lookupWME("StoryStatusWME").listIterator();
        while (listIterator.hasNext()) {
            if (((StoryStatusWME)listIterator.next()).getBeatCount() == 1) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean _TGreetsP_T1_precondition1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_TGreetsP_T1_precondition1_scope");
        final ListIterator<StoryStatusWME> listIterator = (ListIterator<StoryStatusWME>)DramaManager.lookupWME("StoryStatusWME").listIterator();
        while (listIterator.hasNext()) {
            if (((StoryStatusWME)listIterator.next()).getBeatCount() == 2) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean _TFetchesG_T1_precondition1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_TFetchesG_T1_precondition1_scope");
        final ListIterator<StoryStatusWME> listIterator = (ListIterator<StoryStatusWME>)DramaManager.lookupWME("StoryStatusWME").listIterator();
        while (listIterator.hasNext()) {
            if (((StoryStatusWME)listIterator.next()).getBeatCount() == 3) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean _GGreetsP_T1_precondition1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_GGreetsP_T1_precondition1_scope");
        final ListIterator<StoryStatusWME> listIterator = (ListIterator<StoryStatusWME>)DramaManager.lookupWME("StoryStatusWME").listIterator();
        while (listIterator.hasNext()) {
            if (((StoryStatusWME)listIterator.next()).getBeatCount() == 4) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean _ExplDatAnniv_T1_precondition1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ExplDatAnniv_T1_precondition1_scope");
        final ListIterator<StoryStatusWME> listIterator = (ListIterator<StoryStatusWME>)DramaManager.lookupWME("StoryStatusWME").listIterator();
        while (listIterator.hasNext()) {
            if (((StoryStatusWME)listIterator.next()).getBeatCount() > 4) {
                final ListIterator<TensionStoryValueWME> listIterator2 = (ListIterator<TensionStoryValueWME>)DramaManager.lookupWME("TensionStoryValueWME").listIterator();
                while (listIterator2.hasNext()) {
                    if (((TensionStoryValueWME)listIterator2.next()).getValue() == 1.0f) {
                        final ListIterator<DAWME> listIterator3 = (ListIterator<DAWME>)DramaManager.lookupWME("DAWME").listIterator();
                        while (listIterator3.hasNext()) {
                            final DAWME dawme = listIterator3.next();
                            if (dawme.getId() == 10 && dawme.getParam1() == 63) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean _ExplDatAnniv_T1_weighttest1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ExplDatAnniv_T1_weighttest1_scope");
        final ListIterator<StoryStatusWME> listIterator = (ListIterator<StoryStatusWME>)DramaManager.lookupWME("StoryStatusWME").listIterator();
        while (listIterator.hasNext()) {
            if (((StoryStatusWME)listIterator.next()).getBeatCount() < 7) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean _PhoneCall_NGPA_T1_precondition1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_PhoneCall_NGPA_T1_precondition1_scope");
        final ListIterator<StoryStatusWME> listIterator = (ListIterator<StoryStatusWME>)DramaManager.lookupWME("StoryStatusWME").listIterator();
        while (listIterator.hasNext()) {
            final StoryStatusWME storyStatusWME = listIterator.next();
            if (storyStatusWME.getBeatCount() > 4 && storyStatusWME.getAffinity() <= 0) {
                final ListIterator<TensionStoryValueWME> listIterator2 = (ListIterator<TensionStoryValueWME>)DramaManager.lookupWME("TensionStoryValueWME").listIterator();
                while (listIterator2.hasNext()) {
                    if (((TensionStoryValueWME)listIterator2.next()).getValue() == 1.0f) {
                        final ListIterator<BeatCompletedWME> listIterator3 = (ListIterator<BeatCompletedWME>)DramaManager.lookupWME("BeatCompletedWME").listIterator();
                        while (listIterator3.hasNext()) {
                            final BeatCompletedWME beatCompletedWME = listIterator3.next();
                            if (beatCompletedWME.getBeatID() >= 5 && beatCompletedWME.getBeatID() <= 6) {
                                return false;
                            }
                        }
                        final ListIterator<BeatAbortWME> listIterator4 = (ListIterator<BeatAbortWME>)DramaManager.lookupWME("BeatAbortWME").listIterator();
                        while (listIterator4.hasNext()) {
                            final BeatAbortWME beatAbortWME = listIterator4.next();
                            if (beatAbortWME.getBeatID() >= 5 && beatAbortWME.getBeatID() <= 6) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean _PhoneCall_NTPA_T1_precondition1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_PhoneCall_NTPA_T1_precondition1_scope");
        final ListIterator<StoryStatusWME> listIterator = (ListIterator<StoryStatusWME>)DramaManager.lookupWME("StoryStatusWME").listIterator();
        while (listIterator.hasNext()) {
            final StoryStatusWME storyStatusWME = listIterator.next();
            if (storyStatusWME.getBeatCount() > 4 && storyStatusWME.getAffinity() >= 0) {
                final ListIterator<TensionStoryValueWME> listIterator2 = (ListIterator<TensionStoryValueWME>)DramaManager.lookupWME("TensionStoryValueWME").listIterator();
                while (listIterator2.hasNext()) {
                    if (((TensionStoryValueWME)listIterator2.next()).getValue() == 1.0f) {
                        final ListIterator<BeatCompletedWME> listIterator3 = (ListIterator<BeatCompletedWME>)DramaManager.lookupWME("BeatCompletedWME").listIterator();
                        while (listIterator3.hasNext()) {
                            final BeatCompletedWME beatCompletedWME = listIterator3.next();
                            if (beatCompletedWME.getBeatID() >= 5 && beatCompletedWME.getBeatID() <= 6) {
                                return false;
                            }
                        }
                        final ListIterator<BeatAbortWME> listIterator4 = (ListIterator<BeatAbortWME>)DramaManager.lookupWME("BeatAbortWME").listIterator();
                        while (listIterator4.hasNext()) {
                            final BeatAbortWME beatAbortWME = listIterator4.next();
                            if (beatAbortWME.getBeatID() >= 5 && beatAbortWME.getBeatID() <= 6) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean _ArtistAdvertising_N_T1_precondition1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_N_T1_precondition1_scope");
        variableScopeThrowsErrors.defineVariable("storyStatusWME", null, "StoryStatusWME");
        final ListIterator<StoryStatusWME> listIterator = (ListIterator<StoryStatusWME>)DramaManager.lookupWME("StoryStatusWME").listIterator();
        while (listIterator.hasNext()) {
            final StoryStatusWME storyStatusWME = listIterator.next();
            if (storyStatusWME.getBeatCount() > 4 && storyStatusWME.getAffinity() == 0) {
                final ListIterator<TensionStoryValueWME> listIterator2 = (ListIterator<TensionStoryValueWME>)DramaManager.lookupWME("TensionStoryValueWME").listIterator();
                while (listIterator2.hasNext()) {
                    if (((TensionStoryValueWME)listIterator2.next()).getValue() == 1.0f) {
                        final ListIterator<BeatCompletedWME> listIterator3 = (ListIterator<BeatCompletedWME>)DramaManager.lookupWME("BeatCompletedWME").listIterator();
                        while (listIterator3.hasNext()) {
                            final BeatCompletedWME beatCompletedWME = listIterator3.next();
                            if (beatCompletedWME.getBeatID() >= 9 && beatCompletedWME.getBeatID() <= 11) {
                                return false;
                            }
                        }
                        final ListIterator<BeatAbortWME> listIterator4 = (ListIterator<BeatAbortWME>)DramaManager.lookupWME("BeatAbortWME").listIterator();
                        while (listIterator4.hasNext()) {
                            final BeatAbortWME beatAbortWME = listIterator4.next();
                            if (beatAbortWME.getBeatID() >= 9 && beatAbortWME.getBeatID() <= 11 && beatAbortWME.getBeatAbortReason() != 2 && beatAbortWME.getBeatAbortReason() != 1) {
                                return false;
                            }
                        }
                        final ListIterator<StoryStatusWME> listIterator5 = (ListIterator<StoryStatusWME>)DramaManager.lookupWME("StoryStatusWME").listIterator();
                        while (listIterator5.hasNext()) {
                            final StoryStatusWME value = listIterator5.next();
                            variableScopeThrowsErrors.getVariable("storyStatusWME").value = value;
                            if (value.getStoryTopicBeatCount() < 2) {
                                variableScopeThrowsErrors.getParentVariable("storyStatusWME").value = variableScopeThrowsErrors.getVariable("storyStatusWME").value;
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean _ArtistAdvertising_N_T1_weighttest1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_N_T1_weighttest1_scope");
        variableScopeThrowsErrors.defineVariable("daTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("daType", null, "int");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        variableScopeThrowsErrors.defineVariable("objectReference", null, "int");
        final ListIterator listIterator = DramaManager.lookupWME("DAWME").listIterator();
        while (listIterator.hasNext()) {
            final DAWME value = listIterator.next();
            variableScopeThrowsErrors.getVariable("unhandledAct").value = value;
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp");
            final long timestamp = value.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && value.getHandledStatus() != 2) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                final int id = value.getId();
                intValue.i = id;
                if (!DramaManager.constantTrue(id) || value.getParam1() != 59 || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l > ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp() || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l <= ((BeatStartWME)variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value).getTimestamp()) {
                    continue;
                }
                final ListIterator listIterator2 = DramaManager.lookupWME("DAWME").listIterator();
                while (listIterator2.hasNext()) {
                    final DAWME dawme = listIterator2.next();
                    if (dawme.getTimestamp() == ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l) {
                        final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                        final int id2 = dawme.getId();
                        intValue2.i = id2;
                        if (!DramaManager.constantTrue(id2)) {
                            continue;
                        }
                        final VariableScope.IntValue intValue3 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("objectReference");
                        final int param1 = dawme.getParam1();
                        intValue3.i = param1;
                        if (!DramaManager.constantTrue(param1) || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || !BeatHelperFxns.isAASubtopic(((VariableScope.IntValue)variableScopeThrowsErrors.getValue("objectReference")).i)) {
                            continue;
                        }
                        final VariableScope.IntValue intValue4 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType");
                        final int i = 1;
                        intValue4.i = i;
                        if (!DramaManager.constantTrue(i)) {
                            continue;
                        }
                        final VariableScope.IntValue intValue5 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("subtopic");
                        final int j = ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("objectReference")).i;
                        intValue5.i = j;
                        if (DramaManager.constantTrue(j)) {
                            variableScopeThrowsErrors.getParentVariable("unhandledAct").value = variableScopeThrowsErrors.getVariable("unhandledAct").value;
                            return true;
                        }
                        continue;
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean _ArtistAdvertising_N_T1_weighttest2(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_N_T1_weighttest2_scope");
        variableScopeThrowsErrors.defineVariable("daTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("daType", null, "int");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        final ListIterator listIterator = DramaManager.lookupWME("DAWME").listIterator();
        while (listIterator.hasNext()) {
            final DAWME value = listIterator.next();
            variableScopeThrowsErrors.getVariable("unhandledAct").value = value;
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp");
            final long timestamp = value.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && value.getHandledStatus() != 2) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                final int id = value.getId();
                intValue.i = id;
                if (!DramaManager.constantTrue(id) || value.getParam1() != 59 || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l > ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp() || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l <= ((BeatStartWME)variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value).getTimestamp()) {
                    continue;
                }
                final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType");
                final int i = 1;
                intValue2.i = i;
                if (DramaManager.constantTrue(i)) {
                    variableScopeThrowsErrors.getParentVariable("unhandledAct").value = variableScopeThrowsErrors.getVariable("unhandledAct").value;
                    return true;
                }
                continue;
            }
        }
        return false;
    }
    
    public static boolean _ArtistAdvertising_N_T1_prioritytest1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_N_T1_prioritytest1_scope");
        variableScopeThrowsErrors.defineVariable("abortTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("abortBeatID", null, "int");
        variableScopeThrowsErrors.defineVariable("abortReason", null, "int");
        final ListIterator listIterator = DramaManager.lookupWME("BeatAbortWME").listIterator();
        while (listIterator.hasNext()) {
            final BeatAbortWME beatAbortWME = listIterator.next();
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("abortTimestamp");
            final long timestamp = beatAbortWME.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && beatAbortWME.getBeatID() >= 9 && beatAbortWME.getBeatID() <= 11) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortBeatID");
                final int beatID = beatAbortWME.getBeatID();
                intValue.i = beatID;
                if (!DramaManager.constantTrue(beatID)) {
                    continue;
                }
                final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason");
                final int beatAbortReason = beatAbortWME.getBeatAbortReason();
                intValue2.i = beatAbortReason;
                if (DramaManager.constantTrue(beatAbortReason) && ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("abortTimestamp")).l > ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp() && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortBeatID")).i == ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getBeatID() && (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason")).i == 2 || ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason")).i == 1)) {
                    variableScopeThrowsErrors.getParentVariable("abortReason").value = variableScopeThrowsErrors.getVariable("abortReason").value;
                    return true;
                }
                continue;
            }
        }
        return false;
    }
    
    public static boolean _ArtistAdvertising_N_T1_prioritytest2(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_N_T1_prioritytest2_scope");
        variableScopeThrowsErrors.defineVariable("daTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("daType", null, "int");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        variableScopeThrowsErrors.defineVariable("objectReference", null, "int");
        final ListIterator listIterator = DramaManager.lookupWME("DAWME").listIterator();
        while (listIterator.hasNext()) {
            final DAWME value = listIterator.next();
            variableScopeThrowsErrors.getVariable("unhandledAct").value = value;
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp");
            final long timestamp = value.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && value.getHandledStatus() != 2) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                final int id = value.getId();
                intValue.i = id;
                if (!DramaManager.constantTrue(id) || value.getParam1() != 59 || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l <= ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp()) {
                    continue;
                }
                final ListIterator listIterator2 = DramaManager.lookupWME("DAWME").listIterator();
                while (listIterator2.hasNext()) {
                    final DAWME dawme = listIterator2.next();
                    if (dawme.getTimestamp() == ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l) {
                        final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                        final int id2 = dawme.getId();
                        intValue2.i = id2;
                        if (!DramaManager.constantTrue(id2)) {
                            continue;
                        }
                        final VariableScope.IntValue intValue3 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("objectReference");
                        final int param1 = dawme.getParam1();
                        intValue3.i = param1;
                        if (!DramaManager.constantTrue(param1) || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || !BeatHelperFxns.isAASubtopic(((VariableScope.IntValue)variableScopeThrowsErrors.getValue("objectReference")).i)) {
                            continue;
                        }
                        final VariableScope.IntValue intValue4 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType");
                        final int i = 1;
                        intValue4.i = i;
                        if (!DramaManager.constantTrue(i)) {
                            continue;
                        }
                        final VariableScope.IntValue intValue5 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("subtopic");
                        final int j = ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("objectReference")).i;
                        intValue5.i = j;
                        if (DramaManager.constantTrue(j)) {
                            variableScopeThrowsErrors.getParentVariable("unhandledAct").value = variableScopeThrowsErrors.getVariable("unhandledAct").value;
                            return true;
                        }
                        continue;
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean _ArtistAdvertising_N_T1_prioritytest3(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_N_T1_prioritytest3_scope");
        variableScopeThrowsErrors.defineVariable("daTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("daType", null, "int");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        final ListIterator listIterator = DramaManager.lookupWME("DAWME").listIterator();
        while (listIterator.hasNext()) {
            final DAWME value = listIterator.next();
            variableScopeThrowsErrors.getVariable("unhandledAct").value = value;
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp");
            final long timestamp = value.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && value.getHandledStatus() != 2) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                final int id = value.getId();
                intValue.i = id;
                if (!DramaManager.constantTrue(id) || value.getParam1() != 59 || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l <= ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp()) {
                    continue;
                }
                final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType");
                final int i = 1;
                intValue2.i = i;
                if (DramaManager.constantTrue(i)) {
                    variableScopeThrowsErrors.getParentVariable("unhandledAct").value = variableScopeThrowsErrors.getVariable("unhandledAct").value;
                    return true;
                }
                continue;
            }
        }
        return false;
    }
    
    public static boolean _ArtistAdvertising_GPA_T1_precondition1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_GPA_T1_precondition1_scope");
        variableScopeThrowsErrors.defineVariable("storyStatusWME", null, "StoryStatusWME");
        final ListIterator<StoryStatusWME> listIterator = (ListIterator<StoryStatusWME>)DramaManager.lookupWME("StoryStatusWME").listIterator();
        while (listIterator.hasNext()) {
            final StoryStatusWME storyStatusWME = listIterator.next();
            if (storyStatusWME.getBeatCount() > 4 && storyStatusWME.getAffinity() <= -1) {
                final ListIterator<TensionStoryValueWME> listIterator2 = (ListIterator<TensionStoryValueWME>)DramaManager.lookupWME("TensionStoryValueWME").listIterator();
                while (listIterator2.hasNext()) {
                    if (((TensionStoryValueWME)listIterator2.next()).getValue() == 1.0f) {
                        final ListIterator<BeatCompletedWME> listIterator3 = (ListIterator<BeatCompletedWME>)DramaManager.lookupWME("BeatCompletedWME").listIterator();
                        while (listIterator3.hasNext()) {
                            final BeatCompletedWME beatCompletedWME = listIterator3.next();
                            if (beatCompletedWME.getBeatID() >= 9 && beatCompletedWME.getBeatID() <= 11) {
                                return false;
                            }
                        }
                        final ListIterator<BeatAbortWME> listIterator4 = (ListIterator<BeatAbortWME>)DramaManager.lookupWME("BeatAbortWME").listIterator();
                        while (listIterator4.hasNext()) {
                            final BeatAbortWME beatAbortWME = listIterator4.next();
                            if (beatAbortWME.getBeatID() >= 9 && beatAbortWME.getBeatID() <= 11 && beatAbortWME.getBeatAbortReason() != 2 && beatAbortWME.getBeatAbortReason() != 1) {
                                return false;
                            }
                        }
                        final ListIterator<StoryStatusWME> listIterator5 = (ListIterator<StoryStatusWME>)DramaManager.lookupWME("StoryStatusWME").listIterator();
                        while (listIterator5.hasNext()) {
                            final StoryStatusWME value = listIterator5.next();
                            variableScopeThrowsErrors.getVariable("storyStatusWME").value = value;
                            if (value.getStoryTopicBeatCount() < 2) {
                                variableScopeThrowsErrors.getParentVariable("storyStatusWME").value = variableScopeThrowsErrors.getVariable("storyStatusWME").value;
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean _ArtistAdvertising_GPA_T1_weighttest1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_GPA_T1_weighttest1_scope");
        variableScopeThrowsErrors.defineVariable("daTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("daType", null, "int");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        variableScopeThrowsErrors.defineVariable("objectReference", null, "int");
        final ListIterator listIterator = DramaManager.lookupWME("DAWME").listIterator();
        while (listIterator.hasNext()) {
            final DAWME value = listIterator.next();
            variableScopeThrowsErrors.getVariable("unhandledAct").value = value;
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp");
            final long timestamp = value.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && value.getHandledStatus() != 2) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                final int id = value.getId();
                intValue.i = id;
                if (!DramaManager.constantTrue(id) || value.getParam1() != 59 || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l > ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp() || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l <= ((BeatStartWME)variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value).getTimestamp()) {
                    continue;
                }
                final ListIterator listIterator2 = DramaManager.lookupWME("DAWME").listIterator();
                while (listIterator2.hasNext()) {
                    final DAWME dawme = listIterator2.next();
                    if (dawme.getTimestamp() == ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l) {
                        final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                        final int id2 = dawme.getId();
                        intValue2.i = id2;
                        if (!DramaManager.constantTrue(id2)) {
                            continue;
                        }
                        final VariableScope.IntValue intValue3 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("objectReference");
                        final int param1 = dawme.getParam1();
                        intValue3.i = param1;
                        if (!DramaManager.constantTrue(param1) || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || !BeatHelperFxns.isAASubtopic(((VariableScope.IntValue)variableScopeThrowsErrors.getValue("objectReference")).i)) {
                            continue;
                        }
                        final VariableScope.IntValue intValue4 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType");
                        final int i = 1;
                        intValue4.i = i;
                        if (!DramaManager.constantTrue(i)) {
                            continue;
                        }
                        final VariableScope.IntValue intValue5 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("subtopic");
                        final int j = ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("objectReference")).i;
                        intValue5.i = j;
                        if (DramaManager.constantTrue(j)) {
                            variableScopeThrowsErrors.getParentVariable("unhandledAct").value = variableScopeThrowsErrors.getVariable("unhandledAct").value;
                            return true;
                        }
                        continue;
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean _ArtistAdvertising_GPA_T1_weighttest2(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_GPA_T1_weighttest2_scope");
        variableScopeThrowsErrors.defineVariable("daTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("daType", null, "int");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        final ListIterator listIterator = DramaManager.lookupWME("DAWME").listIterator();
        while (listIterator.hasNext()) {
            final DAWME value = listIterator.next();
            variableScopeThrowsErrors.getVariable("unhandledAct").value = value;
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp");
            final long timestamp = value.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && value.getHandledStatus() != 2) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                final int id = value.getId();
                intValue.i = id;
                if (!DramaManager.constantTrue(id) || value.getParam1() != 59 || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l > ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp() || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l <= ((BeatStartWME)variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value).getTimestamp()) {
                    continue;
                }
                final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType");
                final int i = 1;
                intValue2.i = i;
                if (DramaManager.constantTrue(i)) {
                    variableScopeThrowsErrors.getParentVariable("unhandledAct").value = variableScopeThrowsErrors.getVariable("unhandledAct").value;
                    return true;
                }
                continue;
            }
        }
        return false;
    }
    
    public static boolean _ArtistAdvertising_GPA_T1_prioritytest1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_GPA_T1_prioritytest1_scope");
        variableScopeThrowsErrors.defineVariable("abortTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("abortBeatID", null, "int");
        variableScopeThrowsErrors.defineVariable("abortReason", null, "int");
        final ListIterator listIterator = DramaManager.lookupWME("BeatAbortWME").listIterator();
        while (listIterator.hasNext()) {
            final BeatAbortWME beatAbortWME = listIterator.next();
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("abortTimestamp");
            final long timestamp = beatAbortWME.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && beatAbortWME.getBeatID() >= 9 && beatAbortWME.getBeatID() <= 11) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortBeatID");
                final int beatID = beatAbortWME.getBeatID();
                intValue.i = beatID;
                if (!DramaManager.constantTrue(beatID) || beatAbortWME.getBeatAbortReason() != 1) {
                    continue;
                }
                final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason");
                final int beatAbortReason = beatAbortWME.getBeatAbortReason();
                intValue2.i = beatAbortReason;
                if (DramaManager.constantTrue(beatAbortReason) && ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("abortTimestamp")).l > ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp() && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortBeatID")).i == ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getBeatID()) {
                    variableScopeThrowsErrors.getParentVariable("abortReason").value = variableScopeThrowsErrors.getVariable("abortReason").value;
                    return true;
                }
                continue;
            }
        }
        return false;
    }
    
    public static boolean _ArtistAdvertising_GPA_T1_prioritytest2(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_GPA_T1_prioritytest2_scope");
        variableScopeThrowsErrors.defineVariable("daTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("daType", null, "int");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        variableScopeThrowsErrors.defineVariable("objectReference", null, "int");
        final ListIterator listIterator = DramaManager.lookupWME("DAWME").listIterator();
        while (listIterator.hasNext()) {
            final DAWME value = listIterator.next();
            variableScopeThrowsErrors.getVariable("unhandledAct").value = value;
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp");
            final long timestamp = value.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && value.getHandledStatus() != 2) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                final int id = value.getId();
                intValue.i = id;
                if (!DramaManager.constantTrue(id) || value.getParam1() != 59 || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l <= ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp()) {
                    continue;
                }
                final ListIterator listIterator2 = DramaManager.lookupWME("DAWME").listIterator();
                while (listIterator2.hasNext()) {
                    final DAWME dawme = listIterator2.next();
                    if (dawme.getTimestamp() == ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l) {
                        final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                        final int id2 = dawme.getId();
                        intValue2.i = id2;
                        if (!DramaManager.constantTrue(id2)) {
                            continue;
                        }
                        final VariableScope.IntValue intValue3 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("objectReference");
                        final int param1 = dawme.getParam1();
                        intValue3.i = param1;
                        if (!DramaManager.constantTrue(param1) || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || !BeatHelperFxns.isAASubtopic(((VariableScope.IntValue)variableScopeThrowsErrors.getValue("objectReference")).i)) {
                            continue;
                        }
                        final VariableScope.IntValue intValue4 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType");
                        final int i = 1;
                        intValue4.i = i;
                        if (!DramaManager.constantTrue(i)) {
                            continue;
                        }
                        final VariableScope.IntValue intValue5 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("subtopic");
                        final int j = ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("objectReference")).i;
                        intValue5.i = j;
                        if (DramaManager.constantTrue(j)) {
                            variableScopeThrowsErrors.getParentVariable("unhandledAct").value = variableScopeThrowsErrors.getVariable("unhandledAct").value;
                            return true;
                        }
                        continue;
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean _ArtistAdvertising_GPA_T1_prioritytest3(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_GPA_T1_prioritytest3_scope");
        variableScopeThrowsErrors.defineVariable("daTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("daType", null, "int");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        final ListIterator listIterator = DramaManager.lookupWME("DAWME").listIterator();
        while (listIterator.hasNext()) {
            final DAWME value = listIterator.next();
            variableScopeThrowsErrors.getVariable("unhandledAct").value = value;
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp");
            final long timestamp = value.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && value.getHandledStatus() != 2) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                final int id = value.getId();
                intValue.i = id;
                if (!DramaManager.constantTrue(id) || value.getParam1() != 59 || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l <= ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp()) {
                    continue;
                }
                final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType");
                final int i = 1;
                intValue2.i = i;
                if (DramaManager.constantTrue(i)) {
                    variableScopeThrowsErrors.getParentVariable("unhandledAct").value = variableScopeThrowsErrors.getVariable("unhandledAct").value;
                    return true;
                }
                continue;
            }
        }
        return false;
    }
    
    public static boolean _ArtistAdvertising_TPA_T1_precondition1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_TPA_T1_precondition1_scope");
        variableScopeThrowsErrors.defineVariable("storyStatusWME", null, "StoryStatusWME");
        final ListIterator<StoryStatusWME> listIterator = (ListIterator<StoryStatusWME>)DramaManager.lookupWME("StoryStatusWME").listIterator();
        while (listIterator.hasNext()) {
            final StoryStatusWME storyStatusWME = listIterator.next();
            if (storyStatusWME.getBeatCount() > 4 && storyStatusWME.getAffinity() >= 1) {
                final ListIterator<TensionStoryValueWME> listIterator2 = (ListIterator<TensionStoryValueWME>)DramaManager.lookupWME("TensionStoryValueWME").listIterator();
                while (listIterator2.hasNext()) {
                    if (((TensionStoryValueWME)listIterator2.next()).getValue() == 1.0f) {
                        final ListIterator<BeatCompletedWME> listIterator3 = (ListIterator<BeatCompletedWME>)DramaManager.lookupWME("BeatCompletedWME").listIterator();
                        while (listIterator3.hasNext()) {
                            final BeatCompletedWME beatCompletedWME = listIterator3.next();
                            if (beatCompletedWME.getBeatID() >= 9 && beatCompletedWME.getBeatID() <= 11) {
                                return false;
                            }
                        }
                        final ListIterator<BeatAbortWME> listIterator4 = (ListIterator<BeatAbortWME>)DramaManager.lookupWME("BeatAbortWME").listIterator();
                        while (listIterator4.hasNext()) {
                            final BeatAbortWME beatAbortWME = listIterator4.next();
                            if (beatAbortWME.getBeatID() >= 9 && beatAbortWME.getBeatID() <= 11 && beatAbortWME.getBeatAbortReason() != 2 && beatAbortWME.getBeatAbortReason() != 1) {
                                return false;
                            }
                        }
                        final ListIterator<StoryStatusWME> listIterator5 = (ListIterator<StoryStatusWME>)DramaManager.lookupWME("StoryStatusWME").listIterator();
                        while (listIterator5.hasNext()) {
                            final StoryStatusWME value = listIterator5.next();
                            variableScopeThrowsErrors.getVariable("storyStatusWME").value = value;
                            if (value.getStoryTopicBeatCount() < 2) {
                                variableScopeThrowsErrors.getParentVariable("storyStatusWME").value = variableScopeThrowsErrors.getVariable("storyStatusWME").value;
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean _ArtistAdvertising_TPA_T1_weighttest1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_TPA_T1_weighttest1_scope");
        variableScopeThrowsErrors.defineVariable("daTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("daType", null, "int");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        variableScopeThrowsErrors.defineVariable("objectReference", null, "int");
        final ListIterator listIterator = DramaManager.lookupWME("DAWME").listIterator();
        while (listIterator.hasNext()) {
            final DAWME value = listIterator.next();
            variableScopeThrowsErrors.getVariable("unhandledAct").value = value;
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp");
            final long timestamp = value.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && value.getHandledStatus() != 2) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                final int id = value.getId();
                intValue.i = id;
                if (!DramaManager.constantTrue(id) || value.getParam1() != 59 || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l > ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp() || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l <= ((BeatStartWME)variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value).getTimestamp()) {
                    continue;
                }
                final ListIterator listIterator2 = DramaManager.lookupWME("DAWME").listIterator();
                while (listIterator2.hasNext()) {
                    final DAWME dawme = listIterator2.next();
                    if (dawme.getTimestamp() == ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l) {
                        final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                        final int id2 = dawme.getId();
                        intValue2.i = id2;
                        if (!DramaManager.constantTrue(id2)) {
                            continue;
                        }
                        final VariableScope.IntValue intValue3 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("objectReference");
                        final int param1 = dawme.getParam1();
                        intValue3.i = param1;
                        if (!DramaManager.constantTrue(param1) || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || !BeatHelperFxns.isAASubtopic(((VariableScope.IntValue)variableScopeThrowsErrors.getValue("objectReference")).i)) {
                            continue;
                        }
                        final VariableScope.IntValue intValue4 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType");
                        final int i = 1;
                        intValue4.i = i;
                        if (!DramaManager.constantTrue(i)) {
                            continue;
                        }
                        final VariableScope.IntValue intValue5 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("subtopic");
                        final int j = ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("objectReference")).i;
                        intValue5.i = j;
                        if (DramaManager.constantTrue(j)) {
                            variableScopeThrowsErrors.getParentVariable("unhandledAct").value = variableScopeThrowsErrors.getVariable("unhandledAct").value;
                            return true;
                        }
                        continue;
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean _ArtistAdvertising_TPA_T1_weighttest2(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_TPA_T1_weighttest2_scope");
        variableScopeThrowsErrors.defineVariable("daTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("daType", null, "int");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        final ListIterator listIterator = DramaManager.lookupWME("DAWME").listIterator();
        while (listIterator.hasNext()) {
            final DAWME value = listIterator.next();
            variableScopeThrowsErrors.getVariable("unhandledAct").value = value;
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp");
            final long timestamp = value.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && value.getHandledStatus() != 2) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                final int id = value.getId();
                intValue.i = id;
                if (!DramaManager.constantTrue(id) || value.getParam1() != 59 || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l > ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp() || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l <= ((BeatStartWME)variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value).getTimestamp()) {
                    continue;
                }
                final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType");
                final int i = 1;
                intValue2.i = i;
                if (DramaManager.constantTrue(i)) {
                    variableScopeThrowsErrors.getParentVariable("unhandledAct").value = variableScopeThrowsErrors.getVariable("unhandledAct").value;
                    return true;
                }
                continue;
            }
        }
        return false;
    }
    
    public static boolean _ArtistAdvertising_TPA_T1_prioritytest1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_TPA_T1_prioritytest1_scope");
        variableScopeThrowsErrors.defineVariable("abortTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("abortBeatID", null, "int");
        variableScopeThrowsErrors.defineVariable("abortReason", null, "int");
        final ListIterator listIterator = DramaManager.lookupWME("BeatAbortWME").listIterator();
        while (listIterator.hasNext()) {
            final BeatAbortWME beatAbortWME = listIterator.next();
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("abortTimestamp");
            final long timestamp = beatAbortWME.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && beatAbortWME.getBeatID() >= 9 && beatAbortWME.getBeatID() <= 11) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortBeatID");
                final int beatID = beatAbortWME.getBeatID();
                intValue.i = beatID;
                if (!DramaManager.constantTrue(beatID) || beatAbortWME.getBeatAbortReason() != 2) {
                    continue;
                }
                final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason");
                final int beatAbortReason = beatAbortWME.getBeatAbortReason();
                intValue2.i = beatAbortReason;
                if (DramaManager.constantTrue(beatAbortReason) && ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("abortTimestamp")).l > ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp() && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortBeatID")).i == ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getBeatID()) {
                    variableScopeThrowsErrors.getParentVariable("abortReason").value = variableScopeThrowsErrors.getVariable("abortReason").value;
                    return true;
                }
                continue;
            }
        }
        return false;
    }
    
    public static boolean _ArtistAdvertising_TPA_T1_prioritytest2(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_TPA_T1_prioritytest2_scope");
        variableScopeThrowsErrors.defineVariable("daTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("daType", null, "int");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        variableScopeThrowsErrors.defineVariable("objectReference", null, "int");
        final ListIterator listIterator = DramaManager.lookupWME("DAWME").listIterator();
        while (listIterator.hasNext()) {
            final DAWME value = listIterator.next();
            variableScopeThrowsErrors.getVariable("unhandledAct").value = value;
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp");
            final long timestamp = value.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && value.getHandledStatus() != 2) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                final int id = value.getId();
                intValue.i = id;
                if (!DramaManager.constantTrue(id) || value.getParam1() != 59 || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l <= ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp()) {
                    continue;
                }
                final ListIterator listIterator2 = DramaManager.lookupWME("DAWME").listIterator();
                while (listIterator2.hasNext()) {
                    final DAWME dawme = listIterator2.next();
                    if (dawme.getTimestamp() == ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l) {
                        final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                        final int id2 = dawme.getId();
                        intValue2.i = id2;
                        if (!DramaManager.constantTrue(id2)) {
                            continue;
                        }
                        final VariableScope.IntValue intValue3 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("objectReference");
                        final int param1 = dawme.getParam1();
                        intValue3.i = param1;
                        if (!DramaManager.constantTrue(param1) || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || !BeatHelperFxns.isAASubtopic(((VariableScope.IntValue)variableScopeThrowsErrors.getValue("objectReference")).i)) {
                            continue;
                        }
                        final VariableScope.IntValue intValue4 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType");
                        final int i = 1;
                        intValue4.i = i;
                        if (!DramaManager.constantTrue(i)) {
                            continue;
                        }
                        final VariableScope.IntValue intValue5 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("subtopic");
                        final int j = ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("objectReference")).i;
                        intValue5.i = j;
                        if (DramaManager.constantTrue(j)) {
                            variableScopeThrowsErrors.getParentVariable("unhandledAct").value = variableScopeThrowsErrors.getVariable("unhandledAct").value;
                            return true;
                        }
                        continue;
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean _ArtistAdvertising_TPA_T1_prioritytest3(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_TPA_T1_prioritytest3_scope");
        variableScopeThrowsErrors.defineVariable("daTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("daType", null, "int");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        final ListIterator listIterator = DramaManager.lookupWME("DAWME").listIterator();
        while (listIterator.hasNext()) {
            final DAWME value = listIterator.next();
            variableScopeThrowsErrors.getVariable("unhandledAct").value = value;
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp");
            final long timestamp = value.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && value.getHandledStatus() != 2) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                final int id = value.getId();
                intValue.i = id;
                if (!DramaManager.constantTrue(id) || value.getParam1() != 59 || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l <= ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp()) {
                    continue;
                }
                final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType");
                final int i = 1;
                intValue2.i = i;
                if (DramaManager.constantTrue(i)) {
                    variableScopeThrowsErrors.getParentVariable("unhandledAct").value = variableScopeThrowsErrors.getVariable("unhandledAct").value;
                    return true;
                }
                continue;
            }
        }
        return false;
    }
    
    public static boolean _RockyMarriage_N_T1_precondition1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_RockyMarriage_N_T1_precondition1_scope");
        variableScopeThrowsErrors.defineVariable("storyStatusWME", null, "StoryStatusWME");
        final ListIterator<StoryStatusWME> listIterator = (ListIterator<StoryStatusWME>)DramaManager.lookupWME("StoryStatusWME").listIterator();
        while (listIterator.hasNext()) {
            final StoryStatusWME storyStatusWME = listIterator.next();
            if (storyStatusWME.getBeatCount() > 4 && storyStatusWME.getAffinity() == 0) {
                final ListIterator<TensionStoryValueWME> listIterator2 = (ListIterator<TensionStoryValueWME>)DramaManager.lookupWME("TensionStoryValueWME").listIterator();
                while (listIterator2.hasNext()) {
                    if (((TensionStoryValueWME)listIterator2.next()).getValue() == 1.0f) {
                        final ListIterator<BeatCompletedWME> listIterator3 = (ListIterator<BeatCompletedWME>)DramaManager.lookupWME("BeatCompletedWME").listIterator();
                        while (listIterator3.hasNext()) {
                            final BeatCompletedWME beatCompletedWME = listIterator3.next();
                            if (beatCompletedWME.getBeatID() >= 14 && beatCompletedWME.getBeatID() <= 16) {
                                return false;
                            }
                        }
                        final ListIterator<BeatAbortWME> listIterator4 = (ListIterator<BeatAbortWME>)DramaManager.lookupWME("BeatAbortWME").listIterator();
                        while (listIterator4.hasNext()) {
                            final BeatAbortWME beatAbortWME = listIterator4.next();
                            if (beatAbortWME.getBeatID() >= 14 && beatAbortWME.getBeatID() <= 16) {
                                return false;
                            }
                        }
                        final ListIterator<StoryStatusWME> listIterator5 = (ListIterator<StoryStatusWME>)DramaManager.lookupWME("StoryStatusWME").listIterator();
                        while (listIterator5.hasNext()) {
                            final StoryStatusWME value = listIterator5.next();
                            variableScopeThrowsErrors.getVariable("storyStatusWME").value = value;
                            if (value.getStoryTopicBeatCount() < 2) {
                                variableScopeThrowsErrors.getParentVariable("storyStatusWME").value = variableScopeThrowsErrors.getVariable("storyStatusWME").value;
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean _RockyMarriage_N_T1_weighttest1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_RockyMarriage_N_T1_weighttest1_scope");
        variableScopeThrowsErrors.defineVariable("daTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("daType", null, "int");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        final ListIterator listIterator = DramaManager.lookupWME("DAWME").listIterator();
        while (listIterator.hasNext()) {
            final DAWME value = listIterator.next();
            variableScopeThrowsErrors.getVariable("unhandledAct").value = value;
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp");
            final long timestamp = value.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && value.getHandledStatus() != 2) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                final int id = value.getId();
                intValue.i = id;
                if (!DramaManager.constantTrue(id) || value.getParam1() != 61 || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l > ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp() || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l <= ((BeatStartWME)variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value).getTimestamp()) {
                    continue;
                }
                final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType");
                final int i = 1;
                intValue2.i = i;
                if (DramaManager.constantTrue(i)) {
                    variableScopeThrowsErrors.getParentVariable("unhandledAct").value = variableScopeThrowsErrors.getVariable("unhandledAct").value;
                    return true;
                }
                continue;
            }
        }
        return false;
    }
    
    public static boolean _RockyMarriage_N_T1_prioritytest1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_RockyMarriage_N_T1_prioritytest1_scope");
        variableScopeThrowsErrors.defineVariable("daTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("daType", null, "int");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        final ListIterator listIterator = DramaManager.lookupWME("DAWME").listIterator();
        while (listIterator.hasNext()) {
            final DAWME value = listIterator.next();
            variableScopeThrowsErrors.getVariable("unhandledAct").value = value;
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp");
            final long timestamp = value.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && value.getHandledStatus() != 2) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                final int id = value.getId();
                intValue.i = id;
                if (!DramaManager.constantTrue(id) || value.getParam1() != 61 || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l <= ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp()) {
                    continue;
                }
                final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType");
                final int i = 1;
                intValue2.i = i;
                if (DramaManager.constantTrue(i)) {
                    variableScopeThrowsErrors.getParentVariable("unhandledAct").value = variableScopeThrowsErrors.getVariable("unhandledAct").value;
                    return true;
                }
                continue;
            }
        }
        return false;
    }
    
    public static boolean _RockyMarriage_GPA_T1_precondition1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_RockyMarriage_GPA_T1_precondition1_scope");
        variableScopeThrowsErrors.defineVariable("storyStatusWME", null, "StoryStatusWME");
        final ListIterator<StoryStatusWME> listIterator = (ListIterator<StoryStatusWME>)DramaManager.lookupWME("StoryStatusWME").listIterator();
        while (listIterator.hasNext()) {
            final StoryStatusWME storyStatusWME = listIterator.next();
            if (storyStatusWME.getBeatCount() > 4 && storyStatusWME.getAffinity() <= -1) {
                final ListIterator<TensionStoryValueWME> listIterator2 = (ListIterator<TensionStoryValueWME>)DramaManager.lookupWME("TensionStoryValueWME").listIterator();
                while (listIterator2.hasNext()) {
                    if (((TensionStoryValueWME)listIterator2.next()).getValue() == 1.0f) {
                        final ListIterator<BeatCompletedWME> listIterator3 = (ListIterator<BeatCompletedWME>)DramaManager.lookupWME("BeatCompletedWME").listIterator();
                        while (listIterator3.hasNext()) {
                            final BeatCompletedWME beatCompletedWME = listIterator3.next();
                            if (beatCompletedWME.getBeatID() >= 14 && beatCompletedWME.getBeatID() <= 16) {
                                return false;
                            }
                        }
                        final ListIterator<BeatAbortWME> listIterator4 = (ListIterator<BeatAbortWME>)DramaManager.lookupWME("BeatAbortWME").listIterator();
                        while (listIterator4.hasNext()) {
                            final BeatAbortWME beatAbortWME = listIterator4.next();
                            if (beatAbortWME.getBeatID() >= 14 && beatAbortWME.getBeatID() <= 16) {
                                return false;
                            }
                        }
                        final ListIterator<StoryStatusWME> listIterator5 = (ListIterator<StoryStatusWME>)DramaManager.lookupWME("StoryStatusWME").listIterator();
                        while (listIterator5.hasNext()) {
                            final StoryStatusWME value = listIterator5.next();
                            variableScopeThrowsErrors.getVariable("storyStatusWME").value = value;
                            if (value.getStoryTopicBeatCount() < 2) {
                                variableScopeThrowsErrors.getParentVariable("storyStatusWME").value = variableScopeThrowsErrors.getVariable("storyStatusWME").value;
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean _RockyMarriage_GPA_T1_weighttest1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_RockyMarriage_GPA_T1_weighttest1_scope");
        variableScopeThrowsErrors.defineVariable("daTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("daType", null, "int");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        final ListIterator listIterator = DramaManager.lookupWME("DAWME").listIterator();
        while (listIterator.hasNext()) {
            final DAWME value = listIterator.next();
            variableScopeThrowsErrors.getVariable("unhandledAct").value = value;
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp");
            final long timestamp = value.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && value.getHandledStatus() != 2) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                final int id = value.getId();
                intValue.i = id;
                if (!DramaManager.constantTrue(id) || value.getParam1() != 61 || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l > ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp() || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l <= ((BeatStartWME)variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value).getTimestamp()) {
                    continue;
                }
                final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType");
                final int i = 1;
                intValue2.i = i;
                if (DramaManager.constantTrue(i)) {
                    variableScopeThrowsErrors.getParentVariable("unhandledAct").value = variableScopeThrowsErrors.getVariable("unhandledAct").value;
                    return true;
                }
                continue;
            }
        }
        return false;
    }
    
    public static boolean _RockyMarriage_GPA_T1_prioritytest1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_RockyMarriage_GPA_T1_prioritytest1_scope");
        variableScopeThrowsErrors.defineVariable("daTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("daType", null, "int");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        final ListIterator listIterator = DramaManager.lookupWME("DAWME").listIterator();
        while (listIterator.hasNext()) {
            final DAWME value = listIterator.next();
            variableScopeThrowsErrors.getVariable("unhandledAct").value = value;
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp");
            final long timestamp = value.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && value.getHandledStatus() != 2) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                final int id = value.getId();
                intValue.i = id;
                if (!DramaManager.constantTrue(id) || value.getParam1() != 61 || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l <= ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp()) {
                    continue;
                }
                final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType");
                final int i = 1;
                intValue2.i = i;
                if (DramaManager.constantTrue(i)) {
                    variableScopeThrowsErrors.getParentVariable("unhandledAct").value = variableScopeThrowsErrors.getVariable("unhandledAct").value;
                    return true;
                }
                continue;
            }
        }
        return false;
    }
    
    public static boolean _RockyMarriage_TPA_T1_precondition1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_RockyMarriage_TPA_T1_precondition1_scope");
        variableScopeThrowsErrors.defineVariable("storyStatusWME", null, "StoryStatusWME");
        final ListIterator<StoryStatusWME> listIterator = (ListIterator<StoryStatusWME>)DramaManager.lookupWME("StoryStatusWME").listIterator();
        while (listIterator.hasNext()) {
            final StoryStatusWME storyStatusWME = listIterator.next();
            if (storyStatusWME.getBeatCount() > 4 && storyStatusWME.getAffinity() >= 1) {
                final ListIterator<TensionStoryValueWME> listIterator2 = (ListIterator<TensionStoryValueWME>)DramaManager.lookupWME("TensionStoryValueWME").listIterator();
                while (listIterator2.hasNext()) {
                    if (((TensionStoryValueWME)listIterator2.next()).getValue() == 1.0f) {
                        final ListIterator<BeatCompletedWME> listIterator3 = (ListIterator<BeatCompletedWME>)DramaManager.lookupWME("BeatCompletedWME").listIterator();
                        while (listIterator3.hasNext()) {
                            final BeatCompletedWME beatCompletedWME = listIterator3.next();
                            if (beatCompletedWME.getBeatID() >= 14 && beatCompletedWME.getBeatID() <= 16) {
                                return false;
                            }
                        }
                        final ListIterator<BeatAbortWME> listIterator4 = (ListIterator<BeatAbortWME>)DramaManager.lookupWME("BeatAbortWME").listIterator();
                        while (listIterator4.hasNext()) {
                            final BeatAbortWME beatAbortWME = listIterator4.next();
                            if (beatAbortWME.getBeatID() >= 14 && beatAbortWME.getBeatID() <= 16) {
                                return false;
                            }
                        }
                        final ListIterator<StoryStatusWME> listIterator5 = (ListIterator<StoryStatusWME>)DramaManager.lookupWME("StoryStatusWME").listIterator();
                        while (listIterator5.hasNext()) {
                            final StoryStatusWME value = listIterator5.next();
                            variableScopeThrowsErrors.getVariable("storyStatusWME").value = value;
                            if (value.getStoryTopicBeatCount() < 2) {
                                variableScopeThrowsErrors.getParentVariable("storyStatusWME").value = variableScopeThrowsErrors.getVariable("storyStatusWME").value;
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean _RockyMarriage_TPA_T1_weighttest1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_RockyMarriage_TPA_T1_weighttest1_scope");
        variableScopeThrowsErrors.defineVariable("daTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("daType", null, "int");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        final ListIterator listIterator = DramaManager.lookupWME("DAWME").listIterator();
        while (listIterator.hasNext()) {
            final DAWME value = listIterator.next();
            variableScopeThrowsErrors.getVariable("unhandledAct").value = value;
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp");
            final long timestamp = value.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && value.getHandledStatus() != 2) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                final int id = value.getId();
                intValue.i = id;
                if (!DramaManager.constantTrue(id) || value.getParam1() != 61 || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l > ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp() || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l <= ((BeatStartWME)variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value).getTimestamp()) {
                    continue;
                }
                final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType");
                final int i = 1;
                intValue2.i = i;
                if (DramaManager.constantTrue(i)) {
                    variableScopeThrowsErrors.getParentVariable("unhandledAct").value = variableScopeThrowsErrors.getVariable("unhandledAct").value;
                    return true;
                }
                continue;
            }
        }
        return false;
    }
    
    public static boolean _RockyMarriage_TPA_T1_prioritytest1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_RockyMarriage_TPA_T1_prioritytest1_scope");
        variableScopeThrowsErrors.defineVariable("daTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("daType", null, "int");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        final ListIterator listIterator = DramaManager.lookupWME("DAWME").listIterator();
        while (listIterator.hasNext()) {
            final DAWME value = listIterator.next();
            variableScopeThrowsErrors.getVariable("unhandledAct").value = value;
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp");
            final long timestamp = value.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && value.getHandledStatus() != 2) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                final int id = value.getId();
                intValue.i = id;
                if (!DramaManager.constantTrue(id) || value.getParam1() != 61 || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l <= ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp()) {
                    continue;
                }
                final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType");
                final int i = 1;
                intValue2.i = i;
                if (DramaManager.constantTrue(i)) {
                    variableScopeThrowsErrors.getParentVariable("unhandledAct").value = variableScopeThrowsErrors.getVariable("unhandledAct").value;
                    return true;
                }
                continue;
            }
        }
        return false;
    }
    
    public static boolean _Facade_NTPA_T1_precondition1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_Facade_NTPA_T1_precondition1_scope");
        variableScopeThrowsErrors.defineVariable("storyStatusWME", null, "StoryStatusWME");
        final ListIterator<StoryStatusWME> listIterator = (ListIterator<StoryStatusWME>)DramaManager.lookupWME("StoryStatusWME").listIterator();
        while (listIterator.hasNext()) {
            final StoryStatusWME storyStatusWME = listIterator.next();
            if (storyStatusWME.getBeatCount() > 4 && storyStatusWME.getAffinity() >= 0) {
                final ListIterator<TensionStoryValueWME> listIterator2 = (ListIterator<TensionStoryValueWME>)DramaManager.lookupWME("TensionStoryValueWME").listIterator();
                while (listIterator2.hasNext()) {
                    if (((TensionStoryValueWME)listIterator2.next()).getValue() == 1.0f) {
                        final ListIterator<BeatCompletedWME> listIterator3 = (ListIterator<BeatCompletedWME>)DramaManager.lookupWME("BeatCompletedWME").listIterator();
                        while (listIterator3.hasNext()) {
                            final BeatCompletedWME beatCompletedWME = listIterator3.next();
                            if (beatCompletedWME.getBeatID() >= 12 && beatCompletedWME.getBeatID() <= 13) {
                                return false;
                            }
                        }
                        final ListIterator<BeatAbortWME> listIterator4 = (ListIterator<BeatAbortWME>)DramaManager.lookupWME("BeatAbortWME").listIterator();
                        while (listIterator4.hasNext()) {
                            final BeatAbortWME beatAbortWME = listIterator4.next();
                            if (beatAbortWME.getBeatID() >= 12 && beatAbortWME.getBeatID() <= 13) {
                                return false;
                            }
                        }
                        final ListIterator<StoryStatusWME> listIterator5 = (ListIterator<StoryStatusWME>)DramaManager.lookupWME("StoryStatusWME").listIterator();
                        while (listIterator5.hasNext()) {
                            final StoryStatusWME value = listIterator5.next();
                            variableScopeThrowsErrors.getVariable("storyStatusWME").value = value;
                            if (value.getStoryTopicBeatCount() < 2) {
                                variableScopeThrowsErrors.getParentVariable("storyStatusWME").value = variableScopeThrowsErrors.getVariable("storyStatusWME").value;
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean _Facade_NTPA_T1_weighttest1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_Facade_NTPA_T1_weighttest1_scope");
        variableScopeThrowsErrors.defineVariable("daTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("daType", null, "int");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        final ListIterator listIterator = DramaManager.lookupWME("DAWME").listIterator();
        while (listIterator.hasNext()) {
            final DAWME value = listIterator.next();
            variableScopeThrowsErrors.getVariable("unhandledAct").value = value;
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp");
            final long timestamp = value.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && value.getHandledStatus() != 2) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                final int id = value.getId();
                intValue.i = id;
                if (!DramaManager.constantTrue(id) || value.getParam1() != 60 || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l > ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp() || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l <= ((BeatStartWME)variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value).getTimestamp()) {
                    continue;
                }
                final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType");
                final int i = 1;
                intValue2.i = i;
                if (DramaManager.constantTrue(i)) {
                    variableScopeThrowsErrors.getParentVariable("unhandledAct").value = variableScopeThrowsErrors.getVariable("unhandledAct").value;
                    return true;
                }
                continue;
            }
        }
        return false;
    }
    
    public static boolean _Facade_NTPA_T1_prioritytest1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_Facade_NTPA_T1_prioritytest1_scope");
        variableScopeThrowsErrors.defineVariable("daTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("daType", null, "int");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        final ListIterator listIterator = DramaManager.lookupWME("DAWME").listIterator();
        while (listIterator.hasNext()) {
            final DAWME value = listIterator.next();
            variableScopeThrowsErrors.getVariable("unhandledAct").value = value;
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp");
            final long timestamp = value.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && value.getHandledStatus() != 2) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                final int id = value.getId();
                intValue.i = id;
                if (!DramaManager.constantTrue(id) || value.getParam1() != 60 || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l <= ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp()) {
                    continue;
                }
                final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType");
                final int i = 1;
                intValue2.i = i;
                if (DramaManager.constantTrue(i)) {
                    variableScopeThrowsErrors.getParentVariable("unhandledAct").value = variableScopeThrowsErrors.getVariable("unhandledAct").value;
                    return true;
                }
                continue;
            }
        }
        return false;
    }
    
    public static boolean _Facade_GPA_T1_precondition1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_Facade_GPA_T1_precondition1_scope");
        variableScopeThrowsErrors.defineVariable("storyStatusWME", null, "StoryStatusWME");
        final ListIterator<StoryStatusWME> listIterator = (ListIterator<StoryStatusWME>)DramaManager.lookupWME("StoryStatusWME").listIterator();
        while (listIterator.hasNext()) {
            final StoryStatusWME storyStatusWME = listIterator.next();
            if (storyStatusWME.getBeatCount() > 4 && storyStatusWME.getAffinity() <= -1) {
                final ListIterator<TensionStoryValueWME> listIterator2 = (ListIterator<TensionStoryValueWME>)DramaManager.lookupWME("TensionStoryValueWME").listIterator();
                while (listIterator2.hasNext()) {
                    if (((TensionStoryValueWME)listIterator2.next()).getValue() == 1.0f) {
                        final ListIterator<BeatCompletedWME> listIterator3 = (ListIterator<BeatCompletedWME>)DramaManager.lookupWME("BeatCompletedWME").listIterator();
                        while (listIterator3.hasNext()) {
                            final BeatCompletedWME beatCompletedWME = listIterator3.next();
                            if (beatCompletedWME.getBeatID() >= 12 && beatCompletedWME.getBeatID() <= 13) {
                                return false;
                            }
                        }
                        final ListIterator<BeatAbortWME> listIterator4 = (ListIterator<BeatAbortWME>)DramaManager.lookupWME("BeatAbortWME").listIterator();
                        while (listIterator4.hasNext()) {
                            final BeatAbortWME beatAbortWME = listIterator4.next();
                            if (beatAbortWME.getBeatID() >= 12 && beatAbortWME.getBeatID() <= 13) {
                                return false;
                            }
                        }
                        final ListIterator<StoryStatusWME> listIterator5 = (ListIterator<StoryStatusWME>)DramaManager.lookupWME("StoryStatusWME").listIterator();
                        while (listIterator5.hasNext()) {
                            final StoryStatusWME value = listIterator5.next();
                            variableScopeThrowsErrors.getVariable("storyStatusWME").value = value;
                            if (value.getStoryTopicBeatCount() < 2) {
                                variableScopeThrowsErrors.getParentVariable("storyStatusWME").value = variableScopeThrowsErrors.getVariable("storyStatusWME").value;
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean _Facade_GPA_T1_weighttest1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_Facade_GPA_T1_weighttest1_scope");
        variableScopeThrowsErrors.defineVariable("daTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("daType", null, "int");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        final ListIterator listIterator = DramaManager.lookupWME("DAWME").listIterator();
        while (listIterator.hasNext()) {
            final DAWME value = listIterator.next();
            variableScopeThrowsErrors.getVariable("unhandledAct").value = value;
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp");
            final long timestamp = value.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && value.getHandledStatus() != 2) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                final int id = value.getId();
                intValue.i = id;
                if (!DramaManager.constantTrue(id) || value.getParam1() != 60 || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l > ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp() || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l <= ((BeatStartWME)variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value).getTimestamp()) {
                    continue;
                }
                final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType");
                final int i = 1;
                intValue2.i = i;
                if (DramaManager.constantTrue(i)) {
                    variableScopeThrowsErrors.getParentVariable("unhandledAct").value = variableScopeThrowsErrors.getVariable("unhandledAct").value;
                    return true;
                }
                continue;
            }
        }
        return false;
    }
    
    public static boolean _Facade_GPA_T1_prioritytest1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_Facade_GPA_T1_prioritytest1_scope");
        variableScopeThrowsErrors.defineVariable("daTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("daType", null, "int");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        final ListIterator listIterator = DramaManager.lookupWME("DAWME").listIterator();
        while (listIterator.hasNext()) {
            final DAWME value = listIterator.next();
            variableScopeThrowsErrors.getVariable("unhandledAct").value = value;
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp");
            final long timestamp = value.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && value.getHandledStatus() != 2) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                final int id = value.getId();
                intValue.i = id;
                if (!DramaManager.constantTrue(id) || value.getParam1() != 60 || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l <= ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp()) {
                    continue;
                }
                final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType");
                final int i = 1;
                intValue2.i = i;
                if (DramaManager.constantTrue(i)) {
                    variableScopeThrowsErrors.getParentVariable("unhandledAct").value = variableScopeThrowsErrors.getVariable("unhandledAct").value;
                    return true;
                }
                continue;
            }
        }
        return false;
    }
    
    public static boolean _TxnT1ToT2NGPA_precondition1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_TxnT1ToT2NGPA_precondition1_scope");
        final ListIterator<StoryStatusWME> listIterator = (ListIterator<StoryStatusWME>)DramaManager.lookupWME("StoryStatusWME").listIterator();
        while (listIterator.hasNext()) {
            final StoryStatusWME storyStatusWME = listIterator.next();
            if (storyStatusWME.getBeatCount() > 4 && storyStatusWME.getAffinity() <= 0) {
                final ListIterator<TensionStoryValueWME> listIterator2 = (ListIterator<TensionStoryValueWME>)DramaManager.lookupWME("TensionStoryValueWME").listIterator();
                while (listIterator2.hasNext()) {
                    if (((TensionStoryValueWME)listIterator2.next()).getValue() == 1.0f) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean _TxnT1ToT2NGPA_prioritytest1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_TxnT1ToT2NGPA_prioritytest1_scope");
        variableScopeThrowsErrors.defineVariable("count", null, "int");
        final ListIterator listIterator = DramaManager.lookupWME("StoryStatusWME").listIterator();
        while (listIterator.hasNext()) {
            final StoryStatusWME storyStatusWME = listIterator.next();
            final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("count");
            final int beatCount = storyStatusWME.getBeatCount();
            intValue.i = beatCount;
            if (DramaManager.constantTrue(beatCount) && DramaManager.getDramaManager().getStoryTarget("tension").getDesiredValue(((VariableScope.IntValue)variableScopeThrowsErrors.getValue("count")).i) > 1.0f) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean _TxnT1ToT2TPA_precondition1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_TxnT1ToT2TPA_precondition1_scope");
        final ListIterator<StoryStatusWME> listIterator = (ListIterator<StoryStatusWME>)DramaManager.lookupWME("StoryStatusWME").listIterator();
        while (listIterator.hasNext()) {
            final StoryStatusWME storyStatusWME = listIterator.next();
            if (storyStatusWME.getBeatCount() > 4 && storyStatusWME.getAffinity() >= 1) {
                final ListIterator<TensionStoryValueWME> listIterator2 = (ListIterator<TensionStoryValueWME>)DramaManager.lookupWME("TensionStoryValueWME").listIterator();
                while (listIterator2.hasNext()) {
                    if (((TensionStoryValueWME)listIterator2.next()).getValue() == 1.0f) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean _TxnT1ToT2TPA_prioritytest1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_TxnT1ToT2TPA_prioritytest1_scope");
        variableScopeThrowsErrors.defineVariable("count", null, "int");
        final ListIterator listIterator = DramaManager.lookupWME("StoryStatusWME").listIterator();
        while (listIterator.hasNext()) {
            final StoryStatusWME storyStatusWME = listIterator.next();
            final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("count");
            final int beatCount = storyStatusWME.getBeatCount();
            intValue.i = beatCount;
            if (DramaManager.constantTrue(beatCount) && DramaManager.getDramaManager().getStoryTarget("tension").getDesiredValue(((VariableScope.IntValue)variableScopeThrowsErrors.getValue("count")).i) > 1.0f) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean _OneOnOneGAffChr_T2_precondition1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_OneOnOneGAffChr_T2_precondition1_scope");
        final ListIterator<TensionStoryValueWME> listIterator = (ListIterator<TensionStoryValueWME>)DramaManager.lookupWME("TensionStoryValueWME").listIterator();
        while (listIterator.hasNext()) {
            if (((TensionStoryValueWME)listIterator.next()).getValue() == 2.0f) {
                final ListIterator<StoryStatusWME> listIterator2 = (ListIterator<StoryStatusWME>)DramaManager.lookupWME("StoryStatusWME").listIterator();
                while (listIterator2.hasNext()) {
                    if (((StoryStatusWME)listIterator2.next()).getAffinity() <= -1) {
                        final ListIterator listIterator3 = WorkingMemory.lookupWME("BeatMemory", "BeatStatusWME").listIterator();
                        while (listIterator3.hasNext()) {
                            if (listIterator3.next().getAbortReason() == 3) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean _OneOnOneTAffChr_T2_precondition1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_OneOnOneTAffChr_T2_precondition1_scope");
        final ListIterator<TensionStoryValueWME> listIterator = (ListIterator<TensionStoryValueWME>)DramaManager.lookupWME("TensionStoryValueWME").listIterator();
        while (listIterator.hasNext()) {
            if (((TensionStoryValueWME)listIterator.next()).getValue() == 2.0f) {
                final ListIterator<StoryStatusWME> listIterator2 = (ListIterator<StoryStatusWME>)DramaManager.lookupWME("StoryStatusWME").listIterator();
                while (listIterator2.hasNext()) {
                    if (((StoryStatusWME)listIterator2.next()).getAffinity() >= 1) {
                        final ListIterator listIterator3 = WorkingMemory.lookupWME("BeatMemory", "BeatStatusWME").listIterator();
                        while (listIterator3.hasNext()) {
                            if (listIterator3.next().getAbortReason() == 3) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean _NonAffChrGReturns_T2_precondition1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_NonAffChrGReturns_T2_precondition1_scope");
        variableScopeThrowsErrors.defineVariable("lastBeatID", null, "int");
        final ListIterator listIterator = DramaManager.lookupWME("BeatStartWME").listIterator();
        while (listIterator.hasNext()) {
            final BeatStartWME beatStartWME = listIterator.next();
            final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("lastBeatID");
            final int beatID = beatStartWME.getBeatID();
            intValue.i = beatID;
            if (DramaManager.constantTrue(beatID) && beatStartWME.getBeatID() == 24 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("lastBeatID")).i == ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getBeatID()) {
                final ListIterator listIterator2 = DramaManager.lookupWME("BeatAbortWME").listIterator();
                while (listIterator2.hasNext()) {
                    if (listIterator2.next().getBeatID() == ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("lastBeatID")).i) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
    
    public static boolean _NonAffChrTReturns_T2_precondition1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_NonAffChrTReturns_T2_precondition1_scope");
        variableScopeThrowsErrors.defineVariable("lastBeatID", null, "int");
        final ListIterator listIterator = DramaManager.lookupWME("BeatStartWME").listIterator();
        while (listIterator.hasNext()) {
            final BeatStartWME beatStartWME = listIterator.next();
            final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("lastBeatID");
            final int beatID = beatStartWME.getBeatID();
            intValue.i = beatID;
            if (DramaManager.constantTrue(beatID) && beatStartWME.getBeatID() == 23 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("lastBeatID")).i == ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getBeatID()) {
                final ListIterator listIterator2 = DramaManager.lookupWME("BeatAbortWME").listIterator();
                while (listIterator2.hasNext()) {
                    if (listIterator2.next().getBeatID() == ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("lastBeatID")).i) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
    
    public static boolean _OneOnOneGNonAffChr_T2_precondition1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_OneOnOneGNonAffChr_T2_precondition1_scope");
        variableScopeThrowsErrors.defineVariable("lastBeatID", null, "int");
        final ListIterator listIterator = DramaManager.lookupWME("BeatStartWME").listIterator();
        while (listIterator.hasNext()) {
            final BeatStartWME beatStartWME = listIterator.next();
            final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("lastBeatID");
            final int beatID = beatStartWME.getBeatID();
            intValue.i = beatID;
            if (DramaManager.constantTrue(beatID) && beatStartWME.getBeatID() == 24 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("lastBeatID")).i == ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getBeatID()) {
                final ListIterator listIterator2 = DramaManager.lookupWME("BeatAbortWME").listIterator();
                while (listIterator2.hasNext()) {
                    if (listIterator2.next().getBeatID() == ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("lastBeatID")).i) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean _OneOnOneTNonAffChr_T2_precondition1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_OneOnOneTNonAffChr_T2_precondition1_scope");
        variableScopeThrowsErrors.defineVariable("lastBeatID", null, "int");
        final ListIterator listIterator = DramaManager.lookupWME("BeatStartWME").listIterator();
        while (listIterator.hasNext()) {
            final BeatStartWME beatStartWME = listIterator.next();
            final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("lastBeatID");
            final int beatID = beatStartWME.getBeatID();
            intValue.i = beatID;
            if (DramaManager.constantTrue(beatID) && beatStartWME.getBeatID() == 23 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("lastBeatID")).i == ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getBeatID()) {
                final ListIterator listIterator2 = DramaManager.lookupWME("BeatAbortWME").listIterator();
                while (listIterator2.hasNext()) {
                    if (listIterator2.next().getBeatID() == ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("lastBeatID")).i) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean _ArtistAdvertising_GPA_T2_precondition1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_GPA_T2_precondition1_scope");
        variableScopeThrowsErrors.defineVariable("storyStatusWME", null, "StoryStatusWME");
        final ListIterator<StoryStatusWME> listIterator = (ListIterator<StoryStatusWME>)DramaManager.lookupWME("StoryStatusWME").listIterator();
        while (listIterator.hasNext()) {
            if (((StoryStatusWME)listIterator.next()).getAffinity() <= -1) {
                final ListIterator<TensionStoryValueWME> listIterator2 = (ListIterator<TensionStoryValueWME>)DramaManager.lookupWME("TensionStoryValueWME").listIterator();
                while (listIterator2.hasNext()) {
                    if (((TensionStoryValueWME)listIterator2.next()).getValue() == 2.0f) {
                        final ListIterator<BeatCompletedWME> listIterator3 = (ListIterator<BeatCompletedWME>)DramaManager.lookupWME("BeatCompletedWME").listIterator();
                        while (listIterator3.hasNext()) {
                            final BeatCompletedWME beatCompletedWME = listIterator3.next();
                            if (beatCompletedWME.getBeatID() >= 9 && beatCompletedWME.getBeatID() <= 11) {
                                return false;
                            }
                        }
                        final ListIterator<BeatCompletedWME> listIterator4 = (ListIterator<BeatCompletedWME>)DramaManager.lookupWME("BeatCompletedWME").listIterator();
                        while (listIterator4.hasNext()) {
                            final BeatCompletedWME beatCompletedWME2 = listIterator4.next();
                            if (beatCompletedWME2.getBeatID() >= 17 && beatCompletedWME2.getBeatID() <= 18) {
                                return false;
                            }
                        }
                        final ListIterator<BeatAbortWME> listIterator5 = (ListIterator<BeatAbortWME>)DramaManager.lookupWME("BeatAbortWME").listIterator();
                        while (listIterator5.hasNext()) {
                            final BeatAbortWME beatAbortWME = listIterator5.next();
                            if (beatAbortWME.getBeatID() >= 9 && beatAbortWME.getBeatID() <= 11) {
                                return false;
                            }
                        }
                        final ListIterator<BeatAbortWME> listIterator6 = (ListIterator<BeatAbortWME>)DramaManager.lookupWME("BeatAbortWME").listIterator();
                        while (listIterator6.hasNext()) {
                            final BeatAbortWME beatAbortWME2 = listIterator6.next();
                            if (beatAbortWME2.getBeatID() >= 17 && beatAbortWME2.getBeatID() <= 18) {
                                return false;
                            }
                        }
                        final ListIterator<StoryStatusWME> listIterator7 = (ListIterator<StoryStatusWME>)DramaManager.lookupWME("StoryStatusWME").listIterator();
                        while (listIterator7.hasNext()) {
                            final StoryStatusWME value = listIterator7.next();
                            variableScopeThrowsErrors.getVariable("storyStatusWME").value = value;
                            if (value.getStoryTopicBeatCount() < 2) {
                                variableScopeThrowsErrors.getParentVariable("storyStatusWME").value = variableScopeThrowsErrors.getVariable("storyStatusWME").value;
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean _ArtistAdvertising_GPA_T2_weighttest1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_GPA_T2_weighttest1_scope");
        variableScopeThrowsErrors.defineVariable("daTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("daType", null, "int");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        variableScopeThrowsErrors.defineVariable("objectReference", null, "int");
        final ListIterator listIterator = DramaManager.lookupWME("DAWME").listIterator();
        while (listIterator.hasNext()) {
            final DAWME value = listIterator.next();
            variableScopeThrowsErrors.getVariable("unhandledAct").value = value;
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp");
            final long timestamp = value.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && value.getHandledStatus() != 2) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                final int id = value.getId();
                intValue.i = id;
                if (!DramaManager.constantTrue(id) || value.getParam1() != 59 || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l > ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp() || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l <= ((BeatStartWME)variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value).getTimestamp()) {
                    continue;
                }
                final ListIterator listIterator2 = DramaManager.lookupWME("DAWME").listIterator();
                while (listIterator2.hasNext()) {
                    final DAWME dawme = listIterator2.next();
                    if (dawme.getTimestamp() == ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l) {
                        final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                        final int id2 = dawme.getId();
                        intValue2.i = id2;
                        if (!DramaManager.constantTrue(id2)) {
                            continue;
                        }
                        final VariableScope.IntValue intValue3 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("objectReference");
                        final int param1 = dawme.getParam1();
                        intValue3.i = param1;
                        if (!DramaManager.constantTrue(param1) || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || !BeatHelperFxns.isAASubtopic(((VariableScope.IntValue)variableScopeThrowsErrors.getValue("objectReference")).i)) {
                            continue;
                        }
                        final VariableScope.IntValue intValue4 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType");
                        final int i = 1;
                        intValue4.i = i;
                        if (!DramaManager.constantTrue(i)) {
                            continue;
                        }
                        final VariableScope.IntValue intValue5 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("subtopic");
                        final int j = ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("objectReference")).i;
                        intValue5.i = j;
                        if (DramaManager.constantTrue(j)) {
                            variableScopeThrowsErrors.getParentVariable("unhandledAct").value = variableScopeThrowsErrors.getVariable("unhandledAct").value;
                            return true;
                        }
                        continue;
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean _ArtistAdvertising_GPA_T2_weighttest2(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_GPA_T2_weighttest2_scope");
        variableScopeThrowsErrors.defineVariable("daTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("daType", null, "int");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        final ListIterator listIterator = DramaManager.lookupWME("DAWME").listIterator();
        while (listIterator.hasNext()) {
            final DAWME value = listIterator.next();
            variableScopeThrowsErrors.getVariable("unhandledAct").value = value;
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp");
            final long timestamp = value.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && value.getHandledStatus() != 2) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                final int id = value.getId();
                intValue.i = id;
                if (!DramaManager.constantTrue(id) || value.getParam1() != 59 || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l > ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp() || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l <= ((BeatStartWME)variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value).getTimestamp()) {
                    continue;
                }
                final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType");
                final int i = 1;
                intValue2.i = i;
                if (DramaManager.constantTrue(i)) {
                    variableScopeThrowsErrors.getParentVariable("unhandledAct").value = variableScopeThrowsErrors.getVariable("unhandledAct").value;
                    return true;
                }
                continue;
            }
        }
        return false;
    }
    
    public static boolean _ArtistAdvertising_GPA_T2_prioritytest1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_GPA_T2_prioritytest1_scope");
        variableScopeThrowsErrors.defineVariable("abortTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("abortBeatID", null, "int");
        variableScopeThrowsErrors.defineVariable("abortReason", null, "int");
        final ListIterator listIterator = DramaManager.lookupWME("BeatAbortWME").listIterator();
        while (listIterator.hasNext()) {
            final BeatAbortWME beatAbortWME = listIterator.next();
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("abortTimestamp");
            final long timestamp = beatAbortWME.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && beatAbortWME.getBeatID() >= 17 && beatAbortWME.getBeatID() <= 18) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortBeatID");
                final int beatID = beatAbortWME.getBeatID();
                intValue.i = beatID;
                if (!DramaManager.constantTrue(beatID) || beatAbortWME.getBeatAbortReason() != 1) {
                    continue;
                }
                final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason");
                final int beatAbortReason = beatAbortWME.getBeatAbortReason();
                intValue2.i = beatAbortReason;
                if (DramaManager.constantTrue(beatAbortReason) && ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("abortTimestamp")).l > ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp() && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortBeatID")).i == ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getBeatID()) {
                    variableScopeThrowsErrors.getParentVariable("abortReason").value = variableScopeThrowsErrors.getVariable("abortReason").value;
                    return true;
                }
                continue;
            }
        }
        return false;
    }
    
    public static boolean _ArtistAdvertising_GPA_T2_prioritytest2(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_GPA_T2_prioritytest2_scope");
        variableScopeThrowsErrors.defineVariable("daTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("daType", null, "int");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        variableScopeThrowsErrors.defineVariable("objectReference", null, "int");
        final ListIterator listIterator = DramaManager.lookupWME("DAWME").listIterator();
        while (listIterator.hasNext()) {
            final DAWME value = listIterator.next();
            variableScopeThrowsErrors.getVariable("unhandledAct").value = value;
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp");
            final long timestamp = value.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && value.getHandledStatus() != 2) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                final int id = value.getId();
                intValue.i = id;
                if (!DramaManager.constantTrue(id) || value.getParam1() != 59 || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l <= ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp()) {
                    continue;
                }
                final ListIterator listIterator2 = DramaManager.lookupWME("DAWME").listIterator();
                while (listIterator2.hasNext()) {
                    final DAWME dawme = listIterator2.next();
                    if (dawme.getTimestamp() == ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l) {
                        final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                        final int id2 = dawme.getId();
                        intValue2.i = id2;
                        if (!DramaManager.constantTrue(id2)) {
                            continue;
                        }
                        final VariableScope.IntValue intValue3 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("objectReference");
                        final int param1 = dawme.getParam1();
                        intValue3.i = param1;
                        if (!DramaManager.constantTrue(param1) || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || !BeatHelperFxns.isAASubtopic(((VariableScope.IntValue)variableScopeThrowsErrors.getValue("objectReference")).i)) {
                            continue;
                        }
                        final VariableScope.IntValue intValue4 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType");
                        final int i = 1;
                        intValue4.i = i;
                        if (!DramaManager.constantTrue(i)) {
                            continue;
                        }
                        final VariableScope.IntValue intValue5 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("subtopic");
                        final int j = ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("objectReference")).i;
                        intValue5.i = j;
                        if (DramaManager.constantTrue(j)) {
                            variableScopeThrowsErrors.getParentVariable("unhandledAct").value = variableScopeThrowsErrors.getVariable("unhandledAct").value;
                            return true;
                        }
                        continue;
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean _ArtistAdvertising_GPA_T2_prioritytest3(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_GPA_T2_prioritytest3_scope");
        variableScopeThrowsErrors.defineVariable("daTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("daType", null, "int");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        final ListIterator listIterator = DramaManager.lookupWME("DAWME").listIterator();
        while (listIterator.hasNext()) {
            final DAWME value = listIterator.next();
            variableScopeThrowsErrors.getVariable("unhandledAct").value = value;
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp");
            final long timestamp = value.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && value.getHandledStatus() != 2) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                final int id = value.getId();
                intValue.i = id;
                if (!DramaManager.constantTrue(id) || value.getParam1() != 59 || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l <= ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp()) {
                    continue;
                }
                final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType");
                final int i = 1;
                intValue2.i = i;
                if (DramaManager.constantTrue(i)) {
                    variableScopeThrowsErrors.getParentVariable("unhandledAct").value = variableScopeThrowsErrors.getVariable("unhandledAct").value;
                    return true;
                }
                continue;
            }
        }
        return false;
    }
    
    public static boolean _ArtistAdvertising_GPA_T2ToT3_precondition1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_GPA_T2ToT3_precondition1_scope");
        variableScopeThrowsErrors.defineVariable("storyStatusWME", null, "StoryStatusWME");
        final ListIterator<StoryStatusWME> listIterator = (ListIterator<StoryStatusWME>)DramaManager.lookupWME("StoryStatusWME").listIterator();
        while (listIterator.hasNext()) {
            final StoryStatusWME value = listIterator.next();
            variableScopeThrowsErrors.getVariable("storyStatusWME").value = value;
            if (value.getAffinity() <= -1) {
                final ListIterator<TensionStoryValueWME> listIterator2 = (ListIterator<TensionStoryValueWME>)DramaManager.lookupWME("TensionStoryValueWME").listIterator();
                while (listIterator2.hasNext()) {
                    if (((TensionStoryValueWME)listIterator2.next()).getValue() == 2.0f) {
                        final ListIterator<BeatCompletedWME> listIterator3 = (ListIterator<BeatCompletedWME>)DramaManager.lookupWME("BeatCompletedWME").listIterator();
                        while (listIterator3.hasNext()) {
                            final BeatCompletedWME beatCompletedWME = listIterator3.next();
                            if (beatCompletedWME.getBeatID() >= 9 && beatCompletedWME.getBeatID() <= 11) {
                                return false;
                            }
                        }
                        final ListIterator<BeatCompletedWME> listIterator4 = (ListIterator<BeatCompletedWME>)DramaManager.lookupWME("BeatCompletedWME").listIterator();
                        while (listIterator4.hasNext()) {
                            final BeatCompletedWME beatCompletedWME2 = listIterator4.next();
                            if (beatCompletedWME2.getBeatID() >= 17 && beatCompletedWME2.getBeatID() <= 18) {
                                return false;
                            }
                        }
                        final ListIterator<BeatAbortWME> listIterator5 = (ListIterator<BeatAbortWME>)DramaManager.lookupWME("BeatAbortWME").listIterator();
                        while (listIterator5.hasNext()) {
                            final BeatAbortWME beatAbortWME = listIterator5.next();
                            if (beatAbortWME.getBeatID() >= 9 && beatAbortWME.getBeatID() <= 11) {
                                return false;
                            }
                        }
                        final ListIterator<BeatAbortWME> listIterator6 = (ListIterator<BeatAbortWME>)DramaManager.lookupWME("BeatAbortWME").listIterator();
                        while (listIterator6.hasNext()) {
                            final BeatAbortWME beatAbortWME2 = listIterator6.next();
                            if (beatAbortWME2.getBeatID() >= 17 && beatAbortWME2.getBeatID() <= 18) {
                                return false;
                            }
                        }
                        variableScopeThrowsErrors.getParentVariable("storyStatusWME").value = variableScopeThrowsErrors.getVariable("storyStatusWME").value;
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean _ArtistAdvertising_GPA_T2ToT3_weighttest1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_GPA_T2ToT3_weighttest1_scope");
        variableScopeThrowsErrors.defineVariable("daTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("daType", null, "int");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        variableScopeThrowsErrors.defineVariable("objectReference", null, "int");
        final ListIterator listIterator = DramaManager.lookupWME("DAWME").listIterator();
        while (listIterator.hasNext()) {
            final DAWME value = listIterator.next();
            variableScopeThrowsErrors.getVariable("unhandledAct").value = value;
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp");
            final long timestamp = value.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && value.getHandledStatus() != 2) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                final int id = value.getId();
                intValue.i = id;
                if (!DramaManager.constantTrue(id) || value.getParam1() != 59 || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l > ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp() || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l <= ((BeatStartWME)variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value).getTimestamp()) {
                    continue;
                }
                final ListIterator listIterator2 = DramaManager.lookupWME("DAWME").listIterator();
                while (listIterator2.hasNext()) {
                    final DAWME dawme = listIterator2.next();
                    if (dawme.getTimestamp() == ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l) {
                        final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                        final int id2 = dawme.getId();
                        intValue2.i = id2;
                        if (!DramaManager.constantTrue(id2)) {
                            continue;
                        }
                        final VariableScope.IntValue intValue3 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("objectReference");
                        final int param1 = dawme.getParam1();
                        intValue3.i = param1;
                        if (!DramaManager.constantTrue(param1) || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || !BeatHelperFxns.isAASubtopic(((VariableScope.IntValue)variableScopeThrowsErrors.getValue("objectReference")).i)) {
                            continue;
                        }
                        final VariableScope.IntValue intValue4 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType");
                        final int i = 1;
                        intValue4.i = i;
                        if (!DramaManager.constantTrue(i)) {
                            continue;
                        }
                        final VariableScope.IntValue intValue5 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("subtopic");
                        final int j = ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("objectReference")).i;
                        intValue5.i = j;
                        if (DramaManager.constantTrue(j)) {
                            variableScopeThrowsErrors.getParentVariable("unhandledAct").value = variableScopeThrowsErrors.getVariable("unhandledAct").value;
                            return true;
                        }
                        continue;
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean _ArtistAdvertising_GPA_T2ToT3_weighttest2(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_GPA_T2ToT3_weighttest2_scope");
        variableScopeThrowsErrors.defineVariable("daTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("daType", null, "int");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        final ListIterator listIterator = DramaManager.lookupWME("DAWME").listIterator();
        while (listIterator.hasNext()) {
            final DAWME value = listIterator.next();
            variableScopeThrowsErrors.getVariable("unhandledAct").value = value;
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp");
            final long timestamp = value.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && value.getHandledStatus() != 2) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                final int id = value.getId();
                intValue.i = id;
                if (!DramaManager.constantTrue(id) || value.getParam1() != 59 || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l > ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp() || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l <= ((BeatStartWME)variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value).getTimestamp()) {
                    continue;
                }
                final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType");
                final int i = 1;
                intValue2.i = i;
                if (DramaManager.constantTrue(i)) {
                    variableScopeThrowsErrors.getParentVariable("unhandledAct").value = variableScopeThrowsErrors.getVariable("unhandledAct").value;
                    return true;
                }
                continue;
            }
        }
        return false;
    }
    
    public static boolean _ArtistAdvertising_GPA_T2ToT3_prioritytest1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_GPA_T2ToT3_prioritytest1_scope");
        variableScopeThrowsErrors.defineVariable("abortTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("abortBeatID", null, "int");
        variableScopeThrowsErrors.defineVariable("abortReason", null, "int");
        final ListIterator listIterator = DramaManager.lookupWME("BeatAbortWME").listIterator();
        while (listIterator.hasNext()) {
            final BeatAbortWME beatAbortWME = listIterator.next();
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("abortTimestamp");
            final long timestamp = beatAbortWME.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && beatAbortWME.getBeatID() >= 17 && beatAbortWME.getBeatID() <= 18) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortBeatID");
                final int beatID = beatAbortWME.getBeatID();
                intValue.i = beatID;
                if (!DramaManager.constantTrue(beatID) || beatAbortWME.getBeatAbortReason() != 1) {
                    continue;
                }
                final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason");
                final int beatAbortReason = beatAbortWME.getBeatAbortReason();
                intValue2.i = beatAbortReason;
                if (DramaManager.constantTrue(beatAbortReason) && ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("abortTimestamp")).l > ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp() && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortBeatID")).i == ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getBeatID()) {
                    variableScopeThrowsErrors.getParentVariable("abortReason").value = variableScopeThrowsErrors.getVariable("abortReason").value;
                    return true;
                }
                continue;
            }
        }
        return false;
    }
    
    public static boolean _ArtistAdvertising_GPA_T2ToT3_prioritytest2(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_GPA_T2ToT3_prioritytest2_scope");
        variableScopeThrowsErrors.defineVariable("daTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("daType", null, "int");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        variableScopeThrowsErrors.defineVariable("objectReference", null, "int");
        final ListIterator listIterator = DramaManager.lookupWME("DAWME").listIterator();
        while (listIterator.hasNext()) {
            final DAWME value = listIterator.next();
            variableScopeThrowsErrors.getVariable("unhandledAct").value = value;
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp");
            final long timestamp = value.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && value.getHandledStatus() != 2) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                final int id = value.getId();
                intValue.i = id;
                if (!DramaManager.constantTrue(id) || value.getParam1() != 59 || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l <= ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp()) {
                    continue;
                }
                final ListIterator listIterator2 = DramaManager.lookupWME("DAWME").listIterator();
                while (listIterator2.hasNext()) {
                    final DAWME dawme = listIterator2.next();
                    if (dawme.getTimestamp() == ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l) {
                        final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                        final int id2 = dawme.getId();
                        intValue2.i = id2;
                        if (!DramaManager.constantTrue(id2)) {
                            continue;
                        }
                        final VariableScope.IntValue intValue3 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("objectReference");
                        final int param1 = dawme.getParam1();
                        intValue3.i = param1;
                        if (!DramaManager.constantTrue(param1) || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || !BeatHelperFxns.isAASubtopic(((VariableScope.IntValue)variableScopeThrowsErrors.getValue("objectReference")).i)) {
                            continue;
                        }
                        final VariableScope.IntValue intValue4 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType");
                        final int i = 1;
                        intValue4.i = i;
                        if (!DramaManager.constantTrue(i)) {
                            continue;
                        }
                        final VariableScope.IntValue intValue5 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("subtopic");
                        final int j = ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("objectReference")).i;
                        intValue5.i = j;
                        if (DramaManager.constantTrue(j)) {
                            variableScopeThrowsErrors.getParentVariable("unhandledAct").value = variableScopeThrowsErrors.getVariable("unhandledAct").value;
                            return true;
                        }
                        continue;
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean _ArtistAdvertising_GPA_T2ToT3_prioritytest3(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_GPA_T2ToT3_prioritytest3_scope");
        variableScopeThrowsErrors.defineVariable("daTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("daType", null, "int");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        final ListIterator listIterator = DramaManager.lookupWME("DAWME").listIterator();
        while (listIterator.hasNext()) {
            final DAWME value = listIterator.next();
            variableScopeThrowsErrors.getVariable("unhandledAct").value = value;
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp");
            final long timestamp = value.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && value.getHandledStatus() != 2) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                final int id = value.getId();
                intValue.i = id;
                if (!DramaManager.constantTrue(id) || value.getParam1() != 59 || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l <= ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp()) {
                    continue;
                }
                final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType");
                final int i = 1;
                intValue2.i = i;
                if (DramaManager.constantTrue(i)) {
                    variableScopeThrowsErrors.getParentVariable("unhandledAct").value = variableScopeThrowsErrors.getVariable("unhandledAct").value;
                    return true;
                }
                continue;
            }
        }
        return false;
    }
    
    public static boolean _ArtistAdvertising_TPA_T2_precondition1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_TPA_T2_precondition1_scope");
        variableScopeThrowsErrors.defineVariable("storyStatusWME", null, "StoryStatusWME");
        final ListIterator<StoryStatusWME> listIterator = (ListIterator<StoryStatusWME>)DramaManager.lookupWME("StoryStatusWME").listIterator();
        while (listIterator.hasNext()) {
            if (((StoryStatusWME)listIterator.next()).getAffinity() >= 1) {
                final ListIterator<TensionStoryValueWME> listIterator2 = (ListIterator<TensionStoryValueWME>)DramaManager.lookupWME("TensionStoryValueWME").listIterator();
                while (listIterator2.hasNext()) {
                    if (((TensionStoryValueWME)listIterator2.next()).getValue() == 2.0f) {
                        final ListIterator<BeatCompletedWME> listIterator3 = (ListIterator<BeatCompletedWME>)DramaManager.lookupWME("BeatCompletedWME").listIterator();
                        while (listIterator3.hasNext()) {
                            final BeatCompletedWME beatCompletedWME = listIterator3.next();
                            if (beatCompletedWME.getBeatID() >= 9 && beatCompletedWME.getBeatID() <= 11) {
                                return false;
                            }
                        }
                        final ListIterator<BeatCompletedWME> listIterator4 = (ListIterator<BeatCompletedWME>)DramaManager.lookupWME("BeatCompletedWME").listIterator();
                        while (listIterator4.hasNext()) {
                            final BeatCompletedWME beatCompletedWME2 = listIterator4.next();
                            if (beatCompletedWME2.getBeatID() >= 17 && beatCompletedWME2.getBeatID() <= 18) {
                                return false;
                            }
                        }
                        final ListIterator<BeatAbortWME> listIterator5 = (ListIterator<BeatAbortWME>)DramaManager.lookupWME("BeatAbortWME").listIterator();
                        while (listIterator5.hasNext()) {
                            final BeatAbortWME beatAbortWME = listIterator5.next();
                            if (beatAbortWME.getBeatID() >= 9 && beatAbortWME.getBeatID() <= 11) {
                                return false;
                            }
                        }
                        final ListIterator<BeatAbortWME> listIterator6 = (ListIterator<BeatAbortWME>)DramaManager.lookupWME("BeatAbortWME").listIterator();
                        while (listIterator6.hasNext()) {
                            final BeatAbortWME beatAbortWME2 = listIterator6.next();
                            if (beatAbortWME2.getBeatID() >= 17 && beatAbortWME2.getBeatID() <= 18) {
                                return false;
                            }
                        }
                        final ListIterator<StoryStatusWME> listIterator7 = (ListIterator<StoryStatusWME>)DramaManager.lookupWME("StoryStatusWME").listIterator();
                        while (listIterator7.hasNext()) {
                            final StoryStatusWME value = listIterator7.next();
                            variableScopeThrowsErrors.getVariable("storyStatusWME").value = value;
                            if (value.getStoryTopicBeatCount() < 2) {
                                variableScopeThrowsErrors.getParentVariable("storyStatusWME").value = variableScopeThrowsErrors.getVariable("storyStatusWME").value;
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean _ArtistAdvertising_TPA_T2_weighttest1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_TPA_T2_weighttest1_scope");
        variableScopeThrowsErrors.defineVariable("daTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("daType", null, "int");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        variableScopeThrowsErrors.defineVariable("objectReference", null, "int");
        final ListIterator listIterator = DramaManager.lookupWME("DAWME").listIterator();
        while (listIterator.hasNext()) {
            final DAWME value = listIterator.next();
            variableScopeThrowsErrors.getVariable("unhandledAct").value = value;
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp");
            final long timestamp = value.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && value.getHandledStatus() != 2) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                final int id = value.getId();
                intValue.i = id;
                if (!DramaManager.constantTrue(id) || value.getParam1() != 59 || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l > ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp() || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l <= ((BeatStartWME)variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value).getTimestamp()) {
                    continue;
                }
                final ListIterator listIterator2 = DramaManager.lookupWME("DAWME").listIterator();
                while (listIterator2.hasNext()) {
                    final DAWME dawme = listIterator2.next();
                    if (dawme.getTimestamp() == ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l) {
                        final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                        final int id2 = dawme.getId();
                        intValue2.i = id2;
                        if (!DramaManager.constantTrue(id2)) {
                            continue;
                        }
                        final VariableScope.IntValue intValue3 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("objectReference");
                        final int param1 = dawme.getParam1();
                        intValue3.i = param1;
                        if (!DramaManager.constantTrue(param1) || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || !BeatHelperFxns.isAASubtopic(((VariableScope.IntValue)variableScopeThrowsErrors.getValue("objectReference")).i)) {
                            continue;
                        }
                        final VariableScope.IntValue intValue4 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType");
                        final int i = 1;
                        intValue4.i = i;
                        if (!DramaManager.constantTrue(i)) {
                            continue;
                        }
                        final VariableScope.IntValue intValue5 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("subtopic");
                        final int j = ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("objectReference")).i;
                        intValue5.i = j;
                        if (DramaManager.constantTrue(j)) {
                            variableScopeThrowsErrors.getParentVariable("unhandledAct").value = variableScopeThrowsErrors.getVariable("unhandledAct").value;
                            return true;
                        }
                        continue;
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean _ArtistAdvertising_TPA_T2_weighttest2(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_TPA_T2_weighttest2_scope");
        variableScopeThrowsErrors.defineVariable("daTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("daType", null, "int");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        final ListIterator listIterator = DramaManager.lookupWME("DAWME").listIterator();
        while (listIterator.hasNext()) {
            final DAWME value = listIterator.next();
            variableScopeThrowsErrors.getVariable("unhandledAct").value = value;
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp");
            final long timestamp = value.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && value.getHandledStatus() != 2) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                final int id = value.getId();
                intValue.i = id;
                if (!DramaManager.constantTrue(id) || value.getParam1() != 59 || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l > ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp() || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l <= ((BeatStartWME)variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value).getTimestamp()) {
                    continue;
                }
                final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType");
                final int i = 1;
                intValue2.i = i;
                if (DramaManager.constantTrue(i)) {
                    variableScopeThrowsErrors.getParentVariable("unhandledAct").value = variableScopeThrowsErrors.getVariable("unhandledAct").value;
                    return true;
                }
                continue;
            }
        }
        return false;
    }
    
    public static boolean _ArtistAdvertising_TPA_T2_prioritytest1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_TPA_T2_prioritytest1_scope");
        variableScopeThrowsErrors.defineVariable("abortTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("abortBeatID", null, "int");
        variableScopeThrowsErrors.defineVariable("abortReason", null, "int");
        final ListIterator listIterator = DramaManager.lookupWME("BeatAbortWME").listIterator();
        while (listIterator.hasNext()) {
            final BeatAbortWME beatAbortWME = listIterator.next();
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("abortTimestamp");
            final long timestamp = beatAbortWME.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && beatAbortWME.getBeatID() >= 17 && beatAbortWME.getBeatID() <= 18) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortBeatID");
                final int beatID = beatAbortWME.getBeatID();
                intValue.i = beatID;
                if (!DramaManager.constantTrue(beatID) || beatAbortWME.getBeatAbortReason() != 2) {
                    continue;
                }
                final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason");
                final int beatAbortReason = beatAbortWME.getBeatAbortReason();
                intValue2.i = beatAbortReason;
                if (DramaManager.constantTrue(beatAbortReason) && ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("abortTimestamp")).l > ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp() && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortBeatID")).i == ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getBeatID()) {
                    variableScopeThrowsErrors.getParentVariable("abortReason").value = variableScopeThrowsErrors.getVariable("abortReason").value;
                    return true;
                }
                continue;
            }
        }
        return false;
    }
    
    public static boolean _ArtistAdvertising_TPA_T2_prioritytest2(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_TPA_T2_prioritytest2_scope");
        variableScopeThrowsErrors.defineVariable("daTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("daType", null, "int");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        variableScopeThrowsErrors.defineVariable("objectReference", null, "int");
        final ListIterator listIterator = DramaManager.lookupWME("DAWME").listIterator();
        while (listIterator.hasNext()) {
            final DAWME value = listIterator.next();
            variableScopeThrowsErrors.getVariable("unhandledAct").value = value;
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp");
            final long timestamp = value.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && value.getHandledStatus() != 2) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                final int id = value.getId();
                intValue.i = id;
                if (!DramaManager.constantTrue(id) || value.getParam1() != 59 || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l <= ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp()) {
                    continue;
                }
                final ListIterator listIterator2 = DramaManager.lookupWME("DAWME").listIterator();
                while (listIterator2.hasNext()) {
                    final DAWME dawme = listIterator2.next();
                    if (dawme.getTimestamp() == ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l) {
                        final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                        final int id2 = dawme.getId();
                        intValue2.i = id2;
                        if (!DramaManager.constantTrue(id2)) {
                            continue;
                        }
                        final VariableScope.IntValue intValue3 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("objectReference");
                        final int param1 = dawme.getParam1();
                        intValue3.i = param1;
                        if (!DramaManager.constantTrue(param1) || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || !BeatHelperFxns.isAASubtopic(((VariableScope.IntValue)variableScopeThrowsErrors.getValue("objectReference")).i)) {
                            continue;
                        }
                        final VariableScope.IntValue intValue4 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType");
                        final int i = 1;
                        intValue4.i = i;
                        if (!DramaManager.constantTrue(i)) {
                            continue;
                        }
                        final VariableScope.IntValue intValue5 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("subtopic");
                        final int j = ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("objectReference")).i;
                        intValue5.i = j;
                        if (DramaManager.constantTrue(j)) {
                            variableScopeThrowsErrors.getParentVariable("unhandledAct").value = variableScopeThrowsErrors.getVariable("unhandledAct").value;
                            return true;
                        }
                        continue;
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean _ArtistAdvertising_TPA_T2_prioritytest3(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_TPA_T2_prioritytest3_scope");
        variableScopeThrowsErrors.defineVariable("daTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("daType", null, "int");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        final ListIterator listIterator = DramaManager.lookupWME("DAWME").listIterator();
        while (listIterator.hasNext()) {
            final DAWME value = listIterator.next();
            variableScopeThrowsErrors.getVariable("unhandledAct").value = value;
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp");
            final long timestamp = value.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && value.getHandledStatus() != 2) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                final int id = value.getId();
                intValue.i = id;
                if (!DramaManager.constantTrue(id) || value.getParam1() != 59 || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l <= ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp()) {
                    continue;
                }
                final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType");
                final int i = 1;
                intValue2.i = i;
                if (DramaManager.constantTrue(i)) {
                    variableScopeThrowsErrors.getParentVariable("unhandledAct").value = variableScopeThrowsErrors.getVariable("unhandledAct").value;
                    return true;
                }
                continue;
            }
        }
        return false;
    }
    
    public static boolean _ArtistAdvertising_TPA_T2ToT3_precondition1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_TPA_T2ToT3_precondition1_scope");
        variableScopeThrowsErrors.defineVariable("storyStatusWME", null, "StoryStatusWME");
        final ListIterator<StoryStatusWME> listIterator = (ListIterator<StoryStatusWME>)DramaManager.lookupWME("StoryStatusWME").listIterator();
        while (listIterator.hasNext()) {
            final StoryStatusWME value = listIterator.next();
            variableScopeThrowsErrors.getVariable("storyStatusWME").value = value;
            if (value.getAffinity() >= 1) {
                final ListIterator<TensionStoryValueWME> listIterator2 = (ListIterator<TensionStoryValueWME>)DramaManager.lookupWME("TensionStoryValueWME").listIterator();
                while (listIterator2.hasNext()) {
                    if (((TensionStoryValueWME)listIterator2.next()).getValue() == 2.0f) {
                        final ListIterator<BeatCompletedWME> listIterator3 = (ListIterator<BeatCompletedWME>)DramaManager.lookupWME("BeatCompletedWME").listIterator();
                        while (listIterator3.hasNext()) {
                            final BeatCompletedWME beatCompletedWME = listIterator3.next();
                            if (beatCompletedWME.getBeatID() >= 9 && beatCompletedWME.getBeatID() <= 11) {
                                return false;
                            }
                        }
                        final ListIterator<BeatCompletedWME> listIterator4 = (ListIterator<BeatCompletedWME>)DramaManager.lookupWME("BeatCompletedWME").listIterator();
                        while (listIterator4.hasNext()) {
                            final BeatCompletedWME beatCompletedWME2 = listIterator4.next();
                            if (beatCompletedWME2.getBeatID() >= 17 && beatCompletedWME2.getBeatID() <= 18) {
                                return false;
                            }
                        }
                        final ListIterator<BeatAbortWME> listIterator5 = (ListIterator<BeatAbortWME>)DramaManager.lookupWME("BeatAbortWME").listIterator();
                        while (listIterator5.hasNext()) {
                            final BeatAbortWME beatAbortWME = listIterator5.next();
                            if (beatAbortWME.getBeatID() >= 9 && beatAbortWME.getBeatID() <= 11) {
                                return false;
                            }
                        }
                        final ListIterator<BeatAbortWME> listIterator6 = (ListIterator<BeatAbortWME>)DramaManager.lookupWME("BeatAbortWME").listIterator();
                        while (listIterator6.hasNext()) {
                            final BeatAbortWME beatAbortWME2 = listIterator6.next();
                            if (beatAbortWME2.getBeatID() >= 17 && beatAbortWME2.getBeatID() <= 18) {
                                return false;
                            }
                        }
                        variableScopeThrowsErrors.getParentVariable("storyStatusWME").value = variableScopeThrowsErrors.getVariable("storyStatusWME").value;
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean _ArtistAdvertising_TPA_T2ToT3_weighttest1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_TPA_T2ToT3_weighttest1_scope");
        variableScopeThrowsErrors.defineVariable("daTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("daType", null, "int");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        variableScopeThrowsErrors.defineVariable("objectReference", null, "int");
        final ListIterator listIterator = DramaManager.lookupWME("DAWME").listIterator();
        while (listIterator.hasNext()) {
            final DAWME value = listIterator.next();
            variableScopeThrowsErrors.getVariable("unhandledAct").value = value;
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp");
            final long timestamp = value.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && value.getHandledStatus() != 2) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                final int id = value.getId();
                intValue.i = id;
                if (!DramaManager.constantTrue(id) || value.getParam1() != 59 || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l > ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp() || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l <= ((BeatStartWME)variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value).getTimestamp()) {
                    continue;
                }
                final ListIterator listIterator2 = DramaManager.lookupWME("DAWME").listIterator();
                while (listIterator2.hasNext()) {
                    final DAWME dawme = listIterator2.next();
                    if (dawme.getTimestamp() == ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l) {
                        final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                        final int id2 = dawme.getId();
                        intValue2.i = id2;
                        if (!DramaManager.constantTrue(id2)) {
                            continue;
                        }
                        final VariableScope.IntValue intValue3 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("objectReference");
                        final int param1 = dawme.getParam1();
                        intValue3.i = param1;
                        if (!DramaManager.constantTrue(param1) || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || !BeatHelperFxns.isAASubtopic(((VariableScope.IntValue)variableScopeThrowsErrors.getValue("objectReference")).i)) {
                            continue;
                        }
                        final VariableScope.IntValue intValue4 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType");
                        final int i = 1;
                        intValue4.i = i;
                        if (!DramaManager.constantTrue(i)) {
                            continue;
                        }
                        final VariableScope.IntValue intValue5 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("subtopic");
                        final int j = ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("objectReference")).i;
                        intValue5.i = j;
                        if (DramaManager.constantTrue(j)) {
                            variableScopeThrowsErrors.getParentVariable("unhandledAct").value = variableScopeThrowsErrors.getVariable("unhandledAct").value;
                            return true;
                        }
                        continue;
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean _ArtistAdvertising_TPA_T2ToT3_weighttest2(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_TPA_T2ToT3_weighttest2_scope");
        variableScopeThrowsErrors.defineVariable("daTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("daType", null, "int");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        final ListIterator listIterator = DramaManager.lookupWME("DAWME").listIterator();
        while (listIterator.hasNext()) {
            final DAWME value = listIterator.next();
            variableScopeThrowsErrors.getVariable("unhandledAct").value = value;
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp");
            final long timestamp = value.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && value.getHandledStatus() != 2) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                final int id = value.getId();
                intValue.i = id;
                if (!DramaManager.constantTrue(id) || value.getParam1() != 59 || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l > ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp() || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l <= ((BeatStartWME)variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value).getTimestamp()) {
                    continue;
                }
                final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType");
                final int i = 1;
                intValue2.i = i;
                if (DramaManager.constantTrue(i)) {
                    variableScopeThrowsErrors.getParentVariable("unhandledAct").value = variableScopeThrowsErrors.getVariable("unhandledAct").value;
                    return true;
                }
                continue;
            }
        }
        return false;
    }
    
    public static boolean _ArtistAdvertising_TPA_T2ToT3_prioritytest1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_TPA_T2ToT3_prioritytest1_scope");
        variableScopeThrowsErrors.defineVariable("abortTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("abortBeatID", null, "int");
        variableScopeThrowsErrors.defineVariable("abortReason", null, "int");
        final ListIterator listIterator = DramaManager.lookupWME("BeatAbortWME").listIterator();
        while (listIterator.hasNext()) {
            final BeatAbortWME beatAbortWME = listIterator.next();
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("abortTimestamp");
            final long timestamp = beatAbortWME.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && beatAbortWME.getBeatID() >= 17 && beatAbortWME.getBeatID() <= 18) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortBeatID");
                final int beatID = beatAbortWME.getBeatID();
                intValue.i = beatID;
                if (!DramaManager.constantTrue(beatID) || beatAbortWME.getBeatAbortReason() != 2) {
                    continue;
                }
                final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortReason");
                final int beatAbortReason = beatAbortWME.getBeatAbortReason();
                intValue2.i = beatAbortReason;
                if (DramaManager.constantTrue(beatAbortReason) && ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("abortTimestamp")).l > ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp() && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("abortBeatID")).i == ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getBeatID()) {
                    variableScopeThrowsErrors.getParentVariable("abortReason").value = variableScopeThrowsErrors.getVariable("abortReason").value;
                    return true;
                }
                continue;
            }
        }
        return false;
    }
    
    public static boolean _ArtistAdvertising_TPA_T2ToT3_prioritytest2(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_TPA_T2ToT3_prioritytest2_scope");
        variableScopeThrowsErrors.defineVariable("daTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("daType", null, "int");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        variableScopeThrowsErrors.defineVariable("objectReference", null, "int");
        final ListIterator listIterator = DramaManager.lookupWME("DAWME").listIterator();
        while (listIterator.hasNext()) {
            final DAWME value = listIterator.next();
            variableScopeThrowsErrors.getVariable("unhandledAct").value = value;
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp");
            final long timestamp = value.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && value.getHandledStatus() != 2) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                final int id = value.getId();
                intValue.i = id;
                if (!DramaManager.constantTrue(id) || value.getParam1() != 59 || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l <= ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp()) {
                    continue;
                }
                final ListIterator listIterator2 = DramaManager.lookupWME("DAWME").listIterator();
                while (listIterator2.hasNext()) {
                    final DAWME dawme = listIterator2.next();
                    if (dawme.getTimestamp() == ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l) {
                        final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                        final int id2 = dawme.getId();
                        intValue2.i = id2;
                        if (!DramaManager.constantTrue(id2)) {
                            continue;
                        }
                        final VariableScope.IntValue intValue3 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("objectReference");
                        final int param1 = dawme.getParam1();
                        intValue3.i = param1;
                        if (!DramaManager.constantTrue(param1) || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || !BeatHelperFxns.isAASubtopic(((VariableScope.IntValue)variableScopeThrowsErrors.getValue("objectReference")).i)) {
                            continue;
                        }
                        final VariableScope.IntValue intValue4 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType");
                        final int i = 1;
                        intValue4.i = i;
                        if (!DramaManager.constantTrue(i)) {
                            continue;
                        }
                        final VariableScope.IntValue intValue5 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("subtopic");
                        final int j = ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("objectReference")).i;
                        intValue5.i = j;
                        if (DramaManager.constantTrue(j)) {
                            variableScopeThrowsErrors.getParentVariable("unhandledAct").value = variableScopeThrowsErrors.getVariable("unhandledAct").value;
                            return true;
                        }
                        continue;
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean _ArtistAdvertising_TPA_T2ToT3_prioritytest3(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_ArtistAdvertising_TPA_T2ToT3_prioritytest3_scope");
        variableScopeThrowsErrors.defineVariable("daTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("daType", null, "int");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        final ListIterator listIterator = DramaManager.lookupWME("DAWME").listIterator();
        while (listIterator.hasNext()) {
            final DAWME value = listIterator.next();
            variableScopeThrowsErrors.getVariable("unhandledAct").value = value;
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp");
            final long timestamp = value.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && value.getHandledStatus() != 2) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                final int id = value.getId();
                intValue.i = id;
                if (!DramaManager.constantTrue(id) || value.getParam1() != 59 || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l <= ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp()) {
                    continue;
                }
                final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType");
                final int i = 1;
                intValue2.i = i;
                if (DramaManager.constantTrue(i)) {
                    variableScopeThrowsErrors.getParentVariable("unhandledAct").value = variableScopeThrowsErrors.getVariable("unhandledAct").value;
                    return true;
                }
                continue;
            }
        }
        return false;
    }
    
    public static boolean _RockyMarriage_GPA_T2_precondition1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_RockyMarriage_GPA_T2_precondition1_scope");
        variableScopeThrowsErrors.defineVariable("storyStatusWME", null, "StoryStatusWME");
        final ListIterator<StoryStatusWME> listIterator = (ListIterator<StoryStatusWME>)DramaManager.lookupWME("StoryStatusWME").listIterator();
        while (listIterator.hasNext()) {
            if (((StoryStatusWME)listIterator.next()).getAffinity() <= -1) {
                final ListIterator<TensionStoryValueWME> listIterator2 = (ListIterator<TensionStoryValueWME>)DramaManager.lookupWME("TensionStoryValueWME").listIterator();
                while (listIterator2.hasNext()) {
                    if (((TensionStoryValueWME)listIterator2.next()).getValue() == 2.0f) {
                        final ListIterator<BeatCompletedWME> listIterator3 = (ListIterator<BeatCompletedWME>)DramaManager.lookupWME("BeatCompletedWME").listIterator();
                        while (listIterator3.hasNext()) {
                            final BeatCompletedWME beatCompletedWME = listIterator3.next();
                            if (beatCompletedWME.getBeatID() >= 14 && beatCompletedWME.getBeatID() <= 16) {
                                return false;
                            }
                        }
                        final ListIterator<BeatCompletedWME> listIterator4 = (ListIterator<BeatCompletedWME>)DramaManager.lookupWME("BeatCompletedWME").listIterator();
                        while (listIterator4.hasNext()) {
                            final BeatCompletedWME beatCompletedWME2 = listIterator4.next();
                            if (beatCompletedWME2.getBeatID() >= 21 && beatCompletedWME2.getBeatID() <= 22) {
                                return false;
                            }
                        }
                        final ListIterator<BeatAbortWME> listIterator5 = (ListIterator<BeatAbortWME>)DramaManager.lookupWME("BeatAbortWME").listIterator();
                        while (listIterator5.hasNext()) {
                            final BeatAbortWME beatAbortWME = listIterator5.next();
                            if (beatAbortWME.getBeatID() >= 14 && beatAbortWME.getBeatID() <= 16) {
                                return false;
                            }
                        }
                        final ListIterator<BeatAbortWME> listIterator6 = (ListIterator<BeatAbortWME>)DramaManager.lookupWME("BeatAbortWME").listIterator();
                        while (listIterator6.hasNext()) {
                            final BeatAbortWME beatAbortWME2 = listIterator6.next();
                            if (beatAbortWME2.getBeatID() >= 21 && beatAbortWME2.getBeatID() <= 22) {
                                return false;
                            }
                        }
                        final ListIterator<StoryStatusWME> listIterator7 = (ListIterator<StoryStatusWME>)DramaManager.lookupWME("StoryStatusWME").listIterator();
                        while (listIterator7.hasNext()) {
                            final StoryStatusWME value = listIterator7.next();
                            variableScopeThrowsErrors.getVariable("storyStatusWME").value = value;
                            if (value.getStoryTopicBeatCount() < 2) {
                                variableScopeThrowsErrors.getParentVariable("storyStatusWME").value = variableScopeThrowsErrors.getVariable("storyStatusWME").value;
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean _RockyMarriage_GPA_T2_weighttest1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_RockyMarriage_GPA_T2_weighttest1_scope");
        variableScopeThrowsErrors.defineVariable("daTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("daType", null, "int");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        final ListIterator listIterator = DramaManager.lookupWME("DAWME").listIterator();
        while (listIterator.hasNext()) {
            final DAWME value = listIterator.next();
            variableScopeThrowsErrors.getVariable("unhandledAct").value = value;
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp");
            final long timestamp = value.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && value.getHandledStatus() != 2) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                final int id = value.getId();
                intValue.i = id;
                if (!DramaManager.constantTrue(id) || value.getParam1() != 61 || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l > ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp() || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l <= ((BeatStartWME)variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value).getTimestamp()) {
                    continue;
                }
                final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType");
                final int i = 1;
                intValue2.i = i;
                if (DramaManager.constantTrue(i)) {
                    variableScopeThrowsErrors.getParentVariable("unhandledAct").value = variableScopeThrowsErrors.getVariable("unhandledAct").value;
                    return true;
                }
                continue;
            }
        }
        return false;
    }
    
    public static boolean _RockyMarriage_GPA_T2_prioritytest1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_RockyMarriage_GPA_T2_prioritytest1_scope");
        variableScopeThrowsErrors.defineVariable("daTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("daType", null, "int");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        final ListIterator listIterator = DramaManager.lookupWME("DAWME").listIterator();
        while (listIterator.hasNext()) {
            final DAWME value = listIterator.next();
            variableScopeThrowsErrors.getVariable("unhandledAct").value = value;
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp");
            final long timestamp = value.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && value.getHandledStatus() != 2) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                final int id = value.getId();
                intValue.i = id;
                if (!DramaManager.constantTrue(id) || value.getParam1() != 61 || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l <= ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp()) {
                    continue;
                }
                final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType");
                final int i = 1;
                intValue2.i = i;
                if (DramaManager.constantTrue(i)) {
                    variableScopeThrowsErrors.getParentVariable("unhandledAct").value = variableScopeThrowsErrors.getVariable("unhandledAct").value;
                    return true;
                }
                continue;
            }
        }
        return false;
    }
    
    public static boolean _RockyMarriage_GPA_T2ToT3_precondition1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_RockyMarriage_GPA_T2ToT3_precondition1_scope");
        variableScopeThrowsErrors.defineVariable("storyStatusWME", null, "StoryStatusWME");
        final ListIterator<StoryStatusWME> listIterator = (ListIterator<StoryStatusWME>)DramaManager.lookupWME("StoryStatusWME").listIterator();
        while (listIterator.hasNext()) {
            final StoryStatusWME value = listIterator.next();
            variableScopeThrowsErrors.getVariable("storyStatusWME").value = value;
            if (value.getAffinity() <= -1) {
                final ListIterator<TensionStoryValueWME> listIterator2 = (ListIterator<TensionStoryValueWME>)DramaManager.lookupWME("TensionStoryValueWME").listIterator();
                while (listIterator2.hasNext()) {
                    if (((TensionStoryValueWME)listIterator2.next()).getValue() == 2.0f) {
                        final ListIterator<BeatCompletedWME> listIterator3 = (ListIterator<BeatCompletedWME>)DramaManager.lookupWME("BeatCompletedWME").listIterator();
                        while (listIterator3.hasNext()) {
                            final BeatCompletedWME beatCompletedWME = listIterator3.next();
                            if (beatCompletedWME.getBeatID() >= 14 && beatCompletedWME.getBeatID() <= 16) {
                                return false;
                            }
                        }
                        final ListIterator<BeatCompletedWME> listIterator4 = (ListIterator<BeatCompletedWME>)DramaManager.lookupWME("BeatCompletedWME").listIterator();
                        while (listIterator4.hasNext()) {
                            final BeatCompletedWME beatCompletedWME2 = listIterator4.next();
                            if (beatCompletedWME2.getBeatID() >= 21 && beatCompletedWME2.getBeatID() <= 22) {
                                return false;
                            }
                        }
                        final ListIterator<BeatAbortWME> listIterator5 = (ListIterator<BeatAbortWME>)DramaManager.lookupWME("BeatAbortWME").listIterator();
                        while (listIterator5.hasNext()) {
                            final BeatAbortWME beatAbortWME = listIterator5.next();
                            if (beatAbortWME.getBeatID() >= 14 && beatAbortWME.getBeatID() <= 16) {
                                return false;
                            }
                        }
                        final ListIterator<BeatAbortWME> listIterator6 = (ListIterator<BeatAbortWME>)DramaManager.lookupWME("BeatAbortWME").listIterator();
                        while (listIterator6.hasNext()) {
                            final BeatAbortWME beatAbortWME2 = listIterator6.next();
                            if (beatAbortWME2.getBeatID() >= 21 && beatAbortWME2.getBeatID() <= 22) {
                                return false;
                            }
                        }
                        variableScopeThrowsErrors.getParentVariable("storyStatusWME").value = variableScopeThrowsErrors.getVariable("storyStatusWME").value;
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean _RockyMarriage_GPA_T2ToT3_weighttest1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_RockyMarriage_GPA_T2ToT3_weighttest1_scope");
        variableScopeThrowsErrors.defineVariable("daTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("daType", null, "int");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        final ListIterator listIterator = DramaManager.lookupWME("DAWME").listIterator();
        while (listIterator.hasNext()) {
            final DAWME value = listIterator.next();
            variableScopeThrowsErrors.getVariable("unhandledAct").value = value;
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp");
            final long timestamp = value.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && value.getHandledStatus() != 2) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                final int id = value.getId();
                intValue.i = id;
                if (!DramaManager.constantTrue(id) || value.getParam1() != 61 || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l > ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp() || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l <= ((BeatStartWME)variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value).getTimestamp()) {
                    continue;
                }
                final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType");
                final int i = 1;
                intValue2.i = i;
                if (DramaManager.constantTrue(i)) {
                    variableScopeThrowsErrors.getParentVariable("unhandledAct").value = variableScopeThrowsErrors.getVariable("unhandledAct").value;
                    return true;
                }
                continue;
            }
        }
        return false;
    }
    
    public static boolean _RockyMarriage_GPA_T2ToT3_prioritytest1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_RockyMarriage_GPA_T2ToT3_prioritytest1_scope");
        variableScopeThrowsErrors.defineVariable("daTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("daType", null, "int");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        final ListIterator listIterator = DramaManager.lookupWME("DAWME").listIterator();
        while (listIterator.hasNext()) {
            final DAWME value = listIterator.next();
            variableScopeThrowsErrors.getVariable("unhandledAct").value = value;
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp");
            final long timestamp = value.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && value.getHandledStatus() != 2) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                final int id = value.getId();
                intValue.i = id;
                if (!DramaManager.constantTrue(id) || value.getParam1() != 61 || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l <= ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp()) {
                    continue;
                }
                final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType");
                final int i = 1;
                intValue2.i = i;
                if (DramaManager.constantTrue(i)) {
                    variableScopeThrowsErrors.getParentVariable("unhandledAct").value = variableScopeThrowsErrors.getVariable("unhandledAct").value;
                    return true;
                }
                continue;
            }
        }
        return false;
    }
    
    public static boolean _RockyMarriage_TPA_T2_precondition1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_RockyMarriage_TPA_T2_precondition1_scope");
        variableScopeThrowsErrors.defineVariable("storyStatusWME", null, "StoryStatusWME");
        final ListIterator<StoryStatusWME> listIterator = (ListIterator<StoryStatusWME>)DramaManager.lookupWME("StoryStatusWME").listIterator();
        while (listIterator.hasNext()) {
            if (((StoryStatusWME)listIterator.next()).getAffinity() >= 1) {
                final ListIterator<TensionStoryValueWME> listIterator2 = (ListIterator<TensionStoryValueWME>)DramaManager.lookupWME("TensionStoryValueWME").listIterator();
                while (listIterator2.hasNext()) {
                    if (((TensionStoryValueWME)listIterator2.next()).getValue() == 2.0f) {
                        final ListIterator<BeatCompletedWME> listIterator3 = (ListIterator<BeatCompletedWME>)DramaManager.lookupWME("BeatCompletedWME").listIterator();
                        while (listIterator3.hasNext()) {
                            final BeatCompletedWME beatCompletedWME = listIterator3.next();
                            if (beatCompletedWME.getBeatID() >= 14 && beatCompletedWME.getBeatID() <= 16) {
                                return false;
                            }
                        }
                        final ListIterator<BeatCompletedWME> listIterator4 = (ListIterator<BeatCompletedWME>)DramaManager.lookupWME("BeatCompletedWME").listIterator();
                        while (listIterator4.hasNext()) {
                            final BeatCompletedWME beatCompletedWME2 = listIterator4.next();
                            if (beatCompletedWME2.getBeatID() >= 21 && beatCompletedWME2.getBeatID() <= 22) {
                                return false;
                            }
                        }
                        final ListIterator<BeatAbortWME> listIterator5 = (ListIterator<BeatAbortWME>)DramaManager.lookupWME("BeatAbortWME").listIterator();
                        while (listIterator5.hasNext()) {
                            final BeatAbortWME beatAbortWME = listIterator5.next();
                            if (beatAbortWME.getBeatID() >= 14 && beatAbortWME.getBeatID() <= 16) {
                                return false;
                            }
                        }
                        final ListIterator<BeatAbortWME> listIterator6 = (ListIterator<BeatAbortWME>)DramaManager.lookupWME("BeatAbortWME").listIterator();
                        while (listIterator6.hasNext()) {
                            final BeatAbortWME beatAbortWME2 = listIterator6.next();
                            if (beatAbortWME2.getBeatID() >= 21 && beatAbortWME2.getBeatID() <= 22) {
                                return false;
                            }
                        }
                        final ListIterator<StoryStatusWME> listIterator7 = (ListIterator<StoryStatusWME>)DramaManager.lookupWME("StoryStatusWME").listIterator();
                        while (listIterator7.hasNext()) {
                            final StoryStatusWME value = listIterator7.next();
                            variableScopeThrowsErrors.getVariable("storyStatusWME").value = value;
                            if (value.getStoryTopicBeatCount() < 2) {
                                variableScopeThrowsErrors.getParentVariable("storyStatusWME").value = variableScopeThrowsErrors.getVariable("storyStatusWME").value;
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean _RockyMarriage_TPA_T2_weighttest1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_RockyMarriage_TPA_T2_weighttest1_scope");
        variableScopeThrowsErrors.defineVariable("daTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("daType", null, "int");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        final ListIterator listIterator = DramaManager.lookupWME("DAWME").listIterator();
        while (listIterator.hasNext()) {
            final DAWME value = listIterator.next();
            variableScopeThrowsErrors.getVariable("unhandledAct").value = value;
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp");
            final long timestamp = value.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && value.getHandledStatus() != 2) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                final int id = value.getId();
                intValue.i = id;
                if (!DramaManager.constantTrue(id) || value.getParam1() != 61 || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l > ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp() || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l <= ((BeatStartWME)variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value).getTimestamp()) {
                    continue;
                }
                final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType");
                final int i = 1;
                intValue2.i = i;
                if (DramaManager.constantTrue(i)) {
                    variableScopeThrowsErrors.getParentVariable("unhandledAct").value = variableScopeThrowsErrors.getVariable("unhandledAct").value;
                    return true;
                }
                continue;
            }
        }
        return false;
    }
    
    public static boolean _RockyMarriage_TPA_T2_prioritytest1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_RockyMarriage_TPA_T2_prioritytest1_scope");
        variableScopeThrowsErrors.defineVariable("daTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("daType", null, "int");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        final ListIterator listIterator = DramaManager.lookupWME("DAWME").listIterator();
        while (listIterator.hasNext()) {
            final DAWME value = listIterator.next();
            variableScopeThrowsErrors.getVariable("unhandledAct").value = value;
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp");
            final long timestamp = value.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && value.getHandledStatus() != 2) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                final int id = value.getId();
                intValue.i = id;
                if (!DramaManager.constantTrue(id) || value.getParam1() != 61 || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l <= ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp()) {
                    continue;
                }
                final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType");
                final int i = 1;
                intValue2.i = i;
                if (DramaManager.constantTrue(i)) {
                    variableScopeThrowsErrors.getParentVariable("unhandledAct").value = variableScopeThrowsErrors.getVariable("unhandledAct").value;
                    return true;
                }
                continue;
            }
        }
        return false;
    }
    
    public static boolean _RockyMarriage_TPA_T2ToT3_precondition1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_RockyMarriage_TPA_T2ToT3_precondition1_scope");
        variableScopeThrowsErrors.defineVariable("storyStatusWME", null, "StoryStatusWME");
        final ListIterator<StoryStatusWME> listIterator = (ListIterator<StoryStatusWME>)DramaManager.lookupWME("StoryStatusWME").listIterator();
        while (listIterator.hasNext()) {
            final StoryStatusWME value = listIterator.next();
            variableScopeThrowsErrors.getVariable("storyStatusWME").value = value;
            if (value.getAffinity() >= 1) {
                final ListIterator<TensionStoryValueWME> listIterator2 = (ListIterator<TensionStoryValueWME>)DramaManager.lookupWME("TensionStoryValueWME").listIterator();
                while (listIterator2.hasNext()) {
                    if (((TensionStoryValueWME)listIterator2.next()).getValue() == 2.0f) {
                        final ListIterator<BeatCompletedWME> listIterator3 = (ListIterator<BeatCompletedWME>)DramaManager.lookupWME("BeatCompletedWME").listIterator();
                        while (listIterator3.hasNext()) {
                            final BeatCompletedWME beatCompletedWME = listIterator3.next();
                            if (beatCompletedWME.getBeatID() >= 14 && beatCompletedWME.getBeatID() <= 16) {
                                return false;
                            }
                        }
                        final ListIterator<BeatCompletedWME> listIterator4 = (ListIterator<BeatCompletedWME>)DramaManager.lookupWME("BeatCompletedWME").listIterator();
                        while (listIterator4.hasNext()) {
                            final BeatCompletedWME beatCompletedWME2 = listIterator4.next();
                            if (beatCompletedWME2.getBeatID() >= 21 && beatCompletedWME2.getBeatID() <= 22) {
                                return false;
                            }
                        }
                        final ListIterator<BeatAbortWME> listIterator5 = (ListIterator<BeatAbortWME>)DramaManager.lookupWME("BeatAbortWME").listIterator();
                        while (listIterator5.hasNext()) {
                            final BeatAbortWME beatAbortWME = listIterator5.next();
                            if (beatAbortWME.getBeatID() >= 14 && beatAbortWME.getBeatID() <= 16) {
                                return false;
                            }
                        }
                        final ListIterator<BeatAbortWME> listIterator6 = (ListIterator<BeatAbortWME>)DramaManager.lookupWME("BeatAbortWME").listIterator();
                        while (listIterator6.hasNext()) {
                            final BeatAbortWME beatAbortWME2 = listIterator6.next();
                            if (beatAbortWME2.getBeatID() >= 21 && beatAbortWME2.getBeatID() <= 22) {
                                return false;
                            }
                        }
                        variableScopeThrowsErrors.getParentVariable("storyStatusWME").value = variableScopeThrowsErrors.getVariable("storyStatusWME").value;
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean _RockyMarriage_TPA_T2ToT3_weighttest1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_RockyMarriage_TPA_T2ToT3_weighttest1_scope");
        variableScopeThrowsErrors.defineVariable("daTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("daType", null, "int");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        final ListIterator listIterator = DramaManager.lookupWME("DAWME").listIterator();
        while (listIterator.hasNext()) {
            final DAWME value = listIterator.next();
            variableScopeThrowsErrors.getVariable("unhandledAct").value = value;
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp");
            final long timestamp = value.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && value.getHandledStatus() != 2) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                final int id = value.getId();
                intValue.i = id;
                if (!DramaManager.constantTrue(id) || value.getParam1() != 61 || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l > ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp() || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l <= ((BeatStartWME)variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value).getTimestamp()) {
                    continue;
                }
                final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType");
                final int i = 1;
                intValue2.i = i;
                if (DramaManager.constantTrue(i)) {
                    variableScopeThrowsErrors.getParentVariable("unhandledAct").value = variableScopeThrowsErrors.getVariable("unhandledAct").value;
                    return true;
                }
                continue;
            }
        }
        return false;
    }
    
    public static boolean _RockyMarriage_TPA_T2ToT3_prioritytest1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_RockyMarriage_TPA_T2ToT3_prioritytest1_scope");
        variableScopeThrowsErrors.defineVariable("daTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("daType", null, "int");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        final ListIterator listIterator = DramaManager.lookupWME("DAWME").listIterator();
        while (listIterator.hasNext()) {
            final DAWME value = listIterator.next();
            variableScopeThrowsErrors.getVariable("unhandledAct").value = value;
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp");
            final long timestamp = value.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && value.getHandledStatus() != 2) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                final int id = value.getId();
                intValue.i = id;
                if (!DramaManager.constantTrue(id) || value.getParam1() != 61 || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l <= ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp()) {
                    continue;
                }
                final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType");
                final int i = 1;
                intValue2.i = i;
                if (DramaManager.constantTrue(i)) {
                    variableScopeThrowsErrors.getParentVariable("unhandledAct").value = variableScopeThrowsErrors.getVariable("unhandledAct").value;
                    return true;
                }
                continue;
            }
        }
        return false;
    }
    
    public static boolean _Facade_TPA_T2_precondition1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_Facade_TPA_T2_precondition1_scope");
        variableScopeThrowsErrors.defineVariable("storyStatusWME", null, "StoryStatusWME");
        final ListIterator<StoryStatusWME> listIterator = (ListIterator<StoryStatusWME>)DramaManager.lookupWME("StoryStatusWME").listIterator();
        while (listIterator.hasNext()) {
            final StoryStatusWME value = listIterator.next();
            variableScopeThrowsErrors.getVariable("storyStatusWME").value = value;
            if (value.getAffinity() >= 1) {
                final ListIterator<TensionStoryValueWME> listIterator2 = (ListIterator<TensionStoryValueWME>)DramaManager.lookupWME("TensionStoryValueWME").listIterator();
                while (listIterator2.hasNext()) {
                    if (((TensionStoryValueWME)listIterator2.next()).getValue() == 2.0f) {
                        final ListIterator<BeatCompletedWME> listIterator3 = (ListIterator<BeatCompletedWME>)DramaManager.lookupWME("BeatCompletedWME").listIterator();
                        while (listIterator3.hasNext()) {
                            final BeatCompletedWME beatCompletedWME = listIterator3.next();
                            if (beatCompletedWME.getBeatID() >= 12 && beatCompletedWME.getBeatID() <= 13) {
                                return false;
                            }
                        }
                        final ListIterator<BeatCompletedWME> listIterator4 = (ListIterator<BeatCompletedWME>)DramaManager.lookupWME("BeatCompletedWME").listIterator();
                        while (listIterator4.hasNext()) {
                            final BeatCompletedWME beatCompletedWME2 = listIterator4.next();
                            if (beatCompletedWME2.getBeatID() >= 19 && beatCompletedWME2.getBeatID() <= 20) {
                                return false;
                            }
                        }
                        final ListIterator<BeatAbortWME> listIterator5 = (ListIterator<BeatAbortWME>)DramaManager.lookupWME("BeatAbortWME").listIterator();
                        while (listIterator5.hasNext()) {
                            final BeatAbortWME beatAbortWME = listIterator5.next();
                            if (beatAbortWME.getBeatID() >= 12 && beatAbortWME.getBeatID() <= 13) {
                                return false;
                            }
                        }
                        final ListIterator<BeatAbortWME> listIterator6 = (ListIterator<BeatAbortWME>)DramaManager.lookupWME("BeatAbortWME").listIterator();
                        while (listIterator6.hasNext()) {
                            final BeatAbortWME beatAbortWME2 = listIterator6.next();
                            if (beatAbortWME2.getBeatID() >= 19 && beatAbortWME2.getBeatID() <= 20) {
                                return false;
                            }
                        }
                        variableScopeThrowsErrors.getParentVariable("storyStatusWME").value = variableScopeThrowsErrors.getVariable("storyStatusWME").value;
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean _Facade_TPA_T2_weighttest1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_Facade_TPA_T2_weighttest1_scope");
        variableScopeThrowsErrors.defineVariable("daTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("daType", null, "int");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        final ListIterator listIterator = DramaManager.lookupWME("DAWME").listIterator();
        while (listIterator.hasNext()) {
            final DAWME value = listIterator.next();
            variableScopeThrowsErrors.getVariable("unhandledAct").value = value;
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp");
            final long timestamp = value.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && value.getHandledStatus() != 2) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                final int id = value.getId();
                intValue.i = id;
                if (!DramaManager.constantTrue(id) || value.getParam1() != 60 || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l > ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp() || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l <= ((BeatStartWME)variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value).getTimestamp()) {
                    continue;
                }
                final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType");
                final int i = 1;
                intValue2.i = i;
                if (DramaManager.constantTrue(i)) {
                    variableScopeThrowsErrors.getParentVariable("unhandledAct").value = variableScopeThrowsErrors.getVariable("unhandledAct").value;
                    return true;
                }
                continue;
            }
        }
        return false;
    }
    
    public static boolean _Facade_TPA_T2_prioritytest1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_Facade_TPA_T2_prioritytest1_scope");
        variableScopeThrowsErrors.defineVariable("daTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("daType", null, "int");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        final ListIterator listIterator = DramaManager.lookupWME("DAWME").listIterator();
        while (listIterator.hasNext()) {
            final DAWME value = listIterator.next();
            variableScopeThrowsErrors.getVariable("unhandledAct").value = value;
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp");
            final long timestamp = value.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && value.getHandledStatus() != 2) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                final int id = value.getId();
                intValue.i = id;
                if (!DramaManager.constantTrue(id) || value.getParam1() != 60 || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l <= ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp()) {
                    continue;
                }
                final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType");
                final int i = 1;
                intValue2.i = i;
                if (DramaManager.constantTrue(i)) {
                    variableScopeThrowsErrors.getParentVariable("unhandledAct").value = variableScopeThrowsErrors.getVariable("unhandledAct").value;
                    return true;
                }
                continue;
            }
        }
        return false;
    }
    
    public static boolean _Facade_GPA_T2_precondition1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_Facade_GPA_T2_precondition1_scope");
        variableScopeThrowsErrors.defineVariable("storyStatusWME", null, "StoryStatusWME");
        final ListIterator<StoryStatusWME> listIterator = (ListIterator<StoryStatusWME>)DramaManager.lookupWME("StoryStatusWME").listIterator();
        while (listIterator.hasNext()) {
            final StoryStatusWME value = listIterator.next();
            variableScopeThrowsErrors.getVariable("storyStatusWME").value = value;
            if (value.getAffinity() <= -1) {
                final ListIterator<TensionStoryValueWME> listIterator2 = (ListIterator<TensionStoryValueWME>)DramaManager.lookupWME("TensionStoryValueWME").listIterator();
                while (listIterator2.hasNext()) {
                    if (((TensionStoryValueWME)listIterator2.next()).getValue() == 2.0f) {
                        final ListIterator<BeatCompletedWME> listIterator3 = (ListIterator<BeatCompletedWME>)DramaManager.lookupWME("BeatCompletedWME").listIterator();
                        while (listIterator3.hasNext()) {
                            final BeatCompletedWME beatCompletedWME = listIterator3.next();
                            if (beatCompletedWME.getBeatID() >= 12 && beatCompletedWME.getBeatID() <= 13) {
                                return false;
                            }
                        }
                        final ListIterator<BeatCompletedWME> listIterator4 = (ListIterator<BeatCompletedWME>)DramaManager.lookupWME("BeatCompletedWME").listIterator();
                        while (listIterator4.hasNext()) {
                            final BeatCompletedWME beatCompletedWME2 = listIterator4.next();
                            if (beatCompletedWME2.getBeatID() >= 19 && beatCompletedWME2.getBeatID() <= 20) {
                                return false;
                            }
                        }
                        final ListIterator<BeatAbortWME> listIterator5 = (ListIterator<BeatAbortWME>)DramaManager.lookupWME("BeatAbortWME").listIterator();
                        while (listIterator5.hasNext()) {
                            final BeatAbortWME beatAbortWME = listIterator5.next();
                            if (beatAbortWME.getBeatID() >= 12 && beatAbortWME.getBeatID() <= 13) {
                                return false;
                            }
                        }
                        final ListIterator<BeatAbortWME> listIterator6 = (ListIterator<BeatAbortWME>)DramaManager.lookupWME("BeatAbortWME").listIterator();
                        while (listIterator6.hasNext()) {
                            final BeatAbortWME beatAbortWME2 = listIterator6.next();
                            if (beatAbortWME2.getBeatID() >= 19 && beatAbortWME2.getBeatID() <= 20) {
                                return false;
                            }
                        }
                        variableScopeThrowsErrors.getParentVariable("storyStatusWME").value = variableScopeThrowsErrors.getVariable("storyStatusWME").value;
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean _Facade_GPA_T2_weighttest1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_Facade_GPA_T2_weighttest1_scope");
        variableScopeThrowsErrors.defineVariable("daTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("daType", null, "int");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        final ListIterator listIterator = DramaManager.lookupWME("DAWME").listIterator();
        while (listIterator.hasNext()) {
            final DAWME value = listIterator.next();
            variableScopeThrowsErrors.getVariable("unhandledAct").value = value;
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp");
            final long timestamp = value.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && value.getHandledStatus() != 2) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                final int id = value.getId();
                intValue.i = id;
                if (!DramaManager.constantTrue(id) || value.getParam1() != 60 || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l > ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp() || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l <= ((BeatStartWME)variableScopeThrowsErrors.getVariable("beatBeforeLastStart").value).getTimestamp()) {
                    continue;
                }
                final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType");
                final int i = 1;
                intValue2.i = i;
                if (DramaManager.constantTrue(i)) {
                    variableScopeThrowsErrors.getParentVariable("unhandledAct").value = variableScopeThrowsErrors.getVariable("unhandledAct").value;
                    return true;
                }
                continue;
            }
        }
        return false;
    }
    
    public static boolean _Facade_GPA_T2_prioritytest1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_Facade_GPA_T2_prioritytest1_scope");
        variableScopeThrowsErrors.defineVariable("daTimestamp", null, "long");
        variableScopeThrowsErrors.defineVariable("daType", null, "int");
        variableScopeThrowsErrors.defineVariable("unhandledAct", null, "DAWME");
        final ListIterator listIterator = DramaManager.lookupWME("DAWME").listIterator();
        while (listIterator.hasNext()) {
            final DAWME value = listIterator.next();
            variableScopeThrowsErrors.getVariable("unhandledAct").value = value;
            final VariableScope.LongValue longValue = (VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp");
            final long timestamp = value.getTimestamp();
            longValue.l = timestamp;
            if (DramaManager.constantTrue(timestamp) && value.getHandledStatus() != 2) {
                final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType");
                final int id = value.getId();
                intValue.i = id;
                if (!DramaManager.constantTrue(id) || value.getParam1() != 60 || (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 10 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("daType")).i != 35) || ((VariableScope.LongValue)variableScopeThrowsErrors.getValue("daTimestamp")).l <= ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getTimestamp()) {
                    continue;
                }
                final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("txnInType");
                final int i = 1;
                intValue2.i = i;
                if (DramaManager.constantTrue(i)) {
                    variableScopeThrowsErrors.getParentVariable("unhandledAct").value = variableScopeThrowsErrors.getVariable("unhandledAct").value;
                    return true;
                }
                continue;
            }
        }
        return false;
    }
    
    public static boolean _TxnT2ToT3_precondition1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_TxnT2ToT3_precondition1_scope");
        final ListIterator<TensionStoryValueWME> listIterator = (ListIterator<TensionStoryValueWME>)DramaManager.lookupWME("TensionStoryValueWME").listIterator();
        while (listIterator.hasNext()) {
            if (((TensionStoryValueWME)listIterator.next()).getValue() == 2.0f) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean _RomPrp_GPA_T2_precondition1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_RomPrp_GPA_T2_precondition1_scope");
        final ListIterator<StoryStatusWME> listIterator = (ListIterator<StoryStatusWME>)DramaManager.lookupWME("StoryStatusWME").listIterator();
        while (listIterator.hasNext()) {
            if (((StoryStatusWME)listIterator.next()).getAffinity() <= -1) {
                final ListIterator<TensionStoryValueWME> listIterator2 = (ListIterator<TensionStoryValueWME>)DramaManager.lookupWME("TensionStoryValueWME").listIterator();
                while (listIterator2.hasNext()) {
                    if (((TensionStoryValueWME)listIterator2.next()).getValue() == 2.0f) {
                        final ListIterator listIterator3 = WorkingMemory.lookupWME("BeatMemory", "SameAffinityNBeatsWME").listIterator();
                        while (listIterator3.hasNext()) {
                            final SameAffinityNBeatsWME sameAffinityNBeatsWME = listIterator3.next();
                            if (sameAffinityNBeatsWME.getBeatCount() == 2 && sameAffinityNBeatsWME.getTargetAffinity() == -1) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean _CrisisP1_precondition1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_CrisisP1_precondition1_scope");
        final ListIterator<TensionStoryValueWME> listIterator = (ListIterator<TensionStoryValueWME>)DramaManager.lookupWME("TensionStoryValueWME").listIterator();
        while (listIterator.hasNext()) {
            if (((TensionStoryValueWME)listIterator.next()).getValue() == 3) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean _CrisisToTherapyGameGlue_P2_precondition1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_CrisisToTherapyGameGlue_P2_precondition1_scope");
        return variableScopeThrowsErrors.getVariable("lastBeatStart").value != null && ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getBeatID() == 31;
    }
    
    public static boolean _TherapyGame_P2_precondition1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_TherapyGame_P2_precondition1_scope");
        return variableScopeThrowsErrors.getVariable("lastBeatStart").value != null && ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getBeatID() == 32;
    }
    
    public static boolean _RevelationBuildup_P2_precondition1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_RevelationBuildup_P2_precondition1_scope");
        return variableScopeThrowsErrors.getVariable("lastBeatStart").value != null && ((BeatStartWME)variableScopeThrowsErrors.getVariable("lastBeatStart").value).getBeatID() == 33;
    }
    
    public static boolean _Revelations_P2_precondition1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_Revelations_P2_precondition1_scope");
        variableScopeThrowsErrors.defineVariable("rev1Focus", null, "int");
        variableScopeThrowsErrors.defineVariable("rev2Focus", null, "int");
        variableScopeThrowsErrors.defineVariable("rev3Focus", null, "int");
        final ListIterator listIterator = DramaManager.lookupWME("BeatCompletedWME").listIterator();
        while (listIterator.hasNext()) {
            final BeatCompletedWME beatCompletedWME = listIterator.next();
            if (beatCompletedWME.getBeatID() >= 36 && beatCompletedWME.getBeatID() <= 40) {
                return false;
            }
        }
        final ListIterator listIterator2 = DramaManager.lookupWME("BeatCompletedWME").listIterator();
        while (listIterator2.hasNext()) {
            if (listIterator2.next().getBeatID() == 34) {
                final ListIterator listIterator3 = DramaManager.lookupWME("BeatRevelationsP2WME").listIterator();
                while (listIterator3.hasNext()) {
                    final BeatRevelationsP2WME beatRevelationsP2WME = listIterator3.next();
                    final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("rev1Focus");
                    final int rev1CharFocus = beatRevelationsP2WME.getRev1CharFocus();
                    intValue.i = rev1CharFocus;
                    if (DramaManager.constantTrue(rev1CharFocus)) {
                        final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("rev2Focus");
                        final int rev2CharFocus = beatRevelationsP2WME.getRev2CharFocus();
                        intValue2.i = rev2CharFocus;
                        if (!DramaManager.constantTrue(rev2CharFocus)) {
                            continue;
                        }
                        final VariableScope.IntValue intValue3 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("rev3Focus");
                        final int rev3CharFocus = beatRevelationsP2WME.getRev3CharFocus();
                        intValue3.i = rev3CharFocus;
                        if (DramaManager.constantTrue(rev3CharFocus) && (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("rev1Focus")).i != -1 || ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("rev2Focus")).i != -1 || ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("rev3Focus")).i != -1)) {
                            return true;
                        }
                        continue;
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean _EndingNoRevelations_precondition1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_EndingNoRevelations_precondition1_scope");
        final ListIterator<BeatCompletedWME> listIterator = (ListIterator<BeatCompletedWME>)DramaManager.lookupWME("BeatCompletedWME").listIterator();
        while (listIterator.hasNext()) {
            final BeatCompletedWME beatCompletedWME = listIterator.next();
            if (beatCompletedWME.getBeatID() >= 36 && beatCompletedWME.getBeatID() <= 40) {
                return false;
            }
        }
        final ListIterator<BeatCompletedWME> listIterator2 = (ListIterator<BeatCompletedWME>)DramaManager.lookupWME("BeatCompletedWME").listIterator();
        while (listIterator2.hasNext()) {
            if (((BeatCompletedWME)listIterator2.next()).getBeatID() == 34) {
                final ListIterator<BeatRevelationsP2WME> listIterator3 = (ListIterator<BeatRevelationsP2WME>)DramaManager.lookupWME("BeatRevelationsP2WME").listIterator();
                while (listIterator3.hasNext()) {
                    final BeatRevelationsP2WME beatRevelationsP2WME = listIterator3.next();
                    if (beatRevelationsP2WME.getRev1CharFocus() == -1 && beatRevelationsP2WME.getRev2CharFocus() == -1 && beatRevelationsP2WME.getRev3CharFocus() == -1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean _EndingSelfRevelationOnly_precondition1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_EndingSelfRevelationOnly_precondition1_scope");
        variableScopeThrowsErrors.defineVariable("rev1Focus", null, "int");
        variableScopeThrowsErrors.defineVariable("rev2Focus", null, "int");
        variableScopeThrowsErrors.defineVariable("rev3Focus", null, "int");
        final ListIterator listIterator = DramaManager.lookupWME("BeatCompletedWME").listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.next().getBeatID() == 35) {
                final ListIterator listIterator2 = DramaManager.lookupWME("BeatCompletedWME").listIterator();
                while (listIterator2.hasNext()) {
                    final BeatCompletedWME beatCompletedWME = listIterator2.next();
                    if (beatCompletedWME.getBeatID() >= 36 && beatCompletedWME.getBeatID() <= 40) {
                        return false;
                    }
                }
                final ListIterator listIterator3 = DramaManager.lookupWME("BeatRevelationsP2WME").listIterator();
                while (listIterator3.hasNext()) {
                    final BeatRevelationsP2WME beatRevelationsP2WME = listIterator3.next();
                    final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("rev1Focus");
                    final int rev1CharFocus = beatRevelationsP2WME.getRev1CharFocus();
                    intValue.i = rev1CharFocus;
                    if (DramaManager.constantTrue(rev1CharFocus)) {
                        final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("rev2Focus");
                        final int rev2CharFocus = beatRevelationsP2WME.getRev2CharFocus();
                        intValue2.i = rev2CharFocus;
                        if (!DramaManager.constantTrue(rev2CharFocus)) {
                            continue;
                        }
                        final VariableScope.IntValue intValue3 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("rev3Focus");
                        final int rev3CharFocus = beatRevelationsP2WME.getRev3CharFocus();
                        intValue3.i = rev3CharFocus;
                        if (DramaManager.constantTrue(rev3CharFocus) && (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("rev1Focus")).i == 1 || ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("rev1Focus")).i == 0 || ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("rev2Focus")).i == 1 || ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("rev2Focus")).i == 0 || ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("rev3Focus")).i == 1 || ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("rev3Focus")).i == 0) && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("rev1Focus")).i != 2 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("rev2Focus")).i != 2 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("rev3Focus")).i != 2) {
                            return true;
                        }
                        continue;
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean _EndingRelationshipRevelationOnly_precondition1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_EndingRelationshipRevelationOnly_precondition1_scope");
        variableScopeThrowsErrors.defineVariable("rev1Focus", null, "int");
        variableScopeThrowsErrors.defineVariable("rev2Focus", null, "int");
        variableScopeThrowsErrors.defineVariable("rev3Focus", null, "int");
        final ListIterator listIterator = DramaManager.lookupWME("BeatCompletedWME").listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.next().getBeatID() == 35) {
                final ListIterator listIterator2 = DramaManager.lookupWME("BeatCompletedWME").listIterator();
                while (listIterator2.hasNext()) {
                    final BeatCompletedWME beatCompletedWME = listIterator2.next();
                    if (beatCompletedWME.getBeatID() >= 36 && beatCompletedWME.getBeatID() <= 40) {
                        return false;
                    }
                }
                final ListIterator listIterator3 = DramaManager.lookupWME("BeatRevelationsP2WME").listIterator();
                while (listIterator3.hasNext()) {
                    final BeatRevelationsP2WME beatRevelationsP2WME = listIterator3.next();
                    final VariableScope.IntValue intValue = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("rev1Focus");
                    final int rev1CharFocus = beatRevelationsP2WME.getRev1CharFocus();
                    intValue.i = rev1CharFocus;
                    if (DramaManager.constantTrue(rev1CharFocus)) {
                        final VariableScope.IntValue intValue2 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("rev2Focus");
                        final int rev2CharFocus = beatRevelationsP2WME.getRev2CharFocus();
                        intValue2.i = rev2CharFocus;
                        if (!DramaManager.constantTrue(rev2CharFocus)) {
                            continue;
                        }
                        final VariableScope.IntValue intValue3 = (VariableScope.IntValue)variableScopeThrowsErrors.getValue("rev3Focus");
                        final int rev3CharFocus = beatRevelationsP2WME.getRev3CharFocus();
                        intValue3.i = rev3CharFocus;
                        if (DramaManager.constantTrue(rev3CharFocus) && (((VariableScope.IntValue)variableScopeThrowsErrors.getValue("rev1Focus")).i == 2 || ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("rev2Focus")).i == 2 || ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("rev3Focus")).i == 2) && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("rev1Focus")).i != 1 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("rev1Focus")).i != 0 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("rev2Focus")).i != 1 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("rev2Focus")).i != 0 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("rev3Focus")).i != 1 && ((VariableScope.IntValue)variableScopeThrowsErrors.getValue("rev3Focus")).i != 0) {
                            return true;
                        }
                        continue;
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean _EndingSelfAndRelationshipNotGTR_precondition1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_EndingSelfAndRelationshipNotGTR_precondition1_scope");
        final ListIterator<BeatCompletedWME> listIterator = (ListIterator<BeatCompletedWME>)DramaManager.lookupWME("BeatCompletedWME").listIterator();
        while (listIterator.hasNext()) {
            if (((BeatCompletedWME)listIterator.next()).getBeatID() == 35) {
                final ListIterator<BeatCompletedWME> listIterator2 = (ListIterator<BeatCompletedWME>)DramaManager.lookupWME("BeatCompletedWME").listIterator();
                while (listIterator2.hasNext()) {
                    final BeatCompletedWME beatCompletedWME = listIterator2.next();
                    if (beatCompletedWME.getBeatID() >= 36 && beatCompletedWME.getBeatID() <= 40) {
                        return false;
                    }
                }
                if (((LinkedList)variableScopeThrowsErrors.getVariable("wmeList").value).size() == 1 && ((((VariableScope.BooleanValue)variableScopeThrowsErrors.getValue("tripRev")).b && ((VariableScope.BooleanValue)variableScopeThrowsErrors.getValue("relationshipRev")).b) || (((VariableScope.BooleanValue)variableScopeThrowsErrors.getValue("graceRev")).b && ((VariableScope.BooleanValue)variableScopeThrowsErrors.getValue("relationshipRev")).b)) && (!((VariableScope.BooleanValue)variableScopeThrowsErrors.getValue("tripRev")).b || !((VariableScope.BooleanValue)variableScopeThrowsErrors.getValue("graceRev")).b)) {
                    return true;
                }
                continue;
            }
        }
        return false;
    }
    
    public static boolean _EndingGTR_precondition1(final VariableScope variableScope) {
        final VariableScopeThrowsErrors variableScopeThrowsErrors = new VariableScopeThrowsErrors(variableScope, "_EndingGTR_precondition1_scope");
        final ListIterator<BeatCompletedWME> listIterator = (ListIterator<BeatCompletedWME>)DramaManager.lookupWME("BeatCompletedWME").listIterator();
        while (listIterator.hasNext()) {
            if (((BeatCompletedWME)listIterator.next()).getBeatID() == 35) {
                final ListIterator<BeatCompletedWME> listIterator2 = (ListIterator<BeatCompletedWME>)DramaManager.lookupWME("BeatCompletedWME").listIterator();
                while (listIterator2.hasNext()) {
                    final BeatCompletedWME beatCompletedWME = listIterator2.next();
                    if (beatCompletedWME.getBeatID() >= 36 && beatCompletedWME.getBeatID() <= 40) {
                        return false;
                    }
                }
                if (((LinkedList)variableScopeThrowsErrors.getVariable("wmeList").value).size() == 1 && ((VariableScope.BooleanValue)variableScopeThrowsErrors.getValue("tripRev")).b && ((VariableScope.BooleanValue)variableScopeThrowsErrors.getValue("graceRev")).b && ((VariableScope.BooleanValue)variableScopeThrowsErrors.getValue("relationshipRev")).b) {
                    return true;
                }
                continue;
            }
        }
        return false;
    }
}
