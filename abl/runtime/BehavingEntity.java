package abl.runtime;

import java.util.Collections;
import java.util.ListIterator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Arrays;
import java.util.Collection;
import java.util.Vector;
import javax.swing.tree.TreeNode;
import javax.swing.tree.DefaultTreeModel;
import wm.WorkingMemoryDebugger;
import java.util.LinkedList;
import wm.WME;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.HashSet;
import java.util.Set;
import wm.WorkingMemory;
import java.util.Hashtable;
import abl.compiler.AblDebuggerConstants;

public abstract class BehavingEntity implements AblDebuggerConstants
{
    public static final int suspendOnInstantiate = 0;
    public static final int suspendOnExecute = 1;
    protected static final InheritableThreadLocal entity;
    private static BehaviorSpecificityComparator behComparator;
    private static StepPriorityComparator stepPriorityComparator;
    private static StepExpansionComparator stepExpansionComparator;
    static Object[] tempObjArray;
    private static Hashtable entityTable;
    protected final WorkingMemory workingMemory;
    protected CollectionBehavior ABT;
    protected Set leafSteps;
    protected HashSet atomicSteps;
    protected HashSet executingPrimitiveSteps;
    protected HashSet successTestStepsNoSensing;
    protected HashSet contextConditionBehaviorsNoSensing;
    protected final HashSet successConditionBehaviorsNoSensing;
    protected HashSet successTestStepsSensing;
    protected HashSet contextConditionBehaviorsSensing;
    protected final HashSet successConditionBehaviorsSensing;
    protected Hashtable executingSteps;
    protected BehaviorLibrary individualBehaviorLibrary;
    protected BehaviorLibrary jointBehaviorLibrary;
    Random randomGen;
    protected boolean bCurrentLineOfExpansion;
    protected boolean bStepConflicts;
    protected byte debugLevel;
    protected Debugger debuggerGUI;
    protected boolean bDecisionCycleSMCall;
    protected boolean asynchronousSenseCycle;
    private Hashtable currentEntryNegotiators;
    private List activeNegotiationThreads;
    private Thread decisionCycleThread;
    private boolean negotiatorCommittedDuringNegotiation;
    private long continuousConditionTime;
    private ShutdownHook shutdownHook;
    private CollectionBehaviorWME rootCollectionBehaviorWME;
    SensedConditionMonitor senseMonitor;
    ActiveContinuousSensors activeSensors;
    private final ThreadGroup timeCheckThreads;
    private static final /* synthetic */ boolean $noassert;
    
    public String getBehavingEntityShortName() {
        final String name = this.getClass().getName();
        return name.substring(name.lastIndexOf(46) + 1);
    }
    
    public String toString() {
        return this.getBehavingEntityShortName();
    }
    
    CollectionBehavior getRootCollectionBehavior() {
        return this.ABT;
    }
    
    public static BehavingEntity getBehavingEntity() {
        return (BehavingEntity)BehavingEntity.entity.get();
    }
    
    protected static void registerEntity(final String p0, final BehavingEntity p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: aload_2        
        //     4: monitorexit    
        //     5: athrow         
        //     6: getstatic       abl/runtime/BehavingEntity.entityTable:Ljava/util/Hashtable;
        //     9: dup            
        //    10: astore_2       
        //    11: monitorenter   
        //    12: getstatic       abl/runtime/BehavingEntity.entityTable:Ljava/util/Hashtable;
        //    15: aload_0        
        //    16: aload_1        
        //    17: invokevirtual   java/util/Hashtable.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    20: pop            
        //    21: aload_2        
        //    22: monitorexit    
        //    23: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  3      5      3      6      Any
        //  12     23     3      6      Any
        // 
        // The error that occurred was:
        // 
        // java.util.ConcurrentModificationException
        //     at java.util.ArrayList$Itr.checkForComodification(Unknown Source)
        //     at java.util.ArrayList$Itr.next(Unknown Source)
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2863)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2445)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static BehavingEntity getBehavingEntity(final String p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: aload_1        
        //     4: monitorexit    
        //     5: athrow         
        //     6: getstatic       abl/runtime/BehavingEntity.entityTable:Ljava/util/Hashtable;
        //     9: dup            
        //    10: astore_1       
        //    11: monitorenter   
        //    12: getstatic       abl/runtime/BehavingEntity.entityTable:Ljava/util/Hashtable;
        //    15: aload_0        
        //    16: invokevirtual   java/util/Hashtable.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    19: checkcast       Labl/runtime/BehavingEntity;
        //    22: astore          4
        //    24: aload           4
        //    26: ifnonnull       53
        //    29: new             Labl/runtime/AblRuntimeError;
        //    32: dup            
        //    33: new             Ljava/lang/StringBuffer;
        //    36: dup            
        //    37: ldc             "No behaving entity found for entity name "
        //    39: invokespecial   java/lang/StringBuffer.<init>:(Ljava/lang/String;)V
        //    42: aload_0        
        //    43: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //    46: invokevirtual   java/lang/StringBuffer.toString:()Ljava/lang/String;
        //    49: invokespecial   abl/runtime/AblRuntimeError.<init>:(Ljava/lang/String;)V
        //    52: athrow         
        //    53: aload           4
        //    55: aload_1        
        //    56: monitorexit    
        //    57: areturn        
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  3      5      3      6      Any
        //  12     57     3      6      Any
        // 
        // The error that occurred was:
        // 
        // java.util.ConcurrentModificationException
        //     at java.util.ArrayList$Itr.checkForComodification(Unknown Source)
        //     at java.util.ArrayList$Itr.next(Unknown Source)
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2863)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2445)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    Thread getDecisionCycleThread() {
        return this.decisionCycleThread;
    }
    
    public void startBehaving() {
        this.decisionCycleThread = Thread.currentThread();
        if (this.asynchronousSenseCycle) {
            new SenseCycleThread().start();
        }
        this.shutdownHook = new ShutdownHook();
        Runtime.getRuntime().addShutdownHook(this.shutdownHook);
        while (true) {
            Thread.currentThread().setName("DecisionCycleThread");
            this.behave();
        }
    }
    
    public void behave() {
        this.shutdownHook.shutdownMessage = this.getBehavingEntityShortName() + " was running negotiation threads";
        this.runNegotiationThreads();
        if (this.bDecisionCycleSMCall) {
            this.shutdownHook.shutdownMessage = this.getBehavingEntityShortName() + " was in the decision cycle SM call";
            this.decisionCycleSMCall();
        }
        this.workingMemory.deleteMarkedTransientWMEs();
        this.shutdownHook.shutdownMessage = this.getBehavingEntityShortName() + " was checking for completed primitive actions";
        for (final PrimitiveStep primitiveStep : this.executingPrimitiveSteps) {
            if (primitiveStep.getCompletionStatus() == 1) {
                primitiveStep.succeedStep();
                return;
            }
            if (primitiveStep.getCompletionStatus() == 2) {
                primitiveStep.failStep();
                return;
            }
        }
        this.shutdownHook.shutdownMessage = this.getBehavingEntityShortName() + " was checking continuously monitored conditions";
        if (this.atomicSteps.isEmpty()) {
            if (!this.asynchronousSenseCycle) {
                this.activeSensors.sense();
                this.runSuccessTests(true);
                this.runContextConditions(true);
                this.runSuccessConditions(true);
                this.workingMemory.markTransientWMEs();
            }
            final long currentTimeMillis = System.currentTimeMillis();
            this.runSuccessTests(false);
            this.runContextConditions(false);
            this.runSuccessConditions(false);
            this.continuousConditionTime = System.currentTimeMillis() - currentTimeMillis;
            if (this.asynchronousSenseCycle && this.senseMonitor.sensedConditionsReadyToRun()) {
                this.runSuccessTests(true);
                this.runContextConditions(true);
                this.runSuccessConditions(true);
                this.workingMemory.markTransientWMEs();
            }
        }
        this.shutdownHook.shutdownMessage = this.getBehavingEntityShortName() + " was selecting a step";
        final Step chooseStep = this.chooseStep();
        if (this.debugLevel == 2) {
            this.debuggerGUI.debug(this.continuousConditionTime);
        }
        if (chooseStep != null) {
            this.shutdownHook.shutdownMessage = this.getBehavingEntityShortName() + " was executing step " + chooseStep + " of behavior " + chooseStep.getParent();
            chooseStep.execute();
        }
        else {
            try {
                this.shutdownHook.shutdownMessage = this.getBehavingEntityShortName() + " was waiting because there was no step to execute";
                Thread.currentThread();
                Thread.sleep(17L);
            }
            catch (InterruptedException ex) {
                throw new RuntimeError("Unexpected interruption");
            }
        }
    }
    
    void printNegotiationThreads() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     4: monitorexit    
        //     5: athrow         
        //     6: aload_0        
        //     7: getfield        abl/runtime/BehavingEntity.activeNegotiationThreads:Ljava/util/List;
        //    10: dup            
        //    11: astore_1       
        //    12: monitorenter   
        //    13: aload_0        
        //    14: getfield        abl/runtime/BehavingEntity.activeNegotiationThreads:Ljava/util/List;
        //    17: invokeinterface java/util/List.iterator:()Ljava/util/Iterator;
        //    22: astore_3       
        //    23: aload_3        
        //    24: invokeinterface java/util/Iterator.hasNext:()Z
        //    29: ifne            58
        //    32: getstatic       java/lang/System.err:Ljava/io/PrintStream;
        //    35: new             Ljava/lang/StringBuffer;
        //    38: dup            
        //    39: ldc_w           "No active negotiation threads in "
        //    42: invokespecial   java/lang/StringBuffer.<init>:(Ljava/lang/String;)V
        //    45: aload_0        
        //    46: invokevirtual   abl/runtime/BehavingEntity.getBehavingEntityShortName:()Ljava/lang/String;
        //    49: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //    52: invokevirtual   java/lang/StringBuffer.toString:()Ljava/lang/String;
        //    55: invokevirtual   java/io/PrintStream.println:(Ljava/lang/String;)V
        //    58: goto            73
        //    61: getstatic       java/lang/System.err:Ljava/io/PrintStream;
        //    64: aload_3        
        //    65: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    70: invokevirtual   java/io/PrintStream.println:(Ljava/lang/Object;)V
        //    73: aload_3        
        //    74: invokeinterface java/util/Iterator.hasNext:()Z
        //    79: ifne            61
        //    82: aload_1        
        //    83: monitorexit    
        //    84: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  3      5      3      6      Any
        //  13     84     3      6      Any
        // 
        // The error that occurred was:
        // 
        // java.util.ConcurrentModificationException
        //     at java.util.ArrayList$Itr.checkForComodification(Unknown Source)
        //     at java.util.ArrayList$Itr.next(Unknown Source)
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2863)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2445)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private final void runNegotiationThreads() {
        this.negotiatorCommittedDuringNegotiation = false;
        final JointGoalNegotiationThread[] array = this.activeNegotiationThreads.toArray(new JointGoalNegotiationThread[this.activeNegotiationThreads.size()]);
        for (int i = 0; i < array.length; ++i) {
            if (!array[i].getIsStarted()) {
                final TimeCheckThread timeCheckThread = new TimeCheckThread(array[i]);
                timeCheckThread.start();
                array[i].start();
                timeCheckThread.interrupt();
            }
            else if (!array[i].isAlive()) {
                this.activeNegotiationThreads.remove(array[i]);
            }
            else {
                final TimeCheckThread timeCheckThread2 = new TimeCheckThread(array[i]);
                timeCheckThread2.start();
                array[i].continueNegotiation();
                timeCheckThread2.interrupt();
            }
        }
        if (this.negotiatorCommittedDuringNegotiation) {
            this.runNegotiationThreads();
        }
    }
    
    void jointGoalNegotiatorCommitted() {
        try {
            final JointGoalNegotiationThread jointGoalNegotiationThread = (JointGoalNegotiationThread)Thread.currentThread();
        }
        catch (ClassCastException ex) {
            throw new AblRuntimeError("Non-negotiation thread " + Thread.currentThread() + " attempted jointGoalNegotiatorCommitted.");
        }
        this.negotiatorCommittedDuringNegotiation = true;
    }
    
    public WorkingMemory getWorkingMemory() {
        return this.workingMemory;
    }
    
    public void addWME(final WME wme) {
        this.workingMemory.addWME(wme);
    }
    
    public void deleteWME(final WME wme) {
        this.workingMemory.deleteWME(wme);
    }
    
    public void deleteAllWMEClass(final String s) {
        this.workingMemory.deleteAllWMEClass(s);
    }
    
    public LinkedList lookupWME(final String s) {
        return this.workingMemory.lookupWME(s);
    }
    
    public List lookupReflectionWMEBySignature(final String s, final String s2) {
        return this.workingMemory.lookupReflectionWMEBySignature(s, s2);
    }
    
    public List lookupReflectionWMEByUserProperty(final String s, final String s2) {
        return this.workingMemory.lookupReflectionWMEByUserProperty(s, s2);
    }
    
    public WorkingMemoryDebugger getWMDebugger() {
        return new WorkingMemoryDebugger(this.workingMemory);
    }
    
    void resetStep(final Step step) {
        this.executingPrimitiveSteps.remove(step);
        this.removeExecutingStep(step);
        if (step.getStepType() != 3) {
            if (step.getIsAtomic()) {
                this.atomicSteps.add(step);
            }
            else {
                this.leafSteps.add(step);
            }
        }
    }
    
    void abortStep(final PrimitiveStep primitiveStep) {
        this.executingPrimitiveSteps.remove(primitiveStep);
        this.removeExecutingStep(primitiveStep);
    }
    
    void suspendStep(final ExecutableStep executableStep) {
        boolean b;
        if (executableStep.getStepType() == 1) {
            b = (((GoalStep)executableStep).isExpanded() ^ true);
        }
        else {
            b = (executableStep.isExecuting() ^ true);
        }
        if (!b) {
            this.removeExecutingStep(executableStep);
            if (executableStep.getStepType() == 0) {
                this.executingPrimitiveSteps.remove(executableStep);
            }
        }
        else if (executableStep.getIsAtomic()) {
            this.atomicSteps.remove(executableStep);
        }
        else {
            this.leafSteps.remove(executableStep);
        }
    }
    
    void unsuspendStep(final ExecutableStep executableStep) {
        if (executableStep.getStepType() == 1 && ((GoalStep)executableStep).isExpanded()) {
            final HashSet<ExecutableStep> set = this.executingSteps.get(executableStep.getName());
            if (set != null) {
                set.add(executableStep);
            }
            else {
                final HashSet<ExecutableStep> set2 = new HashSet<ExecutableStep>();
                set2.add(executableStep);
                this.executingSteps.put(executableStep.getName(), set2);
            }
        }
        else if (executableStep.getIsAtomic()) {
            this.atomicSteps.add(executableStep);
        }
        else {
            this.leafSteps.add(executableStep);
        }
    }
    
    DefaultTreeModel getABTTreeModel() {
        return new DefaultTreeModel(((DebuggableBehavior)this.ABT).getTree());
    }
    
    void removeSuccessTest(final Step step) {
        if (step.getHasSuccessTest() && (this.successTestStepsSensing.contains(step) || this.successTestStepsNoSensing.contains(step))) {
            final SensorActivation[] successTestSensorActivations = step.getSuccessTestSensorActivations();
            if (successTestSensorActivations != null) {
                this.successTestStepsSensing.remove(step);
            }
            else {
                this.successTestStepsNoSensing.remove(step);
            }
            if (successTestSensorActivations != null) {
                this.activeSensors.deactivateSensors(successTestSensorActivations);
            }
        }
    }
    
    void removeStep(final Step step) {
        this.removeSuccessTest(step);
        this.executingPrimitiveSteps.remove(step);
        if (step.getIsAtomic()) {
            this.atomicSteps.remove(step);
        }
        else {
            this.leafSteps.remove(step);
        }
        this.removeExecutingStep(step);
    }
    
    void addStep(final Step step) {
        if (step.getStepType() != 3) {
            if (step.getIsAtomic()) {
                this.atomicSteps.add(step);
            }
            else {
                this.leafSteps.add(step);
            }
        }
        if (step.getHasSuccessTest()) {
            final SensorActivation[] successTestSensorActivations = step.getSuccessTestSensorActivations();
            if (successTestSensorActivations != null) {
                this.successTestStepsSensing.add(step);
            }
            else {
                this.successTestStepsNoSensing.add(step);
            }
            if (successTestSensorActivations != null) {
                this.activeSensors.activateSensors(successTestSensorActivations);
            }
        }
    }
    
    void removeExecutingStep(final Step step) {
        if (step.getStepType() == 0 || step.getStepType() == 1) {
            final HashSet set = this.executingSteps.get(((ExecutableStep)step).getName());
            if (set != null) {
                set.remove(step);
            }
        }
    }
    
    void executeStep(final Step step) {
        if (step.getIsAtomic()) {
            this.atomicSteps.remove(step);
        }
        else {
            this.leafSteps.remove(step);
        }
        final short stepType = step.getStepType();
        if (stepType == 0) {
            this.executingPrimitiveSteps.add(step);
        }
        if (stepType == 0 || stepType == 1) {
            final HashSet<Step> set = this.executingSteps.get(((ExecutableStep)step).getName());
            if (set != null) {
                set.add(step);
            }
            else {
                final HashSet<Step> set2 = new HashSet<Step>();
                set2.add(step);
                this.executingSteps.put(((ExecutableStep)step).getName(), set2);
            }
        }
    }
    
    void addBehavior(final Behavior behavior) {
        if (behavior.getHasContextCondition()) {
            final SensorActivation[] contextConditionSensorActivations = behavior.getContextConditionSensorActivations();
            if (contextConditionSensorActivations != null) {
                this.contextConditionBehaviorsSensing.add(behavior);
            }
            else {
                this.contextConditionBehaviorsNoSensing.add(behavior);
            }
            if (contextConditionSensorActivations != null) {
                this.activeSensors.activateSensors(contextConditionSensorActivations);
            }
        }
        if (behavior.getHasSuccessCondition()) {
            final SensorActivation[] successConditionSensorActivations = behavior.getSuccessConditionSensorActivations();
            if (successConditionSensorActivations != null) {
                this.successConditionBehaviorsSensing.add(behavior);
            }
            else {
                this.successConditionBehaviorsNoSensing.add(behavior);
            }
            if (successConditionSensorActivations != null) {
                this.activeSensors.activateSensors(successConditionSensorActivations);
            }
        }
    }
    
    void removeBehavior(final Behavior behavior) {
        if ((behavior.getHasContextCondition() || behavior.getHasSuccessCondition()) && !behavior.getBehaviorRemoved()) {
            final SensorActivation[] contextConditionSensorActivations = behavior.getContextConditionSensorActivations();
            if (contextConditionSensorActivations != null) {
                this.contextConditionBehaviorsSensing.remove(behavior);
            }
            else {
                this.contextConditionBehaviorsNoSensing.remove(behavior);
            }
            final SensorActivation[] successConditionSensorActivations = behavior.getSuccessConditionSensorActivations();
            if (successConditionSensorActivations != null) {
                this.successConditionBehaviorsSensing.remove(behavior);
            }
            else {
                this.successConditionBehaviorsNoSensing.remove(behavior);
            }
            behavior.setBehaviorRemoved();
            if (contextConditionSensorActivations != null) {
                this.activeSensors.deactivateSensors(contextConditionSensorActivations);
            }
            if (successConditionSensorActivations != null) {
                this.activeSensors.deactivateSensors(successConditionSensorActivations);
            }
        }
    }
    
    private final boolean runContextConditions(final boolean b) {
        Iterator<Behavior> iterator;
        if (b) {
            iterator = this.contextConditionBehaviorsSensing.iterator();
        }
        else {
            iterator = this.contextConditionBehaviorsNoSensing.iterator();
        }
        while (iterator.hasNext()) {
            final Behavior behavior = iterator.next();
            if (!behavior.contextCondition()) {
                behavior.failBehavior();
                this.runContextConditions(b);
                return true;
            }
        }
        return false;
    }
    
    private final boolean runSuccessConditions(final boolean b) {
        Iterator<Behavior> iterator;
        if (b) {
            iterator = this.successConditionBehaviorsSensing.iterator();
        }
        else {
            iterator = this.successConditionBehaviorsNoSensing.iterator();
        }
        while (iterator.hasNext()) {
            final Behavior behavior = iterator.next();
            if (behavior.successCondition()) {
                behavior.succeedBehavior();
                this.runSuccessConditions(b);
                return true;
            }
        }
        return false;
    }
    
    private final boolean runSuccessTests(final boolean b) {
        Iterator<Step> iterator;
        if (b) {
            iterator = this.successTestStepsSensing.iterator();
        }
        else {
            iterator = this.successTestStepsNoSensing.iterator();
        }
        while (iterator.hasNext()) {
            final Step step = iterator.next();
            if (step.successTest()) {
                step.succeedStep();
                this.runSuccessTests(b);
                return true;
            }
        }
        return false;
    }
    
    Behavior chooseIndividualBehavior(final Object[] array, final HashSet set, final GoalStep goalStep) {
        return this.chooseBehavior(array, set, goalStep, false, null);
    }
    
    Behavior chooseJointBehavior(final Object[] array, final Set set, final GoalStep goalStep) {
        return this.chooseBehavior(array, set, goalStep, true, null);
    }
    
    Behavior chooseJointBehavior(final Object[] array, final Set set, final GoalStep goalStep, final Set set2) {
        return this.chooseBehavior(array, set, goalStep, true, set2);
    }
    
    private final Behavior chooseBehavior(final Object[] array, final Set set, final GoalStep goalStep, final boolean b, final Set set2) {
        if (!BehavingEntity.$noassert && (b || set2 != null) && !b) {
            throw new AssertionError();
        }
        final String signature = goalStep.getSignature();
        List list;
        if (b) {
            list = this.jointBehaviorLibrary.lookupBehavior(signature);
            if (list.isEmpty()) {
                return null;
            }
            if (set2 != null) {
                final Iterator<__BehaviorDesc> iterator = list.iterator();
                while (iterator.hasNext()) {
                    final __BehaviorDesc _BehaviorDesc = iterator.next();
                    final HashSet set3 = new HashSet<BehavingEntity>(_BehaviorDesc.teamMembers.length * 2);
                    for (int i = 0; i < _BehaviorDesc.teamMembers.length; ++i) {
                        set3.add(getBehavingEntity(_BehaviorDesc.teamMembers[i]));
                    }
                    if (!set3.equals(set2)) {
                        iterator.remove();
                    }
                }
            }
        }
        else {
            list = this.individualBehaviorLibrary.lookupBehavior(signature);
            if (list == null) {
                return null;
            }
        }
        final Iterator<__BehaviorDesc> iterator2 = list.iterator();
        while (iterator2.hasNext()) {
            if (set.contains(new Integer(iterator2.next().behaviorID))) {
                iterator2.remove();
            }
        }
        if (list.isEmpty()) {
            return null;
        }
        final Vector vector = new Vector<SatisfiedBehavior>(100);
        final Iterator<__BehaviorDesc> iterator3 = list.iterator();
        final HashSet<Object> set4 = new HashSet<Object>();
        try {
            while (iterator3.hasNext()) {
                final __BehaviorDesc _BehaviorDesc2 = iterator3.next();
                if (_BehaviorDesc2.preconditionSensorFactory != null) {
                    final SensorActivation[] array2 = (SensorActivation[])_BehaviorDesc2.preconditionSensorFactory.invoke(null, new Integer(_BehaviorDesc2.behaviorID));
                    for (int j = 0; j < array2.length; ++j) {
                        set4.add(array2[j]);
                    }
                }
            }
        }
        catch (Exception ex) {
            throw new AblRuntimeError("Reflection error", ex);
        }
        if (!set4.isEmpty()) {
            this.runSensors(new Vector(set4), false);
        }
        final Iterator<__BehaviorDesc> iterator4 = list.iterator();
        try {
            while (iterator4.hasNext()) {
                final __BehaviorDesc _BehaviorDesc3 = iterator4.next();
                if (_BehaviorDesc3.precondition != null) {
                    final Object[] array3 = { new Integer(_BehaviorDesc3.behaviorID), array, new Hashtable(), this };
                    final Boolean b2 = (Boolean)_BehaviorDesc3.precondition.invoke(null, array3);
                    if (this.debugLevel == 2) {
                        this.debuggerGUI.traceAblExecutionEvent(1, _BehaviorDesc3, b2, ((DebuggableStep)goalStep).getNestLevel() + 1, _BehaviorDesc3.behaviorID);
                    }
                    if (!b2) {
                        continue;
                    }
                    vector.add(new SatisfiedBehavior(_BehaviorDesc3, (Hashtable)array3[2]));
                }
                else {
                    if (this.debugLevel == 2) {
                        this.debuggerGUI.traceAblExecutionEvent(1, _BehaviorDesc3, new Boolean(true), ((DebuggableStep)goalStep).getNestLevel() + 1, _BehaviorDesc3.behaviorID);
                    }
                    vector.add(new SatisfiedBehavior(_BehaviorDesc3, null));
                }
            }
            if (!vector.isEmpty()) {
                final SatisfiedBehavior[] array4 = vector.toArray(new SatisfiedBehavior[vector.size()]);
                Arrays.sort(array4, BehavingEntity.behComparator);
                final ArrayList list2 = new ArrayList<Object>(vector.size());
                list2.add(array4[0]);
                for (int k = 1; k < array4.length; ++k) {
                    if (BehavingEntity.behComparator.compare(array4[0], array4[k]) == 0) {
                        list2.add(array4[k]);
                    }
                }
                __BehaviorDesc _BehaviorDesc4;
                Hashtable hashtable;
                if (list2.size() == 1) {
                    _BehaviorDesc4 = list2.get(0).behDesc;
                    hashtable = list2.get(0).preconditionBoundVariables;
                }
                else {
                    if (list2.size() <= 1) {
                        throw new RuntimeError("Expected mostSpecificBeh >= 1, instead < 1");
                    }
                    final int nextInt = this.randomGen.nextInt(list2.size());
                    _BehaviorDesc4 = ((SatisfiedBehavior)list2.get(nextInt)).behDesc;
                    hashtable = ((SatisfiedBehavior)list2.get(nextInt)).preconditionBoundVariables;
                }
                Object[] array5;
                if (this.debugLevel == 2) {
                    array5 = new Object[] { new Integer(_BehaviorDesc4.behaviorID), array, hashtable, goalStep, _BehaviorDesc4.signature, _BehaviorDesc4 };
                }
                else {
                    array5 = new Object[] { new Integer(_BehaviorDesc4.behaviorID), array, hashtable, goalStep, _BehaviorDesc4.signature };
                }
                return (Behavior)_BehaviorDesc4.factory.invoke(null, array5);
            }
            return null;
        }
        catch (Exception ex2) {
            ex2.printStackTrace();
            throw new RuntimeError("Reflection error in chooseBehavior()");
        }
    }
    
    private final Step chooseStep() {
        if (this.leafSteps.isEmpty() && this.atomicSteps.isEmpty()) {
            return null;
        }
        ArrayList list;
        if (!this.atomicSteps.isEmpty()) {
            list = new ArrayList<Step>(this.atomicSteps);
        }
        else {
            list = new ArrayList<Step>(this.leafSteps);
        }
        if (this.bStepConflicts) {
            final ListIterator<Step> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                if (listIterator.next().isSuspended()) {
                    listIterator.remove();
                }
            }
        }
        final ListIterator<Step> listIterator2 = list.listIterator();
        while (listIterator2.hasNext()) {
            final Step step = listIterator2.next();
            if (step.getStepType() == 1 && ((JointGoalStep)step).isJointGoal() && ((JointGoalStep)step).getIsNegotiating()) {
                listIterator2.remove();
            }
        }
        if (list.size() <= 0) {
            return null;
        }
        final Step[] array = list.toArray(new Step[list.size()]);
        Arrays.sort(array, BehavingEntity.stepPriorityComparator);
        list.clear();
        list.add(array[0]);
        for (int n = 1; n < array.length && BehavingEntity.stepPriorityComparator.compare(array[0], array[n]) == 0; ++n) {
            list.add(array[n]);
        }
        if (this.bCurrentLineOfExpansion && list.size() > 1) {
            final Step[] array2 = list.toArray(new Step[list.size()]);
            Arrays.sort(array2, BehavingEntity.stepExpansionComparator);
            list.clear();
            list.add(array2[0]);
            for (int i = 1; i < array2.length; ++i) {
                if (BehavingEntity.stepExpansionComparator.compare(array2[0], array2[i]) != 0) {
                    break;
                }
                list.add(array2[i]);
            }
        }
        if (!BehavingEntity.$noassert && list.size() < 1) {
            throw new AssertionError();
        }
        if (list.size() > 1) {
            return list.get(this.randomGen.nextInt(list.size()));
        }
        return list.get(0);
    }
    
    void findConflictsWithCurrentlyExecutingSteps(final ExecutableStep executableStep, final int n) {
        if (!BehavingEntity.$noassert && n != 0 && n != 1) {
            throw new AssertionError();
        }
        final String[] conflicts = executableStep.getConflicts();
        for (int i = 0; i < conflicts.length; ++i) {
            final HashSet<ExecutableStep> set = this.executingSteps.get(conflicts[i]);
            if (set != null) {
                for (final ExecutableStep executableStep2 : set) {
                    switch (n) {
                        case 1: {
                            if (executableStep2.getPriority() < executableStep.getPriority()) {
                                executableStep2.suspend(executableStep);
                                continue;
                            }
                            executableStep.suspend(executableStep2);
                            continue;
                        }
                        default: {
                            continue;
                        }
                        case 0: {
                            if (executableStep2.getPriority() < executableStep.getPriority()) {
                                continue;
                            }
                            executableStep.suspend(executableStep2);
                            continue;
                        }
                    }
                }
            }
        }
    }
    
    void runSensors(final List list, final boolean b) {
        final Iterator<SensorActivation> iterator = list.iterator();
        final LinkedList<SensorThread> list2 = new LinkedList<SensorThread>();
        while (iterator.hasNext()) {
            final SensorActivation sensorActivation = iterator.next();
            final Sensor activeSensor = sensorActivation.activeSensor;
            final Object[] arguments = sensorActivation.arguments;
            if (activeSensor.canBeParallel()) {
                final SensorThread sensorThread = new SensorThread(activeSensor, arguments, b);
                sensorThread.setPriority(5);
                list2.add(sensorThread);
                sensorThread.start();
            }
            else if (b) {
                activeSensor.senseContinuous(arguments);
            }
            else {
                activeSensor.senseOneShot(arguments);
            }
        }
        if (list2.size() != 0) {
            final ListIterator<Object> listIterator = list2.listIterator();
            while (listIterator.hasNext()) {
                try {
                    listIterator.next().join();
                }
                catch (InterruptedException ex) {
                    throw new AblRuntimeError("Sensor thread interrupted");
                }
            }
        }
    }
    
    protected void decisionCycleSMCall() {
    }
    
    public void breakNextDecisionCycle() {
        if (this.debugLevel == 2) {
            this.debuggerGUI.breakNextDecisionCycle();
        }
    }
    
    public void breakNow() {
        if (this.debugLevel == 2) {
            this.debuggerGUI.breakNextDecisionCycle();
            this.debuggerGUI.debug(0L);
        }
    }
    
    public void setTraceToScreen(final boolean traceToScreen) {
        if (this.debugLevel == 2) {
            this.debuggerGUI.setTraceToScreen(traceToScreen);
        }
    }
    
    public void setTraceToBuffer(final boolean traceToBuffer) {
        if (this.debugLevel == 2) {
            this.debuggerGUI.setTraceToBuffer(traceToBuffer);
        }
    }
    
    protected void startWMEReflection(final CollectionBehavior collectionBehavior) {
        final CollectionBehaviorWME rootCollectionBehaviorWME = new CollectionBehaviorWME(collectionBehavior, null);
        this.addWME(rootCollectionBehaviorWME);
        this.rootCollectionBehaviorWME = rootCollectionBehaviorWME;
    }
    
    boolean reflectionEnabled() {
        return this.rootCollectionBehaviorWME != null;
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
    
    Set getRegisteredIndividualBehaviors() {
        return this.individualBehaviorLibrary.getRegisteredBehaviors();
    }
    
    Set getRegisteredJointBehaviors() {
        return this.jointBehaviorLibrary.getRegisteredBehaviors();
    }
    
    Set getRegisteredBehaviors() {
        final HashSet set = new HashSet(this.individualBehaviorLibrary.getRegisteredBehaviors());
        set.addAll(this.jointBehaviorLibrary.getRegisteredBehaviors());
        return set;
    }
    
    void traceBehaviorSignature(final String s) {
        final List lookupBehavior = this.individualBehaviorLibrary.lookupBehavior(s);
        lookupBehavior.addAll(this.jointBehaviorLibrary.lookupBehavior(s));
        final Iterator<__BehaviorDesc> iterator = lookupBehavior.iterator();
        while (iterator.hasNext()) {
            this.debuggerGUI.traceBehavior(iterator.next().behaviorID);
        }
    }
    
    void untraceBehaviorSignature(final String s) {
        final List lookupBehavior = this.individualBehaviorLibrary.lookupBehavior(s);
        lookupBehavior.addAll(this.jointBehaviorLibrary.lookupBehavior(s));
        final Iterator<__BehaviorDesc> iterator = lookupBehavior.iterator();
        while (iterator.hasNext()) {
            this.debuggerGUI.untraceBehavior(iterator.next().behaviorID);
        }
    }
    
    void registerNegotiationThread(final JointGoalNegotiationThread jointGoalNegotiationThread) {
        if (!BehavingEntity.$noassert && jointGoalNegotiationThread == null) {
            throw new AssertionError();
        }
        this.activeNegotiationThreads.add(jointGoalNegotiationThread);
    }
    
    void unregisterNegotiationThread(final JointGoalNegotiationThread jointGoalNegotiationThread) {
        if (!BehavingEntity.$noassert && jointGoalNegotiationThread == null) {
            throw new AssertionError();
        }
        this.activeNegotiationThreads.remove(jointGoalNegotiationThread);
    }
    
    Hashtable negotiateEntry(final JointGoalStep p0, final Object[] p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     6: astore_3       
        //     7: goto            14
        //    10: aload           5
        //    12: monitorexit    
        //    13: athrow         
        //    14: aload_0        
        //    15: getfield        abl/runtime/BehavingEntity.currentEntryNegotiators:Ljava/util/Hashtable;
        //    18: dup            
        //    19: astore          5
        //    21: monitorenter   
        //    22: aload_1        
        //    23: getfield        abl/runtime/JointGoalStep.negotiator:Labl/runtime/JointGoalNegotiator;
        //    26: invokevirtual   abl/runtime/JointGoalNegotiator.getUniqueEntryNegotiationID:()Ljava/lang/Long;
        //    29: astore          4
        //    31: aload_0        
        //    32: getfield        abl/runtime/BehavingEntity.currentEntryNegotiators:Ljava/util/Hashtable;
        //    35: aload           4
        //    37: aload_1        
        //    38: invokevirtual   java/util/Hashtable.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    41: pop            
        //    42: aload           5
        //    44: monitorexit    
        //    45: aload_1        
        //    46: getfield        abl/runtime/JointGoalStep.negotiator:Labl/runtime/JointGoalNegotiator;
        //    49: aload_2        
        //    50: aload_1        
        //    51: invokevirtual   abl/runtime/JointGoalNegotiator.negotiateEntry:([Ljava/lang/Object;Labl/runtime/JointGoalStep;)Ljava/util/Hashtable;
        //    54: astore          8
        //    56: goto            63
        //    59: aload           5
        //    61: monitorexit    
        //    62: athrow         
        //    63: aload_0        
        //    64: getfield        abl/runtime/BehavingEntity.currentEntryNegotiators:Ljava/util/Hashtable;
        //    67: dup            
        //    68: astore          5
        //    70: monitorenter   
        //    71: aload_0        
        //    72: getfield        abl/runtime/BehavingEntity.currentEntryNegotiators:Ljava/util/Hashtable;
        //    75: aload           4
        //    77: invokevirtual   java/util/Hashtable.remove:(Ljava/lang/Object;)Ljava/lang/Object;
        //    80: pop            
        //    81: aload           5
        //    83: monitorexit    
        //    84: aload           8
        //    86: areturn        
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  10     13     10     14     Any
        //  22     45     10     14     Any
        //  59     62     59     63     Any
        //  71     84     59     63     Any
        // 
        // The error that occurred was:
        // 
        // java.util.ConcurrentModificationException
        //     at java.util.ArrayList$Itr.checkForComodification(Unknown Source)
        //     at java.util.ArrayList$Itr.next(Unknown Source)
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2863)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2445)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public void queueIntentionToEnter(final Long p0, final BehavingEntity p1, final Object[] p2, final boolean p3, final Set p4, final JointGoalStep p5) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: aload           8
        //     5: monitorexit    
        //     6: athrow         
        //     7: aload_0        
        //     8: getfield        abl/runtime/BehavingEntity.currentEntryNegotiators:Ljava/util/Hashtable;
        //    11: dup            
        //    12: astore          8
        //    14: monitorenter   
        //    15: aload_0        
        //    16: getfield        abl/runtime/BehavingEntity.currentEntryNegotiators:Ljava/util/Hashtable;
        //    19: aload_1        
        //    20: invokevirtual   java/util/Hashtable.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    23: checkcast       Labl/runtime/JointGoalStep;
        //    26: astore          7
        //    28: aload           7
        //    30: ifnonnull       94
        //    33: aload_0        
        //    34: getfield        abl/runtime/BehavingEntity.debugLevel:B
        //    37: ifne            63
        //    40: aload_0        
        //    41: aload_0        
        //    42: invokevirtual   abl/runtime/BehavingEntity.getRootCollectionBehavior:()Labl/runtime/CollectionBehavior;
        //    45: aload           6
        //    47: invokevirtual   abl/runtime/JointGoalStep.getSignature:()Ljava/lang/String;
        //    50: aload           5
        //    52: aload_3        
        //    53: iload           4
        //    55: invokespecial   abl/runtime/BehavingEntity.getInitiatedJointGoalStep:(Labl/runtime/CollectionBehavior;Ljava/lang/String;Ljava/util/Set;[Ljava/lang/Object;Z)Labl/runtime/InitiatedJointGoalStep;
        //    58: astore          7
        //    60: goto            83
        //    63: aload_0        
        //    64: aload_0        
        //    65: invokevirtual   abl/runtime/BehavingEntity.getRootCollectionBehavior:()Labl/runtime/CollectionBehavior;
        //    68: aload           6
        //    70: invokevirtual   abl/runtime/JointGoalStep.getSignature:()Ljava/lang/String;
        //    73: aload           5
        //    75: aload_3        
        //    76: iload           4
        //    78: invokespecial   abl/runtime/BehavingEntity.getInitiatedJointGoalStepDebug:(Labl/runtime/CollectionBehavior;Ljava/lang/String;Ljava/util/Set;[Ljava/lang/Object;Z)Labl/runtime/InitiatedJointGoalStep;
        //    81: astore          7
        //    83: aload_0        
        //    84: getfield        abl/runtime/BehavingEntity.currentEntryNegotiators:Ljava/util/Hashtable;
        //    87: aload_1        
        //    88: aload           7
        //    90: invokevirtual   java/util/Hashtable.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    93: pop            
        //    94: aload           8
        //    96: monitorexit    
        //    97: aload           7
        //    99: astore          10
        //   101: new             Labl/runtime/BehavingEntity$5;
        //   104: dup            
        //   105: aload_0        
        //   106: aload           10
        //   108: getfield        abl/runtime/JointGoalStep.negotiator:Labl/runtime/JointGoalNegotiator;
        //   111: new             Ljava/lang/StringBuffer;
        //   114: dup            
        //   115: invokespecial   java/lang/StringBuffer.<init>:()V
        //   118: aload           10
        //   120: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/Object;)Ljava/lang/StringBuffer;
        //   123: ldc_w           " queueIntentionToEnter"
        //   126: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   129: invokevirtual   java/lang/StringBuffer.toString:()Ljava/lang/String;
        //   132: aload_1        
        //   133: aload_2        
        //   134: aload_3        
        //   135: iload           4
        //   137: aload           5
        //   139: aload           6
        //   141: aload           10
        //   143: invokespecial   abl/runtime/BehavingEntity$5.<init>:(Labl/runtime/BehavingEntity;Labl/runtime/JointGoalNegotiator;Ljava/lang/String;Ljava/lang/Long;Labl/runtime/BehavingEntity;[Ljava/lang/Object;ZLjava/util/Set;Labl/runtime/JointGoalStep;Labl/runtime/JointGoalStep;)V
        //   146: astore          11
        //   148: aload_0        
        //   149: aload           11
        //   151: invokevirtual   abl/runtime/BehavingEntity.registerNegotiationThread:(Labl/runtime/JointGoalNegotiationThread;)V
        //   154: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  3      6      3      7      Any
        //  15     97     3      7      Any
        // 
        // The error that occurred was:
        // 
        // java.util.ConcurrentModificationException
        //     at java.util.ArrayList$Itr.checkForComodification(Unknown Source)
        //     at java.util.ArrayList$Itr.next(Unknown Source)
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2863)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2445)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public void queueIntentionToRefuseEntry(final Long p0, final BehavingEntity p1, final Set p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: aload           5
        //     5: monitorexit    
        //     6: athrow         
        //     7: aload_0        
        //     8: getfield        abl/runtime/BehavingEntity.currentEntryNegotiators:Ljava/util/Hashtable;
        //    11: dup            
        //    12: astore          5
        //    14: monitorenter   
        //    15: aload_0        
        //    16: getfield        abl/runtime/BehavingEntity.currentEntryNegotiators:Ljava/util/Hashtable;
        //    19: aload_1        
        //    20: invokevirtual   java/util/Hashtable.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    23: checkcast       Labl/runtime/JointGoalStep;
        //    26: astore          4
        //    28: aload           4
        //    30: ifnonnull       86
        //    33: aload_0        
        //    34: getfield        abl/runtime/BehavingEntity.debugLevel:B
        //    37: ifne            59
        //    40: aload_0        
        //    41: aload_0        
        //    42: invokevirtual   abl/runtime/BehavingEntity.getRootCollectionBehavior:()Labl/runtime/CollectionBehavior;
        //    45: ldc_w           "_RefuseEntryDummy()"
        //    48: aload_3        
        //    49: aconst_null    
        //    50: iconst_0       
        //    51: invokespecial   abl/runtime/BehavingEntity.getInitiatedJointGoalStep:(Labl/runtime/CollectionBehavior;Ljava/lang/String;Ljava/util/Set;[Ljava/lang/Object;Z)Labl/runtime/InitiatedJointGoalStep;
        //    54: astore          4
        //    56: goto            75
        //    59: aload_0        
        //    60: aload_0        
        //    61: invokevirtual   abl/runtime/BehavingEntity.getRootCollectionBehavior:()Labl/runtime/CollectionBehavior;
        //    64: ldc_w           "_RefuseEntryDummy()"
        //    67: aload_3        
        //    68: aconst_null    
        //    69: iconst_0       
        //    70: invokespecial   abl/runtime/BehavingEntity.getInitiatedJointGoalStepDebug:(Labl/runtime/CollectionBehavior;Ljava/lang/String;Ljava/util/Set;[Ljava/lang/Object;Z)Labl/runtime/InitiatedJointGoalStep;
        //    73: astore          4
        //    75: aload_0        
        //    76: getfield        abl/runtime/BehavingEntity.currentEntryNegotiators:Ljava/util/Hashtable;
        //    79: aload_1        
        //    80: aload           4
        //    82: invokevirtual   java/util/Hashtable.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    85: pop            
        //    86: aload           5
        //    88: monitorexit    
        //    89: aload           4
        //    91: astore          7
        //    93: new             Labl/runtime/BehavingEntity$6;
        //    96: dup            
        //    97: aload_0        
        //    98: aload           7
        //   100: getfield        abl/runtime/JointGoalStep.negotiator:Labl/runtime/JointGoalNegotiator;
        //   103: new             Ljava/lang/StringBuffer;
        //   106: dup            
        //   107: invokespecial   java/lang/StringBuffer.<init>:()V
        //   110: aload           7
        //   112: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/Object;)Ljava/lang/StringBuffer;
        //   115: ldc_w           " queueIntentionToRefuseEntry"
        //   118: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   121: invokevirtual   java/lang/StringBuffer.toString:()Ljava/lang/String;
        //   124: aload_1        
        //   125: aload_2        
        //   126: aload           7
        //   128: invokespecial   abl/runtime/BehavingEntity$6.<init>:(Labl/runtime/BehavingEntity;Labl/runtime/JointGoalNegotiator;Ljava/lang/String;Ljava/lang/Long;Labl/runtime/BehavingEntity;Labl/runtime/JointGoalStep;)V
        //   131: astore          8
        //   133: aload_0        
        //   134: aload           8
        //   136: invokevirtual   abl/runtime/BehavingEntity.registerNegotiationThread:(Labl/runtime/JointGoalNegotiationThread;)V
        //   139: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  3      6      3      7      Any
        //  15     89     3      7      Any
        // 
        // The error that occurred was:
        // 
        // java.util.ConcurrentModificationException
        //     at java.util.ArrayList$Itr.checkForComodification(Unknown Source)
        //     at java.util.ArrayList$Itr.next(Unknown Source)
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2863)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2445)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public void terminateEntryNegotiation(final Long p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: aload_2        
        //     4: monitorexit    
        //     5: athrow         
        //     6: aload_0        
        //     7: getfield        abl/runtime/BehavingEntity.currentEntryNegotiators:Ljava/util/Hashtable;
        //    10: dup            
        //    11: astore_2       
        //    12: monitorenter   
        //    13: getstatic       abl/runtime/BehavingEntity.$noassert:Z
        //    16: ifne            38
        //    19: aload_0        
        //    20: getfield        abl/runtime/BehavingEntity.currentEntryNegotiators:Ljava/util/Hashtable;
        //    23: aload_1        
        //    24: invokevirtual   java/util/Hashtable.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    27: ifnonnull       38
        //    30: new             Ljava/lang/AssertionError;
        //    33: dup            
        //    34: invokespecial   java/lang/AssertionError.<init>:()V
        //    37: athrow         
        //    38: aload_0        
        //    39: getfield        abl/runtime/BehavingEntity.currentEntryNegotiators:Ljava/util/Hashtable;
        //    42: aload_1        
        //    43: invokevirtual   java/util/Hashtable.remove:(Ljava/lang/Object;)Ljava/lang/Object;
        //    46: pop            
        //    47: aload_2        
        //    48: monitorexit    
        //    49: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  3      5      3      6      Any
        //  13     49     3      6      Any
        // 
        // The error that occurred was:
        // 
        // java.util.ConcurrentModificationException
        //     at java.util.ArrayList$Itr.checkForComodification(Unknown Source)
        //     at java.util.ArrayList$Itr.next(Unknown Source)
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2863)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2445)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public void queueIntentionToExit(final BehavingEntity behavingEntity, final JointGoalStep jointGoalStep, final int n) {
        this.registerNegotiationThread(new JointGoalNegotiationThread(jointGoalStep.negotiator, jointGoalStep + " queueIntentionToExit(" + JointGoalNegotiator.formatIntention(n) + ')') {
            public final void run() {
                if (jointGoalStep.negotiator != null) {
                    BehavingEntity.entity.set(BehavingEntity.this);
                    switch (n) {
                        case 19: {
                            jointGoalStep.negotiator.processIntentionToSucceed(behavingEntity);
                            break;
                        }
                        case 20: {
                            jointGoalStep.negotiator.processIntentionToFail(behavingEntity);
                            break;
                        }
                        case 21: {
                            jointGoalStep.negotiator.processIntentionToRemove(behavingEntity);
                            break;
                        }
                        case 22: {
                            jointGoalStep.negotiator.processIntentionToSuspend(behavingEntity);
                            break;
                        }
                        case 23: {
                            jointGoalStep.negotiator.processIntentionToUnsuspend(behavingEntity);
                            break;
                        }
                        default: {
                            throw new AblRuntimeError("Unexpected intention");
                        }
                    }
                }
            }
        });
    }
    
    private final InitiatedJointGoalStep getInitiatedJointGoalStep(final CollectionBehavior collectionBehavior, final String s, final Set set, final Object[] array, final boolean b) {
        return new InitiatedJointGoalStep(collectionBehavior, s, set, array, b);
    }
    
    private final InitiatedJointGoalStep getInitiatedJointGoalStepDebug(final CollectionBehavior collectionBehavior, final String s, final Set set, final Object[] array, final boolean b) {
        return new InitiatedJointGoalStepDebug(collectionBehavior, s, set, array, b, this.debugLevel);
    }
    
    void traceAblExecutionEvent(final int n, final Step step, final Object o, final int n2, final int n3) {
        this.debuggerGUI.traceAblExecutionEvent(n, step, o, n2, n3);
    }
    
    void traceAblExecutionEvent(final int n, final __BehaviorDesc _BehaviorDesc, final Object o, final int n2, final int n3) {
        this.debuggerGUI.traceAblExecutionEvent(n, _BehaviorDesc, o, n2, n3);
    }
    
    void printLeafSteps() {
        final Iterator<Object> iterator = this.leafSteps.iterator();
        System.err.println("Leaf steps for " + this.getBehavingEntityShortName());
        while (iterator.hasNext()) {
            System.err.println("    " + iterator.next());
        }
    }
    
    void printExecutingSteps() {
        final Iterator<Object> iterator = this.executingSteps.keySet().iterator();
        System.err.println("Executing steps for " + this.getBehavingEntityShortName());
        while (iterator.hasNext()) {
            System.err.println("    " + iterator.next());
        }
    }
    
    void printAtomicSteps() {
        final Iterator<Object> iterator = this.atomicSteps.iterator();
        System.err.println("Atomic steps for " + this.getBehavingEntityShortName());
        while (iterator.hasNext()) {
            System.err.println("    " + iterator.next());
        }
    }
    
    static final void printABTBranchUpwards(Step parent) {
        while (parent != null) {
            System.err.println(parent);
            final Behavior parent2 = parent.getParent();
            System.err.println(parent2);
            parent = parent2.getParent();
        }
    }
    
    static final void printABTBranchUpwards(Behavior parent) {
        if (parent != null) {
            System.err.println(parent);
            for (GoalStep goalStep = parent.getParent(); goalStep != null; goalStep = parent.getParent()) {
                System.err.println(goalStep);
                parent = goalStep.getParent();
                System.err.println(parent);
            }
        }
    }
    
    private final /* synthetic */ void this() {
        this.leafSteps = Collections.synchronizedSet(new HashSet<Object>());
        this.atomicSteps = new HashSet();
        this.executingPrimitiveSteps = new HashSet();
        this.successTestStepsNoSensing = new HashSet();
        this.contextConditionBehaviorsNoSensing = new HashSet();
        this.successConditionBehaviorsNoSensing = new HashSet();
        this.successTestStepsSensing = new HashSet();
        this.contextConditionBehaviorsSensing = new HashSet();
        this.successConditionBehaviorsSensing = new HashSet();
        this.executingSteps = new Hashtable();
        this.randomGen = new Random();
        this.bCurrentLineOfExpansion = true;
        this.bStepConflicts = true;
        this.debugLevel = 0;
        this.debuggerGUI = null;
        this.bDecisionCycleSMCall = false;
        this.asynchronousSenseCycle = true;
        this.currentEntryNegotiators = new Hashtable();
        this.activeNegotiationThreads = Collections.synchronizedList(new LinkedList<Object>());
        this.decisionCycleThread = null;
        this.negotiatorCommittedDuringNegotiation = false;
        this.continuousConditionTime = 0L;
        this.rootCollectionBehaviorWME = null;
        this.senseMonitor = new SensedConditionMonitor();
        this.activeSensors = new ActiveContinuousSensors();
        this.timeCheckThreads = new ThreadGroup("TimeCheckThreads");
    }
    
    public BehavingEntity() {
        this.this();
        BehavingEntity.entity.set(this);
        final String name = this.getClass().getName();
        this.workingMemory = new WorkingMemory(name.substring(name.lastIndexOf(46) + 1) + "Memory");
    }
    
    static {
        $noassert = (Class.forName("[Labl.runtime.BehavingEntity;").getComponentType().desiredAssertionStatus() ^ true);
        entity = new InheritableThreadLocal();
        BehavingEntity.behComparator = new BehaviorSpecificityComparator();
        BehavingEntity.stepPriorityComparator = new StepPriorityComparator();
        BehavingEntity.stepExpansionComparator = new StepExpansionComparator();
        BehavingEntity.tempObjArray = new Object[1];
        BehavingEntity.entityTable = new Hashtable();
    }
    
    protected class BehaviorLibrary
    {
        Hashtable behaviorNames;
        Hashtable behaviors;
        
        public synchronized void registerBehavior(final __BehaviorDesc _BehaviorDesc) {
            final List<__BehaviorDesc> list = this.behaviors.get(_BehaviorDesc.signature);
            if (list == null) {
                final Vector<__BehaviorDesc> vector = new Vector<__BehaviorDesc>();
                vector.add(_BehaviorDesc);
                if (BehavingEntity.this.debugLevel == 2) {
                    _BehaviorDesc.uniqueName = _BehaviorDesc.signature.substring(0, _BehaviorDesc.signature.indexOf(40)) + "_1";
                }
                this.behaviors.put(_BehaviorDesc.signature, vector);
            }
            else {
                list.add(_BehaviorDesc);
                if (BehavingEntity.this.debugLevel == 2) {
                    _BehaviorDesc.uniqueName = _BehaviorDesc.signature.substring(0, _BehaviorDesc.signature.indexOf(40)) + '_' + list.size();
                }
            }
        }
        
        public synchronized List lookupBehavior(final String s) {
            final List list = this.behaviors.get(s);
            if (list == null) {
                return new Vector(0);
            }
            return new ArrayList(list);
        }
        
        private final synchronized Set getRegisteredBehaviors() {
            return new HashSet(this.behaviors.keySet());
        }
        
        public BehaviorLibrary(final int n) {
            this.behaviors = new Hashtable(n);
        }
    }
    
    private class SensedConditionMonitor
    {
        private boolean ready;
        
        synchronized boolean sensedConditionsReadyToRun() {
            final boolean ready = this.ready;
            this.ready = false;
            return ready;
        }
        
        synchronized void setSensedConditionsReadyToRun(final boolean ready) {
            this.ready = ready;
        }
        
        private final /* synthetic */ void this() {
            this.ready = false;
        }
        
        private SensedConditionMonitor() {
            this.this();
        }
    }
    
    private class ActiveContinuousSensors
    {
        private LinkedList activeSensors;
        
        synchronized void activateSensor(final SensorActivation sensorActivation) {
            final ListIterator listIterator = this.activeSensors.listIterator();
            while (listIterator.hasNext()) {
                final SensorActivation sensorActivation2 = listIterator.next();
                if (sensorActivation.equals(sensorActivation2)) {
                    final SensorActivation sensorActivation3 = sensorActivation2;
                    ++sensorActivation3.referenceCount;
                    return;
                }
            }
            this.activeSensors.add(sensorActivation);
            sensorActivation.activeSensor.initializeContinuous(sensorActivation.arguments);
            this.notify();
        }
        
        synchronized void activateSensors(final SensorActivation[] array) {
            if (array != null) {
                for (int i = 0; i < array.length; ++i) {
                    this.activateSensor(array[i]);
                }
            }
        }
        
        synchronized void deactivateSensor(final SensorActivation sensorActivation) {
            final ListIterator listIterator = this.activeSensors.listIterator();
            while (listIterator.hasNext()) {
                final SensorActivation sensorActivation2 = listIterator.next();
                if (sensorActivation.equals(sensorActivation2)) {
                    if (sensorActivation2.referenceCount == 1) {
                        listIterator.remove();
                    }
                    else {
                        final SensorActivation sensorActivation3 = sensorActivation2;
                        --sensorActivation3.referenceCount;
                    }
                }
            }
        }
        
        synchronized void deactivateSensors(final SensorActivation[] array) {
            if (array != null) {
                for (int i = 0; i < array.length; ++i) {
                    this.deactivateSensor(array[i]);
                }
            }
        }
        
        synchronized void sense() {
            if (!this.activeSensors.isEmpty()) {
                BehavingEntity.this.runSensors(this.activeSensors, true);
                BehavingEntity.this.senseMonitor.setSensedConditionsReadyToRun(true);
            }
            else {
                try {
                    this.wait();
                }
                catch (InterruptedException ex) {
                    throw new RuntimeError("Sense cycle interrupted");
                }
            }
        }
        
        private final /* synthetic */ void this() {
            this.activeSensors = new LinkedList();
        }
        
        private ActiveContinuousSensors() {
            this.this();
        }
    }
    
    class ShutdownHook extends Thread
    {
        public String shutdownMessage;
        
        public void run() {
            System.err.println(this.shutdownMessage);
            BehavingEntity.this.printNegotiationThreads();
            System.err.flush();
        }
    }
    
    class SenseCycleThread extends Thread
    {
        public void run() {
            while (true) {
                BehavingEntity.this.activeSensors.sense();
            }
        }
    }
    
    class TimeCheckThread extends Thread
    {
        JointGoalNegotiationThread monitoredThread;
        
        public void run() {
            try {
                Thread.sleep(1000L);
                System.err.println("WARNING: a negotiation thread took longer than a second to execute. The thread was interrupted.");
                this.monitoredThread.interrupt();
            }
            catch (InterruptedException ex) {}
        }
        
        TimeCheckThread(final JointGoalNegotiationThread monitoredThread) {
            super(BehavingEntity.this.timeCheckThreads, null, "tct");
            this.monitoredThread = monitoredThread;
        }
    }
    
    class SensorThread extends Thread
    {
        Sensor s;
        Object[] args;
        boolean isContinuous;
        
        public void run() {
            if (this.isContinuous) {
                this.s.senseContinuous(this.args);
            }
            else {
                this.s.senseOneShot(this.args);
            }
        }
        
        SensorThread(final Sensor s, final Object[] args, final boolean isContinuous) {
            this.s = s;
            this.args = args;
            this.isContinuous = isContinuous;
        }
    }
}
