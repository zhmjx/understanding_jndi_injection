import javax.naming.Reference;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class RMIRegister {
    public static void main(String args[]) throws Exception {
        Registry registry = LocateRegistry.createRegistry(1099);
	System.out.println("RMI registered at port 1099");
	while(true){
	    Thread.sleep(2000);
	}
    }
}
