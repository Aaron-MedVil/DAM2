package com.example.a12_fragmentos_dinamicos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    FragmentTransaction transaccion;
    Fragment initialFragment, redFragment, greenFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialFragment = new FragmentoInicial();
        redFragment = new FragmentoRojo();
        greenFragment = new FragmentoVerde();

        getSupportFragmentManager().beginTransaction().add(R.id.containerFragments, initialFragment).commit();
    }

    public void cambiarFragmento(View view) {

        transaccion = getSupportFragmentManager().beginTransaction();

        switch (view.getId()) {
            case R.id.btnRojo:
                transaccion.replace(R.id.containerFragments, redFragment).commit();
                transaccion.addToBackStack(null);
                break;
            case R.id.btnVerde:
                transaccion.replace(R.id.containerFragments, greenFragment).commit();
                transaccion.addToBackStack(null);
                break;
        }
    }
}