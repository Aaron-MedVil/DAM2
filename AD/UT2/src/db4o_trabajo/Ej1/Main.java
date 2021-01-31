package db4o_trabajo.Ej1;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Main {

	// Nombre de la base de datos
	private static String dbName = "data/empleded.yap";

	/**
	 * Metodo inicial de la clase
	 * @param args
	 */
	public static void main(String[] args) {
		
		insertarDepartamentos();
		insertarEmpleados();
		consultarDatos();
	}

	/**
	 * Metodo que inserta los datos de los departamentos
	 * 
	 * @param args
	 */
	public static void insertarDepartamentos() {

		Departamentos d1 = new Departamentos("CONTABILIDAD", "SEVILLA", 10);
		Departamentos d2 = new Departamentos("INVESTIGACIÓN", "MADRID", 20);
		Departamentos d3 = new Departamentos("VENTAS", "BARCELONA", 30);
		Departamentos d4 = new Departamentos("PRODUCCIÓN", "BILBAO", 40);

		try {

			ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), dbName);

			db.store(d1); db.store(d2); db.store(d3); db.store(d4);
			db.close();
		}
		catch (Exception err) { err.printStackTrace(); }
	}

	/**
	 * Metodo que inserta los datos de los empleados
	 */
	private static void insertarEmpleados() {

		Empleados e1 = new Empleados("SÁNCHEZ", "EMPLEADO", "17/12/2017", 7369, 7902, 1040, 0, 20);
		Empleados e2 = new Empleados("ARROYO", "VENDEDOR", "20/02/2017", 7499, 7698, 1500, 390, 30);
		Empleados e3 = new Empleados("SALA", "VENDEDOR", "22/02/2018", 7521, 7698, 1625, 650, 30);
		Empleados e4 = new Empleados("JIMÉNEZ", "DIRECTOR", "02/04/2018", 7566, 7839, 2900, 0, 20);

		try {

			ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), dbName);

			db.store(e1); db.store(e2); db.store(e3); db.store(e4);
			db.close();
		}
		catch (Exception err) { err.printStackTrace(); }
	}
	
	/**
	 * Metodo que consulta los datos de los empleados que del departamento 30
	 */
	private static void consultarDatos() {
		
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), dbName);
		
		Departamentos dep = new Departamentos(null, null, 30);
		ObjectSet<Departamentos> d = db.queryByExample(dep);
		
		if (d.size() > 0) {
			
			Departamentos resDep = d.next();
			Empleados emp = new Empleados(null, null, null, 0, 0, 0, 0, resDep.getDept_no());
			ObjectSet<Empleados> e = db.queryByExample(emp);
			
			if (e.size() > 0) {
				
				int cont = 0;
				
				while(e.hasNext()) {
					
					Empleados resEmp = e.next();
					
					System.out.println("\n========== DATOS DEL EMPLEADO " + ++cont + " ==========");
					System.out.println("\t- EMP_NO: " + resEmp.getEmp_no());
					System.out.println("\t- APELLIDO: " + resEmp.getApellido());
					System.out.println("\t- OFICIO: " + resEmp.getOficio());
					System.out.println("\t- DIR: " + resEmp.getDir());
					System.out.println("\t- FECHA_ALT: " + resEmp.getFecha_alt());
					System.out.println("\t- SALARIO: " + resEmp.getSalario());
					System.out.println("\t- COMISIÓN: " + resEmp.getComision());
					System.out.println("\t- DEPT_NO: " + resEmp.getDept_no());
					System.out.println("\t- DEP_NAME: " + resDep.getDnombre());
				}
			}
			else { System.err.println("No existen registros de empleados+"); }
		}
		else { System.err.println("No existen registros de departamentos"); }
		
		db.close();
	}
}