package com.example.a27_sqlite_usuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.a27_sqlite_usuarios.entidades.Usuarios;

import java.util.ArrayList;

import static com.example.a27_sqlite_usuarios.utilidades.utilidades.TABLA_USUARIOS;

public class ListarUsuario extends AppCompatActivity {

    private Spinner spn_listar_usuarios;
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

            Cursor cursor = db.rawQuery("SELECT * FROM "+ TABLA_USUARIOS, null);

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

                ListaSpinner = new ArrayList<String>();
                for (int i=0; i<ListaUsuarios.size(); i++){
                    ListaSpinner.add(ListaUsuarios.get(i).getDni() + " " + ListaUsuarios.get(i).getNombre() + " " + ListaUsuarios.get(i).getTelefono());
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, ListaSpinner);
                spn_listar_usuarios.setAdapter(adapter);
            }
            else { Toast.makeText(getApplicationContext(), "No existen datos de usuarios", Toast.LENGTH_SHORT).show(); }
        }
        catch (Exception err) { Toast.makeText(getApplicationContext(), "Error al cargar los datos de los usuarios", Toast.LENGTH_SHORT).show(); }
        finally { if (db.isOpen()) { db.close(); } }
    }
}