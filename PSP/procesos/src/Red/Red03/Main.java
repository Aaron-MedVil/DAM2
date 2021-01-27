package Red.Red03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

	/**
	 * Metodo principal de la clase
	 * @param args
	 */
	public static void main(String[] args) {
		
		URL url = null;
	
		try {
			
			url = new URL("https://github.com/Aaron-MedVil");
			
			InputStream is = url.openStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			String linea;
			while ((linea = br.readLine()) != null) { System.out.println(linea); }
		}
		catch (MalformedURLException mfuErr) { mfuErr.printStackTrace(); }
		catch (IOException ioErr) { ioErr.printStackTrace(); }
		catch (Exception err) { err.printStackTrace(); }
	}
}