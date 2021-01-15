package com.example.a26_dbconn;

import android.content.Context;
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
}