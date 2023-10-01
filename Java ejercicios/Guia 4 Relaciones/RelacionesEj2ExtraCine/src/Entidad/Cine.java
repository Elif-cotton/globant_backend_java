
package Entidad;

import java.util.Random;

/**
 *
 * @author javer
 */
public class Cine {
    
    private Pelicula pelicula;
    private Asiento[][] sala;
    private double precioEntrada;
     
    
    public Cine() {
    }

    public Cine(Pelicula pelicula, double precioEntrada) {
        this.pelicula = pelicula;
        this.precioEntrada = precioEntrada;
        this.sala = new Asiento [8] [6];
  
        inicializarAsientos();
    }
    
     private void inicializarAsientos() {
        char fila = 'A';
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                sala[i][j] = new Asiento(fila, j + 1);
            }
            fila++;
        }
    }

     public void llenarSala() {
        Random rand = new Random();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                if (!sala[i][j].isOcupado()) {
                    Espectador espectador = generarEspectadorAleatorio();
                    if (espectador != null) {
                        if (espectador.tieneEdadYDineroSuficiente(pelicula, precioEntrada)) {
                            sala[i][j].ocupar();
                        }
                    }
                }
            }
        }
    }
     
    public Espectador generarEspectadorAleatorio() {
        String[] nombres = {"Juan", "Maria", "Pedro", "Ana", "Luis", "Laura"};
        int edad = 10 + new Random().nextInt(40); // Edad entre 10 y 50
        double dinero = 10 + (100 - 10) * new Random().nextDouble(); // Dinero entre 10 y 100
        return new Espectador(nombres[new Random().nextInt(nombres.length)], edad, dinero);
    }
    
    public void mostrarSala() {
        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 6; j++) {
                System.out.print(sala[i][j] + " ");
            }
            System.out.println();
        }
    }
      
    
}
