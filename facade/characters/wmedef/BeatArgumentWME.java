package facade.characters.wmedef;

import facade.util.PrintUtilities;
import wm.WME;

public class BeatArgumentWME extends WME
{
    private int txnInType;
    private int txnOutType;
    private int txnOutDARxnType;
    private boolean bPositiveSpin;
    private int miscBeatArgument;
    
    public String formatTxnInType() {
        return PrintUtilities.beatArgument_txn_EnumToString(this.getTxnInType());
    }
    
    public String formatTxnOutType() {
        return PrintUtilities.beatArgument_txn_EnumToString(this.getTxnOutType());
    }
    
    public synchronized int getTxnInType() {
        return this.txnInType;
    }
    
    public synchronized int getTxnOutType() {
        return this.txnOutType;
    }
    
    public synchronized int getTxnOutDARxnType() {
        return this.txnOutDARxnType;
    }
    
    public synchronized boolean getBPositiveSpin() {
        return this.bPositiveSpin;
    }
    
    public synchronized int getMiscBeatArgument() {
        return this.miscBeatArgument;
    }
    
    public synchronized void setTxnInType(final int txnInType) {
        this.txnInType = txnInType;
    }
    
    public synchronized void setTxnOutType(final int txnOutType) {
        this.txnOutType = txnOutType;
    }
    
    public synchronized void setTxnOutDARxnType(final int txnOutDARxnType) {
        this.txnOutDARxnType = txnOutDARxnType;
    }
    
    public synchronized void setBPositiveSpin(final boolean bPositiveSpin) {
        this.bPositiveSpin = bPositiveSpin;
    }
    
    public synchronized void setMiscBeatArgument(final int miscBeatArgument) {
        this.miscBeatArgument = miscBeatArgument;
    }
    
    public BeatArgumentWME(final int txnInType) {
        this.txnInType = txnInType;
        this.txnOutType = -1;
        this.txnOutDARxnType = -1;
        this.bPositiveSpin = false;
        this.miscBeatArgument = -1;
    }
    
    public BeatArgumentWME(final int txnInType, final int txnOutType) {
        this.txnInType = txnInType;
        this.txnOutType = txnOutType;
        this.txnOutDARxnType = -1;
        this.bPositiveSpin = false;
        this.miscBeatArgument = -1;
    }
    
    public BeatArgumentWME() {
        this.txnInType = -1;
        this.txnOutType = -1;
        this.txnOutDARxnType = -1;
        this.bPositiveSpin = false;
        this.miscBeatArgument = -1;
    }
    
    public BeatArgumentWME(final int txnInType, final int txnOutType, final int txnOutDARxnType, final boolean bPositiveSpin, final int miscBeatArgument) {
        this.txnInType = txnInType;
        this.txnOutType = txnOutType;
        this.txnOutDARxnType = txnOutDARxnType;
        this.bPositiveSpin = bPositiveSpin;
        this.miscBeatArgument = miscBeatArgument;
    }
}
