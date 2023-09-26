package Entidades;

public class Pais {
    private String nombrePais;

    public Pais() {

    }

    public Pais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    @Override
    public String toString() {
        return "Pais{" + "Nombre del País=" + nombrePais + '}';
    }

}
