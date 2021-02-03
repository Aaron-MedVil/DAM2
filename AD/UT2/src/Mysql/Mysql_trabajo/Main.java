package Mysql.Mysql_trabajo;

import java.sql.*;

public class Main {
	
	private static String strConn = "jdbc:mysql://localhost:3306/neptuno", dbUser = "neptuno", dbPass = "neptuno";

	/**
	 * Metodo que se ejecuta al iniciar la clase
	 * @param args
	 */
	public static void main(String[] args) {

		/* ========== AVISO ========== */
		// El conector que nos mandastes me daba fallo en mi base de datos, por lo que
		// buscando por internet recomendaban usar un conector más moderno.
		// En el proyecto te envío también el conector que he utilizado.

		// Por otro lado al ejecutar la sentencia "Class.forName("com.mysql.jdbc.Driver");"
		// me saltaba un error, y al quitarla funciona perfectamente.

		getDataClientes();
		// getDataPedidos();
	}

	/**
	 * Obtiene los datos de clientes
	 */
	private static void getDataClientes() {

		try {

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
		catch (SQLException e) { e.printStackTrace(); }
	}
	
	/**
	 * Obtiene los datos de pedidos
	 */
	private static void getDataPedidos() {
		
		try {

			// Establecemos la conexión con la BD
			Connection conexión = DriverManager.getConnection(strConn, dbUser, dbPass);

			// Preparamos la consulta
			Statement sentencia = conexión.createStatement();
			
			// Cadena de la consulta
			String sql = "SELECT `Id_Pedidos`, `Id_Empleado`, DATE_FORMAT(`Fecha_Pedido`, '%d-%m-%Y'), `Id_Cliente` FROM `pedidos`";
			
			// Ejecutamos la sentencia
			ResultSet result = sentencia.executeQuery(sql);

			// Mostramos los registros de la base de datos
			while (result.next()) {
				System.out.println("DATOS DEL PEDIDO ID " + result.getInt(1));
				System.out.println("\tID Empleado: " + result.getInt(2));
				System.out.println("\tFecha del pedido: " + result.getString(3));
				System.out.println("\tID Cliente: " + result.getInt(4));
				System.out.println("============================================================");
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