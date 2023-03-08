package modelo;

public class Cliente {
    private  String codCli;
    private  String nombre;
    private  String clave;
    private  int codCar;

    public Cliente(String codCli, String nombre, String clave, int codCar) {
        this.codCli = codCli;
        this.nombre = nombre;
        this.clave = clave;
        this.codCar = codCar;
    }

    public String getCodCli() {
        return codCli;
    }

    public void setCodCli(String codCli) {
        this.codCli = codCli;
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

    public int getCodCar() {
        return codCar;
    }

    public void setCodCar(int codCar) {
        this.codCar = codCar;
    }
}
