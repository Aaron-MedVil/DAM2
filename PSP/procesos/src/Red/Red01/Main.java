package Red.Red01;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {

	public static void main(String[] args) {
		
		String pcName = "DESKTOP-RBFFHNS";
		InetAddress dir = null;
		
		System.out.println("========================================");
		System.out.println("SALIDA PARA LOCALHOST");
		
		try {
			dir = InetAddress.getByName(pcName);
			probarMetodos(dir);
		}
		catch (UnknownHostException e) { e.printStackTrace(); }
	}

	private static void probarMetodos(InetAddress dir) {
		
		System.out.println("\t M�todo getByName(): " + dir);
		InetAddress dir2;
		
		try {
			
			dir2 = InetAddress.getLocalHost();
			System.out.println("\t M�todo getLocalHost(): " + dir2);
			System.out.println("\t M�todo getHostAddress(): " + dir.getHostAddress());
		}
		catch (UnknownHostException e) { e.printStackTrace(); }
	}
}