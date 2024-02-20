package jess;

import java.util.Map;
import java.io.Serializable;

public class Pattern implements ConditionalElement, LHSComponent, Serializable, Visitable
{
    private static final int INITSIZE = 1;
    private Deftemplate m_deft;
    private Test1[][] m_tests;
    private int[] m_slotLengths;
    private boolean m_negated;
    private boolean m_logical;
    private boolean m_explicit;
    private String m_name;
    private String m_boundName;
    
    public Object clone() {
        try {
            final Pattern pattern = (Pattern)super.clone();
            if (this.m_slotLengths != null) {
                pattern.m_slotLengths = this.m_slotLengths.clone();
            }
            if (this.m_tests != null) {
                pattern.m_tests = this.m_tests.clone();
            }
            for (int i = 0; i < this.m_tests.length; ++i) {
                if (this.m_tests[i] != null) {
                    pattern.m_tests[i] = this.m_tests[i].clone();
                    for (int j = 0; j < this.m_tests[i].length; ++j) {
                        pattern.m_tests[i][j] = (Test1)this.m_tests[i][j].clone();
                    }
                }
            }
            return pattern;
        }
        catch (CloneNotSupportedException ex) {
            return null;
        }
    }
    
    public void setSlotLength(final String s, final int n) throws JessException {
        final int slotIndex = this.m_deft.getSlotIndex(s);
        if (slotIndex == -1) {
            throw new JessException("Pattern.setSlotLength", "No such slot " + s + " in template", this.m_deft.getName());
        }
        this.m_slotLengths[slotIndex] = n;
    }
    
    public void addTest(final String s, final Test1 test1) throws JessException {
        final int slotIndex = this.m_deft.getSlotIndex(s);
        if (slotIndex == -1) {
            throw new JessException("Pattern.addTest", "No such slot " + s + " in template ", this.m_deft.getName());
        }
        if (this.m_tests[slotIndex] == null) {
            this.m_tests[slotIndex] = new Test1[1];
        }
        int n;
        for (n = 0; n < this.m_tests[slotIndex].length && this.m_tests[slotIndex][n] != null; ++n) {}
        if (n == this.m_tests[slotIndex].length) {
            final Test1[] array = new Test1[n + 1];
            System.arraycopy(this.m_tests[slotIndex], 0, array, 0, n);
            this.m_tests[slotIndex] = array;
        }
        if (n > 0 && this.m_tests[slotIndex][n - 1].m_subIdx > test1.m_subIdx) {
            throw new JessException("Pattern.addTest", "Attempt to add out-of-order test: index ", this.m_tests[slotIndex][n - 1].m_subIdx + " > " + test1.m_subIdx);
        }
        this.m_tests[slotIndex][n] = test1;
    }
    
    void replaceTests(final int n, final Test1[] array) {
        this.m_tests[n] = array;
    }
    
    public void addDirectlyMatchedVariables(final Map map) throws JessException {
        for (int i = 0; i < this.getNSlots(); ++i) {
            for (int j = 0; j < this.getNTests(i); ++j) {
                final Test1 test = this.getTest(i, j);
                final Value slotValue = test.m_slotValue;
                boolean b = false;
                if (test.m_test == 0) {
                    b = true;
                }
                final boolean b2 = b;
                if (slotValue instanceof Variable && b2) {
                    final String variableValue = slotValue.variableValue(null);
                    map.put(variableValue, variableValue);
                }
            }
        }
        if (this.getBoundName() != null) {
            map.put(this.getBoundName(), this.getBoundName());
        }
    }
    
    public void renameUnmentionedVariables(final Map map, final Map map2, final int n, final HasLHS hasLHS) throws JessException {
        final String string = "_" + n + '_';
        for (int i = 0; i < this.getNSlots(); ++i) {
            for (int j = 0; j < this.getNTests(i); ++j) {
                final Test1 test = this.getTest(i, j);
                final Value slotValue = test.m_slotValue;
                boolean b = false;
                if (test.m_test == 0) {
                    b = true;
                }
                final boolean b2 = b;
                if (slotValue instanceof Variable && b2) {
                    final String variableValue = slotValue.variableValue(null);
                    if (map.get(variableValue) == null && !variableValue.startsWith(string)) {
                        String string2;
                        if (map2.get(variableValue) == null) {
                            string2 = string + variableValue;
                            map2.put(variableValue, string2);
                        }
                        else {
                            string2 = map2.get(variableValue);
                        }
                        test.m_slotValue = new Variable(string2, slotValue.type());
                    }
                }
            }
        }
        this.substituteVariableNamesInFuncalls(map2);
    }
    
    private final void substituteVariableNamesInFuncalls(final Map map) throws JessException {
        for (int i = 0; i < this.getNSlots(); ++i) {
            if (this.getNTests(i) != 0) {
                for (int j = 0; j < this.getNTests(i); ++j) {
                    final Value slotValue = this.getTest(i, j).m_slotValue;
                    if (slotValue.type() == 64) {
                        this.substFuncall(slotValue.funcallValue(null), map);
                    }
                }
            }
        }
    }
    
    private final void substFuncall(final Funcall funcall, final Map map) throws JessException {
        for (int i = 1; i < funcall.size(); ++i) {
            final Value value = funcall.get(i);
            if (value instanceof Variable) {
                final String s = map.get(value.variableValue(null));
                if (s != null) {
                    funcall.set(new Variable(s, value.type()), i);
                }
            }
            else if (value instanceof FuncallValue) {
                this.substFuncall(value.funcallValue(null), map);
            }
        }
    }
    
    public boolean getNegated() {
        return this.m_negated;
    }
    
    public void setNegated() {
        this.m_negated = true;
    }
    
    public void setLogical() {
        this.m_logical = true;
    }
    
    public boolean getLogical() {
        return this.m_logical;
    }
    
    public void setExplicit() {
        this.m_explicit = true;
    }
    
    public boolean getExplicit() {
        return this.m_explicit;
    }
    
    public boolean getBackwardChaining() {
        return this.m_deft.getBackwardChaining();
    }
    
    public String getName() {
        return this.m_name;
    }
    
    public void setBoundName(final String boundName) throws JessException {
        if ((this.m_negated || this.m_name.equals("test")) && boundName != null) {
            throw new JessException("Pattern.setBoundName", "Can't bind negated pattern to variable", boundName);
        }
        this.m_boundName = boundName;
    }
    
    public String getBoundName() {
        if (this.isBackwardChainingTrigger() && this.m_boundName == null) {
            this.m_boundName = RU.gensym("__factidx");
        }
        return this.m_boundName;
    }
    
    public int getNSlots() {
        return this.m_tests.length;
    }
    
    public int getNTests(final int n) {
        if (this.m_tests[n] == null) {
            return 0;
        }
        return this.m_tests[n].length;
    }
    
    public int getSlotLength(final int n) {
        return this.m_slotLengths[n];
    }
    
    public int getNMultifieldsInSlot(final int n) {
        int n2 = 0;
        if (this.m_tests[n] == null) {
            return n2;
        }
        for (int i = 0; i < this.m_tests[n].length; ++i) {
            if (this.m_tests[n][i].m_slotValue.type() == 8192) {
                ++n2;
            }
        }
        return n2;
    }
    
    public boolean isMultifieldSubslot(final int n, final int n2) {
        if (this.m_tests[n] == null) {
            return false;
        }
        for (int i = 0; i < this.m_tests[n].length; ++i) {
            if (this.m_tests[n][i].m_slotValue.type() == 8192 && this.m_tests[n][i].m_subIdx == n2) {
                return true;
            }
        }
        return false;
    }
    
    boolean[] getMultifieldFlags(final int n) {
        final boolean[] array = new boolean[this.getSlotLength(n)];
        for (int i = 0; i < this.getSlotLength(n); ++i) {
            if (this.isMultifieldSubslot(n, i)) {
                array[i] = true;
            }
        }
        return array;
    }
    
    public Test1 getTest(final int n, final int n2) {
        return this.m_tests[n][n2];
    }
    
    public Deftemplate getDeftemplate() {
        return this.m_deft;
    }
    
    public void addToGroup(final Group group) throws JessException {
        group.m_data.add((LHSComponent)this.clone());
    }
    
    public LHSComponent canonicalize() {
        return this;
    }
    
    public Object accept(final Visitor visitor) {
        return visitor.visitPattern(this);
    }
    
    public int getGroupSize() {
        return 1;
    }
    
    public boolean isGroup() {
        return false;
    }
    
    public ConditionalElement getConditionalElement(final int n) {
        return (ConditionalElement)this.getLHSComponent(n);
    }
    
    public int getPatternCount() {
        return 1;
    }
    
    public LHSComponent getLHSComponent(final int n) {
        if (n > 0) {
            throw new IllegalArgumentException();
        }
        return this;
    }
    
    public boolean equals(final Object o) {
        if (!(o instanceof Pattern)) {
            return false;
        }
        final Pattern pattern = (Pattern)o;
        if (!this.getName().equals(pattern.getName())) {
            return false;
        }
        if (this.m_negated != pattern.m_negated) {
            return false;
        }
        for (int i = 0; i < this.m_slotLengths.length; ++i) {
            if (this.m_slotLengths[i] != pattern.m_slotLengths[i]) {
                return false;
            }
        }
        for (int j = 0; j < this.m_tests.length; ++j) {
            if (this.m_tests[j] == null || pattern.m_tests[j] == null) {
                if (this.m_tests[j] != pattern.m_tests[j]) {
                    return false;
                }
            }
            else {
                if (this.m_tests[j].length != pattern.m_tests[j].length) {
                    return false;
                }
                for (int k = 0; k < this.m_tests[j].length; ++k) {
                    if ((this.m_tests[j][k] == null || pattern.m_tests[j][k] == null) && this.m_tests[j][k] != pattern.m_tests[j][k]) {
                        return false;
                    }
                    if (!this.m_tests[j][k].equals(pattern.m_tests[j][k])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    public boolean isBackwardChainingTrigger() {
        boolean b = false;
        if (!this.m_negated && this.m_deft.isBackwardChainingTrigger()) {
            b = true;
        }
        return b;
    }
    
    public String getBackchainingTemplateName() {
        return this.m_deft.getBackchainingTemplateName();
    }
    
    public String getNameWithoutBackchainingPrefix() {
        return this.m_deft.getNameWithoutBackchainingPrefix();
    }
    
    public String toString() {
        return "(" + this.getName() + ')';
    }
    
    public Pattern(final String s, final Rete rete) throws JessException {
        this(s, rete.createDeftemplate(s));
    }
    
    public Pattern(final String name, final Deftemplate deft) {
        this.m_name = name;
        this.m_deft = deft;
        final int nSlots = this.m_deft.getNSlots();
        this.m_tests = new Test1[nSlots][];
        this.m_slotLengths = new int[nSlots];
        for (int i = 0; i < nSlots; ++i) {
            this.m_slotLengths[i] = -1;
        }
    }
    
    Pattern(final Pattern pattern, final String name) throws JessException {
        this.m_name = name;
        this.m_deft = pattern.m_deft;
        this.m_tests = new Test1[pattern.m_tests.length][];
        for (int i = 0; i < this.m_tests.length; ++i) {
            this.m_tests[i] = (Test1[])((pattern.m_tests[i] == null) ? null : new Test1[pattern.m_tests[i].length]);
            if (this.m_tests[i] != null) {
                System.arraycopy(pattern.m_tests[i], 0, this.m_tests[i], 0, this.m_tests[i].length);
                for (int j = 0; j < this.m_tests[i].length; ++j) {
                    final Value slotValue = this.m_tests[i][j].m_slotValue;
                    if (slotValue instanceof Variable && slotValue.variableValue(null).startsWith("_blank_")) {
                        this.m_tests[i][j] = new Test1(this.m_tests[i][j], new Variable(RU.gensym("_blank_"), slotValue.type()));
                    }
                }
            }
        }
        this.m_slotLengths = pattern.m_slotLengths;
    }
}
