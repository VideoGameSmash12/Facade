package facade.characters.wmedef;

import facade.util.PrintUtilities;
import javax.swing.JComboBox;
import wm.WMEFieldEditor;
import facade.util.DAType;
import wm.TimeStampedWME;

public class PlayerGestureWME extends TimeStampedWME implements DAType
{
    private int playerGestureID;
    private int objectID;
    private int param;
    
    public synchronized int getPlayerGestureID() {
        return this.playerGestureID;
    }
    
    public synchronized int getObjectID() {
        return this.objectID;
    }
    
    public synchronized int getParam() {
        return this.param;
    }
    
    public synchronized void setPlayerGestureID(final int playerGestureID) {
        this.playerGestureID = playerGestureID;
    }
    
    public synchronized void setObjectID(final int objectID) {
        this.objectID = objectID;
    }
    
    public synchronized void setParam(final int param) {
        this.param = param;
    }
    
    public WMEFieldEditor _getObjectIDEditor() {
        return new ObjectIDEditor();
    }
    
    public WMEFieldEditor _getPlayerGestureIDEditor() {
        return new PlayerGestureIDEditor();
    }
    
    public PlayerGestureWME(final int playerGestureID, final int objectID, final int param) {
        this.playerGestureID = playerGestureID;
        this.objectID = objectID;
        this.param = param;
    }
    
    public PlayerGestureWME() {
    }
    
    private class ObjectIDEditor extends JComboBox implements WMEFieldEditor
    {
        public String getFieldValue() {
            return Integer.toString(PrintUtilities.spriteID_StringToEnum((String)this.getSelectedItem()));
        }
        
        public void setFieldValue(final String s) {
            this.setSelectedItem(PrintUtilities.spriteID_EnumToString(Integer.parseInt(s)));
        }
        
        ObjectIDEditor() {
            super(PrintUtilities.spriteID_GetCharacterEnumArray());
            this.setEditable(false);
            this.setSelectedItem(PrintUtilities.spriteID_EnumToString(PlayerGestureWME.this.getObjectID()));
        }
    }
    
    private class PlayerGestureIDEditor extends JComboBox implements WMEFieldEditor
    {
        public String getFieldValue() {
            return Integer.toString(PrintUtilities.playerGesture_StringToEnum((String)this.getSelectedItem()));
        }
        
        public void setFieldValue(final String s) {
            this.setSelectedItem(PrintUtilities.playerGesture_EnumToString(Integer.parseInt(s)));
        }
        
        PlayerGestureIDEditor() {
            super(PrintUtilities.playerGesture_GetEnumArray());
            this.setEditable(false);
            this.setSelectedItem(PrintUtilities.playerGesture_EnumToString(PlayerGestureWME.this.getObjectID()));
        }
    }
}
