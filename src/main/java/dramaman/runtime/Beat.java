package dramaman.runtime;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import scope.VariableScope;
import java.util.Hashtable;

public class Beat
{
    private static final Class beatTests;
    private static final Class beatActions;
    private static final Class[] argTypes;
    private int beatID;
    private String beatName;
    private StoryEffect[] effects;
    private Hashtable initialValues;
    private float staticWeight;
    private int staticPriority;
    private String[] preconditionNames;
    private PriorityTest[] priorityTests;
    private WeightTest[] weightTests;
    private float probability;
    private VariableScope beatScope;
    private String initBeatMethodName;
    private String selectBeatMethodName;
    private String succeedBeatMethodName;
    private String abortBeatMethodName;
    private int priority;
    private static final /* synthetic */ boolean $noassert;
    
    public int getBeatID() {
        return this.beatID;
    }
    
    public String getBeatName() {
        return this.beatName;
    }
    
    public StoryEffect[] getEffects() {
        return this.effects;
    }
    
    public float getStaticWeight() {
        return this.staticWeight;
    }
    
    public float getStaticPriority() {
        return (float)this.staticPriority;
    }
    
    public float getProbability() {
        return this.probability;
    }
    
    public void setProbability(final float probability) {
        this.probability = probability;
    }
    
    public float score(final Hashtable hashtable, final int n) {
        if (hashtable.size() != this.effects.length) {
            return 0.0f;
        }
        final Hashtable hashtable2 = new Hashtable(hashtable);
        for (int i = 0; i < this.effects.length; ++i) {
            hashtable2.remove(this.effects[i].getValueName());
        }
        if (hashtable2.size() != 0) {
            return 0.0f;
        }
        float n2 = 0.0f;
        for (int j = 0; j < this.effects.length; ++j) {
            final StoryTarget storyTarget = (StoryTarget)hashtable.get(this.effects[j].getValueName());
            final float storyValue = StoryMemory.getStoryMemory().getStoryValue(this.effects[j].getValueWMEName());
            float valueChange;
            if (this.effects[j].getIsAbsolute()) {
                valueChange = this.effects[j].getValueChange() - storyValue;
            }
            else {
                valueChange = this.effects[j].getValueChange();
            }
            n2 += (float)(1.0 / Math.exp(Math.abs(2.0f * (storyTarget.getDesiredSlope(n, storyValue) - valueChange))));
        }
        return n2 / hashtable.size();
    }
    
    public float rawProbability(final Hashtable hashtable, final int n) {
        final float n2 = this.score(hashtable, n) * 3;
        float n3 = 0.0f;
        try {
            for (int i = 0; i < this.weightTests.length; ++i) {
                if (this.weightTests[i].test(this.beatScope)) {
                    n3 = this.weightTests[i].getWeight();
                    break;
                }
            }
        }
        catch (Exception ex) {
            throw new DramaManagerError(ex);
        }
        if (this.staticWeight > n3) {
            n3 = this.staticWeight;
        }
        return n2 * n3;
    }
    
    boolean precondition() {
        if (this.preconditionNames == null) {
            throw new DramaManagerError("No precondition specified for beat " + this.beatName);
        }
        try {
            for (int i = 0; i < this.preconditionNames.length; ++i) {
                if (Beat.beatTests.getMethod(this.preconditionNames[i], (Class[])Beat.argTypes).invoke(null, this.beatScope)) {
                    return true;
                }
            }
        }
        catch (Exception ex) {
            throw new DramaManagerError(ex);
        }
        return false;
    }
    
    int getPriority() {
        if (!Beat.$noassert && this.priority == Integer.MIN_VALUE) {
            throw new AssertionError();
        }
        return this.priority;
    }
    
    void setPriority() {
        int priority = Integer.MIN_VALUE;
        try {
            for (int i = 0; i < this.priorityTests.length; ++i) {
                if (this.priorityTests[i].test(this.beatScope)) {
                    priority = this.priorityTests[i].getPriority();
                    break;
                }
            }
        }
        catch (Exception ex) {
            throw new DramaManagerError(ex);
        }
        if (this.staticPriority > priority) {
            priority = this.staticPriority;
        }
        this.priority = priority;
    }
    
    protected void applyValueChanges() {
        for (int i = 0; i < this.effects.length; ++i) {
            final StoryEffect storyEffect = this.effects[i];
            if (storyEffect.getIsAbsolute()) {
                DramaManager.getStoryMemory().setStoryValue(storyEffect.getValueWMEName(), storyEffect.getValueChange());
            }
            else {
                StoryMemory.getStoryMemory().setStoryValue(storyEffect.getValueWMEName(), StoryMemory.getStoryMemory().getStoryValue(storyEffect.getValueWMEName()) + storyEffect.getValueChange());
            }
        }
    }
    
    void init() {
        try {
            if (this.initBeatMethodName != null) {
                Beat.beatActions.getMethod(this.initBeatMethodName, (Class[])Beat.argTypes).invoke(null, this.beatScope);
            }
        }
        catch (Exception ex) {
            throw new DramaManagerError(ex);
        }
    }
    
    void select() {
        try {
            if (this.selectBeatMethodName != null) {
                Beat.beatActions.getMethod(this.selectBeatMethodName, (Class[])Beat.argTypes).invoke(null, this.beatScope);
            }
        }
        catch (Exception ex) {
            throw new DramaManagerError(ex);
        }
    }
    
    void succeed() {
        if (DramaManager.getDramaManager().isManualTestMode()) {
            this.applyValueChanges();
        }
        try {
            if (this.succeedBeatMethodName != null) {
                Beat.beatActions.getMethod(this.succeedBeatMethodName, (Class[])Beat.argTypes).invoke(null, this.beatScope);
            }
        }
        catch (Exception ex) {
            throw new DramaManagerError(ex);
        }
    }
    
    void abort() {
        try {
            if (this.abortBeatMethodName != null) {
                Beat.beatActions.getMethod(this.abortBeatMethodName, (Class[])Beat.argTypes).invoke(null, this.beatScope);
            }
        }
        catch (Exception ex) {
            throw new DramaManagerError(ex);
        }
    }
    
    private final /* synthetic */ void this() {
        this.initBeatMethodName = null;
        this.selectBeatMethodName = null;
        this.succeedBeatMethodName = null;
        this.abortBeatMethodName = null;
        this.priority = Integer.MIN_VALUE;
    }
    
    public Beat(final int beatID, final String beatName, final StoryEffect[] effects, final float staticWeight, final int staticPriority, final String[] preconditionNames, final WeightTest[] weightTests, final PriorityTest[] priorityTests, final VariableScope beatScope, final String initBeatMethodName, final String selectBeatMethodName, final String succeedBeatMethodName, final String abortBeatMethodName) {
        this.this();
        this.beatID = beatID;
        this.beatName = beatName;
        this.effects = effects;
        this.staticWeight = staticWeight;
        this.staticPriority = staticPriority;
        this.preconditionNames = preconditionNames;
        Arrays.sort(weightTests);
        this.weightTests = weightTests;
        Arrays.sort(priorityTests);
        this.priorityTests = priorityTests;
        this.beatScope = beatScope;
        this.initBeatMethodName = initBeatMethodName;
        this.selectBeatMethodName = selectBeatMethodName;
        this.succeedBeatMethodName = succeedBeatMethodName;
        this.abortBeatMethodName = abortBeatMethodName;
    }
    
    static {
        $noassert = (Class.forName("[Ldramaman.runtime.Beat;").getComponentType().desiredAssertionStatus() ^ true);
        argTypes = new Class[1];
        try {
            beatTests = Class.forName(DramaManager.getDramaManager().getBeatPackage() + ".BeatTests");
            beatActions = Class.forName(DramaManager.getDramaManager().getBeatPackage() + ".BeatActions");
            Beat.argTypes[0] = Class.forName("scope.VariableScope");
        }
        catch (ClassNotFoundException ex) {
            throw new DramaManagerError(ex);
        }
    }
    
    public static class PriorityTest implements Comparable
    {
        private String priorityTestName;
        private int priority;
        Method priorityTest;
        
        public String getPriorityTestName() {
            return new String(this.priorityTestName);
        }
        
        public int getPriority() {
            return this.priority;
        }
        
        public boolean test(final VariableScope variableScope) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
            if (this.priorityTest == null) {
                this.priorityTest = Beat.beatTests.getMethod(this.priorityTestName, (Class[])Beat.argTypes);
            }
            return (boolean)this.priorityTest.invoke(null, variableScope);
        }
        
        public int compareTo(final Object o) {
            return -new Integer(this.priority).compareTo(new Integer(((PriorityTest)o).getPriority()));
        }
        
        public String toString() {
            return "PriorityTest(priorityTestName: " + this.priorityTestName + ", priority: " + this.priority + ')';
        }
        
        private final /* synthetic */ void this() {
            this.priorityTest = null;
        }
        
        public PriorityTest(final String priorityTestName, final int priority) {
            this.this();
            this.priorityTestName = priorityTestName;
            this.priority = priority;
        }
    }
    
    public static class WeightTest implements Comparable
    {
        private String weightTestName;
        private float weight;
        Method weightTest;
        
        public String getWeightTestName() {
            return new String(this.weightTestName);
        }
        
        public float getWeight() {
            return this.weight;
        }
        
        public boolean test(final VariableScope variableScope) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
            if (this.weightTest == null) {
                this.weightTest = Beat.beatTests.getMethod(this.weightTestName, (Class[])Beat.argTypes);
            }
            return (boolean)this.weightTest.invoke(null, variableScope);
        }
        
        public int compareTo(final Object o) {
            return -new Float(this.weight).compareTo(new Float(((WeightTest)o).getWeight()));
        }
        
        public String toString() {
            return "WeightTest(weightTestName: " + this.weightTestName + ", weight: " + this.weight + ')';
        }
        
        private final /* synthetic */ void this() {
            this.weightTest = null;
        }
        
        public WeightTest(final String weightTestName, final float weight) {
            this.this();
            this.weightTestName = weightTestName;
            this.weight = weight;
        }
    }
}
