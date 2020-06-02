package jess;

import java.util.Iterator;
import java.util.Hashtable;
import java.util.ArrayList;
import java.io.Serializable;

public abstract class HasLHS extends Node implements Serializable, Visitable, Modular, NodeSink
{
    String m_module;
    String m_name;
    String m_displayName;
    String m_docstring;
    private ArrayList m_nodes;
    private Hashtable m_bindings;
    private Group m_CEs;
    int m_nodeIndexHash;
    private StringBuffer m_compilationTrace;
    boolean m_new;
    boolean m_frozen;
    private HasLHS m_next;
    private int m_seqNum;
    
    public int getGroupSize() {
        return this.m_CEs.getGroupSize();
    }
    
    LHSComponent getLHSComponent(final int n) {
        return this.m_CEs.getLHSComponent(n);
    }
    
    public ConditionalElement getConditionalElements() {
        return (ConditionalElement)this.getLHSComponents();
    }
    
    LHSComponent getLHSComponents() {
        return this.m_CEs;
    }
    
    public String listNodes() {
        final StringBuffer sb = new StringBuffer(100);
        for (int i = 0; i < this.m_nodes.size(); ++i) {
            sb.append(this.m_nodes.get(i));
            sb.append("\n");
        }
        return sb.toString();
    }
    
    HasLHS getNext() {
        return this.m_next;
    }
    
    void setNext(final HasLHS next) {
        this.m_next = next;
    }
    
    void freeze(final Rete rete) throws JessException {
        this.m_frozen = true;
    }
    
    public int getPatternCount() {
        return this.getLHSComponents().getPatternCount();
    }
    
    void insertCEAt(final LHSComponent lhsComponent, final int n, final Rete rete) throws JessException {
        final Group cEs = this.m_CEs;
        this.m_bindings = new Hashtable();
        this.m_CEs = new Group("and");
        if (cEs.getGroupSize() == 0) {
            this.addCE(lhsComponent, rete);
            return;
        }
        for (int i = 0; i < cEs.getGroupSize(); ++i) {
            if (i == n) {
                this.addCE(lhsComponent, rete);
            }
            this.addCE(cEs.getLHSComponent(i), rete);
        }
    }
    
    void addCE(LHSComponent lhsComponent, final Rete rete) throws JessException {
        lhsComponent = (LHSComponent)lhsComponent.clone();
        if (lhsComponent.getName().equals("not")) {
            this.m_CEs.renameVariables((Group)lhsComponent, this);
        }
        this.storeBoundName(lhsComponent);
        this.m_CEs.add(lhsComponent);
        this.findVariableDefinitions(lhsComponent);
        this.findUndefinedVariables(lhsComponent);
        this.transformOrConjunctionsIntoOrFuncalls(lhsComponent, rete);
        this.addNOTToSupressUnneededBackwardChaining(lhsComponent, rete);
    }
    
    private final void addNOTToSupressUnneededBackwardChaining(final LHSComponent lhsComponent, final Rete rete) throws JessException {
        if (lhsComponent.isBackwardChainingTrigger()) {
            final Pattern pattern = (Pattern)lhsComponent;
            final Pattern pattern2 = new Pattern(pattern, pattern.getNameWithoutBackchainingPrefix());
            final Group group = new Group("not");
            group.add(pattern2);
            this.addCE(group, rete);
        }
    }
    
    private final void storeBoundName(final LHSComponent lhsComponent) throws JessException {
        final String boundName = lhsComponent.getBoundName();
        if (boundName != null && this.m_bindings.get(boundName) == null) {
            this.addBinding(boundName, lhsComponent, this.getGroupSize(), -1, -1, 16);
        }
    }
    
    private final void findVariableDefinitions(final LHSComponent lhsComponent) throws JessException {
        final PatternIterator patternIterator = new PatternIterator(lhsComponent);
        int n = this.getPatternCount() - lhsComponent.getPatternCount();
        while (patternIterator.hasNext()) {
            final Pattern pattern = (Pattern)patternIterator.next();
            final Deftemplate deftemplate = pattern.getDeftemplate();
            for (int i = 0; i < pattern.getNSlots(); ++i) {
                for (int j = 0; j < pattern.getNTests(i); ++j) {
                    final Test1 test = pattern.getTest(i, j);
                    final Value slotValue = test.m_slotValue;
                    boolean b = false;
                    if (test.m_test == 0) {
                        b = true;
                    }
                    final boolean b2 = b;
                    if (slotValue instanceof Variable) {
                        final String variableValue = slotValue.variableValue(null);
                        if (this.m_bindings.get(variableValue) == null) {
                            if (!variableValue.startsWith("*")) {
                                if (b2) {
                                    this.m_bindings.put(variableValue, new BindingValue(variableValue, pattern, n, i, test.m_subIdx, deftemplate.getSlotDataType(i)));
                                }
                            }
                        }
                    }
                }
            }
            ++n;
        }
    }
    
    private final void findUndefinedVariables(final LHSComponent lhsComponent) throws JessException {
        final PatternIterator patternIterator = new PatternIterator(lhsComponent);
        while (patternIterator.hasNext()) {
            final Pattern pattern = (Pattern)patternIterator.next();
            for (int i = 0; i < pattern.getNSlots(); ++i) {
                for (int j = 0; j < pattern.getNTests(i); ++j) {
                    final Value slotValue = pattern.getTest(i, j).m_slotValue;
                    if (slotValue instanceof Variable) {
                        final String variableValue = slotValue.variableValue(null);
                        if (this.m_bindings.get(variableValue) == null) {
                            if (!variableValue.startsWith("*")) {
                                throw new JessException("HasLHS.addPattern", "First use of variable negated:", variableValue);
                            }
                        }
                    }
                }
            }
        }
    }
    
    private final void transformOrConjunctionsIntoOrFuncalls(final LHSComponent lhsComponent, final Rete rete) throws JessException {
        final PatternIterator patternIterator = new PatternIterator(lhsComponent);
        int n = this.getGroupSize() - 1;
        while (patternIterator.hasNext()) {
            final Pattern pattern = (Pattern)patternIterator.next();
            final Deftemplate deftemplate = pattern.getDeftemplate();
            for (int i = 0; i < pattern.getNSlots(); ++i) {
                final int nTests = pattern.getNTests(i);
                if (nTests != 0) {
                    final ArrayList list = new ArrayList<Test1>();
                    int n2 = pattern.getTest(i, 0).m_subIdx;
                    int j = 0;
                    while (j < nTests) {
                        boolean b = false;
                        for (int k = j; k < nTests; ++k) {
                            final Test1 test = pattern.getTest(i, k);
                            if (test.m_subIdx != n2) {
                                break;
                            }
                            if (test.m_conjunction == 2) {
                                b = true;
                                break;
                            }
                        }
                        if (!b) {
                            for (int l = j; l < nTests; ++l) {
                                final Test1 test2 = pattern.getTest(i, l);
                                if (test2.m_subIdx != n2) {
                                    n2 = test2.m_subIdx;
                                    break;
                                }
                                list.add(test2);
                                ++j;
                            }
                        }
                        else {
                            final Value slotValue = pattern.getTest(i, j).m_slotValue;
                            Value value;
                            if (this.isAVariableDefinition(slotValue, pattern, i)) {
                                value = slotValue;
                                ++j;
                            }
                            else {
                                final String gensym = RU.gensym("_blank_");
                                value = new Variable(gensym, 8);
                                this.m_bindings.put(gensym, new BindingValue(gensym, this.getLHSComponent(n), n, i, n2, deftemplate.getSlotDataType(i)));
                            }
                            list.add(new Test1(0, n2, value));
                            final Funcall funcall = new Funcall("or", rete);
                            do {
                                int n3 = 1;
                                for (int n4 = j + 1; n4 < nTests; ++n4) {
                                    final Test1 test3 = pattern.getTest(i, n4);
                                    if (test3.m_conjunction == 2 || test3.m_subIdx != n2) {
                                        break;
                                    }
                                    ++n3;
                                }
                                if (n3 == 1) {
                                    funcall.add(this.testToFuncall(pattern.getTest(i, j), value, rete));
                                }
                                else {
                                    final Funcall funcall2 = new Funcall("and", rete);
                                    for (int n5 = j; n5 < j + n3; ++n5) {
                                        funcall2.add(this.testToFuncall(pattern.getTest(i, n5), value, rete));
                                    }
                                    funcall.add(new FuncallValue(funcall2));
                                }
                                j += n3;
                                if (j == nTests) {
                                    break;
                                }
                            } while (pattern.getTest(i, j).m_subIdx == n2);
                            list.add(new Test1(0, n2, new FuncallValue(funcall)));
                            if (j >= nTests || pattern.getTest(i, j).m_subIdx == n2) {
                                continue;
                            }
                            n2 = pattern.getTest(i, j).m_subIdx;
                        }
                    }
                    final Test1[] array = new Test1[list.size()];
                    for (int n6 = 0; n6 < array.length; ++n6) {
                        array[n6] = list.get(n6);
                    }
                    pattern.replaceTests(i, array);
                }
            }
            ++n;
        }
    }
    
    private final boolean isAVariableDefinition(final Value value, final LHSComponent lhsComponent, final int n) throws JessException {
        if (value.type() != 8) {
            return false;
        }
        final BindingValue bindingValue = this.m_bindings.get(value.variableValue(null));
        boolean b = false;
        if (bindingValue.getCE() == lhsComponent && bindingValue.getSlotIndex() == n) {
            b = true;
        }
        return b;
    }
    
    private final Value testToFuncall(final Test1 test1, final Value value, final Rete rete) throws JessException {
        final Value slotValue = test1.m_slotValue;
        switch (test1.m_slotValue.type()) {
            case 64: {
                if (test1.m_test == 1) {
                    return new FuncallValue(new Funcall("not", rete).arg(slotValue));
                }
                return slotValue;
            }
            default: {
                return new FuncallValue(new Funcall((test1.m_test == 0) ? "eq" : "neq", rete).arg(slotValue).arg(value));
            }
        }
    }
    
    private final void addBinding(final String s, final LHSComponent lhsComponent, final int n, final int n2, final int n3, final int n4) throws JessException {
        this.m_bindings.put(s, new BindingValue(s, lhsComponent, n, n2, n3, n4));
    }
    
    Hashtable getBindings() {
        return this.m_bindings;
    }
    
    ArrayList getNodes() {
        return this.m_nodes;
    }
    
    public void addNode(final Node node) throws JessException {
        if (node == null) {
            new JessException("HasLHS.addNode", "Compiler fault", "null Node added");
        }
        for (int i = 0; i < this.m_nodes.size(); ++i) {
            if (node == this.m_nodes.get(i)) {
                return;
            }
        }
        this.appendCompilationTrace(node);
        ++node.m_usecount;
        this.m_nodes.add(node);
    }
    
    void remove(final Node node) {
        for (final Node node3 : this.m_nodes) {
            final Node node2 = node3;
            if (--node3.m_usecount <= 0) {
                node.removeSuccessor(node2);
                final Iterator<Node> iterator2 = (Iterator<Node>)this.m_nodes.iterator();
                while (iterator2.hasNext()) {
                    iterator2.next().removeSuccessor(node2);
                }
            }
        }
        this.m_nodes.clear();
    }
    
    private final void appendCompilationTrace(final Node node) {
        if (this.m_compilationTrace == null) {
            this.m_compilationTrace = new StringBuffer(this.m_name + ": ");
        }
        if (node.m_usecount == 0) {
            this.m_compilationTrace.append("+");
        }
        else {
            this.m_compilationTrace.append("=");
        }
        this.m_compilationTrace.append(node.getCompilationTraceToken());
    }
    
    String getCompilationTraceToken() {
        return "t";
    }
    
    StringBuffer getCompilationTrace() {
        return this.m_compilationTrace;
    }
    
    public void setNodeIndexHash(final int nodeIndexHash) {
        this.m_nodeIndexHash = nodeIndexHash;
    }
    
    public int getNodeIndexHash() {
        return this.m_nodeIndexHash;
    }
    
    public final String getName() {
        return this.m_name;
    }
    
    public String getDisplayName() {
        return this.m_displayName;
    }
    
    public final String getDocstring() {
        return this.m_docstring;
    }
    
    void setOld() {
        this.m_new = false;
    }
    
    public abstract Object accept(final Visitor p0);
    
    public String getModule() {
        return this.m_module;
    }
    
    int getSequenceNumber() {
        return ++this.m_seqNum;
    }
    
    private final /* synthetic */ void this() {
        this.m_docstring = "";
        this.m_nodes = new ArrayList();
        this.m_bindings = new Hashtable();
        this.m_nodeIndexHash = 0;
        this.m_new = true;
        this.m_frozen = false;
        this.m_next = null;
    }
    
    HasLHS(final String name, final String docstring, final Rete rete) throws JessException {
        this.this();
        final int index = name.indexOf("::");
        if (index != -1) {
            rete.verifyModule(this.m_module = name.substring(0, index));
            this.m_name = name;
        }
        else {
            this.m_module = rete.getCurrentModule();
            this.m_name = rete.resolveName(name);
        }
        final int index2 = this.m_name.indexOf(38);
        this.m_displayName = ((index2 == -1) ? this.m_name : this.m_name.substring(0, index2));
        this.m_docstring = docstring;
        this.m_CEs = new Group("and");
    }
}
