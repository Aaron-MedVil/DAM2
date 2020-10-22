package com.example.ud2_1_operaciones_variante;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView twResult;
    private EditText etN1, etN2;
    private RadioButton rbSumar, rbRestar, rbMultiplicar, rbDividir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etN1 = findViewById(R.id.etN1);
        etN2 = findViewById(R.id.etN2);

        twResult = findViewById(R.id.twResult);

        rbSumar = findViewById(R.id.rbSumar);
        rbRestar = findViewById(R.id.rbRestar);
        rbMultiplicar = findViewById(R.id.rbMultiplicar);
        rbDividir = findViewById(R.id.rbDividir);
    }

    public void realizarCalculo(View view) {

        int n1 = (isNumeric(etN1.getText().toString()) == true) ? Integer.parseInt(etN1.getText().toString()) : 0;
        int n2 = (isNumeric(etN2.getText().toString()) == true) ? Integer.parseInt(etN2.getText().toString()) : 0;

        if (rbSumar.isChecked()) {
            twResult.setText(String.valueOf(n1+n2));
        } else if (rbRestar.isChecked()) {
            twResult.setText(String.valueOf(n1-n2));
        } else if (rbMultiplicar.isChecked()) {
            twResult.setText(String.valueOf(n1*n2));
        } else if (rbDividir.isChecked()) {
            twResult.setText(String.valueOf(n1/n2));
        } else {
            twResult.setText("Resultado");
        }
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