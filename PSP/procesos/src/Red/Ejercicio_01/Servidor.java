// Haz un programa donde se implemente Sockets TCP donde el
// cliente envíe al servidor un mensaje “Hola, soy el cliente. ¿Estás trabajando?”
// y el servidor le conteste “Hola, soy el servidor. Sí, estoy trabajando”.

package Red.Ejercicio_01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	
	private static int puerto = 123;

	/**
	 * Metodo que se ejecuta al crear la clase
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		// Creamos el socket del servidor en un puerto definido
		ServerSocket serverSocket = new ServerSocket(puerto);
		
		// Creamos el socket del cliente
		Socket clienteSocket = serverSocket.accept();
		System.out.println("Cliente conectado...");
		
		// Abrimos el flujo para recibir los datos enviados del cliente
		DataInputStream dis = new DataInputStream(clienteSocket.getInputStream());
		
		// Abrimos el flujo para enviar datos al cliente
		DataOutputStream dos = new DataOutputStream(clienteSocket.getOutputStream());
		
		// Recibimos el mensaje del cliente
		System.out.println(dis.readUTF());
		
		// Enviamos la respuesta al cliente
		dos.writeUTF("Hola, soy el servidor. Sí, estoy trabajando");
		
		// Cerramos el buffer de lectura y el stream de escritura
		dis.close();
		dos.close();
		
		// Cerramos la conexion con los sockets
		serverSocket.close();
		clienteSocket.close();
	}
}