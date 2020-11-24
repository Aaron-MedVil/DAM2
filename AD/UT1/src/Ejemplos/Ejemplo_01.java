package Ejemplos;

import java.io.File;
import java.io.IOException;

public class Ejemplo_01 {

	public static void main(String[] args) {

		File fichero1 = new File("src\\Ejemplos\\Files\\file.txt");

		try {

			// Comprobamos si el fichero se crea
			if (fichero1.createNewFile()) {

				System.out.println("Fichero creado");
			} else {

				System.err.println("Fichero no creado");
			}
		} catch (IOException e) {

			// Imprime la excepcion si se produce algun error
			e.printStackTrace();
		}
	}
}