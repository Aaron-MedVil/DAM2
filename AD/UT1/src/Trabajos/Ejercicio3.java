// Mostrar la siguiente información de un fichero de la carpeta actual
// (si no existiera ninguno, crear uno de cualquier tipo antes de hacer la práctica):
// · Nombre del fichero.
// · Ruta.
// · Ruta absoluta.
// · Nombre del directorio padre.
// · ¿Se puede escribir?
// · ¿Se puede leer?
// · Tamaño.
// · ¿Es un directorio?
// · ¿Es un fichero?

package Trabajos;

import java.io.File;
import java.io.IOException;

public class Ejercicio3 {

	public static void main(String[] args) {

		File f = new File("fichero.txt");

		try {
			
			if (f.createNewFile() == false) {
				if (f.exists()) { printData(f); }
				else { System.err.println("Error al crear el fichero"); }
			} else { printData(f); }
		} catch (IOException e) { e.printStackTrace(); }
	}

	private static void printData(File f) {
		
		System.out.printf("Nombre %s %n", f.getName());
		System.out.printf("Ruta %s %n", f.getPath());
		System.out.printf("Ruta absoluta %s %n", f.getAbsolutePath());
		System.out.printf("Nombre directorio padre %s %n", f.getParent());
		System.out.printf("¿Se puede escribir? %b %n", f.canWrite());
		System.out.printf("¿Se puede leer? %b %n", f.canRead());
		System.out.printf("Tamaño %s %n", f.length());
		System.out.printf("¿Es un directorio? %b %n", f.isDirectory());
		System.out.printf("¿Es un fichero? %b %n", f.isFile());
	}
}