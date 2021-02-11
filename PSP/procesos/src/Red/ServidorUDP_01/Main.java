package Red.ServidorUDP_01;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Main {

	public static void main(String[] args) throws IOException {
		
		// Buffer para recibir el datagrama
		byte[] buffer = new byte[1024];
		
		// Creamos un objeto DatagramSocket y especificamos el puerto
		DatagramSocket dSocket = new DatagramSocket(12345);
		
		// Esperamos que se cliente envie un datagrama
		System.out.println("El servidor esta esperando a recibir un datagrama del cliente...");
		
		// Recogemos el datagrama
		DatagramPacket recibo = new DatagramPacket(buffer, buffer.length);
		dSocket.receive(recibo);
		
		// Obtenemos el numero de bytes recibidos del mensaje
		int bytesRec = recibo.getLength();
		
		// Obtenemos el mensaje
		byte[] paquete = recibo.getData();
		
		// Visualizamos la informacion del datagrama recibido
		System.out.println("Nº Bytes recibidos: " + bytesRec); // Número de bytes recibidos
		System.out.println("Contenido paquete: " + paquete); // Mensaje que envia el paquete
		System.out.println("Puerto de origen: " + recibo.getPort()); // Puerto del cliente
		System.out.println("Dirección IP de origen: " + recibo.getAddress()); // Direccion del cliente
		System.out.println("Puerto de destino: " + dSocket.getLocalPort()); // Puerto local
		
		// Cerramos el DatagramSocket
		dSocket.close();
	}
}