package db4o;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Main {

	// Nombre de la base de datos
	private static String BDPer = "data/DBPersonas.yap";

	/**
	 * Metodo principal del programa
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		insertarRegistros();
		leerRegistros();
	}

	/**
	 * Crea los datos de la base de datos
	 * @param db
	 */
	public static void insertarRegistros() {
		
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
	
	/**
	 * Lee los datos de la base de datos
	 * @param db
	 */
	public static void leerRegistros() {
		
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDPer);
		
		Persona per = new Persona(null, null);
		ObjectSet<Persona> result = db.queryByExample(per);
		
		if (result.size() == 0) { System.out.println("No existen registros de Personas..."); }
		else {
			
			System.out.printf("Número de registros: %d %n", result.size());			
			while (result.hasNext()) {
				Persona p = result.next();
				System.out.printf("Nombre: %s, Ciudad: %s %n", p.getNombre(), p.getCiudad());
			}
		}
		
		db.close();
	}
}