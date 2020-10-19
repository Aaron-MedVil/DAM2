// Obtener la �ltima fecha de modificaci�n del fichero �fichero.txt�.

package Ejercicios;

import java.io.File;
import java.text.SimpleDateFormat;

public class Ejercicio4 {

	public static void main(String[] args) {
		
		File fichero = new File("ejemplo.txt");
		
		// Creamos una instancia de la clase SimpleDateFormat
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		// Mostramos el resultado parseado por la clase SimpleDateFormat
		System.out.println("Fecha de �ltima modificaci�n: " + sdf.format(fichero.lastModified()));
	}
}
