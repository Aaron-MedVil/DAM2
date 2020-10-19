// Crear el directorio ‘UT1’ y en su interior el directorio ‘Ejercicios’.

package Ejercicios;

import java.io.File;

public class Ejercicio6 {

	public static void main(String[] args) {

		File fichero = new File("ejercicios");
		
		// Creamos el directorio
		if ( fichero.mkdirs() ) {
			System.out.println("Directorio creado");
		} else {
			System.err.println("Directorio no creado");
		}		
	}
}
