package com.example.a03_ejemplos_componentes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView twResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Cambia el valor del TextView dependiendo del checkbox que marquemos
    public void cambioEstadoCivil(View view) {

        twResult = findViewById(R.id.twResult);

        Boolean checked = ((RadioButton) view).isChecked();
        String sEstado = "";

        switch (view.getId()) {
            case R.id.rbCasado:
                sEstado = (checked) ? "Casada/o" : "";
                break;
            case R.id.rbSoltero:
                sEstado = (checked) ? "Soltera/o" : "";
                break;
            case R.id.rbViudo:
                sEstado = (checked) ? "Viuda/o" : "";
                break;
            case R.id.rbOtro:
                sEstado = (checked) ? "Otra/o" : "";
                break;
            default:
                sEstado = "";
                break;
        }

        twResult.setText("Estado civil " + sEstado);
    }
}