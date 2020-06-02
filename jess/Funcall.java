package jess;

import java.util.Iterator;
import java.util.HashMap;
import java.io.Serializable;

public class Funcall extends ValueVector implements Serializable
{
    public static Value TRUE;
    public static Value FALSE;
    public static Value NIL;
    public static Value NILLIST;
    public static Value EOF;
    static Value s_else;
    static Value s_then;
    static Value s_do;
    private static HashMap m_intrinsics;
    FunctionHolder m_funcall;
    
    public String toString() {
        try {
            if (this.get(0).equals("assert")) {
                final List list = new List("assert");
                for (int i = 1; i < this.size(); ++i) {
                    list.add(this.get(i).factValue(null));
                }
                return list.toString();
            }
            if (this.get(0).equals("modify") || this.get(0).equals("duplicate")) {
                final List list2 = new List(this.get(0).atomValue(null));
                list2.add(this.get(1));
                for (int j = 2; j < this.size(); ++j) {
                    final ValueVector listValue = this.get(j).listValue(null);
                    final List list3 = new List(listValue.get(0).atomValue(null));
                    for (int k = 1; k < listValue.size(); ++k) {
                        list3.add(listValue.get(k));
                    }
                    list2.add(list3);
                }
                return list2.toString();
            }
            return new List(super.toString()).toString();
        }
        catch (JessException ex) {
            return ex.toString();
        }
    }
    
    public String toStringWithParens() {
        return this.toString();
    }
    
    static Userfunction getIntrinsic(final String s) {
        return Funcall.m_intrinsics.get(s);
    }
    
    static Iterator listIntrinsics() {
        return Funcall.m_intrinsics.values().iterator();
    }
    
    private static final void addIntrinsic(final Userfunction userfunction) {
        Funcall.m_intrinsics.put(userfunction.getName(), userfunction);
    }
    
    private static final void addPackage(final IntrinsicPackage intrinsicPackage) {
        intrinsicPackage.add(Funcall.m_intrinsics);
    }
    
    private static final void loadIntrinsics() throws JessException {
        try {
            addIntrinsic(new Assert());
            addIntrinsic(new Retract());
            addIntrinsic(new Update());
            addIntrinsic(new RetractString());
            addIntrinsic(new DoBackwardChaining());
            addIntrinsic(new Open());
            addIntrinsic(new Close());
            addIntrinsic(new Duplicate());
            addIntrinsic(new Foreach());
            addIntrinsic(new Read());
            addIntrinsic(new Readline());
            addIntrinsic(new GensymStar());
            addIntrinsic(new While());
            addIntrinsic(new If());
            addIntrinsic(new Bind());
            addIntrinsic(new Modify());
            addIntrinsic(new And());
            addIntrinsic(new Or());
            addIntrinsic(new Not());
            addIntrinsic(new Eq());
            addIntrinsic(new EqStar());
            addIntrinsic(new Equals());
            addIntrinsic(new NotEquals());
            addIntrinsic(new Gt());
            addIntrinsic(new Lt());
            addIntrinsic(new GtOrEq());
            addIntrinsic(new LtOrEq());
            addIntrinsic(new Neq());
            addIntrinsic(new Mod());
            addIntrinsic(new Plus());
            addIntrinsic(new Times());
            addIntrinsic(new Minus());
            addIntrinsic(new Divide());
            addIntrinsic(new SymCat());
            addIntrinsic(new LoadFacts());
            addIntrinsic(new SaveFacts());
            addIntrinsic(new AssertString());
            addIntrinsic(new UnDefrule());
            addIntrinsic(new Batch());
            addIntrinsic(new Watch());
            addIntrinsic(new Unwatch());
            addIntrinsic(new JessVersion(0));
            addIntrinsic(new JessVersion(1));
            addIntrinsic(new HaltEtc(0));
            addIntrinsic(new HaltEtc(1));
            addIntrinsic(new HaltEtc(2));
            addIntrinsic(new HaltEtc(3));
            addIntrinsic(new HaltEtc(4));
            addIntrinsic(new HaltEtc(5));
            addIntrinsic(new StoreFetch(0));
            addIntrinsic(new StoreFetch(1));
            addIntrinsic(new StoreFetch(2));
            addIntrinsic(new Defadvice("defadvice"));
            addIntrinsic(new Defadvice("undefadvice"));
            addIntrinsic(new TryCatchThrow("try"));
            addIntrinsic(new TryCatchThrow("throw"));
            final Printout printout = new Printout(0);
            addIntrinsic(printout);
            addIntrinsic(new Printout(1, printout));
            addIntrinsic(new Printout(2, printout));
            addPackage(new ReflectFunctions());
            addPackage(new StringFunctions());
            addPackage(new PredFunctions());
            addPackage(new MultiFunctions());
            addPackage(new MiscFunctions());
            addPackage(new ModuleFunctions());
            addPackage(new MathFunctions());
            addPackage(new LispFunctions());
            addPackage(new DumpFunctions());
            addPackage(new ReflectFunctions());
            addPackage(new ViewFunctions());
            addPackage(new BagFunctions());
        }
        catch (Throwable t) {
            t.printStackTrace();
            throw new JessException("Funcall.loadIntrisics", "Missing non-optional function class", t);
        }
    }
    
    public Object clone() {
        return this.cloneInto(new Funcall(this.size()));
    }
    
    public Funcall cloneInto(final Funcall funcall) {
        super.cloneInto(funcall);
        funcall.m_funcall = this.m_funcall;
        return funcall;
    }
    
    public final Value execute(final Context context) throws JessException {
        try {
            if (this.m_funcall == null) {
                final String stringValue = this.get(0).stringValue(context);
                if ((this.m_funcall = context.getEngine().findFunctionHolder(stringValue)) == null) {
                    throw new JessException("Funcall.execute", "Unimplemented function", stringValue);
                }
            }
            context.getEngine().broadcastEvent(524288, this.m_funcall.getFunction());
            return this.m_funcall.call(this, context);
        }
        catch (JessException ex) {
            ex.addContext(this.toStringWithParens());
            throw ex;
        }
        catch (Exception ex3) {
            final JessException ex2 = new JessException("Funcall.execute", "Error during execution", ex3);
            ex2.addContext(this.toStringWithParens());
            throw ex2;
        }
    }
    
    public Funcall arg(final Value value) {
        this.add(value);
        return this;
    }
    
    public Funcall(final String s, final Rete rete) throws JessException {
        this.add(new Value(s, 1));
        this.m_funcall = rete.findFunctionHolder(s);
    }
    
    Funcall(final int n) {
        super(n);
    }
    
    static {
        Funcall.m_intrinsics = new HashMap();
        try {
            Funcall.TRUE = new Value("TRUE", 1);
            Funcall.FALSE = new Value("FALSE", 1);
            Funcall.NIL = new Value("nil", 1);
            Funcall.NILLIST = new Value(new ValueVector(), 512);
            Funcall.EOF = new Value("EOF", 1);
            Funcall.s_else = new Value("else", 1);
            Funcall.s_then = new Value("then", 1);
            Funcall.s_do = new Value("do", 1);
            loadIntrinsics();
        }
        catch (JessException ex) {
            System.out.println("*** FATAL ***: Can't initialize Jess");
            ex.printStackTrace();
            System.exit(0);
        }
    }
}
