package com.example.a23_comunicacion_fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragmento1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragmento1 extends Fragment {

    EditText etNombreF1; Button btnSendF1; TextView twNombreF2;

    /**
     * Constructor de la clase
     */
    public Fragmento1() {}

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment Fragmento1.
     */
    public static Fragmento1 newInstance() {
        Fragmento1 fragment = new Fragmento1();
        return fragment;
    }

    /**
     * Metodo para crear la clase
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); }

    /**
     * Metodo que se ejecuta cuando se crea la clase
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return vista de la clase
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Instanciamos la vista del xml y la guardamos en una variable
        View v = inflater.inflate(R.layout.fragment_fragmento1, container, false);

        etNombreF1 = v.findViewById(R.id.etNombreF1);
        btnSendF1 = v.findViewById(R.id.btnSendF1);

        // Evento click del boton enviar
        btnSendF1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Oculta el teclado al añadir un elemento
                InputMethodManager imm = (InputMethodManager) getContext().getSystemService(getActivity().INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

                // Cambia el valor del edit text del fragmento 2
                twNombreF2 = getActivity().findViewById(R.id.twNombreF2);
                twNombreF2.setText(etNombreF1.getText().toString());
            }
        });

        return v;
    }
}