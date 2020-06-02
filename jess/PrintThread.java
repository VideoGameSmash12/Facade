package jess;

import java.io.IOException;
import java.io.Writer;

class PrintThread extends Thread
{
    private static PrintThread s_printThread;
    private Writer m_os;
    
    static PrintThread getPrintThread() {
        return PrintThread.s_printThread;
    }
    
    synchronized void assignWork(final Writer os) {
        this.m_os = os;
        this.notify();
    }
    
    public synchronized void run() {
        while (true) {
            try {
                while (this.m_os == null) {
                    this.wait();
                }
                try {
                    this.m_os.flush();
                }
                catch (IOException ex) {}
                finally {
                    this.m_os = null;
                }
                this.m_os = null;
            }
            catch (InterruptedException ex2) {
                break;
            }
            this.notifyAll();
        }
    }
    
    synchronized int waitForCompletion() {
        return 1;
    }
    
    static {
        (PrintThread.s_printThread = new PrintThread()).setDaemon(true);
        PrintThread.s_printThread.start();
    }
}
