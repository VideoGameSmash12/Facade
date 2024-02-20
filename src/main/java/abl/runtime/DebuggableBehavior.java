package abl.runtime;

interface DebuggableBehavior extends DebuggableABTNode
{
    void traceAblExecutionEvent(final int p0, final Step p1, final Object p2, final int p3);
}
