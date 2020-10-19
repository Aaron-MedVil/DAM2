package com.example.a01_hola_mundo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;
    private TextView twr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.insertNumber1);
        et2 = (EditText) findViewById(R.id.insertNumber2);
        twr = (TextView) findViewById(R.id.textViewResultado);
    }

    public void sumar(View view) {

        int n1 = Integer.parseInt(et1.getText().toString()), n2 = Integer.parseInt(et2.getText().toString());
        twr.setText("Resultado de la operación: " + String.valueOf(n1+n2));
    }

    public void restar(View view) {

        int n1 = Integer.parseInt(et1.getText().toString()), n2 = Integer.parseInt(et2.getText().toString());
        twr.setText("Resultado de la operación: " + String.valueOf(n1-n2));
    }
}