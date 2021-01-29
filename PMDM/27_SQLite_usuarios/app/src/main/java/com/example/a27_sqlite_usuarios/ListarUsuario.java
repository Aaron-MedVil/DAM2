package com.example.a27_sqlite_usuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.a27_sqlite_usuarios.entidades.Usuarios;

import java.util.ArrayList;

import static com.example.a27_sqlite_usuarios.utilidades.utilidades.CAMPO_DNI;
import static com.example.a27_sqlite_usuarios.utilidades.utilidades.CAMPO_NOMBRE;
import static com.example.a27_sqlite_usuarios.utilidades.utilidades.CAMPO_TELEFONO;
import static com.example.a27_sqlite_usuarios.utilidades.utilidades.TABLA_USUARIOS;

public class ListarUsuario extends AppCompatActivity {

    private Spinner spn_listar_usuarios;
    private EditText et_dni_listar_usuario, et_nombre_listar_usuario, et_telefono_listar_usuario;
    private DbConn conn;
    private ArrayList<Usuarios> ListaUsuarios;
    private ArrayList<String> ListaSpinner;

    /**
     * Metodo que se ejecuta cuando se crea la clase
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_usuario);

        conn = new DbConn(getApplicationContext(), "bdUsuarios", null, 1);
        spn_listar_usuarios = findViewById(R.id.spn_listar_usuarios);
        et_dni_listar_usuario = findViewById(R.id.et_dni_listar_usuario);
        et_nombre_listar_usuario = findViewById(R.id.et_nombre_listar_usuario);
        et_telefono_listar_usuario = findViewById(R.id.et_telefono_listar_usuario);

        cargarDatosSpinner();
    }

    /**
     * Carga los datos del spinner
     */
    private void cargarDatosSpinner() {

        SQLiteDatabase db = conn.getReadableDatabase();

        Usuarios datosUsuario = null;
        ListaUsuarios = new ArrayList<Usuarios>();

        try {

            String sql = "SELECT " + CAMPO_DNI + ", " + CAMPO_NOMBRE + ", " + CAMPO_TELEFONO + " FROM "+ TABLA_USUARIOS;
            Cursor cursor = db.rawQuery(sql, null);

            if (cursor != null) {

                cursor.moveToFirst();

                do {

                    datosUsuario = new Usuarios();
                    datosUsuario.setDni(cursor.getString(0));
                    datosUsuario.setNombre(cursor.getString(1));
                    datosUsuario.setTelefono(cursor.getString(2));
                    ListaUsuarios.add(datosUsuario);
                }
                while (cursor.moveToNext());

                // Rellena la lista del spinner con los datos obtenidos de la base de datos
                ListaSpinner = new ArrayList<String>();
                for (int i=0; i<ListaUsuarios.size(); i++) { ListaSpinner.add(ListaUsuarios.get(i).getDni() + " - " + ListaUsuarios.get(i).getNombre()); }

                // Rellena el spinner con la lista
                ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, ListaSpinner);
                spn_listar_usuarios.setAdapter(adapter);
            }
            else { Toast.makeText(getApplicationContext(), "No existen datos de usuarios", Toast.LENGTH_SHORT).show(); }

            // Metodo onClick para los elementos del spinner
            spn_listar_usuarios.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    Toast.makeText(getApplicationContext(),"Ha seleccionado elemento "+ position, Toast.LENGTH_SHORT).show();
                    et_dni_listar_usuario.setText(ListaUsuarios.get(position).getDni());
                    et_nombre_listar_usuario.setText(ListaUsuarios.get(position).getNombre());
                    et_telefono_listar_usuario.setText(ListaUsuarios.get(position).getTelefono());
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {}
            });
        }
        catch (Exception err) { Toast.makeText(getApplicationContext(), "Error al cargar los datos de los usuarios", Toast.LENGTH_SHORT).show(); }
        finally { if (db.isOpen()) { db.close(); } }
    }
}