package com.example.a04_pedir_pizza;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView twResumen;
    private RadioButton rbLlevar, rbTomarAqui;
    private CheckBox cbQueso, cbBacon, cbTomate, cbMaiz, cbPina, cbOlivas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Boton realizar pedido
    public void realizarPedido(View view) {

        rbLlevar = findViewById(R.id.rbLlevar);
        rbTomarAqui = findViewById(R.id.rbTomarAqui);

        String res = (rbLlevar.isChecked()) ? "Pedido para llevar" : ( (rbTomarAqui.isChecked()) ? "Pedido para tomar aqui" : "Indique donde va a tomar el pedido" );
        Toast.makeText(this, res, Toast.LENGTH_SHORT).show();
    }

    // Añade un ingrediente al resultado
    public void addIngr(View view) {

        twResumen = findViewById(R.id.twResumen);
        cbQueso = findViewById(R.id.cbQueso);
        cbBacon = findViewById(R.id.cbBacon);
        cbTomate = findViewById(R.id.cbTomate);
        cbMaiz = findViewById(R.id.cbMaiz);
        cbPina = findViewById(R.id.cbPina);
        cbOlivas = findViewById(R.id.cbOlivas);

        String res = "Pedido final";

        if (cbQueso.isChecked()) {
            res = res+" \n- Queso";
        }

        if (cbBacon.isChecked()) {
            res = res+" \n- Bacon";
        }

        if (cbTomate.isChecked()) {
            res = res+" \n- Tomate";
        }

        if (cbMaiz.isChecked()) {
            res = res+" \n- Maíz";
        }

        if (cbPina.isChecked()) {
            res = res+" \n- Piña";
        }

        if (cbOlivas.isChecked()) {
            res = res+" \n- Olivas";
        }

        twResumen.setText(res);
    }
}