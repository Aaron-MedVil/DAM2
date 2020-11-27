package com.example.a17_crear_borrar_listview;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.app.Application;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private EditText textoAgregar;
    private ListView lista;
    private ArrayList<String> arrLista;
    private ArrayAdapter adapter;

    /**
     * Funcion que se ejecuta al crear la actividad
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        crearAgregarLista();
    }

    /**
     * Crea una lista y muestra el contenido en el layout
     */
    private void crearAgregarLista() {

        lista = findViewById(R.id.lista);

        // Creamos una lista y la ordenamos
        arrLista = new ArrayList<>();
        arrLista.addAll(Arrays.asList("Vesta", "Antonio", "Anacarda", "Frida", "Lionel", "Bayo", "Hipolita", "Harpo", "Azulino", "Lucho"));
        Collections.sort(arrLista);

        // Creamos el adaptador y lo añadimos al layout
        adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, arrLista);
        lista.setAdapter(adapter);

        // Añade un evento a los elementos de la lista
        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

            AlertDialog.Builder diag = new AlertDialog.Builder(MainActivity.this);
            diag.setCancelable(false);
            diag.setTitle(R.string.titleRemoveDialog);
            diag.setMessage(getResources().getString(R.string.msgRemoveDialog));
            diag.setNegativeButton(getResources().getString(R.string.aceptar), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            diag.setPositiveButton(getResources().getString(R.string.cancelar), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    arrLista.remove(position);
                    adapter.notifyDataSetChanged();
                }
            });
            diag.show();

            return false;
        }
    });
}

    /**
     * Funcion que se ejecuta al pulsar el boton agregar elemento
     * @param view
     */
    public void agregarElemento(View view) {

        textoAgregar = findViewById(R.id.textoAgregar);
        String textoAgregarText = textoAgregar.getText().toString();

        if (!textoAgregarText.matches("")) {

            arrLista.add(textoAgregarText);
            adapter.notifyDataSetChanged();
            textoAgregar.setText("");

            /*
            // Se crea el SnackBar
            Snackbar snc = Snackbar.make(view, textoAgregar.getText() + " Agregado", Snackbar.LENGTH_LONG);

            // Se le asigna una accion al SnackBar
            snc.setAction("Undo", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "Accion", Toast.LENGTH_SHORT).show();
                }
            });

            // Se muestra el SnackBar
            snc.show(); */
        } else { Toast.makeText(MainActivity.this, "Tiene que indicar un nombre", Toast.LENGTH_SHORT).show(); }
    }
}