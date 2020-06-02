package jess;

import java.io.Serializable;

public class Fact extends ValueVector implements Serializable, Modular
{
    public static final int NO = 0;
    public static final int DYNAMIC = 1;
    public static final int STATIC = 2;
    private static Fact s_nullFact;
    private static Fact s_initialFact;
    private static Fact s_clearFact;
    private int m_id;
    private Deftemplate m_deft;
    private int m_shadow;
    private String m_name;
    private Fact m_icon;
    private int m_time;
    
    public Fact getIcon() {
        return this.m_icon;
    }
    
    void setIcon(final Fact icon) {
        this.m_icon = icon;
    }
    
    static Fact getNullFact() {
        return Fact.s_nullFact;
    }
    
    static Fact getInitialFact() {
        return (Fact)Fact.s_initialFact.clone();
    }
    
    static Fact getClearFact() {
        return Fact.s_clearFact;
    }
    
    public String getName() {
        return this.m_name;
    }
    
    public int getFactId() {
        return this.m_id;
    }
    
    void setFactId(final int id) {
        this.m_id = id;
    }
    
    void setShadowMode(final int shadow) {
        this.m_shadow = shadow;
    }
    
    public boolean isShadow() {
        boolean b = false;
        if (this.m_shadow > 0) {
            b = true;
        }
        return b;
    }
    
    public int getShadowMode() {
        return this.m_shadow;
    }
    
    public final Deftemplate getDeftemplate() {
        return this.m_deft;
    }
    
    public final String getModule() {
        return this.m_deft.getModule();
    }
    
    public int getTime() {
        return this.m_time;
    }
    
    void updateTime(final int time) {
        this.m_time = time;
    }
    
    public Value get(final int n) throws JessException {
        if (n == -1) {
            return new FactIDValue(this);
        }
        return super.get(n);
    }
    
    public Object clone() {
        try {
            return new Fact(this);
        }
        catch (JessException ex) {
            return null;
        }
    }
    
    private final void createNewFact() throws JessException {
        final int nSlots = this.m_deft.getNSlots();
        this.setLength(nSlots);
        this.m_name = this.m_deft.getName();
        this.m_shadow = 0;
        for (int i = 0; i < nSlots; ++i) {
            this.set(this.m_deft.getSlotDefault(i), i);
        }
    }
    
    private final int findSlot(final String s) throws JessException {
        final int slotIndex = this.m_deft.getSlotIndex(s);
        if (slotIndex == -1) {
            throw new JessException("Fact.findSlot", "No slot " + s + " in deftemplate ", this.m_deft.getName());
        }
        return slotIndex;
    }
    
    public final Value getSlotValue(final String s) throws JessException {
        return this.get(this.findSlot(s));
    }
    
    public final void setSlotValue(final String s, final Value value) throws JessException {
        this.set(value, this.findSlot(s));
    }
    
    Fact expand(final Context context) throws JessException {
        final Fact fact = (Fact)this.clone();
        for (int i = 0; i < fact.size(); ++i) {
            Value resolveValue = fact.get(i).resolveValue(context);
            if (resolveValue.type() == 512) {
                final ValueVector valueVector = new ValueVector();
                final ValueVector listValue = resolveValue.listValue(context);
                for (int j = 0; j < listValue.size(); ++j) {
                    final Value resolveValue2 = listValue.get(j).resolveValue(context);
                    if (resolveValue2.type() == 512) {
                        final ValueVector listValue2 = resolveValue2.listValue(context);
                        for (int k = 0; k < listValue2.size(); ++k) {
                            valueVector.add(listValue2.get(k).resolveValue(context));
                        }
                    }
                    else {
                        valueVector.add(resolveValue2);
                    }
                }
                resolveValue = new Value(valueVector, 512);
            }
            fact.set(resolveValue, i);
        }
        return fact;
    }
    
    List toList() {
        try {
            final List list = new List(this.m_name);
            final int size = this.size();
            if (size != 1 || !this.m_deft.getSlotName(0).equals("__data")) {
                for (int i = 0; i < size; ++i) {
                    list.add(new List(this.m_deft.getSlotName(i), this.get(i)));
                }
                return list;
            }
            if (this.get(0).type() != 512) {
                list.add(this.get(0));
                return list;
            }
            if (this.get(0).listValue(null).size() == 0) {
                return list;
            }
            list.add(this.get(0));
            return list;
        }
        catch (JessException ex) {
            return new List(ex.toString());
        }
    }
    
    public String toString() {
        return this.toList().toString();
    }
    
    public String toStringWithParens() {
        return this.toList().toString();
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof Fact && this.m_name.equals(((Fact)o).m_name) && super.equals(o));
    }
    
    public int hashCode() {
        int hashCode = this.m_name.hashCode();
        for (int i = 0; i < this.size(); ++i) {
            hashCode += this.m_v[i].hashCode();
        }
        return hashCode;
    }
    
    private final /* synthetic */ void this() {
        this.m_id = -1;
    }
    
    public Fact(final Deftemplate deft) throws JessException {
        this.this();
        this.m_deft = deft;
        this.createNewFact();
        this.m_time = 0;
        this.m_icon = this;
    }
    
    public Fact(final String s, final Rete rete) throws JessException {
        this.this();
        if (s.equals("not") || s.equals("test") || s.equals("explicit")) {
            throw new JessException("Fact.Fact", "Illegal fact name:", s);
        }
        this.m_deft = rete.createDeftemplate(s);
        this.createNewFact();
        this.m_time = rete.getTime();
        this.m_icon = this;
    }
    
    public Fact(final Fact fact) throws JessException {
        this.this();
        this.m_name = fact.m_name;
        this.m_deft = fact.m_deft;
        this.setLength(fact.size());
        for (int i = 0; i < this.size(); ++i) {
            this.set(fact.get(i), i);
        }
        this.m_time = fact.m_time;
        this.m_id = fact.m_id;
        this.m_icon = this;
    }
    
    static {
        try {
            Fact.s_nullFact = new Fact(Deftemplate.getNullTemplate());
            Fact.s_clearFact = new Fact(Deftemplate.getClearTemplate());
            Fact.s_initialFact = new Fact(Deftemplate.getInitialTemplate());
        }
        catch (JessException ex) {}
    }
}
