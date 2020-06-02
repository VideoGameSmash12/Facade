package TemplateCompiler;

import java.util.StringTokenizer;
import java.util.Vector;

public class SearchUnit
{
    public static String getfirst(final String s) {
        return s.substring(0, s.indexOf(" "));
    }
    
    public static String getlast(final String s) {
        return s.substring(s.lastIndexOf(" ") + 1, s.length());
    }
    
    public static int[] TermExpander(String s, final String s2, final int n) {
        s = s.trim();
        s += ' ';
        final Vector vector = new Vector<Integer>();
        int n2 = 1;
        int n3 = -1;
        while (true) {
            final int index = s.indexOf(" ", n3 + 1);
            if (index == -1) {
                break;
            }
            if (WordNet.IsLinkedJava(s2, s.substring(n3 + 1, index), n)) {
                vector.addElement(new Integer(n2));
            }
            n3 = index;
            ++n2;
        }
        final Object[] array = vector.toArray();
        final int[] array2 = new int[array.length];
        for (int i = 0; i < array.length; ++i) {
            array2[i] = (int)array[i];
        }
        return array2;
    }
    
    public static int[] Search(final String s, final String s2) {
        final Vector vector = new Vector<Integer>();
        int n = 0;
        final StringTokenizer stringTokenizer = new StringTokenizer(s);
        while (stringTokenizer.hasMoreTokens()) {
            ++n;
            if (stringTokenizer.nextToken().equals(s2)) {
                System.out.println(s2 + ' ' + n);
                vector.addElement(new Integer(n));
            }
        }
        final Object[] array = vector.toArray();
        final int[] array2 = new int[array.length];
        for (int i = 0; i < array.length; ++i) {
            array2[i] = (int)array[i];
        }
        return array2;
    }
    
    public static int IsThereWord(final String s, final int n) {
        int n2 = 1;
        int i = s.indexOf(" ");
        while (i != -1) {
            i = s.indexOf(" ", i + 1);
            ++n2;
            if (n == n2) {
                return 0;
            }
        }
        return -1;
    }
    
    public static int NumWords(final String s) {
        int n = 1;
        for (int i = s.indexOf(" "); i != -1; i = s.indexOf(" ", i + 1), ++n) {}
        return n;
    }
}
