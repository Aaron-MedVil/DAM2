// Sockets UDP: Crea un programa donde el cliente envíe un texto tecleado al servidor,
// el servidor lee el datagrama del servidor y le devuelve el mismo mensaje añadiendo RECIBIDO POR EL SERVIDOR.
// El programa cliente recibe un datagrama del servidor y muestra información del mismo por pantalla (IP, puerto del servidor).
// El programa servidor finaliza cuando recibe como cadena un asterisco.

package Red.Ejercicio_03;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Main {

	public static void main(String[] args) throws IOException {
		
		byte[] buffer = new byte[1024];
		byte[] bufferEnvio = new byte[1024];
		DatagramSocket dSocket = new DatagramSocket(123);
		
		System.out.println("Esperando a recibir datagramas de un cliente...");
		
		// Recogemos el mesaje del cliente
		DatagramPacket recibo = new DatagramPacket(buffer, buffer.length);
		dSocket.receive(recibo);
		
		// Transformamos el mensaje en un array de bytes
		String mensaje = recibo.getData() + " RECIBIDO POR EL SERVIDOR";
		bufferEnvio = mensaje.getBytes();
		
		// Devolvemos el mensaje al cliente
		DatagramPacket envio = new DatagramPacket(bufferEnvio, bufferEnvio.length);		
		dSocket.send(envio);
		
		dSocket.close();
	}
}