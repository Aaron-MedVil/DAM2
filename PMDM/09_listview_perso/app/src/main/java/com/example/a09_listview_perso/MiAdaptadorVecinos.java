package com.example.a09_listview_perso;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MiAdaptadorVecinos extends ArrayAdapter<Vecino> {

    Context contexto;
    int layoutVecino;
    List<Vecino> vecinosList;

    // Constructor de la clase
    public MiAdaptadorVecinos(@NonNull Context context, int resource, @NonNull List<Vecino> objects) {
        super(context, resource, objects);

        this.contexto = context;
        this.layoutVecino = resource;
        this.vecinosList = objects;
    }

    // Funcion para crear una vista personalizada
    @NonNull @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = LayoutInflater.from(contexto).inflate(layoutVecino, parent, false);
        return v;
    }
}