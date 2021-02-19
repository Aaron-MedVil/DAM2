package com.example.examen_segunda;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.examen_segunda.utilidades.Utilidades;

public class Db_Conn extends SQLiteOpenHelper {

    /**
     * Constructor de la clase
     * @param context
     * @param name
     * @param factory
     * @param version
     */
    public Db_Conn(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**
     * Metodo que crea la base de datos
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilidades.CREAR_TABLA_EMPLEADO);
    }

    /**
     * Metodo que actualiza la base de datos
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(Utilidades.BORRAR_TABLA_EMPLEADO);
        onCreate(db);
    }
}
