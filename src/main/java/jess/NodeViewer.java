package jess;

import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.Frame;

class NodeViewer extends Frame implements JessListener
{
    private Node m_node;
    private Rete m_rete;
    private TextArea m_view;
    private TextArea m_events;
    
    void describeNode() {
        final StringBuffer sb = new StringBuffer();
        if (this.m_node instanceof Node1) {
            sb.append(this.m_node);
        }
        else if (this.m_node instanceof Node2) {
            sb.append(this.m_node);
            sb.append("\n");
            sb.append(((Node2)this.m_node).displayMemory());
        }
        else if (this.m_node instanceof NodeJoin) {
            sb.append(this.m_node);
        }
        else if (this.m_node instanceof HasLHS) {
            sb.append(new PrettyPrinter((Visitable)this.m_node).toString());
        }
        this.m_view.setText(sb.toString());
    }
    
    public void eventHappened(final JessEvent jessEvent) throws JessException {
        if (jessEvent.getSource() == this.m_node) {
            final Token token = (Token)jessEvent.getObject();
            final int type = jessEvent.getType();
            if (this.m_view != null) {
                this.m_events.append(type + ": " + token + '\n');
            }
        }
        this.describeNode();
    }
    
    NodeViewer(final Node node, final Rete rete) {
        super(node.toString());
        this.m_node = node;
        (this.m_rete = rete).store("NODE", this.m_node);
        this.m_view = new TextArea(40, 20);
        this.m_events = new TextArea(40, 20);
        this.m_view.setEditable(false);
        this.m_events.setEditable(false);
        final Panel panel = new Panel();
        panel.setLayout(new GridLayout(2, 1));
        panel.add(this.m_view);
        panel.add(this.m_events);
        this.addWindowListener(new WindowAdapter() {
            public final void windowClosing(final WindowEvent windowEvent) {
                NodeViewer.this.dispose();
                NodeViewer.this.m_node.removeJessListener(NodeViewer.this);
            }
        });
        this.add(panel, "Center");
        this.describeNode();
        this.setSize(600, 600);
        this.validate();
        this.show();
        this.m_node.addJessListener(this);
        this.m_rete.addJessListener(this);
        this.m_rete.setEventMask(this.m_rete.getEventMask() | 0x1 | 0x800);
    }
}
