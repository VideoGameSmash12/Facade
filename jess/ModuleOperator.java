package jess;

import java.io.PrintWriter;
import java.util.Iterator;
import java.io.Serializable;

abstract class ModuleOperator implements Serializable
{
    String getModule(final ValueVector valueVector, final Context context) throws JessException {
        return (valueVector.size() == 1) ? context.getEngine().getCurrentModule() : valueVector.get(1).stringValue(context);
    }
    
    Filter chooseFilter(final String s, final Rete rete) throws JessException {
        if (s.equals("*")) {
            return (Filter)new NullFilter();
        }
        rete.verifyModule(s);
        return (Filter)new NameFilter(s);
    }
    
    Value displayAll(final Iterator iterator, final ValueVector valueVector, final Context context, final String s, final Displayer displayer) throws JessException {
        final String module = this.getModule(valueVector, context);
        final Rete engine = context.getEngine();
        final Filter chooseFilter = this.chooseFilter(module, engine);
        final PrintWriter outStream = engine.getOutStream();
        int n = 0;
        while (iterator.hasNext()) {
            final Modular modular = iterator.next();
            if (chooseFilter.accept(modular)) {
                displayer.display(modular, outStream);
                ++n;
            }
        }
        outStream.print("For a total of ");
        outStream.print(n);
        outStream.print(" ");
        outStream.print(s);
        outStream.println(".");
        outStream.flush();
        return Funcall.NIL;
    }
    
    class NullFilter implements Filter
    {
        public boolean accept(final Modular modular) {
            return true;
        }
    }
    
    class NameFilter implements Filter
    {
        private String m_name;
        
        public boolean accept(final Modular modular) {
            return this.m_name.equals(modular.getModule());
        }
        
        NameFilter(final String name) {
            this.m_name = name;
        }
    }
    
    interface Filter
    {
        boolean accept(final Modular p0);
    }
    
    interface Displayer
    {
        void display(final Modular p0, final PrintWriter p1);
    }
}
