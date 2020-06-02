package jess;

import java.io.Serializable;

class JessImport implements Userfunction, Serializable
{
    public String getName() {
        return "import";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final String atomValue = valueVector.get(1).atomValue(context);
        if (atomValue.indexOf("*") != -1) {
            context.getEngine().importPackage(atomValue.substring(0, atomValue.indexOf("*")));
        }
        else {
            context.getEngine().importClass(atomValue);
        }
        return Funcall.TRUE;
    }
}
