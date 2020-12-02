package com.example.a18_activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Funcion para abrir la segunda actividad
     * @param view
     */
    public void abrirActividad(View view) {

        // Crea la llamada a la segunda actividad
        Intent intencion = new Intent(this, MainActivity2.class);

        // Pasa parametros a la segunda actividad
        intencion.putExtra("nombre", "Aarón");
        intencion.putExtra("numero", 27);

        // Abre la segunda actividad
        startActivity(intencion);
    }
}