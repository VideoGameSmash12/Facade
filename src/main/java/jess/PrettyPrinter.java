package jess;

import java.util.Iterator;

public class PrettyPrinter implements Visitor
{
    private Visitable m_visitable;
    private boolean m_inTestCE;
    
    public Object visitDeffacts(final Deffacts deffacts) {
        final List list = new List("deffacts", deffacts.getName());
        if (deffacts.getDocstring() != null && deffacts.getDocstring().length() > 0) {
            list.addQuoted(deffacts.getDocstring());
        }
        for (int i = 0; i < deffacts.getNFacts(); ++i) {
            list.newLine();
            list.add(deffacts.getFact(i));
        }
        return list.toString();
    }
    
    public Object visitDeftemplate(final Deftemplate deftemplate) {
        final List list = new List("deftemplate", deftemplate.getName());
        if (deftemplate.getParent() != null && deftemplate.getParent() != deftemplate) {
            list.add("extends");
            list.add(deftemplate.getParent().getName());
        }
        if (deftemplate.getDocstring() != null && deftemplate.getDocstring().length() > 0) {
            list.addQuoted(deftemplate.getDocstring());
        }
        for (int i = 0; i < deftemplate.m_data.size(); i += 3) {
            try {
                final Value value = deftemplate.m_data.get(i);
                final List list2 = new List((value.type() == 16384) ? "slot" : "multislot", value);
                final Value value2 = deftemplate.m_data.get(i + 1);
                if (!value2.equals(Funcall.NIL) && !value2.equals(Funcall.NILLIST)) {
                    list2.add(new List((value2.type() == 64) ? "default-dynamic" : "default", value2));
                }
                final Value value3 = deftemplate.m_data.get(i + 2);
                if (value3.intValue(null) != -1) {
                    list2.add(new List("type", value3));
                }
                list.newLine();
                list.add(list2);
            }
            catch (JessException ex) {
                list.add(ex.toString());
                break;
            }
        }
        return list.toString();
    }
    
    public Object visitDefglobal(final Defglobal defglobal) {
        final List list = new List("defglobal");
        list.add("?" + defglobal.getName());
        list.add("=");
        list.add(defglobal.getInitializationValue());
        return list.toString();
    }
    
    public Object visitDeffunction(final Deffunction deffunction) {
        final List list = new List("deffunction", deffunction.getName());
        final List list2 = new List();
        final Iterator arguments = deffunction.getArguments();
        while (arguments.hasNext()) {
            final Deffunction.Argument argument = arguments.next();
            list2.add(((argument.m_type == 8) ? "?" : "$?") + argument.m_name);
        }
        list.add(list2);
        if (deffunction.getDocstring() != null && deffunction.getDocstring().length() > 0) {
            list.addQuoted(deffunction.getDocstring());
        }
        final Iterator actions = deffunction.getActions();
        while (actions.hasNext()) {
            list.newLine();
            list.add(actions.next());
        }
        return list.toString();
    }
    
    public Object visitDefrule(final Defrule defrule) {
        final List list = new List("defrule");
        list.add(defrule.getName());
        list.indent("  ");
        if (defrule.m_docstring != null && defrule.m_docstring.length() > 0) {
            list.newLine();
            list.addQuoted(defrule.m_docstring);
        }
        int n = 0;
        final List list2 = new List("declare");
        try {
            if (defrule.m_salienceVal.type() != 4 || defrule.m_salienceVal.intValue(null) != 0) {
                final List list3 = new List("salience");
                list3.add(defrule.m_salienceVal);
                list2.add(list3);
                n = 1;
            }
        }
        catch (JessException ex) {}
        if (defrule.getAutoFocus()) {
            if (n != 0) {
                list2.indent("           ");
                list2.newLine();
            }
            final List list4 = new List("auto-focus");
            list4.add("TRUE");
            list2.add(list4);
            n = 1;
        }
        if (n != 0) {
            list.newLine();
            list.add(list2);
        }
        for (int i = 0; i < defrule.getGroupSize(); ++i) {
            final LHSComponent lhsComponent = defrule.getLHSComponent(i);
            list.newLine();
            list.add(((Visitable)lhsComponent).accept(this));
        }
        list.newLine();
        list.add("=>");
        for (int j = 0; j < defrule.getNActions(); ++j) {
            list.newLine();
            list.add(defrule.getAction(j).toString());
        }
        return list.toString();
    }
    
    public Object visitGroup(final Group group) {
        final List list = new List(group.getName());
        for (int i = 0; i < group.getGroupSize(); ++i) {
            list.add(((Visitable)group.getLHSComponent(i)).accept(this));
        }
        if (group.getBoundName() != null) {
            return "?" + group.getBoundName() + " <- " + list.toString();
        }
        return list.toString();
    }
    
    public Object visitPattern(final Pattern pattern) {
        final List list = new List(pattern.getName());
        final Deftemplate deftemplate = pattern.getDeftemplate();
        this.m_inTestCE = pattern.getName().equals("test");
        try {
            for (int i = 0; i < pattern.getNSlots(); ++i) {
                if (pattern.getNTests(i) != 0) {
                    List list2;
                    if (deftemplate.getSlotName(i).equals("__data")) {
                        list2 = list;
                    }
                    else {
                        list2 = new List(deftemplate.getSlotName(i));
                    }
                    for (int j = -1; j <= pattern.getSlotLength(i); ++j) {
                        final StringBuffer sb = new StringBuffer();
                        for (int k = 0; k < pattern.getNTests(i); ++k) {
                            final Test1 test = pattern.getTest(i, k);
                            if (test.m_subIdx == j) {
                                if (sb.length() > 0) {
                                    sb.append("&");
                                }
                                sb.append(test.accept(this));
                            }
                        }
                        if (sb.length() > 0) {
                            list2.add(sb);
                        }
                    }
                    if (!deftemplate.getSlotName(i).equals("__data")) {
                        list.add(list2);
                    }
                }
            }
        }
        catch (JessException ex) {
            list.add(ex.getMessage());
        }
        if (pattern.getBoundName() != null) {
            return "?" + pattern.getBoundName() + " <- " + list.toString();
        }
        return list.toString();
    }
    
    public Object visitTest1(final Test1 test1) {
        final StringBuffer sb = new StringBuffer();
        if (test1.m_test == 1) {
            sb.append("~");
        }
        if (test1.m_slotValue.type() == 64 && !this.m_inTestCE) {
            sb.append(":");
        }
        sb.append(test1.m_slotValue);
        return sb.toString();
    }
    
    public Object visitDefquery(final Defquery defquery) {
        final List list = new List("defquery");
        list.add(defquery.getName());
        list.indent("  ");
        if (defquery.m_docstring != null && defquery.m_docstring.length() > 0) {
            list.newLine();
            list.addQuoted(defquery.m_docstring);
        }
        if (defquery.getNVariables() > 0 || defquery.getMaxBackgroundRules() > 0) {
            list.newLine();
            final List list2 = new List("declare");
            if (defquery.getNVariables() > 0) {
                final List list3 = new List("variables");
                for (int i = 0; i < defquery.getNVariables(); ++i) {
                    list3.add(defquery.getQueryVariable(i));
                }
                list2.add(list3);
            }
            if (defquery.getMaxBackgroundRules() > 0) {
                final List list4 = new List("max-background-rules");
                list4.add(String.valueOf(defquery.getMaxBackgroundRules()));
                list2.add(list4);
            }
            list.add(list2);
        }
        for (int j = 0; j < defquery.getGroupSize(); ++j) {
            final LHSComponent lhsComponent = defquery.getLHSComponent(j);
            if (lhsComponent.getName().indexOf("__query-trigger-") == -1) {
                list.newLine();
                list.add(((Visitable)lhsComponent).accept(this));
            }
        }
        return list.toString();
    }
    
    public String toString() {
        return (String)this.m_visitable.accept(this);
    }
    
    private final /* synthetic */ void this() {
        this.m_inTestCE = false;
    }
    
    public PrettyPrinter(final Visitable visitable) {
        this.this();
        this.m_visitable = visitable;
    }
}
