package abl.runtime;

import java.lang.reflect.Method;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import abl.compiler.AblDebuggerConstants;

public class MentalStepDebug extends MentalStep implements DebuggableStep, AblDebuggerConstants
{
    private final byte debugLevel;
    private final String uniqueStepName;
    
    final void execute() {
        if (this.debugLevel == 2) {
            ((DebuggableBehavior)this.parent).traceAblExecutionEvent(9, this, null, this.getNestLevel());
        }
        final Thread thread = new Thread() {
            public final void run() {
                try {
                    Thread.sleep(1000L);
                    System.err.println("WARNING: a mental act in behavior " + MentalStepDebug.this.parent + " took longer than a second to complete. Mental acts that take a long time to execute block the decision cycle.");
                }
                catch (InterruptedException ex) {}
            }
        };
        thread.start();
        super.execute();
        thread.interrupt();
    }
    
    final void succeedStep() {
        if (this.debugLevel == 2) {
            ((DebuggableBehavior)this.parent).traceAblExecutionEvent(10, this, new Boolean(true), this.getNestLevel());
        }
        super.succeedStep();
    }
    
    final void failStep() {
        if (this.debugLevel == 2) {
            ((DebuggableBehavior)this.parent).traceAblExecutionEvent(10, this, new Boolean(false), this.getNestLevel());
        }
        super.failStep();
    }
    
    final boolean successTest() {
        final boolean successTest = super.successTest();
        if (successTest && this.debugLevel == 2) {
            ((DebuggableBehavior)this.parent).traceAblExecutionEvent(18, this, null, this.getNestLevel());
        }
        return successTest;
    }
    
    public final MutableTreeNode getTree() {
        return new DefaultMutableTreeNode(this);
    }
    
    public final int getNestLevel() {
        return ((DebuggableBehavior)this.parent).getNestLevel() + 1;
    }
    
    public final String toString() {
        return "mental " + this.uniqueStepName;
    }
    
    public MentalStepDebug(final int n, final Behavior behavior, final boolean b, final boolean b2, final boolean b3, final boolean b4, final boolean b5, final boolean b6, final short n2, final short n3, final boolean b7, final String s, final Method method, final Method method2, final Method method3, final AblNamedPropertySupport ablNamedPropertySupport, final byte debugLevel, final String uniqueStepName) {
        super(n, behavior, b, b2, b3, b4, b5, b6, n2, n3, b7, s, method, method2, method3, ablNamedPropertySupport);
        this.debugLevel = debugLevel;
        this.uniqueStepName = uniqueStepName;
    }
}
