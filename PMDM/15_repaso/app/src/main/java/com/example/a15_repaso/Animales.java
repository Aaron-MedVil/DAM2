package com.example.a15_repaso;

public class Animales {

    private String nombre, descripcion;
    private int img;

    public Animales(String nombre, String descripcion, int img) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.img = img;
    }

    // Getter/Setter Nombre
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    // Getter/Setter Descripcion
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    // Getter/Setter image
    public int getImg() { return img; }
    public void setImg(int img) { this.img = img; }
}