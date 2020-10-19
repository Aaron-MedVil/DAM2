// Comprobar si existe el fichero ‘fichero.txt’ dando la ruta completa en la que se encuentra.

package Ejercicios;

import java.io.File;

public class Ejercicio2 {

	public static void main(String[] args) {

		// Declaramos el fichero (Hay que importar el paquete correspondiente)
		File fichero = new File("ejemplo.txt");
		
		// Comprobamos si el fichero existe
		if( fichero.exists() ) {
			System.out.println("El fichero existe");
		} else {
			System.err.println("El fichero no exixte");
		}
	}
}
