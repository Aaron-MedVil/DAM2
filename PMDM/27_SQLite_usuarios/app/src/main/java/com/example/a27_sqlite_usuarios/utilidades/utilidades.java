package com.example.a27_sqlite_usuarios.utilidades;

public class utilidades {

    /* CADENAS TABLA USUARIOS */
    public static final String CREAR_TABLA_USUARIO = "CREATE TABLE usuarios(dni TEXT, nombre TEXT, telefono TEXT)";
    public static final String BORRAR_TABLA_USUARIO = "DROP TABLE IF EXISTS usuarios";
    public static final String TABLA_USUARIOS = "usuarios", CAMPO_DNI = "dni", CAMPO_NOMBRE = "nombre", CAMPO_TELEFONO = "telefono";

    /* CADENAS TABLA CURSOS*/
    public static final String CREAR_TABLA_CURSOS = "CREATE TABLE curso(id_curso INTEGER PRIMARY KEY AUTOINCREMENT, nombre_curso TEXT, duracion INTEGER, dni_usuario TEXT, FOREIGN KEY (dni_usuario) REFERENCES usuarios(dni))";
    public static final String BORRAR_TABLA_CURSOS = "DROP TABLE IF EXISTS cursos";
    public static final String TABLA_CURSOS = "curso", CAMPO_ID_CURSO = "id_curso", CAMPO_NOMBRE_CURSO = "nombre_curso", CAMPO_DURACION = "duracion", CAMPO_DNI_USUARIO_CURSO = "dni_usuario";
}