package Red.Ejercicio_01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {
	
	private static int puerto = 123;
	private static InetAddress dir;

	/**
	 * Metodo que se ejecuta al crear la clase
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		//InetAddress host = dir.getLocalHost();
		
		//System.out.println(host.getHostAddress());
		
		// Creamos el socket del cliente
		Socket socketCliente = new Socket("localhost", puerto);
		
		// Creamos un stream para enviar mensajes al servidor
		DataOutputStream salida = new DataOutputStream(socketCliente.getOutputStream());
		
		// Creamos un stream para recibir los datos del servidor
		DataInputStream entrada = new DataInputStream(socketCliente.getInputStream());
		
		// Enviamos un mensaje al servidor
		salida.writeUTF("Hola, soy el cliente. ¿Estás trabajando?");
		
		// Recibimos un mensaje del servidor
		System.out.println(entrada.readUTF());
		
		// Cerramos los stream de entrada y salida
		salida.close();
		entrada.close();
		
		// Cerramos el socket
		socketCliente.close();
	}
}