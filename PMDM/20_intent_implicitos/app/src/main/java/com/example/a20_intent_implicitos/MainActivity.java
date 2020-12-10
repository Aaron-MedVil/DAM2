package com.example.a20_intent_implicitos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etBuscar;

    /**
     * Metodo que se ejecuta al crearse la aplicacion
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Metodo para crear una alarma
     * @param message
     * @param hour
     * @param minutes
     */
    public void createAlarm(String message, int hour, int minutes) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_HOUR, hour)
                .putExtra(AlarmClock.EXTRA_MINUTES, minutes);
        if (intent.resolveActivity(getPackageManager()) != null) { startActivity(intent); }
    }

    /**
     * Metodo para realizar una llamada
     * @param phoneNumber
     */
    public void dialPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(getPackageManager()) != null) { startActivity(intent); }
    }

    /**
     * Metodo para realizar busquedas en el navegador
     * @param query
     */
    public void searchWeb(String query) {
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY, query);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * Metodo que se ejecuta cuando se pulsa el boton para crear la alarma
     * @param view
     */
    public void crearAlarma(View view) {

        createAlarm("Pruebas", 14, 00);
    }

    /**
     * Metodo que se ejecuta cuando se pulsa el boton para realizar una llamada
     * @param view
     */
    public void realizarLlamada(View view) {

        dialPhoneNumber("652693979");
    }

    /**
     * Metodo que se ejecuta cuando se pulsa el boton para buscar un campo
     * @param view
     */
    public void buscarNavegador(View view) {

        etBuscar = findViewById(R.id.etBuscar);
        searchWeb(etBuscar.getText().toString());
    }
}