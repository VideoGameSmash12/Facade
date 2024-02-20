package jess;

import java.io.PrintWriter;

class ListRules extends ModuleOperator implements Userfunction
{
    public String getName() {
        return "rules";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        return this.displayAll(context.getEngine().listDefrules(), valueVector, context, "rules", (Displayer)new Displayer() {
            public final void display(final Modular modular, final PrintWriter printWriter) {
                printWriter.println(modular.getName());
            }
        });
    }
}
