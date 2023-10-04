
package Entidades;

/**
 *
 * @author javer
 */
public class Hotel extends Alojamiento {
    
    private int cantidadHabitaciones;
    private int numeroCamas;
    private int cantidadPisos;
    private double precioHabitacion;
  
    public Hotel() {
    }

    public Hotel(int cantidadHabitaciones, int numeroCamas, int cantidadPisos, double precioHabitacion,
            String nombre, String direccion, String localidad, String gerente) {
        super(nombre, direccion, localidad, gerente);
        this.cantidadHabitaciones = cantidadHabitaciones;
        this.numeroCamas = numeroCamas;
        this.cantidadPisos = cantidadPisos;
        this.precioHabitacion = precioHabitacion;
    }

    public int getCantidadHabitaciones() {
        return cantidadHabitaciones;
    }

    public void setCantidadHabitaciones(int cantidadHabitaciones) {
        this.cantidadHabitaciones = cantidadHabitaciones;
    }

    public int getNumeroCamas() {
        return numeroCamas;
    }

    public void setNumeroCamas(int numeroCamas) {
        this.numeroCamas = numeroCamas;
    }

    public int getCantidadPisos() {
        return cantidadPisos;
    }

    public void setCantidadPisos(int cantidadPisos) {
        this.cantidadPisos = cantidadPisos;
    }

    public double getPrecioHabitacion() {
        return precioHabitacion;
    }

    public void setPrecioHabitacion(double precioHabitacion) {
        this.precioHabitacion = precioHabitacion;
    }

    @Override
    public String toString() {
        return "Hotel{" + "cantidad de habitaciones=" + cantidadHabitaciones + ", número de camas=" + numeroCamas + 
               ", cantidad de pisos=" + cantidadPisos + ", precio por habitación=" + precioHabitacion + '}';
    }

}
