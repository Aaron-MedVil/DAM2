package Red.ServidorUDP_01;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Cliente {

	public static void main(String[] args) throws IOException {
		
		// IP al que enviamos el mensaje
		InetAddress destino = InetAddress.getLocalHost();
		
		// Puerto al que envio el mensaje
		int puerto = 12345;
		
		// Mensaje que vamos a enviar
		String saludo = "Salidos!!";
		byte[] mensaje = new byte[1024];
		mensaje = saludo.getBytes();
		
		// Construimos el Datagrama para enviar
		DatagramPacket envio = new DatagramPacket(mensaje, mensaje.length, destino, puerto);
		
		// Creamos el DatagramSocket para enviar el Datagrama
		DatagramSocket dSocket = new DatagramSocket(67890);
		
		// Visualizamos la informacion
		System.out.println("Enviando datagramas de longitud: " + envio.getLength());
		System.out.println("Host de destino: " + destino.getHostName());
		System.out.println("Dirección IP de destino: " + destino.getHostAddress());
		System.out.println("Puerto local del socket: " + dSocket.getLocalPort());
		System.out.println("Puerto al que envío: " + envio.getPort());
		
		// Envio el datagrama
		dSocket.send(envio);
		
		// Cerramos el socket
		dSocket.close();		
	}
}