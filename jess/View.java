package jess;

import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Button;
import java.awt.Panel;
import java.awt.Component;
import java.awt.Frame;
import java.io.Serializable;

class View implements Userfunction, Serializable
{
    public String getName() {
        return "view";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        HasLHS defrule = null;
        if (valueVector.size() > 1) {
            defrule = context.getEngine().findDefrule(valueVector.get(1).stringValue(context));
            if (defrule == null) {
                throw new JessException("view", "No such rule or query", valueVector.get(1).stringValue(context));
            }
        }
        final Rete engine = context.getEngine();
        final Frame frame = new Frame("Network View");
        final Graph graph = new Graph(context.getEngine(), defrule);
        engine.setEventMask(engine.getEventMask() | 0x1);
        engine.addJessListener(graph);
        frame.add(graph, "Center");
        frame.setSize(500, 500);
        final Panel panel = new Panel();
        final Button button = new Button("Home");
        button.addActionListener(new ActionListener() {
            public final void actionPerformed(final ActionEvent actionEvent) {
                graph.init();
            }
        });
        panel.add(button);
        frame.add("South", panel);
        frame.addWindowListener(new WindowAdapter() {
            public final void windowClosing(final WindowEvent windowEvent) {
                frame.dispose();
                engine.removeJessListener(graph);
            }
        });
        frame.validate();
        frame.setVisible(true);
        return Funcall.TRUE;
    }
}
