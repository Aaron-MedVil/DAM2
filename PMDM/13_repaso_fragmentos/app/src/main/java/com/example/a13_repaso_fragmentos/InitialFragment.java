package com.example.a13_repaso_fragmentos;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InitialFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InitialFragment extends Fragment implements AdapterView.OnItemClickListener {

    private static final String ARG_PARAM1 = "param1", ARG_PARAM2 = "param2";
    private String mParam1, mParam2;

    private ListView layoutInicial;
    private ArrayList<String> alComponentes;

    FragmentTransaction transaccion;
    Fragment fragmentElement1, fragmentElement2, fragmentElement3;

    public InitialFragment() {}

    public static InitialFragment newInstance(String param1, String param2) {
        InitialFragment fragment = new InitialFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Creo el contexto actual
        View root = inflater.inflate(R.layout.fragment_initial, container, false);

        // Declaracion del ListView y el ArrayList de componentes
        layoutInicial = root.findViewById(R.id.layoutInicial);
        alComponentes = new ArrayList<>();

        // Declaracion de los fragmentos
        fragmentElement1 = new FragmentElement1();
        fragmentElement2 = new FragmentElement2();
        fragmentElement3 = new FragmentElement3();

        // Creacion de los componentes del ListView
        alComponentes.addAll(Arrays.asList("Elemento1", "Elemento2", "Elemento3"));
        Collections.sort(alComponentes);

        // Asignacion de los componentes al adaptador y creacion del listener
        ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_expandable_list_item_1, alComponentes);
        layoutInicial.setAdapter(adapter);
        layoutInicial.setOnItemClickListener(this);

        return root;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        // Obtengo la transaccion del activity
        transaccion = getActivity().getSupportFragmentManager().beginTransaction();

        switch (alComponentes.get(position)) {
            case "Elemento1":
                transaccion.replace(R.id.compContainer, fragmentElement1).commit();
                transaccion.addToBackStack(null);
                break;
            case "Elemento2":
                transaccion.replace(R.id.compContainer, fragmentElement2).commit();
                transaccion.addToBackStack(null);
                break;
            case "Elemento3":
                transaccion.replace(R.id.compContainer, fragmentElement3).commit();
                transaccion.addToBackStack(null);
                break;
        }
    }
}