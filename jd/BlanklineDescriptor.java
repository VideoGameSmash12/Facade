package jd;

public class BlanklineDescriptor extends CodeStringDescriptor
{
    public String toString(final int n) {
        return "";
    }
    
    public void setCodeString(final String s) {
        throw new JavaDescriptorError("setCodeString() should not be called on BlanklineDescriptor.");
    }
}
