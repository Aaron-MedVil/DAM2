package Red.Cli_serv_multihilo_01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
	
	public static void main(String[] args) {
		
		try {
			
			Scanner teclado = new Scanner(System.in);
			InetAddress ip = InetAddress.getByName("localhost");
			
			Socket socket = new Socket(ip, 6000);
			
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			
			while(true) {
				
				// Visualiza por pantalla lo que le envia el servidor
				System.out.println(dis.readUTF());
				
				// Recoge el valor introducido por el usuario
				String res = teclado.nextLine().toLowerCase();
				
				// Devuelve al servidor lo introducido
				dos.writeUTF(res);
				
				if (res.equals("exit")) {
					System.out.println("Cerrando conexion...");
					socket.close();
					System.out.println("Conexion cerrada...");
					break;
				}
			}
			
			dis.close();
			dos.close();
		}
		catch (Exception err) { err.printStackTrace(); }
	}
}