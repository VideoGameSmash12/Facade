package jess;

import java.io.PrintWriter;

class ListDeftemplates extends ModuleOperator implements Userfunction
{
    public String getName() {
        return "list-deftemplates";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        return this.displayAll(context.getEngine().listDeftemplates(), valueVector, context, "deftemplates", (Displayer)new Displayer() {
            public final void display(final Modular modular, final PrintWriter printWriter) {
                printWriter.println(modular.getName());
            }
        });
    }
}
