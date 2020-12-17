package com.example.a24_recycler_view_fragments_com;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecyclerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecyclerFragment extends Fragment {

    ArrayList<Producto> listProducto;
    RecyclerView rv;

    public RecyclerFragment() {}

    /**
     * Use this factory method to create a new instance of this fragment using the provided parameters.
     * @return A new instance of fragment RecyclerFragment.
     */
    public static RecyclerFragment newInstance() {
        return new RecyclerFragment();
    }

    /**
     * Metodo que se ejecuta al crear el fragmento
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * Metodo que se ejecuta cuando se crea la vista del fragmento
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_recycler, container, false);

        listProducto = new ArrayList<Producto>();
        rv = v.findViewById(R.id.idContFragmentRecycler);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));

        llenarLista();

        return v;
    }

    /**
     * Añade elementos a la lista que mostraremos
     */
    private void llenarLista() {

        listProducto.add(new Producto("Catedral", "Catedral bonita", R.drawable.catedral));
        listProducto.add(new Producto("Acueducto", "Es alto", R.drawable.acueducto));
        listProducto.add(new Producto("Casa de las conchas", "Casa con conchas", R.drawable.conchas));
        listProducto.add(new Producto("Muralla", "Muralla grande", R.drawable.murallas));
        listProducto.add(new Producto("San Pablo", "Un santo", R.drawable.sanpablo));
    }
}