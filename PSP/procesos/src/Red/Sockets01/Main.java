package Red.Sockets01;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
	
	private static ServerSocket server;
	private static Socket socket;
	private static DataOutputStream salida;
	private static BufferedReader entrada;
	
	private static int puerto = 9000;

	/**
	 * Metodo inicial de la clase
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			
			// Creamos los sockets
			server = new ServerSocket(puerto);
			socket = new Socket();
			
			// Abrimos la escucha del socket
			socket = server.accept();
			
			// Leemos los datos del socket
			entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String msgEntrada = entrada.readLine();
			System.out.println(msgEntrada);
			
			// Escribimos un mensaje cuando acabe de leer los datos del socket
			salida = new DataOutputStream(socket.getOutputStream());
			salida.writeUTF("Hasta Pronto");
			
			// Cerramos la conexion del socket
			socket.close();
		}
		catch (IOException ioErr) { ioErr.printStackTrace(); }
		catch (Exception e) { e.printStackTrace(); }
	}
}