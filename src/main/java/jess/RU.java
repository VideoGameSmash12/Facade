package jess;

import java.util.Hashtable;
import java.io.Serializable;

public class RU implements Serializable
{
    public static final int DT_SLOT_NAME = 0;
    public static final int DT_DFLT_DATA = 1;
    public static final int DT_DATA_TYPE = 2;
    public static final int DT_SLOT_SIZE = 3;
    public static final int NONE = 0;
    public static final int ATOM = 1;
    public static final int STRING = 2;
    public static final int INTEGER = 4;
    public static final int VARIABLE = 8;
    public static final int FACT = 16;
    public static final int FLOAT = 32;
    public static final int FUNCALL = 64;
    public static final int LIST = 512;
    public static final int EXTERNAL_ADDRESS = 2048;
    public static final int BINDING = 4096;
    public static final int MULTIVARIABLE = 8192;
    public static final int SLOT = 16384;
    public static final int MULTISLOT = 32768;
    public static final int LONG = 65536;
    private static Hashtable m_typeNames;
    static final int ADD = 0;
    static final int REMOVE = 1;
    static final int UPDATE = 2;
    static final int CLEAR = 3;
    public static final int PATTERN = -1;
    public static final int LOCAL = -2;
    public static final int GLOBAL = -3;
    static final int AND = 1;
    static final int OR = 2;
    static final String BACKCHAIN_PREFIX = "need-";
    static final String DEFAULT_SLOT_NAME = "__data";
    static final String ROOT_DEFTEMPLATE = "__fact";
    static int s_gensymIdx;
    
    public static String getTypeName(final int n) {
        return RU.m_typeNames.get(String.valueOf(n));
    }
    
    public static synchronized String gensym(final String s) {
        return s + RU.s_gensymIdx++;
    }
    
    public static String getProperty(final String s) {
        try {
            return System.getProperty(s);
        }
        catch (SecurityException ex) {
            return null;
        }
    }
    
    static String scopeName(final String s, final String s2) {
        final StringBuffer sb = new StringBuffer(s);
        sb.append("::");
        sb.append(s2);
        return sb.toString();
    }
    
    static String getModuleFromName(final String s, final Rete rete) {
        final int index = s.indexOf("::");
        if (index == -1) {
            return rete.getCurrentModule();
        }
        return s.substring(0, index);
    }
    
    static long time() {
        return System.currentTimeMillis();
    }
    
    private RU() {
    }
    
    static {
        (RU.m_typeNames = new Hashtable()).put(String.valueOf(0), "NONE");
        RU.m_typeNames.put(String.valueOf(1), "ATOM");
        RU.m_typeNames.put(String.valueOf(2), "STRING");
        RU.m_typeNames.put(String.valueOf(4), "INTEGER");
        RU.m_typeNames.put(String.valueOf(8), "VARIABLE");
        RU.m_typeNames.put(String.valueOf(16), "FACT");
        RU.m_typeNames.put(String.valueOf(32), "FLOAT");
        RU.m_typeNames.put(String.valueOf(64), "FUNCALL");
        RU.m_typeNames.put(String.valueOf(512), "LIST");
        RU.m_typeNames.put(String.valueOf(2048), "EXTERNAL_ADDRESS");
        RU.m_typeNames.put(String.valueOf(4096), "BINDING");
        RU.m_typeNames.put(String.valueOf(8192), "MULTIVARIABLE");
        RU.m_typeNames.put(String.valueOf(16384), "SLOT");
        RU.m_typeNames.put(String.valueOf(32768), "MULTISLOT");
        RU.m_typeNames.put(String.valueOf(65536), "LONG");
        RU.s_gensymIdx = 0;
    }
}
