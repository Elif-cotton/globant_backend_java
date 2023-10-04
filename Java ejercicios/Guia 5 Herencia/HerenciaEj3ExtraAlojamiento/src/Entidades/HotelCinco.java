
package Entidades;

import Enumeracion.TipoGimnasio;

/**
 *
 * @author javer
 */
public class HotelCinco extends HotelCuatro{
    
    private int cantidadSalonesConferencia;
    private int cantidadSuites;
    private int cantidadLimosinas;

    public HotelCinco() {
    }

    public HotelCinco(int cantidadSalonesConferencia, int cantidadSuites, int cantidadLimosinas,
            TipoGimnasio tipoGimnasio, String nombreRestaurante, int capacidadRestaurante, 
            int cantidadHabitaciones, int numeroCamas, int cantidadPisos, double precioHabitacion, 
            String nombre, String direccion, String localidad, String gerente) {
        super(tipoGimnasio, nombreRestaurante, capacidadRestaurante, cantidadHabitaciones, numeroCamas, 
                cantidadPisos, precioHabitacion, nombre, direccion, localidad, gerente);
        this.cantidadSalonesConferencia = cantidadSalonesConferencia;
        this.cantidadSuites = cantidadSuites;
        this.cantidadLimosinas = cantidadLimosinas;
    }

    public int getCantidadSalonesConferencia() {
        return cantidadSalonesConferencia;
    }

    public void setCantidadSalonesConferencia(int cantidadSalonesConferencia) {
        this.cantidadSalonesConferencia = cantidadSalonesConferencia;
    }

    public int getCantidadSuites() {
        return cantidadSuites;
    }

    public void setCantidadSuites(int cantidadSuites) {
        this.cantidadSuites = cantidadSuites;
    }

    public int getCantidadLimosinas() {
        return cantidadLimosinas;
    }

    public void setCantidadLimosinas(int cantidadLimosinas) {
        this.cantidadLimosinas = cantidadLimosinas;
    }
    
    
    @Override
    public double calcularPrecioHabitacion() {
        
        double precioHabitacion = super.calcularPrecioHabitacion(); // Precio base y valor por restaurante/gimnasio

        // Valor agregado por las limosinas
        precioHabitacion += 15 * cantidadLimosinas;

        return precioHabitacion;
    }

    @Override
    public String toString() {
        return "HotelCinco{" + "cantidad Salones de Conferencia=" + cantidadSalonesConferencia + 
                ", cantidad Suites=" + cantidadSuites + ", cantidad de Limosinas=" + cantidadLimosinas + '}';
    }
    
    

}
