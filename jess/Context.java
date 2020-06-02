package jess;

import java.util.Enumeration;
import java.util.Hashtable;
import java.io.Serializable;

public class Context implements Serializable
{
    private Hashtable m_variables;
    private Context m_parent;
    private boolean m_return;
    private Value m_retval;
    private transient Rete m_rete;
    private LogicalNode m_logicalSupportNode;
    private Token m_token;
    private Fact m_fact;
    private boolean m_inAdvice;
    
    public final Token getToken() {
        return this.m_token;
    }
    
    final void setToken(final Token token) {
        this.m_token = token;
    }
    
    public final Fact getFact() {
        return this.m_fact;
    }
    
    final void setFact(final Fact fact) {
        this.m_fact = fact;
    }
    
    public final LogicalNode getLogicalSupportNode() {
        return this.m_logicalSupportNode;
    }
    
    final void setLogicalSupportNode(final LogicalNode logicalSupportNode) {
        this.m_logicalSupportNode = logicalSupportNode;
    }
    
    boolean getInAdvice() {
        return this.m_inAdvice;
    }
    
    void setInAdvice(final boolean inAdvice) {
        this.m_inAdvice = inAdvice;
    }
    
    void setEngine(final Rete rete) {
        this.m_rete = rete;
    }
    
    void clear() {
        this.m_fact = null;
        this.m_token = null;
        this.m_inAdvice = false;
        this.m_logicalSupportNode = null;
        this.m_return = false;
        this.m_retval = null;
        this.m_variables = null;
    }
    
    public final boolean returning() {
        return this.m_return;
    }
    
    public final Value setReturnValue(final Value retval) {
        this.m_return = true;
        return this.m_retval = retval;
    }
    
    public final Value getReturnValue() {
        return this.m_retval;
    }
    
    public final void clearReturnValue() {
        this.m_return = false;
        this.m_retval = null;
    }
    
    private final int nVariables() {
        if (this.m_variables == null) {
            return 0;
        }
        return this.m_variables.size();
    }
    
    private final Hashtable getVariables() {
        if (this.m_variables == null) {
            this.m_variables = new Hashtable(10);
        }
        return this.m_variables;
    }
    
    public final Rete getEngine() {
        return this.m_rete;
    }
    
    public Context push() {
        return new Context(this);
    }
    
    public Context pop() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        jess/Context.m_parent:Ljess/Context;
        //     4: ifnull          49
        //     7: goto            13
        //    10: aload_1        
        //    11: monitorexit    
        //    12: athrow         
        //    13: aload_0        
        //    14: getfield        jess/Context.m_parent:Ljess/Context;
        //    17: dup            
        //    18: astore_1       
        //    19: monitorenter   
        //    20: aload_0        
        //    21: getfield        jess/Context.m_parent:Ljess/Context;
        //    24: aload_0        
        //    25: getfield        jess/Context.m_return:Z
        //    28: putfield        jess/Context.m_return:Z
        //    31: aload_0        
        //    32: getfield        jess/Context.m_parent:Ljess/Context;
        //    35: aload_0        
        //    36: getfield        jess/Context.m_retval:Ljess/Value;
        //    39: putfield        jess/Context.m_retval:Ljess/Value;
        //    42: aload_0        
        //    43: getfield        jess/Context.m_parent:Ljess/Context;
        //    46: aload_1        
        //    47: monitorexit    
        //    48: areturn        
        //    49: aload_0        
        //    50: areturn        
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  10     12     10     13     Any
        //  20     48     10     13     Any
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
    
    private final Hashtable findVariable(final String s) {
        for (Context parent = this; parent != null; parent = parent.m_parent) {
            final Hashtable variables = parent.getVariables();
            if (variables.get(s) != null) {
                return variables;
            }
        }
        return null;
    }
    
    synchronized void removeNonGlobals() {
        if (this.m_variables == null) {
            return;
        }
        final Hashtable<String, Object> variables = new Hashtable<String, Object>(10);
        final Enumeration<String> keys = this.m_variables.keys();
        while (keys.hasMoreElements()) {
            final String s = keys.nextElement();
            if (this.m_rete.findDefglobal(s) != null) {
                variables.put(s, this.m_variables.get(s));
            }
        }
        this.m_variables = variables;
    }
    
    public Value getVariable(final String s) throws JessException {
        final Hashtable variable = this.findVariable(s);
        if (variable == null) {
            throw new JessException("Context.getVariable", "No such variable", s);
        }
        return variable.get(s).resolveValue(this);
    }
    
    public void setVariable(final String s, final Value value) throws JessException {
        Hashtable hashtable = this.findVariable(s);
        if (hashtable == null) {
            hashtable = this.getVariables();
        }
        hashtable.put(s, value);
    }
    
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append("[Context, " + this.nVariables() + " variables: ");
        final Enumeration<Object> keys = this.getVariables().keys();
        while (keys.hasMoreElements()) {
            final Object nextElement = keys.nextElement();
            sb.append(new StringBuffer().append(nextElement).append('=').append(this.m_variables.get(nextElement)).append(';').toString());
        }
        sb.append("]");
        return sb.toString();
    }
    
    public Context(final Context parent) {
        this.m_rete = parent.m_rete;
        this.m_parent = parent;
    }
    
    Context(final Rete rete) {
        this.m_rete = rete;
        this.m_parent = null;
    }
    
    public Context(final Context parent, final Rete rete) {
        this.m_rete = rete;
        this.m_parent = parent;
    }
}
