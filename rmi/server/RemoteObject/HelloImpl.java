import java.rmi.RemoteException;
import java.rmi.server.RMISocketFactory;
import java.rmi.server.UnicastRemoteObject;
import java.io.*;

public class HelloImpl extends UnicastRemoteObject implements Hello {
    /**
     * Creates and exports a new UnicastRemoteObject object using an
     * anonymous port.
     *
     * <p>The object is exported with a server socket
     * created using the {@link RMISocketFactory} class.
     *
     * @throws RemoteException if failed to export object
     * @since JDK1.1
     */
    protected HelloImpl() throws RemoteException {
	System.out.println("HelloImpl construct called here");
    }

    static{
        System.out.println("static code of HelloImpl called here");
    }

    public String sayHello() throws RemoteException {
        System.out.println("sayHello() called here");
        return ("Hello, the date is " + new java.util.Date());
    }
}
