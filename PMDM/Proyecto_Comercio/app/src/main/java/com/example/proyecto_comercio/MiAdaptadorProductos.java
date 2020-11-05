package com.example.proyecto_comercio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MiAdaptadorProductos extends ArrayAdapter<Producto> {

    Context contexto;
    int layoutProducto;
    List<Producto> productosList;

    // Constructor de mi adaptador de productos
    public MiAdaptadorProductos(@NonNull Context context, int resource, @NonNull List<Producto> objects) {
        super(context, resource, objects);

        this.contexto = context;
        this.layoutProducto = resource;
        this.productosList = objects;
    }

    // Obtiene la informacion del producto y genera el layout
    @NonNull @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = LayoutInflater.from(contexto).inflate(layoutProducto, parent, false);

        // Obtenemos la posicion del producto
        Producto elementoProducto = productosList.get(position);

        // Asignamos las variable a los elementos del layout que hemos creado
        TextView nombreProducto = v.findViewById(R.id.nombreProducto);
        TextView precioProducto = v.findViewById(R.id.precioProducto);
        ImageView imgProducto = v.findViewById(R.id.imgProducto);

        // Obtenemos de la clase productos la informacion de los componentes del layout
        nombreProducto.setText(elementoProducto.getNombre());
        precioProducto.setText(elementoProducto.getPrecio());
        imgProducto.setImageResource(elementoProducto.getImg());

        return v;
    }
}
