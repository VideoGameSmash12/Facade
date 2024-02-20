package jess;

import java.io.Serializable;

class DoBackwardChaining implements Userfunction, Serializable
{
    public String getName() {
        return "do-backward-chaining";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final String stringValue = valueVector.get(1).stringValue(context);
        if (stringValue.equals("test") || Group.isGroupName(stringValue)) {
            throw new JessException("do-backward-chaining", "Can't backchain on special CEs", stringValue);
        }
        Deftemplate deftemplate = context.getEngine().findDeftemplate(stringValue);
        if (deftemplate == null) {
            deftemplate = context.getEngine().createDeftemplate(stringValue);
        }
        deftemplate.doBackwardChaining();
        final Deftemplate backchainingTemplate = deftemplate.getBackchainingTemplate(context.getEngine());
        backchainingTemplate.forgetParent();
        context.getEngine().addDeftemplate(backchainingTemplate);
        return Funcall.TRUE;
    }
}
