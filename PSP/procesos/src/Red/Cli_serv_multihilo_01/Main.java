package Red.Cli_serv_multihilo_01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

	public static void main(String[] args) throws IOException {

		final int puerto = 6000;
		ServerSocket serverSocket = new ServerSocket(puerto);
		
		while (true) {
			
			Socket socket = null;
			
			try {

				// El servidor abre la conexion con el cliente
				socket = serverSocket.accept();
				System.out.println("Un nuevo cliente se ha conectado...");
				
				// Abrimos la lectura y escritura del cliente/servidor
				DataInputStream dis = new DataInputStream(socket.getInputStream());
				DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
				
				// Asignamos un hilo al cliente
				System.out.println("Asignamos un nuevo hilo al cliente...");
				Hilo_Cliente nuevoHilo = new Hilo_Cliente(socket, dos, dis);
				nuevoHilo.start();
			}
			catch (Exception err) {
				err.printStackTrace();
				socket.close();
			}
		}
	}
}