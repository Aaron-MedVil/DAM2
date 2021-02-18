package Red.Cli_serv_multihilo_02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		
		try {
			
			Scanner teclado = new Scanner(System.in);
			
			// Obtenemos la ip del servidor
			InetAddress ip = InetAddress.getByName("localhost");
			
			// Abrimos el socket
			Socket socket = new Socket(ip, 6000);
			
			// Creamos el InputStream para leer informacion al socket del servidor
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			
			// Creamos el OutputStream para enviar informacion al socket del servidor
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			
			while(true) {
				
				// Recogemos el mensaje enviado por el servidor
				System.out.println(dis.readUTF());
				String envio = teclado.nextLine();
				dos.writeUTF(envio);
				
				if (envio.equals("*")) {
					System.out.println("Cerrando conexion...");
					socket.close();
					System.out.println("Conexion cerrada...");
					break;
				}
				
				System.out.println(dis.readUTF());
			}
			
			dis.close();
			dos.close();
			teclado.close();
		}
		catch (Exception err) { err.printStackTrace(); }
	}
}