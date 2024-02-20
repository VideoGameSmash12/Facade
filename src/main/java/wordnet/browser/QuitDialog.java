package wordnet.browser;

import java.awt.event.WindowEvent;
import java.awt.Window;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.Button;
import java.awt.Label;
import java.awt.Dialog;

public class QuitDialog extends Dialog
{
    Label label1;
    Button yesButton;
    Button noButton;
    
    public void setVisible(final boolean visible) {
        if (visible) {
            final Rectangle bounds = this.getParent().getBounds();
            final Rectangle bounds2 = this.getBounds();
            this.setLocation(bounds.x + (bounds.width - bounds2.width) / 2, bounds.y + (bounds.height - bounds2.height) / 2);
        }
        super.setVisible(visible);
    }
    
    public QuitDialog(final Frame frame, final boolean b) {
        super(frame, b);
        this.setTitle("Quit");
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(this.insets().left + this.insets().right + 337, this.insets().top + this.insets().bottom + 135);
        (this.label1 = new Label("Do you really want to quit?", 1)).setBounds(78, 33, 180, 23);
        this.add(this.label1);
        (this.yesButton = new Button(" Yes ")).setBounds(this.insets().left + 72, this.insets().top + 80, 79, 22);
        this.yesButton.setFont(new Font("Dialog", 1, 12));
        this.add(this.yesButton);
        (this.noButton = new Button("No")).setBounds(this.insets().left + 185, this.insets().top + 80, 79, 22);
        this.noButton.setFont(new Font("Dialog", 1, 12));
        this.add(this.noButton);
        this.noButton.addActionListener(new ActionListener() {
            public final void actionPerformed(final ActionEvent actionEvent) {
                QuitDialog.this.dispose();
            }
        });
        this.yesButton.addActionListener(new ActionListener() {
            public final void actionPerformed(final ActionEvent actionEvent) {
                Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(new WindowEvent((Window)QuitDialog.this.getParent(), 201));
            }
        });
    }
    
    public QuitDialog(final Frame frame, final String title, final boolean b) {
        this(frame, b);
        this.setTitle(title);
    }
}
