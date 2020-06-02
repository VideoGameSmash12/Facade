package TemplateCompiler;

import jess.JessEvent;
import jess.JessListener;
import jess.ValueVector;
import java.util.Iterator;
import jess.Context;
import java.util.Collection;
import java.util.Vector;
import jess.Defrule;
import java.io.Reader;
import jess.Jesp;
import java.io.StringReader;
import jess.Value;
import jess.JessException;
import java.util.LinkedList;
import java.util.List;
import jess.Fact;
import java.util.Enumeration;
import java.util.Hashtable;
import jess.Rete;

public class RefCountRete extends Rete
{
    private int sharedRuleRefs;
    private int uniqueRules;
    private int redefinedRules;
    private Hashtable ruletable;
    private Hashtable facttable;
    private static final /* synthetic */ boolean $noassert;
    
    public int getSharedRuleRefs() {
        return this.sharedRuleRefs;
    }
    
    public int getUniqueRules() {
        return this.uniqueRules;
    }
    
    public int getRedefinedRules() {
        return this.redefinedRules;
    }
    
    void printSharedRuleKeys() {
        final Enumeration<Object> keys = this.ruletable.keys();
        while (keys.hasMoreElements()) {
            System.out.println(keys.nextElement());
        }
    }
    
    private final void addFactToTable(final Fact fact) throws JessException {
        if (this.findFactByFact(fact) == null) {
            final String name = fact.getName();
            final String substring = name.substring(name.indexOf(":") + 2, name.length());
            final List<Fact> list = this.facttable.get(substring);
            if (list == null) {
                final LinkedList<Fact> list2 = new LinkedList<Fact>();
                list2.add(fact);
                this.facttable.put(substring, list2);
            }
            else {
                list.add(fact);
            }
        }
    }
    
    private final void removeFactFromTable(final Fact fact) throws JessException {
        if (this.findFactByFact(fact) != null) {
            final String name = fact.getName();
            final String substring = name.substring(name.indexOf(":") + 2, name.length());
            final List list = this.facttable.get(substring);
            if (!RefCountRete.$noassert && list == null) {
                throw new AssertionError((Object)("factList == null, name == " + substring));
            }
            if (!RefCountRete.$noassert && !list.contains(fact)) {
                throw new AssertionError((Object)("!factList.contains(f), name == " + substring));
            }
            list.remove(fact);
            if (list.size() == 0) {
                this.facttable.remove(substring);
            }
        }
    }
    
    public Value executeCommands(final String s) throws JessException {
        return new Jesp(new StringReader(s), this).parse(false);
    }
    
    Value defineRule(final String s, final int n, final String s2) throws JessException {
        if (this.ruletable.containsKey(s)) {
            ++this.sharedRuleRefs;
            this.ruletable.put(s, new Integer(this.ruletable.get(s) + 1));
            final Defrule defrule = (Defrule)this.findDefrule(s);
            if (!RefCountRete.$noassert && defrule == null) {
                throw new AssertionError();
            }
            if (n > defrule.getSalience()) {
                ++this.redefinedRules;
                this.unDefrule(s);
                this.executeCommand("(defrule " + s + s2 + ')');
            }
        }
        else {
            ++this.uniqueRules;
            this.ruletable.put(s, new Integer(1));
            this.executeCommand("(defrule " + s + s2 + ')');
        }
        return new Value("TRUE", 1);
    }
    
    public void conditionalRetract(final String s, final int n, final int n2) {
        try {
            final List<? extends Fact> list = this.facttable.get(s);
            if (list == null) {
                return;
            }
            final Vector vector = new Vector<Fact>(list);
            final Context globalContext = this.getGlobalContext();
            for (final Fact fact : vector) {
                final ValueVector listValue = fact.get(0).listValue(globalContext);
                int intValue;
                if (listValue.get(0).stringValue(globalContext).equals("any")) {
                    intValue = Integer.MAX_VALUE;
                }
                else {
                    intValue = listValue.get(0).intValue(globalContext);
                }
                int intValue2;
                if (listValue.get(1).stringValue(globalContext).equals("any")) {
                    intValue2 = Integer.MIN_VALUE;
                }
                else {
                    intValue2 = listValue.get(1).intValue(globalContext);
                }
                if (intValue >= n && intValue2 <= n2) {
                    super.retract(fact);
                }
            }
        }
        catch (JessException ex) {
            JessExceptionHelper.processJessException(ex);
        }
    }
    
    public Value getHashValue(final String s) throws JessException {
        if (this.ruletable.containsKey(s)) {
            System.out.println(this.ruletable.get(s));
            return new Value("TRUE", 1);
        }
        return new Value("FALSE", 1);
    }
    
    public Value undefineRule(final ValueVector valueVector, final Context context) throws JessException {
        final String s = new String();
        for (int size = valueVector.size(), i = 1; i < size; ++i) {
            final String stringValue = valueVector.get(i).stringValue(context);
            if (this.ruletable.containsKey(stringValue)) {
                final Integer n = this.ruletable.get(stringValue);
                if (n == 1) {
                    this.ruletable.remove(stringValue);
                    this.executeCommand("(undefrule " + stringValue + ')');
                }
                else {
                    this.ruletable.put(stringValue, new Integer(n - 1));
                }
            }
        }
        return new Value("FALSE", 1);
    }
    
    private final /* synthetic */ void this() {
        this.sharedRuleRefs = 0;
        this.uniqueRules = 0;
        this.redefinedRules = 0;
        this.ruletable = new Hashtable(15000);
        this.facttable = new Hashtable(4000);
    }
    
    public RefCountRete() {
        this.this();
        this.addJessListener(new FactTableListener());
    }
    
    static {
        $noassert = (Class.forName("[LTemplateCompiler.RefCountRete;").getComponentType().desiredAssertionStatus() ^ true);
    }
    
    class FactTableListener implements JessListener
    {
        public void eventHappened(final JessEvent jessEvent) throws JessException {
            final int type = jessEvent.getType();
            if ((type & 0x10) != 0x0) {
                final Fact fact = (Fact)jessEvent.getObject();
                if (!fact.getName().equals("MAIN::anaphoricRef")) {
                    if ((type & Integer.MIN_VALUE) == 0x0) {
                        RefCountRete.this.addFactToTable(fact);
                    }
                    else if ((type & Integer.MIN_VALUE) != 0x0) {
                        RefCountRete.this.removeFactFromTable(fact);
                    }
                }
            }
            if ((type & 0x1000) != 0x0) {
                RefCountRete.this.facttable.clear();
            }
        }
        
        public FactTableListener() {
        }
    }
}
