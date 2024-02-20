package jess;

import java.util.HashMap;
import java.util.Hashtable;
import java.io.Serializable;

public class Deftemplate implements Serializable, Visitable, Modular
{
    private static Hashtable s_types;
    private static final String[] s_typenames;
    private static final int[] s_typevals;
    private static Deftemplate s_rootTemplate;
    private static Deftemplate s_clearTemplate;
    private static Deftemplate s_nullTemplate;
    private static Deftemplate s_initialTemplate;
    private boolean m_backchain;
    private String m_baseName;
    private String m_fullName;
    private String m_docstring;
    private Deftemplate m_parent;
    ValueVector m_data;
    private HashMap m_indexes;
    private String m_module;
    
    public static Deftemplate getRootTemplate() {
        return Deftemplate.s_rootTemplate;
    }
    
    public static Deftemplate getInitialTemplate() {
        return Deftemplate.s_initialTemplate;
    }
    
    public static Deftemplate getClearTemplate() {
        return Deftemplate.s_clearTemplate;
    }
    
    public static Deftemplate getNullTemplate() {
        return Deftemplate.s_nullTemplate;
    }
    
    static void addStandardTemplates(final Rete rete) throws JessException {
        rete.addDeftemplate(getRootTemplate());
        rete.addDeftemplate(getNullTemplate());
        rete.addDeftemplate(getClearTemplate());
        rete.addDeftemplate(getInitialTemplate());
    }
    
    public boolean equals(final Object o) {
        if (!(o instanceof Deftemplate)) {
            return false;
        }
        final Deftemplate deftemplate = (Deftemplate)o;
        boolean b = false;
        if (this.m_fullName.equals(deftemplate.m_fullName) && this.m_backchain == deftemplate.m_backchain && this.m_parent == deftemplate.m_parent && this.m_data.equals(deftemplate.m_data)) {
            b = true;
        }
        return b;
    }
    
    public int hashCode() {
        return this.m_fullName.hashCode();
    }
    
    public Deftemplate getParent() {
        return this.m_parent;
    }
    
    public void forgetParent() {
        this.m_parent = null;
    }
    
    public final String getName() {
        return this.m_fullName;
    }
    
    public final String getBaseName() {
        return this.m_baseName;
    }
    
    public final String getDocstring() {
        return this.m_docstring;
    }
    
    public final void doBackwardChaining() {
        this.m_backchain = true;
    }
    
    public final boolean getBackwardChaining() {
        return this.m_backchain;
    }
    
    public void addSlot(final String s, final Value value, final String s2) throws JessException {
        final Value value2 = Deftemplate.s_types.get(s2.toUpperCase());
        if (value2 == null) {
            throw new JessException("Deftemplate.addSlot", "Bad slot type:", s2);
        }
        final int slotIndex;
        if ((slotIndex = this.getSlotIndex(s)) != -1) {
            this.m_data.set(value, slotIndex * 3 + 1);
            this.m_data.set(value2, slotIndex * 3 + 2);
        }
        else {
            final int size = this.m_data.size();
            this.m_data.setLength(size + 3);
            this.m_data.set(new Value(s, 16384), size);
            this.m_data.set(value, size + 1);
            this.m_data.set(value2, size + 2);
            this.m_indexes.put(s, new Integer(size / 3));
        }
    }
    
    public void addMultiSlot(final String s, final Value value) throws JessException {
        final int slotIndex;
        if ((slotIndex = this.getSlotIndex(s)) != -1) {
            this.m_data.set(value, this.absoluteIndex(slotIndex) + 1);
            return;
        }
        final int size = this.m_data.size();
        this.m_data.setLength(size + 3);
        this.m_data.set(new Value(s, 32768), size);
        this.m_data.set(value, size + 1);
        this.m_data.set(Deftemplate.s_types.get(Deftemplate.s_typenames[0]), size + 2);
        this.m_indexes.put(s, new Integer(size / 3));
    }
    
    private final int absoluteIndex(final int n) {
        return n * 3;
    }
    
    public int getSlotDataType(final int n) throws JessException {
        return this.m_data.get(this.absoluteIndex(n) + 2).intValue(null);
    }
    
    public Value getSlotDefault(final int n) throws JessException {
        return this.m_data.get(this.absoluteIndex(n) + 1);
    }
    
    public int getSlotType(final int n) throws JessException {
        return this.m_data.get(this.absoluteIndex(n)).type();
    }
    
    public int getSlotIndex(final String s) throws JessException {
        final Integer n = this.m_indexes.get(s);
        if (n == null) {
            return -1;
        }
        return n;
    }
    
    public String getSlotName(final int n) throws JessException {
        return this.m_data.get(this.absoluteIndex(n)).stringValue(null);
    }
    
    public int getNSlots() {
        return this.m_data.size() / 3;
    }
    
    public String toString() {
        return "[deftemplate " + this.m_fullName + ']';
    }
    
    public Object accept(final Visitor visitor) {
        return visitor.visitDeftemplate(this);
    }
    
    public String getModule() {
        return this.m_module;
    }
    
    public boolean isBackwardChainingTrigger() {
        return this.m_baseName.startsWith("need-");
    }
    
    public String getBackchainingTemplateName() {
        return RU.scopeName(this.m_module, "need-" + this.m_baseName);
    }
    
    public String getNameWithoutBackchainingPrefix() {
        if (!this.isBackwardChainingTrigger()) {
            return this.m_fullName;
        }
        return RU.scopeName(this.m_module, this.m_baseName.substring("need-".length()));
    }
    
    public Deftemplate getBackchainingTemplate(final Rete rete) throws JessException {
        return new Deftemplate(this.getBackchainingTemplateName(), "Goal seeker for " + this.m_fullName, this, rete);
    }
    
    private final /* synthetic */ void this() {
        this.m_docstring = "";
        this.m_data = new ValueVector();
    }
    
    public Deftemplate(final String s, final String s2, final Rete rete) throws JessException {
        this(s, s2, Deftemplate.s_rootTemplate, rete);
    }
    
    public Deftemplate(final String s, final String docstring, final Deftemplate parent, final Rete rete) throws JessException {
        this.this();
        final int index = s.indexOf("::");
        if (index != -1) {
            rete.verifyModule(this.m_module = s.substring(0, index));
            this.m_baseName = s.substring(index + 2);
            this.m_fullName = s;
        }
        else {
            this.m_module = rete.getCurrentModule();
            this.m_baseName = s;
            this.m_fullName = rete.resolveName(s);
        }
        this.m_parent = parent;
        this.m_docstring = docstring;
        for (int i = 0; i < parent.m_data.size(); ++i) {
            this.m_data.add(parent.m_data.get(i));
        }
        this.m_indexes = (HashMap)parent.m_indexes.clone();
    }
    
    private Deftemplate(final String baseName, final String docstring) {
        this.this();
        this.m_module = "MAIN";
        this.m_baseName = baseName;
        this.m_fullName = RU.scopeName(this.m_module, this.m_baseName);
        this.m_docstring = docstring;
        if (!baseName.equals("__fact")) {
            this.m_parent = Deftemplate.s_rootTemplate;
        }
        this.m_indexes = new HashMap();
    }
    
    static {
        Deftemplate.s_types = new Hashtable();
        s_typenames = new String[] { "ANY", "INTEGER", "FLOAT", "NUMBER", "ATOM", "STRING", "LEXEME", "OBJECT", "LONG" };
        s_typevals = new int[] { -1, 4, 32, 36, 1, 2, 3, 2048, 65536 };
        Deftemplate.s_rootTemplate = new Deftemplate("__fact", "Parent template");
        Deftemplate.s_clearTemplate = new Deftemplate("__clear", "(Implied)");
        Deftemplate.s_nullTemplate = new Deftemplate("__not_or_test_CE", "(Implied)");
        Deftemplate.s_initialTemplate = new Deftemplate("initial-fact", "(Implied)");
        try {
            for (int i = 0; i < Deftemplate.s_typenames.length; ++i) {
                Deftemplate.s_types.put(Deftemplate.s_typenames[i], new Value(Deftemplate.s_typevals[i], 4));
            }
        }
        catch (JessException ex) {}
    }
}
