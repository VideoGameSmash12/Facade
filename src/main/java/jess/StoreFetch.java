package jess;

import java.io.Serializable;

class StoreFetch implements Userfunction, Serializable
{
    static final int STORE = 0;
    static final int FETCH = 1;
    static final int CLEAR_STORAGE = 2;
    static final String[] s_names;
    private int m_name;
    
    public String getName() {
        return StoreFetch.s_names[this.m_name];
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        switch (this.m_name) {
            case 0: {
                Value resolveValue = valueVector.get(2).resolveValue(context);
                if (resolveValue.equals(Funcall.NIL)) {
                    resolveValue = null;
                }
                final Value store = context.getEngine().store(valueVector.get(1).stringValue(context), resolveValue);
                if (store != null) {
                    return store;
                }
                return Funcall.NIL;
            }
            case 2: {
                context.getEngine().clearStorage();
                return Funcall.TRUE;
            }
            default: {
                final Value fetch = context.getEngine().fetch(valueVector.get(1).stringValue(context));
                if (fetch != null) {
                    return fetch.resolveValue(context);
                }
                return Funcall.NIL;
            }
        }
    }
    
    StoreFetch(final int name) {
        this.m_name = name;
    }
    
    static {
        s_names = new String[] { "store", "fetch", "clear-storage" };
    }
}
