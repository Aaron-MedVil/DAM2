package com.example.a09_listview_perso;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView lvVecinos;
    private List<Vecino> lVecinos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvVecinos = findViewById(R.id.lvVecinos);

        lVecinos = new ArrayList<>();
        lVecinos.add(new Vecino("Burgos", "Catedral de Burgos", R.drawable.catedral));
        lVecinos.add(new Vecino("Valladolid", "Iglesia de San Pablo", R.drawable.sanpablo));
        lVecinos.add(new Vecino("Ávila", "Murallas", R.drawable.murallas));
        lVecinos.add(new Vecino("Segovia", "Acueducto", R.drawable.acueducto));
        lVecinos.add(new Vecino("Salamanca", "Casa de las conchas", R.drawable.conchas));

        MiAdaptadorVecinos adaptadorVecinos = new MiAdaptadorVecinos(this, R.layout.vecinos_item, lVecinos);
        lvVecinos.setAdapter(adaptadorVecinos);

        lvVecinos.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Nombre: " + lVecinos.get(position).getNombre(), Toast.LENGTH_SHORT).show();
    }
}