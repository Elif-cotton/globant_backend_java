package Entidades;

public class Operación {

    private Double numero1;
    private Double numero2;

    // Constructor con todos los atributos pasados por parámetro
    public Operacion(Double numero1, Double numero2) {
        this.numero1 = numero1;
        this.numero2 = numero2;
    }

    public Operacion() {

    }

    // Constructor sin los atributos pasados por parámetro
    /**
     public Operacion() {
     this.numero1 = 0;
     this.numero2 = 0;
     }
     **/
    //getter and setter

    public Double getNumero1() {
        return numero1;
    }

    public void setNumero1(Double numero1) {
        this.numero1 = numero1;
    }

    public Double getNumero2() {
        return numero2;
    }

    public void setNumero2(Double numero2) {
        this.numero2 = numero2;
    }
}
