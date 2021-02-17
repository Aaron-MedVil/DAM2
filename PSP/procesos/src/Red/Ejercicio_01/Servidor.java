// Haz un programa donde se implemente Sockets TCP donde el
// cliente envíe al servidor un mensaje “Hola, soy el cliente. ¿Estás trabajando?”
// y el servidor le conteste “Hola, soy el servidor. Sí, estoy trabajando”.

package Red.Ejercicio_01;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import java.io.InputStreamReader;

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
		Socket clienteSocket = new Socket();
		
		// El servidor acepta la conexion del cliente
		clienteSocket = serverSocket.accept();
		
		// Creamos el buffer para leer el resultado del cliente
		BufferedReader entrada = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
		String mensaje = entrada.readLine();
		System.out.println(mensaje);
		
		// Enviamos un stream para enviar un mensaje al cliente
		DataOutputStream salida = new DataOutputStream(clienteSocket.getOutputStream());
		salida.writeUTF("Hola, soy el servidor. Sí, estoy trabajando");
		
		// Cerramos el buffer de lectura y el stream de escritura
		entrada.close();
		salida.close();
		
		// Cerramos la conexion con los sockets
		serverSocket.close();
		clienteSocket.close();
	}
}