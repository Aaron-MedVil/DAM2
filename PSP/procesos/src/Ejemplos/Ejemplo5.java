// Se ejecuta desde la linea de comandos.
// Primero lo compilamos desde la carpeta $path\procesos\src\Ejemplos con el comando javac Ejemplo5.java
// Despues ejecutamos el comando java Ejemplos/Ejemplo5 svchost.txt desde la carpeta $path\procesos\src

package Ejemplos;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Ejemplo5 {

	public static void main(String[] args) {

		Runtime r = Runtime.getRuntime();
		String command = "TASKLIST /FI \"imagename eq svchost.exe\" /svc";

		Process p = null;

		// Comprobamos si enviamos por la linea de comandos algun argumento
		if (args.length < 1) {

			System.out.println("Se necesita un nombre de fichero");
			System.exit(1);
		} else {

			try {
				
				// Abrimos el flujo para crear un fichero(El nombre del fichero es el especificado en los argumentos)
				FileOutputStream fos = new FileOutputStream("Resources\\" + args[0]);
				
				// Abre el flujo para escribir en el fichero creado caracter a caracter
				PrintWriter pw = new PrintWriter(fos);
				
				// Ejecutamos el comando
				p = r.exec(command);

				// Leo la salida del comando
				InputStream is = p.getInputStream();
				
				// Abrir el flujo para escribir un fichero linea a linea
				BufferedReader br = new BufferedReader(new InputStreamReader(is));

				// Insertamos la salida del comando ejecutado linea a linea en el fichero que hayamos indicado
				String linea;
				while ((linea = br.readLine()) != null) {
					pw.println(linea);
				}

				// Cerramos el flujo de datos
				br.close();
				pw.close();
			} catch (Exception e) { e.printStackTrace(); }

			// COMPROBACION DEL ERROR (0-bien, 1-mal)
			int exitVal;
			try {
				
				// Espera a que el subproceso acabe de ejecutarse
				exitVal = p.waitFor();
				System.out.println("Valor de Salida: " + exitVal);
			} catch (InterruptedException e) { e.printStackTrace(); }
		}
	}
}