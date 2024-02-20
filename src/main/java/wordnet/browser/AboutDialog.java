package wordnet.browser;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Button;
import java.awt.Component;
import java.awt.Label;
import java.awt.GridBagConstraints;
import java.awt.LayoutManager;
import java.awt.GridBagLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.Dialog;

public class AboutDialog extends Dialog
{
    protected static final String[] LABEL_TEXT;
    
    protected TextArea makeTextArea(final String[] array) {
        int max = 0;
        for (int i = 0; i < array.length; ++i) {
            max = Math.max(max, array[i].length());
        }
        final TextArea textArea = new TextArea("", array.length, max, 3);
        textArea.setEditable(false);
        for (int j = 0; j < array.length; ++j) {
            if (j > 0) {
                textArea.append("\n");
            }
            textArea.append(array[j]);
        }
        return textArea;
    }
    
    public AboutDialog(final Frame frame) {
        super(frame, true);
        this.setVisible(false);
        this.setTitle("About");
        this.setSize(300, 200);
        this.setLayout(new GridBagLayout());
        final GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        this.add(new Label("WordNet Browser"), gridBagConstraints);
        this.add(this.makeTextArea(AboutDialog.LABEL_TEXT), gridBagConstraints);
        final Button button = new Button("OK");
        this.add(button, gridBagConstraints);
        button.addActionListener(new ActionListener() {
            public final void actionPerformed(final ActionEvent actionEvent) {
                AboutDialog.this.setVisible(false);
                AboutDialog.this.dispose();
            }
        });
        final Rectangle bounds = this.getParent().bounds();
        final Rectangle bounds2 = this.bounds();
        this.move(bounds.x + (bounds.width - bounds2.width) / 2, bounds.y + (bounds.height - bounds2.height) / 2);
        this.invalidate();
        this.setVisible(true);
    }
    
    static {
        LABEL_TEXT = new String[] { "A graphical interface to the WordNet online lexical database.", "", "This Java version by Oliver Steele.", "", "The GUI is loosely based on the interface to the Tcl/Tk version by David Slomin." };
    }
}
