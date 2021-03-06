package Red.Cli_serv_multihilo_01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hilo_Cliente extends Thread {
	
	private DateFormat fecha = new SimpleDateFormat("yyyy/MM/dd"), hora = new SimpleDateFormat("hh:mm:ss");
	private Socket socket = null;
	private DataOutputStream dos = null;
	private DataInputStream dis = null;
	
	/**
	 * Constructor de la clase
	 * @param socket
	 * @param dos
	 * @param dis
	 */
	public Hilo_Cliente(Socket socket, DataOutputStream dos, DataInputStream dis) {
		this.socket = socket;
		this.dos = dos;
		this.dis = dis;
	}

	/**
	 * Metodo que ejecuta la clase
	 */
	public void run() {
		
		String recibe, devuelve;
		boolean res = true;
		
		try {
		
			while(res) {
				
					devuelve = "";
					Date fechaActual = new Date();
					
					dos.writeUTF("�Que quieres? [Fecha, Hora, Exit para salir]");
					recibe = dis.readUTF();
					
					switch (recibe.toLowerCase()) {
						case "fecha":
							devuelve = fecha.format(fechaActual);
							dos.writeUTF(devuelve);
							break;
							
						case "hora":
							devuelve = hora.format(fechaActual);
							dos.writeUTF(devuelve);
							break;
							
						case "exit":
							System.out.println("Cliente " + socket + " acaba!");
							socket.close();
							dos.writeUTF("Conexion cerrada");
							res = false;
							break;
							
						default:
							dos.writeUTF("Error en la entrada");
							break;
					}
				}
			
			dos.close();
			dis.close();
		}
		catch (IOException err) { err.printStackTrace(); }
	}
}