package Ejemplos;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejemplo2 {

	public static void main(String[] args) {
		
		Runtime r = Runtime .getRuntime();
		String comando = "cmd /c dir";
		Process p = null;
		
		try {
			
			p = r.exec(comando);
			
			InputStream is = p.getInputStream();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			String linea;
			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
			
			br.close();
		} catch (Exception e) {
			System.err.println("Error en el comando: " + comando);
			e.printStackTrace();
		}
	}
}