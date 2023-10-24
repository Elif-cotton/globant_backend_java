
package Enums;

/**
 *
 * @author javer
 */
public enum DiaDeLaSemana {
    
    LUNES(2),
    MARTES(3),
    MIERCOLES(4),
    JUEVES(5),
    VIERNES(6),
    SABADO(7),
    DOMINGO(1);
    
    final int numero;

    private DiaDeLaSemana(int num) {
        this.numero = num;
    }
}
