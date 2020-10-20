package com.example.a03_ejemplos_componentes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RadioButton rbSoltero, rbCasado, rbViudo, rbOtro;
    private TextView twResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rbCasado = findViewById(R.id.rbCasado);
        rbSoltero = findViewById(R.id.rbSoltero);
        rbViudo = findViewById(R.id.rbViudo);
        rbOtro = findViewById(R.id.rbOtro);
        twResult = findViewById(R.id.twResult);
    }

    public void estadoCivil() {

        if (true) {

            twResult.setText("hola");
        }
    }
}