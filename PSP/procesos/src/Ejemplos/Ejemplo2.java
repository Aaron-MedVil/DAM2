package Ejemplos;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejemplo2 {

	public static void main(String[] args) {

		Runtime r = Runtime.getRuntime();
		String comando = "cmd /c dir";
		Process p = null;

		try {

			p = r.exec(comando);

			// Obtenemos el Stream de error si se produce
			InputStream er = p.getErrorStream();
			BufferedReader brer = new BufferedReader(new InputStreamReader(er));

			// Leemos las lineas de error y las visualizamos por pantalla
			String linea_err;
			while ((linea_err = brer.readLine()) != null)
				System.out.println("ERROR > " + linea_err);

			// Leemos la salida de ejecucion por pantalla
			InputStream is = p.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			// Vamos escribiendo cada linea de salida por pantalla
			String linea;
			while ((linea = br.readLine()) != null)
				System.out.println(linea);

			br.close();
			brer.close();
		} catch (Exception e) {

			System.err.println("Error en el comando: " + comando);
			e.printStackTrace();
		}
	}
}