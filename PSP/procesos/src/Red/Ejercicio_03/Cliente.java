package Red.Ejercicio_03;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws IOException {

		// Creamos las variables que utilizaremos para recibir y enviar cadenas
		String mensajeEnviado, mensajeRecibido;
		
		// Scanner para recoger datos introducidos por el teclado
		Scanner teclado = new Scanner(System.in);

		// IP del servidor
		InetAddress destino = InetAddress.getByName("localhost");
		int puertoEnvio = 0123;
		
		// Socket para recibir y enviar datos datos
		DatagramSocket socketLocal = new DatagramSocket();
		
		while(true) {
			
			// Array de bytes para recibir y enviar datos
			byte[] bufferRecibo = new byte[2048], bufferEnvio = new byte[2048];
			
			/* ======================================= */
			/* ========== ENVIO DE PAQUETES ========== */
			/* ======================================= */
			
			// Recogemos el mensaje que vamos a enviar
			System.out.println("Inserte un mensaje");
			mensajeEnviado = teclado.nextLine();
			bufferEnvio = mensajeEnviado.getBytes();
			
			// Construimos el Datagrama para enviar y lo enviamos
			DatagramPacket envio = new DatagramPacket(bufferEnvio, bufferEnvio.length, destino, puertoEnvio);
			socketLocal.send(envio);
			
			/* =========================================== */
			/* ========== RECEPCION DE PAQUETES ========== */
			/* =========================================== */
			
			// Recogemos el mesaje del cliente
			DatagramPacket recibo = new DatagramPacket(bufferRecibo, bufferRecibo.length);
			socketLocal.receive(recibo);
						
			// Recogemos el mensaje del paquete que hemos recibido
			mensajeRecibido = new String(recibo.getData());
			System.out.println("Mensaje del servidor: " + mensajeRecibido);
			
			/* ================================================= */
			/* ========== RESOLUCION DEL ENVIO/RECIBO ========== */
			/* ================================================= */
			
			if (mensajeEnviado.trim().compareTo("*") == 0) break;
			
			mensajeEnviado = "";
			mensajeRecibido = "";
		}
		
		System.out.println("Conexión cerrada...");
				
		// Cerramos los flujos
		socketLocal.close();
		teclado.close();
	}

}
