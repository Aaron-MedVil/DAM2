package com.example.a06_alumno_curso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView twResult;
    Spinner spnAlumnos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        twResult = findViewById(R.id.twResult);
        spnAlumnos = findViewById(R.id.spnAlumnos);

        String[] cursos = {"DAM", "DAW", "SMR"};

        spnAlumnos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                twResult.setText(parent.getItemAtPosition(position).toString() + " - " + cursos[(int)id]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                twResult.setText("Resultado");
            }
        });
    }
}