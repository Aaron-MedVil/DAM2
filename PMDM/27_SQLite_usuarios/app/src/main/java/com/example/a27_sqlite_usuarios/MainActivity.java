package com.example.a27_sqlite_usuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    /**
     * Metodo que se ejecuta cuando se crea la clase
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DbConn conn = new DbConn(this, "dbUsuarios", null, 1);
    }

    /**
     * Muestra la actividad para crear un usuario
     * @param view
     */
    public void registrarUsuario(View view) {

        Intent intent = new Intent(MainActivity.this, RegistrarUsuario.class);
        startActivity(intent);
    }

    /**
     * Muestra la actividad para consultar los datos de un usuario
     * @param view
     */
    public void consultarUsuario(View view) {

        Intent intent = new Intent(MainActivity.this, ConsultarUsuario.class);
        startActivity(intent);
    }

    /**
     * Muestra la actividad para listar los usuarios
     * @param view
     */
    public void listarUsuarios(View view) {}
}