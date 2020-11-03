package com.example.a09_listview_perso;

public class Vecino {

    private String nombre, descripcion;
    private int img;

    // Constructor de la clase
    public Vecino(String nombre, String descripcion, int img) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.img = img;
    }

    // Get/Set nombre
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    // Get/Set descripcion
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    // Get/ Set imagen
    public int getImg() { return img; }
    public void setImg(int img) { this.img = img; }
}