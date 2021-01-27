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
				+ "\n\t getProtocol(): " + url.getProtocol()
				+ "\n\t getHost(): " + url.getHost()
				+ "\n\t getPort(): " + url.getPort()
				+ "\n\t getFile(): " + url.getFile()
				+ "\n\t getUserInfo(): " + url.getUserInfo()
				+ "\n\t getPath(): " + url.getPath()
				+ "\n\t getAuthority(): " + url.getAuthority()
				+ "\n\t getQuery(): " + url.getQuery());
		
		System.out.println("========================================");
	}
}