package com.example.a27_sqlite_usuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.a27_sqlite_usuarios.entidades.Cursos;
import com.example.a27_sqlite_usuarios.entidades.Usuarios;

public class DetalleConsultaCurso extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_consulta_curso);

        Usuarios usuario = (Usuarios)getIntent().getSerializableExtra("usuario");
        Cursos c = (Cursos)getIntent().getSerializableExtra("cursos");

        Toast.makeText(getApplicationContext(), usuario.getNombre(), Toast.LENGTH_SHORT).show();
    }
}