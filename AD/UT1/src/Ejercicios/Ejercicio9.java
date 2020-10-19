// A partir de la cadena de texto ‘En un lugar de la Mancha de cuyo…’, realizar un programa Java que muestre dicha cadena carácter a carácter.

package Ejercicios;

import java.io.IOException;
import java.io.StringReader;

public class Ejercicio9 {

	public static void main(String[] args) throws IOException {
		
		final String cadena = "En un lugar de la Mancha de cuyo…";
		char c;
		StringReader sr = new StringReader(cadena);
		
		for (int i = 0; i < cadena.length(); i++) {
			c = (char) sr.read();
			System.out.println(c);
		}
	}
}
