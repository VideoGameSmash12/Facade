package wordnet.util;

public abstract class ArrayUtilities
{
    public static int indexOf(final Object[] array, final Object o) {
        for (int i = 0; i < array.length; ++i) {
            if (array[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }
}
