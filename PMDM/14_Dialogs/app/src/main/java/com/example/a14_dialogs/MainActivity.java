package com.example.a14_dialogs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnAlertDialog, btnProgressDialog, btnSimpleDialog, btnListDialog, btnRadioButtonDialog, btnCheckedDialog, btnPersoDialog, btnDatePickerDialog, btnTimePickerDialog;

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
                adLista.setTitle("Elija el navegador que utiliza");
                adLista.setItems(R.array.navegadores, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String nav = getResources().getStringArray(R.array.navegadores)[which];
                    }
                });
                break;
            case R.id.btnRadioButtonDialog:
                break;
            case R.id.btnCheckedDialog:
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