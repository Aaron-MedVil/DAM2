package com.example.a27_sqlite_usuarios.entidades;

import java.io.Serializable;

public class Cursos implements Serializable {

    private int id_curso, duracion;
    private String nombre_curso, dni_usuario;

    public int getId_curso() { return id_curso; }
    public void setId_curso(int id_curso) { this.id_curso = id_curso; }

    public int getDuracion() { return duracion; }
    public void setDuracion(int duracion) { this.duracion = duracion; }

    public String getNombre_curso() { return nombre_curso; }
    public void setNombre_curso(String nombre_curso) { this.nombre_curso = nombre_curso; }

    public String getDni_usuario() { return dni_usuario; }
    public void setDni_usuario(String dni_usuario) { this.dni_usuario = dni_usuario; }
}