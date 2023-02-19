package modelo;

public class Socio {
    private String nombre;
    private String clave;
    private String codigoUsuario;

    public Socio(String nombre, String clave, String codigoUsuario) {
        this.nombre = nombre;
        this.clave = clave;
        this.codigoUsuario = codigoUsuario;
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

    public String getCodigo() {
        return codigoUsuario;
    }

    public void setCodigo(String codigo) {
        this.codigoUsuario = codigo;
    }
}
