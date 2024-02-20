package jess;

import java.util.Map;
import java.util.HashMap;
import java.io.Serializable;

class Group implements ConditionalElement, LHSComponent, Serializable, Visitable
{
    static final String AND = "and";
    static final String UNIQUE = "unique";
    static final String EXPLICIT = "explicit";
    static final String NOT = "not";
    static final String EXISTS = "exists";
    static final String TEST = "test";
    static final String OR = "or";
    static final String LOGICAL = "logical";
    private static final Pattern s_initialFactPattern;
    private static final Pattern s_logicalInitialFactPattern;
    private String m_name;
    private boolean m_explicit;
    private boolean m_logical;
    CEVector m_data;
    private boolean m_unary;
    
    public Object clone() {
        try {
            final Group group = (Group)super.clone();
            group.m_data = new CEVector();
            for (int i = 0; i < this.m_data.size(); ++i) {
                group.m_data.add((LHSComponent)this.getLHSComponent(i).clone());
            }
            return group;
        }
        catch (CloneNotSupportedException ex) {
            throw new IllegalArgumentException();
        }
    }
    
    public String getName() {
        return this.m_name;
    }
    
    public int getPatternCount() {
        int n = 0;
        for (int i = 0; i < this.m_data.size(); ++i) {
            n += this.m_data.get(i).getPatternCount();
        }
        return n;
    }
    
    void add(LHSComponent lhsComponent) throws JessException {
        this.verifyAdditionIsAllowed(lhsComponent);
        if (lhsComponent.getName().equals("or") && lhsComponent.getGroupSize() == 1) {
            lhsComponent = lhsComponent.getLHSComponent(0);
        }
        if (lhsComponent.getName().equals("and") && lhsComponent.getGroupSize() == 1 && !this.getName().equals("or")) {
            lhsComponent = lhsComponent.getLHSComponent(0);
        }
        if (this.m_name.equals("or") && lhsComponent.getName().equals("or")) {
            final Group group = (Group)lhsComponent;
            for (int i = 0; i < group.m_data.size(); ++i) {
                this.add(group.m_data.get(i));
            }
        }
        else if (this.m_name.equals("and") && lhsComponent.getName().equals("and")) {
            final Group group2 = (Group)lhsComponent;
            for (int j = 0; j < group2.m_data.size(); ++j) {
                this.add(group2.m_data.get(j));
            }
        }
        else if (this.m_name.equals("not") && lhsComponent.getName().equals("or")) {
            this.m_name = "and";
            this.m_unary = false;
            final Group group3 = (Group)lhsComponent;
            for (int k = 0; k < group3.m_data.size(); ++k) {
                final Group group4 = new Group("not");
                group4.add(group3.m_data.get(k));
                this.add(group4);
            }
        }
        else if (this.m_name.equals("not") && lhsComponent.getName().equals("and") && this.hasEmbeddedORs((Group)lhsComponent)) {
            lhsComponent = lhsComponent.canonicalize();
            this.add(lhsComponent);
        }
        else {
            this.m_data.add(lhsComponent);
        }
        if (this.m_explicit) {
            this.setExplicit();
        }
        if (this.m_logical) {
            this.setLogical();
        }
        if (this.getNegated()) {
            this.setNegated();
        }
    }
    
    private final boolean hasEmbeddedORs(final Group group) {
        if (group.getName().equals("or")) {
            return true;
        }
        for (int i = 0; i < group.getGroupSize(); ++i) {
            final LHSComponent lhsComponent = group.getLHSComponent(i);
            if (lhsComponent instanceof Group && this.hasEmbeddedORs((Group)lhsComponent)) {
                return true;
            }
        }
        return false;
    }
    
    private final void verifyAdditionIsAllowed(final LHSComponent lhsComponent) throws JessException {
        if (this.m_data.size() > 0 && this.m_unary) {
            throw new JessException("Group.add", "CE is a unary modifier", this.m_name);
        }
        if (this.m_name.equals("logical") && lhsComponent.getName().equals("test")) {
            throw new JessException("Group.add", "CE can't be used in logical:", "test");
        }
        if (this.m_name.equals("not") && lhsComponent.getName().equals("logical")) {
            throw new JessException("Group.add", "CE can't be used in not:", "logical");
        }
    }
    
    public boolean getBackwardChaining() {
        return false;
    }
    
    public void setExplicit() {
        for (int i = 0; i < this.m_data.size(); ++i) {
            this.m_data.get(i).setExplicit();
        }
        this.m_explicit = true;
    }
    
    public void setLogical() {
        for (int i = 0; i < this.m_data.size(); ++i) {
            this.m_data.get(i).setLogical();
        }
        this.m_logical = true;
    }
    
    public boolean getLogical() {
        return this.m_logical;
    }
    
    public boolean getNegated() {
        return this.m_name.equals("not");
    }
    
    public void setNegated() {
        for (int i = 0; i < this.m_data.size(); ++i) {
            this.m_data.get(i).setNegated();
        }
    }
    
    public void setBoundName(final String boundName) throws JessException {
        if (this.m_name.equals("not") || this.m_name.equals("test") || (this.m_data.size() > 1 && !this.m_name.equals("or"))) {
            throw new JessException("Group.setBoundName", "This CE can't be bound to a variable", this.m_name);
        }
        for (int i = 0; i < this.m_data.size(); ++i) {
            this.m_data.get(i).setBoundName(boundName);
        }
    }
    
    public String getBoundName() {
        return this.m_data.get(0).getBoundName();
    }
    
    static boolean isGroupName(final String s) {
        boolean b = false;
        if (isNegatedName(s) || s.equals("and") || s.equals("or") || s.equals("logical") || s.equals("explicit")) {
            b = true;
        }
        return b;
    }
    
    static boolean isNegatedName(final String s) {
        return s.equals("not");
    }
    
    public String toString() {
        final StringBuffer sb = new StringBuffer("(");
        sb.append(this.m_name);
        for (int i = 0; i < this.m_data.size(); ++i) {
            sb.append('\n');
            sb.append(' ');
            sb.append(this.m_data.get(i));
        }
        sb.append(")");
        return sb.toString();
    }
    
    private final int countNumberOfBranches(final LHSComponent[] array) throws JessException {
        for (int i = 0; i < array.length; ++i) {
            array[i] = this.m_data.get(i).canonicalize();
        }
        int n;
        if (this.m_name.equals("or")) {
            n = 0;
            for (int j = 0; j < array.length; ++j) {
                n += array[j].getGroupSize();
            }
        }
        else {
            n = 1;
            for (int k = 0; k < array.length; ++k) {
                n *= array[k].getGroupSize();
            }
        }
        return n;
    }
    
    public LHSComponent canonicalize() throws JessException {
        final LHSComponent[] array = new LHSComponent[this.m_data.size()];
        final int countNumberOfBranches = this.countNumberOfBranches(array);
        if (countNumberOfBranches == 1) {
            final Group group = new Group("or");
            group.add(this);
            return group;
        }
        final Group[] array2 = new Group[countNumberOfBranches];
        for (int i = 0; i < countNumberOfBranches; ++i) {
            array2[i] = new Group("and");
        }
        if (this.m_name.equals("or")) {
            int n = 0;
            for (int j = 0; j < array.length; ++j) {
                for (int k = 0; k < array[j].getGroupSize(); ++k) {
                    array2[n++].add(array[j].getLHSComponent(k));
                }
            }
        }
        else {
            int n2 = countNumberOfBranches;
            for (int l = 0; l < array.length; ++l) {
                if (array[l].getGroupSize() == 1) {
                    for (int n3 = 0; n3 < countNumberOfBranches; ++n3) {
                        array2[n3].add(array[l].getLHSComponent(0));
                    }
                }
                else {
                    n2 /= array[l].getGroupSize();
                    final int n4 = countNumberOfBranches / (n2 * array[l].getGroupSize());
                    int n5 = 0;
                    for (int n6 = 0; n6 < n4; ++n6) {
                        for (int n7 = 0; n7 < array[l].getGroupSize(); ++n7) {
                            for (int n8 = 0; n8 < n2; ++n8) {
                                array2[n5++].add(array[l].getLHSComponent(n7));
                            }
                        }
                    }
                }
            }
        }
        final Group group2 = new Group("or");
        for (int n9 = 0; n9 < countNumberOfBranches; ++n9) {
            if (array2[n9].getGroupSize() == 1 && !array2[n9].getLHSComponent(0).getName().equals("not") && !array2[n9].getLHSComponent(0).getName().equals("test")) {
                group2.add(array2[n9].getLHSComponent(0));
            }
            else {
                group2.add(array2[n9]);
            }
        }
        if (this.m_name.equals("not")) {
            final Group group3 = new Group("not");
            group3.add(group2);
            return group3.canonicalize();
        }
        return group2;
    }
    
    void insertInitialFacts() {
        final LHSComponent lhsComponent = this.getLHSComponent(0);
        if (this.m_name.equals("and") && (this.m_data.size() == 0 || (lhsComponent.getName().equals("logical") && (isNegatedName(lhsComponent.getLHSComponent(0).getName()) || lhsComponent.getLHSComponent(0).getName().equals("test"))) || lhsComponent.getName().equals("not") || lhsComponent.getName().equals("test") || lhsComponent.getBackwardChaining())) {
            this.m_data.addAtStart((LHSComponent)((lhsComponent == null || !lhsComponent.getLogical()) ? Group.s_initialFactPattern.clone() : ((Pattern)Group.s_logicalInitialFactPattern.clone())));
        }
    }
    
    public void addToLHS(final HasLHS hasLHS, final Rete rete) throws JessException {
        if (!this.getName().equals("and")) {
            throw new JessException("Group.addToLHS", "Bad assumption", this.getName());
        }
        for (int i = 0; i < this.m_data.size(); ++i) {
            hasLHS.addCE(this.m_data.get(i), rete);
        }
    }
    
    void renameVariables(final Group group, final HasLHS hasLHS) throws JessException {
        final HashMap hashMap = new HashMap();
        final HashMap hashMap2 = new HashMap();
        this.addDirectlyMatchedVariables(hashMap);
        group.renameUnmentionedVariables(hashMap, hashMap2, hasLHS.getSequenceNumber(), hasLHS);
    }
    
    public void addToGroup(final Group group) throws JessException {
        this.insertInitialFacts();
        for (int i = 0; i < this.m_data.size(); ++i) {
            group.m_data.add((LHSComponent)this.m_data.get(i).clone());
        }
    }
    
    public int getGroupSize() {
        return this.m_data.size();
    }
    
    public boolean isGroup() {
        return true;
    }
    
    public ConditionalElement getConditionalElement(final int n) {
        return (ConditionalElement)this.getLHSComponent(n);
    }
    
    public LHSComponent getLHSComponent(final int n) {
        return this.m_data.get(n);
    }
    
    public void addDirectlyMatchedVariables(final Map map) throws JessException {
        for (int i = 0; i < this.m_data.size(); ++i) {
            this.m_data.get(i).addDirectlyMatchedVariables(map);
        }
    }
    
    public void renameUnmentionedVariables(final Map map, Map hashMap, int sequenceNumber, final HasLHS hasLHS) throws JessException {
        if (isNegatedName(this.m_name)) {
            sequenceNumber = hasLHS.getSequenceNumber();
            hashMap = new HashMap(hashMap);
        }
        for (int i = 0; i < this.m_data.size(); ++i) {
            this.m_data.get(i).renameUnmentionedVariables(map, hashMap, sequenceNumber, hasLHS);
        }
    }
    
    public boolean isBackwardChainingTrigger() {
        return false;
    }
    
    public Object accept(final Visitor visitor) {
        return visitor.visitGroup(this);
    }
    
    private final /* synthetic */ void this() {
        this.m_unary = false;
    }
    
    Group(final String name) throws JessException {
        this.this();
        this.m_data = new CEVector();
        this.m_name = name;
        if (this.m_name.equals("explicit")) {
            this.m_explicit = true;
            this.m_unary = true;
        }
        else if (this.m_name.equals("logical")) {
            this.m_logical = true;
            this.m_unary = false;
        }
        else if (this.m_name.equals("not")) {
            this.m_unary = true;
        }
        else if (this.m_name.equals("exists")) {
            throw new JessException("Group::Group", "Invalid CE name", "exists");
        }
    }
    
    static {
        s_initialFactPattern = new Pattern(Deftemplate.getInitialTemplate().getName(), Deftemplate.getInitialTemplate());
        (s_logicalInitialFactPattern = new Pattern(Deftemplate.getInitialTemplate().getName(), Deftemplate.getInitialTemplate())).setLogical();
    }
    
    static class CEVector implements Serializable
    {
        private LHSComponent[] m_data;
        private int m_nData;
        
        void addAtStart(final LHSComponent lhsComponent) {
            if (this.m_data.length == this.m_nData) {
                final LHSComponent[] data = new LHSComponent[this.m_nData * 2];
                System.arraycopy(this.m_data, 0, data, 0, this.m_nData);
                this.m_data = data;
            }
            System.arraycopy(this.m_data, 0, this.m_data, 1, this.m_nData);
            this.m_data[0] = lhsComponent;
            ++this.m_nData;
        }
        
        void add(final LHSComponent lhsComponent) {
            if (this.m_data.length == this.m_nData) {
                final LHSComponent[] data = new LHSComponent[this.m_nData * 2];
                System.arraycopy(this.m_data, 0, data, 0, this.m_nData);
                this.m_data = data;
            }
            this.m_data[this.m_nData++] = lhsComponent;
        }
        
        LHSComponent get(final int n) {
            return this.m_data[n];
        }
        
        int size() {
            return this.m_nData;
        }
        
        private final /* synthetic */ void this() {
            this.m_data = new LHSComponent[1];
        }
        
        CEVector() {
            this.this();
        }
    }
}
