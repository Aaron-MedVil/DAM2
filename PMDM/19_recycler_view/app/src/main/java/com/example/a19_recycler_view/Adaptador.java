package com.example.a19_recycler_view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolderDatos> {

    ArrayList<String> listDatos;

    public Adaptador(ArrayList<String> listDatos) { this.listDatos = listDatos; }

    @NonNull @Override
    public Adaptador.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout, null, false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptador.ViewHolderDatos holder, int position) {

        // Comunicacion entre el adaptador y nuestro ViewContentDatos
        holder.asignarDatos(listDatos.get(position));
    }

    @Override
    public int getItemCount() { return listDatos.size(); }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView item;

        public ViewHolderDatos(@NonNull View itemView) {

            super(itemView);
            item = itemView.findViewById(R.id.elementosLista);
        }

        public void asignarDatos(String s) { item.setText(s); }
    }
}