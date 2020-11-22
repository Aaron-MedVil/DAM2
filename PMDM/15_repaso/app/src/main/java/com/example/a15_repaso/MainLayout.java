package com.example.a15_repaso;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainLayout extends Fragment {

    private ListView lvAnimales;
    private List<Animales> animalesArr;

    /**
     * Costructor de la clase
     */
    public MainLayout() {}

    public static MainLayout newInstance() {
        MainLayout fragment = new MainLayout();
        return fragment;
    }

    /**
     * Crea el layout
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * Crea la vista del layout
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_main_layout, container, false);

        lvAnimales = root.findViewById(R.id.lvAnimales);
        animalesArr = new ArrayList<>();
        animalesArr.add(new Animales("Vaca", "Animal que da leche", R.drawable.cow));
        animalesArr.add(new Animales("Gato", "Animal que te mira con desprecio", R.drawable.cat));
        animalesArr.add(new Animales("Perro", "Algunos estan gordos", R.drawable.dog));
        animalesArr.add(new Animales("Elefante", "Animal que no olvida", R.drawable.elephant));

        MiAdaptadorAnimales adaptadorAnimales = new MiAdaptadorAnimales(getContext(), R.layout.animales_layout, animalesArr);
        lvAnimales.setAdapter(adaptadorAnimales);

        lvAnimales.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), "Nombre: " + animalesArr.get(position).getNombre(), Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }
}