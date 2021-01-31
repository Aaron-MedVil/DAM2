package db4o_trabajo.Ej2;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Modificar {
	
	private static String BDPer = "data/DBPersonas.yap";
	
	/**
	 * Metodo inicial de la clase
	 * @param args
	 */
	public static void main(String[] args) {
		
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDPer);
		
		// Modifica los datos
		ObjectSet<Persona> result = db.queryByExample(new Persona(null, "Asturias"));
		
		if (result.size() > 0) {
			
			while (result.hasNext()) {
				
				Persona p = result.next();    
				p.setNombre("Aarón");
				db.store(p);
			}
		}
		else { System.out.println("No existen registros para la ciudad Asturias"); }
		
		// Muestra los datos
		ObjectSet<Persona> result2 = db.queryByExample(new Persona(null, null));
		
		if (result2.size() > 0) {
			
			while (result2.hasNext()) {
				
				Persona p = result2.next();
				System.out.printf("%nNombre: %s, Ciudad: %s", p.getNombre(), p.getCiudad());
			}
		}
		else { System.out.println("No existen registros"); }
		
		db.close();
	}

}
