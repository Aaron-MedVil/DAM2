// Realizar un programa Java que muestre los ficheros de un directorio.
// El nombre del directorio se pasará al programa desde la línea de comandos al ejecutarlo.

package Ejercicios;

import java.io.File;
import java.util.Scanner;

public class Ejercicio8 {

	public static void main(String[] args) {

		// Creamos el escanner para que el usuario cree una variable
		Scanner sc = new Scanner(System.in);

		System.out.print("Inserte el nombre del directorio: ");

		// Recogemos el nombre del directorio que ha insertado el usuario
		String userFile = sc.nextLine();

		File fichero = new File(".\\"+userFile);

		// Guardamos los nombres de los ficheros en un array
		String[] files = fichero.list();
		
		// Comprobamos si el directorio contiene ficheros
		if ( files != null ) {
			
			// Creamos un bucle para imprimir el nombre de cada fichero
			for (String file : files) {

				System.out.println(file);
			}
		} else {
			System.err.println("El directorio especificado no contiene ficheros");
		}
		
		sc.close();
	}
}
