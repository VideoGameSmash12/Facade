package jess;

import java.util.Map;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.Serializable;

class Node2 extends NodeJoin implements LogicalNode, Serializable
{
    TokenTree m_left;
    TokenTree m_right;
    private int m_rightIdx;
    private int m_rightSubIdx;
    private int m_leftIdx;
    private int m_leftSubIdx;
    private int m_tokenIdx;
    private int m_tokenSize;
    protected int m_hashkey;
    Pattern m_pattern;
    HasLHS m_defrule;
    public int m_matches;
    private boolean m_blessed;
    protected HashMap m_logicalDepends;
    
    void addTest(final int n, final int n2, final int n3, final int n4, final int n5, final int n6) {
        if (n4 == -1 && n6 == -1) {
            this.addTest(new Test2Simple(n, n2, n3, n5));
        }
        else {
            this.addTest(new Test2Multi(n, n2, n3, n4, n5, n6));
        }
    }
    
    void callNodeLeft(final Token token, final Context context) throws JessException {
        try {
            this.m_matches = 0;
            switch (token.m_tag) {
                case 0:
                case 2: {
                    try {
                        this.m_tokenSize = token.size();
                        final TokenTree left = this.m_left;
                        boolean b = false;
                        if (token.m_tag == 2) {
                            b = true;
                        }
                        left.add(token, b);
                    }
                    catch (NullPointerException ex2) {
                        throw new JessException("Node2.callNode", "Negated conjunction with", "unbound variables");
                    }
                    this.runTestsVaryRight(token, this.m_right, context);
                    this.askForBackChain(token, context);
                    break;
                }
                case 1: {
                    if (this.m_left.remove(token)) {
                        this.runTestsVaryRight(token, this.m_right, context);
                    }
                    break;
                }
                case 3: {
                    this.initTokenTrees();
                    if (this.m_logicalDepends != null) {
                        this.m_logicalDepends.clear();
                    }
                    this.passAlong(token, context);
                    break;
                }
                default: {
                    throw new JessException("Node2.callNode", "Bad tag in token", token.m_tag);
                }
            }
            this.broadcastEvent(32768, token);
        }
        catch (JessException ex) {
            ex.addContext("rule LHS (Node2)");
            throw ex;
        }
    }
    
    protected void removeLogicalSupportFrom(final Token token, final Context context) {
        final ArrayList<Fact> list = this.m_logicalDepends.remove(token);
        if (list != null) {
            final Rete engine = context.getEngine();
            for (int i = 0; i < list.size(); ++i) {
                engine.removeLogicalSupportFrom(token, list.get(i));
            }
        }
    }
    
    void callNodeRight(final Token token, final Context context) throws JessException {
        try {
            final int tag = token.m_tag;
            switch (tag) {
                case 0:
                case 2: {
                    final TokenTree right = this.m_right;
                    boolean b = false;
                    if (tag == 2) {
                        b = true;
                    }
                    right.add(token, b);
                    this.runTestsVaryLeft(token, this.m_left, context);
                    break;
                }
                case 1: {
                    if (this.m_right.remove(token)) {
                        this.runTestsVaryLeft(token, this.m_left, context);
                    }
                    break;
                }
                case 3: {
                    break;
                }
                default: {
                    throw new JessException("Node2.callNode", "Bad tag in token", tag);
                }
            }
            this.broadcastEvent(32769, token);
        }
        catch (JessException ex) {
            ex.addContext("rule LHS (Node2)");
            throw ex;
        }
    }
    
    void debugPrint(final Token token, final int n) {
        System.out.println("TEST " + this.toString() + '(' + this.hashCode() + ");calltype=" + n + ";tag=" + token.m_tag + ";class=" + token.fact(0).getName());
    }
    
    void runTestsVaryRight(final Token token, final TokenTree tokenTree, final Context context) throws JessException {
        if (!this.m_blessed) {
            this.doRunTestsVaryRight(token, tokenTree, context);
            return;
        }
        Value value;
        if (this.m_leftSubIdx == -1) {
            value = token.fact(this.m_tokenIdx).get(this.m_leftIdx);
        }
        else {
            value = token.fact(this.m_tokenIdx).get(this.m_leftIdx).listValue(null).get(this.m_leftSubIdx);
        }
        final TokenVector codeInTree;
        if ((codeInTree = tokenTree.findCodeInTree(value.hashCode(), false)) == null) {
            return;
        }
        this.doRunTestsVaryRight(token, codeInTree, context);
    }
    
    void doRunTestsVaryRight(final Token token, final TokenTree tokenTree, final Context context) throws JessException {
        if (tokenTree == null) {
            return;
        }
        final int hash = tokenTree.m_hash;
        final TokenVector[] tokens = tokenTree.m_tokens;
        for (int i = 0; i < hash; ++i) {
            if (this.doRunTestsVaryRight(token, tokens[i], context)) {
                return;
            }
        }
    }
    
    boolean doRunTestsVaryRight(Token prepare, final TokenVector tokenVector, final Context context) throws JessException {
        if (tokenVector != null) {
            final int size = tokenVector.size();
            final int nTests = this.m_nTests;
            final int tag = prepare.m_tag;
            for (int i = 0; i < size; ++i) {
                context.setToken(prepare);
                final Token element = tokenVector.elementAt(i);
                final boolean runTests;
                if (runTests = this.runTests(nTests, context, element)) {
                    if (tag != 1) {
                        ++this.m_matches;
                    }
                    if (nTests != 0) {
                        prepare = prepare.prepare(runTests);
                    }
                    final Token token = Rete.getFactory().newToken(prepare, element);
                    this.passAlong(token, context);
                    if (this.m_logicalDepends != null && tag != 2) {
                        this.removeLogicalSupportFrom(token, context);
                    }
                }
            }
        }
        return false;
    }
    
    void runTestsVaryLeft(final Token token, final TokenTree tokenTree, final Context context) throws JessException {
        if (tokenTree == null) {
            return;
        }
        if (!this.m_blessed) {
            this.doRunTestsVaryLeft(token, tokenTree, context);
            return;
        }
        final Fact topFact = token.topFact();
        Value value;
        if (this.m_rightSubIdx == -1) {
            value = topFact.get(this.m_rightIdx);
        }
        else {
            value = topFact.get(this.m_rightIdx).listValue(null).get(this.m_rightSubIdx);
        }
        final TokenVector codeInTree;
        if ((codeInTree = tokenTree.findCodeInTree(value.hashCode(), false)) == null) {
            return;
        }
        this.doRunTestsVaryLeft(token, codeInTree, context);
    }
    
    void doRunTestsVaryLeft(final Token token, final TokenTree tokenTree, final Context context) throws JessException {
        if (tokenTree == null) {
            return;
        }
        for (int i = 0; i < tokenTree.m_hash; ++i) {
            this.doRunTestsVaryLeft(token, tokenTree.m_tokens[i], context);
        }
    }
    
    void doRunTestsVaryLeft(final Token token, final TokenVector tokenVector, final Context context) throws JessException {
        if (tokenVector != null) {
            final int size = tokenVector.size();
            if (size > 0) {
                final int nTests = this.m_nTests;
                for (int i = 0; i < size; ++i) {
                    Token token2 = tokenVector.elementAt(i);
                    context.setToken(token2);
                    final boolean runTests;
                    if (runTests = this.runTests(nTests, context, token)) {
                        if (nTests != 0) {
                            token2 = token2.prepare(runTests);
                        }
                        final Token token3 = Rete.getFactory().newToken(token2, token);
                        token3.m_tag = token.m_tag;
                        this.passAlong(token3, context);
                        if (this.m_logicalDepends != null && token3.m_tag != 2) {
                            this.removeLogicalSupportFrom(token3, context);
                        }
                    }
                }
            }
        }
    }
    
    boolean runTests(final int n, final Context context, final Token token) throws JessException {
        final TestBase[] tests = this.m_tests;
        context.setFact(token.topFact());
        for (int i = 0; i < n; ++i) {
            if (!tests[i].doTest(context)) {
                return false;
            }
        }
        return true;
    }
    
    void setBackchainInfo(final Pattern pattern, final HasLHS defrule) {
        this.m_pattern = pattern;
        this.m_defrule = defrule;
    }
    
    private final void askForBackChain(final Token token, final Context context) throws JessException {
        if (this.m_pattern == null || this.m_matches != 0) {
            return;
        }
        final Fact fact = new Fact(this.m_pattern.getBackchainingTemplateName(), context.getEngine());
        for (int i = 0; i < this.m_pattern.getNSlots(); ++i) {
            final int slotType = this.m_pattern.getDeftemplate().getSlotType(i);
            Value value = Funcall.NIL;
            ValueVector valueVector = null;
            if (slotType == 32768) {
                valueVector = new ValueVector();
            }
            for (int j = 0; j < this.m_pattern.getNTests(i); ++j) {
                final Test1 test = this.m_pattern.getTest(i, j);
                if (test.m_test == 0) {
                    if (test.m_slotValue instanceof Variable) {
                        final BindingValue bindingValue = this.m_defrule.getBindings().get(test.m_slotValue.variableValue(null));
                        if (bindingValue == null) {
                            value = test.m_slotValue;
                        }
                        else if (bindingValue.getFactNumber() < token.size()) {
                            value = token.fact(bindingValue.getFactNumber()).get(bindingValue.getSlotIndex());
                            if (bindingValue.getSubIndex() != -1) {
                                value = value.listValue(null).get(bindingValue.getSubIndex());
                            }
                        }
                        if (slotType == 16384) {
                            break;
                        }
                    }
                    else {
                        value = test.m_slotValue;
                        if (slotType == 16384) {
                            break;
                        }
                    }
                    if (slotType == 32768) {
                        if (valueVector.size() < test.m_subIdx + 1) {
                            valueVector.setLength(test.m_subIdx + 1);
                        }
                        valueVector.set(value, test.m_subIdx);
                        value = Funcall.NIL;
                    }
                }
            }
            if (slotType == 32768) {
                for (int k = 0; k < valueVector.size(); ++k) {
                    if (valueVector.get(k) == null) {
                        valueVector.set(Funcall.NIL, k);
                    }
                }
                value = new Value(valueVector, 512);
            }
            fact.set(value, i);
            final Value nil = Funcall.NIL;
        }
        final Rete engine = context.getEngine();
        final Fact fact2 = fact;
        boolean b = false;
        if (this.m_matches == 0) {
            b = true;
        }
        engine.setPendingFact(fact2, b);
    }
    
    public String toString() {
        final StringBuffer sb = new StringBuffer(256);
        sb.append("[Node2 ntests=");
        sb.append(this.m_nTests);
        sb.append(" ");
        for (int i = 0; i < this.m_nTests; ++i) {
            sb.append(this.m_tests[i].toString());
            sb.append(" ");
        }
        sb.append(";usecount = ");
        sb.append(this.m_usecount);
        if (this.m_blessed) {
            sb.append(";blessed");
        }
        sb.append("]");
        return sb.toString();
    }
    
    private final void readObject(final ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
    }
    
    protected void initTokenTrees() {
        boolean b = false;
        if (this.m_leftIdx == -1) {
            b = true;
        }
        final boolean b2 = b;
        int tokenIdx = 0;
        if (!b2) {
            tokenIdx = this.m_tokenIdx;
        }
        final int n = tokenIdx;
        if (this.m_left == null) {
            this.m_left = new TokenTree(this.m_hashkey, b2, n, this.m_leftIdx, this.m_leftSubIdx);
        }
        else {
            this.m_left.clear();
        }
        if (this.m_right == null) {
            final int hashkey = this.m_hashkey;
            boolean b3 = false;
            if (this.m_rightIdx == -1) {
                b3 = true;
            }
            this.m_right = new TokenTree(hashkey, b3, 0, this.m_rightIdx, this.m_rightSubIdx);
        }
        else {
            this.m_right.clear();
        }
    }
    
    StringBuffer displayMemory() {
        final StringBuffer sb = new StringBuffer("*** Left Memory:\n");
        for (int i = 0; i < this.m_left.m_hash; ++i) {
            final TokenVector tokenVector = this.m_left.m_tokens[i];
            if (tokenVector != null) {
                for (int j = 0; j < tokenVector.size(); ++j) {
                    sb.append(tokenVector.elementAt(j));
                    sb.append("\n");
                }
            }
        }
        sb.append("*** RightMemory:\n");
        for (int k = 0; k < this.m_right.m_hash; ++k) {
            final TokenVector tokenVector2 = this.m_right.m_tokens[k];
            if (tokenVector2 != null) {
                for (int l = 0; l < tokenVector2.size(); ++l) {
                    sb.append(tokenVector2.elementAt(l));
                    sb.append("\n");
                }
            }
        }
        return sb;
    }
    
    void complete() throws JessException {
        this.loadAccelerator();
        for (int i = 0; i < this.m_nTests; ++i) {
            final TestBase testBase = this.m_tests[i];
            if (testBase instanceof Test2Simple) {
                final Test2Simple test2Simple = (Test2Simple)testBase;
                if (test2Simple.getTest()) {
                    if (test2Simple.getRightIndex() != -1 && test2Simple.getLeftIndex() != -1) {
                        if (i > 0) {
                            final TestBase testBase2 = this.m_tests[0];
                            this.m_tests[0] = test2Simple;
                            this.m_tests[i] = testBase2;
                        }
                        this.m_rightIdx = test2Simple.getRightIndex();
                        this.m_tokenIdx = test2Simple.getTokenIndex();
                        this.m_leftIdx = test2Simple.getLeftIndex();
                        this.m_blessed = true;
                        break;
                    }
                }
            }
        }
        if (!this.m_blessed) {
            for (int j = 0; j < this.m_nTests; ++j) {
                final TestBase testBase3 = this.m_tests[j];
                if (testBase3 instanceof Test2Multi) {
                    final Test2Multi test2Multi = (Test2Multi)testBase3;
                    if (test2Multi.getTest()) {
                        if (test2Multi.getRightIndex() != -1 && test2Multi.getLeftIndex() != -1) {
                            if (j > 0) {
                                final TestBase testBase4 = this.m_tests[0];
                                this.m_tests[0] = test2Multi;
                                this.m_tests[j] = testBase4;
                            }
                            this.m_rightIdx = test2Multi.getRightIndex();
                            this.m_rightSubIdx = test2Multi.getRightSubIndex();
                            this.m_tokenIdx = test2Multi.getTokenIndex();
                            this.m_leftIdx = test2Multi.getLeftIndex();
                            this.m_leftSubIdx = test2Multi.getLeftSubIndex();
                            this.m_blessed = true;
                            break;
                        }
                    }
                }
            }
        }
        this.initTokenTrees();
    }
    
    public int getTokenSize() {
        return this.m_tokenSize + 1;
    }
    
    public void dependsOn(final Fact p0, final Token p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        jess/Node2.m_logicalDepends:Ljava/util/HashMap;
        //     4: ifnonnull       18
        //     7: aload_0        
        //     8: new             Ljava/util/HashMap;
        //    11: dup            
        //    12: invokespecial   java/util/HashMap.<init>:()V
        //    15: putfield        jess/Node2.m_logicalDepends:Ljava/util/HashMap;
        //    18: aload_0        
        //    19: getfield        jess/Node2.m_logicalDepends:Ljava/util/HashMap;
        //    22: aload_2        
        //    23: invokevirtual   java/util/HashMap.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    26: checkcast       Ljava/util/ArrayList;
        //    29: astore_3       
        //    30: aload_3        
        //    31: ifnonnull       52
        //    34: new             Ljava/util/ArrayList;
        //    37: dup            
        //    38: invokespecial   java/util/ArrayList.<init>:()V
        //    41: astore_3       
        //    42: aload_0        
        //    43: getfield        jess/Node2.m_logicalDepends:Ljava/util/HashMap;
        //    46: aload_2        
        //    47: aload_3        
        //    48: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    51: pop            
        //    52: goto            59
        //    55: aload           4
        //    57: monitorexit    
        //    58: athrow         
        //    59: aload_3        
        //    60: dup            
        //    61: astore          4
        //    63: monitorenter   
        //    64: aload_3        
        //    65: aload_1        
        //    66: invokevirtual   java/util/ArrayList.add:(Ljava/lang/Object;)Z
        //    69: pop            
        //    70: aload           4
        //    72: monitorexit    
        //    73: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  55     58     55     59     Any
        //  64     73     55     59     Any
        // 
        // The error that occurred was:
        // 
        // java.util.ConcurrentModificationException
        //     at java.util.ArrayList$Itr.checkForComodification(Unknown Source)
        //     at java.util.ArrayList$Itr.next(Unknown Source)
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2863)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2445)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public Map getLogicalDependencies() {
        return this.m_logicalDepends;
    }
    
    private final /* synthetic */ void this() {
        this.m_rightIdx = -1;
        this.m_rightSubIdx = -1;
        this.m_leftIdx = -1;
        this.m_leftSubIdx = -1;
        this.m_tokenIdx = 0;
        this.m_matches = 0;
        this.m_blessed = false;
    }
    
    Node2(final int hashkey) {
        this.this();
        this.m_hashkey = hashkey;
    }
}
