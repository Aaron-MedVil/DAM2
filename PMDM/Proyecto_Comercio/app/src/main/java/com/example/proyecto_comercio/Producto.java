package com.example.proyecto_comercio;

public class Producto {

    private String nombre, precio;
    private int img;

    // Constructor de productos
    public Producto(String nombre, String precio, int img) {
        this.nombre = nombre;
        this.precio = precio;
        this.img = img;
    }

    // Getter/Setter nombre
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    // Getter/Setter precio
    public String getPrecio() { return precio; }
    public void setPrecio(String precio) { this.precio = precio; }

    // Getter/Setter imagen
    public int getImg() { return img; }
    public void setImg(int img) { this.img = img; }
}
