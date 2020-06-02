package facade.characters.wmedef;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.JComboBox;
import wm.WMEFieldEditor;
import facade.util.PrintUtilities;
import java.util.Date;
import java.text.SimpleDateFormat;
import facade.util.DAType;
import wm.WME;

public class DAWME extends WME implements DAType
{
    private static final SimpleDateFormat formatter;
    private static final String[] timestampEditorMenuItems;
    private int id;
    private int charID;
    private int param1;
    private int param2;
    private int param3;
    private long timestamp;
    private int handledStatus;
    
    public synchronized int getId() {
        return this.id;
    }
    
    public synchronized int getCharID() {
        return this.charID;
    }
    
    public synchronized int getParam1() {
        return this.param1;
    }
    
    public synchronized int getParam2() {
        return this.param2;
    }
    
    public synchronized int getParam3() {
        return this.param3;
    }
    
    public synchronized long getTimestamp() {
        return this.timestamp;
    }
    
    public synchronized int getHandledStatus() {
        return this.handledStatus;
    }
    
    public synchronized void setId(final int id) {
        this.id = id;
    }
    
    public synchronized void setCharID(final int charID) {
        this.charID = charID;
    }
    
    public synchronized void setParam1(final int param1) {
        this.param1 = param1;
    }
    
    public synchronized void setParam2(final int param2) {
        this.param2 = param2;
    }
    
    public synchronized void setParam3(final int param3) {
        this.param3 = param3;
    }
    
    public synchronized void setTimestamp(final long timestamp) {
        this.timestamp = timestamp;
    }
    
    public synchronized void setHandledStatus(final int handledStatus) {
        this.handledStatus = handledStatus;
    }
    
    public synchronized String formatTimestamp() {
        return DAWME.formatter.format(new Date(this.getTimestamp()));
    }
    
    public synchronized String formatHandledStatus() {
        return PrintUtilities.daHandledStatus_EnumToString(this.getHandledStatus());
    }
    
    public synchronized String formatId() {
        return PrintUtilities.daType_EnumToString(this.getId());
    }
    
    public synchronized String formatCharID() {
        return PrintUtilities.spriteID_EnumToString(this.getCharID());
    }
    
    public synchronized String formatParam1() {
        return PrintUtilities.daParam1_EnumToString(this.getParam1());
    }
    
    public synchronized String formatParam2() {
        return PrintUtilities.daParam2_EnumToString(this.getParam2());
    }
    
    public synchronized String formatParam3() {
        return PrintUtilities.daParam3_EnumToString(this.getParam3());
    }
    
    public WMEFieldEditor _getTimestampEditor() {
        return new TimestampEditor();
    }
    
    public WMEFieldEditor _getHandledStatusEditor() {
        return new HandledStatusEditor();
    }
    
    public WMEFieldEditor _getIdEditor() {
        return new IDEditor();
    }
    
    public WMEFieldEditor _getCharIDEditor() {
        return new CharIDEditor();
    }
    
    public WMEFieldEditor _getParam1Editor() {
        return new Param1Editor();
    }
    
    public WMEFieldEditor _getParam3Editor() {
        return new Param3Editor();
    }
    
    public DAWME(final int id, final int charID, final int param1, final int param2, final int param3, final long timestamp) {
        this.id = id;
        this.charID = charID;
        this.param1 = param1;
        this.param2 = param2;
        this.param3 = param3;
        this.timestamp = timestamp;
        this.handledStatus = 0;
    }
    
    public DAWME(final int id, final int charID, final int param1, final int param2, final int param3, final long timestamp, final int handledStatus) {
        this.id = id;
        this.charID = charID;
        this.param1 = param1;
        this.param2 = param2;
        this.param3 = param3;
        this.timestamp = timestamp;
        this.handledStatus = handledStatus;
    }
    
    public DAWME() {
    }
    
    static {
        formatter = new SimpleDateFormat("MM.dd.yyyy hh:mm:ss:S a");
        timestampEditorMenuItems = new String[] { "Set current time" };
    }
    
    private class TimestampEditor extends JComboBox implements WMEFieldEditor
    {
        public String getFieldValue() {
            try {
                return Long.toString(DAWME.formatter.parse(this.getSelectedItem().toString()).getTime());
            }
            catch (ParseException ex) {
                System.err.println("Parse error: " + ex.getMessage() + " in TimestampEditor.getTimeValue(). Returning null.");
                return null;
            }
        }
        
        public void setFieldValue(final String s) {
            this.setSelectedItem(DAWME.formatter.format(new Date(Long.parseLong(s))));
        }
        
        TimestampEditor() {
            super(DAWME.timestampEditorMenuItems);
            this.setEditable(true);
            if (DAWME.this.getTimestamp() != 0L) {
                this.setSelectedItem(DAWME.this.formatTimestamp());
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
    
    private class HandledStatusEditor extends JComboBox implements WMEFieldEditor
    {
        public String getFieldValue() {
            return Integer.toString(PrintUtilities.daHandledStatus_StringToEnum((String)this.getSelectedItem()));
        }
        
        public void setFieldValue(final String s) {
            this.setSelectedItem(PrintUtilities.daHandledStatus_EnumToString(Integer.parseInt(s)));
        }
        
        HandledStatusEditor() {
            super(PrintUtilities.daHandledStatus_GetEnumArray());
            this.setEditable(false);
            this.setSelectedItem(PrintUtilities.daHandledStatus_EnumToString(DAWME.this.getHandledStatus()));
        }
    }
    
    private class IDEditor extends JComboBox implements WMEFieldEditor
    {
        public String getFieldValue() {
            return Integer.toString(PrintUtilities.daType_StringToEnum((String)this.getSelectedItem()));
        }
        
        public void setFieldValue(final String s) {
            this.setSelectedItem(PrintUtilities.daType_EnumToString(Integer.parseInt(s)));
        }
        
        IDEditor() {
            super(PrintUtilities.daType_GetEnumArray());
            this.setEditable(false);
            this.setSelectedItem(PrintUtilities.daType_EnumToString(DAWME.this.getId()));
        }
    }
    
    private class CharIDEditor extends JComboBox implements WMEFieldEditor
    {
        public String getFieldValue() {
            return Integer.toString(PrintUtilities.spriteID_StringToEnum((String)this.getSelectedItem()));
        }
        
        public void setFieldValue(final String s) {
            this.setSelectedItem(PrintUtilities.spriteID_EnumToString(Integer.parseInt(s)));
        }
        
        CharIDEditor() {
            super(PrintUtilities.spriteID_GetCharacterEnumArray());
            this.setEditable(false);
            this.setSelectedItem(PrintUtilities.spriteID_EnumToString(DAWME.this.getCharID()));
        }
    }
    
    private class Param1Editor extends JComboBox implements WMEFieldEditor
    {
        public String getFieldValue() {
            return Integer.toString(PrintUtilities.daParam1_StringToEnum((String)this.getSelectedItem()));
        }
        
        public void setFieldValue(final String s) {
            this.setSelectedItem(PrintUtilities.daParam1_EnumToString(Integer.parseInt(s)));
        }
        
        Param1Editor() {
            super(PrintUtilities.daParam1_GetEnumArray());
            this.setEditable(false);
            this.setSelectedItem(PrintUtilities.daParam1_EnumToString(DAWME.this.getParam1()));
        }
    }
    
    private class Param2Editor extends JComboBox implements WMEFieldEditor
    {
        public String getFieldValue() {
            return Integer.toString(PrintUtilities.daParam2_StringToEnum((String)this.getSelectedItem()));
        }
        
        public void setFieldValue(final String s) {
            this.setSelectedItem(PrintUtilities.daParam2_EnumToString(Integer.parseInt(s)));
        }
        
        Param2Editor() {
            super(PrintUtilities.daParam2_GetEnumArray());
            this.setEditable(false);
            this.setSelectedItem(PrintUtilities.daParam2_EnumToString(DAWME.this.getParam2()));
        }
    }
    
    private class Param3Editor extends JComboBox implements WMEFieldEditor
    {
        public String getFieldValue() {
            return Integer.toString(PrintUtilities.daParam3_StringToEnum((String)this.getSelectedItem()));
        }
        
        public void setFieldValue(final String s) {
            this.setSelectedItem(PrintUtilities.daParam3_EnumToString(Integer.parseInt(s)));
        }
        
        Param3Editor() {
            super(PrintUtilities.daParam3_GetEnumArray());
            this.setEditable(false);
            this.setSelectedItem(PrintUtilities.daParam3_EnumToString(DAWME.this.getParam3()));
        }
    }
}
