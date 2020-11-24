package com.example.examen_ut1;

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

public class AdaptadorPeliculas extends ArrayAdapter<Peliculas> {

    private Context contexto;
    private int layout;
    private List<Peliculas> list;

    /**
     * Constructor de la clase del adaptador
     * @param context
     * @param resource
     * @param objects
     */
    public AdaptadorPeliculas(@NonNull Context context, int resource, @NonNull List<Peliculas> objects) {
        super(context, resource, objects);

        this.contexto = context;
        this.layout = resource;
        this.list = objects;
    }

    /**
     * Clase que genera la vista
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @NonNull @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Creamos la vista del adaptador
        View v = LayoutInflater.from(contexto).inflate(layout, parent, false);

        // Obtenemos los elementos del array que hemos creado en la MainActivity
        Peliculas elmento = list.get(position);

        // Obtenemos los elementos del layout
        TextView titulo = v.findViewById(R.id.titulo);
        ImageView img = v.findViewById(R.id.img);

        // Asignamos los campos del array a los elementos del layout
        titulo.setText(elmento.getNombre());
        img.setImageResource(elmento.getImg());

        // Devolvemos la vista
        return v;
    }
}
