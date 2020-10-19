package com.example.ud1_1_evaluar;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2, et3;
    private TextView twr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.nota1);
        et2 = findViewById(R.id.nota2);
        et3 = findViewById(R.id.nota3);
        twr = findViewById(R.id.notaMedia);
    }

    // Calcular la media
    public void media(View view) {

        int n1 = (isNumeric(et1.getText().toString()) == true) ? Integer.parseInt(et1.getText().toString()) : 0;
        int n2 = (isNumeric(et2.getText().toString()) == true) ? Integer.parseInt(et2.getText().toString()) : 0;
        int n3 = (isNumeric(et3.getText().toString()) == true) ? Integer.parseInt(et3.getText().toString()) : 0;

        int notamedia = (n1+n2+n3)/3;

        String txt = (notamedia >= 5) ? "El alumno ha aprobado con un: " + notamedia : "El alumno ha suspendido con un: " + notamedia;
        twr.setText(txt);
    }

    // Comprobar que los valores son numericos
    public static boolean isNumeric(String strNum) {

        if (strNum == null) {
            return false;
        }

        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}