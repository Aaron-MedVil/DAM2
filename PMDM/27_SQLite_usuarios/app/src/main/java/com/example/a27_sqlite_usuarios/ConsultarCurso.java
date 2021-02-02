package com.example.a27_sqlite_usuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.a27_sqlite_usuarios.entidades.Cursos;
import com.example.a27_sqlite_usuarios.entidades.Usuarios;

import java.io.Serializable;
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

public class ConsultarCurso extends AppCompatActivity {

    private ListView lv_mostrar_cursos;
    private DbConn conn;
    private ArrayList<String> arrListCursos;
    private ArrayList<Cursos> listaCursos;
    private ArrayList<Usuarios> listaUsuarios;

    /**
     * Metodo que se ejecuta al crear la clase
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_curso);

        conn = new DbConn(getApplicationContext(), "bdUsuarios", null, 1);
        lv_mostrar_cursos = findViewById(R.id.lv_mostrar_cursos);
        arrListCursos = new ArrayList<>();

        fillListViewData();
    }

    /**
     * Carga los datos de los cursos en la ListView
     */
    private void fillListViewData() {

        SQLiteDatabase db = conn.getReadableDatabase();

        try {

            Cursos datosCursos = null;
            Usuarios datosUsuarios = null;
            listaCursos = new ArrayList<Cursos>();
            listaUsuarios = new ArrayList<Usuarios>();

            String sql = "SELECT " + CAMPO_ID_CURSO + ", " + CAMPO_NOMBRE_CURSO + ", " + CAMPO_DURACION + ", " + CAMPO_DNI_USUARIO_CURSO +
                    ", " + CAMPO_DNI + ", " + CAMPO_NOMBRE + ", " + CAMPO_TELEFONO +
                    " FROM " + TABLA_CURSOS +
                    " JOIN " + TABLA_USUARIOS + " on " + CAMPO_DNI + " = " + CAMPO_DNI_USUARIO_CURSO;
            Cursor cursor = db.rawQuery(sql, null);

            if (cursor != null) {

                cursor.moveToFirst();

                do {

                    // Rellena el ArrayList que se mostrara en el ListView
                    arrListCursos.add(cursor.getString(1));

                    // Rellena los datos del ArrayList de los cursos
                    datosCursos = new Cursos();
                    datosCursos.setId_curso(cursor.getInt(0));
                    datosCursos.setNombre_curso(cursor.getString(1));
                    datosCursos.setDuracion(cursor.getInt(2));
                    datosCursos.setDni_usuario(cursor.getString(3));
                    listaCursos.add(datosCursos);

                    // Rellena los datos del ArrayList de los usuarios
                    datosUsuarios = new Usuarios();
                    datosUsuarios.setDni(cursor.getString(4));
                    datosUsuarios.setNombre(cursor.getString(5));
                    datosUsuarios.setTelefono(cursor.getString(6));
                    listaUsuarios.add(datosUsuarios);
                }
                while (cursor.moveToNext());
            }
            else { Toast.makeText(getApplicationContext(), "No existen registros en la base de datos", Toast.LENGTH_SHORT).show(); }
        }
        catch (Exception err) { Toast.makeText(getApplicationContext(), "Error al realizar la consulta a la base de datos", Toast.LENGTH_SHORT).show(); }
        finally { if (db.isOpen()) { db.close(); } }

        // Rellenamos los datos del ListView con el ArrayList
        lv_mostrar_cursos.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_expandable_list_item_1, arrListCursos));
        lv_mostrar_cursos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Recogemos los datos del curso seleccionado
                Cursos c = new Cursos();
                c.setId_curso(listaCursos.get(position).getId_curso());
                c.setNombre_curso(listaCursos.get(position).getNombre_curso());
                c.setDuracion(listaCursos.get(position).getDuracion());
                c.setDni_usuario(listaCursos.get(position).getDni_usuario());

                // Recogemos los datos del usuario seleccionado
                Usuarios u = new Usuarios();
                u.setDni(listaUsuarios.get(position).getDni());
                u.setNombre(listaUsuarios.get(position).getNombre());
                u.setTelefono(listaUsuarios.get(position).getTelefono());

                // Creamos una intencion
                /*Intent intent = new Intent(getApplicationContext(), DetalleConsultaCurso.class);

                // Asignamos a la intencion los datos del elemento que hemos seleccionado
                intent.putExtra("curso", (Serializable)c);
                intent.putExtra("usuario", (Serializable)u);

                // Crea una nueva tarea
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                // Iniciamos la actividad
                getApplicationContext().startActivity(intent);*/

                Intent intent = new Intent(getApplicationContext(), DetalleConsultaCurso.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("curso", (Serializable)c);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}