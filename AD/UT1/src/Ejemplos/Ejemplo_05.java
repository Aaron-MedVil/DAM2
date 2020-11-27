package Ejemplos;

import java.io.File;

public class Ejemplo_05 {

	public static void main(String[] args) {

		File ruta = new File(".");
		String[] nombres = ruta.list();
		
		for (String n : nombres) {
			File f2 = new File(n);
			System.out.printf("Nombre: %s %n", f2.getName());
			System.out.printf("Ruta absoluta: %s %n", f2.getAbsolutePath());
			System.out.printf("Ruta relativa: %s %n", f2.getPath());
			System.out.printf("Es fichero: %b %n", f2.isFile());
			System.out.printf("Es directorio: %b %n", f2.isDirectory());
			System.out.printf("Permisos de lectura: %s %n", f2.canRead());
			System.out.printf("Permisos de escritura: %s %n", f2.canWrite());
			
			System.out.println("-----------------------------------------------------");
		}
	
	}
}