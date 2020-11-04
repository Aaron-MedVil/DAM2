package Ejemplos;

import java.io.File;

public class Ejemplo8 {

	public static void main(String[] args) {
		
		// Creamos la instancia de la clase ProcessBuilder y le pasamos por parametros el comando
		ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "DIR");
		
		File fOut = new File("D:\\Github\\DAM2\\PSP\\procesos\\src\\Resources\\Ejemplo8.txt");
		File fErr = new File("D:\\Github\\DAM2\\PSP\\procesos\\src\\Resources\\Ejemplo8Err.txt");
		
		pb.redirectOutput(fOut);
		pb.redirectError(fErr);
	}
}