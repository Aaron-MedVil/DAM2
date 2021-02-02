package com.example.a27_sqlite_usuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.a27_sqlite_usuarios.entidades.Cursos;

import java.util.ArrayList;

import static com.example.a27_sqlite_usuarios.utilidades.utilidades.CAMPO_DNI_USUARIO_CURSO;
import static com.example.a27_sqlite_usuarios.utilidades.utilidades.CAMPO_DURACION;
import static com.example.a27_sqlite_usuarios.utilidades.utilidades.CAMPO_ID_CURSO;
import static com.example.a27_sqlite_usuarios.utilidades.utilidades.CAMPO_NOMBRE_CURSO;
import static com.example.a27_sqlite_usuarios.utilidades.utilidades.TABLA_CURSOS;

public class ConsultarCurso extends AppCompatActivity {

    private ListView lv_mostrar_cursos;
    private ArrayList<String> arrListCursos;
    private DbConn conn;
    private ArrayList<Cursos> listaCursos;

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
            listaCursos = new ArrayList<Cursos>();

            // String sql = "SELECT " + CAMPO_ID_CURSO + ", " + CAMPO_NOMBRE_CURSO + ", " + CAMPO_DURACION + ", " + CAMPO_DNI_USUARIO_CURSO + " FROM " + TABLA_CURSOS;
            String sql = "SELECT id_curso, nombre_curso, duracion, dni_usuario, dni, nombre, telefono" +
                    " FROM curso " +
                    " JOIN usuarios on dni = dni_usuario";
            Cursor cursor = db.rawQuery(sql, null);

            if (cursor != null) {

                cursor.moveToFirst();

                do {
                    arrListCursos.add(cursor.getString(1));

                    datosCursos = new Cursos();
                    datosCursos.setId_curso(cursor.getInt(0));
                    datosCursos.setNombre_curso(cursor.getString(1));
                    datosCursos.setDuracion(cursor.getInt(2));
                    datosCursos.setDni_usuario(cursor.getString(3));
                    listaCursos.add(datosCursos);
                }
                while (cursor.moveToNext());
            }
            else { Toast.makeText(getApplicationContext(), "No existen registros en la base de datos", Toast.LENGTH_SHORT).show(); }
        }
        catch (Exception err) { Toast.makeText(getApplicationContext(), "Error al realizar la consulta a la base de datos", Toast.LENGTH_SHORT).show(); }
        finally { if (db.isOpen()) { db.close(); } }

        lv_mostrar_cursos.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_expandable_list_item_1, arrListCursos));
        lv_mostrar_cursos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Cursos c = new Cursos();
                c.setId_curso(listaCursos.get(position).getId_curso());
                c.setNombre_curso(listaCursos.get(position).getNombre_curso());
                c.setDuracion(listaCursos.get(position).getDuracion());
                c.setDni_usuario(listaCursos.get(position).getDni_usuario());

                Toast.makeText(getApplicationContext(), c.getNombre_curso(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}