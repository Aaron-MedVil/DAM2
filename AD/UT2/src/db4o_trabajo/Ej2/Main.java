package db4o_trabajo.Ej2;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

public class Main {
	
	private static String BDPer = "data/DBPersonas.yap";
	
	/**
	 * Metodo inicial de la clase
	 * @param args
	 */
	public static void main(String[] args) {
		
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDPer);

		// Creamos Personas
		Persona p1 = new Persona("Juan", "Guadalajara");
		Persona p2 = new Persona("Ana", "Madrid");
		Persona p3 = new Persona("Luis", "Granada");
		Persona p4 = new Persona("Pedro", "Asturias");

		// Almacenar objetos Persona en la base de datos
		db.store(p1); db.store(p2); db.store(p3); db.store(p4);
		db.close();
	}
}
