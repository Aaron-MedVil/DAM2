package com.example.a26_dbconn;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbConn extends SQLiteOpenHelper {

    // Sentencia para crear la tabla
    private final String TB_PRODUCTO = "CREATE TABLE productos (idProd INT PRIMARY KEY, nomProd TEXT, descProd TEXT, pvpProd REAL)";

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
     * Metodo que se ejecuta cuando se crea la clase
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {

        // Si no existe la tabla la crea y si existe la abre
        db.execSQL(TB_PRODUCTO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {  }
}