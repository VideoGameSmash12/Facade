package facade.characters.wmedef;

import wm.TimeStampedWME;

public class DeflectModeWME extends TimeStampedWME
{
    private int mode;
    private int reestWho;
    private int reestPlayer;
    private int reestDialog1;
    private int reestFEBase1;
    private int reestMood1;
    private int reestDialog2;
    private int reestFEBase2;
    private int reestMood2;
    private int reestDialog3;
    private int reestFEBase3;
    private int reestMood3;
    private int reestOtherFinalSigh;
    private boolean reestBSetReest;
    
    public synchronized int getMode() {
        return this.mode;
    }
    
    public synchronized int getReestWho() {
        return this.reestWho;
    }
    
    public synchronized int getReestPlayer() {
        return this.reestPlayer;
    }
    
    public synchronized int getReestDialog1() {
        return this.reestDialog1;
    }
    
    public synchronized int getReestFEBase1() {
        return this.reestFEBase1;
    }
    
    public synchronized int getReestMood1() {
        return this.reestMood1;
    }
    
    public synchronized int getReestDialog2() {
        return this.reestDialog2;
    }
    
    public synchronized int getReestFEBase2() {
        return this.reestFEBase2;
    }
    
    public synchronized int getReestMood2() {
        return this.reestMood2;
    }
    
    public synchronized int getReestDialog3() {
        return this.reestDialog3;
    }
    
    public synchronized int getReestFEBase3() {
        return this.reestFEBase3;
    }
    
    public synchronized int getReestMood3() {
        return this.reestMood3;
    }
    
    public synchronized int getReestOtherFinalSigh() {
        return this.reestOtherFinalSigh;
    }
    
    public synchronized boolean getReestBSetReest() {
        return this.reestBSetReest;
    }
    
    public synchronized void setMode(final int mode) {
        this.mode = mode;
    }
    
    public synchronized void setReestWho(final int reestWho) {
        this.reestWho = reestWho;
    }
    
    public synchronized void setReestPlayer(final int reestPlayer) {
        this.reestPlayer = reestPlayer;
    }
    
    public synchronized void setReestDialog1(final int reestDialog1) {
        this.reestDialog1 = reestDialog1;
    }
    
    public synchronized void setReestFEBase1(final int reestFEBase1) {
        this.reestFEBase1 = reestFEBase1;
    }
    
    public synchronized void setReestMood1(final int reestMood1) {
        this.reestMood1 = reestMood1;
    }
    
    public synchronized void setReestDialog2(final int reestDialog2) {
        this.reestDialog2 = reestDialog2;
    }
    
    public synchronized void setReestFEBase2(final int reestFEBase2) {
        this.reestFEBase2 = reestFEBase2;
    }
    
    public synchronized void setReestMood2(final int reestMood2) {
        this.reestMood2 = reestMood2;
    }
    
    public synchronized void setReestDialog3(final int reestDialog3) {
        this.reestDialog3 = reestDialog3;
    }
    
    public synchronized void setReestFEBase3(final int reestFEBase3) {
        this.reestFEBase3 = reestFEBase3;
    }
    
    public synchronized void setReestMood3(final int reestMood3) {
        this.reestMood3 = reestMood3;
    }
    
    public synchronized void setReestOtherFinalSigh(final int reestOtherFinalSigh) {
        this.reestOtherFinalSigh = reestOtherFinalSigh;
    }
    
    public synchronized void setReestBSetReest(final boolean reestBSetReest) {
        this.reestBSetReest = reestBSetReest;
    }
    
    public DeflectModeWME(final int mode) {
        this.mode = mode;
        this.reestWho = -1;
        this.reestPlayer = -1;
        this.reestDialog1 = -1;
        this.reestFEBase1 = -1;
        this.reestMood1 = -1;
        this.reestDialog2 = -1;
        this.reestFEBase2 = -1;
        this.reestMood2 = -1;
        this.reestDialog3 = -1;
        this.reestFEBase3 = -1;
        this.reestMood3 = -1;
        this.reestOtherFinalSigh = -1;
        this.reestBSetReest = false;
    }
}
