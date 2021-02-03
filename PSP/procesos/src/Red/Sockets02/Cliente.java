package Red.Sockets02;

import java.io.*;
import java.net.*;

public class Cliente {

	public static void main(String[] args) throws Exception {
		
		String host = "localhost";
		int puerto = 6000;
		
		System.out.println("Programa iniciado...");
		Socket cliente = new Socket(host, puerto);
		
		// CREA FLUJO DE SALIDA AL SERVIDOR
		DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());
		
		// CREA FLUJO DE ENTRADA AL SERVIDOR
		DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
		
		// EL SERVIDOR ENVIA UN MENSAJE
		System.out.println("Recibiendo del servidor: \n\t" + flujoEntrada.readUTF());
		
		// CERRAR STREAMS Y SOCKETS
		flujoEntrada.close();
		flujoSalida.close();
		cliente.close();
	}
}