package Red.Red02;

import java.net.MalformedURLException;
import java.net.URL;

public class Main {

	/**
	 * Metodo principal de la clase
	 * @param args
	 */
	public static void main(String[] args) {

		URL url;


		try {

			System.out.println("========================================");
			System.out.println("CONSTRUCTOR SIMPLE PARA LA URL:");
			url = new URL("https://github.com/Aaron-MedVil");
			Visualizar(url);
			
			System.out.println("========================================");
			System.out.println("CONSTRUCTOR PARA PROTOCOLO + URL + DIRECTORIO:");
			url = new URL("https", "www.fpsantacatalina.com", "/cifpsurvey/index.php/58317");
			Visualizar(url);
			
			System.out.println("========================================");
			System.out.println("CONSTRUCTOR PARA PROTOCOLO + URL + PUERTO + DIRECTORIO:");
			url = new URL("http", "docs.oracle.com", 80, "/javase/7");
			Visualizar(url);
		}
		catch (MalformedURLException e) { e.printStackTrace(); }
	}

	/**
	 * Visualiza los datos de las url
	 * @param url
	 */
	private static void Visualizar(URL url) {
		
		System.out.println("\t URL completa: " + url.toString() + ""
				+ "\t getProtocol(): " + url.getProtocol()
				+ "\t getHost(): " + url.getHost()
				+ "\t getPort(): " + url.getPort()
				+ "\t getFile(): " + url.getFile()
				+ "\t getUserInfo(): " + url.getUserInfo()
				+ "\t getPath(): " + url.getPath()
				+ "\t getAuthority(): " + url.getAuthority()
				+ "\t getQuery(): " + url.getQuery());
		
		System.out.println("========================================");
	}
}