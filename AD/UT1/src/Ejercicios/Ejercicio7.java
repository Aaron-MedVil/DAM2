// Crear un directorio (de nombre ‘FICHEROS’) en el directorio actual, a continuación, crear dos ficheros vacíos en dicho directorio.
// Renombrar uno de ellos.
// Finalmente, borrar uno de los ficheros creados.

package Ejercicios;

import java.io.File;
import java.io.IOException;

public class Ejercicio7 {

	public static void main(String[] args) {

		File fichero = new File("ficheros");

		// Creamos el directorio
		if (fichero.mkdirs()) {
			System.out.println("Directorio creado");

			File fichero1 = new File("ficheros\\fichero1.txt");
			File fichero2 = new File("ficheros\\fichero2.txt");

			try {

				// Comprobamos si el fichero1 se crea
				if (fichero1.createNewFile()) {

					System.out.println("Fichero1 creado");
				} else {

					System.err.println("Fichero1 no creado");
				}

				// Comprobamos si el fichero2 se crea
				if (fichero2.createNewFile()) {

					System.out.println("Fichero2 creado");
				} else {

					System.err.println("Fichero2 no creado");
				}
			} catch (IOException e) {

				// Imprime la excepcion si se produce algun error
				e.printStackTrace();
			}
		} else {

			System.err.println("Directorio no creado");
		}
	}
}
