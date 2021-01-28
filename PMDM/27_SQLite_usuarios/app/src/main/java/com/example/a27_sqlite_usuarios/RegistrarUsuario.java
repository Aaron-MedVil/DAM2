package com.example.a27_sqlite_usuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.a27_sqlite_usuarios.utilidades.utilidades.*;

public class RegistrarUsuario extends AppCompatActivity {

    private EditText tw_dni_reg_usuario, tw_nombre_reg_usuario, tw_telefono_reg_usuario;
    private InputMethodManager imm;

    /**
     * Metodo que se ejecuta cuando se crea la clase
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);

        imm = (InputMethodManager)this.getSystemService(Activity.INPUT_METHOD_SERVICE);

        tw_dni_reg_usuario = findViewById(R.id.tw_dni_reg_usuario);
        tw_nombre_reg_usuario = findViewById(R.id.tw_nombre_reg_usuario);
        tw_telefono_reg_usuario = findViewById(R.id.tw_telefono_reg_usuario);
    }

    /**
     * Registra los datos del usuario insertado en la base de datos
     * @param view
     */
    public void click_btn_reg_usuario(View view) {

        if (!isEmptyEt(tw_dni_reg_usuario)) {

            if (!isEmptyEt(tw_nombre_reg_usuario)) {

                if (!isEmptyEt(tw_telefono_reg_usuario)) {

                    DbConn conn = new DbConn(this, "bdUsuarios", null, 1);
                    SQLiteDatabase db = conn.getWritableDatabase();

                    ContentValues values = new ContentValues();
                    values.put(CAMPO_DNI, tw_dni_reg_usuario.getText().toString());
                    values.put(CAMPO_NOMBRE, tw_nombre_reg_usuario.getText().toString());
                    values.put(CAMPO_TELEFONO, tw_telefono_reg_usuario.getText().toString());

                    long result = db.insert(TABLA_USUARIOS, null, values);

                    if (result > 0) { Toast.makeText(getApplicationContext(), "Usuario registrado " + result, Toast.LENGTH_SHORT).show(); }
                    else { Toast.makeText(getApplicationContext(), "Error al registrar el usuario " + result, Toast.LENGTH_SHORT).show(); }

                    limpiarFormulario();
                    if (db.isOpen()) { db.close(); }

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
        tw_dni_reg_usuario.setText("");
        tw_nombre_reg_usuario.setText("");
        tw_telefono_reg_usuario.setText("");
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