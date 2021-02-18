package Red.Ejercicio_03;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws IOException {

		Scanner teclado = new Scanner(System.in);
		byte[] mensaje = new byte[1024];

		// IP al que enviamos el mensaje
		InetAddress destino = InetAddress.getLocalHost();
		
		// Recogemos el mensaje que vamos a enviar
		System.out.println("Inserte un mensaje");
		mensaje = teclado.nextLine().getBytes();
		
		// Construimos el Datagrama para enviar
		DatagramPacket envio = new DatagramPacket(mensaje, mensaje.length, destino, 123);
		DatagramSocket dSocket = new DatagramSocket(67890);
		
		// Envio el datagrama
		dSocket.send(envio);
				
		// Cerramos el socket
		dSocket.close();
	}

}
