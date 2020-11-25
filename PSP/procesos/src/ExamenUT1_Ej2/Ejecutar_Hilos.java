/**
 * Para ejecutar el codigo tendremos que abrir una ventana de comandos.
 * Navegaremos hasta el directorio del proyecto.
 * Tendremos que ejecutar los siguientes comandos desde la carpeta "src"
 * Para compilar el proyecto usaremos el comando "javac ExamenUT1_Ej2/Ejecutar_Hilos.java"
 * Para ejecutar el proyecto usaremos el comando "java ExamenUT1_Ej2/Ejecutar_Hilos"
 */

package ExamenUT1_Ej2;

public class Ejecutar_Hilos {

	public static void main(String[] args) {
		
		// Creamos las instancias de la clase Tic
		Tic ti1 = new Tic(1); Tic ti2 = new Tic(2); Tic ti3 = new Tic(3);
		
		// Ejecutamos el proceso de los hilos de la clase Tic
		ti1.start(); ti2.start(); ti3.start();
		
		// Creamos las instancias de la clase Toc
		Toc to1 = new Toc(1); Toc to2 = new Toc(2); Toc to3 = new Toc(3);
		
		// Ejecutamos el proceso de los hilos de la clase Toc
		to1.start(); to2.start(); to3.start();
	}
}