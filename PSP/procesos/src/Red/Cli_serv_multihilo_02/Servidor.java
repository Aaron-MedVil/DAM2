package Red.Cli_serv_multihilo_02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) throws IOException {
		
		// Creamos el servidor en el puerto 6000
		ServerSocket servidor = new ServerSocket(6000);
		
		while(true) {
			
			try {				
					
				// El servidor espera a que se conecte un cliente
				Socket cliente = servidor.accept();
				System.out.println("Nuevo cliente conectado...");
				
				// Creamos el InputStream para leer informacion al socket del cliente
				DataInputStream dis = new DataInputStream(cliente.getInputStream());
				
				// Creamos el OutputStream para enviar informacion al socket del cliente
				DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());
				
				// Creamos el hilo del cliente
				SocketTCP_Hilo hilo = new SocketTCP_Hilo(cliente, dis, dos);
				// SocketTCP_Hilo hilo = new SocketTCP_Hilo(cliente); // Asi abrimos los flujos en la clase hilo
				hilo.start();
			}
			catch (Exception err) {}
		}
	}
}