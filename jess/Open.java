package jess;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Serializable;

class Open implements Userfunction, Serializable
{
    public String getName() {
        return "open";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final Rete engine = context.getEngine();
        final String stringValue = valueVector.get(1).stringValue(context);
        final String stringValue2 = valueVector.get(2).stringValue(context);
        String stringValue3 = "r";
        if (valueVector.size() > 3) {
            stringValue3 = valueVector.get(3).stringValue(context);
        }
        try {
            if (stringValue3.equals("r")) {
                engine.addInputRouter(stringValue2, new BufferedReader(new FileReader(stringValue)), false);
            }
            else if (stringValue3.equals("w")) {
                engine.addOutputRouter(stringValue2, new BufferedWriter(new FileWriter(stringValue)));
            }
            else {
                if (!stringValue3.equals("a")) {
                    throw new JessException("open", "Unsupported access mode", stringValue3);
                }
                final RandomAccessFile randomAccessFile = new RandomAccessFile(stringValue, "rw");
                randomAccessFile.seek(randomAccessFile.length());
                engine.addOutputRouter(stringValue2, new BufferedWriter(new FileWriter(randomAccessFile.getFD())));
            }
        }
        catch (IOException ex) {
            throw new JessException("open", "I/O Exception", ex);
        }
        return new Value(stringValue2, 1);
    }
}
