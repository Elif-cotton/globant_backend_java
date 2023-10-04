
package Entidades;

/**
 *
 * @author javer
 */
public class Residencia extends AlojamientoExtraHotelero{
    
    private int cantidadHabitaciones;
    private boolean descuentoGremios;
    private boolean tieneCampoDeportivo;

    public Residencia() {
    }

    public Residencia(int cantidadHabitaciones, boolean descuentoGremios, boolean tieneCampoDeportivo, boolean privado, double metrosCuadrados, String nombre, String direccion, String localidad, String gerente) {
        super(privado, metrosCuadrados, nombre, direccion, localidad, gerente);
        this.cantidadHabitaciones = cantidadHabitaciones;
        this.descuentoGremios = descuentoGremios;
        this.tieneCampoDeportivo = tieneCampoDeportivo;
    }

    public int getCantidadHabitaciones() {
        return cantidadHabitaciones;
    }

    public void setCantidadHabitaciones(int cantidadHabitaciones) {
        this.cantidadHabitaciones = cantidadHabitaciones;
    }

    public boolean isDescuentoGremios() {
        return descuentoGremios;
    }

    public void setDescuentoGremios(boolean descuentoGremios) {
        this.descuentoGremios = descuentoGremios;
    }

    public boolean isTieneCampoDeportivo() {
        return tieneCampoDeportivo;
    }

    public void setTieneCampoDeportivo(boolean tieneCampoDeportivo) {
        this.tieneCampoDeportivo = tieneCampoDeportivo;
    }

    @Override
    public String toString() {
        return "Residencia{" + "cantidad Habitaciones=" + cantidadHabitaciones + ", descuento Gremios=" + 
                descuentoGremios + ", tiene Campo Deportivo=" + tieneCampoDeportivo + '}';
    }
    
    
}
