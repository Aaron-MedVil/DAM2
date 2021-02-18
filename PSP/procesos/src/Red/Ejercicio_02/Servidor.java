// Conexión múltiples clientes.
// Crea un programa donde el servidor pueda atender hasta 3 clientes.
// Debe enviar a cada cliente un mensaje indicando el número de cliente que es (1, 2 o 3).
// El cliente responderá al servidor “Mensaje recibido y devuelto por el cliente “ + mensaje.

package Red.Ejercicio_02;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) throws IOException {
		
		// Abrimos el socket del servidor
		ServerSocket server = new ServerSocket(123);
		
		int i = 1;
		
		do {
			
			try {
				
				// Abrimos el socket del cliente
				Socket cliente = server.accept();
				
				// Creamos un hilo con el cliente creado
				Hilo hilo = new Hilo(cliente, "Cliente-" + i);
				hilo.start();
				
				i++;
			} catch (Exception e) {}
		} while(i <= 3);
	}
}
