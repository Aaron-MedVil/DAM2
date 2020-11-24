package com.example.examen_ut1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FragmentTransaction trans;
    private Fragment f1, f2, fd;
    private FrameLayout fragmentContainer;
    private ListView listaPeliculas;
    private List<Peliculas> peliculasArr;

    /**
     * Funcion que se ejecuta al crear la actividad
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Cargamos los fragmentos
        fd = new DefaultFragment();
        f1 = new Fragmento1();
        f2 = new Fragmento2();

        // Creamos un progressDialog que se mostrará cuando arranque la aplicación
        final ProgressDialog progreso = new ProgressDialog(this);

        // Asignamos un titulo al dialogo
        progreso.setTitle(R.string.titleLoadDialog);

        // Asignamos un mensaje al dialogo
        progreso.setMessage(getResources().getString(R.string.msgLoadDialog));

        // Le damos la propiedad para que no se pueda cerrar al pulsar la pantalla
        progreso.setCancelable(false);

        // Mostramos el dialogo
        progreso.show();

        // Creamos un temporizador que cerrara el progressDialog y mostrara los datos de la aplicacion pasado un tiempo
        Handler pdCargar = new Handler();
        pdCargar.postDelayed(new Runnable() {
            @Override
            public void run() {
                setContentView(R.layout.activity_main);

                // Asignamos un fragmento inicial
                getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, fd).commit();

                // Llamamos a la funcion que cargara el layout
                cargarLayout();

                // Cerramos el ProgressDialog
                progreso.cancel();
            }
        }, 2000);
    }

    /**
     * Funcion que carga el dialog con los precios del cine
     * @param view
     */
    public void cargarPrecios(View view) {

        // Recojo los precios de un string-array y los guardo en un array que he creado, lo recorro y voy asignando los valores a una cadena
        String[] precios = getResources().getStringArray(R.array.listPrecios);
        String msgPrecios = "";
        for (int i = 0; i < precios.length; i++) { msgPrecios += "\n" + precios[i]; }

        // Creamos un dialog
        AlertDialog.Builder dPrecios = new AlertDialog.Builder(this);

        // Asignamos el titulo al dialog
        dPrecios.setTitle(R.string.titleDialogPrecios);

        // Asignamos el mensaje al dialogo
        dPrecios.setMessage(msgPrecios);

        // Le damos la propiedad de que si se pulsa fuera del dialogo no se cierre
        dPrecios.setCancelable(false);

        // Le asignamos un boton al dialogo para cerrarlo
        dPrecios.setNeutralButton(getResources().getString(R.string.btnCloseDialog), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) { dialog.cancel(); }
        });

        // Mostramos el dialogo
        dPrecios.show();
    }

    /**
     * Cambia el fragmento que se visualiza
     * @param view
     */
    public void cambiarFragmento(View view) {

        Boolean checked = ((RadioButton)view).isChecked();
        trans = getSupportFragmentManager().beginTransaction();

        // Comprobamos que RadioButton se ha checkeado y cargamos el fragmento correspondiente
        switch (view.getId()) {
            case R.id.rbF1:
                // Reemplazamos el fragmento inicial con el fragmento seleccionado
                trans.replace(R.id.fragmentContainer, f1).commit();
                break;
            case R.id.rbF2:
                // Reemplazamos el fragmento inicial con el fragmento seleccionado
                trans.replace(R.id.fragmentContainer, f2).commit();
                break;
        }
    }

    /**
     * Carga el layout con las peliculas
     */
    private void cargarLayout() {

        // Obtenemos el elemento del layout en el que vamos a insertar nuestra lista
        listaPeliculas = findViewById(R.id.listaPeliculas);

        // Creamos y rellenamos un array con los elementos de la lista
        peliculasArr = new ArrayList<>();
        peliculasArr.add(new Peliculas(R.drawable.eduardo_manostijeras, getResources().getString(R.string.eduardo_manostijeras), getResources().getString(R.string.sala3)));
        peliculasArr.add(new Peliculas(R.drawable.golpe_pequena_china, getResources().getString(R.string.golpe_pequena_china), getResources().getString(R.string.sala1)));
        peliculasArr.add(new Peliculas(R.drawable.gru, getResources().getString(R.string.gru),getResources().getString(R.string.sala2)));
        peliculasArr.add(new Peliculas(R.drawable.spiderman, getResources().getString(R.string.spiderman), getResources().getString(R.string.sala5)));
        peliculasArr.add(new Peliculas(R.drawable.lo_que_el_viento_se_llevo, getResources().getString(R.string.lo_que_el_viento_se_llevo), getResources().getString(R.string.sala4)));

        // Creamos el adaptador y le asignamos los elementos de la lista
        AdaptadorPeliculas ap = new AdaptadorPeliculas(this, R.layout.layout_peliculas, peliculasArr);

        // Asignamos el adaptador al elemento del laout
        listaPeliculas.setAdapter(ap);

        // Asignamos un evento cuando pulsamos en un elemento de la lista
        listaPeliculas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, peliculasArr.get(position).getNombre() + " - " + peliculasArr.get(position).getSala(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}