package com.example.a26_dbconn;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class ProductoDB {

    /**
     * Obtiene la conexion a la base de datos
     * @param context
     * @return
     */
    public SQLiteDatabase getConn(Context context) {

        // Instanciamos la clase DbConn
        DbConn conn = new DbConn(context, "dbProductos", null, 1);

        // Creamos la conexion a la base de datos
        SQLiteDatabase db = conn.getWritableDatabase();
        return db;
    }

    /**
     * Metodo que obtiene la conexion a la base de datos para insertar un registro
     * @param context
     * @param prod
     * @return
     */
    public int InsertaProducto(Context context, Producto prod) {

        int res = 0;

        String sql = "INSERT INTO productos (idProd, nomProd, descProd, pvpProd)" +
                "VALUES ( " + prod.getCodigo() + " , '" + prod.getNombre() + "', '" + prod.getDescripcion() + "', " + prod.getPrecio() + ")";
        SQLiteDatabase db = this.getConn(context);

        try {

            db.execSQL(sql);
            res = 1;
        }
        catch(Exception e) { Log.e("Error", e.toString()); }
        finally { db.close(); }

        return res;
    }

    /**
     * Metodo que obtiene la conexion a la base de datos para eliminar un registro
     * @param context
     * @param codProd
     * @return
     */
    public int EliminarProducto(Context context, int codProd) {

        int res = 0;

        String sql = "DELETE FROM productos WHERE idProd = " + codProd;
        SQLiteDatabase db = this.getConn(context);

        try {

            db.execSQL(sql);
            res = 1;
        }
        catch(Exception e) { Log.e("Error", e.toString()); }
        finally { db.close(); }

        return res;
    }

    /**
     * Metodo que obtiene la conexion a la base de datos para buscar un registro
     * @param context
     * @param codProd
     * @return
     */
    public Producto BuscarProducto(Context context, int codProd) {

        Producto prod = new Producto();

        String sql = "SELECT idProd, nomProd, descProd, pvpProd FROM productos WHERE idProd = " + codProd;
        SQLiteDatabase db = this.getConn(context);

        Cursor c = db.rawQuery(sql, null);

        if (c.moveToFirst()) {

            prod.setCodigo(c.getInt(0));
            prod.setNombre(c.getString(1));
            prod.setDescripcion(c.getString(2));
            prod.setPrecio(c.getDouble(3));

            db.close();

            return prod;
        }
        else { return null; }
    }

    /**
     * Metodo que obtiene la conexion a la base de datos para modificar un registro
     * @param context
     * @param prod
     * @return
     */
    public int ModificarProducto(Context context, Producto prod) {

        int res = 0;

        String sql = "UPDATE productos" +
                " SET idProd = " + prod.getCodigo() + ", nomProd = '" + prod.getNombre() + "', descProd = '" + prod.getDescripcion() + "', pvpProd = " + prod.getPrecio() +
                " WHERE idProd = " + prod.getCodigo();

        SQLiteDatabase db = this.getConn(context);

        try {

            db.execSQL(sql);
            res = 1;
        }
        catch(Exception e) { Log.e("Error", e.toString()); }
        finally { db.close(); }

        return res;
    }
}