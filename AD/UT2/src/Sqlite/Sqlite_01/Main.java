package Sqlite.Sqlite_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

private static String strConn = "jdbc:odbc:Mysql-odbc:mysql://localhost:3306/neptuno", dbUser = "neptuno", dbPass = "neptuno";
	
	public static void main(String[] args) {
		
		try {
			
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

			// Establecemos la conexión con la BD
			Connection conexión = DriverManager.getConnection(strConn, dbUser, dbPass);

			// Preparamos la consulta
			Statement sentencia = conexión.createStatement();
			
			// Cadena de la consulta
			String sql = "SELECT `Id_Cliente`, `Nombre_Compania`, `Nombre_Contacto`, `Ciudad` FROM `clientes`";
			
			// Ejecutamos la sentencia
			ResultSet result = sentencia.executeQuery(sql);

			// Mostramos los registros de la base de datos
			while (result.next()) {
				System.out.println("DATOS DEL USUARIO ID " + result.getInt(1));
				System.out.println("\tNombre de la compañía: " + result.getString(2));
				System.out.println("\tNombre del contacto: " + result.getString(3));
				System.out.println("\tCiudad: " + result.getString(4));
				System.out.println("============================================================");
			}
			
			// Cerramos el ResultSet
			result.close();
			
			// Cerramos la sentencia
			sentencia.close();
			
			// Cerramos la conexion
			conexión.close();
		}
		catch (ClassNotFoundException cn) { cn.printStackTrace(); }
		catch (SQLException e) { e.printStackTrace(); }
	}
}