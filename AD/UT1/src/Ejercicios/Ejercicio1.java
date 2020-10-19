// Comprobar si existe el fichero ‘fichero.txt’ en el directorio actual.

package Ejercicios;

import java.io.File;
import java.io.IOException;

public class Ejercicio1 {

	public static void main(String[] args) {
		
		// Declaramos el fichero (Hay que importar el paquete correspondiente)
		File fichero = new File("ejemplo.txt");

		try {
			
			// Comprobamos si el fichero se crea
			if ( fichero.createNewFile() ) {
				
				System.out.println("Fichero creado");
			} else {
				
				System.err.println("Fichero no creado");
			}
		} catch(IOException e) {
			
			// Imprime la excepcion si se produce algun error
			e.printStackTrace();
		}
	}
}
