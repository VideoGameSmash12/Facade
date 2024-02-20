package jess;

import java.util.Iterator;
import java.util.ArrayList;
import java.io.Serializable;

public class Defquery extends HasLHS implements Serializable
{
    public static final String QUERY_TRIGGER = "__query-trigger-";
    private ArrayList m_results;
    private ArrayList m_queryVariables;
    private int m_maxBackgroundRules;
    
    public int getMaxBackgroundRules() {
        return this.m_maxBackgroundRules;
    }
    
    public void setMaxBackgroundRules(final int maxBackgroundRules) {
        this.m_maxBackgroundRules = maxBackgroundRules;
    }
    
    public synchronized void callNodeLeft(final Token token, final Context context) throws JessException {
        this.broadcastEvent(32768, token);
        if (token.m_tag == 0 || (this.m_new && token.m_tag == 2)) {
            this.m_results.add(token);
        }
        else if (token.m_tag == 1) {
            this.m_results.remove(token);
        }
        else if (token.m_tag == 3) {
            this.m_results.clear();
        }
    }
    
    synchronized Iterator getResults() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   java/util/ArrayList.<init>:()V
        //     7: astore_1       
        //     8: aload_0        
        //     9: astore_2       
        //    10: goto            74
        //    13: aload_2        
        //    14: getfield        jess/Defquery.m_results:Ljava/util/ArrayList;
        //    17: astore_3       
        //    18: goto            25
        //    21: aload           4
        //    23: monitorexit    
        //    24: athrow         
        //    25: aload_3        
        //    26: dup            
        //    27: astore          4
        //    29: monitorenter   
        //    30: aload_3        
        //    31: invokevirtual   java/util/ArrayList.size:()I
        //    34: istore          7
        //    36: iconst_0       
        //    37: istore          8
        //    39: goto            56
        //    42: aload_1        
        //    43: aload_3        
        //    44: iload           8
        //    46: invokevirtual   java/util/ArrayList.get:(I)Ljava/lang/Object;
        //    49: invokevirtual   java/util/ArrayList.add:(Ljava/lang/Object;)Z
        //    52: pop            
        //    53: iinc            8, 1
        //    56: iload           8
        //    58: iload           7
        //    60: if_icmplt       42
        //    63: aload           4
        //    65: monitorexit    
        //    66: aload_2        
        //    67: invokevirtual   jess/Defquery.getNext:()Ljess/HasLHS;
        //    70: checkcast       Ljess/Defquery;
        //    73: astore_2       
        //    74: aload_2        
        //    75: ifnonnull       13
        //    78: aload_1        
        //    79: invokevirtual   java/util/ArrayList.iterator:()Ljava/util/Iterator;
        //    82: areturn        
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  21     24     21     25     Any
        //  30     66     21     25     Any
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
    
    synchronized void clearResults() {
        this.m_results = new ArrayList();
        final Defquery defquery = (Defquery)this.getNext();
        if (defquery != null) {
            defquery.clearResults();
        }
    }
    
    synchronized int countResults() {
        int size = this.m_results.size();
        final Defquery defquery = (Defquery)this.getNext();
        if (defquery != null) {
            size += defquery.countResults();
        }
        return size;
    }
    
    public String getQueryTriggerName() {
        final String displayName = this.getDisplayName();
        return RU.scopeName(this.getModule(), "__query-trigger-" + displayName.substring(displayName.indexOf("::") + 2));
    }
    
    void freeze(final Rete rete) throws JessException {
        if (this.m_frozen) {
            return;
        }
        super.freeze(rete);
        final Pattern pattern = new Pattern(this.getQueryTriggerName(), rete);
        int n = 0;
        final Iterator<Variable> iterator = this.m_queryVariables.iterator();
        while (iterator.hasNext()) {
            pattern.addTest("__data", new Test1(0, n, iterator.next()));
            ++n;
        }
        this.insertCEAt(pattern, 0, rete);
    }
    
    void addQueryVariable(final Variable variable) {
        this.m_queryVariables.add(variable);
    }
    
    int getNVariables() {
        return this.m_queryVariables.size();
    }
    
    Variable getQueryVariable(final int n) {
        return this.m_queryVariables.get(n);
    }
    
    void addCE(final LHSComponent lhsComponent, final Rete rete) throws JessException {
        if (lhsComponent.getLogical()) {
            throw new JessException("Defquery.addCE", "Can't use logical CE in defquery", "");
        }
        super.addCE(lhsComponent, rete);
    }
    
    public String toString() {
        return "Defquery " + this.getName();
    }
    
    public Object accept(final Visitor visitor) {
        return visitor.visitDefquery(this);
    }
    
    private final /* synthetic */ void this() {
        this.m_results = new ArrayList();
        this.m_queryVariables = new ArrayList();
        this.m_maxBackgroundRules = 0;
    }
    
    Defquery(final String s, final String s2, final Rete rete) throws JessException {
        super(s, s2, rete);
        this.this();
    }
}
