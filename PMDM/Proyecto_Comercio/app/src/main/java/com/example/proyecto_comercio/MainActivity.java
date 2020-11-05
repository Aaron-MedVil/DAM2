package com.example.proyecto_comercio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lvProductos;
    private List<Producto> listProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvProductos = findViewById(R.id.lvProductos);

        listProductos = new ArrayList<>();
        listProductos.add(new Producto("Haken - Virus", "Min: 10€ - Max: 19€", R.drawable.haken_virus));
        listProductos.add(new Producto("Haken - Virus", "Min: 10€ - Max: 19€", R.drawable.haken_virus));
        listProductos.add(new Producto("Haken - Virus", "Min: 10€ - Max: 19€", R.drawable.haken_virus));

        MiAdaptadorProductos adapterProductos = new MiAdaptadorProductos(this, R.layout.productos_layout, listProductos);

        lvProductos.setAdapter(adapterProductos);

    }
}