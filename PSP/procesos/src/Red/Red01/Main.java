package Red.Red01;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {

	public static void main(String[] args) {
		
		String pcName = "DESKTOP-RBFFHNS";
		InetAddress dir = null;
		
		try {
			
			// Nombre del equipo
			System.out.println("========================================");
			System.out.println("SALIDA PARA LOCALHOST");
			dir = InetAddress.getByName(pcName);
			probarMetodos(dir);
			
			// URL www.google.es
			System.out.println("========================================");
			System.out.println("SALIDA PARA UNA URL");
			dir = InetAddress.getByName("www.google.es");
			probarMetodos(dir);
			
			// Direcciones IP de una URL www.google.es
			System.out.println("\t DIRECCIONES IP PARA: " + dir.getHostName());
			InetAddress[] direcciones = InetAddress.getAllByName(dir.getHostName());
			for (int i = 0; i < direcciones.length; i++) {
				System.out.println("\t\t" + direcciones[i].toString());
			}
		}
		catch (UnknownHostException e) { e.printStackTrace(); }
	}

	private static void probarMetodos(InetAddress dir) {
		
		System.out.println("\t Método getByName(): " + dir);
		InetAddress dir2;
		
		try {
			
			dir2 = InetAddress.getLocalHost();
			System.out.println("\t Método getLocalHost(): " + dir2);
			System.out.println("\t Método getHostAddress(): " + dir.getHostAddress());
			System.out.println("\t Metodo getCanonicalHostName(): " + dir.getCanonicalHostName());
		}
		catch (UnknownHostException e) { e.printStackTrace(); }
	}
}