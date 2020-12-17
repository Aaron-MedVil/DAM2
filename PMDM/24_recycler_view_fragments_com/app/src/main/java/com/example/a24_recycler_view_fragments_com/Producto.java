package com.example.a24_recycler_view_fragments_com;

public class Producto {

    private String nomProducto, descProducto;
    private int imgProducto;

    /**
     * Constructor de la clase
     * @param nomProducto
     * @param descProducto
     * @param imgProducto
     */
    public Producto(String nomProducto, String descProducto, int imgProducto) {
        this.nomProducto = nomProducto;
        this.descProducto = descProducto;
        this.imgProducto = imgProducto;
    }

    /**
     * Getter nombre producto
     * @return
     */
    public String getNomProducto() { return nomProducto; }

    /**
     * Setter nombre producto
     * @param nomProducto
     */
    public void setNomProducto(String nomProducto) { this.nomProducto = nomProducto; }

    /**
     * Getter descripcion producto
     * @return
     */
    public String getDescProducto() { return descProducto; }

    /**
     * Setter descripcion producto
     * @param descProducto
     */
    public void setDescProducto(String descProducto) { this.descProducto = descProducto; }

    /**
     * Getter imagen producto
     * @return
     */
    public int getImgProducto() { return imgProducto; }

    /**
     * Setter imagen producto
     * @param imgProducto
     */
    public void setImgProducto(int imgProducto) { this.imgProducto = imgProducto; }
}
