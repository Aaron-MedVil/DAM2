package Ejemplos;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class Ejemplo_06_OOS extends ObjectOutputStream {

	public Ejemplo_06_OOS(OutputStream out) throws IOException {
		super(out);
	}

	/** Constructor sin par�metros */
	protected Ejemplo_06_OOS() throws IOException, SecurityException {
		super();
	}

	/** Redefinici�n del m�todo de escribir la cabecera para que no haga nada. */
	protected void writeStreamHeader() throws IOException {
	}
}
