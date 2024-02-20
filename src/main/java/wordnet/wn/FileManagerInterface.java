package wordnet.wn;

import java.rmi.RemoteException;
import java.io.IOException;
import java.rmi.Remote;

public interface FileManagerInterface extends Remote
{
    long getIndexedLinePointer(final String p0, final String p1) throws IOException, RemoteException;
    
    String readLineAt(final String p0, final long p1) throws IOException, RemoteException;
    
    long getNextLinePointer(final String p0, final long p1) throws IOException, RemoteException;
    
    long getMatchingLinePointer(final String p0, final long p1, final String p2) throws IOException, RemoteException;
}
