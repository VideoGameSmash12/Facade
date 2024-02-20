package jess;

import java.util.Hashtable;
import java.io.Serializable;

class ReteCompiler implements Serializable
{
    private int m_hashkey;
    private RootNode m_root;
    private Hashtable m_doneVars;
    
    public int getHashKey() {
        return this.m_hashkey;
    }
    
    public void setHashKey(final int hashkey) {
        this.m_hashkey = hashkey;
    }
    
    public final Node getRoot() {
        return this.m_root;
    }
    
    public synchronized void addRule(final HasLHS hasLHS, final Rete rete) throws JessException {
        hasLHS.freeze(rete);
        final Hashtable bindings = hasLHS.getBindings();
        final LHSComponent lhsComponents = hasLHS.getLHSComponents();
        final Hashtable hashtable = new Hashtable();
        final Node[] array = new Node[lhsComponents.getPatternCount()];
        array[this.compileConditionalElements(lhsComponents, hasLHS, hashtable, bindings, array, 0, rete, false) - 1].mergeSuccessor(hasLHS, hasLHS);
        try {
            rete.updateNodes(hashtable);
        }
        finally {
            hasLHS.setOld();
        }
        hasLHS.setOld();
    }
    
    private final int compileConditionalElements(final LHSComponent lhsComponent, final HasLHS hasLHS, final Hashtable hashtable, final Hashtable hashtable2, final Node[] array, final int n, final Rete rete, final boolean b) throws JessException {
        int compileConditionalElements = n;
        for (int i = 0; i < lhsComponent.getGroupSize(); ++i) {
            final LHSComponent lhsComponent2 = lhsComponent.getLHSComponent(i);
            if (lhsComponent2 instanceof Pattern) {
                final Pattern pattern = (Pattern)lhsComponent2;
                this.buildPatternNetwork(hasLHS, pattern, hashtable, hashtable2, array, compileConditionalElements);
                if (compileConditionalElements == 0) {
                    this.addRTLAdapter(compileConditionalElements, array, hasLHS);
                }
                else {
                    final Node thirdPass = this.thirdPass(hasLHS, pattern, array[compileConditionalElements - 1], array[compileConditionalElements], hashtable2, b);
                    array[compileConditionalElements - 1] = (array[compileConditionalElements] = thirdPass);
                    if (lhsComponent2.getLogical()) {
                        ((Defrule)hasLHS).setLogicalInformation((LogicalNode)thirdPass);
                    }
                }
                ++compileConditionalElements;
            }
            else if (lhsComponent2.getName().equals("not")) {
                final boolean noNotsAboveOrBelow = this.noNotsAboveOrBelow(lhsComponent, lhsComponent2);
                final Node node = array[compileConditionalElements - 1];
                final int n2 = compileConditionalElements - 1;
                int n3 = 1;
                LHSComponent lhsComponent3;
                for (lhsComponent3 = lhsComponent2.getLHSComponent(0); lhsComponent3.getName().equals("not"); lhsComponent3 = lhsComponent3.getLHSComponent(0)) {
                    ++n3;
                }
                Node node2 = array[this.compileConditionalElements(lhsComponent3, hasLHS, hashtable, hashtable2, array, compileConditionalElements, rete, noNotsAboveOrBelow) - 1];
                final int hashValue = this.hashValueFor(hasLHS);
                if (!noNotsAboveOrBelow) {
                    for (int j = 0; j < n3; ++j) {
                        final Node2 node3 = (Node2)node2;
                        final Node1LTR node1LTR = new Node1LTR();
                        final NodeNot2 nodeNot2 = new NodeNot2(hashValue, compileConditionalElements);
                        node3.addSuccessor(node1LTR, hasLHS);
                        node1LTR.addSuccessor(nodeNot2, hasLHS);
                        node.addSuccessor(nodeNot2, hasLHS);
                        array[compileConditionalElements - 1] = (array[compileConditionalElements] = nodeNot2);
                        node2 = nodeNot2;
                    }
                }
                compileConditionalElements = n2 + 1;
                array[compileConditionalElements - 1] = (array[compileConditionalElements] = node2);
                if (lhsComponent2.getLogical()) {
                    ((Defrule)hasLHS).setLogicalInformation((LogicalNode)node2);
                }
                ++compileConditionalElements;
            }
            else {
                compileConditionalElements = this.compileConditionalElements(lhsComponent2, hasLHS, hashtable, hashtable2, array, compileConditionalElements, rete, false);
            }
        }
        return compileConditionalElements;
    }
    
    private final void buildPatternNetwork(final HasLHS hasLHS, final Pattern pattern, final Hashtable hashtable, final Hashtable hashtable2, final Node[] array, final int n) throws JessException {
        array[n] = this.firstPass(hasLHS, pattern, hashtable, hashtable2);
        array[n] = this.secondPass(hasLHS, pattern, array[n]);
    }
    
    private final boolean noNotsAboveOrBelow(final LHSComponent lhsComponent, final LHSComponent lhsComponent2) {
        boolean b = false;
        if (!lhsComponent.getName().equals("not") && !lhsComponent2.getLHSComponent(0).getName().equals("test") && lhsComponent2.getLHSComponent(0) instanceof Pattern) {
            b = true;
        }
        return b;
    }
    
    private final void addRTLAdapter(final int n, final Node[] array, final HasLHS hasLHS) throws JessException {
        final Node mergeSuccessor = array[n].mergeSuccessor(new Node1RTL(), hasLHS);
        array[n] = mergeSuccessor;
        final Node1RTL logicalInformation = (Node1RTL)mergeSuccessor;
        if (hasLHS.getLHSComponent(n).getLogical()) {
            ((Defrule)hasLHS).setLogicalInformation(logicalInformation);
        }
    }
    
    private final int hashValueFor(final HasLHS hasLHS) {
        int n = hasLHS.getNodeIndexHash();
        if (n == 0) {
            n = this.m_hashkey;
        }
        return n;
    }
    
    private final Value eval(final Hashtable hashtable, final Value value) throws JessException {
        if (value.type() != 64) {
            return value;
        }
        final Funcall funcall = (Funcall)value.funcallValue(null).clone();
        for (int i = 0; i < funcall.size(); ++i) {
            final Value value2 = funcall.get(i);
            if (value2 instanceof Variable) {
                final String variableValue = value2.variableValue(null);
                final BindingValue bindingValue = hashtable.get(variableValue);
                if (bindingValue != null) {
                    funcall.set(bindingValue, i);
                }
                else if (variableValue.charAt(0) != '*') {
                    this.compilerError("eval", "Unbound variable found in funcall: " + variableValue);
                }
            }
            else if (value2.type() == 64) {
                funcall.set(this.eval(hashtable, value2), i);
            }
        }
        return new FuncallValue(funcall);
    }
    
    private final boolean checkForMultiPattern(final Value value, final Pattern pattern) throws JessException {
        final Funcall funcallValue = value.funcallValue(null);
        for (int i = 1; i < funcallValue.size(); ++i) {
            final Value value2 = funcallValue.get(i);
            if (value2.type() == 4096 && ((BindingValue)value2).getCE() != pattern) {
                return true;
            }
            if (value2.type() == 64 && this.checkForMultiPattern(value2, pattern)) {
                return true;
            }
        }
        return false;
    }
    
    private final Node firstPass(final NodeSink nodeSink, final Pattern pattern, final Hashtable hashtable, final Hashtable hashtable2) throws JessException {
        final Deftemplate deftemplate = pattern.getDeftemplate();
        final boolean equals = pattern.getName().equals("test");
        Node node = this.m_root.mergeSuccessor(equals ? new Node1NONE() : new Node1TECT(pattern.getName()), nodeSink);
        hashtable.put(node, node);
        for (int n = 0; !equals && n < pattern.getNSlots(); ++n) {
            if (deftemplate.getSlotType(n) == 32768) {
                if (pattern.getNMultifieldsInSlot(n) == 0) {
                    final int slotLength = pattern.getSlotLength(n);
                    if (slotLength != -1) {
                        node = node.mergeSuccessor(new Node1MTELN(n, slotLength), nodeSink);
                    }
                }
                else {
                    node = node.mergeSuccessor(new Node1MTMF(n, pattern.getMultifieldFlags(n)), nodeSink);
                }
            }
        }
        for (int n2 = 0; !equals && n2 < pattern.getNSlots(); ++n2) {
            if (pattern.getNTests(n2) != 0) {
                final int n3 = n2;
                for (int i = 0; i < pattern.getNTests(n2); ++i) {
                    final Test1 test = pattern.getTest(n2, i);
                    final Value slotValue = test.m_slotValue;
                    if (slotValue instanceof Variable) {
                        final String variableValue = slotValue.variableValue(null);
                        if (!variableValue.startsWith("*") || !variableValue.endsWith("*")) {
                            continue;
                        }
                    }
                    final Value eval = this.eval(hashtable2, slotValue);
                    if (slotValue.type() != 64 || !this.checkForMultiPattern(eval, pattern)) {
                        node = this.addSimpleTest(node, nodeSink, n3, test, eval);
                    }
                }
            }
        }
        return node;
    }
    
    private final Node secondPass(final NodeSink nodeSink, final Pattern pattern, Node addMultipleReferenceTest) throws JessException {
        if (pattern.getName().equals("test")) {
            return addMultipleReferenceTest;
        }
        this.m_doneVars.clear();
        for (int i = 0; i < pattern.getNSlots(); ++i) {
            if (pattern.getNTests(i) != 0) {
                for (int j = 0; j < pattern.getNTests(i); ++j) {
                    final Test1 test = pattern.getTest(i, j);
                    if (test.m_slotValue instanceof Variable) {
                        final String variableValue = test.m_slotValue.variableValue(null);
                        if (this.m_doneVars.get(variableValue) == null) {
                            for (int k = i; k < pattern.getNSlots(); ++k) {
                                if (pattern.getNTests(k) != 0) {
                                    for (int l = 0; l < pattern.getNTests(k); ++l) {
                                        final Test1 test2 = pattern.getTest(k, l);
                                        if (test2 != test) {
                                            if (test2.m_slotValue instanceof Variable && test2.m_slotValue.equals(test.m_slotValue)) {
                                                addMultipleReferenceTest = this.addMultipleReferenceTest(addMultipleReferenceTest, i, test, k, test2, nodeSink);
                                            }
                                        }
                                    }
                                }
                            }
                            this.m_doneVars.put(variableValue, variableValue);
                        }
                    }
                }
            }
        }
        return addMultipleReferenceTest;
    }
    
    private final Node thirdPass(final HasLHS hasLHS, final Pattern pattern, final Node node, final Node node2, final Hashtable hashtable, final boolean b) throws JessException {
        int n = hasLHS.getNodeIndexHash();
        if (n == 0) {
            n = this.m_hashkey;
        }
        this.m_doneVars.clear();
        final boolean equals = pattern.getName().equals("test");
        NodeJoin nodeJoin;
        if (equals) {
            nodeJoin = new NodeJoin();
        }
        else if (b) {
            nodeJoin = new NodeNot2Single(n);
        }
        else {
            nodeJoin = new Node2(n);
        }
        if (pattern.getBoundName() != null) {
            final BindingValue bindingValue = hashtable.get(pattern.getBoundName());
            if (bindingValue.getCE() != pattern) {
                nodeJoin.addTest(0, bindingValue.getFactNumber(), bindingValue.getSlotIndex(), bindingValue.getSubIndex(), -1, -1);
            }
        }
        for (int i = 0; i < pattern.getNSlots(); ++i) {
            if (pattern.getNTests(i) != 0) {
                for (int j = 0; j < pattern.getNTests(i); ++j) {
                    final Test1 test = pattern.getTest(i, j);
                    if (test.m_slotValue instanceof Variable) {
                        final String variableValue = pattern.getTest(i, j).m_slotValue.variableValue(null);
                        if (this.m_doneVars.get(variableValue) == null) {
                            if (!variableValue.startsWith("*")) {
                                final BindingValue bindingValue2 = hashtable.get(variableValue);
                                if (bindingValue2 == null) {
                                    this.compilerError("addRule", "Corrupted VarTable: var " + variableValue + " not in table");
                                }
                                else if (bindingValue2.getCE() == pattern) {
                                    continue;
                                }
                                nodeJoin.addTest(test.m_test, bindingValue2.getFactNumber(), bindingValue2.getSlotIndex(), bindingValue2.getSubIndex(), i, test.m_subIdx);
                                this.m_doneVars.put(variableValue, variableValue);
                            }
                        }
                    }
                    else if (test.m_slotValue.type() == 64) {
                        if (pattern.getDeftemplate().getBackwardChaining()) {
                            throw new JessException("ReteCompiler.addRule", "Can't use funcalls in backchained patterns", pattern.getName());
                        }
                        final Value eval = this.eval(hashtable, test.m_slotValue);
                        if (equals || this.checkForMultiPattern(eval, pattern)) {
                            if (test.m_test == 0) {
                                nodeJoin.addTest(0, test.m_subIdx, eval);
                            }
                            else {
                                nodeJoin.addTest(1, test.m_subIdx, eval);
                            }
                        }
                    }
                }
            }
        }
        final NodeJoin addJoinNode = this.addJoinNode(nodeJoin, node, node2, hasLHS);
        addJoinNode.complete();
        if (pattern.getDeftemplate().getBackwardChaining() && !pattern.getExplicit() && !pattern.getNegated()) {
            ((Node2)addJoinNode).setBackchainInfo(pattern, hasLHS);
        }
        return addJoinNode;
    }
    
    private final NodeJoin addJoinNode(final NodeJoin nodeJoin, final Node node, final Node node2, final NodeSink nodeSink) throws JessException {
        final NodeJoin nodeJoin2 = (NodeJoin)node.resolve(nodeJoin);
        if (nodeJoin2 != nodeJoin && nodeJoin2 == node2.resolve(nodeJoin)) {
            nodeSink.addNode(nodeJoin2);
            return nodeJoin2;
        }
        node.addSuccessor(nodeJoin, nodeSink);
        node2.addSuccessor(nodeJoin, nodeSink);
        return nodeJoin;
    }
    
    private final Node addSimpleTest(final Node node, final NodeSink nodeSink, final int n, final Test1 test1, final Value value) throws JessException {
        Node1 node2 = null;
        Label_0140: {
            switch (test1.m_test) {
                case 0: {
                    switch (test1.m_subIdx) {
                        case -1: {
                            node2 = new Node1TEQ(n, value);
                            break;
                        }
                        default: {
                            node2 = new Node1MTEQ(n, test1.m_subIdx, value);
                            break;
                        }
                    }
                    break;
                }
                default: {
                    switch (test1.m_subIdx) {
                        case -1: {
                            node2 = new Node1TNEQ(n, value);
                            break Label_0140;
                        }
                        default: {
                            node2 = new Node1MTNEQ(n, test1.m_subIdx, value);
                            break Label_0140;
                        }
                    }
                    break;
                }
            }
        }
        return node.mergeSuccessor(node2, nodeSink);
    }
    
    private final Node addMultipleReferenceTest(final Node node, final int n, final Test1 test1, final int n2, final Test1 test2, final NodeSink nodeSink) throws JessException {
        if (test1.m_test == 0) {
            if (test2.m_test == 0) {
                return node.mergeSuccessor(new Node1TEV1(n, test1.m_subIdx, n2, test2.m_subIdx), nodeSink);
            }
            return node.mergeSuccessor(new Node1TNEV1(n, test1.m_subIdx, n2, test2.m_subIdx), nodeSink);
        }
        else {
            if (test2.m_test == 0) {
                return node.mergeSuccessor(new Node1TNEV1(n, test1.m_subIdx, n2, test2.m_subIdx), nodeSink);
            }
            return node;
        }
    }
    
    private final void compilerError(final String s, final String s2) throws RuleCompilerException {
        throw new RuleCompilerException("ReteCompiler." + s, s2);
    }

    public ReteCompiler() {
        this.m_hashkey = 101;
        this.m_root = new RootNode();
        this.m_doneVars = new Hashtable();
    }
}
