package jess;

import java.io.Reader;
import java.util.Enumeration;
import java.util.ArrayList;
import java.util.Hashtable;

public class Jesp
{
    private static final String JAVACALL = "call";
    private JessTokenStream m_jts;
    private Rete m_rete;
    
    public Value parse(final boolean b) throws JessException {
        return this.parse(b, this.m_rete.getGlobalContext());
    }
    
    public synchronized Value parse(final boolean b, final Context context) throws JessException {
        Value true;
        Value sexp = true = Funcall.TRUE;
        if (b) {
            this.m_rete.getOutStream().print("Jess> ");
            this.m_rete.getOutStream().flush();
        }
        while (!sexp.equals(Funcall.EOF)) {
            true = sexp;
            sexp = this.parseSexp(context);
            if (b) {
                if (!sexp.equals(Funcall.NIL)) {
                    if (sexp.type() == 512) {
                        this.m_rete.getOutStream().print('(');
                    }
                    this.m_rete.getOutStream().print(sexp);
                    if (sexp.type() == 512) {
                        this.m_rete.getOutStream().print(')');
                    }
                    this.m_rete.getOutStream().println();
                }
                this.m_rete.getOutStream().print("Jess> ");
                this.m_rete.getOutStream().flush();
            }
        }
        return true;
    }
    
    public void clear() {
        this.m_jts.clear();
    }
    
    public Value loadFacts(final Context context) throws JessException {
        for (JessToken jessToken = this.m_jts.nextToken(); jessToken.m_ttype != 0; jessToken = this.m_jts.nextToken()) {
            this.m_jts.pushBack(jessToken);
            this.m_rete.assertFact(this.parseFact(), context);
        }
        return Funcall.TRUE;
    }
    
    private final Value parseSexp(final Context context) throws JessException {
        try {
            final JessToken nextToken = this.m_jts.nextToken();
            switch (nextToken.m_ttype) {
                case 1:
                case 2:
                case 4:
                case 8:
                case 32:
                case 8192: {
                    return nextToken.tokenToValue(context);
                }
                case 40: {
                    this.m_jts.pushBack(nextToken);
                    final String head = this.m_jts.head();
                    if (head.equals("defrule")) {
                        return this.parseDefrule(context);
                    }
                    if (head.equals("defquery")) {
                        return this.parseDefquery(context);
                    }
                    if (head.equals("deffacts")) {
                        return this.parseDeffacts();
                    }
                    if (head.equals("deftemplate")) {
                        return this.parseDeftemplate(context);
                    }
                    if (head.equals("deffunction")) {
                        return this.parseDeffunction();
                    }
                    if (head.equals("defglobal")) {
                        return this.parseDefglobal();
                    }
                    if (head.equals("defmodule")) {
                        return this.parseDefmodule();
                    }
                    if (head.equals("EOF")) {
                        return Funcall.EOF;
                    }
                    return this.parseAndExecuteFuncall(null, context);
                }
                case 0: {
                    if ("EOF".equals(nextToken.m_sval)) {
                        return Funcall.EOF;
                    }
                    break;
                }
            }
            throw new JessException("Jesp.parseSexp", "Expected a '(', constant, or global variable", nextToken.toString());
        }
        catch (JessException ex) {
            if (ex instanceof ParseException) {
                throw ex;
            }
            ex.setLineNumber(this.m_jts.lineno());
            ex.setProgramText(this.m_jts.toString());
            this.m_jts.clear();
            throw ex;
        }
    }
    
    private final Value parseDefmodule() throws JessException {
        if (this.m_jts.nextToken().m_ttype != 40 || !this.m_jts.nextToken().m_sval.equals("defmodule")) {
            this.parseError("parseDefmodule", "Expected (defmodule...");
        }
        final JessToken nextToken = this.m_jts.nextToken();
        if (nextToken.m_ttype != 1) {
            this.parseError("parseDefmodule", "Expected module name");
        }
        final JessToken nextToken2 = this.m_jts.nextToken();
        if (nextToken2.m_ttype == 2) {
            this.m_rete.addDefmodule(nextToken.m_sval, nextToken2.m_sval);
        }
        else if (nextToken2.m_ttype == 41) {
            this.m_rete.addDefmodule(nextToken.m_sval);
        }
        else {
            this.parseError("parseDefmodule", "Expected ')'");
        }
        return Funcall.TRUE;
    }
    
    private final Value parseDefglobal() throws JessException {
        if (this.m_jts.nextToken().m_ttype != 40 || !this.m_jts.nextToken().m_sval.equals("defglobal")) {
            this.parseError("parseDefglobal", "Expected (defglobal...");
        }
        JessToken nextToken;
        while ((nextToken = this.m_jts.nextToken()).m_ttype != 41) {
            if (nextToken.m_ttype != 8) {
                this.parseError("parseDefglobal", "Expected a variable name");
            }
            if (nextToken.m_sval.charAt(0) != '*' || nextToken.m_sval.charAt(nextToken.m_sval.length() - 1) != '*') {
                this.parseError("parseDefglobal", "Defglobal names must start and end with an asterisk!");
            }
            if (this.m_jts.nextToken().m_ttype != 61) {
                this.parseError("parseDefglobal", "Expected =");
            }
            final JessToken nextToken2 = this.m_jts.nextToken();
            switch (nextToken2.m_ttype) {
                case 1:
                case 2:
                case 4:
                case 8:
                case 32:
                case 40:
                case 8192: {
                    this.m_rete.addDefglobal(new Defglobal(nextToken.m_sval, this.tokenToValue(nextToken2)));
                    continue;
                }
                default: {
                    this.parseError("parseDefglobal", "Bad value");
                    continue;
                }
            }
        }
        return Funcall.TRUE;
    }
    
    private final Funcall parseFuncall() throws JessException {
        ValueVector valueVector = null;
        if (this.m_jts.nextToken().m_ttype != 40) {
            this.parseError("parseFuncall", "Expected '('");
        }
        final JessToken nextToken = this.m_jts.nextToken();
        switch (nextToken.m_ttype) {
            case 1: {
                valueVector = new Funcall(nextToken.m_sval, this.m_rete);
                break;
            }
            case 61: {
                valueVector = new Funcall("=".intern(), this.m_rete);
                break;
            }
            case 8: {
                valueVector = new Funcall("call", this.m_rete);
                valueVector.add(new Variable(nextToken.m_sval, 8));
                break;
            }
            case 40: {
                valueVector = new Funcall("call", this.m_rete);
                this.m_jts.pushBack(nextToken);
                valueVector.add(new FuncallValue(this.parseFuncall()));
                break;
            }
            default: {
                this.parseError("parseFuncall", "Bad functor");
                break;
            }
        }
        final String stringValue = valueVector.get(0).stringValue(null);
        for (JessToken jessToken = this.m_jts.nextToken(); jessToken.m_ttype != 41; jessToken = this.m_jts.nextToken()) {
            switch (jessToken.m_ttype) {
                case 1:
                case 2:
                case 4:
                case 8:
                case 32:
                case 8192: {
                    valueVector.add(this.tokenToValue(jessToken));
                    break;
                }
                case 40: {
                    this.m_jts.pushBack(jessToken);
                    if (stringValue.equals("assert")) {
                        valueVector.add(new FactIDValue(this.parseFact()));
                        break;
                    }
                    if ((stringValue.equals("modify") || stringValue.equals("duplicate")) && valueVector.size() > 1) {
                        valueVector.add(new Value(this.parseValuePair(), 512));
                        break;
                    }
                    valueVector.add(new FuncallValue(this.parseFuncall()));
                    break;
                }
                case 0: {
                    this.parseError("parseFuncall", "Unexpected EOF");
                    break;
                }
                default: {
                    valueVector.add(new Value(String.valueOf((char)jessToken.m_ttype), 2));
                    break;
                }
            }
        }
        return (Funcall)valueVector;
    }
    
    private final ValueVector parseValuePair() throws JessException {
        final ValueVector valueVector = new ValueVector(2);
        JessToken nextToken = null;
        if (this.m_jts.nextToken().m_ttype != 40 || (nextToken = this.m_jts.nextToken()).m_ttype != 1) {
            this.parseError("parseValuePair", "Expected '( <atom>'");
        }
        valueVector.add(new Value(nextToken.m_sval, 1));
        JessToken nextToken2;
        do {
            switch ((nextToken2 = this.m_jts.nextToken()).m_ttype) {
                case 1:
                case 2:
                case 4:
                case 8:
                case 32:
                case 40:
                case 8192: {
                    valueVector.add(this.tokenToValue(nextToken2));
                    continue;
                }
                case 41: {
                    continue;
                }
                default: {
                    this.parseError("parseValuePair", "Bad argument");
                    continue;
                }
            }
        } while (nextToken2.m_ttype != 41);
        return valueVector;
    }
    
    private final Value parseDeffacts() throws JessException {
        final JessToken nextToken;
        if (this.m_jts.nextToken().m_ttype != 40 || (nextToken = this.m_jts.nextToken()).m_ttype != 1 || !nextToken.m_sval.equals("deffacts")) {
            this.parseError("parseDeffacts", "Expected '( deffacts'");
        }
        final JessToken nextToken2;
        if ((nextToken2 = this.m_jts.nextToken()).m_ttype != 1) {
            this.parseError("parseDeffacts", "Expected deffacts name");
        }
        final String sval = nextToken2.m_sval;
        JessToken jessToken = this.m_jts.nextToken();
        String sval2 = "";
        if (jessToken.m_ttype == 2) {
            sval2 = jessToken.m_sval;
            jessToken = this.m_jts.nextToken();
        }
        final Deffacts deffacts = new Deffacts(sval, sval2, this.m_rete);
        this.m_rete.setCurrentModule(deffacts.getModule());
        while (jessToken.m_ttype == 40) {
            this.m_jts.pushBack(jessToken);
            deffacts.addFact(this.parseFact());
            jessToken = this.m_jts.nextToken();
        }
        if (jessToken.m_ttype != 41) {
            this.parseError("parseDeffacts", "Expected ')'");
        }
        this.m_rete.addDeffacts(deffacts);
        return Funcall.TRUE;
    }
    
    Fact parseFact() throws JessException {
        String sval = "__data";
        JessToken nextToken = null;
        if (this.m_jts.nextToken().m_ttype != 40 || (nextToken = this.m_jts.nextToken()).m_ttype != 1) {
            this.parseError("parseFact", "Expected '( <atom>'");
        }
        final String sval2 = nextToken.m_sval;
        boolean b = false;
        final Deftemplate deftemplate = this.m_rete.createDeftemplate(sval2);
        if (deftemplate.getSlotIndex("__data") == 0) {
            b = true;
        }
        final Fact fact = new Fact(sval2, this.m_rete);
        JessToken jessToken;
        for (jessToken = this.m_jts.nextToken(); jessToken.m_ttype != 41; jessToken = this.m_jts.nextToken()) {
            if (!b) {
                if (jessToken.m_ttype != 40) {
                    this.parseError("parseFact", "Expected '('");
                }
                final JessToken nextToken2;
                if ((nextToken2 = this.m_jts.nextToken()).m_ttype != 1) {
                    this.parseError("parseFact", "Bad slot name");
                }
                sval = nextToken2.m_sval;
                jessToken = this.m_jts.nextToken();
            }
            final int slotIndex = deftemplate.getSlotIndex(sval);
            if (slotIndex == -1) {
                throw new JessException("Jesp.parseFact", "No such slot " + sval + " in template", deftemplate.getName());
            }
            switch (deftemplate.getSlotType(slotIndex)) {
                case 16384: {
                    switch (jessToken.m_ttype) {
                        case 1:
                        case 2:
                        case 4:
                        case 8:
                        case 32:
                        case 8192: {
                            fact.setSlotValue(sval, this.tokenToValue(jessToken));
                            break;
                        }
                        case 61: {
                            jessToken = this.m_jts.nextToken();
                            if (jessToken.m_ttype != 40) {
                                throw new JessException("Jesp.parseFact", "'=' cannot appear as an atom within a fact", "");
                            }
                        }
                        case 40: {
                            this.m_jts.pushBack(jessToken);
                            fact.setSlotValue(sval, new FuncallValue(this.parseFuncall()));
                            break;
                        }
                        default: {
                            this.parseError("parseFact", "Bad slot value");
                            break;
                        }
                    }
                    if ((jessToken = this.m_jts.nextToken()).m_ttype != 41) {
                        this.parseError("parseFact", "Expected ')'");
                    }
                    break;
                }
                case 32768: {
                    final ValueVector valueVector = new ValueVector();
                    while (jessToken.m_ttype != 41) {
                        switch (jessToken.m_ttype) {
                            case 1:
                            case 2:
                            case 4:
                            case 8:
                            case 32:
                            case 8192: {
                                valueVector.add(this.tokenToValue(jessToken));
                                break;
                            }
                            case 61: {
                                jessToken = this.m_jts.nextToken();
                                if (jessToken.m_ttype != 40) {
                                    throw new JessException("Jesp.parseFact", "'=' cannot appear as an atom within a fact", "");
                                }
                            }
                            case 40: {
                                this.m_jts.pushBack(jessToken);
                                valueVector.add(new FuncallValue(this.parseFuncall()));
                                break;
                            }
                            default: {
                                this.parseError("parseFact", "Bad slot value");
                                break;
                            }
                        }
                        jessToken = this.m_jts.nextToken();
                    }
                    fact.setSlotValue(sval, new Value(valueVector, 512));
                    break;
                }
                default: {
                    this.parseError("parseFact", "No such slot in deftemplate");
                    break;
                }
            }
            if (b) {
                break;
            }
        }
        if (jessToken.m_ttype != 41) {
            this.parseError("parseFact", "Expected ')'");
        }
        return fact;
    }
    
    private final Value parseDeftemplate(final Context context) throws JessException {
        if (this.m_jts.nextToken().m_ttype != 40 || !this.m_jts.nextToken().m_sval.equals("deftemplate")) {
            this.parseError("parseDeftemplate", "Expected (deftemplate...");
        }
        final JessToken nextToken;
        if ((nextToken = this.m_jts.nextToken()).m_ttype != 1) {
            this.parseError("parseDeftemplate", "Expected deftemplate name");
        }
        final String sval = nextToken.m_sval;
        String sval2 = "";
        String sval3 = null;
        JessToken jessToken;
        if ((jessToken = this.m_jts.nextToken()).m_ttype == 1) {
            if (jessToken.m_sval.equals("extends")) {
                final JessToken nextToken2 = this.m_jts.nextToken();
                if (nextToken2.m_ttype == 1) {
                    sval3 = nextToken2.m_sval;
                }
                else {
                    this.parseError("parseDeftemplate", "Expected deftemplate name to extend");
                }
            }
            else {
                this.parseError("parseDeftemplate", "Expected '(' or 'extends'");
            }
            jessToken = this.m_jts.nextToken();
        }
        if (jessToken.m_ttype == 2) {
            sval2 = jessToken.m_sval;
            jessToken = this.m_jts.nextToken();
        }
        Deftemplate deftemplate;
        if (sval3 == null) {
            deftemplate = new Deftemplate(sval, sval2, this.m_rete);
        }
        else {
            deftemplate = new Deftemplate(sval, sval2, this.m_rete.findDeftemplate(sval3), this.m_rete);
        }
        while (jessToken.m_ttype == 40) {
            final JessToken nextToken3;
            if ((nextToken3 = this.m_jts.nextToken()).m_ttype != 1 || (!nextToken3.m_sval.equals("slot") && !nextToken3.m_sval.equals("multislot"))) {
                this.parseError("parseDeftemplate", "Bad slot type");
            }
            final int n = nextToken3.m_sval.equals("slot") ? 16384 : 32768;
            final JessToken nextToken4;
            if ((nextToken4 = this.m_jts.nextToken()).m_ttype != 1) {
                this.parseError("parseDeftemplate", "Bad slot name");
            }
            final String sval4 = nextToken4.m_sval;
            Value value = (n == 16384) ? Funcall.NIL : Funcall.NILLIST;
            String sval5 = "ANY";
            JessToken jessToken2;
            for (jessToken2 = this.m_jts.nextToken(); jessToken2.m_ttype == 40; jessToken2 = this.m_jts.nextToken()) {
                final JessToken nextToken5;
                if ((nextToken5 = this.m_jts.nextToken()).m_ttype != 1) {
                    this.parseError("parseDeftemplate", "Slot qualifier must be atom");
                }
                final String sval6 = nextToken5.m_sval;
                if (sval6.equalsIgnoreCase("default") || sval6.equalsIgnoreCase("default-dynamic")) {
                    final JessToken nextToken6 = this.m_jts.nextToken();
                    switch (nextToken6.m_ttype) {
                        case 1:
                        case 2:
                        case 4:
                        case 32: {
                            value = this.tokenToValue(nextToken6);
                            break;
                        }
                        case 40: {
                            if (sval6.equalsIgnoreCase("default-dynamic")) {
                                this.m_jts.pushBack(nextToken6);
                                value = new FuncallValue(this.parseFuncall());
                            }
                            else {
                                value = this.parseAndExecuteFuncall(nextToken6, context);
                            }
                            break;
                        }
                        default: {
                            this.parseError("parseDeftemplate", "Illegal default slot value");
                            break;
                        }
                    }
                }
                else if (sval6.equalsIgnoreCase("type")) {
                    if (n == 32768) {
                        this.parseError("parseDeftemplate", "'type' not allowed for multislots");
                    }
                    sval5 = this.m_jts.nextToken().m_sval;
                }
                else {
                    this.parseError("parseDeftemplate", "Unimplemented slot qualifier");
                }
                if (this.m_jts.nextToken().m_ttype != 41) {
                    this.parseError("parseDeftemplate", "Expected ')'");
                }
            }
            if (jessToken2.m_ttype != 41) {
                this.parseError("parseDeftemplate", "Expected ')'");
            }
            if (n == 16384) {
                deftemplate.addSlot(sval4, value, sval5);
            }
            else {
                if (value.type() != 512) {
                    this.parseError("parseDeftemplate", "Default value for multislot " + sval4 + " is not a multifield: " + value);
                }
                deftemplate.addMultiSlot(sval4, value);
            }
            jessToken = this.m_jts.nextToken();
        }
        if (jessToken.m_ttype != 41) {
            this.parseError("parseDeftemplate", "Expected ')'");
        }
        this.m_rete.addDeftemplate(deftemplate);
        return Funcall.TRUE;
    }
    
    private final Value parseDefrule(final Context context) throws JessException {
        return this.doParseDefrule(context);
    }
    
    private final synchronized Value doParseDefrule(final Context context) throws JessException {
        final String[] nameAndDocstring = this.parseNameAndDocstring("defrule");
        final Hashtable hashtable = new Hashtable();
        this.parseDeclarations(hashtable);
        final String moduleFromName = RU.getModuleFromName(nameAndDocstring[0], this.m_rete);
        this.m_rete.setCurrentModule(moduleFromName);
        final LHSComponent lhs = this.parseLHS(moduleFromName);
        final JessToken nextToken;
        if (this.m_jts.nextToken().m_ttype != 61 || (nextToken = this.m_jts.nextToken()).m_ttype != 1 || !nextToken.m_sval.equals(">")) {
            this.parseError("parseDefrule", "Expected '=>'");
        }
        final ArrayList actions = this.parseActions();
        this.expect(41, ")");
        Defrule addARule = null;
        final LHSComponent canonicalize = lhs.canonicalize();
        if (!canonicalize.getName().equals("or")) {
            throw new JessException("Jesp.parseDefrule", "Bogus assumption", "");
        }
        for (int i = 0; i < canonicalize.getGroupSize(); ++i) {
            final LHSComponent lhsComponent = canonicalize.getLHSComponent(i);
            final Group group = new Group("and");
            lhsComponent.addToGroup(group);
            addARule = this.addARule(group, nameAndDocstring, i, hashtable, actions, addARule, context);
        }
        return Funcall.TRUE;
    }
    
    private final Defrule addARule(final Group group, final String[] array, final int n, final Hashtable hashtable, final ArrayList list, final Defrule defrule, final Context context) throws JessException {
        String string = array[0];
        if (n > 0) {
            string = string + '&' + n;
        }
        final Defrule next = new Defrule(string, array[1], this.m_rete);
        final Enumeration<Object> keys = (Enumeration<Object>)hashtable.keys();
        while (keys.hasMoreElements()) {
            final Object nextElement = keys.nextElement();
            final ValueVector valueVector = hashtable.get(nextElement);
            if (nextElement.equals("salience")) {
                next.setSalience(valueVector.get(1), this.m_rete);
            }
            else if (nextElement.equals("node-index-hash")) {
                next.setNodeIndexHash(valueVector.get(1).intValue(context));
            }
            else if (nextElement.equals("auto-focus")) {
                next.setAutoFocus(valueVector.get(1).atomValue(context).equals(Funcall.FALSE) ^ true);
            }
            else {
                this.parseError("parseDefrule", "Invalid declarand: " + nextElement);
            }
        }
        group.addToLHS(next, this.m_rete);
        for (int i = 0; i < list.size(); ++i) {
            next.addAction(list.get(i));
        }
        if (defrule != null) {
            defrule.setNext(next);
        }
        this.m_rete.addDefrule(next);
        return next;
    }
    
    private final String[] parseNameAndDocstring(final String s) throws JessException {
        if (this.m_jts.nextToken().m_ttype != 40 || !this.m_jts.nextToken().m_sval.equals(s)) {
            this.parseError("parseNameAndDocstring", "Expected " + s);
        }
        final JessToken nextToken;
        if ((nextToken = this.m_jts.nextToken()).m_ttype != 1) {
            this.parseError("parseNameAndDocstring", "Expected defrule name");
        }
        final String sval = nextToken.m_sval;
        String sval2 = "";
        final JessToken nextToken2;
        if ((nextToken2 = this.m_jts.nextToken()).m_ttype == 2) {
            sval2 = nextToken2.m_sval;
        }
        else {
            this.m_jts.pushBack(nextToken2);
        }
        return new String[] { sval, sval2 };
    }
    
    private final Hashtable parseDeclarations(final Hashtable hashtable) throws JessException {
        final JessToken nextToken = this.m_jts.nextToken();
        final JessToken nextToken2 = this.m_jts.nextToken();
        if (nextToken2.m_ttype == 1 && nextToken2.m_sval.equals("declare")) {
            JessToken nextToken3;
            while ((nextToken3 = this.m_jts.nextToken()).m_ttype != 41) {
                this.m_jts.pushBack(nextToken3);
                final ValueVector valuePair = this.parseValuePair();
                hashtable.put(valuePair.get(0).atomValue(null), valuePair);
            }
        }
        else {
            this.m_jts.pushBack(nextToken2);
            this.m_jts.pushBack(nextToken);
        }
        return hashtable;
    }
    
    private final ArrayList parseActions() throws JessException {
        JessToken jessToken = this.m_jts.nextToken();
        final ArrayList<Funcall> list = new ArrayList<Funcall>();
        while (jessToken.m_ttype == 40) {
            this.m_jts.pushBack(jessToken);
            list.add(this.parseFuncall());
            jessToken = this.m_jts.nextToken();
        }
        this.m_jts.pushBack(jessToken);
        return list;
    }
    
    private final LHSComponent parseLHS(final String s) throws JessException {
        final Hashtable hashtable = new Hashtable();
        final Group group = new Group("and");
        JessToken jessToken;
        for (jessToken = this.m_jts.nextToken(); jessToken.m_ttype == 40 || jessToken.m_ttype == 8; jessToken = this.m_jts.nextToken()) {
            this.m_jts.pushBack(jessToken);
            group.add(this.parsePattern(hashtable, s));
        }
        this.m_jts.pushBack(jessToken);
        return group;
    }
    
    private final JessToken expect(final int n, final String s) throws JessException {
        final JessToken nextToken = this.m_jts.nextToken();
        if (nextToken.m_ttype != n || !nextToken.m_sval.equals(s)) {
            this.parseError("parseLHS", "Expected '" + s + '\'');
        }
        return nextToken;
    }
    
    LHSComponent parsePattern(final Hashtable hashtable, final String s) throws JessException {
        String sval = "__data";
        String sval2 = null;
        JessToken jessToken = this.m_jts.nextToken();
        if (jessToken.m_ttype == 8) {
            sval2 = jessToken.m_sval;
            this.expect(1, "<-");
            jessToken = this.m_jts.nextToken();
        }
        if (jessToken.m_ttype != 40 || (jessToken = this.m_jts.nextToken()).m_ttype != 1) {
            this.parseError("parsePattern", "Expected '( <atom>'");
        }
        final String sval3 = jessToken.m_sval;
        if (sval3.equals("exists")) {
            final Group group = new Group("not");
            JessToken nextToken;
            while ((nextToken = this.m_jts.nextToken()).m_ttype != 41) {
                this.m_jts.pushBack(nextToken);
                group.add(this.parsePattern(hashtable, s));
            }
            final Group group2 = new Group("not");
            group2.add(group);
            if (sval2 != null) {
                group2.setBoundName(sval2);
            }
            return group2;
        }
        if (sval3.equals("unique")) {
            final LHSComponent pattern = this.parsePattern(hashtable, s);
            if (this.m_jts.nextToken().m_ttype != 41) {
                this.parseError("parsePattern", "Expected ')'");
            }
            if (sval2 != null) {
                pattern.setBoundName(sval2);
            }
            return pattern;
        }
        if (Group.isGroupName(sval3)) {
            final Group group3 = new Group(sval3);
            JessToken nextToken2;
            while ((nextToken2 = this.m_jts.nextToken()).m_ttype != 41) {
                this.m_jts.pushBack(nextToken2);
                group3.add(this.parsePattern(hashtable, s));
            }
            if (sval2 != null) {
                group3.setBoundName(sval2);
            }
            return group3;
        }
        if (sval3.equals("test")) {
            if (sval2 != null) {
                this.parseError("parsePattern", "Can't bind a 'test' CE to a variable");
            }
            final Pattern pattern2 = new Pattern(sval3, this.m_rete);
            pattern2.addTest("__data", new Test1(0, -1, new FuncallValue(this.parseFuncall())));
            if (this.m_jts.nextToken().m_ttype != 41) {
                this.parseError("parsePattern", "Expected ')'");
            }
            return pattern2;
        }
        boolean b = false;
        final Deftemplate deftemplate = this.m_rete.createDeftemplate(sval3);
        final String name = deftemplate.getName();
        if (deftemplate.getSlotIndex("__data") == 0) {
            b = true;
        }
        final Pattern pattern3 = new Pattern(name, this.m_rete);
        for (JessToken jessToken2 = this.m_jts.nextToken(); b || jessToken2.m_ttype == 40; jessToken2 = this.m_jts.nextToken()) {
            if (!b) {
                final JessToken nextToken3;
                if ((nextToken3 = this.m_jts.nextToken()).m_ttype != 1) {
                    this.parseError("parsePattern", "Bad slot name");
                }
                sval = nextToken3.m_sval;
                jessToken2 = this.m_jts.nextToken();
            }
            final int slotIndex = deftemplate.getSlotIndex(sval);
            if (slotIndex == -1) {
                throw new JessException("Jesp.parsePattern", "No such slot " + sval + " in template", deftemplate.getName());
            }
            int n = 0;
            if (deftemplate.getSlotType(slotIndex) == 32768) {
                n = 1;
            }
            final int n2 = n;
            int n3 = n2 - 1;
            int conjunction = 1;
            Test1 test1 = null;
            while (jessToken2.m_ttype != 41) {
                int n4 = 0;
                if (jessToken2.m_ttype == 126) {
                    n4 = 1;
                    jessToken2 = this.m_jts.nextToken();
                }
                switch (jessToken2.m_ttype) {
                    case 8:
                    case 8192: {
                        final Integer n5 = hashtable.get(jessToken2.m_sval);
                        if (n5 == null) {
                            hashtable.put(jessToken2.m_sval, new Integer(jessToken2.m_ttype));
                        }
                        else {
                            jessToken2.m_ttype = n5;
                        }
                        test1 = new Test1(n4, n3, new Variable(jessToken2.m_sval, jessToken2.m_ttype));
                        break;
                    }
                    case 1: {
                        if (jessToken2.m_sval.equals(":")) {
                            test1 = new Test1(n4, n3, new FuncallValue(this.parseFuncall()));
                            break;
                        }
                    }
                    case 2:
                    case 4:
                    case 32: {
                        test1 = new Test1(n4, n3, this.tokenToValue(jessToken2));
                        break;
                    }
                    case 61: {
                        final Funcall funcall = this.parseFuncall();
                        final Funcall funcall2 = new Funcall("eq*", this.m_rete);
                        Value value = null;
                        final int slotIndex2 = pattern3.getDeftemplate().getSlotIndex(sval);
                        if (slotIndex2 == -1) {
                            throw new JessException("Jesp.parsePattern", "No such slot " + sval + " in template", deftemplate.getName());
                        }
                        if (pattern3.getNTests(slotIndex2) > 0) {
                            final Test1 test2 = pattern3.getTest(slotIndex2, 0);
                            if (test2.getTest() == 0) {
                                final Value value2 = test2.getValue();
                                if (value2.type() == 8 && test2.m_subIdx == n3) {
                                    value = value2;
                                }
                            }
                        }
                        if (value == null) {
                            value = new Variable(RU.gensym("__jesp"), 8);
                            pattern3.addTest(sval, new Test1(0, n3, value));
                        }
                        funcall2.add(value);
                        funcall2.add(new FuncallValue(funcall));
                        test1 = new Test1(n4, n3, new FuncallValue(funcall2));
                        break;
                    }
                    default: {
                        this.parseError("parsePattern", "Bad slot value");
                        break;
                    }
                }
                jessToken2 = this.m_jts.nextToken();
                test1.m_conjunction = conjunction;
                if (jessToken2.m_ttype == 38) {
                    jessToken2 = this.m_jts.nextToken();
                }
                else if (jessToken2.m_ttype == 124) {
                    conjunction = 2;
                    jessToken2 = this.m_jts.nextToken();
                }
                else if (n2 == 0 && jessToken2.m_ttype != 41) {
                    this.parseError("parsePattern", sval + " is not a multislot");
                }
                else {
                    ++n3;
                    conjunction = 1;
                }
                pattern3.addTest(sval, test1);
            }
            if (n2 != 0) {
                pattern3.setSlotLength(sval, n3);
            }
            if (b) {
                break;
            }
        }
        if (sval2 != null) {
            pattern3.setBoundName(sval2);
        }
        return pattern3;
    }
    
    private final synchronized Value parseDefquery(final Context context) throws JessException {
        final String[] nameAndDocstring = this.parseNameAndDocstring("defquery");
        final Hashtable hashtable = new Hashtable();
        this.parseDeclarations(hashtable);
        final String moduleFromName = RU.getModuleFromName(nameAndDocstring[0], this.m_rete);
        this.m_rete.setCurrentModule(moduleFromName);
        final LHSComponent lhs = this.parseLHS(moduleFromName);
        final JessToken nextToken = this.m_jts.nextToken();
        if (nextToken.m_ttype != 41) {
            this.parseError("parseDefquery", "Expected ')', got " + nextToken.toString());
        }
        Defquery addAQuery = null;
        final LHSComponent canonicalize = lhs.canonicalize();
        if (!canonicalize.getName().equals("or")) {
            throw new JessException("Jesp.parseDefquery", "Bogus assumption", "");
        }
        for (int i = 0; i < canonicalize.getGroupSize(); ++i) {
            final LHSComponent lhsComponent = canonicalize.getLHSComponent(i);
            final Group group = new Group("and");
            lhsComponent.addToGroup(group);
            addAQuery = this.addAQuery(group, nameAndDocstring, i, hashtable, addAQuery, context);
        }
        return Funcall.TRUE;
    }
    
    private final Defquery addAQuery(final Group group, final String[] array, final int n, final Hashtable hashtable, final Defquery defquery, final Context context) throws JessException {
        String string = array[0];
        if (n > 0) {
            string = string + '&' + n;
        }
        final Defquery next = new Defquery(string, array[1], this.m_rete);
        final Enumeration<Object> keys = (Enumeration<Object>)hashtable.keys();
        while (keys.hasMoreElements()) {
            final Object nextElement = keys.nextElement();
            final ValueVector valueVector = hashtable.get(nextElement);
            if (nextElement.equals("variables")) {
                for (int i = 1; i < valueVector.size(); ++i) {
                    next.addQueryVariable((Variable)valueVector.get(i));
                }
            }
            else if (nextElement.equals("node-index-hash")) {
                next.setNodeIndexHash(valueVector.get(1).intValue(context));
            }
            else if (nextElement.equals("max-background-rules")) {
                next.setMaxBackgroundRules(valueVector.get(1).intValue(context));
            }
            else {
                this.parseError("parseDefquery", "Invalid declarand: " + nextElement);
            }
        }
        group.addToLHS(next, this.m_rete);
        if (defquery != null) {
            defquery.setNext(next);
        }
        this.m_rete.addDefrule(next);
        return next;
    }
    
    private final Value parseDeffunction() throws JessException {
        if (this.m_jts.nextToken().m_ttype != 40 || !this.m_jts.nextToken().m_sval.equals("deffunction")) {
            this.parseError("parseDeffunction", "Expected (deffunction...");
        }
        final JessToken nextToken;
        if ((nextToken = this.m_jts.nextToken()).m_ttype != 1) {
            this.parseError("parseDeffunction", "Expected deffunction name");
        }
        final String sval = nextToken.m_sval;
        String sval2 = "";
        JessToken jessToken;
        if ((jessToken = this.m_jts.nextToken()).m_ttype == 2) {
            sval2 = jessToken.m_sval;
            jessToken = this.m_jts.nextToken();
        }
        final Deffunction deffunction = new Deffunction(sval, sval2);
        if (jessToken.m_ttype != 40) {
            this.parseError("parseDeffunction", "Expected '('");
        }
        JessToken nextToken2;
        while ((nextToken2 = this.m_jts.nextToken()).m_ttype == 8 || nextToken2.m_ttype == 8192) {
            deffunction.addArgument(nextToken2.m_sval, nextToken2.m_ttype);
        }
        if (nextToken2.m_ttype != 41) {
            this.parseError("parseDeffunction", "Expected ')'");
        }
        JessToken jessToken2;
        if ((jessToken2 = this.m_jts.nextToken()).m_ttype == 2) {
            deffunction.setDocstring(jessToken2.m_sval);
            jessToken2 = this.m_jts.nextToken();
        }
        while (jessToken2.m_ttype != 41) {
            if (jessToken2.m_ttype == 40) {
                this.m_jts.pushBack(jessToken2);
                deffunction.addAction(this.parseFuncall());
            }
            else {
                switch (jessToken2.m_ttype) {
                    case 1:
                    case 2:
                    case 4:
                    case 8:
                    case 32:
                    case 8192: {
                        deffunction.addValue(this.tokenToValue(jessToken2));
                        break;
                    }
                    default: {
                        this.parseError("parseDeffunction", "Unexpected character");
                        break;
                    }
                }
            }
            jessToken2 = this.m_jts.nextToken();
        }
        this.m_rete.addUserfunction(deffunction);
        return Funcall.TRUE;
    }
    
    Value parseAndExecuteFuncall(final JessToken jessToken, final Context context) throws JessException {
        if (jessToken != null) {
            this.m_jts.pushBack(jessToken);
        }
        return this.parseFuncall().execute(context);
    }
    
    private final Value tokenToValue(final JessToken jessToken) throws JessException {
        switch (jessToken.m_ttype) {
            case 1:
            case 2: {
                return new Value(jessToken.m_sval, jessToken.m_ttype);
            }
            case 8:
            case 8192: {
                return new Variable(jessToken.m_sval, jessToken.m_ttype);
            }
            case 4:
            case 32: {
                return new Value(jessToken.m_nval, jessToken.m_ttype);
            }
            case 40: {
                this.m_jts.pushBack(jessToken);
                return new FuncallValue(this.parseFuncall());
            }
            default: {
                return null;
            }
        }
    }
    
    private final void parseError(final String s, final String s2) throws JessException {
        try {
            final ParseException ex = new ParseException("Jesp." + s, s2);
            ex.setLineNumber(this.m_jts.lineno());
            ex.setProgramText(this.m_jts.toString());
            throw ex;
        }
        finally {
            this.m_jts.clear();
        }
    }
    
    public Jesp(final Reader reader, final Rete rete) {
        this.m_rete = rete;
        Tokenizer inputWrapper = rete.getInputWrapper(reader);
        if (inputWrapper == null) {
            inputWrapper = new Tokenizer(reader);
        }
        this.m_jts = new JessTokenStream(inputWrapper);
    }
}
