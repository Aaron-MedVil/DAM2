package com.example.a24_recycler_view_fragments_com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Detalle_Activity extends AppCompatActivity {

    private ImageView imageViewDetalle;
    private TextView textViewNombreDetalle, textViewDescripcionDetalle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_);

        imageViewDetalle = findViewById(R.id.imageViewDetalle);
        textViewNombreDetalle = findViewById(R.id.textViewNombreDetalle);
        textViewDescripcionDetalle = findViewById(R.id.textViewDescripcionDetalle);

        // Recuperamos los datos que hemos enviado como parametros
        Producto producto = (Producto)getIntent().getSerializableExtra("item_producto");

        // Asignamos los datos que hemos enviado con la interfaz de la actividad
        imageViewDetalle.setImageResource(producto.getImgProducto());
        textViewNombreDetalle.setText(producto.getNomProducto());
        textViewDescripcionDetalle.setText(producto.getDescProducto());
    }
}