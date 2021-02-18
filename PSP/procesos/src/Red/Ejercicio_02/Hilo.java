package Red.Ejercicio_02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Hilo extends Thread {
	
	private Socket cliente;
	private String nombreCliente;

	/**
	 * Constructor de la clase
	 * @param cliente
	 * @param nombreCliente
	 */
	public Hilo(Socket cliente, String nombreCliente) {
		this.cliente = cliente;
		this.nombreCliente = nombreCliente;
	}
	


	/**
	 * Metodo que se ejecuta al iniciar la clase
	 */
	public void run() {
		
		String respuesta = "";
		
		try {
			
			DataInputStream dis = new DataInputStream(cliente.getInputStream());
			DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());
				
			dos.writeUTF("Conectado " + nombreCliente);
			System.out.println(dis.readUTF());
			
			dis.close();
			dos.close();
			cliente.close();
		}
		catch (IOException e) { e.printStackTrace(); }
	}
}
