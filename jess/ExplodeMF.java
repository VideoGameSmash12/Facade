package jess;

import java.io.Reader;
import java.io.StringReader;
import java.io.Serializable;

class ExplodeMF implements Userfunction, Serializable
{
    public String getName() {
        return "explode$";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final ValueVector valueVector2 = new ValueVector();
        final JessTokenStream jessTokenStream = new JessTokenStream(new Tokenizer(new StringReader("(" + valueVector.get(1).stringValue(context))));
        jessTokenStream.nextToken();
        for (JessToken jessToken = jessTokenStream.nextToken(); jessToken.m_ttype != 0; jessToken = jessTokenStream.nextToken()) {
            switch (jessToken.m_ttype) {
                case 1:
                case 2: {
                    valueVector2.add(new Value(jessToken.m_sval, jessToken.m_ttype));
                    break;
                }
                case 4:
                case 32: {
                    valueVector2.add(new Value(jessToken.m_nval, jessToken.m_ttype));
                    break;
                }
                default: {
                    valueVector2.add(new Value(new StringBuffer().append((char)jessToken.m_ttype).toString(), 2));
                    break;
                }
            }
        }
        return new Value(valueVector2, 512);
    }
}
