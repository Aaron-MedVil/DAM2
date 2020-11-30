// Comprobar si existe el fichero ‘fichero.txt’ en el directorio actual.
// Si existe, mostrar por pantalla/consola el siguiente mensaje: “El ‘fichero.txt’ si existe”,
// y si no existiera, mostrar por pantalla el mensaje “El ‘fichero.txt’ no existe en la carpeta actual”.

package Trabajos;

import java.io.File;

public class Ejercicio1 {

	public static void main(String[] args) {
		
		File f = new File("fichero.txt");
		
		if (f.exists() == false) {
			System.out.printf("El fichero %s no existe en la carpeta actual", f.getName());
		} else {
			System.out.printf("El fichero %s sí existe en la carpeta actual", f.getName());
		}
	}
}