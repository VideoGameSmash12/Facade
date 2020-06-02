package dramaman.runtime;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.RenderingHints;
import java.awt.Graphics;
import java.awt.Stroke;
import java.awt.BasicStroke;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.Graphics2D;
import java.util.Vector;
import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.Container;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.Box;
import java.awt.Component;
import javax.swing.ListModel;
import javax.swing.DefaultListModel;
import java.util.Hashtable;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JSplitPane;

public class BeatMonitor extends JSplitPane
{
    private static final int PREFERRED_WIDTH = 500;
    private static final int PREFERRED_HEIGHT = 400;
    private static final String BLANK_BEAT_NAME = "                           ";
    private static final String BLANK_ERROR = "                                 ";
    private BeatGraphPanel graph;
    private JList availableBeats;
    private JList usedBeats;
    private SatisfiedBeatsPane satisfiedBeatsPane;
    private ActiveBeatPane currentBeatPane;
    private JTextField cumulativeError;
    private DramaManager dramaManager;
    
    public void setStory(final Beat[] array, final int n, final Hashtable hashtable) {
        this.graph.setStory(array, n, hashtable);
        final DefaultListModel<String> model = new DefaultListModel<String>();
        model.clear();
        for (int i = 0; i < array.length; ++i) {
            model.addElement(array[i].getBeatName());
        }
        this.availableBeats.setModel(model);
        ((DefaultListModel)this.usedBeats.getModel()).clear();
    }
    
    void succeedBeat(final Beat beat) {
        this.currentBeatPane.clear();
        this.satisfiedBeatsPane.clear();
        ((DefaultListModel)this.availableBeats.getModel()).removeElement(beat.getBeatName());
        ((DefaultListModel)this.usedBeats.getModel()).addElement(beat.getBeatName() + "   succeeded");
        this.graph.succeedBeat(beat);
    }
    
    public void failBeat(final Beat beat) {
        this.currentBeatPane.clear();
        this.satisfiedBeatsPane.clear();
        ((DefaultListModel)this.availableBeats.getModel()).removeElement(beat.getBeatName());
        ((DefaultListModel)this.usedBeats.getModel()).addElement(beat.getBeatName() + "   failed");
    }
    
    public void refreshSatisfiedBeats(final Beat[] array, final Hashtable hashtable, final int n) {
        this.satisfiedBeatsPane.refreshSatisfiedBeats(array, hashtable, n);
    }
    
    public void chooseBeat(final Beat beat) {
        this.currentBeatPane.setCurrentBeat(beat, beat.getProbability());
    }
    
    public void setCumulativeError(final double n) {
        String text = Double.toString(n);
        if (text.length() > 5) {
            text = text.substring(0, 5);
        }
        this.cumulativeError.setText(text);
    }
    
    public BeatMonitor() {
        this.setOrientation(0);
        this.setContinuousLayout(true);
        this.setResizeWeight(0.5);
        this.setTopComponent(this.graph = new BeatGraphPanel());
        this.dramaManager = DramaManager.getDramaManager();
        final Box bottomComponent = new Box(0);
        this.availableBeats = new JList((ListModel<E>)new DefaultListModel<Object>());
        final JScrollPane scrollPane = new JScrollPane(this.availableBeats);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Available Beats"));
        scrollPane.setMinimumSize(new Dimension(100, 100));
        scrollPane.setPreferredSize(new Dimension(150, 100));
        scrollPane.setAlignmentY(0.0f);
        (this.satisfiedBeatsPane = new SatisfiedBeatsPane()).setAlignmentY(0.0f);
        final JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, 1));
        panel.setAlignmentY(0.0f);
        (this.currentBeatPane = new ActiveBeatPane()).setAlignmentY(0.5f);
        panel.add(this.currentBeatPane);
        this.usedBeats = new JList((ListModel<E>)new DefaultListModel<Object>());
        final JScrollPane scrollPane2 = new JScrollPane(this.usedBeats);
        scrollPane2.setBorder(BorderFactory.createTitledBorder("Used Beats"));
        scrollPane2.setMinimumSize(new Dimension(100, 100));
        scrollPane2.setPreferredSize(new Dimension(150, 100));
        scrollPane2.setAlignmentY(0.0f);
        bottomComponent.add(scrollPane);
        bottomComponent.add(this.satisfiedBeatsPane);
        bottomComponent.add(panel);
        bottomComponent.add(scrollPane2);
        this.setBottomComponent(bottomComponent);
        this.setOneTouchExpandable(true);
    }
    
    class BeatGraphPanel extends JPanel
    {
        private static final int MAX_BEAT = 20;
        private static final int MAX_VALUE = 5;
        private static final int VALUE_TICK_INCREMENT = 1;
        private static final int TICK_LENGTH = 10;
        private static final int NUMBER_OF_VALUE_TICKS = 5;
        private static final int X_BORDER = 40;
        private static final int Y_BORDER = 20;
        private static final int MINIMUM_GRAPH_HEIGHT = 40;
        private static final int MINIMUM_GRAPH_WIDTH = 70;
        private final Color[] colors;
        private int xAxisLength;
        private int yAxisLength;
        private float xTickDistance;
        private float yTickDistance;
        private float scale;
        private StoryTarget[] targets;
        private int maxBeats;
        Vector actualStoryValues;
        int beatCount;
        
        void setStory(final Beat[] array, final int maxBeats, final Hashtable hashtable) {
            this.targets = (StoryTarget[])hashtable.values().toArray(new StoryTarget[hashtable.size()]);
            this.maxBeats = maxBeats;
            (this.actualStoryValues = new Vector()).add(new float[this.targets.length]);
            this.beatCount = 0;
            for (int i = 0; i < this.targets.length; ++i) {
                ((float[])this.actualStoryValues.get(0))[i] = this.targets[i].getInitialValue();
            }
            this.repaint();
        }
        
        void succeedBeat(final Beat beat) {
            ++this.beatCount;
            this.actualStoryValues.add(new float[this.targets.length]);
            for (int i = 0; i < this.targets.length; ++i) {
                ((float[])this.actualStoryValues.get(this.beatCount))[i] = DramaManager.getStoryMemory().getStoryValue(this.targets[i].getValueWMEName());
            }
            this.repaint();
        }
        
        private final void computeAxesInfo(final Dimension dimension) {
            this.xAxisLength = dimension.width - 40;
            this.yAxisLength = dimension.height - 20 - 15;
            this.xTickDistance = (float)(this.xAxisLength / 20);
            this.yTickDistance = (float)(this.yAxisLength / 5);
            this.scale = (this.xTickDistance + this.yTickDistance) / 2.0f;
        }
        
        private final void paintAxes(final Graphics2D graphics2D, final Dimension dimension, final AffineTransform affineTransform) {
            graphics2D.draw(new Line2DTransform(0.0f, 0.0f, (float)this.xAxisLength, 0.0f, affineTransform));
            graphics2D.draw(new Line2DTransform(0.0f, 0.0f, 0.0f, (float)this.yAxisLength, affineTransform));
            for (int i = 1; i <= 20; ++i) {
                graphics2D.draw(new Line2DTransform(i * this.xTickDistance, -5.0f, i * this.xTickDistance, 5, affineTransform));
            }
            for (int j = 1; j <= 5; ++j) {
                graphics2D.draw(new Line2DTransform(-5.0f, j * this.yTickDistance, 5, j * this.yTickDistance, affineTransform));
            }
        }
        
        private final Color pickColor(final int n) {
            if (n < this.colors.length) {
                return this.colors[n];
            }
            return this.colors[n % this.colors.length];
        }
        
        private final void paintTargets(final Graphics2D graphics2D, final AffineTransform affineTransform) {
            if (this.targets != null) {
                for (int i = 0; i < this.targets.length; ++i) {
                    graphics2D.setColor(this.pickColor(i));
                    this.targets[i].drawTarget(graphics2D, this.maxBeats, affineTransform);
                }
            }
        }
        
        private final void paintActualValues(final Graphics2D graphics2D, final AffineTransform affineTransform) {
            if (this.beatCount > 0) {
                final BasicStroke stroke = (BasicStroke)graphics2D.getStroke();
                graphics2D.setStroke(new BasicStroke(stroke.getLineWidth(), 0, stroke.getLineJoin(), stroke.getMiterLimit(), new float[] { 3 }, 0.0f));
                for (int i = 0; i < this.targets.length; ++i) {
                    graphics2D.setColor(this.pickColor(i));
                    for (int j = 1; j <= this.beatCount; ++j) {
                        graphics2D.draw(new Line2DTransform((float)(j - 1), ((float[])this.actualStoryValues.get(j - 1))[i], (float)j, ((float[])this.actualStoryValues.get(j))[i], affineTransform));
                    }
                }
                graphics2D.setStroke(stroke);
            }
        }
        
        private final void paintCurrentBeatMarker(final Graphics2D graphics2D, final AffineTransform affineTransform) {
            final Color color = graphics2D.getColor();
            graphics2D.setColor(Color.blue);
            graphics2D.draw(new Line2DTransform((float)(this.beatCount + 1), 0.0f, (float)(this.beatCount + 1), 100.0f, affineTransform));
            graphics2D.setColor(color);
        }
        
        public void paintComponent(final Graphics graphics) {
            super.paintComponent(graphics);
            final Graphics2D graphics2D = (Graphics2D)graphics;
            final Dimension size = this.getSize();
            this.computeAxesInfo(size);
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            graphics2D.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
            final AffineTransform affineTransform = new AffineTransform(1.0f, 0.0f, 0.0f, -1.0f, 30.0f, (float)(size.height - 20));
            this.paintAxes(graphics2D, size, affineTransform);
            final AffineTransform affineTransform2 = new AffineTransform(affineTransform);
            affineTransform2.scale(this.xTickDistance, this.yTickDistance);
            this.paintTargets(graphics2D, affineTransform2);
            this.paintActualValues(graphics2D, affineTransform2);
            this.paintCurrentBeatMarker(graphics2D, affineTransform2);
        }
        
        private final /* synthetic */ void this() {
            this.colors = new Color[] { Color.black, Color.red, Color.cyan, Color.green, Color.darkGray, Color.lightGray, Color.magenta, Color.orange, Color.pink, Color.white, Color.yellow };
        }
        
        public BeatGraphPanel() {
            this.this();
            this.setMinimumSize(new Dimension(110, 60));
            this.setBorder(BorderFactory.createTitledBorder("Story Arc"));
        }
    }
    
    class ActiveBeatPane extends JPanel
    {
        JLabel currentBeat;
        JButton succeedBeatButton;
        JButton failBeatButton;
        
        public void clear() {
            this.currentBeat.setText("                           ");
            this.succeedBeatButton.setEnabled(false);
            this.failBeatButton.setEnabled(false);
        }
        
        public void setCurrentBeat(final Beat beat, final float n) {
            this.currentBeat.setText(beat.getBeatName() + "   " + n);
            this.succeedBeatButton.setEnabled(true);
            this.failBeatButton.setEnabled(true);
        }
        
        public ActiveBeatPane() {
            this.setLayout(new BoxLayout(this, 1));
            this.setBorder(BorderFactory.createTitledBorder("Current Beat"));
            (this.currentBeat = new JLabel("                           ")).setForeground(Color.black);
            this.currentBeat.setAlignmentX(0.5f);
            this.add(this.currentBeat);
            this.add(Box.createVerticalStrut(15));
            (this.succeedBeatButton = new JButton("Succeed beat")).setDefaultCapable(true);
            this.succeedBeatButton.setAlignmentX(0.5f);
            this.add(this.succeedBeatButton);
            this.add(Box.createVerticalStrut(5));
            (this.failBeatButton = new JButton("Fail beat")).setAlignmentX(0.5f);
            this.add(this.failBeatButton);
            this.succeedBeatButton.addActionListener(new ActionListener() {
                public final void actionPerformed(final ActionEvent actionEvent) {
                    new Thread() {
                        public final void run() {
                            BeatMonitor.this.dramaManager.succeedCurrentBeat();
                        }
                    }.start();
                }
            });
            this.failBeatButton.addActionListener(new ActionListener() {
                public final void actionPerformed(final ActionEvent actionEvent) {
                    new Thread() {
                        public final void run() {
                            BeatMonitor.this.dramaManager.failCurrentBeat();
                        }
                    }.start();
                }
            });
            this.clear();
        }
    }
    
    class SatisfiedBeatsPane extends JPanel
    {
        private final JList satisfiedBeatsList;
        private final JButton autoChooseButton;
        private final JPopupMenu chooseBeatPopup;
        private Beat[] satisfiedBeats;
        private boolean popupEnabled;
        private int selectedBeatIndex;
        
        public void refreshSatisfiedBeats(final Beat[] satisfiedBeats, final Hashtable hashtable, final int n) {
            final DefaultListModel<String> model = new DefaultListModel<String>();
            for (int i = 0; i < satisfiedBeats.length; ++i) {
                final Beat beat = satisfiedBeats[i];
                model.addElement(beat.getBeatName() + "   " + beat.getProbability());
            }
            this.satisfiedBeatsList.setModel(model);
            this.satisfiedBeats = satisfiedBeats;
            this.autoChooseButton.setEnabled(true);
            this.satisfiedBeatsList.setEnabled(true);
            this.popupEnabled = true;
        }
        
        public void clear() {
            ((DefaultListModel)this.satisfiedBeatsList.getModel()).removeAllElements();
            this.autoChooseButton.setEnabled(false);
            this.satisfiedBeatsList.setEnabled(false);
            this.popupEnabled = false;
        }
        
        static /* synthetic */ void access$5(final SatisfiedBeatsPane satisfiedBeatsPane, final boolean popupEnabled) {
            satisfiedBeatsPane.popupEnabled = popupEnabled;
        }
        
        static /* synthetic */ void access$6(final SatisfiedBeatsPane satisfiedBeatsPane, final int selectedBeatIndex) {
            satisfiedBeatsPane.selectedBeatIndex = selectedBeatIndex;
        }
        
        private final /* synthetic */ void this() {
            this.popupEnabled = true;
        }
        
        public SatisfiedBeatsPane() {
            this.this();
            this.satisfiedBeatsList = new JList((ListModel<E>)new DefaultListModel<Object>());
            final JScrollPane scrollPane = new JScrollPane(this.satisfiedBeatsList);
            scrollPane.setMinimumSize(new Dimension(140, 100));
            scrollPane.setPreferredSize(new Dimension(140, 100));
            scrollPane.setAlignmentY(0.0f);
            scrollPane.setAlignmentX(0.5f);
            this.chooseBeatPopup = new JPopupMenu();
            final JMenuItem menuItem = new JMenuItem("Choose beat");
            menuItem.addActionListener(new ActionListener() {
                public final void actionPerformed(final ActionEvent actionEvent) {
                    BeatMonitor.this.dramaManager.setManuallySelectedBeat(SatisfiedBeatsPane.this.satisfiedBeats[SatisfiedBeatsPane.this.selectedBeatIndex]);
                    SatisfiedBeatsPane.this.autoChooseButton.setEnabled(false);
                    SatisfiedBeatsPane.this.autoChooseButton.setDefaultCapable(true);
                    BeatMonitor.this.getRootPane().setDefaultButton(SatisfiedBeatsPane.this.autoChooseButton);
                    SatisfiedBeatsPane.this.satisfiedBeatsList.setEnabled(false);
                    SatisfiedBeatsPane.access$5(SatisfiedBeatsPane.this, false);
                    BeatMonitor.this.dramaManager.releaseChooseThread();
                }
            });
            this.chooseBeatPopup.add(menuItem);
            this.satisfiedBeatsList.addMouseListener(new MouseAdapter() {
                public final void mouseClicked(final MouseEvent mouseEvent) {
                    SatisfiedBeatsPane.access$6(SatisfiedBeatsPane.this, SatisfiedBeatsPane.this.satisfiedBeatsList.locationToIndex(mouseEvent.getPoint()));
                    if (SatisfiedBeatsPane.this.popupEnabled && SatisfiedBeatsPane.this.selectedBeatIndex != -1) {
                        SatisfiedBeatsPane.this.chooseBeatPopup.show(mouseEvent.getComponent(), mouseEvent.getX(), mouseEvent.getY());
                    }
                }
            });
            (this.autoChooseButton = new JButton("Auto Choose")).setAlignmentX(0.5f);
            this.autoChooseButton.addActionListener(new ActionListener() {
                public final void actionPerformed(final ActionEvent actionEvent) {
                    BeatMonitor.this.dramaManager.setManuallySelectedBeat(BeatMonitor.this.dramaManager.chooseBeatFromDistribution(SatisfiedBeatsPane.this.satisfiedBeats));
                    SatisfiedBeatsPane.this.autoChooseButton.setEnabled(false);
                    SatisfiedBeatsPane.this.satisfiedBeatsList.setEnabled(false);
                    SatisfiedBeatsPane.access$5(SatisfiedBeatsPane.this, false);
                    BeatMonitor.this.dramaManager.releaseChooseThread();
                }
            });
            this.autoChooseButton.setEnabled(false);
            this.setLayout(new BoxLayout(this, 1));
            this.setBorder(BorderFactory.createTitledBorder("Distribution"));
            this.setMinimumSize(new Dimension(150, 100));
            this.setPreferredSize(new Dimension(150, 100));
            this.setAlignmentY(0.0f);
            this.add(scrollPane);
            this.add(this.autoChooseButton);
        }
    }
}
