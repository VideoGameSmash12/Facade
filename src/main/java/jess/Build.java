package jess;

import java.io.Serializable;

class Build implements Userfunction, Serializable
{
    private String m_name;
    
    public String getName() {
        return this.m_name;
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        return context.getEngine().executeCommand(valueVector.get(1).stringValue(context), context);
    }
    
    Build(final String name) {
        this.m_name = name;
    }
}
