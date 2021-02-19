package com.example.examen_segunda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nombre_entrar, email_entrar;

    /**
     * Metodo que se ejecuta al crear la actividad
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre_entrar = findViewById(R.id.nombre_entrar);
        email_entrar = findViewById(R.id.email_entrar);

        // Cargamos las preferencias
        load_preferences();
    }

    /**
     * Cmprueba que lo insertado en los EditText coincide con los valores del shared preferences y accede a otra actividad
     * @param view
     */
    public void btn_entrar_aplicacion(View view) {

        // Abrimos el fichero preferencias en modo privado
        SharedPreferences preferencias = getSharedPreferences("credenciales", Context.MODE_PRIVATE);

        // Comprobamos que existen valores en el fichero preferencias
        if (preferencias.contains("name") || preferencias.contains("email")) {

            // Obtenemos los valores del fichero preferencias
            String nombre = preferencias.getString("name", null);
            String email = preferencias.getString("email", null);

            // Comparamos los valores insertados por el usuario con los del fichero preferencias
            if (nombre.compareTo(nombre_entrar.getText().toString()) == 0 && email.compareTo(email_entrar.getText().toString()) == 0) {

                // Iniciamos la actividad
                Intent intent = new Intent(MainActivity.this, Activity_Acceso.class);
                startActivity(intent);
            }
            else { Toast.makeText(this, "Los datos no coinciden con los valores guardados en el fichero preferencias", Toast.LENGTH_SHORT).show(); }
        }
        else { Toast.makeText(this, "Primero tiene que guardar las preferencias", Toast.LENGTH_SHORT).show(); }
    }

    /**
     * Guarda los valores de los EditText en el sharedPreferences
     * @param view
     */
    public void btn_guardar_preferencias(View view) {

        // Abrimos el fichero preferencias en modo privado
        SharedPreferences preferencias = getSharedPreferences("credenciales", Context.MODE_PRIVATE);

        // Con el editor almacenamos los datos insertados por el usuario en el fichero preferencias
        SharedPreferences.Editor editor = preferencias.edit();
        editor.putString("name", nombre_entrar.getText().toString());
        editor.putString("email", email_entrar.getText().toString());
        editor.commit();

        Toast.makeText(this, "Credenciales guardadas", Toast.LENGTH_SHORT).show();
    }

    /**
     * Comprueba si existen valores en el sharedPreferences y los muestra en los EditText
     */
    private void load_preferences() {

        // Cargamos el fichero preferencias
        SharedPreferences preferencias = getSharedPreferences("credenciales", Context.MODE_PRIVATE);

        // Comprobamos si existen datos en el fichero preferencias
        if (preferencias.contains("name") || preferencias.contains("email")) {

            // Mostramos los datos del fichero preferencias en los campos del formulario
            nombre_entrar.setText(preferencias.getString("name", null));
            email_entrar.setText(preferencias.getString("email", null));
        }
    }
}

