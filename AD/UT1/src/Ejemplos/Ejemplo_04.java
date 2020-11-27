package Ejemplos;

import java.io.File;

public class Ejemplo_04 {

	public static void main(String[] args) {
		
		String dir = ".";
		File f = new File(dir);
		
		String[] archivos = f.list();
		
		System.out.println("Ficheros en el directorio actual");
		for (String string : archivos) {
			File f2 = new File(f, string);
			System.out.println("Nombre: " + f2.getName());
		}
	}
}