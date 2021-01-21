package Red.Red02;

import java.net.URL;

public class Main {

	public static void main(String[] args) {

		URL url;


		try {

			System.out.println("========================================");
			System.out.println("CONSTRUCTOR SIMPLE PARA LA URL:");
			url = new URL("https://github.com/Aaron-MedVil");
			Visualizar(url);
			
			System.out.println("========================================");
			System.out.println("CONSTRUCTOR PARA PROTOCOLO + URL + DIRECTORIO:");
			url = new URL("https", "www.fpsantacatalina.com", "cifpsurvey/index.php/58317");
			Visualizar(url);
			
			System.out.println("========================================");
			System.out.println("CONSTRUCTOR PARA PROTOCOLO + URL + PUERTO + DIRECTORIO:");
			url = new URL("http", "docs.oracle.com", 80, "/javase/7");
			Visualizar(url);
		}
		catch (Exception e) { e.printStackTrace(); }
	}

	private static void Visualizar(URL url) {
		
		System.out.println("\t URL completa: " + url.toString());
		System.out.println("\t getProtocol(): " + url.getProtocol());
		System.out.println("\t getHost(): " + url.getHost());
		System.out.println("\t getPort(): " + url.getPort());
		System.out.println("\t getFile(): " + url.getFile());
		System.out.println("\t getUserInfo(): " + url.getUserInfo());
	}
}