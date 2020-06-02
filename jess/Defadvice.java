package jess;

import java.io.Serializable;

class Defadvice implements Userfunction, Serializable
{
    static final String BEFORE = "before";
    static final String AFTER = "after";
    static final String ADVICE = "defadvice";
    static final String UNADVICE = "undefadvice";
    private String m_name;
    
    public String getName() {
        return this.m_name;
    }
    
    private final ValueVector functionList(final Value value, final Rete rete) throws JessException {
        switch (value.type()) {
            case 512: {
                return value.listValue(null);
            }
            case 1: {
                if (value.equals("ALL")) {
                    return rete.executeCommand("(list-function$)").listValue(null);
                }
                break;
            }
        }
        final ValueVector valueVector = new ValueVector();
        valueVector.add(value);
        return valueVector;
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final Rete engine = context.getEngine();
        if (this.m_name.equals("defadvice")) {
            final String stringValue = valueVector.get(1).stringValue(context);
            final ValueVector functionList = this.functionList(valueVector.get(2).resolveValue(context), engine);
            for (int i = 0; i < functionList.size(); ++i) {
                final FunctionHolder functionHolder = engine.findFunctionHolder(functionList.get(i).atomValue(context));
                if (functionHolder == null) {
                    throw new JessException("Defadvice.call", "Cannot advice a function before defining it", this.m_name);
                }
                final Userfunction stripAdvice = functionHolder.stripAdvice();
                if (stripAdvice == null) {
                    throw new JessException("Defadvice.call", "Cannot advice a function before defining it", this.m_name);
                }
                final Advice advice = stringValue.equals("before") ? new BeforeAdvice(stripAdvice) : new AfterAdvice(stripAdvice);
                for (int j = 3; j < valueVector.size(); ++j) {
                    advice.addAction(valueVector.get(j));
                }
                engine.addUserfunction(advice);
            }
        }
        else {
            final ValueVector functionList2 = this.functionList(valueVector.get(1).resolveValue(context), engine);
            for (int k = 0; k < functionList2.size(); ++k) {
                final FunctionHolder functionHolder2 = engine.findFunctionHolder(functionList2.get(k).atomValue(context));
                if (functionHolder2 == null) {
                    throw new JessException("Defadvice.call", "Cannot advice a function before defining it", this.m_name);
                }
                final Userfunction stripAdvice2 = functionHolder2.stripAdvice();
                if (stripAdvice2 == null) {
                    throw new JessException("Defadvice.call", "Cannot advice a function before defining it", this.m_name);
                }
                engine.addUserfunction(stripAdvice2);
            }
        }
        return Funcall.TRUE;
    }
    
    Defadvice(final String name) {
        this.m_name = name;
    }
}
