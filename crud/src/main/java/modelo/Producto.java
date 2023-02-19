package modelo;

import java.util.List;

public class Producto {
    private String codigoProducto;
    private String nombreProducto;
    private int precioProducto;

    public Producto(String codigo, String nombre, int precio) {
        this.codigoProducto = codigo;
        this.nombreProducto = nombre;
        this.precioProducto = precio;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(int precioProducto) {
        this.precioProducto = precioProducto;
    }



}
