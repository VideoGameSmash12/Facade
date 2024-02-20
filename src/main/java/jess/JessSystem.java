package jess;

import java.io.InputStream;
import java.io.IOException;
import java.io.Writer;
import java.io.Serializable;

class JessSystem implements Userfunction, Serializable
{
    public String getName() {
        return "system";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        try {
            boolean b = false;
            int size = valueVector.size();
            if (valueVector.get(size - 1).stringValue(context).equals("&")) {
                b = true;
                --size;
            }
            final String[] array = new String[size - 1];
            for (int i = 1; i < size; ++i) {
                array[i - 1] = valueVector.get(i).stringValue(context);
            }
            final Process exec = Runtime.getRuntime().exec(array);
            final ReaderThread readerThread = new ReaderThread(exec.getInputStream(), context.getEngine().getOutStream());
            readerThread.start();
            final ReaderThread readerThread2 = new ReaderThread(exec.getErrorStream(), context.getEngine().getErrStream());
            readerThread2.start();
            if (!b) {
                try {
                    exec.waitFor();
                    readerThread.join();
                    readerThread2.join();
                }
                catch (InterruptedException ex3) {}
            }
            return new Value(exec);
        }
        catch (IOException ex) {
            throw new JessException("system", valueVector.toStringWithParens(), ex);
        }
        catch (SecurityException ex2) {
            throw new JessException("system", valueVector.toStringWithParens(), ex2);
        }
    }
    
    private class ReaderThread extends Thread
    {
        InputStream m_is;
        Writer m_os;
        
        public void run() {
            try {
                int read;
                while ((read = this.m_is.read()) != -1) {
                    this.m_os.write((char)read);
                }
            }
            catch (Exception ex) {}
        }
        
        ReaderThread(final InputStream is, final Writer os) {
            this.m_is = is;
            this.m_os = os;
            this.setDaemon(true);
        }
    }
}
