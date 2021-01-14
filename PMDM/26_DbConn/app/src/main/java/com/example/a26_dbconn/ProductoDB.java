package com.example.a26_dbconn;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

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
}