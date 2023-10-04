
package Entidades;

/**
 *
 * @author javer
 */
public class AlojamientoExtraHotelero extends Alojamiento{
    
    private boolean privado;
    private double metrosCuadrados;

    public AlojamientoExtraHotelero() {
    }

    public AlojamientoExtraHotelero(boolean privado, double metrosCuadrados, String nombre, String direccion, String localidad, String gerente) {
        super(nombre, direccion, localidad, gerente);
        this.privado = privado;
        this.metrosCuadrados = metrosCuadrados;
    }

    public boolean isPrivado() {
        return privado;
    }

    public void setPrivado(boolean privado) {
        this.privado = privado;
    }

    public double getMetrosCuadrados() {
        return metrosCuadrados;
    }

    public void setMetrosCuadrados(double metrosCuadrados) {
        this.metrosCuadrados = metrosCuadrados;
    }

    @Override
    public String toString() {
        return "Alojamiento Extra Hotelero{" + "privado=" + privado + ", metros Cuadrados=" +
                metrosCuadrados + '}';
    }

    
}
