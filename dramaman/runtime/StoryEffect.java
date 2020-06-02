package dramaman.runtime;

public class StoryEffect
{
    private String valueName;
    private float valueChange;
    private boolean isAbsolute;
    
    public String getValueName() {
        return this.valueName;
    }
    
    public float getValueChange() {
        return this.valueChange;
    }
    
    public boolean getIsAbsolute() {
        return this.isAbsolute;
    }
    
    public String getValueWMEName() {
        return DramaManager.getDramaManager().getStoryValueWMEName(this.valueName);
    }
    
    public String toString() {
        return "(" + this.valueName + ", " + this.valueChange + ", " + this.isAbsolute + ')';
    }
    
    public StoryEffect(final String valueName, final float valueChange, final boolean isAbsolute) {
        this.valueName = valueName;
        this.valueChange = valueChange;
        this.isAbsolute = isAbsolute;
    }
}
