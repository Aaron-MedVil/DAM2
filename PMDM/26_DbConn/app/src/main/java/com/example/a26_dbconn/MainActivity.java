package com.example.a26_dbconn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etCod, etNom, etDesc, etPvp;
    Button btnInsertar, btnBuscar, btnModificar, btnEliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCod = findViewById(R.id.etCod);
        etNom = findViewById(R.id.etNom);
        etDesc = findViewById(R.id.etDesc);
        etPvp = findViewById(R.id.etPvp);
    }
}