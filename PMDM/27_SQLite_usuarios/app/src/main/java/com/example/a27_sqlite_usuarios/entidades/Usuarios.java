package com.example.a27_sqlite_usuarios.entidades;

import java.io.Serializable;

public class Usuarios implements Serializable {

    private String dni, nombre, telefono;

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
}