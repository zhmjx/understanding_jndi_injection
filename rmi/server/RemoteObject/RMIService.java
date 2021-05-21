import javax.naming.*;
import java.rmi.registry.*;

public class RMIService{
   public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry(1099);
        HelloImpl h = new HelloImpl();
        registry.bind("hello", h);
    } 
}
