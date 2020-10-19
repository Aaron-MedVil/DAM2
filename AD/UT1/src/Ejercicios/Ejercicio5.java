// Mostrar la siguiente información de un fichero de texto:
// a. Nombre del fichero.
// b. Ruta.
// c. Ruta absoluta.
// d. Nombre del directorio padre.
// e. ¿Se puede escribir?
// f. ¿Se puede leer?
// g. Tamaño.
// h. ¿Es un directorio?
// i. ¿Es un fichero?

package Ejercicios;

import java.io.File;

public class Ejercicio5 {

	public static void main(String[] args) {

		File fichero = new File("ejercicios\\ejemplo.txt");

		if (fichero.exists()) {

			// Mostramos el nombre del fichero
			System.out.println("Nombre del fichero: " + fichero.getName());

			// Mostramos la ruta del fichero
			System.out.println("Ruta del fichero: " + fichero.getPath());

			// Mostramos la ruta absoluta del fichero
			System.out.println("Ruta absoluta del fichero: " + fichero.getAbsolutePath());

			// Mostramos la ruta del directorio padre del fichero
			System.out.println("Directorio padre del fichero: " + fichero.getParent());

			// Mostramos si se puede escribir el fichero
			String canWrite = (fichero.canWrite() ? "Se puede escribir" : "No se puede escribir");
			System.out.println("¿El fichero se puede escribir?: " + canWrite);

			// Mostramos si se puede leer el fichero
			String canRead = (fichero.canRead() ? "Se puede leer" : "No se puede leer");
			System.out.println("¿El fichero se puede leer?: " + canRead);

			// Mostramos el tamaño del fichero
			System.out.println("Tamaño del fichero: " + fichero.length());

			// Mostramos si el fichero es un directorio
			String isDirectory = (fichero.isDirectory() ? "Es un directorio" : "No es un directorio");
			System.out.println("¿El fichero es un directorio?: " + isDirectory);

			// Mostramos si el fichero es un fichero
			String isFile = (fichero.isFile() ? "Es un fichero" : "No es un fichero");
			System.out.println("¿El fichero es un fichero?: " + isFile);
		} else {
			
			System.err.println("El fichero no existe");
		}
	}
}
