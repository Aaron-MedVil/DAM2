// Se ejecuta desde la linea de comandos.
// Primero lo compilamos desde la carpeta path\procesos\src\Ejemplos con el comando javac Ejemplo3.java
// Primero lo compilamos desde la carpeta path\procesos\src\Ejemplos con el comando javac Ejemplo4.java
// Despues ejecutamos el comando java Ejemplos/Ejemplo4 ej4.txt desde la carpeta path\procesos\src

package Ejemplos;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Ejemplo4 {

	public static void main(String[] args) {
		
		Runtime r = Runtime.getRuntime();
		String comando = "java Ejemplos/Ejemplo3 \"Hola Mundo!!!\"";
		
		Process p = null;
		
		if (args.length < 1) {
			
			System.out.println("SE NECESITA UN NOMBRE DE FICHERO...");
			System.exit(1);
		} else {
			
			try {
				
				// Se utilizan las siguientes clases para escribir lo obtenido con el comando en el fichero
				FileOutputStream fos = new FileOutputStream(args[0]);
				PrintWriter pw = new PrintWriter(fos);
				p = r.exec(comando);
				
				// Se lee el Stream de la salida del proceso, del comando
				InputStream is = p.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				
				// Lee lo obtenido por comando, es decir, la ejecucion de la clase Ejemplo4
				String linea;
				while ( (linea = br.readLine()) != null ) {
					
					System.out.println("INSERTO EN " + args[0] + " > " + linea);
					pw.println(linea); // La inserta en el fichero
				}
				
				br.close();
				pw.close();
			} catch (Exception e) {

				System.err.println("Error en el comando: " + comando);
				e.printStackTrace();
			}
			
			// COMPROBACION DEL ERROR (0-bien, 1-mal)
			int exitVal;
			try {
				exitVal = p.waitFor();
				System.out.println("Valor de Salida: " + exitVal);
			} catch (InterruptedException e) { e.printStackTrace(); }
		}
	}
}