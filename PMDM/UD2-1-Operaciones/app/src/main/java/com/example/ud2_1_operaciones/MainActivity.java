// Hacer una aplicacion que pida dos numeros en un textview number y que mediante radio buttons

package com.example.ud2_1_operaciones;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView twResult;
    private EditText etN1, etN2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etN1 = findViewById(R.id.etN1);
        etN2 = findViewById(R.id.etN2);
        twResult = findViewById(R.id.twResult);
    }

    public void realizarCalculo(View view) {

        Boolean checked = ((RadioButton) view).isChecked();
        String result = "";

        int n1 = (isNumeric(etN1.getText().toString()) == true) ? Integer.parseInt(etN1.getText().toString()) : 0;
        int n2 = (isNumeric(etN2.getText().toString()) == true) ? Integer.parseInt(etN2.getText().toString()) : 0;

        switch (view.getId()) {
            case R.id.rbSumar:
                result = String.valueOf(n1+n2);
                break;
            case R.id.rbRestar:
                result = String.valueOf(n1-n2);
                break;
            case R.id.rbMultiplicar:
                result = String.valueOf(n1*n2);
                break;
            case R.id.rbDividir:
                result = String.valueOf(n1/n2);
                break;
            default:
                result = "Resultado";
                break;
        }

        twResult.setText(result);
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