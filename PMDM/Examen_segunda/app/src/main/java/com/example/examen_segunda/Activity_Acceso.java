package com.example.examen_segunda;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.examen_segunda.utilidades.Utilidades;

public class Activity_Acceso extends AppCompatActivity {

    private EditText nombre_nuevo_empleado, email_nuevo_empleado;
    private Spinner departamento_nuevo_empleado;
    private Db_Conn conn;
    private InputMethodManager imm;

    /**
     * Metodo que se ejecuta cuando se crea la actividad
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__acceso);

        imm = (InputMethodManager)this.getSystemService(Activity.INPUT_METHOD_SERVICE);

        nombre_nuevo_empleado = findViewById(R.id.nombre_nuevo_empleado);
        email_nuevo_empleado = findViewById(R.id.email_nuevo_empleado);
        departamento_nuevo_empleado = findViewById(R.id.departamento_nuevo_empleado);

        // Creamos la conexion con la base de datos
        conn = new Db_Conn(getApplicationContext(), Utilidades.NOMBRE_DATABASE, null, 1);

        // Rellenamos los datos del spinner
        fillSpinner();
    }

    /**
     * Rellena el spinner con los departamentos
     */
    private void fillSpinner() {

        String[] departamentos = {"Ventas", "Compras", "Informática"};

        // Asignamos el array creado a un adaptador
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, departamentos);

        // Insertamos el adaptador en el spinner
        departamento_nuevo_empleado.setAdapter(adapter);
    }

    /**
     * Metodo que inserta un empleado en la base de datos
     * @param view
     */
    public void btn_insertar_registro(View view) {

        if (!isEmptyEt(nombre_nuevo_empleado)) {

            if (!isEmptyEt(email_nuevo_empleado)) {

                // Obtenemos los valores del formulario
                String nombre = nombre_nuevo_empleado.getText().toString();
                String email = email_nuevo_empleado.getText().toString();
                String departamento = departamento_nuevo_empleado.getSelectedItem().toString();

                // Abrimos conexion con la base de datos
                SQLiteDatabase db = conn.getWritableDatabase();

                // Definimos los valores que insertaremos en la base de datos
                ContentValues values = new ContentValues();
                values.put(Utilidades.CAMPO_NOMBRE_TABLA_EMPLEADO, nombre);
                values.put(Utilidades.CAMPO_EMAIL_TABLA_EMPLEADO, email);
                values.put(Utilidades.CAMPO_DEPARTAMENTO_TABLA_EMPLEADO, departamento);

                // Hacemos la inserccion y obtenemos el return para ver si se ha realizado correctamente o no
                long result = db.insert(Utilidades.NOMBRE_TABLA_EMPLEADO, null, values);

                // Mostramos el resultado de la consulta
                if (result > 0) { Toast.makeText(getApplicationContext(), "Empleado registrado", Toast.LENGTH_SHORT).show(); }
                else { Toast.makeText(getApplicationContext(), "Error al registrar el empleado", Toast.LENGTH_SHORT).show(); }

                // Limpiamos el formulario
                limpiarFormulario();

                // Cerramos la base de datos si esta abierta
                if (db.isOpen()) { db.close(); }

                // Ocultamos el teclado
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
            else { Toast.makeText(this, "El campo email no puede estar vacio", Toast.LENGTH_SHORT).show(); }
        }
        else { Toast.makeText(this, "El campo nombre no puede estar vacio", Toast.LENGTH_SHORT).show(); }
    }

    /**
     * Abre la actividad que muestra los datos de los empleados
     * @param view
     */
    public void btn_consultar_registros(View view) {
        Intent intent = new Intent(this, Activity_Consulta.class);
        startActivity(intent);
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

    /**
     * Limpia los datos del formulario
     */
    private void limpiarFormulario() {

        nombre_nuevo_empleado.setText("");
        email_nuevo_empleado.setText("");
    }
}

