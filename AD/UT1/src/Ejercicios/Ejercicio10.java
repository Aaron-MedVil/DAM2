// Realizar un programa Java que permita leer de un fichero de texto y escribir en otro su contenido.

package Ejercicios;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class Ejercicio10 {
	
	/*
	 * [Clase main]
	 */
	public static void main(String[] args) throws IOException {
		
		File fichero = new File(".\\ej10\\ej10.txt");
		File ficheroFW = new File(".\\ej10\\ej10-FW.txt");
		File ficheroBW = new File(".\\ej10\\ej10-BW.txt");
		
		System.out.println("---------- Lectura con FileReader ----------");
		char[] c2 = readFileReader(fichero);
		// System.out.println(c2);
		writeFileWriter(fichero, ficheroFW, c2);
		
		//System.out.println("---------- Lectura con BufferedReader ----------");
		//readBufferedReader(fichero);
	}

	private static void writeFileWriter(File fichero, File ficheroFW, char[] c2) {
		System.out.println(c2);
	}

	private static void writeFileWriter(File fichero, File ficheroFW) {}

	/*
	 * [Código para leer con FileReader]
	 */
	private static char[] readFileReader(File fichero) throws IOException {
	
		FileReader fr = new FileReader(fichero);
		char c;
		char[] c2 = new char[(int) fichero.length()];
		for (int i = 0; i < fichero.length(); i++) {
			c = (char) fr.read();
			c2[i] = c;
		}
		
		fr.close();
		return c2;
	}
	
	/*
	 * [Código para leer con BufferedReader]
	 */
	private static void readBufferedReader(File fichero) throws IOException{
		
		FileReader fr = new FileReader(fichero);
		BufferedReader br = new BufferedReader(fr);

		String strCurrentLine;
		
		while ( (strCurrentLine = br.readLine()) != null ) {
			
			System.out.println(strCurrentLine);
		}
		
		br.close();
	}
}
