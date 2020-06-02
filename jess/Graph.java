package jess;

import java.util.ArrayList;
import java.util.Enumeration;
import java.awt.event.MouseEvent;
import java.awt.FontMetrics;
import java.awt.image.ImageObserver;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Image;
import java.util.HashMap;
import java.awt.Color;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseListener;
import java.awt.Panel;

class Graph extends Panel implements MouseListener, MouseMotionListener, JessListener
{
    static final Color m_selectColor;
    static final int WIDTH = 10;
    static final int HW = 5;
    static final int HEIGHT = 10;
    static final int HH = 5;
    private static HashMap m_colors;
    private int m_nVNodes;
    private VNode[] m_VNodes;
    private int m_nVEdges;
    private VEdge[] m_VEdges;
    private VNode m_pick;
    private Node m_show;
    private Image m_offscreen;
    private Dimension m_offscreensize;
    private Graphics m_offgraphics;
    private transient Rete m_rete;
    private long m_lastMD;
    private int[] m_nextSlot;
    private Color[] m_edgeColors;
    private HasLHS m_haslhs;
    static /* synthetic */ Class class$jess$Node1;
    static /* synthetic */ Class class$jess$Node1LTR;
    static /* synthetic */ Class class$jess$Node1RTL;
    static /* synthetic */ Class class$jess$Node2;
    static /* synthetic */ Class class$jess$NodeNot2;
    static /* synthetic */ Class class$jess$NodeNot2Single;
    static /* synthetic */ Class class$jess$NodeJoin;
    static /* synthetic */ Class class$jess$Defrule;
    
    int findVNode(final Node node, final int n) {
        for (int i = 0; i < this.m_nVNodes; ++i) {
            if (this.m_VNodes[i].m_node == node) {
                return i;
            }
        }
        return this.addVNode(node, n);
    }
    
    private final Color getNodeColor(final Node node) {
        final Color color = Graph.m_colors.get(node.getClass());
        if (color != null) {
            return color;
        }
        if (node instanceof Node1) {
            final HashMap colors = Graph.m_colors;
            Class class$jess$Node1;
            if ((class$jess$Node1 = Graph.class$jess$Node1) == null) {
                class$jess$Node1 = (Graph.class$jess$Node1 = class$("[Ljess.Node1;", false));
            }
            return colors.get(class$jess$Node1);
        }
        return Color.black;
    }
    
    private final Color getEdgeColor(final Node node) {
        int n = 1 - ((node instanceof NodeJoin) ? 1 : 0);
        if (node instanceof Node1RTL) {
            n = 0;
        }
        if (n < 0 || n > this.m_edgeColors.length) {
            return Color.black;
        }
        return this.m_edgeColors[n];
    }
    
    int addVNode(final Node node, final int n) {
        final VNode vNode = new VNode(++this.m_nextSlot[n] * 15, n * 15, this.getNodeColor(node), node);
        if (this.m_nVNodes == this.m_VNodes.length) {
            final VNode[] vNodes = new VNode[this.m_nVNodes * 2];
            System.arraycopy(this.m_VNodes, 0, vNodes, 0, this.m_nVNodes);
            this.m_VNodes = vNodes;
        }
        this.m_VNodes[this.m_nVNodes] = vNode;
        return this.m_nVNodes++;
    }
    
    void addVEdge(final Node node, final Node node2, final int n, final Color color) {
        final VEdge vEdge = new VEdge(this.findVNode(node, n), this.findVNode(node2, n + 1), color);
        if (this.m_nVEdges == this.m_VEdges.length) {
            final VEdge[] vEdges = new VEdge[this.m_nVEdges * 2];
            System.arraycopy(this.m_VEdges, 0, vEdges, 0, this.m_nVEdges);
            this.m_VEdges = vEdges;
        }
        this.m_VEdges[this.m_nVEdges++] = vEdge;
    }
    
    public void paintVNode(final Graphics graphics, final VNode vNode) {
        final int x = vNode.m_x;
        final int y = vNode.m_y;
        graphics.setColor((vNode == this.m_pick) ? Graph.m_selectColor : vNode.m_c);
        final int n = 10;
        final int n2 = 10;
        graphics.fillRect(x - n / 2, y - n2 / 2, n, n2);
        graphics.setColor(Color.black);
        graphics.drawRect(x - n / 2, y - n2 / 2, n - 1, n2 - 1);
    }
    
    public synchronized void update(final Graphics graphics) {
        this.paint(graphics);
    }
    
    public synchronized void paint(final Graphics graphics) {
        final Dimension size = this.getSize();
        if (this.m_offscreen == null || size.width != this.m_offscreensize.width || size.height != this.m_offscreensize.height) {
            this.m_offscreen = this.createImage(size.width, size.height);
            this.m_offscreensize = size;
            (this.m_offgraphics = this.m_offscreen.getGraphics()).setFont(this.getFont());
        }
        this.m_offgraphics.setColor(this.getBackground());
        this.m_offgraphics.fillRect(0, 0, size.width, size.height);
        for (int i = 0; i < this.m_nVEdges; ++i) {
            final VEdge vEdge = this.m_VEdges[i];
            final int x = this.m_VNodes[vEdge.m_from].m_x;
            final int y = this.m_VNodes[vEdge.m_from].m_y;
            final int x2 = this.m_VNodes[vEdge.m_to].m_x;
            final int y2 = this.m_VNodes[vEdge.m_to].m_y;
            this.m_offgraphics.setColor(vEdge.m_c);
            this.m_offgraphics.drawLine(x, y, x2, y2);
        }
        for (int j = 0; j < this.m_nVNodes; ++j) {
            this.paintVNode(this.m_offgraphics, this.m_VNodes[j]);
        }
        final FontMetrics fontMetrics = this.m_offgraphics.getFontMetrics();
        if (this.m_show != null) {
            this.m_offgraphics.setColor(Color.black);
            this.m_offgraphics.drawString(this.m_show.toString(), 10, size.height - fontMetrics.getHeight() + fontMetrics.getAscent());
        }
        graphics.drawImage(this.m_offscreen, 0, 0, null);
    }
    
    public void mousePressed(final MouseEvent mouseEvent) {
        int n = Integer.MAX_VALUE;
        final int x = mouseEvent.getX();
        final int y = mouseEvent.getY();
        for (int i = 0; i < this.m_nVNodes; ++i) {
            final VNode pick = this.m_VNodes[i];
            final int n2 = (pick.m_x - x) * (pick.m_x - x) + (pick.m_y - y) * (pick.m_y - y);
            if (n2 < n) {
                this.m_pick = pick;
                n = n2;
            }
        }
        if (n > 200) {
            this.m_pick = null;
        }
        else {
            this.m_pick.m_x = x;
            this.m_pick.m_y = y;
        }
        this.repaint();
        mouseEvent.consume();
    }
    
    public void mouseReleased(final MouseEvent mouseEvent) {
        try {
            if (System.currentTimeMillis() - this.m_lastMD < 500L) {
                new NodeViewer(this.m_pick.m_node, this.m_rete);
                this.m_lastMD = 0L;
                return;
            }
            if (this.m_pick != null) {
                this.m_pick.m_x = mouseEvent.getX();
                this.m_pick.m_y = mouseEvent.getY();
                this.m_lastMD = System.currentTimeMillis();
            }
        }
        finally {
            this.m_pick = null;
            this.repaint();
            mouseEvent.consume();
        }
        this.m_pick = null;
        this.repaint();
        mouseEvent.consume();
    }
    
    public void mouseDragged(final MouseEvent mouseEvent) {
        if (this.m_pick != null) {
            this.m_pick.m_x = mouseEvent.getX();
            this.m_pick.m_y = mouseEvent.getY();
            this.repaint();
        }
        mouseEvent.consume();
    }
    
    public void mouseMoved(final MouseEvent mouseEvent) {
        int n = Integer.MAX_VALUE;
        final int x = mouseEvent.getX();
        final int y = mouseEvent.getY();
        Node node = null;
        for (int i = 0; i < this.m_nVNodes; ++i) {
            final VNode vNode = this.m_VNodes[i];
            final int n2 = (vNode.m_x - x) * (vNode.m_x - x) + (vNode.m_y - y) * (vNode.m_y - y);
            if (n2 < n) {
                node = vNode.m_node;
                n = n2;
            }
        }
        if (n > 200) {
            this.m_show = null;
        }
        else {
            this.m_show = node;
        }
        this.repaint();
    }
    
    public void mouseClicked(final MouseEvent mouseEvent) {
    }
    
    public void mouseEntered(final MouseEvent mouseEvent) {
    }
    
    public void mouseExited(final MouseEvent mouseEvent) {
    }
    
    private final void buildNetwork(final Node node, final int n) {
        final Enumeration successors = node.getSuccessors();
        while (successors.hasMoreElements()) {
            final Node node2 = successors.nextElement();
            if (this.m_haslhs != null && !this.ruleContains(node2)) {
                continue;
            }
            this.addVEdge(node, node2, n, this.getEdgeColor(node));
            this.buildNetwork(node2, n + 1);
        }
    }
    
    private final boolean ruleContains(final Node node) {
        final ArrayList nodes = this.m_haslhs.getNodes();
        for (int i = 0; i < nodes.size(); ++i) {
            if (nodes.get(i) == node) {
                return true;
            }
        }
        return false;
    }
    
    public void init() {
        this.m_VNodes = new VNode[10];
        this.m_VEdges = new VEdge[10];
        final int n = 0;
        this.m_nVEdges = n;
        this.m_nVNodes = n;
        this.m_pick = null;
        this.m_show = null;
        for (int i = 0; i < this.m_nextSlot.length; ++i) {
            this.m_nextSlot[i] = 0;
        }
        this.buildNetwork(this.m_rete.getCompiler().getRoot(), 1);
        this.repaint();
    }
    
    public void eventHappened(final JessEvent jessEvent) {
        if ((jessEvent.getType() & 0x1) != 0x0 || jessEvent.getType() == 2048) {
            if (this.m_haslhs != null) {
                this.m_haslhs = this.m_rete.findDefrule(this.m_haslhs.getName());
            }
            this.init();
        }
    }
    
    static /* synthetic */ Class class$(final String s, final boolean b) {
        try {
            final Class<?> forName = Class.forName(s);
            if (!b) {
                forName.getComponentType();
            }
            return forName;
        }
        catch (ClassNotFoundException ex) {
            throw new NoClassDefFoundError(ex.getMessage());
        }
    }
    
    private final /* synthetic */ void this() {
        this.m_nextSlot = new int[100];
        this.m_edgeColors = new Color[] { Color.green, Color.blue };
    }
    
    Graph(final Rete rete, final HasLHS haslhs) {
        this.this();
        this.m_rete = rete;
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.setSize(500, 500);
        this.m_haslhs = haslhs;
        this.init();
    }
    
    static {
        m_selectColor = Color.pink;
        Graph.m_colors = new HashMap();
        final HashMap colors = Graph.m_colors;
        Class class$jess$Node1;
        if ((class$jess$Node1 = Graph.class$jess$Node1) == null) {
            class$jess$Node1 = (Graph.class$jess$Node1 = class$("[Ljess.Node1;", false));
        }
        colors.put(class$jess$Node1, Color.red);
        final HashMap colors2 = Graph.m_colors;
        Class class$jess$Node1LTR;
        if ((class$jess$Node1LTR = Graph.class$jess$Node1LTR) == null) {
            class$jess$Node1LTR = (Graph.class$jess$Node1LTR = class$("[Ljess.Node1LTR;", false));
        }
        colors2.put(class$jess$Node1LTR, Color.orange);
        final HashMap colors3 = Graph.m_colors;
        Class class$jess$Node1RTL;
        if ((class$jess$Node1RTL = Graph.class$jess$Node1RTL) == null) {
            class$jess$Node1RTL = (Graph.class$jess$Node1RTL = class$("[Ljess.Node1RTL;", false));
        }
        colors3.put(class$jess$Node1RTL, Color.orange);
        final HashMap colors4 = Graph.m_colors;
        Class class$jess$Node2;
        if ((class$jess$Node2 = Graph.class$jess$Node2) == null) {
            class$jess$Node2 = (Graph.class$jess$Node2 = class$("[Ljess.Node2;", false));
        }
        colors4.put(class$jess$Node2, Color.green);
        final HashMap colors5 = Graph.m_colors;
        Class class$jess$NodeNot2;
        if ((class$jess$NodeNot2 = Graph.class$jess$NodeNot2) == null) {
            class$jess$NodeNot2 = (Graph.class$jess$NodeNot2 = class$("[Ljess.NodeNot2;", false));
        }
        colors5.put(class$jess$NodeNot2, Color.yellow);
        final HashMap colors6 = Graph.m_colors;
        Class class$jess$NodeNot2Single;
        if ((class$jess$NodeNot2Single = Graph.class$jess$NodeNot2Single) == null) {
            class$jess$NodeNot2Single = (Graph.class$jess$NodeNot2Single = class$("[Ljess.NodeNot2Single;", false));
        }
        colors6.put(class$jess$NodeNot2Single, Color.yellow);
        final HashMap colors7 = Graph.m_colors;
        Class class$jess$NodeJoin;
        if ((class$jess$NodeJoin = Graph.class$jess$NodeJoin) == null) {
            class$jess$NodeJoin = (Graph.class$jess$NodeJoin = class$("[Ljess.NodeJoin;", false));
        }
        colors7.put(class$jess$NodeJoin, Color.blue);
        final HashMap colors8 = Graph.m_colors;
        Class class$jess$Defrule;
        if ((class$jess$Defrule = Graph.class$jess$Defrule) == null) {
            class$jess$Defrule = (Graph.class$jess$Defrule = class$("[Ljess.Defrule;", false));
        }
        colors8.put(class$jess$Defrule, Color.cyan);
    }
}
