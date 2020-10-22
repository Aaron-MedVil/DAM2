// Se ejecuta desde la linea de comandos.
// Primero lo compilamos desde la carpeta path\procesos\src\Ejemplos con el comando javac Ejemplo3.java
// Despues ejecutamos el comando java Ejemplos\Ejemplo3 "String" desde la carpeta path\procesos\src

package Ejemplos;

public class Ejemplo3 {

	public static void main(String[] args) {
		
		if (args.length < 1) {
			
			System.out.println("Se necesita un saludo");
			System.exit(1);
		} else {
			
			for (int i = 0; i < 5; i++) {
				System.out.println(i + " . " + args[0]);
			}
		}
	}
}