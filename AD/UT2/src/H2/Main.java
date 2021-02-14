package H2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	private static String strConn = "jdbc:h2:D:/Programs/H2/DB/Clases/Clases";
	
	public static void main(String[] args) {
		
		try {

			// Establecemos la conexión con la BD
			Connection conexión = DriverManager.getConnection(strConn, "sa", "");

			// Preparamos la consulta
			Statement sentencia = conexión.createStatement();
			
			// Cadena de la consulta
			String sql = "SELECT * FROM cursos";
			
			// Ejecutamos la sentencia
			ResultSet result = sentencia.executeQuery(sql);

			// Mostramos los registros de la base de datos
			while (result.next()) {
				System.out.println("DATOS DEL CURSO <<" + result.getString(1) + ">>");
				System.out.println("\tNombre: " + result.getString(2));
				System.out.println("\tFecha inicio: " + result.getString(3));
				System.out.println("\tDuracion: " + result.getInt(4));
				System.out.println("\tProfesor: " + result.getString(5));
				System.out.println("\tPrecio: " + result.getInt(6));
				System.out.println("============================================================\n");
			}
			
			// Cerramos el ResultSet
			result.close();
			
			// Cerramos la sentencia
			sentencia.close();
			
			// Cerramos la conexion
			conexión.close();
		}
		catch (SQLException e) { e.printStackTrace(); }
	}
}