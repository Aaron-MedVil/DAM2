// Escribir el nombre de 10 municipios de la provincia de Burgos en un fichero de texto.
// El nombre de las poblaciones se debe obtener de un array de String y se irán grabando una a continuación de la otra sin saltos de línea.

package Trabajos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio5 {

	public static String[] ciudades = { "Aranda de Duero", "Castrillo de la Vega", "Torresandino", "Miranda de Ebro", "Belorado", "Fuentespina", "Pinilla Trasmonte", "Lerma", "Frías", "Roa" };
	
	public static void main(String[] args) throws IOException {

		File f = new File("municipios.txt");
		
		f.createNewFile();
		escribirFichero(f);
				
		BufferedReader br = new BufferedReader(new FileReader(f));
		System.out.println(br.readLine());
		br.close();
		
	}
	
	public static void escribirFichero(File f) throws IOException {
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		String cadena = "";
		
		for (String ciudad : ciudades) { cadena += ciudad + " - "; }
		cadena = cadena.substring(0, cadena.length() -3);
		bw.write(cadena);
		bw.close();
	}
}