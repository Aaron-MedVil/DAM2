package com.example.a30_shared_preferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etuser, etpassword;

    /**
     * Metodo que se ejecuta al ejecutar la clase
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etuser = findViewById(R.id.etuser);
        etpassword = findViewById(R.id.etpassword);

        cargarCredenciaes();
    }

    /**
     * Carga las credenciales del fichero credenciales
     */
    private void cargarCredenciaes() {

        // Abrimos el fichero credenciales con permisos privados
        SharedPreferences preferencias = getSharedPreferences("credenciales", Context.MODE_PRIVATE);

        // Obtenemos las variables de preferencias
        String user = preferencias.getString("user", null);
        String pass = preferencias.getString("pass", null);

        // Insertamos en los EditText los valores de las credenciales
        etuser.setText(user);
        etpassword.setText(pass);
    }

    /**
     * Guarda las credenciales en el fichero credenciales
     * @param view
     */
    public void guardarCredenciales(View view) {

        // Abrimos el fichero credenciales con permisos privados
        SharedPreferences preferencias = getSharedPreferences("credenciales", Context.MODE_PRIVATE);

        // Obtenemos los datos de los EditText
        String user = etuser.getText().toString();
        String pass = etpassword.getText().toString();

        // Guardamos mediante un objeto editor las variables de preferencias
        SharedPreferences.Editor editor = preferencias.edit();
        editor.putString("user", user);
        editor.putString("pass", pass);
        editor.commit();

        Toast.makeText(this, "Credenciales guardadas", Toast.LENGTH_SHORT).show();
    }

    /**
     * Carga la activity de acceso
     * @param view
     */
    public void acceso(View view) {

        Intent intent = new Intent(MainActivity.this, ActivityAcceso.class);
        startActivity(intent);
    }
}