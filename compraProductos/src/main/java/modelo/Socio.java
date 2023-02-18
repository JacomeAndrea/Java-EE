package modelo;

public class Socio {
    private String codigo;
    private String nombre;
    private String clave;
    private int cantidadMax;

    public Socio(String codigo, String nombre, String clave, int cantidadMax) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.clave = clave;
        this.cantidadMax = cantidadMax;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getCantidadMax() {
        return cantidadMax;
    }

    public void setCantidadMax(int cantidadMax) {
        this.cantidadMax = cantidadMax;
    }
}
