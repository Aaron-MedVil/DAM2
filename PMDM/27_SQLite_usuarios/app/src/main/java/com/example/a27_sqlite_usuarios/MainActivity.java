package com.example.a27_sqlite_usuarios;

import androidx.appcompat.app.AppCompatActivity;

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
     *
     * @param view
     */
    public void registrarUsuario(View view) {

        // Intent intent = new Intent(MainActivity.this, );
    }
}