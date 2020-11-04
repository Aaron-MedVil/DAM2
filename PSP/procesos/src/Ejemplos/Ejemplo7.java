// Para ejecutarlo primero lo compilamos con el comando "javac Ejemplos/Ejemplo7.java"
// Despues ejecutamos desde la carpeta src el comando "java Ejemplos/Ejemplo7"

package Ejemplos;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejemplo7 {

	public static void main(String[] args) {
		
		// Creamos la instancia de la clase ProcessBuilder y le asignamos el comando que queramos ejecutar
		ProcessBuilder pb= new ProcessBuilder();
		pb = pb.command("CMD", "/C", "DIR");
		
		try {
			
			// Guardamos en una variable de tipo Process la ejecucion del ProcessBuilder
			Process p = pb.start();
			
			// Guardamos el resultado del comando en un InputStream y lo visualizamos linea a linea con el BufferedReader
			InputStream is = p.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			// Leemos cada linea del buffer y lo visualizamos
			String linea;
			
			while( (linea = br.readLine()) != null ) {
				System.out.println(linea);
			}
			
			br.close();
		} catch (Exception e) { e.printStackTrace(); }
	}
}