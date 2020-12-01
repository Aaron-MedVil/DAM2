package Ejemplos;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;

public class Ejemplo_06_Read {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Ejemplo_06_Persona persona;
		File fichero = new File("./src/Ejemplos/Res/fichPersona.dat");
		
		ObjectInputStream dataIS = new ObjectInputStream(new FileInputStream(fichero));
		
		int i = 1;
		try {
			while (true) {
				persona = (Ejemplo_06_Persona)dataIS.readObject();
				System.out.print(i + " => ");
				System.out.printf("Nombre: %s, edad: %d %n", persona.getNombre(), persona.getEdad());
				i++;
			}
		}
		catch (EOFException eo) { System.out.println("FIN DE LECTURA."); }
		catch (StreamCorruptedException x) {}

		dataIS.close();
	}
}