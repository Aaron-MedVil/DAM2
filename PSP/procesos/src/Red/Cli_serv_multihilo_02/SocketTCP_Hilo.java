package Red.Cli_serv_multihilo_02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SocketTCP_Hilo extends Thread {
	
	private DataOutputStream flujoSalida;
	private DataInputStream flujoEntrada;
	private Socket socketCliente;

	/**
	 * Constructor de la clase
	 * @param cliente
	 * @param dis
	 * @param dos
	 */
	public SocketTCP_Hilo(Socket cliente, DataInputStream dis, DataOutputStream dos) {
		this.flujoEntrada = dis;
		this.flujoSalida = dos;
		this.socketCliente = cliente;
	}

	/**
	 * Metodo que ejecuta la clase
	 */
	public void run() {
		
		String cadena = "";
		
		try {
			
			flujoSalida.writeUTF("\nBienvenido cliente");
			
			do {
				
				flujoSalida.writeUTF("\n* para salir.");
				cadena = flujoEntrada.readUTF();
				flujoSalida.writeUTF("\nEntrada: " + cadena);
			}
			while(cadena == "*");
			
			flujoSalida.close();
			flujoEntrada.close();
			socketCliente.close();
		}
		catch (IOException e) { e.printStackTrace(); }
	}
}
