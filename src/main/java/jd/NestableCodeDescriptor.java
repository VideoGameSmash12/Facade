package jd;

public abstract class NestableCodeDescriptor extends JavaCodeDescriptor
{
    private static final String tabSpaces = "   ";
    
    public abstract String toString(final int p0);
    
    public String toString() {
        return this.toString(0);
    }
    
    public static String leadingTabs(final int n) {
        final StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; ++i) {
            sb.append("   ");
        }
        return sb.toString();
    }
}
