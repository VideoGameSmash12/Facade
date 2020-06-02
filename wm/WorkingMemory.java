package wm;

import abl.runtime.AblNamedPropertySupport;
import abl.runtime.BehaviorWME;
import abl.runtime.SucceedStepWME;
import abl.runtime.FailStepWME;
import abl.runtime.PrimitiveStepWME;
import abl.runtime.MentalStepWME;
import abl.runtime.WaitStepWME;
import abl.runtime.GoalStepWME;
import java.util.Collection;
import java.util.Enumeration;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.util.Vector;
import java.util.Arrays;
import java.util.ListIterator;
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;
import java.util.Hashtable;

public class WorkingMemory
{
    private static Hashtable workingMemoryRegistry;
    private static final Class goalStepWME;
    private static final Class primitiveStepWME;
    private static final Class mentalStepWME;
    private static final Class waitStepWME;
    private static final Class failStepWME;
    private static final Class succeedStepWME;
    private static final Class collectionBehaviorWME;
    private static final Class parallelBehaviorWME;
    private static final Class sequentialBehaviorWME;
    private static final Class stepWME;
    private static final Class behaviorWME;
    protected Hashtable memory;
    protected WorkingMemoryDebugger workingMemoryDebugger;
    private static final /* synthetic */ boolean $noassert;
    
    public static WorkingMemory lookupRegisteredMemory(final String s) {
        return WorkingMemory.workingMemoryRegistry.get(s);
    }
    
    public static String wmeShortName(final WME wme) {
        final String name = wme.getClass().getName();
        return name.substring(name.lastIndexOf(46) + 1);
    }
    
    public static String wmeShortName(final String s) {
        if (s.indexOf(46) != -1) {
            return s.substring(s.lastIndexOf(46) + 1);
        }
        return s;
    }
    
    public synchronized void addWME(final WME wme) {
        if (!WorkingMemory.$noassert && wme == null) {
            throw new AssertionError();
        }
        if (isReflectionWME(wme)) {
            this.addReflectionWME(wme);
        }
        else {
            try {
                if (Class.forName("wm.TimeStampedWME").isAssignableFrom(wme.getClass()) && ((TimeStampedWME)wme).getTimestamp() == 0L) {
                    ((TimeStampedWME)wme).setTimestamp(System.currentTimeMillis());
                }
            }
            catch (Exception ex) {
                throw new WmeReflectionError(ex);
            }
            final String wmeShortName = wmeShortName(wme);
            if (!this.memory.containsKey(wmeShortName)) {
                final LinkedList<WME> list = new LinkedList<WME>();
                list.add(wme);
                this.memory.put(wmeShortName, list);
            }
            else {
                ((LinkedList<WME>)this.memory.get(wmeShortName)).add(wme);
            }
        }
        if (this.workingMemoryDebugger != null) {
            this.workingMemoryDebugger.updateIfMonitoring();
        }
    }
    
    public synchronized void addWMEs(final List list) {
        if (!WorkingMemory.$noassert && list == null) {
            throw new AssertionError();
        }
        final Iterator<WME> iterator = list.iterator();
        while (iterator.hasNext()) {
            this.addWME(iterator.next());
        }
    }
    
    public static void addWME(final String s, final WME wme) {
        lookupRegisteredMemory(s).addWME(wme);
    }
    
    public static void addWMEs(final String s, final List list) {
        lookupRegisteredMemory(s).addWMEs(list);
    }
    
    public synchronized void modifyWME(final WME wme, final WME wme2) throws IncompatibleWmeClassException, NonexistentWmeException {
        if (!WorkingMemory.$noassert && isReflectionWME(wmeShortName(wme))) {
            throw new AssertionError();
        }
        if (!wmeShortName(wme).equals(wmeShortName(wme2))) {
            throw new IncompatibleWmeClassException();
        }
        final String wmeShortName = wmeShortName(wme);
        if (!this.memory.containsKey(wmeShortName)) {
            throw new NonexistentWmeException();
        }
        if (!((LinkedList)this.memory.get(wmeShortName)).contains(wme)) {
            throw new NonexistentWmeException();
        }
        wme.assign(wme2);
        if (this.workingMemoryDebugger != null) {
            this.workingMemoryDebugger.updateIfMonitoring();
        }
    }
    
    public static void modifyWME(final String s, final WME wme, final WME wme2) throws IncompatibleWmeClassException, NonexistentWmeException {
        lookupRegisteredMemory(s).modifyWME(wme, wme2);
    }
    
    public synchronized void deleteWME(final WME wme) {
        final String wmeShortName = wmeShortName(wme);
        if (isReflectionWME(wmeShortName)) {
            this.deleteReflectionWME(wme);
        }
        else if (this.memory.containsKey(wmeShortName)) {
            final LinkedList list = this.memory.get(wmeShortName);
            if (list.contains(wme)) {
                list.remove(wme);
            }
            if (list.size() == 0) {
                this.memory.remove(wmeShortName);
            }
        }
        if (this.workingMemoryDebugger != null) {
            this.workingMemoryDebugger.updateIfMonitoring();
        }
    }
    
    public static void deleteWME(final String s, final WME wme) {
        lookupRegisteredMemory(s).deleteWME(wme);
    }
    
    public synchronized void deleteAllWMEClass(final String s) {
        if (isReflectionWME(s)) {
            this.deleteAllReflectionWMEClass(s);
        }
        else if (this.memory.containsKey(s)) {
            final ListIterator listIterator = this.memory.get(s).listIterator();
            while (listIterator.hasNext()) {
                listIterator.next();
                listIterator.remove();
            }
        }
        if (this.workingMemoryDebugger != null) {
            this.workingMemoryDebugger.updateIfMonitoring();
        }
    }
    
    public static void deleteAllWMEClass(final String s, final String s2) {
        lookupRegisteredMemory(s).deleteAllWMEClass(s2);
    }
    
    protected synchronized void deleteReflectionWME(final WME wme) {
        if (!WorkingMemory.$noassert && !isReflectionWME(wme)) {
            throw new AssertionError();
        }
        final String wmeShortName = wmeShortName(wme);
        final ReflectionWMEEntry reflectionWMEEntry = this.memory.get(wmeShortName);
        if (!WorkingMemory.$noassert && reflectionWMEEntry == null) {
            throw new AssertionError((Object)wmeShortName);
        }
        reflectionWMEEntry.deleteWME(wme);
        if (reflectionWMEEntry.getWMEList().size() == 0) {
            this.memory.remove(wmeShortName);
        }
    }
    
    protected synchronized void deleteAllReflectionWMEClass(final String s) {
        if (!WorkingMemory.$noassert && this.memory.get(s) == null) {
            throw new AssertionError();
        }
        this.memory.remove(s);
    }
    
    public synchronized LinkedList lookupWME(final String s) {
        LinkedList wmeList;
        if (isReflectionWME(s)) {
            final ReflectionWMEEntry reflectionWMEEntry = this.memory.get(s);
            if (reflectionWMEEntry == null) {
                return new LinkedList();
            }
            wmeList = reflectionWMEEntry.getWMEList();
        }
        else {
            wmeList = this.memory.get(s);
        }
        if (wmeList == null) {
            return new LinkedList();
        }
        return (LinkedList)wmeList.clone();
    }
    
    public static LinkedList lookupWME(final String s, final String s2) {
        return lookupRegisteredMemory(s).lookupWME(s2);
    }
    
    public synchronized List lookupReflectionWMEBySignature(final String s, final String s2) {
        if (!WorkingMemory.$noassert && !s.equals("GoalStepWME") && !s.equals("SequentialBehaviorWME") && !s.equals("ParallelBehaviorWME") && !s.equals("CollectionBehaviorWME")) {
            throw new AssertionError();
        }
        final ReflectionWMEEntry reflectionWMEEntry = this.memory.get(s);
        if (reflectionWMEEntry == null) {
            return new LinkedList();
        }
        return (LinkedList)reflectionWMEEntry.lookupWMEBySignature(s2).clone();
    }
    
    public static List lookupReflectionWMEBySignature(final String s, final String s2, final String s3) {
        return lookupRegisteredMemory(s).lookupReflectionWMEBySignature(s2, s3);
    }
    
    public synchronized List lookupReflectionWMEByUserProperty(final String s, final String s2) {
        if (!WorkingMemory.$noassert && !isReflectionWME(s)) {
            throw new AssertionError();
        }
        final ReflectionWMEEntry reflectionWMEEntry = this.memory.get(s);
        if (reflectionWMEEntry == null) {
            return new LinkedList();
        }
        return (LinkedList)reflectionWMEEntry.lookupWMEByProperty(s2).clone();
    }
    
    public static List lookupReflectionWMEByUserProperty(final String s, final String s2, final String s3) {
        return lookupRegisteredMemory(s).lookupReflectionWMEByUserProperty(s2, s3);
    }
    
    protected synchronized void addReflectionWME(final WME wme) {
        if (!WorkingMemory.$noassert && !isReflectionWME(wme)) {
            throw new AssertionError();
        }
        final String wmeShortName = wmeShortName(wme);
        if (!this.memory.containsKey(wmeShortName)) {
            final ReflectionWMEEntry reflectionWMEEntry = new ReflectionWMEEntry();
            reflectionWMEEntry.addWME(wme);
            this.memory.put(wmeShortName, reflectionWMEEntry);
        }
        else {
            ((ReflectionWMEEntry)this.memory.get(wmeShortName)).addWME(wme);
        }
    }
    
    public static boolean isReflectionWME(final String s) {
        return s.equals("GoalStepWME") || s.equals("PrimitiveStepWME") || s.equals("MentalStepWME") || s.equals("WaitStepWME") || s.equals("FailStepWME") || s.equals("SucceedStepWME") || s.equals("CollectionBehaviorWME") || s.equals("ParallelBehaviorWME") || s.equals("SequentialBehaviorWME");
    }
    
    public static boolean isReflectionWME(final WME wme) {
        return isReflectionWME(wmeShortName(wme.getClass().getName()));
    }
    
    public static boolean isReflectionWME(final Class clazz) {
        return isReflectionWME(wmeShortName(clazz.getName()));
    }
    
    public synchronized WME findNext(final String s, final long n) {
        try {
            if (!WorkingMemory.$noassert && !Class.forName("wm.TimeStampedWME").isAssignableFrom(Class.forName(s))) {
                throw new AssertionError();
            }
        }
        catch (Exception ex) {
            throw new WmeReflectionError(ex);
        }
        final LinkedList lookupWME = this.lookupWME(wmeShortName(s));
        if (lookupWME.size() == 0) {
            return null;
        }
        final TimeStampedWME[] array = (TimeStampedWME[])lookupWME.toArray(new TimeStampedWME[lookupWME.size()]);
        Arrays.sort(array);
        for (int i = 0; i < array.length; ++i) {
            if (array[i].getTimestamp() > n) {
                return array[i];
            }
        }
        return null;
    }
    
    public synchronized WME findPrev(final String s, final long n) {
        try {
            if (!WorkingMemory.$noassert && !Class.forName("wm.TimeStampedWME").isAssignableFrom(Class.forName(s))) {
                throw new AssertionError();
            }
        }
        catch (Exception ex) {
            throw new WmeReflectionError(ex);
        }
        final LinkedList lookupWME = this.lookupWME(wmeShortName(s));
        if (lookupWME.size() == 0) {
            return null;
        }
        final TimeStampedWME[] array = (TimeStampedWME[])lookupWME.toArray(new TimeStampedWME[lookupWME.size()]);
        Arrays.sort(array);
        for (int i = array.length - 1; i >= 0; --i) {
            if (array[i].getTimestamp() < n) {
                return array[i];
            }
        }
        return null;
    }
    
    public synchronized WME findFirst(final String s) {
        try {
            if (!WorkingMemory.$noassert && !Class.forName("wm.TimeStampedWME").isAssignableFrom(Class.forName(s))) {
                throw new AssertionError();
            }
        }
        catch (Exception ex) {
            throw new WmeReflectionError(ex);
        }
        final LinkedList lookupWME = this.lookupWME(wmeShortName(s));
        if (lookupWME.size() == 0) {
            return null;
        }
        final TimeStampedWME[] array = (TimeStampedWME[])lookupWME.toArray(new TimeStampedWME[lookupWME.size()]);
        Arrays.sort(array);
        return array[0];
    }
    
    public synchronized WME findLast(final String s) {
        try {
            if (!WorkingMemory.$noassert && !Class.forName("wm.TimeStampedWME").isAssignableFrom(Class.forName(s))) {
                throw new AssertionError();
            }
        }
        catch (Exception ex) {
            throw new WmeReflectionError(ex);
        }
        final LinkedList lookupWME = this.lookupWME(wmeShortName(s));
        if (lookupWME.size() == 0) {
            return null;
        }
        final TimeStampedWME[] array = (TimeStampedWME[])lookupWME.toArray(new TimeStampedWME[lookupWME.size()]);
        Arrays.sort(array);
        return array[array.length - 1];
    }
    
    public synchronized List findAll(final String s, final long n, final long n2) {
        try {
            if (!WorkingMemory.$noassert && !Class.forName("wm.TimeStampedWME").isAssignableFrom(Class.forName(s))) {
                throw new AssertionError();
            }
        }
        catch (Exception ex) {
            throw new WmeReflectionError(ex);
        }
        final LinkedList lookupWME = this.lookupWME(wmeShortName(s));
        if (lookupWME.size() == 0) {
            return new Vector();
        }
        final TimeStampedWME[] array = (TimeStampedWME[])lookupWME.toArray(new TimeStampedWME[lookupWME.size()]);
        Arrays.sort(array);
        final Vector<TimeStampedWME> vector = new Vector<TimeStampedWME>();
        for (int i = 0; i < array.length; ++i) {
            if (array[i].getTimestamp() >= n && array[i].getTimestamp() <= n2) {
                vector.add(array[i]);
            }
            if (array[i].getTimestamp() > n2) {
                break;
            }
        }
        return vector;
    }
    
    public synchronized int countWMEBefore(final String s, final long n) {
        try {
            if (!WorkingMemory.$noassert && !Class.forName("wm.TimeStampedWME").isAssignableFrom(Class.forName(s))) {
                throw new AssertionError();
            }
        }
        catch (Exception ex) {
            throw new WmeReflectionError(ex);
        }
        final LinkedList lookupWME = this.lookupWME(wmeShortName(s));
        if (lookupWME.size() == 0) {
            return 0;
        }
        final TimeStampedWME[] array = (TimeStampedWME[])lookupWME.toArray(new TimeStampedWME[lookupWME.size()]);
        Arrays.sort(array);
        int n2 = 0;
        for (int i = 0; i < array.length; ++i) {
            if (array[i].getTimestamp() < n) {
                ++n2;
            }
            if (array[i].getTimestamp() >= n) {
                break;
            }
        }
        return n2;
    }
    
    public synchronized int countWMEAfter(final String s, final long n) {
        try {
            if (!WorkingMemory.$noassert && !Class.forName("wm.TimeStampedWME").isAssignableFrom(Class.forName(s))) {
                throw new AssertionError();
            }
        }
        catch (Exception ex) {
            throw new WmeReflectionError(ex);
        }
        final LinkedList lookupWME = this.lookupWME(wmeShortName(s));
        if (lookupWME.size() == 0) {
            return 0;
        }
        final TimeStampedWME[] array = (TimeStampedWME[])lookupWME.toArray(new TimeStampedWME[lookupWME.size()]);
        Arrays.sort(array);
        int n2 = 0;
        for (int i = array.length - 1; i >= 0; --i) {
            if (array[i].getTimestamp() > n) {
                ++n2;
            }
            if (array[i].getTimestamp() <= n) {
                break;
            }
        }
        return n2;
    }
    
    public synchronized int countWMEBetween(final String s, final long n, final long n2) {
        try {
            if (!WorkingMemory.$noassert && !Class.forName("wm.TimeStampedWME").isAssignableFrom(Class.forName(s))) {
                throw new AssertionError();
            }
        }
        catch (Exception ex) {
            throw new WmeReflectionError(ex);
        }
        final LinkedList lookupWME = this.lookupWME(wmeShortName(s));
        if (lookupWME.size() == 0) {
            return 0;
        }
        final TimeStampedWME[] array = (TimeStampedWME[])lookupWME.toArray(new TimeStampedWME[lookupWME.size()]);
        Arrays.sort(array);
        int n3 = 0;
        for (int i = 0; i < array.length; ++i) {
            if (array[i].getTimestamp() >= n && array[i].getTimestamp() <= n2) {
                ++n3;
            }
            if (array[i].getTimestamp() > n2) {
                break;
            }
        }
        return n3;
    }
    
    public synchronized DefaultTreeModel getWMTreeModel() {
        final Enumeration<String> keys = (Enumeration<String>)this.memory.keys();
        final DefaultTreeModel defaultTreeModel = new DefaultTreeModel(new DefaultMutableTreeNode("working memory root"));
        final DefaultMutableTreeNode defaultMutableTreeNode = (DefaultMutableTreeNode)defaultTreeModel.getRoot();
        while (keys.hasMoreElements()) {
            final String s = keys.nextElement();
            LinkedList<Object> wmeList;
            if (isReflectionWME(s)) {
                wmeList = (LinkedList<Object>)this.memory.get(s).getWMEList();
            }
            else {
                wmeList = this.memory.get(s);
            }
            if (!wmeList.isEmpty()) {
                final ListIterator<Object> listIterator = wmeList.listIterator();
                final WMTreeNode wmTreeNode = new WMTreeNode(s, true);
                defaultMutableTreeNode.add(wmTreeNode);
                while (listIterator.hasNext()) {
                    wmTreeNode.add(new WMTreeNode(listIterator.next(), false));
                }
            }
        }
        return defaultTreeModel;
    }
    
    public WorkingMemoryDebugger getWMDebugInterface() {
        return new WorkingMemoryDebugger(this);
    }
    
    void setWMDebugger(final WorkingMemoryDebugger workingMemoryDebugger) {
        if (!WorkingMemory.$noassert && this.workingMemoryDebugger != null) {
            throw new AssertionError();
        }
        this.workingMemoryDebugger = workingMemoryDebugger;
    }
    
    public synchronized void markTransientWMEs() {
        final Enumeration<String> keys = this.memory.keys();
        while (keys.hasMoreElements()) {
            final String s = keys.nextElement();
            if (!isReflectionWME(s)) {
                final List<WME> list = this.memory.get(s);
                if (list.isEmpty() || !((TransientWME)list.get(0)).isTransient()) {
                    continue;
                }
                final Iterator<TransientWME> iterator = list.iterator();
                while (iterator.hasNext()) {
                    iterator.next().mark();
                }
            }
        }
    }
    
    public synchronized void deleteMarkedTransientWMEs() {
        final Enumeration<String> keys = this.memory.keys();
        while (keys.hasMoreElements()) {
            final String s = keys.nextElement();
            if (!isReflectionWME(s)) {
                final Vector vector = new Vector<Object>(this.memory.get(s));
                if (vector.isEmpty() || !((TransientWME)vector.get(0)).isTransient()) {
                    continue;
                }
                for (final TransientWME transientWME : vector) {
                    if (transientWME.getMarked()) {
                        this.deleteWME(transientWME);
                    }
                }
            }
        }
    }
    
    private final /* synthetic */ void this() {
        this.memory = new Hashtable();
        this.workingMemoryDebugger = null;
    }
    
    public WorkingMemory() {
        this.this();
    }
    
    public WorkingMemory(final String s) {
        this.this();
        WorkingMemory.workingMemoryRegistry.put(s, this);
    }
    
    static {
        $noassert = (Class.forName("[Lwm.WorkingMemory;").getComponentType().desiredAssertionStatus() ^ true);
        WorkingMemory.workingMemoryRegistry = new Hashtable();
        try {
            goalStepWME = Class.forName("abl.runtime.GoalStepWME");
            primitiveStepWME = Class.forName("abl.runtime.PrimitiveStepWME");
            mentalStepWME = Class.forName("abl.runtime.MentalStepWME");
            waitStepWME = Class.forName("abl.runtime.WaitStepWME");
            failStepWME = Class.forName("abl.runtime.FailStepWME");
            succeedStepWME = Class.forName("abl.runtime.SucceedStepWME");
            collectionBehaviorWME = Class.forName("abl.runtime.CollectionBehaviorWME");
            parallelBehaviorWME = Class.forName("abl.runtime.ParallelBehaviorWME");
            sequentialBehaviorWME = Class.forName("abl.runtime.SequentialBehaviorWME");
            stepWME = Class.forName("abl.runtime.StepWME");
            behaviorWME = Class.forName("abl.runtime.BehaviorWME");
        }
        catch (ClassNotFoundException ex) {
            throw new WmeReflectionError(ex);
        }
    }
    
    protected class ReflectionWMEEntry
    {
        private final LinkedList wmeList;
        private final Hashtable signatureTable;
        private final Hashtable propertyTable;
        private static final /* synthetic */ boolean $noassert;
        
        public void addWME(final WME wme) {
            final String wmeShortName = WorkingMemory.wmeShortName(wme);
            if (wmeShortName.equals("GoalStepWME")) {
                this.addGoalStepWME((GoalStepWME)wme);
            }
            else if (wmeShortName.equals("WaitStepWME")) {
                this.addWaitStepWME((WaitStepWME)wme);
            }
            else if (wmeShortName.equals("MentalStepWME")) {
                this.addMentalStepWME((MentalStepWME)wme);
            }
            else if (wmeShortName.equals("PrimitiveStepWME")) {
                this.addPrimitiveStepWME((PrimitiveStepWME)wme);
            }
            else if (wmeShortName.equals("FailStepWME")) {
                this.addFailStepWME((FailStepWME)wme);
            }
            else if (wmeShortName.equals("SucceedStepWME")) {
                this.addSucceedStepWME((SucceedStepWME)wme);
            }
            else if (wmeShortName.equals("CollectionBehaviorWME") || wmeShortName.equals("ParallelBehaviorWME") || wmeShortName.equals("SequentialBehaviorWME")) {
                this.addBehaviorWME((BehaviorWME)wme);
            }
        }
        
        public void deleteWME(final WME wme) {
            final String wmeShortName = WorkingMemory.wmeShortName(wme);
            if (wmeShortName.equals("GoalStepWME")) {
                this.deleteGoalStepWME((GoalStepWME)wme);
            }
            else if (wmeShortName.equals("WaitStepWME")) {
                this.deleteWaitStepWME((WaitStepWME)wme);
            }
            else if (wmeShortName.equals("MentalStepWME")) {
                this.deleteMentalStepWME((MentalStepWME)wme);
            }
            else if (wmeShortName.equals("PrimitiveStepWME")) {
                this.deletePrimitiveStepWME((PrimitiveStepWME)wme);
            }
            else if (wmeShortName.equals("FailStepWME")) {
                this.deleteFailStepWME((FailStepWME)wme);
            }
            else if (wmeShortName.equals("SucceedStepWME")) {
                this.deleteSucceedStepWME((SucceedStepWME)wme);
            }
            else if (wmeShortName.equals("CollectionBehaviorWME") || wmeShortName.equals("ParallelBehaviorWME") || wmeShortName.equals("SequentialBehaviorWME")) {
                this.deleteBehaviorWME((BehaviorWME)wme);
            }
        }
        
        public void addGoalStepWME(final GoalStepWME goalStepWME) {
            this.wmeList.add(goalStepWME);
            this.indexBySignature(goalStepWME, goalStepWME.getSignature());
            this.indexByUserProperties(goalStepWME, goalStepWME.getAllDefinedProperties());
        }
        
        public void addWaitStepWME(final WaitStepWME waitStepWME) {
            this.wmeList.add(waitStepWME);
            this.indexByUserProperties(waitStepWME, waitStepWME.getAllDefinedProperties());
        }
        
        public void addMentalStepWME(final MentalStepWME mentalStepWME) {
            this.wmeList.add(mentalStepWME);
            this.indexByUserProperties(mentalStepWME, mentalStepWME.getAllDefinedProperties());
        }
        
        public void addPrimitiveStepWME(final PrimitiveStepWME primitiveStepWME) {
            this.wmeList.add(primitiveStepWME);
            this.indexByUserProperties(primitiveStepWME, primitiveStepWME.getAllDefinedProperties());
        }
        
        public void addFailStepWME(final FailStepWME failStepWME) {
            this.wmeList.add(failStepWME);
            this.indexByUserProperties(failStepWME, failStepWME.getAllDefinedProperties());
        }
        
        public void addSucceedStepWME(final SucceedStepWME succeedStepWME) {
            this.wmeList.add(succeedStepWME);
            this.indexByUserProperties(succeedStepWME, succeedStepWME.getAllDefinedProperties());
        }
        
        public void addBehaviorWME(final BehaviorWME behaviorWME) {
            this.wmeList.add(behaviorWME);
            this.indexBySignature(behaviorWME, behaviorWME.getSignature());
            this.indexByUserProperties(behaviorWME, behaviorWME.getAllDefinedProperties());
        }
        
        public void deleteGoalStepWME(final GoalStepWME goalStepWME) {
            this.wmeList.remove(goalStepWME);
            this.deleteFromSignatureTable(goalStepWME, goalStepWME.getSignature());
            this.deleteFromUserPropertiesTable(goalStepWME, goalStepWME.getAllDefinedProperties());
        }
        
        public void deleteWaitStepWME(final WaitStepWME waitStepWME) {
            this.wmeList.remove(waitStepWME);
            this.deleteFromUserPropertiesTable(waitStepWME, waitStepWME.getAllDefinedProperties());
        }
        
        public void deleteMentalStepWME(final MentalStepWME mentalStepWME) {
            this.wmeList.remove(mentalStepWME);
            this.deleteFromUserPropertiesTable(mentalStepWME, mentalStepWME.getAllDefinedProperties());
        }
        
        public void deletePrimitiveStepWME(final PrimitiveStepWME primitiveStepWME) {
            this.wmeList.remove(primitiveStepWME);
            this.deleteFromUserPropertiesTable(primitiveStepWME, primitiveStepWME.getAllDefinedProperties());
        }
        
        public void deleteFailStepWME(final FailStepWME failStepWME) {
            this.wmeList.remove(failStepWME);
            this.deleteFromUserPropertiesTable(failStepWME, failStepWME.getAllDefinedProperties());
        }
        
        public void deleteSucceedStepWME(final SucceedStepWME succeedStepWME) {
            this.wmeList.remove(succeedStepWME);
            this.deleteFromUserPropertiesTable(succeedStepWME, succeedStepWME.getAllDefinedProperties());
        }
        
        public void deleteBehaviorWME(final BehaviorWME behaviorWME) {
            this.wmeList.remove(behaviorWME);
            this.deleteFromSignatureTable(behaviorWME, behaviorWME.getSignature());
            this.deleteFromUserPropertiesTable(behaviorWME, behaviorWME.getAllDefinedProperties());
        }
        
        private final void indexBySignature(final WME wme, final String s) {
            final List<WME> list = this.signatureTable.get(s);
            if (list == null) {
                final LinkedList<WME> list2 = new LinkedList<WME>();
                list2.add(wme);
                this.signatureTable.put(s, list2);
            }
            else {
                list.add(wme);
            }
        }
        
        private final void indexByUserProperties(final WME wme, final List list) {
            final Iterator<AblNamedPropertySupport.UserProperty> iterator = list.iterator();
            while (iterator.hasNext()) {
                final String name = iterator.next().getName();
                final List<WME> list2 = this.propertyTable.get(name);
                if (list2 == null) {
                    final LinkedList<WME> list3 = new LinkedList<WME>();
                    list3.add(wme);
                    this.propertyTable.put(name, list3);
                }
                else {
                    list2.add(wme);
                }
            }
        }
        
        private final void deleteFromSignatureTable(final WME wme, final String s) {
            final List list = this.signatureTable.get(s);
            if (!ReflectionWMEEntry.$noassert && (list == null || list.size() <= 0 || !list.contains(wme))) {
                throw new AssertionError();
            }
            list.remove(wme);
            if (list.size() == 0) {
                this.signatureTable.remove(s);
            }
        }
        
        private final void deleteFromUserPropertiesTable(final WME wme, final List list) {
            final Iterator<AblNamedPropertySupport.UserProperty> iterator = list.iterator();
            while (iterator.hasNext()) {
                final List list2 = this.propertyTable.get(iterator.next().getName());
                if (!ReflectionWMEEntry.$noassert && (list2 == null || list2.size() <= 0 || !list2.contains(wme))) {
                    throw new AssertionError();
                }
                list2.remove(wme);
            }
        }
        
        public LinkedList lookupWMEBySignature(final String s) {
            LinkedList list = this.signatureTable.get(s);
            if (list == null) {
                list = new LinkedList();
            }
            return list;
        }
        
        public LinkedList lookupWMEByProperty(final String s) {
            LinkedList list = this.propertyTable.get(s);
            if (list == null) {
                list = new LinkedList();
            }
            return list;
        }
        
        public LinkedList getWMEList() {
            return this.wmeList;
        }
        
        private final /* synthetic */ void this() {
            this.wmeList = new LinkedList();
            this.signatureTable = new Hashtable();
            this.propertyTable = new Hashtable();
        }
        
        public ReflectionWMEEntry() {
            this.this();
        }
        
        static {
            $noassert = (Class.forName("[Lwm.WorkingMemory;").getComponentType().desiredAssertionStatus() ^ true);
        }
    }
    
    class WMTreeNode extends DefaultMutableTreeNode
    {
        private boolean isClassNode;
        
        boolean getIsClassNode() {
            return this.isClassNode;
        }
        
        private final /* synthetic */ void this() {
            this.isClassNode = false;
        }
        
        WMTreeNode(final Object o, final boolean isClassNode) {
            super(o);
            this.this();
            this.isClassNode = isClassNode;
        }
        
        WMTreeNode(final String s) {
            super(s);
            this.this();
        }
    }
}
