package com.example.a08_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView lvPersonas;
    private ArrayList<String> alPersonas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Asignamos el listView del xml y creamos el arrayList
        lvPersonas = findViewById(R.id.lvPersonas);
        alPersonas = new ArrayList<>();

        // Llenamos el arraylist con los elementos que queramos visualizar y lo ordenamos(Esto ultimo es opcional)
        alPersonas.addAll(Arrays.asList("Vesta", "Antonio", "Anacarda", "Frida", "Lionel", "Bayo", "Hipolita", "Harpo", "Azulino", "Lucho"));
        Collections.sort(alPersonas);

        // Conectamos el adaptador del array a la listView y le asignamos un evento Click
        lvPersonas.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, alPersonas));
        lvPersonas.setOnItemClickListener(this);
    }

    // Evento click del ListView
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, alPersonas.get(position), Toast.LENGTH_SHORT).show();
    }
}