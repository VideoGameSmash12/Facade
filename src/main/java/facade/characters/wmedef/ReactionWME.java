package facade.characters.wmedef;

import facade.util.PrintUtilities;
import wm.WME;

public class ReactionWME extends WME
{
    private int rxnType;
    private int rxnCategory;
    private int rxnCategoryLevel;
    private int order;
    private int rxnPriority;
    private int param1;
    private int param2;
    private DAWME daWME;
    private ReactionInfoWME reactionInfo;
    
    public synchronized String formatRxnType() {
        return PrintUtilities.rxnType_EnumToString(this.getRxnType());
    }
    
    public synchronized int getRxnType() {
        return this.rxnType;
    }
    
    public synchronized void setRxnType(final int rxnType) {
        this.rxnType = rxnType;
    }
    
    public synchronized int getRxnCategory() {
        return this.rxnCategory;
    }
    
    public synchronized void setRxnCategory(final int rxnCategory) {
        this.rxnCategory = rxnCategory;
    }
    
    public synchronized int getRxnCategoryLevel() {
        return this.rxnCategoryLevel;
    }
    
    public synchronized void setRxnCategoryLevel(final int rxnCategoryLevel) {
        this.rxnCategoryLevel = rxnCategoryLevel;
    }
    
    public synchronized int getOrder() {
        return this.order;
    }
    
    public synchronized void setOrder(final int order) {
        this.order = order;
    }
    
    public synchronized int getRxnPriority() {
        return this.rxnPriority;
    }
    
    public synchronized void setRxnPriority(final int rxnPriority) {
        this.rxnPriority = rxnPriority;
    }
    
    public synchronized int getParam1() {
        return this.param1;
    }
    
    public synchronized void setParam1(final int param1) {
        this.param1 = param1;
    }
    
    public synchronized int getParam2() {
        return this.param2;
    }
    
    public synchronized void setParam2(final int param2) {
        this.param2 = param2;
    }
    
    public synchronized DAWME getDaWME() {
        return this.daWME;
    }
    
    public synchronized void setDaWME(final DAWME daWME) {
        this.daWME = daWME;
    }
    
    public synchronized ReactionInfoWME getReactionInfo() {
        return this.reactionInfo;
    }
    
    public synchronized void setReactionInfo(final ReactionInfoWME reactionInfo) {
        this.reactionInfo = reactionInfo;
    }
    
    private final /* synthetic */ void this() {
        this.param1 = -1;
        this.param2 = -1;
    }
    
    public ReactionWME(final int rxnType, final int rxnCategory, final int rxnCategoryLevel, final int order, final int rxnPriority, final int param1, final int param2, final DAWME daWME, final ReactionInfoWME reactionInfo) {
        this.this();
        this.rxnType = rxnType;
        this.rxnCategory = rxnCategory;
        this.rxnCategoryLevel = rxnCategoryLevel;
        this.order = order;
        this.rxnPriority = rxnPriority;
        this.param1 = param1;
        this.param2 = param2;
        this.daWME = daWME;
        this.reactionInfo = reactionInfo;
    }
    
    public ReactionWME() {
        this.this();
    }
}
