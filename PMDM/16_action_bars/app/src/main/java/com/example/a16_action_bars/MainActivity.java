package com.example.a16_action_bars;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    Toolbar tb;

    /**
     * Funcion que se ejecuta al crearse la activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tb = findViewById(R.id.toolbarCustom);

        setSupportActionBar(tb);
    }

    /**
     * Funcion para implementar el menu
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inf = getMenuInflater();
        inf.inflate(R.menu.menu, menu);
        return true;
    }

    /**
     * Funcion que se ejecuta al seleccionar una opcion del menu
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case R.id.opcion1:
                Toast.makeText(this, "Opción 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.opcion2:
                Toast.makeText(this, "Opción 2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.opcion3:
                Toast.makeText(this, "Opcion 3", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buscar:
                Toast.makeText(this, "Buscar", Toast.LENGTH_SHORT).show();
                break;
        }

        return true;
    }
}