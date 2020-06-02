package jd;

public class MethodArgDescriptor extends JavaCodeDescriptor
{
    public String argType;
    public String argName;
    
    public String toString() {
        return this.argType + ' ' + this.argName;
    }
    
    public MethodArgDescriptor() {
        this.argType = null;
        this.argName = null;
    }
    
    public MethodArgDescriptor(final String argType, final String argName) {
        this.argType = argType;
        this.argName = argName;
    }
}
