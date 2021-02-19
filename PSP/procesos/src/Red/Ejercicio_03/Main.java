// Sockets UDP: Crea un programa donde el cliente envíe un texto tecleado al servidor,
// el servidor lee el datagrama del servidor y le devuelve el mismo mensaje añadiendo RECIBIDO POR EL SERVIDOR.
// El programa cliente recibe un datagrama del servidor y muestra información del mismo por pantalla (IP, puerto del servidor).
// El programa servidor finaliza cuando recibe como cadena un asterisco.

package Red.Ejercicio_03;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Main {

	public static void main(String[] args) throws IOException {
		
		// Socket para recibir y enviar datos datos
		DatagramSocket socketLocal = new DatagramSocket(0123);
		System.out.println("Esperando a recibir datagramas de un cliente...");
		
		while(true) {
			
			// Array de bytes para recibir y enviar datos
			byte[] bufferRecibo = new byte[2048], bufferEnvio = new byte[2048];
			
			// Creamos las variables que utilizaremos para recibir y enviar cadenas
			String mensajeEnviado, mensajeRecibido;
			
			/* =========================================== */
			/* ========== RECEPCION DE PAQUETES ========== */
			/* =========================================== */
			
			// Recogemos el mesaje del cliente
			DatagramPacket recibo = new DatagramPacket(bufferRecibo, bufferRecibo.length);
			socketLocal.receive(recibo);
			
			// Recogemos el mensaje del paquete que hemos recibido
			mensajeRecibido = new String(recibo.getData());
			System.out.println("Mensaje del cliente: " + mensajeRecibido);
			System.out.println("IP del cliente: " + recibo.getAddress());
			System.out.println("Puerto del cliente: " + recibo.getPort());
			
			/* ======================================= */
			/* ========== ENVIO DE PAQUETES ========== */
			/* ======================================= */
			
			// Construimos el mensaje que vamos a enviar
			mensajeEnviado = mensajeRecibido+" - RECIBIDO POR EL SERVIDOR";
			bufferEnvio = mensajeEnviado.getBytes();
			
			// Construimos el Datagrama para enviar y lo enviamos
			DatagramPacket envio = new DatagramPacket(bufferEnvio, bufferEnvio.length, recibo.getAddress(), recibo.getPort());
			socketLocal.send(envio);
			
			/* ================================================= */
			/* ========== RESOLUCION DEL ENVIO/RECIBO ========== */
			/* ================================================= */
			
			if (mensajeRecibido.trim().compareTo("*") == 0) break;
			
			mensajeEnviado = "";
			mensajeRecibido = "";
		}
		
		System.out.println("Conexión cerrada...");
		socketLocal.close();
	}
}