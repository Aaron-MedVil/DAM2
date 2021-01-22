package db4o;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

public class Main {
	
	// Nombre de la base de datos
	private static String BDPer = "data/DBPersonas.yap";

	/**
	 * Metodo principal del programa
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Creamos y abrimos la base de datos
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDPer);
		
		// Creamos registro para la base de datos
		Persona p1 = new Persona("Juan", "Guadalajara");
		Persona p2 = new Persona("Ana", "Madrid");
		Persona p3 = new Persona("Luis", "Granada");
		Persona p4 = new Persona("Pedro", "Asturias");
		
		// Almacenamos los registros en la base de datos
		db.store(p1); db.store(p2); db.store(p3); db.store(p4);
		
		// Cerramos la base de datos
		db.close();
	}
}