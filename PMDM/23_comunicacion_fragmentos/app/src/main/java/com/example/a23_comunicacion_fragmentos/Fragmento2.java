package com.example.a23_comunicacion_fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragmento2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragmento2 extends Fragment {

    public Fragmento2() {}

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment Fragmento2.
     */
    public static Fragmento2 newInstance() {
        Fragmento2 fragment = new Fragmento2();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fragmento2, container, false);
    }
}