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
import android.widget.EditText;
import android.widget.Toast;

import static com.example.a27_sqlite_usuarios.utilidades.utilidades.*;

public class ConsultarUsuario extends AppCompatActivity {

    private EditText dni_consultar_usuario, nombre_consultar_usuario, telefono_consultar_usuario;
    private DbConn conn;
    private InputMethodManager imm;

    /**
     * Metodo que se ejecuta cuando se crea la clase
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_usuario);

        imm = (InputMethodManager)this.getSystemService(Activity.INPUT_METHOD_SERVICE);

        dni_consultar_usuario = findViewById(R.id.dni_consultar_usuario);
        nombre_consultar_usuario = findViewById(R.id.nombre_consultar_usuario);
        telefono_consultar_usuario = findViewById(R.id.telefono_consultar_usuario);

        conn = new DbConn(getApplicationContext(), "bdUsuarios", null, 1);
    }

    /**
     * Busca los datos de un usuario
     * @param view
     */
    public void click_btn_buscar_consultar_usuario(View view) {

        if (!isEmptyEt(dni_consultar_usuario)) {

            SQLiteDatabase db = conn.getReadableDatabase();
            String[] campos = new String[] {CAMPO_DNI, CAMPO_NOMBRE, CAMPO_TELEFONO}, params = new String[] {dni_consultar_usuario.getText().toString()};
            String selection = CAMPO_DNI + " = ?";

            try {

                Cursor cursor = db.query(TABLA_USUARIOS, campos, selection, params, null, null, null);
                cursor.moveToFirst();
                nombre_consultar_usuario.setText(cursor.getString(1));
                telefono_consultar_usuario.setText(cursor.getString(2));
            }
            catch (Exception err) { Toast.makeText(getApplicationContext(), "El usuario no existe", Toast.LENGTH_SHORT).show(); }
            finally { if (db.isOpen()) { db.close(); } }

            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
        else { Toast.makeText(getApplicationContext(), "El campo DNI no puede estar vacío", Toast.LENGTH_SHORT).show(); }
    }

    /**
     * Boton para limpiar los campos del formulario
     * @param view
     */
    public void click_btn_limpiar_consultar_usuario(View view) { limpiarFormulario(); }

    /**
     * Elimina los datos de la base de datos del usuario buscado
     * @param view
     */
    public void click_btn_eliminar_consultar_usuario(View view) {

        if (!isEmptyEt(dni_consultar_usuario)) {

            SQLiteDatabase db = conn.getReadableDatabase();

            String where = CAMPO_DNI + " = ?";
            String[] arrWhere = new String[] {dni_consultar_usuario.getText().toString()};

            try {

                int result = db.delete(TABLA_USUARIOS, where, arrWhere);

                if (result > 0) { Toast.makeText(getApplicationContext(), "Usuario eliminado", Toast.LENGTH_SHORT).show(); }
                else { Toast.makeText(getApplicationContext(), "Error al eliminar el usuario", Toast.LENGTH_SHORT).show(); }

                limpiarFormulario();
            }
            catch (Exception err) { Toast.makeText(getApplicationContext(), "Error al eliminar el usuario", Toast.LENGTH_SHORT).show(); }
            finally { if (db.isOpen()) { db.close(); } }

            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
        else { Toast.makeText(getApplicationContext(), "El campo DNI no puede estar vacío", Toast.LENGTH_SHORT).show(); }
    }

    /**
     * Actualiza los datos de la base de datos del usuario buscado
     * @param view
     */
    public void click_btn_actualizar_consultar_usuario(View view) {

        if (!isEmptyEt(dni_consultar_usuario)) {

            if (!isEmptyEt(nombre_consultar_usuario)) {

                if (!isEmptyEt(telefono_consultar_usuario)) {

                    SQLiteDatabase db = conn.getReadableDatabase();

                    ContentValues values = new ContentValues();
                    values.put(CAMPO_DNI, dni_consultar_usuario.getText().toString());
                    values.put(CAMPO_NOMBRE, nombre_consultar_usuario.getText().toString());
                    values.put(CAMPO_TELEFONO, telefono_consultar_usuario.getText().toString());
                    String where = CAMPO_DNI + " = ?";
                    String[] arrWhere = new String[] {dni_consultar_usuario.getText().toString()};

                    try {

                        int result = db.update(TABLA_USUARIOS, values, where, arrWhere);

                        if (result > 0) { Toast.makeText(getApplicationContext(), "Usuario editado", Toast.LENGTH_SHORT).show(); }
                        else { Toast.makeText(getApplicationContext(), "Error al editar el usuario", Toast.LENGTH_SHORT).show(); }
                    }
                    catch (Exception err) { Toast.makeText(getApplicationContext(), "Error al editar el usuario", Toast.LENGTH_SHORT).show(); }
                    finally { if (db.isOpen()) { db.close(); } }

                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
                else { Toast.makeText(getApplicationContext(), "El campo teléfono no puede estar vacío", Toast.LENGTH_SHORT).show(); }
            }
            else { Toast.makeText(getApplicationContext(), "El campo nombre no puede estar vacío", Toast.LENGTH_SHORT).show(); }
        }
        else { Toast.makeText(getApplicationContext(), "El campo DNI no puede estar vacío", Toast.LENGTH_SHORT).show(); }
    }

    /**
     * Vacia los campos del formulario
     */
    private void limpiarFormulario() {
        dni_consultar_usuario.setText("");
        nombre_consultar_usuario.setText("");
        telefono_consultar_usuario.setText("");
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