package jess;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;
import java.io.FileOutputStream;
import java.io.Serializable;

class Dumper implements Userfunction, Serializable
{
    public static final int DUMP = 0;
    public static final int RESTORE = 1;
    private int m_cmd;
    
    public String getName() {
        return (this.m_cmd == 0) ? "bsave" : "bload";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final String stringValue = valueVector.get(1).stringValue(context);
        try {
            switch (this.m_cmd) {
                case 0: {
                    final GZIPOutputStream gzipOutputStream = new GZIPOutputStream(new FileOutputStream(stringValue), 10000);
                    context.getEngine().bsave(gzipOutputStream);
                    gzipOutputStream.flush();
                    gzipOutputStream.close();
                    return Funcall.TRUE;
                }
                default: {
                    final GZIPInputStream gzipInputStream = new GZIPInputStream(new FileInputStream(stringValue), 10000);
                    context.getEngine().bload(gzipInputStream);
                    gzipInputStream.close();
                    return Funcall.TRUE;
                }
            }
        }
        catch (IOException ex) {
            throw new JessException((this.m_cmd == 0) ? "bsave" : "bload", "IO Exception", ex);
        }
        catch (ClassNotFoundException ex2) {
            throw new JessException("bload", "Class not found", ex2);
        }
    }
    
    public Dumper(final int cmd) {
        this.m_cmd = cmd;
    }
}
