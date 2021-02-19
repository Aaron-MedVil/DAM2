package com.example.examen_segunda.utilidades;

public class Utilidades {

    // Nombrede la base de datos
    public static final String NOMBRE_DATABASE = "bd_empleado";

    // Nombre de la tabla empleado
    public static final String NOMBRE_TABLA_EMPLEADO = "empleado";

    // Campos de la tabla empleado
    public static final String CAMPO_ID_TABLA_EMPLEADO = "id";
    public static final String CAMPO_NOMBRE_TABLA_EMPLEADO = "nombre";
    public static final String CAMPO_EMAIL_TABLA_EMPLEADO = "email";
    public static final String CAMPO_DEPARTAMENTO_TABLA_EMPLEADO = "departamento";

    // Crear/Eliminar tabla empleado
    public static final String CREAR_TABLA_EMPLEADO = "CREATE TABLE " + NOMBRE_TABLA_EMPLEADO + "(" +
            CAMPO_ID_TABLA_EMPLEADO + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            CAMPO_NOMBRE_TABLA_EMPLEADO + " TEXT, " +
            CAMPO_EMAIL_TABLA_EMPLEADO + " TEXT, " +
            CAMPO_DEPARTAMENTO_TABLA_EMPLEADO + " TEXT)";
    public static final String BORRAR_TABLA_EMPLEADO = "DROP TABLE IF EXISTS " + NOMBRE_TABLA_EMPLEADO;
}
