package jess;

import java.io.PrintWriter;

class ListFacts extends ModuleOperator implements Userfunction
{
    public String getName() {
        return "facts";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        return this.displayAll(context.getEngine().listFacts(), valueVector, context, "facts", (Displayer)new Displayer() {
            public final void display(final Modular modular, final PrintWriter printWriter) {
                final Fact fact = (Fact)modular;
                printWriter.print("f-");
                printWriter.print(fact.getFactId());
                printWriter.print("   ");
                printWriter.println(fact);
            }
        });
    }
}
