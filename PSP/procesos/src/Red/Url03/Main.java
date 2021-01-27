package Red.Url03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Main {

	/**
	 * Metodo principal de la clase
	 * @param args
	 */
	public static void main(String[] args) {
		
		URL url = null;
		URLConnection urlConn = null;
		
		try {
			
			url = new URL("https://github.com/Aaron-MedVil");
			
			// Abrimos la conexion a la pagina
			urlConn = url.openConnection();
			
			// Guardamos en un inputStream el contenido de la pagina que hemos abierto
			InputStream is = urlConn.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			// Leemos el contenido del inputStream
			String linea;
			while((linea = br.readLine()) != null) { System.out.println(linea); }
		}
		catch (MalformedURLException mfuErr) { mfuErr.printStackTrace(); }
		catch (IOException ioErr) { ioErr.printStackTrace(); }
		catch (Exception err) { err.printStackTrace(); }
	}
}