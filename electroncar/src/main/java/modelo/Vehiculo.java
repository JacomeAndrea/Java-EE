package modelo;

public class Vehiculo {

    private int codCar;
    private String localidad;
    private int estado;
    private int bateria;

    public Vehiculo(int codCar, String localidad, int estado, int bateria) {
        this.codCar = codCar;
        this.localidad = localidad;
        this.estado = estado;
        this.bateria = bateria;
    }

    public int getCodCar() {
        return codCar;
    }

    public void setCodCar(int codCar) {
        this.codCar = codCar;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getBateria() {
        return bateria;
    }

    public void setBateria(int bateria) {
        this.bateria = bateria;
    }
}
