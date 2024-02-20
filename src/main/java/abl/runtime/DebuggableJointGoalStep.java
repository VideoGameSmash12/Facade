package abl.runtime;

interface DebuggableJointGoalStep extends DebuggableStep
{
    void traceAblNegotiationEvent(final int p0, final JointGoalNegotiatorDebug.JointGoalNegotiationInfo p1);
}
