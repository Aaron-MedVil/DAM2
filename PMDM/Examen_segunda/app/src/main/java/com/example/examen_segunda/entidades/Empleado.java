package com.example.examen_segunda.entidades;

import java.io.Serializable;

public class Empleado implements Serializable {

    private int id;
    private String nombre, email, departamento;

    /**
     * Getter/Setter id
     * @return
     */
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    /**
     * Getter/Setter nombre
     * @return
     */
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    /**
     * Getter/Setter email
     * @return
     */
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    /**
     * Getter/Setter departamento
     * @return
     */
    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }
}
