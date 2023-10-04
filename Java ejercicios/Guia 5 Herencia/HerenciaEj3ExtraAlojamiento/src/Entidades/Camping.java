
package Entidades;

/**
 *
 * @author javer
 */
public class Camping extends AlojamientoExtraHotelero{
    
    private int capacidadCarpa;
    private int cantidadBanios;
    private boolean tieneRestaurante;

    public Camping() {
    }

    public Camping(int capacidadCarpa, int cantidadBanios, boolean tieneRestaurante, boolean privado, double metrosCuadrados, String nombre, String direccion, String localidad, String gerente) {
        super(privado, metrosCuadrados, nombre, direccion, localidad, gerente);
        this.capacidadCarpa = capacidadCarpa;
        this.cantidadBanios = cantidadBanios;
        this.tieneRestaurante = tieneRestaurante;
    }

    public int getCapacidadCarpa() {
        return capacidadCarpa;
    }

    public void setCapacidadCarpa(int capacidadCarpa) {
        this.capacidadCarpa = capacidadCarpa;
    }

    public int getCantidadBanios() {
        return cantidadBanios;
    }

    public void setCantidadBanios(int cantidadBanios) {
        this.cantidadBanios = cantidadBanios;
    }

    public boolean isTieneRestaurante() {
        return tieneRestaurante;
    }

    public void setTieneRestaurante(boolean tieneRestaurante) {
        this.tieneRestaurante = tieneRestaurante;
    }

    @Override
    public String toString() {
        return "Camping{" + "capacidad Carpa=" + capacidadCarpa + ", cantidad Baños=" + cantidadBanios + 
                ", tiene Restaurante=" + tieneRestaurante + '}';
    }
    
    
}
