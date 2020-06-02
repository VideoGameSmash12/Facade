package jess;

import java.util.Iterator;
import java.io.PrintWriter;

class ShowAgenda extends ModuleOperator implements Userfunction
{
    public String getName() {
        return "agenda";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final Rete engine = context.getEngine();
        final PrintWriter outStream = engine.getOutStream();
        int showOneAgenda = 0;
        final String module = this.getModule(valueVector, context);
        if (module.equals("*")) {
            final Iterator listModules = engine.listModules();
            while (listModules.hasNext()) {
                final String s = listModules.next();
                outStream.print(s);
                outStream.println(":");
                showOneAgenda += this.showOneAgenda(engine.listActivations(s), outStream);
            }
        }
        else {
            showOneAgenda = this.showOneAgenda(engine.listActivations(module), outStream);
        }
        outStream.print("For a total of ");
        outStream.print(showOneAgenda);
        outStream.println(" activations.");
        outStream.flush();
        return Funcall.NIL;
    }
    
    private final int showOneAgenda(final Iterator iterator, final PrintWriter printWriter) {
        int n = 0;
        while (iterator.hasNext()) {
            final Activation activation = iterator.next();
            if (!activation.isInactive()) {
                printWriter.println(activation);
                ++n;
            }
        }
        return n;
    }
}
