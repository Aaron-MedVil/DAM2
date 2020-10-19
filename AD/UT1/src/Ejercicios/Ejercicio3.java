// 3. Mostrar la lista de ficheros existentes en el directorio actual.

package Ejercicios;

import java.io.File;

public class Ejercicio3 {

	public static void main(String[] args) {
		
		File fichero = new File(".");
		
		// Guardamos los nombres de los ficheros en un array
		String[] files = fichero.list();
		
		// Creamos un bucle para imprimir el nombre de cada fichero
		for(String file:files) {
	         
            System.out.println(file);
         }
	}
}
