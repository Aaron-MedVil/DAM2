using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;
using System.Windows;

namespace Fabrica.Modelo {

    class FabricaSql {

        private String connStr = ConfigurationManager.ConnectionStrings["connFabricaSql"].ConnectionString;
        private SqlConnection conn = null;
        private SqlDataAdapter adp = null;
        private SqlCommand cmd = null;
        private SqlDataReader reader = null;

        private Dictionary<String, dynamic> retornos = null;

        /// <summary>Comprueba la conexion a la base de datos</summary>
        /// <returns type="Dictionary">Informacion de la conexion</returns>
        public Dictionary<String, dynamic> checkConn() {

            retornos = new Dictionary<String, dynamic>();

            bool isConn = false;
            string msg = "Error al conectar a la base de datos";

            try {

                conn = new SqlConnection(connStr);
                conn.Open();
                isConn = true;
                msg = "Conexión realizada correctamente";
            }
            catch (SqlException e) { msg = e.ToString(); }
            finally { if (conn.State == ConnectionState.Open) { conn.Close(); } }

            retornos.Add("status", isConn);
            retornos.Add("msg", msg);

            return retornos;
        }

        /// <summary></summary>
        /// <param name="args">Argumentos para la sentencia</param>
        /// <returns type="Dictionary">Datos de la consulta</returns>
        public Dictionary<String, dynamic> cargaDatosMateriasPrimas(Dictionary<string, string>? args) {

            DataTable dataTabla = new DataTable();

            retornos = new Dictionary<string, dynamic>();
            bool status = false;
            string msg = "Error en la sentencia";

            try {

                // Crea la conexion y la abre
                conn = new SqlConnection(connStr);
                conn.Open();

                // Crea la sentencia a la base de datos
                cmd = new SqlCommand();
                cmd.CommandText = "SELECT id, Descripcion, idProveedor, idFamilia, stock, stockMinimo, precioCoste, rutaImagen, imagen FROM MateriasPrimas";

                // Carga los argumentos en la sentencia
                if (args != null) {

                    cmd.CommandText += " WHERE 1 = @def";

                    foreach (var param in args) {

                        cmd.CommandText += " AND " + param.Key + " = @" + param.Key;
                        cmd.Parameters.AddWithValue("@" + param.Key, param.Value);
                    }

                    cmd.Parameters.AddWithValue("@def", 1);
                }

                // Conecta la sentencia y la conexion
                cmd.Connection = conn;

                // Ejecuta la sentencia
                reader = cmd.ExecuteReader();

                // Comprueba que se retornan datos
                if (reader.HasRows) {

                    // Carga los datos en la datatabla
                    dataTabla.Load(reader);
                    retornos.Add("data", dataTabla);

                    status = true;
                    msg = "Datos de la primera conexion";
                } else { msg = "No se devolvieron datos"; }
            }
            catch (SqlException e) { msg = e.ToString(); }
            finally { if (conn.State == ConnectionState.Open) { conn.Close(); } }

            retornos.Add("status", status);
            retornos.Add("msg", msg);
            return retornos;
        }
    }
}