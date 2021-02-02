package com.example.a27_sqlite_usuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a27_sqlite_usuarios.entidades.Cursos;
import com.example.a27_sqlite_usuarios.entidades.Usuarios;

public class DetalleConsultaCurso extends AppCompatActivity {

    EditText et_id_curso, et_nombre_curso, et_duracion_curso, et_dni_usuario, et_nombre_usuario, et_telefono_usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_consulta_curso);

        Usuarios usuario = (Usuarios) getIntent().getSerializableExtra("usuario");
        Cursos curso = (Cursos) getIntent().getSerializableExtra("cursos");

        et_id_curso = findViewById(R.id.et_id_curso);
        et_nombre_curso = findViewById(R.id.et_nombre_curso);
        et_duracion_curso = findViewById(R.id.et_duracion_curso);
        et_dni_usuario = findViewById(R.id.et_dni_usuario);
        et_nombre_usuario = findViewById(R.id.et_nombre_usuario);
        et_telefono_usuario = findViewById(R.id.et_telefono_usuario);

        // Datos del curso
        et_id_curso.setText(curso.getId_curso());
        et_nombre_curso.setText(curso.getNombre_curso());
        et_duracion_curso.setText(curso.getDuracion());

        // Datos del usuario
        et_dni_usuario.setText(usuario.getDni());
        et_nombre_usuario.setText(usuario.getNombre());
        et_telefono_usuario.setText(usuario.getTelefono());
    }
}