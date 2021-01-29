package com.example.a27_sqlite_usuarios;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.a27_sqlite_usuarios.utilidades.utilidades;

public class DbConn extends SQLiteOpenHelper {

    final String CREAR_TABLA_USUARIO = utilidades.CREAR_TABLA_USUARIO;
    final String BORRAR_TABLA_USUARIO = utilidades.BORRAR_TABLA_USUARIO;

    final String CREAR_TABLA_CURSO = utilidades.CREAR_TABLA_CURSOS;
    final String BORRAR_TABLA_CURSO = utilidades.BORRAR_TABLA_CURSOS;

    /**
     * Constructor de la clase
     * @param context
     * @param name
     * @param factory
     * @param version
     */
    public DbConn(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) { super(context, name, factory, version); }

    /**
     * Metodo que crea la tabla de la base de datos
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREAR_TABLA_USUARIO);
        db.execSQL(CREAR_TABLA_CURSO);
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
        db.execSQL(BORRAR_TABLA_CURSO);
        onCreate(db);
    }
}
