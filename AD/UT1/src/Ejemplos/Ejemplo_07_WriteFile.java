package Ejemplos;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejemplo_07_WriteFile {

	public static void main(String[] args) throws IOException {

		// Creacion del fichero
		File f = new File("src/Ejemplos/Res/AleatorioEjemplo.dat");
		RandomAccessFile raf = new RandomAccessFile(f, "rw");

		// Arrays de datos
		String apellido[] = { "FERNANDEZ", "GIL", "LOPEZ", "RAMOS", "SEVILLA", "CASILLA", "REY" };
		int dep[] = { 10, 20, 10, 10, 30, 30, 20 };
		Double salario[] = { 1000.45, 2400.60, 3000.0, 1500.56, 2200.0, 1435.87, 2000.0 };
		
		// Buffer para almacenar el apellido
		StringBuffer buffer = null;
		
		// Recorremos los arrays
		for (int i = 0; i < apellido.length; i++) {
			
			// Creamos el buffer y le asignamos un tamaño
			buffer = new StringBuffer(apellido[i]);
			buffer.setLength(10);
			
			// Insertamos los valores del fichero
			raf.writeInt(i + 1);
			raf.writeChars(buffer.toString());
			raf.writeInt(dep[i]);
			raf.writeDouble(salario[i]);
		}
		
		raf.close();
	}
}