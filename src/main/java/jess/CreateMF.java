package jess;

import java.io.Serializable;

class CreateMF implements Userfunction, Serializable
{
    public String getName() {
        return "create$";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final ValueVector valueVector2 = new ValueVector();
        for (int i = 1; i < valueVector.size(); ++i) {
            final Value resolveValue = valueVector.get(i).resolveValue(context);
            switch (resolveValue.type()) {
                case 512: {
                    final ValueVector listValue = resolveValue.listValue(context);
                    for (int j = 0; j < listValue.size(); ++j) {
                        valueVector2.add(listValue.get(j).resolveValue(context));
                    }
                    break;
                }
                default: {
                    valueVector2.add(resolveValue);
                    break;
                }
            }
        }
        return new Value(valueVector2, 512);
    }
}
