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

		if (args.length < 1) {

			System.out.println("Se necesita un nombre de fichero");
			System.exit(1);
		} else {

			try {

				FileOutputStream fos = new FileOutputStream(args[0]);
				PrintWriter pw = new PrintWriter(fos);
				p = r.exec(command);

				InputStream is = p.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(is));

				String linea;
				while ((linea = br.readLine()) != null) {

					System.out.println("Inserto en " + args[0] + " > " + linea);
					pw.println(linea);
				}

				br.close();
				pw.close();
			} catch (Exception e) {
				System.err.println("Error en el comando: " + command);
				e.printStackTrace();
			}

			// COMPROBACION DEL ERROR (0-bien, 1-mal)
			int exitVal;
			try {
				exitVal = p.waitFor();
				System.out.println("Valor de Salida: " + exitVal);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}