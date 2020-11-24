package com.example.examen_ut1;

public class Peliculas {

    private int img;
    private String nombre, sala;

    public Peliculas(int img, String nombre, String sala) {
        this.img = img;
        this.nombre = nombre;
        this.sala = sala;
    }

    public int getImg() { return img; }
    public void setImg(int img) { this.img = img; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getSala() { return sala; }
    public void setSala(String sala) { this.sala = sala; }
}
