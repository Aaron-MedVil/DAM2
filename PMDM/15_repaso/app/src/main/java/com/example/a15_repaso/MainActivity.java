package com.example.a15_repaso;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Html;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Map<String, String> usersAdmit = new HashMap();

    /**
     * Carga la aplicacion
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Agregamos usuarios al array de admitidos
        usersAdmit.put("admin", "admin1234");
        usersAdmit.put("user", "user1234");

        showLogin();
    }

    /**
     * Muestra el dialogo de login
     */
    private void showLogin() {

        // Creamos un dialogo para que muestre el login
        AlertDialog.Builder dialogLogin = new AlertDialog.Builder(this);

        // Asignamos el layout al dialog
        dialogLogin.setView(getLayoutInflater().inflate(R.layout.login_layout, null));

        // Evita que cerremos el dialogo si pulsamos fuera
        dialogLogin.setCancelable(false);

        // Crea un boton en el dialog y le asigna un evento onClick
        dialogLogin.setPositiveButton(R.string.login, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                Dialog d = (Dialog) dialog;
                EditText user = d.findViewById(R.id.userLogin);
                EditText password = d.findViewById(R.id.passwordLogin);

                String userStr = user.getText().toString();
                String passwordStr = password.getText().toString();

                // Comprueba que el usuario y la contraseña son correctos
                if (usersAdmit.containsKey(userStr) == true) {
                    if (usersAdmit.get(userStr).equals(passwordStr)) {

                        openMainLayout();
                        Toast.makeText(getApplication(), Html.fromHtml("Usuario <i>" + userStr + "</i> autenticado"), Toast.LENGTH_SHORT).show();
                    } else {
                        closeApp();
                    }
                } else {
                    closeApp();
                }
            }
        });

        // Mostramos el dialog
        dialogLogin.show();
    }

    /**
     * Cierra la aplicacion
     */
    private void closeApp() {
        this.finishAffinity();
        System.exit(0);
    }

    /**
     * Carga el layout principal de la alicacion
     */
    private void openMainLayout() {
        getSupportFragmentManager().beginTransaction().add(R.id.containerFragments, new MainLayout()).commit();
    }
}