
package Servicio;

import Entidad.RevolverDeAgua;
import java.util.Random;

/**
 *
 * @author javer
 */
public class RevolverDeAguaServicio {
    
    public void llenarRevolver(RevolverDeAgua revolver) {
        Random random = new Random();
        revolver.setPosicionActual(random.nextInt(6));
        revolver.setPosicionAgua(random.nextInt(6));
    }

    public boolean mojar(RevolverDeAgua revolver) {
        return revolver.getPosicionActual() == revolver.getPosicionAgua();
    }

    public void siguienteChorro(RevolverDeAgua revolver) {
        revolver.setPosicionActual((revolver.getPosicionActual() + 1) % 6);
    }

    public String mostrarRevolver(RevolverDeAgua revolver) {
        return "Posición actual: " + revolver.getPosicionActual() + ", Posición del agua: " + revolver.getPosicionAgua();
    }
}
