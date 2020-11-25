/**
 * Para ejecutar el codigo tendremos que abrir una ventana de comandos.
 * Navegaremos hasta el directorio del proyecto.
 * Tendremos que ejecutar los siguientes comandos desde la carpeta "src"
 * Para compilar el proyecto usaremos el comando "javac ExamenUT1_Ej1/TablaMultiplicar.java"
 * Para ejecutar el proyecto usaremos el comando "java ExamenUT1_Ej1/TablaMultiplicar 2"
 */

package ExamenUT1_Ej1;

public class TablaMultiplicar {

	public static void main(String[] args) {
		
		// Comprobamos que se recibe al menos un parametro
		if (args.length < 1) {
			
			System.out.println("Se necesita un número");
			System.exit(1);
		} else {
			
			// Trasnformamos el parametro en un numero
			int arg = Integer.parseInt(args[0]);
			
			// Imprimimos la tabla
			System.out.println("La tabla de multiplicar del número " + arg + " es:");
			for (int i = 0; i <= 10; i++) {
				System.out.println(arg + "x" + i + " = " + arg * i);
			}
		}
	}
}