package dramaman.runtime;

import java.util.Collection;
import java.util.Comparator;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;
import facade.nativeinterface.NativeAnimationInterface;
import facade.util.StringUtil;
import facade.util.PrintUtilities;
import wm.WorkingMemoryException;
import wm.WME;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Random;
import java.util.Hashtable;
import java.util.HashSet;
import facade.util.BeatID;

public class DramaManager implements BeatID, DramaManagerConstants
{
    private static StoryMemory storyMemory;
    private static DramaManager dramaManager;
    private String beatPackage;
    private HashSet beatCollection;
    private boolean storyComplete;
    private boolean isMonitored;
    private DramaManagerMonitor monitorGUI;
    private boolean manualTestMode;
    private Beat activeBeat;
    private float cumulativeSquareError;
    private Hashtable targets;
    private final BeatProbabilityComparator beatProbabilityComparator;
    private final BeatPriorityComparator beatPriorityComparator;
    private Random randomGen;
    private Beat manuallySelectedBeat;
    private List conflictSet;
    private static final /* synthetic */ boolean $noassert;
    
    public void initializeDramaManagerState() {
        this.beatCollection = new HashSet();
        try {
            final Method[] declaredMethods = Class.forName(this.beatPackage + ".BeatFactories").getDeclaredMethods();
            for (int i = 0; i < declaredMethods.length; ++i) {
                this.beatCollection.add(declaredMethods[i].invoke(null, (Object[])null));
            }
            DramaManager.storyMemory.setStoryValue("TensionStoryValueWME", 1.0f);
            final StoryStatusWME storyStatusWME = DramaManager.storyMemory.getStoryStatusWME();
            storyStatusWME.setBeatCount(1);
            storyStatusWME.setPreviousBeat(-1);
            storyStatusWME.setCurrentBeat(-1);
            storyStatusWME.setStorySegment(1);
            storyStatusWME.setDramaManagerEnabled(true);
            this.targets = (Hashtable)Class.forName(this.beatPackage + ".StoryTargets").getMethod("getTargets", (Class<?>[])null).invoke(null, (Object[])null);
        }
        catch (Exception ex) {
            throw new DramaManagerError(ex);
        }
        if (this.isMonitored) {
            this.monitorGUI.setStory((Beat[])this.beatCollection.toArray(new Beat[this.beatCollection.size()]), 17, this.targets);
        }
    }
    
    public static DramaManager getDramaManager() {
        return DramaManager.dramaManager;
    }
    
    public boolean isMonitored() {
        return this.isMonitored;
    }
    
    public DramaManagerMonitor getMonitorGUI() {
        return this.monitorGUI;
    }
    
    public boolean isManualTestMode() {
        return this.manualTestMode;
    }
    
    public String getBeatPackage() {
        return this.beatPackage;
    }
    
    public void setManuallySelectedBeat(final Beat manuallySelectedBeat) {
        this.manuallySelectedBeat = manuallySelectedBeat;
    }
    
    public static StoryMemory getStoryMemory() {
        return DramaManager.storyMemory;
    }
    
    public static void addWME(final WME wme) {
        DramaManager.storyMemory.addWME(wme);
    }
    
    public static void modifyWME(final WME wme, final WME wme2) {
        try {
            DramaManager.storyMemory.modifyWME(wme, wme2);
        }
        catch (WorkingMemoryException ex) {
            throw new DramaManagerError(ex);
        }
    }
    
    public static void deleteWME(final WME wme) {
        DramaManager.storyMemory.deleteWME(wme);
    }
    
    public static void deleteAllWMEClass(final String s) {
        DramaManager.storyMemory.deleteAllWMEClass(s);
    }
    
    public static List lookupWME(final String s) {
        return DramaManager.storyMemory.lookupWME(s);
    }
    
    public static void manageDrama(final String s, final boolean b, final boolean b2) {
        new DramaManager(s, b, b2).startManaging();
    }
    
    public Beat getActiveBeat() {
        return this.activeBeat;
    }
    
    public String getStoryValueWMEName(final String s) {
        return this.targets.get(s).getValueWMEName();
    }
    
    public void succeedCurrentBeat() {
        if (!DramaManager.$noassert && this.activeBeat == null) {
            throw new AssertionError();
        }
        StringUtil.println("Succeeding beat " + PrintUtilities.beatID_EnumToString(this.activeBeat.getBeatID()));
        NativeAnimationInterface.addEventInfoToLog("Succeeding beat " + PrintUtilities.beatID_EnumToString(this.activeBeat.getBeatID()));
        this.activeBeat.succeed();
        if (this.isMonitored) {
            this.monitorGUI.succeedBeat(this.activeBeat);
        }
        final StoryStatusWME storyStatusWME = DramaManager.storyMemory.getStoryStatusWME();
        storyStatusWME.setPreviousBeat(this.activeBeat.getBeatID());
        storyStatusWME.setCurrentBeat(-1);
        storyStatusWME.setBeatCount(storyStatusWME.getBeatCount() + 1);
        DramaManager.storyMemory.addWME(new BeatCompletedWME(this.activeBeat));
        this.activeBeat = this.chooseBeat();
        if (this.activeBeat != null) {
            this.activateBeat();
        }
    }
    
    public void failCurrentBeat() {
        this.failCurrentBeat(0);
    }
    
    public void failCurrentBeat(final int n) {
        if (!DramaManager.$noassert && this.activeBeat == null) {
            throw new AssertionError();
        }
        StringUtil.println("Aborting beat " + PrintUtilities.beatID_EnumToString(this.activeBeat.getBeatID()) + " for reason " + PrintUtilities.beatAbortReason_EnumToString(n));
        NativeAnimationInterface.addEventInfoToLog("Aborting beat " + PrintUtilities.beatID_EnumToString(this.activeBeat.getBeatID()) + " for reason " + PrintUtilities.beatAbortReason_EnumToString(n));
        this.activeBeat.abort();
        if (this.isMonitored) {
            this.monitorGUI.failBeat(this.activeBeat);
        }
        final StoryStatusWME storyStatusWME = DramaManager.storyMemory.getStoryStatusWME();
        storyStatusWME.setPreviousBeat(this.activeBeat.getBeatID());
        storyStatusWME.setCurrentBeat(-1);
        DramaManager.storyMemory.addWME(new BeatAbortWME(this.activeBeat, n));
        this.activeBeat = this.chooseBeat();
        if (this.activeBeat != null) {
            this.activateBeat();
        }
    }
    
    public void terminateStory() {
        if (this.activeBeat != null) {
            this.activeBeat.succeed();
            if (this.isMonitored) {
                this.monitorGUI.succeedBeat(this.activeBeat);
            }
            final StoryStatusWME storyStatusWME = DramaManager.storyMemory.getStoryStatusWME();
            storyStatusWME.setPreviousBeat(this.activeBeat.getBeatID());
            storyStatusWME.setCurrentBeat(-1);
            storyStatusWME.setBeatCount(storyStatusWME.getBeatCount() + 1);
            DramaManager.storyMemory.addWME(new BeatCompletedWME(this.activeBeat));
        }
    }
    
    public void startManaging() {
        this.activeBeat = this.chooseBeat();
        if (this.activeBeat != null) {
            this.activateBeat();
        }
    }
    
    private final void activateBeat() {
        StringUtil.println("Activating beat " + PrintUtilities.beatID_EnumToString(this.activeBeat.getBeatID()));
        NativeAnimationInterface.addEventInfoToLog("Activating beat " + PrintUtilities.beatID_EnumToString(this.activeBeat.getBeatID()));
        DramaManager.storyMemory.getStoryStatusWME().setCurrentBeat(this.activeBeat.getBeatID());
        DramaManager.storyMemory.addWME(new BeatStartWME(this.activeBeat));
        this.activeBeat.select();
    }
    
    private final void printSatisfiedBeats(final List list) {
        final Iterator<Beat> iterator = list.iterator();
        final StringBuffer sb = new StringBuffer(500);
        while (iterator.hasNext()) {
            sb.append(PrintUtilities.beatID_EnumToString(iterator.next().getBeatID()) + ' ');
        }
        StringUtil.println("Beats with satisfied preconditions " + sb.toString());
        NativeAnimationInterface.addEventInfoToLog("Beats with satisfied preconditions " + sb.toString());
    }
    
    private final void printBeatsWithPriority(final Beat[] array) {
        final StringBuffer sb = new StringBuffer(1000);
        for (int i = 0; i < array.length; ++i) {
            final Beat beat = array[i];
            sb.append(PrintUtilities.beatID_EnumToString(beat.getBeatID()) + ", " + beat.getPriority() + ' ');
        }
        StringUtil.println("Beats with priority " + sb.toString());
        NativeAnimationInterface.addEventInfoToLog("Beats with priority " + sb.toString());
    }
    
    private final void printBeatsWithProbability(final Beat[] array) {
        final StringBuffer sb = new StringBuffer(1000);
        for (int i = 0; i < array.length; ++i) {
            final Beat beat = array[i];
            sb.append(PrintUtilities.beatID_EnumToString(beat.getBeatID()) + ", " + beat.getProbability() + ' ');
        }
        StringUtil.println("Beats with probability " + sb.toString());
        NativeAnimationInterface.addEventInfoToLog("Beats with probability " + sb.toString());
    }
    
    private final synchronized Beat chooseBeat() {
        if (this.beatCollection.size() == 0) {
            return null;
        }
        final Iterator<Beat> iterator = this.beatCollection.iterator();
        final ArrayList<Beat> list = new ArrayList<Beat>();
        while (iterator.hasNext()) {
            final Beat beat = iterator.next();
            beat.init();
            if (beat.precondition()) {
                list.add(beat);
            }
        }
        this.printSatisfiedBeats(list);
        if (list.size() == 0) {
            return null;
        }
        final Iterator<Object> iterator2 = list.iterator();
        while (iterator2.hasNext()) {
            iterator2.next().setPriority();
        }
        this.conflictSet = new ArrayList();
        final Beat[] array = (Beat[])list.toArray((Object[])new Beat[list.size()]);
        Arrays.sort(array, this.beatPriorityComparator);
        this.printBeatsWithPriority(array);
        this.conflictSet.add(array[0]);
        for (int n = 1; n < array.length && this.beatPriorityComparator.compare(array[0], array[n]) == 0; ++n) {
            this.conflictSet.add(array[n]);
        }
        final Iterator<Beat> iterator3 = this.conflictSet.iterator();
        float n2 = 0.0f;
        while (iterator3.hasNext()) {
            n2 += iterator3.next().rawProbability(this.targets, DramaManager.storyMemory.getStoryStatusWME().getBeatCount());
        }
        for (final Beat beat2 : this.conflictSet) {
            beat2.setProbability(beat2.rawProbability(this.targets, DramaManager.storyMemory.getStoryStatusWME().getBeatCount()) / n2);
        }
        final Beat[] array2 = this.conflictSet.toArray(new Beat[this.conflictSet.size()]);
        Arrays.sort(array2, this.beatProbabilityComparator);
        this.printBeatsWithProbability(array2);
        final ArrayList list2 = new ArrayList<Integer>(array2.length);
        for (int i = 0; i < array2.length; ++i) {
            list2.add(new Integer(array2[i].getBeatID()));
        }
        DramaManager.storyMemory.addWME(new BeatDistributionWME(list2, new ArrayList(Arrays.asList(array2))));
        if (this.isMonitored) {
            this.monitorGUI.refreshSatisfiedBeats(array2, this.targets, DramaManager.storyMemory.getStoryStatusWME().getBeatCount());
        }
        Beat beat3;
        if (!this.manualTestMode) {
            beat3 = this.chooseBeatFromDistribution(array2);
        }
        else {
            try {
                this.wait();
            }
            catch (InterruptedException ex) {
                throw new DramaManagerError(ex.getMessage());
            }
            beat3 = this.manuallySelectedBeat;
        }
        this.beatCollection.remove(beat3);
        if (this.isMonitored) {
            this.monitorGUI.chooseBeat(beat3);
        }
        return beat3;
    }
    
    Beat chooseBeatFromDistribution(final Beat[] array) {
        if (!DramaManager.$noassert && array.length < 1) {
            throw new AssertionError();
        }
        final float nextFloat = this.randomGen.nextFloat();
        float n = 0.0f;
        for (int i = 0; i < array.length; ++i) {
            if (nextFloat < n + array[i].getProbability()) {
                return array[i];
            }
            n += array[i].getProbability();
        }
        return array[array.length - 1];
    }
    
    public synchronized void releaseChooseThread() {
        this.notify();
    }
    
    public static boolean constantTrue(final int n) {
        return true;
    }
    
    public static boolean constantTrue(final float n) {
        return true;
    }
    
    public static boolean constantTrue(final double n) {
        return true;
    }
    
    public static boolean constantTrue(final short n) {
        return true;
    }
    
    public static boolean constantTrue(final long n) {
        return true;
    }
    
    public static boolean constantTrue(final char c) {
        return true;
    }
    
    public static boolean constantTrue(final byte b) {
        return true;
    }
    
    public static boolean constantTrue(final boolean b) {
        return true;
    }
    
    public static boolean constantTrue(final Object o) {
        return true;
    }
    
    public static boolean truePrintln(final String s) {
        System.out.println(s);
        return true;
    }
    
    public static boolean truePrintln(final Object o) {
        return truePrintln(o.toString());
    }
    
    public int[] getConflictSetAsBeatIDs() {
        final int[] array = new int[this.conflictSet.size()];
        final Iterator<Beat> iterator = this.conflictSet.iterator();
        int n = 0;
        while (iterator.hasNext()) {
            array[n++] = iterator.next().getBeatID();
        }
        return array;
    }
    
    public StoryTarget getStoryTarget(final String s) {
        return this.targets.get(s);
    }
    
    private final /* synthetic */ void this() {
        this.storyComplete = false;
        this.isMonitored = false;
        this.monitorGUI = null;
        this.manualTestMode = false;
        this.activeBeat = null;
        this.cumulativeSquareError = 0.0f;
        this.beatProbabilityComparator = new BeatProbabilityComparator();
        this.beatPriorityComparator = new BeatPriorityComparator();
        this.randomGen = new Random();
        this.manuallySelectedBeat = null;
    }
    
    public DramaManager(final String beatPackage, final boolean isMonitored, final boolean manualTestMode) {
        this.this();
        if (!DramaManager.$noassert && (isMonitored || manualTestMode) && !isMonitored) {
            throw new AssertionError();
        }
        this.beatPackage = beatPackage;
        this.isMonitored = isMonitored;
        this.manualTestMode = manualTestMode;
        DramaManager.storyMemory = new StoryMemory();
        DramaManager.dramaManager = this;
        this.beatCollection = new HashSet();
        try {
            final Method[] declaredMethods = Class.forName(beatPackage + ".BeatFactories").getDeclaredMethods();
            for (int i = 0; i < declaredMethods.length; ++i) {
                this.beatCollection.add(declaredMethods[i].invoke(null, (Object[])null));
            }
            DramaManager.storyMemory.addWME(new TensionStoryValueWME(1.0f));
            DramaManager.storyMemory.addWME(new StoryStatusWME());
            this.targets = (Hashtable)Class.forName(beatPackage + ".StoryTargets").getMethod("getTargets", (Class<?>[])null).invoke(null, (Object[])null);
        }
        catch (Exception ex) {
            throw new DramaManagerError(ex);
        }
        if (isMonitored) {
            (this.monitorGUI = new DramaManagerMonitor()).setStory((Beat[])this.beatCollection.toArray(new Beat[this.beatCollection.size()]), 17, this.targets);
        }
    }
    
    static {
        $noassert = (Class.forName("[Ldramaman.runtime.DramaManager;").getComponentType().desiredAssertionStatus() ^ true);
    }
    
    class BeatProbabilityComparator implements Comparator
    {
        public int compare(final Object o, final Object o2) {
            return new Float(((Beat)o2).getProbability()).compareTo(new Float(((Beat)o).getProbability()));
        }
    }
    
    class BeatPriorityComparator implements Comparator
    {
        public int compare(final Object o, final Object o2) {
            return new Integer(((Beat)o2).getPriority()).compareTo(new Integer(((Beat)o).getPriority()));
        }
    }
}
