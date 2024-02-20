package jess;

import java.util.ArrayList;
import java.io.Serializable;

public class Deffacts implements Serializable, Visitable
{
    private String m_name;
    private String m_module;
    private ArrayList m_facts;
    private String m_docstring;
    
    public final String getName() {
        return this.m_name;
    }
    
    public final String getModule() {
        return this.m_module;
    }
    
    public final String getDocstring() {
        return this.m_docstring;
    }
    
    public void addFact(final Fact fact) {
        this.m_facts.add(fact);
    }
    
    public int getNFacts() {
        return this.m_facts.size();
    }
    
    public Fact getFact(final int n) {
        return this.m_facts.get(n);
    }
    
    public void reset(final Rete rete) throws JessException {
        try {
            final Context globalContext = rete.getGlobalContext();
            for (int i = 0; i < this.m_facts.size(); ++i) {
                rete.assertFact(((Fact)this.m_facts.get(i)).expand(globalContext), rete.getGlobalContext());
            }
        }
        catch (JessException ex) {
            ex.addContext("assert from deffacts " + this.m_name);
            throw ex;
        }
    }
    
    public String toString() {
        return "[deffacts " + this.m_name + ']';
    }
    
    public Object accept(final Visitor visitor) {
        return visitor.visitDeffacts(this);
    }
    
    private final /* synthetic */ void this() {
        this.m_docstring = "";
    }
    
    public Deffacts(final String name, final String docstring, final Rete rete) throws JessException {
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
        this.m_facts = new ArrayList();
        this.m_docstring = docstring;
    }
}
