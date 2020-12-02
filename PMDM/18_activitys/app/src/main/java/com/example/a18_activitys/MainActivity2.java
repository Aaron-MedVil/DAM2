package com.example.a18_activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle extras = getIntent().getExtras();
        String nombre = extras.getString("nombre");
        int numero = extras.getInt("numero");

        Toast.makeText(this, "Nombre: " + nombre + ", Número: " + numero, Toast.LENGTH_SHORT).show();
    }
}