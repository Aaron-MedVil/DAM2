package com.example.proyecto_comercio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView lvProductos;
    private List<Producto> listProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvProductos = findViewById(R.id.lvProductos);

        fillLayoutProductos();
    }

    // Funcion del evento de pulsar en un list view
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, listProductos.get(position).getNombre(), Toast.LENGTH_SHORT).show();
    }

    // Rellena el layout de productos
    public void fillLayoutProductos() {

        // Obtenemos los valores del array de imagenes
        TypedArray imgs = getResources().obtainTypedArray(R.array.productImages);

        String nombre = "Haken - Virus";
        String precio = "Min: 10€ - Max: 19€";

        // Insertamos los registros en el arraylist
        listProductos = new ArrayList<>();
        for (int i = 0; i < imgs.length(); i++) {
            listProductos.add(new Producto(nombre, precio, imgs.getResourceId(i, 0)));
        }

        // Asignamos los elementos del arraylist al layout
        MiAdaptadorProductos adapterProductos = new MiAdaptadorProductos(this, R.layout.productos_layout, listProductos);

        // Asignamos el adaptador al listview del activity main
        lvProductos.setAdapter(adapterProductos);

        // Asignamos eventos al pulsar en cada list view
        lvProductos.setOnItemClickListener(this);
    }
}