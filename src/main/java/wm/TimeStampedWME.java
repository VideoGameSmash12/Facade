package wm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.JComboBox;
import java.util.Date;
import java.text.SimpleDateFormat;

public abstract class TimeStampedWME extends WME implements Comparable
{
    private static final SimpleDateFormat formatter;
    private static final String[] menuItems;
    private long timestamp;
    
    public synchronized long getTimestamp() {
        return this.timestamp;
    }
    
    public synchronized void setTimestamp(final long timestamp) {
        this.timestamp = timestamp;
    }
    
    public synchronized String formatTimestamp() {
        return TimeStampedWME.formatter.format(new Date(this.getTimestamp()));
    }
    
    public WMEFieldEditor _getTimestampEditor() {
        return new TimestampEditor();
    }
    
    public int compareTo(final Object o) {
        final TimeStampedWME timeStampedWME = (TimeStampedWME)o;
        if (this.getTimestamp() < timeStampedWME.getTimestamp()) {
            return -1;
        }
        if (this.getTimestamp() > timeStampedWME.getTimestamp()) {
            return 1;
        }
        return 0;
    }
    
    public TimeStampedWME(final long timestamp) {
        this.timestamp = timestamp;
    }
    
    public TimeStampedWME() {
        this.timestamp = 0L;
    }
    
    static {
        formatter = new SimpleDateFormat("MM.dd.yyyy hh:mm:ss:S a");
        menuItems = new String[] { "Set current time" };
    }
    
    private class TimestampEditor extends JComboBox implements WMEFieldEditor
    {
        public String getFieldValue() {
            try {
                return Long.toString(TimeStampedWME.formatter.parse(this.getSelectedItem().toString()).getTime());
            }
            catch (ParseException ex) {
                System.err.println("Parse error: " + ex.getMessage() + " in TimestampEditor.getTimeValue(). Returning null.");
                return null;
            }
        }
        
        public void setFieldValue(final String s) {
            this.setSelectedItem(TimeStampedWME.formatter.format(new Date(Long.parseLong(s))));
        }
        
        TimestampEditor() {
            super(TimeStampedWME.menuItems);
            this.setEditable(true);
            if (TimeStampedWME.this.getTimestamp() != 0L) {
                this.setSelectedItem(TimeStampedWME.this.formatTimestamp());
            }
            else {
                this.setSelectedItem("");
            }
            this.addActionListener(new ActionListener() {
                public final void actionPerformed(final ActionEvent actionEvent) {
                    TimestampEditor.this.setFieldValue(Long.toString(System.currentTimeMillis()));
                }
            });
        }
    }
}
