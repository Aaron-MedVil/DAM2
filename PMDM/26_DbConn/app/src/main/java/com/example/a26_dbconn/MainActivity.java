package com.example.a26_dbconn;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    EditText etCod, etNom, etDesc, etPvp;
    Button btnInsertar, btnBuscar, btnModificar, btnEliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Producto prod = new Producto();
        ProductoDB prodDb = new ProductoDB();

        // Obtenemos los elementos EditText de la interfaz
        etCod = findViewById(R.id.etCod);
        etNom = findViewById(R.id.etNom);
        etDesc = findViewById(R.id.etDesc);
        etPvp = findViewById(R.id.etPvp);

        // Obtenemos los elementos Button de la interfaz
        btnInsertar = findViewById(R.id.btnInsertar);
        btnBuscar = findViewById(R.id.btnBuscar);
        btnModificar = findViewById(R.id.btnModificar);
        btnEliminar = findViewById(R.id.btnEliminar);

        // Asignamos un metodo on click al boton de insertar
        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Comprobamos que los campos de texto no esten vacios
                if (!isEmptyEt(etCod)) {

                    if (!isEmptyEt(etNom)) {

                        if (!isEmptyEt(etDesc)) {

                            if (!isEmptyEt(etPvp)) {

                                // Rellenamos el objeto producto con los datos de los campos de la interfaz
                                prod.setCodigo(Integer.parseInt(etCod.getText().toString()));
                                prod.setNombre(etNom.getText().toString());
                                prod.setDescripcion(etDesc.getText().toString());
                                prod.setPrecio(Double.parseDouble(etPvp.getText().toString()));

                                // Llamamos al metodo para insertar un producto
                                int res = prodDb.InsertaProducto(MainActivity.this, prod);

                                // Oculta el teclado
                                InputMethodManager imm = (InputMethodManager) MainActivity.this.getSystemService(Activity.INPUT_METHOD_SERVICE);
                                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

                                // Comprobamos si se ha insertado el registro
                                String msgRes = (res == 1) ? "Producto insertado correctamente" : "Error al insertar el producto";
                                Snackbar snc = Snackbar.make(v, msgRes, Snackbar.LENGTH_LONG);
                                snc.show();

                                limpiarFormulario();
                            }
                            else { Toast.makeText(MainActivity.this, "El campo precio está vacío", Toast.LENGTH_SHORT).show(); }
                        }
                        else { Toast.makeText(MainActivity.this, "El campo descripción está vacío", Toast.LENGTH_SHORT).show(); }
                    }
                    else { Toast.makeText(MainActivity.this, "El campo nombre está vacío", Toast.LENGTH_SHORT).show(); }
                }
                else { Toast.makeText(MainActivity.this, "El campo código está vacío", Toast.LENGTH_SHORT).show(); }
            }
        });

        // Asignamos un metodo on click al boton de eliminar
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isEmptyEt(etCod)) {

                    String codigo = etCod.getText().toString();
                    int res = prodDb.EliminarProducto(MainActivity.this, Integer.parseInt(codigo));

                    // Oculta el teclado
                    InputMethodManager imm = (InputMethodManager) MainActivity.this.getSystemService(Activity.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

                    // Comprobamos si se ha insertado el registro
                    String msgRes = (res == 1) ? "Producto eliminado correctamente" : "Error al eliminar el producto";
                    Snackbar snc = Snackbar.make(v, msgRes, Snackbar.LENGTH_LONG);
                    snc.show();

                    limpiarFormulario();
                }
                else { Toast.makeText(MainActivity.this, "El campo código está vacío", Toast.LENGTH_SHORT).show(); }
            }
        });
    }

    /**
     * Vacia los valores de los EditText
     */
    private void limpiarFormulario() {

        etCod.setText("");
        etNom.setText("");
        etDesc.setText("");
        etPvp.setText("");
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