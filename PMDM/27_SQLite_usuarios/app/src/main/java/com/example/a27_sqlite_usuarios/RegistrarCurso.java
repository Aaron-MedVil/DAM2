package com.example.a27_sqlite_usuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.a27_sqlite_usuarios.entidades.Usuarios;

import java.util.ArrayList;

import static com.example.a27_sqlite_usuarios.utilidades.utilidades.CAMPO_DNI;
import static com.example.a27_sqlite_usuarios.utilidades.utilidades.CAMPO_DNI_USUARIO_CURSO;
import static com.example.a27_sqlite_usuarios.utilidades.utilidades.CAMPO_DURACION;
import static com.example.a27_sqlite_usuarios.utilidades.utilidades.CAMPO_ID_CURSO;
import static com.example.a27_sqlite_usuarios.utilidades.utilidades.CAMPO_NOMBRE;
import static com.example.a27_sqlite_usuarios.utilidades.utilidades.CAMPO_NOMBRE_CURSO;
import static com.example.a27_sqlite_usuarios.utilidades.utilidades.CAMPO_TELEFONO;
import static com.example.a27_sqlite_usuarios.utilidades.utilidades.TABLA_CURSOS;
import static com.example.a27_sqlite_usuarios.utilidades.utilidades.TABLA_USUARIOS;

public class RegistrarCurso extends AppCompatActivity {

    private EditText et_nombre_curso_registrar_curso, et_duracion_registrar_curso;
    private Spinner spn_usuario_registrar_curso;
    private InputMethodManager imm;
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
        setContentView(R.layout.activity_registrar_curso);

        imm = (InputMethodManager)this.getSystemService(Activity.INPUT_METHOD_SERVICE);

        et_nombre_curso_registrar_curso = findViewById(R.id.et_nombre_curso_registrar_curso);
        et_duracion_registrar_curso = findViewById(R.id.et_duracion_registrar_curso);
        spn_usuario_registrar_curso = findViewById(R.id.spn_usuario_registrar_curso);

        conn = new DbConn(getApplicationContext(), "bdUsuarios", null, 1);

        fillSpinner();
    }

    /**
     * Metodo que rellena los datos del spinner
     */
    private void fillSpinner() {

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
                spn_usuario_registrar_curso.setAdapter(adapter);
            }
            else { Toast.makeText(getApplicationContext(), "No existen datos de usuarios", Toast.LENGTH_SHORT).show(); }
        }
        catch (Exception err) { Toast.makeText(getApplicationContext(), "Error al cargar los datos de los usuarios", Toast.LENGTH_SHORT).show(); }
        finally { if (db.isOpen()) { db.close(); } }
    }

    /**
     * Guarda los datos del curso en la base de datos
     * @param view
     */
    public void clickRegistrarCurso(View view) {

        // Obtiene los datos del spinner
        String spnData = spn_usuario_registrar_curso.getSelectedItem().toString();
        String[] arrUser = spnData.split(" - ");
        String dniUser = arrUser[0].trim();

        if (!isEmptyEt(et_nombre_curso_registrar_curso)) {

            if (!isEmptyEt(et_duracion_registrar_curso)) {

                if (!dniUser.isEmpty()) {

                    DbConn conn = new DbConn(this, "bdUsuarios", null, 1);
                    SQLiteDatabase db = conn.getWritableDatabase();

                    ContentValues values = new ContentValues();
                    values.put(CAMPO_NOMBRE_CURSO, et_nombre_curso_registrar_curso.getText().toString());
                    values.put(CAMPO_DURACION, et_duracion_registrar_curso.getText().toString());
                    values.put(CAMPO_DNI_USUARIO_CURSO, dniUser);

                    long result = db.insert(TABLA_CURSOS, null, values);

                    if (result > 0) { Toast.makeText(getApplicationContext(), "Curso registrado " + result, Toast.LENGTH_SHORT).show(); }
                    else { Toast.makeText(getApplicationContext(), "Error al registrar el curso " + result, Toast.LENGTH_SHORT).show(); }

                    limpiarFormulario();
                    if (db.isOpen()) { db.close(); }

                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
                else { Toast.makeText(getApplicationContext(), "Tiene que seleccionar un usuario", Toast.LENGTH_SHORT).show(); }
            }
            else { Toast.makeText(getApplicationContext(), "El campo duración está vacío", Toast.LENGTH_SHORT).show(); }
        }
        else { Toast.makeText(getApplicationContext(), "El campo nombre está vacío", Toast.LENGTH_SHORT).show(); }
    }

    /**
     * Limpia los datos del formulario
     */
    private void limpiarFormulario() {

        et_nombre_curso_registrar_curso.setText("");
        et_duracion_registrar_curso.setText("");
    }

    /**
     * Comprueba si un EditText esta vacio o no
     * @param etText
     * @return
     */
    private boolean isEmptyEt(EditText etText) {

        if (etText.getText().toString().trim().length() > 0)
            return false;

        return true;
    }
}