package jess;

import java.util.Iterator;
import java.util.Arrays;
import java.util.HashSet;
import java.io.Serializable;

class ListFunctions implements Userfunction, Serializable
{
    public String getName() {
        return "list-function$";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final ValueVector valueVector2 = new ValueVector(100);
        final HashSet set = new HashSet<String>();
        final Iterator listFunctions = context.getEngine().listFunctions();
        while (listFunctions.hasNext()) {
            set.add(listFunctions.next().getName());
        }
        final Iterator listIntrinsics = Funcall.listIntrinsics();
        while (listIntrinsics.hasNext()) {
            set.add(listIntrinsics.next().getName());
        }
        final Object[] array = set.toArray();
        Arrays.sort(array);
        for (int i = 0; i < array.length; ++i) {
            valueVector2.add(new Value((String)array[i], 1));
        }
        return new Value(valueVector2, 512);
    }
}
