// Para ejecutarlo primero lo compilamos con el comando "javac Ejemplos/Ejemplo6.java"
// Despues lo ejecutamos desde la carpeta src con el comando "java Ejemplos/Ejemplo6"

package Ejemplos;

import java.util.List;
import java.util.Map;

public class Ejemplo6 {

	public static void main(String[] args) {
		
		ProcessBuilder pb = new ProcessBuilder();
		
		// El método enviroment del proceso nos devuelve las variables de entorno
		Map entorno = pb.environment();
		
		System.out.println("Variables de entorno: ");
		System.out.println(entorno);
		
		// Creamos el objeto ProcessBuilder con los parametros que queramos y guardamos el resultado en una lista 
		pb = new ProcessBuilder("java", "Ejemplos/Ejemplo3", "\"Hola Mundo!!\"");
		List<String> lista = pb.command();
		
		// Imprime por pantalla los elementos de la lista que se produce al ejecutar el comando
		for (String l : lista) {
			System.out.println(l);
		}
	}
}