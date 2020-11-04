package Ejemplos;

import java.io.File;
import java.io.IOException;

public class Ejemplo8 {

	public static void main(String[] args) throws IOException {
		
		// Creamos la instancia de la clase ProcessBuilder y le pasamos por parametros el comando
		ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "DIR");
		
		// Especificamos los ficheros que queremos que se creen en caso de dar error y en caso de funcionar
		File fOut = new File("D:\\Github\\DAM2\\PSP\\procesos\\src\\Resources\\Ejemplo8.txt");
		File fErr = new File("D:\\Github\\DAM2\\PSP\\procesos\\src\\Resources\\Ejemplo8Err.txt");
		
		// Redirigimos las salidas a los ficheros y ejecutamos el comando
		pb.redirectOutput(fOut);
		pb.redirectError(fErr);
		pb.start();
	}
}