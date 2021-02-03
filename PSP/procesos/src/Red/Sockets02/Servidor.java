package Red.Sockets02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) throws IOException {
		
		int puerto = 6000;
		
		ServerSocket servidor = new ServerSocket(puerto);
		Socket clienteConectado = null;
		System.out.println("Esperando al cliente...");
		clienteConectado = servidor.accept();
		
		// CREA FLUJO DE ENTRADA DEL CLIENTE
		InputStream entrada = null;
		entrada = clienteConectado.getInputStream();
		DataInputStream flujoEntrada = new DataInputStream(entrada);
		
		// EL CLIENTE ENVIA UN MENSAJE
		System.out.println("Recibido del cliente: \n\t" + flujoEntrada.readUTF());
		
		// CREA FLUJO ENTRADA AL CLIENTE
		OutputStream salida = null;
		salida = clienteConectado.getOutputStream();
		DataOutputStream flujoSalida = new DataOutputStream(salida);
		
		// ENVIANDO UN SALUDO AL CLIENTE
		flujoSalida.writeUTF("Saludos al cliente del servidor");
		
		// CERRAR STREAMS Y SOCKETS
		entrada.close();
		flujoEntrada.close();
		salida.close();
		flujoSalida.close();
		clienteConectado.close();
		servidor.close();
	}
}