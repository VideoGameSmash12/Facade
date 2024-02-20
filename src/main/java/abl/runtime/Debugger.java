package abl.runtime;

import java.awt.Rectangle;
import javax.swing.Scrollable;
import java.awt.GraphicsEnvironment;
import java.util.Arrays;
import javax.swing.JDialog;
import java.util.Comparator;
import javax.swing.SwingUtilities;
import java.util.Hashtable;
import java.awt.Color;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.Box;
import java.util.Iterator;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.Dimension;
import javax.swing.JSplitPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.awt.LayoutManager;
import java.awt.Container;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.UIManager;
import java.util.Collection;
import java.util.LinkedList;
import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ListIterator;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreeModel;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.util.Set;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JTree;
import wm.WorkingMemoryDebugger;
import java.util.HashSet;

public class Debugger
{
    private static final String DECISION_CYCLE_TEXT = "Decisions per second";
    private static final String CONDITION_TIME_TEXT = "Continuous condition time/100 cycles";
    private static final int minimumViewWidth = 200;
    private static final int preferredViewWidth = 500;
    private static final int minimumViewHeight = 100;
    private static final int preferredViewHeight = 200;
    private static final int minimumTopPaneWidth = 400;
    private static final int preferredTopPaneWidth = 1000;
    private static final int minimumTopPaneHeight = 200;
    private static final int preferredTopPaneHeight = 400;
    private static final int minimumMainSplitPaneWidth = 200;
    private static final int preferredMainSplitPaneWidth = 500;
    private static final int minimumMainSplitPaneHeight = 300;
    private static final int preferredMainSplitPaneHeight = 600;
    private static final int minimumButtonPaneWidth = 200;
    private static final int preferredButtonPaneWidth = 500;
    private static final int buttonPaneHeight = 90;
    private static final HashSet debuggedBehaviors;
    private BehavingEntity entity;
    private WorkingMemoryDebugger wmPanel;
    private JTree ABTTree;
    protected JTextArea traceArea;
    protected JScrollBar traceViewScroller;
    protected JScrollPane traceView;
    private boolean bBreakDecisionCycle;
    private JLabel decisionsPerSecondLabel;
    private JLabel accumulatedConditionTimeLabel;
    private JCheckBox ABTUpdateTreeButton;
    private int decisionCycleCounterForDecisionsPerMillisecond;
    private int decisionCycleCounterForConditionTime;
    private long accumulatedContinuousConditionTime;
    private long startTime;
    protected JCheckBox traceToScreenChkBox;
    protected JCheckBox traceToBufferChkBox;
    protected final TraceListener traceListener;
    protected List traceBuffer;
    protected Set tracedBehaviors;
    private JFrame debugFrame;
    private JButton breakBtn;
    private JButton stepBtn;
    private JButton continueBtn;
    private final AblEventSupport listenerSupport;
    private static final /* synthetic */ boolean $noassert;
    
    public boolean getBreakDecisionCycle() {
        return this.bBreakDecisionCycle;
    }
    
    protected void setTreeModel(final JTree tree, final DefaultTreeModel model) {
        tree.setModel(model);
        final ListIterator listIterator = this.getAllLeafPaths((TreeNode)model.getRoot(), model).listIterator();
        while (listIterator.hasNext()) {
            tree.makeVisible(listIterator.next());
        }
    }
    
    public void setABTTreeModel(final DefaultTreeModel defaultTreeModel) {
        this.setTreeModel(this.ABTTree, defaultTreeModel);
    }
    
    protected void clearABTTreeModel() {
        this.ABTTree.setModel(new DefaultTreeModel(new DefaultMutableTreeNode("ABT not available")));
    }
    
    public boolean updateABT() {
        return this.ABTUpdateTreeButton.isSelected();
    }
    
    protected LinkedList getAllLeafPaths(final TreeNode treeNode, final DefaultTreeModel defaultTreeModel) {
        final LinkedList<TreePath> list = new LinkedList<TreePath>();
        final int childCount = treeNode.getChildCount();
        if (childCount == 0) {
            list.add(new TreePath(defaultTreeModel.getPathToRoot(treeNode)));
            return list;
        }
        for (int i = 0; i < childCount; ++i) {
            list.addAll(this.getAllLeafPaths(treeNode.getChildAt(i), defaultTreeModel));
        }
        return list;
    }
    
    public synchronized void debug(final long n) {
        if (!Debugger.$noassert && n < 0L) {
            throw new AssertionError();
        }
        if (this.bBreakDecisionCycle) {
            System.out.println(BehavingEntity.getBehavingEntity().getBehavingEntityShortName() + ": hit breakpoint");
            this.decisionCycleCounterForDecisionsPerMillisecond = 0;
            this.wmPanel.update();
            this.setABTTreeModel(this.entity.getABTTreeModel());
            BehavingEntity.getBehavingEntity().printNegotiationThreads();
            BehavingEntity.getBehavingEntity().printLeafSteps();
            BehavingEntity.getBehavingEntity().printAtomicSteps();
            try {
                this.wait();
            }
            catch (Exception ex) {
                throw new AblRuntimeError("Unexpected interruption in Debugger.debug()");
            }
        }
        else {
            if (this.updateABT()) {
                this.setABTTreeModel(this.entity.getABTTreeModel());
            }
            final long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.startTime >= 1000L) {
                this.decisionsPerSecondLabel.setText("Decisions per second " + Math.round(this.decisionCycleCounterForDecisionsPerMillisecond / (float)(currentTimeMillis - this.startTime) * 1000.0f));
                this.decisionCycleCounterForDecisionsPerMillisecond = 0;
                this.startTime = System.currentTimeMillis();
            }
            else {
                ++this.decisionCycleCounterForDecisionsPerMillisecond;
            }
            this.accumulatedContinuousConditionTime += n;
            if (this.decisionCycleCounterForConditionTime == 100) {
                this.accumulatedConditionTimeLabel.setText("Continuous condition time/100 cycles " + this.accumulatedContinuousConditionTime);
                this.decisionCycleCounterForConditionTime = 0;
                this.accumulatedContinuousConditionTime = 0L;
            }
            else {
                ++this.decisionCycleCounterForConditionTime;
            }
        }
    }
    
    public synchronized void breakSenseCycle() {
    }
    
    public synchronized void setTraceToBuffer(final boolean selected) {
        this.traceToBufferChkBox.setSelected(selected);
    }
    
    public synchronized void setTraceToScreen(final boolean selected) {
        this.traceToScreenChkBox.setSelected(selected);
    }
    
    public synchronized void releaseDecisionThread() {
        this.notify();
    }
    
    public void breakNextDecisionCycle() {
        this.bBreakDecisionCycle = true;
    }
    
    public void addABLListener(final AblListener ablListener) {
        this.listenerSupport.addAblListener(ablListener);
    }
    
    public void removeABLListener(final AblListener ablListener) {
        this.listenerSupport.removeAblListener(ablListener);
    }
    
    void traceAblExecutionEvent(final int n, final Step step, final Object o, final int n2, final int n3) {
        if (Debugger.debuggedBehaviors.contains(new Integer(n3))) {
            this.listenerSupport.fireAblEvent(n, step, o, n2);
        }
    }
    
    void traceAblExecutionEvent(final int n, final __BehaviorDesc _BehaviorDesc, final Object o, final int n2, final int n3) {
        if (Debugger.debuggedBehaviors.contains(new Integer(n3))) {
            this.listenerSupport.fireAblEvent(n, _BehaviorDesc, o, n2);
        }
    }
    
    void traceBehavior(final int n) {
        Debugger.debuggedBehaviors.add(new Integer(n));
    }
    
    void untraceBehavior(final int n) {
        Debugger.debuggedBehaviors.remove(new Integer(n));
    }
    
    static /* synthetic */ void access$1(final Debugger debugger, final boolean bBreakDecisionCycle) {
        debugger.bBreakDecisionCycle = bBreakDecisionCycle;
    }
    
    private final /* synthetic */ void this() {
        this.bBreakDecisionCycle = true;
        this.decisionCycleCounterForDecisionsPerMillisecond = 0;
        this.decisionCycleCounterForConditionTime = 0;
        this.accumulatedContinuousConditionTime = 0L;
        this.startTime = System.currentTimeMillis();
        this.traceListener = new TraceListener();
        this.traceBuffer = new LinkedList();
        this.tracedBehaviors = new HashSet();
        this.listenerSupport = new AblEventSupport();
    }
    
    public Debugger(final BehavingEntity entity) {
        this.this();
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        }
        catch (Exception ex) {
            throw new AblRuntimeError("Error setting the look and feel in the debugger");
        }
        this.wmPanel = entity.getWMDebugger();
        (this.ABTTree = new JTree((Object[])null)).setRootVisible(true);
        this.ABTTree.setCellRenderer(new ABTCellRenderer());
        final JPanel panel = new JPanel();
        this.ABTUpdateTreeButton = new JCheckBox("Continuously update ABT");
        final JScrollPane scrollPane = new JScrollPane(this.ABTTree);
        scrollPane.getViewport().setScrollMode(2);
        panel.setLayout(new BoxLayout(panel, 1));
        panel.add(this.ABTUpdateTreeButton);
        panel.add(scrollPane);
        panel.setBorder(BorderFactory.createTitledBorder("Active Behavior Tree"));
        this.breakBtn = new JButton("Break");
        this.stepBtn = new JButton("Step");
        this.continueBtn = new JButton("Continue");
        this.breakBtn.addActionListener(new ActionListener() {
            public final void actionPerformed(final ActionEvent actionEvent) {
                Debugger.access$1(Debugger.this, true);
                Debugger.this.debugFrame.getRootPane().setDefaultButton(Debugger.this.continueBtn);
            }
        });
        this.stepBtn.addActionListener(new ActionListener() {
            public final void actionPerformed(final ActionEvent actionEvent) {
                Debugger.this.releaseDecisionThread();
            }
        });
        this.continueBtn.addActionListener(new ActionListener() {
            public final void actionPerformed(final ActionEvent actionEvent) {
                Debugger.this.wmPanel.clearWMView();
                Debugger.this.clearABTTreeModel();
                Debugger.access$1(Debugger.this, false);
                Debugger.this.releaseDecisionThread();
                Debugger.this.debugFrame.getRootPane().setDefaultButton(Debugger.this.breakBtn);
            }
        });
        final JSplitPane splitPane = new JSplitPane(0, true, this.wmPanel, panel);
        splitPane.setOneTouchExpandable(true);
        this.wmPanel.setMinimumSize(new Dimension(200, 100));
        panel.setMinimumSize(new Dimension(200, 100));
        this.wmPanel.setPreferredSize(new Dimension(500, 200));
        panel.setPreferredSize(new Dimension(500, 200));
        (this.traceArea = new JTextArea()).setEditable(false);
        this.traceView = new JScrollPane(this.traceArea);
        this.traceViewScroller = this.traceView.getVerticalScrollBar();
        this.traceView.getViewport().setScrollMode(2);
        this.traceArea.addMouseListener(new MouseAdapter() {
            public final void mouseClicked(final MouseEvent mouseEvent) {
                Debugger.this.traceArea.selectAll();
                Debugger.this.traceArea.copy();
            }
        });
        final JButton button = new JButton("Select Trace");
        this.traceToScreenChkBox = new JCheckBox("Trace to screen");
        this.traceToBufferChkBox = new JCheckBox("Trace to buffer");
        final JButton button2 = new JButton("Clear Screen");
        final JButton button3 = new JButton("Clear Buffer");
        final JButton button4 = new JButton("Replay Buffer");
        button.addActionListener(new ActionListener() {
            public final void actionPerformed(final ActionEvent actionEvent) {
                new SelectTraceDialog().setVisible(true);
            }
        });
        button2.addActionListener(new ActionListener() {
            public final void actionPerformed(final ActionEvent actionEvent) {
                Debugger.this.traceArea.setText("");
            }
        });
        button3.addActionListener(new ActionListener() {
            public final void actionPerformed(final ActionEvent actionEvent) {
                Debugger.this.traceBuffer.clear();
            }
        });
        button4.addActionListener(new ActionListener() {
            public final void actionPerformed(final ActionEvent actionEvent) {
                Debugger.this.traceArea.setText("");
                for (final AblEvent ablEvent : Debugger.this.traceBuffer) {
                    if (ablEvent.getSourceType() == 1) {
                        if (!Debugger.this.tracedBehaviors.contains(((__BehaviorDesc)ablEvent.getSource()).signature)) {
                            continue;
                        }
                        Debugger.this.traceArea.append(Debugger.this.traceListener.formatBehaviorTrace(ablEvent));
                    }
                    else if (ablEvent.getSourceType() == 3) {
                        final JointGoalNegotiatorDebug.JointGoalNegotiationInfo jointGoalNegotiationInfo = (JointGoalNegotiatorDebug.JointGoalNegotiationInfo)ablEvent.getObject();
                        if (jointGoalNegotiationInfo.g == null) {
                            continue;
                        }
                        if (Debugger.this.tracedBehaviors.contains(jointGoalNegotiationInfo.g.getParent().getSignature())) {
                            Debugger.this.traceArea.append(Debugger.this.traceListener.formatBehaviorTrace(ablEvent));
                        }
                        else {
                            Debugger.this.traceArea.append(Debugger.this.traceListener.formatBehaviorTrace(ablEvent));
                        }
                    }
                    else {
                        if (!Debugger.this.tracedBehaviors.contains(((Step)ablEvent.getSource()).getParent().getSignature())) {
                            continue;
                        }
                        Debugger.this.traceArea.append(Debugger.this.traceListener.formatBehaviorTrace(ablEvent));
                    }
                }
            }
        });
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, 1));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new BoxLayout(panel3, 1));
        panel3.setMaximumSize(new Dimension(400, 120));
        panel3.setAlignmentX(0.5f);
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new BoxLayout(panel4, 0));
        panel4.setAlignmentX(0.0f);
        final JPanel panel5 = new JPanel();
        panel5.setLayout(new BoxLayout(panel5, 0));
        panel5.setAlignmentX(0.0f);
        panel2.add(panel3);
        panel3.add(panel4);
        panel3.add(panel5);
        panel4.add(button);
        panel4.add(Box.createHorizontalStrut(10));
        panel4.add(this.traceToScreenChkBox);
        panel4.add(Box.createHorizontalStrut(10));
        panel4.add(this.traceToBufferChkBox);
        panel5.add(button2);
        panel5.add(Box.createHorizontalStrut(10));
        panel5.add(button3);
        panel5.add(Box.createHorizontalStrut(10));
        panel5.add(button4);
        panel2.add(Box.createVerticalStrut(10));
        panel2.add(this.traceView);
        panel2.setBorder(BorderFactory.createTitledBorder("Behavior Trace"));
        final JSplitPane splitPane2 = new JSplitPane(0, true, splitPane, panel2);
        splitPane2.setOneTouchExpandable(true);
        splitPane.setMinimumSize(new Dimension(400, 200));
        splitPane.setPreferredSize(new Dimension(1000, 400));
        splitPane2.setMinimumSize(new Dimension(200, 300));
        splitPane2.setPreferredSize(new Dimension(500, 600));
        splitPane2.setAlignmentX(1.0f);
        this.decisionsPerSecondLabel = new JLabel("Decisions per second");
        this.accumulatedConditionTimeLabel = new JLabel("Continuous condition time/100 cycles");
        final JPanel panel6 = new JPanel();
        final Box box = new Box(1);
        final Box box2 = new Box(0);
        panel6.add(box);
        panel6.add(Box.createRigidArea(new Dimension(50, 0)));
        panel6.add(box2);
        box.add(this.decisionsPerSecondLabel);
        box.add(this.accumulatedConditionTimeLabel);
        box2.add(this.breakBtn);
        box2.add(Box.createRigidArea(new Dimension(10, 0)));
        box2.add(this.stepBtn);
        box2.add(Box.createRigidArea(new Dimension(10, 0)));
        box2.add(this.continueBtn);
        panel6.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel6.setAlignmentX(1.0f);
        panel6.setMinimumSize(new Dimension(200, 90));
        panel6.setPreferredSize(new Dimension(500, 90));
        this.entity = entity;
        final String name = entity.getClass().getName();
        this.debugFrame = new JFrame(name.substring(name.lastIndexOf(46) + 1) + " Debugger");
        this.debugFrame.getContentPane().setLayout(new BoxLayout(this.debugFrame.getContentPane(), 1));
        this.debugFrame.getContentPane().add(splitPane2);
        this.debugFrame.getContentPane().add(panel6);
        this.debugFrame.getRootPane().setDefaultButton(this.continueBtn);
        this.debugFrame.pack();
        this.debugFrame.setVisible(true);
        this.listenerSupport.addAblListener(this.traceListener);
    }
    
    static {
        $noassert = (Class.forName("[Labl.runtime.Debugger;").getComponentType().desiredAssertionStatus() ^ true);
        debuggedBehaviors = new HashSet();
    }
    
    protected class ABTCellRenderer extends DefaultTreeCellRenderer
    {
        public Component getTreeCellRendererComponent(final JTree tree, final Object o, final boolean b, final boolean b2, final boolean b3, final int n, final boolean b4) {
            super.getTreeCellRendererComponent(tree, o, b, b2, b3, n, b4);
            try {
                final Step step = (Step)((DefaultMutableTreeNode)o).getUserObject();
                if (step.isSuspended()) {
                    this.setForeground(Color.red);
                }
                else if (step.getStepType() == 1 && ((JointGoalStep)step).isJointGoal() && ((JointGoalStep)step).getIsNegotiating()) {
                    this.setForeground(Color.blue);
                }
                else {
                    this.setForeground(Color.black);
                }
                return this;
            }
            catch (ClassCastException ex) {
                this.setForeground(Color.black);
                return this;
            }
            catch (NullPointerException ex2) {
                this.setForeground(Color.black);
                return this;
            }
        }
    }
    
    class TraceListener implements AblListener
    {
        static final String lineSep = "\n";
        final Hashtable timeTable;
        
        private final String getNegotiationActionString(final JointGoalNegotiatorDebug.JointGoalNegotiationInfo jointGoalNegotiationInfo) {
            switch (jointGoalNegotiationInfo.intention) {
                case 17: {
                    return "entry";
                }
                case 18: {
                    return "refuse entry";
                }
                case 19: {
                    return "succeed";
                }
                case 20: {
                    return "fail";
                }
                case 21: {
                    return "remove";
                }
                case 22: {
                    return "suspend";
                }
                case 23: {
                    return "unsuspend";
                }
                default: {
                    return "unrecognized action";
                }
            }
        }
        
        public AblEvent computeElapsedTime(final AblEvent ablEvent) {
            final Object source = ablEvent.getSource();
            Long n = this.timeTable.get(source);
            ablEvent.getType();
            switch (ablEvent.getType()) {
                case 5:
                case 7:
                case 9: {
                    this.timeTable.put(source, new Long(System.currentTimeMillis()));
                    break;
                }
                case 3:
                case 6:
                case 8:
                case 10: {
                    if (n != null) {
                        ablEvent.setElapsedTime(System.currentTimeMillis() - n);
                        this.timeTable.remove(source);
                    }
                    break;
                }
                case 2: {
                    this.timeTable.put(source, new Long(System.currentTimeMillis()));
                    final Object object = ablEvent.getObject();
                    if (object != null) {
                        n = (Long)this.timeTable.get(object);
                    }
                    if (n != null) {
                        ablEvent.setElapsedTime(System.currentTimeMillis() - n);
                        break;
                    }
                    break;
                }
            }
            return ablEvent;
        }
        
        public String formatBehaviorTrace(final AblEvent ablEvent) {
            final Object object = ablEvent.getObject();
            final Object source = ablEvent.getSource();
            final long elapsedTime = ablEvent.getElapsedTime();
            String s = null;
            switch (ablEvent.getType()) {
                case 1: {
                    s = "precondition tested: " + object;
                    break;
                }
                case 2: {
                    s = "behavior chosen";
                    break;
                }
                case 3: {
                    if (object) {
                        s = "behavior succeeded";
                    }
                    else {
                        s = "behavior failed";
                    }
                    break;
                }
                case 4: {
                    s = "context condition failed";
                    break;
                }
                case 5: {
                    s = "execution";
                    break;
                }
                case 6: {
                    if (object) {
                        s = "succeeded";
                    }
                    else {
                        s = "act failed";
                    }
                    break;
                }
                case 7: {
                    s = "execution";
                    break;
                }
                case 8: {
                    if (object) {
                        s = "succeeded";
                    }
                    else {
                        s = "failed";
                    }
                    break;
                }
                case 9: {
                    s = "execution";
                    break;
                }
                case 10: {
                    s = "succeeded";
                    break;
                }
                case 11: {
                    s = "succeeded";
                    break;
                }
                case 12: {
                    s = "execution";
                    break;
                }
                case 13: {
                    s = "failed";
                    break;
                }
                case 14: {
                    s = "execution";
                    break;
                }
                case 15: {
                    s = "succeeded";
                    break;
                }
                case 18: {
                    s = "success test succeeded";
                    break;
                }
                case 19: {
                    s = "re-rooting subgoal at ABT root";
                    break;
                }
                case 20: {
                    s = "initiating " + this.getNegotiationActionString((JointGoalNegotiatorDebug.JointGoalNegotiationInfo)object) + " negotiation";
                    break;
                }
                case 21: {
                    s = "completing " + this.getNegotiationActionString((JointGoalNegotiatorDebug.JointGoalNegotiationInfo)object) + " negotiation";
                    break;
                }
                case 22: {
                    s = "initiating " + this.getNegotiationActionString((JointGoalNegotiatorDebug.JointGoalNegotiationInfo)object) + " intention";
                    break;
                }
                case 23: {
                    s = "committing to " + this.getNegotiationActionString((JointGoalNegotiatorDebug.JointGoalNegotiationInfo)object) + " intention";
                    break;
                }
                case 24: {
                    s = "process " + this.getNegotiationActionString((JointGoalNegotiatorDebug.JointGoalNegotiationInfo)object) + " intention";
                    break;
                }
                default: {
                    s = "unrecognized action " + ablEvent.getType();
                    break;
                }
            }
            final int nestLevel = ablEvent.getNestLevel();
            final StringBuffer sb = new StringBuffer(2 * nestLevel);
            for (int i = 0; i < nestLevel; ++i) {
                sb.append("  ");
            }
            String s2 = "";
            switch (ablEvent.getSourceType()) {
                case 1: {
                    if (ablEvent.getType() == 1 || ablEvent.getType() == 2) {
                        s2 = ((__BehaviorDesc)source).uniqueName;
                    }
                    else {
                        s2 = ((__BehaviorDesc)source).signature;
                    }
                    break;
                }
                case 3: {
                    final JointGoalNegotiatorDebug.JointGoalNegotiationInfo jointGoalNegotiationInfo = (JointGoalNegotiatorDebug.JointGoalNegotiationInfo)object;
                    if (jointGoalNegotiationInfo.g != null) {
                        s2 = jointGoalNegotiationInfo.g.getSignature();
                    }
                    if (jointGoalNegotiationInfo.behavingEntity != null) {
                        s2 = s2 + " from " + jointGoalNegotiationInfo.behavingEntity;
                    }
                    break;
                }
                case 2: {
                    s2 = ((Step)source).toString();
                    break;
                }
                default: {
                    s2 = "unrecognized source " + ablEvent.getSourceType();
                    break;
                }
            }
            if (elapsedTime != -1) {
                s = s + " elapsed time = " + elapsedTime;
            }
            if (s2.equals("")) {
                return (Object)sb + s + '\n';
            }
            return (Object)sb + s2 + ": " + s + '\n';
        }
        
        public void eventHappened(final AblEvent ablEvent) {
            if (Debugger.this.traceToScreenChkBox.isSelected()) {
                SwingUtilities.invokeLater(new Runnable() {
                    public final void run() {
                        Debugger.this.traceArea.append(TraceListener.this.formatBehaviorTrace(TraceListener.this.computeElapsedTime(ablEvent)));
                    }
                });
            }
            if (Debugger.this.traceToBufferChkBox.isSelected()) {
                Debugger.this.traceBuffer.add(this.computeElapsedTime(ablEvent));
            }
        }
        
        private final /* synthetic */ void this() {
            this.timeTable = new Hashtable();
        }
        
        TraceListener() {
            this.this();
        }
    }
    
    class StringIgnoreCaseComparator implements Comparator
    {
        public int compare(final Object o, final Object o2) {
            return ((String)o).compareToIgnoreCase((String)o2);
        }
    }
    
    class SelectTraceDialog extends JDialog
    {
        private final JPanel contentPane;
        private final JPanel checkBoxes;
        private final JScrollPane checkBoxesView;
        private final JPanel buttonContainer;
        private final JButton okBtn;
        private final JButton cancelBtn;
        private final JButton selectAllBtn;
        private final JButton clearAllBtn;
        final SelectTraceDialog me;
        
        SelectTraceDialog() {
            (this.me = this).setTitle("Select behaviors to trace");
            this.setContentPane(this.contentPane = new JPanel());
            this.contentPane.setLayout(new BoxLayout(this.contentPane, 1));
            (this.checkBoxes = new ScrollableJPanel()).setLayout(new BoxLayout(this.checkBoxes, 1));
            this.checkBoxesView = new JScrollPane(this.checkBoxes);
            this.checkBoxesView.getViewport().setScrollMode(2);
            (this.buttonContainer = new JPanel()).setLayout(new BoxLayout(this.buttonContainer, 0));
            this.buttonContainer.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            this.selectAllBtn = new JButton("Select All");
            this.clearAllBtn = new JButton("Clear All");
            this.okBtn = new JButton("OK");
            this.cancelBtn = new JButton("Cancel");
            this.okBtn.addActionListener(new ActionListener() {
                public final void actionPerformed(final ActionEvent actionEvent) {
                    final Component[] components = SelectTraceDialog.this.checkBoxes.getComponents();
                    for (int i = 0; i < components.length; ++i) {
                        final JCheckBox checkBox = (JCheckBox)components[i];
                        if (checkBox.isSelected()) {
                            if (!Debugger.this.tracedBehaviors.contains(checkBox.getText())) {
                                Debugger.this.entity.traceBehaviorSignature(checkBox.getText());
                                Debugger.this.tracedBehaviors.add(checkBox.getText());
                            }
                        }
                        else if (Debugger.this.tracedBehaviors.contains(checkBox.getText())) {
                            Debugger.this.entity.untraceBehaviorSignature(checkBox.getText());
                            Debugger.this.tracedBehaviors.remove(checkBox.getText());
                        }
                    }
                    SelectTraceDialog.this.me.dispose();
                }
            });
            this.cancelBtn.addActionListener(new ActionListener() {
                public final void actionPerformed(final ActionEvent actionEvent) {
                    SelectTraceDialog.this.me.dispose();
                }
            });
            this.selectAllBtn.addActionListener(new ActionListener() {
                public final void actionPerformed(final ActionEvent actionEvent) {
                    final Component[] components = SelectTraceDialog.this.checkBoxes.getComponents();
                    for (int i = 0; i < components.length; ++i) {
                        ((JCheckBox)components[i]).setSelected(true);
                    }
                }
            });
            this.clearAllBtn.addActionListener(new ActionListener() {
                public final void actionPerformed(final ActionEvent actionEvent) {
                    final Component[] components = SelectTraceDialog.this.checkBoxes.getComponents();
                    for (int i = 0; i < components.length; ++i) {
                        ((JCheckBox)components[i]).setSelected(false);
                    }
                }
            });
            this.getContentPane().add(this.checkBoxesView);
            this.getContentPane().add(this.buttonContainer);
            this.buttonContainer.add(this.selectAllBtn);
            this.buttonContainer.add(this.clearAllBtn);
            this.buttonContainer.add(Box.createHorizontalStrut(30));
            this.buttonContainer.add(this.okBtn);
            this.buttonContainer.add(this.cancelBtn);
            this.buttonContainer.setMaximumSize(new Dimension(this.buttonContainer.getMaximumSize().width, 30));
            this.buttonContainer.setMinimumSize(new Dimension(200, 30));
            final Set registeredBehaviors = Debugger.this.entity.getRegisteredBehaviors();
            final String[] array = registeredBehaviors.toArray(new String[registeredBehaviors.size()]);
            Arrays.sort(array, new StringIgnoreCaseComparator());
            for (int i = 0; i < array.length; ++i) {
                this.checkBoxes.add(new JCheckBox(array[i], Debugger.this.tracedBehaviors.contains(array[i])));
            }
            final int n = new JCheckBox().getPreferredSize().height * array.length;
            final Dimension size = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration().getBounds().getSize();
            if (n > size.height - 60) {
                this.checkBoxesView.setPreferredSize(new Dimension(this.checkBoxes.getPreferredSize().width, size.height - 100));
            }
            this.setModal(true);
            this.pack();
        }
        
        class ScrollableJPanel extends JPanel implements Scrollable
        {
            public Dimension getPreferredScrollableViewportSize() {
                return this.getPreferredSize();
            }
            
            public int getScrollableUnitIncrement(final Rectangle rectangle, final int n, final int n2) {
                return new JCheckBox("Sample").getPreferredSize().height;
            }
            
            public int getScrollableBlockIncrement(final Rectangle rectangle, final int n, final int n2) {
                final JCheckBox checkBox = new JCheckBox("Sample");
                if (n == 1) {
                    return rectangle.height - checkBox.getPreferredSize().height;
                }
                return rectangle.width - checkBox.getPreferredSize().height;
            }
            
            public boolean getScrollableTracksViewportWidth() {
                return false;
            }
            
            public boolean getScrollableTracksViewportHeight() {
                return false;
            }
        }
    }
}
