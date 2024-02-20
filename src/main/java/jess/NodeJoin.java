package jess;

import java.io.Serializable;

class NodeJoin extends Node implements Serializable
{
    private static Accelerator m_accelerator;
    private static boolean m_acceleratorChecked;
    int m_nTests;
    TestBase[] m_tests;
    
    void complete() throws JessException {
    }
    
    void addTest(final int n, final int n2, final Value value) throws JessException {
        TestBase speedup = null;
        final Funcall funcallValue = value.funcallValue(null);
        this.loadAccelerator();
        if (NodeJoin.m_accelerator != null) {
            speedup = NodeJoin.m_accelerator.speedup(funcallValue);
        }
        if (speedup == null) {
            speedup = new Test1(n, n2, value);
        }
        this.addTest(speedup);
    }
    
    void addTest(final TestBase testBase) {
        if (this.m_nTests == this.m_tests.length) {
            final TestBase[] tests = new TestBase[this.m_nTests * 2];
            System.arraycopy(this.m_tests, 0, tests, 0, this.m_nTests);
            this.m_tests = tests;
        }
        this.m_tests[this.m_nTests++] = testBase;
    }
    
    void addTest(final int n, final int n2, final int n3, final int n4, final int n5, final int n6) throws JessException {
        throw new JessException("NodeJoin:addtest", "Can't add Test2s to this class", "");
    }
    
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }
        final NodeJoin nodeJoin = (NodeJoin)o;
        if (nodeJoin instanceof NodeNot2 || nodeJoin instanceof NodeNot2Single) {
            return false;
        }
        if (nodeJoin.m_nTests != this.m_nTests) {
            return false;
        }
        int i = 0;
    Label_0108:
        while (i < this.m_nTests) {
            final TestBase testBase = this.m_tests[i];
            for (int j = 0; j < this.m_nTests; ++j) {
                if (testBase.equals(nodeJoin.m_tests[j])) {
                    ++i;
                    continue Label_0108;
                }
            }
            return false;
        }
        return true;
    }
    
    void callNodeLeft(Token token, final Context context) throws JessException {
        this.broadcastEvent(32768, token);
        if (token.m_tag == 3) {
            this.passAlong(token, context);
            return;
        }
        final int nTests = this.m_nTests;
        boolean runTests;
        if (token.m_tag == 1 || nTests == 0) {
            runTests = true;
        }
        else {
            runTests = this.runTests(token, nTests, context);
            token = token.prepare(runTests);
        }
        if (runTests) {
            token = Rete.getFactory().newToken(token, Fact.getNullFact());
            token.updateTime(context.getEngine());
            this.passAlong(token, context);
        }
    }
    
    boolean runTests(final Token token, final int n, final Context context) throws JessException {
        try {
            context.setToken(token);
            for (int i = 0; i < n; ++i) {
                if (!this.m_tests[i].doTest(context)) {
                    return false;
                }
            }
            return true;
        }
        catch (JessException ex) {
            ex.addContext("'test' CE");
            throw ex;
        }
    }
    
    void loadAccelerator() throws JessException {
        if (!NodeJoin.m_acceleratorChecked) {
            NodeJoin.m_acceleratorChecked = true;
            final String property;
            if ((property = RU.getProperty("SPEEDUP")) != null) {
                try {
                    NodeJoin.m_accelerator = (Accelerator)Class.forName(property).newInstance();
                }
                catch (Exception ex) {
                    throw new JessException("NodeJoin.addTest", "Can't load Accelerator class " + property, ex.getMessage());
                }
            }
        }
    }
    
    void passAlong(final Token token, final Context context) throws JessException {
        final Node[] succ = this.m_succ;
        for (int i = 0; i < this.m_nSucc; ++i) {
            succ[i].callNodeLeft(token, context);
        }
    }
    
    public String toString() {
        final StringBuffer sb = new StringBuffer(256);
        sb.append("[NodeJoin ntests=");
        sb.append(this.m_nTests);
        sb.append(" ");
        for (int i = 0; i < this.m_nTests; ++i) {
            sb.append(this.m_tests[i].toString());
            sb.append(" ");
        }
        sb.append(";usecount = ");
        sb.append(this.m_usecount);
        sb.append("]");
        return sb.toString();
    }
    
    String getCompilationTraceToken() {
        return "2";
    }
    
    private final /* synthetic */ void this() {
        this.m_nTests = 0;
        this.m_tests = new TestBase[2];
    }
    
    NodeJoin() {
        this.this();
    }
}
