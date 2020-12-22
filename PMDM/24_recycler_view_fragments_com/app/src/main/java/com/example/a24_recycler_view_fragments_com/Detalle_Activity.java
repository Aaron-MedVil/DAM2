package com.example.a24_recycler_view_fragments_com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

public class Detalle_Activity extends AppCompatActivity implements Serializable {

    private ImageView imageViewDetalle;
    private TextView textViewNombreDetalle, textViewDescripcionDetalle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_);

        imageViewDetalle = findViewById(R.id.imageViewDetalle);
        textViewNombreDetalle = findViewById(R.id.textViewNombreDetalle);
        textViewDescripcionDetalle = findViewById(R.id.textViewDescripcionDetalle);

        Producto producto = (Producto)getIntent().getSerializableExtra("item_producto");


        imageViewDetalle.setImageResource(producto.getImgProducto());
        textViewNombreDetalle.setText(producto.getNomProducto());
        textViewDescripcionDetalle.setText(producto.getDescProducto());
    }
}