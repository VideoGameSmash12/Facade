package jd;

public abstract class JavaCodeDescriptor
{
    public abstract String toString();
    
    protected static String delimitedList(final Object[] array, final String s) {
        if (array.length == 0) {
            return "";
        }
        if (array.length == 1) {
            return (String)array[0];
        }
        final StringBuffer sb = new StringBuffer();
        for (int i = 0; i < array.length - 1; ++i) {
            sb.append((String)array[i] + s);
        }
        sb.append((String)array[array.length - 1]);
        return sb.toString();
    }
}
