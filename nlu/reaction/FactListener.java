package nlu.reaction;

import jess.JessException;
import jess.Context;
import java.util.Vector;
import wm.WorkingMemory;
import facade.characters.wmedef.ReactionInfoWME;
import facade.characters.wmedef.ReactionWME;
import facade.characters.wmedef.DAWME;
import jess.Rete;
import jess.Fact;
import jess.JessEvent;
import jess.Deftemplate;
import java.util.List;
import jess.JessListener;

public class FactListener implements JessListener
{
    private List reactionList;
    private final int NOT_A_GLOBAL = -1;
    private static final /* synthetic */ boolean $noassert;
    
    private final boolean isGlobalReaction(final Deftemplate deftemplate) {
        return deftemplate != null && (deftemplate.getBaseName().equals("globalReaction") || this.isGlobalReaction(deftemplate.getParent()));
    }
    
    public void eventHappened(final JessEvent jessEvent) throws JessException {
        if (jessEvent.getType() == 1073741840) {
            final Fact fact = (Fact)jessEvent.getObject();
            final String baseName = fact.getDeftemplate().getBaseName();
            final Context globalContext = ((Rete)jessEvent.getSource()).getGlobalContext();
            if (baseName.equals("winningReaction")) {
                final int intValue = fact.getSlotValue("order").intValue(globalContext);
                if (intValue != -1) {
                    final Fact factValue = fact.getSlotValue("reactionFactID").factValue(globalContext);
                    if (!FactListener.$noassert && factValue.getSlotValue("rxnType").atomValue(globalContext).equals("nil")) {
                        throw new AssertionError();
                    }
                    if (!FactListener.$noassert && factValue.getSlotValue("priority").atomValue(globalContext).equals("nil")) {
                        throw new AssertionError();
                    }
                    final int intValue2 = factValue.getSlotValue("rxnType").intValue(globalContext);
                    final int intValue3 = factValue.getSlotValue("priority").intValue(globalContext);
                    DAWME dawme;
                    if (intValue2 != 6) {
                        dawme = (DAWME)factValue.getSlotValue("daWME").externalAddressValue(globalContext);
                    }
                    else {
                        dawme = null;
                    }
                    if (factValue.getDeftemplate().getBaseName().equals("deflectReaction")) {
                        if (!FactListener.$noassert && factValue.getSlotValue("daDeflectCategory").atomValue(globalContext).equals("nil")) {
                            throw new AssertionError();
                        }
                        this.reactionList.add(new ReactionWME(intValue2, -1, -1, intValue, intValue3, factValue.getSlotValue("daDeflectCategory").intValue(globalContext), -1, dawme, null));
                    }
                    else if (factValue.getDeftemplate().getBaseName().equals("objectReaction")) {
                        if (!FactListener.$noassert && factValue.getSlotValue("rxnCategory").atomValue(globalContext).equals("nil")) {
                            throw new AssertionError();
                        }
                        if (!FactListener.$noassert && factValue.getSlotValue("rxnCategoryLevel").atomValue(globalContext).equals("nil")) {
                            throw new AssertionError();
                        }
                        this.reactionList.add(new ReactionWME(intValue2, factValue.getSlotValue("rxnCategory").intValue(globalContext), factValue.getSlotValue("rxnCategoryLevel").intValue(globalContext), intValue, intValue3, -1, -1, dawme, (ReactionInfoWME)factValue.getSlotValue("reactionInfoRef").externalAddressValue(globalContext)));
                    }
                    else if (factValue.getDeftemplate().getBaseName().equals("satelliteReaction")) {
                        if (!FactListener.$noassert && factValue.getSlotValue("rxnCategory").atomValue(globalContext).equals("nil")) {
                            throw new AssertionError();
                        }
                        if (!FactListener.$noassert && factValue.getSlotValue("rxnCategoryLevel").atomValue(globalContext).equals("nil")) {
                            throw new AssertionError();
                        }
                        this.reactionList.add(new ReactionWME(intValue2, factValue.getSlotValue("rxnCategory").intValue(globalContext), factValue.getSlotValue("rxnCategoryLevel").intValue(globalContext), intValue, intValue3, -1, -1, dawme, (ReactionInfoWME)factValue.getSlotValue("reactionInfoRef").externalAddressValue(globalContext)));
                    }
                    else if (factValue.getDeftemplate().getBaseName().equals("daReaction")) {
                        if (!FactListener.$noassert && factValue.getSlotValue("rxnCategory").atomValue(globalContext).equals("nil")) {
                            throw new AssertionError();
                        }
                        if (!FactListener.$noassert && factValue.getSlotValue("rxnCategoryLevel").atomValue(globalContext).equals("nil")) {
                            throw new AssertionError();
                        }
                        this.reactionList.add(new ReactionWME(intValue2, factValue.getSlotValue("rxnCategory").intValue(globalContext), factValue.getSlotValue("rxnCategoryLevel").intValue(globalContext), intValue, intValue3, -1, -1, dawme, (ReactionInfoWME)factValue.getSlotValue("reactionInfoRef").externalAddressValue(globalContext)));
                    }
                    else if (factValue.getDeftemplate().getBaseName().equals("pushTooFarReaction")) {
                        if (!FactListener.$noassert && factValue.getSlotValue("rxnCategory").atomValue(globalContext).equals("nil")) {
                            throw new AssertionError();
                        }
                        if (!FactListener.$noassert && factValue.getSlotValue("rxnCategoryLevel").atomValue(globalContext).equals("nil")) {
                            throw new AssertionError();
                        }
                        if (!FactListener.$noassert && factValue.getSlotValue("origSatlOrObjParam").atomValue(globalContext).equals("nil")) {
                            throw new AssertionError();
                        }
                        this.reactionList.add(new ReactionWME(intValue2, factValue.getSlotValue("rxnCategory").intValue(globalContext), factValue.getSlotValue("rxnCategoryLevel").intValue(globalContext), intValue, intValue3, factValue.getSlotValue("origSatlOrObjParam").intValue(globalContext), -1, dawme, (ReactionInfoWME)factValue.getSlotValue("reactionInfoRef").externalAddressValue(globalContext)));
                    }
                    else if (factValue.getDeftemplate().getBaseName().equals("subtopicSwitchReaction")) {
                        if (!FactListener.$noassert && factValue.getSlotValue("subtopicID").atomValue(globalContext).equals("nil")) {
                            throw new AssertionError();
                        }
                        this.reactionList.add(new ReactionWME(intValue2, -1, -1, intValue, intValue3, factValue.getSlotValue("subtopicID").intValue(globalContext), -1, dawme, null));
                    }
                    else if (factValue.getDeftemplate().getBaseName().equals("tellMeMoreAboutReaction")) {
                        if (!FactListener.$noassert && factValue.getSlotValue("subtopicID").atomValue(globalContext).equals("nil")) {
                            throw new AssertionError();
                        }
                        this.reactionList.add(new ReactionWME(intValue2, -1, -1, intValue, intValue3, factValue.getSlotValue("subtopicID").intValue(globalContext), -1, dawme, null));
                    }
                    else if (factValue.getDeftemplate().getBaseName().equals("mixinBeforeBeatGistReaction")) {
                        if (!FactListener.$noassert && factValue.getSlotValue("mixinParam").atomValue(globalContext).equals("nil")) {
                            throw new AssertionError();
                        }
                        if (!FactListener.$noassert && factValue.getSlotValue("daParam").atomValue(globalContext).equals("nil")) {
                            throw new AssertionError();
                        }
                        this.reactionList.add(new ReactionWME(intValue2, -1, -1, intValue, intValue3, factValue.getSlotValue("mixinParam").intValue(globalContext), factValue.getSlotValue("daParam").intValue(globalContext), dawme, null));
                    }
                    else if (factValue.getDeftemplate().getBaseName().equals("txnOutReaction")) {
                        if (!FactListener.$noassert && factValue.getSlotValue("txnOutParam").atomValue(globalContext).equals("nil")) {
                            throw new AssertionError();
                        }
                        if (!FactListener.$noassert && factValue.getSlotValue("daParam").atomValue(globalContext).equals("nil")) {
                            throw new AssertionError();
                        }
                        this.reactionList.add(new ReactionWME(intValue2, -1, -1, intValue, intValue3, factValue.getSlotValue("txnOutParam").intValue(globalContext), factValue.getSlotValue("daParam").intValue(globalContext), dawme, null));
                    }
                    else if (factValue.getDeftemplate().getBaseName().equals("tgReaction")) {
                        if (!FactListener.$noassert && factValue.getSlotValue("daType").atomValue(globalContext).equals("nil")) {
                            throw new AssertionError();
                        }
                        if (!FactListener.$noassert && factValue.getSlotValue("daAddressee").atomValue(globalContext).equals("nil")) {
                            throw new AssertionError();
                        }
                        this.reactionList.add(new ReactionWME(intValue2, -1, -1, intValue, intValue3, factValue.getSlotValue("daType").intValue(globalContext), factValue.getSlotValue("daAddressee").intValue(globalContext), dawme, null));
                    }
                    else {
                        System.out.println("WARNING: ReactionDecider encountered unknown reaction " + factValue.getDeftemplate().getBaseName());
                    }
                }
            }
        }
        else if (jessEvent.getType() == 16384) {
            WorkingMemory.addWMEs("TripMemory", this.reactionList);
            this.reactionList = new Vector();
        }
    }
    
    private final /* synthetic */ void this() {
        this.reactionList = new Vector();
        this.NOT_A_GLOBAL = -1;
    }
    
    public FactListener() {
        this.this();
    }
    
    static {
        $noassert = (Class.forName("[Lnlu.reaction.FactListener;").getComponentType().desiredAssertionStatus() ^ true);
    }
}
