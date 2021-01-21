package com.example.a27_sqlite_usuarios;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbConn extends SQLiteOpenHelper {

    final String CREAR_TABLA_USUARIO = "CREATE TABLE usuarios(dni TEXT, nombre TEXT, telefono TEXT)";
    final String BORRAR_TABLA_USUARIO = "DROP TABLE IF EXISTS usuarios";

    /**
     * Constructor de la clase
     * @param context
     * @param name
     * @param factory
     * @param version
     */
    public DbConn(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**
     * Metodo que crea la tabla de la base de datos
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREAR_TABLA_USUARIO);
    }

    /**
     * Metodo que actualiza la tabla de la base de datos
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(BORRAR_TABLA_USUARIO);
        onCreate(db);
    }
}
