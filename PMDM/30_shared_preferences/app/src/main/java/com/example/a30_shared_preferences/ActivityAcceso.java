package com.example.a30_shared_preferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityAcceso extends AppCompatActivity {

    private TextView tw_usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceso);

        tw_usuario = findViewById(R.id.tw_usuario);

        // Abrimos el fichero credenciales con permisos privados
        SharedPreferences preferencias = getSharedPreferences("credenciales", Context.MODE_PRIVATE);

        // Obtenemos las variables de preferencias
        String user = preferencias.getString("user", null);

        // Asigna el valor de las variables obtenidas en el TextView
        tw_usuario.setText("Bienvenido " + user);
    }
}