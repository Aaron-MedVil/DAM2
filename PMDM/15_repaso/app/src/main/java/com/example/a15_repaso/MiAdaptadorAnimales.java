package com.example.a15_repaso;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Arrays;
import java.util.List;

public class MiAdaptadorAnimales extends ArrayAdapter<Animales> {

    private Context contexto;
    private int layoutAnimales;
    private List<Animales> animalesList;


    /**
     * Constructor
     * @param context
     * @param resource
     * @param objects
     */
    public MiAdaptadorAnimales(@NonNull Context context, int resource, @NonNull List<Animales> objects) {
        super(context, resource, objects);

        this.contexto = context;
        this.layoutAnimales = resource;
        this.animalesList = objects;
    }

    /**
     * Funcion para crear una vista personalizada
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @NonNull @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = LayoutInflater.from(contexto).inflate(layoutAnimales, parent, false);

        // Obtenemos la posicion del vecino
        Animales elmAnimal = animalesList.get(position);

        // Asignamos las variable a los elementos del layout que hemos creado
        TextView tvNombreAnimal = v.findViewById(R.id.nombreAnimal);
        TextView tvDescripcionAnimal = v.findViewById(R.id.descripcionAnimal);
        ImageView ivImagenAnimal = v.findViewById(R.id.imagenAnimal);

        // Obtenemos de la clase vecino la informacion de los componentes del layout
        tvNombreAnimal.setText(elmAnimal.getNombre());
        tvDescripcionAnimal.setText(elmAnimal.getDescripcion());
        ivImagenAnimal.setImageResource(elmAnimal.getImg());

        return v;
    }
}
