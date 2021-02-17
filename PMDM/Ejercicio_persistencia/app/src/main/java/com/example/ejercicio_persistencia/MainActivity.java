package com.example.ejercicio_persistencia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText usuario_entrar, pass_entrar;

    /**
     * Metodo que se ejecuta al crear la clase
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario_entrar = findViewById(R.id.usuario_entrar);
        pass_entrar = findViewById(R.id.pass_entrar);
    }

    /**
     * Metodo que se ejecuta al hacer click en el boton de entrar
     * @param view
     */
    public void btn_entrar(View view) {

        SharedPreferences preferencias = getSharedPreferences("credenciales", Context.MODE_PRIVATE);

        if (preferencias.contains("user") || preferencias.contains("password")) {

            String user = preferencias.getString("user", null);
            String pass = preferencias.getString("password", null);

            if (user.compareTo(usuario_entrar.getText().toString()) == 0 && pass.compareTo(pass_entrar.getText().toString()) == 0) {

                Intent intent = new Intent(MainActivity.this, ActivityAcceso.class);
                startActivity(intent);
            }
            else { guardarCredenciales(preferencias); }
        }
        else { guardarCredenciales(preferencias); }
    }

    /**
     * Crea las preferencias del fichero sharedPreferences
     * @param preferencias
     */
    private void guardarCredenciales(SharedPreferences preferencias) {

        SharedPreferences.Editor editor = preferencias.edit();
        editor.putString("user", usuario_entrar.getText().toString());
        editor.putString("password", pass_entrar.getText().toString());
        editor.commit();

        Toast.makeText(this, "Credenciales guardadas", Toast.LENGTH_SHORT).show();
    }
}