package com.example.a14_dialogs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private CharSequence[] csGo = {"Chrome", "Edge", "Internete Explorer", "Opera", "Firefox"};
    private ArrayList idiomas = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btnAlertDialog:
                AlertDialog.Builder adAlert = new AlertDialog.Builder(this);
                adAlert.setMessage("¿Desea salir?").setCancelable(false);
                adAlert.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface adAlert, int which) {
                        Toast.makeText(getApplication(), "Sí", Toast.LENGTH_SHORT).show();
                    }
                });
                adAlert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface adAlert, int which) {
                        adAlert.cancel();
                        Toast.makeText(getApplication(), "No", Toast.LENGTH_SHORT).show();
                    }
                });
                adAlert.show();
                break;

            case R.id.btnProgressDialog:
                ProgressDialog.show(this, "Progress dialog", "Cargando, Espere por favor...", true, true);
                break;

            case R.id.btnSimpleDialog:
                AlertDialog.Builder adSimple = new AlertDialog.Builder(this);
                adSimple.setTitle("¡Atención!").setMessage("El fichero se eliminó").setCancelable(false);
                adSimple.setNeutralButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                adSimple.show();
                break;

            case R.id.btnListDialog:
                AlertDialog.Builder adLista = new AlertDialog.Builder(this);
                adLista.setTitle("Elija el navegador que utiliza:");
                adLista.setItems(R.array.navegadores, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String nav = getResources().getStringArray(R.array.navegadores)[which];
                        Toast.makeText(getApplication(), "Has elegido la opción: " + nav, Toast.LENGTH_SHORT).show();
                    }
                });
                adLista.show();
                break;

            case R.id.btnRadioButtonDialog:
                AlertDialog.Builder adRadioButton = new AlertDialog.Builder(this);
                adRadioButton.setTitle("Elija el navegado que utiliza:");
                adRadioButton.setSingleChoiceItems(csGo, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplication(), "Ha seleccionado el elemento " + csGo[which], Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });
                adRadioButton.show();
                break;

            case R.id.btnCheckedDialog:
                idiomas.clear();
                AlertDialog.Builder adBtnChecked = new AlertDialog.Builder(this);
                adBtnChecked.setTitle("Conocimiento en idiomas");
                adBtnChecked.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String mensaje = "Idiomas que conoces:";
                        for (Object idioma:idiomas) { mensaje += "\n- " + idioma; }
                        Toast.makeText(getApplication(), mensaje, Toast.LENGTH_SHORT).show();
                    }
                });
                adBtnChecked.setMultiChoiceItems(R.array.idiomas, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        String option = getResources().getStringArray(R.array.idiomas)[which];
                        if (isChecked) { idiomas.add(option); }
                        else if(idiomas.contains(option)) { idiomas.remove(option); }
                        Toast.makeText(getApplication(), "Opciones seleccionadas " + idiomas.size(), Toast.LENGTH_SHORT).show();
                    }
                });
                adBtnChecked.show();
                break;

            case R.id.btnPersoDialog:
                break;

            case R.id.btnDatePickerDialog:
                break;

            case R.id.btnTimePickerDialog:
                break;
        }
    }
}