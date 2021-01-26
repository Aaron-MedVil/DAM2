package com.example.a27_sqlite_usuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.a27_sqlite_usuarios.utilidades.utilidades.*;

public class RegistrarUsuario extends AppCompatActivity {

    private EditText tw_dni_reg_usuario, tw_nombre_reg_usuario, tw_telefono_reg_usuario;

    /**
     * Metodo que se ejecuta cuando se crea la clase
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);

        tw_dni_reg_usuario = findViewById(R.id.tw_dni_reg_usuario);
        tw_nombre_reg_usuario = findViewById(R.id.tw_nombre_reg_usuario);
        tw_telefono_reg_usuario = findViewById(R.id.tw_telefono_reg_usuario);
    }

    /**
     * Registra los datos del usuario insertado en la base de datos
     * @param view
     */
    public void click_btn_reg_usuario(View view) {

        DbConn conn = new DbConn(this, "bdUsuarios", null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(CAMPO_DNI, tw_dni_reg_usuario.getText().toString());
        values.put(CAMPO_NOMBRE, tw_nombre_reg_usuario.getText().toString());
        values.put(CAMPO_TELEFONO, tw_telefono_reg_usuario.getText().toString());

        long result = db.insert(TABLA_USUARIOS, null, values);

        if (result != -1) { Toast.makeText(getApplicationContext(), "Usuario registrado " + result, Toast.LENGTH_SHORT).show(); }
        else { Toast.makeText(getApplicationContext(), "Error al registrar el usuario " + result, Toast.LENGTH_SHORT).show(); }

        limpiarFormulario();
        db.close();
    }

    /**
     * Vacia los campos del formulario
     */
    private void limpiarFormulario() {
        tw_dni_reg_usuario.setText("");
        tw_nombre_reg_usuario.setText("");
        tw_telefono_reg_usuario.setText("");
    }
}