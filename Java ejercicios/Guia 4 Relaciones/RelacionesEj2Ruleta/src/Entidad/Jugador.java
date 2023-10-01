
package Entidad;

/**
 *
 * @author javer
 */
public class Jugador {
    
    private int id; //representa el número del jugador
    private String nombre; //Empezara con Jugador más su ID, “Jugador 1” 
    private boolean mojado;

    public Jugador() {
    }

    public Jugador(int id) {
        this.id = id;
        this.nombre = "Jugador "+id;
        this.mojado = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isMojado() {
        return mojado;
    }

    public void setMojado(boolean mojado) {
        this.mojado = mojado;
    }
    
    public boolean disparo(RevolverDeAgua r) {
        if (!mojado) {
            if (r.getPosicionActual() == r.getPosicionAgua()) {
                mojado = true;
                return true;
            } else {
                r.setPosicionActual((r.getPosicionActual() + 1) % 6);
                return false;
            }
        }
        return false;
    }

    public boolean estaMojado() {
        return mojado;
    }
    
    public String toString() {
        return nombre + (mojado ? " está mojado" : " no está mojado");
    }
    
    
}
