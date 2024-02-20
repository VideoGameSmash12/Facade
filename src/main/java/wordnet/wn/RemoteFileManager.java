package wordnet.wn;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.Remote;

public class RemoteFileManager extends FileManager implements Remote
{
    public static final String BINDING_NAME;
    
    public void bind() throws RemoteException, AlreadyBoundException {
        LocateRegistry.getRegistry().bind(RemoteFileManager.BINDING_NAME, this);
    }
    
    public static FileManagerInterface lookup(final String s) throws AccessException, NotBoundException, RemoteException, UnknownHostException {
        return (FileManagerInterface)LocateRegistry.getRegistry(s).lookup(RemoteFileManager.BINDING_NAME);
    }
    
    public RemoteFileManager() throws RemoteException {
        UnicastRemoteObject.exportObject(this);
    }
    
    public RemoteFileManager(final String s) throws RemoteException {
        super(s);
        UnicastRemoteObject.exportObject(this);
    }
    
    static {
        BINDING_NAME = "edu.brandeis.cs.steele.wn" + FileManager.VERSION;
    }
}
