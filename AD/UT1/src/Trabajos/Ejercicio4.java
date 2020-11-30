// Crear un directorio (de nombre ‘A_Datos’) en el directorio actual,
// a continuación, crear dos ficheros vacíos (‘fiche_1’ y ‘fiche_2’) en dicho directorio.
// Renombrar uno de ellos.

package Trabajos;

import java.io.File;
import java.io.IOException;

public class Ejercicio4 {

	public static void main(String[] args) {

		File f = new File("A_Datos");
		f.mkdir();

		File f2 = new File(f.getAbsolutePath() + "\\fiche_1.txt");
		File f3 = new File(f.getAbsolutePath() + "\\fiche_2.txt");
		File f4 = new File(f.getAbsolutePath() + "\\fiche_2_nuevo.txt");
		
		try {

			f2.createNewFile();
			f3.createNewFile();
		} catch (IOException e) { e.printStackTrace(); }
		
		f3.renameTo(f4);
	}
}