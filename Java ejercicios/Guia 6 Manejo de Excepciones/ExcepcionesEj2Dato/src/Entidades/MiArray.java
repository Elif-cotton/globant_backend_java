
package Entidades;

/**
 *
 * @author javer
 */
public class MiArray {
    
    private int[] miArray;

    public MiArray() {
    }

    public MiArray(int tamaño) {
        this.miArray = new int[tamaño];
    }

    public void asignarValor(int indice, int valor) {
        try {
            miArray[indice] = valor;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Se ha producido una excepción: " + e.getMessage());
            System.out.println("El índice está fuera de rango.");
        }
    }
    
    public int obtenerValor(int indice) {
        try {
            return miArray[indice];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Se ha producido una excepción: " + e.getMessage());
            System.out.println("El índice está fuera de rango. Se devuelve 0 como valor predeterminado.");
            return 0;
        }
    }
    
    
}
