package facade.characters.wmedef;

import javax.swing.JComboBox;
import wm.WMEFieldEditor;
import facade.util.PrintUtilities;
import wm.TimeStampedWME;

public class BeatRevelationsP2WME extends TimeStampedWME
{
    private int rev1Who;
    private int rev1Topic;
    private int rev1CharFocus;
    private int rev2Who;
    private int rev2Topic;
    private int rev2CharFocus;
    private int rev3Who;
    private int rev3Topic;
    private int rev3CharFocus;
    private boolean bChallenged;
    private boolean bChallengedALot;
    private int litanyA1;
    private int litanyA2;
    private int litanyA3;
    private int litanyB1;
    private int litanyB2;
    private int litanyB3;
    private int litanyC1;
    private int litanyC2;
    private int litanyC3;
    private int litanyD;
    private int litanyE_CrisisCorrect;
    private int litanyE_CrisisIncorrect;
    private int litanyF;
    private int endingPrimarySpeaker;
    private int endingNonPrimarySpeaker;
    private int endingSRNotGTR_RelatSpeaker;
    
    public synchronized int getRev1Who() {
        return this.rev1Who;
    }
    
    public synchronized int getRev1Topic() {
        return this.rev1Topic;
    }
    
    public synchronized int getRev1CharFocus() {
        return this.rev1CharFocus;
    }
    
    public synchronized int getRev2Who() {
        return this.rev2Who;
    }
    
    public synchronized int getRev2Topic() {
        return this.rev2Topic;
    }
    
    public synchronized int getRev2CharFocus() {
        return this.rev2CharFocus;
    }
    
    public synchronized int getRev3Who() {
        return this.rev3Who;
    }
    
    public synchronized int getRev3Topic() {
        return this.rev3Topic;
    }
    
    public synchronized int getRev3CharFocus() {
        return this.rev3CharFocus;
    }
    
    public synchronized boolean getBChallenged() {
        return this.bChallenged;
    }
    
    public synchronized boolean getBChallengedALot() {
        return this.bChallengedALot;
    }
    
    public synchronized int getLitanyA1() {
        return this.litanyA1;
    }
    
    public synchronized int getLitanyA2() {
        return this.litanyA2;
    }
    
    public synchronized int getLitanyA3() {
        return this.litanyA3;
    }
    
    public synchronized int getLitanyB1() {
        return this.litanyB1;
    }
    
    public synchronized int getLitanyB2() {
        return this.litanyB2;
    }
    
    public synchronized int getLitanyB3() {
        return this.litanyB3;
    }
    
    public synchronized int getLitanyC1() {
        return this.litanyC1;
    }
    
    public synchronized int getLitanyC2() {
        return this.litanyC2;
    }
    
    public synchronized int getLitanyC3() {
        return this.litanyC3;
    }
    
    public synchronized int getLitanyD() {
        return this.litanyD;
    }
    
    public synchronized int getLitanyE_CrisisCorrect() {
        return this.litanyE_CrisisCorrect;
    }
    
    public synchronized int getLitanyE_CrisisIncorrect() {
        return this.litanyE_CrisisIncorrect;
    }
    
    public synchronized int getLitanyF() {
        return this.litanyF;
    }
    
    public synchronized int getEndingPrimarySpeaker() {
        return this.endingPrimarySpeaker;
    }
    
    public synchronized int getEndingNonPrimarySpeaker() {
        return this.endingNonPrimarySpeaker;
    }
    
    public synchronized int getEndingSRNotGTR_RelatSpeaker() {
        return this.endingSRNotGTR_RelatSpeaker;
    }
    
    public synchronized void setRev1Who(final int rev1Who) {
        this.rev1Who = rev1Who;
    }
    
    public synchronized void setRev1Topic(final int rev1Topic) {
        this.rev1Topic = rev1Topic;
    }
    
    public synchronized void setRev1CharFocus(final int rev1CharFocus) {
        this.rev1CharFocus = rev1CharFocus;
    }
    
    public synchronized void setRev2Who(final int rev2Who) {
        this.rev2Who = rev2Who;
    }
    
    public synchronized void setRev2Topic(final int rev2Topic) {
        this.rev2Topic = rev2Topic;
    }
    
    public synchronized void setRev2CharFocus(final int rev2CharFocus) {
        this.rev2CharFocus = rev2CharFocus;
    }
    
    public synchronized void setRev3Who(final int rev3Who) {
        this.rev3Who = rev3Who;
    }
    
    public synchronized void setRev3Topic(final int rev3Topic) {
        this.rev3Topic = rev3Topic;
    }
    
    public synchronized void setRev3CharFocus(final int rev3CharFocus) {
        this.rev3CharFocus = rev3CharFocus;
    }
    
    public synchronized void setBChallenged(final boolean bChallenged) {
        this.bChallenged = bChallenged;
    }
    
    public synchronized void setBChallengedALot(final boolean bChallengedALot) {
        this.bChallengedALot = bChallengedALot;
    }
    
    public synchronized void setLitanyA1(final int litanyA1) {
        this.litanyA1 = litanyA1;
    }
    
    public synchronized void setLitanyA2(final int litanyA2) {
        this.litanyA2 = litanyA2;
    }
    
    public synchronized void setLitanyA3(final int litanyA3) {
        this.litanyA3 = litanyA3;
    }
    
    public synchronized void setLitanyB1(final int litanyB1) {
        this.litanyB1 = litanyB1;
    }
    
    public synchronized void setLitanyB2(final int litanyB2) {
        this.litanyB2 = litanyB2;
    }
    
    public synchronized void setLitanyB3(final int litanyB3) {
        this.litanyB3 = litanyB3;
    }
    
    public synchronized void setLitanyC1(final int litanyC1) {
        this.litanyC1 = litanyC1;
    }
    
    public synchronized void setLitanyC2(final int litanyC2) {
        this.litanyC2 = litanyC2;
    }
    
    public synchronized void setLitanyC3(final int litanyC3) {
        this.litanyC3 = litanyC3;
    }
    
    public synchronized void setLitanyD(final int litanyD) {
        this.litanyD = litanyD;
    }
    
    public synchronized void setLitanyE_CrisisCorrect(final int litanyE_CrisisCorrect) {
        this.litanyE_CrisisCorrect = litanyE_CrisisCorrect;
    }
    
    public synchronized void setLitanyE_CrisisIncorrect(final int litanyE_CrisisIncorrect) {
        this.litanyE_CrisisIncorrect = litanyE_CrisisIncorrect;
    }
    
    public synchronized void setLitanyF(final int litanyF) {
        this.litanyF = litanyF;
    }
    
    public synchronized void setEndingPrimarySpeaker(final int endingPrimarySpeaker) {
        this.endingPrimarySpeaker = endingPrimarySpeaker;
    }
    
    public synchronized void setEndingNonPrimarySpeaker(final int endingNonPrimarySpeaker) {
        this.endingNonPrimarySpeaker = endingNonPrimarySpeaker;
    }
    
    public synchronized void setEndingSRNotGTR_RelatSpeaker(final int endingSRNotGTR_RelatSpeaker) {
        this.endingSRNotGTR_RelatSpeaker = endingSRNotGTR_RelatSpeaker;
    }
    
    public synchronized String formatRev1CharFocus() {
        return PrintUtilities.therapyGameCharFocus_EnumToString(this.getRev1CharFocus());
    }
    
    public synchronized String formatRev2CharFocus() {
        return PrintUtilities.therapyGameCharFocus_EnumToString(this.getRev2CharFocus());
    }
    
    public synchronized String formatRev3CharFocus() {
        return PrintUtilities.therapyGameCharFocus_EnumToString(this.getRev3CharFocus());
    }
    
    public WMEFieldEditor _getRev1CharFocusEditor() {
        return new CharFocusEditor(1);
    }
    
    public WMEFieldEditor _getRev2CharFocusEditor() {
        return new CharFocusEditor(2);
    }
    
    public WMEFieldEditor _getRev3CharFocusEditor() {
        return new CharFocusEditor(3);
    }
    
    public BeatRevelationsP2WME(final int rev1Who, final int rev1Topic, final int rev1CharFocus, final int rev2Who, final int rev2Topic, final int rev2CharFocus, final int rev3Who, final int rev3Topic, final int rev3CharFocus, final boolean bChallenged, final boolean bChallengedALot) {
        this.rev1Who = rev1Who;
        this.rev1Topic = rev1Topic;
        this.rev1CharFocus = rev1CharFocus;
        this.rev2Who = rev2Who;
        this.rev2Topic = rev2Topic;
        this.rev2CharFocus = rev2CharFocus;
        this.rev3Who = rev3Who;
        this.rev3Topic = rev3Topic;
        this.rev3CharFocus = rev3CharFocus;
        this.bChallenged = bChallenged;
        this.bChallengedALot = bChallengedALot;
        this.litanyA1 = -1;
        this.litanyA2 = -1;
        this.litanyA3 = -1;
        this.litanyB1 = -1;
        this.litanyB2 = -1;
        this.litanyB3 = -1;
        this.litanyC1 = -1;
        this.litanyC2 = -1;
        this.litanyC3 = -1;
        this.litanyD = -1;
        this.litanyE_CrisisCorrect = -1;
        this.litanyE_CrisisIncorrect = -1;
        this.litanyF = -1;
        this.endingPrimarySpeaker = -1;
        this.endingNonPrimarySpeaker = -1;
        this.endingSRNotGTR_RelatSpeaker = -1;
    }
    
    public BeatRevelationsP2WME() {
    }
    
    private class CharFocusEditor extends JComboBox implements WMEFieldEditor
    {
        int revNum;
        private static final /* synthetic */ boolean $noassert;
        
        private final int getCharFocus() {
            switch (this.revNum) {
                case 1: {
                    return BeatRevelationsP2WME.this.getRev1CharFocus();
                }
                case 2: {
                    return BeatRevelationsP2WME.this.getRev2CharFocus();
                }
                case 3: {
                    return BeatRevelationsP2WME.this.getRev3CharFocus();
                }
                default: {
                    throw new Error("Unexpected revNum");
                }
            }
        }
        
        public String getFieldValue() {
            return Integer.toString(PrintUtilities.therapyGameCharFocus_StringToEnum((String)this.getSelectedItem()));
        }
        
        public void setFieldValue(final String s) {
            this.setSelectedItem(PrintUtilities.therapyGameCharFocus_EnumToString(Integer.parseInt(s)));
        }
        
        CharFocusEditor(final int revNum) {
            super(PrintUtilities.therapyGameCharFocus_GetEnumArray());
            if (!CharFocusEditor.$noassert && (revNum < 1 || revNum > 3)) {
                throw new AssertionError();
            }
            this.revNum = revNum;
            this.setEditable(false);
            this.setSelectedItem(PrintUtilities.therapyGameCharFocus_EnumToString(this.getCharFocus()));
        }
        
        static {
            $noassert = (Class.forName("[Lfacade.characters.wmedef.BeatRevelationsP2WME;").getComponentType().desiredAssertionStatus() ^ true);
        }
    }
}
