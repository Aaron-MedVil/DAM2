// Mostrar la lista de ficheros existentes en el directorio actual.
// Listar cada uno en una línea.

package Trabajos;

import java.io.File;

public class Ejercicio2 {

	public static void main(String[] args) {

		File f = new File(".");
		String[] lista = f.list();
		
		System.out.println("Lista de ficheros en el directorio actual");
		System.out.println("-----------------------------------------");
		
		for (String l : lista) {
			File f2 = new File(l);
			if (f2.isFile() == true) { System.out.printf("Fichero %s %n", f2.getName()); }
		}
	}
}
