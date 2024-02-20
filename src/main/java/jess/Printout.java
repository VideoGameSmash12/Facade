package jess;

import java.io.Writer;
import java.io.IOException;
import java.io.Serializable;

class Printout implements Userfunction, Serializable
{
    static final int PRINTOUT = 0;
    static final int SETMULTI = 1;
    static final int GETMULTI = 2;
    private static final String[] s_names;
    private boolean m_multithreadedIO;
    private int m_name;
    private Printout m_printout;
    
    public String getName() {
        return Printout.s_names[this.m_name];
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        switch (this.m_name) {
            case 1: {
                final boolean multithreadedIO = this.m_printout.m_multithreadedIO;
                this.m_printout.m_multithreadedIO = (valueVector.get(1).equals(Funcall.FALSE) ^ true);
                return multithreadedIO ? Funcall.TRUE : Funcall.FALSE;
            }
            case 2: {
                return this.m_printout.m_multithreadedIO ? Funcall.TRUE : Funcall.FALSE;
            }
            default: {
                final String stringValue = valueVector.get(1).stringValue(context);
                final Writer outputRouter = context.getEngine().getOutputRouter(stringValue);
                if (outputRouter == null) {
                    throw new JessException("printout", "printout: bad router", stringValue);
                }
                final StringBuffer sb = new StringBuffer(100);
                for (int i = 2; i < valueVector.size(); ++i) {
                    final Value resolveValue = valueVector.get(i).resolveValue(context);
                    switch (resolveValue.type()) {
                        case 1: {
                            if (resolveValue.equals("crlf")) {
                                sb.append("\n");
                                break;
                            }
                        }
                        case 2: {
                            sb.append(resolveValue.stringValue(context));
                            break;
                        }
                        case 4: {
                            sb.append(resolveValue.intValue(context));
                            break;
                        }
                        case 32: {
                            sb.append(resolveValue.numericValue(context));
                            break;
                        }
                        case 16: {
                            sb.append(resolveValue);
                            break;
                        }
                        case 512: {
                            sb.append(resolveValue.listValue(context).toStringWithParens());
                            break;
                        }
                        case 2048: {
                            sb.append(resolveValue.toString());
                            break;
                        }
                        default: {
                            sb.append(resolveValue.toString());
                            break;
                        }
                    }
                }
                try {
                    outputRouter.write(sb.toString());
                    if (this.m_multithreadedIO) {
                        PrintThread.getPrintThread().assignWork(outputRouter);
                    }
                    else {
                        outputRouter.flush();
                    }
                }
                catch (IOException ex) {
                    throw new JessException("printout", "I/O Exception", ex);
                }
                return Funcall.NIL;
            }
        }
    }
    
    private final /* synthetic */ void this() {
        this.m_multithreadedIO = false;
    }
    
    Printout(final int name) {
        this.this();
        this.m_name = name;
    }
    
    Printout(final int name, final Printout printout) {
        this.this();
        this.m_name = name;
        this.m_printout = printout;
    }
    
    static {
        s_names = new String[] { "printout", "set-multithreaded-io", "get-multithreaded-io" };
    }
}
