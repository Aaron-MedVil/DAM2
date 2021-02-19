package com.example.examen_segunda;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.examen_segunda.utilidades.Utilidades;

import java.util.ArrayList;

public class Activity_Consulta extends AppCompatActivity {

    private ListView lista_datos_database;
    private Db_Conn conn;

    /**
     * Metodo que se ejecuta cuando se inicia la activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__consulta);

        lista_datos_database = findViewById(R.id.lista_datos_database);

        // Creamos la conexion a la base de datos
        conn = new Db_Conn(getApplicationContext(), Utilidades.NOMBRE_DATABASE, null, 1);
    }

    /**
     * Muestra los datos de los empleados dependiendo del departamento seleccionado
     * @param view
     */
    public void rb_mostrar_datos(View view) {

        Boolean checked = ((RadioButton) view).isChecked();
        String dpt = "";

        // Comprueba que departamento se ha seleccionado
        switch (view.getId()) {
            case R.id.rb_compras:
                if (checked) { dpt = "Compras"; }
                break;
            case R.id.rb_ventas:
                if (checked) { dpt = "Ventas"; }
                break;
            case R.id.rb_informatica:
                if (checked) { dpt = "Informática"; }
                break;
        }

        // Creamos la conexion de lectura a la base de datos
        SQLiteDatabase db = conn.getReadableDatabase();

        // Indicamos los campos que vamos a devolver
        String[] campos = new String[] {Utilidades.CAMPO_NOMBRE_TABLA_EMPLEADO, Utilidades.CAMPO_EMAIL_TABLA_EMPLEADO};

        // Indicamos los parametros que vamos a enviar para hacer el filtro por departamento
        String[] params = new String[] {dpt};

        // Creamos el filtro
        String selection = Utilidades.CAMPO_DEPARTAMENTO_TABLA_EMPLEADO + " = ?";

        try {

            // Creamos la consulta en la base de datos
            Cursor cursor = db.query(Utilidades.NOMBRE_TABLA_EMPLEADO, campos, selection, params, null, null, null);

            // Comprobamos que existen registros
            if (cursor != null) {

                // LLevamos el cursor al inicio
                cursor.moveToFirst();

                ArrayList<String> arr_empleados = new ArrayList<>();

                do {

                    // Rellenamos el ArrayList con los datos que mostraremos en el ListView
                    arr_empleados.add(cursor.getString(0) + " - " + cursor.getString(1));

                    // Conectamos el adaptador del array a la listView
                    lista_datos_database.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, arr_empleados));
                }
                while (cursor.moveToNext());
            }
            else { Toast.makeText(getApplicationContext(), "No existen datos de empleados en ese departamento", Toast.LENGTH_SHORT).show(); }
        }
        catch (Exception err) { Toast.makeText(getApplicationContext(), "No existen datos de empleados en ese departamento", Toast.LENGTH_SHORT).show(); }
        finally { if (db.isOpen()) { db.close(); } }
    }
}