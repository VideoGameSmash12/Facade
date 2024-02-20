package jess;

import java.io.Serializable;

public class BindingValue extends Value implements Serializable
{
    private String m_name;
    private int m_factNumber;
    private int m_slotIndex;
    private int m_subIndex;
    private int m_type;
    private LHSComponent m_pattern;
    
    public void resetFactNumber() {
        this.m_factNumber = 0;
    }
    
    public String getName() {
        return this.m_name;
    }
    
    public int getFactNumber() {
        return this.m_factNumber;
    }
    
    public int getSlotIndex() {
        return this.m_slotIndex;
    }
    
    public int getSubIndex() {
        return this.m_subIndex;
    }
    
    public int getType() {
        return this.m_type;
    }
    
    LHSComponent getCE() {
        return this.m_pattern;
    }
    
    public Value resolveValue(final Context context) throws JessException {
        if (context == null) {
            throw new JessException("BindingValue.resolveValue", "Null context ", "");
        }
        final Token token = context.getToken();
        Fact fact;
        if (token == null || this.m_factNumber == token.size()) {
            fact = context.getFact();
        }
        else {
            fact = token.fact(this.m_factNumber);
        }
        final Value value = fact.get(this.m_slotIndex);
        if (this.m_subIndex == -1) {
            return value;
        }
        return value.listValue(null).get(this.m_subIndex);
    }
    
    public final Object externalAddressValue(final Context context) throws JessException {
        return this.resolveValue(context).externalAddressValue(context);
    }
    
    public final Fact factValue(final Context context) throws JessException {
        return this.resolveValue(context).factValue(context);
    }
    
    public final ValueVector listValue(final Context context) throws JessException {
        return this.resolveValue(context).listValue(context);
    }
    
    public final int intValue(final Context context) throws JessException {
        return this.resolveValue(context).intValue(context);
    }
    
    public final double floatValue(final Context context) throws JessException {
        return this.resolveValue(context).floatValue(context);
    }
    
    public final double numericValue(final Context context) throws JessException {
        return this.resolveValue(context).numericValue(context);
    }
    
    public final String atomValue(final Context context) throws JessException {
        return this.resolveValue(context).atomValue(context);
    }
    
    public final String variableValue(final Context context) throws JessException {
        return super.stringValue(context);
    }
    
    public final String stringValue(final Context context) throws JessException {
        return this.resolveValue(context).stringValue(context);
    }
    
    public String toString() {
        return "?" + this.m_name;
    }
    
    public int hashCode() {
        return this.m_factNumber + 512 * this.m_slotIndex + 262144 * this.m_subIndex;
    }
    
    public boolean equals(final Value value) {
        if (!(value instanceof BindingValue)) {
            return false;
        }
        final BindingValue bindingValue = (BindingValue)value;
        boolean b = false;
        if (this.m_factNumber == bindingValue.m_factNumber && this.m_slotIndex == bindingValue.m_slotIndex && this.m_subIndex == bindingValue.m_subIndex) {
            b = true;
        }
        return b;
    }
    
    BindingValue(final String name, final LHSComponent pattern, final int factNumber, final int slotIndex, final int subIndex, final int type) throws JessException {
        this.m_name = name;
        this.m_pattern = pattern;
        this.m_factNumber = factNumber;
        this.m_slotIndex = slotIndex;
        this.m_subIndex = subIndex;
        this.m_type = type;
    }
    
    BindingValue(final BindingValue bindingValue) {
        super(bindingValue);
        this.m_name = bindingValue.m_name;
        this.m_factNumber = bindingValue.m_factNumber;
        this.m_slotIndex = bindingValue.m_slotIndex;
        this.m_subIndex = bindingValue.m_subIndex;
        this.m_type = bindingValue.m_type;
        this.m_pattern = bindingValue.m_pattern;
    }
}
