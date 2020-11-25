/**
 * Para ejecutar el proyecto primero tendremos que seguir las instrucciones de la clase TablaMultiplicar.java y compilar la clase
 * Navegaremos hasta el directorio del proyecto.
 * Tendremos que ejecutar los siguientes comandos desde la carpeta "src"
 * Para compilar el proyecto usaremos el comando "javac ExamenUT1_Ej1/PbClass.java"
 * Para ejecutar el proyecto usaremos el comando "java ExamenUT1_Ej1/PbClass 2"
 * Al terminar la ejecucion en la carpeta Logs se mostraran dos ficheros
 * Si la ejecucion ha sido correcta el fichero de error estara vacio y el fichero de salida mostrara la tabla de multiplicar
 */

package ExamenUT1_Ej1;

import java.io.File;
import java.io.IOException;

public class PbClass {

	public static void main(String[] args) throws IOException {
		
		// Comprobamos si recibimos parametros al ejecutar la clase
		if (args.length < 1) {
			
			System.out.println("Se necesita un número");
			System.exit(1);
		} else {
		
			// Creamos la instancia de la clase ProcessBuilder y especificamos el comando que queremos ejecutar
			ProcessBuilder pb = new ProcessBuilder("java", "ExamenUT1_Ej1/TablaMultiplicar", args[0]);
			
			// Creamos los ficheros donde guardaremos la informacion de las salidas		
			File fOut = new File("ExamenUT1_Ej1\\Logs\\TablaMultiplicar"+args[0]+".txt");
			File fErr = new File("ExamenUT1_Ej1\\Logs\\TablaMultiplicar"+args[0]+"Error.txt");
			
			// Asignamos los ficheros a las salidas y ejecutamos el proceso
			pb.redirectOutput(fOut);
			pb.redirectError(fErr);
			pb.start();
		}
	}
}