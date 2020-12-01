package Ejemplos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Ejemplo_06 {

	public static void main(String[] args) throws IOException {
		
		Ejemplo_06_Persona persona;
		File fichero = new File("./src/Ejemplos/Res/fichPersona.dat");
		
		FileOutputStream fout = new FileOutputStream(fichero, true);
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		
		String nombres[] = {"Ana", "Luis", "Alicia", "Pedro"};
		int edades[] = {14, 15, 16, 17};
		
		System.out.println("Grabo los datos de persona");
		
		for (int i = 0; i < edades.length; i++) {
			persona = new Ejemplo_06_Persona(nombres[i], edades[i]);
			oos.writeObject(persona);
			System.out.println("Grabo los datos de persona");
		}
		
		oos.close();
	}
}