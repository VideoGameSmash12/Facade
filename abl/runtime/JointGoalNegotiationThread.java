package abl.runtime;

import java.io.OutputStream;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

abstract class JointGoalNegotiationThread extends Thread
{
    private boolean isWaiting;
    private boolean isStarted;
    private final JointGoalNegotiator negotiator;
    final String descriptorString;
    private final String stackTrace;
    private final int originalPriority;
    private final JointGoalStep negotiatingStep;
    private static final /* synthetic */ boolean $noassert;
    
    public synchronized boolean getIsWaiting() {
        return this.isWaiting;
    }
    
    private final synchronized void setIsWaiting(final boolean isWaiting) {
        this.isWaiting = isWaiting;
    }
    
    public synchronized boolean getIsStarted() {
        return this.isStarted;
    }
    
    private final synchronized void setIsStarted(final boolean isStarted) {
        this.isStarted = isStarted;
    }
    
    public void start() {
        if (!JointGoalNegotiationThread.$noassert && Thread.currentThread() != BehavingEntity.getBehavingEntity().getDecisionCycleThread()) {
            throw new AssertionError();
        }
        this.setIsStarted(true);
        this.setIsWaiting(false);
        Thread.currentThread().setPriority(10);
        super.start();
        this.waitForNegotiation();
    }
    
    synchronized void waitForDecisionCycle() {
        if (!JointGoalNegotiationThread.$noassert && this.isWaiting) {
            throw new AssertionError();
        }
        Thread.currentThread().getPriority();
        this.isWaiting = true;
        Thread.currentThread().setPriority(10);
        this.notify();
        try {
            this.wait();
            yield();
            Thread.currentThread().setPriority(this.originalPriority);
        }
        catch (InterruptedException ex) {
            System.out.println(this);
            throw new AblRuntimeError(ex);
        }
    }
    
    synchronized void continueNegotiation() {
        if (!JointGoalNegotiationThread.$noassert && this == Thread.currentThread()) {
            throw new AssertionError();
        }
        if (this.isWaiting) {
            Thread.currentThread().setPriority(10);
            this.notify();
            this.isWaiting = false;
            try {
                this.wait();
                yield();
                Thread.currentThread().setPriority(this.originalPriority);
            }
            catch (InterruptedException ex) {
                System.out.println(this);
                throw new AblRuntimeError(ex);
            }
        }
    }
    
    private final synchronized void waitForNegotiation() {
        if (!JointGoalNegotiationThread.$noassert && this == Thread.currentThread()) {
            throw new AssertionError();
        }
        try {
            this.wait();
            yield();
            Thread.currentThread().setPriority(this.originalPriority);
        }
        catch (InterruptedException ex) {
            System.out.println(this);
            throw new AblRuntimeError(ex);
        }
    }
    
    public String toString() {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        final PrintStream printStream = new PrintStream(byteArrayOutputStream);
        printStream.println("JointGoalNegotiationThread: " + this.descriptorString);
        printStream.println("Thread is alive: " + this.isAlive());
        printStream.println("Current execution state:");
        if (this.negotiator != null) {
            this.negotiator.printNegotiationHistory(printStream);
        }
        else if (this.negotiatingStep != null && this.negotiatingStep.negotiator != null) {
            this.negotiatingStep.negotiator.printNegotiationHistory(printStream);
        }
        else {
            printStream.println("No negotiation history");
        }
        printStream.println("Stacktrace indicates negotiation initiator - NOT AN ERROR");
        printStream.println(this.stackTrace);
        return byteArrayOutputStream.toString();
    }
    
    String shortToString() {
        return "JointGoalNegotiationThread: " + this.descriptorString;
    }
    
    private final /* synthetic */ void this() {
        this.isWaiting = true;
        this.isStarted = false;
    }
    
    JointGoalNegotiationThread(final JointGoalNegotiator negotiator, final String descriptorString) {
        this.this();
        this.descriptorString = descriptorString;
        this.negotiator = negotiator;
        this.negotiatingStep = null;
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new Throwable().printStackTrace(new PrintStream(byteArrayOutputStream));
        this.stackTrace = byteArrayOutputStream.toString();
        this.originalPriority = Thread.currentThread().getPriority();
    }
    
    JointGoalNegotiationThread(final JointGoalStep negotiatingStep, final String descriptorString) {
        this.this();
        this.descriptorString = descriptorString;
        this.negotiatingStep = negotiatingStep;
        this.negotiator = null;
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new Throwable().printStackTrace(new PrintStream(byteArrayOutputStream));
        this.stackTrace = byteArrayOutputStream.toString();
        this.originalPriority = Thread.currentThread().getPriority();
    }
    
    static {
        $noassert = (Class.forName("[Labl.runtime.JointGoalNegotiationThread;").getComponentType().desiredAssertionStatus() ^ true);
    }
}
