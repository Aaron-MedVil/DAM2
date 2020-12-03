package com.example.a17_crear_borrar_listview_variante;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.DialogInterface;
import android.inputmethodservice.Keyboard;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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
    private ArrayList<String> arrayListDup = new ArrayList<>();
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

                // Se duplica el array de elementos
                arrayListDup.clear();
                arrayListDup.addAll(arrLista);

                String selItem = arrLista.get(position);

                // Se crea el dialogo para eliminar el elemento
                AlertDialog.Builder diag = new AlertDialog.Builder(MainActivity.this);
                diag.setCancelable(false);
                diag.setTitle(R.string.titleRemoveDialog);
                diag.setMessage(getResources().getString(R.string.msgRemoveDialog));
                diag.setNegativeButton(getResources().getString(R.string.cancelar), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                diag.setPositiveButton(getResources().getString(R.string.aceptar), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        arrLista.remove(position);
                        adapter.notifyDataSetChanged();

                        // Se crea un snackbar para deshacer el eliminado
                        Snackbar snc = Snackbar.make(view, "Se ha eliminado " + selItem, Snackbar.LENGTH_LONG);
                        snc.setAction("Deshacer", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                arrLista.clear();
                                arrLista.addAll(arrayListDup);
                                adapter.notifyDataSetChanged();
                            }
                        });
                        snc.show();
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
    public void agregarElemento(View view)  {

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        LayoutInflater layout = getLayoutInflater();
        dialog.setView(layout.inflate(R.layout.dialog_layout, null));
        dialog.setPositiveButton(getResources().getString(R.string.aceptar), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Dialog d = (Dialog)dialog;
                EditText textoAgregar = (EditText)d.findViewById(R.id.textoAgregar);

                String textoAgregarText = textoAgregar.getText().toString();

                if (!textoAgregarText.matches("")) {

                    // Se duplica el array de elementos
                    arrayListDup.clear();
                    arrayListDup.addAll(arrLista);

                    String selItem = textoAgregar.getText().toString();

                    // Se añade el elemento a la lista, se recarga la vista y se borra el texto del textbox
                    arrLista.add(textoAgregarText);
                    adapter.notifyDataSetChanged();
                    textoAgregar.setText("");

                    // Se crea el SnackBar
                    Snackbar snc = Snackbar.make(view, "Se ha creado " + selItem, Snackbar.LENGTH_LONG);
                    snc.setAction("Deshacer", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            arrLista.clear();
                            arrLista.addAll(arrayListDup);
                            adapter.notifyDataSetChanged();
                        }
                    });
                    snc.show();
                }
                else { Toast.makeText(MainActivity.this, "Tiene que indicar un nombre", Toast.LENGTH_SHORT).show(); }
            }
        });
        dialog.setNegativeButton(getResources().getString(R.string.cancelar), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        dialog.show();
    }
}