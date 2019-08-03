package view;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.edu.ifpb.dao.RefeicaoDao;

public class App {

	public static void main(String[] args) {
		System.out.println("ok");
		
		RefeicaoDao refeicaoDao = lookup("java:global/sessionbeans/RefeicaoDaoJpa");

	}
	
	 private static <T> T lookup(String resource) {
	        try {
	            //ip
	            //porta
	            // ConnectionFactory
	            Properties props = new Properties();
	            props.setProperty(Context.INITIAL_CONTEXT_FACTORY,"com.sun.enterprise.naming.SerialInitContextFactory");
	            props.setProperty("org.omg.CORBA.ORBInitialHost","localhost");
	            props.setProperty("org.omg.CORBA.ORBInitialPort","3701");
	            Context context = new InitialContext(props);
	            return (T) context.lookup(resource);
	        } catch (NamingException ex) {
	            Logger.getLogger(App.class.getName()).log(Level.SEVERE,null,ex);
	        }
	        return null;
	    }
	    private static <T> T lookupRemote(String string) {
	        try {
	            Properties props = new Properties();
	            props.setProperty(Context.INITIAL_CONTEXT_FACTORY,"com.sun.enterprise.naming.SerialInitContextFactory");
	            props.setProperty("org.omg.CORBA.ORBInitialHost","localhost");
	            props.setProperty("org.omg.CORBA.ORBInitialPort","3701");
	            props.setProperty("java.naming.factory.url.pkgs",
	                              "com.sun.enterprise.naming");
	            props.setProperty("java.naming.factory.state",
	                              "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
	            props.setProperty(Context.SECURITY_PRINCIPAL,"admin");
	            props.setProperty(Context.SECURITY_CREDENTIALS,"admin");
	            props.setProperty("com.sun.corba.ee.transport.ORBWaitForResponseTimeout",
	                              "5000");
	            props.setProperty("com.sun.corba.ee.transport.ORBTCPConnectTimeouts",
	                              "100:500:100:500");
	            props.setProperty("com.sun.corba.ee.transport.ORBTCPTimeouts",
	                              "500:2000:50:1000");
	            props.setProperty("https.protocols","TLSv1,TLSv1.1,TLSv1.2");
	            Context context = new InitialContext(props);
	            return (T) context.lookup(string);
	        } catch (NamingException ex) {
	            Logger.getLogger(App.class.getName()).log(Level.SEVERE,null,ex);
	        }
	        return null;
	    }

}
