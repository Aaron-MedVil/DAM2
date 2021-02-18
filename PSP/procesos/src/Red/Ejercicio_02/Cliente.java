package Red.Ejercicio_02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Cliente {

	public static void main(String[] args) throws IOException {
		
		InetAddress ip = InetAddress.getByName("localhost");
		Socket cliente = new Socket(ip, 123);
		
		DataInputStream dis = new DataInputStream(cliente.getInputStream());
		DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());
		
		String respuesta = dis.readUTF();
		System.out.println(respuesta);
		
		dos.writeUTF("Mensaje recibido y devuelto por el cliente " + respuesta.substring(respuesta.length() - 1));
		
		dis.close();
		dos.close();
		cliente.close();
	}
}