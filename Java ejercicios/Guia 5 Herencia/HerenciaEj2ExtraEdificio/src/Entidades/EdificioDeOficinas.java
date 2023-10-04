
package Entidades;

/**
 *
 * @author javer
 */
public class EdificioDeOficinas extends Edificio {

    private int numeroOficinas;
    private int personasPorOficina;
    private int numeroPisos;

    public EdificioDeOficinas() {
    }

    public EdificioDeOficinas(int numeroOficinas, int personasPorOficina, int numeroPisos, double ancho, double alto, double largo) {
        super(ancho, alto, largo);
        this.numeroOficinas = numeroOficinas;
        this.personasPorOficina = personasPorOficina;
        this.numeroPisos = numeroPisos;
    }

    public int getNumeroOficinas() {
        return numeroOficinas;
    }

    public void setNumeroOficinas(int numeroOficinas) {
        this.numeroOficinas = numeroOficinas;
    }

    public int getPersonasPorOficina() {
        return personasPorOficina;
    }

    public void setPersonasPorOficina(int personasPorOficina) {
        this.personasPorOficina = personasPorOficina;
    }

    public int getNumeroPisos() {
        return numeroPisos;
    }

    public void setNumeroPisos(int numeroPisos) {
        this.numeroPisos = numeroPisos;
    }

    
    @Override
    public double calcularSuperficie() {
        return ancho * largo;
    }

    @Override
    public double calcularVolumen() {
         return ancho * alto * largo;
    }
    
    public void cantPersonas() {
        int totalPersonas = numeroOficinas * personasPorOficina * numeroPisos;
        System.out.println("En un piso pueden trabajar " + (numeroOficinas * personasPorOficina) + " personas.");
        System.out.println("En todo el edificio pueden trabajar " + totalPersonas + " personas.");
    }
    
}
