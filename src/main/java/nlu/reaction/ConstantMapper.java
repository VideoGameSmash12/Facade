package nlu.reaction;

import jess.JessException;
import jess.Value;
import jess.Context;
import jess.ValueVector;
import jess.Userfunction;

public class ConstantMapper implements Userfunction
{
    public static String[] interfaces;
    
    public String getName() {
        return "fc";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final String stringValue = valueVector.get(1).stringValue(context);
        int i = 0;
        while (i < ConstantMapper.interfaces.length) {
            try {
                final Object value = Class.forName(ConstantMapper.interfaces[i]).getDeclaredField(stringValue).get(null);
                if (((Number)value).getClass() == Class.forName("java.lang.Integer")) {
                    return new Value(((Number)value).intValue(), 4);
                }
                if (((Number)value).getClass() == Class.forName("java.lang.Float") || ((Number)value).getClass() == Class.forName("java.lang.Double")) {
                    return new Value(((Number)value).doubleValue(), 32);
                }
                if (((Number)value).getClass() == Class.forName("java.lang.Long")) {
                    return new Value((double)((Number)value).longValue(), 65536);
                }
                if (((Number)value).getClass() == Class.forName("java.lang.String")) {
                    return new Value((String)value, 2);
                }
                return new Value(value);
            }
            catch (ClassNotFoundException ex) {
                throw new JessException("ConstantMapper.call", "Reflection error", ex);
            }
            catch (SecurityException ex2) {
                throw new JessException("ConstantMapper.call", "Reflection error", ex2);
            }
            catch (IllegalArgumentException ex3) {
                throw new JessException("ConstantMapper.call", "Reflection error", ex3);
            }
            catch (IllegalAccessException ex4) {
                throw new JessException("ConstantMapper.call", "Reflection error", ex4);
            }
            catch (NoSuchFieldException ex5) {
                ++i;
            }
        }
        throw new JessException("ConstantMapper.call", "Constant not found", stringValue);
    }
    
    static {
        ConstantMapper.interfaces = new String[] { "facade.util.SpriteID", "dramaman.runtime.DramaManagerConstants", "facade.util.ReactionConstants", "facade.util.DAType", "facade.util.ReactionID", "facade.util.BeatID" };
    }
}
